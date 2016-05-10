$(function(){
	try {
		//add page
		$.formValidator.initConfig({
			formid: "formAdd",
			errorfocus: false,
			submitonce: true,
			tipstyle: "both",
			onerror: function(){ // 验证不通过时的回调函数
			alert("红色提示处输入非法，请根据提示修改！");
			}
		});
		$("#name").formValidator({ // 验证：模块名称
			onshow: "（必填）",
			onfocus: "（必填）不超过50个字符",
			oncorrect: "（正确）"
		}).inputValidator({
			min: 1,
			max: 50,
			onerrormin: "（错误）不能为空",
			onerrormax: "（错误）不超过50个字符，汉字算两个字符"
		});
		$("#add_date").formValidator({ // 验证：模块名称
			onshow: "（必填）",
			onfocus: "（必填）",
			oncorrect: "（正确）"
		});
		$("#selectLand").formValidator({ // 验证：模块名称
			onshow:"请选择地块",
			onfocus:"地块必须选择",
			oncorrect:"谢谢你的配合"
		}).inputValidator({
			min:1,
			onerror: "你是不是忘记选择地块了!"
		});
		$("#subFertilizer").formValidator({ // 验证：模块名称
			onshow:"请选择肥料",
			onfocus:"肥料必须选择",
			oncorrect:"谢谢你的配合"
		}).inputValidator({
			min:1,
			onerror: "你是不是忘记选择肥料了!"
		});
		//update page
		$.formValidator.initConfig({
			formid: "formUpdate",
			errorfocus: false,
			submitonce: true,
			tipstyle: "both",
			onerror: function(){ // 验证不通过时的回调函数
			alert("红色提示处输入非法，请根据提示修改！");
			}
		});
		$("#selectUpdateLand").formValidator({ // 验证：模块名称
			onshow:"请选择地块",
			onfocus:"地块必须选择",
			oncorrect:"谢谢你的配合"
		}).inputValidator({
			min:1,
			onerror: "你是不是忘记选择地块了!"
		});
		$("#subFerUpdate").formValidator({ // 验证：模块名称
			onshow:"请选择肥料",
			onfocus:"肥料必须选择",
			oncorrect:"谢谢你的配合"
		}).inputValidator({
			min:1,
			onerror: "你是不是忘记选择肥料了!"
		});
	}catch(e){
		alert(e);
	}
});

$(function(){
	try {
		$("#searchOpDate").focus(function(){
	        WdatePicker({
	            readOnly: true,
	            dateFmt:'yyyy-MM-dd',
	            skin: 'whyGreen'
	        });
	    });
		$("#add_date").focus(function(){
	        WdatePicker({
	            readOnly: true,
	            dateFmt:'yyyy-MM-dd',
	            skin: 'whyGreen'
	        });
	    });
		$("#addDateUpdate").focus(function(){
	        WdatePicker({
	            readOnly: true,
	            dateFmt:'yyyy-MM-dd',
	            skin: 'whyGreen'
	        });
	    });
	}catch(e){
		alert(e);
	}
});

$(function(){
	$("#fertilizer").change(function(){
		var fertilizer = $("#fertilizer option:selected").val(); 
		if(fertilizer!="-1")
		{
			$.ajax({
				url:"fertilizerAction!ajaxGetSubFertilizer.action",
				type: "post",
			    data: "type=" + fertilizer, 
				error: function(xmlHttp,status,errorThrown){   
		            alert("error:"+errorThrown + " status:" + status);   
				},
			   	success: function(result){
			   		//alert(result);
			  		document.getElementById('subAjax').innerHTML = result;
			  	}
			});//*/
		}
	});
	$("#subFertilizer").change(function(){
		var subFertilizer = $("#subFertilizer").val();
		alert(subFertilizer);
	});
	$("#searchFertilizer").change(function(){
		var searchFertilizer = $("#searchFertilizer option:selected").val();
		if(searchFertilizer!="-1")
		{
			$.ajax({
				url:"fertilizerAction!ajaxGetSearchSubFertilizer.action",
				type: "post",
			    data: "type=" + searchFertilizer, 
				error: function(xmlHttp,status,errorThrown){   
		            alert("error:"+errorThrown + " status:" + status);   
				},
			   	success: function(result){
			   		//alert(result);
			  		document.getElementById('searchSubAjax').innerHTML = result;
			  	}
			});//*/
		}
	});
	$("#fertilizerUpdate").change(function(){
		var tt = $("#fertilizerUpdate option:selected").val();
		if(tt!="-1")
		{
			$.ajax({
				url:"fertilizerAction!ajaxGetUpdateSubFertilizer.action",
				type: "post",
			    data: "type=" + tt, 
				error: function(xmlHttp,status,errorThrown){   
		            alert("error:"+errorThrown + " status:" + status);   
				},
			   	success: function(result){
			   		//alert(result);
			  		document.getElementById('subAjaxUpdate').innerHTML = result;
			  	}
			});//*/
		}
	});
});

function showAddPage(){
	location.href="fertilizerAction!fertilizerAddInit.action";
}

function goUrl(pageNo){
	var searchFrm = document.getElementById("searchFrm");
    searchFrm.pageNo.value = pageNo;
    searchFrm.submit();
}

function edit(id){
    location.href = "fertilizerAction!fertilizerUpdateInit.action?frId=" + id;
}

function del(id){
    if (confirm("确定删除？")) {
        location.href = "fertilizerAction!fertilizerDelete.action?frId=" + id;
    }
}



