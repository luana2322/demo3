import java.io.Serializable;

public class SInhVien implements Serializable {
	private static final long serialVersionUID=1L;
	private String StuID;
	private String Name;
	private String Adress;
	public SInhVien(String stuID, String name, String adress) {
		StuID = stuID;
		Name = name;
		Adress = adress;
	}
	public SInhVien() {	
	}
	public String getStuID() {
		return StuID;
	}
	public void setStuID(String stuID) {
		StuID = stuID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAdress() {
		return Adress;
	}
	public void setAdress(String adress) {
		Adress = adress;
	}
    public void parseline(String line) {
    	String[] com=line.split(",");
    	StuID=com[0];
    	Name=com[1];
    	Adress=com[2];
    	
    }

}
