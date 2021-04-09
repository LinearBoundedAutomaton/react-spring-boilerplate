package electrosphere.api.security.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

/**
 *
 * @author lba
 */
@Component
public class AuthSuccessListener implements ApplicationListener<AuthenticationSuccessEvent>{

    @Autowired
    private AuthAttemptService authAttemptService;
    
    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent e) {
        WebAuthenticationDetails auth = (WebAuthenticationDetails) e.getAuthentication().getDetails();
        System.out.println("Login success");
        authAttemptService.loginSucceeded(auth.getRemoteAddress());
    }
    
}
