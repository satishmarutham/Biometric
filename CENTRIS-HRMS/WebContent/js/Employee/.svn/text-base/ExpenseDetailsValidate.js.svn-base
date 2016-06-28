$(document).ready(function() {
$('#validate').click(function() {
	
	var local_allowanceDateArray = [];
	var local_locationArray = [];
	var local_fromArray = [];
	var local_toArray = [];
	var local_remarksArray = [];
	var local_modeArray = [];
	var local_amountArray = [];
	var local_snoArray=[];

	var travel_allowanceDateArray = [];
	var travel_locationArray = [];
	var travel_fromArray = [];
	var travel_toArray = [];
	var travel_remarksArray = [];
	var travel_modeArray = [];
	var travel_amountArray = [];
     var travel_snoArray=[];
	
	var staff_locationArray = [];
	var staff_fromDateArray = [];
	var staff_toDateArray = [];
	var staff_noOfDaysArray = [];
	var staff_singOrTeamArray = [];
	var staff_allowanceArray = [];
	var staff_amountArray = [];
	var staff_snoArray=[];
	
	var purchase_DateArray = [];
	var purchase_billNoArray = [];
	var purchase_particularArray = [];
	var purchase_amountArray = [];
	var purchase_snoArray = [];
	
	var telephone_DateArray = [];
	var telephone_telephonePhoneArray = [];
	var telephone_locationArray = [];
	var telephone_amountArray = [];
	var telephone_snoArray=[];
	
	var other_DateArray = [];
	var other_description = [];
	var other_amountArray = [];
	var other_snoArray = [];
	
	var miscellaneous_DateArray = [];
	var miscellaneous_description = [];
	var miscellaneous_amountArray = [];
	var miscellaneous_snoArray = [];
	
	var rowCount = 1;
	var travel_rowCount = 1;
	var staff_rowCount = 1;
	var tele_rowCount = 1;
	var purchase_rowCount=1;
	var other_rowCount=1;
	var miscellaneous_rowCount=1;
	
	
	
	
	var status = true;
	var regexpforalphabets = /^[a-zA-Z ]+$/i;
	var regexpforInteger = /^([0-9])+$/i;
	
	if($("#year").val().trim() ==''){ alert("Select Year"); return false;}
	if($("#month").val().trim() ==''){ alert("Select Month"); return false;}

	$('table#local tr:gt(0)')
			.each(
					function() {
					
						var date = $(this).find('[name=local_con_Date]').val().trim();
						var location = $(this).find('[name=local_location]').val().trim();
						var from = $(this).find('[name=local_from]').val().trim();
						var to = $(this).find('[name=local_to]').val().trim();
						var remarks = $(this).find('[name=local_remarks]').val().trim();
						var mode = $(this).find('[name=local_mode]').val().trim();
						var amount = $(this).find('[name=local_amount]').val().trim();
						var localsno = $(this).find('[name=localsno]').val().trim();
						if (date == '') {
							 confirmMessage("Local Conveyance : Date is not selected properly for row "
									+ rowCount);
							status = false;return false;
						} 
						else if(checkDate(date)==false){
							 confirmMessage("Local Conveyance : Date is not match with Selected Year and Month for row"
										+ rowCount);
								status = false;return false;
							}
						else if (date != undefined && date != '') {
							local_allowanceDateArray.push(date);status = true;
							local_snoArray.push(localsno);
						} 
						if (location == '') {
							 confirmMessage("Local Conveyance : Location field should not be empty for Date  "
									+ date);
							status = false;return false;
						} 
						else if (!(regexpforalphabets.test(location.trim()))) {
							confirmMessage("Local Conveyance : Location field allows Characters only for Date  "
									+ date);
							status = false;return false;
						} 
						else if (location != undefined && location != '') {
							local_locationArray.push(location);status = true;
						}
						 if (from == '') {
							 confirmMessage("Local Conveyance : From field should not be empty for Date  "
									+ date);
							status = false;return false;
						} 
						else if (!(regexpforalphabets.test(from.trim()))) {

							confirmMessage("Local Conveyance : From field allows Characters only for Date  "
									+ date);
							status = false;return false;
						} 
						else if (from != undefined && from != '') {
							local_fromArray.push(from);status = true;
						}
						 if (to == '') {
							confirmMessage("Local Conveyance : To field should not be empty for Date  "
									+ date);
							status = false;return false;
						} 
						else if (!(regexpforalphabets.test(to.trim()))) {

							confirmMessage("Local Conveyance : To field allows Characters only for Date  "
									+ date);
							status = false;return false;
						} 
						else if (to != undefined && to != '') {
							local_toArray.push(to);status = true;
						}
						if (remarks == '') {
							confirmMessage("Local Conveyance : Remarks field should not be empty for Date  "
									+ date);
							status = false;return false;
						} 
						else if (!(regexpforalphabets.test(remarks.trim()))) {

							confirmMessage("Local Conveyance : Remarks field allows Characters only for Date  "
									+ date);
							status = false;return false;
						} 
						else if (remarks != undefined && remarks != '') {
							local_remarksArray.push(remarks);status = true;
						}
						if (mode == '') {
							confirmMessage("Local Conveyance : Mode field should not be empty for Date  "
									+ date);
							status = false;return false;
						} 
						else if (!(regexpforalphabets.test(mode.trim()))) {
							 confirmMessage("Local Conveyance : Mode field allows Characters only for Date  "
									+ date);
							status = false;return false;
						} 
						else if (mode != undefined && mode != '') {
							local_modeArray.push(mode);status = true;
						}
						if (amount == '') {
							confirmMessage("Local Conveyance : Amount field should not be empty for Date  "
									+ date);
							status = false;return false;
						} 
						else if (!(regexpforInteger.test(parseInt(amount.trim())))) {

							 confirmMessage("Local Conveyance : Amount field allows Numbers only for Date  "
									+ date);
							status = false;return false;
						} 
						else if (amount != undefined && amount != '') {
							local_amountArray.push(amount);status = true;
						}
						rowCount++;
					});

	if (status == true) {
		$('table#travel tr:gt(0)')
				.each(
						function() {

							var travelsno=$(this).find('[name=travelsno]').val();
							var date = $(this).find('[name=travel_con_Date]').val().trim();
							var location = $(this).find('[name=travel_location]').val().trim();
							var from = $(this).find('[name=travel_from]').val().trim();
							var to = $(this).find('[name=travel_to]').val().trim();
							var remarks = $(this).find('[name=travel_remarks]').val().trim();
							var mode = $(this).find('[name=travel_mode]').val().trim();
							var amount = $(this).find('[name=travel_amount]').val().trim();

							if (date == '') {
								 confirmMessage("Travel Expense : Date is not selected properly for row "
										+ travel_rowCount);
								status = false;return false;
							} 
							else if(checkDate(date)==false){
								 confirmMessage("Travel Expense : Date is not match with Selected Year and Month for row"
											+ travel_rowCount);
									status = false;return false;
								}
							else if (date != undefined && date != '') {
								travel_allowanceDateArray.push(date);status = true;
								travel_snoArray.push(travelsno);
							}
							if (location == '') {
								 confirmMessage("Travel Expense : Location field should not be empty for Date  "
										+ date);
								status = false;return false;
							} else if (!(regexpforalphabets.test(location
									.trim()))) {
								 confirmMessage("Travel Expense : Location field allows Characters only for Date  "
										+ date);
								status = false;return false;
							} else if (location != undefined && location != '') {
								travel_locationArray.push(location);status = true;
							}
							if (from == '') {
								 confirmMessage("Travel Expense : From field should not be empty for Date  "
										+ date);
								status = false;return false;
							} else if (!(regexpforalphabets.test(from.trim()))) {
								 confirmMessage("Travel Expense : From field allows Characters only for Date  "
										+ date);
								status = false;return false;
							} else if (from != undefined && from != '') {
								travel_fromArray.push(from);status = true;
							}
							if (to == '') {
								 confirmMessage("Travel Expense : To field should not be empty for Date  "
										+ date);
								status = false;return false;
							} else if (!(regexpforalphabets.test(to.trim()))) {
								 confirmMessage("Travel Expense : To field allows Characters only for Date  "
										+ date);
								status = false;return false;
							} else if (to != undefined && to != '') {
								travel_toArray.push(to);status = true;
							}
							if (remarks == '') {
								 confirmMessage("Travel Expense : Remarks field should not be empty for Date  "
										+ date);
								status = false;return false;
							} else if (!(regexpforalphabets
									.test(remarks.trim()))) {
								 confirmMessage("Travel Expense : Remarks field allows Characters only for Date  "
										+ date);
								status = false;return false;
							} else if (remarks != undefined && remarks != '') {
								travel_remarksArray.push(remarks);status = true;
							}
							if (mode == '') {
								 confirmMessage("Travel Expense : Mode field should not be empty for Date  "
										+ date);
								status = false;return false;
							} else if (!(regexpforalphabets.test(mode.trim()))) {
								 confirmMessage("Travel Expense : Mode field allows Characters only for Date  "
										+ date);
								status = false;return false;
							} else if (mode != undefined && mode != '') {
								travel_modeArray.push(mode);status = true;
							}
							if (amount == '') {
								 confirmMessage("Travel Expense : Amount field should not be empty for Date  "
										+ date);
								status = false;return false;
							} else if (!(regexpforInteger.test(parseInt(amount.trim())))) {
								 confirmMessage("Travel Expense : Amount field allows Numbers only for Date  "
										+ date);
								status = false;return false;
							} else if (amount != undefined && amount != '') {
								travel_amountArray.push(amount);status = true;
							}
							travel_rowCount++;
						});
	}
		if (status == true) {
			$('table#staff tr:gt(0)')
					.each(
							function() {
								var staffsno = $(this).find('[name=staffsno]').val().trim();
								var location = $(this).find('[name=staff_location]').val().trim();
								var fromdate = $(this).find('[name=staff_from_Date]').val().trim();
								var todate = $(this).find('[name=staff_to_Date]').val().trim();
								var noOfdays = $(this).find('[name=staff_noOfDays]').val().trim();
								var sinorTeam = $(this).find('[name=staff_singleOrTeam]').val().trim();
								var allowance = $(this).find('[name=staff_allowance]').val().trim();
								var amount = $(this).find('[name=staff_amount]').val().trim();
								
								
								var d1 = Date.parse(dateConverter(fromdate));
								var d2 = Date.parse(dateConverter(todate));
								
								if (location == '') {
									 confirmMessage("Staff Welfare : Location field should not be empty for Row  "
											+ staff_rowCount);
									status = false;return false;
								} else if (!(regexpforalphabets.test(location
										.trim()))) {
									 confirmMessage("Staff Welfare : Location field allows Characters only for Row  "
											+ staff_rowCount);
									status = false;return false;
								} else if (location != undefined && location != '') {
									staff_locationArray.push(location);status = true;
									staff_snoArray.push(staffsno);
								}
								if (fromdate == '') {
									 confirmMessage("Staff Welfare : From Date is not selected properly for Location "
											+ location);
									status = false;return false;
								} 
								else if(checkDate(fromdate)==false){
									 confirmMessage("Staff Welfare : From Date is not match with Selected Year and Month for row"
												+ staff_rowCount);
										status = false;return false;
									}
								else if (fromdate != undefined && fromdate != '') {
									staff_fromDateArray.push(fromdate);status = true;
								}
								if (todate == '') {
									 confirmMessage("Staff Welfare : To Date is not selected properly for Location "
											+ location);
									status = false;return false;
								}
								else if(checkDate(todate)==false){
									 confirmMessage("Staff Welfare : To Date is not match with Selected Year and Month for row"
												+ staff_rowCount);
										status = false;return false;
								}else if (d1 > d2) {
									confirmMessage("Staff Welfare : To Date is  greater than From Date  for row"
												+ staff_rowCount);
									status = false;return false;
									}
								else if (todate != undefined && todate != '') {
									staff_toDateArray.push(todate);status = true;
								}
								if (noOfdays == '') {
									 confirmMessage("Staff Welfare : No of Days field should not be empty for Location "
											+ location);
									status = false;return false;
								} else if (!(regexpforInteger.test(noOfdays
										.trim()))) {
									 confirmMessage("Staff Welfare : No of Days field allows Numbers only for Location "
											+ location);
									status = false;return false;
								} else if (noOfdays != undefined && noOfdays != '') {
									staff_noOfDaysArray.push(noOfdays);status = true;
								}
								
								if (sinorTeam == '') {
									 confirmMessage("Staff Welfare : Single/Team field should not be empty for Location  "
											+ location);
									status = false;return false;
								} else if (!(regexpforalphabets.test(sinorTeam
										.trim()))) {
									 confirmMessage("Staff Welfare : Single/Team field allows Characters only for Location  "
											+ location);
									status = false;return false;
								} else if (sinorTeam != undefined && sinorTeam != '') {
									staff_singOrTeamArray.push(sinorTeam);status = true;
								}
								
								if (allowance == '') {
									 confirmMessage("Staff Welfare : Type of Activity field should not be empty for Location  "
											+ location);
									status = false;return false;
								} else if (!(regexpforalphabets.test(allowance
										.trim()))) {
									 confirmMessage("Staff Welfare : Type of Activity field allows Characters only for Location  "
											+ location);
									status = false;return false;
								} else if (allowance != undefined && allowance != '') {
									staff_allowanceArray.push(allowance);status = true;
								}
								
								if (amount == '') {
									 confirmMessage("Staff Welfare : Amount field should not be empty for Location  "
											+ location);
									status = false;return false;
								} else if (!(regexpforInteger.test(parseInt(amount
										.trim())))) {
									 confirmMessage("Staff Welfare : Amount field allows Numbers only for Location  "
											+ location);
									status = false;return false;
								} else if (amount != undefined && amount != '') {
									staff_amountArray.push(amount);status = true;
								}
								staff_rowCount++;
							});
		}
		if (status == true) {
			
			$('table#telephone tr:gt(0)')
			.each(
					function() {
						
						var  telephonesno= $(this).find('[name=telephonesno]').val().trim();
						var date = $(this).find('[name=telephone_Date]').val().trim();
						var phone = $(this).find('[name=telephone_phone]').val().trim();
						var location = $(this).find('[name=telephone_location]').val().trim();
						var amount = $(this).find('[name=telephone_amount]').val().trim();
						
						if (date == '') {
							 confirmMessage("Telephone : Date is not selected properly for row "
									+ tele_rowCount);
							status = false;return false;
				} 
						else if(checkDate(date)==false){
							 confirmMessage("Telephone : Date is not match with Selected Year and Month for row"
										+ tele_rowCount);
								status = false;return false;
							}
						else if (date != undefined && date != '') {
							telephone_DateArray.push(date);status = true;
							telephone_snoArray.push(telephonesno);
						}
						if (phone == '') {
							 confirmMessage("Telephone : Telephone field should not be empty for Date  "
									+ date);
							status = false;return false;
						} else if (!(regexpforInteger.test(phone
								.trim()))) {
							 confirmMessage("Telephone : Telephone field allows Numbers only for Date  "
									+ date);
							status = false;return false;
						} 
						else if (phone.length > 12 || phone.length < 10) {
							 confirmMessage("Telephone : Enter valid telepnone number for Date  "
										+ date);
								status = false;return false;
						}
						else if (phone != undefined && phone != '') {
							telephone_telephonePhoneArray.push(phone);status = true;
						}
						if (location == '') {
							 confirmMessage("Telephone : Location field should not be empty for Date  "
									+ date);
							status = false;return false;
						} else if (!(regexpforalphabets.test(location
								.trim()))) {
							 confirmMessage("Telephone : Location field allows Characters only for Date  "
									+ date);
							status = false;return false;
						} else if (location != undefined && location != '') {
							telephone_locationArray.push(location);status = true;
						}
						if (amount == '') {
							 confirmMessage("Telephone : Amount field should not be empty for Date  "
									+ date);
							status = false;return false;
						} else if (!(regexpforInteger.test(parseInt(amount
								.trim())))) {
							 confirmMessage("Telephone : Amount field allows Numbers only for Date  "
									+ date);
							status = false;return false;
						} else if (amount != undefined && amount != '') {
							telephone_amountArray.push(amount);status = true;
						}
						tele_rowCount++;
					});
		}
		if (status == true) {
			$('table#purchase tr:gt(0)')
			.each(
					function() {
						
					
						var purchasesno = $(this).find('[name=purchasesno]').val().trim();
						var date = $(this).find('[name=purchase_Date]').val().trim();
						var billNo = $(this).find('[name=purchase_billno]').val().trim();
						var particular = $(this).find('[name=purchase_particular]').val().trim();
						var amount = $(this).find('[name=purchase_amount]').val().trim();
						
						if (date == '') {
							 confirmMessage("Purchase : Date is not selected properly for row "
									+ purchase_rowCount);
							status = false;return false;
						} 
						else if(checkDate(date)==false){
							 confirmMessage("Purchase : Date is not match with Selected Year and Month for row"
										+ purchase_rowCount);
								status = false;return false;
							}
						else if (date != undefined && date != '') {
							purchase_DateArray.push(date);status = true;
							purchase_snoArray.push(purchasesno);
						}
						if (billNo == '') {
							 confirmMessage("Purchase : Bill No field should not be empty for Date  "
									+ date);
							status = false;return false;
						} else if (!(regexpforInteger.test(parseInt(billNo
								.trim())))) {
							 confirmMessage("Purchase : Bill No field allows Numbers only for Date  "
									+ date);
							status = false;return false;
						} 
						else if (billNo != undefined && billNo != '') {
							purchase_billNoArray.push(billNo);status = true;
						}
						if (particular == '') {
							 confirmMessage("Purchase : Particular field should not be empty for Date  "
									+ date);
							status = false;return false;
						} else if (!(regexpforalphabets.test(particular
								.trim()))) {
							 confirmMessage("Purchase : Particular field allows Characters only for Date  "
									+ date);
							status = false;return false;
						} else if (particular != undefined && particular != '') {
							purchase_particularArray.push(particular);status = true;
						}
						if (amount == '') {
							 confirmMessage("Purchase : Amount field should not be empty for Date  "
									+ date);
							status = false;return false;
						} else if (!(regexpforInteger.test(parseInt(amount
								.trim())))) {
							 confirmMessage("Purchase : Amount field allows Numbers only for Date  "
									+ date);
							status = false;return false;
						} else if (amount != undefined && amount != '') {
							purchase_amountArray.push(amount);status = true;
						}
						purchase_rowCount++;
					});
		}
		
		
		if (status == true) {
			$('table#other tr:gt(0)')
			.each(
					function() {
						
						var otherworksno = $(this).find('[name=otherworksno]').val().trim();
						var date = $(this).find('[name=other_Date]').val().trim();
						var description = $(this).find('[name=other_description]').val().trim();
						var amount = $(this).find('[name=other_amount]').val().trim();
						
						if (date == '') {
							 confirmMessage("Other : Date is not selected properly for row "
									+ other_rowCount);
							status = false;return false;
						} 
						else if(checkDate(date)==false){
							 confirmMessage("Other : Date is not match with Selected Year and Month for row"
										+ other_rowCount);
								status = false;return false;
							}
						else if (date != undefined && date != '') {
							other_DateArray.push(date);status = true;
							other_snoArray.push(otherworksno);
						}
						if (description == '') {
							 confirmMessage("Other : Description field should not be empty for Date  "
									+ date);
							status = false;return false;
						} else if (!(regexpforalphabets.test(description
								.trim()))) {
							 confirmMessage("Other : Description field allows Characters only for Date  "
									+ date);
							status = false;return false;
						} else if (description != undefined && description != '') {
							other_description.push(description);status = true;
						}
						if (amount == '') {
							 confirmMessage("Other : Amount field should not be empty for Date  "
									+ date);
							status = false;return false;
						} else if (!(regexpforInteger.test(parseInt(amount
								.trim())))) {
							 confirmMessage("Other : Amount field allows Numbers only for Date  "
									+ date);
							status = false;return false;
						} else if (amount != undefined && amount != '') {
							other_amountArray.push(amount);status = true;
						}
						other_rowCount++;
					});
		}
		
		if (status == true) {
			$('table#miscellaneous tr:gt(0)')
			.each(
					function() {
						
						var miscellaneoussno = $(this).find('[name=miscellaneoussno]').val();
						var date = $(this).find('[name=miscellaneous_Date]').val().trim();
						var description = $(this).find('[name=miscellaneous_description]').val().trim();
						var amount = $(this).find('[name=miscellaneous_amount]').val().trim();
						
						if (date == '') {
							 confirmMessage("Miscellaneous : Date is not selected properly for row "
									+ miscellaneous_rowCount);
							status = false;return false;
						} 
						else if(checkDate(date)==false){
							 confirmMessage("Miscellaneous : Date is not match with Selected Year and Month for row"
										+ miscellaneous_rowCount);
								status = false;return false;
							}
						else if (date != undefined && date != '') {
							miscellaneous_DateArray.push(date);status = true;
							miscellaneous_snoArray.push(miscellaneoussno);
						}
						if (description == '') {
							 confirmMessage("Miscellaneous : Description field should not be empty for Date  "
									+ date);
							status = false;return false;
						} else if (!(regexpforalphabets.test(description
								.trim()))) {
							 confirmMessage("Miscellaneous : Description field allows Characters only for Date  "
									+ date);
							status = false;return false;
						} else if (description != undefined && description != '') {
							miscellaneous_description.push(description);status = true;
						}
						if (amount == '') {
							 confirmMessage("Miscellaneous : Amount field should not be empty for Date  "
									+ date);
							status = false;return false;
						} else if (!(regexpforInteger.test(parseInt(amount
								.trim())))) {
							 confirmMessage("Miscellaneous : Amount field allows Numbers only for Date  "
									+ date);
							status = false;return false;
						} else if (amount != undefined && amount != '') {
							miscellaneous_amountArray.push(amount);status = true;
						}
						miscellaneous_rowCount++;
					});
		}
		if (status == true) {
		if($("#finalTotal").val().trim()==0)
			{
			confirmMessage("Add any Expenses to Upload");
			status = false;return false;
			}
		else
			{
			status = true;
			}
		}
		if (status == true) {
			
			
		var act_Month=$("#month option:selected").text()+" - "+$("#year option:selected").text();
		var answer = confirm("Are you sure to Post Expense Details for "+ act_Month+" ?");
		if (answer) {	
		var jsonObject = {
				
			'hiddenexpensecode':$('#hiddenExpenseCode').val(),	
			'employeeId':$("#h_Id").val().trim(),
			'expense_month':$("#month").val().trim(),
			'expense_Year':$("#year").val().trim(),
			'employeeMangId':$("#h_MangId").val().trim(),
					
			'totallocalAmount':$("#local_totalAmount").val().trim(),
			'totaltravelAmount':$("#travel_totalAmount").val().trim(),
			'totalstaffAmount':$("#staff_totalAmount").val().trim(),
			'totaltelephoneAmount':$("#telephone_totalAmount").val().trim(),
			'totalpurchaseAmount':$("#purchase_totalAmount").val().trim(),
			'totalotherAmount':$("#other_totalAmount").val().trim(),
			'totalmiscellaneousAmount':$("#miscellaneous_totalAmount").val().trim(),
			'totalfinal':$("#finalTotal").val().trim(),
			
			'allowanceDate' : local_allowanceDateArray,
			'allowancelocation' : local_locationArray,
			'allowancefrom' : local_fromArray,
			'allowanceto' : local_toArray,
			'allowanceremarks' : local_remarksArray,
			'allowancemode' : local_modeArray,
			'allowanceamount' : local_amountArray,
			'allowancesno' : local_snoArray,
			
			'travelDate' : travel_allowanceDateArray,
			'travellocation' : travel_locationArray,
			'travelfrom' : travel_fromArray,
			'travelto' : travel_toArray,
			'travelremarks' : travel_remarksArray,
			'travelmode' : travel_modeArray,
			'travelamount' : travel_amountArray,
			'travelsno'   : travel_snoArray,
			
			'stafflocation' : staff_locationArray,
			'staffFromDate' : staff_fromDateArray,
			'staffToDate' : staff_toDateArray,
			'staffnoOfDays' : staff_noOfDaysArray,
			'staffsingleOrTeam' : staff_singOrTeamArray,
			'staffallowance' : staff_allowanceArray,
			'staffamount' : staff_amountArray,
			'staffsno' : staff_snoArray,
			
			'purchaseDate' : purchase_DateArray,
			'purchasebillNo' : purchase_billNoArray,
			'purchaseParticular' : purchase_particularArray,
			'purchaseamount' : purchase_amountArray,
			'purchasesno' : purchase_snoArray,
			
			'telephoneDate' : telephone_DateArray,
			'telephonePhoneNo' : telephone_telephonePhoneArray,
			'telephoneLocation' : telephone_locationArray,
			'telephoneamount' : telephone_amountArray,
			'telephonesno' : telephone_snoArray,
		
			'otherDate' : other_DateArray,
			'otherDescription' : other_description,
			'otheramount' : other_amountArray,
			'othersno' : other_snoArray,
			
			'miscellaneousDate' : miscellaneous_DateArray,
			'miscellaneousDescription' : miscellaneous_description,
			'miscellaneousamount' : miscellaneous_amountArray,
			'miscellaneoussno' : miscellaneous_snoArray,
			'loginUserMangPrevId' : $('input[name=loginuserMangPrevId]').val()
			
		};
		$.ajax({
			method:'POST',
			url:'empExpenseDetails.do?method=saveEmployeeExpense',
			data:jsonObject,
			 beforeSend: function() {
			       
				  $('#loader').show();
				  
			    },
			success:function(data){
				var result = $.parseJSON(data);
				
				$('#loader').hide();
				
				
				if(result.expense_Result == "success"){
					
					 $('.error-box').css({
							'visibility' : 'visible'
						});
						$('#sucessmessage').text("Your Expense Details Saved Succesfully");
						$('.error-box').addClass("ui-state-error");
						$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
					
					
					setTimeout(function () {
						
					   window.location.href =	"employeeMenu.do?parameter=expenseDetails";
				    }, 5000);
					
					
			}else if (result.expense_Result == "MialNotSent") {
				
				
				$('.error-box').css({
					'visibility' : 'visible'
				});
				$('.error-box').text("Your Expense Details Saved Succesfully,Mail not Sent");
				$('.error-box').addClass("ui-state-error");
				$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
				
				
				setTimeout(function () {
					
					  window.location.href ="employeeMenu.do?parameter=expenseDetails";
			    }, 5000);
				
				
	        }
				else{
					
					$('.error-box').css({
						'visibility' : 'visible'
					});
					$('.error-box').text("Please try again, after some time");
					$('.error-box').addClass("ui-state-error");
					$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
				}	
			}
		});
	}
		}
	return false;
});


/*$("#projectId").change(function(){
	
	$.ajax({
		method:'POST',
		url:'empExpenseDetails.do?method=getProjectRefCode',
		data:{"projectId":$("#projectId").val().trim()},
		success:function(data){
			var result = $.parseJSON(data);
			
			$("#projectRefCode").text(result.projectRefCode);
			
		}
	});
	
});
*/

});
function checkDate(checkingDate) {
	var selected_Year = ($("#year").val().trim());
	var selected_Month = ($("#month").val().trim());
	
	var status;
	var date_year = checkingDate.substring(6, 10);
	var date_month = checkingDate.substring(3, 5);
	
	if ((selected_Year == date_year) && (selected_Month == date_month)) {
		status= true;
	} else {
		status= false;
	}
	return status;
}

function dateConverter(dateString) {
	var dateArray = [];
	var dateStringArray = dateString.split("-");
	dateArray.push(dateStringArray[2]);
	dateArray.push(dateStringArray[1]);
	dateArray.push(dateStringArray[0]);
	var dateString1 = dateArray.join("-");
	return dateString1;
}