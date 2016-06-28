


$(document).ready(function(){
	
$("#pdfDownloadBtn").click(function(){
		
		
		var employeeCode=$("#employeeCodeId").val();
		
		
		window.location.href = "getAllReports.do?method=downloadEmployeeResume&employeeCode="+employeeCode;
	});

$("#wordDownloadBtn").click(function(){
		var employeeCode=$("#employeeCodeId").val();
		
		
		window.location.href = "getAllReports.do?method=downloadEmployeeResumeWord&employeeCode="+employeeCode;
	});
	
	$("#clear").click(function(){
		window.location.href="employeeMenu.do?parameter=home";
	});
	
	
	
	
	var cnt=1;
	var cnt1=1;
	var cnt2=1;
	var cnt3=1;
	var cnt4=1;
var pursuitSno="";
var technicalSkillsSno="";	
var hobbiesSno="";
var experienceSno="";
var responsibilitiesSNo="";
	var pursutString=$("#pursuitTableId tr:last").find('td').find('.pursuitSnoClass').text();
	

	if(pursutString==null || pursutString==""){
		pursuitSno=0;
	}
	else
		{
		pursuitSno=parseInt(pursutString);
		
		}
	var technicalSkillsString=$("#technicalTableId tr:last").find('td').find('.technicalSkillsSnoClass').text();
	
	if(technicalSkillsString==null || technicalSkillsString==""){
		technicalSkillsSno=0;
	}
	else
		{
		technicalSkillsSno=parseInt(technicalSkillsString);
		
		}
	var hobbiesString=$("#hobbiesTableId tr:last").find('td').find('.hobbiesSnClass').text();	

	if(hobbiesString==null || hobbiesString==""){
		hobbiesSno=0;
	}
	else
		{
		
		hobbiesSno=parseInt(hobbiesString);
		
		}
	var experienceString=$("#experienceTableId tr:last").find('td').find('.experienceSnClass').text();
	if(experienceString==null || experienceString==""){
		experienceSno=0;
	}
	else
		{
		experienceSno=parseInt(experienceString);
		
		}
	var responsibilitiesString=$("#responsibilitiesTableId tr:last").find('td').find('.responsibilitiesSnoClass').text();
	
	if(responsibilitiesString==null || responsibilitiesString==""){
		responsibilitiesSNo=0;
	}
	else
		{
		responsibilitiesSNo=parseInt(responsibilitiesString);
		
		}

$("#pursuitButtonId").click(
			function() {
				cnt++;
				pursuitSno++;
				
				var tr1 = document.createElement("tr");
				var td1 = document.createElement("td");
				var check = document.createElement("span");
				
				check.id = "sno" + pursuitSno;
				check.name = "sno";
				check.setAttribute("class","pursuitSnoClass");
				td1.appendChild(check);
				tr1.appendChild(td1);
				
				
				
				var selectElementtwo = document.createElement("input");
				
				selectElementtwo.type="text";
				selectElementtwo.name = "pursuit";
				selectElementtwo.setAttribute("class","pursuitClass");
				
				selectElementtwo.id = "pursuitId"+pursuitSno;
				
				
				selectElementtwo.style.border="1px solid #999999";
			
				selectElementtwo.style.fontSize="12px";
				selectElementtwo.style.padding="2px";
			/*	selectElementtwo.style.width="500%";*/
				selectElementtwo.style.height="21px";
				
				var td2 = document.createElement("td");
				td2.style.width="500%";
				td2.appendChild(selectElementtwo);
				tr1.appendChild(td2);
	
				
				var selectElementThird= document.createElement("input");
				
	selectElementThird.type = "image";
	selectElementThird.name = "delete";
selectElementThird.id = "delete"+pursuitSno;
	selectElementThird.src="images/trash.gif";
	var td3 = document.createElement("td");

	td3.appendChild(selectElementThird);
	tr1.appendChild(td3);
				
		
	document.getElementById("pursuitTableId").appendChild(tr1);
			
				$("#"+check.id).text(""+pursuitSno);
				
				document.getElementById(selectElementThird.id).onclick=deletPursuitMethod;
			});	
$("#hobbiesButtonId").click(
		function() {
hobbiesSno++;
			cnt1++;
			var tr2 = document.createElement("tr");
			var td4 = document.createElement("td");
			var check = document.createElement("span");
			check.id = "sno1" + hobbiesSno;
			check.name = "sno1";
			check.setAttribute("class","hobbiesSnClass");
			td4.appendChild(check);
			tr2.appendChild(td4);
			var HobbiesSecondElement = document.createElement("input");
			
			HobbiesSecondElement.type="text";
			HobbiesSecondElement.name = "hobbies";
			HobbiesSecondElement.setAttribute("class","hobbiesClass");
			
			HobbiesSecondElement.id = "hobbiesId"+hobbiesSno;
			
			
			HobbiesSecondElement.style.border="1px solid #999999";
		
			HobbiesSecondElement.style.fontSize="12px";
			HobbiesSecondElement.style.padding="2px";
			/*HobbiesSecondElement.style.width="500%";*/
			HobbiesSecondElement.style.height="21px";
			
			var td5 = document.createElement("td");
			td5.style.width="500%";
			td5.appendChild(HobbiesSecondElement);
			tr2.appendChild(td5);

			
			var hobbiesDeleteImg= document.createElement("input");
			
			hobbiesDeleteImg.type = "image";
			hobbiesDeleteImg.name = "deleteHobbies";
			hobbiesDeleteImg.id = "delete1"+hobbiesSno;
			hobbiesDeleteImg.src="images/trash.gif";
var td6 = document.createElement("td");
td6.appendChild(hobbiesDeleteImg);
tr2.appendChild(td6);
document.getElementById("hobbiesTableId").appendChild(tr2);
		
			$("#"+check.id).text(" "+hobbiesSno);
			
			document.getElementById(hobbiesDeleteImg.id).onclick=deletHobbiesMethod;
		});	
$("#responsibilitiesButtonId").click(function() {
	
	responsibilitiesSNo++;
			
		cnt2++;
			
			var tr3 = document.createElement("tr");
			var td5 = document.createElement("td");
			var check = document.createElement("span");
			check.id = "sno3"+responsibilitiesSNo;
			check.name = "sno3";
			check.setAttribute("class","responsibilitiesSnoClass");
			td5.appendChild(check);
			tr3.appendChild(td5);
			
			
			
			var responsibilitiesSecondElement = document.createElement("input");
			
			responsibilitiesSecondElement.type="text";
			responsibilitiesSecondElement.name = "responsibilities";
			responsibilitiesSecondElement.setAttribute("class","responsibilitiesClass");
			
			responsibilitiesSecondElement.id = "responsibilitiesId"+responsibilitiesSNo;
			
			
			responsibilitiesSecondElement.style.border="1px solid #999999";
		
			responsibilitiesSecondElement.style.fontSize="12px";
			responsibilitiesSecondElement.style.padding="2px";
		/*	responsibilitiesSecondElement.style.width="500%";*/
			responsibilitiesSecondElement.style.height="21px";
			
			var td6 = document.createElement("td");
			td6.style.width="500%";
			td6.appendChild(responsibilitiesSecondElement);
			tr3.appendChild(td6);

			
			var responsibilitiesDeleteImg= document.createElement("input");
			
			responsibilitiesDeleteImg.type = "image";
			responsibilitiesDeleteImg.name = "deleteresponsibilities";
			responsibilitiesDeleteImg.id = "delete2"+responsibilitiesSNo;
			
			responsibilitiesDeleteImg.src="images/trash.gif";
var td7 = document.createElement("td");
td7.appendChild(responsibilitiesDeleteImg);
tr3.appendChild(td7);
			
	
document.getElementById("responsibilitiesTableId").appendChild(tr3);
		
			$("#"+check.id).text(" "+responsibilitiesSNo);
			
			document.getElementById(responsibilitiesDeleteImg.id).onclick=deletResponsibilitiesMethod;
		});	
$("#technicalSkiilsButtonId").click(
		function() {
			technicalSkillsSno++;
			
			cnt3++;
			var tr4 = document.createElement("tr");
			var td6 = document.createElement("td");
			var check = document.createElement("span");
			check.id = "sno2" + technicalSkillsSno;
			check.name = "sno2";
			check.setAttribute("class","technicalSkillsSnoClass");
			td6.appendChild(check);
			tr4.appendChild(td6);
			
			
			
			var technicalSkillsSecondElement = document.createElement("input");
			
			technicalSkillsSecondElement.type="text";
			technicalSkillsSecondElement.name = "technicalSkills";
			technicalSkillsSecondElement.setAttribute("class","technicalClass");
			technicalSkillsSecondElement.id = "technicalSkillsId"+technicalSkillsSno;
			technicalSkillsSecondElement.style.border="1px solid #999999";
		
			technicalSkillsSecondElement.style.fontSize="12px";
			technicalSkillsSecondElement.style.padding="2px";
		/*	responsibilitiesSecondElement.style.width="500%";*/
			technicalSkillsSecondElement.style.height="21px";
			
			var td7 = document.createElement("td");
			td7.style.width="500%";
			td7.appendChild(technicalSkillsSecondElement);
			tr4.appendChild(td7);

			
			var technicalSkillsDeleteImg= document.createElement("input");
			
			technicalSkillsDeleteImg.type = "image";
			technicalSkillsDeleteImg.name = "technicalSkills";
			technicalSkillsDeleteImg.id = "delete3"+technicalSkillsSno;
			technicalSkillsDeleteImg.src="images/trash.gif";
var td8 = document.createElement("td");
td8.appendChild(technicalSkillsDeleteImg);
tr4.appendChild(td8);
			
	
document.getElementById("technicalTableId").appendChild(tr4);
		
			$("#"+check.id).text(" "+technicalSkillsSno);
			
			document.getElementById(technicalSkillsDeleteImg.id).onclick=deletTechnicalSkillsMethod;
		});	


//Experience

$("#experienceButtonId").click(
		function() {
			experienceSno++;
			cnt4++;
			var tr3 = document.createElement("tr");
			var td6 = document.createElement("td");
			var check = document.createElement("span");
			check.id = "sno4" + experienceSno;
			check.name = "sno4";
			
			check.setAttribute("class","experienceSnClass");
			
			
			td6.appendChild(check);
			tr3.appendChild(td6);
			
			
			
			var experienceSecondElement = document.createElement("input");
			
			experienceSecondElement.type="text";
			experienceSecondElement.name = "experience";
			experienceSecondElement.setAttribute("class","experienceClass");
			
			experienceSecondElement.id = "experienceId"+experienceSno;
			
			
			experienceSecondElement.style.border="1px solid #999999";
		
			experienceSecondElement.style.fontSize="12px";
			experienceSecondElement.style.padding="2px";
		/*	responsibilitiesSecondElement.style.width="500%";*/
			experienceSecondElement.style.height="21px";
			
			var td7 = document.createElement("td");
			td7.style.width="500%";
			td7.appendChild(experienceSecondElement);
			tr3.appendChild(td7);

			
			var experiencesDeleteImg= document.createElement("input");
			
			experiencesDeleteImg.type = "image";
			experiencesDeleteImg.name = "deleteexperience";
			experiencesDeleteImg.id = "delete4"+experienceSno;
			experiencesDeleteImg.src="images/trash.gif";
var td8 = document.createElement("td");
td8.appendChild(experiencesDeleteImg);
tr3.appendChild(td8);
			
	
document.getElementById("experienceTableId").appendChild(tr3);
		
			$("#"+check.id).text(" "+experienceSno);
			
			document.getElementById(experiencesDeleteImg.id).onclick=deletExperienceMethod;
		});	























//for Each

$("#createResumeBtnId").click(function(){
	
	var carrierObjective=$("#carrerObjective").val();

	var carrierObjectiveSno=$("#careerSnoId").val();

	var pursuits=[];
	var hobbies=[];
	var responsibilities=[];
	var technicalSkills=[];
	var experience=[];
	var pursutSno=[];
	var technicalSkillsSno=[]; 
	var experienceSno=[];
	var hobbiesSno=[];
	var responsibilitiesSno=[];
	
$('.createResumeTableClass tr').each(function() {
	
	if($(this).find('.pursuitClass').val()!=undefined){
		pursuits.push($(this).find('.pursuitClass').val().trim());
		}
	
if($(this).find('.hobbiesClass').val()!=undefined){
	hobbies.push($(this).find('.hobbiesClass').val().trim());
		}
if($(this).find('.responsibilitiesClass').val()!=undefined){
responsibilities.push($(this).find('.responsibilitiesClass').val().trim());
		}
if($(this).find('.technicalClass').val()!=undefined){
	technicalSkills.push($(this).find('.technicalClass').val().trim());
			}
if($(this).find('.experienceClass').val()!=undefined){
	experience.push($(this).find('.experienceClass').val().trim());
			}

if($(this).find('.pursuitSnoClass').val()!=undefined){
	pursutSno.push($(this).find('.pursuitSnoClass').text().trim());
}

if($(this).find('.hobbiesSnClass').val()!=undefined){
	hobbiesSno.push($(this).find('.hobbiesSnClass').text().trim());
}

if($(this).find('.technicalSkillsSnoClass').val()!=undefined){
	technicalSkillsSno.push($(this).find('.technicalSkillsSnoClass').text().trim());
}

if($(this).find('.experienceSnClass').val()!=undefined){
	experienceSno.push($(this).find('.experienceSnClass').text().trim());
}

if($(this).find('.responsibilitiesSnoClass').val()!=undefined){
	responsibilitiesSno.push($(this).find('.responsibilitiesSnoClass').text().trim());
}
});
for (var i = 0; i < carrierObjective.length; i++) {
	
	if(carrierObjective[i]==null || carrierObjective[i]==""){
		
 		$("#errordiv").text("Enter CarrierObjective");
		 $('.error-box').css({'visibility': 'visible'});
			$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		return false;
	
	}
	else
		{
		$('.error-box').css({'visibility' : 'hidden'});
		}
}
for (var i = 0; i < pursuits.length; i++) {
	if(pursuits[i]==null || pursuits[i]==""){
		$("#errordiv").text("Enter Pursuits");
		 $('.error-box').css({'visibility': 'visible'});
			$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		return false;
		
	}
	 else
	 {
			$('.error-box').css({'visibility' : 'hidden'});
			}
}


for (var i = 0; i < hobbies.length; i++) {
	if(hobbies[i]==null || hobbies[i]==""){
		$("#errordiv").text("Enter Hobbies");
		 $('.error-box').css({'visibility': 'visible'});
			$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		return false;
		
	}
	 else
	 {
			$('.error-box').css({'visibility' : 'hidden'});
			}
}

for (var i = 0; i < technicalSkills.length; i++) {
	if(technicalSkills[i]==null || technicalSkills[i]==""){
		$("#errordiv").text("Enter Technical Skills");
		 $('.error-box').css({'visibility': 'visible'});
			$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		return false;
		
	}
	 else
	 {
			$('.error-box').css({'visibility' : 'hidden'});
			}
}


for (var i = 0; i < experience.length; i++) {
	if(experience[i]==null || experience[i]==""){
		$("#errordiv").text("Enter Experience");
		 $('.error-box').css({'visibility': 'visible'});
			$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		return false;
		
	}
	 else
	 {
			$('.error-box').css({'visibility' : 'hidden'});
			}
}


for (var i = 0; i < responsibilities.length; i++) {
	if(responsibilities[i]==null || responsibilities[i]==""){
		$("#errordiv").text("Enter Responsibilities");
		 $('.error-box').css({'visibility': 'visible'});
			$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
		return false;
		
	}
	 else
	 {
			$('.error-box').css({'visibility' : 'hidden'});
			}
}








var dataList={
		"carrierObjective":carrierObjective,
		"pursuits":pursuits.join(","),
		"hobbies":hobbies.join(","),
		"responsibilities":responsibilities.join(","),
		"technicalSkills":technicalSkills.join(","),
		"experience":experience.join(","),
	"pursutSno":pursutSno.join(","),
	"hobbiesSno":hobbiesSno.join(","),
	"technicalSkillsSno":technicalSkillsSno.join(","),
	"experienceSno":experienceSno.join(","),
	"responsibilitiesSno":responsibilitiesSno.join(","),
	"carrerObjectSno":carrierObjectiveSno,	
};

$.ajax({
	type : "POST",
	url : "resumeCreationPath.do?method=createEmployeeResume",
	data :dataList,
	
	success : function(data) {
		var result = $.parseJSON(data);
var successMessage=result.status;

window.location.href="employeeMenu.do?parameter=employeeResumeCreation&message="+successMessage;
/*	window.location.href="resumeCreationPath.do?method=createEmployeeResume&status="+status;*/

	}

});


	
	
				
});		
				
				
			});
function deletPursuitMethod(){


	$(this).parent().parent().remove();
}



function deletResponsibilitiesMethod(){
	
	$(this).parent().parent().remove();
}




function deletHobbiesMethod(){
	
	$(this).parent().parent().remove();
}


function deletTechnicalSkillsMethod(){
	
	$(this).parent().parent().remove();
}

function deletExperienceMethod(){
	
	$(this).parent().parent().remove();
}

function deletePursuitSno(code){
	var deletePursuitSno=code;
	$.ajax({
		type : "POST",
		url : "resumeCreationPath.do?method=deletePursuit",
		data :{"deletePursuitSno":deletePursuitSno},
		
		success : function(response) {
			var result = $.parseJSON(response);
			window.location.href="employeeMenu.do?parameter=employeeResumeCreation";
		}
	});

	
}




function deleteHobbiesSno(code){
	var deleteHobbiesSno=code;

	$.ajax({
		type : "POST",
		url : "resumeCreationPath.do?method=deleteHobbies",
		data :{"deleteHobbiesSno":deleteHobbiesSno},
		
		success : function(response) {
		
			var result = $.parseJSON(response);
			
			window.location.href="employeeMenu.do?parameter=employeeResumeCreation";

		}
	});

	
}


function deleteTechnicalSkills(code){
	var deleteTechnicalSkillsSno=code;

	$.ajax({
		type : "POST",
		url : "resumeCreationPath.do?method=deleteTechnicalSkills",
		data :{"deleteTechnicalSkillsSno":deleteTechnicalSkillsSno},
		
		success : function(response) {
			var result = $.parseJSON(response);
			window.location.href="employeeMenu.do?parameter=employeeResumeCreation";
			
		}
	});

}
	
	
function deleteResponsibilities(code){
	var deleteResponsibilitiesSno=code;

	$.ajax({
		type : "POST",
		url : "resumeCreationPath.do?method=deleteResponsibilities",
		data :{"deleteResponsibilitiesSno":deleteResponsibilitiesSno},
		
		success : function(response) {
			var result = $.parseJSON(response);
			window.location.href="employeeMenu.do?parameter=employeeResumeCreation";
		}
	});
}
	function deleteExperienceCode(code){
		 var deleteExperienceSno=code;
		 $.ajax({
					type : "POST",
					url : "resumeCreationPath.do?method=deleteExperienceSno",
					data :{"deleteExperienceSno":deleteExperienceSno},
					success : function(response) {
							var result = $.parseJSON(response);
							window.location.href="employeeMenu.do?parameter=employeeResumeCreation";
						}
					});
				}



