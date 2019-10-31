package agh.cs.lab2;

import java.util.List;

public class UnboundedMap extends AbstractWorldMap {
    Vector2d lowerLeft;
    Vector2d upperRight;
    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position);
    }
    public UnboundedMap(List<AbstractWorldMapElement> elements){
        for(AbstractWorldMapElement element : elements){
            this.place(element);
        }
    }
    public boolean place(AbstractWorldMapElement element){
        if(super.place(element)){
                Vector2d elementPos = element.getPosition();
                if(lowerLeft != null){
                if(elementPos.precedes(lowerLeft))lowerLeft = elementPos;
                }
                else{
                    lowerLeft = elementPos;
                }
                if(upperRight != null){
                if(elementPos.follows(upperRight))upperRight = elementPos;
                }
                else{
                    upperRight = elementPos;
                }

                return true;
        }
        return false;

    }
    public String toString(){
        if(lowerLeft==null||upperRight==null)return"Mapa jest pusta!";/*null?*/
        MapVisualiser visualise = new MapVisualiser(this);
        return visualise.draw(lowerLeft, upperRight);
    }
}
