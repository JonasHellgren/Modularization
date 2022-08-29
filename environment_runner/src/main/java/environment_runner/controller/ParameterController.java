package environment_runner.controller;

import domain.models.Parameter;
import environment_service.api.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * postman (POST):
 * http://localhost:8080/parameters/change
 * {"name":"R","value":4, "description":"R"}
 */

@RestController
@RequestMapping(path = "/parameters")
public class ParameterController {

    @Autowired
    ParameterService parameterService;

    @GetMapping(path = "/par/{name}")
    public Parameter par(@PathVariable("name") String name) {
        return parameterService.getParameter(name);
    }



    @GetMapping(path = "/all")

    public List<Parameter> parameters() {
        return parameterService.getParameters();
    }


    @PostMapping(path = "/change")  //handles post requests from client
    //@Valid, triggers validations on person, @RequestBody put json body into object
    public void changeParameter(@RequestBody Parameter par) {
        System.out.println("changeParameter called, added:" + par.getName());
        parameterService.changeParameterValue(par.name, par.value);

    }

}