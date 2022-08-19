package environment_runner.controller;

import domain.models.Parameter;
import environment_service.api.EnvironmentService;
import environment_service.api.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParameterController {

    @Autowired
    ParameterService parameterService;

    @GetMapping(path = "/par/{name}")
    public Parameter par(@PathVariable("name") String name) {
       // return new Parameter("a",1,"wfaf");
        System.out.println("parameterService.getParameter(name) = " + parameterService.getParameter(name));
        return parameterService.getParameter(name);
    }

}