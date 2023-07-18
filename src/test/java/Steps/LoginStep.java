package Steps;

import Base.BaseUtil;
import PageObjects.LoginPagePO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

//import io.cucumber.messages.types.DataTable;
//import io.cucumber.api.DataTable;

import java.time.Duration;
import java.util.List;

public class LoginStep extends BaseUtil {
    //public WebDriver driver = initializeDriver();

    private BaseUtil base;
    //WebDriver driver;
    LoginPagePO login;

    public LoginStep(BaseUtil base) {
        this.base = base;
    }

    @Given("User navigates to login page")
    public void user_navigates_to_login_page() throws Throwable{
        System.out.println("User navigates to login page");
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        //driver.findElement(By.name("username")).sendKeys("admin");
    }

/*    @When("User enters in username and password")
    public void userEntersInUsernameAndPassword() {
    }*/

/*    @When("User enters in username and password")
    public void user_enters_in_username_and_password() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
    }

    @And("User clicks login button")
    public void userClicksLoginButton() {
    }

    @Then("User should go to the login page")
    public void userShouldGoToTheLoginPage() {
    }*/


    @When("User enters in username and password")
    public void user_enters_in_username_and_password() throws Throwable{
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        System.out.println("Enters in username and password");
    }

    @When("User clicks login button")
    public void user_clicks_login_button() throws Throwable{
        login = new LoginPagePO(driver);
        login.clickLogin();
        //driver.findElement(By.cssSelector("input[value='Log In']")).click();
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        //base.driver.findElement(By.id("loginPanel")).click();
        //base.driver.findElement(By.id("loginPanel")).click();
        ////*[@id="loginPanel"]/form/div[3]/input
    }

    @Then("User should go to the Account page")
    public void user_should_go_to_the_account_page() throws Throwable{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='title']")));
        WebElement IrctcLogo = driver.findElement(By.xpath("//h1[@class='title']"));
        String ExpectedText = "Accounts Overview";
        Assert.assertEquals(ExpectedText, IrctcLogo.getText());
        //Assert.assertEquals(true, driver.findElement(By.xpath("//h1[@class='title']")).isDisplayed());
        //Assert.assertEquals("its not displayed", base.driver.findElement(By.xpath("//h1[@class='title']")).isDisplayed(), true);
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        //System.out.println("The driver is : " + base.StepInfo);
    }



    @When("User enters in username as {string} and password as {string}")
    public void userEntersInUsernameAsAndPasswordAs(String username, String password) throws Throwable {
        System.out.println("username is " + username + " and password is " + password);
        base.driver.findElement(By.name("username")).sendKeys("john");
        //Thread.sleep(5000);
        base.driver.findElement(By.name("password")).sendKeys("demo");

    }

    @And("User enters in the following for <username> and <password>")
    public void userEntersInTheFollowingForUsernameAndPassword(DataTable total) throws Throwable {

        //List<List<String>> data = total.asLists(String.class);
        //List<List<String>> data = total.();

        //List<List<String>> data = total.asLists();
        //System.out.println(data.get(1).get(0));
        //table.asList();
    }

    @And("User enters in the following for username and password in login page")
    public void user_enters_in_the_following_for_username_and_password_in_login_page(DataTable dataTable) throws Throwable {
        login = new LoginPagePO(driver);



        //LoginPagePO page = new LoginPagePO();
        List<List<String>> data = dataTable.cells();
        //driver.findElement(By.name("username")).sendKeys(data.get(1).get(0));

        login.enterUsername(data.get(1).get(0));
        System.out.println("Username: "+data.get(1).get(0));
        login.enterPassword(data.get(1).get(1));
        System.out.println("Password: "+data.get(1).get(1));



        //page.Login(user.username, user.password);




    }

    @And("^User enters in (.*) and (.*) to field$")
    //@And("^User enters in ([^\"]*) and ([^\"]*)$")
    public void userEntersInUsernameAndPassword(String username, String password ) throws Throwable {
        login = new LoginPagePO(driver);
        login.enterUsername(username);
        System.out.println("Username: "+ username);
        login.enterPassword(password);
        System.out.println("Password: "+ password);
        //Thread.sleep(5000);


/*        base.driver.findElement(By.name("username")).sendKeys(username);
        base.driver.findElement(By.name("password")).sendKeys(password);
        System.out.println("Username: "+ username);
        System.out.println("Password: "+ password);*/


    }

    @And("^User enters the email added as Email: (.*)$")
    public void userEntersTheEmailAddedAsEmailAdmin(String email)  throws Throwable {
        System.out.println("The Email Address is " + email);

    }

/*    @And("UserSam enters in the following for username and password in newlogin page")
    public void usersamEntersInTheFollowingForUsernameAndPasswordInNewloginPage() throws Throwable {
            List<User> users = new ArrayList<~>();
            users = table.asList(User.Class);

            for (User user: users){
                base.driver.findElement(By.name("UserName")).sendKeys(user.username);
                base.driver.findElement(By.name("Password")).sendKeys(user.password);
            }
            System.out.println("Username: "+data.get(1).get(0));
            System.out.println("Password: "+data.get(1).get(1));
    }*/
}
