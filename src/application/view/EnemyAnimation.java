package application.view;

import java.awt.Image;
import java.util.HashMap;

import application.model.Enemy;
import application.model.Entity;
import application.model.RobotEnemy;

public class EnemyAnimation {
	private HashMap<Integer, AnimationHandler> animations;
	public EnemyAnimation() {
		animations = new HashMap<Integer, AnimationHandler>();
	}
	public void changeCurrentAnimation(Integer index,Enemy enemy) {
		if(!animations.containsKey(index)) {
			if(enemy instanceof RobotEnemy) {
				animations.put(index, new RobotEnemyAnimationHandler());
			}
		}
		int xState = ((Entity) enemy).getXState();
		int yState = ((Entity) enemy).getYState();
		animations.get(index).changeCurrentAnimation(xState,yState);
	}
	public Image getCurrentImage(int index) {
		if(animations.containsKey(index)) {
			return animations.get(index).getCurrentImage();
		}
		return null;
	}
}