package com.example.apisecurity;

import com.example.apisecurity.domain.AppUser;
import com.example.apisecurity.domain.Role;
import com.example.apisecurity.service.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class ApiSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiSecurityApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(AppUserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));

            userService.saveAppUser((new AppUser(null, "Amy", "usernameAmy", "passwordAmy", new ArrayList<>())));
            userService.saveAppUser((new AppUser(null, "Bob", "usernameBob", "passwordBob", new ArrayList<>())));
            userService.saveAppUser((new AppUser(null, "Carl", "usernameCarl", "passwordCarl", new ArrayList<>())));

            userService.addRoleToUser("usernameAmy","ROLE_USER");
            userService.addRoleToUser("usernameAmy","ROLE_MANAGER");
            userService.addRoleToUser("usernameBob","ROLE_MANAGER");
            userService.addRoleToUser("usernameCarl","ROLE_ADMIN");
        };
    }

}
