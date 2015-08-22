package npu.domain;

public class Customer {
	private String name;
	private int id;
	private String state;

	public Customer() {

	}

	public void setName(String name) {
		this.name = name;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getState() {
		return state;
	}

	public int getId() {
		return id;
	}


}
