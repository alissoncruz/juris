package com.juris.user;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.juris.constants.Constants.BASE_PATH;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(BASE_PATH + "/user")
@AllArgsConstructor
@Api(value = "Juris", tags = "User")
public class UserController {

    private final UserService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void post(@RequestBody User user){
        service.save(user);
    }
}
