/**
 * layui 组件
 * @type {any}
 */
var layer = layui.layer
    ,form = layui.form()
    ,util = layui.util
    ,element = layui.element();


//时间格式化
Date.prototype.Format = function (fmt) { //author: meizz
    var o = {
        "M+": this.getMonth() + 1,                 //月份
        "d+": this.getDate(),                    //日
        "h+": this.getHours(),                   //小时
        "m+": this.getMinutes(),                 //分
        "s+": this.getSeconds(),                 //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds()             //毫秒
    };
    if (/(y+)/.test(fmt))
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
};

//格式化模版函数
String.prototype.Format = function (args) {
    if (arguments.length < 1) {
        return this;
    }
    var result = this,
        len = arguments.length,
        reg = function (s) {
            return new RegExp("(\\{" + s + "\\})", "g")
        };
    if (len == 1 &&
        Object.prototype.toString.call(args) == "[object Object]") {
        for (var k in args) {
            result = result.replace(reg(k), args[k]);
        }
    }
    else {
        for (var i = 0; i < len; i++) {
            if (arguments[i] == undefined) {
                continue;
            }
            result = result.replace(reg(i), arguments[i]);
        }
    }
    return result;
};

//替换所有
String.prototype.replaceAll  = function(s1,s2){
    return this.replace(new RegExp(s1,"gm"),s2);
};

// common 主要封装常用方法
var common = {};

/**
 * post请求
 * @param url
 * @param data
 * @param success
 * @param error
 */
common.post = function(url, data, success, error) {
    common.loading();
    $.ajax({
        "url": url,
        "data": data,
        "type": "POST",
        "success": function(json) {
            common.stop();
            if(success) success(json);
        },
        "error": function(json, t, tt) {
            common.stop();
            if(error) error(json);
        },
        dataType: "json"
    });
};

common.get = function(url, data, success, error) {
    common.loading();
    $.ajax({
        "url": url,
        "data": data,
        "type": "GET",
        "success": function(json) {
            common.stop();
            if(success) success(json);
        },
        "error": function(json, t, tt) {
            common.stop();
            if(error) error(json);
        },
        dataType: "json"
    });
};

/**
 * 获取日期
 * @param i
 */
common.getToday = function (i) {
    var d = new Date();
    if (i !== undefined) {
        d.setDate(d.getDate() + i);
        return d.Format("yyyy-MM-dd");
    } else {
        return d.Format("yyyy-MM-dd");
    }
}

/**
 * a = d = 当前日期
 * b = 6 - w = 当前周的还有几天过完（不算今天）
 * a + b 的和在除以7 就是当天是当前月份的第几周
 * @param a 年
 * @param b 月
 * @param c 日
 * @returns {number}
 */
common.getMonthWeek = function (a, b, c) {
    var date = new Date(a, parseInt(b) - 1, c), w = date.getDay(), d = date.getDate();
    return Math.ceil(
        (d + 6 - w) / 7
    );
};

/**
 * date1是当前日期
 * date2是当年第一天
 * d是当前日期是今年第多少天
 * 用d + 当前年的第一天的周差距的和在除以7就是本年第几周
 * @returns {number}
 */
common.getYearWeek = function () {
    //new Date(a, parseInt(b) - 1, c)
    var date1 = new Date(), date2 = new Date(date1.getFullYear(), 0, 1),
        d = Math.round((date1.valueOf() - date2.valueOf()) / 86400000);
    return Math.ceil(
        (d + ((date2.getDay() + 1) - 1)) / 7
    )-1;
};



/**
 * 信息提示方法
 * 默认0,0表示信息框，1表示页面层，2表示加载层
 * 轻提示,3秒后消失
 * @param msg
 */
common.msg = function (msg) {
    layer.msg(msg);
}

/**
 * 确认提示
 * @param msg
 * @param btn
 * @param callback
 * @param title
 */
common.alert = function (msg, btn, callback, title) {
    var index = layer.open({
        title: title || '提示',
        content: msg,
        className: 'test',
        btn: btn || ['确定'],
        yes: callback || function () {
            layer.close(index);
        }
    })
};

/**
 *
 * @param msg
 * @param btn
 * @param callback
 * @param title
 */
common.confirm = function (msg,callback,callback2,btn,title) {
    var index = layer.confirm(msg, {
            title: title || '提示',
            btn: btn || ['确定', '取消'], //按钮
            //yes:callback,
            cancel:callback2 //右上角关闭回调
        },callback,callback2);
};



var _loading_index = 0;
/**
 * 加载层
 */
common.loading = function () {
    _loading_index = layer.load();
};
/**
 * 停止加载
 */
common.stop = function () {
    layer.close(_loading_index);
};

/**
 * 页面层
 * @param content
 * @param btn
 * @param callback
 * @param success
 */
common.open = function (content, btn,callback, title,area) {
    var index = layer.open({
        type: 1,
        area: area||'360px',
        content: content,
        title: title || '提示信息',
        btn: btn || ['确定', '取消'], //按钮
        yes: callback || function () {
            layer.close(index);
        },
    });
};

/**
 * tips层
 * @param msg 信息
 * @param id id
 */
common.tips = function(msg,id){
    layer.tips(msg, id, {
        tips: [1, '#0FA6D8'] //还可配置颜色
    });
};

/**
 * 关闭层
 * @param index
 */
common.close = function (index) {
    if (index) {
        layer.close(index);
    } else {
        layer.closeAll();
    }
};

/**
 * 像册层
 * @param id
 */
common.photos = function(id){
    layer.photos({
        shift: 5,
        photos: id

    });
}

$(function () {


    //layer.msg('Hello World');
    common.msg("1243")
    element.init();

});
/*
var layer;
layui.use(['layer', 'form','element'], function(){
    layer = layui.layer;
        //,form = layui.form();


});*/
