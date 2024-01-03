import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class WO_012_VAO_03 extends Hooks {

	// 1- Open the URL
	// 2- Click "WebOrder" button on top bar.
	// 3- Enter valid username "Inar" and password "Academy".
	// 4- Navigate to the view all order page.
	// 5- Click "Add More Data" "8" times.
	// 6- Click 1st, 3rd and 5th orders checkboxes.
	// 7- Click "Delete" button.
	// 8- Verify the orders are deleted.

	@Test
	public void verifyDeleteFunctionalityInViewAllOrderPage() throws InterruptedException {
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
		// Navigate to the view all order page.
		WebElement viewAllOrderPage = driver.findElement(By.xpath("//a[@href='/weborder/view-orders']"));
		viewAllOrderPage.click();
		// Click "Add More Data" "8" times.
		WebElement addMoreDataButton = driver.findElement(By.xpath("//button[contains(text(),'Add More Data')]"));
		for (int i = 0; i < 8; i++) {
			addMoreDataButton.click();
		}
		// Click 1st, 3rd and 5th orders checkboxes.
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,400)");
		Thread.sleep(1000);
		for (int i = 1; i <= 5; i += 2) {
			WebElement checkbox = driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[1]/div[1]/input[1]"));
			checkbox.click();
		}
		// Click "Delete" button.
		List<String> deletedOrdersName = new ArrayList<>();
		for (int i = 1; i <= 5; i += 2) {
			WebElement element = driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[2]/span[1]"));
			deletedOrdersName.add(element.getText());
		}
		WebElement deleteButton = driver.findElement(By.xpath("//button[contains(text(),'Delete')]"));
		deleteButton.click();
		Thread.sleep(3000);
		// Verify the orders are deleted.
		List<WebElement> orders = driver.findElements(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr/td[2]/span[1]"));
		boolean result = false;
		for (WebElement order : orders) {
			if (deletedOrdersName.contains(order.getText())) {
				result = true;
			}
		}
		assertFalse(result);
	}

}
