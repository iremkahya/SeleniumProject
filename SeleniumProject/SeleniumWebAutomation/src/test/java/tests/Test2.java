package tests;

import model.Elements;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.Log4j;

import java.util.concurrent.TimeUnit;

public class Test2 {
    public static WebDriver driver;
    public Actions actions;
    public JavascriptExecutor executor;
    public static String url;
    public static Elements elementPage;

    public static String email = "deneme";
    public static String password = "password";

    @Before
    public void setupDriver(){
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver = new ChromeDriver();
        url = "https://www.gittigidiyor.com";
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(200,TimeUnit.SECONDS);
        driver.manage().window().maximize();

        elementPage = new Elements(driver);
    }

    @Test
    public void testProcess(){
        actions = new Actions(driver);
        executor = (JavascriptExecutor)driver;
        Log4j.startLog("Test2");
        driver.get(url);
        Log4j.info("Opening page:" + url);
        actions.moveToElement(elementPage.loginMenu()).perform();
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        String loginLink = elementPage.loginLink().getAttribute("href");
        driver.get(loginLink);
        Log4j.info("Opening login page");
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        elementPage.txtUserName().sendKeys(email);
        elementPage.txtPassword().sendKeys(password);
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        elementPage.loginButton().submit();
        Log4j.info("Logining");
        if(!driver.getCurrentUrl().equals("https://www.gittigidiyor.com/")){
            Log4j.error("Can NOT login");
        }
        else{
            String isLogged = elementPage.labelAccount().getAttribute("title");

            if(isLogged.equals("Hesabım")){
                Log4j.info("Loginned successfully");
                elementPage.txtSearch().sendKeys("bilgisayar");
                driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
                elementPage.buttonSearch().submit();
                Log4j.info("Searching 'bilgisayar' word");
                driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
                String secondPageLink = elementPage.secondPageLink().getAttribute("href");
                driver.get(secondPageLink);
                Log4j.info("Opening second page");
                driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
                String isSecondPage = elementPage.secondPageLink2().getAttribute("class");
                if(isSecondPage.equals("current")){
                    Log4j.info("Second page is open");
                    elementPage.product().click();
                    Log4j.info("Opening product page");
                    driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
                    executor.executeScript("arguments[0].click()", elementPage.buttonAddToBasket());
                    Log4j.info("Adding product to basket");
                    driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
                    String productPrice = elementPage.productPrice().getText();
                    Log4j.info("Product price:"+productPrice);
                    driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
                    String bucketPrice = elementPage.bucketPrice().getText();
                    Log4j.info("Basket price:"+bucketPrice);
                    if(bucketPrice.equals(productPrice)){
                        Log4j.info("Product price and basket price is equal");
                        executor.executeScript("arguments[0].click()", elementPage.buttonAddToBasket());
                        Log4j.info("Adding product to basket");
                        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
                        driver.navigate().refresh();
                        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
                        actions.moveToElement(elementPage.basket()).perform();
                        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
                        int productQuantity = Integer.parseInt(elementPage.productQuantity().getAttribute("value"));
                        if(productQuantity == 2){
                            Log4j.info(productQuantity + " product(s) are in the basket");
                            actions.moveToElement(elementPage.productionInBasket()).perform();
                            driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
                            executor.executeScript("arguments[0].click()", elementPage.removeFromBasket());
                            Log4j.info("Removing products from basket");
                            String basketHRef = elementPage.basketHref().getAttribute("href");
                            driver.get(basketHRef);
                            driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
                            String basketIsEmpty = elementPage.basketIsEmpty().getAttribute("class");
                            if(basketIsEmpty.equals("clearfix")) {
                                Log4j.info("Basket is empty");
                            }
                            else {
                            	Log4j.error("Basket is NOT empty");
                            }

                        }
                        else{
                            Log4j.info("Product quantity is NOT 2");
                        }
                    }
                    else{
                        Log4j.warn("Product price is NOT equal to basket price");
                    }

                }


            }
        }

    }

    @After
    public void exitDriver(){
        Log4j.endLog("Test2");
        driver.manage().timeouts().implicitlyWait(45,TimeUnit.SECONDS);
        driver.quit();
    }
}
