

$(document)
		.ready(
				function() {
					
					
					$("#projectguide").click(function(){
						
				
						window.location.href = "projectmaster.do?parameter=downloadDocument";
						
						
					});
					
					
					$("#projectrefdate").datepicker({
						dateFormat : "dd-mm-yy",
						yearRange : 'c-65:c+65',
						minDate : 0,
						changeMonth : "true",
						changeYear : "true",
						numberOfMonths : 1,

					});
					
					
					

				});


function editProject() {
	
	var count = 0;
	var project_id = null;

	$('input[name="selectBox"]:checked').each(function() {
		count = count + 1;
		project_id = this.value;

	});

	if (count > 1 || count == 0) {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Select any one Project ");
		
		return false;

	} else {

		var projectdetails = {
			"project_id" : project_id
		};

		$.ajax({
			type : "GET",
			url : "projectmaster.do?parameter=editProjectDetails",
			data : projectdetails,
			async : false,

			success : function(data) {
				var result = $.parseJSON(data);
				
				$("#projectname").val(result.projectlist[0].projectname);
				$("#projectlocation").val(result.projectlist[0].project_location);
				$("#projectrefcode").val(result.projectlist[0].projectRefcode);
				$("#projectid").val(result.projectlist[0].projectcode);
				
				$("#clientname").val(result.projectlist[0].clientname);
				$("#projecttype").val(result.projectlist[0].projecttype);
				$("#projectrefname").val(result.projectlist[0].projectrefname);
				$("#endcustomer").val(result.projectlist[0].endcustomer);
				$("#projectreflocation").val(result.projectlist[0].projectreflocation);
				$("#projectrefdate").val(result.projectlist[0].projectrefdate);

			}
		});

	}
}

function deleteProject() {

	var checkboxArray = document.getElementsByName('selectBox');
	var updaterowsArray = new Array();

	for ( var i = 0; i < checkboxArray.length; i++) {
		if (checkboxArray[i].checked == true) {
			updaterowsArray.push(checkboxArray[i].value);
		}
	}
	if (updaterowsArray.length <= 0) {
		$("#errordiv").show();
		$("#errordiv").text(" Select any project to delete");
		$('.error-box').css({
			'visibility' : 'visible'
		});
		return false;
	} else {

		var x = confirm("Are you sure you want to delete this project");
		if (x) {

			var projectdetails = {'project_id':updaterowsArray};
			


			$
					.ajax({
						type : "GET",
						url : "projectmaster.do?parameter=deleteProject",
						data : projectdetails,
						async : false,

						success : function(data) {
							var result = $.parseJSON(data);
							
							window.location = "GetDetails.do?parameter=getProjectMaster&status="
									+ result.status;

						}
					});

		}
	}
}

function selectAll() {

	var selectall = document.getElementsByName("selectall");
	var checkboxArray = document.getElementsByName('selectBox');
	if (selectall[0].checked == true) {
		for ( var i = 0; i < checkboxArray.length; i++) {
			checkboxArray[i].checked = true;

		}
	} else {
		for ( var i = 0; i < checkboxArray.length; i++) {
			checkboxArray[i].checked = false;
		}
	}
}

function validations(){
	
	
	var clientname=$('#clientname').val().trim();
	var projecttype=$('#projecttype').val().trim();
	var endcustomer=$('#endcustomer').val().trim();
	var projectrefname=$('#projectrefname').val().trim();
	var projectreflocation=$('#projectreflocation').val().trim();
	var projectrefdate=$('#projectrefdate').val().trim();
	
	var projectname=$('#projectname').val().trim();	
	var projectlocation=$('#projectlocation').val().trim();
	var projectid=$('#projectid').val().trim();
	var ProjectRefCode=$("#projectrefcode").val().trim();
	
	
	
	if(clientname==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Client name should not be empty");

		return false;
		
	}else if(clientname.length >2 || clientname.length < 2){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Client name should be 2 characters");

		return false;
	}else if(projecttype==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Project type should not be empty");

		return false;
		
	}else if(projecttype.length >2 || projecttype.length < 2){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Project type should be 2 characters");

		return false;
	
	}else if(projectrefname==null || projectrefname==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Project name should not be empty");

		return false;
		
	}else if(projectrefname.length >3 || projectrefname.length < 3){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Project name  should be 3 characters");

		return false;
	
	}else if(endcustomer==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("End customer should not be empty");

		return false;
		
	}else if(endcustomer.length >3 || endcustomer.length < 3){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("End Customer  should be 3 characters");

		return false;
	
	}else if(projectreflocation==null || projectreflocation==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Project location should not be empty");

		return false;
		
	}else if(projectreflocation.length >2 || projectreflocation.length < 2){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Project location should be 2 characters");

		return false;
	
	}else if(projectrefdate==null || projectrefdate==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text(" Project date should not be empty");

		return false;
		
	}else if(ProjectRefCode==null || ProjectRefCode==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("ProjectRefCode should not be empty");

		return false;
		
	}else if(projectname==null || projectname==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Project name should not be empty");
		return false;
		
	}else if(projectlocation==null || projectlocation==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Location should not be empty");

		return false;
		
	}else if(projectid!=""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("project alredy exist you can update");

		return false;
	
	}else{
		
		
		if(checkprojectname()){
			
			$('.error-box').css({
				'visibility' : 'visible'
			});
			$("#errordiv").text("Project already exist");
			
			return false;
		}else if(checkProjectRefCode()){
			
			$('.error-box').css({
				'visibility' : 'visible'
			});
			$("#errordiv").text("ProjectRefCode already exist");
			
			return false;
		}else{
		
		return true;
		}
	}
}

function validationsUpdate(){
	
	var clientname=$('#clientname').val().trim();
	var projecttype=$('#projecttype').val().trim();
	var endcustomer=$('#endcustomer').val().trim();
	var projectrefdate=$('#projectrefdate').val().trim();
	var projectrefname=$('#projectrefname').val().trim();
	var projectreflocation=$('#projectreflocation').val().trim();
	
	var projectname=$('#projectname').val().trim();
	var projectlocation=$('#projectlocation').val().trim();
	var projectid=$('#projectid').val().trim();
	var ProjectRefCode=$("#projectrefcode").val().trim();
	
	
	
	var count = 0;
	var project_id = null;

	$('input[name="selectBox"]:checked').each(function() {
		count = count + 1;
		project_id = this.value;

	});

	if (count > 1 || count == 0) {

		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Select any one Project ");
		
		return false;

	}else if(clientname==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Client name should not be empty");

		return false;
		
	}else if(clientname.length >2 || clientname.length < 2){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Client name should be 2 characters");

		return false;
	}else if(projecttype==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Project type should not be empty");

		return false;
		
	}else if(projecttype.length >2 || projecttype.length < 2){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Project type should be 2 characters");

		return false;
	
	}else if(projectrefname==null || projectrefname==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Project name should not be empty");

		return false;
		
	}else if(projectrefname.length >3 || projectrefname.length < 3){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Project name  should be 3 characters");

		return false;
	
	}else if(endcustomer==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("End customer should not be empty");

		return false;
		
	}else if(endcustomer.length >3 || endcustomer.length < 3){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("End Customer  should be 3 characters");

		return false;
	
	}else if(projectreflocation==null || projectreflocation==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Project location should not be empty");

		return false;
		
	}else if(projectreflocation.length >2 || projectreflocation.length < 2){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Project location should be 2 characters");

		return false;
	
	}else if(projectrefdate==null || projectrefdate==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text(" Project date should not be empty");

		return false;
		
	}else if(ProjectRefCode==null || ProjectRefCode==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("ProjectRefCode should not be empty");

		return false;
		
	}else if(projectname==null || projectname==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Project name should not be empty");
		return false;
		
	}else if(projectlocation==null || projectlocation==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Location should not be empty");

		return false;
		
	}else{
		
		if(checkprojectnameUpdate()){
			
			$('.error-box').css({
				'visibility' : 'visible'
			});
			$("#errordiv").text("Project already exist");
			
			return false;
		}else if(checkProjectRefCode()){
			
			$('.error-box').css({
				'visibility' : 'visible'
			});
			$("#errordiv").text("ProjectRefCode already exist");
			
			return false;
		
		}else{
		
		return true;
		}
	}
}


function checkprojectname(){
	
	var status=false;
	
	var project_name =$('#projectname').val().trim();
	
	var projectdetails={"project_name":project_name};
	
	$.ajax({

		type : "GET",
		url : "projectmaster.do?parameter=checkProjectCount",
		data : projectdetails,
		async : false,

		success : function(data) {

			var result = $.parseJSON(data);
			
			if (result.status) {
				
				status=true;

				$('.error-box').css({
					'visibility' : 'visible'
				});
				$("#errordiv").text("Project already exist");

			} else{
				
				status=false;
			}

		}

	});
	
	return status;
}

function checkProjectRefCode(){
	
	var status=false;
	
	var ProjectRefCode =$('#projectrefcode').val().trim();
	var project_id =$('#projectid').val().trim();
	
	var projectdetails={"project_id":project_id,"projectcode":ProjectRefCode};
	
	
	$.ajax({

		type : "GET",
		url : "projectmaster.do?parameter=checkProjectCode",
		data : projectdetails,
		async : false,

		success : function(data) {

			var result = $.parseJSON(data);
			
			if (result.status) {
				
				status=true;

				$('.error-box').css({
					'visibility' : 'visible'
				});
				$("#errordiv").text("ProjectRefCode already exist");

			} else{
				
				status=false;
			}

		}

	});
	
	return status;
}

function checkprojectnameUpdate(){
	
	var status=false;
	
	var project_name =$('#projectname').val().trim();
	var project_id =$('#projectid').val().trim();
	
	var projectdetails={"project_id":project_id,"project_name":project_name};
	
	$.ajax({

		type : "GET",
		url : "projectmaster.do?parameter=checkProjectCountUpdate",
		data : projectdetails,
		async : false,

		success : function(data) {

			var result = $.parseJSON(data);
			
			if (result.status) {
				
				status=true;

				$('.error-box').css({
					'visibility' : 'visible'
				});
				$("#errordiv").text("Project already exist");

			} else{
				
				status=false;
			}

		}

	});
	
	return status;
}


function ceateprojectrefCode(){
	
	var clientname=$('#clientname').val().trim();
	var projecttype=$('#projecttype').val().trim();
	var endcustomer=$('#endcustomer').val().trim();
	var projectrefdate=$('#projectrefdate').val().trim();
	var projectrefname=$('#projectrefname').val().trim();
	var projectreflocation=$('#projectreflocation').val().trim();
	
	
	
	if(clientname==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Client name should not be empty");

		return false;
		
	}else if(clientname.length >2 || clientname.length < 2){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Client name should be 2 characters");

		return false;
	}else if(projecttype==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Project type should not be empty");

		return false;
		
	}else if(projecttype.length >2 || projecttype.length < 2){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Project type should be 2 characters");

		return false;
	
	}else if(projectrefname==null || projectrefname==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Project name should not be empty");

		return false;
		
	}else if(projectrefname.length >3 || projectrefname.length < 3){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Project name  should be 3 characters");

		return false;
	
	}else if(endcustomer==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("End customer should not be empty");

		return false;
		
	}else if(endcustomer.length >3 || endcustomer.length < 3){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("End Customer  should be 3 characters");

		return false;
	
	}else if(projectreflocation==null || projectreflocation==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Project ref location should not be empty");

		return false;
		
	}else if(projectreflocation.length >2 || projectreflocation.length < 2){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Project ref location should be 2 characters");

		return false;
	
	}else if(projectrefdate==null || projectrefdate==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Date should not be empty");

		return false;
		
	}else{
	
		$('.error-box').css({'visibility' : 'hidden'});
		
		var selectmonth=projectrefdate.substring(projectrefdate.length-7,projectrefdate.length-5);
		var selectyear=projectrefdate.substring(projectrefdate.length-2,projectrefdate.length);
		
	     var refCode=clientname+"-"+projecttype+"-"+projectrefname+"-"+endcustomer+"-"+projectreflocation+"-"+selectmonth+selectyear;
	
	     $("#projectrefcode").val(refCode);
	
	}
}



