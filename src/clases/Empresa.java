package clases;
import clases.excepciones.MaximoBienesException;
import clases.excepciones.PaisDistintoException;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Empresa {

	private List<Factura> facturas = new ArrayList<>();
	private List<Bien> bienes;
	private List<Proveedor> proveedores;
	private List<Responsable> responsables;
	//private List<Pais> paises;
	//private List<Provincia> provincias;
	//private List<Localidad> localidades;

	public Empresa(List<Bien> bienes, List<Proveedor> proveedores, List<Responsable> responsables) {
		this.bienes = bienes;
		this.proveedores = proveedores;
		this.responsables = responsables;
		//this.paises = paises;
		//this.provincias = provincias;
		//this.localidades = localidades;
	}

	public Factura crearFactura(List<Bien> bienes, Responsable responsable, Proveedor proveedor, LocalDate fecha){
		try
		{
			Factura factura = new Factura(bienes,responsable,proveedor,fecha);
			facturas.add(factura);
			return factura;
		}
		catch (MaximoBienesException e){
			System.out.println("Se ha superado el limite de bienes (Maximo: 20, Recibidos: " + bienes.size() + ")");
			return null;
		}
		catch(PaisDistintoException e) {
			System.out.println("El proveedor: " + proveedor.getNombre() + " y el responsable: " + responsable.getNombre() + " tienen paises distintos");
			return null;
		}
	}

	public ArrayList<Factura> listarFacturaByProveedor(Proveedor p)
	{
		return facturas.stream().filter((f) -> f.getProveedor().equals(p)).collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ArrayList<Factura> listarFacturaByResponsable(Responsable r)
	{
		return facturas.stream().filter((f) -> f.getResponsable().equals(r)).collect(Collectors.toCollection(ArrayList::new));
	}
	
	public ArrayList<String> listarNombresProveedores(Localidad l) //Se agrego el argumento que no estaba en el enunciado
	{
		return proveedores.stream().filter(p -> p.esDeLocalidad(l)).map(Persona::getNombre).sorted(Comparator.naturalOrder()).collect(Collectors.toCollection(ArrayList::new));
	}

	public ArrayList<Bien> listarBienesByLocalidad(Localidad l)
	{
		List<Factura> facturasLocalidad = facturas.stream().filter((f) -> f.getResponsable().esDeLocalidad(l)).collect(Collectors.toList());
		HashSet<Bien> bienesAux = new HashSet<>();
		for(Factura factura : facturasLocalidad)  bienesAux.addAll(factura.getBienes());
		return new ArrayList<>(bienesAux);
	}

	public ArrayList<Bien> listarBienesByPrecioMayor(Double precioMayor)
	{
		return bienes.stream().filter(b -> b.getPrecio() > precioMayor).collect(Collectors.toCollection(ArrayList::new));
	}

	public ArrayList<Factura> listarFacturasByMontoMayor(Double montoMayor)
	{
		return facturas.stream().filter(f -> f.getMonto() > montoMayor).collect(Collectors.toCollection(ArrayList::new));
	}

	public ArrayList<String> listarFactuadasPorProveedor(Proveedor p)
	{
		StringBuilder texto = new StringBuilder();
		ArrayList<String> lista = new ArrayList<>();
		List<Factura> facturasProveedor = listarFacturaByProveedor(p);
		facturasProveedor.sort(Collections.reverseOrder());
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		nf.setMinimumFractionDigits(2);
		nf.setGroupingUsed(false);

		for(Factura f : facturasProveedor)
		{
			String fecha = f.getFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

			texto.append("En la fecha: ").append(fecha).append(", ").append(p.getNombre()).append(" facturó con un total de $").append(nf.format(f.getMonto()))
					.append(" con ").append(f.getBienes().size()).append(" bien(es)");
			lista.add(texto.toString());
			texto.delete(0,texto.length());
		}
		return lista;
	}

}
