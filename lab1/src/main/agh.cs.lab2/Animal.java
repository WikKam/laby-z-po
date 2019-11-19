package agh.cs.lab2;

import java.util.ArrayList;
import java.util.List;

import static agh.cs.lab2.MapDirection.*;

public class Animal extends AbstractWorldMapElement {
        private MapDirection direction = NORTH;
        private AbstractWorldMap map;
        private List<IPositionChangeObserver> observers = new ArrayList<>();
    public String toString(){
            return position.toString() + " " + direction.toString();
        }
        public void move(MoveDirection dir){
            switch(dir){
                case RIGHT:
                    this.direction = this.direction.next();
                    break;
                case LEFT:
                    this.direction = this.direction.previous();
                    break;
                case FORWARD:
                    if(map.canMoveTo(direction.toUnitVector().add(this.position)))
                        this.position = this.position.add(direction.toUnitVector());
                    break;
                case BACKWARD:
                    if(map.canMoveTo(this.position.subtract(direction.toUnitVector())))
                        this.position = this.position.subtract(direction.toUnitVector());
                    break;
            }

        }
        public MapDirection getDirection(){
            return this.direction;
        }
        @Override
        public String getShortString(){
            switch(direction) {
                case NORTH:
                    return "N";
                case SOUTH:
                    return "S";
                case WEST:
                    return "W";
                case EAST:
                    return "E";
                default:
                    return null;
            }
        }
        public Animal(AbstractWorldMap map){
            this(map, new Vector2d(2,2));
            /*this.map = map;*/
        }
        public Animal(AbstractWorldMap map, Vector2d position){
        super(position);
        this.map = map;
        observers.add(map);
        if(map instanceof UnboundedMap){
        IPositionChangeObserver temp = ((UnboundedMap) map).boundary;
        observers.add(temp);
        }
        }
        public void addObserver(IPositionChangeObserver observer){
            observers.add(observer);
        }
        public void removeObserver(IPositionChangeObserver observer){
            observers.remove(observer);
        }
        public void positionChanged(Vector2d oldPos){
            for(IPositionChangeObserver observer : observers){
                observer.positionChanged(oldPos, this.getPosition());
            }
        }
}
