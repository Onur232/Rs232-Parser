package com.sur.parser.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.Border;

import com.sur.parser.objects.Sentence;


public class MainFrame {
	JFrame frame=new JFrame("SUR PARSER");
	private JButton btnCreateTextFile;
//	private JButton btnDrawGraph;
	private JToggleButton btnSelectAll;
	private JPanel pnlNorth;
	private ArrayList<JCheckBox> checkBoxs=new ArrayList<>();
	private ArrayList<JLabel> labels=new ArrayList<>();
	private String[] checkBoxNames={"Sürat","Umk","Rota"};
	
//	
	
	//TODO bilgi ve checkbox panelleri ayrý olacak ve border'lý olacak.
	public MainFrame() {
		initializeComponents();
	}

	private void initializeComponents() {
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
//		frame.setLayout(new FlowLayout());
		pnlNorth = new JPanel();
//		JPanel pnlMain=new JPanel();
//		pnlMain.setLayout(new BoxLayout(pnlMain, BoxLayout.Y_AXIS));
//		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//		pnlMain.setLayout(new BorderLayout());
//		TitledBorder createTitledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE), "ASS FIELDS");
		Border createLineBorder = BorderFactory.createLineBorder(Color.DARK_GRAY, 3);
//		pnlNorth.setBorder(createLineBorder);
		GridLayout gridLayout=new GridLayout(20, 2);
		pnlNorth.setLayout(gridLayout);
		Border borderLabels = BorderFactory.createLineBorder(Color.BLUE, 1);
		
		
//		for (int i = 0; i < labelNames.length; i++) {
//			JLabel label=new JLabel(labelNames[i]);
//			label.setBackground(Color.DARK_GRAY);
//			label.setBorder(borderLabels);
//			pnlNorth.add(label);
//			labels.add(label);
//		}
		
		
//		pnlMain.add(pnlNorth,BorderLayout.NORTH);
//		JPanel pnlMiddle=new JPanel();
		Border borderCheckbox = BorderFactory.createLineBorder(Color.GREEN, 1);
//		Font myFont = new Font("Verdana", Font.ITALIC | Font.BOLD,14);
		Font myFont = new Font("Courier", Font.ITALIC | Font.BOLD,15);
		for (int i = 0; i < checkBoxNames.length; i++) {
				JCheckBox checkBox=new JCheckBox(checkBoxNames[i]);
				checkBox.setBorder(borderCheckbox);
				checkBox.setBorderPainted(true);
				checkBox.setBackground(Color.LIGHT_GRAY);
				checkBox.setFont(myFont);
				pnlNorth.add(checkBox);
				checkBoxs.add(checkBox);
		}
//		pnlMain.add(pnlMiddle,BorderLayout.CENTER);
		btnCreateTextFile = new JButton("Create Text File");
//		btnDrawGraph=new JButton("Draw Graph");
		btnSelectAll=new JToggleButton("Select All");
		JPanel pnlSouth=new JPanel();
		pnlSouth.add(btnCreateTextFile);
//		pnlSouth.add(btnDrawGraph);
		pnlSouth.add(btnSelectAll);
//		frame.add(pnlMain);
		frame.add(pnlNorth);
		frame.add(pnlSouth,BorderLayout.SOUTH);
	}
	
//	
	
	public void addCheckBoxListener(ActionListener listener){
		for (JCheckBox jCheckBox : checkBoxs) {
			jCheckBox.addActionListener(listener);
		}
	}
	
	public void addBtnCreateTextFileListener(ActionListener listener){
		btnCreateTextFile.addActionListener(listener);
	}
	
//	public void addBtnDrawGraphListener(ActionListener listener){
//		btnDrawGraph.addActionListener(listener);
//	}
	
	public void addBtnSelectAllListener(ActionListener listener){
		btnSelectAll.addActionListener(listener);
	}
	
	public void setVisible(boolean visible){
		frame.setVisible(visible);
	}

	public void dispose() {
		frame.setVisible(false);
	}

	public void selectAllCheckBox(boolean selected) {
		for (JCheckBox checkBox : checkBoxs) {
//			checkBox.setSelected(selected);
			if (selected) {
				btnSelectAll.setText("Deselect All");
				if (!checkBox.isSelected()) {
					checkBox.doClick();
				}
			}
			else {
				btnSelectAll.setText("Select All");
				if (checkBox.isSelected()) {
					checkBox.doClick();
				}
			}
		}
	}

}
