
$(document).ready(function(){
	
	
	$("#errordiv").hide();
	
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
	
	
	$("#month option[value=" + $("#hmonth").val() + "]").attr('selected','true');
	$("#year option[value=" + $("#hyear").val() + "]").attr('selected','true');
	
	}
	
	
	
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
			url:"attendancetimesheetreport.do?parameter=getManagersByDept",
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
		url:"attendancetimesheetreport.do?parameter=getEmployeeByMang",
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


function validations(){
	
	
	var department=$('#department').val();
	var manager=$('#manager').val();
	var employee=$('#employee').val();
	var month=$('#month').val();
	var year=$('#year').val();
	
	
	if(department==null || department==""){
		
		$("#errordiv").show();
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("select Department");

		return false;
	}else if(manager==null || manager==""){
		
		$("#errordiv").show();
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("select Manager");

		return false;
		
	}else if(employee==null || employee==""){
		
		$("#errordiv").show();
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("select Employee");

		return false;
	}else if(month==""){
		
		$("#errordiv").show();
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("select Month");

		return false;
	}else if(year==""){
		
		$("#errordiv").show();
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("select Year");

		return false;
	}else{
		
		return true;
	}
	
	
}
