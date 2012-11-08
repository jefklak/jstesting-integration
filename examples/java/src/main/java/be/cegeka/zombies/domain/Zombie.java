package be.cegeka.zombies.domain;

public class Zombie {

	private int health;
	
	public Zombie(int health) {
		if(health < 0) {
			throw new IllegalArgumentException("zombie health cannot be less than 0");
		}
		this.health = health;
	}

	public Zombie getHit(int damage) {
		health -= damage;
		return this;
	}
	
	public boolean isDead() {
		return this.health <= 0;
	}
	
	public int getHealth() {
		return health;
	}
	
	
	
}
