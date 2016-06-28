$(document).ready(function(){
	
	
	$(".employeeId").hide();
	
	$('#stratdate').attr("placeholder", "Click here");
	$('#enddate').attr("placeholder", "Click here");
	
	if(($('#currentempid').val()!=undefined) && ($('#currentempid').val()!="")){
		
		var empSerachDetails=$('#currentempid').val().trim().split(",");
	
		$("#employee option[value="+empSerachDetails[0]+"]").attr('selected', 'true');
		$("#stratdate").val(empSerachDetails[1]);
		$("#enddate").val(empSerachDetails[2]);
		$("#selectattendance option[value="+$("#currentstatus").val().trim()+"]").attr('selected', 'true');
		
	}
	
	$("#stratdate").datepicker(
			{
				dateFormat : "dd-mm-yy",
				yearRange : 'c-65:c+65',
				changeMonth : "true",
				changeYear : "true",
				numberOfMonths : 1,
				onClose : function(selectedDate) {
					$("#enddate").datepicker("option", "minDate",
							selectedDate);
				}
			});
	$("#enddate").datepicker(
			{
				dateFormat : "dd-mm-yy",
				yearRange : 'c-65:c+65',
				changeMonth : "true",
				changeYear : "true",
				numberOfMonths : 1,
				onClose : function(selectedDate) {
					$("#stratdate").datepicker("option", "maxDate",
							selectedDate);
				}
			});
	
	
	

	
	if( ($('#currentstatus').val()!=undefined) && ($('#currentstatus').val()!="")){
		
		
		var status=$('#currentstatus').val();
		
		
		$("#selectattendance option[value="+status+"]").attr('selected', 'true');
		
	}
	
	$('.editfunction').click(function(){
		
		var attendencedate=this.id;
	
		$(this).parents('tr:first').find('td:nth-child(12)').find('input[type=button]').val("Approve");
		$(this).parents('tr:first').find('td:nth-child(12)').find('input[type=button]').css('color','black');
		$(this).parents('tr:first').find('td:nth-child(12)').find('input[type=button]').css("background-color","#f9f9f9 ");
		
		
		 $('#'+attendencedate+'status').prop('disabled', false);
		 
		 $('#'+attendencedate+'projectname').prop("disabled", false);
		 
		 $('#'+attendencedate+'location').removeAttr( "readonly" );
		 
		 $('#'+attendencedate+'statustype').prop("disabled", false);
		 
		 $("#attendance .inTimeClass"+attendencedate+",.outTimeClass"+attendencedate+"").datetimepicker({
				
				pickDate : false,
				 
			});
		 
		 var projectname= $('#'+attendencedate+'projectname').val();
		 var status= $('#'+attendencedate+'status').val();
		 var statustype= $('#'+attendencedate+'statustype').val();
		
		 $.ajax({
			 
				type : 'POST',
				url : "managerLeaveApprovedbydate.do?parameter=getAttendanceStatus",
				async:false,
				
				success : function(response) {
					var result = $.parseJSON(response);
					
					$('#'+attendencedate+'status').html("");
					
					$('#'+attendencedate+'status').append(
							'<option value="'
									+ ""
									+ '">'
									+ "---Select---"
									+ '</option>');
					
					for (var j = 0; j < result.att_status.length; j++) {
						
						$('#'+attendencedate+'status').append(
								'<option value="'
										+ result.att_status[j].attendancestatus
										+ '">'
										+ result.att_status[j].attendancestatus
										+ '</option>');
					}
					
					
					$("#attendance #"+attendencedate+"status option[value^='"+status+"']").attr('selected', 'true');
					
					

				}
			});
			
			
			 $.ajax({
				 
					type : 'POST',
					url : "managerLeaveApprovedbydate.do?parameter=getAttendanceStatusType",
					async:false,
					
					success : function(response) {
						var result = $.parseJSON(response);
						
						$('#'+attendencedate+'statustype').html("");
						
						$('#'+attendencedate+'statustype').append(
								'<option value="'
										+ ""
										+ '">'
										+ "---Select---"
										+ '</option>');
						
						for (var j = 0; j < result.ATT_TYPE_LIST.length; j++) {
							$('#'+attendencedate+'statustype').append(
									'<option value="'
											+ result.ATT_TYPE_LIST[j].attendencetypecode
											+ '">'
											+ result.ATT_TYPE_LIST[j].attendancetype
											+ '</option>');
						}
						
						$("#attendance #"+attendencedate+"statustype option[value^="+statustype+"]").attr('selected', 'true');

					}
				});
			 
			 $.ajax({
				 
					type : 'POST',
					url : "managerLeaveApprovedbydate.do?parameter=getClients",
					data: {"empId":$("#employee").val().trim()},
					async:false,
					
					success : function(response) {
						var result = $.parseJSON(response);
						
						$('#'+attendencedate+'projectname').html("");
						
						$('#'+attendencedate+'projectname').append(
								'<option value="'
										+ ""
										+ '">'
										+ "---Select---"
										+ '</option>');
						
						
						
						for (var j = 0; j < result.client_list.length; j++) {
							
							
							$('#'+attendencedate+'projectname').append(
									'<option value="'
											+ result.client_list[j].clientcode
											+ '">'
											+ result.client_list[j].clientname
											+ '</option>');
						}
						
						$("#attendance #"+attendencedate+"projectname option[value^="+projectname+"]").attr('selected', 'true');

					}
				});
			
		
	});
	
	
	$('.updatefunction').click(function(){
		var object=$(this);
		var id=this.id;
		var updateid=id;
		var flag=true;
		
		var update_details=id.split("--");
		var attendencedate=update_details[0];
		var empid=update_details[1];
		
		var attendence_status=	$('#'+id+'status').val();
		 
		var inTime= $('#'+id+'intime1').val();
		 
		 var outTime=$('#'+id+'outtime').val();
		 
		var project_name= $('#'+id+'projectname').val();
		 
		 var location=$('#'+id+'location').val();
		 
		 var status_type=$('#'+id+'statustype').val();
		 
		 
		 if(attendence_status.trim()=="" || attendence_status.trim()=="yet to post"){
				
				$('.error-box').css({
					'visibility' : 'visible'
				});
				$("#errordiv").text("select attandance status");
				
				return false;
				
		}else if(attendence_status=="Present"){
		 
			 if(status_type==""){
			
			$('.error-box').css({
				'visibility' : 'visible'
			});
			$("#errordiv").text("select attendance type");
			return false;
			
		}/*else	if(location==""){
			
			$('.error-box').css({
		'visibility' : 'visible'
			});
			$("#errordiv").text("Employee location should not be empty");
			return false;
	
		}*/else if(project_name==""){
			
			$('.error-box').css({
				'visibility' : 'visible'
			});
			$("#errordiv").text("select client name");
			return false;
			
		}else{
			
			
			

			var ftimeSplitHour = inTime.split(':')[0];
			var ftimeSplitMin = inTime.split(':')[1];
			var ftimeSplitSec = inTime.split(':')[2];

			var ttimeSplitHour = outTime.split(':')[0];
			var ttimeSplitMin = outTime.split(':')[1];
			var ttimeSplitSec = outTime.split(':')[2];

			if (ftimeSplitHour.charAt(0) == 0) {
				ftimeSplitHour = ftimeSplitHour.charAt(1);
			}
			if (ttimeSplitHour.charAt(0) == 0) {
				ttimeSplitHour = ttimeSplitHour.charAt(1);
			}

			if (ftimeSplitMin.charAt(0) == 0) {
				ftimeSplitMin = ftimeSplitMin.charAt(1);
			}
			if (ttimeSplitMin.charAt(0) == 0) {
				ttimeSplitMin = ttimeSplitMin.charAt(1);
			}

			if (ftimeSplitSec.charAt(0) == 0) {
				ftimeSplitSec = ftimeSplitSec.charAt(1);
			}
			if (ttimeSplitSec.charAt(0) == 0) {
				ttimeSplitSec = ttimeSplitSec.charAt(1);
			}

			ftimeSplitHour = parseInt(ftimeSplitHour);
			ttimeSplitHour = parseInt(ttimeSplitHour);
			ftimeSplitMin = parseInt(ftimeSplitMin);
			ttimeSplitMin = parseInt(ttimeSplitMin);

			ftimeSplitSec = parseInt(ftimeSplitSec);
			ttimeSplitSec = parseInt(ttimeSplitSec);
			

			if (ftimeSplitHour > ttimeSplitHour) {
				$("#errordiv").show();
				$("#errordiv").text("The Out Time Should Not less than In Time");
				$('.error-box').css({'visibility': 'visible'});
				 flag=false;
			}
			
				if (ttimeSplitHour == ftimeSplitHour) {
				if (ftimeSplitMin > ttimeSplitMin) {
					$("#errordiv").show();
					$("#errordiv").text("The Out Time Should Not less than In Time");
					$('.error-box').css({'visibility': 'visible'});
				
					flag=false;
				}
				if (ftimeSplitMin == ttimeSplitMin) {
					if (ftimeSplitSec >= ttimeSplitSec) {
						$("#errordiv").show();
						$("#errordiv").text("The Out Time Should Not less than In Time");
						$('.error-box').css({'visibility': 'visible'});
						flag=false;
					}
				}
			}
				
		}	
		
		}else if(status_type==""){
			
			$('.error-box').css({
				'visibility' : 'visible'
			});
			$("#errordiv").text("select attendance type");
			return false;
			
		}
		if(flag){
		 
		$("#errordiv").hide();
		
		 var empatendance_details={
			
				 "empid":empid,
				 "attendencedate":attendencedate,
				 "attendence_status":attendence_status,
				 "status_type":status_type,
				/* "location":location,*/
				 "project_name":project_name,
				 "inTime":inTime,
				 "outTime":outTime
				 
		 };
		 
		 
		 
		 $.ajax({
			 
				type : 'POST',
				url : "managerLeaveApprovedbydate.do?parameter=updateEmpAttendance",
				data :empatendance_details,
				 beforeSend: function() {
				       
					  $('#loader').show();
					  
				    },
				
				success : function(response) {
					var result = $.parseJSON(response);
					
					 $('#loader').hide();
					 $('#'+update_details+'status').prop('disabled', true);
					 
					 $('#'+update_details+'projectname').prop("disabled", true);
					 
					 /*$('#'+update_details+'location').attr('readonly', true);*/
					 
					 $('#'+update_details+'statustype').prop("disabled", true);
					
					 object.val("Approved");
					 object.css('color','white');
					 object.css("background-color","#1267E9");
					 
					 
					 
					
					
				}
			});
		 
			}
	
		
	});
	

	
});

function updateAll(){
	
	
	var dataArray=$('#currentempid').val().split(",");
	
	var startdate=dataArray[1];
	var enddate=dataArray[2];
	
	var empid=[];
	var sno=[];
	var attendanceDate=[];
	var inTime=[];
	var outTime=[];
	/*var location=[];*/
	var status=[];
	var statustype=[];
	var projectName=[];
	
	 $("#attendance tr").each(function(){
		 
		 
		 
			
		   var snoVal=$(this).find('.sno').text();
				  
		    if(snoVal!=undefined && snoVal!=''){
		    	sno.push(snoVal.trim());
		    	
			}
		    
		    var empidVal=$(this).find('.employeeId').text();
			  
		    if(empidVal!=undefined &&  empidVal!='EmployeeId'){
		    	
		    	empid.push(empidVal.trim());
		    	
			}
		    
		   
		    var dateval =$(this).find('.attendanceDate').val();
		
		    if(dateval!=undefined ){
			 
		    	attendanceDate.push(dateval.trim());

	    	 }
		  
		   var intimeval =$(this).find('.intime').val();
	
		   if(intimeval!=undefined ) {
     
			   inTime.push(intimeval.trim());
  			
		   }
		
		   var outtimeval =$(this).find('.outtime').val();

           if(outtimeval!=undefined){
			 
        	   outTime.push(outtimeval.trim());
		      }
     
         /*   var locationVal =$(this).find('.location').val();
  
            if(locationVal!=undefined){
     	            if(locationVal==''){
     	            	location.push("null");
     	            }else{
            	location.push(locationVal.trim());
     	            } 	
		     }*/
     
       
            var statusval =$(this).find('.status').val();
            
            if(statusval!=undefined ){
     	            	
            	status.push(statusval.trim());
     	      }
     
            var statustypeval =$(this).find('.statusType').val();
            
            if(statustypeval!=undefined ){
     	            	
            	statustype.push(statustypeval.trim());
     	      }
            
              
           
            var projectNameval =$(this).find('.projectName').val();
            
            
            if(projectNameval!=undefined ){
     	           
            	if(projectNameval==""){
            		
            		projectName.push("null");
            	}else{
            		
            		projectName.push(projectNameval.trim());
            	}
            	
     	      }
        
				
	});
	 
	 
	 for (var i = 0; i < attendanceDate.length; i++) {
		 
		 
	
		 if(status[i]=="" || status[i]==undefined){
			 
				$("#errordiv").show();
	    		$("#errordiv").text("Select Status");
	    		$(".error-box").css({"visibility":"visible"});
	    	return false;
			
		 }else if(status[i]=="Present"){
			 
			  if(statustype[i]=="" || statustype[i]==undefined){
					$("#errordiv").show();
		    		$("#errordiv").text("Select StatusType");
		    		$(".error-box").css({"visibility":"visible"});
		    	return false;
				}else if(inTime[i]==null || inTime[i]==""){
				$("#errordiv").show();
		 		$("#errordiv").text("Select Intime");
				 $('.error-box').css({'visibility': 'visible'});
				return false;
			}else  if(outTime[i]=="" || outTime[i]==undefined){
				$("#errordiv").show();
	       	     $("#errordiv").text("Select Outtime");
				 $('.error-box').css({'visibility': 'visible'});
				 return false;
			}else if(projectName[i]=="null" || projectName[i]==undefined){
				$("#errordiv").show();
	    		$("#errordiv").text("Select Project");
	    		$(".error-box").css({"visibility":"visible"});
	    	return false;
			}
			else{
				
				var ftimeSplitHour = inTime[i].split(':')[0];
				var ftimeSplitMin = inTime[i].split(':')[1];
				var ftimeSplitSec = inTime[i].split(':')[2];

				var ttimeSplitHour = outTime[i].split(':')[0];
				var ttimeSplitMin = outTime[i].split(':')[1];
				var ttimeSplitSec = outTime[i].split(':')[2];

				if (ftimeSplitHour.charAt(0) == 0) {
					ftimeSplitHour = ftimeSplitHour.charAt(1);
				}
				if (ttimeSplitHour.charAt(0) == 0) {
					ttimeSplitHour = ttimeSplitHour.charAt(1);
				}

				if (ftimeSplitMin.charAt(0) == 0) {
					ftimeSplitMin = ftimeSplitMin.charAt(1);
				}
				if (ttimeSplitMin.charAt(0) == 0) {
					ttimeSplitMin = ttimeSplitMin.charAt(1);
				}

				if (ftimeSplitSec.charAt(0) == 0) {
					ftimeSplitSec = ftimeSplitSec.charAt(1);
				}
				if (ttimeSplitSec.charAt(0) == 0) {
					ttimeSplitSec = ttimeSplitSec.charAt(1);
				}

				ftimeSplitHour = parseInt(ftimeSplitHour);
				ttimeSplitHour = parseInt(ttimeSplitHour);
				ftimeSplitMin = parseInt(ftimeSplitMin);
				ttimeSplitMin = parseInt(ttimeSplitMin);

				ftimeSplitSec = parseInt(ftimeSplitSec);
				ttimeSplitSec = parseInt(ttimeSplitSec);
				
				if (ftimeSplitHour > ttimeSplitHour) {
					$("#errordiv").show();
		    		$("#errordiv").text("The Out Time Should Not less than In Time");
		    		$(".error-box").css({"visibility":"visible"});
					
		    		return false;
				}
				
					if (ttimeSplitHour == ftimeSplitHour) {
					if (ftimeSplitMin > ttimeSplitMin) {
						$("#errordiv").show();
						$("#errordiv").text("The Out Time Should Not less than In Time");
						$('.error-box').css({'visibility': 'visible'});
					
						return false;
					}
					if (ftimeSplitMin == ttimeSplitMin) {
						if (ftimeSplitSec >= ttimeSplitSec) {
							$("#errordiv").show();
							$("#errordiv").text("The Out Time Should Not less than In Time");
							$('.error-box').css({'visibility': 'visible'});
							return false;
						}
					}
				}
					
				$("#errordiv").hide();
				$('.error-box').css({'visibility' : 'hidden'});
				
			   }
	  		
		 }else if(statustype[i]=="" || statustype[i]==undefined){
				$("#errordiv").show();
	    		$("#errordiv").text("Select StatusType");
	    		$(".error-box").css({"visibility":"visible"});
	    	return false;
			}
			
		}
	 
	
	var empdetails={
			"startdate":startdate,
			"enddate":enddate,
			"empid":empid.join(","),
			"sno":sno.join(","),
			"attendanceDate":attendanceDate.join(","),
			"inTime":inTime.join(","),
			"outTime":outTime.join(","),
			/*"location":location.join(","),*/
			"status":status.join(","),
			"statustype":statustype.join(","),
			"projectName":projectName.join(","),
			
			};	
	var x = confirm("Are you sure you want to approve all employees attendance");
	if (x) {
	
	 $.ajax({
		 
			type : 'POST',
			url : "managerLeaveApprovedbydate.do?parameter=updateAllEmpAttendance",
			data :empdetails,
			 beforeSend: function() {
			       
				  $('#loader').show();
				  
			    },
			
			success : function(response) {
				var result = $.parseJSON(response);
				
				window.location.href="GetDetails.do?parameter=getAttendanceApprovalByDate&status="+result.status;
				
			}
		});
	}
	
}

function getAttendanceSelectType(){
	
	var empdetails=$('#currentempid').val();
	var selectattendance=$('#selectattendance').val();
	
	
	window.location.href="managerLeaveApprovedbydate.do?parameter=getEmployeeSpecificAttendence&empdetails="+empdetails+"&selectattendance="+selectattendance;
	
	
}

function validations(){
	
	var startdate=$("#stratdate").val();
	var enddate=$("#enddate").val();
	var employee=$("#employee").val();
	
	
	if(startdate==""){
		
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("select start date");
		
		return false;
		
	}else if(enddate==""){
		
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("select end date");
		
		return false;
		
	}else if(employee==""){
		
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("select employee");
		
		return false;
		
	}else{
		
		return true;
	}
	
}
