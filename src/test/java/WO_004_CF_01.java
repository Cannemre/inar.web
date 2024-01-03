import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class WO_004_CF_01 extends Hooks {

	// 1- Open the URL.
	// 2- Click "WebOrder" button on top bar.
	// 3- Enter valid username "Inar" and password "Academy".
	// 4- Navigate to the order page.
	// 5- Select "HomeDecor" from Product dropdown.
	// 6- Enter "5" as quantity number.
	// 7- Enter "15" as discount percentage.
	// 8- Click on the "Calculate" button.
	// 9- Verify that the total amount is successfully displayed.

	@Test
	public void verifyCalculateFunctionality() {
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
		// Select "HomeDecor" from Product dropdown.
		WebElement productDropdownElement = driver.findElement(By.id("productSelect"));
		Select productDropdown = new Select(productDropdownElement);
		productDropdown.selectByIndex(4);
		// Enter "5" as quantity number.
		WebElement quantityField = driver.findElement(By.id("quantityInput"));
		quantityField.sendKeys("5");
		// Enter "15" as discount percentage.
		WebElement discountField = driver.findElement(By.id("discountInput"));
		discountField.sendKeys("15");
		// Click on the "Calculate" button.
		WebElement calculateButton = driver.findElement(By.xpath("//button[text()='Calculate']"));
		calculateButton.click();
		// Verify that the total amount is successfully displayed.
		WebElement totalField = driver.findElement(By.id("totalInput"));
		assertEquals("638", totalField.getAttribute("value"));
	}

}
