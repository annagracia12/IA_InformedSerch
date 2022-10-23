import java.util.ArrayList;

public class Astar extends AlgoritmosBusqueda{

    public void busqueda(Heuristica h, Estado[][] grafo) {
        ArrayList<Estado> pendientes = new ArrayList<>();
        ArrayList<Estado> tratados = new ArrayList<>();
        ArrayList<Estado> vecinos;

        Coordenada ini = new Coordenada(0,0);
        Coordenada fin = new Coordenada(9,9);
        Estado inicial = new Estado(ini,grafo[ini.getX()][ini.getY()].getAltura());
        Estado efinal = new Estado(fin,grafo[ini.getX()][ini.getY()].getAltura());
        pendientes.add(inicial);
        boolean trobat = false;

        inicial.setG();
        inicial.setF(inicial.getG(), h, efinal);

        while(!trobat && !pendientes.isEmpty()){

            Estado e = pendientes.get(0);
            pendientes.remove(0);

            if(!e.getPos().compare(fin)){
                vecinos = e.obtener_vecinos(grafo);
                for(int i=0; i< vecinos.size(); i++){
                    if(!tratados.contains(vecinos.get(i)) && !pendientes.contains(vecinos.get(i))){
                        vecinos.get(i).setG();
                        vecinos.get(i).setF(e.getG(),h,efinal);
                        pendientes.add(vecinos.get(i));
                        h.ordenar_pend(pendientes);
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
