import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WO_006_OP_01 extends Hooks {

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
	// 16- Enter "11/28" Expire Date(mm/yy format).
	// 17- Click "Process"" button.
	// 18- Verify the confirmation message is displayed.
	// 19- Navigate to view all orders page.
	// 20- Verify the order is successfully placed.

	@Test
	public void verifyOrderPlacement() throws InterruptedException {
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
		// Select "Visa" as Card Type.
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,1000)");
		Thread.sleep(1000);
		WebElement visaCheckbox = driver.findElement(By.id("visa"));
		visaCheckbox.click();
		// Enter "4938281746192845" as Card Number.
		WebElement cardNumberField = driver.findElement(By.id("cardNumber"));
		cardNumberField.sendKeys("4938281746192845");
		// Enter "11/28" Expire Date(mm/yy format).
		WebElement expiryDateField = driver.findElement(By.id("expiryDate"));
		expiryDateField.sendKeys("11/28");
		// Click "Process"" button.
		WebElement processButton = driver.findElement(By.xpath("//button[text()='Process']"));
		processButton.click();
		// Verify the confirmation message is displayed.
		WebElement confirmationAlert = driver.findElement(By.cssSelector("div[role='alert']"));
		assertEquals("New order has been successfully added.", confirmationAlert.getText());
		// Navigate to view all orders page.
		js.executeScript("window.scroll(0,-1000)");
		Thread.sleep(1000);
		WebElement viewAllOrdersPage = driver.findElement(By.xpath("//a[@href='/weborder/view-orders']"));
		viewAllOrdersPage.click();
		// Verify the order is successfully placed.
		ArrayList<String> orderInformation = new ArrayList<>();
		orderInformation.add("Inar Academy");
		orderInformation.add("MyMoney");
		orderInformation.add("8");
		orderInformation.add(DateTimeFormatter.ofPattern("MM/dd/yyyy").format(LocalDate.now()));
		orderInformation.add("1100 Congress Ave");
		orderInformation.add("Austin");
		orderInformation.add("TX");
		orderInformation.add("78701");
		orderInformation.add("Visa");
		orderInformation.add("4938281746192845");
		orderInformation.add("11/28");
		List<WebElement> tableRows = driver.findElements(By.cssSelector("tbody > tr"));
		List<WebElement> columnValuesInLastRow = tableRows.get(tableRows.size() - 1).findElements(By.xpath("td"));
		for (int i = 0; orderInformation.size() > i; i++) {
			String expected = orderInformation.get(i);
			String actual = columnValuesInLastRow.get(i + 1).getText();
			assertEquals(expected, actual);
		}
	}

}
