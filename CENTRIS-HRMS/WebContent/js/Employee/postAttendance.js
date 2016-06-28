/*function getTimeDifference(actualinTime,actualOutTime) {
	
	var in_hh = 0;
	var in_mm = 0;
	var in_ss = 0;
	var in_timeArray = actualinTime.split(":");
	in_hh =  parseInt(in_timeArray[0]);
	in_mm =  parseInt(in_timeArray[1]);
	in_ss =  parseInt(in_timeArray[2]);
	
	
	var cal_Overtime = "";
	var hh = 0;
	var mm = 0;
	var ss = 0;


				// var checked= $(this).attr('checked');
				var overtime = $(this).parents('tr:first').find('td.overtime')
						.text().trim();
				var timeArray = overtime.split(":");
				hh = hh + parseInt(timeArray[0]);
				mm = mm + parseInt(timeArray[1]);
				ss = ss + parseInt(timeArray[2]);
				if (ss > 60) {
					mm = mm + 1;
					ss = ss % 60;
				}
				if (mm > 60) {
					hh = hh + 1;
					mm = mm % 60;
				}

			

	hh = hh.length < 0 ? "0" + hh : hh;
	mm = mm.length < 0 ? "0" + mm : mm;
	ss = ss.length < 0 ? "0" + ss : ss;
	cal_Overtime = hh + ":" + mm + ":" + ss;
	document.getElementById("countOverTime").value = cal_Overtime;
}*/

function confirmMessage(message){
	var r = confirm(message);
	return r;
}

function validate() {
		var attendanceDateArray=[];
		var inTimeArray=[];
		var outTimeArray=[];
		var totalTimeArray=[];
		//var locationArray=[];
		var managerCodeArray=[];
		var projectCodeArray=[];
		var attendanceStatusArray=[];
		var attendanceTypeArray=[];
		var descriptionArray=[];
		var rowCount=1;
		var statusboolean=true;
		
		var count=0;
		
		$('table.view tr:gt(0)').each(function() {
			var date = $(this).find('[class=dateVal]').text().trim();
			var intime = $(this).find('[name=intimeVal]').val().trim();
			var outtime = $(this).find('[name=outtimeVal]').val().trim();
			var totaltime = $(this).find('[name=totaltimeVal]').val().trim();
			/*var location = $(this).find('[name=locationVal]').val().trim();*/
			var description=$(this).find('[name=description]').val().trim();
			
			var manager = $(this).find('.managerVal option:selected').val();
			var project=$(this).find('.projectVal option:selected').val();
			var status =$(this).find('.statusVal option:selected').val();
			var statustype = $(this).find('.statusTypeVal option:selected').val();
					
	
	if(rowCount==1){
			
			if (status != undefined && status != '') {
				attendanceStatusArray.push(status);
			}
			else{
				statusboolean=confirmMessage("Status is not Selected for row "+rowCount+" \n press ok - Dont save this row and below.\n press cancel - To edit this row ");
				count++;
				return false;
			}
			
			if (statustype != undefined && statustype != '') {
				attendanceTypeArray.push(statustype);
			}
			else{
				statusboolean=confirmMessage("Attendance Type is not Selected for row "+rowCount+" \n press ok - Dont save this row and below.\n press cancel - To edit this row ");
				count++;
				return false;
			}
			
			
			if(status=="Present"){
				
				if (intime != undefined && intime != '00:00:00') {
					inTimeArray.push(intime);
				}
				else{
					statusboolean=confirmMessage("In time is not filled properly for row "+rowCount+" \n press ok - Dont save this row and below.\n press cancel - To edit this row ");
					count++;
					return false;
				}
				
		   }else{
					
					inTimeArray.push(intime);
					
		      }
				
				
				
		 if(status=="Present"){	
				
				if (outtime != undefined && outtime != '00:00:00') {
					outTimeArray.push(outtime);
				}
				else{
					statusboolean=confirmMessage("Out time is not filled properly for row "+rowCount+" \n press ok - Dont save this row and below.\n press cancel - To edit this row ");
					count++;
					return false;
				}
		
		 }else{		
				
			    outTimeArray.push(outtime);
		}
				
		
		
		
		if(status=="Present"){	
			
			if (totaltime != undefined && totaltime != '00:00:00') {
				totalTimeArray.push(totaltime);
			}
			
		}else{
			
			
			   totalTimeArray.push(totaltime);
		}
		
		
		if (manager != undefined && manager != '') {
			managerCodeArray.push(manager);
		}
		else{
			statusboolean=confirmMessage("Project Manager is not Selected for row "+rowCount+" \n press ok -  Dont save this row and below.\n press cancel - To edit this row ");
			count++;
			return false;
		}
	
				
			
		if(status=="Present"){	
			
		
				if (project != undefined && project != '') {
					projectCodeArray.push(project);
				}
				else{
					statusboolean=confirmMessage("Cliient is not Selected for row "+rowCount+" \n press ok -  Dont save this row and below.\n press cancel - To edit this row ");
					count++;
					return false;
				}
				
		}else{
			
			projectCodeArray.push(project);
			
		}
		
		
		
		
	/*	if(status=="Present"){	
			
			if (location != undefined && location != '') {
				locationArray.push(location);
			}else{
				statusboolean=confirmMessage("Location is not filled for row "+rowCount+" \n press ok - Dont save this row and below.\n press cancel - To edit this row ");
				count++;
				return false;
			}
			
		}else{
		
		
			locationArray.push(location);
		}*/
		
		
		
				
		if(status=="Present"){	
			

			if (description != undefined && description != '') {
				descriptionArray.push(description);
			}
			else{
				statusboolean=confirmMessage("Description is not filled for row "+rowCount+" \n press ok - Dont save this row and below.\n press cancel - To edit this row ");
				count++;
				return false;
			}
			
			
		}else{
			
				descriptionArray.push(description);
		}	
				
			if (date != undefined && date != '') {
					attendanceDateArray.push(date);
				}
				
	
	
}else{
		
		if(status != undefined && status != ''){
	     
			attendanceStatusArray.push(status);
			if (statustype != undefined && statustype != '') {
				attendanceTypeArray.push(statustype);
			}
			else{
				statusboolean=confirmMessage("Attendance Type is not Selected for row "+rowCount+" \n press ok - Dont save this row and below.\n press cancel - To edit this row ");
				count++;
				return false;
			}
			
			
		if(status=="Present"){
			
			if (intime != undefined && intime != '00:00:00') {
				inTimeArray.push(intime);
			}
			else{
				statusboolean=confirmMessage("In time is not filled properly for row "+rowCount+" \n press ok - Dont save this row and below.\n press cancel - To edit this row ");
				count++;
				return false;
			}
			
	     }else{
				inTimeArray.push(intime);
				
	      }
			
			
			
	    if(status=="Present"){	
			
			if (outtime != undefined && outtime != '00:00:00') {
				outTimeArray.push(outtime);
			}
			else{
				statusboolean=confirmMessage("Out time is not filled properly for row "+rowCount+" \n press ok - Dont save this row and below.\n press cancel - To edit this row ");
				count++;
				return false;
			}
	
	    }else{		
		    outTimeArray.push(outtime);
	    }
			
	
	   if(status=="Present"){	
		
		if (totaltime != undefined && totaltime != '00:00:00') {
			totalTimeArray.push(totaltime);
		}
		
	   }else{
		   totalTimeArray.push(totaltime);
	   }
	
	
		if (manager != undefined && manager != '') {
			managerCodeArray.push(manager);
		}
		else{
			statusboolean=confirmMessage("Project Manager is not Selected for row "+rowCount+" \n press ok -  Dont save this row and below.\n press cancel - To edit this row ");
			count++;
			return false;
		}
	
			
		
	if(status=="Present"){	
		
	
			if (project != undefined && project != '') {
				projectCodeArray.push(project);
			}
			else{
				statusboolean=confirmMessage("Client is not Selected for row "+rowCount+" \n press ok -  Dont save this row and below.\n press cancel - To edit this row ");
				count++;
				return false;
			}
			
	}else{
		
		projectCodeArray.push(project);
		
	}
	
	
	
	
/*	if(status=="Present"){	
		
		if (location != undefined && location != '') {
			locationArray.push(location);
		}else{
			statusboolean=confirmMessage("Location is not filled for row "+rowCount+" \n press ok - Dont save this row and below.\n press cancel - To edit this row ");
			count++;
			return false;
		}
		
	}else{
	
	
		locationArray.push(location);
	}*/
	
	
	
			
	if(status=="Present"){	
		

		if (description != undefined && description != '') {
			descriptionArray.push(description);
		}
		else{
			statusboolean=confirmMessage("Description is not filled for row "+rowCount+" \n press ok - Dont save this row and below.\n press cancel - To edit this row ");
			count++;
			return false;
		}
		
		
	}else{
		
			descriptionArray.push(description);
	}	
			
			
	
	
			if (date != undefined && date != '') {
				attendanceDateArray.push(date);
			}
			
		}
	}
		

			
			if(intime>outtime){
				statusboolean=false;
				$('.error-box').css({'visibility': 'visible'});
				$('.error-box').text("In Time should be less than Out Time");
				count++;
				return false;
			}
			
			
		
			
			rowCount++;
			
	});
		
		if(count>0){
			
			return false;
		}else{		
		
	      if(statusboolean && attendanceDateArray.length>0){
		
			var jsonObject={'attendanceDate': attendanceDateArray,
					'inTime': inTimeArray,
					'outTime': outTimeArray,
					'totalTime': totalTimeArray,
					/*'location': locationArray,*/
					'managerCode': managerCodeArray,
					'projectCode':projectCodeArray,
					'attendanceStatus':attendanceStatusArray,
					'description':descriptionArray,
					'attendanceType': attendanceTypeArray
					};
		
			$.ajax({
				url:'employeeAttendanceposting.do?parameter=updateAttendanceDetails',
				data:jsonObject,
				beforeSend: function(){
					$('#loader').show();
				},
				success:function(response){
					var status=$.parseJSON(response);
					$('#loader').hide();
					window.location.href="employeeMenu.do?parameter=postattendance&message="+status.message;
					//location.reload();
				}
			});
			
	   }
		
		
		}
	      
		return false;

}

$(document).ready(function(){
	
	/*var projectDetails = callAjax("projectManagerMapping.do?parameter=getMappedProject",{'ManagerVal':managerId});
	var object=$(this).parent().next().find('.projectVal');
	createSelectBox(object, projectDetails.mappedprojectlist) ;

	$('.managerVal').change(function(){
		
	});*/
	
$(".inTimeClass,.outTimeClass").datetimepicker({
	pickDate : false,
	 onSelect: function (date) {
		 getTime($(this));
	    },
	    onChange: function (date) {
			 getTime($(this));
		    },
});
var row;
$('.input-append img').click(function(){
	row= $(this);
});

$('.table-condensed td').click(function(){
	var rowDetails= row.parents('tr:first');
	setTimeout(function(){getTime(rowDetails);},100);
});


});

function checkTime(ftime,ttime) {

var flag= true;

if(ftime==0){
	$(".alertMessage").text("please select the inTime");
 }else if(ttime==0){
	 $(".alertMessage").text("please select the OutTime");
}else{

var ftimeSplitHour = ftime.split(':')[0];
var ftimeSplitMin = ftime.split(':')[1];
var ftimeSplitSec = ftime.split(':')[2];

var ttimeSplitHour = ttime.split(':')[0];
var ttimeSplitMin = ttime.split(':')[1];
var ttimeSplitSec = ttime.split(':')[2];

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
	$(".alertMessage").text("The Out Time Should Not less than In Time");
	 document.getElementById("outtime").value = "";
	 flag=false;
}
if (ttimeSplitHour == ftimeSplitHour) {
	if (ftimeSplitMin > ttimeSplitMin) {
		$(".alertMessage").text("The Out Time Should Not less than In Time");
		document.getElementById("outtime").value = "";
		flag=false;
	}
	if (ftimeSplitMin == ttimeSplitMin) {
		if (ftimeSplitSec >= ttimeSplitSec) {
			$(".alertMessage").text("The Out Time Should Not less than In Time");
			document.getElementById("outtime").value = "";
			flag=false;
		}
	}
}
}
return flag;
}

function getTime(rowObject) {
	
   function toSeconds(time_str) {
	    var parts = time_str.split(':');
	    return parts[0] * 3600 + // an hour has 3600 seconds
	    parts[1] * 60 + // a minute has 60 seconds
	    +
	    parts[2]; // seconds
	}
   	var inTime = rowObject.find('.inTimeClass').find('#intime').val();
	var outTime = rowObject.find('.outTimeClass').find('#outtime').val();
	var difference = Math.abs(toSeconds(inTime) - toSeconds(outTime));
    
	var result = [
	    Math.floor(difference / 3600), // an hour has 3600 seconds
	    Math.floor((difference % 3600) / 60), // a minute has 60 seconds
	    difference % 60
	];
	result = result.map(function(v) {
	    return v < 10 ? '0' + v : v;
	}).join(':');

	rowObject.find('input[name=totaltimeVal]').val(result);
	

}

function goback(){
	
	document.location.href="employeeMenu.do?parameter=home";
	
}
