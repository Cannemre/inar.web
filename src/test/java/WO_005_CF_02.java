import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WO_005_CF_02 extends Hooks {

	// 1- Open the URL.
	// 2- Click "WebOrder" button on top bar.
	// 3- Enter valid username "Inar" and password "Academy".
	// 4- Navigate to the order page.
	// 5- Select "ScreenSaver" from Product dropdown.
	// 6- Leave blank the quantity box.
	// 7- Enter "20" as discount percentage.
	// 8- Click on the "Calculate" button.
	// 9- Verify the invalid Quantity error message is displayed.

	@Test
	public void verifyCalculateFunctionalityInOrderPageInvalidInput() {
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
		// Select "ScreenSaver" from Product dropdown.
		WebElement productDropdownElement = driver.findElement(By.id("productSelect"));
		Select productDropdown = new Select(productDropdownElement);
		productDropdown.selectByIndex(2);
		// Enter "20" as discount percentage.
		WebElement discountField = driver.findElement(By.id("discountInput"));
		discountField.sendKeys("20");
		// Click on the "Calculate" button.
		WebElement calculateButton = driver.findElement(By.xpath("//button[text()='Calculate']"));
		calculateButton.click();
		// Verify the invalid Quantity error message is displayed.
		WebElement quantityErrorMessage = driver.findElement(By.xpath("//*[@id='quantityValidateError']/em"));
		assertEquals("Field 'Quantity' must be greater than zero.", quantityErrorMessage.getText());
	}

}
