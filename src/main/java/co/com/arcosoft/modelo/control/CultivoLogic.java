package co.com.arcosoft.modelo.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.com.arcosoft.dataaccess.dao.IAnaCultivoDAO;
import co.com.arcosoft.dataaccess.dao.ICultivoDAO;
import co.com.arcosoft.dataaccess.dao.ICultivoFitosanidadDAO;
import co.com.arcosoft.dataaccess.dao.IEtapaDAO;
import co.com.arcosoft.dataaccess.dao.IFaseFenologicaDAO;
import co.com.arcosoft.dataaccess.dao.ITipCultivoDAO;
import co.com.arcosoft.dataaccess.dao.IVariedadDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.AnaCultivo;
import co.com.arcosoft.modelo.Cultivo;
import co.com.arcosoft.modelo.CultivoFitosanidad;
import co.com.arcosoft.modelo.Etapa;
import co.com.arcosoft.modelo.FaseFenologica;
import co.com.arcosoft.modelo.TipCultivo;
import co.com.arcosoft.modelo.Variedad;
import co.com.arcosoft.modelo.dto.CultivoDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("CultivoLogic")
public class CultivoLogic implements ICultivoLogic {
	private static final Logger log = LoggerFactory.getLogger(CultivoLogic.class);

	/**
	 * DAO injected by Spring that manages Cultivo entities
	 *
	 */
	@Autowired
	private ICultivoDAO cultivoDAO;

	/**
	 * DAO injected by Spring that manages AnaCultivo entities
	 *
	 */
	@Autowired
	private IAnaCultivoDAO anaCultivoDAO;

	/**
	 * DAO injected by Spring that manages CultivoFitosanidad entities
	 *
	 */
	@Autowired
	private ICultivoFitosanidadDAO cultivoFitosanidadDAO;

	/**
	 * DAO injected by Spring that manages Etapa entities
	 *
	 */
	@Autowired
	private IEtapaDAO etapaDAO;

	/**
	 * DAO injected by Spring that manages FaseFenologica entities
	 *
	 */
	@Autowired
	private IFaseFenologicaDAO faseFenologicaDAO;

	/**
	 * DAO injected by Spring that manages TipCultivo entities
	 *
	 */
	@Autowired
	private ITipCultivoDAO tipCultivoDAO;

	/**
	 * DAO injected by Spring that manages Variedad entities
	 *
	 */
	@Autowired
	private IVariedadDAO variedadDAO;

	/**
	 * Logic injected by Spring that manages UdadMed entities
	 *
	 */
	@Autowired
	IUdadMedLogic logicUdadMed1;

	/**
	 * Logic injected by Spring that manages UdadMed entities
	 *
	 */
	@Autowired
	IUdadMedLogic logicUdadMed2;

	@Override
	@Transactional(readOnly = true)
	public List<Cultivo> getCultivo() throws Exception {
		log.debug("finding all Cultivo instances");

		List<Cultivo> list = new ArrayList<Cultivo>();

		try {
			list = cultivoDAO.findAll();
		} catch (Exception e) {
			log.error("finding all Cultivo failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "Cultivo");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveCultivo(Cultivo entity) throws Exception {
		log.debug("saving Cultivo instance");

		try {
			if (entity.getUdadMedByUdadMedId() == null) {
				throw new ZMessManager().new ForeignException("udadMedByUdadMedId");
			}

			if (entity.getUdadMedByUdadMedId1() == null) {
				throw new ZMessManager().new ForeignException("udadMedByUdadMedId1");
			}

			if ((entity.getAnalisisLaboratorio() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getAnalisisLaboratorio(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("analisisLaboratorio");
			}

			if ((entity.getAplicaPolinizado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getAplicaPolinizado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("aplicaPolinizado");
			}

			if ((entity.getCalcularArea() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCalcularArea(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("calcularArea");
			}

			if ((entity.getCalcularEdad() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCalcularEdad(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("calcularEdad");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getControlPlanta() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getControlPlanta(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("controlPlanta");
			}

			if ((entity.getControlProduccion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getControlProduccion(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("controlProduccion");
			}

			if ((entity.getControlSemillero() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getControlSemillero(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("controlSemillero");
			}

			/*
			 * if (entity.getCultivoId() == null) { throw new ZMessManager().new
			 * EmptyFieldException("cultivoId"); }
			 * 
			 * if ((entity.getCultivoId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getCultivoId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "cultivoId"); }
			 */

			if ((entity.getEsAcuicultura() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEsAcuicultura(), 10) == false)) {
				throw new ZMessManager().new NotValidFormatException("esAcuicultura");
			}

			if ((entity.getEsMineria() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEsMineria(), 10) == false)) {
				throw new ZMessManager().new NotValidFormatException("esMineria");
			}

			if ((entity.getEsPecuaria() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEsPecuaria(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("esPecuaria");
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

			if ((entity.getLogoCultivo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getLogoCultivo(), 150) == false)) {
				throw new ZMessManager().new NotValidFormatException("logoCultivo");
			}

			if ((entity.getModeloPlanificacionCosecha() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getModeloPlanificacionCosecha(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("modeloPlanificacionCosecha");
			}

			if ((entity.getMostrarEdad() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getMostrarEdad(), 10) == false)) {
				throw new ZMessManager().new NotValidFormatException("mostrarEdad");
			}

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			if (entity.getUdadMedByUdadMedId().getUdadMedId() == null) {
				throw new ZMessManager().new EmptyFieldException("udadMedId_UdadMed");
			}

			if ((entity.getUdadMedByUdadMedId().getUdadMedId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getUdadMedByUdadMedId().getUdadMedId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("udadMedId_UdadMed");
			}

			if (entity.getUdadMedByUdadMedId1().getUdadMedId() == null) {
				throw new ZMessManager().new EmptyFieldException("udadMedId_UdadMed");
			}

			if ((entity.getUdadMedByUdadMedId1().getUdadMedId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getUdadMedByUdadMedId1().getUdadMedId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("udadMedId_UdadMed");
			}

			/*
			 * if (getCultivo(entity.getCultivoId()) != null) { throw new
			 * ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */

			cultivoDAO.save(entity);

			log.debug("save Cultivo successful");
		} catch (Exception e) {
			log.error("save Cultivo failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteCultivo(Cultivo entity) throws Exception {
		log.debug("deleting Cultivo instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Cultivo");
		}

		if (entity.getCultivoId() == null) {
			throw new ZMessManager().new EmptyFieldException("cultivoId");
		}

		List<AnaCultivo> anaCultivos = null;
		List<CultivoFitosanidad> cultivoFitosanidads = null;
		List<Etapa> etapas = null;
		List<FaseFenologica> faseFenologicas = null;
		List<TipCultivo> tipCultivos = null;
		List<Variedad> variedads = null;

		try {
			anaCultivos = anaCultivoDAO.findByProperty("cultivo.cultivoId", entity.getCultivoId());

			if (Utilities.validationsList(anaCultivos) == true) {
				throw new ZMessManager().new DeletingException("anaCultivos");
			}

			cultivoFitosanidads = cultivoFitosanidadDAO.findByProperty("cultivo.cultivoId", entity.getCultivoId());

			if (Utilities.validationsList(cultivoFitosanidads) == true) {
				throw new ZMessManager().new DeletingException("cultivoFitosanidads");
			}

			etapas = etapaDAO.findByProperty("cultivo.cultivoId", entity.getCultivoId());

			if (Utilities.validationsList(etapas) == true) {
				throw new ZMessManager().new DeletingException("etapas");
			}

			faseFenologicas = faseFenologicaDAO.findByProperty("cultivo.cultivoId", entity.getCultivoId());

			if (Utilities.validationsList(faseFenologicas) == true) {
				throw new ZMessManager().new DeletingException("faseFenologicas");
			}

			tipCultivos = tipCultivoDAO.findByProperty("cultivo.cultivoId", entity.getCultivoId());

			if (Utilities.validationsList(tipCultivos) == true) {
				throw new ZMessManager().new DeletingException("tipCultivos");
			}

			variedads = variedadDAO.findByProperty("cultivo.cultivoId", entity.getCultivoId());

			if (Utilities.validationsList(variedads) == true) {
				throw new ZMessManager().new DeletingException("variedads");
			}

			cultivoDAO.delete(entity);

			log.debug("delete Cultivo successful");
		} catch (Exception e) {
			log.error("delete Cultivo failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateCultivo(Cultivo entity) throws Exception {
		log.debug("updating Cultivo instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Cultivo");
			}

			if (entity.getUdadMedByUdadMedId() == null) {
				throw new ZMessManager().new ForeignException("udadMedByUdadMedId");
			}

			if (entity.getUdadMedByUdadMedId1() == null) {
				throw new ZMessManager().new ForeignException("udadMedByUdadMedId1");
			}

			if ((entity.getAnalisisLaboratorio() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getAnalisisLaboratorio(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("analisisLaboratorio");
			}

			if ((entity.getAplicaPolinizado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getAplicaPolinizado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("aplicaPolinizado");
			}

			if ((entity.getCalcularArea() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCalcularArea(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("calcularArea");
			}

			if ((entity.getCalcularEdad() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCalcularEdad(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("calcularEdad");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getControlPlanta() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getControlPlanta(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("controlPlanta");
			}

			if ((entity.getControlProduccion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getControlProduccion(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("controlProduccion");
			}

			if ((entity.getControlSemillero() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getControlSemillero(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("controlSemillero");
			}

			if (entity.getCultivoId() == null) {
				throw new ZMessManager().new EmptyFieldException("cultivoId");
			}

			if ((entity.getCultivoId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCultivoId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("cultivoId");
			}

			if ((entity.getEsAcuicultura() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEsAcuicultura(), 10) == false)) {
				throw new ZMessManager().new NotValidFormatException("esAcuicultura");
			}

			if ((entity.getEsMineria() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEsMineria(), 10) == false)) {
				throw new ZMessManager().new NotValidFormatException("esMineria");
			}

			if ((entity.getEsPecuaria() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEsPecuaria(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("esPecuaria");
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

			if ((entity.getLogoCultivo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getLogoCultivo(), 150) == false)) {
				throw new ZMessManager().new NotValidFormatException("logoCultivo");
			}

			if ((entity.getModeloPlanificacionCosecha() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getModeloPlanificacionCosecha(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("modeloPlanificacionCosecha");
			}

			if ((entity.getMostrarEdad() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getMostrarEdad(), 10) == false)) {
				throw new ZMessManager().new NotValidFormatException("mostrarEdad");
			}

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			if (entity.getUdadMedByUdadMedId().getUdadMedId() == null) {
				throw new ZMessManager().new EmptyFieldException("udadMedId_UdadMed");
			}

			if ((entity.getUdadMedByUdadMedId().getUdadMedId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getUdadMedByUdadMedId().getUdadMedId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("udadMedId_UdadMed");
			}

			if (entity.getUdadMedByUdadMedId1().getUdadMedId() == null) {
				throw new ZMessManager().new EmptyFieldException("udadMedId_UdadMed");
			}

			if ((entity.getUdadMedByUdadMedId1().getUdadMedId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getUdadMedByUdadMedId1().getUdadMedId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("udadMedId_UdadMed");
			}

			cultivoDAO.update(entity);

			log.debug("update Cultivo successful");
		} catch (Exception e) {
			log.error("update Cultivo failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<CultivoDTO> getDataCultivo() throws Exception {
		try {
			List<Cultivo> cultivo = cultivoDAO.findAll();

			List<CultivoDTO> cultivoDTO = new ArrayList<CultivoDTO>();

			for (Cultivo cultivoTmp : cultivo) {
				CultivoDTO cultivoDTO2 = new CultivoDTO();

				cultivoDTO2.setCultivoId(cultivoTmp.getCultivoId());
				cultivoDTO2.setAnalisisLaboratorio(
						(cultivoTmp.getAnalisisLaboratorio() != null) ? cultivoTmp.getAnalisisLaboratorio() : null);
				cultivoDTO2.setAplicaPolinizado(
						(cultivoTmp.getAplicaPolinizado() != null) ? cultivoTmp.getAplicaPolinizado() : null);
				cultivoDTO2
						.setCalcularArea((cultivoTmp.getCalcularArea() != null) ? cultivoTmp.getCalcularArea() : null);
				cultivoDTO2
						.setCalcularEdad((cultivoTmp.getCalcularEdad() != null) ? cultivoTmp.getCalcularEdad() : null);
				cultivoDTO2.setCodigo((cultivoTmp.getCodigo() != null) ? cultivoTmp.getCodigo() : null);
				cultivoDTO2.setCompania((cultivoTmp.getCompania() != null) ? cultivoTmp.getCompania() : null);
				cultivoDTO2.setControlPlanta(
						(cultivoTmp.getControlPlanta() != null) ? cultivoTmp.getControlPlanta() : null);
				cultivoDTO2.setControlProduccion(
						(cultivoTmp.getControlProduccion() != null) ? cultivoTmp.getControlProduccion() : null);
				cultivoDTO2.setControlSemillero(
						(cultivoTmp.getControlSemillero() != null) ? cultivoTmp.getControlSemillero() : null);
				cultivoDTO2.setEsAcuicultura(
						(cultivoTmp.getEsAcuicultura() != null) ? cultivoTmp.getEsAcuicultura() : null);
				cultivoDTO2.setEsMineria((cultivoTmp.getEsMineria() != null) ? cultivoTmp.getEsMineria() : null);
				cultivoDTO2.setEsPecuaria((cultivoTmp.getEsPecuaria() != null) ? cultivoTmp.getEsPecuaria() : null);
				cultivoDTO2.setEstado((cultivoTmp.getEstado() != null) ? cultivoTmp.getEstado() : null);
				cultivoDTO2.setFechaCreacion(cultivoTmp.getFechaCreacion());
				cultivoDTO2.setFechaModificacion(cultivoTmp.getFechaModificacion());
				cultivoDTO2.setInfoAdicional(
						(cultivoTmp.getInfoAdicional() != null) ? cultivoTmp.getInfoAdicional() : null);
				cultivoDTO2.setInfoAdicional2(
						(cultivoTmp.getInfoAdicional2() != null) ? cultivoTmp.getInfoAdicional2() : null);
				cultivoDTO2
						.setLogoCultivo((cultivoTmp.getLogoCultivo() != null && !cultivoTmp.getLogoCultivo().equals(""))
								? cultivoTmp.getLogoCultivo() : "default.jpg");
				cultivoDTO2.setModeloPlanificacionCosecha((cultivoTmp.getModeloPlanificacionCosecha() != null)
						? cultivoTmp.getModeloPlanificacionCosecha() : null);
				cultivoDTO2.setMostrarEdad((cultivoTmp.getMostrarEdad() != null) ? cultivoTmp.getMostrarEdad() : null);
				cultivoDTO2.setNombre((cultivoTmp.getNombre() != null) ? cultivoTmp.getNombre() : null);

				if (cultivoTmp.getUdadMedByUdadMedId1() != null) {
					cultivoDTO2.setNombreUdadMed1(cultivoTmp.getUdadMedByUdadMedId1().getNombre());					
				} else {
					cultivoDTO2.setNombreUdadMed1(null);
				}

				if (cultivoTmp.getUdadMedByUdadMedId() != null) {
					cultivoDTO2.setNombreUdadMed(cultivoTmp.getUdadMedByUdadMedId().getNombre());
				} else {
					cultivoDTO2.setNombreUdadMed(null);
				}

				cultivoDTO.add(cultivoDTO2);
			}

			return cultivoDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Cultivo getCultivo(Long cultivoId) throws Exception {
		log.debug("getting Cultivo instance");

		Cultivo entity = null;

		try {
			entity = cultivoDAO.findById(cultivoId);
		} catch (Exception e) {
			log.error("get Cultivo failed", e);
			throw new ZMessManager().new FindingException("Cultivo");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cultivo> findPageCultivo(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<Cultivo> entity = null;

		try {
			entity = cultivoDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Cultivo Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberCultivo() throws Exception {
		Long entity = null;

		try {
			entity = cultivoDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Cultivo Count");
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
	public List<Cultivo> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<Cultivo> list = new ArrayList<Cultivo>();
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
			list = cultivoDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
