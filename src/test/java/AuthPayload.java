import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthPayload { //set up JSON object to be used in LoginAPITest

    //first, declare JSON class variables
    @JsonProperty
    private String email;
    @JsonProperty
    private String password;

    //next, we create a constructor that lets us pass the email & pw parameters
    public AuthPayload(String email, String password) {
        this.email = email;
        this.password = password;
    }

    //finally, our tooling converts this class into JSON object using "get" functions
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }

}
