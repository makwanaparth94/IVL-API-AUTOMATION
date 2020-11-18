package testbase;

public interface EndPoint {

	//User Endpoints
	String LOGIN						="/login";
	String CREATE_USER 					="/users";
	String GET_USER 					="/users";
	String DELETE_USER 					="/users/{user_id}";
	
}
