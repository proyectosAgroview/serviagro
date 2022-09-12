package co.com.arcosoft.modelo;

// Generated 08-sep-2015 22:35:03 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

/**
 * Cliente generated by hbm2java
 */
public class Cliente implements java.io.Serializable {

	private Long clienteId;
	private PersEmpr persEmpr;
	private TipoCliente tipoCliente;
	public Long compania;
	private String infoAdicional;
	private String infoAdicional2;
	private String fechaCreacion;
	private String fechaModificacion;
	private String estado;
	private Set<DatTransProd> datTransProds = new HashSet<DatTransProd>(0);
	private Set<DatTransProdDet> datTransProdDets = new HashSet<DatTransProdDet>(0);

	public Cliente() {
	}

	public Cliente(Long clienteId) {
		this.clienteId = clienteId;
	}

	public Cliente(Long clienteId, PersEmpr persEmpr, TipoCliente tipoCliente, Long compania, String infoAdicional,
			String infoAdicional2, String fechaCreacion, String fechaModificacion, String estado,
			Set<DatTransProd> datTransProds, Set<DatTransProdDet> datTransProdDets) {
		this.clienteId = clienteId;
		this.persEmpr = persEmpr;
		this.tipoCliente = tipoCliente;
		this.compania = compania;
		this.infoAdicional = infoAdicional;
		this.infoAdicional2 = infoAdicional2;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.estado = estado;
		this.datTransProds = datTransProds;
		this.datTransProdDets = datTransProdDets;
	}

	public Long getClienteId() {
		return this.clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public PersEmpr getPersEmpr() {
		return this.persEmpr;
	}

	public void setPersEmpr(PersEmpr persEmpr) {
		this.persEmpr = persEmpr;
	}

	public TipoCliente getTipoCliente() {
		return this.tipoCliente;
	}

	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public Long getCompania() {
		return this.compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public String getInfoAdicional() {
		return this.infoAdicional;
	}

	public void setInfoAdicional(String infoAdicional) {
		this.infoAdicional = infoAdicional;
	}

	public String getInfoAdicional2() {
		return this.infoAdicional2;
	}

	public void setInfoAdicional2(String infoAdicional2) {
		this.infoAdicional2 = infoAdicional2;
	}

	public String getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(String fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Set<DatTransProd> getDatTransProds() {
		return this.datTransProds;
	}

	public void setDatTransProds(Set<DatTransProd> datTransProds) {
		this.datTransProds = datTransProds;
	}

	public Set<DatTransProdDet> getDatTransProdDets() {
		return this.datTransProdDets;
	}

	public void setDatTransProdDets(Set<DatTransProdDet> datTransProdDets) {
		this.datTransProdDets = datTransProdDets;
	}

}