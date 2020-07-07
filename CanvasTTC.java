import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JPanel;

public class CanvasTTC extends JPanel {
	
	@Override
	//original game board
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke (5));
		Shape lineOne = new Line2D.Double(190, 190, 190, 490);
		Shape lineTwo = new Line2D.Double(290, 190, 290, 490);
		Shape lineThree = new Line2D.Double(90, 290, 390, 290);
		Shape lineFour = new Line2D.Double(90, 390, 390, 390);
		Shape lineFive = new Line2D.Double(0, 100, 480, 100);
		Shape rectOne = new RoundRectangle2D.Double(180, 15, 120, 65, 50, 50);
		Shape rectTwo = new RoundRectangle2D.Double(330, 15, 120, 65, 50, 50);
		Shape rectThree = new RoundRectangle2D.Double(30, 15, 120, 65, 50, 50);

		
		g2.draw(lineOne);
		g2.draw(lineTwo);
		g2.draw(lineThree);
		g2.draw(lineFour);
		g2.draw(lineFive);
		g2.draw(rectOne);
		g2.draw(rectTwo);
		g2.draw(rectThree);
		((Graphics2D) g).setStroke(new BasicStroke (10));
		Font currentFont = g.getFont();
		Font newFont = currentFont.deriveFont(currentFont.getSize() * 1F);
		Font boldFont = newFont.deriveFont(Font.BOLD);
		g.setFont(boldFont);
		g.drawString("P1's Turn", 215, 50);
		g.drawString("P1 Wins: 0", 360, 37);
		g.drawString("P2 Wins: 0", 360, 50);
		g.drawString("Draws: 0", 360, 63);
		g.drawString("New Game", 60, 50);
	}
		
}

