$(function() {
		
		$("#datefrom").datepicker({
			dateFormat : "dd-mm-yy",
			yearRange : 'c-65:c+65',
			maxDate : 0,
			changeMonth : "true",
			changeYear : "true",
			numberOfMonths : 1,
			onClose : function(selectedDate) {
				$("#dateto").datepicker("option", "minDate", selectedDate);
			}
		});
		$("#dateto").datepicker({
			dateFormat : "dd-mm-yy",
			yearRange : 'c-65:c+65',
			maxDate : 0,
			changeMonth : "true",
			changeYear : "true",
			numberOfMonths : 1,
			onClose : function(selectedDate) {
				$("#datefrom").datepicker("option", "maxDate", selectedDate);
			}
		});
		
		$("#validateTable").hide();
		
	});

function empDetails(){
	
	var shiftid=$("#shiftid").val();
	var deptid=$("#empdepartment").val();
	
	var empdata={"shiftid" : shiftid , "deptid" : deptid};
	
	
	if(!(shiftid=="" || deptid=="")){
		
		
		
		$.ajax({
			
			
			type : "GET",
			url  : "auditreport.do?parameter=getEmpDetails",
			data : empdata,
			async: false,
			
			success : function(data){
				
				var result = $.parseJSON(data);
			
				
				createSelectBox("empidval", result.EMPDETAILS);
				
			}
			
		});
		
	}
	

}



function createSelectBox(selectboxId,optionValue){
	
	$('#'+selectboxId).empty();
	
	var selectObject=document.getElementById(selectboxId);
	
	var anOption = document.createElement("OPTION");
	
	anOption.innerHTML = "---Select---";
	
	
	anOption.setAttribute("value","");
	
	selectObject.appendChild(anOption);
	if(optionValue.length!=0){
		
		anOption.setAttribute("value","0");
		anOption.innerHTML = "All";
	}

	for(var i=0;i<optionValue.length;i++){
		
		var anOption = document.createElement("OPTION");
		anOption.setAttribute("value",optionValue[i].empId);
		anOption.innerHTML = optionValue[i].empName;
		selectObject.appendChild(anOption);
	}
}



function validations() {

	var shiftid = $("#shiftid").val();
	var deptid = $("#empdepartment").val();
	var fromdate = $("#datefrom").val();
	var todate = $("#dateto").val();
	var filter = $("#filter").val();
	var empid=$("#empidval").val();

	if (shiftid == "") {

		$("#validateTable").show();
		$(".validateTips").text("select shift");

		return false;
	} else if (deptid == "") {

		$("#validateTable").show();
		$(".validateTips").text("select department");

		return false;

	}else if(empid=="" || empid==null){
		
		$("#validateTable").show();
		$(".validateTips").text("select employee");
		
		return false;
		
	}else if (fromdate == "") {

		$("#validateTable").show();
		$(".validateTips").text("from date should not be null");

		return false;

	} else if (filter == "") {

		$("#validateTable").show();
		$(".validateTips").text("selct filter");

		return false;

	} else if (!(todate == "")) {

		var startdate = dateConverter($("#datefrom").val());
		
		var endDate = dateConverter($("#dateto").val());

		if (startdate > endDate) {

			$("#validateTable").show();
			$(".validateTips").text("enddate should be greterthan startdate");

			return false;
		} else {

			return true;
		}

	}  else {

		return true;
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