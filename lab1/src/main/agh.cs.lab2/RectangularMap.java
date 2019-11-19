package agh.cs.lab2;

import java.util.Collections;
import java.util.List;

public class RectangularMap extends AbstractWorldMap {
    private int width;
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
        return !isOccupied(position) || objectAt(position) instanceof Grass;
    }
    public List<AbstractWorldMapElement> getAnimals(){
        return Collections.unmodifiableList(this.elements);
    }
}
