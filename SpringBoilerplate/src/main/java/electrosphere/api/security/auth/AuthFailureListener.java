package electrosphere.api.security.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

/**
 *
 * @author lba
 */
@Component
public class AuthFailureListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent>{

    @Autowired
    private AuthAttemptService authAttemptService;

    
    @Override
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent e) {
        WebAuthenticationDetails auth = (WebAuthenticationDetails) e.getAuthentication().getDetails();
        System.out.println("Login failure");
        authAttemptService.loginFailed(auth.getRemoteAddress());
    }
    
}
