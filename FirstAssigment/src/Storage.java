import java.util.Random;

import javax.swing.JFrame;

public class Storage extends Main{

	private Random Unlucky = new Random();
	private int[] coordx = new int[20];
	private int[] coordy = new int[20];
	private int[] coordxforwin = new int[20];
	private int[] coordyforwin = new int[20];
	private int counterForWin = 0;
	private int repeatx = 0;
	private int repeaty = 0;
	private int norepeat = 0;
	private int yorn = 0;
	
	public Storage(){
	int i = 0;
	while (i<20){
		norepeat = 0;
		int j = 0;
		repeatx = Unlucky.nextInt(9 + 1 - 1) + 1;
		repeaty = Unlucky.nextInt(9 + 1 - 1) + 1;
		int k = 0;
		while(j<20){
			
			if(this.repeatx==this.coordx[k]&&this.repeaty==this.coordy[k]){
								
				repeatx = Unlucky.nextInt(9 + 1 - 1) + 1;
				repeaty = Unlucky.nextInt(9 + 1 - 1) + 1;
			}
			else{
				
				k++;
				
			}
			
			if(k==20){
				k = 0;
				j++;
				norepeat++;
			}
				
		}
	if(norepeat == 20){	
		this.coordx[i] = repeatx;
		this.coordy[i] = repeaty;
	System.out.println("(" + coordx[i] + "," + coordy[i] + ")");
	i++;}
	
		}	
	}
	
	
	
	public int getBombs(int x, int y){          //Devuelve 1 o 0, si devuelve 1 perdistes
		int i = 0;
		while(i<20){
		if(x==this.coordx[i]&&y==this.coordy[i]){
			System.out.println("si +" + x + y);
			return 1;
			}
		i++;
		}
		
			return 0;
		
		}

	
	public int hitBomb(int x, int y){      //Devuelve 1 o 0, si devuelve 1 perdistes
		int i = 0;
		while(i<20){
			if(x==this.coordx[i]&&y==this.coordy[i]){
				this.yorn = 1;
				return  1;
			}
			i++;
		}
		this.yorn = 0;
		return 0;
	}
	

	public int sHowManyB(int x, int y){
		int result = 0;
		
		result = sBombTopLeft(x,y)
				+ sBombTopMid(x,y)
				+ sBombTopRight(x,y)
				+ sBombMidLeft(x,y)
				+ sBombMidRight(x,y)
				+ sBombBotLeft(x,y)
				+ sBombBotMid(x,y)
				+ sBombBotRight(x,y); 
		
		
		return result;
	}
	
	
	
	
	
	public int sBombTopLeft(int x, int y){				//Verificar minas alrededor 1 a 1
		x = x-1;
		y = y-1;
		int test = 0;
		int i = 0;
		while(i<20){
			if(x==this.coordx[i]&&y==this.coordy[i]){
				
			 test = 1;
			}
			i++;
		}
		
		return test;
				
	}

	public int sBombTopMid(int x, int y){
		y = y-1;
		int test = 0;
		int i = 0;
		while(i<20){
			if(x==this.coordx[i]&&y==this.coordy[i]){
				
			 test = 1;
			}
			i++;
		}
		
		return test;
				
	}public int sBombTopRight(int x, int y){
		x = x+1;
		y = y-1;
		int test = 0;
		int i = 0;
		while(i<20){
			if(x==this.coordx[i]&&y==this.coordy[i]){
				
			test = 1;
			}
			i++;
		}
		
		return test;
				
	}public int sBombMidLeft(int x, int y){
		x = x-1;
		int test = 0;
		int i = 0;
		while(i<20){
			if(x==this.coordx[i]&&y==this.coordy[i]){
				
				test = 1;
			}
			i++;
		}
		
		return test;
				
	}public int sBombMidRight(int x, int y){
		x = x+1;
		int i = 0;
		int test = 0;
		while(i<20){
			if(x==this.coordx[i]&&y==this.coordy[i]){
				
				test = 1;
			}
			i++;
		}
		
		return test;
				
	}public int sBombBotLeft(int x, int y){
		x = x-1;
		y = y+1;
		int test = 0;
		int i = 0;
		while(i<20){
			if(x==this.coordx[i]&&y==this.coordy[i]){
				
				test = 1;
			}
			i++;
		}
		
		return test;
				
	}public int sBombBotMid(int x, int y){
		
		y = y+1;
		int test = 0;
		int i = 0;
		while(i<20){
			if(x==this.coordx[i]&&y==this.coordy[i]){
				
				test = 1;
			}
			i++;
		}
		
		return test;
				
	}public int sBombBotRight(int x, int y){
		x = x+1;
		y = y+1;
		int i = 0;
		int test = 0;
		while(i<20){
			if(x==this.coordx[i]&&y==this.coordy[i]){
				
				test = 1;
			}
			i++;
		}
		
		return test;
				
	}
	
	
	public int cantRepeatMine(int x, int y){		//Se asegura de que poner el flag en la misma mina cuente mas de una vez

		int dReturn = 1;
		int i = 0;
		while(i<20){
			
			
			if(x==this.coordxforwin[i]&&y==this.coordyforwin[i]){
							dReturn = 0;
			}
				i++;
				if(i==20&&dReturn==1){
				this.coordxforwin[this.counterForWin] = x;
				this.coordyforwin[this.counterForWin] = y;
				this.counterForWin++;
				}
		}
			
		return dReturn;
	}
	
	
	



	public int[] getCoordx() {
		return  coordx;
	}

	public void setCoordx(int[] coordx) {
		this.coordx = coordx;
	}

	public int[] getCoordy() {
		return coordy;
	}

	public void setCoordy(int[] coordy) {
		this.coordy = coordy;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
