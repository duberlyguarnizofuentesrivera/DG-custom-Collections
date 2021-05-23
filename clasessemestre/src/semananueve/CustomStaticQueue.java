package semananueve;

import java.lang.reflect.Array;

public class CustomStaticQueue<T> {
	// creamos una variable del tipo genérico e indicamos que contendrá un array
	private T[] elementos;
	private int lenght = 0;
	private int elementos_en_cola = 0;

	// Aquí nos hacemos un poco los listos...
	// Java no permite asignar arrays con elementos genéricos, es decir
	// elementos = T[tamaño], ya que no compila (la razón de esto es bien
	// interesante pero también larga.
	// Para empezar, al constructor no solo le pasamos el tamaño del array (size)
	// sino también la "clase" del tipo de datos que usará. Todos los objeto tienen
	// el atributo "class", que guarda una referencia a la clase, o molde que lo
	// creó.
	public CustomStaticQueue(Class<T> cls, int size) {
		// Entonces, una vez teniendo la clase del objeto, y el tamaño, usamos el método
		// newInstance (nueva instancia) que crea una nueva instancia de una clase. En
		// este caso, crea una nueva instancia de la clase Array (que es la clase que
		// corresponde a la estructura primitiva "[]"... este método requiere la "clase"
		// del objeto a crear y el número de elementos que definirá el tamaño del array.
		// Creado este array, le hacemos "cast" (lo convertimos a otro tipo de objeto)
		// hacia un array del tipo genérico T ("T[]) mediante el uso de paréntesis.
		// Es posible que esto genere una advertencia, ya que el IDE no puede
		// garantizar la conversión, pero si funciona, así que no pasa nada.
		elementos = (T[]) Array.newInstance(cls, size);
		this.lenght = size;
	}

	public int lenght() {
		return this.lenght;
	}

	public T consultar(int index) {
		return this.elementos[index];
	}

	public void agregar(T element) throws Exception {
		// Agregamos nuevos elementos. El nuevo elemento siempre se agrega al final
		if (elementos_en_cola == lenght) {
			// la cola está llena
			throw new Exception("Sin espacio en la cola: hay " + this.elementos_en_cola + " de " + this.lenght
					+ " espacios utilizados");
		}
		else {
			if (elementos_en_cola == 0) {
				// no existen aún elementos en la cola
				elementos[0] = element;
			}
			else {
				// existe al menos un elemento en la cola
				elementos[elementos_en_cola] = element;
			}
			elementos_en_cola++;
		}

	}

	public T sacar() {
		T resultado = null;
		if(elementos[0]==null) {
			//no hay elementos
			return resultado;
		}else {
			//hay elementos
			resultado=elementos[0];
			T[] auxiliar = elementos;
			for (int i = 0; i < elementos_en_cola-1; i++) {
				elementos[i]=auxiliar[i+1];
			}
			elementos_en_cola--;
			return resultado;
		}
	}
	public void listarElementos() {
		System.out.println("Listado de elementos en " + elementos);
		for (int i=0; i<elementos_en_cola; i++) {
			System.out.println("--> "+elementos[i]);
		}
	}
}
