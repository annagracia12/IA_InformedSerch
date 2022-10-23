import java.util.ArrayList;

public class Estado {
    /*Atributos de la clase*/
    private Coordenada pos;
    private int altura;
    private ArrayList<Estado> camino = new ArrayList<>();
    private Estado anterior;

    //siendo f el coste al nodo final y g el coste hasta el nodo actual
    private double f,g;

    /*Constructor de la clase*/
    public Estado(Coordenada pos, int altura){
        this.pos = pos;
        this.altura = altura;
    }

    /*Metodos de la clase*/
    public int getAltura() { return altura; }

    public void setAltura(int altura) { this.altura = altura; }

    public void setPos(Coordenada pos) { this.pos = pos; }
    public Coordenada getPos(){ return pos; }

    public Estado getAnterior(){ return anterior; }
    public void setAnterior(Estado anterior) { this.anterior = anterior; }
    public ArrayList<Estado> getCamino() { return camino; }

    public boolean samePos(Coordenada p){
        return pos.compare(p);
    }

    public void setF(double g, Heuristica h, Estado fin){
        if(anterior != null){
            this.f = g + h.getHeuristica(this, fin);
        }
    }

    public double calcularTiempo(){
        double tiempo=0;
        if(camino.size()>1){
            for(int i=0; i<camino.size()-1;i++){
                if(camino.get(i+1).getAltura()-camino.get(i).getAltura() >= 0){
                    tiempo=tiempo+camino.get(i+1).getAltura()-camino.get(i).getAltura()+1;
                }else{
                    tiempo=tiempo+0.5;
                }
            }

        }
        if(camino.size()==1){
            if(this.getAltura()-camino.get(0).getAltura() >= 0){
                tiempo=tiempo+this.getAltura()-camino.get(0).getAltura()+1;
            }else{
                tiempo=tiempo+0.5;
            }
        }
        return tiempo;
    }

    public double getF() { return f; }

    public void setG() {
        this.g = calcularTiempo();
    }

    public double getG() { return g; }

    public void setCamino() {
        if(anterior != null){
            camino = (ArrayList<Estado>) anterior.getCamino().clone();
            camino.add(anterior);
        }else{
            camino.add(this);
        }

    }
    public ArrayList<Estado> obtener_vecinos(Estado[][] grafo){
        int fila = getPos().getX();
        int col = getPos().getY();
        ArrayList<Estado> vecinos = new ArrayList<>();

        if(fila == 0){
            if(grafo[fila+1][col].getAltura() != -1){
                vecinos.add(grafo[fila+1][col]);
                grafo[fila+1][col].setAnterior(this);
                grafo[fila+1][col].setCamino();
            }
        }

        if(fila == 9){
            if(grafo[fila-1][col].getAltura() != -1){
                vecinos.add(grafo[fila-1][col]);
                grafo[fila-1][col].setAnterior(this);
                grafo[fila-1][col].setCamino();
            }
        }
        if(col == 0){
            if(grafo[fila][col+1].getAltura() != -1){
                vecinos.add(grafo[fila][col+1]);
                grafo[fila][col+1].setAnterior(this);
                grafo[fila][col+1].setCamino();
            }
        }
        if(col == 9){
            if(grafo[fila][col-1].getAltura() != -1){
                vecinos.add(grafo[fila][col-1]);
                grafo[fila][col-1].setAnterior(this);
                grafo[fila][col-1].setCamino();
            }
        }
        if(fila < 9 && fila != 0){
            if(grafo[fila-1][col].getAltura() != -1){
                vecinos.add(grafo[fila-1][col]);
                grafo[fila-1][col].setAnterior(this);
                grafo[fila-1][col].setCamino();
            }
            if(grafo[fila+1][col].getAltura() != -1){
                vecinos.add(grafo[fila+1][col]);
                grafo[fila+1][col].setAnterior(this);
                grafo[fila+1][col].setCamino();
            }
        }
        if(col < 9 && col != 0){
            if(grafo[fila][col+1].getAltura() != -1){
                vecinos.add(grafo[fila][col+1]);
                grafo[fila][col+1].setAnterior(this);
                grafo[fila][col+1].setCamino();
            }
            if(grafo[fila][col-1].getAltura() != -1){
                vecinos.add(grafo[fila][col-1]);
                grafo[fila][col-1].setAnterior(this);
                grafo[fila][col-1].setCamino();
            }
        }
        return vecinos;
    }
}
