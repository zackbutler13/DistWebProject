$('document').ready(function() {
	
	$('.table #editButton').on('click',function(event) {
		event.preventDefault();
		
		var href= $(this).attr('href');
		
		$.get(href, function(user, status){
			$('#nameEdit').val(user.name);
			$('#dateJoinedEdit').val(user.dateJoined);
			$('#membershipStatusEdit').val(user.membershipStatus);
			$('#gymIdEdit').val(user.gymId);
			$('#trainerIdEdit').val(user.trainerId);
			$('#userIdEdit').val(user.userId);
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