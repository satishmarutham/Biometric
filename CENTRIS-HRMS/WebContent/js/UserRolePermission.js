$(document).ready(function(){
	
	$('td .permissionEmployee').change(function(){
		var cnt = 0;
		$('input.permissionEmployee:checkbox:checked').map(function() {
			++cnt;
		});
		var cn = $('input.permissionEmployee:checkbox').length;
		if(cnt==cn){
			$('#employeeall').attr('checked',true);
		}
		else{
			$('#employeeall').attr('checked',false);
		}
	});
	
	
	$('td .permissionUser').change(function(){
		var cnt = 0;
		$('input.permissionUser:checkbox:checked').map(function() {
			++cnt;
		});
		var cn = $('input.permissionUser:checkbox').length;
		if(cnt==cn){
			$('#userAll').attr('checked',true);
		}
		else{
			$('#userAll').attr('checked',false);
		}
	});
	
	$('td .permissionLocation').change(function(){
		var cnt = 0;
		$('input.permissionLocation:checkbox:checked').map(function() {
			++cnt;
		});
		var cn = $('input.permissionLocation:checkbox').length;
		if(cnt==cn){
			$('#locationAll').attr('checked',true);
		}
		else{
			$('#locationAll').attr('checked',false);
		}
	});
	
	$('td .permissionShift').change(function(){
		var cnt = 0;
		$('input.permissionShift:checkbox:checked').map(function() {
			++cnt;
		});
		var cn = $('input.permissionShift:checkbox').length;
		if(cnt==cn){
			$('#shiftAll').attr('checked',true);
		}
		else{
			$('#shiftAll').attr('checked',false);
		}
	});
	
	$('td .permissionRole').change(function(){
		var cnt = 0;
		$('input.permissionRole:checkbox:checked').map(function() {
			++cnt;
		});
		var cn = $('input.permissionRole:checkbox').length;
		if(cnt==cn){
			$('#roleAll').attr('checked',true);
		}
		else{
			$('#roleAll').attr('checked',false);
		}
	});
	
	$('td .permissionRole').change(function(){
		var cnt = 0;
		$('input.permissionRole:checkbox:checked').map(function() {
			++cnt;
		});
		var cn = $('input.permissionRole:checkbox').length;
		if(cnt==cn){
			$('#departmentall').attr('checked',true);
		}
		else{
			$('#departmentall').attr('checked',false);
		}
	});
	
	
	$('td .permissionRole').change(function(){
		var cnt = 0;
		$('input.permissionRole:checkbox:checked').map(function() {
			++cnt;
		});
		var cn = $('input.permissionRole:checkbox').length;
		if(cnt==cn){
			$('#holidayall').attr('checked',true);
		}
		else{
			$('#holidayall').attr('checked',false);
		}
	});
	
	
	$('td .permissionRole').change(function(){
		var cnt = 0;
		$('input.permissionRole:checkbox:checked').map(function() {
			++cnt;
		});
		var cn = $('input.permissionRole:checkbox').length;
		if(cnt==cn){
			$('#designationall').attr('checked',true);
		}
		else{
			$('#designationall').attr('checked',false);
		}
	});
	
	
	$('td .permissionRole').change(function(){
		var cnt = 0;
		$('input.permissionRole:checkbox:checked').map(function() {
			++cnt;
		});
		var cn = $('input.permissionRole:checkbox').length;
		if(cnt==cn){
			$('#groupall').attr('checked',true);
		}
		else{
			$('#groupall').attr('checked',false);
		}
	});
	
	
	
	$('td .permissionLeave').change(function(){
		var cnt = 0;
		$('input.permissionLeave:checkbox:checked').map(function() {
			++cnt;
		});
		var cn = $('input.permissionLeave:checkbox').length;
		if(cnt==cn){
			$('#leavebankall').attr('checked',true);
		}
		else{
			$('#leavebankall').attr('checked',false);
		}
	});
	
	$('td .permissionStatusType').change(function(){
		var cnt = 0;
		$('input.permissionStatusType:checkbox:checked').map(function() {
			++cnt;
		});
		var cn = $('input.permissionLeave:checkbox').length;
		if(cnt==cn){
			$('#statustypeall').attr('checked',true);
		}
		else{
			$('#statustypeall').attr('checked',false);
		}
	});
	
	
	$('td .permissionApprove').change(function(){
		var cnt = 0;
		$('input.permissionApprove:checkbox:checked').map(function() {
			++cnt;
		});
		var cn = $('input.permissionLeave:checkbox').length;
		if(cnt==cn){
			$('#approveall').attr('checked',true);
		}
		else{
			$('#approveall').attr('checked',false);
		}
	});
	
	
	$('td .permissionView').change(function(){
		var cnt = 0;
		$('input.permissionView:checkbox:checked').map(function() {
			++cnt;
		});
		var cn = $('input.permissionView:checkbox').length;
		if(cnt==cn){
			$('#viewAll').attr('checked',true);
		}
		else{
			$('#viewAll').attr('checked',false);
		}
	});
	$('td .permissionOther').change(function(){
		var cnt = 0;
		$('input.permissionOther:checkbox:checked').map(function() {
			++cnt;
		});
		var cn = $('input.permissionOther:checkbox').length;
		if(cnt==cn){
			$('#otherAll').attr('checked',true);
		}
		else{
			$('#otherAll').attr('checked',false);
		}
	});
	
	
	
	
	$('#employeeall').change(function(){
		var bCheck = $(this).attr('checked');
		if(bCheck){
			$('input.permissionEmployee').attr('checked',true);
			$('input.permissionEmployee').parent().css({'color':'blue'});
		}
		else{
			$('input.permissionEmployee').attr('checked',false);
			$('input.permissionEmployee').parent().css({'color':''});
		}
	});
	
	$('#userAll').change(function(){
		var bCheck = $(this).attr('checked');
		if(bCheck){
			$('input.permissionUser').attr('checked',true);
			$('input.permissionUser').parent().css({'color':'blue'});
		}
		else{
			$('input.permissionUser').attr('checked',false);
			$('input.permissionUser').parent().css({'color':''});
		}
	});
	$('#locationAll').change(function(){
		var bCheck = $(this).attr('checked');
		if(bCheck){
			$('input.permissionLocation').attr('checked',true);
			$('input.permissionLocation').parent().css({'color':'blue'});
		}
		else{
			$('input.permissionLocation').attr('checked',false);
			$('input.permissionLocation').parent().css({'color':''});
		}
	});
	$('#shiftAll').change(function(){
		var bCheck = $(this).attr('checked');
		if(bCheck){
			$('input.permissionShift').attr('checked',true);
			$('input.permissionShift').parent().css({'color':'blue'});
		}
		else{
			$('input.permissionShift').attr('checked',false);
			$('input.permissionShift').parent().css({'color':''});
		}
	});
	$('#roleAll').change(function(){
		var bCheck = $(this).attr('checked');
		if(bCheck){
			$('input.permissionRole').attr('checked',true);
			$('input.permissionRole').parent().css({'color':'blue'});
		}
		else{
			$('input.permissionRole').attr('checked',false);
			$('input.permissionRole').parent().css({'color':''});
		}
	});
	$('#departmentall').change(function(){
		var bCheck = $(this).attr('checked');
		if(bCheck){
			$('input.permissionDepartment').attr('checked',true);
			$('input.permissionDepartment').parent().css({'color':'blue'});
		}
		else{
			$('input.permissionDepartment').attr('checked',false);
			$('input.permissionDepartment').parent().css({'color':''});
		}
	});
	$('#holidayall').change(function(){
		var bCheck = $(this).attr('checked');
		if(bCheck){
			$('input.permissionHoliday').attr('checked',true);
			$('input.permissionHoliday').parent().css({'color':'blue'});
		}
		else{
			$('input.permissionHoliday').attr('checked',false);
			$('input.permissionHoliday').parent().css({'color':''});
		}
	});
	$('#designationall').change(function(){
		var bCheck = $(this).attr('checked');
		if(bCheck){
			$('input.permissionDesignation').attr('checked',true);
			$('input.permissionDesignation').parent().css({'color':'blue'});
		}
		else{
			$('input.permissionDesignation').attr('checked',false);
			$('input.permissionDesignation').parent().css({'color':''});
		}
	});
	$('#groupall').change(function(){
		var bCheck = $(this).attr('checked');
		if(bCheck){
			$('input.permissiongroup').attr('checked',true);
			$('input.permissiongroup').parent().css({'color':'blue'});
		}
		else{
			$('input.permissiongroup').attr('checked',false);
			$('input.permissiongroup').parent().css({'color':''});
		}
	});
	$('#leavebankall').change(function(){
		var bCheck = $(this).attr('checked');
		if(bCheck){
			$('input.permissionLeave').attr('checked',true);
			$('input.permissionLeave').parent().css({'color':'blue'});
		}
		else{
			$('input.permissionLeave').attr('checked',false);
			$('input.permissionLeave').parent().css({'color':''});
		}
	});
	
	$('#statustypeall').change(function(){
		var bCheck = $(this).attr('checked');
		if(bCheck){
			$('input.permissionStatusType').attr('checked',true);
			$('input.permissionStatusType').parent().css({'color':'blue'});
		}
		else{
			$('input.permissionStatusType').attr('checked',false);
			$('input.permissionStatusType').parent().css({'color':''});
		}
	});
	
	
	$('#approveall').change(function(){
		var bCheck = $(this).attr('checked');
		if(bCheck){
			$('input.permissionApprove').attr('checked',true);
			$('input.permissionApprove').parent().css({'color':'blue'});
		}
		else{
			$('input.permissionApprove').attr('checked',false);
			$('input.permissionApprove').parent().css({'color':''});
		}
	});
	
	$('#viewAll').change(function(){
		var bCheck = $(this).attr('checked');
		if(bCheck){
			$('input.permissionView').attr('checked',true);
			$('input.permissionView').parent().css({'color':'blue'});
		}
		else{
			$('input.permissionView').attr('checked',false);
			$('input.permissionView').parent().css({'color':''});
		}
	});
	$('#otherAll').change(function(){
		var bCheck = $(this).attr('checked');
		if(bCheck){
			$('input.permissionOther').attr('checked',true);
			$('input.permissionOther').parent().css({'color':'blue'});
		}
		else{
			$('input.permissionOther').attr('checked',false);
			$('input.permissionOther').parent().css({'color':''});
		}
	});
	
	$('input.permission').change(function(){
		if($(this).is(':checked')){
			$(this).parent().css({'color':'blue'});
		}
		else{
			$(this).parent().css({'color':''});
		}
	});
	
	$('#savePermission').click(function(){
		var roleCode=$('#roleId').val();
		if(roleCode=="All"){
			$('#errordiv').text("Select Role");
			$('#errordiv').css({'visibility': 'visible'});
			return false;
		}
	var permissionCode=[];
	var permission=[];
	var permissionShortName=[];
	var isPermissionAllowed=[];
	
	$('.permission').each(function(){
		permissionCode.push($(this).attr('id'));
		permissionShortName.push($(this).attr('name'));
		permission.push($(this).attr('data_permission'));
		var isAllowed = false;
		if($(this).is(':checked')){
			isAllowed=true;
		}
		isPermissionAllowed.push(isAllowed);
		
		
	});
	
	
	
	var dataArray={"roleCode":$('#roleId').val(),"permissionCode":permissionCode,"permissionShortName":permissionShortName,"isPermissionAllowed":isPermissionAllowed,"permission":permission};
		$.ajax({
			type:"POST",
			url:"userPermission.do?method=insertRolePermission",
			data:dataArray,
			async:false,
			success:function(){
				location.reload();
			}
		});
	
	});
	
	$('#roleId').change(function(){
		$('.permission').attr('checked',false);
		$('.permission').parent().css({'color':''});
		$('#employeeall').attr('checked',false);
		$('#userAll').attr('checked',false);
		$('#locationAll').attr('checked',false);
		$('#shiftAll').attr('checked',false);
		$('#roleAll').attr('checked',false);
		$('#departmentall').attr('checked',false);
		$('#holidayall').attr('checked',false);
		$('#designationall').attr('checked',false);
		$('#groupall').attr('checked',false);
		$('#leavebankall').attr('checked',false);
		$('#viewAll').attr('checked',false);
		$('#otherAll').attr('checked',false);
		$.ajax({
			url:"userPermission.do?method=getPermissionByRole",
			data:{"roleCode":$(this).val()},
			async:false,
			success:function(data){
				var result = JSON.parse(data);
				for(var i=0;i<result.permission.length;i++){
					var id=result.permission[i].permissionId;
					
					
					var isApplicable = result.permission[i].permissionIsApplicable;
					if(isApplicable=="true"){
						$('#'+id).attr('checked',true);
						$('#'+id).parent().css({'color':'blue'});
					}
					else{
						$('#'+id).attr('checked',false);
						$('#'+id).parent().css({'color':''});
					}
				}
			}
		});
	});
	
	$('#selectAll').change(function(){
		if($(this).is(':checked')){
			$('.permission').attr('checked',true);
			$('input.permission').parent().css({'color':'blue'});
			$('#userAll').attr('checked',true);
			$('#locationAll').attr('checked',true);
			$('#shiftAll').attr('checked',true);
			$('#roleAll').attr('checked',true);
			$('#departmentall').attr('checked',true);
			$('#holidayall').attr('checked',true);
			$('#designationall').attr('checked',true);
			$('#groupall').attr('checked',true);
			$('#viewAll').attr('checked',true);
			$('#otherAll').attr('checked',true);
		}
		else{
			$('.permission').attr('checked',false);
			$('input.permission').parent().css({'color':''});
			
			$('#employeeall').attr('checked',false);
			$('#userAll').attr('checked',false);
			$('#locationAll').attr('checked',false);
			$('#shiftAll').attr('checked',false);
			$('#roleAll').attr('checked',false);
			$('#departmentall').attr('checked',false);
			$('#holidayall').attr('checked',false);
			$('#designationall').attr('checked',false);
			$('#groupall').attr('checked',false);
			$('#viewAll').attr('checked',false);
			$('#otherAll').attr('checked',false);
		}
	});
	
	$('.removePermission').click(function(){
		var roleCode=$('#roleId').val();
		if(roleCode=="All"){
			$('#errordiv').text("Select Role");
			$('#errordiv').css({'visibility': 'visible'});
			return false;
		}
		
		$.ajax({
			url:"userPermission.do?method=removePermission",
			data:{"roleCode":roleCode},
			async:false,
			success:function(data){
				location.reload();
			}
		});
	
	});
	
});