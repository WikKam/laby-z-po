package agh.cs.lab2;

import java.util.Arrays;

public class OptionParser {
    public static MoveDirection[] parse(String[] args){
        return Arrays.stream(args)
                .filter(x-> x.equals("f")||
                        x.equals("forward")||
                        x.equals("b")||
                        x.equals("backward")||
                        x.equals("r")||
                        x.equals("right")||
                        x.equals("l")||
                        x.equals("left"))
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
