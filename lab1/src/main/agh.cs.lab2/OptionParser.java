package agh.cs.lab2;

import java.util.Arrays;

public class OptionParser {
    public static MoveDirection[] parse(String[] args) throws  IllegalArgumentException{
        Arrays.stream(args).forEach( x -> {
                if(!(x.equals("f")||
                        x.equals("forward")||
                        x.equals("b")||
                        x.equals("backward")||
                        x.equals("r")||
                        x.equals("right")||
                        x.equals("l")||
                        x.equals("left")))throw new IllegalArgumentException(x +" is not legal move specification");
                }
        );
        return Arrays.stream(args)
                .map(OptionParser::stringToMove)
                .toArray(MoveDirection[]::new);
    }
    public static MoveDirection stringToMove(String arg){
        switch(arg){
            case "f":
            case "forward":
                return MoveDirection.FORWARD;
            case "b":
            case "backward":
                return MoveDirection.BACKWARD;
            case "r":
            case "right":
                return MoveDirection.RIGHT;
            case "l":
            case "left":
                return MoveDirection.LEFT;
        }
        return null;
    }

}
