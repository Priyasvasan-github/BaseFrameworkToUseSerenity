package apis;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.json.Json;

import static net.serenitybdd.rest.RestRequests.given;


/**
 * Created by Sripriya Srinivasan on 12/3/2018.
 */
public class APIMethods {

    @Step
    public void getCityWeather(String cityCode){
        try{
                Response restAPIResponse = given()
                    .header("Accept", "*/*")
                    .header("Authorization", "")
                    .header("Content-Type","application/json").when().log().all().get("http://restcountries.eu/rest/v1/capital/"+cityCode);

            String responseAsString =restAPIResponse.asString();
            String formattedResponse = responseAsString.substring(1, responseAsString.length()-1);

            //Json object always fetches only first element
            JSONObject  restAPIResponseObject = new JSONObject (formattedResponse);
            Serenity.setSessionVariable("endResponse").to(formattedResponse);
            Serenity.setSessionVariable("response"+cityCode).to(restAPIResponseObject.getString("name"));

            JSONArray callingCodesArray = new JSONArray(restAPIResponseObject.getString("callingCodes"));
            Serenity.setSessionVariable("callingCode"+cityCode).to(callingCodesArray.getString(0));

            JSONObject translationsObject = new JSONObject(restAPIResponseObject.getString("translations"));
            Serenity.setSessionVariable("translations"+cityCode).to(translationsObject.getString("es"));

            //Json path is to fetch the data when there are multiple values
            JsonPath test = new JsonPath(restAPIResponse.getBody().asString());
            System.out.println("This Value is"+test.getString("name")+" Json Body is "+restAPIResponseObject.get("name"));
        }catch (Exception e){
            System.out.println("Error is"+e.getMessage());
        }
    }
}
