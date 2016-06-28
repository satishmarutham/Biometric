$(document)
		.ready(
				function() {
					var cnt = 0;
				
					$("#CreateHolidayList")
					.click(
							function() {
								//alert("create holiday");
								var holidayyear=document.getElementById('holidayyear').value;
								var department=document.getElementById('department').value;
								
								 if(department==""){
									 
									 $('.error-box').css({'visibility': 'visible'});
										$("#errordiv").text("Select Department");
										 return false ;
									   }
								 else if(holidayyear==""){
									 
									 $('.error-box').css({'visibility': 'visible'});
										$("#errordiv").text("Select Year");
										
										 return false ;
									   }else {
							
								var dateArray=[];
								var errorCount=0;
								var datanaseholidayList=null;
								$.ajax({
									url:"holidayMaster.do?parameter=getDistinctHolidayList",
									async:false,
									success:function(data){
										var holidayList =$.parseJSON(data);
										datanaseholidayList=holidayList.jsonResponse;
										//alert(JSON.stringify(datanaseholidayList));
									}
								});
								
								 
								 $('#parentRegSecond tr').each(function(){
									var date= $(this).find('.groupDate').val();
									var holiday= $(this).find('input[name=holiday]').val();
									
									if(dateArray.length!=0 &&  dateArray.join().indexOf(date.trim())!=-1){
										
										 $('.error-box').css({'visibility': 'visible'});
											$("#errordiv").text("Holiday date should be Unique");
										errorCount++;
										
										return false;
									
									}
								
									else if(holiday.trim()==""){
										 $('.error-box').css({'visibility': 'visible'});
											$("#errordiv").text("Enter reason for Holiday");
										errorCount++;
										return false;
									}
									
									else if(date.trim()==""){
										 $('.error-box').css({'visibility': 'visible'});
											$("#errordiv").text("Select Date");
										errorCount++;
										return false;
									}
									else if(date.trim().indexOf(holidayyear)==-1){
										
										 $('.error-box').css({'visibility': 'visible'});
											$("#errordiv").text('Holiday Date not match with Selected Year:'+holidayyear);
										errorCount++;
										return false;
									}
									else{
										
										var date1 = new Date(date);
										
										
										for(var i=0;i<datanaseholidayList.length;i++){
											
											
											if(process(datanaseholidayList[i].date)===process(date) && datanaseholidayList[i].depId==department){
												
												 $('.error-box').css({'visibility': 'visible'});
													$("#errordiv").text('Holiday date '+date1+' Already Exist');
												errorCount++;
												return false;
											}else{
												
												return true;
											}
										}
										
																											}
									});
									   }
								if(errorCount>0){
									 return false;
								 }
								 else{
									 return true;
								 }
							});
					$("#Add")
					.click(
							function() {

								cnt++;
								var tr1 = document.createElement("tr");
								var td1 = document.createElement("td");
								var check = document
										.createElement("input");
								check.type = "checkbox";
								check.id = "chk" + cnt;
								check.name = "selectcheckbox";
								td1.appendChild(check);
								tr1.appendChild(td1);


								
								
								var td2 = document.createElement("td");
								var selectElement = document
								.createElement("input");
								selectElement.name ="date";
								selectElement.setAttribute('class','groupDate');
								selectElement.placeholder = " Click here";
								var option = new Option("--select--","");
								selectElement.style.fontSize="12px";
								selectElement.style.padding="2px";
								selectElement.style.width="157px"; 
								selectElement.style.height="21px"; 
								td2.appendChild(selectElement);
								tr1.appendChild(td2);

								var studclassidval = "datepicker"
										+ cnt;
								var selectElementsecond = document
								.createElement("input");
								selectElementsecond.name = "weekday";
								selectElementsecond.id = "alternate"+cnt
										;
								selectElementsecond.style.fontSize="12px";
								selectElementsecond.style.padding="2px";
								selectElementsecond.style.width="157px";
								selectElementsecond.style.height="21px";
								selectElementsecond.readOnly=true;
								var td3 = document.createElement("td");
								td3.appendChild(selectElementsecond);
                                tr1.appendChild(td3);
								var studsectionidval = "alternate"
										+ cnt;
								var selectElementthird = document
								.createElement("input");
								selectElementthird.name = "holiday"
										;
								selectElementthird.id = "holiday"+cnt
										;
								selectElementthird.style.fontSize="12px";
								selectElementthird.style.padding="2px";
								selectElementthird.style.width="157px";
								selectElementthird.style.height="21px";
								var td4 = document.createElement("td");
								td4.appendChild(selectElementthird);
								tr1.appendChild(td4);
								var studsubidval = "holiday" + cnt;
								document.getElementById(
										"parentRegSecond").appendChild(
										tr1);
								/** ** */
								
								var studclassid ="#"+studclassidval;
                                var alternateval="#"+studsectionidval;
								$(studclassid).datepicker({
									dateFormat : "yy-mm-dd",
									yearRange : 'c-65:c+65',
								/*	minDate : 1,*/
									changeMonth : "true",
									changeYear : "true",
									numberOfMonths : 1,
								});
								
							});
					
					
					var weekday=new Array(7);
					
					weekday[0]="Monday";
					weekday[1]="Tuesday";
					weekday[2]="Wednesday";
					weekday[3]="Thursday";
					weekday[4]="Friday";
					weekday[5]="Saturday";
					weekday[6]="Sunday";
					
					  $('#parentRegSecond').on("focus",".groupDate", function(){
						    $(this).datepicker({
						    	dateFormat : "dd-mm-yy",
								yearRange : 'c-65:c+65',
								changeMonth : "true",
								changeYear : "true",
								numberOfMonths : 1,
								onSelect: function(dateText, inst) { 
									var $this=$(this);
							        var date = $(this).datepicker('getDate');
							            day  = date.getUTCDay();
							            $this.parent('td').next('td').find('input[name=weekday]').val(weekday[day]);
							         
							    }
							});
						});
					
				
			
						$("#chk")
						.click(
								function() {

									var selectall = document
											.getElementsByName("selectall");
									var checkboxArray = document
											.getElementsByName('selectcheckbox');
									if (selectall[0].checked == true) {
										for ( var i = 0; i < checkboxArray.length; i++) {
											checkboxArray[i].checked = true;

										}
									} else {
										for ( var i = 0; i < checkboxArray.length; i++) {
											checkboxArray[i].checked = false;
										}
									}
								});

				$("#RemoveHoliday")
						.click(
								function() {

									var allRows = document.getElementById(
											'parentRegSecond')
											.getElementsByTagName('tr');

									var root = allRows[2].parentNode;

									var allInp = root
											.getElementsByTagName('input');

									for ( var i = allInp.length - 1; i >= 0; i--) {
										if ((allInp[i].getAttribute('type') == 'checkbox')
												&& (allInp[i].checked)) {
											root
													.removeChild(allInp[i].parentNode.parentNode);
										}
									}

								});

						
				});


function goBack(){
	
	window.location="holidayMaster.do?parameter=getDetails";
}

function process(date){
	   var parts = date.split("-");
	   var date = new Date(parts[1] + "-" + parts[0] + "-" + parts[2]);
	   return date.getTime();
	}
					