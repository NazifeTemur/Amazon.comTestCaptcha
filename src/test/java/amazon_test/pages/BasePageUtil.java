package amazon_test.pages;

import amazon_test.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class BasePageUtil {

    WebDriverWait wait=new WebDriverWait(Driver.get(), Duration.ofSeconds(10));

    public void sendKeysFunction(WebElement element, String content)
    {
        waitUntilVisible(element);
        element.clear();
        element.sendKeys(content);
    }

    public void clickFunction(WebElement element){

         element.click();
    }

    public void waitUntilVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public void waitUntilClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].click();", element);
    }
}
