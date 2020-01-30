package base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.lang3.RandomStringUtils;


import io.restassured.RestAssured;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import resources.Environment;
import resources.JsonPaths;

public class BaseClass {

	public static Environment ENV;
	public static JsonPaths JP;
	public String Responsestr;
	public Response response;
	public RequestSpecification request;

	//private Scenario scenario;
	/*
	 * @BeforeTest(alwaysRun = true)
	 * 
	 * @Parameters({ "environment" }) public void beforeTest(String environment) {
	 * /// System.out.println(environment); ConfigFactory.setProperty("env",
	 * environment); System.out.println(ConfigFactory.setProperty("env",
	 * environment)); ENV = ConfigFactory.create(Environment.class);
	 * System.out.println("ENV Value" + ENV);
	 * 
	 * }
	 */

 
	public static String transactionid() {
		String transactionid = "RESTASSURED_CUCUMBER_" + RandomStringUtils.randomAlphanumeric(10);
		return transactionid;
	}

	public static String generateStringFromResource(String path) throws IOException {
		System.getProperty("user.dir");
		return new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir"), path)));

	}

	public static RequestSpecification givenreq() throws IOException {
		RestAssured.urlEncodingEnabled = true;
		RequestSpecification httpRequest = RestAssured.given();

		return httpRequest;

	}

	public static void generatepayload(String filePath, String opfilePath, String oldString, String newString) {
		System.out.println("filePath::" + filePath);
		System.out.println("outputfilePath::" + opfilePath);

		File fileToBeModified = new File(filePath);
		File fileToBeModifiedat = new File(opfilePath);
		String oldContent = "";
		BufferedReader reader = null;

		FileWriter writer = null;

		try {
			reader = new BufferedReader(new FileReader(fileToBeModified));

			// Reading all the lines of input text file into oldContent

			String line = reader.readLine();

			while (line != null) {
				oldContent = oldContent + line + System.lineSeparator();

				line = reader.readLine();
			}

			// Replacing oldString with newString in the oldContent

			String newContent = oldContent.replaceAll(oldString, newString);

			// Rewriting the input text file with newContent

			writer = new FileWriter(fileToBeModifiedat);

			writer.write(newContent);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// Closing the resources

				reader.close();

				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
