import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class MainMenu{
    private static final long serialVersionUID = 1L;

    JFrame frame;

    int screenWidth = 475;
    int screenHeight = 300;

    int buttonWidth = 200;
    int buttonHeight = 40;

    JButton Play, Quit, twoPlayers;


    public MainMenu(){
        frame = new JFrame();
        frame.getContentPane().setLayout(null);

        addButtons();
        addActions();

        Play.setBounds((screenWidth - buttonWidth)/2, 20, buttonWidth, buttonHeight);
        twoPlayers.setBounds((screenWidth - buttonWidth)/2, 75, buttonWidth, buttonHeight);
        Quit.setBounds((screenWidth - buttonWidth)/2, 200, buttonWidth, buttonHeight);


        //placing buttons
        frame.getContentPane().add(Play);
        frame.getContentPane().add(Quit);
        frame.getContentPane().add(twoPlayers);

        //JFrame stuff
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(screenWidth, screenHeight);
        frame.setTitle("Pong");
        frame.setResizable(false);

    }

    private void addButtons(){
        Play = new JButton("One Player");
        twoPlayers = new JButton("Two Players");
        Quit = new JButton("Quit");


    }

    private void addActions(){

        Play.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
              frame.dispose();
              Game game = new Game();
              game.ai.isTwoPlayer = false;
              game.start();
          }
        });

        twoPlayers.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
              frame.dispose();
              Game game = new Game();
              game.ai.isTwoPlayer = true;
              game.start();
          }
        });


        Quit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });

    }



}
