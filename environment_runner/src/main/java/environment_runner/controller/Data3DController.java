package environment_runner.controller;

import domain.models.Edge3D;
import domain.models.Vertex3D;
import environment_service.api.Data3DService;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.MatrixUtils;

import org.apache.commons.math3.linear.RealMatrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//web browser: http://localhost:8080/vertices
//web browser: http://localhost:8080/edges

@RestController
public class Data3DController {


    @Autowired
    Data3DService data3DService;

    @GetMapping(value = "/vertices")
    public List<Vertex3D> getVertices() {
        System.out.println("environmentService.getVertices() = " + data3DService.getVertices());
        return data3DService.getVertices();
    }


    @GetMapping(value = "/edges")
    public List<Edge3D> getEdges() {
        System.out.println("environmentService.getEdges() = " + data3DService.getEdges());
        return data3DService.getEdges();
    }



}
