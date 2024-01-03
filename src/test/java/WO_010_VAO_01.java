import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WO_010_VAO_01 extends Hooks {

	// 1- Open the URL
	// 2- Click "WebOrder" button on top bar.
	// 3- Enter valid username "Inar" and password "Academy".
	// 4- Navigate to the view all order page.
	// 5- Click "Add More Data" "4" times.
	// 6- Click "Check All" button.
	// 7- Verify all orders selected.

	@Test
	public void verifyCheckAllFunctionalityInViewAllOrderPage() {
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
		// Click "Add More Data" "4" times.
		WebElement addMoreDataButton = driver.findElement(By.xpath("//button[contains(text(),'Add More Data')]"));
		for (int i = 0; i < 4; i++) {
			addMoreDataButton.click();
		}
		// Click "Check All" button.
		WebElement checkAllButton = driver.findElement(By.xpath("//button[contains(text(),'Check All')]"));
		checkAllButton.click();
		// Verify all orders selected.
		for (int i = 1; i < 5; i++) {
			WebElement checkbox = driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[1]/div[1]/input[1]"));
			assertTrue(checkbox.isSelected());
		}
	}

}
