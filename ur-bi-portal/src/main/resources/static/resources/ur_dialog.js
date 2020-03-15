$(function(){
    //$('#dialogBig').onclick(function(){
    //    alert(1);
    //});
});

var dialog_width=$(window).width();//浏览器宽度
var dialog_height=$(window).height();//浏览器高度

var dwidth =dialog_width-10;//自定义宽度
var dheight =dialog_height-10;//自定义高度

/**
 * 打开dialog
 * @param title 窗口名称
 * @param url 页面地址
 * @param dzwidth 自定义宽度
 * @param dzheight 自定义高度
 * @param dtype max=最大化，min=自定义大小
 */
var openDialog = function (title,url,dzwidth,dzheight,dtype){
    //var dialog_width=$(window).width();
    //var dialog_height=$(window).height();
    var initwidth =dzwidth;
    var initheight =dzheight;
    if(dtype=='max'){
        initwidth =dialog_width;
        initheight =dialog_height;
    }
    dwidth =dzwidth;
    dheight =dzheight;


    $('#dialogIframe').width(initwidth-30);
    $('#dialogIframe').height(initheight-30);
    $("#dialog").dialog({
        title:title,
        autoOpen: false,
        modal: true,
        width:initwidth-10,
        height:initheight-10,
//	  buttons:{
//		  "确定":function(){alert('确定方法');},
//		  "取消":function(){$(this).dialog('close');}
//	  },
        open: function(ev, ui){
            $('#dialogIframe').attr('src',url);
        }
    });
    $('#dialog').dialog('open');
}

/**
 * 关闭弹出dialog
 */
var closedialog = function () {
    $( "#dialog" ).dialog('close');
}

/**
 * 设置dialog最大化
 */
var dialogMax = function(){
    //var dialog_width=$(window).width();
    //var dialog_height=$(window).height();
    //alert(444);
    //设置dialog大小

    $('#dialogIframe').width(dialog_width-30);
    $('#dialogIframe').height(dialog_height-30);

    $('#dialog').dialog('option','width',dialog_width-10);
    $('#dialog').dialog('option','height',dialog_height-10);
}
/**
 * 设置dialog传入的大小
 */
var dialogMin = function(){
    //var dialog_width=$(window).width();
    //var dialog_height=$(window).height();
    //alert(132);
    //设置dialog大小

    $('#dialogIframe').width(dwidth-30);
    $('#dialogIframe').height(dheight-30);

    $('#dialog').dialog('option','width',dwidth-10);
    $('#dialog').dialog('option','height',dheight-10);
}


/**
 * 弹窗回调方法
 */
function dialogCallback() {
    alert('弹窗回调方法');
}