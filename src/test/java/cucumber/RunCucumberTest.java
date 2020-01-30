package cucumber;

import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseClass;
import cucumber.api.CucumberOptions;

import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

import resources.Environment;
import resources.JsonPaths;

@CucumberOptions(features = "src/test/resources/cucumber", glue = { "base", "rrpairs", "resources", "listeners",
		"cucumber" }, plugin = {"pretty","json:target/cucumber.json"}, monochrome = true)
public class RunCucumberTest extends BaseClass {
	private TestNGCucumberRunner testNGCucumberRunner;


	
	
	@BeforeClass(alwaysRun = true)
	@Parameters({ "environment" , "apiver"})
	public void setUpClass(String environment, String apiver) throws Exception {
		ConfigFactory.setProperty("env", environment);
		ConfigFactory.setProperty("ver", apiver);
		ENV = ConfigFactory.create(Environment.class);
		JP = ConfigFactory.create(JsonPaths.class);
		System.out.println("Environment Chosen:" + ConfigFactory.getProperty("env"));
		System.out.println("API version Chosen:" + ConfigFactory.getProperty("ver"));

		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}

	@Test(groups = "Cucumber", description = "Runs Cucumber Feature", dataProvider = "scenarios")
	public void scenario(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cucumberFeature) throws Throwable {
		testNGCucumberRunner.runScenario(pickleEvent.getPickleEvent());
		
	}

	@DataProvider
	public Object[][] scenarios() {
		return testNGCucumberRunner.provideScenarios();
	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() throws Exception {
		testNGCucumberRunner.finish();

	}

}