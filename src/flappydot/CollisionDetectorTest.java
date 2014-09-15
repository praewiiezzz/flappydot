package flappydot;

import static org.junit.Assert.*;

import org.junit.Test;

public class CollisionDetectorTest {

	@Test
	  public void testNotCollideFarLeft() {
	    assertFalse(CollisionDetector.isCollide(0, 100, 320, 320));
	  }
	 
	  @Test
	  public void testNotCollideThrough() {
	    assertFalse(CollisionDetector.isCollide(320, 320, 320, 320));
	  }
	 
	  @Test
	  public void testNotCollideThroughHigh() {
	    assertFalse(CollisionDetector.isCollide(320, 240, 320, 320));
	  }
	 
	  @Test
	  public void testCollideTop() {
	    assertTrue(CollisionDetector.isCollide(320, 500, 320, 320));
	  }

}
