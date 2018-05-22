import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class InputHandler implements KeyListener{

  public InputHandler(Game game){
    game.addKeyListener(this);
  }

	//@Override
	public void keyPressed(KeyEvent e) {
      int keyCode = e.getKeyCode();
//First player
      if(keyCode == KeyEvent.VK_UP){
        Game.player.goingUp = true;
      }
      if(keyCode == KeyEvent.VK_DOWN){
        Game.player.goingDown = true;
      }
//Second player
      if(keyCode == KeyEvent.VK_W){
        Game.ai.goingUp = true;
      }
      if(keyCode == KeyEvent.VK_S){
        Game.ai.goingDown = true;
      }
      if(keyCode == KeyEvent.VK_ESCAPE){
        //Game.quit_game = true;
        //new MainMenu();
        System.exit(0);
      }

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	//@Override
	public void keyReleased(KeyEvent e) {
    int keyCode = e.getKeyCode();
//First player
    if(keyCode == KeyEvent.VK_UP){
      Game.player.goingUp = false;
    }
    if(keyCode == KeyEvent.VK_DOWN){
      Game.player.goingDown = false;
    }
//Second player
    if(keyCode == KeyEvent.VK_W){
      Game.ai.goingUp = false;
    }
    if(keyCode == KeyEvent.VK_S){
      Game.ai.goingDown = false;
	  }
  }



}
