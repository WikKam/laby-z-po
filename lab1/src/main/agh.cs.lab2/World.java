package agh.cs.lab2;

import java.util.ArrayList;
import java.util.List;

public class World {
    public static void main(String[] args){
        try{
        MoveDirection[] directions = null;
        directions = OptionParser.parse(args);
        UnboundedMap map = new UnboundedMap(5);
        map.place(new Animal(map));
        map.place(new Animal(map,new Vector2d(3,4)));
        map.run(directions);
        System.out.println(map.toString());
    }catch(Exception e){
        e.printStackTrace();
    }

}}
