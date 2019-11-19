package agh.cs.lab2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected Vector2d lowerLeft;
    protected Vector2d upperRight;
    protected List<Animal> elements = new ArrayList<>();
    protected HashMap<Vector2d,AbstractWorldMapElement> animalPositions = new HashMap<>();
    public Object objectAt(Vector2d position) {
        return animalPositions.get(position);
    }
    public boolean isOccupied(Vector2d position) {
        return objectAt(position)!=null;
    }
    public boolean place(Animal element) throws IllegalArgumentException {
        Vector2d position = element.getPosition();
        if(isOccupied(element.getPosition())&&objectAt(element.getPosition()) instanceof Animal)
            throw new IllegalArgumentException(position.toString() + " is occupied by Animal");
        if(!canMoveTo(element.getPosition()))
            throw new IllegalArgumentException(position.toString() + " is not accesible in current map");
        elements.add(element);
        animalPositions.put(position,element);
        return true;
    }
    public void run(MoveDirection[] directions) {
        int i =0;
        while(i<directions.length){
            for(Animal element : elements){
                    Vector2d currPos = element.getPosition();
                    element.move(directions[i]);
                    element.positionChanged(currPos);
                    //animalPositions.remove(currPos);
                    //animalPositions.put(element.getPosition(),element);
                    i++;
            }
        }
    }
    public String toString(){
        if(lowerLeft==null||upperRight==null)return"Mapa jest pusta!";
        MapVisualiser visualise = new MapVisualiser(this);
        return visualise.draw(lowerLeft, upperRight);
    }
    public void positionChanged(Vector2d oldPos, Vector2d newPos){
        AbstractWorldMapElement ele = animalPositions.get(oldPos);
        animalPositions.remove(oldPos);
        animalPositions.put(newPos,ele);
    }
}
