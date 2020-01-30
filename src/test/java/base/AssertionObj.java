package base;

import org.hamcrest.Matchers;
import java.util.logging.*;
import io.restassured.response.Response;

public class AssertionObj extends BaseClass {
	final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	public static void validatekeyc(Response response, String AssertValue) {
		response.then().assertThat().body(JP.jpkey(), Matchers.notNullValue()).log();
		response.then().assertThat().body(JP.jpkey(), Matchers.equalTo(AssertValue)).log();
		response.then().assertThat().body(JP.jpkeyc(), Matchers.notNullValue()).log();
		response.then().assertThat().body(JP.jpkeyc(), Matchers.equalTo(AssertValue)).log();

		LOGGER.log(Level.INFO, "Verified validatekeyc is::" +AssertValue );
	}
	
	public static void validatekeyd(Response response, String AssertValue) {
		response.then().assertThat().body(JP.jpkey(), Matchers.notNullValue()).log();
		response.then().assertThat().body(JP.jpkey(), Matchers.equalTo(AssertValue)).log();
		response.then().assertThat().body(JP.jpkeyc(), Matchers.notNullValue()).log();
		response.then().assertThat().body(JP.jpkeyc(), Matchers.equalTo(AssertValue)).log();

		LOGGER.log(Level.INFO, "Verified validatekeyd is::" +AssertValue );
	}
	

}

