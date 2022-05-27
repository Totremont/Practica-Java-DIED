package clases;

import java.util.Objects;

public class Pais extends Ubicacion {
	
	private static int increment = 0;
	
	public Pais(String nombre)
	{
		super(nombre);
		this.id = increment;
		increment++;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Pais pais = (Pais) o;
		return Objects.equals(nombre,pais.getNombre());
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

}
