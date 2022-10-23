public class Coordenada {
    /*Atributos de la clase*/
    private int x;
    private int y;

    /*Constructor de la clase*/
    public Coordenada(int x, int y){
        this.x = x;
        this.y = y;
    }

    /*Metodos de la clase*/
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) { this.x=x; }
    public void setY(int y) { this.y=y; }
    public boolean compare(Coordenada pos){ return x==pos.getX() && y==pos.getY(); }
}
