package mx.ipn.upiicsa.web.entity;

public class ContactType {
	private Integer id;
	private String name;

	public static final ContactType PHONE = new ContactType(1, "Phone");
	public static final ContactType TWITTER = new ContactType(2, "Twitter");
	public static final ContactType FACEBOOK = new ContactType(3, "Facebook");
	public static final ContactType EMAIL = new ContactType(4, "Email");
	
	public ContactType(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
