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

import co.com.arcosoft.dataaccess.dao.IDatRiegoDAO;
import co.com.arcosoft.dataaccess.dao.IInfraestructuraDAO;
import co.com.arcosoft.dataaccess.dao.ITarifaInfraestructuraDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatRiego;
import co.com.arcosoft.modelo.Infraestructura;
import co.com.arcosoft.modelo.TarifaInfraestructura;
import co.com.arcosoft.modelo.dto.InfraestructuraDTO;
import co.com.arcosoft.modelo.dto.TarifaInfraestructuraDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("InfraestructuraLogic")
public class InfraestructuraLogic implements IInfraestructuraLogic {
	private static final Logger log = LoggerFactory.getLogger(InfraestructuraLogic.class);

	/**
	 * DAO injected by Spring that manages Infraestructura entities
	 *
	 */
	@Autowired
	private IInfraestructuraDAO infraestructuraDAO;

	/**
	 * DAO injected by Spring that manages DatRiego entities
	 *
	 */
	@Autowired
	private IDatRiegoDAO datRiegoDAO;

	/**
	 * Logic injected by Spring that manages TipoInfraestructura entities
	 *
	 */
	@Autowired
	ITipoInfraestructuraLogic logicTipoInfraestructura1;

	@Autowired
	private ITarifaInfraestructuraDAO tarifaInfraestructuraDAO;

	@Override
	@Transactional(readOnly = true)
	public List<Infraestructura> getInfraestructura() throws Exception {
		log.debug("finding all Infraestructura instances");

		List<Infraestructura> list = new ArrayList<Infraestructura>();

		try {
			list = infraestructuraDAO.findAll();
		} catch (Exception e) {
			log.error("finding all Infraestructura failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "Infraestructura");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveInfraestructura(Infraestructura entity, List<TarifaInfraestructuraDTO> data) throws Exception {
		log.debug("saving Infraestructura instance");

		try {
			if (entity.getTipoInfraestructura() == null) {
				throw new ZMessManager().new ForeignException("tipoInfraestructura");
			}

			if ((entity.getAbastecimiento() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getAbastecimiento(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("abastecimiento");
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

			if ((entity.getInfoAdicional() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional");
			}

			if ((entity.getInfoAdicional2() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional2(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional2");
			}

			if ((entity.getFoto() != null) && (Utilities.checkWordAndCheckWithlength(entity.getFoto(), 150) == false)) {
				throw new ZMessManager().new NotValidFormatException("foto");
			}

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			if (entity.getTipoInfraestructura().getTipoInfraId() == null) {
				throw new ZMessManager().new EmptyFieldException("tipoInfraId_TipoInfraestructura");
			}

			if ((entity.getTipoInfraestructura().getTipoInfraId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getTipoInfraestructura().getTipoInfraId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("tipoInfraId_TipoInfraestructura");
			}

			/*
			 * if (entity.getInfraId() == null) { throw new ZMessManager().new
			 * EmptyFieldException("infraId"); }
			 * 
			 * if ((entity.getInfraId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getInfraId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException("infraId"); }
			 * 
			 * 
			 * if (getInfraestructura(entity.getInfraId()) != null) { throw new
			 * ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */

			infraestructuraDAO.save(entity);

			if (data != null) {

				for (TarifaInfraestructuraDTO valor : data) {

					if (valor.getTarInfraId() == null) {

						TarifaInfraestructura tarifa = new TarifaInfraestructura();

						tarifa.setFechaInicial(valor.getFechaInicial());
						tarifa.setFechaFinal(valor.getFechaFinal());
						tarifa.setValor(valor.getValor());
						tarifa.setFechaCreacion(valor.getFechaModificacion());
						tarifa.setFechaModificacion(valor.getFechaModificacion());
						tarifa.setInfraestructura(entity);

						tarifaInfraestructuraDAO.save(tarifa);

					}

				}

			}

			log.debug("save Infraestructura successful");
		} catch (Exception e) {
			log.error("save Infraestructura failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteInfraestructura(Infraestructura entity) throws Exception {
		log.debug("deleting Infraestructura instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Infraestructura");
		}

		if (entity.getInfraId() == null) {
			throw new ZMessManager().new EmptyFieldException("infraId");
		}

		List<DatRiego> datRiegos = null;

		try {
			datRiegos = datRiegoDAO.findByProperty("infraestructura.infraId", entity.getInfraId());

			if (Utilities.validationsList(datRiegos) == true) {
				throw new ZMessManager().new DeletingException("datRiegos");
			}

			infraestructuraDAO.delete(entity);

			log.debug("delete Infraestructura successful");
		} catch (Exception e) {
			log.error("delete Infraestructura failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateInfraestructura(Infraestructura entity, List<TarifaInfraestructuraDTO> data) throws Exception {
		log.debug("updating Infraestructura instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Infraestructura");
			}

			if (entity.getTipoInfraestructura() == null) {
				throw new ZMessManager().new ForeignException("tipoInfraestructura");
			}

			if ((entity.getAbastecimiento() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getAbastecimiento(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("abastecimiento");
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

			if ((entity.getInfoAdicional() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional");
			}

			if ((entity.getInfoAdicional2() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional2(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional2");
			}

			if (entity.getInfraId() == null) {
				throw new ZMessManager().new EmptyFieldException("infraId");
			}

			if ((entity.getInfraId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getInfraId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("infraId");
			}

			if ((entity.getFoto() != null) && (Utilities.checkWordAndCheckWithlength(entity.getFoto(), 150) == false)) {
				throw new ZMessManager().new NotValidFormatException("foto");
			}

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			if (entity.getTipoInfraestructura().getTipoInfraId() == null) {
				throw new ZMessManager().new EmptyFieldException("tipoInfraId_TipoInfraestructura");
			}

			if ((entity.getTipoInfraestructura().getTipoInfraId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getTipoInfraestructura().getTipoInfraId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("tipoInfraId_TipoInfraestructura");
			}

			infraestructuraDAO.update(entity);

			if (data != null) {

				for (TarifaInfraestructuraDTO valor : data) {

					if (valor.getTarInfraId() == null) {

						TarifaInfraestructura tarifa = new TarifaInfraestructura();

						tarifa.setFechaInicial(valor.getFechaInicial());
						tarifa.setFechaFinal(valor.getFechaFinal());
						tarifa.setValor(valor.getValor());
						tarifa.setFechaCreacion(valor.getFechaModificacion());
						tarifa.setFechaModificacion(valor.getFechaModificacion());
						tarifa.setInfraestructura(entity);

						tarifaInfraestructuraDAO.save(tarifa);

					} else {

						TarifaInfraestructura tarifa = tarifaInfraestructuraDAO.findById(valor.getTarInfraId());

						tarifa.setFechaInicial(valor.getFechaInicial());
						tarifa.setFechaFinal(valor.getFechaFinal());
						tarifa.setValor(valor.getValor());
						tarifa.setFechaCreacion(valor.getFechaModificacion());
						tarifa.setFechaModificacion(valor.getFechaModificacion());
						tarifa.setInfraestructura(entity);

						tarifaInfraestructuraDAO.update(tarifa);

					}

				}

			}

			log.debug("update Infraestructura successful");
		} catch (Exception e) {
			log.error("update Infraestructura failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<InfraestructuraDTO> getDataInfraestructura() throws Exception {
		try {
			List<Infraestructura> infraestructura = infraestructuraDAO.findAll();

			List<InfraestructuraDTO> infraestructuraDTO = new ArrayList<InfraestructuraDTO>();

			for (Infraestructura infraestructuraTmp : infraestructura) {
				InfraestructuraDTO infraestructuraDTO2 = new InfraestructuraDTO();

				infraestructuraDTO2.setInfraId(infraestructuraTmp.getInfraId());
				infraestructuraDTO2.setAbastecimiento((infraestructuraTmp.getAbastecimiento() != null)
						? infraestructuraTmp.getAbastecimiento() : null);
				infraestructuraDTO2
						.setCodigo((infraestructuraTmp.getCodigo() != null) ? infraestructuraTmp.getCodigo() : null);
				infraestructuraDTO2.setCompania(
						(infraestructuraTmp.getCompania() != null) ? infraestructuraTmp.getCompania() : null);
				infraestructuraDTO2
						.setEstado((infraestructuraTmp.getEstado() != null) ? infraestructuraTmp.getEstado() : null);
				infraestructuraDTO2.setFechaCreacion(infraestructuraTmp.getFechaCreacion());
				infraestructuraDTO2.setFechaModificacion(infraestructuraTmp.getFechaModificacion());
				infraestructuraDTO2.setInfoAdicional(
						(infraestructuraTmp.getInfoAdicional() != null) ? infraestructuraTmp.getInfoAdicional() : null);
				infraestructuraDTO2.setInfoAdicional2((infraestructuraTmp.getInfoAdicional2() != null)
						? infraestructuraTmp.getInfoAdicional2() : null);
				infraestructuraDTO2
						.setLatitud((infraestructuraTmp.getLatitud() != null) ? infraestructuraTmp.getLatitud() : null);
				infraestructuraDTO2.setLongitud(
						(infraestructuraTmp.getLongitud() != null) ? infraestructuraTmp.getLongitud() : null);
				infraestructuraDTO2
						.setFoto((infraestructuraTmp.getFoto() != null && !infraestructuraTmp.getFoto().equals(""))
								? infraestructuraTmp.getFoto() : "default.jpg");
				infraestructuraDTO2
						.setNombre((infraestructuraTmp.getNombre() != null) ? infraestructuraTmp.getNombre() : null);
				infraestructuraDTO2.setPrecision(
						(infraestructuraTmp.getPrecision() != null) ? infraestructuraTmp.getPrecision() : null);
				infraestructuraDTO2.setTipoInfraId_TipoInfraestructura(
						(infraestructuraTmp.getTipoInfraestructura().getTipoInfraId() != null)
								? infraestructuraTmp.getTipoInfraestructura().getTipoInfraId() : null);
				infraestructuraDTO.add(infraestructuraDTO2);
			}

			return infraestructuraDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Infraestructura getInfraestructura(Long infraId) throws Exception {
		log.debug("getting Infraestructura instance");

		Infraestructura entity = null;

		try {
			entity = infraestructuraDAO.findById(infraId);
		} catch (Exception e) {
			log.error("get Infraestructura failed", e);
			throw new ZMessManager().new FindingException("Infraestructura");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Infraestructura> findPageInfraestructura(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<Infraestructura> entity = null;

		try {
			entity = infraestructuraDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Infraestructura Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberInfraestructura() throws Exception {
		Long entity = null;

		try {
			entity = infraestructuraDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Infraestructura Count");
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
	public List<Infraestructura> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<Infraestructura> list = new ArrayList<Infraestructura>();
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
			list = infraestructuraDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
