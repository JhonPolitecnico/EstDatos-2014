package user;

/**
 * Estate
 * 
 * @author Jhon Jairo Eslava
 * @code 1310012946
 * 
 */
public class User {

	private String name;
	private String surname;
	private int phone;
	private int cellphone;
	private int dni;
	private String nick;
	private String password;
	private String email;

	public User(String name, String surname, int phone, int cellphone, int dni, String nick, String password, String email) {
		super();
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.cellphone = cellphone;
		this.dni = dni;
		this.nick = nick;
		this.password = password;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public int getPhone() {
		return phone;
	}

	public int getCellphone() {
		return cellphone;
	}

	public int getDni() {
		return dni;
	}

	public String getNick() {
		return nick;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public void setCellphone(int cellphone) {
		this.cellphone = cellphone;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
