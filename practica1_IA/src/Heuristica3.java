import java.util.ArrayList;
import java.util.Comparator;

public class Heuristica3 extends Heuristica{

    /*
        Esta heuristica se basa en escoger el nodo de menos peso que está más cerca del final, se suma la altura y la distancia euclidiana al nodo final
    */

    public void ordenar_pendientes(ArrayList<Estado> pend) {
        pend.sort(new Comparator<Estado>(){
            public int compare(Estado e1, Estado e2){
                Coordenada destine = new Coordenada(9,9);
                double dist_peso1, dist_peso2;
                dist_peso1 = dist_eucli_peso(e1, destine);
                dist_peso2 = dist_eucli_peso(e2, destine);
                return Double.compare(dist_peso1,dist_peso2);
            }
        });

    }

    public double dist_eucli_peso(Estado origen, Coordenada dest){
        double dist;
        int x1 = origen.getPos().getX();
        int y1 = origen.getPos().getY();
        int x2 = dest.getX();
        int y2 = dest.getY();

        dist = Math.sqrt((Math.pow((x2-x1),2)+Math.pow((y2-y1),2))) + origen.getAltura();

        return dist;
    }

    public void ordenar_pend(ArrayList<Estado> pend) {
        pend.sort(new Comparator<Estado>(){
            public int compare(Estado e1, Estado e2){
                return Double.compare(e1.getF(), e2.getF());
            }
        });
    }

    public double getHeuristica(Estado e1, Estado e2) {
        return dist_eucli_peso(e1,e2.getPos());
    }
}
