package hashtable;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * @key: pais
 * @value: capital
 */
public class Estudiante extends Hashtable<Integer, model.Estudiante> {

	private static final long serialVersionUID = 2838123559435597802L;

	public void insertarEstudiante(int codigo, String nombre) {
		model.Estudiante estudiante = new model.Estudiante(nombre, codigo);
		super.put(estudiante.hashCode(), estudiante);
	}

	public model.Estudiante buscarPorCodigo(int codigo) {
		return (this.containsKey(codigo)) ? this.get(codigo) : null;
	}

	public void removerPorCodigo(int codigo) {
		if (this.containsKey(codigo))
			this.remove(codigo);

	}

	public String devolverEstudiantes() {
		String sRet = "";
		Enumeration<Integer> claves = this.keys();

		while (claves.hasMoreElements()) {
			Object clave = claves.nextElement();
			Object valor = this.get(clave);
			sRet += valor.toString() + "\n";
		}

		return sRet;
	}

}