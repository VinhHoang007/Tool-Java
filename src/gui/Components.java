package gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Components extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;

	public JPanel createHeader() {
		// Create Label
		JLabel inputLabel = new CustomItem().customJLabel("Input File", new int[] { 11, 21, 69, 14 });
		contentPanel.add(inputLabel);

		JLabel outputLabel = new CustomItem().customJLabel("Output File", new int[] { 11, 49, 69, 14 });
		contentPanel.add(outputLabel);

		// Create Text Field
		JTextField inputPathField = new CustomItem().customTextField("Input Path", new int[] { 90, 46, 609, 22 }, 10);
		contentPanel.add(inputPathField);

		JTextField outputPathField = new CustomItem().customTextField("Output Path", new int[] { 90, 46, 609, 22 }, 10);
		contentPanel.add(outputPathField);

		// Create browser
		JButton inputBrowser = new CustomItem().customButton("Browser", new int[] { 723, 18, 124, 23 });
		contentPanel.add(inputBrowser);

		// Create browser
		JButton outputBrowser = new CustomItem().customButton("Browser", new int[] { 723, 46, 124, 23 });
		contentPanel.add(outputBrowser);

		return contentPanel;
	}

	public JPanel createBody() {
		// Create Text Area
		JTextArea textArea = new CustomItem().customTextArea(new int[] { 11, 91, 836, 233 },
				new int[] { 51, 102, 204 });

		// Create Scroll
		JScrollPane scrollArea = new CustomItem().customScrollPane(textArea);
		contentPanel.add(scrollArea);

		return contentPanel;
	}

	public JPanel createFooter() {
		// Create Clear
		JButton clearButton = new CustomItem().customButton("Clear", new int[] { 575, 335, 124, 29 });
		contentPanel.add(clearButton);

		// Create Submit
		JButton submitButton = new CustomItem().customButton("Submit", new int[] { 600, 335, 124, 29 });
		contentPanel.add(submitButton);
		return contentPanel;
	}
}
