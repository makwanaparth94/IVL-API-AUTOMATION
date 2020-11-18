package fakeTestcases;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import extentreports.ExtentMethods;
import io.restassured.response.Response;
import services.FakeAPIService.FakeAPISetService;
import testbase.EndPoint;
import testbase.TestConfiguraionProperties;
import utilities.Util;

public class DeleteUser {
	TestConfiguraionProperties config = new TestConfiguraionProperties();
	FakeAPISetService fakeService = new FakeAPISetService();
	CreateUser createUser = new CreateUser();
	Util utility  = new Util();
	
	@Test(description ="Verify deletion of an User with valid inputs")
	public void deleteUser_validInputs() {
		
		String userid;
		Object obj = createUser.createUser_SetUserData(utility.getRandomAlphanumericString());
		
		//Set up test case description
		utility.setUP_TC_Description("To remove dependency, Add an user. Then,Verify User data should delete by calling delete API with validations");
		
		/*
		 * Create an User to validate DELETE call 
		 */
		Response response = fakeService.createUser((Map) obj);
		//Logging an extent
		ExtentMethods.Extentlogs_POST_Request(((Map) obj), response, EndPoint.CREATE_USER,"Adding an User with valid inputs for delete operations");
		try {
			Assert.assertEquals(response.getStatusCode(), 201);
			userid = response.jsonPath().getString("id");
		}catch(AssertionError e) {
			ExtentMethods.Extentlogs_Error(e.getMessage());
			throw new AssertionError();
		}
				
		/*
		 * Perform DELETE Operation
		 */
		response = fakeService.deleteUser(userid);
		//Logging an extent
		ExtentMethods.Extentlogs_DELETE_Request(userid, response, EndPoint.DELETE_USER, "Create data should exists in GET call after performing delete operation");
		try {
			Assert.assertEquals(response.getStatusCode(), 204);			
		}catch(AssertionError e) {
			ExtentMethods.Extentlogs_Error(e.getMessage());
			throw new AssertionError();
		}
		
		/*
		 * Validate Delete Operation with GET CALL
		 */
		response = fakeService.getUser(userid);
		//Logging an extent
		ExtentMethods.Extentlogs_GET_WithoutParam(response, EndPoint.GET_USER+"?user="+userid, "Validate DELETED data by calling GET API");
		try {
			Assert.assertEquals(response.getStatusCode(), 200);
			List total_data = response.jsonPath().get("data");
			Assert.assertEquals(total_data.size(), 0);
		}catch(AssertionError e) {
			ExtentMethods.Extentlogs_Error(e.getMessage());
			throw new AssertionError();
		}
	}
}
