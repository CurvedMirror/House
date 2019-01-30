package cn.pojo;

public class House {
	private int id;
	private String title;
	private int type_id;
	private String fdate;
	private String description;
	private double price;
	private String pic;
	private String contact;
	private Type type;

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
	}

	public String getFdate() {
		return fdate;
	}

	public void setFdate(String fdate) {
		this.fdate = fdate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescriptio(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "House [id=" + id + ", title=" + title + ", type_id=" + type_id
				+ ", fdate=" + fdate + ", description=" + description
				+ ", price=" + price + ", pic=" + pic + ", contact=" + contact
				+ ", type=" + type + "]";
	}

}
