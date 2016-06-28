$(document).ready(function(){

	
	
	$('#addbreakupMaster')
	.dialog(
			{

				autoOpen : false,
				height :300,
				width :700,
				modal : true,
				resizable : true,
				buttons : [
						{
							text : "Add",
							class:"button1",
							click : function() {
								
								addtotalTime();
								
									dataList = {
										breakupName : $('#breakupNameId').val(),
										startTime : $('#addStartTimeId').val(),
										endTime : $('#addendTimeId').val(),
										totalTime:$('#addtotalTimeId').val()
										
									};
									
							var bvalid = addValidate();
						
							
									if (bvalid) {
							$.ajax({
									type:"GET",
									url:"breakupmaster.do?method=addBreakupMaster",
									data:dataList,
									async:false,
									
									success : function(data) {
										
										var result = $.parseJSON(data);
										alert(result.SuccessMessage);
										
									}
								});
									
									$('#addbreakupMaster')
											.dialog('close');

									location.reload();
								}
					}
						
						},
						{
							text : "Close",
							class:"button1",
							click : function() {
								$(this).dialog('close');
							}
						} ]
			});
	
	$('#createBreakId').click(function(){
		
		$('#addbreakupMaster').dialog('option', 'title',
		'Add Breakup Master');
	
		$('#addbreakupMaster').dialog('open');
		
		
	});
	
	
	
	$('#EditbreakupMaster')
	.dialog(
			{

				autoOpen : false,
				height :300,
				width :700,
				modal : false,
				resizable : false,
				buttons : [
						{
							text : "Update",
							class:"button1",
							click : function() {
							var bvalid = editValidate();
								if (bvalid) {
									
									edittotalTime();
									dataList = {
											breakupCode:$("#editbreakupCodeId").val(),
										breakupName : $('#editbreakupNameId').val(),
										startTime : $('#editstartTimeId').val(),
										endTime : $('#editendTimeId').val(),
										totalTime:$('#edittotalTimeId').val()
									};
									
									
									
									$.ajax({
										url:"breakupmaster.do?method=editBreakupMaster",
										data:dataList,
										async:false,
										success : function(data) {
											
											var result = $.parseJSON(data);
											alert(result.SuccessMessage);
											
										}
									});
									
								$('#EditbreakupMaster').dialog('close');
							
								location.reload();

								}
							
							}
						},
						{
							text : "Close",
							class:"button1",
							click : function() {
								$(this).dialog('close');
							}
						} ]
			});
	
	deleteServiceUrl="breakupmaster.do?method=deleteBreakupMaster";
	$('#editId').click(function(){
	var cnt=0;
		$('input.breakup_Checkbox_Class:checkbox:checked').map(function() {
			if(cnt>0){
				
				alert("Please Select only One Row");
cnt++;
				return false;
			}
			else{
				var check_id = $(this).attr("id");
				var split_id = check_id.split('_');
				 edit_Array = split_id[1].split(',');
				cnt++;
			}
		});
		if(cnt==0){
			
		alert("Please Select Row To Update");
		}
		
		
		if(cnt==1){
			$('#editbreakupNameId').val(edit_Array[1]);
			$('#editbreakupCodeId').val(edit_Array[5]);
		
			$('#editstartTimeId').val(edit_Array[2]);
			$('#editendTimeId').val(edit_Array[3]);
			$('#edittotalTimeId').val(edit_Array[4]);
			$("#EditbreakupMaster").dialog('option','title','Update Breakup Master');
			$('#EditbreakupMaster').dialog('open');
		}
	
	
		
	});
	$('#deleteId').click(function(){
		
		var breakupCode_Array=[];
		$('input.breakup_Checkbox_Class:checked').map(function() {
			
			var check_id = $(this).attr("id");
			var split_id = check_id.split('_');
			breakupCode_Array = split_id[1].split(',');
			
			breakupCode_Array.push(breakupCode_Array[0]);
		});
		
		if(breakupCode_Array != ""){
			var bconfirm = breakupCode_Array;
			confirm("Are you sure to delete");
			if(bconfirm){
				var breakupToBeDeleted = {"BreakCodeArray":breakupCode_Array.join(",")};
			
				var breakList=callAjax(deleteServiceUrl,breakupToBeDeleted);
				location.reload();
				
			}
		}
		else{
			
			
		alert("Please Select Row To Delete");
		}
		

	});
	
	
	
	
	});
	

	
	
	
	
	





function editValidate() {
	tips = $("#editalertMessage");
	
	var bValid = true;

	bValid = bValid
			&& checkRegexpText($('#editbreakupNameId'), /^[A-Za-z0-9\s.]+$/g,
					"Please EnterBreakup Name");
	
	if(!bValid){
		return false;
	}
	
	 var startTimeval=$('#editstartTimeId').val();
	var  endTimeVal=$('#editendTimeId').val();
	 

	  if(startTimeval > endTimeVal)
		  {
		  $("#editalertMessage").html("EndTime Should be greater than StartTime");
		  return false;
		  }
	   else{
		  
		  return true;
	  }
	return bValid;
}

function addValidate() {
	tips = $("#addalertMessage");
	
	var bValid = true;

	bValid = bValid && checkRegexpText($('#breakupNameId'), /^[A-Za-z0-9\s.]+$/g,"Please EnterBreakup Name");
	if(!bValid){
		return false;
	}
	
	var startTimeval=$('#addStartTimeId').val();
	var  endTimeVal=$('#addendTimeId').val();


	 if(startTimeval > endTimeVal)
		  {
		  $("#addalertMessage").html("EndTime Should be greater than StartTime");
		  return false;
		  }
	   else{
		  
		  return true;
	  }
	 var totalTime =$("#addtotalTimeId").val();	
	 if(totalTime==0){
		  $("#addalertMessage").html("Please Click on TotalTime"); 
	 }
	 else{
		return true; 
	 }
	 
	return bValid;
}








function callAjax(urlWithMethod, dataToBeSend) {

	var jsonResult = "";
	try {
		$.ajax({
			type : "GET",
			url : urlWithMethod,
			data : dataToBeSend,
			async : false,
			success : function(data) {
				
				var result = $.parseJSON(data);
				alert(result.SuccessMessage);

				
			}
		});
	} catch (e) {
		jsonResult = "";
	}
	return jsonResult;
}
function ConfirmDelete(count)
{
  var x = confirm("Are you sure you want to delete "+count+" Service(s)?");
  if (x)
      return true;
  else
    return false;
}

function addtotalTime() {
	
	   function toSeconds(time_str) {
		   
		    var parts = time_str.split(':');
		
		    return parts[0] * 3600 + // an hour has 3600 seconds
		    parts[1] * 60 + // a minute has 60 seconds
		    +
		    parts[2]; // seconds
		}
	 
	   
	   var startTime = $("#addStartTimeId").val();
		
			 
			var endTime = $("#addendTimeId").val(); 
		
		var difference = Math.abs(toSeconds(startTime) - toSeconds(endTime));
     

		var result = [
		    Math.floor(difference / 3600), // an hour has 3600 seconds
		    Math.floor((difference % 3600) / 60), // a minute has 60 seconds
		    difference % 60
		];
		
		result = result.map(function(v) {
		    return v < 10 ? '0' + v : v;
		}).join(':');
	
		var totalTime=result;
		$('#addtotalTimeId').val(totalTime);
	    

}
function edittotalTime() {
	

	   function toSeconds(time_str) {
		    // Extract hours, minutes and seconds
		    var parts = time_str.split(':');
		    // compute  and return total seconds
		    return parts[0] * 3600 + // an hour has 3600 seconds
		    parts[1] * 60 + // a minute has 60 seconds
		    +
		    parts[2]; // seconds
		}
	 
	   
	   var startTime = $("#editstartTimeId").val();
		
			 
			var endTime = $("#editendTimeId").val(); 
		
		var difference = Math.abs(toSeconds(startTime) - toSeconds(endTime));
  

		var result = [
		    Math.floor(difference / 3600), // an hour has 3600 seconds
		    Math.floor((difference % 3600) / 60), // a minute has 60 seconds
		    difference % 60
		];

		result = result.map(function(v) {
		    return v < 10 ? '0' + v : v;
		}).join(':');

		var totalTime=result;
		$('#edittotalTimeId').val(totalTime);
	    
	
}



