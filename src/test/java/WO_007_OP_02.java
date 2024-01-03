import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WO_007_OP_02 extends Hooks {

	// 1- Open the URL.
	// 2- Click "WebOrder" button on top bar.
	// 3- Enter valid username "Inar" and password "Academy".
	// 4- Navigate to the order page.
	// 5- Select "FamilyAlbum" from Product dropdown.
	// 6- Enter "3" as quantity number.
	// 7- Enter "17" as discount percentage.
	// 8- Enter "Inar Academy" as Name.
	// 9- Enter "1100 Congress Ave" as Street.
	// 10- Enter "Austin" as City.
	// 11- Enter "TX" State.
	// 12- Enter "78701" as Zip Code(number).
	// 13- Select "Mastercard" as Card Type.
	// 14- Enter "5162738261027163" as Card Number.
	// 15- Enter "11/28" Expire Date(mm/yy format).
	// 16- Click "Process"" button.
	// 17- Verify the invalid Product Information error message is displayed.

	@Test
	public void verifyOrderPlacementWithoutCalculation() throws InterruptedException {
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
		// Select "FamilyAlbum" from Product dropdown.
		WebElement productDropdownElement = driver.findElement(By.id("productSelect"));
		Select productDropdown = new Select(productDropdownElement);
		productDropdown.selectByIndex(1);
		// Enter "3" as quantity number.
		WebElement quantityField = driver.findElement(By.id("quantityInput"));
		quantityField.sendKeys("3");
		// Enter "17" as discount percentage.
		WebElement discountField = driver.findElement(By.id("discountInput"));
		discountField.sendKeys("17");
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
		// Select "Mastercard" as Card Type.
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,1000)");
		Thread.sleep(1000);
		WebElement mastercardCheckbox = driver.findElement(By.id("mastercard"));
		mastercardCheckbox.click();
		// Enter "5162738261027163" as Card Number.
		WebElement cardNumberField = driver.findElement(By.id("cardNumber"));
		cardNumberField.sendKeys("5162738261027163");
		// Enter "11/28" Expire Date(mm/yy format).
		WebElement expiryDateField = driver.findElement(By.id("expiryDate"));
		expiryDateField.sendKeys("11/28");
		// Click "Process"" button.
		WebElement processButton = driver.findElement(By.xpath("//button[text()='Process']"));
		processButton.click();
		// Verify the invalid Product Information error message is displayed.
		js.executeScript("window.scroll(0,-1000)");
		Thread.sleep(1000);
		WebElement productInformationError = driver
			.findElement(By.xpath("//em[contains(text(),'Fix errors in Product Information')]"));
		assertEquals("Fix errors in Product Information", productInformationError.getText(), "Error message is wrong!");

	}

}
