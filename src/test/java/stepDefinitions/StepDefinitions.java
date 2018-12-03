package stepDefinitions;

import apis.APIMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import pageMethods.HomePageMethods;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Sripriya srinivasan on 12/3/2018.
 */
public class StepDefinitions {

    @Steps
    HomePageMethods homePageMethod;

    @Steps
    APIMethods apiMethods;

    @Given("^I navigate to Test webapage$")
    public void launchWebPage() {
      homePageMethod.launch();
      assertThat(homePageMethod.isHomePageDisplayed()).isTrue();
    }


    @When("^I click on Login button$")
    public void navigateToLogin() {
      homePageMethod.navigateToLogin();
    }

    @Then("^Login form is Displayed$")
    public void verifyLogin() {
      assertThat(homePageMethod.isLoginFormDisplayed()).isTrue();
    }

    @Given("^i retrieve country details of city code (.*)$")
    public void getCityDetails(String cityCode) {
        Serenity.setSessionVariable("cityCode").to(cityCode);
        apiMethods.getCityWeather(cityCode);
    }

    @Then("^Country name is displayed as (.*)$")
    public void verifyTheDetails(String countryName) {
        String expectedCountry= "response"+Serenity.sessionVariableCalled("cityCode");
        assertThat(Serenity.sessionVariableCalled(expectedCountry).toString()).isEqualToIgnoringCase(countryName);
    }

    @Then("^Calling code is displayed as (.*)$")
    public void calling_code_is_displayed_as(String countryCode) {
        String expectedCountry= "callingCode"+Serenity.sessionVariableCalled("cityCode");
        assertThat(Serenity.sessionVariableCalled(expectedCountry).toString()).isEqualToIgnoringCase(countryCode);
    }

    @Then("^Translation of country name in spanish is (.*)$")
    public void translation_of_country_name_in_spanish_is_Países_Bajos(String countryNameInSpanish) {
        String expectedCountry= "translations"+Serenity.sessionVariableCalled("cityCode");
        assertThat(Serenity.sessionVariableCalled(expectedCountry).toString()).isEqualToIgnoringCase(countryNameInSpanish);
    }



}
