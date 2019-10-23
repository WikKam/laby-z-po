package agh.cs.lab2;

import static agh.cs.lab2.MapDirection.*;

public class Animal {
        private Vector2d position = new Vector2d(2,2);
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
                    switch(direction){
                        case NORTH:
                            if(map.canMoveTo(NORTH.toUnitVector().add(position)))
                                this.position = this.position.add(NORTH.toUnitVector());
                            break;
                        case EAST:
                            if(map.canMoveTo(EAST.toUnitVector().add(position)))
                                this.position = this.position.add(NORTH.toUnitVector());
                            break;
                        case SOUTH:
                            if(map.canMoveTo(SOUTH.toUnitVector().add(position)))
                                this.position = this.position.add(SOUTH.toUnitVector());
                            break;
                        case WEST:
                            if(map.canMoveTo(WEST.toUnitVector().add(position)))
                                this.position = this.position.add(WEST.toUnitVector());
                            break;
                    }
                    break;
                case BACKWARD:
                    switch (direction){
                        case NORTH:
                            if(position.y>0)
                                this.position = new Vector2d(position.x,position.y-1);
                            break;
                        case EAST:
                            if(position.x>0)
                                this.position = new Vector2d(position.x-1,position.y);
                            break;
                        case SOUTH:
                            if(position.y<4)
                                this.position = new Vector2d(position.x,position.y+1);
                            break;
                        case WEST:
                            if(position.x<4)
                                this.position = new Vector2d(position.x+1,position.y);
                            break;
                    }
                    break;
            }

        }
        public Vector2d getPosition(){
            return this.position;
        }
        public MapDirection getDirection(){
            return this.direction;
        }
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
            this.map = map;
        }
         public Animal(IWorldMap map, Vector2d position){
        this.map = map;
        this.position = position;
        }
}
