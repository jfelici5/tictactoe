/*Name: Juan Ramon Feliciano
* Netid: jfelici5
* Assignment: Project 2
* Lab section: TR 12:30pm
*
* I did not collaborate with anyone on this assignment.
*/

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;


public class TTTGame {
	
	public static int oneWinsint = 0;
	public static int twoWinsint = 0;
	public static int drawsint = 0;
	public static CanvasTTC canvasReal = new CanvasTTC();
	public static JFrame frame = new JFrame("Jack's TicTacToe Game");
	
	public static void main(String[] args) {
		
		canvasReal.setPreferredSize(new Dimension(480,580));
		canvasReal.addMouseListener(new Listener(canvasReal));
		frame.add(canvasReal, BorderLayout.SOUTH);
		
		frame.setSize(480,615);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	
	}
	public static void repaint() {
		// TODO Auto-generated method stub
		
	}
	
}
