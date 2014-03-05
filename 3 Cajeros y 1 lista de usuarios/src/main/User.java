package main;

public class User {
	private String name;
	private int ticket;

	public User(String name, int ticket) {
		this.name = name;
		this.ticket = ticket;
	}

	public String getName() {
		return this.name;
	}

	public int getTicket() {
		return this.ticket;
	}

}
