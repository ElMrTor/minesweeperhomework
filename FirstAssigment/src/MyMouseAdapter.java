import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class MyMouseAdapter extends MouseAdapter {
	private Random generator = new Random();
	private int Fila  = 0;
	private int Columna = 0;
	private String infobox = ("You clicked on a mine.");
	private String titlebar = ("Game Ended.");
	private String won = ("All mines are cleared.");
	private int winCondition = 0;
	
	Storage myStorage = new Storage();
	//MinesObj myMines = new MinesObj();
	
	public void mousePressed(MouseEvent e) {
		switch (e.getButton()) {
		case 1:		//Left mouse button
			Component c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			JFrame myFrame = (JFrame) c;
			MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);
			Insets myInsets = myFrame.getInsets();
			int x1 = myInsets.left;
			int y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			int x = e.getX();
			int y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
			myPanel.mouseDownGridX = myPanel.getGridX(x, y);
			myPanel.mouseDownGridY = myPanel.getGridY(x, y);
			myPanel.repaint();
			break;
		case 3:c = e.getComponent();
		while (!(c instanceof JFrame)) {
			c = c.getParent();
			if (c == null) {
				return;
			}
		}
		myFrame = (JFrame) c;
		myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);
		myInsets = myFrame.getInsets();
		x1 = myInsets.left;
		y1 = myInsets.top;
		e.translatePoint(-x1, -y1);
		x = e.getX();
		y = e.getY();
		myPanel.x = x;
		myPanel.y = y;
		myPanel.mouseDownGridX = myPanel.getGridX(x, y);
		myPanel.mouseDownGridY = myPanel.getGridY(x, y);
		myPanel.repaint();
		break;	//Right mouse button
			//Do nothing
			
		default:    //Some other button (2 = Middle mouse button, etc.)
			//Do nothing
			break;
		}
	}
	public void mouseReleased(MouseEvent e) {
		switch (e.getButton()) {
		case 1:		//Left mouse button
			Component c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			JFrame myFrame = (JFrame)c;
			MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);  //Can also loop among components to find MyPanel
			Insets myInsets = myFrame.getInsets();
			int x1 = myInsets.left;
			int y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			int x = e.getX();
			int y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
			int gridX = myPanel.getGridX(x, y);
			int gridY = myPanel.getGridY(x, y);
			if ((myPanel.mouseDownGridX == -1) || (myPanel.mouseDownGridY == -1)) {
				//Had pressed outside
				//Do nothing
			} else {
				if ((gridX == -1) || (gridY == -1)) {
					//Is releasing outside
					//Do nothing
				} else {
					if ((myPanel.mouseDownGridX != gridX) || (myPanel.mouseDownGridY != gridY)) {
						//Released the mouse button on a different cell where it was pressed
						//Do nothing
					} else {
						//Released the mouse button on the same cell where it was pressed
						if ((gridX == 0) || (gridY == 0)) {
							//On the left column and on the top row... do nothing
						} else {
							//On the grid other than on the left column and on the top row:
							
							int color = myStorage.getBombs(myPanel.mouseDownGridX, myPanel.mouseDownGridY);
							Color newColor = null;
							int near = myStorage.sHowManyB(myPanel.mouseDownGridX, myPanel.mouseDownGridY);
							
							if (near == 0){
								int topleft = myStorage.sHowManyB(myPanel.mouseDownGridX - 1, myPanel.mouseDownGridY - 1);
								int topmid = myStorage.sHowManyB(myPanel.mouseDownGridX, myPanel.mouseDownGridY - 1);
								int topright = myStorage.sHowManyB(myPanel.mouseDownGridX + 1, myPanel.mouseDownGridY - 1);
								int midleft = myStorage.sHowManyB(myPanel.mouseDownGridX - 1, myPanel.mouseDownGridY);
								int midright = myStorage.sHowManyB(myPanel.mouseDownGridX + 1, myPanel.mouseDownGridY);
								int botleft = myStorage.sHowManyB(myPanel.mouseDownGridX - 1, myPanel.mouseDownGridY + 1);
								int botmid = myStorage.sHowManyB(myPanel.mouseDownGridX, myPanel.mouseDownGridY + 1);
								int botright = myStorage.sHowManyB(myPanel.mouseDownGridX + 1, myPanel.mouseDownGridY + 1);
								
								switch(topleft){
								
								case 0:
									newColor = Color.YELLOW;
									myPanel.colorArray[myPanel.mouseDownGridX - 1][myPanel.mouseDownGridY - 1] = newColor;
									myPanel.repaint();
									break;
								case 1:
									newColor = Color.GREEN;
									myPanel.colorArray[myPanel.mouseDownGridX - 1][myPanel.mouseDownGridY - 1] = newColor;
									myPanel.repaint();
									break;
								case 2:
									newColor = Color.BLUE;
									myPanel.colorArray[myPanel.mouseDownGridX - 1][myPanel.mouseDownGridY - 1] = newColor;
									myPanel.repaint();
									break;
								case 3:
									newColor = Color.MAGENTA;
									myPanel.colorArray[myPanel.mouseDownGridX - 1][myPanel.mouseDownGridY - 1] = newColor;
									myPanel.repaint();
									break;
									
								}
								
								switch(topmid){
								
								case 0:
									newColor = Color.YELLOW;
									myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY - 1] = newColor;
									myPanel.repaint();
									break;
								case 1:
									newColor = Color.GREEN;
									myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY - 1] = newColor;
									myPanel.repaint();
									break;
								case 2:
									newColor = Color.BLUE;
									myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY - 1] = newColor;
									myPanel.repaint();
									break;
								case 3:
									newColor = Color.MAGENTA;
									myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY - 1] = newColor;
									myPanel.repaint();
									break;
								}
								
								switch(topright){
								
								case 0:
									newColor = Color.YELLOW;
									myPanel.colorArray[myPanel.mouseDownGridX + 1][myPanel.mouseDownGridY - 1] = newColor;
									myPanel.repaint();
									break;
								case 1:
									newColor = Color.GREEN;
									myPanel.colorArray[myPanel.mouseDownGridX + 1][myPanel.mouseDownGridY - 1] = newColor;
									myPanel.repaint();
									break;
								case 2:
									newColor = Color.BLUE;
									myPanel.colorArray[myPanel.mouseDownGridX + 1][myPanel.mouseDownGridY - 1] = newColor;
									myPanel.repaint();
									break;
								case 3:
									newColor = Color.MAGENTA;
									myPanel.colorArray[myPanel.mouseDownGridX + 1][myPanel.mouseDownGridY - 1] = newColor;
									myPanel.repaint();
									break;
								}
								
								/*int rowy = 1;
								while(rowy<10){
									int rowx = 1;
									while(rowx<10){
									
										
										if(myStorage.sHowManyB(rowx, rowy) == 4 && myStorage.getBombs(rowx, rowy) == 0){	
											switch (0) {
											case 0:
												newColor = Color.MAGENTA;
												break;
																																			
											}
											myPanel.colorArray[rowx][rowy] = newColor;
											myPanel.repaint();
											
												}	
										
										
										
										if(myStorage.sHowManyB(rowx, rowy) == 2 && myStorage.getBombs(rowx, rowy) == 0){	
											switch (0) {
											case 0:
												newColor = Color.BLUE;
												break;
																																			
											}
											myPanel.colorArray[rowx][rowy] = newColor;
											myPanel.repaint();
											
												}	
										
										
										if(myStorage.sHowManyB(rowx, rowy) == 1 && myStorage.getBombs(rowx, rowy) == 0){	
											switch (0) {
											case 0:
												newColor = Color.GREEN;
												break;
																																			
											}
											myPanel.colorArray[rowx][rowy] = newColor;
											myPanel.repaint();
											
												}	
										
										
										if(myStorage.sHowManyB(rowx, rowy) == 0 && myStorage.getBombs(rowx, rowy) == 0){	
											switch (0) {
											case 0:
											newColor = Color.YELLOW;
											break;
											}
											
											myPanel.colorArray[rowx][rowy] = newColor;
											myPanel.repaint();
											}
									rowx++;
									}
									rowy++;
								}*/
							}
							
							switch (near) {
							case 0:
								newColor = Color.YELLOW;
								break;
							case 1:
								newColor = Color.GREEN;
								break;
							case 2:
								newColor = Color.BLUE;
								break;
							case 3:
								newColor = Color.MAGENTA;
								break;
								
								}
							
								if(color == 1){
									newColor = Color.BLACK;
																						
							}
							myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = newColor;
							myPanel.repaint();
							
							
							System.out.println(near);
							
							
							int loose =  myStorage.getBombs(myPanel.mouseDownGridX, myPanel.mouseDownGridY);
							if(loose == 1){
								
								JOptionPane.showMessageDialog(null, this.infobox, "End: " + this.titlebar, JOptionPane.INFORMATION_MESSAGE);
								
							}
																				
							//System.out.println(myPanel.mouseDownGridX + " + " + myPanel.mouseDownGridY);
							
							
							
						}
					}
				}
			
			myPanel.repaint();
			this.setFila(myPanel.mouseDownGridX); 
			this.setColumna(myPanel.mouseDownGridY);
			System.out.println("La fila es: "+ this.getFila() + " y la columna es: " + this.getColumna() );
			}
			break;
		case 3:		//Right mouse button
			 c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			myFrame = (JFrame)c;
			myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);  //Can also loop among components to find MyPanel
			myInsets = myFrame.getInsets();
			x1 = myInsets.left;
			y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			x = e.getX();
			y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
			gridX = myPanel.getGridX(x, y);
			gridY = myPanel.getGridY(x, y);
			if ((myPanel.mouseDownGridX == -1) || (myPanel.mouseDownGridY == -1)) {
				//Had pressed outside
				//Do nothing
			} else {
				if ((gridX == -1) || (gridY == -1)) {
					//Is releasing outside
					//Do nothing
				} else {
					if ((myPanel.mouseDownGridX != gridX) || (myPanel.mouseDownGridY != gridY)) {
						//Released the mouse button on a different cell where it was pressed
						//Do nothing
					} else {
						//Released the mouse button on the same cell where it was pressed
						if ((gridX == 0) || (gridY == 0)) {
							//On the left column and on the top row... do nothing
						} else {
							//On the grid other than on the left column and on the top row:
							
							int color = myStorage.getBombs(myPanel.mouseDownGridX, myPanel.mouseDownGridY);
							Color newColor = null;
							switch (color) {
							case 0:
								newColor = Color.YELLOW;
								break;
							case 1:
								newColor = Color.RED;
								this.winCondition = this.winCondition + myStorage.cantRepeatMine(myPanel.mouseDownGridX, myPanel.mouseDownGridY);
								break;
							case 2:
								newColor = Color.BLACK;
								break;
																						
							}
							myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = newColor;
							
							System.out.println(this.winCondition);
							myPanel.repaint();
							if(this.winCondition==20){
								JOptionPane.showMessageDialog(null, this.won, "End: " + this.titlebar, JOptionPane.INFORMATION_MESSAGE);
							}													
							//System.out.println(myPanel.mouseDownGridX + " + " + myPanel.mouseDownGridY);
							
							
							
						}
					}
				}
			
			myPanel.repaint();
			this.setFila(myPanel.mouseDownGridX); 
			this.setColumna(myPanel.mouseDownGridY);
			System.out.println("La fila es: "+ this.getFila() + " y la columna es: " + this.getColumna() );
			}
			break;
		default:    //Some other button (2 = Middle mouse button, etc.)
			//Do nothing
			break;
		}
	}
	public int getFila() {
		return Fila;
	}
	public void setFila(int fila) {
		Fila = fila;
	}
	public int getColumna() {
		return Columna;
	}
	public void setColumna(int columna) {
		Columna = columna;
	}
}