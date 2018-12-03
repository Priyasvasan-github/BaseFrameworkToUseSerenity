package pageObjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * Created by Sripriya Srinivasan on 12/3/2018.
 */
public class HomePage extends PageObject {

    @FindBy(id="header")
    WebElementFacade headerLogo;

    @FindBy(xpath="//div[@id='wptAuthBar']/a[1]")
    WebElementFacade loginLink;

    @FindBy(xpath="//form[@action='member.php']")
    WebElementFacade loginForm;

    public boolean verifyHomePageisLoaded(){
        return headerLogo.isDisplayed();
    }

    public void clickLoginLink(){
        loginLink.waitUntilVisible().then().click();
    }

    public boolean verifyLoginFormisDisplayed(){
        return loginForm.isDisplayed();
    }


}
