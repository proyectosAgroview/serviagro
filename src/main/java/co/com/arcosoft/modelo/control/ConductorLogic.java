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

import co.com.arcosoft.dataaccess.dao.IConductorDAO;
import co.com.arcosoft.dataaccess.dao.IDatTransProdDAO;
import co.com.arcosoft.dataaccess.dao.IVehiculosTranspDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Conductor;
import co.com.arcosoft.modelo.DatTransProd;
import co.com.arcosoft.modelo.VehiculosTransp;
import co.com.arcosoft.modelo.dto.ConductorDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("ConductorLogic")
public class ConductorLogic implements IConductorLogic {
	private static final Logger log = LoggerFactory.getLogger(ConductorLogic.class);

	/**
	 * DAO injected by Spring that manages Conductor entities
	 *
	 */
	@Autowired
	private IConductorDAO conductorDAO;

	/**
	 * DAO injected by Spring that manages DatTransProd entities
	 *
	 */
	@Autowired
	private IDatTransProdDAO datTransProdDAO;

	/**
	 * DAO injected by Spring that manages VehiculosTransp entities
	 *
	 */
	@Autowired
	private IVehiculosTranspDAO vehiculosTranspDAO;

	/**
	 * Logic injected by Spring that manages Ciudad entities
	 *
	 */
	@Autowired
	ICiudadLogic logicCiudad1;

	/**
	 * Logic injected by Spring that manages Ciudad entities
	 *
	 */
	@Autowired
	ICiudadLogic logicCiudad2;

	@Override
	@Transactional(readOnly = true)
	public List<Conductor> getConductor() throws Exception {
		log.debug("finding all Conductor instances");

		List<Conductor> list = new ArrayList<Conductor>();

		try {
			list = conductorDAO.findAll();
		} catch (Exception e) {
			log.error("finding all Conductor failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "Conductor");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveConductor(Conductor entity) throws Exception {
		log.debug("saving Conductor instance");

		try {
			if (entity.getCiudadByCiudadExpId() == null) {
				throw new ZMessManager().new ForeignException("ciudadByCiudadExpId");
			}

			if (entity.getCiudadByCiudadExpLic() == null) {
				throw new ZMessManager().new ForeignException("ciudadByCiudadExpLic");
			}

			if ((entity.getNIdentidad() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNIdentidad(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("NIdentidad");
			}

			if ((entity.getNLicencia() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNLicencia(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("NLicencia");
			}

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

			if ((entity.getFoto() != null) && (Utilities.checkWordAndCheckWithlength(entity.getFoto(), 150) == false)) {
				throw new ZMessManager().new NotValidFormatException("foto");
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

			if ((entity.getPrimerApellido() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getPrimerApellido(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("primerApellido");
			}

			if ((entity.getPrimerNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getPrimerNombre(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("primerNombre");
			}

			if ((entity.getSegundoApellido() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getSegundoApellido(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("segundoApellido");
			}

			if ((entity.getSegundoNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getSegundoNombre(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("segundoNombre");
			}

			if ((entity.getTelefono() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getTelefono(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("telefono");
			}

			if (entity.getCiudadByCiudadExpId().getCiudadId() == null) {
				throw new ZMessManager().new EmptyFieldException("ciudadId_Ciudad");
			}

			if ((entity.getCiudadByCiudadExpId().getCiudadId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getCiudadByCiudadExpId().getCiudadId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("ciudadId_Ciudad");
			}

			if (entity.getCiudadByCiudadExpLic().getCiudadId() == null) {
				throw new ZMessManager().new EmptyFieldException("ciudadId_Ciudad");
			}

			if ((entity.getCiudadByCiudadExpLic().getCiudadId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getCiudadByCiudadExpLic().getCiudadId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("ciudadId_Ciudad");
			}

			/*
			 * if (entity.getConductorId() == null) { throw new
			 * ZMessManager().new EmptyFieldException("conductorId"); }
			 * 
			 * if ((entity.getConductorId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getConductorId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "conductorId"); } if
			 * (getConductor(entity.getConductorId()) != null) { throw new
			 * ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */

			conductorDAO.save(entity);

			log.debug("save Conductor successful");
		} catch (Exception e) {
			log.error("save Conductor failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteConductor(Conductor entity) throws Exception {
		log.debug("deleting Conductor instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Conductor");
		}

		if (entity.getConductorId() == null) {
			throw new ZMessManager().new EmptyFieldException("conductorId");
		}

		List<DatTransProd> datTransProds = null;
		List<VehiculosTransp> vehiculosTransps = null;

		try {
			datTransProds = datTransProdDAO.findByProperty("conductor.conductorId", entity.getConductorId());

			if (Utilities.validationsList(datTransProds) == true) {
				throw new ZMessManager().new DeletingException("datTransProds");
			}

			vehiculosTransps = vehiculosTranspDAO.findByProperty("conductor.conductorId", entity.getConductorId());

			if (Utilities.validationsList(vehiculosTransps) == true) {
				throw new ZMessManager().new DeletingException("vehiculosTransps");
			}

			conductorDAO.delete(entity);

			log.debug("delete Conductor successful");
		} catch (Exception e) {
			log.error("delete Conductor failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateConductor(Conductor entity) throws Exception {
		log.debug("updating Conductor instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Conductor");
			}

			if (entity.getCiudadByCiudadExpId() == null) {
				throw new ZMessManager().new ForeignException("ciudadByCiudadExpId");
			}

			if (entity.getCiudadByCiudadExpLic() == null) {
				throw new ZMessManager().new ForeignException("ciudadByCiudadExpLic");
			}

			if ((entity.getNIdentidad() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNIdentidad(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("NIdentidad");
			}

			if ((entity.getNLicencia() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNLicencia(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("NLicencia");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if (entity.getConductorId() == null) {
				throw new ZMessManager().new EmptyFieldException("conductorId");
			}

			if ((entity.getConductorId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getConductorId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("conductorId");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getFoto() != null) && (Utilities.checkWordAndCheckWithlength(entity.getFoto(), 150) == false)) {
				throw new ZMessManager().new NotValidFormatException("foto");
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

			if ((entity.getPrimerApellido() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getPrimerApellido(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("primerApellido");
			}

			if ((entity.getPrimerNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getPrimerNombre(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("primerNombre");
			}

			if ((entity.getSegundoApellido() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getSegundoApellido(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("segundoApellido");
			}

			if ((entity.getSegundoNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getSegundoNombre(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("segundoNombre");
			}

			if ((entity.getTelefono() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getTelefono(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("telefono");
			}

			if (entity.getCiudadByCiudadExpId().getCiudadId() == null) {
				throw new ZMessManager().new EmptyFieldException("ciudadId_Ciudad");
			}

			if ((entity.getCiudadByCiudadExpId().getCiudadId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getCiudadByCiudadExpId().getCiudadId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("ciudadId_Ciudad");
			}

			if (entity.getCiudadByCiudadExpLic().getCiudadId() == null) {
				throw new ZMessManager().new EmptyFieldException("ciudadId_Ciudad");
			}

			if ((entity.getCiudadByCiudadExpLic().getCiudadId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getCiudadByCiudadExpLic().getCiudadId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("ciudadId_Ciudad");
			}

			conductorDAO.update(entity);

			log.debug("update Conductor successful");
		} catch (Exception e) {
			log.error("update Conductor failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<ConductorDTO> getDataConductor() throws Exception {
		try {
			List<Conductor> conductor = conductorDAO.findAll();

			List<ConductorDTO> conductorDTO = new ArrayList<ConductorDTO>();

			for (Conductor conductorTmp : conductor) {
				ConductorDTO conductorDTO2 = new ConductorDTO();

				conductorDTO2.setConductorId(conductorTmp.getConductorId());
				conductorDTO2
						.setNIdentidad((conductorTmp.getNIdentidad() != null) ? conductorTmp.getNIdentidad() : null);
				conductorDTO2.setNLicencia((conductorTmp.getNLicencia() != null) ? conductorTmp.getNLicencia() : null);
				conductorDTO2.setCodigo((conductorTmp.getCodigo() != null) ? conductorTmp.getCodigo() : null);
				conductorDTO2.setCompania((conductorTmp.getCompania() != null) ? conductorTmp.getCompania() : null);
				conductorDTO2.setEstado((conductorTmp.getEstado() != null) ? conductorTmp.getEstado() : null);
				conductorDTO2.setFechaCreacion(conductorTmp.getFechaCreacion());
				conductorDTO2.setFechaModificacion(conductorTmp.getFechaModificacion());
				conductorDTO2.setFoto((conductorTmp.getFoto() != null && !conductorTmp.getFoto().equals(""))
						? conductorTmp.getFoto() : "default.jpg");
				conductorDTO2.setInfoAdicional(
						(conductorTmp.getInfoAdicional() != null) ? conductorTmp.getInfoAdicional() : null);
				conductorDTO2.setInfoAdicional2(
						(conductorTmp.getInfoAdicional2() != null) ? conductorTmp.getInfoAdicional2() : null);
				conductorDTO2.setNombre((conductorTmp.getNombre() != null) ? conductorTmp.getNombre() : null);
				conductorDTO2.setPrimerApellido(
						(conductorTmp.getPrimerApellido() != null) ? conductorTmp.getPrimerApellido() : null);
				conductorDTO2.setPrimerNombre(
						(conductorTmp.getPrimerNombre() != null) ? conductorTmp.getPrimerNombre() : null);
				conductorDTO2.setSegundoApellido(
						(conductorTmp.getSegundoApellido() != null) ? conductorTmp.getSegundoApellido() : null);
				conductorDTO2.setSegundoNombre(
						(conductorTmp.getSegundoNombre() != null) ? conductorTmp.getSegundoNombre() : null);
				conductorDTO2.setTelefono((conductorTmp.getTelefono() != null) ? conductorTmp.getTelefono() : null);
				conductorDTO2.setCiudadId_Ciudad((conductorTmp.getCiudadByCiudadExpId().getCiudadId() != null)
						? conductorTmp.getCiudadByCiudadExpId().getCiudadId() : null);
				conductorDTO2.setCiudadId_Ciudad1((conductorTmp.getCiudadByCiudadExpLic().getCiudadId() != null)
						? conductorTmp.getCiudadByCiudadExpLic().getCiudadId() : null);

				conductorDTO.add(conductorDTO2);
			}

			return conductorDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Conductor getConductor(Long conductorId) throws Exception {
		log.debug("getting Conductor instance");

		Conductor entity = null;

		try {
			entity = conductorDAO.findById(conductorId);
		} catch (Exception e) {
			log.error("get Conductor failed", e);
			throw new ZMessManager().new FindingException("Conductor");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Conductor> findPageConductor(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<Conductor> entity = null;

		try {
			entity = conductorDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Conductor Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberConductor() throws Exception {
		Long entity = null;

		try {
			entity = conductorDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Conductor Count");
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
	public List<Conductor> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<Conductor> list = new ArrayList<Conductor>();
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
			list = conductorDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
