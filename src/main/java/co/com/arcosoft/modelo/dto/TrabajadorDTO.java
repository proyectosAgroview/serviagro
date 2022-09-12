package co.com.arcosoft.modelo.dto;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class TrabajadorDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(TrabajadorDTO.class);
	private String codigo;
	private Long compania;
	private String email;
	private String nIdentificacion;
	private String estadoCivil;
	private String direccion;
	private String estado;
	private Date fechaAdmision;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Date fechaNacimiento;
	private String foto;
	private String genero;
	private String infoAdicional;
	private String infoAdicional2;
	private String nombre;
	private String primerApellido;
	private String primerNombre;
	private String segundoApellido;
	private String segundoNombre;
	private String telefono;
	private Long trabId;
	private Long ciudadId_Ciudad;
	private Long centCostId_CentCost;
	private Long contratistaId_Contratista;
	private Long eqpTrabId_EquipoTrabajo;
	private Long profId_Profesion;
	private String claseContrato;
	private String ubicacion;
	private String origenDatos;
	private String barrio;
	private String tipo_vivienda;
	private String celular;
	private String tipo_licencia_conduccion;
	private String numero_licencia_conduccion;
	private String num_pasado_judicial;
	private String num_tarjeta_profesional;
	private Date fecha_matricula_profesional;
	private String tipo_sangre;
	private String nombre_eps;
	private String nombre_fondo_pension;
	private String nombre_fondo_cesantias;
	private String nombre_arp;
	private String nombre_caja_compensacion;
	private String numero_cuenta_bancaria;
	private Long ent_banc_id;
	private String tipo_cuenta_bancaria;
	private String nombres_conyugue;
	private Long numero_hijos;
	private String contacto_emergencia;
	private String contacto_emergencia_parentesco;
	private String estudio_bachillerato;
	private String estudio_bachillerato_entidad;
	private String estudio_tecnico;
	private String estudio_tecnico_titulo;
	private String estudio_tecnico_entidad;
	private String estudio_tecnologico;
	private String estudio_tecnologico_titulo;
	private String estudio_tecnologico_entidad;
	private String estudio_pregrado;
	private String estudio_pregrado_titulo;
	private String estudio_pregrado_entidad;
	private String estudio_potsgrado;
	private String estudio_potsgrado_titulo;
	private String estudio_potsgrado_entidad;
	private String estudio_otros;
	private String estudio_otros_titulo;
	private String estudio_otros_entidad;
	private String pecargo1_nombre;
	private String pecargo1_parentesco;
	private Date pecargo1_fecha_nacimiento;
	private Long pecargo1_edad;
	private String pecargo1_niveleducativo;
	private String pecargo2_nombre;
	private String pecargo2_parentesco;
	private Date pecargo2_fecha_nacimiento;
	private Long pecargo2_edad;
	private String pecargo2_niveleducativo;
	private String pecargo3_nombre;
	private String pecargo3_parentesco;
	private Date pecargo3_fecha_nacimiento;
	private Long pecargo3_edad;
	private String pecargo3_niveleducativo;
	private String pecargo4_nombre;
	private String pecargo4_parentesco;
	private Date pecargo4_fecha_nacimiento;
	private Long pecargo4_edad;
	private String pecargo4_niveleducativo;
	private String pecargo5_nombre;
	private String pecargo5_parentesco;
	private Date pecargo5_fecha_nacimiento;
	private Long pecargo5_edad;
	private String pecargo5_niveleducativo;
	private Double salario;
	private Long usuario_asociado;
	private String tipo_trabajador;
	
	private Long tipoCotizante;
	private String aportaEps;
	private String empleadorAportaEps;	
	private Long epsActual;
	private Date fechaInicioEps;
	private Long epsAnterior;
	private Long subTipoCotizante;
	private String aportaAfp;
	private Long afpActual;
	private Date fechaInicioAfp;
	private Long afpAnterior;
	private String aportaCcf;
	private String aportaArl;
	private String aportaIcbf;
	private String aportaSena;
	private String altoRiesgo;
	private Double tarifaCajaCompensacion;
	private String claseTarifaArl;
	private Double tarifaArl;
	private Double tarifaIcbf;
	private Double tarifaSena;
	private Long cajaCompensacion;
	private Long arl;
	private Long fondoCesantias;
	private Long tarifasArlId;
	private Date fechaRetiro;
	
	
	

	public Date getFechaRetiro() {
		return fechaRetiro;
	}

	public void setFechaRetiro(Date fechaRetiro) {
		this.fechaRetiro = fechaRetiro;
	}

	public Long getTarifasArlId() {
		return tarifasArlId;
	}

	public void setTarifasArlId(Long tarifasArlId) {
		this.tarifasArlId = tarifasArlId;
	}

	public String getTipo_trabajador() {
		return tipo_trabajador;
	}

	public void setTipo_trabajador(String tipo_trabajador) {
		this.tipo_trabajador = tipo_trabajador;
	}

	public Long getUsuario_asociado() {
		return usuario_asociado;
	}

	public void setUsuario_asociado(Long usuario_asociado) {
		this.usuario_asociado = usuario_asociado;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getTipo_vivienda() {
		return tipo_vivienda;
	}

	public void setTipo_vivienda(String tipo_vivienda) {
		this.tipo_vivienda = tipo_vivienda;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTipo_licencia_conduccion() {
		return tipo_licencia_conduccion;
	}

	public void setTipo_licencia_conduccion(String tipo_licencia_conduccion) {
		this.tipo_licencia_conduccion = tipo_licencia_conduccion;
	}

	public String getNumero_licencia_conduccion() {
		return numero_licencia_conduccion;
	}

	public void setNumero_licencia_conduccion(String numero_licencia_conduccion) {
		this.numero_licencia_conduccion = numero_licencia_conduccion;
	}

	public String getNum_pasado_judicial() {
		return num_pasado_judicial;
	}

	public void setNum_pasado_judicial(String num_pasado_judicial) {
		this.num_pasado_judicial = num_pasado_judicial;
	}

	public String getNum_tarjeta_profesional() {
		return num_tarjeta_profesional;
	}

	public void setNum_tarjeta_profesional(String num_tarjeta_profesional) {
		this.num_tarjeta_profesional = num_tarjeta_profesional;
	}

	public Date getFecha_matricula_profesional() {
		return fecha_matricula_profesional;
	}

	public void setFecha_matricula_profesional(Date fecha_matricula_profesional) {
		this.fecha_matricula_profesional = fecha_matricula_profesional;
	}

	public String getTipo_sangre() {
		return tipo_sangre;
	}

	public void setTipo_sangre(String tipo_sangre) {
		this.tipo_sangre = tipo_sangre;
	}

	public String getNombre_eps() {
		return nombre_eps;
	}

	public void setNombre_eps(String nombre_eps) {
		this.nombre_eps = nombre_eps;
	}

	public String getNombre_fondo_pension() {
		return nombre_fondo_pension;
	}

	public void setNombre_fondo_pension(String nombre_fondo_pension) {
		this.nombre_fondo_pension = nombre_fondo_pension;
	}

	public String getNombre_fondo_cesantias() {
		return nombre_fondo_cesantias;
	}

	public void setNombre_fondo_cesantias(String nombre_fondo_cesantias) {
		this.nombre_fondo_cesantias = nombre_fondo_cesantias;
	}

	public String getNombre_arp() {
		return nombre_arp;
	}

	public void setNombre_arp(String nombre_arp) {
		this.nombre_arp = nombre_arp;
	}

	public String getNombre_caja_compensacion() {
		return nombre_caja_compensacion;
	}

	public void setNombre_caja_compensacion(String nombre_caja_compensacion) {
		this.nombre_caja_compensacion = nombre_caja_compensacion;
	}

	public String getNumero_cuenta_bancaria() {
		return numero_cuenta_bancaria;
	}

	public void setNumero_cuenta_bancaria(String numero_cuenta_bancaria) {
		this.numero_cuenta_bancaria = numero_cuenta_bancaria;
	}

	public Long getEnt_banc_id() {
		return ent_banc_id;
	}

	public void setEnt_banc_id(Long ent_banc_id) {
		this.ent_banc_id = ent_banc_id;
	}

	public String getTipo_cuenta_bancaria() {
		return tipo_cuenta_bancaria;
	}

	public void setTipo_cuenta_bancaria(String tipo_cuenta_bancaria) {
		this.tipo_cuenta_bancaria = tipo_cuenta_bancaria;
	}

	public String getNombres_conyugue() {
		return nombres_conyugue;
	}

	public void setNombres_conyugue(String nombres_conyugue) {
		this.nombres_conyugue = nombres_conyugue;
	}

	public Long getNumero_hijos() {
		return numero_hijos;
	}

	public void setNumero_hijos(Long numero_hijos) {
		this.numero_hijos = numero_hijos;
	}

	public String getContacto_emergencia() {
		return contacto_emergencia;
	}

	public void setContacto_emergencia(String contacto_emergencia) {
		this.contacto_emergencia = contacto_emergencia;
	}

	public String getContacto_emergencia_parentesco() {
		return contacto_emergencia_parentesco;
	}

	public void setContacto_emergencia_parentesco(String contacto_emergencia_parentesco) {
		this.contacto_emergencia_parentesco = contacto_emergencia_parentesco;
	}

	public String getEstudio_bachillerato() {
		return estudio_bachillerato;
	}

	public void setEstudio_bachillerato(String estudio_bachillerato) {
		this.estudio_bachillerato = estudio_bachillerato;
	}

	public String getEstudio_bachillerato_entidad() {
		return estudio_bachillerato_entidad;
	}

	public void setEstudio_bachillerato_entidad(String estudio_bachillerato_entidad) {
		this.estudio_bachillerato_entidad = estudio_bachillerato_entidad;
	}

	public String getEstudio_tecnico() {
		return estudio_tecnico;
	}

	public void setEstudio_tecnico(String estudio_tecnico) {
		this.estudio_tecnico = estudio_tecnico;
	}

	public String getEstudio_tecnico_titulo() {
		return estudio_tecnico_titulo;
	}

	public void setEstudio_tecnico_titulo(String estudio_tecnico_titulo) {
		this.estudio_tecnico_titulo = estudio_tecnico_titulo;
	}

	public String getEstudio_tecnico_entidad() {
		return estudio_tecnico_entidad;
	}

	public void setEstudio_tecnico_entidad(String estudio_tecnico_entidad) {
		this.estudio_tecnico_entidad = estudio_tecnico_entidad;
	}

	public String getEstudio_tecnologico() {
		return estudio_tecnologico;
	}

	public void setEstudio_tecnologico(String estudio_tecnologico) {
		this.estudio_tecnologico = estudio_tecnologico;
	}

	public String getEstudio_tecnologico_titulo() {
		return estudio_tecnologico_titulo;
	}

	public void setEstudio_tecnologico_titulo(String estudio_tecnologico_titulo) {
		this.estudio_tecnologico_titulo = estudio_tecnologico_titulo;
	}

	public String getEstudio_tecnologico_entidad() {
		return estudio_tecnologico_entidad;
	}

	public void setEstudio_tecnologico_entidad(String estudio_tecnologico_entidad) {
		this.estudio_tecnologico_entidad = estudio_tecnologico_entidad;
	}

	public String getEstudio_pregrado() {
		return estudio_pregrado;
	}

	public void setEstudio_pregrado(String estudio_pregrado) {
		this.estudio_pregrado = estudio_pregrado;
	}

	public String getEstudio_pregrado_titulo() {
		return estudio_pregrado_titulo;
	}

	public void setEstudio_pregrado_titulo(String estudio_pregrado_titulo) {
		this.estudio_pregrado_titulo = estudio_pregrado_titulo;
	}

	public String getEstudio_pregrado_entidad() {
		return estudio_pregrado_entidad;
	}

	public void setEstudio_pregrado_entidad(String estudio_pregrado_entidad) {
		this.estudio_pregrado_entidad = estudio_pregrado_entidad;
	}

	public String getEstudio_potsgrado() {
		return estudio_potsgrado;
	}

	public void setEstudio_potsgrado(String estudio_potsgrado) {
		this.estudio_potsgrado = estudio_potsgrado;
	}

	public String getEstudio_potsgrado_titulo() {
		return estudio_potsgrado_titulo;
	}

	public void setEstudio_potsgrado_titulo(String estudio_potsgrado_titulo) {
		this.estudio_potsgrado_titulo = estudio_potsgrado_titulo;
	}

	public String getEstudio_potsgrado_entidad() {
		return estudio_potsgrado_entidad;
	}

	public void setEstudio_potsgrado_entidad(String estudio_potsgrado_entidad) {
		this.estudio_potsgrado_entidad = estudio_potsgrado_entidad;
	}

	public String getEstudio_otros() {
		return estudio_otros;
	}

	public void setEstudio_otros(String estudio_otros) {
		this.estudio_otros = estudio_otros;
	}

	public String getEstudio_otros_titulo() {
		return estudio_otros_titulo;
	}

	public void setEstudio_otros_titulo(String estudio_otros_titulo) {
		this.estudio_otros_titulo = estudio_otros_titulo;
	}

	public String getEstudio_otros_entidad() {
		return estudio_otros_entidad;
	}

	public void setEstudio_otros_entidad(String estudio_otros_entidad) {
		this.estudio_otros_entidad = estudio_otros_entidad;
	}

	public String getPecargo1_nombre() {
		return pecargo1_nombre;
	}

	public void setPecargo1_nombre(String pecargo1_nombre) {
		this.pecargo1_nombre = pecargo1_nombre;
	}

	public String getPecargo1_parentesco() {
		return pecargo1_parentesco;
	}

	public void setPecargo1_parentesco(String pecargo1_parentesco) {
		this.pecargo1_parentesco = pecargo1_parentesco;
	}

	public Date getPecargo1_fecha_nacimiento() {
		return pecargo1_fecha_nacimiento;
	}

	public void setPecargo1_fecha_nacimiento(Date pecargo1_fecha_nacimiento) {
		this.pecargo1_fecha_nacimiento = pecargo1_fecha_nacimiento;
	}

	public Long getPecargo1_edad() {
		return pecargo1_edad;
	}

	public void setPecargo1_edad(Long pecargo1_edad) {
		this.pecargo1_edad = pecargo1_edad;
	}

	public String getPecargo1_niveleducativo() {
		return pecargo1_niveleducativo;
	}

	public void setPecargo1_niveleducativo(String pecargo1_niveleducativo) {
		this.pecargo1_niveleducativo = pecargo1_niveleducativo;
	}

	public String getPecargo2_nombre() {
		return pecargo2_nombre;
	}

	public void setPecargo2_nombre(String pecargo2_nombre) {
		this.pecargo2_nombre = pecargo2_nombre;
	}

	public String getPecargo2_parentesco() {
		return pecargo2_parentesco;
	}

	public void setPecargo2_parentesco(String pecargo2_parentesco) {
		this.pecargo2_parentesco = pecargo2_parentesco;
	}

	public Date getPecargo2_fecha_nacimiento() {
		return pecargo2_fecha_nacimiento;
	}

	public void setPecargo2_fecha_nacimiento(Date pecargo2_fecha_nacimiento) {
		this.pecargo2_fecha_nacimiento = pecargo2_fecha_nacimiento;
	}

	public Long getPecargo2_edad() {
		return pecargo2_edad;
	}

	public void setPecargo2_edad(Long pecargo2_edad) {
		this.pecargo2_edad = pecargo2_edad;
	}

	public String getPecargo2_niveleducativo() {
		return pecargo2_niveleducativo;
	}

	public void setPecargo2_niveleducativo(String pecargo2_niveleducativo) {
		this.pecargo2_niveleducativo = pecargo2_niveleducativo;
	}

	public String getPecargo3_nombre() {
		return pecargo3_nombre;
	}

	public void setPecargo3_nombre(String pecargo3_nombre) {
		this.pecargo3_nombre = pecargo3_nombre;
	}

	public String getPecargo3_parentesco() {
		return pecargo3_parentesco;
	}

	public void setPecargo3_parentesco(String pecargo3_parentesco) {
		this.pecargo3_parentesco = pecargo3_parentesco;
	}

	public Date getPecargo3_fecha_nacimiento() {
		return pecargo3_fecha_nacimiento;
	}

	public void setPecargo3_fecha_nacimiento(Date pecargo3_fecha_nacimiento) {
		this.pecargo3_fecha_nacimiento = pecargo3_fecha_nacimiento;
	}

	public Long getPecargo3_edad() {
		return pecargo3_edad;
	}

	public void setPecargo3_edad(Long pecargo3_edad) {
		this.pecargo3_edad = pecargo3_edad;
	}

	public String getPecargo3_niveleducativo() {
		return pecargo3_niveleducativo;
	}

	public void setPecargo3_niveleducativo(String pecargo3_niveleducativo) {
		this.pecargo3_niveleducativo = pecargo3_niveleducativo;
	}

	public String getPecargo4_nombre() {
		return pecargo4_nombre;
	}

	public void setPecargo4_nombre(String pecargo4_nombre) {
		this.pecargo4_nombre = pecargo4_nombre;
	}

	public String getPecargo4_parentesco() {
		return pecargo4_parentesco;
	}

	public void setPecargo4_parentesco(String pecargo4_parentesco) {
		this.pecargo4_parentesco = pecargo4_parentesco;
	}

	public Date getPecargo4_fecha_nacimiento() {
		return pecargo4_fecha_nacimiento;
	}

	public void setPecargo4_fecha_nacimiento(Date pecargo4_fecha_nacimiento) {
		this.pecargo4_fecha_nacimiento = pecargo4_fecha_nacimiento;
	}

	public Long getPecargo4_edad() {
		return pecargo4_edad;
	}

	public void setPecargo4_edad(Long pecargo4_edad) {
		this.pecargo4_edad = pecargo4_edad;
	}

	public String getPecargo4_niveleducativo() {
		return pecargo4_niveleducativo;
	}

	public void setPecargo4_niveleducativo(String pecargo4_niveleducativo) {
		this.pecargo4_niveleducativo = pecargo4_niveleducativo;
	}

	public String getPecargo5_nombre() {
		return pecargo5_nombre;
	}

	public void setPecargo5_nombre(String pecargo5_nombre) {
		this.pecargo5_nombre = pecargo5_nombre;
	}

	public String getPecargo5_parentesco() {
		return pecargo5_parentesco;
	}

	public void setPecargo5_parentesco(String pecargo5_parentesco) {
		this.pecargo5_parentesco = pecargo5_parentesco;
	}

	public Date getPecargo5_fecha_nacimiento() {
		return pecargo5_fecha_nacimiento;
	}

	public void setPecargo5_fecha_nacimiento(Date pecargo5_fecha_nacimiento) {
		this.pecargo5_fecha_nacimiento = pecargo5_fecha_nacimiento;
	}

	public Long getPecargo5_edad() {
		return pecargo5_edad;
	}

	public void setPecargo5_edad(Long pecargo5_edad) {
		this.pecargo5_edad = pecargo5_edad;
	}

	public String getPecargo5_niveleducativo() {
		return pecargo5_niveleducativo;
	}

	public void setPecargo5_niveleducativo(String pecargo5_niveleducativo) {
		this.pecargo5_niveleducativo = pecargo5_niveleducativo;
	}

	public String getnIdentificacion() {
		return nIdentificacion;
	}

	public void setnIdentificacion(String nIdentificacion) {
		this.nIdentificacion = nIdentificacion;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static Logger getLog() {
		return log;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Long getCompania() {
		return compania;
	}

	public void setCompania(Long compania) {
		this.compania = compania;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstadoCivil() {
		return this.estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getNIdentificacion() {
		return this.nIdentificacion;
	}

	public String getOrigenDatos() {
		return origenDatos;
	}

	public void setOrigenDatos(String origenDatos) {
		this.origenDatos = origenDatos;
	}

	public void setNIdentificacion(String nIdentificacion) {
		this.nIdentificacion = nIdentificacion;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaAdmision() {
		return fechaAdmision;
	}

	public void setFechaAdmision(Date fechaAdmision) {
		this.fechaAdmision = fechaAdmision;
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

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
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

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Long getTrabId() {
		return trabId;
	}

	public void setTrabId(Long trabId) {
		this.trabId = trabId;
	}

	public Long getCentCostId_CentCost() {
		return centCostId_CentCost;
	}

	public void setCentCostId_CentCost(Long centCostId_CentCost) {
		this.centCostId_CentCost = centCostId_CentCost;
	}

	public Long getCiudadId_Ciudad() {
		return ciudadId_Ciudad;
	}

	public void setCiudadId_Ciudad(Long ciudadId_Ciudad) {
		this.ciudadId_Ciudad = ciudadId_Ciudad;
	}

	public Long getContratistaId_Contratista() {
		return contratistaId_Contratista;
	}

	public void setContratistaId_Contratista(Long contratistaId_Contratista) {
		this.contratistaId_Contratista = contratistaId_Contratista;
	}

	public Long getEqpTrabId_EquipoTrabajo() {
		return eqpTrabId_EquipoTrabajo;
	}

	public void setEqpTrabId_EquipoTrabajo(Long eqpTrabId_EquipoTrabajo) {
		this.eqpTrabId_EquipoTrabajo = eqpTrabId_EquipoTrabajo;
	}

	public Long getProfId_Profesion() {
		return profId_Profesion;
	}

	public void setProfId_Profesion(Long profId_Profesion) {
		this.profId_Profesion = profId_Profesion;
	}

	public String getClaseContrato() {
		return claseContrato;
	}

	public void setClaseContrato(String claseContrato) {
		this.claseContrato = claseContrato;
	}

	public Long getTipoCotizante() {
		return tipoCotizante;
	}

	public void setTipoCotizante(Long tipoCotizante) {
		this.tipoCotizante = tipoCotizante;
	}

	public String getAportaEps() {
		return aportaEps;
	}

	public void setAportaEps(String aportaEps) {
		this.aportaEps = aportaEps;
	}

	public String getEmpleadorAportaEps() {
		return empleadorAportaEps;
	}

	public void setEmpleadorAportaEps(String empleadorAportaEps) {
		this.empleadorAportaEps = empleadorAportaEps;
	}

	public Long getEpsActual() {
		return epsActual;
	}

	public void setEpsActual(Long epsActual) {
		this.epsActual = epsActual;
	}

	public Date getFechaInicioEps() {
		return fechaInicioEps;
	}

	public void setFechaInicioEps(Date fechaInicioEps) {
		this.fechaInicioEps = fechaInicioEps;
	}

	public Long getEpsAnterior() {
		return epsAnterior;
	}

	public void setEpsAnterior(Long epsAnterior) {
		this.epsAnterior = epsAnterior;
	}

	public Long getSubTipoCotizante() {
		return subTipoCotizante;
	}

	public void setSubTipoCotizante(Long subTipoCotizante) {
		this.subTipoCotizante = subTipoCotizante;
	}

	public String getAportaAfp() {
		return aportaAfp;
	}

	public void setAportaAfp(String aportaAfp) {
		this.aportaAfp = aportaAfp;
	}

	public Long getAfpActual() {
		return afpActual;
	}

	public void setAfpActual(Long afpActual) {
		this.afpActual = afpActual;
	}

	public Date getFechaInicioAfp() {
		return fechaInicioAfp;
	}

	public void setFechaInicioAfp(Date fechaInicioAfp) {
		this.fechaInicioAfp = fechaInicioAfp;
	}

	public Long getAfpAnterior() {
		return afpAnterior;
	}

	public void setAfpAnterior(Long afpAnterior) {
		this.afpAnterior = afpAnterior;
	}

	public String getAportaCcf() {
		return aportaCcf;
	}

	public void setAportaCcf(String aportaCcf) {
		this.aportaCcf = aportaCcf;
	}

	public String getAportaArl() {
		return aportaArl;
	}

	public void setAportaArl(String aportaArl) {
		this.aportaArl = aportaArl;
	}

	public String getAportaIcbf() {
		return aportaIcbf;
	}

	public void setAportaIcbf(String aportaIcbf) {
		this.aportaIcbf = aportaIcbf;
	}

	public String getAportaSena() {
		return aportaSena;
	}

	public void setAportaSena(String aportaSena) {
		this.aportaSena = aportaSena;
	}

	public String getAltoRiesgo() {
		return altoRiesgo;
	}

	public void setAltoRiesgo(String altoRiesgo) {
		this.altoRiesgo = altoRiesgo;
	}

	public Double getTarifaCajaCompensacion() {
		return tarifaCajaCompensacion;
	}

	public void setTarifaCajaCompensacion(Double tarifaCajaCompensacion) {
		this.tarifaCajaCompensacion = tarifaCajaCompensacion;
	}

	public String getClaseTarifaArl() {
		return claseTarifaArl;
	}

	public void setClaseTarifaArl(String claseTarifaArl) {
		this.claseTarifaArl = claseTarifaArl;
	}

	public Double getTarifaArl() {
		return tarifaArl;
	}

	public void setTarifaArl(Double tarifaArl) {
		this.tarifaArl = tarifaArl;
	}

	public Double getTarifaIcbf() {
		return tarifaIcbf;
	}

	public void setTarifaIcbf(Double tarifaIcbf) {
		this.tarifaIcbf = tarifaIcbf;
	}

	public Double getTarifaSena() {
		return tarifaSena;
	}

	public void setTarifaSena(Double tarifaSena) {
		this.tarifaSena = tarifaSena;
	}

	public Long getCajaCompensacion() {
		return cajaCompensacion;
	}

	public void setCajaCompensacion(Long cajaCompensacion) {
		this.cajaCompensacion = cajaCompensacion;
	}

	public Long getArl() {
		return arl;
	}

	public void setArl(Long arl) {
		this.arl = arl;
	}

	public Long getFondoCesantias() {
		return fondoCesantias;
	}

	public void setFondoCesantias(Long fondoCesantias) {
		this.fondoCesantias = fondoCesantias;
	}
}