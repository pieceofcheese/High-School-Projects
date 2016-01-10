import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ClickListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		count++;
		System.out.println("I was clicked" + count + "times.");

	}
	
	public int count;

}
