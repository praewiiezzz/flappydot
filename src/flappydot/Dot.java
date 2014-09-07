package flappydot;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Dot {
	 private float x;
	  private float y;
	  private Image image;
	 
	  public Dot(float x, float y) throws SlickException {
	    this.x = x;
	    this.y = y;
	    image = new Image("res/dot.png");
	  }
	 
	  public void render() {
	    image.draw(x - 20, 480 - (y + 20));
	  }
}
