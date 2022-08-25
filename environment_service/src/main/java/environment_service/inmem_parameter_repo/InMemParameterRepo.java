package environment_service.inmem_parameter_repo;


import domain.models.Parameter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemParameterRepo implements InMemParameterRepoInterface {

    private final HashMap<String, Parameter> parameterMap;

    public InMemParameterRepo() {
        parameterMap=new HashMap<>();
    }

    public InMemParameterRepo(List<Parameter> parameterList) {
        parameterMap=new HashMap<>();
        insertAll(parameterList);
    }

    @Override
    public Parameter get(String name) {
        return parameterMap.get(name);
    }

    @Override
    public List<Parameter> getAll() {
        return new ArrayList<>(parameterMap.values());
    }

    @Override
    public float getValue(String name) {
        return parameterMap.get(name).value;
    }


    @Override
    public void changeValue(String name, float newValue) {
        Parameter p=parameterMap.get(name);
        p.value=newValue;
    }


    void insertAll(List<Parameter> parameterList) {
        for (Parameter p: parameterList) {
            parameterMap.put(p.name,p);
        }
    }

    @Override
    public String  toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ParameterRepo{");
        sb.append(System.getProperty("line.separator")); //new line after every node

        for (String p : parameterMap.keySet()) {
            sb.append(parameterMap.get(p));
            sb.append(System.getProperty("line.separator")); //new line after every node
        }
        sb.append("}");
        return sb.toString();
    }


}
