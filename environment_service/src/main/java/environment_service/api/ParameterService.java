package environment_service.api;

import domain.models.Parameter;
import environment_service.inmem_parameter_repo.InMemParameterRepo;
import environment_service.inmem_parameter_repo.InMemParameterRepoThreeDim;
import org.springframework.stereotype.Service;

@Service
public class ParameterService implements ParameterServiceInterface {

    InMemParameterRepo inMemParameterRepo;

    public ParameterService() {
        inMemParameterRepo=new InMemParameterRepoThreeDim();
    }

    @Override
    public Parameter getParameter(String name) {
        return inMemParameterRepo.get(name);
    }

    @Override
    public void changeParameterValue(String name, float newValue) {
        inMemParameterRepo.changeValue(name,newValue);
    }
}
