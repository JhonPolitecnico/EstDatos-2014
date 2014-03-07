package Main;

import java.util.ArrayList;

public class Almacen {
	private String name;
	private String address;
	private ArrayList<Empleado> empleados;
	private ArrayList<Cliente> clientes;

	public Almacen(String name, String address) {
		super();
		this.name = name;
		this.address = address;
		this.empleados = new ArrayList<Empleado>();
		this.clientes = new ArrayList<Cliente>();
	}

	public Almacen(String name) {
		super();
		this.name = name;
	}

	public Almacen() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(ArrayList<Empleado> empleados) {
		this.empleados = empleados;
	}

	public void addEmpleado(Empleado empleado) {
		this.empleados.add(empleado);
	}

	public void addCliente(Cliente cliente) {
		this.clientes.add(cliente);
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

}
