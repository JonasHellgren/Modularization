package environment_service.api;

import domain.models.Parameter;

public interface ParameterServiceInterface {

    Parameter getParameter(String name);
    void changeParameterValue(String name, float newValue);

}
