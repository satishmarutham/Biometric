$(document)
		.ready(
				function() {
					
				//	var projectcode	=$('#hiddenproject').val();
				
				/*	if(projectcode ==""){
						$("#details").hide();
					}else{
						$("#details").show();
					}*/
					
					
				
					
					
							
				var month_val	=$('#hiddenmonth').val();
				var yearval =  $('#hiddenyear').val();
				
				if(yearval=="" && month_val==""){
					
					$("#details").hide();
				}else{
					
					$("#details").show();
				}
				
				
		//		var projectRefCode=$("#hiddenprojectRef").val();
				
				//getProjectDetails($("#h_MangId").val().trim(),projectcode);
					
		
				$("#month option[value=" + month_val + "]").attr('selected', 'true');
				$("#year option[value=" + yearval + "]").attr('selected', 'true');
			
			//	$("#projectRefCode").text(projectRefCode);
					
				var name1 = $("#h_Name").val().trim();
					var name2 = $("#h_BioId").val().trim();
					$("#emp_Name").text(name1 + " / " + name2);
					$("#emp_ManName").text($("#h_ManagName").val().trim());
					$("#emp_DesName").text($("#h_Desig").val().trim());
					$("#emp_Num").text($("#h_Cont").val().trim());
					$("#emp_Mail").text($("#h_Email").val().trim());

					$('.accBody').css('display', 'none');
					$('.accBody:first').css('display', 'block');

					$('.accordHead').click(function() {
						var displaypro = $(this).next('div').css('display');
						if (displaypro == 'none') {
							$(this).next('div').css({
								'display' : 'block'
							});
						} else {
							$(this).next('div').css({
								'display' : 'none'
							});
						}
						$('div .accordHead:last-child', this).hide();
					});
					/*$('.projectId')
							.change(
									function() {
										if (($("#year").val().trim() != '')
												&& ($("#month").val().trim() != '')
												&& ($("#projectId").val()
														.trim() != '')) {
											var act_Month = $(
													"#month option:selected")
													.text()
													+ " - "
													+ $("#year option:selected")
															.text();
											var jsonData = {
												'sel_Year' : $("#year").val()
														.trim(),
												'sel_Month' : $("#month").val()
														.trim(),
												'sel_Project' : $("#projectId")
														.val().trim()
											};
											$
													.ajax({
														method : 'POST',
														url : 'empExpenseDetails.do?method=checkEmployeeExpense',
														data : jsonData,
														success : function(data) {
															var result = $
																	.parseJSON(data);
															
															document.location.href="empExpenseDetails.do?method=getEmployeeExpenses&expensecode="+result.expense_Result
													    	+"&projectcode="+$('.projectId').val()
													    	+"&monthval="+$('.month_val').val()
													    	+"&yearval="+$('.year_val').val()
													    	+"&projectRefcode="+$("#projectRefCode").text();
														}
													});
										}
									});*/
					$('.month_val')
							.change(
									function() {
										if (($("#year").val().trim() != '')
												&& ($("#month").val().trim() != '')) {
										
											var act_Month = $(
													"#month option:selected")
													.text()
													+ " - "
													+ $("#year option:selected")
															.text();
											var jsonData = {
												'sel_Year' : $("#year").val()
														.trim(),
												'sel_Month' : $("#month").val()
														.trim()
												
											};
											$
													.ajax({
														method : 'POST',
														url : 'empExpenseDetails.do?method=checkEmployeeExpense',
														data : jsonData,
														success : function(data) {
															var result = $
																	.parseJSON(data);
															
																document.location.href="empExpenseDetails.do?method=getEmployeeExpenses&expensecode="+result.expense_Result
															       	+"&monthval="+$('.month_val').val()
															    	+"&yearval="+$('.year_val').val();
														
														
														}
													});
										}
									});
					$('.year_val')
							.change(
									function() {
										if (($("#year").val().trim() != '')
												&& ($("#month").val().trim() != '')
												) {
											var jsonData = {
												'sel_Year' : $("#year").val()
														.trim(),
												'sel_Month' : $("#month").val()
														.trim()
												
											};
											$
													.ajax({
														method : 'POST',
														url : 'empExpenseDetails.do?method=checkEmployeeExpense',
														data : jsonData,
														success : function(data) {
															var result = $
																	.parseJSON(data);
															
															document.location.href="empExpenseDetails.do?method=getEmployeeExpenses&expensecode="+result.expense_Result
													       	+"&monthval="+$('.month_val').val()
													    	+"&yearval="+$('.year_val').val()
													    	;
													
														}
													});
										}
									});
			
				
				
				});




function getDate() {

	var max_Date;
	var mdate = new Date();
	var current_year = mdate.getFullYear();
	var current_month = mdate.getMonth();
	var current_day = mdate.getDate();
	current_month = current_month + 1;

	var maxDay = daysInMonth();

	var min_Date = getPerfectDate('01');
	
	if (($('#year').val() == current_year)
			&& ($('#month').val() == current_month)) {
		max_Date = getPerfectDate(current_day);
	} else {
		max_Date = getPerfectDate(maxDay);
	}
		
	var selectedmnthcnt=$('#month').val();
	
	if (($('#year').val() == current_year)  && (parseInt(selectedmnthcnt) <= parseInt(current_month))) {

		$("input[class=mydate]").datepicker({
			dateFormat : "dd-mm-yy",
			defaultDate : "+1w",
			minDate : min_Date,
			maxDate : max_Date,
			changeYear : true,
			changeMonth : true,
			numberOfMonths : 1
		});
		return true;
	} else {
		alert("You can update your Expense Details for current and past  months only");
		return false;
	}
}
function daysInMonth() {
	return new Date($('#year').val(), $('#month').val(), 0).getDate();
}

function getPerfectDate(day) {
	return day + '-' + $('#month').val() + '-' + $('#year').val();
}
function confirmMessage(message) {
	var r = confirm(message);
	return r;
}

function finalTotal() {
	var sum = 0;
	$(".local_amount").each(function() {
		if (!isNaN(this.value) && this.value.length != 0) {
			sum += parseFloat(this.value);
		}
	});
	$(".travel_amount").each(function() {
		if (!isNaN(this.value) && this.value.length != 0) {
			sum += parseFloat(this.value);
		}
	});
	$(".staff_amount").each(function() {
		if (!isNaN(this.value) && this.value.length != 0) {
			sum += parseFloat(this.value);
		}
	});
	$(".telephone_amount").each(function() {
		if (!isNaN(this.value) && this.value.length != 0) {
			sum += parseFloat(this.value);
		}
	});
	$(".purchase_amount").each(function() {
		if (!isNaN(this.value) && this.value.length != 0) {
			sum += parseFloat(this.value);
		}
	});
	$(".other_amount").each(function() {
		if (!isNaN(this.value) && this.value.length != 0) {
			sum += parseFloat(this.value);
		}
	});
	$(".miscellaneous_amount").each(function() {
		if (!isNaN(this.value) && this.value.length != 0) {
			sum += parseFloat(this.value);
		}
	});
	$("#finalTotal").val(sum.toFixed(2));
}
function getLocalTotal() {
	var sum = 0;
	$(".local_amount").each(function() {
		if (!isNaN(this.value) && this.value.length != 0) {
			sum += parseFloat(this.value);
		}
	});
	$("#local_totalAmount").val(sum.toFixed(2));
	finalTotal();
}

function getTravelTotal() {
	var sum = 0;
	$(".travel_amount").each(function() {
		if (!isNaN(this.value) && this.value.length != 0) {
			sum += parseFloat(this.value);
		}
	});
	$("#travel_totalAmount").val(sum.toFixed(2));
	finalTotal();
}
function getStaffTotal() {
	var sum = 0;
	$(".staff_amount").each(function() {
		if (!isNaN(this.value) && this.value.length != 0) {
			sum += parseFloat(this.value);
		}
	});
	$("#staff_totalAmount").val(sum.toFixed(2));
	finalTotal();
}
function getTelephoneTotal() {
	var sum = 0;
	$(".telephone_amount").each(function() {
		if (!isNaN(this.value) && this.value.length != 0) {
			sum += parseFloat(this.value);
		}
	});
	$("#telephone_totalAmount").val(sum.toFixed(2));
	finalTotal();
}
function getPurchaseTotal() {
	var sum = 0;
	$(".purchase_amount").each(function() {
		if (!isNaN(this.value) && this.value.length != 0) {
			sum += parseFloat(this.value);
		}
	});
	$("#purchase_totalAmount").val(sum.toFixed(2));
	finalTotal();
}
function getOtherTotal() {
	var sum = 0;
	$(".other_amount").each(function() {
		if (!isNaN(this.value) && this.value.length != 0) {
			sum += parseFloat(this.value);
		}
	});
	$("#other_totalAmount").val(sum.toFixed(2));
	finalTotal();
}
function getMiscellaneousTotal() {
	var sum = 0;
	$(".miscellaneous_amount").each(function() {
		if (!isNaN(this.value) && this.value.length != 0) {
			sum += parseFloat(this.value);
		}
	});
	$("#miscellaneous_totalAmount").val(sum.toFixed(2));
	finalTotal();
}

function removeLocal(removeNum) {

	jQuery('#localId' + removeNum).remove();
	getLocalTotal();
	finalTotal();
}
function removeTravel(removeNum) {
	jQuery('#travelId' + removeNum).remove();
	getTravelTotal();
	finalTotal();
}
function removeStaff(removeNum) {
	jQuery('#staffId' + removeNum).remove();
	getStaffTotal();
	finalTotal();
}
function removeTelephone(removeNum) {
	jQuery('#telephone' + removeNum).remove();
	getTelephoneTotal();
	finalTotal();
}
function removePurchase(removeNum) {
	jQuery('#purchase' + removeNum).remove();
	getPurchaseTotal();
	finalTotal();
}
function removeOther(removeNum) {
	jQuery('#other' + removeNum).remove();
	getOtherTotal();
	finalTotal();
}
function removeMiscellaneous(removeNum) {
	jQuery('#miscellaneous' + removeNum).remove();
	getMiscellaneousTotal();
	finalTotal();
}

var rowLocal = 0;
var rowTravel = 0;
var rowStaff = 0;
var rowTele = 0;
var rowPurchase = 0;
var rowOther = 0;
var rowMiscellaneous = 0;
function addMoreLocal(frm) {
	rowLocal++;
	$('#local tr')
			.last()
			.after(
					'<tr id="localId'
							+ rowLocal
						+ '"><td><input name="local_con_Date"  onclick="return getDate();" class="mydate"  placeholder="Click here" type="text" readonly="readonly" size="17%"  maxlength="25" /></td><td><input name="local_location" type="text"  maxlength="25" /></td><td><input name="local_from" type="text" maxlength="25" /></td><td><input name="local_to" type="text" maxlength="25" /></td><td><input name="local_remarks" type="text" maxlength="25" /></td><td><input name="local_mode" type="text" maxlength="25" /></td><td ><input name="local_amount" type="text" class="local_amount" onkeyup="return getLocalTotal()" maxlength="10" /></td><td> <a href="javascript:void(0);" style="font: normal 12px Segoe UI;" onclick="removeLocal('
							+ rowLocal + ');">Delete</a></td><td><input type="hidden" name="localsno" /></td></tr>');
}
function addMoreTravel(frm) {
	rowTravel++;
	$('#travel tr')
			.last()
			.after(
					'<tr id="travelId'
							+ rowTravel
							+ '"><td><input name="travel_con_Date"  onclick="return getDate();" class="mydate"  placeholder="Click here" type="text" readonly="readonly" size="17%"  maxlength="25" /></td><td><input name="travel_location" type="text"  maxlength="25" /></td><td><input name="travel_from" type="text" maxlength="25" /></td><td><input name="travel_to" type="text" maxlength="25" /></td><td><input name="travel_remarks" type="text" maxlength="25" /></td><td><input name="travel_mode" type="text" maxlength="25" /></td><td ><input name="travel_amount" type="text" class="travel_amount" onkeyup="return getTravelTotal()" maxlength="10" /></td><td> <a href="javascript:void(0);" style="font: normal 12px Segoe UI;" onclick="removeTravel('
							+ rowTravel + ');">Delete</a></td><td><input type="hidden" name="travelsno" /></td></tr>');
}
function addMoreStaff(frm) {
	rowStaff++;
	$('#staff tr')
			.last()
			.after(
					'<tr id="staffId'
							+ rowStaff
							+ '"><td><input name="staff_location" type="text"  maxlength="25" /></td><td><input name="staff_from_Date"  onclick="return getDate();" class="mydate"  placeholder="Click here" type="text" readonly="readonly" size="17%"  maxlength="25" /></td><td><input name="staff_to_Date"  onclick="return getDate();" class="mydate"  placeholder="Click here" type="text" readonly="readonly" size="17%"  maxlength="25" /></td><td><input name="staff_noOfDays" type="text" maxlength="25" /></td><td><input name="staff_singleOrTeam" type="text" maxlength="25" /></td><td><input name="staff_allowance" type="text" maxlength="25" /></td><td ><input name="staff_amount" type="text" class="staff_amount" onkeyup="return getStaffTotal()" maxlength="10" /></td><td> <a href="javascript:void(0);" style="font: normal 12px Segoe UI;" onclick="removeStaff('
							+ rowStaff + ');">Delete</a></td><td><input type="hidden" name="staffsno" /></td></tr>');
}
function addMorePhone(frm) {
	rowTele++;
	$('#telephone tr')
			.last()
			.after(
					'<tr id="telephone'
							+ rowTele
							+ '"><td><input name="telephone_Date"  onclick="return getDate();" class="mydate" placeholder="Click here" type="text" readonly="readonly" size="20%"  maxlength="25" /></td><td><input name="telephone_phone" type="text" maxlength="10" /></td><td><input name="telephone_location" type="text"  maxlength="25" /></td><td ><input name="telephone_amount" type="text" class="telephone_amount" onkeyup="return getTelephoneTotal()" maxlength="10" /></td><td> <a href="javascript:void(0);" style="font: normal 12px Segoe UI;" onclick="removeTelephone('
							+ rowTele + ');">Delete</a></td><td><input type="hidden" name="telephonesno" /></td></tr>');
}
function addMorePurchases(frm) {
	rowPurchase++;
	$('#purchase tr')
			.last()
			.after(
					'<tr id="purchase'
							+ rowPurchase
							+ '"><td><input name="purchase_Date"  onclick="return getDate();" class="mydate" placeholder="Click here" type="text" readonly="readonly" size="20%"  maxlength="25" /></td><td><input name="purchase_billno" type="text" maxlength="25" /></td><td><input name="purchase_particular" type="text"  maxlength="25" /></td><td ><input name="purchase_amount" type="text" class="purchase_amount" onkeyup="return getPurchaseTotal()" maxlength="10" /></td><td> <a href="javascript:void(0);" style="font: normal 12px Segoe UI;" onclick="removePurchase('
							+ rowPurchase + ');">Delete</a></td><td><input type="hidden" name="purchasesno" /></td></tr>');
}
function addMoreOther(frm) {
	rowOther++;
	$('#other tr')
			.last()
			.after(
					'<tr id="other'
							+ rowOther
							+ '"><td><input name="other_Date"  onclick="return getDate();" class="mydate" placeholder="Click here" type="text" readonly="readonly" size="20%"  maxlength="25" /></td><td><input name="other_description" type="text"  maxlength="25" /></td><td ><input name="other_amount" type="text" class="other_amount" onkeyup="return getOtherTotal()" maxlength="10" /></td><td> <a href="javascript:void(0);" style="font: normal 12px Segoe UI;" onclick="removeOther('
							+ rowOther + ');">Delete</a></td><td><input type="hidden" name="otherworksno" /></td></tr>');
}
function addMoreMiscellaneous(frm) {
	rowMiscellaneous++;
	$('#miscellaneous tr')
			.last()
			.after(
					'<tr id="miscellaneous'
							+ rowMiscellaneous
							+ '"><td><input name="miscellaneous_Date"  onclick="return getDate();" class="mydate" placeholder="Click here" type="text" readonly="readonly" size="20%"  maxlength="25" /></td><td><input name="miscellaneous_description" type="text"  maxlength="25" /></td><td ><input name="miscellaneous_amount" type="text" class="miscellaneous_amount" onkeyup="return getMiscellaneousTotal()" maxlength="10" /></td><td> <a href="javascript:void(0);" style="font: normal 12px Segoe UI;" onclick="removeMiscellaneous('
							+ rowMiscellaneous + ');">Delete</a></td><td><input type="hidden" name="miscellaneoussno" /></td></tr>');
}

/*function getProjectDetails(ManagerId,projectVal) {
	datalist = {
		"managerIdVal" : ManagerId
	}, $.ajax({
		type : 'POST',
		url : "employeeMenu.do?parameter=getProjectDetails",
		data : datalist,
	
		success : function(response) {
			var result = $.parseJSON(response);
			$("#projectId").html("");
			$("#projectId").append(
					'<option value="' + "" + '">' + "-----Select-----"
							+ '</option>');
			for ( var j = 0; j < result.projectDetails.length; j++) {
				
				if(projectVal==result.projectDetails[j].emp_ProjectId){
				
					$("#projectId").append(
							'<option value="'
									+ result.projectDetails[j].emp_ProjectId + '">'
									+ result.projectDetails[j].emp_ProjectName
									+ '</option>');
					$("#projectId option[value= '" + projectVal.trim() + "']").attr('selected', 'true');	
				
				}else{
					$("#projectId").append(
							'<option value="'
									+ result.projectDetails[j].emp_ProjectId + '">'
									+ result.projectDetails[j].emp_ProjectName
									+ '</option>');
				}
				
					
				
				
			}
		}
	});
}*/