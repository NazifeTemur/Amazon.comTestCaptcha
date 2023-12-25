package amazon_test.tests;

import amazon_test.pages.Locators;
import amazon_test.utilities.ExcelUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.awt.*;


public class AmazonTest extends TestBase {

    @Test
    public void VerifyLikedBasketTest() throws AWTException {
        String mainWindowId= driver.getWindowHandle();

        extentLogger = report.createTest("Amazon.com alışveriş süreçleri testi");

        Locators mainPage = new Locators();


        extentLogger.info("Site görüntülenmesi kontrol ediliyor");
        assert driver.getTitle().contains("Amazon") : "Amazon anasayfa yüklenemedi.";


        extentLogger.info("Siteye mevcut üyelikle, excelden veriler alınarak giriş yapılıyor");
        mainPage.waitUntilVisible(mainPage.loginButton);
        mainPage.clickFunction(mainPage.loginButton);
        mainPage.sendKeysFunction(mainPage.emailField, emailaddress);
        mainPage.clickFunction(mainPage.continueLink);
        mainPage.sendKeysFunction(mainPage.passwordField, password);
        mainPage.clickFunction(mainPage.signInButton);
        extentLogger.info("Kullanıcı girişi yapıldığında görüntülenebilen menü seçeneklerinden olan -buy again- kontrol ediliyor ");
        assert driver.getPageSource().toLowerCase().contains("buy again") : "Giriş Yapılamadı.";


        extentLogger.info("Samsung kelimesi ile arama yapılıyor");
        mainPage.sendKeysFunction(mainPage.searchBox, "Samsung");
        mainPage.searchBox.sendKeys(Keys.RETURN);

        mainPage.clickFunction(mainPage.cepTelefonMenu);

        extentLogger.info("Samsung arama sonuçları kontrol ediliyor ");
        assert driver.getPageSource().toLowerCase().contains("samsung") : "Samsung için sonuç bulunamadı.";


        extentLogger.info("2. sayfa gösterimi kontrol ediliyor " );
        mainPage.waitUntilVisible(mainPage.page2Link);
        Assert.assertTrue(mainPage.page2Link.isDisplayed(), "2. sayfa yok.");
        mainPage.clickFunction(mainPage.page2Link);

        mainPage.waitUntilVisible(mainPage.fifthProduct);
        mainPage.clickFunction(mainPage.fifthProduct);

        mainPage.waitUntilVisible(mainPage.likeButton);
        mainPage.clickFunction(mainPage.likeButton);

        mainPage.waitUntilVisible(mainPage.createList);
        mainPage.clickFunction(mainPage.createList);

        extentLogger.info("Listelerime ürün ekleme kontrol ediliyor");
        mainPage.waitUntilVisible(mainPage.popupMessage);
        assert mainPage.popupMessage.getText().toLowerCase().contains("1 item added to shopping list") : "Ürün eklenemedi.";

        mainPage.waitUntilVisible(mainPage.continueShopping);
        mainPage.clickFunction(mainPage.continueShopping);

        mainPage.waitUntilClickable(mainPage.accountLink);
        mainPage.clickWithJS(mainPage.accountLink);

        mainPage.waitUntilClickable(mainPage.yourLists);
        mainPage.clickFunction(mainPage.yourLists);

        extentLogger.info("Listelerim sayfasında ürün bulunduğu kontrol ediliyor");
        assert mainPage.chooseOptions.getText().toLowerCase().contains("add to cart") : "Listelerim sayfasında ürün bulunamadı.";
        mainPage.waitUntilClickable(mainPage.chooseOptions);
        mainPage.clickFunction(mainPage.chooseOptions);

        mainPage.waitUntilClickable(mainPage.shoppingCard);
        mainPage.clickFunction(mainPage.shoppingCard);

        extentLogger.info("Ürün sepete ekleme işlemi kontrol ediliyor");
        assert mainPage.cartPopupMessage.getText().toLowerCase().contains("samsung") : "Ürün sepete eklenemedi.";

        mainPage.waitUntilClickable(mainPage.cartLink);
        mainPage.clickFunction(mainPage.cartLink);

        mainPage.waitUntilClickable(mainPage.deleteButton);
        mainPage.clickFunction(mainPage.deleteButton);

        extentLogger.info("Alışveriş sepetinde ürün olup olmadığı kontrol ediliyor");
        assert mainPage.emptyCart.getText().toLowerCase().contains("your amazon cart is empty.") : "Sepette hala ürün var.";

        mainPage.waitUntilClickable(mainPage.accountLink);
        mainPage.clickWithJS(mainPage.accountLink);

        mainPage.waitUntilClickable(mainPage.yourLists);
        mainPage.clickFunction(mainPage.yourLists);

        mainPage.waitUntilClickable(mainPage.moreOptions);
        mainPage.clickFunction(mainPage.moreOptions);

        mainPage.waitUntilClickable(mainPage.editYourList);
        mainPage.clickFunction(mainPage.editYourList);

        mainPage.waitUntilClickable(mainPage.deleteList);
        mainPage.clickFunction(mainPage.deleteList);

        mainPage.waitUntilClickable(mainPage.deleteConfirm);
        mainPage.clickWithJS(mainPage.deleteConfirm);

        try {Thread.sleep(3000);} catch (InterruptedException e)
        {e.printStackTrace();}

        mainPage.waitUntilClickable(mainPage.homePage);
        mainPage.clickFunction(mainPage.homePage);

        extentLogger.pass("PASS: Test");
        System.out.println("Test başarılı!");
    }
}








