$(function() {
	$("#errordiv").hide();
	$.ajax({
		      type : "POST",
				url : "mangerDirectorMapping.do?method=getAvailableManagers",
				success : function(response) {
					var result = $.parseJSON(response);
					var original = $("#original");
				
					for ( var j = 0; j < result.managerlist.length; j++) {

						$(original)
								.append(
										'<option value="'
												+ result.managerlist[j].managerId
												+ '">'
												+ result.managerlist[j].managerName
												+ '</option>');
					}
				}
			});
	$.ajax({
		type : "POST",
		url : "mangerDirectorMapping.do?method=getDirector",
		success : function(response) {
			
			
			var result = $.parseJSON(response);
		

			var director = $("#director");
			

			for ( var j = 0; j < result.directorlist.length; j++) {
			

				$(director).append(
						'<option value="' + result.directorlist[j].directorId + '">'
								+ result.directorlist[j].directorname + '</option>');
			}
		}
	});	
	$("#director").change(function() {
	
		directorDetailMapping();
	});
	
});

function assign() {

	$("#errordiv").show();
	var directorId = $("#director").val();

	if (directorId == "") {
		$("#errordiv").show();
		$("#errordiv").text("Select Any Director");
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
	     url : "mangerDirectorMapping.do?method=savemanagerDirectorMapping",
		data : {
			"directorId" : directorId,
			"employeeDetails" : myarray
		},
		success : function(response) {
			var result = response.replace(/"result":/g,	"").trim();
			
		if (result == '{"success"}') {
			$("#successdiv").show();
			 $('.error-box').css({'visibility': 'visible'});
			$("#spanid").text("Manager_Director Mapping Done Successfully");
			setTimeout("location.reload();", 2000);
		    	 
    	}else{
    		$("#errordiv").show();
    		$("#errordiv").text("Manager_Director  Mapping  Is Failed");
    		 $('.error-box').css({'visibility': 'visible'});
    			setTimeout("location.reload();", 2000);
		}
		}
	});

	}
}

function directorDetailMapping() {

	var directorVal = $("#director > option:selected").val();
	$("#copy").empty();
	if (directorVal != 0) {
		$.ajax({
			type : "POST",
		url : "mangerDirectorMapping.do?method=getMappedManagers",
			data : {"DirectorVal": directorVal},
			success : function(data) {
				var result= $.parseJSON(data);
				for ( var i = 0; i < result.mappedmanagers.length; i++) {
					
					$('#copy').append(
							'<option value="' + result.mappedmanagers[i].managerId
									+ '">' + result.mappedmanagers[i].managerName
									+ '</option>');
				}
			}
		});
	}
}


