import java.awt.event.ActionListener;
import javax.swing.*;

public class P122 {
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		JButton button = new JButton("Click me!");
		JButton button2 = new JButton("No, click me!");
		
		JPanel panel = new JPanel();
		
		panel.add(button);
		panel.add(button2);
		
		frame.add(panel);
		
		ActionListener listener = new ClickListener();
		button.addActionListener(listener);
		
		ActionListener listener2 = new ClickListener();
		button2.addActionListener(listener2);
		
		frame.setSize(360, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}

}
