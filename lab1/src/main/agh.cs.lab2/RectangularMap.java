package agh.cs.lab2;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {
    private int width;
    private int height;
    List<Animal> animals = new ArrayList<>();
    public RectangularMap(int width, int height){
    this.width = width;
    this.height = height;
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
       if(position.x>width||position.x<0||position.y>height||position.y<0) return false;
       return true;
    }

    @Override
    public boolean place(Animal animal) {
        if(isOccupied(animal.getPosition()))return false;
        animals.add(animal);
        return true;
    }

    @Override
    public void run(MoveDirection[] directions) {
        int i =0 ;
        while(i<directions.length){
            for(Animal animal : animals){
                animal.move(directions[i]);
                i++;
            }
        }

    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for(Animal animal : animals){
            if(animal.getPosition().equals(position))return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
       for(Animal animal : animals){
           if(animal.getPosition().equals(position))return animal;
       }
        return null;
    }
    public String toString(){
        MapVisualiser visualise = new MapVisualiser(this);
        return visualise.draw(new Vector2d(0,0), new Vector2d(width,height));

    }
}
