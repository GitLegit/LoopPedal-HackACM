import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI1 {
   
	
   private static class ButtonHandler implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         
      }
   }
   
   	public static void main(String[]args) {
  
   	  JFrame window = new JFrame("Loop Pedal Program");
   	  window.setLayout(new BorderLayout());
   	  window.setSize(650,450);
      window.setLocation(100,100);
      window.setVisible(true);
     
   	  JLabel background = (new JLabel(new ImageIcon("7650973744_IMG_9683.jpg")));
   	  window.add(background);
   	  background.setLayout(new FlowLayout());
	  Font font = new Font("Arial", Font.BOLD, 20);
	  
      JButton start = new JButton("Record");
      ((JButton)start).setFont(font);
      ButtonHandler listener2 = new ButtonHandler();
      start.addActionListener(listener2);

      JButton okButton = new JButton("Play");
      ((JButton)okButton).setFont(font);
      ButtonHandler listener = new ButtonHandler();
      okButton.addActionListener(listener);

      JButton stop = new JButton("Stop");
      ((JButton)stop).setFont(font);
      ButtonHandler listener3 = new ButtonHandler();
      stop.addActionListener(listener3);
      
      JButton pause = new JButton("Pause");
      ((JButton)pause).setFont(font);
      ButtonHandler listener4 = new ButtonHandler();
      pause.addActionListener(listener4);
      
      JButton save = new JButton("Save");
      ((JButton)save).setFont(font);
      ButtonHandler listener5 = new ButtonHandler();
      pause.addActionListener(listener5);
      
      
      JPanel middle = new JPanel();
      middle.setLayout(new BoxLayout(middle, BoxLayout.LINE_AXIS));
      middle.add(start);
      middle.add(Box.createHorizontalGlue());
     
      middle.add(okButton);
      middle.add(Box.createHorizontalGlue());
      middle.add(stop);
      middle.add(Box.createHorizontalGlue());
      middle.add(pause);
      
      middle.add(Box.createHorizontalGlue());
      middle.add(save);
      
     /* ImageIcon drums = new ImageIcon("7650973744_IMG_9683.jpg");
     * JLabel label = new JLabel(drums);
     * JPanel p = new JPanel();
     * p.add(label);
     *
   *
     * label.setSize(500,500);
     * label.setLocation(100,100);
     * label.setVisible(true);
     */
      
      
 
      
      background.add(middle);
    
      
   	}

  /* public class Back extends JPanel{
	   
	   private Image drums;
	   public Back(String pic) throws IOException{
	   		drums = ImageIO.read(new File(pic));
	   }
	  
	   public void paints(Graphics g) {
		   super.paintComponent(g);
		   g.drawImage(drums, 0, 0, this);
	   }
	   	JFrame f = new JFrame();
	      f.add(new Back("7650973744_IMG_9683.jpg"));
   }*/
}

   
