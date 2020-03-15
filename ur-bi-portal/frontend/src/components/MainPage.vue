<template>
  <div class="main-page flex flex-1 flex-align-top flex-justify-center">
    <div class="flex flex-1 menu-list flex-column" 
        v-if="menuData.length > 0">
      <div
        class="flex flex-1 menu-item"
        v-for="(item,key) in menuData"
        :key="key"
        @click="openUrl(item.url)"
      >{{language === "zh-CN" ? item.name : item.enName}}</div>
    </div>
    <div class="tips flex flex-justify-center flex-align-center" v-if="menuData.length < 1 || menuData===null">当前用户无菜单列表</div>
  </div>
</template>

<script>
export default {
  name: "MainPage",
  data() {
    return {
      menuData: [],
      href:'',
      userId:'',
      language:navigator.browserLanguage || navigator.language
    };
  },
  mounted() {
    let _this = this;
    this.userId = window.userid;
    const fetch = require("node-fetch");
    this.href = window.location.href.substr(0,window.location.href.indexOf("/WeiXin/MenuPage"));
    let address = this.href+"/WeiXin/getMenuList?userId="+this.userId;
    new Promise(function(resolve, reject) {
      fetch(address)
        .then(res => res.json())
        .then(json => {
          if (json) {
            _this.menuData = json;
            console.log("2019-10-28 17:44:27->日志记录:", json);
          }
        });
    });
  },
  methods: {
    openUrl(url){
      let openUrl = this.href+"/WeiXin/openPage?url="+url+"&userId="+this.userId;
      window.location.href = openUrl;
    }
  },
};
</script>

<style scoped lang='less'>
.main-page {
  font-family: "Regular";
  padding: 12px 10px 30px 10px;
  background-color: #f1f4fb;
  overflow-y: auto !important;
  .menu-list {
    font-size: 14px;
    width: 100%;
    height: auto;
    background-color: #f1f4fb;
    padding: 12px 10px 30px 10px;
    transition: transform 0.4s ease-out;
    z-index: 12;
    .menu-item {
      min-height: 146px;
      border-radius: 20px;
      border: 1px #dbdbdb solid;
      background-color: white;
      font-size: 44px;
      color: #666666;
      margin-top: 20px;
      align-items: center;
      justify-content: center;
    }
  }
  .tips{
    font-size: 60px;
  }
}
</style>
