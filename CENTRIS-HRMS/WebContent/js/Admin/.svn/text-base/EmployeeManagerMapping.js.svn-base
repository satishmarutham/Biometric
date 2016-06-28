$(function() {
	$("#errordiv").hide();
	$.ajax({
		      type : "POST",
				url : "employeeMangerMapping.do?method=getAvailableEmployees",
				success : function(response) {
					var result = $.parseJSON(response);
					var original = $("#original");
				
					for ( var j = 0; j < result.EmployeeList.length; j++) {

						$(original)
								.append(
										'<option value="'
												+ result.EmployeeList[j].employeeId
												+ '">'
												+ result.EmployeeList[j].employeeName
												+ '</option>');
					}
				}
			});
	$.ajax({
		type : "POST",
		url : "projectManagerMapping.do?parameter=getManager",
		success : function(response) {
			
			var result = $.parseJSON(response);

			var manager = $("#manager");

			for ( var j = 0; j < result.managerList.length; j++) {

				$(manager).append(
						'<option value="' + result.managerList[j].managerId + '">'
								+ result.managerList[j].managerName + '</option>');
			}
		}
	});	
	$("#manager").change(function() {
	/*	$.ajax({
		      type : "POST",
				url : "employeeMangerMapping.do?method=getAvailableEmployees",
				success : function(response) {
					var result = $.parseJSON(response);
					var original = $("#original");
				
					for ( var j = 0; j < result.EmployeeList.length; j++) {

						$(original)
								.append(
										'<option value="'
												+ result.EmployeeList[j].employeeId
												+ '">'
												+ result.EmployeeList[j].employeeName
												+ '</option>');
					}
				}
			});*/
		managerDetailMapping();
	});
	
});

function assign() {
	$("#errordiv").show();
	var managerId = $("#manager").val();

	if (managerId == "") {
		$("#errordiv").show();
		$("#errordiv").text("Select Any Manger");
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
		url : "employeeMangerMapping.do?method=saveemployeeMangerMapping",
		data : {
			"managerId" : managerId,
			"employeeDetails" : myarray
		},
		success : function(response) {
			var result = response.replace(/"result":/g,	"").trim();
			
		if (result == '{"success"}') {
			$("#successdiv").show();
			 $('.error-box').css({'visibility': 'visible'});
			$("#spanid").text("Employee-Manager Mapping Done Successfully");
			setTimeout("location.reload();", 2000);
		    	 
    	}else{
    		$("#errordiv").show();
    		$("#errordiv").text("Employee-Manager  Mapping  Is Failed");
    		 $('.error-box').css({'visibility': 'visible'});
    			setTimeout("location.reload();", 2000);
		}
		}
	});

	}
}

function managerDetailMapping() {

	var managerVal = $("#manager > option:selected").val();
	$("#copy").empty();
	if (managerVal != 0) {
		$.ajax({
			type : "POST",
			url : "employeeMangerMapping.do?method=getMappedEmployees",
			data : {"ManagerVal": managerVal},
			success : function(data) {
				var result= $.parseJSON(data);
				for ( var i = 0; i < result.Mappedemployeelist.length; i++) {
					$('#copy').append(
							'<option value="' + result.Mappedemployeelist[i].employeeId
									+ '">' + result.Mappedemployeelist[i].employeeName
									+ '</option>');
				}
			}
		});
	}
}