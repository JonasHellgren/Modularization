package domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor  //needed for RestTemplate to work, else HttpException
public class Edge3D {
    long vertexIdx1;
    long vertexIdx2;
}
