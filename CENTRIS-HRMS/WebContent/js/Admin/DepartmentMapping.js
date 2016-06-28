
$(document).ready(function(){
	$("#errordiv").hide();
	$.ajax({
		type : "POST",
		url : "projectManagerMapping.do?parameter=getManager",
		success : function(response) {
			
			var result = $.parseJSON(response);

			var manager = $("#user");

			for ( var j = 0; j < result.managerList.length; j++) {

				$(manager).append(
						'<option value="' + result.managerList[j].managerId + '">'
								+ result.managerList[j].managerName + '</option>');
			}
		}
	});		
});

function getMappedDepartments(manager) {
		
	$.ajax({
	      type : "POST",
			url : "departmentMapping.do?method=getAvailableDepartments",
			data:{"userCode":manager},
			success : function(response) {
				var result = $.parseJSON(response);
			
				$("#original").empty();
				for ( var j = 0; j < result.AvailableDepartments.length; j++) {
					$("#original")
							.append(
									'<option value="'
											+ result.AvailableDepartments[j].dept_id
											+ '">'
											+ result.AvailableDepartments[j].dept_name
											+ '</option>');
				}
			}
		});
	
	
	$.ajax({
	      type : "POST",
			url : "departmentMapping.do?method=getMappedDepartments",
			data:{"userCode":manager},
			success : function(response) {
				var result = $.parseJSON(response);
				$("#copy").empty();
				for ( var j = 0; j < result.MappedDepartments.length; j++) {
					$("#copy")
							.append(
									'<option value="'
											+ result.MappedDepartments[j].dept_id
											+ '">'
											+ result.MappedDepartments[j].dept_name
											+ '</option>');
				}
			}
		});
}
function assign() {
	
	
	
	var designation = $("#designation").val();
	var userId= $("#user option:selected").val();
	
	if(designation == ""){
		$("#errordiv").show();
		$("#errordiv").text("Select Designation");
		 $('.error-box').css({'visibility': 'visible'});
		return false;
	}
	if (userId == "") {
		$("#errordiv").show();
		$("#errordiv").text("Select User");
		 $('.error-box').css({'visibility': 'visible'});
		return false;
	}
	
	if(copy.options.length >1){
		$("#errordiv").show();
		$("#errordiv").text("Mapping Only One Department");
		 $('.error-box').css({'visibility': 'visible'});
		return false;
	}else{
		$("#errordiv").hide();
		 $('.error-box').css({'visibility': 'hidden'});
	var updaterowsArray = new Array();
	for ( var i = 0; i < copy.options.length; i++) {
		updaterowsArray.push(copy.options[i].value);
		copy.options[i].value = "";
	}
 
	var myarray = JSON.stringify(updaterowsArray);
	$.ajax({
	   type: "POST",
		url : "departmentMapping.do?method=saveDepartmentMapping",
		data : {
			"userId" : userId,
			"deptDetails" : myarray
		},
		success : function(response) {
		var result = response.replace(/"status":/g,	"").trim();
			if (result == '{"success"}') {
			$("#successdiv").show();
			 $('.error-box').css({'visibility': 'visible'});
			$("#spanid").text("Department Mapping Done Successfully");
			setTimeout("location.reload();", 2000);
		    	 
    	}else{
    		$("#errordiv").show();
    		$("#errordiv").text("Department  Mapping  Is Failed");
    		 $('.error-box').css({'visibility': 'visible'});
    			setTimeout("location.reload();", 2000);
		}
		}
	});
	
	}
} 



