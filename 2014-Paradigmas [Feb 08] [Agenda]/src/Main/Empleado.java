package Main;

public class Empleado extends Persona {
	private String eps;
	private String arp;
	private double salario;

	public Empleado(String name, String address, String eps, String arp, double salario) {
		super(name, address);
		this.eps = eps;
		this.arp = arp;
		this.salario = salario;
	}

	public String getEps() {
		return eps;
	}

	public void setEps(String eps) {
		this.eps = eps;
	}

	public String getArp() {
		return arp;
	}

	public void setArp(String arp) {
		this.arp = arp;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

}
