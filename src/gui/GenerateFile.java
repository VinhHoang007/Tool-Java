package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileSystemView;

@SuppressWarnings("serial")
public class GenerateFile extends JFrame {

	/**
	 * Create the frame.
	 */
	private JPanel contentPanel;

	public GenerateFile() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 873, 414);
		setLayout(null);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(null);

		// Create Label
		JLabel inputLabel = new CustomItem().customJLabel("Input File", new int[] { 11, 21, 69, 14 });
		contentPanel.add(inputLabel);

		JLabel outputLabel = new CustomItem().customJLabel("Output File", new int[] { 11, 49, 69, 14 });
		contentPanel.add(outputLabel);

		// Create Text Field
		JTextField inputPathField = new CustomItem().customTextField(new int[] { 90, 21, 609, 22 }, 10);
		contentPanel.add(inputPathField);

		JTextField outputPathField = new CustomItem().customTextField(new int[] { 90, 46, 609, 22 }, 10);
		contentPanel.add(outputPathField);

		// Create browse
		JButton inputBrowse = new CustomItem().customButton("Browse", new int[] { 723, 18, 124, 23 });
		contentPanel.add(inputBrowse);

		// Create browse
		JButton outputBrowse = new CustomItem().customButton("Browse", new int[] { 723, 46, 124, 23 });
		contentPanel.add(outputBrowse);

		// Create Text Area
		JTextArea logArea = new CustomItem().customTextArea(new int[] { 11, 91, 836, 233 },
				new int[] { 51, 102, 204 });

		// Create Scroll
		JScrollPane scrollArea = new CustomItem().customScrollPane(logArea);
		contentPanel.add(scrollArea);

		// Create Clear
		JButton clearButton = new CustomItem().customButton("Clear", new int[] { 575, 335, 124, 29 },
				new int[] { 51, 102, 204 });
		contentPanel.add(clearButton);

		// Create Submit
		JButton submitButton = new CustomItem().customButton("Submit", new int[] { 723, 335, 124, 29 },
				new int[] { 51, 102, 204 });
		contentPanel.add(submitButton);

		// Add to jframe
		setContentPane(contentPanel);

		// Add action clear
		addActionClearButton(clearButton, inputPathField, outputPathField,logArea);

		// Add action choose file
		addActionBrowseChooseFile(inputBrowse, inputPathField, logArea);

		// Add action choose folder
		addActionBrowseChooseFolder(outputBrowse, outputPathField, logArea);
		
		// Add action submit button
		addActionSubmitButton(submitButton,inputPathField,outputPathField,logArea);


	}

	public void addActionClearButton(JButton button, JTextField inputPathField, JTextField outputPathField,
			JTextArea textArea) {
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				inputPathField.setText("");
				outputPathField.setText("");
				textArea.setText("");

			}
		});
	}
	
	public void addActionSubmitButton(JButton button, JTextField inputPathField, JTextField outputPathField,
			JTextArea textArea) {
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Create File
				createFile(outputPathField,textArea);
			}
		});
	}

	public void addActionBrowseChooseFile(JButton button, JTextField pathField, JTextArea textArea) {
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				jfc.setAcceptAllFileFilterUsed(false);
				int returnValue = jfc.showSaveDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					if (jfc.getSelectedFile().isFile()) {
						pathField.setText(jfc.getSelectedFile().toString());
						textArea.append("You selected the file: " + jfc.getSelectedFile().toString() + "\n");

					} else {
						textArea.append("You must choose a file!!! \n");
					}
				}

			}
		});
	}

	public void addActionBrowseChooseFolder(JButton button, JTextField pathField, JTextArea textArea) {
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int returnValue = jfc.showSaveDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					if (jfc.getSelectedFile().isDirectory()) {
						pathField.setText(jfc.getSelectedFile().toString());
						textArea.append("You selected the folder: " + jfc.getSelectedFile().toString() + "\n");

					} else {
						textArea.append("You must choose a folder!!! \n");
					}
				}

			}
		});
	}
	
	private void createFile(JTextField pathField, JTextArea textArea) {
	    try {
	    	int rd = (int)Math.random()*1000;
	        File myObj = new File(pathField.getText()+"\\demo_"+String.valueOf(rd)+".t");
	        if (myObj.createNewFile()) {
	        	textArea.append("Create file: "+pathField.getText()+"demo_"+rd);
	          System.out.println("File created: " + myObj.getName());
	        } else {
	          System.out.println("File is overiding.");
	        }
	      } catch (IOException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	      }
	}

}
