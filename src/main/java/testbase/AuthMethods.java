package testbase;

import static io.restassured.RestAssured.given;

public class AuthMethods {

	private String userToken;
	
	Credential cred = new Credential();
	TestConfiguraionProperties conf = new TestConfiguraionProperties();
	
	
	//Set User Token at run time
	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}
	
	//Generate User token for Authentication
	public String getUserToken() {
		try {
			if(userToken == null) {
				cred.setEmail(conf.getemailID());
				cred.setPassword(conf.getpassword());
				String token = given()
								.contentType("application/json")
								.body(cred)
								.expect()
								.statusCode(200)
								.when()
								.post(EndPoint.LOGIN)
								.then()
								.extract()
								.body()
								.path("token");
				setUserToken(token);
			}
			return userToken;
		}catch (Exception e) {
			System.out.println("Something went wrong (AUTHENTICATION):" + e.getMessage());
			return null;
		}
			
	}



}
