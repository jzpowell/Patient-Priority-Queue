package Priority_Queue;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.sql.*;

import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.Box;



public class PatientUI  {

	protected static final String String = null;
	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_8;
	//private JPanel panelMain;
	private JPanel addPanel;
	private JPanel searchPanel ;
	private JTextField textField;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientUI window = new PatientUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 Connection con = null;
	 private JTable table;
	 private JTable table_1;
	 private JTextField textField_4;
	 private JTextField textField_7;

	/**
	 * Create the application.
	 */
	public PatientUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		con = methodClass.dbConnection();
		frame = new JFrame();
		frame.setBounds(100, 100, 1273, 723);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		final JPanel homePanel = new JPanel();
		homePanel.setBackground(new Color(176, 196, 222));
		frame.getContentPane().add(homePanel, "name_196719312612489");
		homePanel .setVisible(true);
			


		addPanel = new JPanel();
		addPanel.setBackground(new Color(176, 196, 222));
		frame.getContentPane().add(addPanel, "name_196727655918713");
		addPanel.setLayout(null);
		homePanel .setVisible(false);
		
		
		searchPanel = new JPanel();
		searchPanel.setBackground(new Color(176, 196, 222));
		frame.getContentPane().add(searchPanel, "name_196731797739741");
		searchPanel.setLayout(null);
		searchPanel.setVisible(false);
			
			
		
		JButton btnaddpatientNewButton = new JButton("Add Patient");
		Image Img2 = new ImageIcon(this.getClass().getResource("/add1.png")).getImage();
		btnaddpatientNewButton.setIcon(new ImageIcon(Img2));
		btnaddpatientNewButton.setBounds(367, 150, 206, 54);
		btnaddpatientNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		  addPanel.setVisible(true);
		  homePanel.setVisible(false);
		  //methodClass.updateIDNum();
			}
			
		});
		homePanel.setLayout(null);
		homePanel.add(btnaddpatientNewButton);
		
		JButton btnSearchNewButton_1 = new JButton("Search");
		Image Img1 = new ImageIcon(this.getClass().getResource("/Search1.png")).getImage();
		btnSearchNewButton_1.setIcon(new ImageIcon(Img1));
		btnSearchNewButton_1.setBounds(697, 150, 206, 54);
		try {
			btnSearchNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					searchPanel.setVisible(true);
					  homePanel.setVisible(false);
				}
			});
		} catch (Exception e1) {
			System.out.println(e1);
			e1.printStackTrace();
		}
		homePanel.add(btnSearchNewButton_1);
		
		JLabel labelLogo = new JLabel("");
		Image Img = new ImageIcon(this.getClass().getResource("/Sacred_transparent.png")).getImage();
		labelLogo.setIcon(new ImageIcon(Img));
		labelLogo.setBounds(256, -11, 760, 162);
		homePanel.add(labelLogo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 239, 1238, 456);
		homePanel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Load Current List");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "Select * from Pat_List;";
					PreparedStatement pst = con.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}
			}
		});
		btnNewButton.setBounds(17, 198, 135, 29);
		homePanel.add(btnNewButton);
		
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setBounds(350, 166, 75, 16);
		addPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name");
		lblNewLabel_2.setBounds(752, 166, 66, 16);
		addPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Date of Birth");
		lblNewLabel_3.setBounds(350, 245, 84, 16);
		addPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Height (e.g. 5\" 3')");
		lblNewLabel_4.setBounds(556, 245, 160, 16);
		addPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Weight (lbs.)");
		lblNewLabel_5.setBounds(752, 245, 160, 16);
		addPanel.add(lblNewLabel_5);
		
		textField_1 = new JTextField();
		textField_1.setBounds(350, 182, 160, 26);
		addPanel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(556, 182, 160, 26);
		addPanel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(752, 182, 160, 26);
		addPanel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(752, 261, 160, 26);
		addPanel.add(textField_5);
		textField_5.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(350, 261, 160, 26);
		addPanel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(558, 261, 157, 26);
		addPanel.add(textField_7);
		textField_7.setColumns(10);
		
		
		JLabel lblNewLabel_11 = new JLabel("Add Patient");
		lblNewLabel_11.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setBounds(531, 50, 210, 52);
		addPanel.add(lblNewLabel_11);
		
		JLabel lblPatient = new JLabel("Patient # "+ methodClass.updateIDNum());
		lblPatient.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatient.setBounds(582, 100, 109, 16);
		addPanel.add(lblPatient);
		
		String [] patPriority= {"Select One", "None", "Low", "Medium", "High", "Extreme"};
		JComboBox comboBox = new JComboBox(patPriority);
		comboBox.setBounds(556, 397, 160, 27);
		addPanel.add(comboBox);
		
		JButton btnSubmit = new JButton("Submit");
		Image Img5 = new ImageIcon(this.getClass().getResource("/check.png")).getImage();
		btnSubmit.setIcon(new ImageIcon(Img5));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final String fNameText  =  textField_1.getText();
				final String mNameText  =  textField_2.getText();
				final String lNameText  =  textField_3.getText();
				final String dobText    =  textField_4.getText();
				final String weightText =  textField_5.getText();
				final String heightText =  textField_7.getText();
				final String streetText =  textField_9.getText();
				final String cityText 	=  textField_10.getText();
				final String stateText  =  textField_11.getText();
				
				
				String patPrioritySetting = "";
				
				if(comboBox.getSelectedIndex()==1){
					patPrioritySetting = "0";
				}else if (comboBox.getSelectedIndex() == 2){
					patPrioritySetting = "1";
				}else if (comboBox.getSelectedIndex() == 3){
					patPrioritySetting = "2";
				}else if (comboBox.getSelectedIndex() == 4){
					patPrioritySetting = "3";
				}else if (comboBox.getSelectedIndex() == 5){
					patPrioritySetting = "4";
				}
				
				
				boolean success = false;
						
						try {
					methodClass.addEntry(fNameText, lNameText, mNameText, streetText, cityText, stateText, heightText, weightText, dobText, patPrioritySetting);
					success = true;
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				if(success){
					JOptionPane.showMessageDialog(frame, "Entry Added!");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					textField_7.setText("");
					textField_9.setText("");
					textField_10.setText("");
					textField_11.setText("");
					
					methodClass.updateIDNum();
					
					
				}
				
				/*
				Driver.setPat_FName(fNameText);
				Driver.setPat_MName(mNameText);
				Driver.setPat_LName(lNameText);
				Driver.setPat_DOB(dobText);
				Driver.setPat_Height(heightText);
				Driver.setPat_Weight(weightText);
				Driver.setPat_City(cityText);
				Driver.setPat_State(stateText);
				Driver.setPat_StreetAddrs(streetText);
				*/
			}
		});
		btnSubmit.setBounds(544, 513, 185, 43);
		addPanel.add(btnSubmit);
		
		JButton btnBackToHome = new JButton("Home");
		btnBackToHome.setBackground(Color.LIGHT_GRAY);
		Image Img3 = new ImageIcon(this.getClass().getResource("/Home.png")).getImage();
		btnBackToHome.setIcon(new ImageIcon(Img3));
		btnBackToHome.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				homePanel.setVisible(true);  
				addPanel.setVisible(false);
					}
		});
		btnBackToHome.setBounds(6, 6, 130, 52);
		addPanel.add(btnBackToHome);
		
		
		//Search panel
		
		textField_9 = new JTextField();
		textField_9.setBounds(350, 329, 160, 26);
		addPanel.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(556, 329, 160, 26);
		addPanel.add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(752, 329, 160, 26);
		addPanel.add(textField_11);
		textField_11.setColumns(10);
		
		JLabel lblStreetAddress = new JLabel("Street Address");
		lblStreetAddress.setBounds(350, 311, 98, 16);
		addPanel.add(lblStreetAddress);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(556, 311, 61, 16);
		addPanel.add(lblCity);
		
		JLabel lblState = new JLabel("State");
		lblState.setBounds(752, 311, 61, 16);
		addPanel.add(lblState);
		
		JLabel lblMiddleName = new JLabel("Middle Name");
		lblMiddleName.setBounds(556, 166, 84, 16);
		addPanel.add(lblMiddleName);
		
		JLabel lblPriority = new JLabel("Priority");
		lblPriority.setBounds(556, 379, 61, 16);
		addPanel.add(lblPriority);
		
		
		
		
		
		JLabel lblNewLabel_7 = new JLabel("Patient Search");
		lblNewLabel_7.setBounds(588, 6, 96, 16);
		searchPanel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("First Name");
		lblNewLabel_8.setBounds(517, 49, 96, 16);
		searchPanel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Last Name");
		lblNewLabel_9.setBounds(517, 77, 66, 16);
		searchPanel.add(lblNewLabel_9);
		
		textField_6 = new JTextField();
		textField_6.setBounds(685, 44, 200, 26);
		searchPanel.add(textField_6);
		textField_6.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(685, 72, 200, 26);
		searchPanel.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblor = new JLabel("-OR-");
		lblor.setHorizontalAlignment(SwingConstants.CENTER);
		lblor.setBounds(588, 121, 96, 16);
		searchPanel.add(lblor);
		
		JLabel lblPatientId = new JLabel("Patient ID");
		lblPatientId.setBounds(522, 177, 61, 16);
		searchPanel.add(lblPatientId);
		
		textField = new JTextField();
		textField.setBounds(685, 172, 200, 26);
		searchPanel.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(6, 319, 1261, 376);
		searchPanel.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JButton btnSubmit_1 = new JButton("Submit");
		Image Img4 = new ImageIcon(this.getClass().getResource("/check.png")).getImage();
		btnSubmit_1.setIcon(new ImageIcon(Img4));
			btnSubmit_1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					
					final String fName = textField_6.getText();
					final String lName = textField_8.getText();
					final String patID = textField.getText();
					int counter = 0;
					
					if (fName.isEmpty() == false){
						counter = 1;
					} else if (lName.isEmpty()==false){
						counter = 2;
					}else if (patID.isEmpty()==false){
						counter = 4;
					}
					
					//System.out.println(counter);
					
					switch (counter) {
					case 1:
						try {
							String query = "Select * from Pat_List where Pat_FName Like '" +fName+"';";
							PreparedStatement pst = con.prepareStatement(query);
							ResultSet rs = pst.executeQuery();
							
							table_1.setModel(DbUtils.resultSetToTableModel(rs));
						} catch (Exception e4) {
							System.out.println(e4.getMessage());
						}
						break;
					case 2:
						try {
							String query = "Select * from Pat_List where Pat_LName Like '" +lName+"';";
							PreparedStatement pst = con.prepareStatement(query);
							ResultSet rs = pst.executeQuery();
							
							table_1.setModel(DbUtils.resultSetToTableModel(rs));
						} catch (Exception e5) {
							System.out.println(e5.getMessage());
						}
						break;
					case 4:
						try {
							String query = "Select * from Pat_List where Pat_ID Like '" +patID+"';";
							PreparedStatement pst = con.prepareStatement(query);
							ResultSet rs = pst.executeQuery();
								
							table_1.setModel(DbUtils.resultSetToTableModel(rs));
						} catch (Exception e3) {
							System.out.println(e3.getMessage());
						}	
						break;
					default:
						JOptionPane.showMessageDialog(frame, "Please enter search information. ");
						break;
					}
					
					textField_6.setText("");
					textField_8.setText("");
					textField.setText("");
					
		
				}});
		btnSubmit_1.setBounds(563, 230, 185, 43);
		searchPanel.add(btnSubmit_1);
		
		
		JLabel lblResults = new JLabel("Results");
		lblResults.setBounds(6, 291, 61, 16);
		searchPanel.add(lblResults);
		
		
		
		JButton button = new JButton("Home");
		Image Img6 = new ImageIcon(this.getClass().getResource("/Home.png")).getImage();
		button.setIcon(new ImageIcon(Img6));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homePanel.setVisible(true);  
				searchPanel.setVisible(false);
			}
		});
		btnBackToHome.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				homePanel.setVisible(true);  
				searchPanel.setVisible(false);
					}
		});
		button.setBounds(6, 6, 120, 59);
		searchPanel.add(button);
		
	
		
	
	}
}
