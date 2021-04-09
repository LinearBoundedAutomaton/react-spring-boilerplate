package electrosphere.api.security.auth;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.springframework.stereotype.Service;

/**
 *
 * @author lba
 */
@Service
public class AuthAttemptService {
    
    private static int MAX_ATTEMPTS_ALLOWED = 10;
    private LoadingCache<String,Integer> attemptsCache;
    
    
    public AuthAttemptService(){
        super();
        attemptsCache = CacheBuilder.newBuilder()
                .expireAfterWrite(1, TimeUnit.DAYS)
                .build(
                        new CacheLoader<String,Integer>() {
                            public Integer load(String key){
                                return 0;
                            }
                        }
                );
    }
    
    public void loginSucceeded(String key){
        attemptsCache.invalidate(key);
    }
    
    public void loginFailed(String key){
        int attempts = 0;
        try {
            attempts = attemptsCache.get(key);
            if(attempts > MAX_ATTEMPTS_ALLOWED){
                System.out.println("User should not have been allowed to login.");
            }
        } catch (ExecutionException e){
            attempts = 0;
        }
        attempts++;
        attemptsCache.put(key,attempts);
    }
    
    public boolean isBlocked(String key){
        try {
            return attemptsCache.get(key) >= MAX_ATTEMPTS_ALLOWED;
        } catch (ExecutionException e){
            return false;
        }
    }
}
