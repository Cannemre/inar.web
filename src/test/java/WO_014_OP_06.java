import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class WO_014_OP_06 extends Hooks {
	// try

	// 1- Open the URL.
	// 2- Click "WebOrder" button on top bar.
	// 3- Enter valid username "Inar" and password "Academy".
	// 4- Navigate to the order page.
	// 5- Select "MyMoney" from Product dropdown.
	// 6- Enter "8" as quantity number.
	// 7- Enter "20" as discount percentage.
	// 8- Click on the "Calculate" button.
	// 9- Enter "Inar Academy" as Name.
	// 10- Enter "1100 Congress Ave" as Street.
	// 11- Enter "Austin" as City.
	// 12- Enter "TX" State.
	// 13- Enter "78701" as Zip Code(number).
	// 14- Select "Visa" as Card Type.
	// 15- Enter "4938281746192845" as Card Number.
	// 16- Enter past "11/02" Expire Date(mm/yy format).
	// 17- Click "Process"" button.
	// 18- Verify the invalid Expire Date error message is displayed.

	@Test
	public void verifyInvalidExpireDateErrorMessage() throws InterruptedException {
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
		// Select "MyMoney" from Product dropdown.
		WebElement productDropdownElement = driver.findElement(By.id("productSelect"));
		Select productDropdown = new Select(productDropdownElement);
		productDropdown.selectByIndex(0);
		// Enter "8" as quantity number.
		WebElement quantityField = driver.findElement(By.id("quantityInput"));
		quantityField.sendKeys("8");
		// Enter "20" as discount percentage.
		WebElement discountField = driver.findElement(By.id("discountInput"));
		discountField.sendKeys("20");
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
		// Select "American Express" as Card Type.
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,1000)");
		Thread.sleep(1000);
		WebElement americanExpressCheckbox = driver.findElement(By.id("amex"));
		americanExpressCheckbox.click();
		// Enter "342738261027163" as Card Number.
		WebElement cardNumberField = driver.findElement(By.id("cardNumber"));
		cardNumberField.sendKeys("342738261027163");
		// Enter "11/02" Expire Date(mm/yy format).
		WebElement expiryDateField = driver.findElement(By.id("expiryDate"));
		expiryDateField.sendKeys("11/02");
		// Click "Process"" button.
		WebElement processButton = driver.findElement(By.xpath("//button[text()='Process']"));
		processButton.click();
		// Verify the invalid Expire Date error message is displayed.
		WebElement successfullyProcessAlert = driver.findElement(By.cssSelector("div[role='alert']"));
		assertFalse(successfullyProcessAlert.isDisplayed());
	}

}
