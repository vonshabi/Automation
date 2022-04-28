import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.junit.Assert.assertEquals;
import java.time.Duration;

public class MyStepdefs {


    private WebDriver driver;

    @Given("I have written my email {string}")
    public void IHaveWrittenMyEmail(String email) {
        System.out.println(email);
        System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://login.mailchimp.com/signup/");
        sendKeys(driver, By.id("email"), email);
    }

    @Given("I have written my username {string}")
    public void IHaveWrittenMyUsername(String username) {
        System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://login.mailchimp.com/signup/");
        sendKeys(driver, By.id("new_username"), username);
    }
    @Given("I have written my password {string}")
    public void Ihavewrittenmypassword(String password) {
        sendKeys(driver, By.id("new_password"), password);
    }
    @When("I click the signup button")
    public void IClickTheSignupButton() {
        scroll(driver);
        click(driver, By.id("create_account"));
    }
    @Then("Another page is displayed")
    public void AnotherPageIsDisplayed() {
        String expected = "check your email";
        String actual = getText(driver, By.xpath("//*[@id=\"signup-content\"]div/div/div/h1"));
        assertEquals(expected, actual);
        driver.quit();
    }
    @Then("It cannot create an account")
    public void ItCannotCreateAnAccount() {
        String expected = "This username already exists.";
        String acutal = getText(driver, By.xpath("//*[@id=\"signup-form\"]/fieldset/div[2]/div/span"));
        assertEquals(expected, acutal);

        driver.quit();
    }
    @Given("I have written an existing username {string}")
    public void iHaveWrittenAnExistingUsername(String username) {
        sendKeys(driver, By.id("new_username"), username);
    }

    @Given("I have written my username, at least {int}chars {string}")
    public void iHaveWrittenMyUsernameAtLeastChars(int args0, String arg1) {
        sendKeys(driver, By.id("new_username"), "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
    }

    @Given("I have written my username {string}")
    public void iHaveWrittenMyUsername(String username) {
        System.setProperty("wwebdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://login.mailchimp.com/signup/");
        sendKeys(driver, By.id("new_username"), username);
    }

    @When("I have written my username {string}")
    public void iHaveWrittenMyUser(String username) {
        sendKeys(driver, By.id("new_username"), username);
    }
    @When("I click the signup button")
    public void iClickTheSignUpButton() {
        scroll(driver);
        click(driver, By.id("create_account"));
    }

    @Then("it cannot create an accout")
    public void itCannotCreateAnAccount() {
        String expected = "This username already exists.";
        String acutal = getText(driver, By.xpath("//*[@id=\"signup-form\"]/fieldset/div[2]/div/span"));
        assertEquals(expected, acutal);

        driver.quit();
    }
    @Then("It cannot create an account, too many characters")
    public void itCannotCreateAccountTooManyCharacters() {
        String expected = "enter a value less than 100 characters long";
        String acutal = getText(driver, By.xpath("//*[@id=\"signup-form\"]/fieldset/div2"));
        assertEquals(expected, acutal);
        driver.quit();
    }

    @Then("It cannot create an account, mail is missing")
    public void itCannotCreateAccountMailIsMissing() {
        String expected = "Enter a value";
        String actual = getText(driver, By.xpath("//*[@id=\"signup-form\"]/fieldset/div[1]/div/span"));
        assertEquals(expected, actual);
        driver.quit();
    }

    private String getText(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
        String text = element.getText();
        return text;
    }

    private static void sendKeys(WebDriver driver, By by, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
        ((WebElement) element).sendKeys(text);
    }

    private static void click(WebDriver driver, By by) {
        WebDriverWait foobar = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = foobar.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }

    private static void scroll(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250", "");
    }
}
