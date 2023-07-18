package Steps;

import Base.BaseUtil;
import io.cucumber.java.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Hooks extends BaseUtil {
    //WebDriver driver;
    private  BaseUtil base;
    public Hooks(BaseUtil base) {
        this.base = base;
    }
    //@BeforeAll
    //@BeforeStep
    @Before
    public void InitializeTest() {
        System.out.println("------------------------Opening the Browser: Chrome-----------------------");
        //passing a dummy webdriver instance
        //base.StepInfo = "FirefoxDriver";
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sadam\\libs\\chromedriver.exe");
        //System.setProperty("webdriver.http.factory", "jdk-http-client");
/*        ChromeDriverService service=new ChromeDriverService.Builder().withLogOutput(System.out).build();
        driver=new ChromeDriver(service);*/

       ChromeOptions options = new ChromeOptions();
       options.addArguments("--remote-allow-origins=*");
       //DesiredCapabilities cp = new DesiredCapabilities();
       //cp.setCapability(ChromeOptions.CAPABILITY, options);
       //options.merge(cp);
        driver = new ChromeDriver(options);
        //driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        driver.manage().window().maximize();
/*        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));*/
        //driver.findElement(By.name("username")).sendKeys("admin");
    }
    //@AfterAll
    //@AfterStep
    @After
    public void TearDownTest(Scenario scenario)
    {
        if (scenario.isFailed()) {
            System.out.println(scenario.getName());
        }
        System.out.println("-----------------------Closing the Browser------------------------------");
        driver.close();

    }
}
