//将字符串转成对象
var parseObj = function(objStr, defaultStr){
	return (new Function("return ( " + ( objStr || defaultStr ) + " );"))();
}
// 获取今天yyyy-mm-dd格式
var getTodayStr = function(){
	var dObj = new Date();
	var y = dObj.getFullYear();
	var m = dObj.getMonth() + 1;
	if(m < 10) {
		m = "0" + m.toString();
	}
	var d = dObj.getDate();
	if(d < 10) {
		d = "0" + d.toString();
	}
	var str = y + "-" + m + "-" + d;
	return str; 
}
// 获取昨天yyyy-mm-dd格式
var getYesterdayStr = function() {
   	var dObj = new Date();
	var y = dObj.getFullYear();
	var m = dObj.getMonth() + 1;
	if(m < 10) {
		m = "0" + m.toString();
	}
	var d = dObj.getDate()-1;
	if(d < 10) {
		d = "0" + d.toString();
	}
	var str = y + "-" + m + "-" + d ;
	return str; 
}

// 获取文件的扩展名,大写的
var getFileExt = function(fileName){
    fileName.match(/(\.)/ig);
    return RegExp.rightContext.toString().toUpperCase();
}

// 设置select默认option
var setSelectDefaultOption = function(selectObjId, optionValue){
    var selectObj = document.getElementById(selectObjId);
    for (var i = 0; i < selectObj.options.length; i += 1) {
        if (selectObj.options[i].value == optionValue) {
            selectObj.options[i].selected = true;
            break;
        }
    }
}

// 设置radio默认选中
var setRadioDefault = function(radioName, value){
    var radioBoxObj = document.getElementsByName(radioName);
    for (var i = 0; i < radioBoxObj.length; i += 1) {
        if (radioBoxObj[i].value == value) {
            radioBoxObj[i].checked = true;
            break;
        }
    }
}

// 数组去除相同元素的函数,相同元素只保留一个
Array.prototype.strip = function(){
    if (this.length < 2) {
        return [this[0]] || [];
    }
    var arr = [];
    for (var i = 0; i < this.length; i += 1) {
        arr.push(this.splice(i--, 1));
        for (var j = 0; j < this.length; j += 1) {
            if (this[j] == arr[arr.length - 1]) {
                this.splice(j--, 1);
            }
        }
    }
    return arr;
}

// 返回一个日期字符串yyyy-MM-dd的星期
var getWeekDate = function(dateString){
    var pDate = dateString.split("-");
    var pYear = pDate[0];//年
    if (parseInt(pDate[1]) == 0) {//月份第一个数字是0,即未满10月,取第二个数字
        var pMonth = pDate[1].charAt(1);
    } else {//否则取整个
        var pMonth = pDate[1];
    }
    if (parseInt(pDate[2]) == 0) {//同月份道理,取日
        var pDay = pDate[2].charAt(1);
    } else {
        var pDay = pDate[2];
    }
    var vDate = new Date(pYear, pMonth - 1, pDay);//转Date对象
    var wDate = vDate.getDay();//取星期几,返回一个数字,0是星期天,以此类推
    return wDate;
}

// 返回和date相距离n天的Date对象
var getDateN = function(date, n){
    return new Date(date.getFullYear(), date.getMonth(), date.getDate() + n);
}

// 返回date对象的yyyy-MM-dd格式
var formateDate = function(date){
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    if (month < 10) {
        month = "0" + month;
    }
    var day = date.getDate();
    if (day < 10) {
        day = "0" + day;
    }
    return year + "-" + month + "-" + day;
}

// 返回今天的yyyy-MM-dd格式
var getToday = function(split){
    return formateDate(new Date());
}

// 比较日期格式为yyyy-MM-dd的两个日期的大小,前面日期大返回false,否则true
var compareDate = function(a, b){
    var al = a.split("-");
    var bl = b.split("-");
    if (al[0] > bl[0] || (al[0] == bl[0] && al[1] > bl[1]) || (al[0] == bl[0] && al[1] == bl[1] && al[2] > bl[2])) {
        return false;
    }
    return true;
}

// 
$(function(){
	//id为list的表格划过高亮,单双行颜色,点击高亮
	$("#list tr").mouseover(function(){
		$(this).addClass("mouseoverTr");
	}).mouseout(function(){
		$(this).removeClass("mouseoverTr");
	}).click(function(){
		$("#list tr").removeClass("mouseclickTr");
		$(this).addClass("mouseclickTr");
	});
	$("#list tr:even").addClass("doubleTr");
	
	//表单获取焦点高亮
	$("#searchBar input[type='text']").focus(function(){
		$(this).addClass("inputOnfocus");
	}).blur(function(){
		$(this).removeClass("inputOnfocus");
	}).addClass("searchBarinput");

	//表单获取焦点高亮
	$("#formTable input[type='text']").focus(function(){
		$(this).addClass("inputOnfocus");
	}).blur(function(){
		$(this).removeClass("inputOnfocus");
	});
	$("#formTable input[type='file']").focus(function(){
		$(this).addClass("inputOnfocus");
	}).blur(function(){
		$(this).removeClass("inputOnfocus");
	});
	$("#formTable textarea").focus(function(){
		$(this).addClass("inputOnfocus");
	}).blur(function(){
		$(this).removeClass("inputOnfocus");
	});
	$("#formTable .controlButton").parent().css({"text-align":"center"});
});