package services.FakeAPIService;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import testbase.EndPoint;
import testbase.TestConfiguraionProperties;
import static io.restassured.RestAssured.given;

import java.util.Map;

public class FakeAPISetService {

	TestConfiguraionProperties testConfig = new TestConfiguraionProperties();

	/*
	 * Create Fake User
	 */
	public Response createUser(Map userData) {

		Response response = null;
		RestAssured.baseURI = testConfig.getbaseURI();
		RestAssured.basePath = testConfig.getbasePath();

		try {
			response = given()
					.contentType(ContentType.JSON) 
					.body(userData)
					.log().all()
					.when()
					.post(EndPoint.CREATE_USER);
			return response;
		} catch (Exception e) {
			System.out.println("Something went wrong (Create an User):" + e.getMessage());
			return null;
		}
	}

	/*
	 * Get List of Fake User
	 */
	public Response getAllUser() {

		Response response = null;
		RestAssured.baseURI = testConfig.getbaseURI();
		RestAssured.basePath = testConfig.getbasePath();

		try {
			response = given()
					.contentType(ContentType.JSON) 
					.log().all()
					.when()
					.get(EndPoint.GET_USER);
			return response;
		} catch (Exception e) {
			System.out.println("Something went wrong (Get all User data):" + e.getMessage());
			return null;
		}
	}

	/*
	 * Get detail of Fake User
	 */
	public Response getUser(String userid) {

		Response response = null;
		RestAssured.baseURI = testConfig.getbaseURI();
		RestAssured.basePath = testConfig.getbasePath();

		try {
			response = given()
					.queryParam("user", userid)
					.contentType(ContentType.JSON) 
					.log().all()
					.when()
					.get(EndPoint.GET_USER);
			return response;
		} catch (Exception e) {
			System.out.println("Something went wrong (Get an User):" + e.getMessage());
			return null;
		}
	}
	/*
	 * Delete Fake User
	 */
	public Response deleteUser(String userid) {

		Response response = null;
		RestAssured.baseURI = testConfig.getbaseURI();
		RestAssured.basePath = testConfig.getbasePath();

		try {
			response = given()
					.pathParam("user_id", userid)
					.contentType(ContentType.JSON) 
					.log().all()
					.when()
					.delete(EndPoint.DELETE_USER);
			return response;
		} catch (Exception e) {
			System.out.println("Something went wrong (Delete an User):" + e.getMessage());
			return null;
		}
	}
}
