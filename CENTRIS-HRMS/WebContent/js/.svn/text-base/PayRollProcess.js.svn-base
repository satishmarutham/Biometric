$(document).ready(function(){
var Thead=$('#depRecords thead').find('tr');
$('<tr><th colspan="2"> </th><th colspan="4">Internal</th><th colspan="4">External</th></tr>').insertBefore(Thead);
	
	$( "#startDate,#endDate" ).datepicker({
		changeMonth: true,
		changeYear: true,
		dateFormat: 'dd-mm-yy',
	});
	if($('#mailMessage').val()!=""){
		alert($('#mailMessage').val());
		$('#mailMessage').val("");
	}
	$('#depRecords.displayTableClass').find('tr:nth-child(1)').css({'height':'35px'});
	$('#depRecords.displayTableClass').find('tr:nth-child(2)').css({'height':'30px'});
	$('#depRecords.displayTableClass').find('th').css({'color':'white','font-size':'14px','font-weight':'normal'});
	
	$('#depRecords.displayTableClass').delegate('.button1','click',function(){
		$(this).val('Sending...');
	});
	
});
function createPaySlip(){
	if($('#serchedCategory').text().trim()=="Contract")
		window.location.href="payRollProcess.do?method=getHourlyPaySlip";
	else
		window.location.href="payRollProcess.do?method=getPaySlip";
	
}
function validatePayRoleProcess(){
	var formCategory = $('#empCategory option:selected').text();
	var formPayment = $('#payment option:selected').text();
	var formShift = $('#empShift option:selected').text();
	var formStartDate = $('#startDate').val();
	var formEndDate = $('#endDate').val();
	var latestCategory = $('#latestSearch #category').text();
	var latestPaymentType = $('#latestSearch #paymentType').text();
	var latestShift = $('#latestSearch #shift').text();
	var latestSDate = $('#latestSearch #sDate').text();
	var latestEDate = $('#latestSearch #eDate').text();
	
	var d1 = Date.parse(dateConverter(formStartDate));
	var d2 = Date.parse(dateConverter(formEndDate));
	var d3 = Date.parse(dateConverter(latestSDate));
	var d4 = Date.parse(dateConverter(latestEDate));
	if(formStartDate==""){
		$('#alertMessage').text("Start Date Should Not Be Empty");
		return false;
	}
	if(formEndDate==""){
		$('#alertMessage').text("End Date Should Not Be Empty");
		return false;
	}
	if(d1>d2){
		$('#alertMessage').text("Start Date Should Be Less Than End Date");
		return false;
	}

	if(formCategory.trim()!=latestCategory.trim() || formPayment.trim()!=latestPaymentType.trim()   || (formShift.trim() != latestShift.trim() && latestShift.trim() !="All") || (d1<d3 && d2<d3) || (d1>d4 && d2>d4)){
		return true;
	}
	else{
		$('#alertMessage').text("Previous Batch Run");
		return false;
	}
	
}

function dateConverter(dateString){
	var dateArray=[];
	var dateStringArray=dateString.split("-");
	dateArray.push(dateStringArray[2]);
	dateArray.push(dateStringArray[1]);
	dateArray.push(dateStringArray[0]);
	var dateString1 = dateArray.join("-");
	return dateString1;
	
}

function sendMail(parameter){
	window.location.href="consolidatedpayRoll.do?method=sendPaySlipToEmpMail"+parameter;
	$('#depRecords').css({'z-index':1,'position':'absolute'});
	$('#imageDiv').css({'display':'block','width':$('html').width(),'height':'2000px'});
/*	$.ajax({
		url:"consolidatedpayRoll.do?method=sendPaySlipToEmpMail",
		async:false,
		data:parameter,
		success:function(){
		}
	});*/
}
function openPDF(parameter){
	$.ajax({
		url:"consolidatedpayRoll.do?method=openPDF",
		async:false,
		data:parameter,
success:function(){
			
		}
	});
}