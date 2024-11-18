package tacos.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(new AntPathRequestMatcher("/design")).hasRole("USER")  // USER 권한 필요
                        .requestMatchers(new AntPathRequestMatcher("/orders")).hasRole("USER")  // USER 권한 필요
                        .requestMatchers(new AntPathRequestMatcher("/**")).permitAll()          // 모든 요청 허용
                )
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    // 사용자 인증 정보 설정
//    @Bean
//    public UserDetailsService userDetailsService() {
//        String encodedPassword1 = passwordEncoder().encode("password1");
//        String encodedPassword2 = passwordEncoder().encode("password2");
//        // 메모리 기반 사용자 정보 설정
//        return new InMemoryUserDetailsManager(
//                User.withUsername("user1")
//                        .password(encodedPassword1) // {noop}: 비밀번호 암호화 안 함
//                        .roles("USER")
//                        .build(),
//                User.withUsername("user2")
//                        .password(encodedPassword2)
//                        .roles("USER")
//                        .build()
//        );
//    }

    // JDBC 기반 사용자 인증 정보 설정
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // 필요시, 기본 테이블 생성 SQL 설정 (Spring Security 기본 스키마를 사용하지 않을 경우)
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "SELECT username, password, enabled FROM users WHERE username = ?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "SELECT username, authority FROM authorities WHERE username = ?");

        return jdbcUserDetailsManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
