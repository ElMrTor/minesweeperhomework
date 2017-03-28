import java.util.Random;
import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

public class MinesObj  {

	private Random Unlucky = new Random();
		MyMouseAdapter Fila = new MyMouseAdapter();
	int FilaMina = Fila.getFila();
	MyMouseAdapter Columna = new MyMouseAdapter();
	int ColumnaMina = Columna.getColumna();
	private int numberofb = 0;
	
	public MinesObj(){
		
	}
	
	public int getHowMany(int q,int w,int e,int r,int t,int y,int u,int i){
		this.numberofb = 0;
		numberofb = q+w+e+r+t+y+u+i;
		return numberofb;
	}
	
	
	
	
	
	
	
	
}
