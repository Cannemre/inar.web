import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WO_001_LP_01 extends Hooks {

	// 1- Open the URL.
	// 2- Click "WebOrder" button on top bar.
	// 3- Enter "Inar" as username and "Academy" password.
	// 4- Click on the "Login" button.
	// 5- Verify that the user is successfully logged in.

	@Test
	public void verifyLoginFunctionality() {
		// Click "WebOrder" button on top bar.
		WebElement webOrderPage = driver.findElement(By.xpath("//a[@href='/weborder']"));
		webOrderPage.click();
		WebElement userNameInputField = driver.findElement(By.id("login-username-input"));
		WebElement passwordInputField = driver.findElement(By.id("login-password-input"));
		// Enter "Inar" as username and "Academy" password.
		userNameInputField.sendKeys("Inar");
		passwordInputField.sendKeys("Academy");
		// Click on the login button.
		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Verify that the user is successfully logged in.
		WebElement webOrderHomePage = driver.findElement(By.id("welcome-heading"));
		assertEquals("Welcome, Inar!", webOrderHomePage.getText());
	}

}
