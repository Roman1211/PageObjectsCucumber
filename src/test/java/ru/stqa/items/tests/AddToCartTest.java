package ru.stqa.items.tests;
import org.junit.Test;
public class AddToCartTest extends BaseTest{
    @Test
    public void test() throws InterruptedException {
        app.openMainPage();
        for (int i = 0; i < 3; i++){
            app.addItemToCart();
            app.checkItemsQuantity();
        }
        app.deleteItems();
        app.quit();
    }
}
