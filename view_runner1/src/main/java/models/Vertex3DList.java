package models;

import domain.models.Vertex3D;

import java.util.ArrayList;
import java.util.List;

public class Vertex3DList {
    private List<Vertex3D> employees;

    public Vertex3DList() {
        employees = new ArrayList<>();
    }

    public List<Vertex3D> getEmployees() {
        return employees;
    }
}