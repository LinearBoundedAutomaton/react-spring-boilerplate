package electrosphere.main;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.WebApplicationInitializer;

/**
 *
 * @author lba
 */
@Configuration
@Import({ org.springdoc.core.SpringDocConfiguration.class, 
          org.springdoc.webmvc.core.SpringDocWebMvcConfiguration.class,
          org.springdoc.webmvc.ui.SwaggerConfig.class,
          org.springdoc.core.SwaggerUiConfigProperties.class,
          org.springdoc.core.SwaggerUiOAuthProperties.class,
          org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration.class
})
public class LocalSwaggerConfig implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext sc) throws ServletException {
        System.out.println("Initialized swagger");
    }
    
}
