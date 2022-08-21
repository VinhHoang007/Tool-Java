package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.plaf.ColorUIResource;

public class CustomItem extends JFrame {
	public CustomItem() {
	}

	public JButton customButton(String name, int positions[], int colors[]) {
		JButton button = new JButton(name);
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
//		button.setBackground(new Color(51, 102, 204));
		button.setBackground(new Color(colors[0], colors[1], colors[2]));
//		button.setBounds(723, 335, 124, 29);
		button.setBounds(positions[0], positions[1], positions[2], positions[3]);
//		btnNewButton_2.setBounds(723, 18, 124, 23);
//		btnNewButton_3.setBounds(723, 46, 124, 23);
		return button;
	}

	public JButton customButton(String name, int positions[]) {
		JButton button = new JButton(name);
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.setBounds(positions[0], positions[1], positions[2], positions[3]);
		return button;
	}

	public JTextField customTextField(String name, int positions[], int column) {
		JTextField textField = new JTextField(name);
		textField.setColumns(column);
		textField.setBounds(positions[0], positions[1], positions[2], positions[3]);
		return textField;
	}

	public JTextField customTextField(int positions[], int column) {
		JTextField textField = new JTextField();
		textField.setColumns(column);
		textField.setBounds(positions[0], positions[1], positions[2], positions[3]);
		return textField;
	}

	public JLabel customJLabel(String name, int positions[]) {
		JLabel label = new JLabel(name);
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setHorizontalAlignment(SwingConstants.LEFT);
//		outputFile.setBounds(11, 49, 69, 14);
		label.setBounds(positions[0], positions[1], positions[2], positions[3]);
		return label;
	}

	public JTextArea customTextArea(int positions[], int colors[]) {
		JTextArea textArea = new JTextArea();
		textArea.setBounds(positions[0], positions[1], positions[2], positions[3]);
		textArea.setDisabledTextColor(new ColorUIResource(colors[0], colors[1], colors[2]));
		textArea.disable();
		textArea.setAutoscrolls(true);
		return textArea;
	}

	public JScrollPane customScrollPane(JTextArea textArea) {
		JScrollPane scrollArea = new JScrollPane(textArea);
		scrollArea.setBounds(textArea.getBounds(getBounds()));
		return scrollArea;
	}

}
