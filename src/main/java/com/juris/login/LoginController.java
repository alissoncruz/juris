package com.juris.login;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.juris.constants.Constants.BASE_PATH;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(BASE_PATH + "/login")
public class LoginController {

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse login(@RequestBody Login login){
        log.info("The method login was started. {}", login.toString());
        return LoginResponse.builder().token("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c").build();
    }
}
