import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;

public class GUI1 {
   
	
   private static class ButtonHandler implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         
      }
   }
   
   	public static void main(String[] args)throws IOException {
   	
   	  JFrame window = new JFrame("Loop Pedal Program");
   	  window.setLayout(new BorderLayout());
   	  window.setSize(650,450);
      window.setLocation(100,100);
      JLabel label = new JLabel("Press record to begin your loop!");
      label.setOpaque(true);
      label.setBackground(Color.YELLOW);
      window.add(label);
      
     /*  BufferedImage image = null;
      try {
    	  image = ImageIO.read(getClass().getResource("drums.png"));
      }
      catch (IOException e) {
    	    e.printStackTrace();
    	}

    	window.setIconImage(image);
     /* JPanel panel = new JPanel();
      BufferedImage image = ImageIO.read(new File("drums.png"));
     JLabel label = new JLabel(new ImageIcon(image));
      panel.add(label);
     window.add(panel);*/
         
     // JLabel background = new JLabel(new ImageIcon("Users\kileyobrien\CompSci_2019\Hackathon\LoopPedal-HackACM\drums.png"));
	 // window.setContentPane(background);
	//window.setVisible(true);
	// window.setLayout(new BorderLayout());
      Font font = new Font("Arial", Font.BOLD, 20);
	  
      JButton start = new JButton("Record");
      ((JButton)start).setFont(font);
      start.setBackground(Color.RED);
      start.setOpaque(true);
      start.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
      ButtonHandler listener2 = new ButtonHandler();
      start.addActionListener(listener2);
      
      

      JButton okButton = new JButton("Play");
      ((JButton)okButton).setFont(font);
      okButton.setBackground(Color.GREEN);
      okButton.setOpaque(true);
      okButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
      ButtonHandler listener = new ButtonHandler();
      okButton.addActionListener(listener);

     /* JButton stop = new JButton("Stop");
      ((JButton)stop).setFont(font);
      stop.setBackground(Color.RED);
      stop.setOpaque(true);
      stop.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
      ButtonHandler listener3 = new ButtonHandler();
      stop.addActionListener(listener3);
      
      JButton pause = new JButton("Pause");
      ((JButton)pause).setFont(font);
      pause.setBackground(Color.LIGHT_GRAY);
      pause.setOpaque(true);
      pause.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
      ButtonHandler listener4 = new ButtonHandler();
      pause.addActionListener(listener4);
      */
      JButton save = new JButton("Save");
      ((JButton)save).setFont(font);
      save.setBackground(Color.ORANGE);
      save.setOpaque(true);
      save.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
      ButtonHandler listener5 = new ButtonHandler();
      save.addActionListener(listener5);
      
      JButton message = new JButton("Welcome to our Loop pedal!");
      ((JButton)save).setFont(font);
      save.setBackground(Color.PINK);
      save.setOpaque(true);
      //save.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    
      
      JPanel middle = new JPanel();
      middle.setLayout(new BoxLayout(middle, BoxLayout.LINE_AXIS));
 
      middle.add(start);
      middle.add(Box.createHorizontalGlue());
     
      middle.add(okButton);
      middle.add(Box.createHorizontalGlue());
     /* middle.add(stop);
      middle.add(Box.createHorizontalGlue());
      middle.add(pause);*/
      
     // middle.add(Box.createHorizontalGlue());
      middle.add(save);
      
      
     /* ImageIcon drums = new ImageIcon("7650973744_IMG_9683.jpg");
     * JLabel label = new JLabel(drums);
     * JPanel p = new JPanel();
     * p.add(label);
     *label.setVisible(true);*/
     
      
      
 
      
       window.add(middle);
      window.setVisible(true);
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   	}
}

   
