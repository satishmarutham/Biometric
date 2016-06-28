$(document).ready(function() {
	
 // pick the time
	      
		$("#datetimepicker3").datetimepicker({
	          pickDate : false
		});
	
		$("#datetimepicker4").datetimepicker({
			pickDate : false
		});
	

});
function checkTime() {
  
	

	var ftime = document.getElementById("intime").value;

	var ttime = document.getElementById("outtime").value;
	
	if(ftime==0){
		$("#errordiv").text("please select the inTime");
		 return false;
     }else if(ttime==0){
    	 $("#errordiv").text("please select the OutTime");
    	 return false;
      }else{

	var ftimeSplitHour = ftime.split(':')[0];
	var ftimeSplitMin = ftime.split(':')[1];
	var ftimeSplitSec = ftime.split(':')[2];

	var ttimeSplitHour = ttime.split(':')[0];
	var ttimeSplitMin = ttime.split(':')[1];
	var ttimeSplitSec = ttime.split(':')[2];

	if (ftimeSplitHour.charAt(0) == 0) {
		ftimeSplitHour = ftimeSplitHour.charAt(1);
	}
	if (ttimeSplitHour.charAt(0) == 0) {
		ttimeSplitHour = ttimeSplitHour.charAt(1);
	}

	if (ftimeSplitMin.charAt(0) == 0) {
		ftimeSplitMin = ftimeSplitMin.charAt(1);
	}
	if (ttimeSplitMin.charAt(0) == 0) {
		ttimeSplitMin = ttimeSplitMin.charAt(1);
	}

	if (ftimeSplitSec.charAt(0) == 0) {
		ftimeSplitSec = ftimeSplitSec.charAt(1);
	}
	if (ttimeSplitSec.charAt(0) == 0) {
		ttimeSplitSec = ttimeSplitSec.charAt(1);
	}

	ftimeSplitHour = parseInt(ftimeSplitHour);
	ttimeSplitHour = parseInt(ttimeSplitHour);
	ftimeSplitMin = parseInt(ftimeSplitMin);
	ttimeSplitMin = parseInt(ttimeSplitMin);

	ftimeSplitSec = parseInt(ftimeSplitSec);
	ttimeSplitSec = parseInt(ttimeSplitSec);

	if (ftimeSplitHour > ttimeSplitHour) {
		$("#errordiv").text("The Out Time Should Not less than In Time");
		 document.getElementById("outtime").value = "";
		 return false;
	}
	if (ttimeSplitHour == ftimeSplitHour) {
		if (ftimeSplitMin > ttimeSplitMin) {
			$("#errordiv").text("The Out Time Should Not less than In Time");
			document.getElementById("outtime").value = "";
			 return false;
		}
		if (ftimeSplitMin == ttimeSplitMin) {
			if (ftimeSplitSec >= ttimeSplitSec) {
				$("#errordiv").text("The Out Time Should Not less than In Time");
				document.getElementById("outtime").value = "";
				 return false;
			}
		}
	}
	
     
    
	
	
	function toSeconds(time_str) {
	    // Extract hours, minutes and seconds
	    var parts = time_str.split(':');
	    // compute  and return total seconds
	    return parts[0] * 3600 + // an hour has 3600 seconds
	    parts[1] * 60 + // a minute has 60 seconds
	    +
	    parts[2]; // seconds
	}
 
   
   var inTime = document.getElementById("intime").value;
	var outTime = document.getElementById("outtime").value;
	
	var difference = Math.abs(toSeconds(inTime) - toSeconds(outTime));
    
	// format time differnece
	var result = [
	    Math.floor(difference / 3600), // an hour has 3600 seconds
	    Math.floor((difference % 3600) / 60), // a minute has 60 seconds
	    difference % 60
	];
	// 0 padding and concatation
	result = result.map(function(v) {
	    return v < 10 ? '0' + v : v;
	}).join(':');
	
	
    
	document.getElementById("totalhours").value = result;
    document.getElementById("workinghours").value = result;
    if(ftime==0){
		$("#errordiv").text("please select the inTime");
		 return false;
     }else if(ttime==0){
    	 $("#errordiv").text("please select the OutTime");
    	 return false;
    	 
    }
	 
    }

	
	
	
	
	 
}
 
function getTime() {
		
	   function toSeconds(time_str) {
		    // Extract hours, minutes and seconds
		    var parts = time_str.split(':');
		    // compute  and return total seconds
		    return parts[0] * 3600 + // an hour has 3600 seconds
		    parts[1] * 60 + // a minute has 60 seconds
		    +
		    parts[2]; // seconds
		}
	 
	   
	   var inTime = document.getElementById("intime").value;
		var outTime = document.getElementById("outtime").value;
		
		var difference = Math.abs(toSeconds(inTime) - toSeconds(outTime));
        
		// format time differnece
		var result = [
		    Math.floor(difference / 3600), // an hour has 3600 seconds
		    Math.floor((difference % 3600) / 60), // a minute has 60 seconds
		    difference % 60
		];
		// 0 padding and concatation
		result = result.map(function(v) {
		    return v < 10 ? '0' + v : v;
		}).join(':');
		
		
	    
 	document.getElementById("totalhours").value = result;
	document.getElementById("workinghours").value = result;
 	 
 	 
}
