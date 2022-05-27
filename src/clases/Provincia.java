package clases;

import java.util.Objects;

public class Provincia extends Ubicacion {
	
	private static int increment;
	private Pais pais;

	
	public Provincia(String nombre, Pais pais) {
		super(nombre);
		this.pais = pais;
		this.id = increment;
		increment++;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Provincia prov = (Provincia) o;
		return Objects.equals(pais,prov.pais) && Objects.equals(nombre,prov.nombre);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), pais,nombre);
	}

	public Pais getPais() {
		return pais;
	}
	
	

}
