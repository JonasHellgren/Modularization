package test;

import environment_service.inmem_parameter_repo.InMemParameterRepoInterface;
import org.junit.Assert;
import org.junit.Test;

public class InMemParameterRepo {

    @Test
    public void createThreeDim() {
        InMemParameterRepoInterface repo=InMemParameterRepoInterface.newParameterRepoThreeDim();
        System.out.println("repo = " + repo);
        float R=repo.getValue("R");
        Assert.assertEquals(3,R,0.1);
    }


    @Test
    public void changeR() {
        InMemParameterRepoInterface repo=InMemParameterRepoInterface.newParameterRepoThreeDim();
        repo.changeValue("R",20);
        float R=repo.getValue("R");
        Assert.assertEquals(20,R,0.1);
    }


}
