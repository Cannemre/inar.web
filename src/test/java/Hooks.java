import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

	protected static WebDriver driver;

	@BeforeAll
	public static void setUpBeforeTest() throws InterruptedException {
		// Open the URL.
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://InarAcademy:Fk160621.@test.inar-academy.com");
		Thread.sleep(1000);
	}

	@AfterAll
	public static void tearDownAfterTest() {
		if (driver != null)
			driver.quit();
	}

}
