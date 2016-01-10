package timer;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class ElevenPointFourteen {

public static void main(String[] args) {
		
		int delay = 1000;
		
		final Rectangle rct = new Rectangle(0,0,5,5);
		final Rectangle rct2 = new Rectangle(0,0,5,5);

		ActionListener moveRectangle = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				rct.setLocation(rct.x+1,rct.y+1);
				System.out.println(rct.toString());
			}
		};
		
		ActionListener moveRectangle2 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				rct2.setLocation(rct2.x+1,rct2.y+1);
				System.out.println(rct2.toString());
			}
		};
		
		Timer time = new Timer(delay/2, moveRectangle);
		Timer time2 = new Timer(delay, moveRectangle2);
		
		while (true) {
			
			time.start();
			time2.start();
			
		}
		
	}
	
}
