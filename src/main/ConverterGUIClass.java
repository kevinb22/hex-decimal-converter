package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import conversionTools.DecimalToHexConverter;
import conversionTools.HexToDecimalConverter;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class ConverterGUIClass {

	private JFrame frmConverter;
	private JTextField outputTextField;
	private JTextField inputTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConverterGUIClass window = new ConverterGUIClass();
					window.frmConverter.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConverterGUIClass() {
		initialize();
	}

	/**
	 * Update the buttons to be mutually exclusive, only one can be selected at a time.
	 * @param {JRadioButton} bttn1 the button to be selected if it is not already 
	 * @param {JRadioButton} bttn2 the button to be de-selected.
	 */
	private void updateRadioButtons(JRadioButton bttn1, JRadioButton bttn2) {
		if (!bttn1.isSelected()) {
			bttn1.setSelected(true);
			bttn2.setSelected(false);
		}
	}
	
	/**
	 * Clear the JTextFields
	 * @param {JTextField} txtfld1 first field to be cleared
	 * @param {JTextField} txtfld2 second field to be cleared
	 */
	private void clearTextFields(JTextField txtfld1, JTextField txtfld2){
		txtfld1.setText("");
		txtfld2.setText("");
	}
	
	/**
	 * Update the JLabel text fields
	 * @param {JLabel} lb1
	 * @param {String} msg1
	 * @param {JLabel} lb2
	 * @param {String} msg2
	 */
	private void updateJLabels(JLabel lb1, String msg1, JLabel lb2, String msg2) {
		lb1.setText(msg1);
		lb2.setText(msg2);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		HexToDecimalConverter hexToDecimalConverter = new HexToDecimalConverter();
		DecimalToHexConverter decimalToHexConverter = new DecimalToHexConverter();
		
		frmConverter = new JFrame();
		frmConverter.setTitle("Converter");
		frmConverter.setBounds(100, 100, 450, 300);
		frmConverter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel topPane = new JPanel();
		frmConverter.getContentPane().add(topPane, BorderLayout.NORTH);
		
		JRadioButton decimalToHexRadioButton = new JRadioButton("Decimal to Hex");
		decimalToHexRadioButton.setSelected(true);
		decimalToHexRadioButton.setHorizontalAlignment(SwingConstants.LEFT);

		topPane.add(decimalToHexRadioButton);
		
		JRadioButton hexToDecimalRadioButton = new JRadioButton("Hex to Decimal");
		hexToDecimalRadioButton.setHorizontalAlignment(SwingConstants.LEFT);
		topPane.add(hexToDecimalRadioButton);
		
		JPanel bottomPane = new JPanel();
		frmConverter.getContentPane().add(bottomPane, BorderLayout.CENTER);
		bottomPane.setLayout(null);
		
		JLabel inputLabel = new JLabel("Input");
		inputLabel.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if (decimalToHexRadioButton.isSelected()) {
					inputLabel.setText("Decimal");
				} else if (hexToDecimalRadioButton.isSelected()) {
					inputLabel.setText("Hex");
				}
			}
		});
		inputLabel.setBounds(97, 35, 64, 16);
		bottomPane.add(inputLabel);
		
		JButton convertButton = new JButton("Convert");
		convertButton.setBounds(146, 178, 93, 29);
		convertButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String input = inputTextField.getText(),
					   output = "";
				if (input.equals("")) {
					return;
				} else if (decimalToHexRadioButton.isSelected()) {
					int val = 0;
					try {
						val = Integer.parseInt(input);
						output = decimalToHexConverter.decimalToHex(val);
					} catch (Exception e1) {
						output = "";
					}
				} else if (hexToDecimalRadioButton.isSelected()) {
					long ret = hexToDecimalConverter.hexToDecimal(input);
				    output = (ret != -1) ? Long.toString(ret) : "";
				}
				outputTextField.setText(output);
			}
		});
		
		inputTextField = new JTextField();
		inputTextField.setBounds(212, 30, 175, 26);
		bottomPane.add(inputTextField);
		inputTextField.setColumns(10);
		
		JLabel outputLabel = new JLabel("Output");
		outputLabel.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if (decimalToHexRadioButton.isSelected()) {
					outputLabel.setText("Hex");
				} else if (hexToDecimalRadioButton.isSelected()) {
					outputLabel.setText("Decimal");
				}
			}
		});
		outputLabel.setBounds(97, 96, 69, 16);
		bottomPane.add(outputLabel);
		
		outputTextField = new JTextField();
		outputTextField.setBounds(212, 91, 175, 26);
		bottomPane.add(outputTextField);
		outputTextField.setColumns(10);
		bottomPane.add(convertButton);
		
		JButton clearButton = new JButton("Clear");
		clearButton.setBounds(250, 178, 76, 29);
		clearButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearTextFields(inputTextField, outputTextField);
			}
		});
		bottomPane.add(clearButton);
		
		decimalToHexRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateRadioButtons(decimalToHexRadioButton, hexToDecimalRadioButton);
				clearTextFields(inputTextField, outputTextField);
				updateJLabels(inputLabel, "Decimal", outputLabel, "Hex");
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				updateRadioButtons(decimalToHexRadioButton, hexToDecimalRadioButton);
				clearTextFields(inputTextField, outputTextField);
				updateJLabels(inputLabel, "Decimal", outputLabel, "Hex");
			}
		});
		
		hexToDecimalRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateRadioButtons(hexToDecimalRadioButton, decimalToHexRadioButton);
				clearTextFields(inputTextField, outputTextField);
				updateJLabels(inputLabel, "Hex", outputLabel, "Decimal");
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				updateRadioButtons(hexToDecimalRadioButton, decimalToHexRadioButton);
				clearTextFields(inputTextField, outputTextField);
				updateJLabels(inputLabel, "Hex", outputLabel, "Decimal");
			}
		});
	}
}
