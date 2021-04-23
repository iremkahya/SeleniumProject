package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Elements {
    public static WebDriver driver;

    public Elements(WebDriver webDriver){
        driver = webDriver;
    }

    public WebElement loginMenu(){
        return driver.findElement(By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[3]/div/div[1]"));
    }

    public WebElement loginLink(){
        return driver.findElement(By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[3]/div/div[1]/div[2]/div/div/div/a"));
    }

    public WebElement txtUserName(){
        return driver.findElement(By.name("kullanici"));
    }

    public WebElement txtPassword(){
        return driver.findElement(By.name("sifre"));
    }

    public WebElement loginButton(){
        return driver.findElement(By.name("pass"));
    }

    public WebElement labelAccount(){
        return driver.findElement(By.xpath("/html/body/div[1]/header/div[3]/div/div/div/div[3]/div/div[1]/div"));
    }

    public WebElement txtSearch(){
        return driver.findElement(By.xpath("/html/body/div[1]/header/div[3]/div/div/div/div[2]/form/div/div[1]/div[2]/input"));
    }

    public WebElement buttonSearch(){
        return driver.findElement(By.xpath("/html/body/div[1]/header/div[3]/div/div/div/div[2]/form/div/div[2]/button"));
    }

    public WebElement secondPageLink(){
        return driver.findElement(By.xpath("//*[@id=\"best-match-right\"]/div[5]/ul/li[2]/a"));
    }

    public WebElement secondPageLink2(){
        return driver.findElement(By.xpath("//*[@id=\"best-match-right\"]/div[4]/ul/li[3]/a"));
    }

    public WebElement product(){
        return driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[2]/div[3]/div[2]/ul/li[14]/a/div"));
    }

    public WebElement buttonAddToBasket(){
        return driver.findElement(By.id("add-to-basket"));
    }

    public WebElement productPrice(){
        return driver.findElement(By.id("sp-price-lowPrice"));
    }

    public WebElement bucketPrice(){
        return driver.findElement(By.className("product-new-price"));
    }

    public WebElement basket(){
        return driver.findElement(By.className("dIB"));
    }

    public WebElement productQuantity(){
        return driver.findElement(By.className("productQuantity"));
    }

    public WebElement productionInBasket(){
        return driver.findElement(By.className("user-cart-items-container"));
    }

    public WebElement removeFromBasket(){
        return driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[4]/div[3]/div/div/div/div[2]/div[2]/ul/li/a"));
    }

    public WebElement basketHref(){
        return driver.findElement(By.xpath("//*[@id=\"header_wrapper\"]/div[4]/div[3]/div/a"));
    }

    public WebElement basketIsEmpty(){
        return driver.findElement(By.id("empty-cart-container"));
    }

    public WebElement wrongPassword(){
        return driver.findElement(By.xpath("//*[@id=\"formlogin\"]/div[1]/div[2]/div/div[2]/span[1]"));
    }
    
     
    

}
