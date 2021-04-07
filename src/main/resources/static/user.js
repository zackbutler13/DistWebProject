$('document').ready(function() {
	
	$('.table #editButton').on('click',function(event) {
		event.preventDefault();
		
		var href= $(this).attr('href');
		
		$.get(href, function(user, status){
			$('#userIdEdit').val(user.userId);
			$('#dateJoinedEdit').val(user.dateJoined);
			$('#gymIdEdit').val(user.gymId);
			$('#membershipStatusEdit').val(user.membershipStatus);
			$('#nameEdit').val(user.name);
			$('#trainerIdEdit').val(user.trainerId);			
		});
		
		$('#editModal').modal();
		
	});
	
	$('table #deleteButton').on('click',function(event) {
	
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href',href);
		$('#deleteModal').modal();
		
	});
	
	
});