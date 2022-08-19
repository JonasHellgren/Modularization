package domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Edge3D {
    long vertexIdx1;
    long vertexIdx2;
}
