package environment_service.inmem_parameter_repo;

import domain.models.Parameter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InMemParameterRepoThreeDim extends InMemParameterRepo {

    public InMemParameterRepoThreeDim() {
        super();
        List<Parameter> parameterList = new ArrayList<>(
                Arrays.asList(
                new Parameter("R",10,"Camera distance (m)"),
                new Parameter("theta", (float) (0.2*Math.PI/2),"Camera angle (rad)"),
                new Parameter("alpha", (float) (1.0*Math.PI/4),"Zoom factor (rad)")

        ));
        super.insertAll(parameterList);
    }

    public InMemParameterRepoThreeDim(List<Parameter> parameterList) {
        super(parameterList);
    }

}
