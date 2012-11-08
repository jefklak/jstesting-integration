(function() {

	var customMatchers = {
		toHaveAmountOfProperties: function(expected) {
			return Object.keys(this.actual).length === expected;
		},
		
		toBeAnEmptyObject: function() {
			return Object.keys(this.actual).length === 0;
		},
		
		toHavePrototype: function(expected) {
			return Object.getPrototypeOf(this.actual) === expected.prototype;
		}
	};

	beforeEach(function() {
		this.addMatchers(customMatchers);
	});

})();
