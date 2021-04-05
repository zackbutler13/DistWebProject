$('document').ready(function() {
	
	$('.table #editButton').on('click',function(event) {
		event.preventDefault();
		
		var href= $(this).attr('href');
		
		$.get(href, function(gym, status){
			$('#nameEdit').val(gym.name);
			$('#membershipCostEdit').val(gym.membershipCost);
			$('#locationEdit').val(gym.location);
			$('#gymIdEdit').val(gym.gymId);
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