import java.io.*;
import java.util.ArrayList;

import static java.lang.Integer.MIN_VALUE;

public class Main {
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static Estado[][] grafo= new Estado[10][10];
    private static ArrayList<Estado> camino;

    public static void main(String[] args) {
        /*Variables locales para la lectura del fichero*/
        File f;
        FileReader fr = null;
        BufferedReader br;
        String line;
        String[] info;
        int row=0;

        /*Variables locales del grafo de estados*/
        Coordenada pos;
        Estado estado;

        try{
            f = new File("src\\tablero1");
            fr = new FileReader(f);
            br = new BufferedReader(fr);

            /*Lectura del fichero*/
            while((line=br.readLine())!=null){
                info= line.split(" ");
                for(int i=0; i<info.length; i++) {
                    pos = new Coordenada(row,i);
                    int altura = Integer.parseInt(info[i]);
                    estado = new Estado(pos,altura);
                    grafo[row][i]=estado;
                }
                row++;
            }

            /* Instancias de las heurísticas */
            Heuristica menor_altura = new Heuristica1();
            Heuristica menor_dist = new Heuristica2();
            Heuristica menor_peso_dist = new Heuristica3();

            /* ALGORITMO BEST FIRST */
            System.out.println("");
            System.out.println("ALGORITMO BEST FIRST");
            System.out.println("");
            AlgoritmosBusqueda bestfirst = new BestFirst();


            System.out.println("Heuristica 1: Nodo de menos peso");
            bestfirst.busqueda(menor_altura,grafo);

            System.out.println("Heuristica 2: Distancia euclidiana");
            bestfirst.busqueda(menor_dist,grafo);

            System.out.println("Heuristica 3: Nodo de menos peso + distancia euclidiana");
            bestfirst.busqueda(menor_peso_dist,grafo);


            /* ALGORITMO A STAR */
            System.out.println("");
            System.out.println("ALGORITMO ASTAR");
            System.out.println("");
            AlgoritmosBusqueda astar = new Astar();

            System.out.println("Heuristica 1: Nodo de menos peso");
            astar.busqueda(menor_altura,grafo);

            System.out.println("Heuristica 2: Distancia euclidiana");
            astar.busqueda(menor_dist,grafo);

            System.out.println("Heuristica 3: Nodo de menos peso + distancia euclidiana");
            astar.busqueda(menor_peso_dist,grafo);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            /*En el finally cerramos el fichero*/
            try{
                if(null != fr){
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

}