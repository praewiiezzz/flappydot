package flappydot;

public class CollisionDetector {
	public static boolean isCollide(float dotX, float dotY, float pX, float pY) {
		if((dotY > pY+100 && dotX > pX-40 && dotX < pX+40) || (dotY < pY-100 && dotX > pX-40 && dotX < pX+40)) 
		{
			return true;
		}
		else{
			return false;
		}
	  }
}
