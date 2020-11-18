package extentreports;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;

public class ExtentMethods {
	
/*---------------------------------------------For General Comments----------------------------------------------------------------*/	

	public static void Extentlogs_GeneralComments(String body)
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, body);
	}
	
	public static void Extentlogs_Error(String error ) 
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, "Failure Error : \n"+ error );
	}
	
	
/*-----------------------------------------For POST request with JSON body-----------------------------------------------------------------------------*/
	
	//Print with Iteration (Test number)
	public static void Extentlogs_POST_Request(Object Requestbody, Response response, String Endpoint, int iteration, String comment  ) 
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, "Test Info (POST Request): " + comment);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Test iteration (For D.D.T) is : " + iteration);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Endpoint is : " +Endpoint);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Request body is : " +Requestbody.toString());
		ExtentTestManager.getTest().log(LogStatus.INFO, "Response is : " +response.asString());
	}
	
	//Print without Iteration (Overridden)
	public static void Extentlogs_POST_Request(Object Requestbody, Response response, String Endpoint, String comment) 
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, "Test Info : " + comment);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Endpoint is : " +Endpoint);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Request body is : " +Requestbody.toString());
		ExtentTestManager.getTest().log(LogStatus.INFO, "Response is : " +response.asString());
	}

	
/*-----------------------------------------For GET request without Parameter-----------------------------------------------------------------------------*/

	public static void Extentlogs_GET_WithoutParam(Response response, String Endpoint, int iteration, String comment) 
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, "Test Info : " + comment);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Test iteration (For D.D.T) is : " + iteration);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Endpoint is : " +Endpoint);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Response is : " +response.asString());
	}

	//Overridden above method
	public static void Extentlogs_GET_WithoutParam(Response response, String Endpoint, String comment) 
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, "Test Info : " + comment);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Endpoint is : " +Endpoint);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Response is : " +response.asString());
	}

/*---------------------------------------For DELETE request Parameter with URL-------------------------------------------------------------------------------*/
	
	//Print with Iteration (Test number) [Below method is for Delete request but only when we pass parameter from url]
	public static void Extentlogs_DELETE_Request(Object Urlparameter, Response response, String Endpoint, int iteration, String comment) 
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, "Test Info : " + comment);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Test iteration (For D.D.T) is : " + iteration);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Endpoint is : " +Endpoint);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Request URL Parameter is : " +Urlparameter.toString());
		ExtentTestManager.getTest().log(LogStatus.INFO, "Response is : " +response.asString());
	}
		
		
	//Print without Iteration (Overridden)
	public static void Extentlogs_DELETE_Request(Object Urlparameter, Response response, String Endpoint, String comment) 
	{
		ExtentTestManager.getTest().log(LogStatus.INFO, "Test Info : " + comment);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Endpoint is : " +Endpoint);
		ExtentTestManager.getTest().log(LogStatus.INFO, "Request URL Parameter is : " +Urlparameter.toString());
		ExtentTestManager.getTest().log(LogStatus.INFO, "Response is : " +response.asString());
	}
		
			
	
}
