package flappydot;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class FlappyDotGame extends BasicGame {

	private Dot dot;
	public PillarPair pillar;
	public static final int GAME_WIDTH = 640;
	public static final int GAME_HEIGHT = 480;
	public static final float DOT_JUMP_VY = 10;
	public static final float G = (float) 0.5;
	public static final float PILLAR_VX = -4;
	private boolean isStarted;
	private PillarPair[] pillars;
	public static final int PILLAR_COUNT = 3;
	private boolean isGameOver = false;

	public FlappyDotGame(String title) {
		super(title);
	}

	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		// TODO Auto-generated method stub
		for (PillarPair pillar : pillars) {
			pillar.render();
		}
		dot.render();
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		// TODO Auto-generated method stub
		Color background = new Color(233, 245, 266); // RBG color
		container.getGraphics().setBackground(background);
		dot = new Dot(GAME_WIDTH / 2, GAME_HEIGHT / 2, DOT_JUMP_VY);
		isStarted = false;
		isGameOver = false;
		pillar = new PillarPair(GAME_WIDTH / 2, GAME_HEIGHT / 2, PILLAR_VX);
		initPillars();
	}

	private void initPillars() throws SlickException {

		pillars = new PillarPair[PILLAR_COUNT];
		for (int i = 0; i < PILLAR_COUNT; i++) {
			pillars[i] = new PillarPair(GAME_WIDTH + 100 + 250 * i,
					GAME_HEIGHT / 2, PILLAR_VX);
		}
	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		if (!isGameOver) {
			if (isStarted) {
				dot.update();
			}
			dot.isCollide(pillar);
			for (PillarPair pillar : pillars) {
				pillar.update();
				if (dot.isCollide(pillar)) {
					System.out.println("Collision!");
					isGameOver = true;
				}
			}
		}
		else
		{
			init(container);
		}

	}

	public static void main(String[] args) {
		try {
			FlappyDotGame game = new FlappyDotGame("FlappyDot Game");
			AppGameContainer container = new AppGameContainer(game);
			container.setDisplayMode(GAME_WIDTH, GAME_HEIGHT, false);
			container.setMinimumLogicUpdateInterval(1000 / 60); // 60 frame per
																// second
			container.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void keyPressed(int key, char c) {
		// TODO Auto-generated method stub
		if (key == Input.KEY_SPACE)
			;
		{
			dot.jump();
			isStarted = true;
		}
	}

}
