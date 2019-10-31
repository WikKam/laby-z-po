package agh.cs.lab2;

import java.util.List;

public class RectangularMap extends AbstractWorldMap {
    private int width;
    private Vector2d lowerLeft;
    private Vector2d upperRight;
    private int height;
   /* List<Animal> animals = new ArrayList<>();*/
    public RectangularMap(int width, int height){
    this.width = width;
    this.height = height;
    upperRight = new Vector2d(width,height);
    lowerLeft = new Vector2d(0,0);
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
       if(!position.follows(lowerLeft)||!position.precedes(upperRight)) return false;
       if(isOccupied(position)) return false;
       return true;
    }
    public List<AbstractWorldMapElement> getAnimals(){
        return this.elements;
    }
}
