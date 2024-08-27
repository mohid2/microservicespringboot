package app.vercel.mohammedelyousfi.car_service.config;


//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.security.authentication.AbstractAuthenticationToken;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.oauth2.jwt.Jwt;
//import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
//import org.springframework.security.web.SecurityFilterChain;

//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig {

//    @Bean
//    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
//        System.out.println("CONFIGURE");
//        http.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests((requests) -> requests
//                .anyRequest().authenticated())
//                .oauth2ResourceServer((oauth2) -> oauth2.jwt( (jwt) -> jwt.jwtAuthenticationConverter(jwtAuthConverter())));
//        return http.build();
//    }
//
//    private Converter<Jwt, ? extends AbstractAuthenticationToken> jwtAuthConverter() {
//        System.out.println("JWT AUTH CONVERTER");
//        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
//        converter.setJwtGrantedAuthoritiesConverter(jwt -> {
//            if (jwt.getClaims() != null) {
//                return List.of();
//            }
//            final Map<String,List<String>> realAccess = (Map<String, List<String>>) jwt.getClaims().get("realm_access");
//
//            return realAccess.get("roles").stream().map(roleName -> "ROLE_"+roleName).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
//        });
//        return null;
//    }

}
