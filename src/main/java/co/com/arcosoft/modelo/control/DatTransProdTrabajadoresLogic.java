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

import co.com.arcosoft.dataaccess.dao.IDatTransProdTrabajadoresDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatTransProdTrabajadores;
import co.com.arcosoft.modelo.dto.DatTransProdTrabajadoresDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("DatTransProdTrabajadoresLogic")
public class DatTransProdTrabajadoresLogic implements IDatTransProdTrabajadoresLogic {
	private static final Logger log = LoggerFactory.getLogger(DatTransProdTrabajadoresLogic.class);

	/**
	 * DAO injected by Spring that manages DatTransProdTrabajadores entities
	 *
	 */
	@Autowired
	private IDatTransProdTrabajadoresDAO datTransProdTrabajadoresDAO;

	/**
	 * Logic injected by Spring that manages DatTransProd entities
	 *
	 */
	@Autowired
	IDatTransProdLogic logicDatTransProd1;

	/**
	 * Logic injected by Spring that manages Labor entities
	 *
	 */
	@Autowired
	ILaborLogic logicLabor2;

	/**
	 * Logic injected by Spring that manages Nivel2 entities
	 *
	 */
	@Autowired
	INivel2Logic logicNivel23;

	/**
	 * Logic injected by Spring that manages Nivel4 entities
	 *
	 */
	@Autowired
	INivel4Logic logicNivel44;

	/**
	 * Logic injected by Spring that manages Trabajador entities
	 *
	 */
	@Autowired
	ITrabajadorLogic logicTrabajador5;

	/**
	 * Logic injected by Spring that manages UdadMed entities
	 *
	 */
	@Autowired
	IUdadMedLogic logicUdadMed6;

	@Override
	@Transactional(readOnly = true)
	public List<DatTransProdTrabajadores> getDatTransProdTrabajadores() throws Exception {
		log.debug("finding all DatTransProdTrabajadores instances");

		List<DatTransProdTrabajadores> list = new ArrayList<DatTransProdTrabajadores>();

		try {
			list = datTransProdTrabajadoresDAO.findAll();
		} catch (Exception e) {
			log.error("finding all DatTransProdTrabajadores failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "DatTransProdTrabajadores");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveDatTransProdTrabajadores(DatTransProdTrabajadores entity) throws Exception {
		log.debug("saving DatTransProdTrabajadores instance");

		try {
			if (entity.getDatTransProd() == null) {
				throw new ZMessManager().new ForeignException("datTransProd");
			}

			if (entity.getLabor() == null) {
				throw new ZMessManager().new ForeignException("labor");
			}

			if (entity.getNivel2() == null) {
				throw new ZMessManager().new ForeignException("nivel2");
			}

			if (entity.getNivel4() == null) {
				throw new ZMessManager().new ForeignException("nivel4");
			}

			if (entity.getTrabajador() == null) {
				throw new ZMessManager().new ForeignException("trabajador");
			}

			if (entity.getUdadMed() == null) {
				throw new ZMessManager().new ForeignException("udadMed");
			}

			if ((entity.getCantidadDescontar() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCantidadDescontar(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cantidadDescontar");
			}

			if ((entity.getCantidadPago() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCantidadPago(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cantidadPago");
			}

			if ((entity.getCantidadProd() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCantidadProd(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cantidadProd");
			}

			if ((entity.getCeptoNominaId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCeptoNominaId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("ceptoNominaId");
			}

			if ((entity.getCierreCostos() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCierreCostos(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("cierreCostos");
			}

			if ((entity.getContratistaId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getContratistaId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("contratistaId");
			}

			if ((entity.getCostoTotal() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCostoTotal(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("costoTotal");
			}

			if (entity.getDatTransProdTrabajadoresId() == null) {
				throw new ZMessManager().new EmptyFieldException("datTransProdTrabajadoresId");
			}

			if ((entity.getDatTransProdTrabajadoresId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getDatTransProdTrabajadoresId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("datTransProdTrabajadoresId");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getEtapaId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEtapaId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("etapaId");
			}

			if ((entity.getMalla1() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getMalla1(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("malla1");
			}

			if ((entity.getMalla2() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getMalla2(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("malla2");
			}

			if ((entity.getMalla3() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getMalla3(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("malla3");
			}

			if ((entity.getMalla4() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getMalla4(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("malla4");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacion(), 1000) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacion");
			}

			if ((entity.getPesoPromedio() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getPesoPromedio(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("pesoPromedio");
			}

			if ((entity.getUdadMedProd() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getUdadMedProd(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("udadMedProd");
			}

			if ((entity.getValorUnitario() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getValorUnitario(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("valorUnitario");
			}

			if ((entity.getVariedId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariedId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("variedId");
			}

			if (entity.getLabor().getLaborId() == null) {
				throw new ZMessManager().new EmptyFieldException("laborId_Labor");
			}

			if ((entity.getLabor().getLaborId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getLabor().getLaborId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("laborId_Labor");
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

			if (entity.getTrabajador().getTrabId() == null) {
				throw new ZMessManager().new EmptyFieldException("trabId_Trabajador");
			}

			if ((entity.getTrabajador().getTrabId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTrabajador().getTrabId(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("trabId_Trabajador");
			}

			if (entity.getUdadMed().getUdadMedId() == null) {
				throw new ZMessManager().new EmptyFieldException("udadMedId_UdadMed");
			}

			if ((entity.getUdadMed().getUdadMedId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getUdadMed().getUdadMedId(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("udadMedId_UdadMed");
			}


			datTransProdTrabajadoresDAO.save(entity);

			log.debug("save DatTransProdTrabajadores successful");
		} catch (Exception e) {
			log.error("save DatTransProdTrabajadores failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteDatTransProdTrabajadores(DatTransProdTrabajadores entity) throws Exception {
		log.debug("deleting DatTransProdTrabajadores instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("DatTransProdTrabajadores");
		}

		if (entity.getDatTransProdTrabajadoresId() == null) {
			throw new ZMessManager().new EmptyFieldException("datTransProdTrabajadoresId");
		}

		try {
			datTransProdTrabajadoresDAO.delete(entity);

			log.debug("delete DatTransProdTrabajadores successful");
		} catch (Exception e) {
			log.error("delete DatTransProdTrabajadores failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateDatTransProdTrabajadores(DatTransProdTrabajadores entity) throws Exception {
		log.debug("updating DatTransProdTrabajadores instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("DatTransProdTrabajadores");
			}

			if (entity.getLabor() == null) {
				throw new ZMessManager().new ForeignException("labor");
			}

			if (entity.getNivel2() == null) {
				throw new ZMessManager().new ForeignException("nivel2");
			}

			if (entity.getNivel4() == null) {
				throw new ZMessManager().new ForeignException("nivel4");
			}

			if (entity.getTrabajador() == null) {
				throw new ZMessManager().new ForeignException("trabajador");
			}

			if (entity.getUdadMed() == null) {
				throw new ZMessManager().new ForeignException("udadMed");
			}

			if ((entity.getCantidadDescontar() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCantidadDescontar(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cantidadDescontar");
			}

			if ((entity.getCantidadPago() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCantidadPago(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cantidadPago");
			}

			if ((entity.getCantidadProd() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCantidadProd(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cantidadProd");
			}

//			if ((entity.getCeptoNominaId() != null) && (Utilities
//					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCeptoNominaId(), 18, 0) == false)) {
//				throw new ZMessManager().new NotValidFormatException("ceptoNominaId");
//			}

			if ((entity.getCierreCostos() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCierreCostos(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("cierreCostos");
			}

//			if ((entity.getContratistaId() != null) && (Utilities
//					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getContratistaId(), 18, 0) == false)) {
//				throw new ZMessManager().new NotValidFormatException("contratistaId");
//			}

			if ((entity.getCostoTotal() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCostoTotal(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("costoTotal");
			}

			if (entity.getDatTransProdTrabajadoresId() == null) {
				throw new ZMessManager().new EmptyFieldException("datTransProdTrabajadoresId");
			}

			if ((entity.getDatTransProdTrabajadoresId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getDatTransProdTrabajadoresId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("datTransProdTrabajadoresId");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getEtapaId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEtapaId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("etapaId");
			}

			if ((entity.getMalla1() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getMalla1(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("malla1");
			}

			if ((entity.getMalla2() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getMalla2(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("malla2");
			}

			if ((entity.getMalla3() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getMalla3(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("malla3");
			}

			if ((entity.getMalla4() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getMalla4(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("malla4");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacion(), 1000) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacion");
			}

			if ((entity.getPesoPromedio() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getPesoPromedio(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("pesoPromedio");
			}

//			if ((entity.getUdadMedProd() != null) && (Utilities
//					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getUdadMedProd(), 18, 0) == false)) {
//				throw new ZMessManager().new NotValidFormatException("udadMedProd");
//			}

			if ((entity.getValorUnitario() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getValorUnitario(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("valorUnitario");
			}

//			if ((entity.getVariedId() != null) && (Utilities
//					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariedId(), 18, 0) == false)) {
//				throw new ZMessManager().new NotValidFormatException("variedId");
//			}

			if (entity.getLabor().getLaborId() == null) {
				throw new ZMessManager().new EmptyFieldException("laborId_Labor");
			}

//			if ((entity.getLabor().getLaborId() != null) && (Utilities
//					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getLabor().getLaborId(), 18, 0) == false)) {
//				throw new ZMessManager().new NotValidFormatException("laborId_Labor");
//			}

			if (entity.getNivel2().getNivel2Id() == null) {
				throw new ZMessManager().new EmptyFieldException("nivel2Id_Nivel2");
			}

//			if ((entity.getNivel2().getNivel2Id() != null) && (Utilities
//					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivel2().getNivel2Id(), 18, 0) == false)) {
//				throw new ZMessManager().new NotValidFormatException("nivel2Id_Nivel2");
//			}

			if (entity.getNivel4().getNivel4Id() == null) {
				throw new ZMessManager().new EmptyFieldException("nivel4Id_Nivel4");
			}

//			if ((entity.getNivel4().getNivel4Id() != null) && (Utilities
//					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivel4().getNivel4Id(), 18, 0) == false)) {
//				throw new ZMessManager().new NotValidFormatException("nivel4Id_Nivel4");
//			}

			if (entity.getTrabajador().getTrabId() == null) {
				throw new ZMessManager().new EmptyFieldException("trabId_Trabajador");
			}

//			if ((entity.getTrabajador().getTrabId() != null)
//					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTrabajador().getTrabId(), 18,
//							0) == false)) {
//				throw new ZMessManager().new NotValidFormatException("trabId_Trabajador");
//			}

			if (entity.getUdadMed().getUdadMedId() == null) {
				throw new ZMessManager().new EmptyFieldException("udadMedId_UdadMed");
			}

//			if ((entity.getUdadMed().getUdadMedId() != null)
//					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getUdadMed().getUdadMedId(), 18,
//							0) == false)) {
//				throw new ZMessManager().new NotValidFormatException("udadMedId_UdadMed");
//			}

			datTransProdTrabajadoresDAO.update(entity);

			log.debug("update DatTransProdTrabajadores successful");
		} catch (Exception e) {
			log.error("update DatTransProdTrabajadores failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatTransProdTrabajadoresDTO> getDataDatTransProdTrabajadores() throws Exception {
		try {
			List<DatTransProdTrabajadores> datTransProdTrabajadores = datTransProdTrabajadoresDAO.findAll();

			List<DatTransProdTrabajadoresDTO> datTransProdTrabajadoresDTO = new ArrayList<DatTransProdTrabajadoresDTO>();

			for (DatTransProdTrabajadores datTransProdTrabajadoresTmp : datTransProdTrabajadores) {
				DatTransProdTrabajadoresDTO datTransProdTrabajadoresDTO2 = new DatTransProdTrabajadoresDTO();

				datTransProdTrabajadoresDTO2
						.setDatTransProdTrabajadoresId(datTransProdTrabajadoresTmp.getDatTransProdTrabajadoresId());
				datTransProdTrabajadoresDTO2
						.setCantidadDescontar((datTransProdTrabajadoresTmp.getCantidadDescontar() != null)
								? datTransProdTrabajadoresTmp.getCantidadDescontar() : null);
				datTransProdTrabajadoresDTO2.setCantidadPago((datTransProdTrabajadoresTmp.getCantidadPago() != null)
						? datTransProdTrabajadoresTmp.getCantidadPago() : null);
				datTransProdTrabajadoresDTO2.setCantidadProd((datTransProdTrabajadoresTmp.getCantidadProd() != null)
						? datTransProdTrabajadoresTmp.getCantidadProd() : null);
				datTransProdTrabajadoresDTO2.setCierreCostos((datTransProdTrabajadoresTmp.getCierreCostos() != null)
						? datTransProdTrabajadoresTmp.getCierreCostos() : null);
				datTransProdTrabajadoresDTO2.setContratistaId((datTransProdTrabajadoresTmp.getContratistaId() != null)
						? datTransProdTrabajadoresTmp.getContratistaId() : null);
				datTransProdTrabajadoresDTO2.setCostoTotal((datTransProdTrabajadoresTmp.getCostoTotal() != null)
						? datTransProdTrabajadoresTmp.getCostoTotal() : null);
				datTransProdTrabajadoresDTO2.setEstado((datTransProdTrabajadoresTmp.getEstado() != null)
						? datTransProdTrabajadoresTmp.getEstado() : null);
				datTransProdTrabajadoresDTO2.setEtapaId((datTransProdTrabajadoresTmp.getEtapaId() != null)
						? datTransProdTrabajadoresTmp.getEtapaId() : null);
				datTransProdTrabajadoresDTO2.setFechaCreacion(datTransProdTrabajadoresTmp.getFechaCreacion());
				datTransProdTrabajadoresDTO2.setFechaModificacion(datTransProdTrabajadoresTmp.getFechaModificacion());
				datTransProdTrabajadoresDTO2.setMalla1((datTransProdTrabajadoresTmp.getMalla1() != null)
						? datTransProdTrabajadoresTmp.getMalla1() : null);
				datTransProdTrabajadoresDTO2.setMalla2((datTransProdTrabajadoresTmp.getMalla2() != null)
						? datTransProdTrabajadoresTmp.getMalla2() : null);
				datTransProdTrabajadoresDTO2.setMalla3((datTransProdTrabajadoresTmp.getMalla3() != null)
						? datTransProdTrabajadoresTmp.getMalla3() : null);
				datTransProdTrabajadoresDTO2.setMalla4((datTransProdTrabajadoresTmp.getMalla4() != null)
						? datTransProdTrabajadoresTmp.getMalla4() : null);
				datTransProdTrabajadoresDTO2.setObservacion((datTransProdTrabajadoresTmp.getObservacion() != null)
						? datTransProdTrabajadoresTmp.getObservacion() : null);
				datTransProdTrabajadoresDTO2.setPesoPromedio((datTransProdTrabajadoresTmp.getPesoPromedio() != null)
						? datTransProdTrabajadoresTmp.getPesoPromedio() : null);
				datTransProdTrabajadoresDTO2.setUdadMedProd((datTransProdTrabajadoresTmp.getUdadMedProd() != null)
						? datTransProdTrabajadoresTmp.getUdadMedProd() : null);
				datTransProdTrabajadoresDTO2.setValorUnitario((datTransProdTrabajadoresTmp.getValorUnitario() != null)
						? datTransProdTrabajadoresTmp.getValorUnitario() : null);
				datTransProdTrabajadoresDTO2.setVariedId((datTransProdTrabajadoresTmp.getVariedId() != null)
						? datTransProdTrabajadoresTmp.getVariedId() : null);
				datTransProdTrabajadoresDTO2.setDatTransProdId_DatTransProd(
						(datTransProdTrabajadoresTmp.getDatTransProd().getDatTransProdId() != null)
								? datTransProdTrabajadoresTmp.getDatTransProd().getDatTransProdId() : null);


				if (datTransProdTrabajadoresTmp.getCeptoNominaId() != null) {
					datTransProdTrabajadoresDTO2.setCeptoNominaId(datTransProdTrabajadoresTmp.getCeptoNominaId());
				} else {
					datTransProdTrabajadoresDTO2.setCeptoNominaId(null);
				}

				if (datTransProdTrabajadoresTmp.getLabor() != null) {
					datTransProdTrabajadoresDTO2.setLaborId_Labor(datTransProdTrabajadoresTmp.getLabor());
				} else {
					datTransProdTrabajadoresDTO2.setLaborId_Labor(null);
				}

				if (datTransProdTrabajadoresTmp.getNivel2() != null) {
					datTransProdTrabajadoresDTO2
							.setNivel2Id_Nivel2(datTransProdTrabajadoresTmp.getNivel2());
				} else {
					datTransProdTrabajadoresDTO2.setNivel2Id_Nivel2(null);
				}

				if (datTransProdTrabajadoresTmp.getNivel4() != null) {
					datTransProdTrabajadoresDTO2
							.setNivel4Id_Nivel4(datTransProdTrabajadoresTmp.getNivel4());
				} else {
					datTransProdTrabajadoresDTO2.setNivel4Id_Nivel4(null);
				}

				if (datTransProdTrabajadoresTmp.getTrabajador() != null) {
					datTransProdTrabajadoresDTO2
							.setTrabId_Trabajador(datTransProdTrabajadoresTmp.getTrabajador());
				} else {
					datTransProdTrabajadoresDTO2.setTrabId_Trabajador(null);
				}

				if (datTransProdTrabajadoresTmp.getUdadMed() != null) {
					datTransProdTrabajadoresDTO2
							.setUdadMedId_UdadMed(datTransProdTrabajadoresTmp.getUdadMed());
				} else {
					datTransProdTrabajadoresDTO2.setUdadMedId_UdadMed(null);
				}

				
				
				datTransProdTrabajadoresDTO.add(datTransProdTrabajadoresDTO2);
			}

			return datTransProdTrabajadoresDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public DatTransProdTrabajadores getDatTransProdTrabajadores(Long datTransProdTrabajadoresId) throws Exception {
		log.debug("getting DatTransProdTrabajadores instance");

		DatTransProdTrabajadores entity = null;

		try {
			entity = datTransProdTrabajadoresDAO.findById(datTransProdTrabajadoresId);
		} catch (Exception e) {
			log.error("get DatTransProdTrabajadores failed", e);
			throw new ZMessManager().new FindingException("DatTransProdTrabajadores");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatTransProdTrabajadores> findPageDatTransProdTrabajadores(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		List<DatTransProdTrabajadores> entity = null;

		try {
			entity = datTransProdTrabajadoresDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatTransProdTrabajadores Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberDatTransProdTrabajadores() throws Exception {
		Long entity = null;

		try {
			entity = datTransProdTrabajadoresDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatTransProdTrabajadores Count");
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
	public List<DatTransProdTrabajadores> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<DatTransProdTrabajadores> list = new ArrayList<DatTransProdTrabajadores>();
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
			list = datTransProdTrabajadoresDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public List<DatTransProdTrabajadoresDTO> getDataDatTransProdTrabajadoresByTrabajador(Long  datTransProdId) throws Exception {
		try {
			List<DatTransProdTrabajadores> datTransProdTrabajadores = datTransProdTrabajadoresDAO.findByCriteria("datTransProd.datTransProdId= " + datTransProdId);


			List<DatTransProdTrabajadoresDTO> datTransProdTrabajadoresDTO = new ArrayList<DatTransProdTrabajadoresDTO>();

			for (DatTransProdTrabajadores datTransProdTrabajadoresTmp : datTransProdTrabajadores) {
				DatTransProdTrabajadoresDTO datTransProdTrabajadoresDTO2 = new DatTransProdTrabajadoresDTO();

				datTransProdTrabajadoresDTO2
						.setDatTransProdTrabajadoresId(datTransProdTrabajadoresTmp.getDatTransProdTrabajadoresId());
				datTransProdTrabajadoresDTO2
						.setCantidadDescontar((datTransProdTrabajadoresTmp.getCantidadDescontar() != null)
								? datTransProdTrabajadoresTmp.getCantidadDescontar() : null);
				datTransProdTrabajadoresDTO2.setCantidadPago((datTransProdTrabajadoresTmp.getCantidadPago() != null)
						? datTransProdTrabajadoresTmp.getCantidadPago() : null);
				datTransProdTrabajadoresDTO2.setCantidadProd((datTransProdTrabajadoresTmp.getCantidadProd() != null)
						? datTransProdTrabajadoresTmp.getCantidadProd() : null);
				datTransProdTrabajadoresDTO2.setCierreCostos((datTransProdTrabajadoresTmp.getCierreCostos() != null)
						? datTransProdTrabajadoresTmp.getCierreCostos() : null);
				datTransProdTrabajadoresDTO2.setContratistaId((datTransProdTrabajadoresTmp.getContratistaId() != null)
						? datTransProdTrabajadoresTmp.getContratistaId() : null);
				datTransProdTrabajadoresDTO2.setCostoTotal((datTransProdTrabajadoresTmp.getCostoTotal() != null)
						? datTransProdTrabajadoresTmp.getCostoTotal() : null);
				datTransProdTrabajadoresDTO2.setEstado((datTransProdTrabajadoresTmp.getEstado() != null)
						? datTransProdTrabajadoresTmp.getEstado() : null);
				datTransProdTrabajadoresDTO2.setEtapaId((datTransProdTrabajadoresTmp.getEtapaId() != null)
						? datTransProdTrabajadoresTmp.getEtapaId() : null);
				datTransProdTrabajadoresDTO2.setFechaCreacion(datTransProdTrabajadoresTmp.getFechaCreacion());
				datTransProdTrabajadoresDTO2.setFechaModificacion(datTransProdTrabajadoresTmp.getFechaModificacion());
				datTransProdTrabajadoresDTO2.setMalla1((datTransProdTrabajadoresTmp.getMalla1() != null)
						? datTransProdTrabajadoresTmp.getMalla1() : null);
				datTransProdTrabajadoresDTO2.setMalla2((datTransProdTrabajadoresTmp.getMalla2() != null)
						? datTransProdTrabajadoresTmp.getMalla2() : null);
				datTransProdTrabajadoresDTO2.setMalla3((datTransProdTrabajadoresTmp.getMalla3() != null)
						? datTransProdTrabajadoresTmp.getMalla3() : null);
				datTransProdTrabajadoresDTO2.setMalla4((datTransProdTrabajadoresTmp.getMalla4() != null)
						? datTransProdTrabajadoresTmp.getMalla4() : null);
				datTransProdTrabajadoresDTO2.setObservacion((datTransProdTrabajadoresTmp.getObservacion() != null)
						? datTransProdTrabajadoresTmp.getObservacion() : null);
				datTransProdTrabajadoresDTO2.setPesoPromedio((datTransProdTrabajadoresTmp.getPesoPromedio() != null)
						? datTransProdTrabajadoresTmp.getPesoPromedio() : null);
				datTransProdTrabajadoresDTO2.setUdadMedProd((datTransProdTrabajadoresTmp.getUdadMedProd() != null)
						? datTransProdTrabajadoresTmp.getUdadMedProd() : null);
				datTransProdTrabajadoresDTO2.setValorUnitario((datTransProdTrabajadoresTmp.getValorUnitario() != null)
						? datTransProdTrabajadoresTmp.getValorUnitario() : null);
				datTransProdTrabajadoresDTO2.setVariedId((datTransProdTrabajadoresTmp.getVariedId() != null)
						? datTransProdTrabajadoresTmp.getVariedId() : null);
				datTransProdTrabajadoresDTO2.setDatTransProdId_DatTransProd(
						(datTransProdTrabajadoresTmp.getDatTransProd().getDatTransProdId() != null)
								? datTransProdTrabajadoresTmp.getDatTransProd().getDatTransProdId() : null);


				if (datTransProdTrabajadoresTmp.getCeptoNominaId() != null) {
					datTransProdTrabajadoresDTO2.setCeptoNominaId(datTransProdTrabajadoresTmp.getCeptoNominaId());
				} else {
					datTransProdTrabajadoresDTO2.setCeptoNominaId(null);
				}

				if (datTransProdTrabajadoresTmp.getLabor() != null) {
					datTransProdTrabajadoresDTO2.setLaborId_Labor(datTransProdTrabajadoresTmp.getLabor());
				} else {
					datTransProdTrabajadoresDTO2.setLaborId_Labor(null);
				}

				if (datTransProdTrabajadoresTmp.getNivel2() != null) {
					datTransProdTrabajadoresDTO2
							.setNivel2Id_Nivel2(datTransProdTrabajadoresTmp.getNivel2());
				} else {
					datTransProdTrabajadoresDTO2.setNivel2Id_Nivel2(null);
				}

				if (datTransProdTrabajadoresTmp.getNivel4() != null) {
					datTransProdTrabajadoresDTO2
							.setNivel4Id_Nivel4(datTransProdTrabajadoresTmp.getNivel4());
				} else {
					datTransProdTrabajadoresDTO2.setNivel4Id_Nivel4(null);
				}

				if (datTransProdTrabajadoresTmp.getTrabajador() != null) {
					datTransProdTrabajadoresDTO2
							.setTrabId_Trabajador(datTransProdTrabajadoresTmp.getTrabajador());
				} else {
					datTransProdTrabajadoresDTO2.setTrabId_Trabajador(null);
				}

				if (datTransProdTrabajadoresTmp.getUdadMed() != null) {
					datTransProdTrabajadoresDTO2
							.setUdadMedId_UdadMed(datTransProdTrabajadoresTmp.getUdadMed());
				} else {
					datTransProdTrabajadoresDTO2.setUdadMedId_UdadMed(null);
				}

				/************************/
				if (datTransProdTrabajadoresTmp.getCeptoNominaId() != null) {
					datTransProdTrabajadoresDTO2.setCodigoConceptoNomina(datTransProdTrabajadoresTmp.getCeptoNominaId().getCodigo());
				} else {
					datTransProdTrabajadoresDTO2.setCodigoConceptoNomina(null);
				}

				if (datTransProdTrabajadoresTmp.getLabor() != null) {
					datTransProdTrabajadoresDTO2.setCodigoLabor(datTransProdTrabajadoresTmp.getLabor().getCodigo());
				} else {
					datTransProdTrabajadoresDTO2.setCodigoLabor(null);
				}

				if (datTransProdTrabajadoresTmp.getNivel2() != null) {
					datTransProdTrabajadoresDTO2
							.setCodigoNivel2(datTransProdTrabajadoresTmp.getNivel2().getNombre());
				} else {
					datTransProdTrabajadoresDTO2.setCodigoNivel2(null);
				}

				if (datTransProdTrabajadoresTmp.getNivel4() != null) {
					datTransProdTrabajadoresDTO2
							.setCodigoNivel4(datTransProdTrabajadoresTmp.getNivel4().getNombre());
				} else {
					datTransProdTrabajadoresDTO2.setCodigoNivel4(null);
				}

				if (datTransProdTrabajadoresTmp.getTrabajador() != null) {
					datTransProdTrabajadoresDTO2
							.setCodigoTrabajador(datTransProdTrabajadoresTmp.getTrabajador().getCodigo());
				} else {
					datTransProdTrabajadoresDTO2.setCodigoTrabajador(null);
				}

				if (datTransProdTrabajadoresTmp.getUdadMed() != null) {
					datTransProdTrabajadoresDTO2
							.setCodigoUdadMed(datTransProdTrabajadoresTmp.getUdadMed().getCodigo());
				} else {
					datTransProdTrabajadoresDTO2.setCodigoUdadMed(null);
				}
				
				datTransProdTrabajadoresDTO.add(datTransProdTrabajadoresDTO2);
			}

			return datTransProdTrabajadoresDTO;
		} catch (Exception e) {
			throw e;
		}
	}

}
