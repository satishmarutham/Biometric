$(function() {
	$("#errordiv").hide();
	$.ajax({
		      type : "POST",
				url : "grouplocationmap.do?parameter=getLocation",
				success : function(response) {
					var result = $.parseJSON(response);
					var original = $("#original");
				
					for ( var j = 0; j < result.locationlist.length; j++) {

						$(original)
								.append(
										'<option value="'
												+ result.locationlist[j].locationId
												+ '">'
												+ result.locationlist[j].locationName
												+ '</option>');
					}
				}
			});
	$.ajax({
		type : "POST",
		url : "grouplocationmap.do?parameter=getGroup",
		success : function(response) {
			
			var result = $.parseJSON(response);

			var group = $("#group");

			for ( var j = 0; j < result.grouplist.length; j++) {

				$(group).append(
						'<option value="' + result.grouplist[j].groupId + '">'
								+ result.grouplist[j].groupName + '</option>');
			}
		}
	});	
	$("#group").change(function() {
		groupDetailMapping();
	});
	
});

function assign() {
	$("#errordiv").show();
	var groupId = $("#group").val();

	if (groupId == "") {
		$("#errordiv").show();
		$("#errordiv").text("Select Any Group");
		 $('.error-box').css({'visibility': 'visible'});
		return false;
	}
	var updaterowsArray = new Array();
	for ( var i = 0; i < copy.options.length; i++) {
		updaterowsArray.push(copy.options[i].value);
		copy.options[i].value = "";
	}

	var myarray = JSON.stringify(updaterowsArray);
	$.ajax({

	   type: "POST",
		url : "grouplocationmap.do?parameter=saveGroupLocationMapping",
		data : {
			"groupId" : groupId,
			"locDetails" : myarray
		},
		success : function(response) {
			var result = response.replace(/"result":/g,	"").trim();
		if (result == '{"success"}') {
			$("#spanid").text("Group Location Mapping Done Successfully");
			setTimeout("location.reload();", 2000);
		    	 
    	}else{
    		$("#errordiv").show();
    		$("#errordiv").text("Group Location Mapping  Is Failed");
    		 $('.error-box').css({'visibility': 'visible'});
    			setTimeout("location.reload();", 2000);
		}
		}
	});
}

function groupDetailMapping() {

	var groupVal = $("#group > option:selected").val();
	$("#copy").empty();
	if (groupVal != 0) {
		$.ajax({
			type : "POST",
			url : "grouplocationmap.do?parameter=getMappedLoc",
			data : {"groupVal": groupVal},
			success : function(data) {
				var result= $.parseJSON(data);
				for ( var i = 0; i < result.mappedlocationlist.length; i++) {
					$('#copy').append(
							'<option value="' + result.mappedlocationlist[i].locationId
									+ '">' + result.mappedlocationlist[i].locationName
									+ '</option>');
				}
			}
		});
	}
}