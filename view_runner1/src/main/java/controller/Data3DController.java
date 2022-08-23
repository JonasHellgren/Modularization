package controller;

//import domain.models.Edge3D;
//import domain.models.Vertex3D;
//import environment_service.api.EnvironmentService;
//import domain.models.Vertex3D;
//import domain.models.Vertex3D;
//import domain.models.Vertex3D;
//import environment_service.api.EnvironmentService;
import domain.models.Edge3D;
import domain.models.Vertex3D;
import environment_service.api.Data3DService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import viewservice.api.ViewService;

import java.util.List;

//web browser: http://localhost:8080/vertices
//web browser: http://localhost:8080/edges


@RestController
public class Data3DController {

    @Autowired
    ViewService viewService;

  //  @Autowired
  //  Data3DService data3DService;

    @GetMapping(value = "/test")
    public String test() {
        return "test";
    }


    @GetMapping(value = "/vertices")
    public void getVertices() {

        System.out.println("environmentService.getVertices() = " + data3DService.getVertices());

        viewService.insertVertices(data3DService.getVertices());
    }



    /*
    @GetMapping(value = "/edges")
    public List<Edge3D> getEdges() {
        System.out.println("environmentService.getEdges() = " + data3DService.getEdges());
        return data3DService.getEdges();
    }

*/

}
