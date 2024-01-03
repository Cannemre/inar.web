import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WO_003_LP_03 extends Hooks {

	// 1- Open the URL
	// 2- Click "WebOrder" button on top bar.
	// 3- Enter valid username "Inar" and password "Academy".
	// 4- Click "Logout" button.
	// 5- Verify logout successfully.

	@Test
	public void verifyLogoutFunctionality() {
		// Click "WebOrder" button on top bar.
		WebElement webOrderPage = driver.findElement(By.xpath("//a[@href='/weborder']"));
		webOrderPage.click();
		WebElement userNameInputField = driver.findElement(By.id("login-username-input"));
		WebElement passwordInputField = driver.findElement(By.id("login-password-input"));
		// Enter valid username "Inar" and password "Academy".
		userNameInputField.sendKeys("Inar");
		passwordInputField.sendKeys("Academy");
		// Click on the login button.
		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Click "Logout" button.
		WebElement logoutButton = driver.findElement(By.id("logout-button"));
		logoutButton.click();
		// Verify logout successfully.
		WebElement webOrderLoginPage = driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div/h2"));
		assertEquals("Login", webOrderLoginPage.getText());
	}

}
