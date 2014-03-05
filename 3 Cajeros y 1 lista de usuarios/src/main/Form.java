package main;

public class Form {
	private int ticket;
	private User user;

	public Form(User user, int ticket) {
		this.user = user;
		this.ticket = ticket;
	}

	public int getTicket() {
		return ticket;
	}

	public User getUser() {
		return user;
	}
}
