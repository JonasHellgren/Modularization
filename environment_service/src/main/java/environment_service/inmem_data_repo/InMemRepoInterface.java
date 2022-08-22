package environment_service.inmem_data_repo;

import environment_service.data3d_examples.BarnData;

import java.util.List;

public interface InMemRepoInterface<T> {
    void insertAll(List<T> items);
    List<T> getAll();
    void clearAll();
    int nofItems();

    static VertexRepo newVertexRepo() {
        return new VertexRepo();
    }

    static EdgeRepo newEdgeRepo() {
        return new EdgeRepo();
    }

    static VertexRepo newVertexRepoBarnExample() {
        VertexRepo repo=InMemRepoInterface.newVertexRepo();
        repo.insertAll(BarnData.vertexList());
        return repo;
    }


    static EdgeRepo newEdgeRepoBarnExample() {
        EdgeRepo repo=InMemRepoInterface.newEdgeRepo();
        repo.insertAll(BarnData.edgeList());
        return repo;
    }

}
