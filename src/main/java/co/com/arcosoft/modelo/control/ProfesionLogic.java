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

import co.com.arcosoft.dataaccess.dao.IPersEmprDAO;
import co.com.arcosoft.dataaccess.dao.IProfesionDAO;
import co.com.arcosoft.dataaccess.dao.ITarifaProfesionDAO;
import co.com.arcosoft.dataaccess.dao.ITrabajadorDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.Profesion;
import co.com.arcosoft.modelo.TarifaProfesion;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.dto.ProfesionDTO;
import co.com.arcosoft.modelo.dto.TarifaProfesionDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("ProfesionLogic")
public class ProfesionLogic implements IProfesionLogic {
	private static final Logger log = LoggerFactory.getLogger(ProfesionLogic.class);

	/**
	 * DAO injected by Spring that manages Profesion entities
	 *
	 */
	@Autowired
	private IProfesionDAO profesionDAO;

	/**
	 * DAO injected by Spring that manages PersEmpr entities
	 *
	 */
	@Autowired
	private IPersEmprDAO persEmprDAO;

	/**
	 * DAO injected by Spring that manages Trabajador entities
	 *
	 */
	@Autowired
	private ITrabajadorDAO trabajadorDAO;

	@Autowired
	private ITarifaProfesionDAO tarifaProfesionDAO;

	/**
	 * Logic injected by Spring that manages ElementoCosto entities
	 *
	 */
	@Autowired
	IElementoCostoLogic logicElementoCosto1;

	@Override
	@Transactional(readOnly = true)
	public List<Profesion> getProfesion() throws Exception {
		log.debug("finding all Profesion instances");

		List<Profesion> list = new ArrayList<Profesion>();

		try {
			list = profesionDAO.findAll();
		} catch (Exception e) {
			log.error("finding all Profesion failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "Profesion");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveProfesion(Profesion entity, List<TarifaProfesionDTO> dataTarifaProfesion) throws Exception {
		log.debug("saving Profesion instance");

		try {
			/*
			 * if (entity.getElementoCosto() == null) { throw new
			 * ZMessManager().new ForeignException("elementoCosto"); }
			 */
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

			if ((entity.getFunciones() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getFunciones(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("funciones");
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

			/*
			 * if (entity.getElementoCosto().getElemCostoId() == null) { throw
			 * new ZMessManager().new EmptyFieldException(
			 * "elemCostoId_ElementoCosto"); }
			 */

			if ((entity.getElementoCosto() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getElementoCosto(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("elemCostoId_ElementoCosto");
			}

			/*
			 * if (entity.getProfId() == null) { throw new ZMessManager().new
			 * EmptyFieldException("profId"); }
			 * 
			 * if ((entity.getProfId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getProfId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException("profId"); } if
			 * (getProfesion(entity.getProfId()) != null) { throw new
			 * ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */

			profesionDAO.save(entity);

			if (dataTarifaProfesion != null) {

				for (TarifaProfesionDTO valorDto : dataTarifaProfesion) {

					if (valorDto.getTarifaProfId() == null) {

						TarifaProfesion valor = new TarifaProfesion();

						valor.setCompania(valorDto.getCompania());
						valor.setConceptoNomina(valorDto.getCeptoNominaId_ConceptoNomina());
						valor.setFechaCreacion(valorDto.getFechaCreacion());
						valor.setFechaFinal(valorDto.getFechaFinal());
						valor.setFechaInicial(valorDto.getFechaInicial());
						valor.setFechaModificacion(valorDto.getFechaModificacion());
						valor.setContratistaId(valorDto.getContratistaId());
						valor.setTarifa(valorDto.getTarifa());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());

						valor.setProfesion(entity);

						tarifaProfesionDAO.save(valor);
					}

				}
			}
			log.debug("save Profesion successful");
		} catch (Exception e) {
			log.error("save Profesion failed", e);
			throw e;
		} finally {
		}

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteProfesion(Profesion entity) throws Exception {
		log.debug("deleting Profesion instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Profesion");
		}

		if (entity.getProfId() == null) {
			throw new ZMessManager().new EmptyFieldException("profId");
		}

		List<PersEmpr> persEmprs = null;
		List<Trabajador> trabajadors = null;
		List<TarifaProfesion> tarifaProfesions = null;

		try {
			persEmprs = persEmprDAO.findByProperty("profesion.profId", entity.getProfId());

			if (Utilities.validationsList(persEmprs) == true) {
				throw new ZMessManager().new DeletingException("persEmprs");
			}

			trabajadors = trabajadorDAO.findByProperty("profesion.profId", entity.getProfId());
			if (Utilities.validationsList(trabajadors) == true) {
				throw new ZMessManager().new DeletingException("trabajadors");
			}

			/****** corregir ****/
			tarifaProfesions = tarifaProfesionDAO.findByProperty("profesion.profId", entity.getProfId());
			if (Utilities.validationsList(tarifaProfesions) == true) {
				throw new ZMessManager().new DeletingException("tarifaProfesions");
			}

			profesionDAO.delete(entity);

			log.debug("delete Profesion successful");
		} catch (Exception e) {
			log.error("delete Profesion failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateProfesion(Profesion entity, List<TarifaProfesionDTO> dataTarifaProfesion) throws Exception {
		log.debug("updating Profesion instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Profesion");
			}

			/*
			 * if (entity.getElementoCosto() == null) { throw new
			 * ZMessManager().new ForeignException("elementoCosto"); }
			 */
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

			if ((entity.getFunciones() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getFunciones(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("funciones");
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

			if (entity.getProfId() == null) {
				throw new ZMessManager().new EmptyFieldException("profId");
			}

			if ((entity.getProfId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getProfId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("profId");
			}
			/*
			 * if (entity.getElementoCosto().getElemCostoId() == null) { throw
			 * new ZMessManager().new EmptyFieldException(
			 * "elemCostoId_ElementoCosto"); }
			 */

			if ((entity.getElementoCosto() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getElementoCosto(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("elemCostoId_ElementoCosto");
			}

			profesionDAO.update(entity);

			if (dataTarifaProfesion != null) {

				for (TarifaProfesionDTO valorDto : dataTarifaProfesion) {

					if (valorDto.getTarifaProfId() == null) {

						TarifaProfesion valor = new TarifaProfesion();

						valor.setCompania(valorDto.getCompania());
						valor.setConceptoNomina(valorDto.getCeptoNominaId_ConceptoNomina());
						valor.setFechaCreacion(valorDto.getFechaCreacion());
						valor.setFechaFinal(valorDto.getFechaFinal());
						valor.setFechaInicial(valorDto.getFechaInicial());
						valor.setFechaModificacion(valorDto.getFechaModificacion());
						valor.setContratistaId(valorDto.getContratistaId());
						valor.setTarifa(valorDto.getTarifa());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());

						valor.setProfesion(entity);

						tarifaProfesionDAO.save(valor);
					} else {
						TarifaProfesion valor = tarifaProfesionDAO.findById(valorDto.getTarifaProfId());

						valor.setCompania(valorDto.getCompania());
						valor.setConceptoNomina(valorDto.getCeptoNominaId_ConceptoNomina());
						valor.setFechaCreacion(valorDto.getFechaCreacion());
						valor.setFechaFinal(valorDto.getFechaFinal());
						valor.setFechaInicial(valorDto.getFechaInicial());
						valor.setFechaModificacion(valorDto.getFechaModificacion());
						valor.setContratistaId(valorDto.getContratistaId());
						valor.setTarifa(valorDto.getTarifa());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());

						tarifaProfesionDAO.save(valor);
					}

				}
			}

			log.debug("update Profesion successful");
		} catch (Exception e) {
			log.error("update Profesion failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProfesionDTO> getDataProfesion() throws Exception {
		try {
			List<Profesion> profesion = profesionDAO.findAll();

			List<ProfesionDTO> profesionDTO = new ArrayList<ProfesionDTO>();

			for (Profesion profesionTmp : profesion) {
				ProfesionDTO profesionDTO2 = new ProfesionDTO();

				profesionDTO2.setProfId(profesionTmp.getProfId());
				profesionDTO2.setCodigo((profesionTmp.getCodigo() != null) ? profesionTmp.getCodigo() : null);
				profesionDTO2.setCompania((profesionTmp.getCompania() != null) ? profesionTmp.getCompania() : null);
				profesionDTO2.setEstado((profesionTmp.getEstado() != null) ? profesionTmp.getEstado() : null);
				profesionDTO2.setFechaCreacion(profesionTmp.getFechaCreacion());
				profesionDTO2.setFechaModificacion(profesionTmp.getFechaModificacion());
				profesionDTO2.setFunciones((profesionTmp.getFunciones() != null) ? profesionTmp.getFunciones() : null);
				profesionDTO2.setInfoAdicional(
						(profesionTmp.getInfoAdicional() != null) ? profesionTmp.getInfoAdicional() : null);
				profesionDTO2.setInfoAdicional2(
						(profesionTmp.getInfoAdicional2() != null) ? profesionTmp.getInfoAdicional2() : null);
				profesionDTO2.setNombre((profesionTmp.getNombre() != null) ? profesionTmp.getNombre() : null);
				profesionDTO2.setElemCostoId_ElementoCosto(
						(profesionTmp.getElementoCosto() != null) ? profesionTmp.getElementoCosto() : null);

				profesionDTO.add(profesionDTO2);
			}

			return profesionDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Profesion getProfesion(Long profId) throws Exception {
		log.debug("getting Profesion instance");

		Profesion entity = null;

		try {
			entity = profesionDAO.findById(profId);
		} catch (Exception e) {
			log.error("get Profesion failed", e);
			throw new ZMessManager().new FindingException("Profesion");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Profesion> findPageProfesion(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<Profesion> entity = null;

		try {
			entity = profesionDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Profesion Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberProfesion() throws Exception {
		Long entity = null;

		try {
			entity = profesionDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Profesion Count");
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
	public List<Profesion> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<Profesion> list = new ArrayList<Profesion>();
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
			list = profesionDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
