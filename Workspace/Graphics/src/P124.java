import java.awt.event.ActionListener;
import javax.swing.*;

public class P124 {
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		JButton button = new JButton("A");
		JButton button2 = new JButton("B");
		
		JPanel panel = new JPanel();
		
		panel.add(button);
		panel.add(button2);
		
		frame.add(panel);
		
		ActionListener listener = new ClickListener2();
		button.addActionListener(listener);
		button2.addActionListener(listener);
		
		frame.setSize(360, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}

}
