package com.juris.login;

import com.juris.config.securiry.AccountCredentials;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/login")
public class LoginController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void login(@RequestBody AccountCredentials credentials){
        log.info("Logado");

    }
}
