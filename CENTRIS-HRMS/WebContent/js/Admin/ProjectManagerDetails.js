$(function() {
	$("#errordiv").hide();
	
	$('#selectall').click(function(){
		
		if($(this).is(':checked')){
			
			$.ajax({
			      type : "POST",
					url : "projectManagerMapping.do?parameter=getAllProjects",
					success : function(response) {
						var result = $.parseJSON(response);
					
						var original = $("#original");
					
						$(original).empty();
						
						for ( var j = 0; j < result.ProjectList.length; j++) {

							$(original)
									.append(
											'<option value="'
													+ result.ProjectList[j].projectId
													+ '">'
													+ result.ProjectList[j].projectName
													+ '</option>');
						}
					}
				});
				
	
		}else{
			
			
			$.ajax({
			      type : "POST",
					url : "projectManagerMapping.do?parameter=getProject",
					success : function(response) {
						var result = $.parseJSON(response);
						var original = $("#original");
						$(original).empty();
						for ( var j = 0; j < result.ProjectList.length; j++) {

							$(original)
									.append(
											'<option value="'
													+ result.ProjectList[j].projectId
													+ '">'
													+ result.ProjectList[j].projectName
													+ '</option>');
						}
					}
				});
			
			
		}
		
	});
		
	
	
	
	$.ajax({
		      type : "POST",
				url : "projectManagerMapping.do?parameter=getProject",
				success : function(response) {
					var result = $.parseJSON(response);
					var original = $("#original");
				
					for ( var j = 0; j < result.ProjectList.length; j++) {

						$(original)
								.append(
										'<option value="'
												+ result.ProjectList[j].projectId
												+ '">'
												+ result.ProjectList[j].projectName
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
	}
	

	var updaterowsArray = new Array();
	for ( var i = 0; i < copy.options.length; i++) {
		updaterowsArray.push(copy.options[i].value);
		//copy.options[i].value = "";
	}

	var count=0;
	var sorted_arr = updaterowsArray.sort(); 
	for (var i = 0; i < updaterowsArray.length - 1; i++) {
	    if (sorted_arr[i + 1] == sorted_arr[i]) {
	    	count++;
	   }
	}
	if(count>0){
		
		$("#errordiv").show();
		$("#errordiv").text("Mapped Projects should not be duplicate");
		 $('.error-box').css({'visibility': 'visible'});
		return false;
		
	}else{
		$("#errordiv").hide();
		 $('.error-box').css({'visibility': 'hidden'});
	}
	
	
	var myarray = JSON.stringify(updaterowsArray);
	
	
	$.ajax({

	   type: "POST",
		url : "projectManagerMapping.do?parameter=saveProjectManagerMapping",
		data : {
			"managerId" : managerId,
			"projectDetails" : myarray
		},
		success : function(response) {
			var result = response.replace(/"result":/g,	"").trim();
			
		if (result == '{"success"}') {
			
			$('.error-box').css({'visibility': 'visible'});
			$("#spanid").text("Project-Manager Mapping Done Successfully");
			setTimeout("location.reload();", 3000);
		    	 
    	}else{
    		$("#errordiv").show();
    		$("#errordiv").text("Project-Manager  Mapping  Is Failed");
    		 $('.error-box').css({'visibility': 'visible'});
    			setTimeout("location.reload();",3000);
		}
		}
	});


}

function managerDetailMapping() {

	var managerVal = $("#manager > option:selected").val();
	$("#copy").empty();

	if (managerVal != 0) {
		$.ajax({
			type : "POST",
			url : "projectManagerMapping.do?parameter=getMappedProject",
			data : {"ManagerVal": managerVal},
			success : function(data) {
				var result= $.parseJSON(data);
				
			
				for ( var i = 0; i < result.mappedprojectlist.length; i++) {
					$('#copy').append(
							'<option value="' + result.mappedprojectlist[i].projectId
									+ '">' + result.mappedprojectlist[i].projectName
									+ '</option>');
				}
			}
		});
	}
}