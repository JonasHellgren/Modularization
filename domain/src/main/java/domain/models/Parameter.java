package domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Parameter {
    public String name;    //String for “naming”
    public float value;    //the assigned value
    public String description;    //for example "Mass (kg)"
}
