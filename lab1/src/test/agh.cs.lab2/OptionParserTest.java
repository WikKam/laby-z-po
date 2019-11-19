package agh.cs.lab2;
import org.junit.Test;
import org.junit.Assert;
import static agh.cs.lab2.MapDirection.EAST;
import static agh.cs.lab2.MapDirection.SOUTH;
import static agh.cs.lab2.MoveDirection.*;
public class OptionParserTest {
    private String[] args = {"f", "forward","b","backward","r","right","l","left","a","abcd"};
    private MoveDirection[] result ={FORWARD,FORWARD,BACKWARD,BACKWARD,RIGHT,RIGHT,LEFT,LEFT};
    @Test(expected = IllegalArgumentException.class)
    public void parsingTest(){
        MoveDirection[] parsedData = OptionParser.parse(args);
        Assert.assertArrayEquals(parsedData,result);
    }

}
