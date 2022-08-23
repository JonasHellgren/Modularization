package test;

import environment_service.inmem_data_repo.InMemRepoInterface;
import environment_service.inmem_data_repo.VertexRepo;
import org.junit.Assert;
import org.junit.Test;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.Test;

public class TestVertex3DRepo {

    @Test
    public void createRepoWithThreeItems() {
        VertexRepo repo= InMemRepoInterface.newVertexRepoBarnExample();
        System.out.println("repo = " + repo);
        Assert.assertEquals(10, repo.nofItems());


    }
}
