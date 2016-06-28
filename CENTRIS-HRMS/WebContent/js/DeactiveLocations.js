function activeRecords(val){
	
	var locationname=val.id;
	var locname={"locationname":locationname};
	
	 var x = confirm("Are you sure you want to Activate this Location");
	  if (x){
	
$.ajax({
		
		type : "GET",
		url  : "location.do?parameter=activatelocations",
		data : locname,
		async: false,
		
		success : function(data){
			
			var result = $.parseJSON(data);
			window.location="location.do?parameter=deactiveLocations&status="+result.locationstatus;
	
		}
		
	});
}
	
}

function goback(){
	
	window.location="location.do?parameter=addlocation";
	
	
}