package agh.cs.lab2;

import java.util.*;

public class UnboundedMap extends AbstractWorldMap {
    private ArrayList<Grass> grasses = new ArrayList<>();
    private HashMap<Vector2d,Grass> grassesPos = new HashMap<>();
    public MapBoundary boundary = new MapBoundary();
    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(isOccupied(position) && !(objectAt(position) instanceof Grass));
    }
    public UnboundedMap(int n){
        int max = (int) Math.sqrt(10*n);
        Random random = new Random();
        int i=0;
        while(i<n){
            int randX = random.nextInt(max);
            int randY = random.nextInt(max);
            Vector2d pos = new Vector2d(randX,randY);
            Grass grass = new Grass(randX,randY);
            if(canMoveTo(pos)){
                i++;
                grasses.add(grass);
                grassesPos.put(new Vector2d(randX,randY),grass);
                boundary.insert(pos);
             }
        }
    }
    @Override
    public boolean isOccupied(Vector2d pos){
        return super.isOccupied(pos)||grassesPos.containsKey(pos);
    }
    @Override
    public Object objectAt(Vector2d pos){
        return super.objectAt(pos)!=null?super.objectAt(pos) : grassesPos.get(pos);
    }
    @Override
    public String toString(){
        MapVisualiser visualizer = new MapVisualiser(this);

        Vector2d lowerLeft = boundary.getLowerLeft();
        Vector2d upperRight = boundary.getUpperRight();
        return visualizer.draw(lowerLeft, upperRight);
    }
    @Override
    public boolean place (Animal animal) throws IllegalArgumentException{
        super.place(animal);
        boundary.insert(animal.getPosition());
        return true;
    }
}
