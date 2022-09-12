package co.com.arcosoft.modelo.control;

import co.com.arcosoft.dataaccess.dao.*;
import co.com.arcosoft.exceptions.*;
import co.com.arcosoft.modelo.*;
import co.com.arcosoft.modelo.dto.DatAnaLaboratorioDetDTO;
import co.com.arcosoft.modelo.informes.dto.ListaVariablesAnaLaboratorioDTO;
import co.com.arcosoft.modelo.dto.DatAnaLaboratorioDTO;
import co.com.arcosoft.modelo.dto.DatAnaLaboratorioDetDTO;
import co.com.arcosoft.utilities.Utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("DatAnaLaboratorioLogic")
public class DatAnaLaboratorioLogic implements IDatAnaLaboratorioLogic {
	private static final Logger log = LoggerFactory.getLogger(DatAnaLaboratorioLogic.class);

	/**
	 * DAO injected by Spring that manages DatAnaLaboratorio entities
	 *
	 */
	@Autowired
	private IDatAnaLaboratorioDAO datAnaLaboratorioDAO;

	/**
	 * DAO injected by Spring that manages DatAnaLaboratorioDet entities
	 *
	 */
	@Autowired
	private IDatAnaLaboratorioDetDAO datAnaLaboratorioDetDAO;

	/**
	 * Logic injected by Spring that manages AnaLaboratorio entities
	 *
	 */
	@Autowired
	IAnaLaboratorioLogic logicAnaLaboratorio1;

	@Autowired
	IVariableLabLogic logicVariableLab;

	@Transactional(readOnly = true)
	public List<DatAnaLaboratorio> getDatAnaLaboratorio() throws Exception {
		log.debug("finding all DatAnaLaboratorio instances");

		List<DatAnaLaboratorio> list = new ArrayList<DatAnaLaboratorio>();

		try {
			list = datAnaLaboratorioDAO.findAll();
		} catch (Exception e) {
			log.error("finding all DatAnaLaboratorio failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "DatAnaLaboratorio");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveDatAnaLaboratorio(DatAnaLaboratorio entity,
			List<ListaVariablesAnaLaboratorioDTO> dataAnalisisLabDet) throws Exception {
		log.debug("saving DatAnaLaboratorio instance");

		try {
			if (entity.getAnaLaboratorio() == null) {
				throw new ZMessManager().new ForeignException("anaLaboratorio");
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

			if ((entity.getMobileId() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getMobileId(), 23) == false)) {
				throw new ZMessManager().new NotValidFormatException("mobileId");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacion(), 1000) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacion");
			}

			if ((entity.getObservacionAnularReg() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacionAnularReg(), 500) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacionAnularReg");
			}

			if (entity.getAnaLaboratorio().getAnaLabId() == null) {
				throw new ZMessManager().new EmptyFieldException("anaLabId_AnaLaboratorio");
			}

			datAnaLaboratorioDAO.save(entity);

			if (dataAnalisisLabDet != null) {

				for (ListaVariablesAnaLaboratorioDTO valorDto : dataAnalisisLabDet) {

					DatAnaLaboratorioDet valor = new DatAnaLaboratorioDet();
					VariableLab variableLab = logicVariableLab.getVariableLab(valorDto.getIdVariable().longValue());
					valor.setVariableLab(variableLab);

					valor.setValorVariable(valorDto.getValorVariableDia().doubleValue());
					valor.setHora0000(valorDto.getValorVariableHora0().doubleValue());
					valor.setHora0100(valorDto.getValorVariableHora1().doubleValue());
					valor.setHora0200(valorDto.getValorVariableHora2().doubleValue());
					valor.setHora0300(valorDto.getValorVariableHora3().doubleValue());
					valor.setHora0400(valorDto.getValorVariableHora4().doubleValue());
					valor.setHora0500(valorDto.getValorVariableHora5().doubleValue());
					valor.setHora0600(valorDto.getValorVariableHora6().doubleValue());
					valor.setHora0700(valorDto.getValorVariableHora7().doubleValue());
					valor.setHora0800(valorDto.getValorVariableHora8().doubleValue());
					valor.setHora0900(valorDto.getValorVariableHora9().doubleValue());
					valor.setHora1000(valorDto.getValorVariableHora10().doubleValue());
					valor.setHora1100(valorDto.getValorVariableHora11().doubleValue());
					valor.setHora1200(valorDto.getValorVariableHora12().doubleValue());
					valor.setHora1300(valorDto.getValorVariableHora13().doubleValue());
					valor.setHora1400(valorDto.getValorVariableHora14().doubleValue());
					valor.setHora1500(valorDto.getValorVariableHora15().doubleValue());
					valor.setHora1600(valorDto.getValorVariableHora16().doubleValue());
					valor.setHora1700(valorDto.getValorVariableHora17().doubleValue());
					valor.setHora1800(valorDto.getValorVariableHora18().doubleValue());
					valor.setHora1900(valorDto.getValorVariableHora19().doubleValue());
					valor.setHora2000(valorDto.getValorVariableHora20().doubleValue());
					valor.setHora2100(valorDto.getValorVariableHora21().doubleValue());
					valor.setHora2200(valorDto.getValorVariableHora22().doubleValue());
					valor.setHora2300(valorDto.getValorVariableHora23().doubleValue());
					valor.setDatAnaLaboratorio(entity);

					datAnaLaboratorioDetDAO.save(valor);

				}
			}

			log.debug("save DatAnaLaboratorio successful");
		} catch (Exception e) {
			log.error("save DatAnaLaboratorio failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteDatAnaLaboratorio(DatAnaLaboratorio entity) throws Exception {
		log.debug("deleting DatAnaLaboratorio instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("DatAnaLaboratorio");
		}

		if (entity.getDatAnaLabId() == null) {
			throw new ZMessManager().new EmptyFieldException("datAnaLabId");
		}

		List<DatAnaLaboratorioDet> datAnaLaboratorioDets = null;

		try {
			datAnaLaboratorioDets = datAnaLaboratorioDetDAO.findByProperty("datAnaLaboratorio.datAnaLabId",
					entity.getDatAnaLabId());

			if (Utilities.validationsList(datAnaLaboratorioDets) == true) {
				throw new ZMessManager().new DeletingException("datAnaLaboratorioDets");
			}

			datAnaLaboratorioDAO.delete(entity);

			log.debug("delete DatAnaLaboratorio successful");
		} catch (Exception e) {
			log.error("delete DatAnaLaboratorio failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateDatAnaLaboratorio(DatAnaLaboratorio entity, List<DatAnaLaboratorioDetDTO> dataAnalisisLabDet,
			List<ListaVariablesAnaLaboratorioDTO> dataVariables) throws Exception {
		log.debug("updating DatAnaLaboratorio instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("DatAnaLaboratorio");
			}

			if (entity.getAnaLaboratorio() == null) {
				throw new ZMessManager().new ForeignException("anaLaboratorio");
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

			if ((entity.getMobileId() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getMobileId(), 23) == false)) {
				throw new ZMessManager().new NotValidFormatException("mobileId");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacion(), 1000) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacion");
			}

			if ((entity.getObservacionAnularReg() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacionAnularReg(), 500) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacionAnularReg");
			}

			if (entity.getAnaLaboratorio().getAnaLabId() == null) {
				throw new ZMessManager().new EmptyFieldException("anaLabId_AnaLaboratorio");
			}

			datAnaLaboratorioDAO.update(entity);
			
			//if (dataVariables != null && dataAnalisisLabDet != null) {

			if (dataVariables != null) {

				for (ListaVariablesAnaLaboratorioDTO valorDto : dataVariables) {

					List<DatAnaLaboratorioDet> datAnaLaboratorioDet = datAnaLaboratorioDetDAO
							.findByCriteria("variableLab.variableLabId = " + valorDto.getIdVariable().intValue());

					if (datAnaLaboratorioDet != null && datAnaLaboratorioDet.size() > 0) {

						DatAnaLaboratorioDet valor = datAnaLaboratorioDet.get(0);

						VariableLab variableLab = logicVariableLab.getVariableLab(valorDto.getIdVariable().longValue());
						valor.setVariableLab(variableLab);

						valor.setValorVariable(datAnaLaboratorioDet.get(0).getValorVariable());
						valor.setHora0100(datAnaLaboratorioDet.get(0).getHora0100());
						valor.setHora0200(datAnaLaboratorioDet.get(0).getHora0200());
						valor.setHora0300(datAnaLaboratorioDet.get(0).getHora0300());
						valor.setHora0400(datAnaLaboratorioDet.get(0).getHora0400());
						valor.setHora0500(datAnaLaboratorioDet.get(0).getHora0500());
						valor.setHora0600(datAnaLaboratorioDet.get(0).getHora0600());
						valor.setHora0700(datAnaLaboratorioDet.get(0).getHora0700());
						valor.setHora0800(datAnaLaboratorioDet.get(0).getHora0800());
						valor.setHora0900(datAnaLaboratorioDet.get(0).getHora0900());
						valor.setHora1000(datAnaLaboratorioDet.get(0).getHora1000());
						valor.setHora1100(datAnaLaboratorioDet.get(0).getHora1100());
						valor.setHora1200(datAnaLaboratorioDet.get(0).getHora1200());
						valor.setHora1300(datAnaLaboratorioDet.get(0).getHora1300());
						valor.setHora1400(datAnaLaboratorioDet.get(0).getHora1400());
						valor.setHora1500(datAnaLaboratorioDet.get(0).getHora1500());
						valor.setHora1600(datAnaLaboratorioDet.get(0).getHora1600());
						valor.setHora1700(datAnaLaboratorioDet.get(0).getHora1700());
						valor.setHora1800(datAnaLaboratorioDet.get(0).getHora1800());
						valor.setHora1900(datAnaLaboratorioDet.get(0).getHora1900());
						valor.setHora2000(datAnaLaboratorioDet.get(0).getHora2000());
						valor.setHora2100(datAnaLaboratorioDet.get(0).getHora2100());
						valor.setHora2200(datAnaLaboratorioDet.get(0).getHora2200());
						valor.setHora2300(datAnaLaboratorioDet.get(0).getHora2300());
						valor.setHora0000(datAnaLaboratorioDet.get(0).getHora0000());

						valor.setDatAnaLaboratorio(entity);

						datAnaLaboratorioDetDAO.update(valor);

					} else {

						DatAnaLaboratorioDet valor = new DatAnaLaboratorioDet();
						VariableLab variableLab = logicVariableLab.getVariableLab(valorDto.getIdVariable().longValue());

						valor.setVariableLab(variableLab);
						valor.setValorVariable(valorDto.getValorVariableDia().doubleValue());
						valor.setHora0000(valorDto.getValorVariableHora0().doubleValue());
						valor.setHora0100(valorDto.getValorVariableHora1().doubleValue());
						valor.setHora0200(valorDto.getValorVariableHora2().doubleValue());
						valor.setHora0300(valorDto.getValorVariableHora3().doubleValue());
						valor.setHora0400(valorDto.getValorVariableHora4().doubleValue());
						valor.setHora0500(valorDto.getValorVariableHora5().doubleValue());
						valor.setHora0600(valorDto.getValorVariableHora6().doubleValue());
						valor.setHora0700(valorDto.getValorVariableHora7().doubleValue());
						valor.setHora0800(valorDto.getValorVariableHora8().doubleValue());
						valor.setHora0900(valorDto.getValorVariableHora9().doubleValue());
						valor.setHora1000(valorDto.getValorVariableHora10().doubleValue());
						valor.setHora1100(valorDto.getValorVariableHora11().doubleValue());
						valor.setHora1200(valorDto.getValorVariableHora12().doubleValue());
						valor.setHora1300(valorDto.getValorVariableHora13().doubleValue());
						valor.setHora1400(valorDto.getValorVariableHora14().doubleValue());
						valor.setHora1500(valorDto.getValorVariableHora15().doubleValue());
						valor.setHora1600(valorDto.getValorVariableHora16().doubleValue());
						valor.setHora1700(valorDto.getValorVariableHora17().doubleValue());
						valor.setHora1800(valorDto.getValorVariableHora18().doubleValue());
						valor.setHora1900(valorDto.getValorVariableHora19().doubleValue());
						valor.setHora2000(valorDto.getValorVariableHora20().doubleValue());
						valor.setHora2100(valorDto.getValorVariableHora21().doubleValue());
						valor.setHora2200(valorDto.getValorVariableHora22().doubleValue());
						valor.setHora2300(valorDto.getValorVariableHora23().doubleValue());
						valor.setDatAnaLaboratorio(entity);

						datAnaLaboratorioDetDAO.save(valor);

					}

				}
			}

			log.debug("update DatAnaLaboratorio successful");
		} catch (Exception e) {
			log.error("update DatAnaLaboratorio failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<DatAnaLaboratorioDTO> getDataDatAnaLaboratorio() throws Exception {
		try {
			List<DatAnaLaboratorio> datAnaLaboratorio = datAnaLaboratorioDAO.findAll();

			List<DatAnaLaboratorioDTO> datAnaLaboratorioDTO = new ArrayList<DatAnaLaboratorioDTO>();

			for (DatAnaLaboratorio datAnaLaboratorioTmp : datAnaLaboratorio) {
				DatAnaLaboratorioDTO datAnaLaboratorioDTO2 = new DatAnaLaboratorioDTO();

				datAnaLaboratorioDTO2.setDatAnaLabId(datAnaLaboratorioTmp.getDatAnaLabId());
				datAnaLaboratorioDTO2.setCompania(
						(datAnaLaboratorioTmp.getCompania() != null) ? datAnaLaboratorioTmp.getCompania() : null);
				datAnaLaboratorioDTO2.setConsecutivo(
						(datAnaLaboratorioTmp.getConsecutivo() != null) ? datAnaLaboratorioTmp.getConsecutivo() : null);
				datAnaLaboratorioDTO2.setEstado(
						(datAnaLaboratorioTmp.getEstado() != null) ? datAnaLaboratorioTmp.getEstado() : null);
				datAnaLaboratorioDTO2.setFechaAnalisis(datAnaLaboratorioTmp.getFechaAnalisis());
				datAnaLaboratorioDTO2.setFechaCreacion(datAnaLaboratorioTmp.getFechaCreacion());
				datAnaLaboratorioDTO2.setFechaModificacion(datAnaLaboratorioTmp.getFechaModificacion());
				datAnaLaboratorioDTO2.setInfoAdicional(
						(datAnaLaboratorioTmp.getInfoAdicional() != null) ? datAnaLaboratorioTmp.getInfoAdicional()
								: null);
				datAnaLaboratorioDTO2.setInfoAdicional2(
						(datAnaLaboratorioTmp.getInfoAdicional2() != null) ? datAnaLaboratorioTmp.getInfoAdicional2()
								: null);
				datAnaLaboratorioDTO2.setMobileId(
						(datAnaLaboratorioTmp.getMobileId() != null) ? datAnaLaboratorioTmp.getMobileId() : null);
				datAnaLaboratorioDTO2.setObservacion(
						(datAnaLaboratorioTmp.getObservacion() != null) ? datAnaLaboratorioTmp.getObservacion() : null);
				datAnaLaboratorioDTO2.setObservacionAnularReg((datAnaLaboratorioTmp.getObservacionAnularReg() != null)
						? datAnaLaboratorioTmp.getObservacionAnularReg()
						: null);
				datAnaLaboratorioDTO2.setUsuarioDigitacion((datAnaLaboratorioTmp.getUsuarioDigitacion() != null)
						? datAnaLaboratorioTmp.getUsuarioDigitacion()
						: null);
				datAnaLaboratorioDTO2
						.setAnaLabId_AnaLaboratorio((datAnaLaboratorioTmp.getAnaLaboratorio().getAnaLabId() != null)
								? datAnaLaboratorioTmp.getAnaLaboratorio().getAnaLabId()
								: null);

				if (datAnaLaboratorioTmp.getAnaLaboratorio() != null) {
					datAnaLaboratorioDTO2.setNombreAnalisis(datAnaLaboratorioTmp.getAnaLaboratorio().getNombre());
				} else {
					datAnaLaboratorioDTO2.setNombreAnalisis(null);
				}

				datAnaLaboratorioDTO2.setNroTicket(
						(datAnaLaboratorioTmp.getNroTicket() != null) ? datAnaLaboratorioTmp.getNroTicket() : null);

				if (datAnaLaboratorioTmp.getNivel2Id() != null) {
					datAnaLaboratorioDTO2.setNivel2Id(datAnaLaboratorioTmp.getNivel2Id());
				} else {
					datAnaLaboratorioDTO2.setNivel2Id(null);
				}
				if (datAnaLaboratorioTmp.getNivel4Id() != null) {
					datAnaLaboratorioDTO2.setNivel4Id(datAnaLaboratorioTmp.getNivel4Id());
				} else {
					datAnaLaboratorioDTO2.setNivel4Id(null);
				}

				if (datAnaLaboratorioTmp.getNivel2Id() != null) {
					datAnaLaboratorioDTO2.setNomNivel2(datAnaLaboratorioTmp.getNivel2Id().getNombre());
				} else {
					datAnaLaboratorioDTO2.setNomNivel2(null);
				}
				if (datAnaLaboratorioTmp.getNivel4Id() != null) {
					datAnaLaboratorioDTO2.setNomNivel4(datAnaLaboratorioTmp.getNivel4Id().getNombre());
				} else {
					datAnaLaboratorioDTO2.setNomNivel4(null);
				}

				if (datAnaLaboratorioTmp.getEquipo() != null) {
					datAnaLaboratorioDTO2.setEquipo(datAnaLaboratorioTmp.getEquipo().getEquipoId());
				} else {
					datAnaLaboratorioDTO2.setEquipo(null);
				}

				if (datAnaLaboratorioTmp.getEquipo() != null) {
					datAnaLaboratorioDTO2.setCodEquipo(datAnaLaboratorioTmp.getEquipo().getNombre());
				} else {
					datAnaLaboratorioDTO2.setCodEquipo(null);
				}

				datAnaLaboratorioDTO.add(datAnaLaboratorioDTO2);
			}

			return datAnaLaboratorioDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public DatAnaLaboratorio getDatAnaLaboratorio(Long datAnaLabId) throws Exception {
		log.debug("getting DatAnaLaboratorio instance");

		DatAnaLaboratorio entity = null;

		try {
			entity = datAnaLaboratorioDAO.findById(datAnaLabId);
		} catch (Exception e) {
			log.error("get DatAnaLaboratorio failed", e);
			throw new ZMessManager().new FindingException("DatAnaLaboratorio");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<DatAnaLaboratorio> findPageDatAnaLaboratorio(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<DatAnaLaboratorio> entity = null;

		try {
			entity = datAnaLaboratorioDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatAnaLaboratorio Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberDatAnaLaboratorio() throws Exception {
		Long entity = null;

		try {
			entity = datAnaLaboratorioDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatAnaLaboratorio Count");
		} finally {
		}

		return entity;
	}

	/**
	 *
	 * @param varibles         este arreglo debera tener:
	 *
	 *                         [0] = String variable = (String) varibles[i];
	 *                         representa como se llama la variable en el pojo
	 *
	 *                         [1] = Boolean booVariable = (Boolean) varibles[i +
	 *                         1]; representa si el valor necesita o no ''(comillas
	 *                         simples)usado para campos de tipo string
	 *
	 *                         [2] = Object value = varibles[i + 2]; representa el
	 *                         valor que se va a buscar en la BD
	 *
	 *                         [3] = String comparator = (String) varibles[i + 3];
	 *                         representa que tipo de busqueda voy a hacer..,
	 *                         ejemplo: where nombre=william o where
	 *                         nombre<>william, en este campo iria el tipo de
	 *                         comparador que quiero si es = o <>
	 *
	 *                         Se itera de 4 en 4..., entonces 4 registros del
	 *                         arreglo representan 1 busqueda en un campo, si se
	 *                         ponen mas pues el continuara buscando en lo que se le
	 *                         ingresen en los otros 4
	 *
	 *
	 * @param variablesBetween
	 *
	 *                         la diferencia son estas dos posiciones
	 *
	 *                         [0] = String variable = (String) varibles[j]; la
	 *                         variable ne la BD que va a ser buscada en un rango
	 *
	 *                         [1] = Object value = varibles[j + 1]; valor 1 para
	 *                         buscar en un rango
	 *
	 *                         [2] = Object value2 = varibles[j + 2]; valor 2 para
	 *                         buscar en un rango ejempolo: a > 1 and a < 5 --> 1
	 *                         seria value y 5 seria value2
	 *
	 *                         [3] = String comparator1 = (String) varibles[j + 3];
	 *                         comparador 1 ejemplo: a comparator1 1 and a < 5
	 *
	 *                         [4] = String comparator2 = (String) varibles[j + 4];
	 *                         comparador 2 ejemplo: a comparador1>1 and a
	 *                         comparador2<5 (el original: a > 1 and a < 5) *
	 * @param                  variablesBetweenDates(en este caso solo para mysql)
	 *                         [0] = String variable = (String) varibles[k]; el
	 *                         nombre de la variable que hace referencia a una fecha
	 *
	 *                         [1] = Object object1 = varibles[k + 2]; fecha 1 a
	 *                         comparar(deben ser dates)
	 *
	 *                         [2] = Object object2 = varibles[k + 3]; fecha 2 a
	 *                         comparar(deben ser dates)
	 *
	 *                         esto hace un between entre las dos fechas.
	 *
	 * @return lista con los objetos que se necesiten
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	public List<DatAnaLaboratorio> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<DatAnaLaboratorio> list = new ArrayList<DatAnaLaboratorio>();
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
			list = datAnaLaboratorioDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = true)
	public List<DatAnaLaboratorioDTO> getDataDatAnaLaboratorioByTipoAnalisis(Long idAnalisis) throws Exception {
		try {
			List<DatAnaLaboratorio> datAnaLaboratorio = datAnaLaboratorioDAO
					.findByCriteria("anaLaboratorio.anaLabId= " + idAnalisis);

			List<DatAnaLaboratorioDTO> datAnaLaboratorioDTO = new ArrayList<DatAnaLaboratorioDTO>();

			for (DatAnaLaboratorio datAnaLaboratorioTmp : datAnaLaboratorio) {
				DatAnaLaboratorioDTO datAnaLaboratorioDTO2 = new DatAnaLaboratorioDTO();

				datAnaLaboratorioDTO2.setDatAnaLabId(datAnaLaboratorioTmp.getDatAnaLabId());
				datAnaLaboratorioDTO2.setCompania(
						(datAnaLaboratorioTmp.getCompania() != null) ? datAnaLaboratorioTmp.getCompania() : null);
				datAnaLaboratorioDTO2.setConsecutivo(
						(datAnaLaboratorioTmp.getConsecutivo() != null) ? datAnaLaboratorioTmp.getConsecutivo() : null);
				datAnaLaboratorioDTO2.setEstado(
						(datAnaLaboratorioTmp.getEstado() != null) ? datAnaLaboratorioTmp.getEstado() : null);
				datAnaLaboratorioDTO2.setFechaAnalisis(datAnaLaboratorioTmp.getFechaAnalisis());
				datAnaLaboratorioDTO2.setFechaCreacion(datAnaLaboratorioTmp.getFechaCreacion());
				datAnaLaboratorioDTO2.setFechaModificacion(datAnaLaboratorioTmp.getFechaModificacion());
				datAnaLaboratorioDTO2.setInfoAdicional(
						(datAnaLaboratorioTmp.getInfoAdicional() != null) ? datAnaLaboratorioTmp.getInfoAdicional()
								: null);
				datAnaLaboratorioDTO2.setInfoAdicional2(
						(datAnaLaboratorioTmp.getInfoAdicional2() != null) ? datAnaLaboratorioTmp.getInfoAdicional2()
								: null);
				datAnaLaboratorioDTO2.setMobileId(
						(datAnaLaboratorioTmp.getMobileId() != null) ? datAnaLaboratorioTmp.getMobileId() : null);
				datAnaLaboratorioDTO2.setObservacion(
						(datAnaLaboratorioTmp.getObservacion() != null) ? datAnaLaboratorioTmp.getObservacion() : null);
				datAnaLaboratorioDTO2.setObservacionAnularReg((datAnaLaboratorioTmp.getObservacionAnularReg() != null)
						? datAnaLaboratorioTmp.getObservacionAnularReg()
						: null);
				datAnaLaboratorioDTO2.setUsuarioDigitacion((datAnaLaboratorioTmp.getUsuarioDigitacion() != null)
						? datAnaLaboratorioTmp.getUsuarioDigitacion()
						: null);
				datAnaLaboratorioDTO2
						.setAnaLabId_AnaLaboratorio((datAnaLaboratorioTmp.getAnaLaboratorio().getAnaLabId() != null)
								? datAnaLaboratorioTmp.getAnaLaboratorio().getAnaLabId()
								: null);

				if (datAnaLaboratorioTmp.getAnaLaboratorio() != null) {
					datAnaLaboratorioDTO2.setNombreAnalisis(datAnaLaboratorioTmp.getAnaLaboratorio().getNombre());
				} else {
					datAnaLaboratorioDTO2.setNombreAnalisis(null);
				}

				datAnaLaboratorioDTO2.setNroTicket(
						(datAnaLaboratorioTmp.getNroTicket() != null) ? datAnaLaboratorioTmp.getNroTicket() : null);

				if (datAnaLaboratorioTmp.getNivel2Id() != null) {
					datAnaLaboratorioDTO2.setNivel2Id(datAnaLaboratorioTmp.getNivel2Id());
				} else {
					datAnaLaboratorioDTO2.setNivel2Id(null);
				}
				if (datAnaLaboratorioTmp.getNivel4Id() != null) {
					datAnaLaboratorioDTO2.setNivel4Id(datAnaLaboratorioTmp.getNivel4Id());
				} else {
					datAnaLaboratorioDTO2.setNivel4Id(null);
				}

				if (datAnaLaboratorioTmp.getNivel2Id() != null) {
					datAnaLaboratorioDTO2.setNomNivel2(datAnaLaboratorioTmp.getNivel2Id().getNombre());
				} else {
					datAnaLaboratorioDTO2.setNomNivel2(null);
				}
				if (datAnaLaboratorioTmp.getNivel4Id() != null) {
					datAnaLaboratorioDTO2.setNomNivel4(datAnaLaboratorioTmp.getNivel4Id().getNombre());
				} else {
					datAnaLaboratorioDTO2.setNomNivel4(null);
				}

				String estadoEstrue = "false";
				if (datAnaLaboratorioTmp.getEstado().equals("I")) {
					estadoEstrue = "true";
					datAnaLaboratorioDTO2.setEstadoTrue(estadoEstrue);
				}
				datAnaLaboratorioDTO2.setEstadoTrue(estadoEstrue);

				if (datAnaLaboratorioTmp.getEquipo() != null) {
					datAnaLaboratorioDTO2.setEquipo(datAnaLaboratorioTmp.getEquipo().getEquipoId());
				} else {
					datAnaLaboratorioDTO2.setEquipo(null);
				}

				if (datAnaLaboratorioTmp.getEquipo() != null) {
					datAnaLaboratorioDTO2.setCodEquipo(datAnaLaboratorioTmp.getEquipo().getNombre());
				} else {
					datAnaLaboratorioDTO2.setCodEquipo(null);
				}

				datAnaLaboratorioDTO.add(datAnaLaboratorioDTO2);
			}

			return datAnaLaboratorioDTO;
		} catch (Exception e) {
			throw e;
		}
	}

}
