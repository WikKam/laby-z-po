package agh.cs.lab2;

import static agh.cs.lab2.MapDirection.*;

public class Animal extends AbstractWorldMapElement {
        private MapDirection direction = NORTH;
        private IWorldMap map;
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
        public Animal(IWorldMap map){
            this(map, new Vector2d(2,2));
            /*this.map = map;*/
        }
        public Animal(IWorldMap map, Vector2d position){
        super(position);
        this.map = map;
        }
}
