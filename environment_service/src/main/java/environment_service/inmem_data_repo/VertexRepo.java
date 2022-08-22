package environment_service.inmem_data_repo;

import domain.models.Vertex3D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class VertexRepo implements InMemRepoInterface<Vertex3D> {

    List<Vertex3D> vertex3DList;

    public VertexRepo() {
        this.vertex3DList = new ArrayList<>();
    }

    public VertexRepo(List<Vertex3D> vertex3DList) {
        this.vertex3DList = vertex3DList;
    }

    @Override
    public void insertAll(List<Vertex3D> vertex3DList) {
        this.vertex3DList = vertex3DList;
    }

    @Override
    public List<Vertex3D> getAll() {
        return new ArrayList<>(vertex3DList);
    }

    @Override
    public void clearAll() {
        vertex3DList.clear();

    }

    @Override
    public int nofItems() {
        return vertex3DList.size();
    }


    @Override
    public String  toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VertexRepo{");
        sb.append(System.getProperty("line.separator")); //new line after every node

        for (Vertex3D v : getAll()) {
            sb.append(v.toString());
            sb.append(System.getProperty("line.separator")); //new line after every node
        }
        sb.append("}");
        return sb.toString();
    }

}
