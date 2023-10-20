import java.util.List;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;
import java.time.Duration;


public class step {
    WebDriver driver = new ChromeDriver();

    @Given("User is logged in with username {string} and password {string}")
    public void userIsLoggedIn(String username, String password) {
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));

        System.out.println(String.format("User is logged in with username %s and password %s",username, password));
    }

    @Then("User click menu button")
    public void userClickMenuButton() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
        System.out.println("User click menu button");
    }

    @Then("User click logout")
    public void userClickLogout() {
        new WebDriverWait(driver,Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
        driver.findElement(By.id("logout_sidebar_link")).click();
        System.out.println("User click logout");
    }

    @Then("User is redirected to login page {string}")
    public void userIsRedirectedToLoginPageHttpsWwwSaucedemoCom(String url) {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.urlToBe(url));
        System.out.println(String.format("User is redirected to login page %s", url));
    }

    @Then("User click {string}")
    public void userClick(String name) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        new WebDriverWait(driver,Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='"+name+"']")));
        driver.findElement(By.xpath("//button[text()='"+name+"']")).click();
        System.out.println(String.format("User click %s",name));
    }

    @Then("User click basket button on the right top")
    public void userClickBasketButtonOnTheRightTop() {
        driver.findElement(By.className("shopping_cart_link")).click();
        System.out.println("User click basket button on the right top");
    }

    @Then("User input {string} in the {string} field")
    public void userInputFirstNameInTheFirstNameField(String value, String field) {
        driver.findElement(By.id(field)).sendKeys(value);
        System.out.println(String.format("User input %s in the %s field", value,field));
    }


    @Then("User click Add to cart for 2 items")
    public void userClickOnItems() {
        driver.findElements(By.xpath("//button[text()='Add to cart']")).get(1).click();
        driver.findElements(By.xpath("//button[text()='Add to cart']")).get(2).click();
        System.out.println("User click Add to cart for 2 items");
    }

    @Given("Open web url {string}")
    public void openWebUrl(String arg0) {
        driver.get(arg0);
        System.out.println(String.format("Open web url %s", arg0));
    }

    @Then("User input {string} in field Username")
    public void userInputInFieldUsername(String arg0) {
        WebElement uField = driver.findElement(By.id("user-name"));
        uField.sendKeys(arg0);
        System.out.println(String.format("User input %s in field Username", arg0));
    }

    @And("User input {string} in field Password")
    public void userInputInFieldPassword(String arg0) {
        WebElement pField = driver.findElement(By.id("password"));
        pField.sendKeys(arg0);
        System.out.println(String.format("User input %s in field Password", arg0));
    }

    @Then("User click Login Button")
    public void userClickLoginButton() {
        WebElement lButton = driver.findElement(By.id("login-button"));
        lButton.click();
        System.out.println("User click Login Button");
    }


    @Then("User get error {string}")
    public void userGetError(String arg0) {

        Assert.assertEquals(driver.findElement(By.xpath("//h3[@data-test='error']")).getText(),arg0);

        System.out.println(String.format("User get error %s",arg0));

    }

    @Then("User redirected to {string}")
    public void userRedirectedTo(String arg0) {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.urlToBe(arg0));
        System.out.println(String.format("User redirected to %s",arg0));
    }

    @Then("User click Continue button")
    public void userClickInputContinuebutton() {
        driver.findElement(By.id("continue")).click();
        System.out.println("User click Continue button");
    }

    @Then("User click Reset App State")
    public void userClickResetAppState() {
        new WebDriverWait(driver,Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.id("reset_sidebar_link")));
        driver.findElement(By.id("reset_sidebar_link")).click();
        System.out.println("User click Reset App State");
    }

    @Then("Cart is empty")
    public void cartIsEmpty() {
        Assert.assertTrue(driver.findElements(By.className("cart_item")).isEmpty());
        System.out.println("Cart is empty");
    }
}
