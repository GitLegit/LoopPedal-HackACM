import java.io.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyPressing extends JFrame{
	KeyPressing(){
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(300, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.addKeyListener(new MyListener());
	}
	public static void main(String[] args) {
		new KeyPressing();
	}
	class MyListener implements KeyListener {
		public void keyPressed(KeyEvent e) {
			System.out.println("key pressed");
		}
		public void keyReleased(KeyEvent e){

		}
		public void keyTyped(KeyEvent e){

		}
	}
}


	
