
function activeRecords(val){
	
	var id=val.id;
	var empdetails=id.split(",");
	var empid={"id":empdetails[0]};
	
	 var x = confirm("Are you sure you want to Activate this Employee");
	  if (x){
		  
		  checkDseCount(empdetails[1],empdetails[2]);
		  
		if(DseCount){
			
			
		}else{
			
		
			$.ajax({
		
		type : "GET",
		url  : "AddEmployee.do?parameter=activateEmployee",
		data : empid,
		async: false,
		
		success : function(data){
			
			var result = $.parseJSON(data);
			
			
			window.location="GetDetails.do?parameter=listofDeactiveEmployee&status="+result.status;
	
		}
		
	});
}

 }
	
	
}

$(document)
.ready(
		function() {
			$('.locationid').hide();
			
			
		});

var DseCount=false;
function checkDseCount(locationid,desid){
	
	
	if(locationid != "" && desid != ""){
		
		var dsedata={"locationid":locationid,"desid":desid};
		
		
		$.ajax({

			type : "GET",
			url : "AddEmployee.do?parameter=checkDseCount",
			data : dsedata,
			async : false,
			success : function(response) {
				var result = $.parseJSON(response);
				
			
				if(result.status!="false"){
					
					
					DseCount=true;
					
					$('.error-box').css({
						'visibility' : 'visible'
					});
					$("#errordiv").text(result.status);
				
				}else{
					
					DseCount=false;
					
					
				}
				

			}
		});
		
	}
	
	
	
	
}