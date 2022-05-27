package clases;

public class Responsable extends Persona {
	
	private static int increment;
	private String oficina;
	
	
	public Responsable(String nombre, Localidad localidad, String oficina) {
		super(nombre,localidad);
		this.oficina = oficina;
		this.id = increment;
		increment++;
	}

	public String getOficina() {
		return oficina;
	}
	public void setOficina(String oficina) {
		this.oficina = oficina;
	}
	
	

}
