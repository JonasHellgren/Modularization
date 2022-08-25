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
}
