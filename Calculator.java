// New java project, no new module
// Imports:
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// javax, java and ==> awt


public class Calculator implements ActionListener{
	// implements?
	// ActionListener?
	
	// General declarations
	JFrame frame;
	JTextField textfield;
	// textfield
	// JButton, predetermined?
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[9];
	
	// manual declarations of the buttons
	// assigning into elements of above arrays
	JButton addButton, subButton, mulButton, divButton;
	JButton decButton, equButton, delButton, clrButton, negButton;
	
	// JPanel panel declaration
	JPanel panel;
	
	// declaring an reusable font
	Font myFont = new Font("Arial Rounded MT Bold", Font.BOLD, 30);
	double num1 = 0, num2 = 0, result = 0; // double accounting for decimal values
	char operator;
	
	// Constructor
	Calculator() {
		// finish initializing the frame.
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// JFrame.EXIT_ON_CLOSE
		frame.setSize(420, 550);
		frame.setLayout(null);
		// run program to test, especially when working with frames.
		// finishing text field [HERE]
		textfield = new JTextField();
		textfield.setBounds(50, 25, 300, 50);
		textfield.setFont(myFont);
		// set editable to false
		textfield.setEditable(false);
		
		// syntax buttons (eight total)
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("delete");
		clrButton = new JButton("clear");
		negButton = new JButton("(-)");
		
		// place syntax buttons in function buttons array
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = negButton;
		
		// creating a for loop to iterate....
		for (int i = 0; i < 9; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
		}
		for (int i = 0; i < 10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
		}
		
		negButton.setBounds(50, 430, 100, 50);
		// delete and clear set separately
		delButton.setBounds(150, 430, 100, 50);
		clrButton.setBounds(250, 430, 145, 50);
		
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4, 4, 10, 10)); // rows and columns and spacing
		// panel.setBackground(Color.GRAY); //(for visualization purposes
		
		// adding buttons to panel
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton); // row 1
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton); // row 2
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton); // row 3
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);// forgot to add
		panel.add(divButton);
		
		// add panel to frame
		frame.add(panel);
		frame.add(negButton);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(textfield);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		// instance of the class
		Calculator calc = new Calculator();
	}
	
	// adding for actionListener
	@Override
	public void actionPerformed(ActionEvent e) { // primary actions functionality
		// check if any buttons have been pressed
		for (int i = 0; i < 10; i++) {
			if (e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		if (e.getSource() == decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		// addition button
		if (e.getSource() == addButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText("");
		}
		// subtraction button
		if (e.getSource() == subButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText("");
		}
		// multiplication button
		if (e.getSource() == mulButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '*';
			textfield.setText("");
		}
		// divide button
		if (e.getSource() == divButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText("");
		}
		if (e.getSource() == equButton) {
			num2=Double.parseDouble(textfield.getText());
			switch(operator) {
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			case '/':
				result = num1 / num2;
				break;
			}
			// update the text field
			textfield.setText(String.valueOf(result));
			num1 = result;
		}
		// clear button
		if (e.getSource() == clrButton) {
			textfield.setText("");
		}
		// delete button
		if (e.getSource() == delButton) {
			String string = textfield.getText();
			textfield.setText("");
			for(int i = 0; i < string.length() - 1; i++) {
				textfield.setText(textfield.getText() + string.charAt(i));
			}
		}
		// negative button
		if (e.getSource() == negButton) {
			double temp = Double.parseDouble(textfield.getText());
			// flip sign (mul by -1)
			temp *= -1;
			// reset text
			textfield.setText(String.valueOf(temp));
		}
	}
}







