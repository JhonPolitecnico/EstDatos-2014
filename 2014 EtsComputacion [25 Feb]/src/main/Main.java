package main;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getBono(21));
	}

	// Obtener el valor del bono
	public static float getBono(int empleados) {

		// No evaluar numeros primos
		if (isPrimo(empleados))
			return -1;

		float bono = 0;
		float bonoFinal = 0;

		// no tomar el 1 ni el numero de empleados
		for (int i = 2; i < empleados; i++) {
			// Solo numeros divisores
			if ((empleados % i) == 0) {
				// Formula del bono
				bono = (i * (empleados - i)) / (float) (empleados / i);
				// Si bono es mayor al bono antetior, guardar este bono como el mejor
				if (bono > bonoFinal)
					bonoFinal = bono;
			}
		}

		// Retornar el mejor bono
		return bonoFinal;
	}

	public static boolean isPrimo(int num) {
		int count = 0;
		// Omitir los 2 divisores por defecto
		for (int i = 2; i < num; i++) {
			if ((num % i) == 0)
				count++;
		}

		// False si hay almenos un divisor distinto a los 2 por defecto
		return !(count >= 1);
	}

}
