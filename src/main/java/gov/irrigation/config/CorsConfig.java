package gov.irrigation.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").
                allowCredentials(true).

                allowedOrigins("http://gp-iprights-app-container-frontend.development.internal.saip.gov.sa"
                        , "http://gp-iprights-app-container-frontend.test.internal.saip.gov.sa"
                        , "http://gp-iprights-app-container-frontend.staging.internal.saip.gov.sa"
                        , "http://gp-iprights-app-container-se-frontend.development.internal.saip.gov.sa"
                        , "http://app.local.iprs.saip.gov.sa:3000","http://admin.app.local.iprs.saip.gov.sa:4000").
                allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS").
                allowedHeaders("*"). //"Origin, X-Requested-With, Content-Type, Accept, " + "X-CSRF-TOKEN"
                exposedHeaders("Access-Control-Allow-Credentials");//"Vary","Access-Control-Max-Age", "Access-Control-Allow-Credentials","Access-Control-Allow-Methods" "Access-Control-Allow-Headers"
    }

}