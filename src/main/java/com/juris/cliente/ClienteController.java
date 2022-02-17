package com.juris.cliente;

import com.juris.model.Cliente;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cliente")
@AllArgsConstructor
@Api(value = "Juris", tags = "Cliente")
public class ClienteController {

    private final ClienteService service;

    @PostMapping
    @ResponseStatus(CREATED)
    public void create(@RequestBody Cliente cliente){
        service.save(cliente);
    }


    @GetMapping
    @ResponseStatus(OK)
    public List<Cliente> findAll(){
        return service.findAll();
    }

    @DeleteMapping
    @ResponseStatus(NO_CONTENT)
    public void deleteAll(){
        service.deleteAll();
    }

    @GetMapping("/{id}")
    public Cliente findById(@PathVariable String id){
        return service.findById(id);
    }
}
