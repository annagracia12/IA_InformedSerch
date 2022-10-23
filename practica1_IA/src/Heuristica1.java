import java.util.*;
import java.util.Comparator;

public class Heuristica1 extends Heuristica{

    /*
        Esta heuristica se basa en escoger el nodo de menos peso para realizar el camino
    */

    public void ordenar_pendientes(ArrayList<Estado> pend) {
        pend.sort(new Comparator<Estado>(){
            public int compare(Estado e1, Estado e2){
                return Integer.compare(e1.getAltura(), e2.getAltura());
            }
        });

    }

    public void ordenar_pend(ArrayList<Estado> pend) {
        pend.sort(new Comparator<Estado>(){
            public int compare(Estado e1, Estado e2){
                return Double.compare(e1.getF(), e2.getF());
            }
        });

    }

    /*En este caso la heuristica no trata con las distancias hacia el nodo por lo que se devuelve su altura*/
    public double getHeuristica(Estado e1, Estado e2) {
        return e1.getAltura();
    }
}
