
function URRestRequest(){
    this.requestData = {
            "condList":[],
            "orderByList":null,
            "selectFields":null,
            "currPage":1,
            "pageSize":20
          };
    this.addCondition = function(columnName,value,operator){
    	if(value!=null&&value!=""&&columnName!=null&&columnName!=""){
            var cond = {
                    "columnName":columnName,
                    "operator":operator,
                    "value":value
                  };
            this.requestData.condList.push(cond);    		
    	}
    };
    this.addOrderBy = function(columnName){
    	this.requestData.orderByList=this.requestData.orderByList||[];
    	if(columnName!=null&&columnName!=""){
            this.requestData.orderByList.push(columnName);    		
    	}
    };    
    this.addSelectField = function(columnName){
    	this.requestData.selectFields=this.requestData.selectFields||[];
    	if(columnName!=null&&columnName!=""){
            this.requestData.selectFields.push(columnName);    		
    	}
    };      
    this.setCurrPage = function(page){
    	this.requestData.currPage = page;
    };
    this.setPageSize = function(pageSize){
    	this.requestData.pageSize = pageSize;
    };    
    this.getRequestData = function(){
    	return this.requestData;
    }
}

function downloadFile(url){
	var f = document.createElement("form");
	document.body.appendChild(f);
	var i = document.createElement("input");
	i.type = "hidden";
	f.appendChild(i);
	i.value = "5";
	i.name = "price";
	f.action = url;  //下载的url 地址
	f.submit();
}

function downloadFileReName(fileName,extName,newFileName){
	var f = document.createElement("form");
	document.body.appendChild(f);
	var i = document.createElement("input");
	i.type = "hidden";
	f.appendChild(i);
	i.value = fileName;
	i.name = "fileName";
	var i1 = document.createElement("input");
	i1.type = "hidden";
	f.appendChild(i1);
	i1.value = extName;
	i1.name = "extName";
	var i2 = document.createElement("input");
	i2.type = "hidden";
	f.appendChild(i2);
	i2.value = newFileName;
	i2.name = "newFileName";
	f.action = "/DownloadFile";  //下载的url 地址
	f.submit();	
}

//element table formater函数 begin

//百分比
 function formatPercent(row, column, cellValue) {
	 if (!cellValue) return cellValue; 
     var result = parseInt(cellValue * 10000).toString();
     var formatResult=result / 100
     return formatResult+'%';
}
 
 //舍掉小数，取整
 function formatInteger(row, column, cellValue) {
	 if (!cellValue) return cellValue; 
	 return  parseInt(cellValue);
}
 
 //四舍五入取整
 function formatMathRound(row, column, cellValue) {
	 if (!cellValue) return cellValue; 
	 return Math.round(cellValue);
}
 
 /* 
  * 功能：金额按千位逗号分隔
 */ 
function formatMoney(row, column, cellValue) {
	if (!cellValue) return cellValue; 
	if (cellValue == null || cellValue == "null" || cellValue == "")
	      return "0.00";
	var isMinus=false;
	
	//负数处理
	if(cellValue.toString().indexOf('-')==0){
		  console.log(cellValue);
		  isMinus=true;
		  cellValue=cellValue.toString().replace('-',"");
		  console.log(cellValue);
	  }
    if (/[^0-9\.]/.test(cellValue))
    return "0.00";

    cellValue = cellValue.toString().replace(/^(\d*)$/, "$1.");
    cellValue = (cellValue + "00").replace(/(\d*\.\d\d)\d*/, "$1");
    cellValue = cellValue.replace(".", ",");
    var re = /(\d)(\d{3},)/;
    while (re.test(cellValue))
    	cellValue = cellValue.replace(re, "$1,$2");
    cellValue = cellValue.replace(/,(\d\d)$/, ".$1");
    
    //判断格式化后的金额是否需要小数位. 
    var a = cellValue.split(".");
    if (a[1] == "00") {
       cellValue = a[0];
    }
    
    return cellValue;
}
 //element table formater函数 end