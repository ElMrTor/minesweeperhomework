



import javax.swing.JFrame;
import java.util.Random;
public class Main {
	
	public static void main(String[] args) {
		
		/*Random Unlucky  = new Random();
		int[] coordx = new int[20];
		int[] coordy = new int[20];
		
		int i = 0;
		while (i<20){
		coordx[i] = Unlucky.nextInt(9 + 1 - 1) + 1;
		coordy[i] = Unlucky.nextInt(9 + 1 -1) + 1;
		System.out.println("(" + coordx[i] + "," + coordy[i] + ")");
		i++;
			}	*/
		
		
		JFrame myFrame = new JFrame("MineSweeper");
		myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		myFrame.setLocation(400, 150);
		myFrame.setSize(400, 400);

	
		
		
		MyPanel myPanel = new MyPanel();
		myFrame.add(myPanel);

		MyMouseAdapter myMouseAdapter = new MyMouseAdapter();
		myFrame.addMouseListener(myMouseAdapter);
		
		//Storage myStorage = new Storage();
		
		
		//myStorage.getConfirmation();
				//System.out.println(coordx[11]+"+"+coordy[11]);
		

		myFrame.setVisible(true);
	}
		}