package electrosphere.api.security.user;

/**
 *
 * @author lba
 */
public class UserRepository {
    
    public static User findByUsername(String username){
        User rVal = null;
        if(username.matches("user")){
            rVal = new User();
            rVal.setId(1L);
            rVal.setUsername("user");
            rVal.setPassword("{noop}password");
        }
        return rVal;
    }
    
}
