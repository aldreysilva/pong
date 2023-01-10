package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball {
	public double x, y;
	public int width, height;
	public double dx, dy;
	public double speed = 1.5;
	
	public Ball(int x, int y) {
		this.x = x;
		this.y = y;
		width = 3;
		height = 3;
		int angle = new Random().nextInt(80);
		dx = Math.cos(Math.toRadians(angle));
		dy = Math.sin(Math.toRadians(angle));
	}
	
	public void tick() {
		if((x+dx*speed) + width>= Game.WIDTH) {
			dx*=-1;
		}else if(x + (dx*speed) < 0 ) {
			dx*=-1;
		}
		if( y>= Game.HEIGHT) {
			System.out.println("ENEMY WIN!! ");
			new Game();
			return;
		}else if(y < 0) {
			System.out.println("YOU WIN!!!");
			new Game();
			return;
		}
		Rectangle bounds = new Rectangle((int)(x+(dx*speed)), (int)(y+(dy*speed)), width, height);
		Rectangle boundsPlayer = new Rectangle(Game.player.x, Game.player.y, Game.player.width, Game.player.height);
		Rectangle boundsEnemy = new Rectangle((int)Game.enemy.x, (int)Game.enemy.y, Game.enemy.width, Game.enemy.height);
		x+=dx*speed;
		y+=dy*speed;
		
		if(bounds.intersects(boundsPlayer)) {
			dy*=-1;
			
		}else if(bounds.intersects(boundsEnemy)) {
			dy*=-1;
		}
		
		
	}
	public void render(Graphics g) {
		g.setColor(Color.orange);
		g.fillRect((int)x,(int) y, width, height);

	}
}
