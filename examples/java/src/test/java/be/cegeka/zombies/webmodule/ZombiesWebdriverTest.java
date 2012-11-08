package be.cegeka.zombies.webmodule;

import java.io.File;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ZombiesWebdriverTest {
	private WebDriver driver;

	@Before
	public void createDriver() {
		driver = new FirefoxDriver();
		driver.get(mainZombiePage());

		disableJQueryAnimations();
	}

	@After
	public void quitDriver() {
		driver.quit();
	}

	private String mainZombiePage() {
		return "file:" + new File("webapp/main_veryugly.html").getAbsolutePath();
	}

	private Object disableJQueryAnimations() {
		return ((JavascriptExecutor) driver).executeScript("$.fx.off = true;");
	}

	@Test
	public void wateringMyPlantIncreasesItsHealth() {
		getWateringCan().click();
		getWateringCan().click();

		Assert.assertEquals("2", getPlantSize());
	}

	@Test
	public void shootingWithMyStrongPlantWillKillTheZombie() {
		getWateringCan().click();
		shootWithMyPlantTimes(3);

		assertZombieDead();
	}

	@Test
	public void iCantKillTheZombieWithoutWateringThePlantFirst() {
		shootWithMyPlantTimes(10);
		Assert.assertTrue(Integer.parseInt(getZombieHealth()) > 0);
	}

	private void shootWithMyPlantTimes(int times) {
		for (int i = 1; i <= times; i++) {
			getPlant().click();
		}
	}

	private void assertZombieDead() {
		try {
			driver.findElement(By.id("zombie"));
			Assert.fail("expected zombie not to be present on the page!");
		} catch (NoSuchElementException expectedEx) {
		}
	}

	private String getZombieHealth() {
		return driver.findElement(By.id("health")).getText();
	}

	private String getPlantSize() {
		return driver.findElement(By.id("size")).getText();
	}

	private WebElement getPlant() {
		return driver.findElement(By.id("plant"));
	}

	private WebElement getWateringCan() {
		return driver.findElement(By.id("can"));
	}

}
