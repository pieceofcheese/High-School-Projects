package timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.Timer;

public class ElevenPointThirteen {
	
	public static void main(String[] args) {
		
		int delay = 1000;
		ActionListener printDate = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				Date now = new Date();
				
				System.out.println(now);
				
			}
			
		};
		
		Timer time = new Timer(delay, printDate);
		
		while (true) {
			
			time.start();
			
		}
		
	}

}
