package agh.cs.lab2;

public abstract class AbstractWorldMapElement implements IMapElement {
    protected Vector2d position;

    public AbstractWorldMapElement(Vector2d position) {
        this.position = position;
    }
    public AbstractWorldMapElement(int x, int y){
        this.position = new Vector2d(x,y);
    }
    @Override
    public Vector2d getPosition() {
        return position;
    }

}
