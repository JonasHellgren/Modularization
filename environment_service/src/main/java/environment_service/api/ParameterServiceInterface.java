package environment_service.api;

import domain.models.Parameter;

import java.util.List;

public interface ParameterServiceInterface {

    Parameter getParameter(String name);
    List<Parameter> getParameters();
    void changeParameterValue(String name, float newValue);

}
