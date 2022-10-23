import java.util.ArrayList;

public class BestFirst extends AlgoritmosBusqueda{

    public void busqueda(Heuristica h, Estado[][] grafo){
        ArrayList<Estado> pendientes = new ArrayList<>();
        ArrayList<Estado> tratados = new ArrayList<>();
        ArrayList<Estado> vecinos = null;
        Coordenada ini = new Coordenada(0,0);
        Coordenada fin = new Coordenada(9,9);
        Estado inicial = new Estado(ini,grafo[ini.getX()][ini.getY()].getAltura());
        pendientes.add(inicial);
        boolean trobat = false;

        while(!trobat && !pendientes.isEmpty()){

            Estado e = pendientes.get(0);
            pendientes.remove(0);

            if(!e.getPos().compare(fin)){
                vecinos = e.obtener_vecinos(grafo);
                for(int i=0; i< vecinos.size(); i++){
                    if(!tratados.contains(vecinos.get(i)) && !pendientes.contains(vecinos.get(i))){
                        pendientes.add(vecinos.get(i));
                        h.ordenar_pendientes(pendientes);
                    }
                }
                tratados.add(e);
            }else{
                trobat=true;
                e.getCamino().add(e);
                mostrar_camino(e.getCamino(),grafo);
                System.out.println("Nodos tratados: "+tratados.size());
                System.out.println("Tiempo "+e.calcularTiempo());
                System.out.println("");
            }
        }
    }


}
