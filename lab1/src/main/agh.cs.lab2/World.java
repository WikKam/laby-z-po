package agh.cs.lab2;

public class World {
    public static void main(String[] args){
        Animal zwierzak = new Animal();
       MoveDirection[] commands = OptionParser.parser(args);
       for(MoveDirection command : commands){
           zwierzak.move(command);
       }
       System.out.println(zwierzak.toString());
    }
}
