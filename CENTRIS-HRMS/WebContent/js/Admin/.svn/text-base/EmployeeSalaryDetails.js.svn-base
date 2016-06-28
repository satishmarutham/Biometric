


/*$(window).load(function() {

	if($("#bankaccno").val() == " ")
		{
		$("#bankaccno").prop("readonly",false);
		}
	
	
	
});*/
/*function calculateEmpSalary(val){
	
	
	if(val.name=="ctc"){
		
		var ctc=$("#ctc").val();
		
		$.ajax({
			
			type:"GET",
			url : "employeeSalaryDetailsAction.do?method=calculateEmpSalaryDetails",
			data : {"salary":ctc,"name":"ctc"},
			async : false,
			
			success : function(data) {
				result = $.parseJSON(data);
				
				$("#basicda").val(result.salarylist[0].basic_da);
				$("#hra").val(result.salarylist[0].hra);
				$("#epfempr").val(result.salarylist[0].pf_empr);
				$("#pfempr").val(result.salarylist[0].pf_empr);
				$("#pfempy").val(result.salarylist[0].pf_empy);
				$("#ptax").val(result.salarylist[0].pt);
				
				var tot_earnings=parseFloat($("#basicda").val())+parseFloat($("#hra").val())+parseFloat($("#epfempr").val())+parseFloat($("#eesiempr").val())+parseFloat($("#conveyance").val())
				+parseFloat($("#medical").val())+parseFloat($("#cca").val())+parseFloat($("#splallow").val())+parseFloat($("#variablepay").val());
			
				var tot_deductions=parseFloat($("#pfempr").val())+parseFloat($("#pfempy").val())+parseFloat($("#esiempr").val())+parseFloat($("#esiempy").val())+parseFloat($("#ptax").val())
				+parseFloat($("#incometax").val())+parseFloat($("#advance").val());
				
				
				$("#totearned").val(Math.round(tot_earnings));
				$("#totdeductions").val(Math.round(tot_deductions));
				$("#totpayable").val(Math.round(tot_earnings-tot_deductions));
			
			}
			
			
		});
		
		
		
	}else{
		
		var grosssalary=$("#grosssalary").val();
		
		$.ajax({
			
			type:"GET",
			url : "employeeSalaryDetailsAction.do?method=calculateEmpSalaryDetails",
			data : {"salary":grosssalary,"name":"gross"},
			async : false,
			
			success : function(data) {
				result = $.parseJSON(data);
				
				$("#eesiempr").val(result.salarylist[0].esi_empr);
				$("#esiempr").val(result.salarylist[0].esi_empr);
				$("#esiempy").val(result.salarylist[0].esi_empy);
				
				
				var tot_earnings=parseFloat($("#basicda").val())+parseFloat($("#hra").val())+parseFloat($("#epfempr").val())+parseFloat($("#eesiempr").val())+parseFloat($("#conveyance").val())
				+parseFloat($("#medical").val())+parseFloat($("#cca").val())+parseFloat($("#splallow").val())+parseFloat($("#variablepay").val());
			
				var tot_deductions=parseFloat($("#pfempr").val())+parseFloat($("#pfempy").val())+parseFloat($("#esiempr").val())+parseFloat($("#esiempy").val())+parseFloat($("#ptax").val())
				+parseFloat($("#incometax").val())+parseFloat($("#advance").val());
				
				
				$("#totearned").val(Math.round(tot_earnings));
				$("#totdeductions").val(Math.round(tot_deductions));
				$("#totpayable").val(Math.round(tot_earnings-tot_deductions));
			}
			
			
		});
		
		
		
	}
	
}*/



function calculateEmpSalary(){
	
		var basicDa=$("#basicda").val();
		var ctc=$("#ctc").val();
		var grossSalary=$("#grosssalary").val();
		
		$.ajax({
			
			type:"GET",
			url : "employeeSalaryDetailsAction.do?method=calculateEmpSalaryDetails",
			data : {"basicDa":basicDa,"ctc":ctc,"grossSalary":grossSalary},
			async : false,
			
			success : function(data) {
				
				result = $.parseJSON(data);
				
				$("#hra").val(result.salarylist[0].hra);
				
				$("#epfempr").val(result.salarylist[0].pf_empr);
				$("#eesiempr").val(result.salarylist[0].esi_empr);
				
				$("#pfempr").val(result.salarylist[0].pf_empr);
				$("#esiempr").val(result.salarylist[0].esi_empr);
				
				$("#pfempy").val(result.salarylist[0].pf_empy);
				$("#esiempy").val(result.salarylist[0].esi_empy);
				
				$("#ptax").val(result.salarylist[0].pt);
				
				
				
				var lta=0.0;
				
				if(!($("#lta").val().trim()=="")){
					
					lta=parseFloat($("#lta").val());
				}
				
				var loan=0.0;
				
				if(!($("#loan").val().trim()=="")){
					
					loan=parseFloat($("#loan").val());
				}
				
				
				var tot_earnings=parseFloat($("#basicda").val())+parseFloat($("#hra").val())+parseFloat($("#epfempr").val())+parseFloat($("#eesiempr").val())+parseFloat($("#conveyance").val())
				+parseFloat($("#medical").val())+parseFloat($("#cca").val())+parseFloat($("#splallow").val())+parseFloat($("#variablepay").val())+lta;
			
				var tot_deductions=parseFloat($("#pfempr").val())+parseFloat($("#pfempy").val())+parseFloat($("#esiempr").val())+parseFloat($("#esiempy").val())+parseFloat($("#ptax").val())
				+parseFloat($("#incometax").val())+parseFloat($("#advance").val())+loan;
				
				
				$("#totearned").val(Math.round(tot_earnings));
				$("#totdeductions").val(Math.round(tot_deductions));
				$("#totpayable").val(Math.round(tot_earnings-tot_deductions));
			
			}
			
			
		});
		
}


function calTotals(){
	
	var lta=0.0;
	
	if(!($("#lta").val().trim()=="")){
		
		lta=parseFloat($("#lta").val());
	}
	
	var loan=0.0;
	
	if(!($("#loan").val().trim()=="")){
		
		loan=parseFloat($("#loan").val());
	}
	
	var tot_earnings=parseFloat($("#basicda").val())+parseFloat($("#hra").val())+parseFloat($("#epfempr").val())+parseFloat($("#eesiempr").val())+parseFloat($("#conveyance").val())
	+parseFloat($("#medical").val())+parseFloat($("#cca").val())+parseFloat($("#splallow").val())+parseFloat($("#variablepay").val())+parseFloat(lta);

	var tot_deductions=parseFloat($("#pfempr").val())+parseFloat($("#pfempy").val())+parseFloat($("#esiempr").val())+parseFloat($("#esiempy").val())+parseFloat($("#ptax").val())
	+parseFloat($("#incometax").val())+parseFloat($("#advance").val())+parseFloat(loan);
	
	
	$("#totearned").val(Math.round(tot_earnings));
	$("#totdeductions").val(Math.round(tot_deductions));
	$("#totpayable").val(Math.round(tot_earnings-tot_deductions));
}



function validateEmployeeSalaryDetails(){
	
	var empId=$("#empid").val().trim();
	var empname=$("#empname").val().trim();
	var bankaccno=$("#bankaccno").val().trim();
	var emppfno=$("#emppfno").val().trim();
	var empesino=$("#empesino").val().trim();
	var paymenttype=$("#paymenttype").val().trim();
	var ctc=$("#ctc").val().trim();
	var grosssalary=$("#grosssalary").val().trim();
	var totpayable=$("#totpayable").val().trim();
	var basicda=$("#basicda").val().trim();
	var hra=$("#hra").val().trim();
	var conveyance=$("#conveyance").val().trim();
	var medical=$("#medical").val().trim();
	var cca=$("#cca").val().trim();
	var splallow=$("#splallow").val().trim();
	var variablepay=$("#variablepay").val().trim();
	var epfempr=$("#epfempr").val().trim();
	var eesiempr=$("#eesiempr").val().trim();
	var totearned=$("#totearned").val().trim();
	var pfempr=$("#pfempr").val().trim();
	var pfempy=$("#pfempy").val().trim();
	var esiempr=$("#esiempr").val().trim();
	var esiempy=$("#esiempy").val().trim();
	var ptax=$("#ptax").val().trim();
	var incometax=$("#incometax").val().trim();
	var advance=$("#advance").val().trim();
	var totdeductions=$("#totdeductions").val().trim();
	var lta=$("#lta").val().trim();
	var loan=$("#loan").val().trim();
	
	
	var re_for_double = '^[0-9]*\.[0-9]*$';
	var int_regex=/^\d+$/;

	
	if(empId==""){
		
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Employee Id should not empty");
		$('#empid').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		return false;
	}else if(empname==""){
		
		$("#errordiv").text("Employee Name should not empty");
		$('#empname').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
		return false;
		
	}else if(bankaccno==""){
		
		$("#errordiv").css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Please Update Bank acc Number in Amendment and come back");
		$('#bankaccno').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		return false;
		
	}else if(checkBankAccNo()){
		
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Bank account number already exist");
		$('#bankaccno').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		return false;
	}else if(checkEpfCode()){
		
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Employee Pf number already exist");
		$('#emppfno').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		return false;
	}else if(checkEsiCode()){
		
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Employee Esi code already exist");
		$('#empesino').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		return false;
	}else if(paymenttype==""){
		
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Payment type should not empty");
		$('#paymenttype').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
		return false;
		
	}else if(ctc==null || ctc==""){

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Ctc should not empty");
		$('#ctc').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
		return false;
		
	}else if(!((int_regex.test(ctc)) || (ctc.match(re_for_double)))){

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Enter valid Ctc");
		$('#ctc').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
		return false;
	}else if(grosssalary==null || grosssalary==""){

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("GrossSalary should not empty");
		$('#grosssalary').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
		return false;
		
	}else if(!((int_regex.test(grosssalary)) || (grosssalary.match(re_for_double)))){

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Enter valid GrossSalary");
		$('#grosssalary').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
		return false;
	}else if(totpayable==null || totpayable==""){

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Total payable should not empty");
		$('#totpayable').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
		return false;
		
	}else if(!((int_regex.test(totpayable)) || (totpayable.match(re_for_double)))){

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Enter valid Total Payable");
		$('#totpayable').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
		return false;
	}else if(basicda==null || basicda==""){

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Basic&Da should not empty");
		$('#basicda').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
		return false;
		
	}else if(!((int_regex.test(basicda)) || (basicda.match(re_for_double)))){

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Enter valid Basic&Da");
		$('#basicda').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
		return false;
	}else if(hra==null || hra==""){

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Hra should not empty");
		$('#hra').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
		return false;
		
	}else if(!((int_regex.test(hra)) || (hra.match(re_for_double)))){

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Enter valid Hra");
		$('#hra').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
		return false;
	}else if(conveyance==null || conveyance==""){

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Conveyance should not empty");
		$('#conveyance').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
		return false;
		
	}else if(!((int_regex.test(conveyance)) || (conveyance.match(re_for_double)))){

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Enter valid Conveyance");
		$('#conveyance').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
		return false;
	}else if(medical==null || medical==""){

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Medical Allowences should not empty");
		$('#medical').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
		return false;
		
	}else if(!((int_regex.test(medical)) || (medical.match(re_for_double)))){

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Enter valid Medical Allowences");
		$('#medical').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
		return false;
	}else if(cca==null || cca==""){

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("CCA should not empty");
		$('#cca').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
		return false;
		
	}else if(!((int_regex.test(cca)) || (cca.match(re_for_double)))){

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Enter valid CCA");
		$('#cca').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
		return false;
	}else if(splallow==null || splallow==""){

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Spl allowances should not empty");
		$('#splallow').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
		return false;
		
	}else if(!((int_regex.test(splallow)) || (splallow.match(re_for_double)))){

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Enter valid Spl allowances");
		$('#splallow').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
		return false;
	}else if(variablepay==null || variablepay==""){

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Variable pay should not empty");
		$('#variablepay').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
		return false;
		
	}else if(!((int_regex.test(variablepay)) || (variablepay.match(re_for_double)))){

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Enter valid Variyable pay");
		$('#variablepay').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
		return false;
	}else if(epfempr==null || epfempr==""){

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Employer Pf should not empty");
		$('#epfempr').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
		return false;
		
	}else if(!((int_regex.test(epfempr)) || (epfempr.match(re_for_double)))){

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Enter valid Employer Pf");
		$('#epfempr').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
		return false;
	}else if(eesiempr==null || eesiempr==""){

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Employer Esi should not empty");
		$('#eesiempr').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
		return false;
		
	}else if(!((int_regex.test(eesiempr)) || (eesiempr.match(re_for_double)))){

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Enter valid Employer Esi");
		$('#eesiempr').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
		return false;
	}else if((lta!="") && !((int_regex.test(lta)) || (lta.match(re_for_double)))){

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Enter valid LTA");
		$('#lta').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
		return false;
	
		
	}
	else if(totearned==null || totearned==""){

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Total Earned amount should not empty");
		$('#totearned').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
		return false;
		
	}else if(!((int_regex.test(totearned)) || (totearned.match(re_for_double)))){

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Enter valid Employer Total Earned amount");
		$('#totearned').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
		return false;
	}else if(pfempr==null || pfempr==""){

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Enter valid Employer Pf");
		$('#pfempr').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
		return false;
		
	}else if(!((int_regex.test(pfempr)) || (pfempr.match(re_for_double)))){

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Enter valid Employer Employer Pf");
		$('#pfempr').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
		return false;
	}else if(pfempy==null || pfempy==""){


		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Enter valid Employee Pf");
		$('#pfempy').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
		return false;
		
	}else if(!((int_regex.test(pfempy)) || (pfempy.match(re_for_double)))){

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Enter valid Employer Employee Pf");
		$('#pfempy').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
		return false;
	}else if(esiempr==null || esiempr==""){

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Employer Esi should not empty");
		$('#esiempr').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
		return false;
		
	}else if(!((int_regex.test(esiempr)) || (esiempr.match(re_for_double)))){

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Enter valid Employer Esi");
		$('#esiempr').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
		return false;
	}else if(esiempy==null || esiempy==""){

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Employee Esi should not empty");
		$('#esiempy').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
		return false;
		
	}else if(!((int_regex.test(esiempy)) || (esiempy.match(re_for_double)))){

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Enter valid Employee Esi");
		$('#esiempy').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
		return false;
	}else if(ptax==null || ptax==""){

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("P.Tax should not empty");
		$('#ptax').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
		return false;
		
	}else if(!((int_regex.test(ptax)) || (ptax.match(re_for_double)))){

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Enter valid P.Tax");
		$('#ptax').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
		return false;
	}else if(incometax==null || incometax==""){

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Incometax should not empty");
		$('#incometax').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
		return false;
		
	}else if(!((int_regex.test(incometax)) || (incometax.match(re_for_double)))){

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Enter valid Incometax");
		$('#incometax').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
		return false;
	}else if(advance==null || advance==""){

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Advance amount should not empty");
		$('#advance').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
		return false;
		
	}else if(!((int_regex.test(advance)) || (advance.match(re_for_double)))){

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Enter valid Advance amount");
		$('#advance').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
		return false;
	}else if((loan!="") && !((int_regex.test(loan)) || (loan.match(re_for_double)))){
		

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Enter valid Loan Amount");
		$('#loan').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
		return false;
		
	}
	else if(totdeductions==null || totdeductions==""){

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Total Deductions should not empty");
		$('#totdeductions').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
		return false;
		
	}else if(!((int_regex.test(totdeductions)) || (totdeductions.match(re_for_double)))){

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Enter valid Total Deductions");
		$('#totdeductions').addClass("ui-state-error");
		$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		
		return false;
	}else{
		if(parseFloat(ctc)!=parseFloat(totearned)){
			
			$('.error-box').css({
				'visibility' : 'visible'
			});
			$("#errordiv").text("Ctc and Total earned salary should match");
			$('#totearned').addClass("ui-state-error");
			$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
			
			return false;
		}else{
		return true;
		}
	}
	
	
	
	
	
}




function checkBankAccNo(){
	
	var bankstatus=false;
	
	var bankaccnumber=$("#bankaccno").val().trim();
	var empid=$('#empid').val();
	
   var accountnumber={"bankaccnumber":bankaccnumber,"empid":empid};
	
	$.ajax({
		type : "GET",
		url  :"employeeSalaryDetailsAction.do?method=validateBankAccNumber",
		data : accountnumber,
		async:false,

		success : function(data) {
			var result = $.parseJSON(data);
			
			bankstatus=result.status;
			
		
					}
	});
	
	return bankstatus;
	
	
	
}


function checkEsiCode(){
	
	var esistatus=false;
	
	var esicode=$("#empesino").val().trim();
	var empid=$('#empid').val();
	
	if(esicode!=""){
	
var Esi={"esicode":esicode,"empid":empid};
	
	$.ajax({
		type : "GET",
		url  : "employeeSalaryDetailsAction.do?method=validateEsiNumber",
		data : Esi,
		async:false,

		success : function(data) {
			var result = $.parseJSON(data);
			
			esistatus=result.status;
			
		
					}
	});
	
	}
	
	return esistatus;
	
	
	
}


function checkEpfCode(){
	
	var EPFSTATUS=false;
	
	var epfcode=$("#emppfno").val().trim();
	var empid=$('#empid').val();
	
	if(epfcode!=""){
	
var epf={"epfcode":epfcode,"empid":empid};
	
	$.ajax({
		type : "GET",
		url  : "employeeSalaryDetailsAction.do?method=validatePfNumber",
		data : epf,
		async:false,

		success : function(data) {
			var result = $.parseJSON(data);
			
			EPFSTATUS=result.status;
			
		
					}
	});
	}
	
	return EPFSTATUS;
	
	
	
}