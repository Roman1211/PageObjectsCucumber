package ru.stqa.items.tests;
import ru.stqa.items.app.Application;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
    public Application app;
    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void start() {
        app = new Application();

    }


}