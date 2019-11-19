package agh.cs.lab2;
import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

public class RectangularMapTest {
   private RectangularMap testMap = new RectangularMap(5,5);
   private Animal testAnimal = new Animal(testMap);
   private Vector2d testVec1 = new Vector2d(10,10);
   private Vector2d testVec2 = new Vector2d(-10,-10);
   private Vector2d testVec3 = new Vector2d(3,4);
    @Test
    public void canMoveToTest(){
        Assert.assertFalse(testMap.canMoveTo(testVec1));
        Assert.assertFalse(testMap.canMoveTo(testVec2));
        Assert.assertTrue(testMap.canMoveTo(testVec3));
    }
    @Test
    public void placeTest(){
        Animal animal2 = new Animal(testMap);
        Assert.assertTrue(testMap.place(testAnimal));
        try{
            testMap.place(animal2);
            fail();
        }catch(Exception e){

        }
    }
    @Test
    public void isOccupiedTest(){
        testMap.place(testAnimal);
        Assert.assertTrue(testMap.isOccupied(new Vector2d(2,2)));
        Assert.assertFalse(testMap.isOccupied(testVec3));
        Assert.assertFalse(testMap.isOccupied(testVec1));
    }
    @Test
    public void runTest(){
        String[] args = {"f", "forward","b","backward","r","right","l","left"};
        MoveDirection[] directions = OptionParser.parse(args);
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
}
