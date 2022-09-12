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

import co.com.arcosoft.dataaccess.dao.IDatSanVegDAO;
import co.com.arcosoft.dataaccess.dao.INivel2DAO;
import co.com.arcosoft.dataaccess.dao.INivel2PersemprDAO;
import co.com.arcosoft.dataaccess.dao.INivel3DAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatSanVeg;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel2Persempr;
import co.com.arcosoft.modelo.Nivel3;
import co.com.arcosoft.modelo.dto.Nivel2DTO;
import co.com.arcosoft.modelo.dto.Nivel2PersemprDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("Nivel2Logic")
public class Nivel2Logic implements INivel2Logic {
	private static final Logger log = LoggerFactory.getLogger(Nivel2Logic.class);

	/**
	 * DAO injected by Spring that manages Nivel2 entities
	 *
	 */
	@Autowired
	private INivel2DAO nivel2DAO;

	/**
	 * DAO injected by Spring that manages DatSanVeg entities
	 *
	 */
	@Autowired
	private IDatSanVegDAO datSanVegDAO;

	/**
	 * DAO injected by Spring that manages Nivel3 entities
	 *
	 */
	@Autowired
	private INivel3DAO nivel3DAO;

	/**
	 * Logic injected by Spring that manages CentCost entities
	 *
	 */
	@Autowired
	ICentCostLogic logicCentCost1;

	/**
	 * Logic injected by Spring that manages Ciudad entities
	 *
	 */
	@Autowired
	ICiudadLogic logicCiudad2;

	/**
	 * Logic injected by Spring that manages FrenteCos entities
	 *
	 */
	@Autowired
	IFrenteCosLogic logicFrenteCos3;

	/**
	 * Logic injected by Spring that manages GrpTenen entities
	 *
	 */
	@Autowired
	IGrpTenenLogic logicGrpTenen4;

	/**
	 * Logic injected by Spring that manages Nivel1 entities
	 *
	 */
	@Autowired
	INivel1Logic logicNivel15;

	/**
	 * Logic injected by Spring that manages Proveedor entities
	 *
	 */

	/**
	 * Logic injected by Spring that manages Trabajador entities
	 *
	 */
	@Autowired
	ITrabajadorLogic logicTrabajador7;

	/**
	 * Logic injected by Spring that manages ZonaGeografica entities
	 *
	 */
	@Autowired
	IZonaGeograficaLogic logicZonaGeografica8;

	@Autowired
	private INivel2PersemprDAO nivel2PersemprDAO;

	@Autowired
	INivel2PersemprLogic nivel2PersemprLogic;

	@Override
	@Transactional(readOnly = true)
	public List<Nivel2> getNivel2() throws Exception {
		log.debug("finding all Nivel2 instances");

		List<Nivel2> list = new ArrayList<Nivel2>();

		try {
			list = nivel2DAO.findAll();
		} catch (Exception e) {
			log.error("finding all Nivel2 failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "Nivel2");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveNivel2(Nivel2 entity, List<Nivel2PersemprDTO> dataNivel2PersEmpr) throws Exception {
		log.debug("saving Nivel2 instance");

		try {
			/*
			 * if (entity.getCentCost() == null) { throw new ZMessManager().new
			 * ForeignException("centCost"); }
			 * 
			 * if (entity.getCiudad() == null) { throw new ZMessManager().new
			 * ForeignException("ciudad"); }
			 * 
			 * if (entity.getFrenteCos() == null) { throw new ZMessManager().new
			 * ForeignException("frenteCos"); }
			 * 
			 * if (entity.getGrpTenen() == null) { throw new ZMessManager().new
			 * ForeignException("grpTenen"); }
			 */

			if (entity.getNivel1() == null) {
				throw new ZMessManager().new ForeignException("nivel1");
			}

			if (entity.getProveedor() == null) {
				throw new ZMessManager().new ForeignException("proveedor");
			}
			/*
			 * if (entity.getTrabajador() == null) { throw new
			 * ZMessManager().new ForeignException("trabajador"); }
			 * 
			 * if (entity.getZonaGeografica() == null) { throw new
			 * ZMessManager().new ForeignException("zonaGeografica"); }
			 */

			if ((entity.getBarrio() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getBarrio(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("barrio");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getDireccion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getDireccion(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("direccion");
			}

			if ((entity.getDistanciaOficina() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getDistanciaOficina(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("distanciaOficina");
			}

			if ((entity.getPesoPromedio() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getPesoPromedio(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("pesoPromedio");
			}

			if ((entity.getDistanciaPlanta() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getDistanciaPlanta(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("distanciaPlanta");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getInfoAdicional() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional");
			}

			if ((entity.getInfoAdicional2() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional2(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional2");
			}

			/*
			 * if ((entity.getLatitud() != null) && (Utilities.isDecimal("" +
			 * entity.getLatitud()) == false)) { throw new ZMessManager().new
			 * NotValidFormatException( "latitud"); } if ((entity.getLongitud()
			 * != null) && (Utilities.isDecimal("" + entity.getLongitud()) ==
			 * false)) { throw new ZMessManager().new NotValidFormatException(
			 * "longitud"); } if ((entity.getPrecision() != null) &&
			 * (Utilities.isDecimal("" + entity.getPrecision()) == false)) {
			 * throw new ZMessManager().new NotValidFormatException(
			 * "precision"); }
			 */
			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacion(), 150) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacion");
			}

			if ((entity.getPbx() != null) && (Utilities.checkWordAndCheckWithlength(entity.getPbx(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("pbx");
			}

			if ((entity.getTelefono() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getTelefono(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("telefono");
			}

			if ((entity.getTipoPropiedad() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getTipoPropiedad(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("tipoPropiedad");
			}

			/*
			 * if (entity.getCentCost() == null) { throw new ZMessManager().new
			 * EmptyFieldException( "centCostId_CentCost"); }
			 */

			if ((entity.getCentCost() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCentCost(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("centCostId_CentCost");
			}

			/*
			 * if (entity.getCiudad() == null) { throw new ZMessManager().new
			 * EmptyFieldException( "ciudadId_Ciudad"); }
			 */
			if ((entity.getCiudad() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCiudad(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("ciudadId_Ciudad");
			}

			/*
			 * if (entity.getFrenteCos() == null) { throw new ZMessManager().new
			 * EmptyFieldException( "frtCosId_FrenteCos"); }
			 */

			if ((entity.getFrenteCos() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getFrenteCos(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("frtCosId_FrenteCos");
			}

			/*
			 * if (entity.getGrpTenen() == null) { throw new ZMessManager().new
			 * EmptyFieldException( "grpTenId_GrpTenen"); }
			 */
			if ((entity.getGrpTenen() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getGrpTenen(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("grpTenId_GrpTenen");
			}

			if (entity.getNivel1().getNivel1Id() == null) {
				throw new ZMessManager().new EmptyFieldException("nivel1Id_Nivel1");
			}

			if ((entity.getNivel1().getNivel1Id() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivel1().getNivel1Id(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivel1Id_Nivel1");
			}

			if (entity.getProveedor() == null) {
				throw new ZMessManager().new EmptyFieldException("proveId_Proveedor");
			}

			if ((entity.getProveedor() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getProveedor().getPersEmprId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("proveId_Proveedor");
			}

			/*
			 * if (entity.getTrabajador() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "trabId_Trabajador"); }
			 */

			if ((entity.getTrabajador() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTrabajador(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("trabId_Trabajador");
			}

			/*
			 * if (entity.getZonaGeografica() == null) { throw new
			 * ZMessManager().new EmptyFieldException(
			 * "zonaGeograficaId_ZonaGeografica"); }
			 */
			if ((entity.getZonaGeografica() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getZonaGeografica(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("zonaGeograficaId_ZonaGeografica");
			}

			/*
			 * if (entity.getNivel2Id() == null) { throw new ZMessManager().new
			 * EmptyFieldException("nivel2Id"); }
			 * 
			 * if ((entity.getNivel2Id() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getNivel2Id(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException("nivel2Id"); }
			 * 
			 * 
			 * if (getNivel2(entity.getNivel2Id()) != null) { throw new
			 * ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */

			nivel2DAO.save(entity);

			if (dataNivel2PersEmpr != null) {

				for (Nivel2PersemprDTO n2pDTO : dataNivel2PersEmpr) {

					if (n2pDTO.getProveedorParticipacion().getPersEmprId() == null) {

						Nivel2Persempr valor = new Nivel2Persempr();
						valor.setProveedorParticipacion(n2pDTO.getProveedorParticipacion());
						valor.setProcentajeParticipacion(n2pDTO.getProcentajeParticipacion());
						valor.setNivel2(entity);

						nivel2PersemprDAO.save(valor);
					}

				}

			}

			log.debug("save Nivel2 successful");
		} catch (Exception e) {
			log.error("save Nivel2 failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteNivel2(Nivel2 entity) throws Exception {
		log.debug("deleting Nivel2 instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Nivel2");
		}

		if (entity.getNivel2Id() == null) {
			throw new ZMessManager().new EmptyFieldException("nivel2Id");
		}

		List<DatSanVeg> datSanVegs = null;
		List<Nivel3> nivel3s = null;

		try {
			datSanVegs = datSanVegDAO.findByProperty("nivel2.nivel2Id", entity.getNivel2Id());

			if (Utilities.validationsList(datSanVegs) == true) {
				throw new ZMessManager().new DeletingException("datSanVegs");
			}

			nivel3s = nivel3DAO.findByProperty("nivel2.nivel2Id", entity.getNivel2Id());

			if (Utilities.validationsList(nivel3s) == true) {
				throw new ZMessManager().new DeletingException("nivel3s");
			}

			nivel2DAO.delete(entity);

			log.debug("delete Nivel2 successful");
		} catch (Exception e) {
			log.error("delete Nivel2 failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateNivel2(Nivel2 entity, List<Nivel2PersemprDTO> dataNivel2PersEmpr) throws Exception {
		log.debug("updating Nivel2 instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Nivel2");
			}

			/*
			 * if (entity.getCentCost() == null) { throw new ZMessManager().new
			 * ForeignException("centCost"); }
			 * 
			 * if (entity.getCiudad() == null) { throw new ZMessManager().new
			 * ForeignException("ciudad"); }
			 * 
			 * if (entity.getFrenteCos() == null) { throw new ZMessManager().new
			 * ForeignException("frenteCos"); }
			 * 
			 * if (entity.getGrpTenen() == null) { throw new ZMessManager().new
			 * ForeignException("grpTenen"); }
			 */

			if (entity.getNivel1() == null) {
				throw new ZMessManager().new ForeignException("nivel1");
			}

			if (entity.getProveedor() == null) {
				throw new ZMessManager().new ForeignException("proveedor");
			}

			/*
			 * if (entity.getTrabajador() == null) { throw new
			 * ZMessManager().new ForeignException("trabajador"); }
			 * 
			 * if (entity.getZonaGeografica() == null) { throw new
			 * ZMessManager().new ForeignException("zonaGeografica"); }
			 */

			if ((entity.getBarrio() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getBarrio(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("barrio");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getDireccion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getDireccion(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("direccion");
			}

			if ((entity.getDistanciaOficina() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getDistanciaOficina(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("distanciaOficina");
			}

			if ((entity.getDistanciaPlanta() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getDistanciaPlanta(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("distanciaPlanta");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getInfoAdicional() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional");
			}

			if ((entity.getPesoPromedio() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getPesoPromedio(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("pesoPromedio");
			}

			if ((entity.getInfoAdicional2() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional2(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional2");
			}

			/*
			 * 
			 * if ((entity.getLatitud() != null) && (Utilities.("" +
			 * entity.getLatitud()) == false)) { throw new ZMessManager().new
			 * NotValidFormatException( "latitud"); } if ((entity.getLongitud()
			 * != null) && (Utilities.isDecimal("" + entity.getLongitud()) ==
			 * false)) { throw new ZMessManager().new NotValidFormatException(
			 * "longitud"); } if ((entity.getPrecision() != null) &&
			 * (Utilities.isDecimal("" + entity.getPrecision()) == false)) {
			 * throw new ZMessManager().new NotValidFormatException(
			 * "precision"); }
			 */
			if (entity.getNivel2Id() == null) {
				throw new ZMessManager().new EmptyFieldException("nivel2Id");
			}

			if ((entity.getNivel2Id() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivel2Id(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivel2Id");
			}

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacion(), 150) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacion");
			}

			if ((entity.getPbx() != null) && (Utilities.checkWordAndCheckWithlength(entity.getPbx(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("pbx");
			}

			if ((entity.getTelefono() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getTelefono(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("telefono");
			}

			if ((entity.getTipoPropiedad() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getTipoPropiedad(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("tipoPropiedad");
			}

			/*
			 * if (entity.getCentCost() == null) { throw new ZMessManager().new
			 * EmptyFieldException( "centCostId_CentCost"); }
			 */

			if ((entity.getCentCost() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCentCost(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("centCostId_CentCost");
			}

			/*
			 * if (entity.getCiudad() == null) { throw new ZMessManager().new
			 * EmptyFieldException( "ciudadId_Ciudad"); }
			 */

			if ((entity.getCiudad() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCiudad(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("ciudadId_Ciudad");
			}

			/*
			 * if (entity.getFrenteCos() == null) { throw new ZMessManager().new
			 * EmptyFieldException( "frtCosId_FrenteCos"); }
			 */

			if ((entity.getFrenteCos() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getFrenteCos(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("frtCosId_FrenteCos");
			}
			/*
			 * if (entity.getGrpTenen() == null) { throw new ZMessManager().new
			 * EmptyFieldException( "grpTenId_GrpTenen"); }
			 */

			if ((entity.getGrpTenen() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getGrpTenen(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("grpTenId_GrpTenen");
			}

			if (entity.getNivel1().getNivel1Id() == null) {
				throw new ZMessManager().new EmptyFieldException("nivel1Id_Nivel1");
			}

			if ((entity.getNivel1().getNivel1Id() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivel1().getNivel1Id(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivel1Id_Nivel1");
			}

			if (entity.getProveedor() == null) {
				throw new ZMessManager().new EmptyFieldException("proveId_Proveedor");
			}

			if ((entity.getProveedor() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getProveedor().getPersEmprId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("proveId_Proveedor");
			}

			/*
			 * if (entity.getTrabajador() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "trabId_Trabajador"); }
			 */

			if ((entity.getTrabajador() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTrabajador(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("trabId_Trabajador");
			}
			/*
			 * if (entity.getZonaGeografica() == null) { throw new
			 * ZMessManager().new EmptyFieldException(
			 * "zonaGeograficaId_ZonaGeografica"); }
			 */

			if ((entity.getZonaGeografica() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getZonaGeografica(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("zonaGeograficaId_ZonaGeografica");
			}

			nivel2DAO.update(entity);

			if (dataNivel2PersEmpr != null) {

				for (Nivel2PersemprDTO n2pDTO : dataNivel2PersEmpr) {

					if (n2pDTO.getId() == null) {

						Nivel2Persempr valor = new Nivel2Persempr();
						valor.setProveedorParticipacion(n2pDTO.getProveedorParticipacion());
						valor.setProcentajeParticipacion(n2pDTO.getProcentajeParticipacion());
						valor.setNivel2(entity);

						nivel2PersemprDAO.save(valor);

					} else {

						Nivel2Persempr valor = nivel2PersemprDAO
								.findById(n2pDTO.getProveedorParticipacion().getPersEmprId());

						valor.setProveedorParticipacion(n2pDTO.getProveedorParticipacion());
						valor.setProcentajeParticipacion(n2pDTO.getProcentajeParticipacion());
						valor.setNivel2(entity);

					}

				}

			}

			log.debug("update Nivel2 successful");
		} catch (Exception e) {
			log.error("update Nivel2 failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Nivel2DTO> getDataNivel2() throws Exception {
		try {
			List<Nivel2> nivel2 = nivel2DAO.findAll();

			List<Nivel2DTO> nivel2DTO = new ArrayList<Nivel2DTO>();

			for (Nivel2 nivel2Tmp : nivel2) {
				Nivel2DTO nivel2DTO2 = new Nivel2DTO();

				nivel2DTO2.setNivel2Id(nivel2Tmp.getNivel2Id());
				nivel2DTO2.setBarrio((nivel2Tmp.getBarrio() != null) ? nivel2Tmp.getBarrio() : null);
				nivel2DTO2.setVereda((nivel2Tmp.getVereda() != null) ? nivel2Tmp.getVereda() : null);
				nivel2DTO2.setCodigo((nivel2Tmp.getCodigo() != null) ? nivel2Tmp.getCodigo() : null);
				nivel2DTO2.setCompania((nivel2Tmp.getCompania() != null) ? nivel2Tmp.getCompania() : null);
				nivel2DTO2.setDireccion((nivel2Tmp.getDireccion() != null) ? nivel2Tmp.getDireccion() : null);
				nivel2DTO2.setDistanciaOficina(
						(nivel2Tmp.getDistanciaOficina() != null) ? nivel2Tmp.getDistanciaOficina() : null);

				nivel2DTO2.setPesoPromedio((nivel2Tmp.getPesoPromedio() != null) ? nivel2Tmp.getPesoPromedio() : null);

				nivel2DTO2.setDistanciaPlanta(
						(nivel2Tmp.getDistanciaPlanta() != null) ? nivel2Tmp.getDistanciaPlanta() : null);
				nivel2DTO2.setEstado((nivel2Tmp.getEstado() != null) ? nivel2Tmp.getEstado() : null);
				nivel2DTO2.setFechaCreacion(nivel2Tmp.getFechaCreacion());
				nivel2DTO2.setFechaModificacion(nivel2Tmp.getFechaModificacion());
				nivel2DTO2
						.setInfoAdicional((nivel2Tmp.getInfoAdicional() != null) ? nivel2Tmp.getInfoAdicional() : null);
				nivel2DTO2.setInfoAdicional2(
						(nivel2Tmp.getInfoAdicional2() != null) ? nivel2Tmp.getInfoAdicional2() : null);
				nivel2DTO2.setLatitud((nivel2Tmp.getLatitud() != null) ? nivel2Tmp.getLatitud() : null);
				nivel2DTO2.setLongitud((nivel2Tmp.getLongitud() != null) ? nivel2Tmp.getLongitud() : null);
				nivel2DTO2.setNombre((nivel2Tmp.getNombre() != null) ? nivel2Tmp.getNombre() : null);
				nivel2DTO2.setObservacion((nivel2Tmp.getObservacion() != null) ? nivel2Tmp.getObservacion() : null);
				nivel2DTO2.setPbx((nivel2Tmp.getPbx() != null) ? nivel2Tmp.getPbx() : null);
				nivel2DTO2.setPrecision((nivel2Tmp.getPrecision() != null) ? nivel2Tmp.getPrecision() : null);
				nivel2DTO2.setTelefono((nivel2Tmp.getTelefono() != null) ? nivel2Tmp.getTelefono() : null);
				nivel2DTO2
						.setTipoPropiedad((nivel2Tmp.getTipoPropiedad() != null) ? nivel2Tmp.getTipoPropiedad() : null);
				nivel2DTO2.setCentCostId_CentCost((nivel2Tmp.getCentCost() != null) ? nivel2Tmp.getCentCost() : null);
				nivel2DTO2.setCiudadId_Ciudad((nivel2Tmp.getCiudad() != null) ? nivel2Tmp.getCiudad() : null);
				nivel2DTO2.setFrtCosId_FrenteCos((nivel2Tmp.getFrenteCos() != null) ? nivel2Tmp.getFrenteCos() : null);
				nivel2DTO2.setGrpTenId_GrpTenen((nivel2Tmp.getGrpTenen() != null) ? nivel2Tmp.getGrpTenen() : null);
				nivel2DTO2.setTrabId_Trabajador((nivel2Tmp.getTrabajador() != null) ? nivel2Tmp.getTrabajador() : null);
				nivel2DTO2.setZonaGeograficaId_ZonaGeografica(
						(nivel2Tmp.getZonaGeografica() != null) ? nivel2Tmp.getZonaGeografica() : null);

				if (nivel2Tmp.getNivel1() != null) {

					String nombre = nivel2Tmp.getNivel1().getNombre();
					nivel2DTO2.setNombreNivel1(nombre);
				}

				if (nivel2Tmp.getProveedor() != null) {
					nivel2DTO2.setProveId_Proveedor(nivel2Tmp.getProveedor().getPersEmprId());
				} else {
					nivel2DTO2.setProveId_Proveedor(null);
				}

				if (nivel2Tmp.getPluvioId() != null) {
					nivel2DTO2.setPluvioId(nivel2Tmp.getPluvioId().getEstPluvioId());
				} else {
					nivel2DTO2.setPluvioId(null);
				}
				nivel2DTO.add(nivel2DTO2);
			}

			return nivel2DTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Nivel2 getNivel2(Long nivel2Id) throws Exception {
		log.debug("getting Nivel2 instance");

		Nivel2 entity = null;

		try {
			entity = nivel2DAO.findById(nivel2Id);
		} catch (Exception e) {
			log.error("get Nivel2 failed", e);
			throw new ZMessManager().new FindingException("Nivel2");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Nivel2> findPageNivel2(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<Nivel2> entity = null;

		try {
			entity = nivel2DAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Nivel2 Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberNivel2() throws Exception {
		Long entity = null;

		try {
			entity = nivel2DAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Nivel2 Count");
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
	public List<Nivel2> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<Nivel2> list = new ArrayList<Nivel2>();
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
			list = nivel2DAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Nivel2DTO> findByCriteriaPageNivel2(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) throws Exception {
		try {

			List<Nivel2> entity = null;

			String whereCondition = new String();
			Iterator it = filters.entrySet().iterator();

			while (it.hasNext()) {
				Map.Entry e = (Map.Entry) it.next();
				// whereCondition+=((whereCondition.length() ==
				// 0)?" ":" and ")+"upper("+e.getKey()+")"+ " LIKE '%" +
				// e.getValue().toString().toUpperCase()+"%' ";
				if (e.getKey().equals("nombreNivel1")) {

					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(nivel1.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else {
					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(" + e.getKey() + ")"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				}

			}

			entity = nivel2DAO.findByCriteriaPage(whereCondition, sortField, sortOrder, startRow, pageSize);

			List<Nivel2DTO> nivel2DTO = new ArrayList<Nivel2DTO>();

			for (Nivel2 nivel2Tmp : entity) {
				Nivel2DTO nivel2DTO2 = new Nivel2DTO();

				nivel2DTO2.setNivel2Id(nivel2Tmp.getNivel2Id());
				nivel2DTO2.setBarrio((nivel2Tmp.getBarrio() != null) ? nivel2Tmp.getBarrio() : null);
				nivel2DTO2.setCodigo((nivel2Tmp.getCodigo() != null) ? nivel2Tmp.getCodigo() : null);
				nivel2DTO2.setCompania((nivel2Tmp.getCompania() != null) ? nivel2Tmp.getCompania() : null);
				nivel2DTO2.setDireccion((nivel2Tmp.getDireccion() != null) ? nivel2Tmp.getDireccion() : null);
				nivel2DTO2.setDistanciaOficina(
						(nivel2Tmp.getDistanciaOficina() != null) ? nivel2Tmp.getDistanciaOficina() : null);
				nivel2DTO2.setDistanciaPlanta(
						(nivel2Tmp.getDistanciaPlanta() != null) ? nivel2Tmp.getDistanciaPlanta() : null);
				nivel2DTO2.setEstado((nivel2Tmp.getEstado() != null) ? nivel2Tmp.getEstado() : null);
				nivel2DTO2.setFechaCreacion(nivel2Tmp.getFechaCreacion());
				nivel2DTO2.setFechaModificacion(nivel2Tmp.getFechaModificacion());
				nivel2DTO2
						.setInfoAdicional((nivel2Tmp.getInfoAdicional() != null) ? nivel2Tmp.getInfoAdicional() : null);
				nivel2DTO2.setInfoAdicional2(
						(nivel2Tmp.getInfoAdicional2() != null) ? nivel2Tmp.getInfoAdicional2() : null);
				nivel2DTO2.setLatitud((nivel2Tmp.getLatitud() != null) ? nivel2Tmp.getLatitud() : null);
				nivel2DTO2.setLongitud((nivel2Tmp.getLongitud() != null) ? nivel2Tmp.getLongitud() : null);
				nivel2DTO2.setNombre((nivel2Tmp.getNombre() != null) ? nivel2Tmp.getNombre() : null);
				nivel2DTO2.setObservacion((nivel2Tmp.getObservacion() != null) ? nivel2Tmp.getObservacion() : null);
				nivel2DTO2.setPbx((nivel2Tmp.getPbx() != null) ? nivel2Tmp.getPbx() : null);
				nivel2DTO2.setPrecision((nivel2Tmp.getPrecision() != null) ? nivel2Tmp.getPrecision() : null);
				nivel2DTO2.setTelefono((nivel2Tmp.getTelefono() != null) ? nivel2Tmp.getTelefono() : null);
				nivel2DTO2
						.setTipoPropiedad((nivel2Tmp.getTipoPropiedad() != null) ? nivel2Tmp.getTipoPropiedad() : null);
				nivel2DTO2.setCentCostId_CentCost((nivel2Tmp.getCentCost() != null) ? nivel2Tmp.getCentCost() : null);
				nivel2DTO2.setCiudadId_Ciudad((nivel2Tmp.getCiudad() != null) ? nivel2Tmp.getCiudad() : null);
				nivel2DTO2.setFrtCosId_FrenteCos((nivel2Tmp.getFrenteCos() != null) ? nivel2Tmp.getFrenteCos() : null);
				nivel2DTO2.setGrpTenId_GrpTenen((nivel2Tmp.getGrpTenen() != null) ? nivel2Tmp.getGrpTenen() : null);
				nivel2DTO2.setTrabId_Trabajador((nivel2Tmp.getTrabajador() != null) ? nivel2Tmp.getTrabajador() : null);
				nivel2DTO2.setZonaGeograficaId_ZonaGeografica(
						(nivel2Tmp.getZonaGeografica() != null) ? nivel2Tmp.getZonaGeografica() : null);

				if (nivel2Tmp.getNivel1() != null) {

					String nombre = nivel2Tmp.getNivel1().getNombre();
					nivel2DTO2.setNombreNivel1(nombre);
				}

				if (nivel2Tmp.getProveedor() != null) {
					nivel2DTO2.setProveId_Proveedor(nivel2Tmp.getProveedor().getPersEmprId());
				} else {
					nivel2DTO2.setProveId_Proveedor(null);
				}

				if (nivel2Tmp.getPluvioId() != null) {
					nivel2DTO2.setPluvioId(nivel2Tmp.getPluvioId().getEstPluvioId());
				} else {
					nivel2DTO2.setPluvioId(null);
				}
				nivel2DTO.add(nivel2DTO2);
			}

			return nivel2DTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberNivel2(Map<String, Object> filters) throws Exception {
		Long entity = null;

		try {
			String whereCondition = new String();
			Iterator it = filters.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry e = (Map.Entry) it.next();
				// whereCondition+=((whereCondition.length() ==
				// 0)?" ":" and ")+"upper("+e.getKey()+")"+ " LIKE '%" +
				// e.getValue().toString().toUpperCase()+"%' ";
				if (e.getKey().equals("nombreNivel1")) {

					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(nivel1.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else {
					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(" + e.getKey() + ")"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				}
			}
			entity = nivel2DAO.countByCriteria(whereCondition);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Nivel2 Count");
		} finally {
		}
		return entity;
	}

}
