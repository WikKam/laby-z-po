
package agh.cs.lab2;
import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
public class WorldIntegrationTest {
    private String[] args = {"f", "forward","b","backward","r","right","l","left","a","abcd"};
    @Test
    public void IntegrationTest(){
        MoveDirection[] directions = new OptionParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        map.place(new Animal(map));
        map.place(new Animal(map,new Vector2d(3,4)));
        map.run(directions);
        RectangularMap temp = (RectangularMap)map;
        Assert.assertEquals(temp.getAnimals().get(0).getPosition(),new Vector2d(2,2));
        Assert.assertEquals(temp.getAnimals().get(1).getPosition(),new Vector2d(3,4));

        System.out.println(map.toString());
    }
}