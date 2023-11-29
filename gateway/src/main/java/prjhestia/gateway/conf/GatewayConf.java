package prjhestia.gateway.conf;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConf {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
    return build.routes()
            .route("MsStore", r -> r
                    .path("/MsStore")
                    .uri("http://localhost:8082/MsStore"))
            .route("MsPerson", r -> r
                    .path("/MsPerson")
                    .uri("http://localhost:8083/MsPerson"))
            .build();
    }
}
