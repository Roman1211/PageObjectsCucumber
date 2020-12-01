package ru.stqa.items.cucumber;

import io.cucumber.java8.En;
import static org.junit.Assert.assertEquals;
import ru.stqa.items.app.Application;

public class itemsStepdefs implements En {
    private static Application app = new Application();
    private int quantity = 0;

    public itemsStepdefs() {
        Given("^we open main page$", () -> {
            app.openMainPage();
        });
        When("^we add item to cart$", () -> {
            app.addItemToCart();
        });
        Then("^number of items increases to (\\d+)$", (Integer quantity_up) -> {
            app.checkItemsQuantity();
            quantity +=1;
            assertEquals(java.util.Optional.ofNullable(quantity_up), java.util.Optional.ofNullable(quantity));
        });
        Given("^we open cart page$", () -> {
            app.openCart();
        });
        When("^we delete all items one by one$", () -> {
            app.deleteItems();
        });
        Then("^we close page$", () -> {
            app.quit();
        });
    }
}
