import java.util.ArrayList;

public abstract class AlgoritmosBusqueda {

    public abstract void busqueda(Heuristica h, Estado[][] grafo);
    public static void mostrar_camino(ArrayList<Estado> camino, Estado[][] grafo){
        String red="\033[31m";
        String white="\033[37m";

        if(camino != null){
            for (int x=0; x < grafo.length; x++) {
                System.out.print(white+"");
                for (int y=0; y < grafo.length; y++) {

                    if(x==0 && y==0){
                        System.out.print(red+grafo[x][y].getAltura());
                    }else{
                        if(camino.contains(grafo[x][y])){
                            System.out.print(red+grafo[x][y].getAltura());
                        }else{
                            System.out.print(white+grafo[x][y].getAltura());
                        }
                    }

                    if (y!=grafo.length-1) System.out.print("\t");

                }
                System.out.println(white+"");
            }

        }else System.out.println(white+"No se ha encontrado camino al nodo final");
    }
}
