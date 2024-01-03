import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WO_002_LP_02 extends Hooks {

	// 1- Open the URL.
	// 2- Click "WebOrder" button on top bar.
	// 3- Enter invalid username "InvalidUserName" and/or password "InvalidPassword".
	// 4- Click on the "Login" button
	// 5- Verify that the appropriate error message is displayed.

	@Test
	public void verifyLoginFailure() {
		// Click "WebOrder" button on top bar.
		WebElement webOrderPage = driver.findElement(By.xpath("//a[@href='/weborder']"));
		webOrderPage.click();
		WebElement userNameInputField = driver.findElement(By.id("login-username-input"));
		WebElement passwordInputField = driver.findElement(By.id("login-password-input"));
		// Enter invalid username "InvalidUserName" and/or password "InvalidPassword".
		userNameInputField.sendKeys("InvalidUserName");
		passwordInputField.sendKeys("InvalidPassword");
		// Click on the login button.
		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Verify that the appropriate error message is displayed.
		WebElement invalidUsernameAlert = driver.findElement(By.id("username-error-alert"));
		WebElement invalidPasswordAlert = driver.findElement(By.id("password-error-alert"));
		assertEquals("Invalid username", invalidUsernameAlert.getText());
		assertEquals("Invalid password", invalidPasswordAlert.getText());
	}

}
