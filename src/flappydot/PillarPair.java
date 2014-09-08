package flappydot;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class PillarPair {
	private Image topPillar;
	private Image bottomPillar;
	private float x;
	private float y;
	private float vx;
	static public final int WIDTH = 80;
	static public final int IMAGE_HEIGHT = 600;
	static public final int PILLAR_SPACE = 200;

	public PillarPair(float x, float y,float vx) throws SlickException {
		this.x = x;
		this.y = y;
		this.vx = vx;
		topPillar = new Image("res/pillar-top.png");
		bottomPillar = new Image("res/pillar-bottom.png");
	}
	
	public void render() {
		topPillar.draw(x-(WIDTH/2),FlappyDotGame.GAME_HEIGHT -(y + IMAGE_HEIGHT+(PILLAR_SPACE/2)));
		bottomPillar.draw(x-(WIDTH/2),FlappyDotGame.GAME_HEIGHT-(y-(PILLAR_SPACE/2)));
	}
	
	public void update() {
		x +=vx;
	}
}
