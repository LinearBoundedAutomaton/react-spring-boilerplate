package electrosphere.api.security.user;

import electrosphere.api.security.auth.AuthAttemptService;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 *
 * @author lba
 */
@Service("userDetailsService")
public class LocalUserDetailsService implements UserDetailsService {
    
    @Autowired
    AuthAttemptService authAttemptService;
    
    @Autowired
    HttpServletRequest request;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("username " + username);
        if(request == null){
            throw new RuntimeException("null request");
        }
        String ip = getClientIP();
        if(authAttemptService.isBlocked(ip)){
            throw new RuntimeException("blocked");
        }
        User user = UserRepository.findByUsername(username);
        if(user == null){
            System.out.println("Throwing exception");
            throw new UsernameNotFoundException(username);
        }
        return new LocalUserDetails(user);
    }
    
    private String getClientIP(){
        System.out.println("request " + request);
        String xfHeader = request.getHeader("X-Forwarded-For");
        if(xfHeader == null){
            return request.getRemoteAddr();
        }
        return xfHeader.split(",")[0];
    }
    
}
