package environment_runner.controller;

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


    @GetMapping(value = "/test")
    public String test() {

        double[][] matrixData = { {1d,2d,3d}, {2d,5d,3d}};
        RealMatrix m = MatrixUtils.createRealMatrix(matrixData);
        System.out.println("m = " + m);
        double[][] matrixData2 = { {1d,2d}, {2d,5d}, {1d, 7d}};
        RealMatrix n = new Array2DRowRealMatrix(matrixData2);

        RealMatrix p = m.multiply(n);
        System.out.println(p.getRowDimension());    // 2
        System.out.println(p.getColumnDimension()); // 2

        System.out.println("p = " + p);

        return "test";
    }



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
