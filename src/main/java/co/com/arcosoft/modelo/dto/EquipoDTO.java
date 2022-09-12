package co.com.arcosoft.modelo.dto;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.CategoriaEquipo;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class EquipoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(EquipoDTO.class);
	private Long anioFabricacion;
	private String codigo;
	private String color;
	private Long compania;
	private Long equipoId;
	private String estado;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Date fechaUltimoServicios;
	private Date fechaUltimoAbastecimiento;
	private String foto;
	private String funcion;
	private String infoAdicional;
	private String infoAdicional2;
	private String nombre;
	private String placa;
	private String tipoPropiedad;
	private Double taraEstandar;
	private Long categEquipId_CategoriaEquipo;
	private Long centCostId_CentCost;
	private Long contratistaId_Contratista;
	private Long elemCostoId_ElementoCosto;
	private Long flotaTranspId_FlotaTransporte;
	private Long laborId_Labor;
	private Long medidorId_Medidor;
	private Long modeloEquipoId_ModeloEquipo;
	private Long numEjeId_NumeroEje;
	private Long servicioId_Servicio;
	private Long trabId_Trabajador;
	private Long productoId;
	private Double consumoGlHora;
	private Double consumoKmGl;
	private Double horometroActual;
	private Double odometroActual;
	private Long contarEventos;
	private String colorEvento;

	private Long transportadora;
	private String origenDatos;
	private Long tagId;
	private String especieEquipo;

	private Double horasDiaEstandar;
	private Double kmDiaEstandar;
	
	private String altura;
	private String diametro;
	private String tamano;
	private String presion;
	private String caudal;
	private String serial;
	private String revoluciones;
	private String potencia;
	private String voltaje;
	private String corriente;
	
	private String  generico;
	private String  excluirDistribucciones;
	
	
	private Double valorCompra;
	private Long indicador_vuelta_medidor;
	private Double hor_odo_abastecimiento_inicial;

	private CategoriaEquipo categoriaEquipo;
	private String nombreCategoria;
	
	private String  tipoDistribuccionCostos;
	private Double capacidadTanque;
	
	
	

    public Double getCapacidadTanque() {
		return capacidadTanque;
	}

	public void setCapacidadTanque(Double capacidadTanque) {
		this.capacidadTanque = capacidadTanque;
	}

	public String getTipoDistribuccionCostos() {
		return tipoDistribuccionCostos;
	}

	public void setTipoDistribuccionCostos(String tipoDistribuccionCostos) {
		this.tipoDistribuccionCostos = tipoDistribuccionCostos;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	public CategoriaEquipo getCategoriaEquipo() {
		return categoriaEquipo;
	}

	public void setCategoriaEquipo(CategoriaEquipo categoriaEquipo) {
		this.categoriaEquipo = categoriaEquipo;
	}

	public Double getHor_odo_abastecimiento_inicial() {
		return hor_odo_abastecimiento_inicial;
	}

	public void setHor_odo_abastecimiento_inicial(Double hor_odo_abastecimiento_inicial) {
		this.hor_odo_abastecimiento_inicial = hor_odo_abastecimiento_inicial;
	}

	public Long getIndicador_vuelta_medidor() {
		return indicador_vuelta_medidor;
	}

	public void setIndicador_vuelta_medidor(Long indicador_vuelta_medidor) {
		this.indicador_vuelta_medidor = indicador_vuelta_medidor;
	}

	public Double getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(Double valorCompra) {
		this.valorCompra = valorCompra;
	}

	public String getGenerico() {
		return generico;
	}

	public void setGenerico(String generico) {
		this.generico = generico;
	}

	public String getExcluirDistribucciones() {
		return excluirDistribucciones;
	}

	public void setExcluirDistribucciones(String excluirDistribucciones) {
		this.excluirDistribucciones = excluirDistribucciones;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getDiametro() {
		return diametro;
	}

	public void setDiametro(String diametro) {
		this.diametro = diametro;
	}

	public String getTamano() {
		return tamano;
	}

	public void setTamano(String tamano) {
		this.tamano = tamano;
	}

	public String getPresion() {
		return presion;
	}

	public void setPresion(String presion) {
		this.presion = presion;
	}

	public String getCaudal() {
		return caudal;
	}

	public void setCaudal(String caudal) {
		this.caudal = caudal;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getRevoluciones() {
		return revoluciones;
	}

	public void setRevoluciones(String revoluciones) {
		this.revoluciones = revoluciones;
	}

	public String getPotencia() {
		return potencia;
	}

	public void setPotencia(String potencia) {
		this.potencia = potencia;
	}

	public String getVoltaje() {
		return voltaje;
	}

	public void setVoltaje(String voltaje) {
		this.voltaje = voltaje;
	}

	public String getCorriente() {
		return corriente;
	}

	public void setCorriente(String corriente) {
		this.corriente = corriente;
	}

	public Double getHorasDiaEstandar() {
		return horasDiaEstandar;
	}

	public void setHorasDiaEstandar(Double horasDiaEstandar) {
		this.horasDiaEstandar = horasDiaEstandar;
	}

	public Double getKmDiaEstandar() {
		return kmDiaEstandar;
	}

	public void setKmDiaEstandar(Double kmDiaEstandar) {
		this.kmDiaEstandar = kmDiaEstandar;
	}

	public Long getTagId() {
		return tagId;
	}

	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}

	public String getEspecieEquipo() {
		return especieEquipo;
	}

	public void setEspecieEquipo(String especieEquipo) {
		this.especieEquipo = especieEquipo;
	}

	public String getOrigenDatos() {
		return origenDatos;
	}

	public void setOrigenDatos(String origenDatos) {
		this.origenDatos = origenDatos;
	}

	public Long getTransportadora() {
		return transportadora;
	}

	public void setTransportadora(Long transportadora) {
		this.transportadora = transportadora;
	}

	public Long getProductoId() {
		return productoId;
	}

	public void setProductoId(Long productoId) {
		this.productoId = productoId;
	}

	public Long getAnioFabricacion() {
		return anioFabricacion;
	}

	public void setAnioFabricacion(Long anioFabricacion) {
		this.anioFabricacion = anioFabricacion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTipoPropiedad() {
		return tipoPropiedad;
	}

	public void setTipoPropiedad(String tipoPropiedad) {
		this.tipoPropiedad = tipoPropiedad;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Long getCompania() {
		return compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public Long getEquipoId() {
		return equipoId;
	}

	public void setEquipoId(Long equipoId) {
		this.equipoId = equipoId;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getFuncion() {
		return funcion;
	}

	public void setFuncion(String funcion) {
		this.funcion = funcion;
	}

	public String getInfoAdicional() {
		return infoAdicional;
	}

	public void setInfoAdicional(String infoAdicional) {
		this.infoAdicional = infoAdicional;
	}

	public String getInfoAdicional2() {
		return infoAdicional2;
	}

	public void setInfoAdicional2(String infoAdicional2) {
		this.infoAdicional2 = infoAdicional2;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Double getTaraEstandar() {
		return taraEstandar;
	}

	public void setTaraEstandar(Double taraEstandar) {
		this.taraEstandar = taraEstandar;
	}

	public Long getCategEquipId_CategoriaEquipo() {
		return categEquipId_CategoriaEquipo;
	}

	public void setCategEquipId_CategoriaEquipo(Long categEquipId_CategoriaEquipo) {
		this.categEquipId_CategoriaEquipo = categEquipId_CategoriaEquipo;
	}

	public Long getCentCostId_CentCost() {
		return centCostId_CentCost;
	}

	public void setCentCostId_CentCost(Long centCostId_CentCost) {
		this.centCostId_CentCost = centCostId_CentCost;
	}

	public Long getContratistaId_Contratista() {
		return contratistaId_Contratista;
	}

	public void setContratistaId_Contratista(Long contratistaId_Contratista) {
		this.contratistaId_Contratista = contratistaId_Contratista;
	}

	public Long getElemCostoId_ElementoCosto() {
		return elemCostoId_ElementoCosto;
	}

	public void setElemCostoId_ElementoCosto(Long elemCostoId_ElementoCosto) {
		this.elemCostoId_ElementoCosto = elemCostoId_ElementoCosto;
	}

	public Long getFlotaTranspId_FlotaTransporte() {
		return flotaTranspId_FlotaTransporte;
	}

	public void setFlotaTranspId_FlotaTransporte(Long flotaTranspId_FlotaTransporte) {
		this.flotaTranspId_FlotaTransporte = flotaTranspId_FlotaTransporte;
	}

	public Long getLaborId_Labor() {
		return laborId_Labor;
	}

	public void setLaborId_Labor(Long laborId_Labor) {
		this.laborId_Labor = laborId_Labor;
	}

	public Long getMedidorId_Medidor() {
		return medidorId_Medidor;
	}

	public void setMedidorId_Medidor(Long medidorId_Medidor) {
		this.medidorId_Medidor = medidorId_Medidor;
	}

	public Long getModeloEquipoId_ModeloEquipo() {
		return modeloEquipoId_ModeloEquipo;
	}

	public void setModeloEquipoId_ModeloEquipo(Long modeloEquipoId_ModeloEquipo) {
		this.modeloEquipoId_ModeloEquipo = modeloEquipoId_ModeloEquipo;
	}

	public Long getNumEjeId_NumeroEje() {
		return numEjeId_NumeroEje;
	}

	public void setNumEjeId_NumeroEje(Long numEjeId_NumeroEje) {
		this.numEjeId_NumeroEje = numEjeId_NumeroEje;
	}

	public Long getServicioId_Servicio() {
		return servicioId_Servicio;
	}

	public void setServicioId_Servicio(Long servicioId_Servicio) {
		this.servicioId_Servicio = servicioId_Servicio;
	}

	public Long getTrabId_Trabajador() {
		return trabId_Trabajador;
	}

	public void setTrabId_Trabajador(Long trabId_Trabajador) {
		this.trabId_Trabajador = trabId_Trabajador;
	}

	public Double getConsumoGlHora() {
		return consumoGlHora;
	}

	public void setConsumoGlHora(Double consumoGlHora) {
		this.consumoGlHora = consumoGlHora;
	}

	public Double getConsumoKmGl() {
		return consumoKmGl;
	}

	public void setConsumoKmGl(Double consumoKmGl) {
		this.consumoKmGl = consumoKmGl;
	}

	public Double getHorometroActual() {
		return horometroActual;
	}

	public void setHorometroActual(Double horometroActual) {
		this.horometroActual = horometroActual;
	}

	public Double getOdometroActual() {
		return odometroActual;
	}

	public void setOdometroActual(Double odometroActual) {
		this.odometroActual = odometroActual;
	}

	public Long getContarEventos() {
		return contarEventos;
	}

	public void setContarEventos(Long contarEventos) {
		this.contarEventos = contarEventos;
	}

	public String getColorEvento() {
		return colorEvento;
	}

	public void setColorEvento(String colorEvento) {
		this.colorEvento = colorEvento;
	}

	public Date getFechaUltimoServicios() {
		return fechaUltimoServicios;
	}

	public Date getFechaUltimoAbastecimiento() {
		return fechaUltimoAbastecimiento;
	}

	public void setFechaUltimoServicios(Date fechaUltimoServicios) {
		this.fechaUltimoServicios = fechaUltimoServicios;
	}

	public void setFechaUltimoAbastecimiento(Date fechaUltimoAbastecimiento) {
		this.fechaUltimoAbastecimiento = fechaUltimoAbastecimiento;
	}

}
