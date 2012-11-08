package be.cegeka.zombies.domain;

import junit.framework.Assert;

import org.junit.Test;

public class ZombieTest {

	@Test
	public void createNewZombieWithSomeHealth() {
		Assert.assertEquals(3, new Zombie(3).getHealth());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void iCannotCreateAZombieWithNegativeHealth() {
		new Zombie(-5);
	}
	
	@Test
	public void getHitRecudesHealth() {
		Zombie zombie = new Zombie(5).getHit(2);
		Assert.assertEquals(3, zombie.getHealth());
	}
	
	@Test
	public void isDeadTrueIfGotHitMoreThanInitialHealth() {
		Zombie zombie = new Zombie(5).getHit(5);
		Assert.assertEquals(true, zombie.isDead());		
	}
	
	@Test
	public void isDeadFalseIfSomeHealthLeft() {
		Zombie zombie = new Zombie(5).getHit(4);
		Assert.assertEquals(false, zombie.isDead());		
	}
	
}
