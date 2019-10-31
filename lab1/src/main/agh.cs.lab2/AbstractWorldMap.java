package agh.cs.lab2;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap {
    protected List<AbstractWorldMapElement> elements = new ArrayList<>();
    public Object objectAt(Vector2d position) {
        for(AbstractWorldMapElement element : elements){
            if(element.getPosition().equals(position))return element;
        }
        return null;
    }
    public boolean isOccupied(Vector2d position) {
        return objectAt(position)!=null;
    }
    public boolean place(AbstractWorldMapElement element) {
        if(isOccupied(element.getPosition()))return false;
        if(!canMoveTo(element.getPosition()))return false;
        elements.add(element);
        return true;
    }
    public void run(MoveDirection[] directions) {
        int i =0 ;
        while(i<directions.length){
            for(AbstractWorldMapElement element : elements){
                if(element instanceof Animal){
                    Animal animal = (Animal)element;
                    animal.move(directions[i]);
                    /*System.out.println(this.toString());*/
                    i++;}
            }
        }
    }
}
