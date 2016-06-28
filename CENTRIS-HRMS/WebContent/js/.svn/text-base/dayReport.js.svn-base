function disableField(val) {
	if (val == 'all') {
		var x = document.forms["ReportForm"]["shiftid"].value;
		$("#empid").attr("disabled", false);
		
		var str = $("#shiftid").val();
		showState(str);

	} else {
	
		var str = $("#shiftid").val();
		var dept = $("#empdepartment").val();
		showNames(str,dept);
	}

}
function showNames(str,dept) {
	var xmlhttp;
	/*alert(str);
	alert(dept);*/
	if (str == "") {
		document.getElementById("txtHint").innerHTML = "";
		return;
	}
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			document.getElementById("txtHint").innerHTML = xmlhttp.responseText;
		}
	}
	var parameters="empdepartment="+dept;
	xmlhttp.open("GET", "empinfo.do?shiftid=" + str+"&empdepartment="+dept, true);
	xmlhttp.send(parameters);
}