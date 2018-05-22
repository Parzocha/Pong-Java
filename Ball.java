import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;

public class Ball{
  int x;
  int y;
  int size = 20;
  int speed = 6;

  int speedx;
  int speedy;

  Rectangle boundingBox;

  public Ball(int x, int y){
      this.x = x;
      this.y = y;

      speedx = speed;
      speedy = speed;

      boundingBox = new Rectangle(x, y, size, size);
      boundingBox.setBounds(x, y, size, size);
  }


  public void tick(Game game){
      boundingBox.setBounds(x, y, size, size);

      if(x <= 0){
        game.p2Score += 1;
        speedx = speed;
        x = game.getWidth()/2;
        y = game.getHeight()/2;
      }
      else if(x + size >= game.getWidth()){
        game.p1Score += 1;
        speedx = -speed;
        x = game.getWidth()/2;
        y = game.getHeight()/2;
      }

      if(y <= 0){
        speedy = speed;
      }
      else if(y + size >= game.getHeight()){
        speedy = -speed;
      }

      x += speedx;
      y += speedy;

      paddleCollide(game);

  }

  private void paddleCollide(Game game){
      if(boundingBox.intersects(game.player.boundingBox)){
        speedx = speed;
      }
      else if(boundingBox.intersects(game.ai.boundingBox)){
        speedx = -speed;
      }
  }

  public void render(Graphics g){
      g.setColor(Color.YELLOW);
      g.fillOval(x, y, size, size);
  }
}
