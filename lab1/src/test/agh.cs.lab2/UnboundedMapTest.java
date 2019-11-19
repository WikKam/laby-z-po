package agh.cs.lab2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;

public class UnboundedMapTest {
    private UnboundedMap testMap = new UnboundedMap(5);
    private Animal testAnimal = new Animal(testMap);
    private Vector2d testVec1 = new Vector2d(10, 10);
    private Vector2d testVec2 = new Vector2d(-10, -10);
    private Vector2d testVec3 = new Vector2d(3, 4);

    @Test
    public void canMoveToTest() {
        Assert.assertTrue(testMap.canMoveTo(testVec1));
        Assert.assertTrue(testMap.canMoveTo(testVec2));
        Assert.assertTrue(testMap.canMoveTo(testVec3));
        testMap.place(testAnimal);
        Assert.assertFalse(testMap.canMoveTo(new Vector2d(2, 2)));
    }

    @Test
    public void placeTest() {
        Animal animal2 = new Animal(testMap);
        Assert.assertTrue(testMap.place(testAnimal));
        try{
            testMap.place(animal2);
            fail();
        }catch(Exception e){

        }
    }

    @Test
    public void isOccupiedTest() {
        testMap.place(testAnimal);
        Assert.assertTrue(testMap.isOccupied(new Vector2d(2, 2)));
    }



    @Test
    public void runTest() {
        String[] args = {"f", "forward", "b", "backward", "r", "right", "l", "left"};
        MoveDirection[] directions = OptionParser.parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Assert.assertFalse(map.canMoveTo(new Vector2d(11, 6)));
        Animal animal1 = new Animal(map);
        map.place(animal1);
        Assert.assertEquals(map.objectAt(new Vector2d(2, 2)), animal1);
        Assert.assertTrue(map.isOccupied(new Vector2d(2, 2)));
        Animal animal2 = new Animal(map, new Vector2d(3, 4));
        map.place(animal2);
        Assert.assertTrue(map.isOccupied(new Vector2d(3, 4)));
        Assert.assertEquals(map.objectAt(new Vector2d(3, 4)), animal2);
        map.run(directions);
        RectangularMap temp = (RectangularMap) map;
        Assert.assertEquals(temp.getAnimals().get(0).getPosition(), new Vector2d(2, 2));
        Assert.assertEquals(temp.getAnimals().get(1).getPosition(), new Vector2d(3, 4));
    }
}
