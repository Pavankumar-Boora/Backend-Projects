package StreamAPI;

public class MyObject {
	
	private String str;
	
	public MyObject() {
		super();
	}
	public MyObject(String str) {
		super();
		this.str = str;
	}

	public String toUppercase() {
		return "I'm in uppercase";
	}
	
	public String toUppercase(String str) {
		return str.toUpperCase();
	}
	@Override
	public String toString() {
		return "MyObject [str=" + str + "]";
	}
	
}
