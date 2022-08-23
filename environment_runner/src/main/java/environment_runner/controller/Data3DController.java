package environment_runner.controller;

//import domain.models.Edge3D;
//import domain.models.Vertex3D;
//import environment_service.api.EnvironmentService;
//import domain.models.Vertex3D;
//import domain.models.Vertex3D;
//import domain.models.Vertex3D;
//import environment_service.api.EnvironmentService;

import org.ejml.simple.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//web browser: http://localhost:8080/vertices
//web browser: http://localhost:8080/edges


@RestController
public class Data3DController {

    /*
    @Autowired
    Data3DService data3DService;

     */

    @GetMapping(value = "/test")
    public String test() {

        SimpleMatrix firstMatrix = new SimpleMatrix(
                new double[][] {
                        new double[] {1d, 5d},
                        new double[] {2d, 3d},
                        new double[] {1d ,7d}
                }
        );

        SimpleMatrix secondMatrix = new SimpleMatrix(
                new double[][] {
                        new double[] {1d, 2d, 3d, 7d},
                        new double[] {5d, 2d, 8d, 1d}
                }
        );

        SimpleMatrix actual = firstMatrix.mult(secondMatrix);
        System.out.println("actual = " + actual);


        return "test";
    }

    /*

    @GetMapping(value = "/vertices")
    public List<Vertex3D> getVertices() {

        System.out.println("environmentService.getVertices() = " + data3DService.getVertices());

        double[] arr1Dim = {1, 1, 1};
        INDArray ia=Nd4j.createFromArray(arr1Dim);
        System.out.println("ia = " + ia);



        return data3DService.getVertices();
    }



    @GetMapping(value = "/edges")
    public List<Edge3D> getEdges() {
        System.out.println("environmentService.getEdges() = " + data3DService.getEdges());
        return data3DService.getEdges();
    }
*/


}
