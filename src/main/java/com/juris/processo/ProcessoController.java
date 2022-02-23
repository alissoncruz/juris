package com.juris.processo;

import com.juris.model.Processo;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.juris.constants.Constants.BASE_PATH;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(BASE_PATH + "/processo")
@AllArgsConstructor
@Api(value = "Juris", tags = "Processo")
public class ProcessoController {

    private ProcessoService service;

    @PostMapping
    @ResponseStatus(CREATED)
    public void create(@RequestBody Processo processo){
        service.save(processo);
    }


    @GetMapping
    @ResponseStatus(OK)
    public List<Processo> findAll(){
        return service.findAll();
    }


}
