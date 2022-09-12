package co.com.arcosoft.modelo.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.com.arcosoft.dataaccess.dao.IDatAnaTransProdDAO;
import co.com.arcosoft.dataaccess.dao.IDatTransProdDAO;
import co.com.arcosoft.dataaccess.dao.IDatTransProdDetDAO;
import co.com.arcosoft.dataaccess.dao.IDatTransProdNivel4DAO;
import co.com.arcosoft.dataaccess.dao.IDatTransProdTrabajadoresDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatAnaTransProd;
import co.com.arcosoft.modelo.DatTransProd;
import co.com.arcosoft.modelo.DatTransProdDet;
import co.com.arcosoft.modelo.DatTransProdNivel4;
import co.com.arcosoft.modelo.DatTransProdTrabajadores;
import co.com.arcosoft.modelo.Etapa;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.dto.DatTransProdDTO;
import co.com.arcosoft.modelo.dto.DatTransProdDetDTO;
import co.com.arcosoft.modelo.dto.DatTransProdNivel4DTO;
import co.com.arcosoft.modelo.dto.DatTransProdTrabajadoresDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("DatTransProdLogic")
public class DatTransProdLogic implements IDatTransProdLogic {
	private static final Logger log = LoggerFactory.getLogger(DatTransProdLogic.class);

	@Autowired
	private IDatTransProdDAO datTransProdDAO;

	@Autowired
	private IDatAnaTransProdDAO datAnaTransProdDAO;

	@Autowired
	private IDatTransProdDetDAO datTransProdDetDAO;

	@Autowired
	private IDatTransProdNivel4DAO datTransProdNivel4DAO;

	@Autowired
	private IDatTransProdTrabajadoresDAO datTransProdTrabajadoresDAO;
	
	@Autowired
	private IBusinessDelegatorView businessDelegator;

	@Autowired
	IConductorLogic logicConductor2;

	@Autowired
	IFrenteCosLogic logicFrenteCos3;

	@Autowired
	IModalidadCosechaLogic logicModalidadCosecha4;

	@Autowired
	INivel4Logic logicNivel45;

	@Autowired
	ITransportadoraLogic logicTransportadora7;

	@Autowired
	IVehiculosTranspLogic logicVehiculosTransp8;

	@Autowired
	IPersEmprLogic logicPersEmpr15;
	
	@Override
	@Transactional(readOnly = true)
	public List<DatTransProd> getDatTransProd() throws Exception {
		log.debug("finding all DatTransProd instances");

		List<DatTransProd> list = new ArrayList<DatTransProd>();

		try {
			list = datTransProdDAO.findAll();
		} catch (Exception e) {
			log.error("finding all DatTransProd failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "DatTransProd");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveDatTransProd(DatTransProd entity, List<DatTransProdDetDTO> dataDetTransProductos,
			List<DatTransProdNivel4DTO> dataDetTransNivel4,
			List<DatTransProdTrabajadoresDTO> dataPlanillaDet) throws Exception {
		log.debug("saving DatTransProd instance");

		try {

			if ((entity.getAnioFiscalNivel4() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAnioFiscalNivel4(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("anioFiscalNivel4");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getConsecutivo() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getConsecutivo(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("consecutivo");
			}

			if ((entity.getDestinoProduccion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getDestinoProduccion(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("destinoProduccion");
			}

			if ((entity.getEdadNivel4() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEdadNivel4(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("edadNivel4");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getEtapaNivel4() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEtapaNivel4(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("etapaNivel4");
			}

			if ((entity.getFaseFenoNivel4() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getFaseFenoNivel4(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("faseFenoNivel4");
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

			if ((entity.getNivel1Id() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivel1Id(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivel1Id");
			}

			if ((entity.getNivel2Id() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivel2Id(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivel2Id");
			}

			if ((entity.getNivel3Id() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivel3Id(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivel3Id");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacion(), 1000) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacion");
			}

			if ((entity.getObservacionAnularReg() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacionAnularReg(), 500) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacionAnularReg");
			}

			if ((entity.getTipoTransaccion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getTipoTransaccion(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("tipoTransaccion");
			}

			if ((entity.getUsuarioDigitacion() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getUsuarioDigitacion(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("usuarioDigitacion");
			}

			if ((entity.getVariedNivel4() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariedNivel4(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("variedNivel4");
			}

			if ((entity.getEmpresaCompradora() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEmpresaCompradora(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("empresaCompradora");
			}

			if ((entity.getConductor() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getConductor(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("conductorId_Conductor");
			}

			if ((entity.getFrenteCos() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getFrenteCos(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("frtCosId_FrenteCos");
			}

			if ((entity.getModalidadCosecha() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getModalidadCosecha(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("modalidadCosId_ModalidadCosecha");
			}

			if ((entity.getNivel4() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivel4(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivel4Id_Nivel4");
			}

			if ((entity.getProveedor() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getProveedor(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("proveId_Proveedor");
			}

			if ((entity.getTransportadora() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTransportadora(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("transpId_Transportadora");
			}

			if ((entity.getVehiculosTransp() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVehiculosTransp(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("vehiTranspId_VehiculosTransp");
			}

			datTransProdDAO.save(entity);

			if (dataDetTransProductos != null) {

				for (DatTransProdDetDTO valorDto : dataDetTransProductos) {

					if (valorDto.getDatTransProdDetId() == null) {

						DatTransProdDet valor = new DatTransProdDet();

						valor.setProducto(valorDto.getProductoId_Producto());
						valor.setCiudad(valorDto.getCiudadId_Ciudad());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());
						valor.setCliente(valorDto.getClienteId_Cliente());
						valor.setEmpaque(valorDto.getEmpaqueId_Empaque());
						valor.setCantidadReal(valorDto.getCantidadReal());
						valor.setCantidadSolicitada(valorDto.getCantidadSolicitada());
						valor.setRendimiento(valorDto.getRendimiento());
						valor.setValorUnitario(valorDto.getValorUnitario());
						valor.setValorTotal(valorDto.getValorTotal());
						valor.setCantidadKilosLiq(valorDto.getCantidadKilosLiq());
						valor.setValorNeto(valorDto.getValorNeto());
						valor.setValorDeduccion(valorDto.getValorDeduccion());
						valor.setCertificacionAceite(valorDto.getCertificacionAceite());
						valor.setDatTransProd(entity);

						datTransProdDetDAO.save(valor);
					}
				}
			}
			
			if (dataDetTransNivel4 != null) {

				for (DatTransProdNivel4DTO valorDto : dataDetTransNivel4) {

					if (valorDto.getDatTransProdNivel4Id() == null) {

						DatTransProdNivel4 valor = new DatTransProdNivel4();

						valor.setNivel1Id(valorDto.getNivel1Id());
						valor.setNivel2(valorDto.getNivel2Id_Nivel2());
						valor.setNivel3Id(valorDto.getNivel3Id());
						valor.setNivel4(valorDto.getNivel4Id_Nivel4());
						valor.setEtapaNivel4(valorDto.getEtapaNivel4());
						valor.setVariedNivel4(valorDto.getVariedNivel4());
						valor.setEdadNivel4(valorDto.getEdadNivel4());
						valor.setModalidadCosId(valorDto.getModalidadCosId());
						valor.setFinCosecha(valorDto.getFinCosecha());
						valor.setAreaCosechada(valorDto.getAreaCosechada());
						valor.setCantidadCosechada(valorDto.getCantidadCosechada());
						valor.setCantidadCosechadaHa(valorDto.getCantidadCosechadaHa());
						valor.setPorcRendimiento(valorDto.getPorcRendimiento());
						valor.setPorcMateriaExtrana(valorDto.getPorcMateriaExtrana());
						valor.setPorcSacarosa(valorDto.getPorcSacarosa());
						valor.setKilosPorTonelada(valorDto.getKilosPorTonelada());
						valor.setIndicadorDistribuccion(valorDto.getIndicadorDistribuccion());
						valor.setCantidadRacimos(valorDto.getPesoPromedio());
						valor.setPesoPromedio(valorDto.getCantidadRacimos());						
						valor.setFechaInicioCosecha(valorDto.getFechaInicioCosecha());
						valor.setFechaFinCosecha(valorDto.getFechaFinCosecha());
						valor.setProducto(valorDto.getProducto());
						valor.setClienteId(valorDto.getClienteId());						
						valor.setDestinoProduccion(valorDto.getDestinoProduccion());	
						
						valor.setKilogramosAzucarTonelada(valorDto.getKilogramosAzucarTonelada());				
						valor.setValorKilogramosAzucar(valorDto.getValorKilogramosAzucar());						
						valor.setValorUnitario(valorDto.getValorUnitario());						
						valor.setIngresoBruto(valorDto.getIngresoBruto());						
						valor.setAjusteLiquidacion(valorDto.getAjusteLiquidacion());						
						valor.setBonificacion(valorDto.getBonificacion());						
						valor.setOtrosIngresos(valorDto.getOtrosIngresos());						
						valor.setRetenciones(valorDto.getRetenciones());						
						valor.setDescuentos(valor.getDescuentos());						
						valor.setCantidadCosechadaHaMes(valorDto.getCantidadCosechadaHaMes());						
						
						valor.setFondoAgroIndustriaPorcentaje(valorDto.getFondoAgroIndustriaPorcentaje());	
						valor.setDescuentoAdicional1Porcentaje(valorDto.getDescuentoAdicional1Porcentaje());	
						valor.setDescuentoAdicional2Porcentaje(valorDto.getDescuentoAdicional2Porcentaje());	
						
						
						valor.setDatTransProd(entity);

						datTransProdNivel4DAO.save(valor);
					}
				}
			}
			
			
			
			if (dataPlanillaDet != null) {

				for (DatTransProdTrabajadoresDTO valorDto : dataPlanillaDet) {

					if (valorDto.getDatTransProdTrabajadoresId() == null) {

						DatTransProdTrabajadores valor = new DatTransProdTrabajadores();

						valor.setTrabajador(valorDto.getTrabId_Trabajador());
						valor.setCeptoNominaId(valorDto.getCeptoNominaId());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());
						valor.setCostoTotal(valorDto.getCostoTotal());
						valor.setValorUnitario(valorDto.getValorUnitario());
						valor.setCantidadPago(valorDto.getCantidadPago());
						valor.setCantidadDescontar(valorDto.getCantidadDescontar());
						valor.setContratistaId(valorDto.getContratistaId());
						valor.setCantidadProd(valorDto.getCantidadProd());						
						valor.setLabor(valorDto.getLaborId_Labor());
						valor.setNivel2(valorDto.getNivel2Id_Nivel2());
						valor.setNivel4(valorDto.getNivel4Id_Nivel4());
						valor.setPesoPromedio(valorDto.getPesoPromedio());						
						valor.setEtapaId(valorDto.getEtapaId());
						valor.setVariedId(valorDto.getVariedId());												
						valor.setDatTransProd(entity);

						datTransProdTrabajadoresDAO.save(valor);
					}
				}
			}
			log.debug("save DatTransProd successful");
		} catch (Exception e) {
			log.error("save DatTransProd failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteDatTransProd(DatTransProd entity) throws Exception {
		log.debug("deleting DatTransProd instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("DatTransProd");
		}

		if (entity.getDatTransProdId() == null) {
			throw new ZMessManager().new EmptyFieldException("datTransProdId");
		}

		List<DatAnaTransProd> datAnaTransProds = null;
		List<DatTransProdDet> datTransProdDets = null;
		List<DatTransProdNivel4> datTransProdNivel4s = null;
		try {
			datAnaTransProds = datAnaTransProdDAO.findByProperty("datTransProd.datTransProdId",
					entity.getDatTransProdId());

			if (Utilities.validationsList(datAnaTransProds) == true) {
				throw new ZMessManager().new DeletingException("datAnaTransProds");
			}

			datTransProdDets = datTransProdDetDAO.findByProperty("datTransProd.datTransProdId",
					entity.getDatTransProdId());

			if (Utilities.validationsList(datTransProdDets) == true) {
				throw new ZMessManager().new DeletingException("datTransProdDets");
			}

			datTransProdNivel4s = datTransProdNivel4DAO.findByProperty("datTransProd.datTransProdId",
					entity.getDatTransProdId());

			if (Utilities.validationsList(datTransProdNivel4s) == true) {
				throw new ZMessManager().new DeletingException("datTransProdNivel4s");
			}

			datTransProdDAO.delete(entity);

			log.debug("delete DatTransProd successful");
		} catch (Exception e) {
			log.error("delete DatTransProd failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateDatTransProd(DatTransProd entity, List<DatTransProdDetDTO> dataDetTransProductos,
			List<DatTransProdNivel4DTO> dataDetTransNivel4,
			List<DatTransProdTrabajadoresDTO> dataPlanillaDet) throws Exception {
		log.debug("updating DatTransProd instance");

		try {
			if ((entity.getAnioFiscalNivel4() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAnioFiscalNivel4(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("anioFiscalNivel4");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getConsecutivo() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getConsecutivo(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("consecutivo");
			}

			if (entity.getDatTransProdId() == null) {
				throw new ZMessManager().new EmptyFieldException("datTransProdId");
			}

			if ((entity.getDatTransProdId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getDatTransProdId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("datTransProdId");
			}

			if ((entity.getDestinoProduccion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getDestinoProduccion(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("destinoProduccion");
			}

			if ((entity.getEdadNivel4() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEdadNivel4(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("edadNivel4");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getEtapaNivel4() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEtapaNivel4(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("etapaNivel4");
			}

			if ((entity.getFaseFenoNivel4() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getFaseFenoNivel4(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("faseFenoNivel4");
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

			if ((entity.getNivel1Id() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivel1Id(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivel1Id");
			}

			if ((entity.getNivel2Id() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivel2Id(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivel2Id");
			}

			if ((entity.getNivel3Id() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivel3Id(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivel3Id");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacion(), 1000) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacion");
			}

			if ((entity.getObservacionAnularReg() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacionAnularReg(), 500) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacionAnularReg");
			}

			if ((entity.getTipoTransaccion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getTipoTransaccion(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("tipoTransaccion");
			}

			if ((entity.getUsuarioDigitacion() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getUsuarioDigitacion(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("usuarioDigitacion");
			}

			if ((entity.getVariedNivel4() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariedNivel4(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("variedNivel4");
			}

			if ((entity.getEmpresaCompradora() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEmpresaCompradora(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("empresaCompradora");
			}
	
			if ((entity.getConductor() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getConductor(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("conductorId_Conductor");
			}

			if ((entity.getFrenteCos() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getFrenteCos(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("frtCosId_FrenteCos");
			}

			if ((entity.getModalidadCosecha() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getModalidadCosecha(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("modalidadCosId_ModalidadCosecha");
			}

			if ((entity.getNivel4() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivel4(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivel4Id_Nivel4");
			}
		
			if ((entity.getProveedor() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getProveedor(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("proveId_Proveedor");
			}

			if ((entity.getTransportadora() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTransportadora(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("transpId_Transportadora");
			}

			if ((entity.getVehiculosTransp() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVehiculosTransp(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("vehiTranspId_VehiculosTransp");
			}

			datTransProdDAO.update(entity);

			if (dataDetTransProductos != null) {

				for (DatTransProdDetDTO valorDto : dataDetTransProductos) {

					if (valorDto.getDatTransProdDetId() == null) { 

						DatTransProdDet valor = new DatTransProdDet();

						valor.setProducto(valorDto.getProductoId_Producto());
						valor.setCiudad(valorDto.getCiudadId_Ciudad());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());
						valor.setCliente(valorDto.getClienteId_Cliente());
						valor.setEmpaque(valorDto.getEmpaqueId_Empaque());
						valor.setCantidadReal(valorDto.getCantidadReal());
						valor.setCantidadSolicitada(valorDto.getCantidadSolicitada());
						valor.setRendimiento(valorDto.getRendimiento());
						valor.setValorUnitario(valorDto.getValorUnitario());
						valor.setValorTotal(valorDto.getValorTotal());
						valor.setDatTransProd(entity);
						valor.setCantidadKilosLiq(valorDto.getCantidadKilosLiq());
						valor.setValorNeto(valorDto.getValorNeto());
						valor.setValorDeduccion(valorDto.getValorDeduccion());
						valor.setCertificacionAceite(valorDto.getCertificacionAceite());

						datTransProdDetDAO.save(valor);

					} else {
						
						DatTransProdDet valor = datTransProdDetDAO.findById(valorDto.getDatTransProdDetId());

						valor.setProducto(valorDto.getProductoId_Producto());
						valor.setCiudad(valorDto.getCiudadId_Ciudad());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());
						valor.setCliente(valorDto.getClienteId_Cliente());
						valor.setEmpaque(valorDto.getEmpaqueId_Empaque());
						valor.setCantidadReal(valorDto.getCantidadReal());
						valor.setCantidadSolicitada(valorDto.getCantidadSolicitada());
						valor.setRendimiento(valorDto.getRendimiento());
						valor.setValorUnitario(valorDto.getValorUnitario());
						valor.setValorTotal(valorDto.getValorTotal());
						valor.setCantidadKilosLiq(valorDto.getCantidadKilosLiq());
						valor.setValorNeto(valorDto.getValorNeto());
						valor.setValorDeduccion(valorDto.getValorDeduccion());
						valor.setCertificacionAceite(valorDto.getCertificacionAceite());
						valor.setDatTransProd(entity);

						datTransProdDetDAO.update(valor);
					}
				}
			}
			
			if (dataDetTransNivel4 != null) {

				for (DatTransProdNivel4DTO valorDto : dataDetTransNivel4) {

					if (valorDto.getDatTransProdNivel4Id() == null) { 

						DatTransProdNivel4 valor = new DatTransProdNivel4();
						valor.setNivel1Id(valorDto.getNivel1Id());
						valor.setNivel2(valorDto.getNivel2Id_Nivel2());
						valor.setNivel3Id(valorDto.getNivel3Id());
						valor.setNivel4(valorDto.getNivel4Id_Nivel4());
						valor.setEtapaNivel4(valorDto.getEtapaNivel4());
						valor.setVariedNivel4(valorDto.getVariedNivel4());
						valor.setEdadNivel4(valorDto.getEdadNivel4());
						valor.setModalidadCosId(valorDto.getModalidadCosId());
						valor.setFinCosecha(valorDto.getFinCosecha());
						valor.setAreaCosechada(valorDto.getAreaCosechada());
						valor.setCantidadCosechada(valorDto.getCantidadCosechada());
						valor.setCantidadCosechadaHa(valorDto.getCantidadCosechadaHa());
						valor.setPorcRendimiento(valorDto.getPorcRendimiento());
						valor.setPorcMateriaExtrana(valorDto.getPorcMateriaExtrana());
						valor.setPorcSacarosa(valorDto.getPorcSacarosa());
						valor.setKilosPorTonelada(valorDto.getKilosPorTonelada());
						valor.setIndicadorDistribuccion(valorDto.getIndicadorDistribuccion());
						valor.setCantidadRacimos(valorDto.getPesoPromedio());
						valor.setPesoPromedio(valorDto.getCantidadRacimos());
						valor.setFechaInicioCosecha(valorDto.getFechaInicioCosecha());
						valor.setFechaFinCosecha(valorDto.getFechaFinCosecha());
						valor.setProducto(valorDto.getProducto());
						valor.setClienteId(valorDto.getClienteId());
						valor.setDestinoProduccion(valorDto.getDestinoProduccion());
						valor.setKilogramosAzucarTonelada(valorDto.getKilogramosAzucarTonelada());				
						valor.setValorKilogramosAzucar(valorDto.getValorKilogramosAzucar());						
						valor.setValorUnitario(valorDto.getValorUnitario());						
						valor.setIngresoBruto(valorDto.getIngresoBruto());						
						valor.setAjusteLiquidacion(valorDto.getAjusteLiquidacion());						
						valor.setBonificacion(valorDto.getBonificacion());						
						valor.setOtrosIngresos(valorDto.getOtrosIngresos());						
						valor.setRetenciones(valorDto.getRetenciones());						
						valor.setDescuentos(valor.getDescuentos());						
						valor.setCantidadCosechadaHaMes(valorDto.getCantidadCosechadaHaMes());		

						valor.setFondoAgroIndustriaPorcentaje(valorDto.getFondoAgroIndustriaPorcentaje());	
						valor.setDescuentoAdicional1Porcentaje(valorDto.getDescuentoAdicional1Porcentaje());	
						valor.setDescuentoAdicional2Porcentaje(valorDto.getDescuentoAdicional2Porcentaje());	
						
						valor.setDatTransProd(entity);

						datTransProdNivel4DAO.save(valor);

					} else {
						
						DatTransProdNivel4 valor = datTransProdNivel4DAO.findById(valorDto.getDatTransProdNivel4Id());

						valor.setNivel1Id(valorDto.getNivel1Id());
						valor.setNivel2(valorDto.getNivel2Id_Nivel2());
						valor.setNivel3Id(valorDto.getNivel3Id());
						valor.setNivel4(valorDto.getNivel4Id_Nivel4());
						valor.setEtapaNivel4(valorDto.getEtapaNivel4());
						valor.setVariedNivel4(valorDto.getVariedNivel4());
						valor.setEdadNivel4(valorDto.getEdadNivel4());
						valor.setModalidadCosId(valorDto.getModalidadCosId());
						valor.setFinCosecha(valorDto.getFinCosecha());
						valor.setAreaCosechada(valorDto.getAreaCosechada());
						valor.setCantidadCosechada(valorDto.getCantidadCosechada());
						valor.setCantidadCosechadaHa(valorDto.getCantidadCosechadaHa());
						valor.setPorcRendimiento(valorDto.getPorcRendimiento());
						valor.setPorcMateriaExtrana(valorDto.getPorcMateriaExtrana());
						valor.setPorcSacarosa(valorDto.getPorcSacarosa());
						valor.setKilosPorTonelada(valorDto.getKilosPorTonelada());
						valor.setIndicadorDistribuccion(valorDto.getIndicadorDistribuccion());
						valor.setCantidadRacimos(valorDto.getPesoPromedio());
						valor.setPesoPromedio(valorDto.getCantidadRacimos());
						valor.setFechaInicioCosecha(valorDto.getFechaInicioCosecha());
						valor.setFechaFinCosecha(valorDto.getFechaFinCosecha());
						valor.setProducto(valorDto.getProducto());
						valor.setClienteId(valorDto.getClienteId());
						valor.setDestinoProduccion(valorDto.getDestinoProduccion());
						valor.setKilogramosAzucarTonelada(valorDto.getKilogramosAzucarTonelada());				
						valor.setValorKilogramosAzucar(valorDto.getValorKilogramosAzucar());						
						valor.setValorUnitario(valorDto.getValorUnitario());						
						valor.setIngresoBruto(valorDto.getIngresoBruto());						
						valor.setAjusteLiquidacion(valorDto.getAjusteLiquidacion());						
						valor.setBonificacion(valorDto.getBonificacion());						
						valor.setOtrosIngresos(valorDto.getOtrosIngresos());						
						valor.setRetenciones(valorDto.getRetenciones());						
						valor.setDescuentos(valor.getDescuentos());						
						valor.setCantidadCosechadaHaMes(valorDto.getCantidadCosechadaHaMes());		

						valor.setFondoAgroIndustriaPorcentaje(valorDto.getFondoAgroIndustriaPorcentaje());	
						valor.setDescuentoAdicional1Porcentaje(valorDto.getDescuentoAdicional1Porcentaje());	
						valor.setDescuentoAdicional2Porcentaje(valorDto.getDescuentoAdicional2Porcentaje());	
						
						valor.setDatTransProd(entity);

						datTransProdNivel4DAO.update(valor);
					}
				}
			}			
			
	
			
			if (dataPlanillaDet != null) {

				for (DatTransProdTrabajadoresDTO valorDto : dataPlanillaDet) {

					if (valorDto.getDatTransProdTrabajadoresId() == null) {

						DatTransProdTrabajadores valor = new DatTransProdTrabajadores();

						valor.setTrabajador(valorDto.getTrabId_Trabajador());
						valor.setCeptoNominaId(valorDto.getCeptoNominaId());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());
						valor.setCostoTotal(valorDto.getCostoTotal());
						valor.setValorUnitario(valorDto.getValorUnitario());
						valor.setCantidadPago(valorDto.getCantidadPago());
						valor.setCantidadDescontar(valorDto.getCantidadDescontar());
						valor.setContratistaId(valorDto.getContratistaId());
						valor.setCantidadProd(valorDto.getCantidadProd());						
						valor.setLabor(valorDto.getLaborId_Labor());
						valor.setNivel2(valorDto.getNivel2Id_Nivel2());
						valor.setNivel4(valorDto.getNivel4Id_Nivel4());
						valor.setPesoPromedio(valorDto.getPesoPromedio());						
						valor.setEtapaId(valorDto.getEtapaId());
						valor.setVariedId(valorDto.getVariedId());						
						valor.setDatTransProd(entity);
						
						datTransProdTrabajadoresDAO.save(valor);

					} else {
						DatTransProdTrabajadores valor = datTransProdTrabajadoresDAO.findById(valorDto.getDatTransProdTrabajadoresId());

						valor.setTrabajador(valorDto.getTrabId_Trabajador());
						valor.setCeptoNominaId(valorDto.getCeptoNominaId());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());
						valor.setCostoTotal(valorDto.getCostoTotal());
						valor.setValorUnitario(valorDto.getValorUnitario());
						valor.setCantidadPago(valorDto.getCantidadPago());
						valor.setCantidadDescontar(valorDto.getCantidadDescontar());
						valor.setContratistaId(valorDto.getContratistaId());
						valor.setCantidadProd(valorDto.getCantidadProd());						
						valor.setLabor(valorDto.getLaborId_Labor());
						valor.setNivel2(valorDto.getNivel2Id_Nivel2());
						valor.setNivel4(valorDto.getNivel4Id_Nivel4());
						valor.setPesoPromedio(valorDto.getPesoPromedio());						
						valor.setEtapaId(valorDto.getEtapaId());
						valor.setVariedId(valorDto.getVariedId());												
						valor.setDatTransProd(entity);
						
						datTransProdTrabajadoresDAO.update(valor);
					}
				}
			}
			log.debug("update DatTransProd successful");
		} catch (Exception e) {
			log.error("update DatTransProd failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatTransProdDTO> getDataDatTransProd() throws Exception {
		try {
			List<DatTransProd> datTransProd = datTransProdDAO.findAll();

			List<DatTransProdDTO> datTransProdDTO = new ArrayList<DatTransProdDTO>();

			for (DatTransProd datTransProdTmp : datTransProd) {
				DatTransProdDTO datTransProdDTO2 = new DatTransProdDTO();

				datTransProdDTO2.setDatTransProdId(datTransProdTmp.getDatTransProdId());
				datTransProdDTO2.setAnioFiscalNivel4(
						(datTransProdTmp.getAnioFiscalNivel4() != null) ? datTransProdTmp.getAnioFiscalNivel4() : null);
				datTransProdDTO2
						.setCompania((datTransProdTmp.getCompania() != null) ? datTransProdTmp.getCompania() : null);
				datTransProdDTO2.setConsecutivo(
						(datTransProdTmp.getConsecutivo() != null) ? datTransProdTmp.getConsecutivo() : null);
				datTransProdDTO2.setConsecutivoPesoNeto(
						(datTransProdTmp.getConsecutivoPesoNeto() != null) ? datTransProdTmp.getConsecutivoPesoNeto() : null);
				datTransProdDTO2.setDestinoProduccion((datTransProdTmp.getDestinoProduccion() != null)
						? datTransProdTmp.getDestinoProduccion() : null);
				datTransProdDTO2.setEdadNivel4(
						(datTransProdTmp.getEdadNivel4() != null) ? datTransProdTmp.getEdadNivel4() : null);
				datTransProdDTO2.setEstado((datTransProdTmp.getEstado() != null) ? datTransProdTmp.getEstado() : null);
				datTransProdDTO2.setEtapaNivel4(
						(datTransProdTmp.getEtapaNivel4() != null) ? datTransProdTmp.getEtapaNivel4() : null);
				datTransProdDTO2.setFaseFenoNivel4(
						(datTransProdTmp.getFaseFenoNivel4() != null) ? datTransProdTmp.getFaseFenoNivel4() : null);
				datTransProdDTO2.setFechaCreacion(datTransProdTmp.getFechaCreacion());
				datTransProdDTO2.setFechaModificacion(datTransProdTmp.getFechaModificacion());
				datTransProdDTO2.setFechaRegistro(datTransProdTmp.getFechaRegistro());
				datTransProdDTO2.setFechaEstadoVehiculo(datTransProdTmp.getFechaEstadoVehiculo());
				datTransProdDTO2.setObservacion3((datTransProdTmp.getObservacion3() != null)
						? datTransProdTmp.getObservacion3() : null);
				datTransProdDTO2.setInfoAdicional(
						(datTransProdTmp.getInfoAdicional() != null) ? datTransProdTmp.getInfoAdicional() : null);
				datTransProdDTO2.setInfoAdicional2(
						(datTransProdTmp.getInfoAdicional2() != null) ? datTransProdTmp.getInfoAdicional2() : null);
				datTransProdDTO2
						.setMobileId((datTransProdTmp.getMobileId() != null) ? datTransProdTmp.getMobileId() : null);
				datTransProdDTO2
						.setNivel1Id((datTransProdTmp.getNivel1Id() != null) ? datTransProdTmp.getNivel1Id() : null);
				datTransProdDTO2
						.setNivel2Id((datTransProdTmp.getNivel2Id() != null) ? datTransProdTmp.getNivel2Id() : null);
				datTransProdDTO2
						.setNivel3Id((datTransProdTmp.getNivel3Id() != null) ? datTransProdTmp.getNivel3Id() : null);
				datTransProdDTO2.setObservacion(
						(datTransProdTmp.getObservacion() != null) ? datTransProdTmp.getObservacion() : null);
				datTransProdDTO2.setObservacionAnularReg((datTransProdTmp.getObservacionAnularReg() != null)
						? datTransProdTmp.getObservacionAnularReg() : null);
				datTransProdDTO2.setObservacion2((datTransProdTmp.getObservacion2() != null)
						? datTransProdTmp.getObservacion2() : null);
				datTransProdDTO2.setOrigen((datTransProdTmp.getOrigen() != null)
						? datTransProdTmp.getOrigen() : null);
				datTransProdDTO2.setNoDocumento((datTransProdTmp.getNoDocumento() != null)
						? datTransProdTmp.getNoDocumento() : null);
				datTransProdDTO2.setTipoTransaccion(
						(datTransProdTmp.getTipoTransaccion() != null) ? datTransProdTmp.getTipoTransaccion() : null);
				datTransProdDTO2.setUsuarioDigitacion((datTransProdTmp.getUsuarioDigitacion() != null)
						? datTransProdTmp.getUsuarioDigitacion() : null);
				datTransProdDTO2.setVariedNivel4(
						(datTransProdTmp.getVariedNivel4() != null) ? datTransProdTmp.getVariedNivel4() : null);

				if (datTransProdTmp.getEmpresaCompradora() != null) {
					datTransProdDTO2.setEmpresaCompradora(datTransProdTmp.getEmpresaCompradora());
				} else {
					datTransProdDTO2.setEmpresaCompradora(null);
				}

				if (datTransProdTmp.getConductor() != null) {
					datTransProdDTO2.setConductorId_Conductor(datTransProdTmp.getConductor());
				} else {
					datTransProdDTO2.setConductorId_Conductor(null);
				}

				datTransProdDTO2.setFrtCosId_FrenteCos(
						(datTransProdTmp.getFrenteCos() != null) ? datTransProdTmp.getFrenteCos() : null);
				datTransProdDTO2.setModalidadCosId_ModalidadCosecha(
						(datTransProdTmp.getModalidadCosecha() != null) ? datTransProdTmp.getModalidadCosecha() : null);

				if (datTransProdTmp.getNivel4() != null) {
					datTransProdDTO2.setNivel4Id_Nivel4(datTransProdTmp.getNivel4());
				} else {
					datTransProdDTO2.setNivel4Id_Nivel4(null);
				}

				if (datTransProdTmp.getProveedor() != null) {
					datTransProdDTO2.setProveId_Proveedor(datTransProdTmp.getProveedor());
				} else {
					datTransProdDTO2.setProveId_Proveedor(null);
				}

				if (datTransProdTmp.getTransportadora() != null) {
					datTransProdDTO2.setTranspId_Transportadora(datTransProdTmp.getTransportadora());
				} else {
					datTransProdDTO2.setTranspId_Transportadora(null);
				}

				datTransProdDTO2.setVehiTranspId_VehiculosTransp(
						(datTransProdTmp.getVehiculosTransp() != null) ? datTransProdTmp.getVehiculosTransp() : null);
				datTransProdDTO.add(datTransProdDTO2);
				
				String name = "Peso bruto";
	            if(datTransProdTmp.getPesoTara() !=null) {
	                
	            	Double tara_bruto = datTransProdTmp.getPesoTara();
		            
	            	if(tara_bruto > 0 && tara_bruto != null) {
	            		name = "Peso bruto";
	            		datTransProdDTO2.setNombrePeso(name);
		            }else {
		            	name = "Peso tara";
		            	datTransProdDTO2.setNombrePeso(name);
		            }
	            }
	            
	            String name2 = "Peso tara";
	            if(datTransProdTmp.getPesoTara() !=null) {
	                
	            	Double tara_bruto = datTransProdTmp.getPesoTara();
		            
	            	if(tara_bruto > 0 && tara_bruto != null) {
	            		name2 = "Peso tara";
	            		datTransProdDTO2.setNombrePeso(name2);
		            }else {
		            	name2 = "Peso bruto";
		            	datTransProdDTO2.setNombrePeso(name2);
		            }
	            }
			}

			return datTransProdDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public DatTransProd getDatTransProd(Long datTransProdId) throws Exception {
		log.debug("getting DatTransProd instance");

		DatTransProd entity = null;

		try {
			entity = datTransProdDAO.findById(datTransProdId);
		} catch (Exception e) {
			log.error("get DatTransProd failed", e);
			throw new ZMessManager().new FindingException("DatTransProd");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatTransProd> findPageDatTransProd(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<DatTransProd> entity = null;

		try {
			entity = datTransProdDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatTransProd Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberDatTransProd() throws Exception {
		Long entity = null;

		try {
			entity = datTransProdDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatTransProd Count");
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
	public List<DatTransProd> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<DatTransProd> list = new ArrayList<DatTransProd>();
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
			list = datTransProdDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatTransProdDTO> findByCriteriaPageDatTransProd(int startRow, int pageSize, String sortField,
			boolean sortOrder, Map<String, Object> filters) throws Exception {
		try {
			List<DatTransProd> entity = null;

			String whereCondition = new String();
			Iterator it = filters.entrySet().iterator();

			while (it.hasNext()) {
				Map.Entry e = (Map.Entry) it.next();
				whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(" + e.getKey() + ")"
						+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";
			}

			entity = datTransProdDAO.findByCriteriaPage(whereCondition, sortField, sortOrder, startRow, pageSize);

			List<DatTransProdDTO> datTransProdDTO = new ArrayList<DatTransProdDTO>();

			for (DatTransProd datTransProdTmp : entity) {
				DatTransProdDTO datTransProdDTO2 = new DatTransProdDTO();

				datTransProdDTO2.setDatTransProdId(datTransProdTmp.getDatTransProdId());
				datTransProdDTO2.setAnioFiscalNivel4(
						(datTransProdTmp.getAnioFiscalNivel4() != null) ? datTransProdTmp.getAnioFiscalNivel4() : null);
				datTransProdDTO2
						.setCompania((datTransProdTmp.getCompania() != null) ? datTransProdTmp.getCompania() : null);
				datTransProdDTO2.setConsecutivo(
						(datTransProdTmp.getConsecutivo() != null) ? datTransProdTmp.getConsecutivo() : null);
				datTransProdDTO2.setConsecutivoPesoNeto(
						(datTransProdTmp.getConsecutivoPesoNeto() != null) ? datTransProdTmp.getConsecutivoPesoNeto() : null);
				datTransProdDTO2.setDestinoProduccion((datTransProdTmp.getDestinoProduccion() != null)
						? datTransProdTmp.getDestinoProduccion() : null);
				datTransProdDTO2.setEdadNivel4(
						(datTransProdTmp.getEdadNivel4() != null) ? datTransProdTmp.getEdadNivel4() : null);
				datTransProdDTO2.setEstado((datTransProdTmp.getEstado() != null) ? datTransProdTmp.getEstado() : null);
				datTransProdDTO2.setEtapaNivel4(
						(datTransProdTmp.getEtapaNivel4() != null) ? datTransProdTmp.getEtapaNivel4() : null);
				datTransProdDTO2.setFaseFenoNivel4(
						(datTransProdTmp.getFaseFenoNivel4() != null) ? datTransProdTmp.getFaseFenoNivel4() : null);
				datTransProdDTO2.setFechaCreacion(datTransProdTmp.getFechaCreacion());
				datTransProdDTO2.setFechaModificacion(datTransProdTmp.getFechaModificacion());
				datTransProdDTO2.setFechaRegistro(datTransProdTmp.getFechaRegistro());
				datTransProdDTO2.setObservacion2((datTransProdTmp.getObservacion2() != null)
						? datTransProdTmp.getObservacion2() : null);
				datTransProdDTO2.setObservacion3((datTransProdTmp.getObservacion3() != null)
						? datTransProdTmp.getObservacion3() : null);
				datTransProdDTO2.setOrigen((datTransProdTmp.getOrigen() != null)
						? datTransProdTmp.getOrigen() : null);
				datTransProdDTO2.setNoDocumento((datTransProdTmp.getNoDocumento() != null)
						? datTransProdTmp.getNoDocumento() : null);
				datTransProdDTO2.setInfoAdicional(
						(datTransProdTmp.getInfoAdicional() != null) ? datTransProdTmp.getInfoAdicional() : null);
				datTransProdDTO2.setInfoAdicional2(
						(datTransProdTmp.getInfoAdicional2() != null) ? datTransProdTmp.getInfoAdicional2() : null);
				datTransProdDTO2
						.setMobileId((datTransProdTmp.getMobileId() != null) ? datTransProdTmp.getMobileId() : null);
				datTransProdDTO2
						.setNivel1Id((datTransProdTmp.getNivel1Id() != null) ? datTransProdTmp.getNivel1Id() : null);
				datTransProdDTO2
						.setNivel2Id((datTransProdTmp.getNivel2Id() != null) ? datTransProdTmp.getNivel2Id() : null);
				datTransProdDTO2
						.setNivel3Id((datTransProdTmp.getNivel3Id() != null) ? datTransProdTmp.getNivel3Id() : null);
				datTransProdDTO2.setObservacion(
						(datTransProdTmp.getObservacion() != null) ? datTransProdTmp.getObservacion() : null);
				datTransProdDTO2.setObservacionAnularReg((datTransProdTmp.getObservacionAnularReg() != null)
						? datTransProdTmp.getObservacionAnularReg() : null);
				datTransProdDTO2.setTipoTransaccion(
						(datTransProdTmp.getTipoTransaccion() != null) ? datTransProdTmp.getTipoTransaccion() : null);
				datTransProdDTO2.setUsuarioDigitacion((datTransProdTmp.getUsuarioDigitacion() != null)
						? datTransProdTmp.getUsuarioDigitacion() : null);
				datTransProdDTO2.setVariedNivel4(
						(datTransProdTmp.getVariedNivel4() != null) ? datTransProdTmp.getVariedNivel4() : null);

				if (datTransProdTmp.getEmpresaCompradora() != null) {
					datTransProdDTO2.setEmpresaCompradora(datTransProdTmp.getEmpresaCompradora());
				} else {
					datTransProdDTO2.setEmpresaCompradora(null);
				}

				if (datTransProdTmp.getConductor() != null) {
					datTransProdDTO2.setConductorId_Conductor(datTransProdTmp.getConductor());
				} else {
					datTransProdDTO2.setConductorId_Conductor(null);
				}

				datTransProdDTO2.setFrtCosId_FrenteCos(
						(datTransProdTmp.getFrenteCos() != null) ? datTransProdTmp.getFrenteCos() : null);
				datTransProdDTO2.setModalidadCosId_ModalidadCosecha(
						(datTransProdTmp.getModalidadCosecha() != null) ? datTransProdTmp.getModalidadCosecha() : null);

				if (datTransProdTmp.getNivel4() != null) {
					datTransProdDTO2.setNivel4Id_Nivel4(datTransProdTmp.getNivel4());
				} else {
					datTransProdDTO2.setNivel4Id_Nivel4(null);
				}

				if (datTransProdTmp.getProveedor() != null) {
					datTransProdDTO2.setProveId_Proveedor(datTransProdTmp.getProveedor());
				} else {
					datTransProdDTO2.setProveId_Proveedor(null);
				}

				if (datTransProdTmp.getTransportadora() != null) {
					datTransProdDTO2.setTranspId_Transportadora(datTransProdTmp.getTransportadora());
				} else {
					datTransProdDTO2.setTranspId_Transportadora(null);
				}

				datTransProdDTO2.setVehiTranspId_VehiculosTransp(
						(datTransProdTmp.getVehiculosTransp() != null) ? datTransProdTmp.getVehiculosTransp() : null);

				datTransProdDTO2
						.setValorNeto((datTransProdTmp.getValorNeto() != null) ? datTransProdTmp.getValorNeto() : null);
				datTransProdDTO2.setValorDeduccion(
						(datTransProdTmp.getValorDeduccion() != null) ? datTransProdTmp.getValorDeduccion() : null);

				datTransProdDTO2.setValorUnitario(
						(datTransProdTmp.getValorUnitario() != null) ? datTransProdTmp.getValorUnitario() : null);
				datTransProdDTO2.setValorTotal(
						(datTransProdTmp.getValorTotal() != null) ? datTransProdTmp.getValorTotal() : null);
				datTransProdDTO2.setCantidadKilosLiq(
						(datTransProdTmp.getCantidadKilosLiq() != null) ? datTransProdTmp.getCantidadKilosLiq() : null);

				datTransProdDTO2.setSello1(
						(datTransProdTmp.getSello1() != null) ? datTransProdTmp.getSello1() : null);
				datTransProdDTO2.setSello2(
						(datTransProdTmp.getSello2() != null) ? datTransProdTmp.getSello2() : null);
				datTransProdDTO2.setSello3(
						(datTransProdTmp.getSello3() != null) ? datTransProdTmp.getSello3() : null);
				datTransProdDTO2.setSello4(
						(datTransProdTmp.getSello4() != null) ? datTransProdTmp.getSello4() : null);
				datTransProdDTO2.setSello5(
						(datTransProdTmp.getSello5() != null) ? datTransProdTmp.getSello5() : null);
				datTransProdDTO2.setSello6(
						(datTransProdTmp.getSello6() != null) ? datTransProdTmp.getSello6() : null);
				datTransProdDTO2.setSello7(
						(datTransProdTmp.getSello7() != null) ? datTransProdTmp.getSello7() : null);
				datTransProdDTO2.setSello8(
						(datTransProdTmp.getSello8() != null) ? datTransProdTmp.getSello8() : null);
				datTransProdDTO2.setSello9(
						(datTransProdTmp.getSello9() != null) ? datTransProdTmp.getSello9() : null);
				datTransProdDTO2.setSello10(
						(datTransProdTmp.getSello10() != null) ? datTransProdTmp.getSello10() : null);
				
				
				datTransProdDTO2.setVariable1(
						(datTransProdTmp.getVariable1() != null) ? datTransProdTmp.getVariable1() : null);
				datTransProdDTO2.setVariable2(
						(datTransProdTmp.getVariable2() != null) ? datTransProdTmp.getVariable2() : null);
				datTransProdDTO2.setVariable3(
						(datTransProdTmp.getVariable3() != null) ? datTransProdTmp.getVariable3() : null);
				datTransProdDTO2.setVariable4(
						(datTransProdTmp.getVariable4() != null) ? datTransProdTmp.getVariable4() : null);
				datTransProdDTO2.setVariable5(
						(datTransProdTmp.getVariable5() != null) ? datTransProdTmp.getVariable5() : null);
				
				datTransProdDTO2.setFechaEntrada(
						(datTransProdTmp.getFechaEntrada() != null) ? datTransProdTmp.getFechaEntrada() : null);
				datTransProdDTO2.setFechaEstadoVehiculo(
						(datTransProdTmp.getFechaEstadoVehiculo() != null) ? datTransProdTmp.getFechaEstadoVehiculo() : null);
				datTransProdDTO2.setFechaSalida(
						(datTransProdTmp.getFechaSalida() != null) ? datTransProdTmp.getFechaSalida() : null);
				datTransProdDTO2.setFechaPesoBruto(
						(datTransProdTmp.getFechaPesoBruto() != null) ? datTransProdTmp.getFechaPesoBruto() : null);
				datTransProdDTO2.setFechaTara(
						(datTransProdTmp.getFechaTara() != null) ? datTransProdTmp.getFechaTara() : null);
				datTransProdDTO2.setFechaPesoNeto(
						(datTransProdTmp.getFechaPesoNeto() != null) ? datTransProdTmp.getFechaPesoNeto() : null);
				datTransProdDTO2.setPesoBruto(
						(datTransProdTmp.getPesoBruto() != null) ? datTransProdTmp.getPesoBruto() : null);
				datTransProdDTO2.setPesoTara(
						(datTransProdTmp.getPesoTara() != null) ? datTransProdTmp.getPesoTara() : null);
				datTransProdDTO2.setPesoNeto(
						(datTransProdTmp.getPesoNeto() != null) ? datTransProdTmp.getPesoNeto() : null);
				datTransProdDTO2.setTipoPesajeBruto(
						(datTransProdTmp.getTipoPesajeBruto() != null) ? datTransProdTmp.getTipoPesajeBruto() : null);
				
				datTransProdDTO2.setTipoPesajeTara(
						(datTransProdTmp.getTipoPesajeTara() != null) ? datTransProdTmp.getTipoPesajeTara() : null);
				datTransProdDTO2.setVariableTexto1(
						(datTransProdTmp.getVariableTexto1() != null) ? datTransProdTmp.getVariableTexto1() : null);
				
				
				
				String estadoEstrue = "false";
				if (datTransProdTmp.getEstado().equals("I")) {
					estadoEstrue = "true";
					datTransProdDTO2.setEstadoTrue(estadoEstrue);
				}
				datTransProdDTO2.setEstadoTrue(estadoEstrue);

				datTransProdDTO.add(datTransProdDTO2);
			}

			return datTransProdDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberDatTransProd(Map<String, Object> filters) throws Exception {
		Long entity = null;

		try {
			String whereCondition = new String();
			Iterator it = filters.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry e = (Map.Entry) it.next();
				whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(" + e.getKey() + ")"
						+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";
			}
			entity = datTransProdDAO.countByCriteria(whereCondition);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatTransProd Count");
		} finally {
		}
		return entity;
	}

}
