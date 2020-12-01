package ru.stqa.items.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
public class ItemPage extends Page{
    public ItemPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = ".//select[@name = 'options[Size]']")
    public WebElement sizeSelector;
    @FindBy(xpath = ".//button[@name = 'add_cart_product']")
    private WebElement addButton;
    @FindBy(xpath = ".//span[@class = 'quantity']")
    private WebElement quantity;
    public int oldQuantity=0;

    public void selectSize(){
        if (elementIsPresent(".//select[@name = 'options[Size]']")) {
            WebElement sel = driver.findElement(By.xpath(".//select[@name = 'options[Size]']"));
            Select size = new Select(sel);
            size.selectByValue("Small");
        }
    }

    public void addItem(){
        oldQuantity = Integer.parseInt(quantity.getText());
        addButton.click();
    }

    public void checkQuantity(){
        wait.until((WebDriver driver) -> Integer.parseInt(quantity.getText()) - oldQuantity == 1);
    }

    private boolean elementIsPresent(String xpath) {          //метод для определения присутсвия элемента на странице
        try {
            driver.findElement(By.xpath(xpath));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
    public void goBack(){
        driver.navigate().back();
    }
}
