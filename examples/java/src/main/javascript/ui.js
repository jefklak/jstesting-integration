
var UI = (function() {
	var zombie = Zombies.create(3);
	var plant = Plants.create();

	function updateHealth() {
		$("#health").html(zombie.health);
		if(zombie.isDead()) {
			$("#zombie").hide("slow", function() {
				$(this).remove();
			});
		}
	}
	function updatePlantSize() {
		$("#size").html(plant.getSize());
	}
	
	function init() {
		$("#plant").click(function() {
			plant.shootAt(zombie);
			updateHealth();
			
			$("<img class='pea' src='pea.png'/>")
				.insertAfter($('#plant'))
				.animate({
					left: '+400',
					opacity: '0'
				}, 500, function() {
					$(this).remove();
				});
		});
		$("#can").click(function() {
			plant.water();
			updatePlantSize();
		});
		$("#zombie").click(updateHealth);
		updateHealth();
		updatePlantSize();
	}
	
	return { init: init };
})();
