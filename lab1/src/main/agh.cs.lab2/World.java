package agh.cs.lab2;

import java.util.ArrayList;
import java.util.List;

public class World {
    public static void main(String[] args){
        MoveDirection[] directions = new OptionParser().parse(args);
        List<AbstractWorldMapElement> Rocks = new ArrayList<>();
        Rocks.add(new Rock(-4,-4));
        Rocks.add(new Rock(7,7));
        Rocks.add(new Rock(3,6));
        Rocks.add(new Rock(2,0));
        IWorldMap map = new UnboundedMap(Rocks);
        map.place(new Animal(map));
        map.place(new Animal(map,new Vector2d(3,4)));
        map.run(directions);
        System.out.println(map.toString());
    }

}
