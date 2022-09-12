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

import co.com.arcosoft.dataaccess.dao.IDatOtrosCostosDAO;
import co.com.arcosoft.dataaccess.dao.IDatOtrosCostosDetalleDAO;
import co.com.arcosoft.dataaccess.dao.IDatOtrosCostosNivel4DAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.CentCost;
import co.com.arcosoft.modelo.DatOtrosCostos;
import co.com.arcosoft.modelo.DatOtrosCostosDetalle;
import co.com.arcosoft.modelo.DatOtrosCostosMq;
import co.com.arcosoft.modelo.DatOtrosCostosMqdet;
import co.com.arcosoft.modelo.DatOtrosCostosMqdetDistribuccion;
import co.com.arcosoft.modelo.DatOtrosCostosNivel4;
import co.com.arcosoft.modelo.DatPlanillaNominaDet;
import co.com.arcosoft.modelo.Etapa;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.dto.DatOtrosCostosDTO;
import co.com.arcosoft.modelo.dto.DatOtrosCostosDetalleDTO;
import co.com.arcosoft.modelo.dto.DatOtrosCostosMqDTO;
import co.com.arcosoft.modelo.dto.DatOtrosCostosMqdetDistribuccionDTO;
import co.com.arcosoft.modelo.dto.DatOtrosCostosNivel4DTO;
import co.com.arcosoft.modelo.informes.dto.ListaNivel4DTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org <
 */
@Scope("singleton")
@Service("DatOtrosCostosLogic")
public class DatOtrosCostosLogic implements IDatOtrosCostosLogic {
	private static final Logger log = LoggerFactory.getLogger(DatOtrosCostosLogic.class);

	/**
	 * DAO injected by Spring that manages DatOtrosCostos entities
	 *
	 */
	@Autowired
	private IDatOtrosCostosDAO datOtrosCostosDAO;

	/**
	 * DAO injected by Spring that manages DatOtrosCostosNivel4 entities
	 *
	 */
	@Autowired
	private IDatOtrosCostosNivel4DAO datOtrosCostosNivel4DAO;
	@Autowired
	private IDatOtrosCostosDetalleDAO datOtrosCostosDetalleDAO;

	/**
	 * Logic injected by Spring that manages CentCost entities
	 *
	 */
	@Autowired
	ICentCostLogic logicCentCost1;

	/**
	 * Logic injected by Spring that manages ElementoCosto entities
	 *
	 */
	@Autowired
	IElementoCostoLogic logicElementoCosto2;

	/**
	 * Logic injected by Spring that manages Labor entities
	 *
	 */
	@Autowired
	ILaborLogic logicLabor3;

	/**
	 * Logic injected by Spring that manages PersEmpr entities
	 *
	 */
	@Autowired
	IPersEmprLogic logicPersEmpr4;

	@Autowired
	INivel2Logic logicNivel2;

	@Autowired
	INivel4Logic logicNivel4;

	@Override
	@Transactional(readOnly = true)
	public List<DatOtrosCostos> getDatOtrosCostos() throws Exception {
		log.debug("finding all DatOtrosCostos instances");

		List<DatOtrosCostos> list = new ArrayList<DatOtrosCostos>();

		try {
			list = datOtrosCostosDAO.findAll();
		} catch (Exception e) {
			log.error("finding all DatOtrosCostos failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "DatOtrosCostos");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveDatOtrosCostos(DatOtrosCostos entity, List<DatOtrosCostosNivel4DTO> dataNivel4,
			List<DatOtrosCostosDetalleDTO> dataDetalle) throws Exception {
		log.debug("saving DatOtrosCostos instance");

		try {

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getConsecutivo() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getConsecutivo(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("consecutivo");
			}

			if ((entity.getEquipoId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEquipoId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("equipoId");
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

			if ((entity.getInfraId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getInfraId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("infraId");
			}

			if ((entity.getObservacionAnularReg() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacionAnularReg(), 500) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacionAnularReg");
			}

			if ((entity.getReglaDistribuccion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getReglaDistribuccion(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("reglaDistribuccion");
			}

			if ((entity.getSerieFactura() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getSerieFactura(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("serieFactura");
			}

			if ((entity.getTipoTransaccion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getTipoTransaccion(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("tipoTransaccion");
			}

			if ((entity.getUsuarioDigitacion() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getUsuarioDigitacion(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("usuarioDigitacion");
			}

			if ((entity.getValorTotal() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getValorTotal(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("valorTotal");
			}

			datOtrosCostosDAO.save(entity);

			if (dataNivel4 != null) {

				for (DatOtrosCostosNivel4DTO valorDto : dataNivel4) {

					if (valorDto.getDatOtrosCostosNivel4Id() == null) {

						DatOtrosCostosNivel4 valor = new DatOtrosCostosNivel4();

						valor.setNivel2(valorDto.getNivel2Id_Nivel2());
						valor.setNivel4(valorDto.getNivel4Id_Nivel4());
						valor.setAreaNivel4(valorDto.getAreaNivel4());
						valor.setEtapaId(valorDto.getEtapaId());
						valor.setVariedId(valorDto.getVariedId());

						valor.setDatOtrosCostos(entity);

						datOtrosCostosNivel4DAO.save(valor);
					}
				}
			}

			if (dataDetalle != null) {

				for (DatOtrosCostosDetalleDTO valorDto : dataDetalle) {

					DatOtrosCostosDetalle valor = new DatOtrosCostosDetalle();

					valor.setLabor(valorDto.getLaborId_Labor());
					valor.setPersEmpr(valorDto.getPersEmprId_PersEmpr());
					valor.setElementoCosto(valorDto.getElemCostoId_ElementoCosto());
					valor.setCcontableId(valorDto.getCcontableId());
					valor.setNumFactura(valorDto.getNumFactura());
					valor.setValorTotal(valorDto.getValorTotal());
					valor.setObservacion(valorDto.getObservacion());
					
				 
					valor.setDatOtrosCostos(entity);

					datOtrosCostosDetalleDAO.save(valor);
				}
			}

			log.debug("save DatOtrosCostos successful");
		} catch (Exception e) {
			log.error("save DatOtrosCostos failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteDatOtrosCostos(DatOtrosCostos entity) throws Exception {
		log.debug("deleting DatOtrosCostos instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("DatOtrosCostos");
		}

		if (entity.getDatOtrosCostosId() == null) {
			throw new ZMessManager().new EmptyFieldException("datOtrosCostosId");
		}

		List<DatOtrosCostosNivel4> datOtrosCostosNivel4s = null;

		try {
			datOtrosCostosNivel4s = datOtrosCostosNivel4DAO.findByProperty("datOtrosCostos.datOtrosCostosId",
					entity.getDatOtrosCostosId());

			if (Utilities.validationsList(datOtrosCostosNivel4s) == true) {
				throw new ZMessManager().new DeletingException("datOtrosCostosNivel4s");
			}

			datOtrosCostosDAO.delete(entity);

			log.debug("delete DatOtrosCostos successful");
		} catch (Exception e) {
			log.error("delete DatOtrosCostos failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateDatOtrosCostos(DatOtrosCostos entity, List<DatOtrosCostosNivel4DTO> dataNivel4,
			List<DatOtrosCostosDetalleDTO> dataDetalle) throws Exception {
		log.debug("updating DatOtrosCostos instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("DatOtrosCostos");
			}

		

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getConsecutivo() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getConsecutivo(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("consecutivo");
			}

			if (entity.getDatOtrosCostosId() == null) {
				throw new ZMessManager().new EmptyFieldException("datOtrosCostosId");
			}

			if ((entity.getDatOtrosCostosId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getDatOtrosCostosId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("datOtrosCostosId");
			}

			if ((entity.getEquipoId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEquipoId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("equipoId");
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

			if ((entity.getInfraId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getInfraId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("infraId");
			}

			if ((entity.getNumFactura() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNumFactura(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("numFactura");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacion(), 3900) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacion");
			}

			if ((entity.getObservacionAnularReg() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacionAnularReg(), 500) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacionAnularReg");
			}

			if ((entity.getReglaDistribuccion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getReglaDistribuccion(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("reglaDistribuccion");
			}

			if ((entity.getSerieFactura() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getSerieFactura(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("serieFactura");
			}

			if ((entity.getTipoTransaccion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getTipoTransaccion(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("tipoTransaccion");
			}

			if ((entity.getUsuarioDigitacion() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getUsuarioDigitacion(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("usuarioDigitacion");
			}

			if ((entity.getValorTotal() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getValorTotal(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("valorTotal");
			}

		
		

			datOtrosCostosDAO.update(entity);
			if (dataNivel4 != null) {
				for (DatOtrosCostosNivel4DTO valorDto : dataNivel4) {

					if (valorDto.getDatOtrosCostosNivel4Id() == null) { 

						DatOtrosCostosNivel4 valor = new DatOtrosCostosNivel4();
						
						valor.setNivel2(valorDto.getNivel2Id_Nivel2());
						valor.setNivel4(valorDto.getNivel4Id_Nivel4());
						valor.setAreaNivel4(valorDto.getAreaNivel4());
						valor.setEtapaId(valorDto.getEtapaId());
						valor.setVariedId(valorDto.getVariedId());

						valor.setDatOtrosCostos(entity);
						datOtrosCostosNivel4DAO.save(valor);

					} else {
						DatOtrosCostosNivel4 valor = datOtrosCostosNivel4DAO
								.findById(valorDto.getDatOtrosCostosNivel4Id());
						valor.setNivel2(valorDto.getNivel2Id_Nivel2());
						valor.setNivel4(valorDto.getNivel4Id_Nivel4());
						valor.setAreaNivel4(valorDto.getAreaNivel4());

						valor.setDatOtrosCostos(entity);
						datOtrosCostosNivel4DAO.update(valor);
					}

				}
			}

			if (dataDetalle != null) {

				for (DatOtrosCostosDetalleDTO valorDto : dataDetalle) {

					DatOtrosCostosDetalle valor = new DatOtrosCostosDetalle();

					valor.setLabor(valorDto.getLaborId_Labor());
					valor.setPersEmpr(valorDto.getPersEmprId_PersEmpr());
					valor.setElementoCosto(valorDto.getElemCostoId_ElementoCosto());
					valor.setCcontableId(valorDto.getCcontableId());
					valor.setNumFactura(valorDto.getNumFactura());
					valor.setValorTotal(valorDto.getValorTotal());
					valor.setObservacion(valorDto.getObservacion());

					valor.setDatOtrosCostos(entity);

					datOtrosCostosDetalleDAO.save(valor);
				}
			}
			log.debug("update DatOtrosCostos successful");
		} catch (Exception e) {
			log.error("update DatOtrosCostos failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatOtrosCostosDTO> getDataDatOtrosCostos() throws Exception {
		try {
			List<DatOtrosCostos> datOtrosCostos = datOtrosCostosDAO.findAll();

			List<DatOtrosCostosDTO> datOtrosCostosDTO = new ArrayList<DatOtrosCostosDTO>();

			for (DatOtrosCostos datOtrosCostosTmp : datOtrosCostos) {
				DatOtrosCostosDTO datOtrosCostosDTO2 = new DatOtrosCostosDTO();

				datOtrosCostosDTO2.setDatOtrosCostosId(datOtrosCostosTmp.getDatOtrosCostosId());
				datOtrosCostosDTO2.setCompania(
						(datOtrosCostosTmp.getCompania() != null) ? datOtrosCostosTmp.getCompania() : null);
				datOtrosCostosDTO2.setConsecutivo(
						(datOtrosCostosTmp.getConsecutivo() != null) ? datOtrosCostosTmp.getConsecutivo() : null);
				datOtrosCostosDTO2.setEquipoId(
						(datOtrosCostosTmp.getEquipoId() != null) ? datOtrosCostosTmp.getEquipoId() : null);
				datOtrosCostosDTO2
						.setEstado((datOtrosCostosTmp.getEstado() != null) ? datOtrosCostosTmp.getEstado() : null);
				datOtrosCostosDTO2.setFechaAnulacion(datOtrosCostosTmp.getFechaAnulacion());
				datOtrosCostosDTO2.setFechaInicial(datOtrosCostosTmp.getFechaInicial());

				datOtrosCostosDTO2.setFechaCreacion(datOtrosCostosTmp.getFechaCreacion());
				datOtrosCostosDTO2.setFechaModificacion(datOtrosCostosTmp.getFechaModificacion());
				datOtrosCostosDTO2.setFechaRegistro(datOtrosCostosTmp.getFechaRegistro());
				datOtrosCostosDTO2.setInfoAdicional(
						(datOtrosCostosTmp.getInfoAdicional() != null) ? datOtrosCostosTmp.getInfoAdicional() : null);
				datOtrosCostosDTO2.setInfoAdicional2(
						(datOtrosCostosTmp.getInfoAdicional2() != null) ? datOtrosCostosTmp.getInfoAdicional2() : null);
				datOtrosCostosDTO2
						.setInfraId((datOtrosCostosTmp.getInfraId() != null) ? datOtrosCostosTmp.getInfraId() : null);
				datOtrosCostosDTO2.setNumFactura(
						(datOtrosCostosTmp.getNumFactura() != null) ? datOtrosCostosTmp.getNumFactura() : null);
				datOtrosCostosDTO2.setObservacion(
						(datOtrosCostosTmp.getObservacion() != null) ? datOtrosCostosTmp.getObservacion() : null);
				datOtrosCostosDTO2.setObservacionAnularReg((datOtrosCostosTmp.getObservacionAnularReg() != null)
						? datOtrosCostosTmp.getObservacionAnularReg()
						: null);
				datOtrosCostosDTO2.setReglaDistribuccion(
						(datOtrosCostosTmp.getReglaDistribuccion() != null) ? datOtrosCostosTmp.getReglaDistribuccion()
								: null);
				datOtrosCostosDTO2.setSerieFactura(
						(datOtrosCostosTmp.getSerieFactura() != null) ? datOtrosCostosTmp.getSerieFactura() : null);
				datOtrosCostosDTO2.setTipoTransaccion(
						(datOtrosCostosTmp.getTipoTransaccion() != null) ? datOtrosCostosTmp.getTipoTransaccion()
								: null);
				datOtrosCostosDTO2.setUsuarioDigitacion(
						(datOtrosCostosTmp.getUsuarioDigitacion() != null) ? datOtrosCostosTmp.getUsuarioDigitacion()
								: null);
				datOtrosCostosDTO2.setValorTotal(
						(datOtrosCostosTmp.getValorTotal() != null) ? datOtrosCostosTmp.getValorTotal() : null);

				if (datOtrosCostosTmp.getCentCost() != null) {
					datOtrosCostosDTO2.setCentCostId_CentCost(datOtrosCostosTmp.getCentCost().getCentCostId());
				} else {
					datOtrosCostosDTO2.setCentCostId_CentCost(null);
				}

				datOtrosCostosDTO2
						.setElemCostoId_ElementoCosto((datOtrosCostosTmp.getElementoCosto().getElemCostoId() != null)
								? datOtrosCostosTmp.getElementoCosto().getElemCostoId()
								: null);

				if (datOtrosCostosTmp.getLabor() != null) {
					datOtrosCostosDTO2.setLaborId_Labor(datOtrosCostosTmp.getLabor().getLaborId());
				} else {
					datOtrosCostosDTO2.setLaborId_Labor(null);
				}

				datOtrosCostosDTO2.setPersEmprId_PersEmpr((datOtrosCostosTmp.getPersEmpr().getPersEmprId() != null)
						? datOtrosCostosTmp.getPersEmpr().getPersEmprId()
						: null);

				if (datOtrosCostosTmp.getNivel2Indicador() != null) {
					datOtrosCostosDTO2.setNivel2Indicador(datOtrosCostosTmp.getNivel2Indicador().getNivel2Id());
				} else {
					datOtrosCostosDTO2.setNivel2Indicador(null);
				}

				datOtrosCostosDTO.add(datOtrosCostosDTO2);
			}

			return datOtrosCostosDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public DatOtrosCostos getDatOtrosCostos(Long datOtrosCostosId) throws Exception {
		log.debug("getting DatOtrosCostos instance");

		DatOtrosCostos entity = null;

		try {
			entity = datOtrosCostosDAO.findById(datOtrosCostosId);
		} catch (Exception e) {
			log.error("get DatOtrosCostos failed", e);
			throw new ZMessManager().new FindingException("DatOtrosCostos");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatOtrosCostos> findPageDatOtrosCostos(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<DatOtrosCostos> entity = null;

		try {
			entity = datOtrosCostosDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatOtrosCostos Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberDatOtrosCostos() throws Exception {
		Long entity = null;

		try {
			entity = datOtrosCostosDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatOtrosCostos Count");
		} finally {
		}

		return entity;
	}

	/**
	 *
	 * @param varibles                 este arreglo debera tener:
	 *
	 *                                 [0] = String variable = (String) varibles[i];
	 *                                 representa como se llama la variable en el
	 *                                 pojo
	 *
	 *                                 [1] = Boolean booVariable = (Boolean)
	 *                                 varibles[i + 1]; representa si el valor
	 *                                 necesita o no ''(comillas simples)usado para
	 *                                 campos de tipo string
	 *
	 *                                 [2] = Object value = varibles[i + 2];
	 *                                 representa el valor que se va a buscar en la
	 *                                 BD
	 *
	 *                                 [3] = String comparator = (String) varibles[i
	 *                                 + 3]; representa que tipo de busqueda voy a
	 *                                 hacer.., ejemplo: where nombre=william o
	 *                                 where nombre<>william, en este campo iria el
	 *                                 tipo de comparador que quiero si es = o <>
	 *
	 *                                 Se itera de 4 en 4..., entonces 4 registros
	 *                                 del arreglo representan 1 busqueda en un
	 *                                 campo, si se ponen mas pues el continuara
	 *                                 buscando en lo que se le ingresen en los
	 *                                 otros 4
	 *
	 *
	 * @param variablesBetween
	 *
	 *                                 la diferencia son estas dos posiciones
	 *
	 *                                 [0] = String variable = (String) varibles[j];
	 *                                 la variable ne la BD que va a ser buscada en
	 *                                 un rango
	 *
	 *                                 [1] = Object value = varibles[j + 1]; valor 1
	 *                                 para buscar en un rango
	 *
	 *                                 [2] = Object value2 = varibles[j + 2]; valor
	 *                                 2 para buscar en un rango ejempolo: a > 1 and
	 *                                 a < 5 --> 1 seria value y 5 seria value2
	 *
	 *                                 [3] = String comparator1 = (String)
	 *                                 varibles[j + 3]; comparador 1 ejemplo: a
	 *                                 comparator1 1 and a < 5
	 *
	 *                                 [4] = String comparator2 = (String)
	 *                                 varibles[j + 4]; comparador 2 ejemplo: a
	 *                                 comparador1>1 and a comparador2<5 (el
	 *                                 original: a > 1 and a < 5) *
	 * @param variablesBetweenDates(en este caso solo para mysql) [0] = String
	 *                                 variable = (String) varibles[k]; el nombre de
	 *                                 la variable que hace referencia a una fecha
	 *
	 *                                 [1] = Object object1 = varibles[k + 2]; fecha
	 *                                 1 a comparar(deben ser dates)
	 *
	 *                                 [2] = Object object2 = varibles[k + 3]; fecha
	 *                                 2 a comparar(deben ser dates)
	 *
	 *                                 esto hace un between entre las dos fechas.
	 *
	 * @return lista con los objetos que se necesiten
	 * @throws Exception
	 */
	@Override
	@Transactional(readOnly = true)
	public List<DatOtrosCostos> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<DatOtrosCostos> list = new ArrayList<DatOtrosCostos>();
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
			list = datOtrosCostosDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveDatOtrosCostosVer2(DatOtrosCostos entity, List<ListaNivel4DTO> dataLotes,
			List<DatOtrosCostosDetalleDTO> dataDetalle) throws Exception {
		log.debug("saving DatOtrosCostos instance");

		try {

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getConsecutivo() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getConsecutivo(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("consecutivo");
			}

			if ((entity.getEquipoId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEquipoId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("equipoId");
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

			if ((entity.getInfraId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getInfraId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("infraId");
			}

			if ((entity.getObservacionAnularReg() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacionAnularReg(), 500) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacionAnularReg");
			}

			if ((entity.getReglaDistribuccion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getReglaDistribuccion(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("reglaDistribuccion");
			}

			if ((entity.getSerieFactura() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getSerieFactura(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("serieFactura");
			}

			if ((entity.getTipoTransaccion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getTipoTransaccion(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("tipoTransaccion");
			}

			if ((entity.getUsuarioDigitacion() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getUsuarioDigitacion(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("usuarioDigitacion");
			}

			datOtrosCostosDAO.save(entity);

			if (dataLotes != null) {

				for (ListaNivel4DTO valorDto : dataLotes) {

					DatOtrosCostosNivel4 valor = new DatOtrosCostosNivel4();

					Nivel2 nivel2 = logicNivel2.getNivel2(valorDto.getNivel2_id().longValue());
					Nivel4 nivel4 = logicNivel4.getNivel4(valorDto.getNivel4_id().longValue());
					Etapa etapa = nivel4.getEtapa();
					
					valor.setNivel2(nivel2);
					valor.setNivel4(nivel4);
					if (etapa != null) {
						valor.setEtapaId(etapa.getEtapaId());							
					}
					valor.setVariedId(nivel4.getVariedad());
					valor.setAreaNivel4(valorDto.getArea_neta().doubleValue());

					valor.setDatOtrosCostos(entity);

					datOtrosCostosNivel4DAO.save(valor);
				}

			}

			if (dataDetalle != null) {

				for (DatOtrosCostosDetalleDTO valorDto : dataDetalle) {

					DatOtrosCostosDetalle valor = new DatOtrosCostosDetalle();

					valor.setLabor(valorDto.getLaborId_Labor());
					valor.setPersEmpr(valorDto.getPersEmprId_PersEmpr());
					valor.setElementoCosto(valorDto.getElemCostoId_ElementoCosto());
					valor.setCcontableId(valorDto.getCcontableId());
					valor.setNumFactura(valorDto.getNumFactura());
					valor.setValorTotal(valorDto.getValorTotal());
					valor.setObservacion(valorDto.getObservacion());

					valor.setDatOtrosCostos(entity);

					datOtrosCostosDetalleDAO.save(valor);
				}
			}

			log.debug("save DatOtrosCostos successful");
		} catch (Exception e) {
			log.error("save DatOtrosCostos failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateDatOtrosCostosVer2(DatOtrosCostos entity, List<ListaNivel4DTO> dataLotes,
			List<DatOtrosCostosDetalleDTO> dataDetalle) throws Exception {
		log.debug("updating DatOtrosCostos instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("DatOtrosCostos");
			}

		

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getConsecutivo() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getConsecutivo(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("consecutivo");
			}

			if (entity.getDatOtrosCostosId() == null) {
				throw new ZMessManager().new EmptyFieldException("datOtrosCostosId");
			}

			if ((entity.getDatOtrosCostosId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getDatOtrosCostosId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("datOtrosCostosId");
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

			if ((entity.getInfraId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getInfraId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("infraId");
			}

			if ((entity.getNumFactura() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNumFactura(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("numFactura");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacion(), 3900) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacion");
			}

			if ((entity.getObservacionAnularReg() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacionAnularReg(), 500) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacionAnularReg");
			}

			if ((entity.getReglaDistribuccion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getReglaDistribuccion(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("reglaDistribuccion");
			}

			if ((entity.getSerieFactura() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getSerieFactura(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("serieFactura");
			}

			if ((entity.getTipoTransaccion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getTipoTransaccion(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("tipoTransaccion");
			}

			if ((entity.getUsuarioDigitacion() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getUsuarioDigitacion(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("usuarioDigitacion");
			}

			if ((entity.getValorTotal() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getValorTotal(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("valorTotal");
			}

			
		

			datOtrosCostosDAO.update(entity);

			if (dataLotes != null) {

				for (ListaNivel4DTO valorDto : dataLotes) {

					DatOtrosCostosNivel4 valor = new DatOtrosCostosNivel4();

					Nivel2 nivel2 = logicNivel2.getNivel2(valorDto.getNivel2_id().longValue());
					Nivel4 nivel4 = logicNivel4.getNivel4(valorDto.getNivel4_id().longValue());
					Etapa etapa = nivel4.getEtapa();
					
					valor.setNivel2(nivel2);
					valor.setNivel4(nivel4);
					if (etapa != null) {
						valor.setEtapaId(etapa.getEtapaId());							
					}
					valor.setVariedId(nivel4.getVariedad());
					valor.setAreaNivel4(valorDto.getArea_neta().doubleValue());

					valor.setDatOtrosCostos(entity);

					datOtrosCostosNivel4DAO.save(valor);
				}

			}

			if (dataDetalle != null) {

				for (DatOtrosCostosDetalleDTO valorDto : dataDetalle) {
					if (valorDto.getDatOtrosCostosDetId() == null) { 
					DatOtrosCostosDetalle valor = new DatOtrosCostosDetalle();

					valor.setLabor(valorDto.getLaborId_Labor());
					valor.setPersEmpr(valorDto.getPersEmprId_PersEmpr());
					valor.setElementoCosto(valorDto.getElemCostoId_ElementoCosto());
					valor.setCcontableId(valorDto.getCcontableId());
					valor.setNumFactura(valorDto.getNumFactura());
					valor.setValorTotal(valorDto.getValorTotal());
					valor.setObservacion(valorDto.getObservacion());

					valor.setDatOtrosCostos(entity);

					datOtrosCostosDetalleDAO.save(valor);
					} else {
					
						DatOtrosCostosDetalle valor = datOtrosCostosDetalleDAO.findById(valorDto.getDatOtrosCostosDetId());
						valor.setLabor(valorDto.getLaborId_Labor());
						valor.setPersEmpr(valorDto.getPersEmprId_PersEmpr());
						valor.setElementoCosto(valorDto.getElemCostoId_ElementoCosto());
						valor.setCcontableId(valorDto.getCcontableId());
						valor.setNumFactura(valorDto.getNumFactura());
						valor.setValorTotal(valorDto.getValorTotal());
						valor.setObservacion(valorDto.getObservacion());

						valor.setDatOtrosCostos(entity);

						datOtrosCostosDetalleDAO.update(valor);
					
					}					
				}
			}
					

			log.debug("update DatOtrosCostos successful");
		} catch (Exception e) {
			log.error("update DatOtrosCostos failed", e);
			throw e;
		} finally {
		}
	}

}
