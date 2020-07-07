import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Listener extends TTTGame implements MouseListener{

	public static CanvasTTC canvasReal;

	//two turn integers: "1" refers to player one; "2" refers to player two
	static int turn = 1;
	// "0" means game not over; "1" means game over
	static int over = 0;
	//positioning of each square
	int[] gridArray = {0, 0, 0, 0, 0, 0, 0, 0, 0};
	//winner
	static int winner = 0;
	//turn string
	static int x;
	static int y;

	
	public Listener(CanvasTTC canvas) {
		Listener.canvasReal = canvas;
	}
	
	//counts draws
	public void labelChecker() {
		
		Graphics g2 = this.canvasReal.getGraphics();
		((Graphics2D) g2).setStroke(new BasicStroke (5));
		Font whiteFont = g2.getFont();
		Font newWhiteFont = whiteFont.deriveFont(whiteFont.getSize() * 1.0F);
		Font newBoldWhiteFont = newWhiteFont.deriveFont(Font.BOLD);
		g2.setFont(newBoldWhiteFont);
		g2.setColor(canvasReal.getBackground());
		
		Graphics g3 = this.canvasReal.getGraphics();
		((Graphics2D) g3).setStroke(new BasicStroke (5));
		Font blackFont = g3.getFont();
		Font newBlackFont = blackFont.deriveFont(blackFont.getSize() * 1.0F);
		Font newBoldBlackFont = newBlackFont.deriveFont(Font.BOLD);
		g3.setFont(newBoldBlackFont);
		
		String oneToken = "P1's Turn";
		String oneWinToken = "P1 Wins!";
		String twoToken = "P2's Turn";
		String twoWinToken = "P2 Wins!";
		String drawToken = "   Draw";
		String oneWins = "P1 Wins: " + Integer.toString(oneWinsint);
		String twoWins = "P2 Wins: " + Integer.toString(twoWinsint);
		String draws = "Draws: " + Integer.toString(drawsint);
		
		if (over == 1) {
			g2.drawString(oneToken, 215, 50);
			g2.drawString(twoToken, 215, 50);
			g2.drawString("P1 Wins: 0", 360, 37);
			g2.drawString("P2 Wins: 0", 360, 50);
			g2.drawString("Draws: 0", 360, 63);
			
			if (winner == 1) {
				
				g2.drawString("P1 Wins: " + Integer.toString(oneWinsint), 360, 37);
				oneWinsint++;
				g3.drawString("P1 Wins: " + Integer.toString(oneWinsint), 360, 37);
				g3.drawString("P2 Wins: " + Integer.toString(twoWinsint), 360, 50);
				g3.drawString("Draws: " + Integer.toString(drawsint), 360, 63);
				g3.drawString(oneWinToken, 215, 50);
				
			}
			else if (winner == 2) {
				
				g2.drawString("P2 Wins: " + Integer.toString(twoWinsint), 360, 50);
				twoWinsint++;
				g3.drawString("P1 Wins: " + Integer.toString(oneWinsint), 360, 37);
				g3.drawString("P2 Wins: " + Integer.toString(twoWinsint), 360, 50);
				g3.drawString("Draws: " + Integer.toString(drawsint), 360, 63);
				g3.drawString(twoWinToken, 215, 50);
				
				
			}
			
			else if (winner == 3) {
				
				g2.drawString("Draws: " + Integer.toString(drawsint), 360, 63);
				drawsint++;
				g3.drawString("P1 Wins: " + Integer.toString(oneWinsint), 360, 37);
				g3.drawString("P2 Wins: " + Integer.toString(twoWinsint), 360, 50);
				g3.drawString("Draws: " + Integer.toString(drawsint), 360, 63);
				g3.drawString(drawToken, 215, 50);
				gamePlay();
				
			}
		} else if  (over == 0) {
			
			if(turn == 1) {
				g2.drawString(twoToken, 215, 50);
				g3.drawString(oneToken, 215, 50);
				
			}else if(turn == 2) {
				g2.drawString(oneToken, 215, 50);
				g3.drawString(twoToken, 215, 50);
				
			}
		}
	}
	
	//checking that conditions for a win have not yet been satisfied
	public void checker() {
		if(gridArray [0] == 1 && gridArray [1] == 1 && gridArray [2] == 1) {
			over = 1;
			winner = 1;
		}else if(gridArray [0] == 1 && gridArray [3] == 1 && gridArray [6] == 1) {
			over = 1; 
			winner = 1;
		}else if(gridArray [1] == 1 && gridArray [4] == 1 && gridArray [7] == 1) {
			over = 1;
			winner = 1;
		}else if(gridArray [2] == 1 && gridArray [5] == 1 && gridArray [8] == 1) {
			over = 1;
			winner = 1;
		}else if(gridArray [3] == 1 && gridArray [4] == 1 && gridArray [5] == 1) {
			over = 1;
			winner = 1;
		}else if(gridArray [6] == 1 && gridArray [7] == 1 && gridArray [8] == 1) {
			over = 1;
			winner = 1;
		}else if(gridArray [0] == 1 && gridArray [4] == 1 && gridArray [8] == 1) {
			over = 1;
			winner = 1;
		}else if(gridArray [6] == 1 && gridArray [4] == 1 && gridArray [2] == 1) {
			over = 1;
			winner = 1;
		}else if(gridArray [0] == 2 && gridArray [1] == 2 && gridArray [2] == 2) {
			over = 1;
			winner = 2;
		}else if(gridArray [0] == 2 && gridArray [3] == 2 && gridArray [6] == 2) {
			over = 1;
			winner = 2;
		}else if(gridArray [1] == 2 && gridArray [4] == 2 && gridArray [7] == 2) {
			over = 1;
			winner = 2;
		}else if(gridArray [2] == 2 && gridArray [5] == 2 && gridArray [8] == 2) {
			over = 1;
			winner = 2;
		}else if(gridArray [3] == 2 && gridArray [4] == 2 && gridArray [5] == 2) {
			over = 1;
			winner = 2;
		}else if(gridArray [6] == 2 && gridArray [7] == 2 && gridArray [8] == 2) {
			over = 1;
			winner = 2;
		}else if(gridArray [0] == 2 && gridArray [4] == 2 && gridArray [8] == 2) {
			over = 1;
			winner = 2;
		}else if(gridArray [6] == 2 && gridArray [4] == 2 && gridArray [2] == 2) {
			over = 1;
			winner = 2;
		}else if(!(gridArray [0] == 0) && !(gridArray [1] == 0) && !(gridArray [2] == 0) &&
				!(gridArray [3] == 0) && !(gridArray [4] == 0) && !(gridArray [5] == 0) &&
				!(gridArray [6] == 0) && !(gridArray [7] == 0) && !(gridArray [8] == 0)) {
			over = 1;
			winner = 3;
		}
		
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		x = arg0.getX();
		y = arg0.getY();

		gamePlay();
		
	}
	
	//sets turns and draws x and o
	public void gamePlay() {
		
		String oneToken = "P1's Turn";
		String oneWinToken = "P1 Wins!";
		String twoToken = "P2's Turn";
		String twoWinToken = "P2 Wins!";
		String drawToken = "   Draw";
		
		Graphics g2 = this.canvasReal.getGraphics();
		((Graphics2D) g2).setStroke(new BasicStroke (5));
		Font whiteFont = g2.getFont();
		Font newWhiteFont = whiteFont.deriveFont(whiteFont.getSize() * 1.0F);
		Font newBoldWhiteFont = newWhiteFont.deriveFont(Font.BOLD);
		g2.setFont(newBoldWhiteFont);
		g2.setColor(canvasReal.getBackground());
		
		Graphics g3 = this.canvasReal.getGraphics();
		((Graphics2D) g3).setStroke(new BasicStroke (5));
		Font blackFont = g3.getFont();
		Font newBlackFont = blackFont.deriveFont(blackFont.getSize() * 1.0F);
		Font newBoldBlackFont = newBlackFont.deriveFont(Font.BOLD);
		g3.setFont(newBoldBlackFont);
		
		Graphics g = this.canvasReal.getGraphics();
		((Graphics2D) g).setStroke(new BasicStroke (5));
		Font currentFont = g.getFont();
		Font newFont = currentFont.deriveFont(currentFont.getSize() * 5.0F);
		g.setFont(newFont);
		
		Graphics g4 = this.canvasReal.getGraphics();
		((Graphics2D) g4).setStroke(new BasicStroke (5));
		Font ovalFont = g4.getFont();
		Font newOvalFont = currentFont.deriveFont(ovalFont.getSize() * 5.0F);
		g4.setFont(newOvalFont);
		Graphics g5 = this.canvasReal.getGraphics();
		((Graphics2D) g5).setStroke(new BasicStroke (5));
		
		if(x > 30 && x < 145 && y > 15 && y < 80) {
			gridArray [0] = 0;
			gridArray [1] = 0;
			gridArray [2] = 0;
			gridArray [3] = 0;
			gridArray [4] = 0;
			gridArray [5] = 0;
			gridArray [6] = 0;
			gridArray [7] = 0;
			gridArray [8] = 0;
			over = 0;
			turn = 1;
			
			g2.drawString(oneWinToken, 215, 50);
			g2.drawString(twoWinToken, 215, 50);
			g2.drawString(drawToken, 215, 50);
			g3.drawString("P1's Turn", 215, 50);
			g2.fillRect(0, 110, 480, 480);
			

			g5.drawLine(90, 290, 390, 290);
			g5.drawLine(190, 190, 190, 490);
			g5.drawLine(290, 190, 290, 490);
			g5.drawLine(90, 390, 390, 390);
			g5.drawLine(0, 100, 480, 100);
		} else if (turn == 1 && over == 0){
			if(x > 90 && x < 190 && y > 190 && y < 290 && gridArray [0] == 0) {
				g.drawOval(110, 210, 50, 50);
				gridArray [0] = 1;
				checker();
				turn = 2;
				labelChecker();
				
			}
			else if(x > 90 && x < 190 && y > 290 && y < 390 && gridArray [1] == 0) {
				g.drawOval(110, 310, 50, 50);
				gridArray [1] = 1;
				checker();
				turn = 2;
				labelChecker();
			}
			else if(x > 90 && x < 190 && y > 390 && y < 490 && gridArray [2] == 0) {
				g.drawOval(110, 410, 50, 50);
				gridArray [2] = 1;
				checker();
				turn = 2;
				labelChecker();
			}
			else if(x > 190 && x < 290 && y > 190 && y < 290 && gridArray [3] == 0) {
				g.drawOval(210, 210, 50, 50);
				gridArray [3] = 1;
				checker();
				turn = 2;
				labelChecker();
			}
			else if(x > 190 && x < 290 && y > 290 && y < 390 && gridArray [4] == 0) {
				g.drawOval(210, 310, 50, 50);
				gridArray [4] = 1;
				checker();
				turn = 2;
				labelChecker();
			}
			else if(x > 190 && x < 290 && y > 390 && y < 490 && gridArray [5] == 0) {
				g.drawOval(210, 410, 50, 50);
				gridArray [5] = 1;
				checker();
				turn = 2;
				labelChecker();
			}
			else if(x > 290 && x < 390 && y > 190 && y < 290 && gridArray [6] == 0) {
				g.drawOval(310, 210, 50, 50);
				gridArray [6] = 1;
				checker();
				turn = 2;
				labelChecker();
			}
			else if(x > 290 && x < 390 && y > 290 && y < 390 && gridArray [7] == 0) {
				g.drawOval(310, 310, 50, 50);
				gridArray [7] = 1;
				checker();
				turn = 2;
				labelChecker();
			}
			else if(x > 290 && x < 390 && y > 390 && y < 490 && gridArray [8] == 0) {
				g.drawOval(310, 410, 50, 50);
				gridArray [8] = 1;
				checker();
				turn = 2;
				labelChecker();
			}
		}else if(turn == 2 && over == 0){
			if(x > 90 && x < 190 && y > 190 && y < 290 && gridArray [0] == 0) {
				g4.drawString("X", 110, 260);
				gridArray [0] = 2;
				checker();
				turn = 1;
				labelChecker();
			}
			else if(x > 90 && x < 190 && y > 290 && y < 390 && gridArray [1] == 0) {
				g4.drawString("X", 110, 360);
				gridArray [1] = 2;
				checker();
				turn = 1;
				labelChecker();
			}
			else if(x > 90 && x < 190 && y > 390 && y < 490  && gridArray [2] == 0) {
				g4.drawString("X", 110, 460);
				gridArray [2] = 2;
				checker();
				turn = 1;
				labelChecker();
			}
			else if(x > 190 && x < 290 && y > 190 && y < 290  && gridArray [3] == 0) {
				g4.drawString("X", 210, 260);
				gridArray [3] = 2;
				checker();
				turn = 1;
				labelChecker();
			}
			else if(x > 190 && x < 290 && y > 290 && y < 390  && gridArray [4] == 0) {
				g4.drawString("X", 210, 360);
				gridArray [4] = 2;
				checker();
				turn = 1;
				labelChecker();
			}
			else if(x > 190 && x < 290 && y > 390 && y < 490 && gridArray [5] == 0) {
				g4.drawString("X", 210, 460);
				gridArray [5] = 2;
				checker();
				turn = 1;
				labelChecker();
			}
			else if(x > 290 && x < 390 && y > 190 && y < 290 && gridArray [6] == 0) {
				g4.drawString("X", 310, 260);
				gridArray [6] = 2;
				checker();
				turn = 1;
				labelChecker();
			}
			else if(x > 290 && x < 390 && y > 290 && y < 390 && gridArray [7] == 0) {
				g4.drawString("X", 310, 360);
				gridArray [7] = 2;
				checker();
				turn = 1;
				labelChecker();
			}
			else if(x > 290 && x < 390 && y > 390 && y < 490 && gridArray [8] == 0) {
				g4.drawString("X", 310, 460);
				gridArray [8] = 2;
				checker();
				turn = 1;
				labelChecker();
			}
		}
	}
	

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

