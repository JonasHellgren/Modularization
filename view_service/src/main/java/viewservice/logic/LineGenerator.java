package viewservice.logic;

import domain.models.Dot2D;
import domain.models.Edge3D;
import domain.models.Line2D;
import domain.models.Vertex3D;
import lombok.extern.java.Log;
import viewservice.view_mediator.MediatorMemberAbstract;

import java.util.ArrayList;
import java.util.List;

@Log
public class LineGenerator extends MediatorMemberAbstract {


    public List<Line2D>  getLines(List<Dot2D> dots) {

        List<Edge3D> edges=mediator.getEdges();
        List<Line2D> lines=new ArrayList<>();
        long nofDots=dots.size();
        System.out.println("nofDots = " + nofDots);
        for (Edge3D e:edges) {

            long dot1Idx=e.getVertexIdx1()-1;
            long dot2Idx=e.getVertexIdx2()-1;

            if (checkDotIdx(dot1Idx,dot1Idx,nofDots)) {
                Dot2D dot1 = dots.get((int) dot1Idx);
                Dot2D dot2 = dots.get((int) dot2Idx);
                Line2D line=new Line2D(dot1.getX(), dot1.getY(), dot2.getX(), dot2.getY());
                lines.add(line);

            } else
            {
                log.warning("Fault dot index for line generation");
            }

        }

        return lines;
    }

    private  boolean checkDotIdx(long dot1Idx, long dot2Idx, long nofDots)  {
        return (dot1Idx>0 && dot1Idx<nofDots && dot2Idx>0 && dot2Idx<nofDots);
    }


}
