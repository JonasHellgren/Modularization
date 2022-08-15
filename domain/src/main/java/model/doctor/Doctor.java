package model.doctor;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class Doctor {

   // @Id
    private int id;
    private String name;
    private String specialist;


}
