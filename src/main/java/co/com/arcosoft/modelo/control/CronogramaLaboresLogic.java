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

import co.com.arcosoft.dataaccess.dao.ICronogramaLaboresDAO;
import co.com.arcosoft.dataaccess.dao.ICronogramaLaboresLaboresDAO;
import co.com.arcosoft.dataaccess.dao.ICronogramaLaboresNivel4DAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.CronogramaLabores;
import co.com.arcosoft.modelo.CronogramaLaboresLabores;
import co.com.arcosoft.modelo.CronogramaLaboresNivel4;
import co.com.arcosoft.modelo.dto.CronogramaLaboresDTO;
import co.com.arcosoft.modelo.dto.CronogramaLaboresLaboresDTO;
import co.com.arcosoft.modelo.dto.CronogramaLaboresNivel4DTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("CronogramaLaboresLogic")
public class CronogramaLaboresLogic implements ICronogramaLaboresLogic {
	private static final Logger log = LoggerFactory.getLogger(CronogramaLaboresLogic.class);

	/**
	 * DAO injected by Spring that manages CronogramaLabores entities
	 *
	 */
	@Autowired
	private ICronogramaLaboresDAO cronogramaLaboresDAO;

	/**
	 * DAO injected by Spring that manages CronogramaLaboresLabores entities
	 *
	 */
	@Autowired
	private ICronogramaLaboresLaboresDAO cronogramaLaboresLaboresDAO;

	/**
	 * DAO injected by Spring that manages CronogramaLaboresNivel4 entities
	 *
	 */
	@Autowired
	private ICronogramaLaboresNivel4DAO cronogramaLaboresNivel4DAO;

	@Override
	@Transactional(readOnly = true)
	public List<CronogramaLabores> getCronogramaLabores() throws Exception {
		log.debug("finding all CronogramaLabores instances");

		List<CronogramaLabores> list = new ArrayList<CronogramaLabores>();

		try {
			list = cronogramaLaboresDAO.findAll();
		} catch (Exception e) {
			log.error("finding all CronogramaLabores failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "CronogramaLabores");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveCronogramaLabores(CronogramaLabores entity,
			List<CronogramaLaboresLaboresDTO> dataCronogramaLaboresLabores,
			List<CronogramaLaboresNivel4DTO> dataCronogramaLaboresNivel4) throws Exception {
		log.debug("saving CronogramaLabores instance");

		try {
			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
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

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			cronogramaLaboresDAO.save(entity);

			if (dataCronogramaLaboresLabores == null) {

				for (CronogramaLaboresLaboresDTO valorDto : dataCronogramaLaboresLabores) {

					if (valorDto.getCronogramaLaboresLaboresId() == null) {

						CronogramaLaboresLabores valor = new CronogramaLaboresLabores();

						valor.setLabor(valorDto.getLaborId_Labor());
						valor.setDuracion(valorDto.getDuracion());
						valor.setNumeroDiasFin(valorDto.getNumeroDiasFin());
						valor.setNumeroDiasInicio(valorDto.getNumeroDiasInicio());
						valor.setTarifaLabor(valorDto.getTarifaLabor());
						valor.setPresupuestoBaseAreaPlantas(valorDto.getPresupuestoBaseAreaPlantas());
						valor.setUdadMed(valorDto.getUdadMed());

						valor.setEnero(valorDto.getEnero());
						valor.setFebrero(valorDto.getFebrero());
						valor.setMarzo(valorDto.getMarzo());
						valor.setAbril(valorDto.getAbril());
						valor.setMayo(valorDto.getMayo());
						valor.setJunio(valorDto.getJunio());
						valor.setJulio(valorDto.getJulio());
						valor.setAgosto(valorDto.getAgosto());
						valor.setSeptiembre(valorDto.getSeptiembre());
						valor.setOctubre(valorDto.getOctubre());
						valor.setNoviembre(valorDto.getNoviembre());
						valor.setDiciembre(valorDto.getDiciembre());
						valor.setAreaEnero(valorDto.getAreaEnero());
						valor.setAreaFebrero(valorDto.getAreaFebrero());
						valor.setAreaMarzo(valorDto.getAreaMarzo());
						valor.setAreaAbril(valorDto.getAreaAbril());
						valor.setAreaMayo(valorDto.getAreaMayo());
						valor.setAreaJunio(valorDto.getAreaJunio());
						valor.setAreaJulio(valorDto.getAreaJulio());
						valor.setAreaAgosto(valorDto.getAreaAgosto());
						valor.setAreaSeptiembre(valorDto.getAreaSeptiembre());
						valor.setAreaOctubre(valorDto.getAreaOctubre());
						valor.setAreaNoviembre(valorDto.getAreaNoviembre());
						valor.setAreaDiciembre(valorDto.getAreaDiciembre());

						valor.setCronogramaLabores(entity);

						cronogramaLaboresLaboresDAO.save(valor);
					}

				}
			}

			if (dataCronogramaLaboresNivel4 == null) {

				for (CronogramaLaboresNivel4DTO valorDto : dataCronogramaLaboresNivel4) {

					if (valorDto.getCronogramaLaboresNivel4Id() == null) {

						CronogramaLaboresNivel4 valor = new CronogramaLaboresNivel4();

						valor.setNivel4(valorDto.getNivel4Id_Nivel4());
						valor.setNivel2Id(valorDto.getNivel2Id());

						valor.setAreaNeta(valorDto.getAreaNeta());
						valor.setNumeroPlantas(valorDto.getNumeroPlantas());
						valor.setFechaStart(valorDto.getFechaStart());
						valor.setCronogramaLabores(entity);

						cronogramaLaboresNivel4DAO.save(valor);
					}

				}
			}

			log.debug("save CronogramaLabores successful");
		} catch (Exception e) {
			log.error("save CronogramaLabores failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteCronogramaLabores(CronogramaLabores entity) throws Exception {
		log.debug("deleting CronogramaLabores instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("CronogramaLabores");
		}

		if (entity.getCronogramaLaboresId() == null) {
			throw new ZMessManager().new EmptyFieldException("cronogramaLaboresId");
		}

		List<CronogramaLaboresLabores> cronogramaLaboresLaboreses = null;
		List<CronogramaLaboresNivel4> cronogramaLaboresNivel4s = null;

		try {
			cronogramaLaboresLaboreses = cronogramaLaboresLaboresDAO
					.findByProperty("cronogramaLabores.cronogramaLaboresId", entity.getCronogramaLaboresId());

			if (Utilities.validationsList(cronogramaLaboresLaboreses) == true) {
				throw new ZMessManager().new DeletingException("cronogramaLaboresLaboreses");
			}

			cronogramaLaboresNivel4s = cronogramaLaboresNivel4DAO
					.findByProperty("cronogramaLabores.cronogramaLaboresId", entity.getCronogramaLaboresId());

			if (Utilities.validationsList(cronogramaLaboresNivel4s) == true) {
				throw new ZMessManager().new DeletingException("cronogramaLaboresNivel4s");
			}

			cronogramaLaboresDAO.delete(entity);

			log.debug("delete CronogramaLabores successful");
		} catch (Exception e) {
			log.error("delete CronogramaLabores failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateCronogramaLabores(CronogramaLabores entity,
			List<CronogramaLaboresLaboresDTO> dataCronogramaLaboresLabores,
			List<CronogramaLaboresNivel4DTO> dataCronogramaLaboresNivel4) throws Exception {
		log.debug("updating CronogramaLabores instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("CronogramaLabores");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if (entity.getCronogramaLaboresId() == null) {
				throw new ZMessManager().new EmptyFieldException("cronogramaLaboresId");
			}

			if ((entity.getCronogramaLaboresId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCronogramaLaboresId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("cronogramaLaboresId");
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

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			cronogramaLaboresDAO.update(entity);

			if (dataCronogramaLaboresLabores != null) {

				for (CronogramaLaboresLaboresDTO valorDto : dataCronogramaLaboresLabores) {

					if (valorDto.getCronogramaLaboresLaboresId() == null) {

						CronogramaLaboresLabores valor = new CronogramaLaboresLabores();

						valor.setLabor(valorDto.getLaborId_Labor());
						valor.setDuracion(valorDto.getDuracion());
						valor.setNumeroDiasFin(valorDto.getNumeroDiasFin());
						valor.setNumeroDiasInicio(valorDto.getNumeroDiasInicio());
						valor.setTarifaLabor(valorDto.getTarifaLabor());
						valor.setPresupuestoBaseAreaPlantas(valorDto.getPresupuestoBaseAreaPlantas());
						valor.setUdadMed(valorDto.getUdadMed());
						valor.setEnero(valorDto.getEnero());
						valor.setFebrero(valorDto.getFebrero());
						valor.setMarzo(valorDto.getMarzo());
						valor.setAbril(valorDto.getAbril());
						valor.setMayo(valorDto.getMayo());
						valor.setJunio(valorDto.getJunio());
						valor.setJulio(valorDto.getJulio());
						valor.setAgosto(valorDto.getAgosto());
						valor.setSeptiembre(valorDto.getSeptiembre());
						valor.setOctubre(valorDto.getOctubre());
						valor.setNoviembre(valorDto.getNoviembre());
						valor.setDiciembre(valorDto.getDiciembre());
						valor.setAreaEnero(valorDto.getAreaEnero());
						valor.setAreaFebrero(valorDto.getAreaFebrero());
						valor.setAreaMarzo(valorDto.getAreaMarzo());
						valor.setAreaAbril(valorDto.getAreaAbril());
						valor.setAreaMayo(valorDto.getAreaMayo());
						valor.setAreaJunio(valorDto.getAreaJunio());
						valor.setAreaJulio(valorDto.getAreaJulio());
						valor.setAreaAgosto(valorDto.getAreaAgosto());
						valor.setAreaSeptiembre(valorDto.getAreaSeptiembre());
						valor.setAreaOctubre(valorDto.getAreaOctubre());
						valor.setAreaNoviembre(valorDto.getAreaNoviembre());
						valor.setAreaDiciembre(valorDto.getAreaDiciembre());

						valor.setCronogramaLabores(entity);

						cronogramaLaboresLaboresDAO.save(valor);

					} else {

						CronogramaLaboresLabores valor = cronogramaLaboresLaboresDAO
								.findById(valorDto.getCronogramaLaboresLaboresId());

						valor.setLabor(valorDto.getLaborId_Labor());
						valor.setDuracion(valorDto.getDuracion());
						valor.setNumeroDiasFin(valorDto.getNumeroDiasFin());
						valor.setNumeroDiasInicio(valorDto.getNumeroDiasInicio());
						valor.setTarifaLabor(valorDto.getTarifaLabor());
						valor.setPresupuestoBaseAreaPlantas(valorDto.getPresupuestoBaseAreaPlantas());
						valor.setUdadMed(valorDto.getUdadMed());

						valor.setEnero(valorDto.getEnero());
						valor.setFebrero(valorDto.getFebrero());
						valor.setMarzo(valorDto.getMarzo());
						valor.setAbril(valorDto.getAbril());
						valor.setMayo(valorDto.getMayo());
						valor.setJunio(valorDto.getJunio());
						valor.setJulio(valorDto.getJulio());
						valor.setAgosto(valorDto.getAgosto());
						valor.setSeptiembre(valorDto.getSeptiembre());
						valor.setOctubre(valorDto.getOctubre());
						valor.setNoviembre(valorDto.getNoviembre());
						valor.setDiciembre(valorDto.getDiciembre());
						valor.setAreaEnero(valorDto.getAreaEnero());
						valor.setAreaFebrero(valorDto.getAreaFebrero());
						valor.setAreaMarzo(valorDto.getAreaMarzo());
						valor.setAreaAbril(valorDto.getAreaAbril());
						valor.setAreaMayo(valorDto.getAreaMayo());
						valor.setAreaJunio(valorDto.getAreaJunio());
						valor.setAreaJulio(valorDto.getAreaJulio());
						valor.setAreaAgosto(valorDto.getAreaAgosto());
						valor.setAreaSeptiembre(valorDto.getAreaSeptiembre());
						valor.setAreaOctubre(valorDto.getAreaOctubre());
						valor.setAreaNoviembre(valorDto.getAreaNoviembre());
						valor.setAreaDiciembre(valorDto.getAreaDiciembre());

						valor.setCronogramaLabores(entity);

						cronogramaLaboresLaboresDAO.update(valor);
					}

				}

			}

			if (dataCronogramaLaboresNivel4 != null) {

				for (CronogramaLaboresNivel4DTO valorDto : dataCronogramaLaboresNivel4) {

					if (valorDto.getCronogramaLaboresNivel4Id() == null) {

						CronogramaLaboresNivel4 valor = new CronogramaLaboresNivel4();

						valor.setNivel4(valorDto.getNivel4Id_Nivel4());
						valor.setNivel2Id(valorDto.getNivel2Id());

						valor.setAreaNeta(valorDto.getAreaNeta());
						valor.setNumeroPlantas(valorDto.getNumeroPlantas());
						valor.setFechaStart(valorDto.getFechaStart());
						valor.setCronogramaLabores(entity);

						cronogramaLaboresNivel4DAO.save(valor);

					} else {

						CronogramaLaboresNivel4 valor = cronogramaLaboresNivel4DAO
								.findById(valorDto.getCronogramaLaboresNivel4Id());

						valor.setNivel4(valorDto.getNivel4Id_Nivel4());
						valor.setNivel2Id(valorDto.getNivel2Id());

						valor.setAreaNeta(valorDto.getAreaNeta());
						valor.setNumeroPlantas(valorDto.getNumeroPlantas());
						valor.setFechaStart(valorDto.getFechaStart());
						valor.setCronogramaLabores(entity);

						cronogramaLaboresNivel4DAO.update(valor);
					}

				}

			}

			log.debug("update CronogramaLabores successful");
		} catch (Exception e) {
			log.error("update CronogramaLabores failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<CronogramaLaboresDTO> getDataCronogramaLabores() throws Exception {
		try {
			List<CronogramaLabores> cronogramaLabores = cronogramaLaboresDAO.findAll();

			List<CronogramaLaboresDTO> cronogramaLaboresDTO = new ArrayList<CronogramaLaboresDTO>();

			for (CronogramaLabores cronogramaLaboresTmp : cronogramaLabores) {
				CronogramaLaboresDTO cronogramaLaboresDTO2 = new CronogramaLaboresDTO();

				cronogramaLaboresDTO2.setCronogramaLaboresId(cronogramaLaboresTmp.getCronogramaLaboresId());
				cronogramaLaboresDTO2.setCodigo(
						(cronogramaLaboresTmp.getCodigo() != null) ? cronogramaLaboresTmp.getCodigo() : null);
				cronogramaLaboresDTO2.setCompania(
						(cronogramaLaboresTmp.getCompania() != null) ? cronogramaLaboresTmp.getCompania() : null);
				cronogramaLaboresDTO2.setEstado(
						(cronogramaLaboresTmp.getEstado() != null) ? cronogramaLaboresTmp.getEstado() : null);
				cronogramaLaboresDTO2.setFechaCreacion(cronogramaLaboresTmp.getFechaCreacion());
				cronogramaLaboresDTO2.setFechaModificacion(cronogramaLaboresTmp.getFechaModificacion());
				cronogramaLaboresDTO2.setInfoAdicional((cronogramaLaboresTmp.getInfoAdicional() != null)
						? cronogramaLaboresTmp.getInfoAdicional() : null);
				cronogramaLaboresDTO2.setInfoAdicional2((cronogramaLaboresTmp.getInfoAdicional2() != null)
						? cronogramaLaboresTmp.getInfoAdicional2() : null);
				cronogramaLaboresDTO2.setNombre(
						(cronogramaLaboresTmp.getNombre() != null) ? cronogramaLaboresTmp.getNombre() : null);

				cronogramaLaboresDTO2.setEsExpres(
						(cronogramaLaboresTmp.getEsExpres() != null) ? cronogramaLaboresTmp.getEsExpres() : null);

				cronogramaLaboresDTO2.setPeriodoFinal(cronogramaLaboresTmp.getPeriodoFinal());

				cronogramaLaboresDTO2.setPeriodoInicial(cronogramaLaboresTmp.getPeriodoInicial());

				cronogramaLaboresDTO.add(cronogramaLaboresDTO2);
			}

			return cronogramaLaboresDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public CronogramaLabores getCronogramaLabores(Long cronogramaLaboresId) throws Exception {
		log.debug("getting CronogramaLabores instance");

		CronogramaLabores entity = null;

		try {
			entity = cronogramaLaboresDAO.findById(cronogramaLaboresId);
		} catch (Exception e) {
			log.error("get CronogramaLabores failed", e);
			throw new ZMessManager().new FindingException("CronogramaLabores");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<CronogramaLabores> findPageCronogramaLabores(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<CronogramaLabores> entity = null;

		try {
			entity = cronogramaLaboresDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("CronogramaLabores Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberCronogramaLabores() throws Exception {
		Long entity = null;

		try {
			entity = cronogramaLaboresDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("CronogramaLabores Count");
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
	 * @param variablesBetweenDates(en
	 *            este caso solo para mysql) [0] = String variable = (String)
	 *            varibles[k]; el nombre de la variable que hace referencia a
	 *            una fecha
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
	public List<CronogramaLabores> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<CronogramaLabores> list = new ArrayList<CronogramaLabores>();
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
			list = cronogramaLaboresDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
