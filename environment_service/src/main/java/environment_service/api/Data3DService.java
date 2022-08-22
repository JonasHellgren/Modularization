package environment_service.api;

import domain.models.Edge3D;
import domain.models.Vertex3D;
import environment_service.inmem_data_repo.EdgeRepo;
import environment_service.inmem_data_repo.InMemRepoInterface;
import environment_service.inmem_data_repo.VertexRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Data3DService implements Data3DServiceInterface {

    VertexRepo vertexRepo;
    EdgeRepo edgeRepo;

    public Data3DService() {
        this.vertexRepo = InMemRepoInterface.newVertexRepoBarnExample();
        this.edgeRepo = InMemRepoInterface.newEdgeRepoBarnExample();
    }

    @Override
    public void insertVertices(List<Vertex3D> vertices) {
        vertexRepo.insertAll(vertices);
    }

    @Override
    public List<Vertex3D> getVertices() {
        return vertexRepo.getAll();
    }

    @Override
    public void insertEdges(List<Edge3D> edge3DS) {
        edgeRepo.insertAll(edge3DS);
    }

    @Override
    public List<Edge3D> getEdges() {
        return edgeRepo.getAll();
    }

    @Override
    public void rotateAroundY(float angle) {
        //TODO
    }
}
