package ingredient.model;

public class Ingredient {
	private int inum;	//재료 넘버
	private int recnum;	//레시피 넘버
	private String fname;	//음식 이름
	private String iname;	//재료 이름
	private String mass;	//용량
	public Ingredient() {
		super();
	}
	public Ingredient(int inum, int recnum, String fname, String iname, String mass) {
		super();
		this.inum = inum;
		this.recnum = recnum;
		this.fname = fname;
		this.iname = iname;
		this.mass = mass;
	}
	public int getInum() {
		return inum;
	}
	public void setInum(int inum) {
		this.inum = inum;
	}
	public int getRecnum() {
		return recnum;
	}
	public void setRecnum(int recnum) {
		this.recnum = recnum;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public String getMass() {
		return mass;
	}
	public void setMass(String mass) {
		this.mass = mass;
	}
	@Override
	public String toString() {
		return "Ingredient [inum=" + inum + ", recnum=" + recnum + ", fname=" + fname + ", iname=" + iname + ", mass="
				+ mass + "]";
	}
	
	
}
