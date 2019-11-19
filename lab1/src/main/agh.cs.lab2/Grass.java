package agh.cs.lab2;

public class Grass extends AbstractWorldMapElement {
    public Grass(Vector2d position){
        super(position);
    }
    public Grass(int x, int y){
        super(x,y);
    }
    @Override
    public String getShortString() {
        return "*";
    }
    public String toString(){
        return "*";
    }
}
