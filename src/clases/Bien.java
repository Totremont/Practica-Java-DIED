package clases;

import java.util.Objects;

public class Bien {
	
	private int id;
	private static int increment = 0;
	private String alias;
	private String descripcion;
	private Double precio;

	
	public Bien(String alias, String descripcion, Double precio) {
		super();
		this.id = increment;
		increment++;
		this.alias = alias;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public int getId() {
		return id;
	}
	
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getPrecio() {
		return precio;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Bien bien = (Bien) o;
		return Objects.equals(id,bien.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
