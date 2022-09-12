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

import co.com.arcosoft.dataaccess.dao.IDatTransProdDAO;
import co.com.arcosoft.dataaccess.dao.IVehiculosTranspDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatTransProd;
import co.com.arcosoft.modelo.VehiculosTransp;
import co.com.arcosoft.modelo.dto.VehiculosTranspDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("VehiculosTranspLogic")
public class VehiculosTranspLogic implements IVehiculosTranspLogic {
	private static final Logger log = LoggerFactory.getLogger(VehiculosTranspLogic.class);

	/**
	 * DAO injected by Spring that manages VehiculosTransp entities
	 *
	 */
	@Autowired
	private IVehiculosTranspDAO vehiculosTranspDAO;

	/**
	 * DAO injected by Spring that manages DatTransProd entities
	 *
	 */
	@Autowired
	private IDatTransProdDAO datTransProdDAO;

	/**
	 * Logic injected by Spring that manages Conductor entities
	 *
	 */
	@Autowired
	IConductorLogic logicConductor1;

	/**
	 * Logic injected by Spring that manages FabricanteEquipo entities
	 *
	 */
	@Autowired
	IFabricanteEquipoLogic logicFabricanteEquipo2;

	/**
	 * Logic injected by Spring that manages NumeroEje entities
	 *
	 */
	@Autowired
	INumeroEjeLogic logicNumeroEje3;

	/**
	 * Logic injected by Spring that manages Transportadora entities
	 *
	 */
	@Autowired
	ITransportadoraLogic logicTransportadora4;

	@Override
	@Transactional(readOnly = true)
	public List<VehiculosTransp> getVehiculosTransp() throws Exception {
		log.debug("finding all VehiculosTransp instances");

		List<VehiculosTransp> list = new ArrayList<VehiculosTransp>();

		try {
			list = vehiculosTranspDAO.findAll();
		} catch (Exception e) {
			log.error("finding all VehiculosTransp failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "VehiculosTransp");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveVehiculosTransp(VehiculosTransp entity) throws Exception {
		log.debug("saving VehiculosTransp instance");

		try {
			if (entity.getConductor() == null) {
				throw new ZMessManager().new ForeignException("conductor");
			}

			if (entity.getFabricanteEquipo() == null) {
				throw new ZMessManager().new ForeignException("fabricanteEquipo");
			}

			if (entity.getNumeroEje() == null) {
				throw new ZMessManager().new ForeignException("numeroEje");
			}

			if (entity.getTransportadora() == null) {
				throw new ZMessManager().new ForeignException("transportadora");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getColor() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getColor(), 30) == false)) {
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

			if ((entity.getPlaca() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getPlaca(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("placa");
			}

			if (entity.getConductor().getConductorId() == null) {
				throw new ZMessManager().new EmptyFieldException("conductorId_Conductor");
			}

			if ((entity.getConductor().getConductorId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getConductor().getConductorId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("conductorId_Conductor");
			}

			if (entity.getFabricanteEquipo().getFabricEquipId() == null) {
				throw new ZMessManager().new EmptyFieldException("fabricEquipId_FabricanteEquipo");
			}

			if ((entity.getFabricanteEquipo().getFabricEquipId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getFabricanteEquipo().getFabricEquipId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("fabricEquipId_FabricanteEquipo");
			}

			if (entity.getNumeroEje().getNumEjeId() == null) {
				throw new ZMessManager().new EmptyFieldException("numEjeId_NumeroEje");
			}

			if ((entity.getNumeroEje().getNumEjeId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumeroEje().getNumEjeId(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("numEjeId_NumeroEje");
			}

			if (entity.getTransportadora().getTranspId() == null) {
				throw new ZMessManager().new EmptyFieldException("transpId_Transportadora");
			}

			if ((entity.getTransportadora().getTranspId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getTransportadora().getTranspId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("transpId_Transportadora");
			}

			/*
			 * if (entity.getVehiTranspId() == null) { throw new
			 * ZMessManager().new EmptyFieldException("vehiTranspId"); }
			 * 
			 * if ((entity.getVehiTranspId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getVehiTranspId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "vehiTranspId"); } if
			 * (getVehiculosTransp(entity.getVehiTranspId()) != null) { throw
			 * new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */

			vehiculosTranspDAO.save(entity);

			log.debug("save VehiculosTransp successful");
		} catch (Exception e) {
			log.error("save VehiculosTransp failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteVehiculosTransp(VehiculosTransp entity) throws Exception {
		log.debug("deleting VehiculosTransp instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("VehiculosTransp");
		}

		if (entity.getVehiTranspId() == null) {
			throw new ZMessManager().new EmptyFieldException("vehiTranspId");
		}

		List<DatTransProd> datTransProds = null;

		try {
			datTransProds = datTransProdDAO.findByProperty("vehiculosTransp.vehiTranspId", entity.getVehiTranspId());

			if (Utilities.validationsList(datTransProds) == true) {
				throw new ZMessManager().new DeletingException("datTransProds");
			}

			vehiculosTranspDAO.delete(entity);

			log.debug("delete VehiculosTransp successful");
		} catch (Exception e) {
			log.error("delete VehiculosTransp failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateVehiculosTransp(VehiculosTransp entity) throws Exception {
		log.debug("updating VehiculosTransp instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("VehiculosTransp");
			}

			if (entity.getConductor() == null) {
				throw new ZMessManager().new ForeignException("conductor");
			}

			if (entity.getFabricanteEquipo() == null) {
				throw new ZMessManager().new ForeignException("fabricanteEquipo");
			}

			if (entity.getNumeroEje() == null) {
				throw new ZMessManager().new ForeignException("numeroEje");
			}

			if (entity.getTransportadora() == null) {
				throw new ZMessManager().new ForeignException("transportadora");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getColor() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getColor(), 30) == false)) {
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

			if ((entity.getPlaca() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getPlaca(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("placa");
			}

			if (entity.getVehiTranspId() == null) {
				throw new ZMessManager().new EmptyFieldException("vehiTranspId");
			}

			if ((entity.getVehiTranspId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVehiTranspId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("vehiTranspId");
			}

			if (entity.getConductor().getConductorId() == null) {
				throw new ZMessManager().new EmptyFieldException("conductorId_Conductor");
			}

			if ((entity.getConductor().getConductorId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getConductor().getConductorId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("conductorId_Conductor");
			}

			if (entity.getFabricanteEquipo().getFabricEquipId() == null) {
				throw new ZMessManager().new EmptyFieldException("fabricEquipId_FabricanteEquipo");
			}

			if ((entity.getFabricanteEquipo().getFabricEquipId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getFabricanteEquipo().getFabricEquipId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("fabricEquipId_FabricanteEquipo");
			}

			if (entity.getNumeroEje().getNumEjeId() == null) {
				throw new ZMessManager().new EmptyFieldException("numEjeId_NumeroEje");
			}

			if ((entity.getNumeroEje().getNumEjeId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumeroEje().getNumEjeId(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("numEjeId_NumeroEje");
			}

			if (entity.getTransportadora().getTranspId() == null) {
				throw new ZMessManager().new EmptyFieldException("transpId_Transportadora");
			}

			if ((entity.getTransportadora().getTranspId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getTransportadora().getTranspId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("transpId_Transportadora");
			}

			vehiculosTranspDAO.update(entity);

			log.debug("update VehiculosTransp successful");
		} catch (Exception e) {
			log.error("update VehiculosTransp failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<VehiculosTranspDTO> getDataVehiculosTransp() throws Exception {
		try {
			List<VehiculosTransp> vehiculosTransp = vehiculosTranspDAO.findAll();

			List<VehiculosTranspDTO> vehiculosTranspDTO = new ArrayList<VehiculosTranspDTO>();

			for (VehiculosTransp vehiculosTranspTmp : vehiculosTransp) {
				VehiculosTranspDTO vehiculosTranspDTO2 = new VehiculosTranspDTO();

				vehiculosTranspDTO2.setVehiTranspId(vehiculosTranspTmp.getVehiTranspId());
				vehiculosTranspDTO2
						.setCodigo((vehiculosTranspTmp.getCodigo() != null) ? vehiculosTranspTmp.getCodigo() : null);
				vehiculosTranspDTO2
						.setColor((vehiculosTranspTmp.getColor() != null) ? vehiculosTranspTmp.getColor() : null);
				vehiculosTranspDTO2.setCompania(
						(vehiculosTranspTmp.getCompania() != null) ? vehiculosTranspTmp.getCompania() : null);
				vehiculosTranspDTO2
						.setEstado((vehiculosTranspTmp.getEstado() != null) ? vehiculosTranspTmp.getEstado() : null);
				vehiculosTranspDTO2.setFechaCreacion(vehiculosTranspTmp.getFechaCreacion());
				vehiculosTranspDTO2.setFechaModificacion(vehiculosTranspTmp.getFechaModificacion());
				vehiculosTranspDTO2
						.setFoto((vehiculosTranspTmp.getFoto() != null && !vehiculosTranspTmp.getFoto().equals(""))
								? vehiculosTranspTmp.getFoto() : "default.jpg");
				vehiculosTranspDTO2.setInfoAdicional(
						(vehiculosTranspTmp.getInfoAdicional() != null) ? vehiculosTranspTmp.getInfoAdicional() : null);
				vehiculosTranspDTO2.setInfoAdicional2((vehiculosTranspTmp.getInfoAdicional2() != null)
						? vehiculosTranspTmp.getInfoAdicional2() : null);
				vehiculosTranspDTO2
						.setNombre((vehiculosTranspTmp.getNombre() != null) ? vehiculosTranspTmp.getNombre() : null);
				vehiculosTranspDTO2
						.setPlaca((vehiculosTranspTmp.getPlaca() != null) ? vehiculosTranspTmp.getPlaca() : null);

				if (vehiculosTranspTmp.getConductor() != null) {
					vehiculosTranspDTO2.setConductorId_Conductor(vehiculosTranspTmp.getConductor().getConductorId());
				} else {
					vehiculosTranspDTO2.setConductorId_Conductor(null);
				}

				vehiculosTranspDTO2.setFabricEquipId_FabricanteEquipo(
						(vehiculosTranspTmp.getFabricanteEquipo().getFabricEquipId() != null)
								? vehiculosTranspTmp.getFabricanteEquipo().getFabricEquipId() : null);
				vehiculosTranspDTO2.setNumEjeId_NumeroEje((vehiculosTranspTmp.getNumeroEje().getNumEjeId() != null)
						? vehiculosTranspTmp.getNumeroEje().getNumEjeId() : null);

				if (vehiculosTranspTmp.getTransportadora() != null) {
					vehiculosTranspDTO2
							.setTranspId_Transportadora(vehiculosTranspTmp.getTransportadora().getTranspId());
				} else {
					vehiculosTranspDTO2.setTranspId_Transportadora(null);
				}

				vehiculosTranspDTO.add(vehiculosTranspDTO2);
			}

			return vehiculosTranspDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public VehiculosTransp getVehiculosTransp(Long vehiTranspId) throws Exception {
		log.debug("getting VehiculosTransp instance");

		VehiculosTransp entity = null;

		try {
			entity = vehiculosTranspDAO.findById(vehiTranspId);
		} catch (Exception e) {
			log.error("get VehiculosTransp failed", e);
			throw new ZMessManager().new FindingException("VehiculosTransp");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<VehiculosTransp> findPageVehiculosTransp(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<VehiculosTransp> entity = null;

		try {
			entity = vehiculosTranspDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("VehiculosTransp Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberVehiculosTransp() throws Exception {
		Long entity = null;

		try {
			entity = vehiculosTranspDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("VehiculosTransp Count");
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
	public List<VehiculosTransp> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<VehiculosTransp> list = new ArrayList<VehiculosTransp>();
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
			list = vehiculosTranspDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
