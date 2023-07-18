package PageObjects;

import Base.BaseUtil;
import org.openqa.selenium.By;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.time.Duration;
import java.util.List;
public class LoginPagePO extends BaseUtil {
    private BaseUtil base;

    By txtUserName = By.name("username");
    By txtPassword = By.name("password");

    By btnLogIn = By.cssSelector("input[value='Log In");

    public LoginPagePO(WebDriver driver){
        this.driver = driver;

    }

/*    @FindBy(how = How.NAME, using = "username")
    public WebElement txtUserName;

    @FindBy(how = How.NAME, using = "password")
    public WebElement txtPassword;

    @FindBy(how = How.CSS, using = "input[value='Log In']")
    public WebElement btnLogIn;*/

    public void Login (String username, String password){
        driver.findElement(txtUserName).sendKeys(username);
        driver.findElement(txtPassword).sendKeys(password);
    }
    public void enterUsername (String username) {
       driver.findElement(txtUserName).sendKeys(username);
    }

    public void enterPassword (String password) {
        driver.findElement(txtPassword).sendKeys(password);
    }
    public void clickLogin (){
        driver.findElement(btnLogIn).click();
    }

    public void validUserLogin (String username, String password){
        driver.findElement(txtUserName).sendKeys(username);
        driver.findElement(txtUserName).sendKeys(password);
        driver.findElement(btnLogIn).click();

    }



}
