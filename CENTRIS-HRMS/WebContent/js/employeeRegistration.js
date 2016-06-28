function getNetSalary(id,value){
	if(isNaN(value) || parseInt(value)<0){
		$('#'+id).val("0.0");
		return false;
	}
	
	if(isNaN(parseFloat($('#basic').val())) || parseFloat($('#basic').val())<0){
		$('#basic').val("0.0");
	}
	
	if(isNaN(parseFloat($('#hra').val()))  || parseFloat($('#hra').val())<0){
		$('#hra').val("0.0");
	}
	
	if(isNaN(parseFloat($('#conveyance').val()))  || parseFloat($('#conveyance').val())<0){
		$('#conveyance').val("0.0");
	}
	
	if(isNaN(parseFloat($('#allowance').val()))  || parseFloat($('#allowance').val())<0){
		$('#allowance').val("0.0");
	}
	
	if(isNaN(parseFloat($('#medical').val()))  || parseFloat($('#medical').val())<0){
		$('#medical').val("0.0");
	}
	
	if(isNaN(parseFloat($('#pfEmployeeContribution').val()))  || parseFloat($('#pfEmployeeContribution').val())<0){
		$('#pfEmployeeContribution').val("0.0");
	}
	
	if(isNaN(parseFloat($('#pf').val()))  || parseFloat($('#pf').val())<0){
		$('#pf').val("0.0");
	}
	
	if(isNaN(parseFloat($('#incometax').val()))  || parseFloat($('#incometax').val())<0){
		$('#incometax').val("0.0");
	}
	
	if(isNaN(parseFloat($('#profTax').val()))  || parseFloat($('#profTax').val())<0){
		$('#profTax').val("0.0");
	}
		
	var grossSalary = parseFloat($('#basic').val())+parseFloat($('#hra').val())+parseFloat($('#conveyance').val())+parseFloat($('#allowance').val())+parseFloat($('#medical').val())+parseFloat($('#pfEmployeeContribution').val());
	$('#grosssalary').val(grossSalary);
	var netSalary=	parseFloat($('#grosssalary').val())-(parseFloat($('#pf').val())+parseFloat($('#incometax').val())+parseFloat($('#profTax').val()));
	$('#netSalary').val(netSalary);
	var shiftId=$('#empshift option:selected').attr('id');
	
	if(shiftId==undefined){
		$('tr.flatCategory #incentivePerMinute').val("0.0");
		$('tr.flatCategory #incentivePerHour').val("0.0");
		$('tr.flatCategory #incentivePerDay').val("0.0");
	}
	else{
		var hourmin=shiftId.split(".");
		var hourWorkedPerDay1 = parseFloat(hourmin[0])+(parseFloat(hourmin[1])/60);
		var hourWorkedPerDay = parseFloat(hourWorkedPerDay1);
		$('tr.flatCategory #incentivePerMinute').val((parseFloat(netSalary)/(30*60*parseFloat(hourWorkedPerDay))).toFixed(2));
		$('tr.flatCategory #incentivePerHour').val((parseFloat(netSalary)/(30*parseFloat(hourWorkedPerDay))).toFixed(2));
		$('tr.flatCategory #incentivePerDay').val((parseFloat(netSalary)/30).toFixed(2));
	}
		}

function getHourlyNetSalary(id,value){
	if(isNaN(value)  || parseInt(value)<0){
		$('#'+id).val("0.0");
		return false;
	}
	var hourWorkedPerDay1 = parseFloat($('#shiftHour').val())+(parseFloat($('#min').val())/60);
	var hourWorkedPerDay = parseFloat(hourWorkedPerDay1);
	var incentivePerHour=$('#incentivePerHour').val();
	if(value=="0.0" || incentivePerHour=="0.0" || incentivePerHour==""){
		$('tr.hourlyCategory #incentivePerMinute').val("0.0");
		$('#incentivePerHour').val("0.0");
		$('tr.hourlyCategory  #incentivePerDay').val("0.0");
		$('#incentivePerWeek').val("0.0");
		$('#hourlyNetSalary').val("0.0");
		
	}
	else{
		value=incentivePerHour;
		$('tr.hourlyCategory #incentivePerMinute').val((parseFloat(value)/ 60).toFixed(2));
		$('tr.hourlyCategory #incentivePerDay').val((parseFloat(value) * hourWorkedPerDay).toFixed(2));
		$('#incentivePerWeek').val((parseFloat(value)* hourWorkedPerDay * 7).toFixed(2));
		$('#hourlyNetSalary').val((parseFloat(value)* hourWorkedPerDay * 30).toFixed(2));
	}
	
		}

function onChangeShift(){
	var shiftId=$('#empshift option:selected').attr('id');
	var shiftId_split = shiftId.split(".");
	$('#shiftHour').val(shiftId_split[0]);
	var min = shiftId_split[1].length<1?'0'+shiftId_split[1]:shiftId_split[1];
	$('#min').val(min);
	var paymentType=$('#paymenttype option:selected').val();
	if(paymentType=="Flat"){
		getNetSalary("id","1.0");
	}
	else{
		getHourlyNetSalary("id","1.0");
	}
}

function onChangeHoursPerDay(){
	getHourlyNetSalary("id","1.0");
}

function getDaysInCurrentMonth() {
	var d = new Date();
	var m = d.getMonth();
	var y = d.getFullYear();
	return /8|3|5|10/.test(--m) ? 30 : m == 1 ? (!(y % 4) && y % 100)|| !(y % 400) ? 29 : 28 : 31;
}
	

$(document).ready(function(){
//*****************Highlight The Error Massage**************************//
	var userRole= $('#userRole').val();
	if(userRole!=null && userRole!=undefined && userRole!='' && userRole!='null' && userRole!='undefined'){
		if(userRole!="ROL1"){
			$('tr#location').remove();
		}
	}
	
	$('#paymenttype').change(function(){
		var paymentType=$('#paymenttype option:selected').text();
		if(paymentType=="Hourly"){
			$('.hourlyCategory').find('input[type=text]').val("0.0");
			$('.flatCategory').find('input[type=text]').attr('disabled','disabled');
			$('.flatCategory').css({'display':'none'});
			$('#shiftHour').empty();
			for(var i=0;i<24;i++){
				 optionObject = document.createElement('option');
				 optionObject.setAttribute("value", i);
				 optionObject.innerHTML=i;
				$('#shiftHour').append(optionObject);
				}
			var hourVal=$('#shiftHour').val();
			if(hourVal==null){}
			else{
				$('#shiftHour option[value="'+$('#empshift option:selected').attr('id')+'"]').attr('selected',true);
			}
			$('.hourlyCategory').css({'display':''});
			$('.hourlyCategory').find('input[type=text]').removeAttr('disabled');
			var shiftId=$('#empshift option:selected').attr('id');
			var shiftId_split = shiftId.split(".");
			$('#shiftHour').val(shiftId_split[0]);
			var min = shiftId_split[1].length<1?'0'+shiftId_split[1]:shiftId_split[1];
			$('#min').val(min);
		}
		else{
			$('.flatCategory').find('input[type=text]').val("0.0");
			$('.flatCategory').css({'display':''});
			$('.flatCategory').find('input[type=text]').removeAttr('disabled');
			$('.hourlyCategory').find('input[type=text]').attr('disabled','disabled');
			$('.hourlyCategory').css({'display':'none'});
		}
	});
		
		
		
function updateTips(t) {
			tips.text(t).addClass("ui-state-highlight");
			setTimeout(function() {
			tips.removeClass("ui-state-highlight", 500);
		}, 500);
	}
		
//*****************Validation Of All TextBox Input**************************//

 function checkLengthTextPH( o, n, min, max ) {
	     
	             
	        if(o.val()==0)
	        	{
	        
	        	o.addClass( "ui-state-error" );
	        	updateTips( "Enter"+" " + n);
	        	return false;
	        	}
	        else{
	        	if ( o.val().trim().length > max || o.val().trim().length < min ) {
	  			  o.addClass( "ui-state-error" );
	                updateTips( "Length of " + n + " must be " +min +"." );
	                return false;
	                } else {
	  			  o.removeClass("ui-state-error");
	                return true;
	                }	
	          }
	        
	        
              
              
      }
function checkLengthText( o, n, min, max ) {
    
    
    if(o.val()==0)
    	{
    
    	//o.addClass( "ui-state-error" );
    	updateTips( "Enter"+" " + n);
    	return false;
    	}
    else{
    	if ( o.val().trim().length > max || o.val().trim().length < min ) {
			  //o.addClass( "ui-state-error" );
            updateTips( "Length of " + n + " must be between " + min + " and "
            		+ max + ".");
            return false;
            } else {
			//  o.removeClass("ui-state-error");
            return true;
            }	
      }
    
    
      
      
}
function selectDateElement(selectVal, errorMessage) {
	  
	   
    var selectId=selectVal.val();

    if (selectId==''){
 	   selectVal.addClass( "ui-state-error" );
    updateTips( errorMessage);
    return false;
      }else{
     	 selectVal.removeClass("ui-state-error");
      return true;
      }
}
 function checkRegexpText( o, regexp, n ) {
             if ( !( regexp.test( o.val().trim() ) ) ) {
             o.addClass( "ui-state-error" );
             updateTips(n);
             return false;
            } else {
			o.removeClass("ui-state-error");
            return true;
            }
      }
 function checkRegexpTextVal( o, regexp, n ) {
		
     if (o) {
    	// o.addClass( "ui-state-error" );
    		
     updateTips(n);
 //   o.removeClass("ui-state-error",5000);
     return false;
    }
	
    return true;
    
}
//*****************Validation Of SelectBox**************************//
function selectBoxElement(selectVal, errorMessage) {

	   
           var selectId=selectVal.val().length;
      
           if (selectId==0){
        	   selectVal.addClass( "ui-state-error" );
           updateTips( errorMessage);
           return false;
             }else{
            	 selectVal.removeClass("ui-state-error");
             return true;
             }
       }
//*******************Validation Of CheckBox***********************//
  function checkBoxElement(checkbox, errorMessage1) {
	             
            var checkbox=document.getElementById("checkbox");
            if (checkbox.checked != true ){
            updateTips( errorMessage1);
            return false;
            }else{
            $("#checkbox").prop("checked", false);
            return true;
              }
        }
//*******************Validation Of Radio button***********************//
  function radioButtonElement(gender, errorMessage1) {

  if($('input[name=gender]:checked').length<=0)
	{
	 
	  gender.addClass( "ui-state-error" );
	  updateTips( errorMessage1);
      return false;
	}
  else{
	  gender.removeClass("ui-state-error");
      return true;
        }
	}
//*****************Validation Of ChekBox And Radio Button**************************//
function countSelected(formElement, inputType, inputName) {
             if (inputType == null) inputType = 'checkbox';
             var returnValue = 0;
             for (var loopCounter = 0; loopCounter < formElement.length; loopCounter++) {
             var element = formElement.elements[loopCounter];
             if (element.type == inputType && element.checked == true) {
             if (inputName.length > 0)
             if (element.name == inputName)
             returnValue++;
             else
             returnValue++;
               }
           }
            return returnValue;
       }
  function countSelectedOptions(selectElement) {
              var returnValue = 0;
              for (var loopCounter = 0; loopCounter < selectElement.options.length; loopCounter++)
              if (selectElement.options[loopCounter].selected == true)
              returnValue++;
              return returnValue;
           }
  window.checkLengthText=checkLengthText;
  window.checkRegexpText=checkRegexpText;
  window.selectBoxElement=selectBoxElement;
  window.checkRegexpTextVal=checkRegexpTextVal;
  window.radioButtonElement=radioButtonElement;
  window.checkLengthTextPH=checkLengthTextPH;
  window.selectDateElement=selectDateElement;
});
//****************************************CALL VALIDATION FUNCION RULES  OF TEXT FIELD**************************************************//
 //checkLengthText( RoleId , "RoleId ", 5, 16 );/*********length for all text field****************/
 //checkRegexpText( RoleId, /^([0-9])+$/, "RoleId field only allow Integer :0-9" );/********number***********/
 //checkRegexpText( RoleName, /^[a-z]([0-9a-z_])+$/i, "RoleName may consist of a-z, 0-9, underscores, begin with a letter." );/***********combination of num and alphabate***/
 //checkRegexpText( Description, /^[a-z]([a-z_])+$/i, "Description may consist only alphabate a-z." );/********combination of only alphabate************/
 //checkRegexpText( EmailId, \b[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}\b, "please enter the valid mail ending with .com." );/********Emailid************/