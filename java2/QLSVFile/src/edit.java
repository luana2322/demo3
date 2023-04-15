import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class edit extends JFrame {

	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtAdress;
Giaodien gd;
SaveFile savefile;
private JTextField txtName;
private JLabel label;

	/**
	 * Launch the application.
	 * 
	  selectedrow = table.getSelectedRow();
	 v = model.getDataVector().get(selectedrow);
	y = String.valueOf(v.firstElement());
	 */
	public static void main(String[] args) {
	
					edit frame = new edit();
	}
	/**
	 * Create the frame.
	 */
	public edit() {
		init();
		this.setTitle("Edit");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
		public void init() {
			savefile=new SaveFile();
			savefile.read();
			

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 10, 446, 287);
		contentPane.add(panel);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				for (SInhVien sv : savefile.studentList) {
//					if( gd.y.equals(sv.getStuID()) ) {
//						
//						savefile.studentList.remove(sv);
//						 savefile.write(savefile.studentList);
//					        savefile.writetext(savefile.studentList);
//						
//					
//						
//					}
//				} 
				
				
				
				
				
				
				// add
				
StringBuilder str=new StringBuilder();
System.out.println("ok");
				
				if(txtid.getText().equals("")) {
					str.append("Hãy nhập ID");
				} if(txtAdress.getText().equals("")) {                                  
					 str.append("\nHãy nhập địa chỉ");
				} if(txtName.getText().equals("")){
			      str.append("\nHãy nhập Tên sv");
				}
//				int u=0;
//				
//				for (SInhVien sv : savefile.studentList) {
//					if(txtid.getText().equals(sv.getStuID())) {
//						u++;
//					}
//				}
//				
//				if(u!=0) {
//					str.append("\nMã Sinh Viên đã tồn tại.Hãy nhập lại.");
//				}
//				
				
				
				
				if(!str.isEmpty()) {
					JOptionPane.showInternalMessageDialog(null, str);
				}else {
					
					for (SInhVien sv : savefile.studentList) {
						if( gd.y.equals(sv.getStuID())){
							sv.setName(txtName.getText());
							sv.setStuID(txtid.getText());
							sv.setAdress(txtAdress.getText());
						}
					}
					 savefile.write(savefile.studentList);
				        savefile.writetext(savefile.studentList);
				        
					
			        txtAdress.setText("");
			        txtid.setText("");
			        txtName.setText("");
			        
			        JOptionPane.showInternalMessageDialog(null, "Chỉnh sửa thông tin thành công.");
			
//				
//				
//			        String name = txtName.getText();
//			        String StuID= txtid.getText();
//			        String address = txtAdress.getText();
//			       
//			        SInhVien student = new SInhVien(StuID, name, address);
//			        savefile.add(student);
//			    	for (SInhVien sv : savefile.studentList) {
//						System.out.println(sv.getName());
//					}
//			        savefile.write(savefile.studentList);
//			        savefile.writetext(savefile.studentList);
//			        
			   
		        
			        dispose();
			        
				}
				
				
				
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnSave.setBounds(240, 236, 196, 41);
		panel.add(btnSave);
		
		JLabel lblNewLabel_1 = new JLabel("StuID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 79, 105, 32);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(10, 138, 105, 32);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Adress:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(10, 191, 105, 32);
		panel.add(lblNewLabel_1_2);
		
		txtid = new JTextField();
		txtid.setColumns(10);
		txtid.setBounds(174, 82, 234, 32);
		panel.add(txtid);
		
		 txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(174, 141, 234, 32);
		panel.add(txtName);
		
		txtAdress = new JTextField();
		txtAdress.setColumns(10);
		txtAdress.setBounds(174, 194, 234, 32);
		panel.add(txtAdress);
		
		 label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.PLAIN, 21));
		label.setBounds(10, 10, 398, 41);
		panel.add(label);

		label.setText("Chỉnh sửa thông tin sinh viên "+gd.y);
	}
}
