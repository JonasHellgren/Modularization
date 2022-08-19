package environment_runner.controller;

//import domain.models.Edge3D;
//import domain.models.Vertex3D;
//import environment_service.api.EnvironmentService;
//import domain.models.Vertex3D;
//import domain.models.Vertex3D;
//import domain.models.Vertex3D;
//import environment_service.api.EnvironmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//web browser: http://localhost:8080/vertices
//web browser: http://localhost:8080/edges


@RestController
public class EnvironmentController {

  //  @Autowired
  //  EnvironmentService environmentService;

    @GetMapping(value = "/test")
    public String test() {
        return "test";
    }

 /*
    @GetMapping(value = "/vertices")
    public List<Vertex3D> getVertices() {
        return environmentService.getVertices();
    }



    @GetMapping(value = "/edges")
    public List<Edge3D> getEdges() {
        return environmentService.getEdges();
    }
    */


}
