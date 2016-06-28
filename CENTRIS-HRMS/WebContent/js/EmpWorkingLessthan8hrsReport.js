function callAjax(urlWithMethod,dataToBeSend){

	var jsonResult="";
	try{
	$.ajax({
		type : "GET",
		url : urlWithMethod,
		data : dataToBeSend,
		async:false,
		success : function(data) {
			var result = $.parseJSON(data);
			jsonResult=result;
		}
	});
	}
	catch (e) {
		jsonResult="";
	}
	return jsonResult;
}

function createSelectBox(selectboxId,dataForOption){
	var jsonkey=[];
	for( key in dataForOption[0] ){
		if(key.indexOf("Name")!=-1 || key.indexOf("name")!=-1 ){
			jsonkey[1]=key;
		}
		else if(key.indexOf("id")!=-1 || key.indexOf("code")!=-1  || key.indexOf("Id")!=-1){
			
			jsonkey[0]=key;
		}
	}
	
	$(selectboxId).empty();
	var selectObject=$(selectboxId);
	var anOption = document.createElement("OPTION");
	anOption.setAttribute("value","");
	anOption.innerHTML = "---Select Option---";
	selectObject.append(anOption);
	var anOptionAll = document.createElement("OPTION");
		anOptionAll.setAttribute("value","%%");
		anOptionAll.innerHTML = "All";
		if(dataForOption.length>0)
		selectObject.append(anOptionAll);
	for(var i=0;i<dataForOption.length;i++){
		if(dataForOption[i][jsonkey[1]]!=""){
		var anOption = document.createElement("OPTION");
		if(selectboxId==".empClassForAdmin" || selectboxId==".shiftClassForAdmin"){
			anOption.setAttribute("value",dataForOption[i][jsonkey[0]]);
		}
		else{
			anOption.setAttribute("value",dataForOption[i][jsonkey[0]]);
		}
		anOption.innerHTML = dataForOption[i][jsonkey[1]];
		selectObject.append(anOption);
		}
	}
	
}

$(document).ready(function(){
	$('#downloadPdflessThen8hrs').hide();
	if($('#tableId').find('table').length!=0){
		$('#downloadPdflessThen8hrs').show();
	}
$("#startdateId").datepicker({
		dateFormat : "dd-mm-yy",
		defaultDate : "+1w",
		maxDate : 0,
		changeYear : true,
		changeMonth : true,
		numberOfMonths : 1
	});
	$("#enddateId").datepicker({
		dateFormat : "dd-mm-yy",
		defaultDate : "+1w",
		maxDate : 0,
		changeYear : true,
		changeMonth : true,
		numberOfMonths : 1
	});
$('#groupId').change(function(){
		var sendGroup = {'group':$(this).val()};
		
		var result = callAjax("location.do?parameter=getLocationByGroup",sendGroup);

		createSelectBox("#locationId",result.locationList);
	});
	
	$('#locationId').change(function(){
		var sendLocation = {'location':$(this).val(),'group':$("#groupId").val()};
		
		var result = callAjax("shiftMaster.do?method=getShiftByLocation",sendLocation);
	
		createSelectBox("#shiftId",result.shiftList);
	});
	
	$('#shiftId').change(function(){
		var sendshift = {'shift':$(this).val(),'group':$("#groupId").val(),'location':$('#locationId').val()};
		var result = callAjax("consolidateDetailedMonthReport.do?parameter=getEmpDetailsByShift",sendshift);

		createSelectBox("#employeeId",result.empList);
	});
	
	$('#LessThen8hrsId').click(function(){
		var valid=validations();
		if(valid){
			$("#WorkingLess8HoursFormId").attr('action','lessthen8hrsinfo.do?parameter=getEmpWorkingLessthen8hrsDetails');
			$('#methodNameId').val('getEmpWorkingLessthen8hrsDetails');
			$("#WorkingLess8HoursFormId").submit();
		}
	});
	
	$('#downloadPdflessThen8hrs').click(function(){

		window.location.href='lessthen8hrsinfo.do?parameter=workingLessThen8hrsdownloadPdf&employee='+$("#hiddenemployeeId").val()+' &startDate='+$("#hiddenstartDateId").val()+' &endDate='+$("#hiddenendDateId").val();
});
	
	
	
	
});

function validations(){
	
	var bvalid=true;
	var groupName = $("#groupId").val();
	var locationName = $("#locationId").val();
	var shiftName = $("#shiftId").val();
	var employeeName = $("#employeeId").val();
	var startDate = $("#startdateId").val();
	var endDate = $("#enddateId").val();
	var startDateVal=new Date(startDate);
	 var endtDateVal=new Date(endDate);
	if (groupName == "") {

		$("#errordiv").text("Please Select Group");
		$('.error-box').css({
			'visibility' : 'visible'});

		bvalid= false;
	} else if (locationName == "") {

		$("#errordiv").text("Please Select Location");
		$('.error-box').css({'visibility' : 'visible'
		});
		bvalid= false;

	} else if (shiftName == "") {

		$("#errordiv").text("Please Select Shift");
		$('.error-box').css({'visibility' : 'visible'
		});
		bvalid= false;

	} else if (employeeName == "") {
		$("#errordiv").text("Please Select Employee");
		$('.error-box').css({'visibility' : 'visible'
		});
		bvalid= false;
	}

	else if (startDate == "") {
		$("#errordiv").text("Please Select StartDate");
		$('.error-box').css({'visibility' : 'visible'
		});
		bvalid= false;
	} 
	else if (endDate == "") {
		$("#errordiv").text("Please Select EndDate");
		$('.error-box').css({'visibility' : 'visible'
		});
		bvalid= false;
	}
	else if(startDateVal.getTime()>endtDateVal.getTime()){
		$("#errordiv").text("StartDate Should Less Then EndDate");
		$('.error-box').css({'visibility': 'visible'});
		bvalid= false;
	}
	else if(endtDateVal.getTime()< startDateVal.getTime()){
		$("#errordiv").text("End Date Should GreaterThen StartDate");
		$('.error-box').css({'visibility': 'visible'});
		bvalid= false;
	}
	return bvalid;
	  
	
}

	

	


