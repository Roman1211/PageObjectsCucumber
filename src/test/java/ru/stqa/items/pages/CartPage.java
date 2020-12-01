package ru.stqa.items.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBe;

public class CartPage extends Page{
    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("http://localhost/litecart/en/checkout");
    }

    @FindBy(xpath = ".//td[@class= 'item']")
    private List<WebElement> goods;
    


    public void removeItems() throws InterruptedException {
        int j = goods.size();
        for (int i = 0; i < j;  i++) {
            List <WebElement> table  = driver.findElements(By.xpath(".//td[@class= 'item']"));
            int items = table.size();
            driver.findElement(By.xpath(".//button[@name= 'remove_cart_item']")).click();
            List <WebElement> after = wait.until(numberOfElementsToBe((By.xpath(".//td[@class= 'item']")), items-1)); //ожидание обновления таблицы
            }
        }
}
