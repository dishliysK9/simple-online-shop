package onlineshop.services.implementations;

import java.util.Arrays;

import onlineshop.entities.User;
import onlineshop.services.UserManagementService;

public class DefaultUserManagementService implements UserManagementService{

    private static final String NOT_UNIQUE_EMAIL_ERROR_MESSAGE = "This email is already used by another user. Please, use another email";
	private static final String EMPTY_EMAIL_ERROR_MESSAGE = "You have to input email to register. Please, try one more time";
	private static final String NO_ERROR_MESSAGE = "";
	
	private static final int DEFAULT_USERS_CAPACITY = 10;

    private static DefaultUserManagementService instance;

    private User[] users;
	private int lastUserIndex;

    {
		users = new User[DEFAULT_USERS_CAPACITY];
	}

    private DefaultUserManagementService() {
	}

    public static UserManagementService getInstance(){
        if (instance == null){
            instance = new DefaultUserManagementService();
        }
        return instance;
    }

    private String checkUniqueEmail(String email){
        if (email == null || email.isEmpty()){
            return EMPTY_EMAIL_ERROR_MESSAGE;
        }
        for (User user : users){
            if (user != null && user.getEmail() != null && user.getEmail().equalsIgnoreCase(email)){
                return NOT_UNIQUE_EMAIL_ERROR_MESSAGE;
            }
        }
        return NO_ERROR_MESSAGE;
    }

    public String registerUser(User user){

        if (user == null) {
			return NO_ERROR_MESSAGE;
		}
        
        String errorMessage = checkUniqueEmail(user.getEmail());
        if (errorMessage != null && !errorMessage.isEmpty()) {
			return errorMessage;
		}

        if (users.length <= lastUserIndex) {
			users = Arrays.copyOf(users, users.length << 1);
		}
		
		users[lastUserIndex++] = user;
		return NO_ERROR_MESSAGE;
    }

    public User[] getUsers(){

        int nonNullUsersAmmount  = 0;

        for (User user : users){
            if (user != null){
                nonNullUsersAmmount++;
            }
        }

        User[] nonNullUsers = new User[nonNullUsersAmmount];

        int index = 0;

        for(User user : users){

            if (user != null){

            nonNullUsers[index++] = user;

            }

        }

        return nonNullUsers;
    }

    public User getUserByEmail(String userEmail){

        for (User user : users){
            if(user != null && user.getEmail().equalsIgnoreCase(userEmail)){
                return user;
            }
        }

        return null;

    }

    void clearServiceState() {
        lastUserIndex = 0;
        users = new User[DEFAULT_USERS_CAPACITY];
    }
}
