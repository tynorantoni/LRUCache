package entities;

public class Example {

	
	private String name;
	private int id;
	private boolean isTrue;
	
	
	
	public Example(){}
	
	public Example(int id,String name, boolean isTrue) {
		
		this.name = name;
		this.id = id;
		this.isTrue = isTrue;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isTrue() {
		return isTrue;
	}
	public void setTrue(boolean isTrue) {
		this.isTrue = isTrue;
	}
	@Override
	public String toString() {
		return "Example [name=" + name + ", id=" + id + ", isTrue=" + isTrue + "]";
	}
	
	
	
	
}
