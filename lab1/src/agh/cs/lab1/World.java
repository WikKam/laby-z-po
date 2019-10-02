package agh.cs.lab1;

import java.util.Arrays;

public class World {
    public static void main(String[] args) {
        System.out.println("Start");
        run(convert(args));
        System.out.println("Stop");
    }

    public static void run(Direction[] args){
        //System.out.println("Zwierzak idzie do przodu");

       for(int i=0;i<args.length;i++){
           // if(args[i]==nullptr)break;
           switch(args[i]){
               case FORWARD:
                   System.out.println("Zwierzak idzie do przodu");
                   break;
               case BACKWARD:
                   System.out.println("Zwierzak idzie do tyłu");
                   break;
               case RIGHT:
                   System.out.println("Zwierzak idzie w prawo");
                   break;
               case LEFT:
                   System.out.println("Zwierzak idzie w lewo");
                   break;
               default:
                   System.out.println("nwm oco chodzi ;_;");
           }
          /* if(i==args.length - 1){
               System.out.println(args[i]);
           }
           else{
               System.out.print(args[i] + ", ");
           }*/
       }
    }
    public static Direction[] convert(String[] args){
        Direction[] ret = new Direction[args.length];
        int counter=0;
        for(int i = 0;i<args.length;i++){
                switch(args[i]){
                    case "f":
                        ret[counter] = Direction.FORWARD;
                        counter++;
                        break;
                    case "r":
                        ret[counter] = Direction.RIGHT;
                        counter++;
                        break;
                    case "l":
                        ret[counter] = Direction.LEFT;
                        counter++;
                        break;
                    case "b":
                        ret[counter] = Direction.BACKWARD;
                        counter++;
                        break;
                }

        }
        return Arrays.copyOfRange(ret,0,counter);
    }
}
