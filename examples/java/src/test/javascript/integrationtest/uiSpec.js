
jasmine.getFixtures().fixturesPath = './';

describe("plants versus zombies, UI module", function() {

	beforeEach(function() {
		loadFixtures('fixture.html');
		UI.init();
		$.fx.off = true;
	});
	
	describe("growing my plant", function() {
	
		it("should see the size on the page, initialized with zero", function() {
			expect($("#size")).toHaveHtml(0);
		});
	
		it("should increase my plant size when watering with my can", function() {
			$("#can").click();
			expect($("#size")).toHaveHtml(1);
		});
		
	});
	
	describe("shooting at zombies", function() {
		function getHealthAsInt() {
			return parseInt($("#health").html());
		}
		
		it("should damage the zombie after watering the plant once", function() {
			var originalHealth = getHealthAsInt();
			$("#can").click();
			$("#plant").click();
			
			expect(getHealthAsInt()).toBeLessThan(originalHealth);
			expect($("#zombie")).toExist();
		});
	
		it("should kill and hide the zombie in one shot after watering my plant three times", function() {
			$("#can").click().click().click();
			$("#plant").click();
			
			expect($("#zombie")).not.toExist();
		});
	});

});
