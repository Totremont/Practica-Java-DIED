package clases;
import clases.excepciones.MaximoBienesException;
import clases.excepciones.PaisDistintoException;


import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Factura implements Comparable<Factura> {
	
	private int id;
	private static int increment = 0;
	private static final int bienesMaximos = 20;
	private Double monto = 0d;
	private List<Bien> bienes;
	private Responsable responsable;
	private Proveedor proveedor;
	private LocalDate fecha;
	
	
	
	
	public Factura(List<Bien> bienes, Responsable responsable, Proveedor proveedor, LocalDate fecha) throws MaximoBienesException, PaisDistintoException {
		super();
		setBienes(bienes);
		setResponsable(responsable);
		setProveedor(proveedor);
		this.fecha = fecha;
		calcularMonto();
		this.id = increment;
		increment++;
	}

	private boolean bienesValidos(List<Bien> bienes)
	{
		return (bienes.size() <= bienesMaximos);
	}

	private void calcularMonto()
	{
		float descuento = 1;							//Factor sobre el total
		if(bienes.size() > 10) descuento = 0.8f;		// 20 %
		else if(bienes.size() > 5) descuento = 0.9f;	// 10 %

		for(Bien bien : bienes )
		{
			monto += bien.getPrecio()*descuento;
		}
		if(responsable.esDeLocalidad(proveedor.getLocalidad())) monto = monto*1.1;
		else if(responsable.getLocalidad().getProvincia().equals(proveedor.getLocalidad().getProvincia())) monto = monto*1.3;
		else monto = monto*1.7;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Factura factura = (Factura) o;
		return Objects.equals(id,factura.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public int compareTo(Factura o) {
		return this.getFecha().compareTo(o.getFecha());
	}

	public void setBienes(List<Bien> bienes) throws MaximoBienesException {
		if(bienesValidos(bienes)) this.bienes = bienes;
		else throw new MaximoBienesException();
	}

	public void setResponsable(Responsable responsable) throws PaisDistintoException {
		if(this.proveedor != null)
			if(!this.proveedor.getLocalidad().getProvincia().getPais().equals(responsable.getLocalidad().getProvincia().getPais()))
				throw new PaisDistintoException();
		this.responsable = responsable;
	}


	public void setProveedor(Proveedor proveedor) throws PaisDistintoException {
		if(this.responsable != null)
			if(!this.responsable.getLocalidad().getProvincia().getPais().equals(proveedor.getLocalidad().getProvincia().getPais()))
				throw new PaisDistintoException();
		this.proveedor = proveedor;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public List<Bien> getBienes() {
		return bienes;
	}


	public Responsable getResponsable() {
		return this.responsable;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public int getId() {
		return id;
	}
}
