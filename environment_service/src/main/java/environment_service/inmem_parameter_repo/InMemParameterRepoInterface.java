package environment_service.inmem_parameter_repo;

import domain.models.Parameter;

import java.util.List;

public interface InMemParameterRepoInterface {
    Parameter get(String name);
    List<Parameter> getAll();
    float getValue(String name);
    void changeValue(String name, float newValue);

    static InMemParameterRepo newParameterRepoThreeDim() {
        return new InMemParameterRepoThreeDim();
    }

}
