
var Zombies = (function() {

	var Zombie = {
		getHit: function(damage) {
			this.health -= damage;
		},
		
		isDead: function() {
			return this.health <= 0;
		}
	};

	function create(health) {
		var someZombie = Object.create(Zombie);
		someZombie.health = health;
		return someZombie;
	}

	return {
		create: create
	};

})();

var Plants = (function() {

	var Plant = {
		water: function() {
			this.size = this.getSize() + 1;
			return this;
		},
		
		getSize: function() {
			return this.size ? this.size : 0;
		},
		
		shootAt: function(zombie) {
			zombie.getHit(this.getSize());
		}
	};

	function create() {
		return Object.create(Plant);
	}

	return {
		create: create
	};

})();
