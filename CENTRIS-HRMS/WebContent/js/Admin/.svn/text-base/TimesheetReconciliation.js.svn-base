$(document).ready(function(){
	
	
	var hdepId=$("#hdepId").val();
	
	if(hdepId!=null && hdepId!=undefined){
		
		var deptIdArray=hdepId.split(",");
		var empIdArray=$("#hempId").val().split(",");
		var mgrIdArray=$("#hmgrId").val().split(",");
	
	for(var i=0;i<deptIdArray.length;i++ ){
		
		
		$("#department option[value=" + deptIdArray[i] + "]").attr('selected',
		'true');
	}
	 
	getManagers();
	
	for(var i=0;i<mgrIdArray.length;i++ ){
		
		
		$("#manager option[value=" + mgrIdArray[i] + "]").attr('selected',
		'true');
	}
	
	getEmployees();
	
	for(var i=0;i<empIdArray.length;i++ ){
		
		
		$("#employee option[value=" + empIdArray[i] + "]").attr('selected',
		'true');
	}
	
	$("#sdate").val($("#hstartDate").val());
	$("#edate").val($("#hEndDate").val());
	
	}
	
	
	$("#sdate,#edate").datepicker(
			{
				dateFormat : "dd-mm-yy",
				yearRange : 'c-65:c+65',
				maxDate : new Date(),
				changeMonth : "true",
				changeYear : "true",
		});
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
	
	$('.savebutton').click(function(){
		
		
		var currentObject = $(this);
		var rowObject = currentObject.parents('tr:first');
		var flag = checkTime(rowObject.find('.inTimeClass').find('#intime').val(),rowObject.find('.outTimeClass').find('#outtime').val());
		var id=currentObject.attr('id');
		
		var timeSheetDetails=id.split(",");
		
		
		
		if(flag){
			
			$("#errordiv").hide();
			var x = confirm("Are you sure you want update time");
			if (x) {
			currentObject.val("Updating...");
		var rowData={
				'date':timeSheetDetails[1],
				'id':timeSheetDetails[0],
				'inTime':rowObject.find('.inTimeClass').find('#intime').val(),
				'outTime':rowObject.find('.outTimeClass').find('#outtime').val(),
				'workinghours':rowObject.find('.workinghours').val()
		};
		
		
		setTimeout(function(){
		$.ajax({
			url:'timesheetReconcil.do?parameter=updateTimeSheet',
			data:rowData,
			async:false,
			success:function(data){
				result = $.parseJSON(data);
				currentObject.attr("style","background-color:RoyalBlue ;color:white;height:32px;width:110px;");
				currentObject.val(result.status);
			}
		});
		}, 100);
		
		}
		}
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

	
	
});

function checkTime(ftime,ttime) {
  
	var flag= true;
	
	if(ftime==0){
		$("#errordiv").show();
		$("#errordiv").text("please select the inTime");
		$('.error-box').css({'visibility': 'visible'});
		flag= false;
   }else if(ttime==0){
    	 $("#errordiv").show();
 		$("#errordiv").text("please select the OutTime");
 		$('.error-box').css({'visibility': 'visible'});
 		flag= false;
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
		$("#errordiv").show();
		$("#errordiv").text("The Out Time Should Not less than In Time");
		$('.error-box').css({'visibility': 'visible'});
			 document.getElementById("outtime").value = "";
		 flag=false;
	}
	if (ttimeSplitHour == ftimeSplitHour) {
		if (ftimeSplitMin > ttimeSplitMin) {
			$("#errordiv").show();
			$("#errordiv").text("The Out Time Should Not less than In Time");
			$('.error-box').css({'visibility': 'visible'});
		
		document.getElementById("outtime").value = "";
			flag=false;
		}
		if (ftimeSplitMin == ttimeSplitMin) {
			if (ftimeSplitSec >= ttimeSplitSec) {
				$("#errordiv").show();
				$("#errordiv").text("The Out Time Should Not less than In Time");
				$('.error-box').css({'visibility': 'visible'});
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
		
		
		var hours = parseInt( difference / 3600 ) % 24;
		var minutes = parseInt( difference / 60 ) % 60;
		var seconds = difference % 60;

		var result = (hours < 10 ? "0" + hours : hours) + ":" + (minutes < 10 ? "0" + minutes : minutes) + ":" + (seconds  < 10 ? "0" + seconds : seconds);
        
		/*alert("result :: "+result);
		
		var result = [
		    Math.floor(difference / 3600), // an hour has 3600 seconds
		    Math.floor((difference % 3600) / 60), // a minute has 60 seconds
		    difference % 60
		];
		result = result.map(function(v) {
		    return v < 10 ? '0' + v : v;
		}).join(':');
		
		rowObject.find('.totalhours').val(result);
		var hour="00";
		var realHour=(result+"").substring(0,2);
		if(parseInt(realHour)!=0)
		hour = (parseInt(realHour)-1)+"";
		hour = (hour+"").length<2?"0"+hour:hour;
		var workingHour =hour+ (result+"").substring(2);*/
		rowObject.find('.workinghours').val(result);
}

function validation(){
		
	 var deptVal=$("#department").val();
	 var mangVal=$("#manager").val();
	 var employeeVal=$("#employee").val();
   	var sdate=$("#sdate").val();
	var edate=$("#edate").val();
	
	
     if(deptVal==null){
		$("#errordiv").show();
		$("#errordiv").text("Please select the Department");
		$('.error-box').css({'visibility': 'visible'});
		return false;
 	}else if(mangVal==null){
		$("#errordiv").show();
		$("#errordiv").text("Please select the Location");
		$('.error-box').css({'visibility': 'visible'});
		return false;
 	}else if(employeeVal==null){
		$("#errordiv").show();
		$("#errordiv").text("Please select the Employee");
		$('.error-box').css({'visibility': 'visible'});
		return false;
     }else if(sdate==""){
		$("#errordiv").show();
		$("#errordiv").text("Please select the Start Date");
		$('.error-box').css({'visibility': 'visible'});
		return false;
	}else if(edate==""){
		$("#errordiv").show();
		$("#errordiv").text("Please select the End Date");
		$('.error-box').css({'visibility': 'visible'});
		return false;
	}else{
    	 $("#errordiv").hide();
    		$('.error-box').css({'visibility': 'hidden'});
	}
     
}

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
			url:"timesheetReconcil.do?parameter=getManagersByDept",
			data:sendParam,
			async:false,
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
		url:"timesheetReconcil.do?parameter=getEmployeeByMang",
		data:sendParam,
		async:false,
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