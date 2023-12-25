package amazon_test.pages;

import amazon_test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Locators extends BasePageUtil {

    public Locators() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id="nav-signin-tooltip")
    public  WebElement loginButton;

    @FindBy(id="ap_email")
    public WebElement emailField;

    @FindBy(id="ap_password")
    public WebElement passwordField;

    @FindBy(id="continue")
    public WebElement continueLink;

    @FindBy(id="signInSubmit")
    public WebElement signInButton;

    @FindBy(id="twotabsearchtextbox")
    public  WebElement searchBox;

    @FindBy(xpath = "//span[text()='Cell Phones']")
    public WebElement cepTelefonMenu;

    @FindBy(xpath = "//a[@aria-label='Go to page 2']")
    public WebElement page2Link;

    @FindBy(xpath = "//div[@cel_widget_id='MAIN-SEARCH_RESULTS-6']")
    public WebElement fifthProduct;

    @FindBy(id="add-to-wishlist-button-submit")
    public WebElement likeButton;

    @FindBy(id="wl-redesigned-create-list")
    public WebElement createList;

    @FindBy(id="wl-huc-post-create-msg")
    public WebElement popupMessage;

    @FindBy(xpath="//button[text()='Continue shopping']")
    public WebElement continueShopping;

    @FindBy(id="nav-link-accountList-nav-line-1")
    public WebElement accountLink;

    @FindBy(xpath="//span[@class='nav-text' and text()='Shopping List']")
    public WebElement wishlistLink;

    @FindBy(xpath="//*[starts-with(@id, 'pab-declarative')]")
    public WebElement chooseOptions;

    @FindBy(id="nav-cart-text-container")
    public WebElement shoppingCard;

    @FindBy(xpath="//*[starts-with(@id, 'sc-active')]")
    public WebElement cartPopupMessage;

    @FindBy(id="nav-cart")
    public WebElement cartLink;

    @FindBy(xpath="//input[@value='Delete']")
    public WebElement  deleteButton;

    @FindBy(xpath=" //h1[@class='a-spacing-mini a-spacing-top-base']")
    public WebElement  emptyCart;


    @FindBy(xpath="//div[@data-card-identifier='YourLists_C']")
    public WebElement  yourLists;

    @FindBy(id="overflow-menu-popover-trigger")
    public WebElement  moreOptions;
    @FindBy(id="editYourList")
    public WebElement  editYourList;

    @FindBy(xpath="//span[@class='a-button a-spacing-base a-button-base full-width-element']")
    public WebElement  deleteList;

    @FindBy(xpath = "//input[@name='submit.save']")
    public WebElement  deleteConfirm;

    @FindBy(id = "nav-logo")
    public WebElement  homePage;

}
