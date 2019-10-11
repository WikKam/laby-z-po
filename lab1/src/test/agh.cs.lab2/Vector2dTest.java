package agh.cs.lab2;
import org.junit.Assert;
import org.junit.Test;
public class Vector2dTest {
    @Test
    public void precedesTest(){
        Assert.assertTrue(new Vector2d(1,1).precedes(new Vector2d(10,10)));
    }
    @Test
    public void followsTest(){
        Assert.assertTrue(new Vector2d(10,10).follows(new Vector2d(1,1)));
    }
    @Test
    public void upperRightTest(){
        Assert.assertEquals(new Vector2d(5,1).upperRight(new Vector2d(1,5)),new Vector2d(5,5));
    }
    @Test
    public void lowerLeftTest(){
        Assert.assertEquals(new Vector2d(5,1).lowerLeft(new Vector2d(1,5)),new Vector2d(1,1));
    }
    @Test
    public void addTest(){
        Assert.assertEquals(new Vector2d(5,5).add(new Vector2d(1,1)),new Vector2d(6,6));
    }
    @Test
    public void oppositeTest(){
        Assert.assertEquals(new Vector2d(1,1).opposite(),new Vector2d(-1,-1));
    }
    @Test
    public void subtractTest(){
        Assert.assertEquals(new Vector2d(1,1).subtract(new Vector2d(-1,-1)),new Vector2d(2,2));
    }
    @Test
    public void equalsTest(){
        Assert.assertEquals(new Vector2d(1,1),new Vector2d(1,1));
    }
    @Test
    public void toStringTest(){
        Assert.assertEquals(new Vector2d(1,1).toString(),"(1,1)");
    }

}
