import java.util.ArrayList;

public abstract class Heuristica {
    /* Ordenar en BF */
    public abstract void ordenar_pendientes(ArrayList<Estado> pend);
    /* Ordenar en A* */
    public abstract void ordenar_pend(ArrayList<Estado> pend);
    public abstract double getHeuristica(Estado e1, Estado e2);
}
