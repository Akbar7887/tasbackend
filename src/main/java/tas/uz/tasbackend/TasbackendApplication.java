package tas.uz.tasbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import tas.uz.tasbackend.service.fileupload.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class TasbackendApplication extends Exception {

    public static void main(String[] args) {
        SpringApplication.run(TasbackendApplication.class, args);
    }

//    @Bean
//    public ServletWebServerFactory servletContainer() {
//
//        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
//
//            @Override
//            protected void postProcessContext(Context context) {
//                SecurityConstraint securityConstraint = new SecurityConstraint();
//                securityConstraint.setUserConstraint("CONFIDENTIAL");
//                SecurityCollection collection = new SecurityCollection();
//                collection.addPattern("/*");
//                securityConstraint.addCollection(collection);
//                context.addConstraint(securityConstraint);
//            }
//        };
//
//        tomcat.addAdditionalTomcatConnectors(httpToHttpRedirectConnector());
//        return tomcat;
//    }
//
//    private Connector httpToHttpRedirectConnector() {
//
//        Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
//        connector.setScheme("http");
//        connector.setPort(8083);
//        connector.setSecure(false);
//        connector.setRedirectPort(8087);
//        return connector;
//
//    }
}

