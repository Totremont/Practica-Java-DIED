package clases;

import java.util.Objects;

public class Localidad extends Ubicacion {
	
	private static int increment = 0;
	private Provincia provincia;
	
	
	public Localidad(String nombre, Provincia provincia) {
		super(nombre);
		this.provincia = provincia;
		this.id = increment;
		increment++;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Localidad localidad = (Localidad) o;
		return (Objects.equals(provincia, localidad.provincia) && Objects.equals(nombre, localidad.getNombre()));
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), provincia,nombre);
	}

	public Provincia getProvincia() {
		return provincia;
	}
	
	

}
