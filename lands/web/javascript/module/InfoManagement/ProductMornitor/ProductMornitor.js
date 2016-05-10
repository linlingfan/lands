$(function(){
    $("#searchStartDate").focus(function(){
    	var searchEndDate=$dp.$('searchEndDate');
        WdatePicker({
            readOnly: true,
            skin: 'whyGreen',
            onpicked:function(){searchEndDate.focus();},
            maxDate: '#F{$dp.$D(\'searchEndDate\')}'
        });
    });
    $("#searchEndDate").focus(function(){
    	var searchStartDate=$dp.$('searchStartDate');
        WdatePicker({
            readOnly: true,
            skin: 'whyGreen',
            onpicked:function(){searchStartDate.focus();},
            minDate: '#F{$dp.$D(\'searchStartDate\')}'
        });
    });
});

function goUrl(pageNo){
	var searchFrm = document.getElementById("searchFrm");
    searchFrm.pageNo.value = pageNo;
    searchFrm.submit();
}