package environment_service.inmem_parameter_repo;

import domain.models.Parameter;

public interface InMemParameterRepoInterface {
    Parameter get(String name);
    float getValue(String name);
    void changeValue(String name, float newValue);

    static InMemParameterRepo newParameterRepoThreeDim() {
        return new InMemParameterRepoThreeDim();
    }

}
