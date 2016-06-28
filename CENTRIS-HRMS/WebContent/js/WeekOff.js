/**
 * 
 */


$(document).ready(function(){
	
	$("#emp").attr("placeholder","Type Employee Name");
	

	function log( message ) {
		$( "<div>" ).text( message ).prependTo( "#log" );
		$( "#log" ).scrollTop( 0 );
	}

	$( "#emp" ).autocomplete({
		
		source: function( request, response ) {
			$.ajax({
				url: "weekoff.do?parameter=getEmployeeNames",
				dataType: "json",
				data: {
					featureClass: "P",
					style: "full",
					maxRows: 12,
					name_startsWith: request.term
				},
				success: function( data ) {
//					alert(data.list1[0].empname);
					response( $.map( data.list1, function( item ) {
						return {
							label: item.empname,
							value: item.empname,
							id : item.email+"("+item.phone+"("+item.shiftname+"("+item.deptname+"("+item.emplocation+"("+item.empid
						}
					}));
				}
				
			});
		},
		minLength: 1,
		select: function( event, ui ) {
			var vals = ui.item.id.split("(");
//			alert(ui.item.id);
//			alert(vals);
			     $("#name").val(ui.item.label);
				$("#email").val(vals[0]);
				$("#shift").val(vals[2]);
				$("#dept").val(vals[3]);
				$("#location").val(vals[4]);
				
			$("#empid1").val(vals[5]);
			$("#empid").val(vals[5]);
			$.ajax({
				url: "weekoff.do?parameter=getEmployeeWeekOffs",
				dataType: "json",
				data: {
					maxRows: 12,
					empid: vals[5]
				},
				
				success: function( data ) {
					var sun = data.sun;
					if(sun == 1){
						$("#sunday").attr("checked",true);
					}else{
						$("#sunday").attr("checked",false);
					}
					
					var mon = data.mon;
					if(mon == 1){
						$("#monday").attr("checked",true);
					}else{
						$("#monday").attr("checked",false);
					}
					
					var tue = data.tue;
					if(tue == 1){
						$("#tuesday").attr("checked",true);
					}else{
						$("#tuesday").attr("checked",false);
					}
					
					var wed = data.wed;
					if(wed == 1){
						$("#wednesday").attr("checked",true);
					}else{
						$("#wednesday").attr("checked",false);
					}
					
					var thu = data.thu;
					if(thu == 1){
						$("#thursday").attr("checked",true);
					}else{
						$("#thursday").attr("checked",false);
					}
					
					var fri = data.fri;
					if(fri == 1){
						$("#friday").attr("checked",true);
					}else{
						$("#friday").attr("checked",false);
					}
					
					var sat = data.sat;
					if(sat == 1){
						$("#saturday").attr("checked",true);
					}else{
						$("#saturday").attr("checked",false);
					}
				}
				
			});
			
			log( ui.item ?
				"Selected: " + ui.item.id :
				"Nothing selected, input was " + this.value);
		},
	
		open: function() {
			$( this ).removeClass( "ui-corner-all" ).addClass( "ui-corner-top" );
		},
		close: function() {
			$( this ).removeClass( "ui-corner-top" ).addClass( "ui-corner-all" );
		}
	});
	
	
//	alert("JQUERY Ended ");
});




function validateForm(){
	var emp= $("#emp").val();
	var empID = $("#empid").val();
	
	
	/*alert(emp+"-"+empID+"-"+empID1+"-"+name+"-");*/
	
	if(emp=="" || empID==""){
		
		$("#errordiv").text("Type Employee Name");
		$('.error-box').css({'visibility': 'visible'});
		$("#error1").hide();
		return false;
	}else{
		return true;
	}
	
}