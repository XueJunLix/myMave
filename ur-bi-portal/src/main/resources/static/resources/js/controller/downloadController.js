// 窗口加载完
window.onload = function () {
    var vue = new Vue({
        el : '#app', // 元素绑定
        data : { // 数据模型
            loginName : '', // 登录用户名
            files : [], // 订单集合
            flag :'',
            responseType:'blob',
            method:'get'
            //items : []


        },
        methods : { // 操作方法
            // 获取登录用户名
            loadUsername : function () {
                axios.get("/user/showName").then(function(response){
                    vue.loginName = response.data.loginName;
                });
            },
            findFileName : function () {
                axios.get("/listFile").then(function (response) {
                    vue.files = response.data;
                })
            },
            handleDownload : function (fileName) {
                axios.get("/downloadFile?fileName="+fileName).then(function (res){
                    const fileName = res.headers["content-disposition"].split("=")[1];
                    const _res = res.data;
                    var blob = new Blob([_res]);
                    var downloadElement = document.createElement("a");
                    var href = window.URL.createObjectURL(blob); //创建下载的链接
                    downloadElement.href = href;
                    downloadElement.download = fileName; //下载后文件名
                    document.body.appendChild(downloadElement);
                    downloadElement.click(); //点击下载
                    document.body.removeChild(downloadElement); //下载完成移除元素
                    window.URL.revokeObjectURL(href); //释放掉blob对象

                })
            }

        },
        created : function () { // 创建生命周期
            //this.loadUsername();
            this.findFileName();
            //this.search(this.page)
        }
    });
};