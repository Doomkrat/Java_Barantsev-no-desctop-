import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.sandbox.Point1;

@Test
public class Point1Test {
  public void distance1() {
    Point1 p1 = new Point1(6, 4);
    Point1 p2 = new Point1(6, 11);
    Assert.assertEquals((p1.distance1(p2)), 7,0.00501);
  }
}
