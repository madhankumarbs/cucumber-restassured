package cucumber;

import java.io.IOException;

import base.AssertionObj;
import base.BaseClass;
import base.Requesthdrs;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.http.ContentType;
import resources.CustomLogFilter;
import rrpairs.Create;

public class VerifyCreate extends Create {
	public Scenario scenario;
	public Filter logFilter;
	
	
    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
        logFilter = new CustomLogFilter();
        System.out.println("logFilter======="+logFilter);
    }
	

	@Given("the Keys endpoint with headers and payload")
	public void the_Keys_endpoint_with_headers_and_payload() throws IOException {
		System.out.println(ENV);
		System.out.println(ENV.gethost());
		RestAssured.urlEncodingEnabled = false;
		RestAssured.baseURI = ENV.gethost();
		RestAssured.port = ENV.PORT();
		request = BaseClass.givenreq().headers(Requesthdrs.webheaders()).contentType(ContentType.JSON)
				.body(Create.createsomething()).log().all();
		request.filter(logFilter);
		

	}

	@When("post the payload")
	public void post_the_payload() throws IOException {
		response = request.when().post(ENV.getpath());
		Responsestr = response.getBody().asString();
		
        if (logFilter instanceof CustomLogFilter) {
            CustomLogFilter customLogFilter = (CustomLogFilter) logFilter;
            scenario.write("\n" + "API Request: " + customLogFilter.getRequestBuilder()
                    + "\n" + "API Response: " + customLogFilter.getResponseBuilder());
        }

	}

	@Then("the Keys should be successfull")
	public void the_Keys_should_be_successfull() {

		System.out.println("Response under Then:" + Responsestr);
		AssertionObj.validatekeyc(response, ENV.Key1());
		AssertionObj.validatekeyd(response, ENV.Key2());

	}

	@Then("verify the Keys are present")
	public String verify_the_Keys_are_present() {
		// Write code here that turns the phrase above into concrete actions
		return Responsestr;

	}

}
