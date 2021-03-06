package model;

/**
 * Class that defines a Contact
 * @author Simor
 *
 */
public class Contact implements Comparable<Contact> {
	// Attributes
	private String name;
	private String phone;

	// Getters & Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	// CompareTo
	@Override
	public int compareTo(Contact contact) {
		return this.getName().trim().toLowerCase().compareTo(contact.getName().trim().toLowerCase());
	}
	
	/**
	 * Return a 'toString' String (Name + Phone)
	 */
	public String toString()
	{
		String ret = "===========================\n";
		ret += "Nome: " + getName() + "\n";
		ret += "Telefone: " + getPhone() + "\n";
		ret += "===========================\n";
		
		return ret;
	}
}
