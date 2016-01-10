import java.awt.event.*;

import javax.swing.*;

public class P126 {
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		
		JButton button = new JButton("Add Interest");
		
		final BankAccount account = new BankAccount(INITIAL_BALANCE);
		
		final JLabel label = new JLabel("balance=" + account.getBalance());
		
		JPanel panel = new JPanel();
		panel.add(button);
		panel.add(label);
		frame.add(panel);
		
		
		
		ActionListener listener = new AddInterestListener(account, label);
		button.addActionListener(listener);
		
		frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
	private static final double INTEREST_RATE = 10;
	private static final double INITIAL_BALANCE = 1000;
	
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 200;

}
