package clases;

import clases.interfaces.CriterioBusqueda;

import java.util.Objects;

public abstract class Persona implements CriterioBusqueda<Localidad> {
	
	protected int id;
	protected String nombre;
	protected Localidad localidad;

	protected Persona(String nombre, Localidad localidad)
	{
		this.nombre = nombre;
		this.localidad = localidad;
	}

	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Localidad getLocalidad() {
		return localidad;
	}
	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	@Override
	public Boolean esDeLocalidad(Localidad l)
	{
		return this.localidad.equals(l);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Persona persona = (Persona) o;
		return Objects.equals(id,persona.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
