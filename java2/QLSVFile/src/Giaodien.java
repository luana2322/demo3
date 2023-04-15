import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.PopupMenu;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class Giaodien extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtid;
	private JTextField txtname;
	private JTextField txtadress;
	private static DefaultTableModel model;
	    private SaveFile savefile;
	    SInhVien sv;
	    private static int selectedrow = -1;
		public static Vector v;
		public static	String   y;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	      Giaodien giaodien=new Giaodien();
					
					
	
	}

		public Giaodien(){
		init();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
	}
	
public void init() {
				
	  
	savefile=new SaveFile();
	
//	edit frame = new edit();


		
		setBounds(100, 100, 1126, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 43, 431, 442);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnadd = new JButton("ADD");
		btnadd.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				StringBuilder str=new StringBuilder();
				
				if(txtid.getText().equals("")) {
					str.append("Hãy nhập ID");
				} if(txtname.getText().equals("")) {                                  
					str.append("\nHãy nhập Tên sv");
				} if(txtadress.getText().equals("")){
			       str.append("\nHãy nhập địa chỉ");
				}
				int u=0;
				
				for (SInhVien sv : savefile.studentList) {
					if(txtid.getText().equals(sv.getStuID())) {
						u++;
					}
				}
				
				if(u!=0) {
					str.append("\nMã Sinh Viên đã tồn tại.Hãy nhập lại.");
				}
				
				
				
				
				if(!str.isEmpty()) {
					JOptionPane.showInternalMessageDialog(null, str);
				}else {
					
			
				
				
			        String name = txtname.getText();
			        String StuID= txtid.getText();
			        String address = txtadress.getText();
			       
			        SInhVien student = new SInhVien(StuID, name, address);
			        savefile.add(student);
			        savefile.write(savefile.studentList);
			        savefile.writetext(savefile.studentList);
			        
			   
		            model.addRow(new Object[] { StuID, name, address});
			       
			        txtadress.setText("");
			        txtid.setText("");
			        txtname.setText("");
			        
				}
				    
			        
			        
			}
		});
		btnadd.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnadd.setBounds(0, 277, 196, 41);
		panel.add(btnadd);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				for (SInhVien sv : savefile.studentList) {
//					if( txtname.getText().equals(sv.getName())||txtid.getText().equals(sv.getStuID())  ||txtadress.getText().equals(sv.getAdress())) {
//						
//						savefile.studentList.remove(sv);
//						 savefile.write(savefile.studentList);
//					        savefile.writetext(savefile.studentList);
//						
//						JOptionPane.showMessageDialog(null, "Xoa thanh cong!");
//						txtadress.setText("");
//						txtid.setText("");
//						txtname.setText("");
//						
//					}
//				}
				
				selectedrow = table.getSelectedRow();

				if (selectedrow < 0) {
					JOptionPane.showMessageDialog(null, "Hãy chọn sinh viên	 muốn xoá.");
				} else {
					try {
						v = model.getDataVector().get(selectedrow);
						y = String.valueOf(v.firstElement()); 

for (SInhVien sv : savefile.studentList) {
	if(sv.getStuID().equals(y)) {
		savefile.studentList.remove(sv);
		 savefile.write(savefile.studentList);
	        savefile.writetext(savefile.studentList);
		
		JOptionPane.showMessageDialog(null, "Xoa thanh cong!");
		txtadress.setText("");
		txtid.setText("");
		txtname.setText("");
	}
}
						
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
				
				selectedrow=-1;
				  model.setRowCount(0);
			        
			        for (SInhVien sv: savefile.studentList) {
			        	model.addRow(new Object[] { sv.getStuID(), sv.getName(), sv.getAdress()});
					       
					}
				
				
		
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnDelete.setBounds(206, 277, 196, 41);
		panel.add(btnDelete);
		int p = 0;
		
		JButton btnEdit = new JButton("EDIT");
		btnEdit.addActionListener(new ActionListener() {
		
			

			public void actionPerformed(ActionEvent e) {
				
StringBuilder str=new StringBuilder();

if(txtid.getText().equals("")&&txtname.getText().equals("")&&txtadress.getText().equals("")) {
	JOptionPane.showMessageDialog(null,"Chọn sinh viên muốn chỉnh sửa thông tin.");
}else {
	

				
				if(txtid.getText().equals("")) {
					str.append("Hãy nhập ID");
				} if(txtname.getText().equals("")) {                                  
					str.append("\nHãy nhập Tên sv");
				} if(txtadress.getText().equals("")){
			       str.append("\nHãy nhập địa chỉ");
				}
				


				if(!str.isEmpty()) {
					JOptionPane.showInternalMessageDialog(null, str);
				}else {
					
					if(JOptionPane.showConfirmDialog(null,"Xác nhận lưu lại thông tin sinh viên ?","Confirm",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
						
						
						for (SInhVien sv : savefile.studentList) {
							if( txtid.getText().equals(sv.getStuID())){
								sv.setName(txtname.getText());
								sv.setStuID(txtid.getText());
								sv.setAdress(txtadress.getText());
							}
						}
						 savefile.write(savefile.studentList);
					        savefile.writetext(savefile.studentList);
					        
						
				        txtadress.setText("");
				        txtid.setText("");
				        txtname.setText("");
				        
				        JOptionPane.showInternalMessageDialog(null, "Chỉnh sửa thông tin thành công.");
				        
				        model.setRowCount(0);
				        
				        for (SInhVien sv: savefile.studentList) {
				        	model.addRow(new Object[] { sv.getStuID(), sv.getName(), sv.getAdress()});
						       
						}
				
						
						
					}
				
					
					
				}

	
					
}
					
			}
		});
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnEdit.setBounds(0, 340, 196, 41);
		panel.add(btnEdit);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);	
				int u=0;
				for (SInhVien sv : savefile.studentList) {
					if( txtname.getText().equals(sv.getName())||txtid.getText().equals(sv.getStuID())  ||txtadress.getText().equals(sv.getAdress())) {
						model.addRow(new Object[] { sv.getStuID(), sv.getName(), sv.getAdress()});
						u++;
					}
				}
				if(u==0) {
					JOptionPane.showMessageDialog(null, "Không tồn tại sinh viên ");
				}
				
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnSearch.setBounds(206, 340, 196, 41);
		panel.add(btnSearch);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(JOptionPane.showConfirmDialog(null, "Do you want to clear all?","Confirmation", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
			savefile.studentList.clear();
					savefile.write(savefile.studentList);
			        savefile.writetext(savefile.studentList);
			}
				
				model.setRowCount(0);
				  for (SInhVien sv: savefile.studentList) {
			        	model.addRow(new Object[] { sv.getStuID(), sv.getName(), sv.getAdress()});
					       
					}
				
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnClear.setBounds(0, 391, 196, 41);
		panel.add(btnClear);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Do you want to exit?","Confirmation", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
						dispose();
				}
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnCancel.setBounds(206, 391, 196, 41);
		panel.add(btnCancel);
		
		JLabel lblNewLabel_1 = new JLabel("StuID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 30, 105, 32);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(10, 96, 105, 32);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Adress:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(10, 156, 105, 32);
		panel.add(lblNewLabel_1_2);
		
		txtid = new JTextField();
		txtid.setBounds(174, 30, 234, 32);
		panel.add(txtid);
		txtid.setColumns(10);
		
		txtname = new JTextField();
		txtname.setColumns(10);
		txtname.setBounds(174, 105, 234, 32);
		panel.add(txtname);
		
		txtadress = new JTextField();
		txtadress.setColumns(10);
		txtadress.setBounds(174, 165, 234, 32);
		panel.add(txtadress);
		
		JButton btnShow = new JButton("SHOW ALL");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				savefile.studentList.clear();;
				
				 savefile.readfiletext();
				 model.setRowCount(0);
				   
					for (SInhVien sv : savefile.studentList) {
						model.addRow(new Object[] { sv.getStuID(), sv.getName(), sv.getAdress()});
					       
						
						
					}
					
			}
		});
		btnShow.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnShow.setBounds(0, 230, 196, 41);
		panel.add(btnShow);
		
		JLabel lblNewLabel = new JLabel("STUDENT MANAGEMENT");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(218, 10, 712, 31);
		contentPane.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(449, 43, 663, 442);
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedrow=table.getSelectedRow();
				v = model.getDataVector().get(selectedrow);
				y = String.valueOf(v.firstElement()); 
				
				for (SInhVien sv : savefile.studentList) {
					if(y.equals(sv.getStuID())) {
						txtid.setText(sv.getStuID());
						txtname.setText(sv.getName());
						txtadress.setText(sv.getAdress());
					}
				}
				
				
				
			}
		});
		scrollPane.setViewportView(table);
		model = new DefaultTableModel();
		model.addColumn("StuID");
		model.addColumn("Name");
		model.addColumn("Address");
	
		
	 savefile.readfiletext();
	 model.setRowCount(0);
	   
		for (SInhVien sv : savefile.studentList) {
			
			model.addRow(new Object[] { sv.getStuID(), sv.getName(), sv.getAdress()});
		       
			
			
		}
		
		

		table.setModel(model);
	}

}
