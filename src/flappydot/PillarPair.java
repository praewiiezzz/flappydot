package flappydot;

import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class PillarPair {
	private Image topPillar;
	private Image bottomPillar;
	private float x;
	private float y;
	private float vx;
	private int ran = 0;
	static public final int WIDTH = 80;
	static public final int IMAGE_HEIGHT = 600;
	static public final int PILLAR_SPACE = 200;

	public PillarPair(float x, float y, float vx) throws SlickException {
		this.x = x;
		randomY();
		this.vx = vx;
		topPillar = new Image("res/pillar-top.png");
		bottomPillar = new Image("res/pillar-bottom.png");
		// randomY();
	}

	public void render() {
		topPillar.draw(x - (WIDTH / 2), FlappyDotGame.GAME_HEIGHT
				- (y + IMAGE_HEIGHT + (PILLAR_SPACE / 2)));
		bottomPillar.draw(x - (WIDTH / 2), FlappyDotGame.GAME_HEIGHT
				- (y - (PILLAR_SPACE / 2)));
	}

	// random ��ͧ��Ҫ�ͧ���ҧ����ҧ��ҧ��͹
	public void randomY() {
		Random random = new Random();
		ran = random.nextInt(FlappyDotGame.GAME_HEIGHT - 270) + 135;
		this.y = ran;
	}

	public void update() {
		x += vx;
		if (x <= -80) {
			x = FlappyDotGame.GAME_WIDTH;
			this.randomY();
		}
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}
}
