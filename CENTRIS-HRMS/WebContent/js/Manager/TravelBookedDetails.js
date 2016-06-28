
var filepath;
$(document).ready(function(){
	
	
	$("#bookingdate").datepicker({
		dateFormat : "dd-mm-yy",
		yearRange : 'c-65:c+65',
		changeMonth : "true",
		 maxDate: 0,
		changeYear : "true",
		numberOfMonths : 1,
		onClose : function(selectedDate) {
			$("#travellingdate").datepicker("option",
					"minDate", selectedDate);
		}
	});
	
	$("#travellingdate").datepicker({
		dateFormat : "dd-mm-yy",
		yearRange : 'c-65:c+65',
		changeMonth : "true",
		changeYear : "true",
		numberOfMonths : 1,
		onClose : function(selectedDate) {
			$("#bookingdate").datepicker("option",
					"maxDate", selectedDate);
		}
	});
	
	$.ajax({
	      type : "POST",
			url : "travelBooked.do?method=getAllprojects",
			success : function(response) {
				var result = $.parseJSON(response);
				
				
		    	for ( var j = 0; j < result.ProjectList.length; j++) {
		    		
		    
					$("#project")
							.append(
									'<option value="'
											+ result.ProjectList[j].projectcode
											+ '">'
											+ result.ProjectList[j].projectRefCode
											+ '</option>');
				}
			}
		});
	
	
	
	$("#ticketbookedby").autocomplete({
		
		source : function(request, response) {
				$.ajax({
						url : "travelBooked.do?method=getEmployeeSearch",
						dataType : "json",
						async : false,
						data : {
							featureClass : "P",
							style : "full",
							name_startsWith :request.term
						},
						
						success : function(data) {
							 $("#ticketbookedbyempid").val("");
							response($.map(data.response,
											function(
													item) {
								
												return {
																						
													value : item.employee,
													empid:item.employeeId,
												};
											}));
						}
					});
		},
		minLength : 1,
		
		select : function(event, ui) {
		
			$("#ticketbookedby").val(ui.item.value);
		
            $("#ticketbookedbyempid").val(ui.item.empid);
		}
	});
	
	
	$("#whoisontravel").autocomplete({
		source : function(request, response) {
				$.ajax({
						url : "travelBooked.do?method=getEmployeeSearch",
						dataType : "json",
						async : false,
						data : {
							featureClass : "P",
							style : "full",
							name_startsWith :request.term
						},
						success : function(data) {
							$("#whoisontravelempid").val("");
						
							response($.map(data.response,
											function(
													item) {
								
						        				return {
									
													empid:item.employeeId,
													value : item.employee,
												};
											}));
						}
					});
		},
		minLength : 1,
		select : function(event, ui) {
			var searchTerm=ui.item.label;
			
			$("#whoisontravel").val(ui.item.value);
			$("#whoisontravelempid").val(ui.item.empid);
			
		}
	});
	
	$("#debitorcreditcardused").autocomplete({
		source : function(request, response) {
				$.ajax({
						url : "travelBooked.do?method=getEmployeeSearch",
						dataType : "json",
						async : false,
						data : {
							featureClass : "P",
							style : "full",
							name_startsWith :request.term
						},
						success : function(data) {
							$("#debitorcreditcardusedempid").val("");
							response($.map(data.response,
											function(
													item) {
								
												return {
													empid:item.employeeId,
													value : item.employee,
												};
											}));
						}
					});
		},
		minLength : 1,
		select : function(event, ui) {
			$("#debitorcreditcardused").val(ui.item.label);
			$("#debitorcreditcardusedempid").val(ui.item.empid);
			
		}
	});
	
});

var Manager_flag;
function checkManager(projectCode){
	

	
  $.ajax({
	      type : "POST",
			url : "travelBooked.do?method=checkManager",
			data:{"projectCode":projectCode},
			async:false,
			success : function(response) {
				var result = $.parseJSON(response);
				
							
		    	if(result.status){
					$("#errordiv").show();
					$("#errordiv").text("Please Map the Project to any Manager");
					$(".error-box").css({"visibility":"visible"});
				
					Manager_flag=result.status;
			    }else{
		        		$("#errordiv").hide();
						$(".error-box").css({"visibility":"hidden"});
		       
					Manager_flag=result.status;
		        	 
		         }
			}
		});
	return Manager_flag;
}

var traveldateflag;
function checkvalidateTravelDate(traveldate){
	
	var bookedby=$("#ticketbookedby").val();
	var whoisontravel=$("#whoisontravel").val();
	var travellingdate=$("#travellingdate").val();
	
	var whoisontravelempid=$("#whoisontravelempid").val();
	
	$.ajax({
	      type : "POST",
			url : "travelBooked.do?method=checkvalidateTravelDate",
			data:{"whoisontravelempid":whoisontravelempid,"travellingDate":travellingdate},
			async:false,
			success : function(response) {
				var result = $.parseJSON(response);
				
				
				if(result.TravelBookedDetailsVo[0].filepath !="" && result.TravelBookedDetailsVo[0].filepath!=undefined){
					    $("#downloadtr").show();
					    filepath =result.TravelBookedDetailsVo[0].filepath;
				}else{
					  $("#downloadtr").hide();
				}	
					
			  	if(result.TravelBookedDetailsVo[0].status=="Already You Claimed for Booking Ticket"){
			   		$("#errordiv").show();
					$("#errordiv").text(result.TravelBookedDetailsVo[0].status);
					$(".error-box").css({"visibility":"visible"});
					traveldateflag=false;
				
					return false;
		       	}
			   	if(result.TravelBookedDetailsVo[0].status!=null && result.TravelBookedDetailsVo[0].status!="Already You Claimed for Booking Ticket"){
			   		
			   		var answer=confirm(result.TravelBookedDetailsVo[0].status);
		       		$("#conflictRow").val("Y");
		       		$("#errordiv").hide();
		       		$(".error-box").css({"visibility":"hidden"});
		       		traveldateflag=true;
		       		
		    	}else{
		    		$("#errordiv").hide();
		       		$(".error-box").css({"visibility":"hidden"});
		    		traveldateflag=true;
		    		
		    	}
			}
		});
	
	 return traveldateflag;
    
}
function validations(){
	
	$("#errordiv").hide();
	
	var bookedby=$("#ticketbookedby").val();
	var whoisontravel=$("#whoisontravel").val();
	var travelmode=$("#travelmode").val();
	var projectcode=$("#project").val();
	var travelFrom=$("#travelfrom").val();
	var travelto=$("#travelto").val();
	var bookingdate=$("#bookingdate").val();
	var travellingdate=$("#travellingdate").val();
	var amount=$("#amount").val();
	var debitorcreditcardused=$("#debitorcreditcardused").val();
	
	
	var ticketbookedbyempid=$("#ticketbookedbyempid").val();
	var whoisontravelempid=$("#whoisontravelempid").val();
	var debitorcreditcardusedempid=$("#debitorcreditcardusedempid").val();
	var remarks=$("#remarks").val();
	var file=$("#file").val();
	
		
	var regexpforalphabets = /^[a-zA-Z ]+$/i;
	var regex_double = '^[0-9]*\.[0-9]*$';
	var int_regex = /^\d+$/;
	
	
	var projectrefcode=$("#project option:selected").text();
	$("#projectrefcode").val(projectrefcode);
	
	
	if(bookedby == ""){
    	$("#errordiv").show();
		$("#errordiv").text(" 'Ticket Booked by' Field Should Not be Empty");
		$(".error-box").css({"visibility":"visible"});
		return false;
	}else if(ticketbookedbyempid == ""){
		$("#errordiv").show();
		$("#errordiv").text(" Enter Valid 'Ticket Booked by' Employee Field ");
		$(".error-box").css({"visibility":"visible"});
		return false;
	}else if(whoisontravel == ""){
    	$("#errordiv").show();
		$("#errordiv").text("'Resource Who is on Travel' Field Should Not be Empty ");
		$(".error-box").css({"visibility":"visible"});
		return false;
	}else if(whoisontravelempid == ""){
    	$("#errordiv").show();
		$("#errordiv").text(" Enter Valid 'Resource Who is on Travel' Employee Field ");
		$(".error-box").css({"visibility":"visible"});
		return false;
	}else if(travelmode == ""){
    	$("#errordiv").show();
		$("#errordiv").text(" 'Mode' Field Should Not be Empty");
		$(".error-box").css({"visibility":"visible"});
		return false;
	}else if(projectcode == ""){
    	$("#errordiv").show();
		$("#errordiv").text("'Project' Field Should Not be Empty");
		$(".error-box").css({"visibility":"visible"});
		return false;
	}else if(checkManager(projectcode)){
		$("#errordiv").show();
		$("#errordiv").text("Please Map the Project to any Manager");
		$(".error-box").css({"visibility":"visible"});
		return false;
	}else if(travelFrom == ""){
    	$("#errordiv").show();
		$("#errordiv").text("'Travel From'  Field Should Not be Empty");
		$(".error-box").css({"visibility":"visible"});
		return false;
	}else if(!travelFrom.match(regexpforalphabets)){
    	$("#errordiv").show();
		$("#errordiv").text("'Travel From' Field  Should be Alphabet");
		$(".error-box").css({"visibility":"visible"});
		return false;
	}else if(travelto == ""){
    	$("#errordiv").show();
		$("#errordiv").text("'Travel To' Field  Should Not be Empty");
		$(".error-box").css({"visibility":"visible"});
		return false;
	}else if(!travelto.match(regexpforalphabets)){
    	$("#errordiv").show();
		$("#errordiv").text("'Travel To'  Field Should be Alphabet");
		$(".error-box").css({"visibility":"visible"});
		return false;
	}else if(bookingdate == ""){
    	$("#errordiv").show();
		$("#errordiv").text("'Booking Date' Field Should Not be Empty");
		$(".error-box").css({"visibility":"visible"});
		return false;
	}else if(travellingdate == ""){
    	$("#errordiv").show();
		$("#errordiv").text("'Travelling Date' Field  Should Not be Empty");
		$(".error-box").css({"visibility":"visible"});
		return false;
	}else if(!checkvalidateTravelDate(travellingdate)){
    	$("#errordiv").show();
		$("#errordiv").text("Already You Claimed for Booking Ticket");
		$(".error-box").css({"visibility":"visible"});
		return false;
	}else if(amount == ""){
    	$("#errordiv").show();
		$("#errordiv").text("'Amount' Field Should Not be Empty");
		$(".error-box").css({"visibility":"visible"});
		return false;
	}else if (!((int_regex.test(amount)) || (amount.match(regex_double)))) {
		
		$("#errordiv").show();
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("'Amount'Field  should be Integer or Double ");
	   return false;
	}else if(debitorcreditcardused == ""){
    	$("#errordiv").show();
		$("#errordiv").text("'Debit/Credit Card Used' Field Should Not be Empty");
		$(".error-box").css({"visibility":"visible"});
		return false;
	}else if(debitorcreditcardusedempid == ""){
    	$("#errordiv").show();
		$("#errordiv").text("Enter Valid 'Debit/Credit Card Used' Employee Field");
		$(".error-box").css({"visibility":"visible"});
		return false;
	}else if(file==""){
		
		$("#errordiv").show();
		$("#errordiv").text("Select the File Upload");
		$(".error-box").css({"visibility":"visible"});
		return false;
		
		
	}else if(remarks.length  > 100){
		
		$("#errordiv").show();
		$("#errordiv").text("Remarks length should be 100");
		$(".error-box").css({"visibility":"visible"});
		return false;
		
		
	}else{
		$("#errordiv").hide();
	     $('#loader').show();
	     $('.submitbutton').hide();
	}
	
}

function filedownload(){
	
	var whoisontravelemp=$("#whoisontravelempid option:selected").text();
	var travellingdate=$("#travellingdate").val();
	
	window.location ="travelBooked.do?method=download&filepath="+filepath;
	
	
}
