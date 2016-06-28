function validate() {

	var locationname = $('#searchlocation').val();

	if ( locationname == "" || locationname == null) {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Type Location Name or ID");

		return false;
	} else {

		return true;
	}

}
function validationUpdate() {

	var machinenumber=$('#machinenumber').val().trim();
	var locationnumber=$('#locationnomber').val().trim();
	var locationname=$('#locationname').val().trim();
	var propritername=$('#propritername').val().trim();
	var mobilenumber=$('#mobilenumber').val().trim();
	var companyname=$('#companyname').val().trim();
	var propriteraddress=$('#propriteraddresss').val().trim();
	var locationid=$('#locationid').val().trim();
	var bioidindexnumber=$('#bioidindexnumber').val().trim();
	var tsmname=$('#tsmname').val().trim;
	var contactnumber=$('#contactnumber').val().trim();
	var employeeStrength=$('#empstrength').val().trim();
	
	 var mob = /^[1-9]{1}[0-9]{9}$/;
	 var regexpforInteger=/^([0-9])+$/;


	if(locationid=="" || locationid==null){
		
		$('.error-box').css({'visibility': 'visible'});
		$("#errordiv").text("Select One Location to Update");
		
		return false;
		
	}else 


		if(machinenumber=="" || machinenumber==null ){
			
			
			$('.error-box').css({'visibility': 'visible'});
			$("#errordiv").text("Machine Number Should not be Empty");
			
			return false;
			
		}else if(locationnumber=="" || locationnumber==null ){
			
			
			$('.error-box').css({'visibility': 'visible'});
			$("#errordiv").text("SCD Code Should not be Empty");
			
			return false;
			
		}else if(bioidindexnumber==""||bioidindexnumber==null){
			
			
			$('.error-box').css({'visibility': 'visible'});
			$("#errordiv").text("Bio ID Index Number Should not Empty");
		
			
			return false;
			
		}else if( !( regexpforInteger.test(bioidindexnumber) ) ){
			
			
			$('.error-box').css({'visibility': 'visible'});
			$("#errordiv").text("Bio ID Index Number Should Accept only Integers");
		
			
			return false;
			
		}else if( bioidindexnumber.length<3 ){
			
			
			$('.error-box').css({'visibility': 'visible'});
			$("#errordiv").text("Bio ID Index Number length Should be minimum 3");
		
			
			return false;
			
		}
		else if(locationname=="" || locationname==null ){
			
			
			$('.error-box').css({'visibility': 'visible'});
			$("#errordiv").text("Location Name Should not be Empty");
			
			return false;
			
		}else if(tsmname=="" || tsmname==null ){
			
			
			$('.error-box').css({'visibility': 'visible'});
			$("#errordiv").text("TSM / TSE Same Should not be Empty");
			
			return false;
			
		}else if(propritername=="" || propritername==null ){
			
			
			$('.error-box').css({'visibility': 'visible'});
			$("#errordiv").text("Propriter / Distributor name Should not be Empty");
			
			return false;
			
		}else if(mobilenumber=="" || mobilenumber==null ){
			
			
			$('.error-box').css({'visibility': 'visible'});
			$("#errordiv").text("Distributer Number Should not be Empty");
			
			return false;
			
		}else if(mob.test(mobilenumber) == false){
			
			$('.error-box').css({'visibility': 'visible'});
			$("#errordiv").text("Invalid Distributer Number");
		
			
			return false;
			
		}else if(companyname=="" || companyname==null ){
			
			
			$('.error-box').css({'visibility': 'visible'});
			$("#errordiv").text("Contact Person Should not be Empty");
			
			return false;
			
		}else if(contactnumber==""|| contactnumber==null){
			
			
			
			$('.error-box').css({'visibility': 'visible'});
			$("#errordiv").text("Contact Person Number Should not be Empty");
			
			return false;
			
		}else if(mob.test(contactnumber) == false){
			
			$('.error-box').css({'visibility': 'visible'});
			$("#errordiv").text("Invalid Contact Number");
		
			
			return false;
			
		}else if(employeeStrength=="" || employeeStrength==null ){
			
			$('.error-box').css({'visibility': 'visible'});
			$("#errordiv").text("Employee Strength Should not be Empty");
		
		
			
			return false;
			
		}else if(regexpforInteger.test(employeeStrength) == false){
			
			$('.error-box').css({'visibility': 'visible'});
			$("#errordiv").text("Employee Strength Should be Integers");
		
			
			return false;
			
		}
		
		else if(propriteraddress=="" || propriteraddress==null ){
			
			$('.error-box').css({'visibility': 'visible'});
			$("#errordiv").text("Propriter / Distributor Address Should not be Empty");
		
		
			
			return false;
			
		}else if(propriteraddress.length>250){
			
			$('.error-box').css({'visibility': 'visible'});
			$("#errordiv").text("Propriter / Distributor Address not more than 250");
		

			
			return false;
			
		}else{
	
			 if(validateMachinenumberUpdate()==1){
				
				$('.error-box').css({'visibility': 'visible'});
				$("#errordiv").text("Machine Number Already Exist");
				
				
				return false;
				
				
			}else if(validateLocationNumberUpdate()==1){
				
				$('.error-box').css({'visibility': 'visible'});
				$("#errordiv").text("SCD code Already Exist");
				
				
				return false;
			}else if(checkbioindexnumberUpdate()==1){
				
				$('.error-box').css({'visibility': 'visible'});
				$("#errordiv").text("Bio ID Index Number Already Exist");
				
				
				return false;
			}else
		if(validateLocationNameUpdate1()==1){
			
			$('.error-box').css({'visibility': 'visible'});
			$("#errordiv").text("Location Name Already Exist");
			
			
			return false;
			
		}
		
		else{
		return true;
		}
	}
}
var locname1=0;
var checkmachineno=0;
var cheklocationnumber=0;
var checkbioidindex=0;

var locnameupdate1=0;
var checkmachinenoupdate=0;
var cheklocationnumberupdate=0;
var checkbioindexupdate=0;



function validateLocationName1(){
	

	
	var locationname=$('#locationname').val();
	
	var locationid=$('#locationid').val();
	 var locName={"locationname":locationname,"locationid":locationid};
	 
	 
	

	$.ajax({
		type : "GET",
		url  : "location.do?parameter=validateLocationName",
		data : locName,
		async:false,

		success : function(data) {
			
			var result = $.parseJSON(data);
			
			
			if(result.count>0){
				
				locname1=1;
				$('.error-box').css({'visibility': 'visible'});
				$("#errordiv").text("Location Name Already Exist");
				
				
			}else{
				
				locname1=0;
			}
			
			
			}
	});
	
	return locname1;

}


function validateLocationNameUpdate1(){
	

	
	var locationname=$('#locationname').val();
	
	var locationid=$('#locationid').val();
	 var locName={"locationname":locationname,"locationid":locationid};
	 
	 
	

	$.ajax({
		type : "GET",
		url  : "location.do?parameter=validateLocationNameUpdate",
		data : locName,
		async:false,

		success : function(data) {
			
			var result = $.parseJSON(data);
			
			
			if(result.count>0){
				
				locnameupdate1=1;
				$('.error-box').css({'visibility': 'visible'});
				$("#errordiv").text("Location Name Already Exist");
				
				
			}else{
				
				locnameupdate1=0;
			}
			
			
			}
	});
	
	return locnameupdate1;

}

function validateMachinenumber(){
	

	
	var machinenumber=$('#machinenumber').val().trim();
	var locationid=$('#locationid').val();

	 var machineno={"machinenumber":machinenumber,"locationid":locationid};
	 

	$.ajax({
		type : "GET",
		url  : "location.do?parameter=validateMachineNumber",
		data : machineno,
		async:false,

		success : function(data) {
			
			var result = $.parseJSON(data);
			
			
			if(result.count>0){
				
				checkmachineno=1;
				$('.error-box').css({'visibility': 'visible'});
				$("#errordiv").text("Machine Number Already Exist");
				
				
			}else{
				
				checkmachineno=0;
			}
			
			
			}
	});
	
	return checkmachineno;

}

function validateMachinenumberUpdate(){
	

	
	var machinenumber=$('#machinenumber').val().trim();
	var locationid=$('#locationid').val();

	 var machineno={"machinenumber":machinenumber,"locationid":locationid};
	 

	$.ajax({
		type : "GET",
		url  : "location.do?parameter=validateMachineNumberUpdate",
		data : machineno,
		async:false,

		success : function(data) {
			
			var result = $.parseJSON(data);
			
			
			if(result.count>0){
				
				checkmachinenoupdate=1;
				$('.error-box').css({'visibility': 'visible'});
				$("#errordiv").text("Machine Number Already Exist");
				
				
			}else{
				
				checkmachinenoupdate=0;
			}
			
			
			}
	});
	
	return checkmachinenoupdate;

}

function validateLocationNumber(){
	

	
	var locationnumber=$('#locationnomber').val().trim();
	
	var locationid=$('#locationid').val();
	 var locationno={"locationnumber":locationnumber,"locationid":locationid};
	 
	

	$.ajax({
		type : "GET",
		url  : "location.do?parameter=validateLocationNumber",
		data : locationno,
		async:false,

		success : function(data) {
			
			var result = $.parseJSON(data);
			
			if(result.count>0){
				
				cheklocationnumber=1;
				$('.error-box').css({'visibility': 'visible'});
				$("#errordiv").text("SCD code Already Exist");
				
				
			}else{
				
				cheklocationnumber=0;
			}
			
			
			}
	});
	
	return cheklocationnumber;

}

function validateLocationNumberUpdate(){
	

	
	var locationnumber=$('#locationnomber').val().trim();
	
	var locationid=$('#locationid').val();
	 var locationno={"locationnumber":locationnumber,"locationid":locationid};
	 
	

	$.ajax({
		type : "GET",
		url  : "location.do?parameter=validateLocationNumberUpdate",
		data : locationno,
		async:false,

		success : function(data) {
			
			var result = $.parseJSON(data);
			
			if(result.count>0){
				
				cheklocationnumberupdate=1;
				$('.error-box').css({'visibility': 'visible'});
				$("#errordiv").text("SCD Code Already Exist");
				
				
			}else{
				
				cheklocationnumberupdate=0;
			}
			
			}
	
	});
	
	return cheklocationnumberupdate;

}
function checkbioindexnumberUpdate(){
	
	var bioidindexnumber=$('#bioidindexnumber').val().trim();
	
	var locationid=$('#locationid').val();
	 var locationno={"bioidindexnumber":bioidindexnumber,"locationid":locationid};
	 
	

	$.ajax({
		type : "GET",
		url  : "location.do?parameter=validateBioIdIndexUpdate",
		data : locationno,
		async:false,

		success : function(data) {
			
			var result = $.parseJSON(data);
			
			
			if(result.count>0){
				
				checkbioindexupdate=1;
				$('.error-box').css({'visibility': 'visible'});
				$("#errordiv").text("Bio ID Index Number Already Exist");
				
				
			}else{
				
				checkbioindexupdate=0;
			}
			
			}
	
	});
	
	return checkbioindexupdate;


}
