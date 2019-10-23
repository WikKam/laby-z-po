package agh.cs.lab2;

public class Animal {
        private Vector2d position = new Vector2d(2,2);
        private MapDirection direction = MapDirection.NORTH;
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
                            if(position.y<4)
                            this.position = new Vector2d(position.x,position.y+1);
                            break;
                        case EAST:
                            if(position.x<4)
                            this.position = new Vector2d(position.x+1,position.y);
                            break;
                        case SOUTH:
                            if(position.y>0)
                            this.position = new Vector2d(position.x,position.y-1);
                            break;
                        case WEST:
                            if(position.x>0)
                            this.position = new Vector2d(position.x-1,position.y);
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
}
