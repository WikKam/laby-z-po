
package agh.cs.lab2;
import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

public class WorldIntegrationTest {
    private String[] args = {"f", "forward","b","backward","r","right","l","left"};
    @Test
    public void IntegrationTest(){
        MoveDirection[] directions = new OptionParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Assert.assertFalse(map.canMoveTo(new Vector2d(11,6)));
        Animal animal1 = new Animal(map);
        map.place(animal1);
        Assert.assertEquals(map.objectAt(new Vector2d(2,2)),animal1);
        Assert.assertTrue(map.isOccupied(new Vector2d(2,2)));
        Animal animal2 = new Animal(map,new Vector2d(3,4));
        map.place(animal2);
        Assert.assertTrue(map.isOccupied(new Vector2d(3,4)));
        Assert.assertEquals(map.objectAt(new Vector2d(3,4)),animal2);
        map.run(directions);
        RectangularMap temp = (RectangularMap)map;
        Assert.assertEquals(temp.getAnimals().get(0).getPosition(),new Vector2d(2,2));
        Assert.assertEquals(temp.getAnimals().get(1).getPosition(),new Vector2d(3,4));
    }

    @Test
    public void placeTest(){
        RectangularMap temp = new RectangularMap(10,10);
        Animal test = new Animal(temp, new Vector2d(-2,-2));
        try {
            temp.place(test);
            fail();
        }catch (Exception e){

        }
    }
}