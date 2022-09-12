package co.com.arcosoft.modelo.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.com.arcosoft.dataaccess.dao.INivel2DAO;
import co.com.arcosoft.dataaccess.dao.INivel4DAO;
import co.com.arcosoft.dataaccess.dao.IPersEmprDAO;
import co.com.arcosoft.dataaccess.dao.ITarifaContratistaDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.TarifaContratista;
import co.com.arcosoft.modelo.dto.PersEmprDTO;
import co.com.arcosoft.modelo.dto.TarifaContratistaDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("PersEmprLogic")
public class PersEmprLogic implements IPersEmprLogic {
	private static final Logger log = LoggerFactory.getLogger(PersEmprLogic.class);

	/**
	 * DAO injected by Spring that manages PersEmpr entities
	 *
	 */
	@Autowired
	private IPersEmprDAO persEmprDAO;

	@Autowired
	private INivel4DAO nivel4DAO;

	@Autowired
	private INivel2DAO nivel2DAO;

	/**
	 * Logic injected by Spring that manages Ciudad entities
	 *
	 */
	@Autowired
	ICiudadLogic logicCiudad1;

	/**
	 * Logic injected by Spring that manages EntBanc entities
	 *
	 */
	@Autowired
	IEntBancLogic logicEntBanc2;

	/**
	 * Logic injected by Spring that manages Profesion entities
	 *
	 */
	@Autowired
	IProfesionLogic logicProfesion3;

	@Autowired
	INivel4Logic logicNivel4;

	@Autowired
	INivel2Logic logicNivel2;

	@Autowired
	private ITarifaContratistaDAO dataTarifaContratistaDAO;

	@Override
	@Transactional(readOnly = true)
	public List<PersEmpr> getPersEmpr() throws Exception {
		log.debug("finding all PersEmpr instances");

		List<PersEmpr> list = new ArrayList<PersEmpr>();

		try {
			list = persEmprDAO.findAll();
		} catch (Exception e) {
			log.error("finding all PersEmpr failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "PersEmpr");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void savePersEmpr(PersEmpr entity, List<TarifaContratistaDTO> dataTarifaContratista) throws Exception {
		log.debug("saving PersEmpr instance");

		try {
			/*
			 * if (entity.getCiudad() == null) { throw new ZMessManager().new
			 * ForeignException("ciudad"); }
			 * 
			 * if (entity.getEntBanc() == null) { throw new ZMessManager().new
			 * ForeignException("entBanc"); }
			 * 
			 * if (entity.getProfesion() == null) { throw new ZMessManager().new
			 * ForeignException("profesion"); }
			 */

			if ((entity.getApartadoPostal() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getApartadoPostal(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("apartadoPostal");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getCodigoPostal() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigoPostal(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigoPostal");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getDireccion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getDireccion(), 40) == false)) {
				throw new ZMessManager().new NotValidFormatException("direccion");
			}

			if ((entity.getEmail() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEmail(), 40) == false)) {
				throw new ZMessManager().new NotValidFormatException("email");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getEstadoCivil() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstadoCivil(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("estadoCivil");
			}

			if ((entity.getIdentificacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getIdentificacion(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("identificacion");
			}

			if ((entity.getInfoAdicional() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional");
			}

			if ((entity.getInfoAdicional2() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional2(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional2");
			}

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 300) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			if ((entity.getNumeroCuenta() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNumeroCuenta(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("numeroCuenta");
			}

			if ((entity.getPbx() != null) && (Utilities.checkWordAndCheckWithlength(entity.getPbx(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("pbx");
			}

			/*
			 * if (entity.getPersEmprId() == null) { throw new
			 * ZMessManager().new EmptyFieldException("persEmprId"); }
			 * 
			 * if ((entity.getPersEmprId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getPersEmprId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "persEmprId"); }
			 */

			if ((entity.getRepresentanteLegal() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getRepresentanteLegal(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("representanteLegal");
			}

			if ((entity.getSitioWeb() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getSitioWeb(), 150) == false)) {
				throw new ZMessManager().new NotValidFormatException("sitioWeb");
			}

			if ((entity.getTelefono() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getTelefono(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("telefono");
			}

			if ((entity.getTelefono2() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getTelefono2(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("telefono2");
			}

			if ((entity.getTipoEmpresa() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getTipoEmpresa(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("tipoEmpresa");
			}

			if ((entity.getTipoIdentificacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getTipoIdentificacion(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("tipoIdentificacion");
			}

			if ((entity.getTipoPersona() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getTipoPersona(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("tipoPersona");
			}

			/*
			 * if (entity.getCiudad().getCiudadId() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "ciudadId_Ciudad"); }
			 * 
			 * if ((entity.getCiudad().getCiudadId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getCiudad().getCiudadId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "ciudadId_Ciudad"); }
			 * 
			 * if (entity.getEntBanc().getEntBancId() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "entBancId_EntBanc"); }
			 * 
			 * if ((entity.getEntBanc().getEntBancId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getEntBanc().getEntBancId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "entBancId_EntBanc");
			 * }
			 * 
			 * if (entity.getProfesion().getProfId() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "profId_Profesion"); }
			 * 
			 * if ((entity.getProfesion().getProfId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getProfesion().getProfId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "profId_Profesion");
			 * }
			 */

			/*
			 * if (getPersEmpr(entity.getPersEmprId()) != null) { throw new
			 * ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */

			persEmprDAO.save(entity);

			if (dataTarifaContratista != null) {

				for (TarifaContratistaDTO valorDto : dataTarifaContratista) {

					if (valorDto.getTarifaCtrId() == null) {

						TarifaContratista valor = new TarifaContratista();

						valor.setCompania(valorDto.getCompania());
						valor.setLabor(valorDto.getLaborId_Labor());
						valor.setFechaFinal(valorDto.getFechaFinal());
						valor.setFechaInicial(valorDto.getFechaInicial());
						valor.setServicio(valorDto.getServicioId_Servicio());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());
						valor.setTarifa(valorDto.getTarifa());
						valor.setFechaCreacion(valorDto.getFechaCreacion());
						valor.setFechaModificacion(valorDto.getFechaModificacion());
						valor.setProfesion(valorDto.getProfesion());
						
						valor.setEdadInicial(valorDto.getEdadInicial());
						valor.setEdadFinal(valorDto.getEdadFinal());
						valor.setPesoPromedio(valorDto.getPesoPromedio());
						valor.setEstadoIncidencia(valorDto.getEstadoIncidencia());
						valor.setNivel2(valorDto.getNivel2Id_Nivel2());
						valor.setNivel4(valorDto.getNivel4Id_Nivel4());
						valor.setAlturaPlanta(valorDto.getAlturaPlanta());
										
						valor.setPersEmpr(entity);

						dataTarifaContratistaDAO.save(valor);
					}

				}
			}

			log.debug("save PersEmpr successful");
		} catch (Exception e) {
			log.error("save PersEmpr failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deletePersEmpr(PersEmpr entity) throws Exception {
		log.debug("deleting PersEmpr instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("PersEmpr");
		}

		if (entity.getPersEmprId() == null) {
			throw new ZMessManager().new EmptyFieldException("persEmprId");
		}

		List<Nivel4> nivel4 = null;
		List<Nivel2> nivel2 = null;
		List<TarifaContratista> dataTarifaContratistas = null;

		try {
			nivel4 = nivel4DAO.findByProperty("persEmpr.persEmprId", entity.getPersEmprId());

			if (Utilities.validationsList(nivel4) == true) {
				throw new ZMessManager().new DeletingException("nivel4");
			}

			nivel2 = nivel2DAO.findByProperty("persEmpr.persEmprId", entity.getPersEmprId());

			if (Utilities.validationsList(nivel2) == true) {
				throw new ZMessManager().new DeletingException("nivel2");
			}

			dataTarifaContratistas = dataTarifaContratistaDAO.findByProperty("persEmpr.persEmprId",
					entity.getPersEmprId());

			if (Utilities.validationsList(dataTarifaContratistas) == true) {
				throw new ZMessManager().new DeletingException("dataTarifaContratistas");
			}

			persEmprDAO.delete(entity);

			log.debug("delete PersEmpr successful");
		} catch (Exception e) {
			log.error("delete PersEmpr failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updatePersEmpr(PersEmpr entity, List<TarifaContratistaDTO> dataTarifaContratista) throws Exception {
		log.debug("updating PersEmpr instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("PersEmpr");
			}

			/*
			 * if (entity.getCiudad() == null) { throw new ZMessManager().new
			 * ForeignException("ciudad"); }
			 * 
			 * if (entity.getEntBanc() == null) { throw new ZMessManager().new
			 * ForeignException("entBanc"); }
			 * 
			 * if (entity.getProfesion() == null) { throw new ZMessManager().new
			 * ForeignException("profesion"); }
			 */

			if ((entity.getApartadoPostal() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getApartadoPostal(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("apartadoPostal");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getCodigoPostal() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigoPostal(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigoPostal");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getDireccion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getDireccion(), 40) == false)) {
				throw new ZMessManager().new NotValidFormatException("direccion");
			}

			if ((entity.getEmail() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEmail(), 40) == false)) {
				throw new ZMessManager().new NotValidFormatException("email");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getEstadoCivil() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstadoCivil(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("estadoCivil");
			}

			if ((entity.getIdentificacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getIdentificacion(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("identificacion");
			}

			if ((entity.getInfoAdicional() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional");
			}

			if ((entity.getInfoAdicional2() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional2(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional2");
			}

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 300) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			if ((entity.getNumeroCuenta() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNumeroCuenta(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("numeroCuenta");
			}

			if ((entity.getPbx() != null) && (Utilities.checkWordAndCheckWithlength(entity.getPbx(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("pbx");
			}

			/*
			 * if (entity.getPersEmprId() == null) { throw new
			 * ZMessManager().new EmptyFieldException("persEmprId"); }
			 * 
			 * if ((entity.getPersEmprId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getPersEmprId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "persEmprId"); }
			 */

			if ((entity.getRepresentanteLegal() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getRepresentanteLegal(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("representanteLegal");
			}

			if ((entity.getSitioWeb() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getSitioWeb(), 150) == false)) {
				throw new ZMessManager().new NotValidFormatException("sitioWeb");
			}

			if ((entity.getTelefono() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getTelefono(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("telefono");
			}

			if ((entity.getTelefono2() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getTelefono2(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("telefono2");
			}

			if ((entity.getTipoEmpresa() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getTipoEmpresa(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("tipoEmpresa");
			}

			if ((entity.getTipoIdentificacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getTipoIdentificacion(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("tipoIdentificacion");
			}

			if ((entity.getTipoPersona() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getTipoPersona(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("tipoPersona");
			}

			/*
			 * if (entity.getCiudad() == null) { throw new ZMessManager().new
			 * EmptyFieldException( "ciudadId_Ciudad"); }
			 */

			/*
			 * if ((entity.getCiudad().getCiudadId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getCiudad().getCiudadId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "ciudadId_Ciudad"); }
			 */

			/*
			 * if (entity.getEntBanc() == null) { throw new ZMessManager().new
			 * EmptyFieldException( "entBancId_EntBanc"); }
			 */

			/*
			 * if ((entity.getEntBanc().getEntBancId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getEntBanc().getEntBancId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "entBancId_EntBanc");
			 * }
			 */

			/*
			 * if ((entity.getProfesion().getProfId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getProfesion().getProfId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "profId_Profesion");
			 * }
			 */

			persEmprDAO.update(entity);
			if (dataTarifaContratista != null) {

				for (TarifaContratistaDTO valorDto : dataTarifaContratista) {

					if (valorDto.getTarifaCtrId() == null) {

						TarifaContratista valor = new TarifaContratista();

						valor.setCompania(valorDto.getCompania());
						valor.setLabor(valorDto.getLaborId_Labor());
						valor.setFechaFinal(valorDto.getFechaFinal());
						valor.setFechaInicial(valorDto.getFechaInicial());
						valor.setServicio(valorDto.getServicioId_Servicio());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());
						valor.setTarifa(valorDto.getTarifa());
						valor.setFechaCreacion(valorDto.getFechaCreacion());
						valor.setFechaModificacion(valorDto.getFechaModificacion());
						valor.setProfesion(valorDto.getProfesion());

						valor.setEdadInicial(valorDto.getEdadInicial());
						valor.setEdadFinal(valorDto.getEdadFinal());
						valor.setPesoPromedio(valorDto.getPesoPromedio());
						valor.setEstadoIncidencia(valorDto.getEstadoIncidencia());
						valor.setNivel2(valorDto.getNivel2Id_Nivel2());
						valor.setNivel4(valorDto.getNivel4Id_Nivel4());
						valor.setAlturaPlanta(valorDto.getAlturaPlanta());
						
						valor.setPersEmpr(entity);

						dataTarifaContratistaDAO.save(valor);
					} else {
						TarifaContratista valor = dataTarifaContratistaDAO.findById(valorDto.getTarifaCtrId());

						valor.setCompania(valorDto.getCompania());
						valor.setLabor(valorDto.getLaborId_Labor());
						valor.setFechaFinal(valorDto.getFechaFinal());
						valor.setFechaInicial(valorDto.getFechaInicial());
						valor.setServicio(valorDto.getServicioId_Servicio());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());
						valor.setTarifa(valorDto.getTarifa());
						valor.setFechaCreacion(valorDto.getFechaCreacion());
						valor.setFechaModificacion(valorDto.getFechaModificacion());
						valor.setProfesion(valorDto.getProfesion());

						valor.setEdadInicial(valorDto.getEdadInicial());
						valor.setEdadFinal(valorDto.getEdadFinal());
						valor.setPesoPromedio(valorDto.getPesoPromedio());
						valor.setEstadoIncidencia(valorDto.getEstadoIncidencia());
						valor.setNivel2(valorDto.getNivel2Id_Nivel2());
						valor.setNivel4(valorDto.getNivel4Id_Nivel4());
						valor.setAlturaPlanta(valorDto.getAlturaPlanta());
						
						valor.setPersEmpr(entity);

					}

				}
			}

			log.debug("update PersEmpr successful");
		} catch (Exception e) {
			log.error("update PersEmpr failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<PersEmprDTO> getDataPersEmpr() throws Exception {
		try {

			List<PersEmpr> persEmpr = persEmprDAO.findAll();

			List<PersEmprDTO> persEmprDTO = new ArrayList<PersEmprDTO>();

			for (PersEmpr persEmprTmp : persEmpr) {
				PersEmprDTO persEmprDTO2 = new PersEmprDTO();

				persEmprDTO2.setPersEmprId(persEmprTmp.getPersEmprId());
				persEmprDTO2.setApartadoPostal(
						(persEmprTmp.getApartadoPostal() != null) ? persEmprTmp.getApartadoPostal() : null);
				persEmprDTO2.setCertificacion(
								(persEmprTmp.getCertificacion() != null) ? persEmprTmp.getCertificacion() : null);
				persEmprDTO2.setCodigo((persEmprTmp.getCodigo() != null) ? persEmprTmp.getCodigo() : null);
				persEmprDTO2.setCodigoPostal(
						(persEmprTmp.getCodigoPostal() != null) ? persEmprTmp.getCodigoPostal() : null);
				persEmprDTO2.setCompania((persEmprTmp.getCompania() != null) ? persEmprTmp.getCompania() : null);
				persEmprDTO2.setDireccion((persEmprTmp.getDireccion() != null) ? persEmprTmp.getDireccion() : null);
				persEmprDTO2.setEmail((persEmprTmp.getEmail() != null) ? persEmprTmp.getEmail() : null);
				persEmprDTO2.setEstado((persEmprTmp.getEstado() != null) ? persEmprTmp.getEstado() : null);
				persEmprDTO2
						.setEstadoCivil((persEmprTmp.getEstadoCivil() != null) ? persEmprTmp.getEstadoCivil() : null);
				persEmprDTO2.setFechaCreacion(persEmprTmp.getFechaCreacion());
				persEmprDTO2.setFechaModificacion(persEmprTmp.getFechaModificacion());
				persEmprDTO2.setIdentificacion(
						(persEmprTmp.getIdentificacion() != null) ? persEmprTmp.getIdentificacion() : null);
				persEmprDTO2.setInfoAdicional(
						(persEmprTmp.getInfoAdicional() != null) ? persEmprTmp.getInfoAdicional() : null);
				persEmprDTO2.setInfoAdicional2(
						(persEmprTmp.getInfoAdicional2() != null) ? persEmprTmp.getInfoAdicional2() : null);
				persEmprDTO2.setNombre((persEmprTmp.getNombre() != null) ? persEmprTmp.getNombre() : null);
				persEmprDTO2.setNumeroCuenta(
						(persEmprTmp.getNumeroCuenta() != null) ? persEmprTmp.getNumeroCuenta() : null);
				persEmprDTO2.setPbx((persEmprTmp.getPbx() != null) ? persEmprTmp.getPbx() : null);
				persEmprDTO2.setRepresentanteLegal(
						(persEmprTmp.getRepresentanteLegal() != null) ? persEmprTmp.getRepresentanteLegal() : null);
				persEmprDTO2.setSitioWeb((persEmprTmp.getSitioWeb() != null) ? persEmprTmp.getSitioWeb() : null);
				persEmprDTO2.setTelefono((persEmprTmp.getTelefono() != null) ? persEmprTmp.getTelefono() : null);
				
				persEmprDTO2.setTablaPrecios((persEmprTmp.getTablaPrecios() != null) ? persEmprTmp.getTablaPrecios() : null);
				
				persEmprDTO2.setTelefono2((persEmprTmp.getTelefono2() != null) ? persEmprTmp.getTelefono2() : null);
				persEmprDTO2
						.setTipoEmpresa((persEmprTmp.getTipoEmpresa() != null) ? persEmprTmp.getTipoEmpresa() : null);
				persEmprDTO2.setTipoIdentificacion(
						(persEmprTmp.getTipoIdentificacion() != null) ? persEmprTmp.getTipoIdentificacion() : null);
				persEmprDTO2
						.setTipoPersona((persEmprTmp.getTipoPersona() != null) ? persEmprTmp.getTipoPersona() : null);
				
				persEmprDTO2.setEsArlEpsPension((persEmprTmp.getEsArlEpsPension() != null) ? persEmprTmp.getEsArlEpsPension() : null);

				if (persEmprTmp.getCiudad() != null) {
					persEmprDTO2.setCiudadId_Ciudad(persEmprTmp.getCiudad());
				} else {
					persEmprDTO2.setCiudadId_Ciudad(null);
				}

				persEmprDTO2.setEntBancId_EntBanc((persEmprTmp.getEntBanc() != null) ? persEmprTmp.getEntBanc() : null);

				if (persEmprTmp.getProfesion() != null) {
					persEmprDTO2.setProfId_Profesion(persEmprTmp.getProfesion());
				} else {
					persEmprDTO2.setProfId_Profesion(null);
				}

				persEmprDTO.add(persEmprDTO2);
			}

			return persEmprDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public PersEmpr getPersEmpr(Long persEmprId) throws Exception {
		log.debug("getting PersEmpr instance");

		PersEmpr entity = null;

		try {
			entity = persEmprDAO.findById(persEmprId);
		} catch (Exception e) {
			log.error("get PersEmpr failed", e);
			throw new ZMessManager().new FindingException("PersEmpr");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<PersEmpr> findPagePersEmpr(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<PersEmpr> entity = null;

		try {
			entity = persEmprDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("PersEmpr Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberPersEmpr() throws Exception {
		Long entity = null;

		try {
			entity = persEmprDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("PersEmpr Count");
		} finally {
		}

		return entity;
	}

	/**
	 *
	 * @param varibles
	 *            este arreglo debera tener:
	 *
	 *            [0] = String variable = (String) varibles[i]; representa como
	 *            se llama la variable en el pojo
	 *
	 *            [1] = Boolean booVariable = (Boolean) varibles[i + 1];
	 *            representa si el valor necesita o no ''(comillas simples)usado
	 *            para campos de tipo string
	 *
	 *            [2] = Object value = varibles[i + 2]; representa el valor que
	 *            se va a buscar en la BD
	 *
	 *            [3] = String comparator = (String) varibles[i + 3]; representa
	 *            que tipo de busqueda voy a hacer.., ejemplo: where
	 *            nombre=william o where nombre<>william, en este campo iria el
	 *            tipo de comparador que quiero si es = o <>
	 *
	 *            Se itera de 4 en 4..., entonces 4 registros del arreglo
	 *            representan 1 busqueda en un campo, si se ponen mas pues el
	 *            continuara buscando en lo que se le ingresen en los otros 4
	 *
	 *
	 * @param variablesBetween
	 *
	 *            la diferencia son estas dos posiciones
	 *
	 *            [0] = String variable = (String) varibles[j]; la variable ne
	 *            la BD que va a ser buscada en un rango
	 *
	 *            [1] = Object value = varibles[j + 1]; valor 1 para buscar en
	 *            un rango
	 *
	 *            [2] = Object value2 = varibles[j + 2]; valor 2 para buscar en
	 *            un rango ejempolo: a > 1 and a < 5 --> 1 seria value y 5 seria
	 *            value2
	 *
	 *            [3] = String comparator1 = (String) varibles[j + 3];
	 *            comparador 1 ejemplo: a comparator1 1 and a < 5
	 *
	 *            [4] = String comparator2 = (String) varibles[j + 4];
	 *            comparador 2 ejemplo: a comparador1>1 and a comparador2<5 (el
	 *            original: a > 1 and a < 5) *
	 * @param variablesBetweenDates
	 *            (en este caso solo para mysql) [0] = String variable =
	 *            (String) varibles[k]; el nombre de la variable que hace
	 *            referencia a una fecha
	 *
	 *            [1] = Object object1 = varibles[k + 2]; fecha 1 a
	 *            comparar(deben ser dates)
	 *
	 *            [2] = Object object2 = varibles[k + 3]; fecha 2 a
	 *            comparar(deben ser dates)
	 *
	 *            esto hace un between entre las dos fechas.
	 *
	 * @return lista con los objetos que se necesiten
	 * @throws Exception
	 */
	@Override
	@Transactional(readOnly = true)
	public List<PersEmpr> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<PersEmpr> list = new ArrayList<PersEmpr>();
		String where = new String();
		String tempWhere = new String();

		if (variables != null) {
			for (int i = 0; i < variables.length; i++) {
				if ((variables[i] != null) && (variables[i + 1] != null) && (variables[i + 2] != null)
						&& (variables[i + 3] != null)) {
					String variable = (String) variables[i];
					Boolean booVariable = (Boolean) variables[i + 1];
					Object value = variables[i + 2];
					String comparator = (String) variables[i + 3];

					if (booVariable.booleanValue()) {
						tempWhere = (tempWhere.length() == 0)
								? ("(model." + variable + " " + comparator + " \'" + value + "\' )")
								: (tempWhere + " AND (model." + variable + " " + comparator + " \'" + value + "\' )");
					} else {
						tempWhere = (tempWhere.length() == 0)
								? ("(model." + variable + " " + comparator + " " + value + " )")
								: (tempWhere + " AND (model." + variable + " " + comparator + " " + value + " )");
					}
				}

				i = i + 3;
			}
		}

		if (variablesBetween != null) {
			for (int j = 0; j < variablesBetween.length; j++) {
				if ((variablesBetween[j] != null) && (variablesBetween[j + 1] != null)
						&& (variablesBetween[j + 2] != null) && (variablesBetween[j + 3] != null)
						&& (variablesBetween[j + 4] != null)) {
					String variable = (String) variablesBetween[j];
					Object value = variablesBetween[j + 1];
					Object value2 = variablesBetween[j + 2];
					String comparator1 = (String) variablesBetween[j + 3];
					String comparator2 = (String) variablesBetween[j + 4];
					tempWhere = (tempWhere.length() == 0)
							? ("(" + value + " " + comparator1 + " " + variable + " and " + variable + " " + comparator2
									+ " " + value2 + " )")
							: (tempWhere + " AND (" + value + " " + comparator1 + " " + variable + " and " + variable
									+ " " + comparator2 + " " + value2 + " )");
				}

				j = j + 4;
			}
		}

		if (variablesBetweenDates != null) {
			for (int k = 0; k < variablesBetweenDates.length; k++) {
				if ((variablesBetweenDates[k] != null) && (variablesBetweenDates[k + 1] != null)
						&& (variablesBetweenDates[k + 2] != null)) {
					String variable = (String) variablesBetweenDates[k];
					Object object1 = variablesBetweenDates[k + 1];
					Object object2 = variablesBetweenDates[k + 2];
					String value = null;
					String value2 = null;

					try {
						Date date1 = (Date) object1;
						Date date2 = (Date) object2;
						value = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date1);
						value2 = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date2);
					} catch (Exception e) {
						list = null;
						throw e;
					}

					tempWhere = (tempWhere.length() == 0)
							? ("(model." + variable + " between \'" + value + "\' and \'" + value2 + "\')")
							: (tempWhere + " AND (model." + variable + " between \'" + value + "\' and \'" + value2
									+ "\')");
				}

				k = k + 2;
			}
		}

		if (tempWhere.length() == 0) {
			where = null;
		} else {
			where = "(" + tempWhere + ")";
		}

		try {
			list = persEmprDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<PersEmprDTO> findByCriteriaPageEmpresa(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) throws Exception {
		try {

			List<PersEmpr> entity = null;

			String whereCondition = new String();
			Iterator it = filters.entrySet().iterator();

			while (it.hasNext()) {
				Map.Entry e = (Map.Entry) it.next();
				whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(" + e.getKey() + ")"
						+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";
			}

			entity = persEmprDAO.findByCriteriaPage(whereCondition, sortField, sortOrder, startRow, pageSize);

			List<PersEmprDTO> persEmprDTO = new ArrayList<PersEmprDTO>();

			for (PersEmpr persEmprTmp : entity) {
				PersEmprDTO persEmprDTO2 = new PersEmprDTO();

				persEmprDTO2.setPersEmprId(persEmprTmp.getPersEmprId());
				persEmprDTO2.setApartadoPostal(
						(persEmprTmp.getApartadoPostal() != null) ? persEmprTmp.getApartadoPostal() : null);
				persEmprDTO2.setCertificacion(
								(persEmprTmp.getCertificacion() != null) ? persEmprTmp.getCertificacion() : null);
				persEmprDTO2.setCodigo((persEmprTmp.getCodigo() != null) ? persEmprTmp.getCodigo() : null);
				persEmprDTO2.setCodigoPostal(
						(persEmprTmp.getCodigoPostal() != null) ? persEmprTmp.getCodigoPostal() : null);
				persEmprDTO2.setCompania((persEmprTmp.getCompania() != null) ? persEmprTmp.getCompania() : null);
				persEmprDTO2.setDireccion((persEmprTmp.getDireccion() != null) ? persEmprTmp.getDireccion() : null);
				persEmprDTO2.setEmail((persEmprTmp.getEmail() != null) ? persEmprTmp.getEmail() : null);
				persEmprDTO2.setEstado((persEmprTmp.getEstado() != null) ? persEmprTmp.getEstado() : null);
				persEmprDTO2
						.setEstadoCivil((persEmprTmp.getEstadoCivil() != null) ? persEmprTmp.getEstadoCivil() : null);
				
				persEmprDTO2.setTablaPrecios((persEmprTmp.getTablaPrecios() != null) ? persEmprTmp.getTablaPrecios() : null);
				persEmprDTO2.setFechaCreacion(persEmprTmp.getFechaCreacion());
				persEmprDTO2.setFechaModificacion(persEmprTmp.getFechaModificacion());
				persEmprDTO2.setIdentificacion(
						(persEmprTmp.getIdentificacion() != null) ? persEmprTmp.getIdentificacion() : null);
				persEmprDTO2.setInfoAdicional(
						(persEmprTmp.getInfoAdicional() != null) ? persEmprTmp.getInfoAdicional() : null);
				persEmprDTO2.setInfoAdicional2(
						(persEmprTmp.getInfoAdicional2() != null) ? persEmprTmp.getInfoAdicional2() : null);
				persEmprDTO2.setNombre((persEmprTmp.getNombre() != null) ? persEmprTmp.getNombre() : null);
				persEmprDTO2.setNumeroCuenta(
						(persEmprTmp.getNumeroCuenta() != null) ? persEmprTmp.getNumeroCuenta() : null);
				persEmprDTO2.setPbx((persEmprTmp.getPbx() != null) ? persEmprTmp.getPbx() : null);
				persEmprDTO2.setRepresentanteLegal(
						(persEmprTmp.getRepresentanteLegal() != null) ? persEmprTmp.getRepresentanteLegal() : null);
				persEmprDTO2.setSitioWeb((persEmprTmp.getSitioWeb() != null) ? persEmprTmp.getSitioWeb() : null);
				persEmprDTO2.setTelefono((persEmprTmp.getTelefono() != null) ? persEmprTmp.getTelefono() : null);
				persEmprDTO2.setTelefono2((persEmprTmp.getTelefono2() != null) ? persEmprTmp.getTelefono2() : null);
				persEmprDTO2
						.setTipoEmpresa((persEmprTmp.getTipoEmpresa() != null) ? persEmprTmp.getTipoEmpresa() : null);
				persEmprDTO2.setTipoIdentificacion(
						(persEmprTmp.getTipoIdentificacion() != null) ? persEmprTmp.getTipoIdentificacion() : null);
				persEmprDTO2
						.setTipoPersona((persEmprTmp.getTipoPersona() != null) ? persEmprTmp.getTipoPersona() : null);
				
				persEmprDTO2.setEsArlEpsPension((persEmprTmp.getEsArlEpsPension() != null) ? persEmprTmp.getEsArlEpsPension() : null);

				if (persEmprTmp.getCiudad() != null) {
					persEmprDTO2.setCiudadId_Ciudad(persEmprTmp.getCiudad());
				} else {
					persEmprDTO2.setCiudadId_Ciudad(null);
				}

				persEmprDTO2.setEntBancId_EntBanc((persEmprTmp.getEntBanc() != null) ? persEmprTmp.getEntBanc() : null);

				if (persEmprTmp.getProfesion() != null) {
					persEmprDTO2.setProfId_Profesion(persEmprTmp.getProfesion());
				} else {
					persEmprDTO2.setProfId_Profesion(null);
				}

				persEmprDTO.add(persEmprDTO2);
			}

			return persEmprDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberEmpresa(Map<String, Object> filters) throws Exception {
		Long entity = null;

		try {
			String whereCondition = new String();
			Iterator it = filters.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry e = (Map.Entry) it.next();
				whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(" + e.getKey() + ")"
						+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";
			}
			entity = persEmprDAO.countByCriteria(whereCondition);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("PersEmpr Count");
		} finally {
		}
		return entity;
	}
}
