package test;

import environment_service.inmem_data_repo.EdgeRepo;
import environment_service.inmem_data_repo.InMemRepoInterface;
import org.junit.Assert;
import org.junit.Test;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.Test;

public class TestEdge3DRepo {

    @Test
    public void createRepoWithThreeItems() {
        EdgeRepo repo= InMemRepoInterface.newEdgeRepoBarnExample();
        System.out.println("repo = " + repo);
        Assert.assertEquals(3, repo.nofItems());


    }
}
