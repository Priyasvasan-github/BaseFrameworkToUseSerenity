package pageMethods;

import net.thucydides.core.annotations.Step;
import pageObjects.HomePage;

/**
 * Created by Sripriya Srinivasan on 12/3/2018.
 */
public class HomePageMethods {

    private HomePage homePage;

    @Step
    public void launch(){
        homePage.open();
    }

    @Step
    public boolean isHomePageDisplayed(){
        return homePage.verifyHomePageisLoaded();
    }

    @Step
    public void navigateToLogin(){
        homePage.clickLoginLink();
    }

    @Step
    public boolean isLoginFormDisplayed(){
        return homePage.verifyLoginFormisDisplayed();
    }
}
