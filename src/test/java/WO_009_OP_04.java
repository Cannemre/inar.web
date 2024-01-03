import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WO_009_OP_04 extends Hooks {

	// 1- Open the URL.
	// 2- Click "WebOrder" button on top bar.
	// 3- Enter valid username "Inar" and password "Academy".
	// 4- Navigate to the order page.
	// 5- Select "SportsEquipment" from Product dropdown.
	// 6- Enter "1" as quantity number.
	// 7- Enter "10" as discount percentage.
	// 8- Click on the "Calculate" button.
	// 9- Enter "Inar Academy" as Name.
	// 10- Enter "1100 Congress Ave" as Street.
	// 11- Enter "Austin" as City.
	// 12- Enter "TX" State.
	// 13- Enter "78701" as Zip Code(number).
	// 14- Enter "4938220192845" as Card Number.
	// 15- Enter "09/26" Expire Date(mm/yy format).
	// 16- Click "Process"" button.
	// 17- Verify the Card Type error message is displayed.

	@Test
	public void verifyOrderPlacementWithoutCardType() throws InterruptedException {
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
		// Select "SportsEquipment" from Product dropdown.
		WebElement productDropdownElement = driver.findElement(By.id("productSelect"));
		Select productDropdown = new Select(productDropdownElement);
		productDropdown.selectByIndex(8);
		// Enter "1" as quantity number.
		WebElement quantityField = driver.findElement(By.id("quantityInput"));
		quantityField.sendKeys("1");
		// Enter "10" as discount percentage.
		WebElement discountField = driver.findElement(By.id("discountInput"));
		discountField.sendKeys("10");
		// Click on the "Calculate" button.
		WebElement calculateButton = driver.findElement(By.xpath("//button[text()='Calculate']"));
		calculateButton.click();
		// Enter "Inar Academy" as Name.
		WebElement nameField = driver.findElement(By.id("name"));
		nameField.sendKeys("Inar Academy");
		// Enter "1100 Congress Ave" as Street.
		WebElement streetField = driver.findElement(By.id("street"));
		streetField.sendKeys("1100 Congress Ave");
		// Enter "Austin" as City.
		WebElement cityField = driver.findElement(By.id("city"));
		cityField.sendKeys("Austin");
		// Enter "TX" State.
		WebElement stateField = driver.findElement(By.id("state"));
		stateField.sendKeys("TX");
		// Enter "78701" as Zip Code(number).
		WebElement zipField = driver.findElement(By.id("zip"));
		zipField.sendKeys("78701");
		// Enter "4938281746192845" as Card Number.
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,1000)");
		Thread.sleep(1000);
		WebElement cardNumberField = driver.findElement(By.id("cardNumber"));
		cardNumberField.sendKeys("4938281746192845");
		// Enter "09/26" Expire Date(mm/yy format).
		WebElement expiryDateField = driver.findElement(By.id("expiryDate"));
		expiryDateField.sendKeys("09/26");
		// Click "Process"" button.
		WebElement processButton = driver.findElement(By.xpath("//button[text()='Process']"));
		processButton.click();
		// Verify the Card Type error message is displayed.
		WebElement cardTypeErrorMessage = driver
			.findElement(By.xpath("//em[contains(text(),'Card type cannot be empty')]"));
		assertTrue(cardTypeErrorMessage.isDisplayed());
	}

}
