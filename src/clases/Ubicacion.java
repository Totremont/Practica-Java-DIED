package clases;

import java.util.Objects;

public abstract class Ubicacion {
	
	protected int id;
	protected String nombre;
	
	protected Ubicacion(String nombre)
	{
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}

}
