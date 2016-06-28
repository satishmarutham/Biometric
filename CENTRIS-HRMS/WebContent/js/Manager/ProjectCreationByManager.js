
var USERTYPE ="";
window.onload = Scrolldown;
$(document)
		.ready(
				function() {
					$("#regenerete").hide();
					
					$.ajax({
						type : "GET",
						url : "projectmaster.do?parameter=getApproveUsers",
						async:false,
						success : function(response) {
						var result = $.parseJSON(response);
					
							for ( var j = 0; j < result.approveusersList.length; j++) {
						
								$("#reportingto").append(
										'<option value="' + result.approveusersList[j].approvebyId + '">'
												+ result.approveusersList[j].approveby + '</option>');
							}
							
						}

					});
					
					
					$("#projectguide").click(function(){
						
				
						window.location.href = "projectmaster.do?parameter=downloadDocument";
						
						
					});
					
					
					
				$("#projectcoderegenerate").click(function(){
						
						var chhk = GenerateRefCodeValidations();
						
						if( chhk == true ){
							
							 reGenerateProjectCode();
							
							   window.setTimeout(function(){

							       if ( USERTYPE == 'MAN'){
								      window.location.href = "GetDetails.do?parameter=projectCreationByManager";
							       }else if( USERTYPE == 'DIR'){
							    	   
							    	   window.location.href = "GetDetails.do?parameter=getProjectMaster";
							       }else{
							    	 
							    	   window.location.href = "GetDetails.do?parameter=getProjectMaster";
							    	   
							       }

							    }, 5000);

							
						
								
						}
						
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
		$('#errordiv').show();
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
				
				$('#tdclosed').show();
				
				$("#projectname").val(result.projectlist[0].projectname);
				$("#projectlocation").val(result.projectlist[0].projectlocation);
				$("#projectrefcode").val(result.projectlist[0].projectRefCode);
				$("#projectid").val(result.projectlist[0].projectcode);
				
				$("#clientname").val(result.projectlist[0].clientname);
				$("#projecttype").val(result.projectlist[0].projecttype);
				$("#projectHighLevelActivity").val(result.projectlist[0].projectHighLevelActivity);
				$("#endcustomer").val(result.projectlist[0].endcustomer);
				$("#forFuturExpan").val(result.projectlist[0].forFuturExpan);
				$("#projectActivityCat").val(result.projectlist[0].projectActivityCat);
				$("#linkfinancialyear").val(result.projectlist[0].linkfinancialyear);
				$("#linkfinancialyear").val(result.projectlist[0].linkfinancialyear);
				
				$('#ponumber').val(result.projectlist[0].ponumber);
				 
				$("#reportingto option[value='"+result.projectlist[0].reportingto.trim()+"']").attr('selected','true');
			
				
				if(result.projectlist[0].projectstatus.trim()=="Approved"){
				
					$("#reportingto").attr('disabled',true);
				
				}else{
				
					$("#reportingto").attr('disabled',false);
				}
				
				
			
				
				
			}
		});

//		$("#regenerete").show();
		
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
		$("#errordiv").text("Select any project to delete");
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
	
	$('#errordiv').show();	
	var clientname=$('#clientname').val().trim();
	var projecttype=$('#projecttype').val().trim();
	var endcustomer=$('#endcustomer').val().trim();
	var projectHighLevelActivity=$('#projectHighLevelActivity').val().trim();
	var forFuturExpan=$('#forFuturExpan').val().trim();
	var projectActivityCat=$('#projectActivityCat').val().trim();
	
	var projectname=$('#projectname').val().trim();	
	var projectlocation=$('#projectlocation').val().trim();
	var projectid=$('#projectid').val().trim();
	var ProjectRefCode=$("#projectrefcode").val().trim();
	
	var reportingto=$("#reportingto").val().trim();
	
	
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
	
	}else if(projectHighLevelActivity==null || projectHighLevelActivity==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Project high level should not be empty");

		return false;
		
	}else if(projectHighLevelActivity.length >3 || projectHighLevelActivity.length < 3){
		
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
	
	}else if(forFuturExpan==null || forFuturExpan==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Project location should not be empty");

		return false;
		
	}else if(forFuturExpan.length >2 || forFuturExpan.length < 2){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Project location should be 2 characters");

		return false;
	
	}else if(projectActivityCat==null || projectActivityCat==""){
		
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
		
	}else if(reportingto==null || reportingto==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Select Approval Authority");

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
			$('#loader').show();
	    	return true;
		}
	}
}

function validationsUpdate(){
	$('#errordiv').show();
	var clientname=$('#clientname').val().trim();
	var projecttype=$('#projecttype').val().trim();
	var endcustomer=$('#endcustomer').val().trim();
	var projectActivityCat=$('#projectActivityCat').val().trim();
	var projectHighLevelActivity=$('#projectHighLevelActivity').val().trim();
	var forFuturExpan=$('#forFuturExpan').val().trim();
	
	var projectname=$('#projectname').val().trim();
	var projectlocation=$('#projectlocation').val().trim();
	var projectid=$('#projectid').val().trim();
	var ProjectRefCode=$("#projectrefcode").val().trim();
	
	var reportingto=$("#reportingto").val().trim();
	
	var  hprojectstatus  = $('#hprojectstatus').val();
	
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
	
	}else if(projectHighLevelActivity==null || projectHighLevelActivity==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Project name should not be empty");

		return false;
		
	}else if(projectHighLevelActivity.length >3 || projectHighLevelActivity.length < 3){
		
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
	
	}else if(forFuturExpan==null || forFuturExpan==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Project location should not be empty");

		return false;
		
	}else if(forFuturExpan.length >2 || forFuturExpan.length < 2){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Project location should be 2 characters");

		return false;
	
	}else if(projectActivityCat==null || projectActivityCat==""){
		
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
		
	}else if(reportingto==null || reportingto==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Select Approval Authority");

		return false;
	}else if(hprojectstatus=="Closed"){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("You should not do update operation on closed project");

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
		
	
			if($('#closedcheckbox').is(':checked')){
				
				$('#hiddencheck').val('Closed');
			}
			
			$('#hiddenreportingto').val(reportingto);
			
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
				$('#errordiv').show();	
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
				$('#errordiv').show();	
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
				$('#errordiv').show();	
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
	$('#errordiv').show();	
	var clientname=$('#clientname').val().trim();
	var projecttype=$('#projecttype').val().trim();
	var endcustomer=$('#endcustomer').val().trim();
	var projectActivityCat=$('#projectActivityCat').val().trim();
	var projectHighLevelActivity=$('#projectHighLevelActivity').val().trim();
	var forFuturExpan=$('#forFuturExpan').val().trim();
	
	var linkfinancialyear=$('#linkfinancialyear').val().trim();
	
	
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
	
	}else if(projectHighLevelActivity==null || projectHighLevelActivity==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Project HighLevel Activity should not be empty");

		return false;
		
	}else if(projectHighLevelActivity.length >3 || projectHighLevelActivity.length < 3){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Project HighLevel Activity  should be 3 characters");

		return false;
	
	}else if(endcustomer==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("End customer should not be empty");

		return false;
		
	}else if(endcustomer.length >3 || endcustomer.length < 3){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("End Customer  should be 3 characters");

		return false;
	
	}else if(forFuturExpan==null || forFuturExpan==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("For Future Expansion should not be empty");

		return false;
		
	}else if(forFuturExpan.length >2 || forFuturExpan.length < 2){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("'For Future Expansion' should be 2 characters");

		return false;
	
	}else if(projectActivityCat==null || projectActivityCat==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text(" 'Project Activity Categorization' should not be empty");

		return false;
		
	}else if(projectActivityCat.length >3  || projectActivityCat.length >3 ){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text(" 'Project Activity Categorization' should be 3 characters");

		return false;
		
	}else if(linkfinancialyear==null || linkfinancialyear==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("link financial year should not be empty");

		return false;
		
	}else if(linkfinancialyear.length >6 || linkfinancialyear.length >6){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("link financial year should be 6 characters");

		return false;
		
	}
	
	else{
		
		$('.error-box').css({'visibility' : 'hidden'});
		
//		var selectmonth=projectActivityCat.substring(projectActivityCat.length-7,projectActivityCat.length-5);
//		var selectyear=projectActivityCat.substring(projectActivityCat.length-2,projectActivityCat.length);
		
	     var refCode=clientname+"-"+projecttype+"-"+projectHighLevelActivity+"-"+endcustomer+"-"+forFuturExpan+"-"+projectActivityCat+"-"+linkfinancialyear;
	
	     $("#projectrefcode").val(refCode);
	
	}
}


function convertToUpper(str)
{
		$('#'+str).val($('#'+str).val().trim().toUpperCase());
		
		ceateprojectrefCode();
}



function convertToTitle(str)
{
	
	var te =$('#'+str).val();
	var con =  convertTT(te);
	$('#'+str).val(con);	
		
		
}



function  convertTT(str){
	
	return str.replace(/\w\S*/g, function(txt){return txt.charAt(0).toUpperCase() + txt.substr(1).toLowerCase();})
	
}



function GenerateRefCodeValidations(){
	$('#errordiv').show();	
	
	    var chk = validationsUpdate();
	   
	    var newRefCode = $("#projectrerefcode").val().trim();
		
	    var ProjectRefCode=$("#projectrefcode").val().trim();
	    
	    var projectrerefdate=$('#projectrerefdate').val().trim();
	    var projectActivityCat=$('#projectActivityCat').val().trim();
	    
	    var pronewdate = projectrerefdate.split('-');
	    var proolddate = projectActivityCat.split('-');
	    
	    
	    var pronewdate_1 = [pronewdate[1], pronewdate[0], pronewdate[2]].join('/');
	    
	    var proolddate_1 = [proolddate[1], proolddate[0], proolddate[2]].join('/');
	    
	    
	    if( chk == false){
	    	$('.error-box').css({'visibility' : 'visible'});
	    	$("#errordiv").text("Select any one Project and Click on Edit ");
	    	
	    	return false;
	    }
	    
	    else if(projectrerefdate==null || projectrerefdate==""){
			
			$('.error-box').css({'visibility' : 'visible'});
			$("#errordiv").text(" Project New Date should not be empty");

			return false;
	    }
	      else if(newRefCode == proolddate_1){
			
			$('.error-box').css({'visibility' : 'visible'});
			$("#errordiv").text(" Both Reference codes are same please try again ");

			return false;
	    }
	    
	      else if( pronewdate_1 < proolddate_1)
	    	  {
	    	    $('.error-box').css({'visibility' : 'visible'});
				$("#errordiv").text(" New Project code month Should not be less than the existing Code ");

				return false;
	    	  
	    	  }
	      else{
	    	  
	    	  return true ;
	      }
	
	
}



function reGenerateProjectCode(){
	
    	
    var newRefCode = $("#projectrerefcode").val();
    var ProjectRefCode=$("#projectrefcode").val().trim();
	var project_id =$('#projectid').val().trim();
	

		var projectdetails = {
			"project_id" : project_id,
			"newrefcode": newRefCode,
			"oldrefcode": ProjectRefCode
		};

		$.ajax({
			type : "GET",
			url : "projeccreationbymanager.do?parameter=reGenereteProjectCode",
			data : projectdetails,
			async : false,

			success : function(data) {
				var result = $.parseJSON(data);
				

				USERTYPE = result.status[2];
				if(result.status[0] == true)
					{$('#errordiv').show();	
					$('.error-box').css({
						'visibility' : 'visible',
						'color' : 'green'
					});
					
					$("#errordiv").text(result.status[1]);
			      }
				else{
					$('#errordiv').show();	
					$('.error-box').css({
						'visibility' : 'visible',
						'color' : 'red'
					});
					
					$("#errordiv").text(result.status[1]);
					
				}
				 
				

			}
		});

	}

	

function createNewProjectRefCode(){
	
	var clientname=$('#clientname').val().trim();
	var projecttype=$('#projecttype').val().trim();
	var endcustomer=$('#endcustomer').val().trim();
	var projectHighLevelActivity=$('#projectHighLevelActivity').val().trim();
	var forFuturExpan=$('#forFuturExpan').val().trim();
	
	
	var projectrerefdate=$('#projectrerefdate').val().trim();
	 
	var selectmonth=projectrerefdate.substring(projectrerefdate.length-7,projectrerefdate.length-5);
	var selectyear=projectrerefdate.substring(projectrerefdate.length-2,projectrerefdate.length);
	
     var refCode=clientname+"-"+projecttype+"-"+projectHighLevelActivity+"-"+endcustomer+"-"+forFuturExpan+"-"+selectmonth+selectyear;

     $("#projectrerefcode").val(refCode);

}
	
function approveProject(projectCode,approvedby,projectname){
	
	var x =confirm("Are you sure to approve the project "+projectname);
	
	if(x){
  	       
        $.ajax({

    		type : "GET",
    		url : "projectmaster.do?parameter=approvedProject",
    		data : {'projectCode':projectCode,'approvedBy':approvedby},
    		beforeSend: function() {
			       
				  $('#loader1').show();
				  
			    },
    		async : false,

    		success : function(data) {

    			var result = $.parseJSON(data);
    			$('#loader1').hide();
    			
       			if (result.status=="true") {
    				$("#project tr").find('td').find('input#'+projectCode).val('Approved');
    		        $("#project tr").find('td').find('input#'+projectCode).css({'background-color':'#1267E9','color':'#FFFFFF','font-weight':'bold'});
    				$("#project tr").find('td').find('span#status'+projectCode).text('Approved');
    				$("#project tr").find('td').find('input#reject'+projectCode).hide();
    				
    			}else if(result.status=="MialNotSent"){
    				$("#project tr").find('td').find('input#'+projectCode).val('Approved');
    		        $("#project tr").find('td').find('input#'+projectCode).css({'background-color':'#1267E9','color':'#FFFFFF','font-weight':'bold'});
    				$("#project tr").find('td').find('span#status'+projectCode).text('Approved');
    				$("#project tr").find('td').find('input#reject'+projectCode).hide();
    				
    				$("#messagediv").show();
    				$("#messagediv").text("Project is Approved,Mail not Sent");
    				$('.error-box').css({'visibility' : 'visible'});
    				$('html, body').animate({ scrollTop: $('#messagediv').offset().top }, 'fast');
    			}else{
    				
    				$("#messagediv").show();
    				$("#messagediv").text("Project not  Approved,Please try again");
    				$('.error-box').css({'visibility' : 'visible'});
    				$('html, body').animate({ scrollTop: $('#messagediv').offset().top }, 'fast');
    			} 


    		}

    	});
        
   
	}
   
}

function rejectProject(projectCode,rejectedby,projectname){
	
	var x =confirm("Are you sure to reject the project "+projectname);
	
	if(x){
        
        $.ajax({

    		type : "GET",
    		url : "projectmaster.do?parameter=rejectedProject",
    		data : {'projectCode':projectCode,'rejectedby':rejectedby},
    		beforeSend: function() {
			       
				  $('#loader1').show();
				  
			    },
    		async : false,

    		success : function(data) {

    			var result = $.parseJSON(data);
    			$('#loader1').hide();
    			
    			if (result.status=="true") {
    				
    				$("#project tr").find('td').find('input#reject'+projectCode).val('Rejected');
    		        $("#project tr").find('td').find('input#reject'+projectCode).css({'background-color':'#1267E9','color':'#FFFFFF','font-weight':'bold'});
    				$("#project tr").find('td').find('span#status'+projectCode).text('Rejected');
    				$("#project tr").find('td').find('input#'+projectCode).hide();
    				
    			}else if(result.status=="MialNotSent"){
    				$("#project tr").find('td').find('input#reject'+projectCode).val('Rejected');
    		        $("#project tr").find('td').find('input#reject'+projectCode).css({'background-color':'#1267E9','color':'#FFFFFF','font-weight':'bold'});
    				$("#project tr").find('td').find('span#status'+projectCode).text('Rejected');
    				$("#project tr").find('td').find('input#'+projectCode).hide();
    				
    				$("#messagediv").show();
    				$("#messagediv").text("Project is Rejected,Mail not Sent");
    				$('.error-box').css({'visibility' : 'visible'});
    				$('html, body').animate({ scrollTop: $('#messagediv').offset().top }, 'fast');
    			
    			}else{
    				
    				$("#messagediv").show();
    				$("#messagediv").text("Project not Rejected,Please try again");
    				$('.error-box').css({'visibility' : 'visible'});
    				$('html, body').animate({ scrollTop: $('#messagediv').offset().top }, 'fast');
    			} 

    			
    		}

    	});
        
   
	}
	
		
}

function search(){
	$("#errordiv").hide();
	var projectname =$('#searchprojectName').val();

	if(projectname == ''){
			
		$("#messagediv").show();
		$("#messagediv").text("Enter any project name or projectRef code");
		$('.error-box').css({'visibility' : 'visible'});
    	
    	
    	return false;
	}else{
		
		window.location.href="projeccreationbymanager.do?parameter=getProjectSearchDetails&projectId="+projectname;
		
	}
	
	
}
function Scrolldown() {
    window.scroll(0,200); 
}

function downloadAll(){
	
	window.location.href="projeccreationbymanager.do?parameter=downloadAllProjects";
}


