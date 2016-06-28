var employeeArray=[];
	function  getEmployeedetails(employeeCode,employeeName,sno){
	
var Sno=sno;
		 
			 if(sno==undefined){
				 Sno=1;
			 }
			 else
				 {
				 Sno=sno;
				 
				 }
			 
		 $.ajax({
				
				type:"POST",
				url:"managerMenu.do?parameter=getEmployeeDetailsById",
				data :{"employeeId":employeeCode},
	
			    success:function(data){
			  
					var result=$.parseJSON(data);
					
		if(Sno==1){
					
					$("#employeeCodeId"+Sno).val(result.employeeListDetails[0].bioId);
					$("#projectCodeId"+Sno).val(result.employeeListDetails[0].projectCode);
					/*$("#projectReferenceCodeId  option[value=" +result.employeeListDetails[0].projectReferenceCode+ "]").attr(
							'selected', 'true');*/
			}else{
				
					$("#employeeCodeId"+Sno).val(result.employeeListDetails[0].bioId);
					$("#projectCodeId"+Sno).val(result.employeeListDetails[0].projectCode);
					
				/*	$("#projectReferenceCodeId1"+Sno+" option[value=" + result.employeeListDetails[0].projectReferenceCode+ "]").attr(
							'selected', 'true');*/
					
				}
					
								
				}
			
			});
		
		 
		 
		
	}

	
	
$(document).ready(function(){
	var cnt=1;
	getEmployees();
	$("#loading").hide();
/*$(".error-box").hide();
$("#errordiv").hide();*/

	var projectReferenceCode="#"+"projectReferenceCodeId";
	getProjectReferenceCode(projectReferenceCode);
	

	
	
	$("#Add").click(
			function() {
				
				
				cnt++;
			
				var tr1 = document.createElement("tr");
				var td1 = document.createElement("td");
				var check = document.createElement("span");
				check.id = "sno" + cnt;
				check.name = "sno";
				td1.appendChild(check);
				tr1.appendChild(td1);
				
				
				var selectElementone = document.createElement("select");
				
				selectElementone.name = "employeename";
				selectElementone.id = "employeeId"+cnt;
				selectElementone.setAttribute("class","selectClass");
				
				selectElementone.style.fontSize="12px";
				selectElementone.style.padding="2px";
				selectElementone.style.width="104%";
				selectElementone.style.height="26px";
				
				var td2 = document.createElement("td");
				td2.appendChild(selectElementone);
				tr1.appendChild(td2);
				
				
				var selectElementtwo = document.createElement("input");
				
				selectElementtwo.type="text";
				selectElementtwo.name = "employeeCode";
				selectElementone.setAttribute("class","selectClass");
				
				selectElementtwo.id = "employeeCodeId"+cnt;
				selectElementtwo.readOnly="true";
				
				selectElementtwo.style.background="#C2C2C2";
				selectElementtwo.style.border="1px solid #999999";
			
				selectElementtwo.style.fontSize="12px";
				selectElementtwo.style.padding="2px";
				selectElementtwo.style.width="96%";
				selectElementtwo.style.height="21px";
				
				var td3 = document.createElement("td");
				td3.appendChild(selectElementtwo);
				tr1.appendChild(td3);
				var selectElementThree = document.createElement("select");
				
				selectElementThree.name = "projectReferenceCode";
				selectElementThree.id = "projectReferenceCodeId1"+cnt;
				selectElementThree.setAttribute("class","projectReferenceCodeClass");
				
				selectElementThree.style.fontSize="12px";
				selectElementThree.style.padding="2px";
				selectElementThree.style.width="104%";
				selectElementThree.style.height="26px";
				
				var td2 = document.createElement("td");
				td2.appendChild(selectElementThree);
				tr1.appendChild(td2);
			
				
				var selectElementfourth = document.createElement("input");
				
				selectElementfourth.type = "text";
				selectElementfourth.name = "salary";
				selectElementfourth.id = "salaryId"+cnt;
				selectElementfourth.setAttribute("class","salaryClass");
				

			
				selectElementfourth.style.border="1px solid #999999";
				
				selectElementfourth.style.fontSize="12px";
				selectElementfourth.style.padding="2px";
				selectElementfourth.style.width="96%";
				selectElementfourth.style.height="21px";
				
				var td5 = document.createElement("td");
				td5.appendChild(selectElementfourth);
				tr1.appendChild(td5);
			
				
			
				var selectElementfifth = document.createElement("textarea");
				selectElementfifth.name = "description";
				selectElementfifth.id = "descriptionId"+cnt;
				selectElementfifth.setAttribute("class","descriptionClass");
				selectElementfifth.rows="2";
				selectElementfifth.cols="22";
				
				selectElementfifth.style.fontSize="12px";
				
				selectElementfifth.style.padding="2px";
				selectElementfifth.style.width="98%";
				selectElementfifth.style.height="40px";
				
				var td6 = document.createElement("td");
				td6.appendChild(selectElementfifth);
				tr1.appendChild(td6);	
				
				
				
			
	var selectElementsixth = document.createElement("input");
				
	selectElementsixth.type = "image";
	selectElementsixth.name = "delete";
	selectElementsixth.id = "delete"+cnt;
			
	selectElementsixth.src="images/trash.gif";
	
	
					
	var td7 = document.createElement("td");
	td7.appendChild(selectElementsixth);
	tr1.appendChild(td7);
				
		
	var selectElementSeventh = document.createElement("input");
		
	 selectElementSeventh.type = "hidden";
	 selectElementSeventh.name = "projectCode";
	 selectElementSeventh.id = "projectCodeId"+cnt;
/*	 selectElementSeventh.value = result.projectCodeReferenceList[j].projectReferenceCode;*/
	 selectElementSeventh.setAttribute("class","projectCodeClass");
		
		var td8 = document.createElement("td");
		td8.appendChild(selectElementSeventh);
		tr1.appendChild(td8);
	document.getElementById("salaryRequest").appendChild(tr1);
				
			
				$("#"+check.id).text(""+cnt);
				
				document.getElementById(selectElementsixth.id).onclick=deletMethod;
			
					
				$.ajax({
					
					type:"POST",
					url:"managerMenu.do?parameter=advanceSalaryRequestEmployee",
					success:function(data){
				  
						var result=$.parseJSON(data);
					$("#"+"employeeId"+cnt).append(
								'<option value="'
										+ ""
										+ '">'
										+ "-----select-----"
										+ '</option>');
												
						for(var j=0 ;j<result.employeeList.length;j++){
						
							$("#"+"employeeId"+cnt).append(
									'<option value="'
									+ result.employeeList[j].empid
									+ '">'
									+ result.employeeList[j].empname
									+ '</option>');
							
						}
				
					for(var k=0 ;k < employeeArray.length; k++){
							
							$("#"+"employeeId"+cnt+" > option").map(function() {
								if ($(this).val() == employeeArray[k]) {
									/*$(this).attr('disabled', true);*/
									$(this).remove();
									
								}
							});
						
					}
					
					}
				
				});
				
				//
	$.ajax({
					
					type:"POST",
					url:"managerMenu.do?parameter=getProjectCodeReferenceByManager",
					success:function(data){
					
				  
						var result=$.parseJSON(data);
					$("#"+"projectReferenceCodeId1"+cnt).append(
								'<option value="'
										+ ""
										+ '">'
										+ "-----select-----"
										+ '</option>');
												
						for(var j=0 ;j<result.projectCodeReferenceList.length;j++){
							
							$("#"+"projectReferenceCodeId1"+cnt).append(
									'<option value="'
									+result.projectCodeReferenceList[j].projectReferenceCode
									+ '">'
									+result.projectCodeReferenceList[j].projectReferenceCode
									+ '</option>');
							
						}
						

					}
				
				});
				
				$("#"+"employeeId"+cnt).change(function(){
					
					var stringvar=this.id;
					
					
				getEmployeedetails(this.value,this.id,stringvar.substring(10,stringvar.length));

				
					
				});	
				$('#salaryRequest').delegate('.selectClass','change', function() {

					employeeArray.push($(this).val());
				});
			
				
				
				
			});

	$('#salaryRequest').delegate('.selectClass','change', function() {

		employeeArray.push($(this).val());
	});
	
	$('#requestId')
	.click(
			function() {
			
				
				var employeeCode =[];
				var projectCode = [];
				var salary = [];
				var description=[];
				var regex_double ='^[0-9]*\.[0-9]*$';
				var int_regex = /^\d+$/;
				var projectrefCode=[];
				$('#salaryRequest tr').each(function() {
							
					if($(this).find('.selectClass').val()!=undefined){
						
						
						employeeCode.push($(this).find('.selectClass').val());
						}
					
if($(this).find('.projectCodeClass').val()!=undefined){
						
						
	projectCode.push($(this).find('.projectCodeClass').val().trim());
						}
if($(this).find('.salaryClass').val()!=undefined){
	
	
	salary.push($(this).find('.salaryClass').val().trim());
						}
							
							

if($(this).find('.descriptionClass').val()!=undefined){
	
	
	description.push($(this).find('.descriptionClass').val().trim());
						}


	if($(this).find('.projectReferenceCodeClass').val()!=undefined){
		projectrefCode.push($(this).find('.projectReferenceCodeClass').val().trim());
	}			
			});		
				

				for (var i = 0; i < employeeCode.length; i++) {
				
					if(employeeCode[i]==null || employeeCode[i]==""){
						
				 		$("#errordiv").text("Select Employee");
						 $('.error-box').css({'visibility': 'visible'});
						return false;
					
					}
					
					
					
					
					
/*if(projectCode[i]==null || projectCode[i]==""){
						
				 		$("#errordiv").text("Select ProjectCode");
						 $('.error-box').css({'visibility': 'visible'});
						return false;
					
					}*/
					 if(projectrefCode[i]==null || projectrefCode[i]==""){
						$("#errordiv").text("Select Project Code");
						 $('.error-box').css({'visibility': 'visible'});
						return false;
						
					}
					
					
					else if(salary[i]=="" || salary[i]==null){
						
						$("#errordiv").text("Enter Salary");
						 $('.error-box').css({'visibility': 'visible'});
						return false;
					}
					
					
				else if(!((int_regex.test(salary[i])) || (salary[i].match(regex_double)))) {
						$("#errordiv").text("Salary should be Integer or Double ");
						$('.error-box').css({'visibility' : 'visible'});
						return false;
					}
				else if(description[i]=="" || description[i]==null){
					
					$("#errordiv").text("Enter Comment");
					 $('.error-box').css({'visibility': 'visible'});
					return false;
				}
					
					
					else
						{
					
						$('.error-box').css({'visibility' : 'hidden'});
						//$("#loading").show();
						/* $("#loading").css("display", "block");*/
						
	/*return true;*/
						
						/* document.getElementById("loading").style.display = "block"; */
						}	
						}
				var datalist = {
						"employeeCodes" : employeeCode.join(","),
						"projectCodes" : projectCode
								.join(","),
						"salary" : salary
								.join(","),
								"description":description.join(",").trim()
							
					};
		
		
$.ajax({
	
		type : "POST",
		url : "advancedSalaryRequest.do?parameter=saveAdvanceSalaryRequest",
		data :datalist,
	
		beforeSend:function(){
			$("#loading").show();
			$("#requestId").hide();
			
		},
		complete: function(){
			
		},
	
	
	success : function(response) {
		$("#loading").hide();
			var result = $.parseJSON(response);
			
			var status=result.status;	
			
window.location.href="managerMenu.do?parameter=advanceSalaryRequest&successMesage="+status;
			
				

		}
	});
	
			
				
			
	
});

});


function deletMethod(){
	
	$(this).parent().parent().remove();
}
function getEmployees(){
				
			  $.ajax({
					
					type:"POST",
					url:"managerMenu.do?parameter=advanceSalaryRequestEmployee",
					success:function(data){
				  
						var result=$.parseJSON(data);
												
						for(var j=0 ;j<result.employeeList.length;j++){
							
								$("#employeeIdCode").append(
									'<option value="'
									+ result.employeeList[j].empid
									+ '">'
									+ result.employeeList[j].empname
									+ '</option>');
							
						}
		for(var k=0 ;k < employeeArray.length; k++){
							
							$("#employeeIdCode"+" option").map(function() {
								
								
								if ($(this).val() == employeeArray[k]) {
									/*$(this).attr('disabled', true);*/
									$(this).remove();
								
								}
							});
						
					}
				
					
						
						
					}
				
				});
				
			}
		 
		 
		 function getProjectReferenceCode(getProjectReferenceCode){
	
			  $.ajax({
					
					type:"POST",
					url:"managerMenu.do?parameter=getProjectCodeReferenceByManager",
					success:function(data){
				  
						var result=$.parseJSON(data);
										
						for(var j=0 ;j<result.projectCodeReferenceList.length;j++){
							
								$(getProjectReferenceCode).append(
									'<option value="'
									+ result.projectCodeReferenceList[j].projectReferenceCode
									+ '">'
									+ result.projectCodeReferenceList[j].projectReferenceCode
									+ '</option>');
							
						}
						
					}
				
				});
				
			}

/*function HideStatus(){
	alert("dsfasfda");
	 $('#loading').show();
}
function ShowStatus(){
	
}*/