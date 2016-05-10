$(function(){
	try {
		//add page
		$.formValidator.initConfig({
			formid: "formAdd",
			errorfocus: false,
			submitonce: true,
			tipstyle: "both",
			onerror: function(){ // ��֤��ͨ��ʱ�Ļص�����
			alert("��ɫ��ʾ������Ƿ����������ʾ�޸ģ�");
			}
		});
		$("#name").formValidator({ // ��֤��ģ������
			onshow: "�����",
			onfocus: "�����������50���ַ�",
			oncorrect: "����ȷ��"
		}).inputValidator({
			min: 1,
			max: 50,
			onerrormin: "�����󣩲���Ϊ��",
			onerrormax: "�����󣩲�����50���ַ��������������ַ�"
		});
		$("#add_date").formValidator({ // ��֤��ģ������
			onshow: "�����",
			onfocus: "�����",
			oncorrect: "����ȷ��"
		});
		$("#selectLand").formValidator({ // ��֤��ģ������
			onshow:"��ѡ��ؿ�",
			onfocus:"�ؿ����ѡ��",
			oncorrect:"лл������"
		}).inputValidator({
			min:1,
			onerror: "���ǲ�������ѡ��ؿ���!"
		});
		$("#subFertilizer").formValidator({ // ��֤��ģ������
			onshow:"��ѡ�����",
			onfocus:"���ϱ���ѡ��",
			oncorrect:"лл������"
		}).inputValidator({
			min:1,
			onerror: "���ǲ�������ѡ�������!"
		});
		//update page
		$.formValidator.initConfig({
			formid: "formUpdate",
			errorfocus: false,
			submitonce: true,
			tipstyle: "both",
			onerror: function(){ // ��֤��ͨ��ʱ�Ļص�����
			alert("��ɫ��ʾ������Ƿ����������ʾ�޸ģ�");
			}
		});
		$("#selectUpdateLand").formValidator({ // ��֤��ģ������
			onshow:"��ѡ��ؿ�",
			onfocus:"�ؿ����ѡ��",
			oncorrect:"лл������"
		}).inputValidator({
			min:1,
			onerror: "���ǲ�������ѡ��ؿ���!"
		});
		$("#subFerUpdate").formValidator({ // ��֤��ģ������
			onshow:"��ѡ�����",
			onfocus:"���ϱ���ѡ��",
			oncorrect:"лл������"
		}).inputValidator({
			min:1,
			onerror: "���ǲ�������ѡ�������!"
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
    if (confirm("ȷ��ɾ����")) {
        location.href = "fertilizerAction!fertilizerDelete.action?frId=" + id;
    }
}



