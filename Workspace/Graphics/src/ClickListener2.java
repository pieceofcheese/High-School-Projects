import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ClickListener2 implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
	System.out.print("Button " + arg0.getActionCommand() + " was clicked!");
	
	}
	
	public int count;

}
