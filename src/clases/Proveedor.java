package clases;
import java.util.List;

public class Proveedor extends Persona {
	
	private static int increment;
	private List<Bien> bienes;
		
	public Proveedor(String nombre, Localidad localidad, List<Bien> bienes) {
		super(nombre,localidad);
		this.bienes = bienes;
		this.id = increment;
		increment++;
	}

	public List<Bien> getBienes() {
		return bienes;
	}
	public void setBienes(List<Bien> bienes) {
		this.bienes = bienes;
	}
	
	
	

}
