package ru.stqa.items.app;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.items.pages.CartPage;
import ru.stqa.items.pages.ItemPage;
import ru.stqa.items.pages.MainPage;

public class Application {
    private WebDriver driver;
    private MainPage mainPage;
    private ItemPage itemPage;
    private CartPage cartPage;


    public Application() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        itemPage = new ItemPage(driver);
        cartPage = new CartPage(driver);
    }

    public void openMainPage(){
        mainPage.open();
    }

    public void addItemToCart() {
        mainPage.item.click();
        itemPage.selectSize();
        itemPage.addItem();
    }

    public int checkItemsQuantity() {
        itemPage.checkQuantity();
        itemPage.goBack();
        return itemPage.oldQuantity + 1;
    }

    public void openCart(){
        cartPage.open();
    }

    public void deleteItems() throws InterruptedException {
        cartPage.removeItems();
    }


    public void quit() {
        driver.quit();
    }

}
