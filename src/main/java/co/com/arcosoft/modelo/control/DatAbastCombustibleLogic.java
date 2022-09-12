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

import co.com.arcosoft.dataaccess.dao.IDatAbastCombustibleDAO;
import co.com.arcosoft.dataaccess.dao.IEquipoDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatAbastCombustible;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.Medidor;
import co.com.arcosoft.modelo.dto.DatAbastCombustibleDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("DatAbastCombustibleLogic")
public class DatAbastCombustibleLogic implements IDatAbastCombustibleLogic {
	private static final Logger log = LoggerFactory.getLogger(DatAbastCombustibleLogic.class);

	/**
	 * DAO injected by Spring that manages DatAbastCombustible entities
	 *
	 */
	@Autowired
	private IDatAbastCombustibleDAO datAbastCombustibleDAO;

	/**
	 * Logic injected by Spring that manages BombaAbastecimiento entities
	 *
	 */
	@Autowired
	IBombaAbastecimientoLogic logicBombaAbastecimiento1;

	/**
	 * Logic injected by Spring that manages CentCost entities
	 *
	 */
	@Autowired
	ICentCostLogic logicCentCost2;

	/**
	 * Logic injected by Spring that manages Equipo entities
	 *
	 */
	@Autowired
	IEquipoLogic logicEquipo3;

	/**
	 * Logic injected by Spring that manages Producto entities
	 *
	 */
	@Autowired
	IProductoLogic logicProducto4;

	/**
	 * Logic injected by Spring that manages TipoAbastecimiento entities
	 *
	 */
	@Autowired
	ITipoAbastecimientoLogic logicTipoAbastecimiento5;

	/**
	 * Logic injected by Spring that manages Trabajador entities
	 *
	 */
	@Autowired
	ITrabajadorLogic logicTrabajador6;

	/**
	 * Logic injected by Spring that manages UdadMed entities
	 *
	 */
	@Autowired
	IUdadMedLogic logicUdadMed7;

	@Autowired
	IMedidorLogic logicMedidor;

	@Autowired
	private IEquipoDAO equipoProdDAO;

	@Override
	@Transactional(readOnly = true)
	public List<DatAbastCombustible> getDatAbastCombustible() throws Exception {
		log.debug("finding all DatAbastCombustible instances");

		List<DatAbastCombustible> list = new ArrayList<DatAbastCombustible>();

		try {
			list = datAbastCombustibleDAO.findAll();
		} catch (Exception e) {
			log.error("finding all DatAbastCombustible failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "DatAbastCombustible");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveDatAbastCombustible(DatAbastCombustible entity) throws Exception {
		log.debug("saving DatAbastCombustible instance");

		try {
		
			if (entity.getEquipo() == null) {
				throw new ZMessManager().new ForeignException("equipo");
			}

			if (entity.getProducto() == null) {
				throw new ZMessManager().new ForeignException("producto");
			}

		
			if (entity.getTrabajador() == null) {
				throw new ZMessManager().new ForeignException("trabajador");
			}

			if (entity.getUdadMed() == null) {
				throw new ZMessManager().new ForeignException("udadMed");
			}

			if ((entity.getCantidad() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCantidad(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cantidad");
			}

			if ((entity.getCierreOt() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCierreOt(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("cierreOt");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getConductor() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getConductor(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("conductor");
			}

			if ((entity.getConsecutivo() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getConsecutivo(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("consecutivo");
			}

			if ((entity.getCostoTotal() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCostoTotal(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("costoTotal");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getMedidor() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getMedidor(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("medidor");
			}

			if ((entity.getNumeroPlanillaFisica() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumeroPlanillaFisica(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("numeroPlanillaFisica");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacion(), 3000) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacion");
			}

			if ((entity.getObservacionAnularReg() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacionAnularReg(), 500) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacionAnularReg");
			}

			if ((entity.getTurnoCampoId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTurnoCampoId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("turnoCampoId");
			}

			if ((entity.getUsuarioDigitacion() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getUsuarioDigitacion(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("usuarioDigitacion");
			}

			if ((entity.getValorUnitario() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getValorUnitario(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("valorUnitario");
			}

			if (entity.getEquipo().getEquipoId() == null) {
				throw new ZMessManager().new EmptyFieldException("equipoId_Equipo");
			}

			if ((entity.getEquipo().getEquipoId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEquipo().getEquipoId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("equipoId_Equipo");
			}

			if (entity.getProducto().getProductoId() == null) {
				throw new ZMessManager().new EmptyFieldException("productoId_Producto");
			}

			if ((entity.getProducto().getProductoId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getProducto().getProductoId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("productoId_Producto");
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
			/*******
			 * Actualizar Medidor Km o Hr Equipo
			 *******/
			/*
			 * 
			 * Equipo equipo = logicEquipo3.getEquipo(entity.getEquipo().getEquipoId());
			 * 
			 * Medidor medidor = logicMedidor.getMedidor( equipo.getMedidor().longValue());
			 * 
			 * if(medidor.getTipoMedidor().equals("Horómetro")){
			 * 
			 * equipo.setHorometroActual(entity.getMedidor());
			 * equipo.setFechaUltimoAbastecimiento(entity.getFechaRegistro());
			 * equipoProdDAO.update(equipo);
			 * 
			 * }
			 * 
			 * if(medidor.getTipoMedidor().equals("Odómetro")){
			 * 
			 * equipo.setOdometroActual(entity.getMedidor());
			 * equipo.setFechaUltimoAbastecimiento(entity.getFechaRegistro());
			 * equipoProdDAO.update(equipo);
			 * 
			 * }
			 * 
			 */
			datAbastCombustibleDAO.save(entity);

			log.debug("save DatAbastCombustible successful");
		} catch (Exception e) {
			log.error("save DatAbastCombustible failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteDatAbastCombustible(DatAbastCombustible entity) throws Exception {
		log.debug("deleting DatAbastCombustible instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("DatAbastCombustible");
		}

		if (entity.getDatAbastCombustibleId() == null) {
			throw new ZMessManager().new EmptyFieldException("datAbastCombustibleId");
		}

		try {
			datAbastCombustibleDAO.delete(entity);

			log.debug("delete DatAbastCombustible successful");
		} catch (Exception e) {
			log.error("delete DatAbastCombustible failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateDatAbastCombustible(DatAbastCombustible entity) throws Exception {
		log.debug("updating DatAbastCombustible instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("DatAbastCombustible");
			}

			if (entity.getEquipo() == null) {
				throw new ZMessManager().new ForeignException("equipo");
			}

			if (entity.getProducto() == null) {
				throw new ZMessManager().new ForeignException("producto");
			}

			if (entity.getTrabajador() == null) {
				throw new ZMessManager().new ForeignException("trabajador");
			}

			if (entity.getUdadMed() == null) {
				throw new ZMessManager().new ForeignException("udadMed");
			}

			if ((entity.getCantidad() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCantidad(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cantidad");
			}

			if ((entity.getCierreOt() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCierreOt(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("cierreOt");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getConductor() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getConductor(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("conductor");
			}

			if ((entity.getConsecutivo() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getConsecutivo(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("consecutivo");
			}

			if ((entity.getCostoTotal() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCostoTotal(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("costoTotal");
			}

			if (entity.getDatAbastCombustibleId() == null) {
				throw new ZMessManager().new EmptyFieldException("datAbastCombustibleId");
			}

			if ((entity.getDatAbastCombustibleId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getDatAbastCombustibleId(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("datAbastCombustibleId");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getMedidor() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getMedidor(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("medidor");
			}

			if ((entity.getNumeroPlanillaFisica() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumeroPlanillaFisica(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("numeroPlanillaFisica");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacion(), 3000) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacion");
			}

			if ((entity.getObservacionAnularReg() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacionAnularReg(), 500) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacionAnularReg");
			}

			if ((entity.getTurnoCampoId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTurnoCampoId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("turnoCampoId");
			}

			if ((entity.getUsuarioDigitacion() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getUsuarioDigitacion(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("usuarioDigitacion");
			}

			if ((entity.getValorUnitario() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getValorUnitario(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("valorUnitario");
			}

			if (entity.getEquipo().getEquipoId() == null) {
				throw new ZMessManager().new EmptyFieldException("equipoId_Equipo");
			}

			if ((entity.getEquipo().getEquipoId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEquipo().getEquipoId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("equipoId_Equipo");
			}

			if (entity.getProducto().getProductoId() == null) {
				throw new ZMessManager().new EmptyFieldException("productoId_Producto");
			}

			if ((entity.getProducto().getProductoId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getProducto().getProductoId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("productoId_Producto");
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

			/*******
			 * Actualizar Medidor Km o Hr Equipo
			 *******/

			Equipo equipo = logicEquipo3.getEquipo(entity.getEquipo().getEquipoId());

			Medidor medidor = logicMedidor.getMedidor(equipo.getMedidor().longValue());

			if (medidor.getTipoMedidor().equals("Horómetro")) {

				equipo.setHorometroActual(entity.getMedidor());
				equipo.setFechaUltimoAbastecimiento(entity.getFechaRegistro());
				equipoProdDAO.update(equipo);

			}

			if (medidor.getTipoMedidor().equals("Odómetro")) {

				equipo.setOdometroActual(entity.getMedidor());
				equipo.setFechaUltimoAbastecimiento(entity.getFechaRegistro());
				equipoProdDAO.update(equipo);

			}

			datAbastCombustibleDAO.update(entity);

			log.debug("update DatAbastCombustible successful");
		} catch (Exception e) {
			log.error("update DatAbastCombustible failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatAbastCombustibleDTO> getDataDatAbastCombustible() throws Exception {
		try {
			List<DatAbastCombustible> datAbastCombustible = datAbastCombustibleDAO.findAll();

			List<DatAbastCombustibleDTO> datAbastCombustibleDTO = new ArrayList<DatAbastCombustibleDTO>();

			for (DatAbastCombustible datAbastCombustibleTmp : datAbastCombustible) {
				DatAbastCombustibleDTO datAbastCombustibleDTO2 = new DatAbastCombustibleDTO();

				datAbastCombustibleDTO2.setDatAbastCombustibleId(datAbastCombustibleTmp.getDatAbastCombustibleId());
				datAbastCombustibleDTO2.setCantidad(
						(datAbastCombustibleTmp.getCantidad() != null) ? datAbastCombustibleTmp.getCantidad() : null);
				datAbastCombustibleDTO2.setCierreOt(
						(datAbastCombustibleTmp.getCierreOt() != null) ? datAbastCombustibleTmp.getCierreOt() : null);
				datAbastCombustibleDTO2.setCompania(
						(datAbastCombustibleTmp.getCompania() != null) ? datAbastCombustibleTmp.getCompania() : null);
				datAbastCombustibleDTO2.setConductor(
						(datAbastCombustibleTmp.getConductor() != null) ? datAbastCombustibleTmp.getConductor() : null);
				datAbastCombustibleDTO2.setConsecutivo(
						(datAbastCombustibleTmp.getConsecutivo() != null) ? datAbastCombustibleTmp.getConsecutivo()
								: null);
				datAbastCombustibleDTO2.setCostoTotal(
						(datAbastCombustibleTmp.getCostoTotal() != null) ? datAbastCombustibleTmp.getCostoTotal()
								: null);
				datAbastCombustibleDTO2.setEstado(
						(datAbastCombustibleTmp.getEstado() != null) ? datAbastCombustibleTmp.getEstado() : null);
				datAbastCombustibleDTO2.setFechaAnulacion(datAbastCombustibleTmp.getFechaAnulacion());
				datAbastCombustibleDTO2.setFechaCierreOt(datAbastCombustibleTmp.getFechaCierreOt());
				datAbastCombustibleDTO2.setFechaCreacion(datAbastCombustibleTmp.getFechaCreacion());
				datAbastCombustibleDTO2.setFechaModificacion(datAbastCombustibleTmp.getFechaModificacion());
				datAbastCombustibleDTO2.setFechaReaperturaOt(datAbastCombustibleTmp.getFechaReaperturaOt());
				datAbastCombustibleDTO2.setFechaRegistro(datAbastCombustibleTmp.getFechaRegistro());
				datAbastCombustibleDTO2.setMedidor(
						(datAbastCombustibleTmp.getMedidor() != null) ? datAbastCombustibleTmp.getMedidor() : null);
				datAbastCombustibleDTO2
						.setNumeroPlanillaFisica((datAbastCombustibleTmp.getNumeroPlanillaFisica() != null)
								? datAbastCombustibleTmp.getNumeroPlanillaFisica()
								: null);
				datAbastCombustibleDTO2.setObservacion(
						(datAbastCombustibleTmp.getObservacion() != null) ? datAbastCombustibleTmp.getObservacion()
								: null);
				datAbastCombustibleDTO2
						.setObservacionAnularReg((datAbastCombustibleTmp.getObservacionAnularReg() != null)
								? datAbastCombustibleTmp.getObservacionAnularReg()
								: null);
				datAbastCombustibleDTO2.setUsuarioDigitacion((datAbastCombustibleTmp.getUsuarioDigitacion() != null)
						? datAbastCombustibleTmp.getUsuarioDigitacion()
						: null);
				datAbastCombustibleDTO2.setValorUnitario(
						(datAbastCombustibleTmp.getValorUnitario() != null) ? datAbastCombustibleTmp.getValorUnitario()
								: null);
				
				
				datAbastCombustibleDTO2.setCentCostId_CentCost((datAbastCombustibleTmp.getCentCost() != null)
						? datAbastCombustibleTmp.getCentCost().getCentCostId()
						: null);


				if (datAbastCombustibleTmp.getBombaAbastecimiento() != null) {
					datAbastCombustibleDTO2.setBombaAbastecimientoId_BombaAbastecimiento(datAbastCombustibleTmp.getBombaAbastecimiento().getBombaAbastecimientoId());
				} else {
					datAbastCombustibleDTO2.setBombaAbastecimientoId_BombaAbastecimiento(null);
				}

				
				if (datAbastCombustibleTmp.getEquipo() != null) {
					datAbastCombustibleDTO2.setEquipoId_Equipo(datAbastCombustibleTmp.getEquipo().getEquipoId());
				} else {
					datAbastCombustibleDTO2.setEquipoId_Equipo(null);
				}

				if (datAbastCombustibleTmp.getProducto() != null) {
					datAbastCombustibleDTO2
							.setProductoId_Producto(datAbastCombustibleTmp.getProducto().getProductoId());
				} else {
					datAbastCombustibleDTO2.setProductoId_Producto(null);
				}


				if (datAbastCombustibleTmp.getTipoAbastecimiento() != null) {
					datAbastCombustibleDTO2.setTipoAbastecimientoId_TipoAbastecimiento(datAbastCombustibleTmp.getTipoAbastecimiento().getTipoAbastecimientoId());
				} else {
					datAbastCombustibleDTO2.setTipoAbastecimientoId_TipoAbastecimiento(null);
				}


				if (datAbastCombustibleTmp.getTrabajador() != null) {
					datAbastCombustibleDTO2.setTrabId_Trabajador(datAbastCombustibleTmp.getTrabajador().getTrabId());
				} else {
					datAbastCombustibleDTO2.setTrabId_Trabajador(null);
				}

				datAbastCombustibleDTO2
						.setUdadMedId_UdadMed((datAbastCombustibleTmp.getUdadMed().getUdadMedId() != null)
								? datAbastCombustibleTmp.getUdadMed().getUdadMedId()
								: null);

				datAbastCombustibleDTO2.setTurnoCampoId(
						(datAbastCombustibleTmp.getTurnoCampoId() != null) ? datAbastCombustibleTmp.getTurnoCampoId()
								: null);

				String estadoEstrue = "false";
				if (datAbastCombustibleTmp.getEstado() != null) {
					if (datAbastCombustibleTmp.getEstado().equals("I")) {
						estadoEstrue = "true";
						datAbastCombustibleDTO2.setEstadoTrue(estadoEstrue);
					}
					datAbastCombustibleDTO2.setEstadoTrue(estadoEstrue);
				}

				datAbastCombustibleDTO.add(datAbastCombustibleDTO2);
			}

			return datAbastCombustibleDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public DatAbastCombustible getDatAbastCombustible(Long datAbastCombustibleId) throws Exception {
		log.debug("getting DatAbastCombustible instance");

		DatAbastCombustible entity = null;

		try {
			entity = datAbastCombustibleDAO.findById(datAbastCombustibleId);
		} catch (Exception e) {
			log.error("get DatAbastCombustible failed", e);
			throw new ZMessManager().new FindingException("DatAbastCombustible");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatAbastCombustible> findPageDatAbastCombustible(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		List<DatAbastCombustible> entity = null;

		try {
			entity = datAbastCombustibleDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatAbastCombustible Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberDatAbastCombustible() throws Exception {
		Long entity = null;

		try {
			entity = datAbastCombustibleDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatAbastCombustible Count");
		} finally {
		}

		return entity;
	}

	/**
	 *
	 * @param varibles
	 *            este arreglo debera tener:
	 *
	 *            [0] = String variable = (String) varibles[i]; representa como se
	 *            llama la variable en el pojo
	 *
	 *            [1] = Boolean booVariable = (Boolean) varibles[i + 1]; representa
	 *            si el valor necesita o no ''(comillas simples)usado para campos de
	 *            tipo string
	 *
	 *            [2] = Object value = varibles[i + 2]; representa el valor que se
	 *            va a buscar en la BD
	 *
	 *            [3] = String comparator = (String) varibles[i + 3]; representa que
	 *            tipo de busqueda voy a hacer.., ejemplo: where nombre=william o
	 *            where nombre<>william, en este campo iria el tipo de comparador
	 *            que quiero si es = o <>
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
	 *            [0] = String variable = (String) varibles[j]; la variable ne la BD
	 *            que va a ser buscada en un rango
	 *
	 *            [1] = Object value = varibles[j + 1]; valor 1 para buscar en un
	 *            rango
	 *
	 *            [2] = Object value2 = varibles[j + 2]; valor 2 para buscar en un
	 *            rango ejempolo: a > 1 and a < 5 --> 1 seria value y 5 seria value2
	 *
	 *            [3] = String comparator1 = (String) varibles[j + 3]; comparador 1
	 *            ejemplo: a comparator1 1 and a < 5
	 *
	 *            [4] = String comparator2 = (String) varibles[j + 4]; comparador 2
	 *            ejemplo: a comparador1>1 and a comparador2<5 (el original: a > 1
	 *            and a < 5) *
	 * @param variablesBetweenDates(en
	 *            este caso solo para mysql) [0] = String variable = (String)
	 *            varibles[k]; el nombre de la variable que hace referencia a una
	 *            fecha
	 *
	 *            [1] = Object object1 = varibles[k + 2]; fecha 1 a comparar(deben
	 *            ser dates)
	 *
	 *            [2] = Object object2 = varibles[k + 3]; fecha 2 a comparar(deben
	 *            ser dates)
	 *
	 *            esto hace un between entre las dos fechas.
	 *
	 * @return lista con los objetos que se necesiten
	 * @throws Exception
	 */
	@Override
	@Transactional(readOnly = true)
	public List<DatAbastCombustible> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<DatAbastCombustible> list = new ArrayList<DatAbastCombustible>();
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
			list = datAbastCombustibleDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
