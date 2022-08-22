package environment_service.inmem_data_repo;

import domain.models.Edge3D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EdgeRepo implements InMemRepoInterface<Edge3D> {

    List<Edge3D> edge3DList;

    public EdgeRepo() {
        this.edge3DList = new ArrayList<>();
    }

    public EdgeRepo(List<Edge3D> edge3DList) {
        this.edge3DList = edge3DList;
    }

    @Override
    public void insertAll(List<Edge3D> edge3DList) {
        this.edge3DList = edge3DList;
    }

    @Override
    public List<Edge3D> getAll() {
        return new ArrayList<>(edge3DList);
    }

    @Override
    public void clearAll() {
        edge3DList.clear();

    }

    @Override
    public int nofItems() {
        return edge3DList.size();
    }

    @Override
    public String  toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EdgeRepo{");
        sb.append(System.getProperty("line.separator")); //new line after every node

        for (Edge3D v : getAll()) {
            sb.append(v.toString());
            sb.append(System.getProperty("line.separator")); //new line after every node
        }
        sb.append("}");
        return sb.toString();


    }

}
