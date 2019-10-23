package agh.cs.lab2;
import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import static agh.cs.lab2.MapDirection.*;
import static agh.cs.lab2.MoveDirection.*;

public class AnimalTest {
    private Animal testSub1 = new Animal();
    private Animal testSub2 = new Animal();
    private Vector2d testVec = new Vector2d(2,2);
    private Vector2d endDest = new Vector2d(3,3);
    @Test
    public void toStringTest(){
        Assert.assertEquals(testSub1.toString(),"(2,2) Północ");
    }
    @Test
    public void movePositionTest(){
        testSub1.move(FORWARD);
        testSub1.move(RIGHT);
        testSub1.move(FORWARD);
        Assert.assertEquals(testSub1.getPosition(),endDest);
        testSub1.move(MoveDirection.BACKWARD);
        testSub1.move(LEFT);
        testSub1.move(MoveDirection.BACKWARD);
        Assert.assertEquals(testSub1.getPosition(),testSub2.getPosition());
    }
    @Test
    public void moveAboveBoundsTest(){
        Animal testSub =new Animal();
        testSub.move(FORWARD);
        testSub.move(FORWARD);
        testSub.move(FORWARD);
        testSub.move(FORWARD);
        testSub.move(RIGHT);
        testSub.move(FORWARD);
        testSub.move(FORWARD);
        testSub.move(FORWARD);
        testSub.move(FORWARD);
        Assert.assertEquals(testSub.getPosition(), new Vector2d(4,4));
    }
    @Test
    public void directionTest(){
        testSub2.move(RIGHT);
        testSub2.move(RIGHT);
        testSub2.move(RIGHT);
        Assert.assertEquals(testSub2.getDirection(), WEST);
        testSub2.move(LEFT);
        Assert.assertEquals(testSub2.getDirection(), SOUTH);
    }

}
