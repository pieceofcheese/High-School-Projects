import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;


public class AddInterestListener implements ActionListener {

	public AddInterestListener(BankAccount b, JLabel l) {
		
		bank = b;
		label = l;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		double interest = bank.getBalance()*10/100;
		bank.deposit(interest);
		label.setText("balance = " + bank.getBalance());

	}
	
	JLabel label;
	BankAccount bank;

}
