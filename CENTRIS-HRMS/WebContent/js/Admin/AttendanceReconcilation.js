$(document).ready(function(){
	
	$("#EmpAttendance").hide();
	$("#date").datepicker({
		dateFormat : "dd-mm-yy",
		changeMonth : "true",
		maxDate : 0,
		changeYear : "true",
		buttonImage : "images/calendar.GIF",
		buttonImageOnly : true
	});
	
$("#department").change( function() {
	
  	var optionlength = $('#department > option').length;
	var selectedoptionlength = $('#department :selected').length;

	if (optionlength == selectedoptionlength) {
		
		$("#deptcheckbox").attr('checked', true);
	} 
	else {
		$("#deptcheckbox").attr('checked', false);
	}
	
	      getManagers();
	
   });
	

$("#manager").change( function() {

	var optionlength = $('#manager > option').length;
	var selectedoptionlength = $('#manager :selected').length;

	if (optionlength == selectedoptionlength) {
		
		$("#mgrcheckbox").attr('checked', true);
	} 
	else {
		$("#mgrcheckbox").attr('checked', false);
	}
	
	
	getEmployees();
	
});


$("#employee").change( function() {
	
	var optionlength = $('#employee > option').length;
	var selectedoptionlength = $('#employee :selected').length;

	if (optionlength == selectedoptionlength) {
		
		$("#empcheckbox").attr('checked', true);
	} 
	else {
		$("#empcheckbox").attr('checked', false);
	}
	
	
	
});





var count=1;
$("#Search").click(function(){
	 $("#EmpAttendance").empty();
	 var deptVal=$("#department").val();
	 var mangVal=$("#manager").val();
	 var employeeVal=$("#employee").val();
	  var dateVal=$("#date").val();
	
     if(deptVal==null){
		$("#errordiv").show();
		$("#errordiv").text("Please select the Department");
		$('.error-box').css({'visibility': 'visible'});
 	}else if(mangVal==null){
		$("#errordiv").show();
		$("#errordiv").text("Please select the Location");
		$('.error-box').css({'visibility': 'visible'});
 	}else if(employeeVal==null){
		$("#errordiv").show();
		$("#errordiv").text("Please select the Employee");
		$('.error-box').css({'visibility': 'visible'});
     }else if(dateVal==""){
    	 $("#errordiv").show();
 		$("#errordiv").text("Please select the Date");
 		$('.error-box').css({'visibility': 'visible'});
     } else{
    	 $("#errordiv").hide();
    		$('.error-box').css({'visibility': 'hidden'});
	$.ajax({
		type:'POST',
		url:"attendaceReconcil.do?parameter=getEmployeeAttendance",
		data:{"employeeVal":employeeVal.join(","),"dateVal":dateVal},
		success:function(response){
			 $("#EmpAttendance").empty();
			var result=$.parseJSON(response);
	
	if(result.EmployeeInfoList.length){
		$("#EmpAttendance").show();
		 //dynamically Created display tag	
		var tt=document.getElementById('EmpAttendance');//Created table tag
		var tr1=document.createElement("tr");//Created First TR
		var td1=document.createElement("td");//Created First TD
		
		tr1.setAttribute("style","background-color:#C8C8C8");
	
		
		var child=document.createElement('label');
	    child.innerHTML="Sno";
	 
        
		td1.appendChild(child);
		tr1.appendChild(td1);
		
		
		var td6=document.createElement("td");
		var child=document.createElement('label');
	    child.innerHTML="Employee_ID";
	
		td6.appendChild(child);
		var br6=document.createElement("br");
		td6.appendChild(br6);
		tr1.appendChild(td6);
	
		
		var td2=document.createElement("td");
		var child=document.createElement('label');
	    child.innerHTML="Employee_Name";
	
        
		td2.appendChild(child);
		var br2=document.createElement("br");
		td2.appendChild(br2);
		tr1.appendChild(td2);
	
		
		var td3=document.createElement("td");
		var child=document.createElement('label');
	    child.innerHTML="Attendance_Status";
	         
		td3.appendChild(child);
		var br3=document.createElement("br");
		td3.appendChild(br3);
		tr1.appendChild(td3);
	
		
		var td4=document.createElement("td");
		var child=document.createElement('label');
	    child.innerHTML="Payable";
	
		td4.appendChild(child);
		var br4=document.createElement("br");
		td4.appendChild(br4);
		tr1.appendChild(td4);
	
		
		
		
		var td5=document.createElement("td");
		var child=document.createElement('label');
	    child.innerHTML="Not_Payable";
	
        
		td5.appendChild(child);
	
		tr1.appendChild(td5);
		tt.appendChild(tr1);       

		
 for(var j=0;j<result.EmployeeInfoList.length;j++){
		
	
			var tr2=document.createElement("tr");//Creating Second TR
		    var td_sno=document.createElement("td");//Creating Second SNO TD
			var td_employeeName=document.createElement("td");//Creating Second employee name TD
			var td_employeeId=document.createElement("td");
			var td_attendanceStatus=document.createElement("td");//Creating Attendance Status Class TD
			var td_payable=document.createElement("td");//Creating Payble TD
			var td_netpayable=document.createElement("td");//Creating NotPayble TD
			
			td_sno.setAttribute("align","center");
			td_attendanceStatus.setAttribute("align","center");
			td_employeeId.setAttribute("align","center");
			
		var addtxt1=document.createElement("span");
		addtxt1.id="sno"+j;
		addtxt1.setAttribute("value",count);
		addtxt1.innerHTML=count;
	
		
		addtxt1.style.color = "#333";
		addtxt1.style.padding = "3px";
		addtxt1.style.fontFamily = "Segoe UI";
		addtxt1.style.width = "100px";
	    addtxt1.style.textAlign = "center";

		td_sno.appendChild(addtxt1);
		tr2.appendChild(td_sno);
		
		
		var addtxt6=document.createElement("input");
		addtxt6.type="text";
		addtxt6.id="employeeid"+j;
		addtxt6.setAttribute("class","employeeid");
		
		addtxt6.setAttribute("value",result.EmployeeInfoList[j].empid);
		addtxt6.readOnly =true;
		
	
		addtxt6.style.textAlign="center";
		addtxt6.style.width = "120px";

		
		td_employeeId.appendChild(addtxt6);
		tr2.appendChild(td_employeeId);
		
		
		var addtxt2=document.createElement("input");
		addtxt2.type="text";
		addtxt2.id="employeename";
		addtxt2.id="employeename"+j;
		addtxt2.setAttribute("class","employeename");
		
		addtxt2.setAttribute("value",result.EmployeeInfoList[j].empname);
	
	    addtxt2.readOnly =true;
		
		
		addtxt2.style.width = "120px";

		td_employeeName.appendChild(addtxt2);
		tr2.appendChild(td_employeeName);
		
		
		var addtxt3=document.createElement("span");
		addtxt3.id="attendancestatus"+j;
		addtxt3.setAttribute("class","attendancestatus");
		addtxt3.setAttribute("value",result.EmployeeInfoList[j].status);
		addtxt3.innerHTML=result.EmployeeInfoList[j].status;
	
	
		addtxt3.style.width = "120px";

		td_attendanceStatus.appendChild(addtxt3);
		tr2.appendChild(td_attendanceStatus);
		
		
		var addtxt4=document.createElement("select");
		addtxt4.id="payable"+j;
		addtxt4.setAttribute("class","payable");
	
		
		var option = new Option("Casual leave-CL","1");
		var option0 = new Option("---select---","");
		var option1 = new Option("Sick leave -SL","2");
		var option2 = new Option("Earned leave -EL","3");
		var option3 = new Option("General Holiday -H","4");
		var option4 = new Option("Weekly Off - w","5");
		var option5 = new Option("On Duty -  OD","6");
		 var option6 = new Option("Compensation off -CO","7");
	
		addtxt4.options[addtxt4.options.length] = option0;
		addtxt4.options[addtxt4.options.length] = option;
		addtxt4.options[addtxt4.options.length] = option1;
		addtxt4.options[addtxt4.options.length] = option2;
		addtxt4.options[addtxt4.options.length] = option3;
		addtxt4.options[addtxt4.options.length] = option4;
		addtxt4.options[addtxt4.options.length] = option5;
		addtxt4.options[addtxt4.options.length] = option6;
	
	/*	addtxt4.style.color = "#333";
		addtxt4.style.padding = "3px";
		addtxt4.style.fontFamily = "Segoe UI";
		addtxt4.style.width = "138px";*/

		td_payable.appendChild(addtxt4);
		tr2.appendChild(td_payable);
		
		
		
		var addtxt5=document.createElement("select");
		addtxt5.id="nonpayable"+j;
		addtxt5.setAttribute("class","nonpayable");
		
		var option = new Option("ESI-Leave -ESI","8");
		var option0 = new Option("---select---",
				"");
		var option1 = new Option("Maternity leave -ML","9");
		addtxt5.options[addtxt5.options.length] = option0;
		addtxt5.options[addtxt5.options.length] = option;
		addtxt5.options[addtxt5.options.length] = option1;
		
	/*	addtxt5.style.color = "#333";
		addtxt5.style.padding = "3px";
		addtxt5.style.fontFamily = "Segoe UI";
		addtxt5.style.width = "138px";*/

		td_netpayable.appendChild(addtxt5);
		tr2.appendChild(td_netpayable);
		
		tt.appendChild(tr2);
	
		count++;
		if(count>result.EmployeeInfoList.length){
			count=1;
		}
		
				
	    $(".payable").change(function(){
	    	if($(this).val()==0){
	    		$(this).parent().next().find(".nonpayable").removeAttr('disabled');
	    	}else{
			    $(this).parent().next().find(".nonpayable").attr('disabled', 'disabled');
	    	}

        });
	       
    	$(".nonpayable").change(function(){
    		
    		if($(this).val()==0){
	    		$(this).parent().prev().find(".payable").removeAttr('disabled');
	    	}else{
	    		$(this).parent().prev().find(".payable").attr('disabled', 'disabled');
	    	}
			
		});
    
		
		
 }
		var uploadBtn_tr1 = document.createElement("tr"); //Creating TR Tag for Button
		var  uploadBtn_td1 = document.createElement("td"); // Creating  TD for Button
		
		uploadBtn_td1.setAttribute("align","center");
		uploadBtn_td1.setAttribute("colspan","6");
			
		 var  uploadBtn = document.createElement("input");
		 uploadBtn.setAttribute("type","button");
		 uploadBtn.setAttribute("value","Save Attendance Reconcil");
		 uploadBtn.setAttribute("name","uploadattendance");
		 uploadBtn.setAttribute("class","uploadattendance");
				
		 uploadBtn.style.background="#1267E9";
		 uploadBtn.style.padding="5px";
		 uploadBtn.style.border_style="hidden";
		 uploadBtn.style.color="#FFFFFF";
		 uploadBtn.style.textAlign ="center";
		 uploadBtn.style.fontSize="13px";
		 uploadBtn.style.fontWeight="bold";
		 uploadBtn.style.cursor="pointer";
		 uploadBtn.style.font_family="Segoe UI";
		
		
		 
		 uploadBtn_td1.appendChild(uploadBtn); 
		 uploadBtn_tr1.appendChild(uploadBtn_td1);
		document.getElementById("uploadbutton").appendChild(uploadBtn_tr1);
	
			
	 $(".uploadattendance").click(function(){
			 var empValarray=[];
			 var payble=[];
			 var notpayble=[];
			 
			 $('#EmpAttendance tr').each(function () {
				   var row = $(this);
				
	           	   empValarray.push(row.find('[class="employeeid"]').val());
				   payble.push(row.find('[class="payable"]').val());
				   notpayble.push(row.find('[class="nonpayable"]').val());
	            });
		     var date=$("#date").val();	
   			$.ajax({
			type:'POST',
			url:"attendaceReconcil.do?parameter=attendnaceReconcilInsertion",
			data:{"employeeid":empValarray,"payble":payble,"notpayble":notpayble,"date":date},
			success:function(response){
			var data=$.parseJSON(response);
			
		
	        	window.location="attendaceReconcil.do?parameter=attendanceReconcilationHome&status="+data.result;
							
			    }
		        });
		  		 
		 
		 });
		 
	
		}else{
			$("#EmpAttendance").hide();
			
			var spantag=document.getElementById('uploadbutton');//Created table tag
			//var tr1=document.createElement("tr");//Created First TR
			//var td1=document.createElement("td");
			
			//var spantag=document.createElement("label");
			spantag.innerHTML="Nothing found to display";
			//td1.appendChild(spantag);
			//tr1.appendChild(td1);
			//tt.appendChild(tr1);
		}
	
	}
	});
  }
});
});


function selectAllDepartments(){
	
	if ($("#deptcheckbox").is(':checked')) {

		$("#department option").attr('selected', true);

	} else {

		$("#department option").attr('selected', false);
	}

    getManagers();
	
	
}
function selectAllManagers(){
	
	if ($("#mgrcheckbox").is(':checked')) {

		$("#manager option").attr('selected', true);

	} else {

		$("#manager option").attr('selected', false);
	}

	getEmployees();
	
	
}

function selectAllEmployees(){
	
	if ($("#empcheckbox").is(':checked')) {

		$("#employee option").attr('selected', true);

	} else {

		$("#employee option").attr('selected', false);
	}

	
}



 function getManagers(){
	 
	 var deptList = []; 
		$('#department :selected').each(function(i, selected){ 
			deptList[i] = $(selected).val(); 
		});
	    
		var sendParam = {
				'dept' : deptList.join(",")
			};
		
		$.ajax({
			type:'POST',
			url:"attendaceReconcil.do?parameter=getManagersByDept",
			data:sendParam,
			success:function(response){
				var result=$.parseJSON(response);
				$("#manager").html("");
				for(var j=0;j<result.ManagerList.length;j++){
				$("#manager").append('<option value="'
						+ result.ManagerList[j].managerid
						+ '">'
						+ result.ManagerList[j].managername
						+ '</option>');
				}
			}
		});
	 
 }

function getEmployees(){
	
	var mangList = []; 
	$('#manager :selected').each(function(i, selected){ 
		mangList[i] = $(selected).val(); 
	});
    
	var sendParam = {
			'manager' : mangList.join(",")
		};
	

	$.ajax({
		type:'POST',
		url:"attendaceReconcil.do?parameter=getEmployeeByMang",
		data:sendParam,
		success:function(response){
			var result=$.parseJSON(response);
			$("#employee").html("");
		for(var j=0;j<result.employeeList.length;j++){
			$("#employee").append('<option value="'
					+ result.employeeList[j].empid
					+ '">'
					+ result.employeeList[j].empname
					+ '</option>');
			}
		}
	});
	
	
	
}