package viewservice.logic;

import domain.models.Dot2D;
import domain.models.Edge3D;
import domain.models.Line2D;
import lombok.extern.java.Log;
import viewservice.view_mediator.MediatorMemberAbstract;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log
public class LineGenerator extends MediatorMemberAbstract {


    public List<Line2D>  getLines(List<Dot2D> dots) {
        List<Edge3D> edges=mediator.getEdges();
        List<Line2D> lines=new ArrayList<>();
        for (Edge3D edge:edges) {
            Optional<Line2D> line= getLine(dots, edge);
            line.ifPresent(lines::add);
        }
        return lines;
    }

    private Optional<Line2D> getLine(List<Dot2D> dots, Edge3D edge) {
        long dot1Idx= edge.getVertexIdx1()-1;
        long dot2Idx= edge.getVertexIdx2()-1;
        Optional<Line2D> line=Optional.empty();

        try {
            Dot2D dot1 = dots.get((int) dot1Idx);
            Dot2D dot2 = dots.get((int) dot2Idx);
            line=Optional.of(new Line2D(dot1.getX(), dot1.getY(), dot2.getX(), dot2.getY()));

        } catch (IndexOutOfBoundsException e)
        {
            log.warning("Faulty vertex index for line generation, edge = "+edge);
        } catch (Exception e) {
            log.warning("Unknown exception, class = "+e.getClass());
        }

        return line;
    }

}
