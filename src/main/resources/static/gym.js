$('document').ready(function() {
	
	$('.table #editButton').on('click',function(event) {
		event.preventDefault();
		
		var href= $(this).attr('href');
		
		$.get(href, function(gym, status){
			$('#gymIdEdit').val(gym.gymId);
			$('#locationEdit').val(gym.location);
			$('#membershipCostEdit').val(gym.membershipCost);
			$('#nameEdit').val(gym.name);
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