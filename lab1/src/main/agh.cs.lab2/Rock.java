package agh.cs.lab2;

public class Rock extends AbstractWorldMapElement {
    public Vector2d position;
    public Rock(Vector2d position){
        super(position);
    }
    public Rock(int x, int y){
        super(x,y);
    }
    @Override
    public String getShortString() {
        return "R";
    }
    public String toString(){
        return "R";
    }
}
