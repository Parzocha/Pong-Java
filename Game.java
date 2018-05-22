import java.awt.Canvas;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {
    private static final long serialVersionUID = 1L;

    public static PlayerPaddle player;
    public static AIPaddle ai;
    public static Ball ball;
    InputHandler IH;


    JFrame frame; //window of the game
    public final int WIDTH = 800;
    public final int HEIGHT = WIDTH / 16 * 9;
    public final Dimension gameSize = new Dimension(WIDTH, HEIGHT);
    public final String TITLE = "Pong";
    public final int FPS = 60;

    BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

    static boolean gameRunning = false; //whether the game is running

    int p1Score;
    int p2Score;

    public void run() {

        while(gameRunning){  //if gameRunning = true
            tick();
            render();
            /*if(quit_game)
            {
              return;
            }*/

            try{
              Thread.sleep(1000/FPS);
            }catch(Exception e){
              e.printStackTrace();
            }

        }


    }

    public synchronized void start(){
        gameRunning = true;
        new Thread(this).start();
    }

    public static synchronized void stop(){
        gameRunning = false;
        System.exit(0);
    }

    public Game() {
        frame = new JFrame();

        setMinimumSize(gameSize);
        setPreferredSize(gameSize);
        setMaximumSize(gameSize);

        frame.add(this, BorderLayout.CENTER);
        frame.pack();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setTitle(TITLE);
        frame.setLocationRelativeTo(null);

        IH = new InputHandler(this);

        player = new PlayerPaddle(10, getHeight()/2 - 40);
        ai = new AIPaddle(getWidth() - 25, getHeight()/2 - 40);
        ball = new Ball(getWidth()/2, getHeight()/2);

    }

    public void tick(){
      player.tick(this);
      ai.tick(this);
      ball.tick(this);

    }

    public void render(){
        BufferStrategy bs = getBufferStrategy();
        if(bs == null){
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);

        g.setColor(Color.WHITE);
        g.fillRect(getWidth()/2 - getWidth()/60/2, 0, getWidth()/60, getHeight()); //Drawing the white line in the middle

        g.setColor(Color.WHITE);

        g.drawString("Player 1: " + p1Score, 0, 10);
        g.drawString("Player 2: " + p2Score, getWidth() - 80, 10);

        player.render(g);
        ai.render(g);
        ball.render(g);

        g.dispose();
        bs.show();
    }


}
