package environment_service.inmem_data_repo;

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
        repo.insertAll(VertexRepo.vertexListBarnExample());
        return repo;
    }


    static EdgeRepo newEdgeRepoBarnExample() {
        EdgeRepo repo=InMemRepoInterface.newEdgeRepo();
        repo.insertAll(EdgeRepo.edgeListBarnExample());
        return repo;
    }

}
