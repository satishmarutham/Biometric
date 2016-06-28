
$(document).ready(function(){

	$("#errordiv").hide();
	$("#date").datepicker({
		dateFormat : "dd-mm-yy",
		yearRange : 'c-65:c+65',
		maxDate:0,
		changeMonth : "true",
		changeYear : "true",
		numberOfMonths : 1,

	});
	getAllManagers();
	
	$("#edit").click(function(){
		document.location.href="employeeAllowances.do?method=getClaimedAllowanceDetails&selecteddate="+$("#date").val();
	});
	
	$("#viewmoreAllowances").click(function(){
		
		document.location.href="employeeAllowances.do?method=getViewMoreAllowances";
	
	});
	
	
	
var cnt=5;
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
				
				
				var bioid_input = document.createElement("input");
			
				bioid_input.name = "bioid";
				bioid_input.id = "bioid"+cnt;
				bioid_input.placeholder="Search Employee Name";
				bioid_input.setAttribute("class","BioIdClass");
				
				bioid_input.style.border="1px solid #90A9B7 ";
				bioid_input.style.fontSize="12px";
				bioid_input.style.padding="2px";
				bioid_input.style.width="98%";
				bioid_input.style.height="21px";
				bioid_input.style.borderRadius="4px";
				bioid_input.style.backgroundColor="#fff";
				
		
				
				var td2 = document.createElement("td");
				td2.appendChild(bioid_input);
				tr1.appendChild(td2);
				
				
				var empname_input = document.createElement("input");
				
				empname_input.type="text";
				empname_input.name = "empname";
				empname_input.id = "empname"+cnt;
				empname_input.readOnly="true";
				empname_input.setAttribute("class","EmpnameClass");
						
				empname_input.style.background="#C2C2C2";
				empname_input.style.border="1px solid #999999";
			
				empname_input.style.fontSize="12px";
				empname_input.style.padding="2px";
				empname_input.style.width="98%";
				empname_input.style.height="21px";
				
				var td3 = document.createElement("td");
				td3.appendChild(empname_input);
				tr1.appendChild(td3);
				
				
               var hdfcacno_input = document.createElement("input");
				
				hdfcacno_input.type="text";
				hdfcacno_input.name = "hdfcacno";
				hdfcacno_input.id = "hdfcacno"+cnt;
				hdfcacno_input.readOnly="true";
				hdfcacno_input.setAttribute("class","HdfcacnoClass");
						
				hdfcacno_input.style.background="#C2C2C2";
				hdfcacno_input.style.border="1px solid #999999";
			
				hdfcacno_input.style.fontSize="12px";
				hdfcacno_input.style.padding="2px";
				hdfcacno_input.style.width="98%";
				hdfcacno_input.style.height="21px";
				
				var td4 = document.createElement("td");
				td4.appendChild(hdfcacno_input);
				tr1.appendChild(td4);
				
				
                var amount_input = document.createElement("input");
				
                amount_input.type="text";
                amount_input.name = "amount";
                amount_input.id = "amount"+cnt;
                amount_input.setAttribute("class","AmountClass");
						
                amount_input.style.background="#fff";
                amount_input.style.border="1px solid #90A9B7";
			
                amount_input.style.fontSize="12px";
                amount_input.style.padding="2px";
                amount_input.style.width="98%";
                amount_input.style.height="21px";
				
				var td5 = document.createElement("td");
				td5.appendChild(amount_input);
				tr1.appendChild(td5);
				
					
				var noofdaymonthallowance_select = document.createElement("select");
			
				noofdaymonthallowance_select.name = "noofdayormonthallowance";
				noofdaymonthallowance_select.id = "noofdayormonthallowance"+cnt;
				noofdaymonthallowance_select.setAttribute("class","NoofdayormonthallowanceClass");
				
				noofdaymonthallowance_select.style.fontSize="12px";
				noofdaymonthallowance_select.style.padding="2px";
				noofdaymonthallowance_select.style.width="104%";
				noofdaymonthallowance_select.style.height="26px";
				
				var td6 = document.createElement("td");
				td6.appendChild(noofdaymonthallowance_select);
				tr1.appendChild(td6);
						
				
				var datype_select = document.createElement("select");
			
				datype_select.name = "datype";
				datype_select.id = "datype"+cnt;
				datype_select.setAttribute("class","DatypeClass");
				
				datype_select.style.fontSize="12px";
				datype_select.style.padding="2px";
				datype_select.style.width="104%";
				datype_select.style.height="26px";
				
				var td7 = document.createElement("td");
				td7.appendChild(datype_select);
				tr1.appendChild(td7);
						
				var singleteamgh_select = document.createElement("select");
				
				singleteamgh_select.name = "singleteamgh";
				singleteamgh_select.id = "singleteamgh"+cnt;
				singleteamgh_select.setAttribute("class","SingleteamghClass");
				
				singleteamgh_select.style.fontSize="12px";
				singleteamgh_select.style.padding="2px";
				singleteamgh_select.style.width="104%";
				singleteamgh_select.style.height="26px";
				
				var td8 = document.createElement("td");
				td8.appendChild(singleteamgh_select);
				tr1.appendChild(td8);
						
	           var projectmanager_select = document.createElement("select");
				
	           projectmanager_select.name = "projectmanager";
	           projectmanager_select.id = "projectmanager"+cnt;
	           projectmanager_select.setAttribute("class","ProjectmanagerClass");
				
	           projectmanager_select.style.border="1px solid #90A9B7 ";
	           projectmanager_select.style.fontSize="12px";
	           projectmanager_select.style.padding="2px";
	           projectmanager_select.style.width="104%";
	           projectmanager_select.style.height="25px";
	           projectmanager_select.style.borderRadius="4px";
	           projectmanager_select.style.backgroundColor="#fff";
				
				var td9 = document.createElement("td");
				td9.appendChild(projectmanager_select);
				tr1.appendChild(td9);
			
				var project_select= document.createElement("select");
				project_select.type = "text";
				project_select.name = "project";
				project_select.id = "project"+cnt;
				project_select.setAttribute("class","ProjectClass");
			
			
				project_select.style.border="1px solid  #90A9B7";
				project_select.style.background="#fff";
				project_select.style.fontSize="12px";
				project_select.style.padding="2px";
				project_select.style.width="104%";
				project_select.style.height="25px";
				
		    	var td10 = document.createElement("td");
				td10.appendChild(project_select);
				tr1.appendChild(td10);
				
				
				var client_select = document.createElement("select");
			
				client_select.type = "text";
				client_select.name = "client";
				client_select.id = "client"+cnt;
				client_select.setAttribute("class","CientClass");
			
				client_select.style.background="#fff";
				client_select.style.border="1px solid #90A9B7";
				
				client_select.style.fontSize="12px";
				client_select.style.padding="2px";
				client_select.style.width="104%";
				client_select.style.height="25px";
				
				var td11 = document.createElement("td");
				td11.appendChild(client_select);
				tr1.appendChild(td11);
				
				
				
				var teamlead_input = document.createElement("input");
				teamlead_input.type = "text";
				teamlead_input.name = "teamlead";
				teamlead_input.id = "teamlead"+cnt;
				teamlead_input.setAttribute("class","TeamleadClass");
			
				teamlead_input.style.background="#fff";
				teamlead_input.style.border="1px solid #90A9B7";
				
				teamlead_input.style.fontSize="12px";
				teamlead_input.style.padding="2px";
				teamlead_input.style.width="98%";
				teamlead_input.style.height="21px";
				
				var td12 = document.createElement("td");
				td12.appendChild(teamlead_input);
				tr1.appendChild(td12);
				
			var location_input = document.createElement("input");
			    location_input.type = "text";
			    location_input.name = "location";
			    location_input.id = "location"+cnt;
				location_input.setAttribute("class","LocationClass");
			
				location_input.style.background="#fff";
				location_input.style.border="1px solid #90A9B7";
				
				location_input.style.fontSize="12px";
				location_input.style.padding="2px";
				location_input.style.width="98%";
				location_input.style.height="21px";
				
				var td13 = document.createElement("td");
				td13.appendChild(location_input);
				tr1.appendChild(td13);
				
							
				var remarks_textarea = document.createElement("textarea");
				remarks_textarea.name = "remarks";
				remarks_textarea.id = "remarks"+cnt;
				remarks_textarea.setAttribute("class","RemarksClass");
				remarks_textarea.rows="2";
				remarks_textarea.cols="22";
				
				remarks_textarea.style.fontSize="12px";
				
				remarks_textarea.style.padding="2px";
				remarks_textarea.style.width="98%";
				remarks_textarea.style.height="40px";
				
				var td14 = document.createElement("td");
				td14.appendChild(remarks_textarea);
				tr1.appendChild(td14);
				
				
				var deleteimage_input = document.createElement("input");
				
				deleteimage_input.type = "image";
				deleteimage_input.name = "delete";
				deleteimage_input.id = "delete"+cnt;
				deleteimage_input.src="images/trash.gif";
								
				var td15 = document.createElement("td");
				td15.appendChild(deleteimage_input);
				tr1.appendChild(td15);
			 	
               var empid_hidden = document.createElement("input");
				
               empid_hidden.type = "hidden";
               empid_hidden.name = "empid";
               empid_hidden.id = "empid"+cnt;
               empid_hidden.setAttribute("class","EmpidClass");
				
				tr1.appendChild(empid_hidden);
					
				document.getElementById("EmployeeAllowances").appendChild(tr1);
						
			$("#"+check.id).text(""+cnt);
				
				$("#"+deleteimage_input.id).click(function(){
					
					deletMethod(this.id);
				
				});

				$("#"+noofdaymonthallowance_select.id).append(
						'<option value="'+ ""+ '">'+ "-----Select-----"	+ '</option>',
						'<option value="'+ "0"+ '">'+ "NA"	+ '</option>',
						'<option value="'+ "1"+ '">'+ "1"	+ '</option>',
						'<option value="'+ "2"+ '">'+ "2"	+ '</option>',
						'<option value="'+ "3"+ '">'+ "3"	+ '</option>',
						'<option value="'+ "4"+ '">'+ "4"	+ '</option>',
						'<option value="'+ "5"+ '">'+ "5"	+ '</option>',
						'<option value="'+ "6"+ '">'+ "6"	+ '</option>',
						'<option value="'+ "7"+ '">'+ "7"	+ '</option>',
						'<option value="'+ "30"+ '">'+ "MA"	+ '</option>');
							
				$("#"+datype_select.id).append(
						'<option value="'+ ""+ '">'+ "-----Select-----"	+ '</option>',
						'<option value="'+ "NA"+ '">'+ "NA"	+ '</option>',
						'<option value="'+ "Local"+ '">'+ "Local(Single/Team)"	+ '</option>',
						'<option value="'+ "Single"+ '">'+ "Single(Out Of Station)"	+ '</option>',
						'<option value="'+ "Team"+ '">'+ "Team(Out Of Station)"	+ '</option>',
						'<option value="'+ "GHNM"+ '">'+ "GH(Non Metro)"	+ '</option>',
						'<option value="'+ "GHM"+ '">'+ "GH(Metro)"	+ '</option>');
				$("#"+singleteamgh_select.id).append(
						'<option value="'+ ""+ '">'+ "-----Select-----"	+ '</option>',
						'<option value="'+ "NA"+ '">'+ "NA"	+ '</option>',
						'<option value="'+ "Single"+ '">'+ "Single"	+ '</option>',
						'<option value="'+ "Team"+ '">'+ "Team"	+ '</option>',
						'<option value="'+ "CE"+ '">'+ "CE 5Y/PMs"	+ '</option>');
				$("#"+projectmanager_select.id).append(
						'<option value="'
								+ ""
								+ '">'
								+ "-----Select-----"
								+ '</option>');
				$("#"+client_select.id).append(
						'<option value="'
								+ ""
								+ '">'
								+ "-----Select-----"
								+ '</option>');
				$("#"+project_select.id).append(
						'<option value="'
								+ ""
								+ '">'
								+ "-----Select-----"
								+ '</option>');
		      	getAllManagers();
				
				$("#"+ bioid_input.id).keyup(function(){
					
					getEmployeeDetails(this.id,this.value,bioid_input.id.substring(5,bioid_input.id.length));
				
				}); 
				
				$("#"+ projectmanager_select.id).change(function(){
				
					getProjects(projectmanager_select.id.substring(14, projectmanager_select.id.length));
				
				}); 
				$("#"+project_select.id).change(function(){
					
					getClient(this.value,project_select.id.substring(7, project_select.id.length));
				
				});
					
	});
	

	
	
});
var conflict_rows=[];
var seletedBioIds=[];
function deletMethod(deletebutton){
	$("#"+deletebutton).parent().parent().remove();
}


var exitflag=false;

function getEmployeeDetails(bioid,bioval,sno){
	
	var date=$("#date").val();
	var int_regex = /^\d+$/;	
	
	if(date==""){
		$("#errordiv").show();
		$("#errordiv").text("Select the Date");
		$("#date").addClass("ui-state-error");
		$(".error-box").css({"visibility":"visible"});
		return false;
	}else if(bioval.length >50){
		$("#errordiv").show();
		$("#errordiv").text("Employee Name Length Should be 50");
		$(".error-box").css({"visibility":"visible"});
		return false;
	}else{
		$("#errordiv").hide();
		$(".error-box").css({"visibility":"hidden"});
	
	if(bioval!=""){
		$("#"+bioid).autocomplete({
					source : function(request, response) {
							$.ajax({
									url : "employeeAllowances.do?method=getBioIdBySearch",
									dataType : "json",
									async : false,
									data : {
										featureClass : "P",
										style : "full",
										name_startsWith :bioval
									},
									success : function(data) {
										$("#messagediv").hide();
									
									if(data.response == ""){
										$("#errordiv").show();
						        		$("#errordiv").text("Enter Valid Employee Name");
						        		$(".error-box").css({"visibility":"visible"});
						        		exitflag=true;
						        		return false;
									}else{
									   exitflag=false;
									}
										response($.map(data.response,
														function(
																item) {
										
															return {
															
															
																label : item.bioidlabel,
																value : item.bioid,
															};
														}));

									
										
									}

								});
					},
					minLength : 1,
					select : function(event, ui) {
						exitflag=false;
						$("#errordiv").hide();
						var searchTerm = ui.item.value;
						$("#messagediv").hide();
				
						 $("#EmployeeAllowances tr").each(function(){
								
							   var bioId=$(this).find('.BioIdClass').val();
					
							    if(bioId!=undefined && bioId.split("-")[1]==searchTerm){
							     	$("#errordiv").show();
							 		$("#errordiv").text("You Already Claim Allowance for Selected Employee ");
									 $('.error-box').css({'visibility': 'visible'});
									 return false;
								}
						 });
				
						$.ajax({
							type : "POST",
							url : "employeeAllowances.do?method=getSerchTermDetails",
							data : {'BioId' : searchTerm,'selecteddate':date},
							async:false,
							success : function(data) {
													  
					          	var result= $.parseJSON(data);
					        
					          	$("#empid"+sno).val("");
					          	$("#empname"+sno).val("");
					            $("#client"+sno).val("");
					       		$("#teamlead"+sno).val("");
				        		$("#location"+sno).val("");
				        		$("#remarks"+sno).val("");
				        		$("#project"+sno).val("");
				        		$("#empname"+sno).parent().parent().css("background","#fff");
				        		
					 
					          	$('#projectmanager'+sno).empty();
					          	$("#projectmanager"+sno).append('<option value="' + ""
				        				+ '">' + "----Select----"
				        				+ '</option>');
					          
					     
					           	
					          	if(result.EmployeeList[0].empid==undefined){
					        		$("#errordiv").show();
					        		$("#errordiv").text("Employee Is not there,Please Try Again");
					        		$(".error-box").css({"visibility":"visible"});
					        		return false;
					        		
					        	}else if(result.EmployeeList[0].empid!=undefined && result.EmployeeList[0].projectmanagercode==undefined){
					        		$("#errordiv").show();
					        		$("#errordiv").text("Please Map the Employee to Any Manager");
					        		$(".error-box").css({"visibility":"visible"});
					        		
					        		$("#empid"+sno).val(result.EmployeeList[0].empid);
					        		$("#empname"+sno).val(result.EmployeeList[0].empname);
					        		return false;
					            }else if(result.EmployeeList[0].flag){
					            
					            	var answer=confirm("You already claim allowance to selected employee amount of "+result.EmployeeList[0].amount	);
					            	
					            	$("#empname"+sno).parent().parent().css("background","#D9D9D9");
					            	
					            	$("#empid"+sno).val(result.EmployeeList[0].empid);
					        		$("#empname"+sno).val(result.EmployeeList[0].empname);
					           	
					        		
					        		$("#hdfcacno"+sno).val(result.EmployeeList[0].hdfcacno);
					        		/*$("#amount"+sno).val(result.EmployeeList[0].amount);*/
					        	//	$("#noofdayormonthallowance"+sno+" option[value='"+result.EmployeeList[0].noofdayormonthallowance+"']").attr('selected', 'true');
					        	//	$("#datype"+sno+" option[value='"+result.EmployeeList[0].datype+"']").attr('selected', 'true');
					        	//	$("#singleteamgh"+sno+" option[value='"+result.EmployeeList[0].singleteamgh+"']").attr('selected', 'true');
					        		
					        
					              	getAllManagers();
					        		/*$("#projectmanager"+sno).append('<option value="' + result.EmployeeList[0].projectmanagercode
					        				+ '">' + result.EmployeeList[0].projectmanagername
					        				+ '</option>');*/
					        		$("#projectmanager"+sno+" option[value='"+result.EmployeeList[0].projectmanagercode+"']").attr('selected', 'true');
					        	
					        		getProjects(sno);
					        	       	 
					       	        		
					               $("#client"+sno+" option[value='"+result.EmployeeList[0].clientcode+"']").attr('selected','true');
					        	
					        		$("#teamlead"+sno).val(result.EmployeeList[0].teamlead);
					        		$("#location"+sno).val(result.EmployeeList[0].location);
					        		$("#remarks"+sno).val(result.EmployeeList[0].remarks);
					        			
					        		conflict_rows.push(searchTerm);
					        		$("#project"+sno).append('<option  selected="selected" value="' + result.EmployeeList[0].projectcode
					        				+ '">' + result.EmployeeList[0].project
					        				+ '</option>');
					        		return true;
					            	
					       					        		
					        		conflict_rows.push(searchTerm);
					        
					            	
					            }else if(!result.EmployeeList[0].flag && result.EmployeeList[0].amount!=undefined){
					            					            	
					            					           	        		
					            	var answer=confirm(" Manager "+result.EmployeeList[0].postedBy +" Already Claimed Allowance To \n"+ " Employee "+result.EmployeeList[0].empname+" with Amount of "+result.EmployeeList[0].amount+" .\n"
					            			+" If you want to save the row click OK, otherwise Delete the row"	);
					        		$("#empname"+sno).parent().parent().css("background","#D9D9D9");
					        		
					        		$("#empid"+sno).val(result.EmployeeList[0].empid);
					        		$("#empname"+sno).val(result.EmployeeList[0].empname);
					        		
					        		$("#hdfcacno"+sno).val(result.EmployeeList[0].hdfcacno);
					        	//	$("#amount"+sno).val(result.EmployeeList[0].amount);
					        	//	$("#noofdayormonthallowance"+sno+" option[value='"+result.EmployeeList[0].noofdayormonthallowance+"']").attr('selected', 'true');
					        	//	$("#datype"+sno+" option[value='"+result.EmployeeList[0].datype+"']").attr('selected', 'true');
					        	//	$("#singleteamgh"+sno+" option[value='"+result.EmployeeList[0].singleteamgh+"']").attr('selected', 'true');
					        		
					        
					              	getAllManagers();
					        		/*$("#projectmanager"+sno).append('<option value="' + result.EmployeeList[0].projectmanagercode
					        				+ '">' + result.EmployeeList[0].projectmanagername
					        				+ '</option>');*/
					        		$("#projectmanager"+sno+" option[value='"+result.EmployeeList[0].projectmanagercode+"']").attr('selected', 'true');
					        	
					        		getProjects(sno);
					        	       	 
					       	        		
					             $("#client"+sno+" option[value='"+result.EmployeeList[0].clientcode+"']").attr('selected','true');
					        	
					        		$("#teamlead"+sno).val(result.EmployeeList[0].teamlead);
					        		$("#location"+sno).val(result.EmployeeList[0].location);
					        		$("#remarks"+sno).val(result.EmployeeList[0].remarks);
					        			
					        		conflict_rows.push(searchTerm);
					        		$("#project"+sno).append('<option  selected="selected" value="' + result.EmployeeList[0].projectcode
					        				+ '">' + result.EmployeeList[0].project
					        				+ '</option>');
					        		return true;
					            	
					        	
					            }else if(result.EmployeeList[0].teamlead !=null && result.EmployeeList[0].location !=null){
					            	
					            	$("#empid"+sno).val(result.EmployeeList[0].empid);
					        		$("#empname"+sno).val(result.EmployeeList[0].empname);
					           		$("#hdfcacno"+sno).val(result.EmployeeList[0].hdfcacno);
					        	
					      		
					        	/*	$("#projectmanager"+sno).append('<option value="' + result.EmployeeList[0].projectmanagercode
					        				+ '">' + result.EmployeeList[0].projectmanagername
					        				+ '</option>');*/
					           	 	getAllManagers();
					        		$("#projectmanager"+sno+" option[value='"+result.EmployeeList[0].projectmanagercode+"']").attr('selected', 'true');
					        	
					        		getProjects(sno);
					        	       	 
					       	        		
					               $("#client"+sno+" option[value='"+result.EmployeeList[0].clientcode+"']").attr('selected','true');
					        	
					        		$("#teamlead"+sno).val(result.EmployeeList[0].teamlead);
					        		$("#location"+sno).val(result.EmployeeList[0].location);
					        		$("#remarks"+sno).val(result.EmployeeList[0].remarks);
					        			
					             
					        		$("#project"+sno).append('<option  selected="selected" value="' + result.EmployeeList[0].projectcode
					        				+ '">' + result.EmployeeList[0].project
					        				+ '</option>');
					        		return true;
					            	
					            	
					            	
					            }else{
					        
					        		$("#empid"+sno).val(result.EmployeeList[0].empid);
					        		$("#empname"+sno).val(result.EmployeeList[0].empname);
					        		$("#hdfcacno"+sno).val(result.EmployeeList[0].hdfcacno);
					        
					        		
					            	$("#projectmanager"+sno).append('<option value="' + result.EmployeeList[0].projectmanagercode
					        				+ '">' + result.EmployeeList[0].projectmanagername
					        				+ '</option>');
					            	
					            	return true;
					            }
								
							}
						});
					

						$("#"+bioid).val(ui.item.label);
						return false;
					},
				});
		
		
	}
}
	
}
function getProjects(sno){
		
			$.ajax({
			type : "POST",
			url : "employeeAllowances.do?method=getMappedProject",
			async:false,
			success : function(data) {
				var result= $.parseJSON(data);
				$("#project"+sno).html("");
				$("#project"+sno).append(
						'<option value="' + ""
								+ '">' + "-----Select-----"
								+ '</option>');
				for ( var i = 0; i < result.mappedprojectlist.length; i++) {
					$("#project"+sno).append(
							'<option value="' + result.mappedprojectlist[i].projectId
									+ '">' + result.mappedprojectlist[i].projectName
									+ '</option>');
				}
			}
		});
			$.ajax({
				type : "POST",
				url : "employeeAllowances.do?method=getAllClients",
				async:false,
				success : function(data) {
					$("#client"+sno).html("");
					$("#client"+sno).append(
							'<option value="' + ""
									+ '">' + "-----Select-----"
									+ '</option>');
					var result= $.parseJSON(data);
					for ( var i = 0; i < result.clientDetails.length; i++) {
						$("#client"+sno).append(
								'<option value="' + result.clientDetails[i].clientCode
										+ '">' + result.clientDetails[i].clientName
										+ '</option>');
					}
				}
			});
		
		
}

var duplicateflag=false;
function saveAllowances(){
	
	var date=$("#date").val();
	
	var bioidVal=[];
	var empidVal=[];
	var amountVal=[];
	var noofdaysormonthallowanceVal=[];
	var datypeVal=[];
	var singleteamghVal=[];
	var projectmanagerVal=[];
	var clientVal=[];
	var projectrefVal=[];
	var teamleadVal=[];
	var locationVal=[];
	var remarksVal=[];
	var projectcodeVal=[];

	
	var regex_double = '^[0-9]*\.[0-9]*$';
	var int_regex = /^\d+$/;
	var alphabet_regex="^[a-zA-Z ]+$";
	
	bioidVal.splice(0,bioidVal.length);
	amountVal.splice(0,empidVal.length);
	noofdaysormonthallowanceVal.splice(0,noofdaysormonthallowanceVal.length);
	datypeVal.splice(0,datypeVal.length);
	singleteamghVal.splice(0,singleteamghVal.length);
	projectmanagerVal.splice(0,projectmanagerVal.length);
	clientVal.splice(0,clientVal.length);
	projectrefVal.splice(0,projectrefVal.length);
	teamleadVal.splice(0,teamleadVal.length);
	locationVal.splice(0,locationVal.length);
	remarksVal.splice(0,remarksVal.length);
	projectcodeVal.splice(0,projectcodeVal.length);
	
	
   $("#EmployeeAllowances tr").each(function(){
		
		   var bioId=$(this).find('.BioIdClass').val();
				  
		    if(bioId!=undefined){
		    	bioidVal.push(bioId.split("-")[1]);
		    	
			}
		    
		   
		    var employeeId =$(this).find('.EmpidClass').val();
		
		    if(employeeId!=undefined){
			 
		    	empidVal.push(employeeId.trim());

	    	 }
		  
		   var amount =$(this).find('.AmountClass').val();
	
		   if(amount!=undefined){
     
			   amountVal.push(amount.trim());
  			
		   }
		
		   var noofdaysormonthallowance =$(this).find('.NoofdayormonthallowanceClass').val();

           if(noofdaysormonthallowance!=undefined){
			 
        	   noofdaysormonthallowanceVal.push(noofdaysormonthallowance.trim());
		      }
     
            var datype =$(this).find('.DatypeClass').val();
  
            if(datype!=undefined){
     	            	
    	     datypeVal.push(datype.trim());
     	            	
		     }
     
       
            var singleteamgh =$(this).find('.SingleteamghClass').val();
            
            if(singleteamgh!=undefined){
     	            	
            	singleteamghVal.push(singleteamgh.trim());
     	      }
     
            var projectmanager =$(this).find('.ProjectmanagerClass').val();
            
            if(projectmanager!=undefined){
     	            	
            	projectmanagerVal.push(projectmanager.trim());
     	      }
            
              
           
            var projectrefcode =$(this).find('.ProjectClass option:selected').text();
            
            
            if(projectrefcode!=""){
     	            	
            	projectrefVal.push(projectrefcode.trim());
     	      }
        
           
            var projectcode =$(this).find('.ProjectClass option:selected').val();
          
            if(projectcode!=undefined){
	            	
            	projectcodeVal.push(projectcode.trim());
     	      }
            
            
            
            var client =$(this).find('.CientClass').val();
            
            if(client!=undefined){
     	            	
            	clientVal.push(client.trim());
     	      }
            var teamlead =$(this).find('.TeamleadClass').val();
            
            if(teamlead!=undefined){
     	            	
            	teamleadVal.push(teamlead.trim());
     	      }
            
            var location =$(this).find('.LocationClass').val();
            
            if(location!=undefined){
     	            	
            	locationVal.push(location.trim());
     	      }
       
            
            var remarks =$(this).find('.RemarksClass').val();
     
           if(remarks!=undefined){
        		
        	   if(remarks.trim()==""){
		    		
        			remarksVal.push("null");
		    		
		    	}else{
		    		remarksVal.push(remarks.trim());
		    
		    	}
        	 
		 }
		
				
	});
   
   var biosortArray=[];
   
   for(var i=0;i<bioidVal.length;i++){
	   
	   biosortArray.push(bioidVal[i]);
   }
   
	var sortbiovalarr=biosortArray.sort();
	  for (var j = 0; j < biosortArray.length-1; j++) {
		
		 if(biosortArray[j]!="" && sortbiovalarr[j + 1] ){
		  if (sortbiovalarr[j + 1] == biosortArray[j]) {
		    	$("#errordiv").show();
		 		$("#errordiv").text("You Already Claim Allowance for Selected Employee ");
				 $('.error-box').css({'visibility': 'visible'});
				return false;
		    }
		  }
		  
		}
	  
	  
	  
      for (var i = 0; i < bioidVal.length; i++) {
    	  
    
    	  
  		if(date==null || date==""){
			$("#errordiv").show();
	 		$("#errordiv").text("Select the Date");
			 $('.error-box').css({'visibility': 'visible'});
			return false;
		}else  if(bioidVal[i]=="" || bioidVal[i]==undefined){
			$("#errordiv").show();
       	     $("#errordiv").text("Employee Name should not be Empty");
			 $('.error-box').css({'visibility': 'visible'});
			 return false;
		}else if(exitflag){
			$("#errordiv").show();
    		$("#errordiv").text("Enter Valid Employee Name");
    		$(".error-box").css({"visibility":"visible"});
    	return false;
		}else if(empidVal[i]==""){
			$("#errordiv").show();
			 $("#errordiv").text("You Already Claimed Allowance for Selected Employee "+bioidVal[i]);
			 $('.error-box').css({'visibility': 'visible'});
			 return false;
		}else if(amountVal[i]==""){
			$("#errordiv").show();
			 $("#errordiv").text("Amount should not be Empty of Employee "+bioidVal[i]);
			 $('.error-box').css({'visibility': 'visible'});
			 return false;
		}else if (!((int_regex.test(amountVal[i])) || (amountVal[i].match(regex_double)))) {
			$('.error-box').css({'visibility' : 'visible'});
			$("#errordiv").text("Amount should be Integer or Double of Employee "+bioidVal[i]);
		   return false;
		}else if(noofdaysormonthallowanceVal[i]==""){
			$("#errordiv").show();
			 $("#errordiv").text("Noof Days/Month Allowance should not be Empty of Employee "+bioidVal[i]);
			 $('.error-box').css({'visibility': 'visible'});
			 return false;
		}else if(datypeVal[i]==""){
			$("#errordiv").show();
			 $("#errordiv").text("DA Type should not be Empty of Employee "+bioidVal[i]);
			 $('.error-box').css({'visibility': 'visible'});
			 return false;
		}else if(singleteamghVal[i]==""){
			$("#errordiv").show();
			 $("#errordiv").text("Single/Team/GH should not be Empty of Employee "+bioidVal[i]);
			 $('.error-box').css({'visibility': 'visible'});
			 return false;
		}else if(projectmanagerVal[i]==""){
			$("#errordiv").show();
			 $("#errordiv").text("Project Manager should not be Empty map the Employee to Manager of Employee "+bioidVal[i]);
			 $('.error-box').css({'visibility': 'visible'});
			 return false;
		}else if(projectcodeVal[i]==""){
			$("#errordiv").show();
			 $("#errordiv").text("Project Should not be Empty map the any Project to Manager of Employee "+bioidVal[i]);
			 $('.error-box').css({'visibility': 'visible'});
			 return false;
		}else if(clientVal[i]==""){
			$("#errordiv").show();
			 $("#errordiv").text("Client should not be Empty of Employee "+bioidVal[i]);
			 $('.error-box').css({'visibility': 'visible'});
			 return false;
		}else if(teamleadVal[i]==""){
			$("#errordiv").show();
			 $("#errordiv").text("Team Lead Should not be Empty of Employee "+bioidVal[i]);
			 $('.error-box').css({'visibility': 'visible'});
			 return false;
		}else if(!teamleadVal[i].match(alphabet_regex)){
			$("#errordiv").show();
			 $("#errordiv").text("Team Lead Should be alphabet and allow space of Employee "+bioidVal[i]);
			 $('.error-box').css({'visibility': 'visible'});
			 return false;
		}else if(teamleadVal[i].length > 50){
			$("#errordiv").show();
			 $("#errordiv").text("Team Lead Length Should  be 50 of Employee "+bioidVal[i]);
			 $('.error-box').css({'visibility': 'visible'});
			 return false;
		}else if(locationVal[i]==""){
			$("#errordiv").show();
			 $("#errordiv").text("Location Should not be Empty of Employee "+bioidVal[i]);
			 $('.error-box').css({'visibility': 'visible'});
			 return false;
		}else if(!locationVal[i].match(alphabet_regex)){
			$("#errordiv").show();
			 $("#errordiv").text("Location Should be alphabet and allow space of Employee "+bioidVal[i]);
			 $('.error-box').css({'visibility': 'visible'});
			 return false;
		}else if(locationVal[i].length  > 30){
			$("#errordiv").show();
			 $("#errordiv").text("Location Length Should  be 30 of Employee "+bioidVal[i]);
			 $('.error-box').css({'visibility': 'visible'});
			 return false;
		}/*else if(remarksVal[i] == ""){
			$("#errordiv").show();
			 $("#errordiv").text("Remarks Should not be Empty");
			 $('.error-box').css({'visibility': 'visible'});
			 return false;
		}*/else if(remarksVal[i]!="" && remarksVal[i].length>100){
			$("#errordiv").show();
			 $("#errordiv").text("Remarks Length Should be 100 of Employee "+bioidVal[i]);
			 $('.error-box').css({'visibility': 'visible'});
			 return false;
		}else{
			$("#errordiv").hide();
			$('.error-box').css({'visibility' : 'hidden'});
			
		   }
		
	}
      
      if(bioidVal.length==0){
    		$("#errordiv").show();
			 $("#errordiv").text("Please Claim the Allowance at least one Employee");
			 $('.error-box').css({'visibility': 'visible'});
			 return false;
      }else{
    	  
        $("#errordiv").hide();
		$('.error-box').css({'visibility' : 'hidden'});
  	   $.ajax({
		type : "POST",
		url : "employeeAllowances.do?method=saveAllowances",
		data : {
			
			"selectdate" : date,
			"BioId" : bioidVal.join(","),
			"EmployeeId" : empidVal.join(","),
			"Amount" : amountVal.join(","),
			"noofdaysormonthallowance" : noofdaysormonthallowanceVal.join(","),
			"datype" : datypeVal.join(","),
			"singleteamgh" : singleteamghVal.join(","),
			"projectmanager" : projectmanagerVal.join(","),
			"clientVal" : clientVal.join(","),
			"projectrefcode" : projectrefVal.join(","),
			"teamlead" : teamleadVal.join(","),
			"location" : locationVal.join(","),
			"remarksVal" : remarksVal.join("|"),
			"conflict_rows" : conflict_rows.join(","),
			"teamlead" : teamleadVal.join(","),
			"projectcode":projectcodeVal.join(",")
			
		},
		  beforeSend: function() {
	  
			  $('#loader').show();
			  $('#saveallowances').hide();
			  
		    },
		//async:false,
		success : function(data) {
			var result = $.parseJSON(data);
			
			window.location.href="employeeAllowances.do?method=employeeDailyAllowanceHome&status="+result.status;
			 $('#saveallowances').show();
		}
  	});
  	   
      }
        
} 
function getAlreadyClaimedCount(selecteddate){
	
	$("#errordiv").hide();
	$(".error-box").css({"visibility":"hidden"});
	
	$('#EmployeeAllowances  input[type="text"]').val('');
	$('#EmployeeAllowances  select').prop('selectedIndex',0);
	$('#EmployeeAllowances  textarea').val('');
    $("#EmployeeAllowances tr").css("background","#fff");
	$.ajax({
		type : "POST",
		url : "employeeAllowances.do?method=getAlreadyClaimedCount",
		data : {"selecteddate":selecteddate},
		async:false,
		success : function(data) {
			var result = $.parseJSON(data);
			
			if(result.count > 0){
				
				var answer=confirm("You Already  Claimed Allowances \n"+" To "+result.count+" Employees " +"for Selected Date\n"
						+"\n"+"If You Want to See the Details click OK and See the View");
				if(answer){
				
					$("#edit").show();
					
				}
			}else{
				
				$("#edit").hide();
			}
		}
	});
}


function getAllManagers(){
	
	$.ajax({
		type : "POST",
		url : "projectManagerMapping.do?parameter=getManager",
		async:false,
		success : function(response) {
			
			var result = $.parseJSON(response);

			var manager = $(".ProjectmanagerClass");

			for ( var j = 0; j < result.managerList.length; j++) {

				$(manager).append(
						'<option value="' + result.managerList[j].managerId + '">'
								+ result.managerList[j].managerName + '</option>');
			}
		}
	});	
	
	
}

