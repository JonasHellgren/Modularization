package domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Parameter {
    public String name;    //String for “naming”
    public float value;    //the assigned value
    public String description;    //for example "Mass (kg)"

    public static Parameter newParameter(String name, float value, String description) {
        return new Parameter(name,value,description);
    }

    public static Parameter newParameter(String name, float value) {
        return new Parameter(name,value,"");
    }

}
