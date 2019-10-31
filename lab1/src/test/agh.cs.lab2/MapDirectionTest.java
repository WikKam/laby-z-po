package agh.cs.lab2;

import org.junit.Assert;
import org.junit.Test;

public class MapDirectionTest {
    @Test
    public void nextTest(){
        MapDirection test = MapDirection.NORTH;
        Assert.assertEquals(test.next(),MapDirection.EAST);
        test = MapDirection.EAST;
        Assert.assertEquals(test.next(),MapDirection.SOUTH);
        test = MapDirection.SOUTH;
        Assert.assertEquals(test.next(),MapDirection.WEST);
        test = MapDirection.WEST;
        Assert.assertEquals(test.next(),MapDirection.NORTH);
    }
    @Test
    public void previousTest(){
        MapDirection test = MapDirection.NORTH;
        Assert.assertEquals(test.previous(),MapDirection.WEST);
        test = MapDirection.EAST;
        Assert.assertEquals(test.previous(),MapDirection.NORTH);
        test = MapDirection.SOUTH;
        Assert.assertEquals(test.previous(),MapDirection.EAST);
        test = MapDirection.WEST;
        Assert.assertEquals(test.previous(),MapDirection.SOUTH);
    }
    @Test
    public void unitTest(){
        MapDirection test = MapDirection.NORTH;
        Assert.assertEquals(test.toUnitVector(),new Vector2d(0,1));
        test = MapDirection.EAST;
        Assert.assertEquals(test.toUnitVector(),new Vector2d(1,0));
        test = MapDirection.SOUTH;
        Assert.assertEquals(test.toUnitVector(),new Vector2d(0,-1));
        test = MapDirection.WEST;
        Assert.assertEquals(test.toUnitVector(),new Vector2d(-1,0));
    }
}