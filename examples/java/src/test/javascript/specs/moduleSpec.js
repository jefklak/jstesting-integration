
describe("plants versus zombies!", function() {

	describe("growing plants", function() {
	
		var plant;
		beforeEach(function() {
			plant = Plants.create();
		});
	
		it("should be zero in size by default", function() {
			expect(plant.getSize()).toEqual(0);
		});
	
		it("should grow once in size when watered just once", function() {
			plant.water();
			expect(plant.getSize()).toEqual(1);
		});
		
		it("should grow twice in size when watered twice", function() {
			plant.water().water();
			expect(plant.getSize()).toEqual(2);
		});
	
	});
	
	describe("creating zombies", function() {
	
		it("should not 'be dead' when created", function() {
			expect(Zombies.create(2).isDead()).not.toBeTruthy();
		});
		
		it("should have the specified health at creation time", function() {
			var zombie = Zombies.create(3);
			expect(zombie.health).toEqual(3);
		});

		it("should be dead when health set to zero manually", function() {
			var zombie = Zombies.create(1);
			zombie.health = 0;
			
			expect(zombie.isDead()).toBeTruthy();
		});
		
		describe("killing zombies with plants, wow!", function() {
			
			it("should kill a zombie with health 1 after watering the plant once", function() {
				var plant = Plants.create().water();
				var zombie = Zombies.create(1);
				
				plant.shootAt(zombie);
				expect(zombie.isDead()).toBeTruthy();
			});
			
			it("should damage the zombie by the size of the plant", function() {
				var plant = Plants.create().water().water();
				var zombie = Zombies.create(4);
			
				plant.shootAt(zombie);
				expect(zombie.health).toBe(2);
			});
			
		});
	
	});

});
