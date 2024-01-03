import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WO_013_OP_05 extends Hooks {

	// 1- Open the URL.
	// 2- Click "WebOrder" button on top bar.
	// 3- Enter "Inar" as username and "Academy" password.
	// 4- Click on the "Login" button.
	// 4- Navigate to the order page.
	// 5- Select "Books" from Product dropdown.
	// 6- Verify Unit Price value.

	@Test
	public void unitPriceVerification() {
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
		// Navigate to the order page.
		WebElement orderPage = driver.findElement(By.xpath("//a[@href='/weborder/order']"));
		orderPage.click();
		// Select "Books" from Product dropdown.
		WebElement productDropdownElement = driver.findElement(By.id("productSelect"));
		Select productDropdown = new Select(productDropdownElement);
		productDropdown.selectByIndex(9);
		// Verify Unit Price value.
		WebElement unitPriceField = driver.findElement(By.id("unitPriceInput"));
		assertEquals("90", unitPriceField.getAttribute("value"), "Unit Price is wrong!");
	}

}
