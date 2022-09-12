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

import co.com.arcosoft.dataaccess.dao.IDatAplicProdDetDAO;
import co.com.arcosoft.dataaccess.dao.IDatPlanillaNominaDAO;
import co.com.arcosoft.dataaccess.dao.IDatPlanillaNominaDetDAO;
import co.com.arcosoft.dataaccess.dao.IDatPlanillaNominaOnivel4DAO;
import co.com.arcosoft.dataaccess.dao.IDatRiegoDAO;
import co.com.arcosoft.dataaccess.dao.IDatServicioDetDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatAplicProdDet;
import co.com.arcosoft.modelo.DatPlanillaNomina;
import co.com.arcosoft.modelo.DatPlanillaNominaDet;
import co.com.arcosoft.modelo.DatPlanillaNominaOnivel4;
import co.com.arcosoft.modelo.DatRiego;
import co.com.arcosoft.modelo.DatServicioDet;
import co.com.arcosoft.modelo.dto.DatAplicProdDetDTO;
import co.com.arcosoft.modelo.dto.DatPlanillaNominaDTO;
import co.com.arcosoft.modelo.dto.DatPlanillaNominaDetDTO;
import co.com.arcosoft.modelo.dto.DatPlanillaNominaOnivel4DTO;
import co.com.arcosoft.modelo.dto.DatRiegoDTO;
import co.com.arcosoft.modelo.dto.DatServicioDetDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("DatPlanillaNominaLogic")
public class DatPlanillaNominaLogic implements IDatPlanillaNominaLogic {
	private static final Logger log = LoggerFactory.getLogger(DatPlanillaNominaLogic.class);

	/**
	 * DAO injected by Spring that manages DatPlanillaNomina entities
	 *
	 */
	@Autowired
	private IDatPlanillaNominaDAO datPlanillaNominaDAO;

	@Autowired
	private IDatPlanillaNominaDetDAO datPlanillaNominaDetDAO;

	/**
	 * Logic injected by Spring that manages ConceptoNomina entities
	 *
	 */
	@Autowired
	IConceptoNominaLogic logicConceptoNomina1;

	/**
	 * Logic injected by Spring that manages Contratista entities
	 *
	 */

	/**
	 * Logic injected by Spring that manages EquipoTrabajo entities
	 *
	 */
	@Autowired
	IEquipoTrabajoLogic logicEquipoTrabajo3;

	/**
	 * Logic injected by Spring that manages Labor entities
	 *
	 */
	@Autowired
	ILaborLogic logicLabor4;

	/**
	 * Logic injected by Spring that manages Nivel4 entities
	 *
	 */
	@Autowired
	INivel4Logic logicNivel45;

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
	private IDatAplicProdDetDAO datAplicProdDetDAO;
	@Autowired
	private IDatServicioDetDAO datServicioDetDAO;
	@Autowired
	private IDatRiegoDAO datRiegoDAO;
	@Autowired
	private IDatPlanillaNominaOnivel4DAO datPlanillaNominaOnivel4DAO;

	

	@Override
	@Transactional(readOnly = true)
	public List<DatPlanillaNomina> getDatPlanillaNomina() throws Exception {
		log.debug("finding all DatPlanillaNomina instances");

		List<DatPlanillaNomina> list = new ArrayList<DatPlanillaNomina>();

		try {
			list = datPlanillaNominaDAO.findAll();
		} catch (Exception e) {
			log.error("finding all DatPlanillaNomina failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "DatPlanillaNomina");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveDatPlanillaNomina(DatPlanillaNomina entity, List<DatPlanillaNominaDetDTO> dataPlanillaDet,
			List<DatServicioDetDTO> dataDetServicio,
			List<DatAplicProdDetDTO> dataDetProductos,
			List<DatRiegoDTO> dataRiegoDet, List<DatPlanillaNominaOnivel4DTO> datPlanillaNominaOnivel4
			
			)
			throws Exception {
		log.debug("saving DatPlanillaNomina instance");

		try {

			if ((entity.getAnio() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAnio(), 4, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("anio");
			}

			if ((entity.getCierreCostos() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCierreCostos(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("cierreCostos");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getConsecutivo() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getConsecutivo(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("consecutivo");
			}

			if ((entity.getDocumetoErp() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getDocumetoErp(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("documetoErp");
			}

			if ((entity.getEdadEjecucion() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEdadEjecucion(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("edadEjecucion");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getIdMobile() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getIdMobile(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("idMobile");
			}

			if ((entity.getInfoAdicional() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional");
			}

			if ((entity.getInfoAdicional2() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional2(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional2");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacion(), 1000) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacion");
			}

			if ((entity.getObservacionAnularReg() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacionAnularReg(), 500) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacionAnularReg");
			}

			if ((entity.getUsuarioDigitacion() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getUsuarioDigitacion(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("usuarioDigitacion");
			}


			datPlanillaNominaDAO.save(entity);

			if (dataPlanillaDet != null) {

				for (DatPlanillaNominaDetDTO valorDto : dataPlanillaDet) {

					if (valorDto.getDetPlanillaNominaId() == null) {

						DatPlanillaNominaDet valor = new DatPlanillaNominaDet();

						valor.setTrabajador(valorDto.getTrabId_Trabajador());
						valor.setConceptoNomina(valorDto.getCeptoNominaId_ConceptoNomina());
						valor.setUdadMedByUdadMedPago(valorDto.getUdadMedIdPago());
						valor.setCostoTotal(valorDto.getCostoTotal());
						valor.setValorUnitario(valorDto.getValorUnitario());
						valor.setCantidadPago(valorDto.getCantidadPago());
						valor.setCantidadDescontar(valorDto.getCantidadDescontar());
						valor.setPersEmpr(valorDto.getPersEmprId_PersEmpr());
						valor.setCantidadProd(valorDto.getCantidadProd());
						valor.setEstadoIncidencia(valorDto.getEstadoIncidencia());
						valor.setAlturaPlanta(valorDto.getAlturaPlanta());
						valor.setOrdenTrabajo(valorDto.getOrdenTrabajo());
						valor.setLaborId(valorDto.getLaborId());
						valor.setNivel2Id(valorDto.getNivel2Id());
						valor.setNivel4(valorDto.getNivel4());
						valor.setPesoPromedio(valorDto.getPesoPromedio());
						valor.setNumeroTiquete(valorDto.getNumeroTiquete());
						valor.setEtapaId(valorDto.getEtapaId());
						valor.setVariedId(valorDto.getVariedId());
						valor.setEdad(valorDto.getEdad());
						valor.setHorasTrabajadas(valorDto.getHorasTrabajadas());
						valor.setEquipoId(valorDto.getEquipoId());
						valor.setTipoPersona(valorDto.getTipoPersona());
						
						valor.setTipoServicio(valorDto.getTipoServicio());
						valor.setUdadMedMaq(valorDto.getUdadMedMaq());
						valor.setHorometroInicial(valorDto.getHorometroInicial());
						valor.setHorometroFinal(valorDto.getHorometroFinal());
						valor.setHorometroTotal(valorDto.getHorometroTotal());
						valor.setCantidadMaq(valorDto.getCantidadMaq());
						valor.setValorTotalMaq(valorDto.getValorTotalMaq());
				
						valor.setImplementoId(valorDto.getImplementoId());
						
						valor.setPlanillaNominaId(entity);
						datPlanillaNominaDetDAO.save(valor);
					}

				}
			}

			if (dataDetProductos != null) {

				for (DatAplicProdDetDTO valorDto : dataDetProductos) {

					if (valorDto.getDatProdDetId() == null) {

						DatAplicProdDet valor = new DatAplicProdDet();

						valor.setCantidadAplicada(valorDto.getCantidadAplicada());
						valor.setCostoTotal(valorDto.getCostoTotal());
						valor.setDosis(valorDto.getDosis());
						valor.setProducto(valorDto.getProductoId_Producto());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());
						valor.setValorUnit(valorDto.getValorUnit());

						valor.setOrdenTrabajo(valorDto.getOrdenTrabajo());
						valor.setLaborId(valorDto.getLaborId());
						valor.setNivel2Id(valorDto.getNivel2Id());
						valor.setNivel4(valorDto.getNivel4());
						valor.setNumTinas(valorDto.getNumTinas());
						valor.setAlmacenId(valorDto.getAlmacenId());
						valor.setEtapaId(valorDto.getEtapaId());
						valor.setVariedId(valorDto.getVariedId());
						valor.setEdad(valorDto.getEdad());
						
						
						
						valor.setDatPlanillaNominaId(entity);
						
						datAplicProdDetDAO.save(valor);
					}

				}
			}
			
			if (dataDetServicio != null) {

				for (DatServicioDetDTO valorDto : dataDetServicio) {

					if (valorDto.getDatServicioDetId() == null) {

						DatServicioDet valor = new DatServicioDet();

						valor.setEquipo(valorDto.getEquipoId_Equipo());
						valor.setUdadMedByUdadMedPago(valorDto.getUdadMedPago());
						valor.setCostoTotal(valorDto.getCostoTotal());
						valor.setValorUnit(valorDto.getValorUnit());
						valor.setHoraFinal(valorDto.getHoraFinal());
						valor.setHoraInicial(valorDto.getHoraInicial());
						valor.setHorometroInicial(valorDto.getHorometroInicial());
						valor.setHorometroFinal(valorDto.getHorometroFinal());
						valor.setTotalHoras(valorDto.getTotalHoras());
						valor.setCantidadPago(valorDto.getTotalHoras());
						valor.setPersEmpr(valorDto.getPersEmprId_PersEmpr());
						
						valor.setOrdenTrabajo(valorDto.getOrdenTrabajo());
						valor.setLaborId(valorDto.getLaborId());
						
						valor.setNivel2Id(valorDto.getNivel2Id());
						valor.setNivel4(valorDto.getNivel4());
						valor.setEtapaId(valorDto.getEtapaId());
						valor.setVariedId(valorDto.getVariedId());
						valor.setEdad(valorDto.getEdad());
						valor.setDatPlanillaNominaId(entity);

						datServicioDetDAO.save(valor);
					}

				}
			}


				if (dataRiegoDet != null) {

					for (DatRiegoDTO valorDto : dataRiegoDet) {

						if (valorDto.getDatRiegoId() == null) {

							DatRiego valor = new DatRiego();

							valor.setInfraestructura(valorDto.getInfraId_Infraestructura());
							valor.setSistemaRiego(valorDto.getSistemaRiegoId_SistemaRiego());
							valor.setCostoTotal(valorDto.getCostoTotal());
							valor.setValorUnit(valorDto.getValorUnit());
							valor.setHoraFinNivel4(valorDto.getHoraFinNivel4());
							valor.setHoraIniNivel4(valorDto.getHoraIniNivel4());
							valor.setHoraTotalNivel4(valorDto.getHoraTotalNivel4());
							valor.setHorometroInicial(valorDto.getTotalHorometro());
							valor.setHorometroFinal(valorDto.getHorometroFinal());
							valor.setHoraTotalNivel4(valorDto.getHoraTotalNivel4());
							valor.setTotalHorometro(valorDto.getTotalHorometro());
							valor.setTotalAreaRegada(valorDto.getTotalAreaRegada());
							valor.setKwhIncial(valorDto.getKwhIncial());
							valor.setKwhFinal(valorDto.getKwhFinal());
							
							valor.setSurcosCortos(valorDto.getSurcosCortos());
							valor.setSurcosLargos(valorDto.getSurcosLargos());
							valor.setAreaRegada(valorDto.getAreaRegada());
							valor.setCaudalNivel4(valorDto.getCaudalNivel4());
							valor.setHoraTotalNivel4(valorDto.getNumeroRiegos());
							valor.setTurnoCampo(valorDto.getTurnoCampoId());
							valor.setNumeroRiegos(valorDto.getNumeroRiegos());
							
							
							valor.setTrabajador(valorDto.getTrabId_Trabajador());
							valor.setOrdenTrabajo(valorDto.getOrdenTrabajo());
							valor.setLabor(valorDto.getLaborId_Labor());
							valor.setNivel2Id(valorDto.getNivel2Id());
							valor.setNivel4(valorDto.getNivel4Id_Nivel4());
							valor.setVolTotalNivel4(valorDto.getVolTotalNivel4());
							valor.setEtapaId(valorDto.getEtapaId());
							valor.setVariedId(valorDto.getVariedId());
							valor.setEdadEjecucion(valorDto.getEdadEjecucion());	
							valor.setDatPlanillaNominaId(entity);
							datRiegoDAO.save(valor);
						}

					}
				}
				if (datPlanillaNominaOnivel4 != null) {

					for (DatPlanillaNominaOnivel4DTO valorDto : datPlanillaNominaOnivel4) {

						if (valorDto.getDetPlanillaNominaOnivel4Id() == null) {

							DatPlanillaNominaOnivel4 valor = new DatPlanillaNominaOnivel4();

							valor.setNivel2(valorDto.getNivel2Id_Nivel2());
							valor.setNivel4(valorDto.getNivel4Id_Nivel4());
							valor.setAreaNeta(valorDto.getAreaNeta());
							valor.setEtapa(valorDto.getEtapa());
							valor.setVariedad(valorDto.getVariedad());
							
							valor.setDatPlanillaNomina(entity);
							
							datPlanillaNominaOnivel4DAO.save(valor);
						}

					}
				}
			log.debug("save DatPlanillaNomina successful");
		} catch (Exception e) {
			log.error("save DatPlanillaNomina failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteDatPlanillaNomina(DatPlanillaNomina entity) throws Exception {
		log.debug("deleting DatPlanillaNomina instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("DatPlanillaNomina");
		}

		if (entity.getPlanillaNominaId() == null) {
			throw new ZMessManager().new EmptyFieldException("planillaNominaId");
		}

		List<DatPlanillaNominaDet> datPlanillaNominaDets = null;
		List<DatAplicProdDet> datAplicProdDets = null;
		List<DatServicioDet> datServicioDets = null;
		List<DatRiego> datRiegos = null;

		try {
			datPlanillaNominaDets = datPlanillaNominaDetDAO.findByProperty("datPlanillaNomina.planillaNominaId",
					entity.getPlanillaNominaId());

			if (Utilities.validationsList(datPlanillaNominaDets) == true) {
				throw new ZMessManager().new DeletingException("datPlanillaNominaDets");

			}
			
			datAplicProdDets = datAplicProdDetDAO.findByProperty("datPlanillaNomina.planillaNominaId",
						entity.getPlanillaNominaId());
			
				if (Utilities.validationsList(datAplicProdDets) == true) {
					throw new ZMessManager().new DeletingException("datAplicProdDets");
				}
			datServicioDets = datServicioDetDAO.findByProperty("datPlanillaNomina.planillaNominaId",
							entity.getPlanillaNominaId());
				
				if (Utilities.validationsList(datServicioDets) == true) {
						throw new ZMessManager().new DeletingException("datServicioDets");
				}		
						
				
				datRiegos = datRiegoDAO.findByProperty("datPlanillaNomina.planillaNominaId",
						entity.getPlanillaNominaId());
				if (Utilities.validationsList(datRiegos) == true) {
							throw new ZMessManager().new DeletingException("datRiegos");}

			datPlanillaNominaDAO.delete(entity);

			log.debug("delete DatPlanillaNomina successful");
		} catch (Exception e) {
			log.error("delete DatPlanillaNomina failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateDatPlanillaNomina(DatPlanillaNomina entity,  List<DatPlanillaNominaDetDTO> dataPlanillaDet,
			List<DatServicioDetDTO> dataDetServicio,
			List<DatAplicProdDetDTO> dataDetProductos,
			List<DatRiegoDTO> dataRiegoDet,List<DatPlanillaNominaOnivel4DTO> datPlanillaNominaOnivel4
			)
			throws Exception {
		log.debug("updating DatPlanillaNomina instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("DatPlanillaNomina");
			}

			if ((entity.getNPases() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNPases(), 4, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("NPases");
			}

			if ((entity.getAnio() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAnio(), 4, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("anio");
			}

			if ((entity.getCierreCostos() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCierreCostos(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("cierreCostos");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getConsecutivo() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getConsecutivo(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("consecutivo");
			}

			if ((entity.getDocumetoErp() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getDocumetoErp(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("documetoErp");
			}

			if ((entity.getEdadEjecucion() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEdadEjecucion(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("edadEjecucion");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

						if ((entity.getIdMobile() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getIdMobile(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("idMobile");
			}

			if ((entity.getInfoAdicional() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional");
			}

			if ((entity.getInfoAdicional2() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional2(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional2");
			}

			
			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacion(), 1000) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacion");
			}

			if ((entity.getObservacionAnularReg() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacionAnularReg(), 500) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacionAnularReg");
			}

			if (entity.getPlanillaNominaId() == null) {
				throw new ZMessManager().new EmptyFieldException("planillaNominaId");
			}

			if ((entity.getPlanillaNominaId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getPlanillaNominaId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("planillaNominaId");
			}

			if ((entity.getUsuarioDigitacion() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getUsuarioDigitacion(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("usuarioDigitacion");
			}

			
			datPlanillaNominaDAO.update(entity);
			
			if (dataPlanillaDet != null) {

			for (DatPlanillaNominaDetDTO valorDto : dataPlanillaDet) {

				if (valorDto.getDetPlanillaNominaId() == null) { // crear el
																	// valor
					// nuevo

					DatPlanillaNominaDet valor = new DatPlanillaNominaDet();

					valor.setTrabajador(valorDto.getTrabId_Trabajador());
					valor.setConceptoNomina(valorDto.getCeptoNominaId_ConceptoNomina());
					valor.setUdadMedByUdadMedPago(valorDto.getUdadMedIdPago());
					valor.setCostoTotal(valorDto.getCostoTotal());
					valor.setValorUnitario(valorDto.getValorUnitario());
					valor.setCantidadPago(valorDto.getCantidadPago());
					valor.setPersEmpr(valorDto.getPersEmprId_PersEmpr());
					valor.setCantidadProd(valorDto.getCantidadProd());
					valor.setEstadoIncidencia(valorDto.getEstadoIncidencia());
					valor.setCantidadDescontar(valorDto.getCantidadDescontar());
					valor.setAlturaPlanta(valorDto.getAlturaPlanta());
					valor.setPesoPromedio(valorDto.getPesoPromedio());
					valor.setNumeroTiquete(valorDto.getNumeroTiquete());
					valor.setOrdenTrabajo(valorDto.getOrdenTrabajo());
					valor.setLaborId(valorDto.getLaborId());
					valor.setNivel2Id(valorDto.getNivel2Id());
					valor.setNivel4(valorDto.getNivel4());
					valor.setPesoPromedio(valorDto.getPesoPromedio());
					valor.setEtapaId(valorDto.getEtapaId());
					valor.setVariedId(valorDto.getVariedId());
					valor.setEdad(valorDto.getEdad());
					valor.setHorasTrabajadas(valorDto.getHorasTrabajadas());
					valor.setEquipoId(valorDto.getEquipoId());
					valor.setTipoPersona(valorDto.getTipoPersona());

					valor.setTipoServicio(valorDto.getTipoServicio());
					valor.setUdadMedMaq(valorDto.getUdadMedMaq());
					valor.setHorometroInicial(valorDto.getHorometroInicial());
					valor.setHorometroFinal(valorDto.getHorometroFinal());
					valor.setHorometroTotal(valorDto.getHorometroTotal());
					valor.setCantidadMaq(valorDto.getCantidadMaq());
					valor.setValorTotalMaq(valorDto.getValorTotalMaq());
					valor.setImplementoId(valorDto.getImplementoId());
					
					valor.setPlanillaNominaId(entity);
					datPlanillaNominaDetDAO.save(valor);

				} else {
					DatPlanillaNominaDet valor = datPlanillaNominaDetDAO.findById(valorDto.getDetPlanillaNominaId());

					valor.setTrabajador(valorDto.getTrabId_Trabajador());
					valor.setConceptoNomina(valorDto.getCeptoNominaId_ConceptoNomina());
					valor.setUdadMedByUdadMedPago(valorDto.getUdadMedIdPago());
					valor.setCostoTotal(valorDto.getCostoTotal());
					valor.setValorUnitario(valorDto.getValorUnitario());
					valor.setCantidadPago(valorDto.getCantidadPago());
					valor.setPersEmpr(valorDto.getPersEmprId_PersEmpr());
					valor.setCantidadProd(valorDto.getCantidadProd());
					valor.setCantidadDescontar(valorDto.getCantidadDescontar());
					valor.setEstadoIncidencia(valorDto.getEstadoIncidencia());
					valor.setAlturaPlanta(valorDto.getAlturaPlanta());
					valor.setPesoPromedio(valorDto.getPesoPromedio());
					valor.setNumeroTiquete(valorDto.getNumeroTiquete());
					valor.setOrdenTrabajo(valorDto.getOrdenTrabajo());
					valor.setLaborId(valorDto.getLaborId());
					valor.setNivel2Id(valorDto.getNivel2Id());
					valor.setNivel4(valorDto.getNivel4());
					valor.setPesoPromedio(valorDto.getPesoPromedio());
					valor.setEtapaId(valorDto.getEtapaId());
					valor.setVariedId(valorDto.getVariedId());
					valor.setEdad(valorDto.getEdad());
					valor.setHorasTrabajadas(valorDto.getHorasTrabajadas());
					valor.setEquipoId(valorDto.getEquipoId());
					valor.setTipoPersona(valorDto.getTipoPersona());

					valor.setTipoServicio(valorDto.getTipoServicio());
					valor.setUdadMedMaq(valorDto.getUdadMedMaq());
					valor.setHorometroInicial(valorDto.getHorometroInicial());
					valor.setHorometroFinal(valorDto.getHorometroFinal());
					valor.setHorometroTotal(valorDto.getHorometroTotal());
					valor.setCantidadMaq(valorDto.getCantidadMaq());
					valor.setValorTotalMaq(valorDto.getValorTotalMaq());
					valor.setImplementoId(valorDto.getImplementoId());
					
					valor.setPlanillaNominaId(entity);
					datPlanillaNominaDetDAO.update(valor);
				}
			}
		}
			
			if (dataDetServicio != null) {

			for (DatServicioDetDTO valorDto : dataDetServicio) {

				if (valorDto.getDatServicioDetId() == null) { // crear el
																// valor
																// nuevo

					DatServicioDet valor = new DatServicioDet();

					valor.setEquipo(valorDto.getEquipoId_Equipo());
					valor.setUdadMedByUdadMedPago(valorDto.getUdadMedPago());
					valor.setCostoTotal(valorDto.getCostoTotal());
					valor.setValorUnit(valorDto.getValorUnit());
					valor.setHoraFinal(valorDto.getHoraFinal());
					valor.setHoraInicial(valorDto.getHoraInicial());
					valor.setHorometroInicial(valorDto.getHorometroInicial());
					valor.setHorometroFinal(valorDto.getHorometroFinal());
					valor.setTotalHoras(valorDto.getTotalHoras());
					valor.setCantidadPago(valorDto.getTotalHoras());
					valor.setPersEmpr(valorDto.getPersEmprId_PersEmpr());
					
					valor.setOrdenTrabajo(valorDto.getOrdenTrabajo());
					valor.setLaborId(valorDto.getLaborId());
					
					valor.setNivel2Id(valorDto.getNivel2Id());
					valor.setNivel4(valorDto.getNivel4());
					valor.setEtapaId(valorDto.getEtapaId());
					valor.setVariedId(valorDto.getVariedId());
					valor.setEdad(valorDto.getEdad());
					valor.setDatPlanillaNominaId(entity);
					datServicioDetDAO.save(valor);

				} else {
					DatServicioDet valor = datServicioDetDAO.findById(valorDto.getDatServicioDetId());

					valor.setEquipo(valorDto.getEquipoId_Equipo());
					valor.setUdadMedByUdadMedPago(valorDto.getUdadMedPago());
					valor.setCostoTotal(valorDto.getCostoTotal());
					valor.setValorUnit(valorDto.getValorUnit());
					valor.setHoraFinal(valorDto.getHoraFinal());
					valor.setCantidadPago(valorDto.getTotalHoras());
					valor.setHoraInicial(valorDto.getHoraInicial());
					valor.setTotalHoras(valorDto.getTotalHoras());
					valor.setPersEmpr(valorDto.getPersEmprId_PersEmpr());
					valor.setHorometroInicial(valorDto.getHorometroInicial());
					valor.setHorometroFinal(valorDto.getHorometroFinal());

					valor.setOrdenTrabajo(valorDto.getOrdenTrabajo());
					valor.setLaborId(valorDto.getLaborId());
					
					valor.setNivel2Id(valorDto.getNivel2Id());
					valor.setNivel4(valorDto.getNivel4());
					valor.setEtapaId(valorDto.getEtapaId());
					valor.setVariedId(valorDto.getVariedId());
					valor.setEdad(valorDto.getEdad());
					datServicioDetDAO.update(valor);
				}
			}
		}
			if (dataDetProductos != null) {

			for (DatAplicProdDetDTO valorDto : dataDetProductos) {

				if (valorDto.getDatProdDetId() == null) { // crear el valor
															// nuevo

					DatAplicProdDet valor = new DatAplicProdDet();

					valor.setCantidadAplicada(valorDto.getCantidadAplicada());
					valor.setCostoTotal(valorDto.getCostoTotal());
					valor.setDosis(valorDto.getDosis());
					valor.setProducto(valorDto.getProductoId_Producto());
					valor.setUdadMed(valorDto.getUdadMedId_UdadMed());
					valor.setValorUnit(valorDto.getValorUnit());

					valor.setOrdenTrabajo(valorDto.getOrdenTrabajo());
					valor.setLaborId(valorDto.getLaborId());
					valor.setNivel2Id(valorDto.getNivel2Id());
					valor.setNivel4(valorDto.getNivel4());
					valor.setNumTinas(valorDto.getNumTinas());
					valor.setAlmacenId(valorDto.getAlmacenId());
					
					valor.setEtapaId(valorDto.getEtapaId());
					valor.setVariedId(valorDto.getVariedId());
					
					valor.setDatPlanillaNominaId(entity);
					valor.setEdad(valorDto.getEdad());
					
					datAplicProdDetDAO.save(valor);

				} else {
					DatAplicProdDet valor = datAplicProdDetDAO.findById(valorDto.getDatProdDetId());

					valor.setCantidadAplicada(valorDto.getCantidadAplicada());
					valor.setCostoTotal(valorDto.getCostoTotal());
					valor.setDosis(valorDto.getDosis());
					valor.setProducto(valorDto.getProductoId_Producto());
					valor.setUdadMed(valorDto.getUdadMedId_UdadMed());
					valor.setValorUnit(valorDto.getValorUnit());

					valor.setOrdenTrabajo(valorDto.getOrdenTrabajo());
					valor.setLaborId(valorDto.getLaborId());
					valor.setNivel2Id(valorDto.getNivel2Id());
					valor.setNivel4(valorDto.getNivel4());
					valor.setNumTinas(valorDto.getNumTinas());
					valor.setAlmacenId(valorDto.getAlmacenId());
					valor.setEtapaId(valorDto.getEtapaId());
					valor.setVariedId(valorDto.getVariedId());
					valor.setEdad(valorDto.getEdad());
					valor.setDatPlanillaNominaId(entity);

					datAplicProdDetDAO.update(valor);
				}

			}

		} 
			
			
			if (dataRiegoDet != null) {

				for (DatRiegoDTO valorDto : dataRiegoDet) {

					if (valorDto.getDatRiegoId() == null) { // crear el valor
																// nuevo

						DatRiego valor = new DatRiego();

						valor.setInfraestructura(valorDto.getInfraId_Infraestructura());
						valor.setSistemaRiego(valorDto.getSistemaRiegoId_SistemaRiego());
						valor.setCostoTotal(valorDto.getCostoTotal());
						valor.setValorUnit(valorDto.getValorUnit());
						valor.setHoraFinNivel4(valorDto.getHoraFinNivel4());
						valor.setHoraIniNivel4(valorDto.getHoraIniNivel4());
						valor.setHoraTotalNivel4(valorDto.getHoraTotalNivel4());
						valor.setHorometroInicial(valorDto.getTotalHorometro());
						valor.setHorometroFinal(valorDto.getHorometroFinal());
						valor.setHoraTotalNivel4(valorDto.getHoraTotalNivel4());
						valor.setTotalHorometro(valorDto.getTotalHorometro());
						valor.setTotalAreaRegada(valorDto.getTotalAreaRegada());
						valor.setKwhIncial(valorDto.getKwhIncial());
						valor.setKwhFinal(valorDto.getKwhFinal());
						valor.setVolTotalNivel4(valorDto.getVolTotalNivel4());
						valor.setSurcosCortos(valorDto.getSurcosCortos());
						valor.setSurcosLargos(valorDto.getSurcosLargos());
						valor.setAreaRegada(valorDto.getAreaRegada());
						valor.setCaudalNivel4(valorDto.getCaudalNivel4());
						valor.setHoraTotalNivel4(valorDto.getNumeroRiegos());
						valor.setTurnoCampo(valorDto.getTurnoCampoId());
						valor.setNumeroRiegos(valorDto.getNumeroRiegos());
						
						
						valor.setTrabajador(valorDto.getTrabId_Trabajador());
						valor.setOrdenTrabajo(valorDto.getOrdenTrabajo());
						valor.setLabor(valorDto.getLaborId_Labor());
						valor.setNivel2Id(valorDto.getNivel2Id());
						valor.setNivel4(valorDto.getNivel4Id_Nivel4());
						valor.setEtapaId(valorDto.getEtapaId());
						valor.setVariedId(valorDto.getVariedId());
						valor.setEdadEjecucion(valorDto.getEdadEjecucion());	
						valor.setDatPlanillaNominaId(entity);
						datRiegoDAO.save(valor);

					} else {
						DatRiego valor = datRiegoDAO.findById(valorDto.getDatRiegoId());

						valor.setInfraestructura(valorDto.getInfraId_Infraestructura());
						valor.setSistemaRiego(valorDto.getSistemaRiegoId_SistemaRiego());
						valor.setCostoTotal(valorDto.getCostoTotal());
						valor.setValorUnit(valorDto.getValorUnit());
						valor.setHoraFinNivel4(valorDto.getHoraFinNivel4());
						valor.setHoraIniNivel4(valorDto.getHoraIniNivel4());
						valor.setHoraTotalNivel4(valorDto.getHoraTotalNivel4());
						valor.setHorometroInicial(valorDto.getTotalHorometro());
						valor.setHorometroFinal(valorDto.getHorometroFinal());
						valor.setHoraTotalNivel4(valorDto.getHoraTotalNivel4());
						valor.setTotalHorometro(valorDto.getTotalHorometro());
						valor.setTotalAreaRegada(valorDto.getTotalAreaRegada());
						valor.setKwhIncial(valorDto.getKwhIncial());
						valor.setKwhFinal(valorDto.getKwhFinal());
						
						valor.setSurcosCortos(valorDto.getSurcosCortos());
						valor.setSurcosLargos(valorDto.getSurcosLargos());
						valor.setAreaRegada(valorDto.getAreaRegada());
						valor.setCaudalNivel4(valorDto.getCaudalNivel4());
						valor.setHoraTotalNivel4(valorDto.getNumeroRiegos());
						valor.setTurnoCampo(valorDto.getTurnoCampoId());
						valor.setNumeroRiegos(valorDto.getNumeroRiegos());
						valor.setVolTotalNivel4(valorDto.getVolTotalNivel4());
						
						valor.setTrabajador(valorDto.getTrabId_Trabajador());
						valor.setOrdenTrabajo(valorDto.getOrdenTrabajo());
						valor.setLabor(valorDto.getLaborId_Labor());
						valor.setNivel2Id(valorDto.getNivel2Id());
						valor.setNivel4(valorDto.getNivel4Id_Nivel4());
						valor.setEtapaId(valorDto.getEtapaId());
						valor.setVariedId(valorDto.getVariedId());
						valor.setEdadEjecucion(valorDto.getEdadEjecucion());
						valor.setDatPlanillaNominaId(entity);
						
						datRiegoDAO.update(valor);
						
					}

				}

			} 
			
			if (datPlanillaNominaOnivel4 != null) {
			for (DatPlanillaNominaOnivel4DTO valorDto : datPlanillaNominaOnivel4) {

				if (valorDto.getDetPlanillaNominaOnivel4Id() == null) { // crear el valor
															// nuevo

					DatPlanillaNominaOnivel4 valor = new DatPlanillaNominaOnivel4();


					valor.setNivel2(valorDto.getNivel2Id_Nivel2());
					valor.setNivel4(valorDto.getNivel4Id_Nivel4());
					valor.setAreaNeta(valorDto.getAreaNeta());
					valor.setDatPlanillaNomina(entity);
					datPlanillaNominaOnivel4DAO.save(valor);

				} else {
					DatPlanillaNominaOnivel4 valor = datPlanillaNominaOnivel4DAO
							.findById(valorDto.getDetPlanillaNominaOnivel4Id());

					valor.setNivel2(valorDto.getNivel2Id_Nivel2());
					valor.setNivel4(valorDto.getNivel4Id_Nivel4());
					valor.setAreaNeta(valorDto.getAreaNeta());
					valor.setEtapa(valorDto.getEtapa());
					valor.setVariedad(valorDto.getVariedad());
					
					valor.setDatPlanillaNomina(entity);
					datPlanillaNominaOnivel4DAO.update(valor);
				
				}

			}
			
		}


			log.debug("update DatPlanillaNomina successful");
		} catch (Exception e) {
			log.error("update DatPlanillaNomina failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatPlanillaNominaDTO> getDataDatPlanillaNomina() throws Exception {
		try {
			List<DatPlanillaNomina> datPlanillaNomina = datPlanillaNominaDAO.findAll();

			List<DatPlanillaNominaDTO> datPlanillaNominaDTO = new ArrayList<DatPlanillaNominaDTO>();

			for (DatPlanillaNomina datPlanillaNominaTmp : datPlanillaNomina) {
				DatPlanillaNominaDTO datPlanillaNominaDTO2 = new DatPlanillaNominaDTO();

				datPlanillaNominaDTO2.setPlanillaNominaId(datPlanillaNominaTmp.getPlanillaNominaId());
				datPlanillaNominaDTO2.setNPases(
						(datPlanillaNominaTmp.getNPases() != null) ? datPlanillaNominaTmp.getNPases() : null);
				datPlanillaNominaDTO2
						.setAnio((datPlanillaNominaTmp.getAnio() != null) ? datPlanillaNominaTmp.getAnio() : null);
				datPlanillaNominaDTO2.setCantidadPago((datPlanillaNominaTmp.getCantidadPago() != null)
						? datPlanillaNominaTmp.getCantidadPago() : null);
				datPlanillaNominaDTO2.setCantidadProd((datPlanillaNominaTmp.getCantidadProd() != null)
						? datPlanillaNominaTmp.getCantidadProd() : null);
				datPlanillaNominaDTO2.setCierreCostos((datPlanillaNominaTmp.getCierreCostos() != null)
						? datPlanillaNominaTmp.getCierreCostos() : null);
				datPlanillaNominaDTO2.setCompania(
						(datPlanillaNominaTmp.getCompania() != null) ? datPlanillaNominaTmp.getCompania() : null);
				datPlanillaNominaDTO2.setConsecutivo(
						(datPlanillaNominaTmp.getConsecutivo() != null) ? datPlanillaNominaTmp.getConsecutivo() : null);
				datPlanillaNominaDTO2.setCostoTotal(
						(datPlanillaNominaTmp.getCostoTotal() != null) ? datPlanillaNominaTmp.getCostoTotal() : null);
				datPlanillaNominaDTO2.setDocumetoErp(
						(datPlanillaNominaTmp.getDocumetoErp() != null) ? datPlanillaNominaTmp.getDocumetoErp() : null);
				datPlanillaNominaDTO2.setEdadEjecucion((datPlanillaNominaTmp.getEdadEjecucion() != null)
						? datPlanillaNominaTmp.getEdadEjecucion() : null);
				datPlanillaNominaDTO2.setEstado(
						(datPlanillaNominaTmp.getEstado() != null) ? datPlanillaNominaTmp.getEstado() : null);
				datPlanillaNominaDTO2.setEtapaId(
						(datPlanillaNominaTmp.getEtapaId() != null) ? datPlanillaNominaTmp.getEtapaId() : null);
				datPlanillaNominaDTO2.setFechaCreacion(datPlanillaNominaTmp.getFechaCreacion());
				datPlanillaNominaDTO2.setFechaModificacion(datPlanillaNominaTmp.getFechaModificacion());
				datPlanillaNominaDTO2.setFechaRegistro(datPlanillaNominaTmp.getFechaRegistro());
				datPlanillaNominaDTO2.setIdMobile(
						(datPlanillaNominaTmp.getIdMobile() != null) ? datPlanillaNominaTmp.getIdMobile() : null);
				datPlanillaNominaDTO2.setInfoAdicional((datPlanillaNominaTmp.getInfoAdicional() != null)
						? datPlanillaNominaTmp.getInfoAdicional() : null);
				datPlanillaNominaDTO2.setInfoAdicional2((datPlanillaNominaTmp.getInfoAdicional2() != null)
						? datPlanillaNominaTmp.getInfoAdicional2() : null);
				datPlanillaNominaDTO2.setLatitud(
						(datPlanillaNominaTmp.getLatitud() != null) ? datPlanillaNominaTmp.getLatitud() : null);
				datPlanillaNominaDTO2.setLongitud(
						(datPlanillaNominaTmp.getLongitud() != null) ? datPlanillaNominaTmp.getLongitud() : null);
				datPlanillaNominaDTO2.setNivel1Id(
						(datPlanillaNominaTmp.getNivel1Id() != null) ? datPlanillaNominaTmp.getNivel1Id() : null);
				if (datPlanillaNominaTmp.getNivel2Id() != null) {
					datPlanillaNominaDTO2.setNivel2Id(datPlanillaNominaTmp.getNivel2Id().getNivel2Id());
				} else {
					datPlanillaNominaDTO2.setNivel2Id(null);
				}
				datPlanillaNominaDTO2.setNivel3Id(
						(datPlanillaNominaTmp.getNivel3Id() != null) ? datPlanillaNominaTmp.getNivel3Id() : null);
				datPlanillaNominaDTO2.setObservacion(
						(datPlanillaNominaTmp.getObservacion() != null) ? datPlanillaNominaTmp.getObservacion() : null);
				datPlanillaNominaDTO2.setObservacionAnularReg((datPlanillaNominaTmp.getObservacionAnularReg() != null)
						? datPlanillaNominaTmp.getObservacionAnularReg() : null);

				datPlanillaNominaDTO2.setOrdenTrabajo((datPlanillaNominaTmp.getOrdenTrabajo() != null)
						? datPlanillaNominaTmp.getOrdenTrabajo().getDatPlanLabor().getOrdenTrabajo() : null);

				datPlanillaNominaDTO2.setPrecision(
						(datPlanillaNominaTmp.getPrecision() != null) ? datPlanillaNominaTmp.getPrecision() : null);
				
				datPlanillaNominaDTO2.setOrigenDatos(
						(datPlanillaNominaTmp.getOrigenDatos() != null) ? datPlanillaNominaTmp.getOrigenDatos() : null);
				
				datPlanillaNominaDTO2.setUdadMedPago((datPlanillaNominaTmp.getUdadMedPago() != null)
						? datPlanillaNominaTmp.getUdadMedPago() : null);
				
				datPlanillaNominaDTO2.setUsuarioDigitacion((datPlanillaNominaTmp.getUsuarioDigitacion() != null)
						? datPlanillaNominaTmp.getUsuarioDigitacion() : null);
				datPlanillaNominaDTO2.setValorUnitario((datPlanillaNominaTmp.getValorUnitario() != null)
						? datPlanillaNominaTmp.getValorUnitario() : null);
				datPlanillaNominaDTO2.setVariedId(
						(datPlanillaNominaTmp.getVariedId() != null) ? datPlanillaNominaTmp.getVariedId() : null);
				datPlanillaNominaDTO2.setCeptoNominaId_ConceptoNomina(
						(datPlanillaNominaTmp.getConceptoNomina().getCeptoNominaId() != null)
								? datPlanillaNominaTmp.getConceptoNomina().getCeptoNominaId() : null);

				if (datPlanillaNominaTmp.getContratista() != null) {
					datPlanillaNominaDTO2.setContratistaId_Contratista(datPlanillaNominaTmp.getContratista());
				} else {
					datPlanillaNominaDTO2.setContratistaId_Contratista(null);
				}

				if (datPlanillaNominaTmp.getLabor() != null) {
					datPlanillaNominaDTO2.setLaborId_Labor(datPlanillaNominaTmp.getLabor().getLaborId());
				} else {
					datPlanillaNominaDTO2.setLaborId_Labor(null);
				}

				if (datPlanillaNominaTmp.getNivel4() != null) {
					datPlanillaNominaDTO2.setNivel4Id_Nivel4(datPlanillaNominaTmp.getNivel4().getNivel4Id());
				} else {
					datPlanillaNominaDTO2.setNivel4Id_Nivel4(null);
				}

				if (datPlanillaNominaTmp.getTrabajador() != null) {
					datPlanillaNominaDTO2.setTrabId_Trabajador(datPlanillaNominaTmp.getTrabajador().getTrabId());
				} else {
					datPlanillaNominaDTO2.setTrabId_Trabajador(null);
				}

				datPlanillaNominaDTO2.setUdadMedId_UdadMed(
						(datPlanillaNominaTmp.getUdadMed().getUdadMedId() != null) ? datPlanillaNominaTmp.getUdadMed().getUdadMedId() : null);

				String nombreLabor = datPlanillaNominaTmp.getLabor().getNombre();
				datPlanillaNominaDTO2.setLaborNombre(nombreLabor);

				String nombreNivel2 = datPlanillaNominaTmp.getNivel2Id().getNombre();
				datPlanillaNominaDTO2.setNivel2Nombre(nombreNivel2);

				String nombreNivel4 = datPlanillaNominaTmp.getNivel4().getNombre();
				datPlanillaNominaDTO2.setNivel4Nombre(nombreNivel4);
				String nombreConceptoNomi = datPlanillaNominaTmp.getConceptoNomina().getNombre();
				datPlanillaNominaDTO2.setConceptoNomiNombre(nombreConceptoNomi);
				String nombreTrabajador = datPlanillaNominaTmp.getTrabajador().getNombre();
				datPlanillaNominaDTO2.setTrabajadorNombre(nombreTrabajador);
				String codigoTrabajador = datPlanillaNominaTmp.getTrabajador().getCodigo();
				datPlanillaNominaDTO2.setTrabajadorCodigo(codigoTrabajador);
				datPlanillaNominaDTO.add(datPlanillaNominaDTO2);
			}

			return datPlanillaNominaDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public DatPlanillaNomina getDatPlanillaNomina(Long planillaNominaId) throws Exception {
		log.debug("getting DatPlanillaNomina instance");

		DatPlanillaNomina entity = null;

		try {
			entity = datPlanillaNominaDAO.findById(planillaNominaId);
		} catch (Exception e) {
			log.error("get DatPlanillaNomina failed", e);
			throw new ZMessManager().new FindingException("DatPlanillaNomina");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatPlanillaNomina> findPageDatPlanillaNomina(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<DatPlanillaNomina> entity = null;

		try {
			entity = datPlanillaNominaDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatPlanillaNomina Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberDatPlanillaNomina() throws Exception {
		Long entity = null;

		try {
			entity = datPlanillaNominaDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatPlanillaNomina Count");
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
	public List<DatPlanillaNomina> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<DatPlanillaNomina> list = new ArrayList<DatPlanillaNomina>();
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
			list = datPlanillaNominaDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DatPlanillaNominaDTO> findByCriteriaPagePlanillaNomina(int startRow, int pageSize, String sortField,
			boolean sortOrder, Map<String, Object> filters) throws Exception {
		try {
			List<DatPlanillaNomina> entity = null;

			String whereCondition = new String();
			Iterator it = filters.entrySet().iterator();

			while (it.hasNext()) {
				Map.Entry e = (Map.Entry) it.next();

				if (e.getKey().equals("laborNombre")) {
					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(labor.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else if (e.getKey().equals("nivel2Nombre")) {

					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(nivel2Id.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else if (e.getKey().equals("nivel4Nombre")) {

					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(nivel4.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else if (e.getKey().equals("ordenTrabajo")) {
					whereCondition += ((whereCondition.length() == 0) ? " " : " and ")
							+ "upper(ordenTrabajo.ordenTrabajo)" + " LIKE '%" + e.getValue().toString().toUpperCase()
							+ "%' ";

				} else if (e.getKey().equals("trabajadorCodigo")) {

					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(trabajador.codigo)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else if (e.getKey().equals("conceptoNomiNombre")) {

					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(conceptoNomina.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else {
					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(" + e.getKey() + ")"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				}
			}

			entity = datPlanillaNominaDAO.findByCriteriaPage(whereCondition, sortField, sortOrder, startRow, pageSize);

			List<DatPlanillaNominaDTO> datPlanillaNominaDTO = new ArrayList<DatPlanillaNominaDTO>();

			for (DatPlanillaNomina datPlanillaNominaTmp : entity) {
				DatPlanillaNominaDTO datPlanillaNominaDTO2 = new DatPlanillaNominaDTO();

				datPlanillaNominaDTO2.setPlanillaNominaId(datPlanillaNominaTmp.getPlanillaNominaId());
				datPlanillaNominaDTO2.setNPases(
						(datPlanillaNominaTmp.getNPases() != null) ? datPlanillaNominaTmp.getNPases() : null);
				datPlanillaNominaDTO2
						.setAnio((datPlanillaNominaTmp.getAnio() != null) ? datPlanillaNominaTmp.getAnio() : null);
				datPlanillaNominaDTO2.setCierreCostos((datPlanillaNominaTmp.getCierreCostos() != null)
						? datPlanillaNominaTmp.getCierreCostos() : null);
				datPlanillaNominaDTO2.setCompania(
						(datPlanillaNominaTmp.getCompania() != null) ? datPlanillaNominaTmp.getCompania() : null);
				datPlanillaNominaDTO2.setConsecutivo(
						(datPlanillaNominaTmp.getConsecutivo() != null) ? datPlanillaNominaTmp.getConsecutivo() : null);
				datPlanillaNominaDTO2.setDocumetoErp(
						(datPlanillaNominaTmp.getDocumetoErp() != null) ? datPlanillaNominaTmp.getDocumetoErp() : null);
				datPlanillaNominaDTO2.setEdadEjecucion((datPlanillaNominaTmp.getEdadEjecucion() != null)
						? datPlanillaNominaTmp.getEdadEjecucion() : null);
				datPlanillaNominaDTO2.setEstado(
						(datPlanillaNominaTmp.getEstado() != null) ? datPlanillaNominaTmp.getEstado() : null);
				datPlanillaNominaDTO2.setEtapaId(
						(datPlanillaNominaTmp.getEtapaId() != null) ? datPlanillaNominaTmp.getEtapaId() : null);
				datPlanillaNominaDTO2.setFechaCreacion(datPlanillaNominaTmp.getFechaCreacion());
				datPlanillaNominaDTO2.setFechaModificacion(datPlanillaNominaTmp.getFechaModificacion());
				datPlanillaNominaDTO2.setFechaRegistro(datPlanillaNominaTmp.getFechaRegistro());
				datPlanillaNominaDTO2.setIdMobile(
						(datPlanillaNominaTmp.getIdMobile() != null) ? datPlanillaNominaTmp.getIdMobile() : null);
				datPlanillaNominaDTO2.setInfoAdicional((datPlanillaNominaTmp.getInfoAdicional() != null)
						? datPlanillaNominaTmp.getInfoAdicional() : null);
				datPlanillaNominaDTO2.setInfoAdicional2((datPlanillaNominaTmp.getInfoAdicional2() != null)
						? datPlanillaNominaTmp.getInfoAdicional2() : null);
				datPlanillaNominaDTO2.setLatitud(
						(datPlanillaNominaTmp.getLatitud() != null) ? datPlanillaNominaTmp.getLatitud() : null);
				datPlanillaNominaDTO2.setLongitud(
						(datPlanillaNominaTmp.getLongitud() != null) ? datPlanillaNominaTmp.getLongitud() : null);
				datPlanillaNominaDTO2.setNivel1Id(
						(datPlanillaNominaTmp.getNivel1Id() != null) ? datPlanillaNominaTmp.getNivel1Id() : null);
				if (datPlanillaNominaTmp.getNivel2Id() != null) {
					datPlanillaNominaDTO2.setNivel2Id(datPlanillaNominaTmp.getNivel2Id().getNivel2Id());
				} else {
					datPlanillaNominaDTO2.setNivel2Id(null);
				}
				datPlanillaNominaDTO2.setNivel3Id(
						(datPlanillaNominaTmp.getNivel3Id() != null) ? datPlanillaNominaTmp.getNivel3Id() : null);
				datPlanillaNominaDTO2.setObservacion(
						(datPlanillaNominaTmp.getObservacion() != null) ? datPlanillaNominaTmp.getObservacion() : null);
				datPlanillaNominaDTO2.setObservacionAnularReg((datPlanillaNominaTmp.getObservacionAnularReg() != null)
						? datPlanillaNominaTmp.getObservacionAnularReg() : null);

				datPlanillaNominaDTO2.setOrdenTrabajo((datPlanillaNominaTmp.getOrdenTrabajo() != null)
						? datPlanillaNominaTmp.getOrdenTrabajo().getPlanLaborDetId() : null);

				datPlanillaNominaDTO2.setPrecision(
						(datPlanillaNominaTmp.getPrecision() != null) ? datPlanillaNominaTmp.getPrecision() : null);
				
				datPlanillaNominaDTO2.setOrigenDatos(
						(datPlanillaNominaTmp.getOrigenDatos() != null) ? datPlanillaNominaTmp.getOrigenDatos() : null);

				datPlanillaNominaDTO2.setUsuarioDigitacion((datPlanillaNominaTmp.getUsuarioDigitacion() != null)
						? datPlanillaNominaTmp.getUsuarioDigitacion() : null);
				datPlanillaNominaDTO2.setVariedId(
						(datPlanillaNominaTmp.getVariedId() != null) ? datPlanillaNominaTmp.getVariedId() : null);

				if (datPlanillaNominaTmp.getLabor() != null) {
					datPlanillaNominaDTO2.setLaborId_Labor(datPlanillaNominaTmp.getLabor().getLaborId());
				} else {
					datPlanillaNominaDTO2.setLaborId_Labor(null);
				}

				if (datPlanillaNominaTmp.getNivel4() != null) {
					datPlanillaNominaDTO2.setNivel4Id_Nivel4(datPlanillaNominaTmp.getNivel4().getNivel4Id());
				} else {
					datPlanillaNominaDTO2.setNivel4Id_Nivel4(null);
				}

				String estadoEstrue = "false";
				if (datPlanillaNominaTmp.getEstado().equals("I")) {
					estadoEstrue = "true";
					datPlanillaNominaDTO2.setEstadoTrue(estadoEstrue);
				}
				datPlanillaNominaDTO2.setEstadoTrue(estadoEstrue);

				datPlanillaNominaDTO.add(datPlanillaNominaDTO2);
			}

			return datPlanillaNominaDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberPlanillaNomina(Map<String, Object> filters) throws Exception {
		Long entity = null;

		try {
			String whereCondition = new String();
			Iterator it = filters.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry e = (Map.Entry) it.next();

				if (e.getKey().equals("laborNombre")) {
					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(labor.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else if (e.getKey().equals("nivel2Nombre")) {

					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(nivel2Id.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else if (e.getKey().equals("nivel4Nombre")) {

					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(nivel4.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else if (e.getKey().equals("ordenTrabajo")) {
					whereCondition += ((whereCondition.length() == 0) ? " " : " and ")
							+ "upper(ordenTrabajo.ordenTrabajo)" + " LIKE '%" + e.getValue().toString().toUpperCase()
							+ "%' ";

				} else if (e.getKey().equals("trabajadorCodigo")) {

					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(trabajador.codigo)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else if (e.getKey().equals("conceptoNomiNombre")) {

					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(conceptoNomina.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else {
					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(" + e.getKey() + ")"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				}

			}
			entity = datPlanillaNominaDAO.countByCriteria(whereCondition);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("PlanillaNomina Count");
		} finally {
		}
		return entity;
	}

}
