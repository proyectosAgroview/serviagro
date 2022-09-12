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

import co.com.arcosoft.dataaccess.dao.IDatTransProdNivel4DAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatTransProdNivel4;
import co.com.arcosoft.modelo.dto.DatTransProdNivel4DTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("DatTransProdNivel4Logic")
public class DatTransProdNivel4Logic implements IDatTransProdNivel4Logic {
	private static final Logger log = LoggerFactory.getLogger(DatTransProdNivel4Logic.class);

	/**
	 * DAO injected by Spring that manages DatTransProdNivel4 entities
	 *
	 */
	@Autowired
	private IDatTransProdNivel4DAO datTransProdNivel4DAO;

	/**
	 * Logic injected by Spring that manages DatTransProd entities
	 *
	 */
	@Autowired
	IDatTransProdLogic logicDatTransProd1;

	/**
	 * Logic injected by Spring that manages Nivel2 entities
	 *
	 */
	@Autowired
	INivel2Logic logicNivel22;

	/**
	 * Logic injected by Spring that manages Nivel4 entities
	 *
	 */
	@Autowired
	INivel4Logic logicNivel43;

	@Override
	@Transactional(readOnly = true)
	public List<DatTransProdNivel4> getDatTransProdNivel4() throws Exception {
		log.debug("finding all DatTransProdNivel4 instances");

		List<DatTransProdNivel4> list = new ArrayList<DatTransProdNivel4>();

		try {
			list = datTransProdNivel4DAO.findAll();
		} catch (Exception e) {
			log.error("finding all DatTransProdNivel4 failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "DatTransProdNivel4");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveDatTransProdNivel4(DatTransProdNivel4 entity) throws Exception {
		log.debug("saving DatTransProdNivel4 instance");

		try {
			if (entity.getDatTransProd() == null) {
				throw new ZMessManager().new ForeignException("datTransProd");
			}

			if (entity.getNivel2() == null) {
				throw new ZMessManager().new ForeignException("nivel2");
			}

			if (entity.getNivel4() == null) {
				throw new ZMessManager().new ForeignException("nivel4");
			}

			if ((entity.getCiclo() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCiclo(), 1, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("ciclo");
			}

			if (entity.getDatTransProdNivel4Id() == null) {
				throw new ZMessManager().new EmptyFieldException("datTransProdNivel4Id");
			}

			if ((entity.getDatTransProdNivel4Id() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getDatTransProdNivel4Id(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("datTransProdNivel4Id");
			}

			if ((entity.getEdadNivel4() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEdadNivel4(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("edadNivel4");
			}

			if ((entity.getEtapaNivel4() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEtapaNivel4(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("etapaNivel4");
			}

			if ((entity.getModalidadCosId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getModalidadCosId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("modalidadCosId");
			}

			if ((entity.getNivel1Id() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivel1Id(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivel1Id");
			}

			if ((entity.getNivel3Id() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivel3Id(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivel3Id");
			}

			if ((entity.getVariedNivel4() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariedNivel4(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("variedNivel4");
			}

			if (entity.getDatTransProd().getDatTransProdId() == null) {
				throw new ZMessManager().new EmptyFieldException("datTransProdId_DatTransProd");
			}

			if ((entity.getDatTransProd().getDatTransProdId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getDatTransProd().getDatTransProdId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("datTransProdId_DatTransProd");
			}

			if (entity.getNivel2().getNivel2Id() == null) {
				throw new ZMessManager().new EmptyFieldException("nivel2Id_Nivel2");
			}

			if ((entity.getNivel2().getNivel2Id() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivel2().getNivel2Id(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivel2Id_Nivel2");
			}

			if (entity.getNivel4().getNivel4Id() == null) {
				throw new ZMessManager().new EmptyFieldException("nivel4Id_Nivel4");
			}

			if ((entity.getNivel4().getNivel4Id() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivel4().getNivel4Id(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivel4Id_Nivel4");
			}

			if (getDatTransProdNivel4(entity.getDatTransProdNivel4Id()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			datTransProdNivel4DAO.save(entity);

			log.debug("save DatTransProdNivel4 successful");
		} catch (Exception e) {
			log.error("save DatTransProdNivel4 failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteDatTransProdNivel4(DatTransProdNivel4 entity) throws Exception {
		log.debug("deleting DatTransProdNivel4 instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("DatTransProdNivel4");
		}

		if (entity.getDatTransProdNivel4Id() == null) {
			throw new ZMessManager().new EmptyFieldException("datTransProdNivel4Id");
		}

		try {
			datTransProdNivel4DAO.delete(entity);

			log.debug("delete DatTransProdNivel4 successful");
		} catch (Exception e) {
			log.error("delete DatTransProdNivel4 failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateDatTransProdNivel4(DatTransProdNivel4 entity) throws Exception {
		log.debug("updating DatTransProdNivel4 instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("DatTransProdNivel4");
			}

			if (entity.getDatTransProd() == null) {
				throw new ZMessManager().new ForeignException("datTransProd");
			}

			if (entity.getNivel2() == null) {
				throw new ZMessManager().new ForeignException("nivel2");
			}

			if (entity.getNivel4() == null) {
				throw new ZMessManager().new ForeignException("nivel4");
			}

			if ((entity.getCiclo() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCiclo(), 1, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("ciclo");
			}

			if (entity.getDatTransProdNivel4Id() == null) {
				throw new ZMessManager().new EmptyFieldException("datTransProdNivel4Id");
			}

			if ((entity.getDatTransProdNivel4Id() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getDatTransProdNivel4Id(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("datTransProdNivel4Id");
			}

			if ((entity.getEdadNivel4() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEdadNivel4(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("edadNivel4");
			}

			if ((entity.getNivel3Id() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivel3Id(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivel3Id");
			}

			if (entity.getDatTransProd().getDatTransProdId() == null) {
				throw new ZMessManager().new EmptyFieldException("datTransProdId_DatTransProd");
			}

			if ((entity.getDatTransProd().getDatTransProdId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getDatTransProd().getDatTransProdId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("datTransProdId_DatTransProd");
			}

			if (entity.getNivel2().getNivel2Id() == null) {
				throw new ZMessManager().new EmptyFieldException("nivel2Id_Nivel2");
			}

			if (entity.getNivel4().getNivel4Id() == null) {
				throw new ZMessManager().new EmptyFieldException("nivel4Id_Nivel4");
			}

			datTransProdNivel4DAO.update(entity);

			log.debug("update DatTransProdNivel4 successful");
		} catch (Exception e) {
			log.error("update DatTransProdNivel4 failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatTransProdNivel4DTO> getDataDatTransProdNivel4() throws Exception {
		try {
			List<DatTransProdNivel4> datTransProdNivel4 = datTransProdNivel4DAO.findAll();

			List<DatTransProdNivel4DTO> datTransProdNivel4DTO = new ArrayList<DatTransProdNivel4DTO>();

			for (DatTransProdNivel4 datTransProdNivel4Tmp : datTransProdNivel4) {
				DatTransProdNivel4DTO datTransProdNivel4DTO2 = new DatTransProdNivel4DTO();

				datTransProdNivel4DTO2.setDatTransProdNivel4Id(datTransProdNivel4Tmp.getDatTransProdNivel4Id());
				datTransProdNivel4DTO2
						.setCiclo((datTransProdNivel4Tmp.getCiclo() != null) ? datTransProdNivel4Tmp.getCiclo() : null);
				datTransProdNivel4DTO2.setEdadNivel4(
						(datTransProdNivel4Tmp.getEdadNivel4() != null) ? datTransProdNivel4Tmp.getEdadNivel4() : null);
				datTransProdNivel4DTO2.setEtapaNivel4((datTransProdNivel4Tmp.getEtapaNivel4() != null)
						? datTransProdNivel4Tmp.getEtapaNivel4() : null);
				datTransProdNivel4DTO2.setModalidadCosId((datTransProdNivel4Tmp.getModalidadCosId() != null)
						? datTransProdNivel4Tmp.getModalidadCosId() : null);
				datTransProdNivel4DTO2.setNivel1Id(
						(datTransProdNivel4Tmp.getNivel1Id() != null) ? datTransProdNivel4Tmp.getNivel1Id() : null);
				datTransProdNivel4DTO2.setNivel3Id(
						(datTransProdNivel4Tmp.getNivel3Id() != null) ? datTransProdNivel4Tmp.getNivel3Id() : null);
				datTransProdNivel4DTO2.setVariedNivel4((datTransProdNivel4Tmp.getVariedNivel4() != null)
						? datTransProdNivel4Tmp.getVariedNivel4() : null);
				datTransProdNivel4DTO2.setDatTransProdId_DatTransProd(
						(datTransProdNivel4Tmp.getDatTransProd().getDatTransProdId() != null)
								? datTransProdNivel4Tmp.getDatTransProd().getDatTransProdId() : null);

				if (datTransProdNivel4Tmp.getNivel2() != null) {
					datTransProdNivel4DTO2.setNivel2Id_Nivel2(datTransProdNivel4Tmp.getNivel2());
				} else {
					datTransProdNivel4DTO2.setNivel2Id_Nivel2(null);
				}

				if (datTransProdNivel4Tmp.getNivel4() != null) {
					datTransProdNivel4DTO2.setNivel4Id_Nivel4(datTransProdNivel4Tmp.getNivel4());
				} else {
					datTransProdNivel4DTO2.setNivel4Id_Nivel4(null);
				}
				
				datTransProdNivel4DTO2.setPesoPromedio((datTransProdNivel4Tmp.getPesoPromedio() != null)
						? datTransProdNivel4Tmp.getPesoPromedio() : null);
				datTransProdNivel4DTO2.setCantidadRacimos((datTransProdNivel4Tmp.getCantidadRacimos() != null)
						? datTransProdNivel4Tmp.getCantidadRacimos() : null);
				
				datTransProdNivel4DTO2.setValorUnitario((datTransProdNivel4Tmp.getValorUnitario() != null)
						? datTransProdNivel4Tmp.getValorUnitario() : null);
				
				datTransProdNivel4DTO2.setIngresoBruto((datTransProdNivel4Tmp.getIngresoBruto() != null)
						? datTransProdNivel4Tmp.getIngresoBruto() : null);
				
				datTransProdNivel4DTO2.setKilogramosAzucarTonelada((datTransProdNivel4Tmp.getKilogramosAzucarTonelada() != null)
						? datTransProdNivel4Tmp.getKilogramosAzucarTonelada() : null);
				
				datTransProdNivel4DTO2.setValorKilogramosAzucar((datTransProdNivel4Tmp.getValorKilogramosAzucar() != null)
						? datTransProdNivel4Tmp.getValorKilogramosAzucar() : null);
				
				
				datTransProdNivel4DTO2.setAjusteLiquidacion((datTransProdNivel4Tmp.getAjusteLiquidacion() != null)
						? datTransProdNivel4Tmp.getAjusteLiquidacion() : null);
				
				datTransProdNivel4DTO2.setBonificacion((datTransProdNivel4Tmp.getBonificacion() != null)
						? datTransProdNivel4Tmp.getBonificacion() : null);
				
				datTransProdNivel4DTO2.setOtrosIngresos((datTransProdNivel4Tmp.getOtrosIngresos() != null)
						? datTransProdNivel4Tmp.getOtrosIngresos() : null);
				
				datTransProdNivel4DTO2.setRetenciones((datTransProdNivel4Tmp.getRetenciones() != null)
						? datTransProdNivel4Tmp.getRetenciones() : null);
				
				datTransProdNivel4DTO2.setDescuentos((datTransProdNivel4Tmp.getDescuentos() != null)
						? datTransProdNivel4Tmp.getDescuentos() : null);

				datTransProdNivel4DTO.add(datTransProdNivel4DTO2);
			}

			return datTransProdNivel4DTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public DatTransProdNivel4 getDatTransProdNivel4(Long datTransProdNivel4Id) throws Exception {
		log.debug("getting DatTransProdNivel4 instance");

		DatTransProdNivel4 entity = null;

		try {
			entity = datTransProdNivel4DAO.findById(datTransProdNivel4Id);
		} catch (Exception e) {
			log.error("get DatTransProdNivel4 failed", e);
			throw new ZMessManager().new FindingException("DatTransProdNivel4");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatTransProdNivel4> findPageDatTransProdNivel4(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		List<DatTransProdNivel4> entity = null;

		try {
			entity = datTransProdNivel4DAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatTransProdNivel4 Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberDatTransProdNivel4() throws Exception {
		Long entity = null;

		try {
			entity = datTransProdNivel4DAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatTransProdNivel4 Count");
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
	public List<DatTransProdNivel4> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<DatTransProdNivel4> list = new ArrayList<DatTransProdNivel4>();
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
			list = datTransProdNivel4DAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatTransProdNivel4DTO> getDataDatTransProdNivel4ByNivel4Id(Long datTransProdId) throws Exception {
		try {

			List<DatTransProdNivel4> datTransProdNivel4 = datTransProdNivel4DAO
					.findByCriteria("datTransProd.datTransProdId= " + datTransProdId);

			List<DatTransProdNivel4DTO> datTransProdNivel4DTO = new ArrayList<DatTransProdNivel4DTO>();

			for (DatTransProdNivel4 datTransProdNivel4Tmp : datTransProdNivel4) {
				DatTransProdNivel4DTO datTransProdNivel4DTO2 = new DatTransProdNivel4DTO();

				datTransProdNivel4DTO2.setDatTransProdNivel4Id(datTransProdNivel4Tmp.getDatTransProdNivel4Id());
				datTransProdNivel4DTO2
						.setCiclo((datTransProdNivel4Tmp.getCiclo() != null) ? datTransProdNivel4Tmp.getCiclo() : null);
				datTransProdNivel4DTO2.setEdadNivel4(
						(datTransProdNivel4Tmp.getEdadNivel4() != null) ? datTransProdNivel4Tmp.getEdadNivel4() : null);
				datTransProdNivel4DTO2.setModalidadCosId((datTransProdNivel4Tmp.getModalidadCosId() != null)
						? datTransProdNivel4Tmp.getModalidadCosId() : null);
				datTransProdNivel4DTO2.setNivel1Id(
						(datTransProdNivel4Tmp.getNivel1Id() != null) ? datTransProdNivel4Tmp.getNivel1Id() : null);
				datTransProdNivel4DTO2.setNivel3Id(
						(datTransProdNivel4Tmp.getNivel3Id() != null) ? datTransProdNivel4Tmp.getNivel3Id() : null);

				datTransProdNivel4DTO2.setDatTransProdId_DatTransProd(
						(datTransProdNivel4Tmp.getDatTransProd().getDatTransProdId() != null)
								? datTransProdNivel4Tmp.getDatTransProd().getDatTransProdId() : null);

				if (datTransProdNivel4Tmp.getNivel2() != null) {
					datTransProdNivel4DTO2.setNivel2Id_Nivel2(datTransProdNivel4Tmp.getNivel2());
				} else {
					datTransProdNivel4DTO2.setNivel2Id_Nivel2(null);
				}

				if (datTransProdNivel4Tmp.getNivel2() != null) {
					datTransProdNivel4DTO2.setNombreNivel2(datTransProdNivel4Tmp.getNivel2().getNombre());
				} else {
					datTransProdNivel4DTO2.setNombreNivel2(null);
				}

				if (datTransProdNivel4Tmp.getNivel4() != null) {
					datTransProdNivel4DTO2.setNivel4Id_Nivel4(datTransProdNivel4Tmp.getNivel4());
				} else {
					datTransProdNivel4DTO2.setNivel4Id_Nivel4(null);
				}

				if (datTransProdNivel4Tmp.getNivel4() != null) {
					datTransProdNivel4DTO2.setCodigoNivel4(datTransProdNivel4Tmp.getNivel4().getCodigo());
				} else {
					datTransProdNivel4DTO2.setCodigoNivel4(null);
				}

				if (datTransProdNivel4Tmp.getNivel4() != null) {
					datTransProdNivel4DTO2.setNombreNivel4(datTransProdNivel4Tmp.getNivel4().getNombre());
				} else {
					datTransProdNivel4DTO2.setNombreNivel4(null);
				}

				datTransProdNivel4DTO2.setAreaCosechada((datTransProdNivel4Tmp.getAreaCosechada() != null)
						? datTransProdNivel4Tmp.getAreaCosechada() : null);

				datTransProdNivel4DTO2.setFinCosecha(
						(datTransProdNivel4Tmp.getFinCosecha() != null) ? datTransProdNivel4Tmp.getFinCosecha() : null);

				if (datTransProdNivel4Tmp.getEtapaNivel4() != null) {
					datTransProdNivel4DTO2.setEtapaNivel4(datTransProdNivel4Tmp.getEtapaNivel4());
				} else {
					datTransProdNivel4DTO2.setEtapaNivel4(null);
				}

				if (datTransProdNivel4Tmp.getEtapaNivel4() != null) {
					datTransProdNivel4DTO2.setNombreEtapa(datTransProdNivel4Tmp.getEtapaNivel4().getNombre());
				} else {
					datTransProdNivel4DTO2.setNombreEtapa(null);
				}

				if (datTransProdNivel4Tmp.getVariedNivel4() != null) {
					datTransProdNivel4DTO2.setVariedNivel4(datTransProdNivel4Tmp.getVariedNivel4());
				} else {
					datTransProdNivel4DTO2.setVariedNivel4(null);
				}

				if (datTransProdNivel4Tmp.getVariedNivel4() != null) {
					datTransProdNivel4DTO2.setNombreVariedad(datTransProdNivel4Tmp.getVariedNivel4().getNombre());
				} else {
					datTransProdNivel4DTO2.setNombreVariedad(null);
				}

				datTransProdNivel4DTO2.setCantidadCosechada((datTransProdNivel4Tmp.getCantidadCosechada() != null)
						? datTransProdNivel4Tmp.getCantidadCosechada() : null);
				datTransProdNivel4DTO2.setCantidadCosechadaHa((datTransProdNivel4Tmp.getCantidadCosechadaHa() != null)
						? datTransProdNivel4Tmp.getCantidadCosechadaHa() : null);
				datTransProdNivel4DTO2.setPorcRendimiento((datTransProdNivel4Tmp.getPorcRendimiento() != null)
						? datTransProdNivel4Tmp.getPorcRendimiento() : null);

				datTransProdNivel4DTO2.setPorcMateriaExtrana((datTransProdNivel4Tmp.getPorcMateriaExtrana() != null)
						? datTransProdNivel4Tmp.getPorcMateriaExtrana() : null);
				datTransProdNivel4DTO2.setPorcSacarosa((datTransProdNivel4Tmp.getPorcSacarosa() != null)
						? datTransProdNivel4Tmp.getPorcSacarosa() : null);
				datTransProdNivel4DTO2.setKilosPorTonelada((datTransProdNivel4Tmp.getKilosPorTonelada() != null)
						? datTransProdNivel4Tmp.getKilosPorTonelada() : null);

				datTransProdNivel4DTO2.setFechaFinCosecha((datTransProdNivel4Tmp.getFechaFinCosecha() != null)
						? datTransProdNivel4Tmp.getFechaFinCosecha() : null);

				datTransProdNivel4DTO2.setFechaInicioCosecha((datTransProdNivel4Tmp.getFechaInicioCosecha() != null)
						? datTransProdNivel4Tmp.getFechaInicioCosecha() : null);
				
				if (datTransProdNivel4Tmp.getProducto() != null) {
					datTransProdNivel4DTO2.setNombreProducto(datTransProdNivel4Tmp.getProducto().getNombre());
				} else {
					datTransProdNivel4DTO2.setNombreProducto(null);
				}
				
				if (datTransProdNivel4Tmp.getVagonId() != null) {
					datTransProdNivel4DTO2.setNombreVagon(datTransProdNivel4Tmp.getVagonId().getCodigo());
				} else {
					datTransProdNivel4DTO2.setNombreVagon(null);
				}
				
				if (datTransProdNivel4Tmp.getVagonId() != null) {
					datTransProdNivel4DTO2.setVagonId(datTransProdNivel4Tmp.getVagonId());
				} else {
					datTransProdNivel4DTO2.setVagonId(null);
				}

				if (datTransProdNivel4Tmp.getClienteId() != null) {
					datTransProdNivel4DTO2.setClienteId(datTransProdNivel4Tmp.getClienteId());
				} else {
					datTransProdNivel4DTO2.setClienteId(null);
				}
				
				if (datTransProdNivel4Tmp.getProducto() != null) {
					datTransProdNivel4DTO2.setProducto(datTransProdNivel4Tmp.getProducto());
				} else {
					datTransProdNivel4DTO2.setProducto(null);
				}
				
				if (datTransProdNivel4Tmp.getClienteId() != null) {
					datTransProdNivel4DTO2.setNomClienteId(datTransProdNivel4Tmp.getClienteId().getNombre());
				} else {
					datTransProdNivel4DTO2.setClienteId(null);
				}
				datTransProdNivel4DTO2.setNumeroViajes((datTransProdNivel4Tmp.getNumeroViajes() != null)
						? datTransProdNivel4Tmp.getNumeroViajes() : null);

				datTransProdNivel4DTO2.setCantidadCosechadaHaMes((datTransProdNivel4Tmp.getCantidadCosechadaHaMes() != null)
						? datTransProdNivel4Tmp.getCantidadCosechadaHaMes() : null);
				datTransProdNivel4DTO2.setTonAzucarHaMes((datTransProdNivel4Tmp.getTonAzucarHaMes() != null)
						? datTransProdNivel4Tmp.getTonAzucarHaMes() : null);
				
				datTransProdNivel4DTO2.setPesoPromedio((datTransProdNivel4Tmp.getPesoPromedio() != null)
						? datTransProdNivel4Tmp.getPesoPromedio() : null);
				
				datTransProdNivel4DTO2.setCantidadRacimos((datTransProdNivel4Tmp.getCantidadRacimos() != null)
						? datTransProdNivel4Tmp.getCantidadRacimos() : null);
				
				datTransProdNivel4DTO2.setValorUnitario((datTransProdNivel4Tmp.getValorUnitario() != null)
						? datTransProdNivel4Tmp.getValorUnitario() : null);
				
				datTransProdNivel4DTO2.setIngresoBruto((datTransProdNivel4Tmp.getIngresoBruto() != null)
						? datTransProdNivel4Tmp.getIngresoBruto() : null);
				
				datTransProdNivel4DTO2.setKilogramosAzucarTonelada((datTransProdNivel4Tmp.getKilogramosAzucarTonelada() != null)
						? datTransProdNivel4Tmp.getKilogramosAzucarTonelada() : null);
				
				datTransProdNivel4DTO2.setValorKilogramosAzucar((datTransProdNivel4Tmp.getValorKilogramosAzucar() != null)
						? datTransProdNivel4Tmp.getValorKilogramosAzucar() : null);
				
				
				datTransProdNivel4DTO2.setAjusteLiquidacion((datTransProdNivel4Tmp.getAjusteLiquidacion() != null)
						? datTransProdNivel4Tmp.getAjusteLiquidacion() : null);
				
				datTransProdNivel4DTO2.setBonificacion((datTransProdNivel4Tmp.getBonificacion() != null)
						? datTransProdNivel4Tmp.getBonificacion() : null);
				
				datTransProdNivel4DTO2.setOtrosIngresos((datTransProdNivel4Tmp.getOtrosIngresos() != null)
						? datTransProdNivel4Tmp.getOtrosIngresos() : null);
				
				datTransProdNivel4DTO2.setRetenciones((datTransProdNivel4Tmp.getRetenciones() != null)
						? datTransProdNivel4Tmp.getRetenciones() : null);
				
				datTransProdNivel4DTO2.setDescuentos((datTransProdNivel4Tmp.getDescuentos() != null)
						? datTransProdNivel4Tmp.getDescuentos() : null);
				
				datTransProdNivel4DTO2.setFondoAgroIndustriaPorcentaje((datTransProdNivel4Tmp.getFondoAgroIndustriaPorcentaje() != null) ? datTransProdNivel4Tmp.getFondoAgroIndustriaPorcentaje() : null);
				datTransProdNivel4DTO2.setDescuentoAdicional1Porcentaje((datTransProdNivel4Tmp.getDescuentoAdicional1Porcentaje() != null) ? datTransProdNivel4Tmp.getDescuentoAdicional1Porcentaje() : null);
				datTransProdNivel4DTO2.setDescuentoAdicional2Porcentaje((datTransProdNivel4Tmp.getDescuentoAdicional2Porcentaje() != null) ? datTransProdNivel4Tmp.getDescuentoAdicional2Porcentaje() : null);
				
				datTransProdNivel4DTO2.setEstadoRegistro((datTransProdNivel4Tmp.getEstadoRegistro() != null) ? datTransProdNivel4Tmp.getEstadoRegistro() : null);
				
				datTransProdNivel4DTO.add(datTransProdNivel4DTO2);
			}

			return datTransProdNivel4DTO;
		} catch (Exception e) {
			throw e;
		}
	}

}
