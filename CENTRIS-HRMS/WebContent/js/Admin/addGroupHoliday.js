var acadamicYear;
function getAcadamicYear(YearId){
	
	$.ajax({
		url:"holidayMaster.do?parameter=getAcadamicYear",
		async:false,
		data:{"yearid":YearId},
		success:function(data){
			var result =$.parseJSON(data);
			acadamicYear=result.acadamicyear;
		}
	});
	
	return acadamicYear;
}

var dataflag=false;
$(document)
		.ready(
				function() {
					var cnt = 0;
									
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

function validations(){
	
	var holidayyear=document.getElementById('holidayyear').value;
	var clientCode=document.getElementById('clientaddId').value;
	
	var yearString=getAcadamicYear(holidayyear);
	
	
   if(clientCode==""){
     $('.error-box').css({'visibility': 'visible'});
	 $("#errordiv").text("Select Client Name");
	 return false ;
   }
 
  if(holidayyear==""){
	    $('.error-box').css({'visibility': 'visible'});
		$("#errordiv").text("Select Year");
			
	 return false ;
    }

		
			
			var datanaseholidayList=null;
			$.ajax({
				url:"holidayMaster.do?parameter=getDistinctHolidayList",
				data:{"ClientCode":clientCode,"Year":holidayyear},
				async:false,
				success:function(data){
					var holidayList =$.parseJSON(data);
					datanaseholidayList=holidayList.jsonResponse;
					
				}
			});
			
		var dateArray=[];
		var holidayArray=[];
			
		   $('#parentRegSecond tr').each(function(){
			
			    var date =$(this).find('.groupDate').val();
			    if(date!=null){
			    	dateArray.push(date.trim());
				}
			    var holidayreason =  $(this).find('input[name=holiday]').val();
				 if(holidayreason!=null){
					  holidayArray.push(holidayreason.trim());
				}
			 });										

		
			 for (var k = 0; k < dateArray.length; k++) {
				
				
				 if(dateArray[k].trim()==""){
					 $('.error-box').css({'visibility': 'visible'});
						$("#errordiv").text("Please Select Date");
					 return false;	
							
				 }else if(dateArray[k].trim().indexOf(yearString)==-1){
					
					 $('.error-box').css({'visibility': 'visible'});
						$("#errordiv").text('Holiday date not match with selected Year:'+yearString);
				     return false;	 
				 }else if(holidayArray[k].trim()==""){
					
					 $('.error-box').css({'visibility': 'visible'});
					 $("#errordiv").text("Enter Reason for Holiday");
				
					 return false;	 
				}else{
	              							
					for(var i=0;i<datanaseholidayList.length;i++){
						
						
						if(process(datanaseholidayList[i].date)===process(dateArray[k].trim())){
							
							 $('.error-box').css({'visibility': 'visible'});
								$("#errordiv").text('Holiday Date '+dateArray[k].trim()+' already Exist');
							  return false;
					    	}
					 }
					
				}
				 
		}
			 

}

					