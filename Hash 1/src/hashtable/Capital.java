package hashtable;

import java.util.Hashtable;

/**
 * @key: pais
 * @value: capital
 */
public class Capital extends Hashtable<String, String> {

	private static final long serialVersionUID = 2838123559435597802L;

	public void insertarPareja(String pais, String capital) {
		super.put(pais, capital);
	}

	public String buscarPorClave(String clave) {
		return (this.containsKey(clave)) ? this.get(clave) : null;
	}

	public void removerPorClave(String clave) {
		if (this.containsKey(clave))
			this.remove(clave);

	}

}