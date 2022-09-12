package co.com.arcosoft.modelo.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
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

import co.com.arcosoft.dataaccess.dao.IDatServImplementoDAO;
import co.com.arcosoft.dataaccess.dao.IDatServicioDAO;
import co.com.arcosoft.dataaccess.dao.IEquipoDAO;
import co.com.arcosoft.dataaccess.dao.IEquipoEventoDAO;
import co.com.arcosoft.dataaccess.dao.ITarifaEquipPropDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatServImplemento;
import co.com.arcosoft.modelo.DatServicio;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.EquipoEvento;
import co.com.arcosoft.modelo.TarifaEquipProp;
import co.com.arcosoft.modelo.dto.EquipoDTO;
import co.com.arcosoft.modelo.dto.EquipoEventoDTO;
import co.com.arcosoft.modelo.dto.TarifaEquipPropDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("EquipoLogic")
public class EquipoLogic implements IEquipoLogic {
	private static final Logger log = LoggerFactory
			.getLogger(EquipoLogic.class);

	/**
	 * DAO injected by Spring that manages Equipo entities
	 *
	 */
	@Autowired
	private IEquipoDAO equipoDAO;

	/**
	 * DAO injected by Spring that manages DatServImplemento entities
	 *
	 */
	@Autowired
	private IDatServImplementoDAO datServImplementoDAO;

	/**
	 * DAO injected by Spring that manages DatServicio entities
	 *
	 */
	@Autowired
	private IDatServicioDAO datServicioDAO;

	/**
	 * Logic injected by Spring that manages CategoriaEquipo entities
	 *
	 */
	@Autowired
	ICategoriaEquipoLogic logicCategoriaEquipo1;

	/**
	 * Logic injected by Spring that manages CentCost entities
	 *
	 */
	@Autowired
	ICentCostLogic logicCentCost2;

	/**
	 * Logic injected by Spring that manages Contratista entities
	 *
	 */

	/**
	 * Logic injected by Spring that manages ElementoCosto entities
	 *
	 */
	@Autowired
	IElementoCostoLogic logicElementoCosto4;

	/**
	 * Logic injected by Spring that manages FlotaTransporte entities
	 *
	 */
	@Autowired
	IFlotaTransporteLogic logicFlotaTransporte5;

	/**
	 * Logic injected by Spring that manages Labor entities
	 *
	 */
	@Autowired
	ILaborLogic logicLabor6;

	/**
	 * Logic injected by Spring that manages Medidor entities
	 *
	 */
	@Autowired
	IMedidorLogic logicMedidor7;

	/**
	 * Logic injected by Spring that manages ModeloEquipo entities
	 *
	 */
	@Autowired
	IModeloEquipoLogic logicModeloEquipo8;

	/**
	 * Logic injected by Spring that manages NumeroEje entities
	 *
	 */
	@Autowired
	INumeroEjeLogic logicNumeroEje9;

	/**
	 * Logic injected by Spring that manages Servicio entities
	 *
	 */
	@Autowired
	IServicioLogic logicServicio10;

	/**
	 * Logic injected by Spring that manages Trabajador entities
	 *
	 */
	@Autowired
	ITrabajadorLogic logicTrabajador11;
	
	@Autowired
	private ITarifaEquipPropDAO tarifaEquipPropDAO;
	
	
	@Autowired
	private IEquipoEventoDAO equipoEventoDAO;
	
	

	@Override
	@Transactional(readOnly = true)
	public List<Equipo> getEquipo() throws Exception {
		log.debug("finding all Equipo instances");

		List<Equipo> list = new ArrayList<Equipo>();

		try {
			list = equipoDAO.findAll();
		} catch (Exception e) {
			log.error("finding all Equipo failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL
					+ "Equipo");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveEquipo(Equipo entity, List<TarifaEquipPropDTO> dataTarifaEquipProp,  List<EquipoEventoDTO> dataEventosEquipos) throws Exception {
		log.debug("saving Equipo instance");

		try {
			/*if (entity.getCategoriaEquipo() == null) {
				throw new ZMessManager().new ForeignException("categoriaEquipo");
			}*/
			
			/*if (entity.getContratista() == null) {
				throw new ZMessManager().new ForeignException("contratista");
			}*/
			
			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getAnioFabricacion() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getAnioFabricacion(), 4, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"anioFabricacion");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getColor() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getColor(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("color");
			}

			if ((entity.getTipoPropiedad() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getTipoPropiedad(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"tipoPropiedad");
			}

			if ((entity.getCompania() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getFoto() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getFoto(),
							150) == false)) {
				throw new ZMessManager().new NotValidFormatException("foto");
			}

			if ((entity.getFuncion() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getFuncion(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("funcion");
			}

			if ((entity.getInfoAdicional() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getInfoAdicional(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"infoAdicional");
			}

			if ((entity.getInfoAdicional2() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getInfoAdicional2(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"infoAdicional2");
			}

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getNombre(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			if ((entity.getPlaca() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getPlaca(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("placa");
			}

			if ((entity.getTaraEstandar() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getTaraEstandar(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"taraEstandar");
			}

/*			if (entity.getCategoriaEquipo().getCategEquipId() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"categEquipId_CategoriaEquipo");
			}*/

			/*if ((entity.getCategoriaEquipo().getCategEquipId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCategoriaEquipo().getCategEquipId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"categEquipId_CategoriaEquipo");
			}

			if ((entity.getCentCost() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCentCost(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"centCostId_CentCost");
			}

			if (entity.getContratista().getPersEmprId() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"contratistaId_Contratista");
			}

			if ((entity.getContratista().getPersEmprId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getContratista().getPersEmprId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"contratistaId_Contratista");
			}
*/
			if ((entity.getElementoCosto() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getElementoCosto(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"elemCostoId_ElementoCosto");
			}

			if ((entity.getFlotaTransporte() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getFlotaTransporte(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"flotaTranspId_FlotaTransporte");
			}
			
			if ((entity.getLabor() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getLabor(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"laborId_Labor");
			}

			if ((entity.getMedidor() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getMedidor(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"medidorId_Medidor");
			}
			
			if ((entity.getModeloEquipo() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getModeloEquipo(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"modeloEquipoId_ModeloEquipo");
			}

			if ((entity.getNumeroEje() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getNumeroEje(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"numEjeId_NumeroEje");
			}

			if ((entity.getServicio() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getServicio(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"servicioId_Servicio");
			}

			if ((entity.getTrabajador() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getTrabajador(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"trabId_Trabajador");
			}

			equipoDAO.save(entity);

			if (dataTarifaEquipProp != null) {

				for (TarifaEquipPropDTO valorDto : dataTarifaEquipProp) {

					if (valorDto.getTarifaEquipPropId() == null) {

						TarifaEquipProp valor = new TarifaEquipProp();

						valor.setCompania(valorDto.getCompania());
						valor.setFechaInicial(valorDto.getFechaInicial());
						valor.setFechaFinal(valorDto.getFechaFinal());
						valor.setTarifa(valorDto.getTarifa());
						valor.setFechaCreacion(valorDto.getFechaCreacion());
						valor.setFechaModificacion(valorDto.getFechaModificacion());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());
						valor.setLabor_tarifa(valorDto.getLabor_tarifa());
						valor.setEquipo(entity);

						tarifaEquipPropDAO.save(valor);
					}

				}
			}
			
			if(dataEventosEquipos !=null){
				
				for (EquipoEventoDTO equipoEventoDTO : dataEventosEquipos) {
					
					if(equipoEventoDTO.getId() == null){
						
						EquipoEvento ee = new EquipoEvento();
						
						ee.setFechaInicial(equipoEventoDTO.getFechaInicial());
						ee.setFechaFinal(equipoEventoDTO.getFechaFinal());
						ee.setEventos(equipoEventoDTO.getEventosId_Eventos());
						ee.setFechaCreacion(equipoEventoDTO.getFechaCreacion());
						ee.setFechaModificacion(equipoEventoDTO.getFechaModificacion());
						ee.setDiasNotificacion(equipoEventoDTO.getDiasNotificacion());
						ee.setRegistraPago(equipoEventoDTO.getRegistraPago());
						ee.setEquipo(entity);
						
						equipoEventoDAO.save(ee);
						
					}
				}
			}
			log.debug("save Equipo successful");
		} catch (Exception e) {
			log.error("save Equipo failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteEquipo(Equipo entity) throws Exception {
		log.debug("deleting Equipo instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Equipo");
		}

		if (entity.getEquipoId() == null) {
			throw new ZMessManager().new EmptyFieldException("equipoId");
		}

		List<DatServImplemento> datServImplementos = null;
		List<DatServicio> datServicios = null;
		List<TarifaEquipProp> dataTarifaEquipProps = null;
		try {
			datServImplementos = datServImplementoDAO.findByProperty(
					"equipo.equipoId", entity.getEquipoId());

			if (Utilities.validationsList(datServImplementos) == true) {
				throw new ZMessManager().new DeletingException(
						"datServImplementos");
			}

			datServicios = datServicioDAO.findByProperty("equipo.equipoId",
					entity.getEquipoId());


			if (Utilities.validationsList(datServicios) == true) {
				throw new ZMessManager().new DeletingException("datServicios");
			}

			dataTarifaEquipProps = tarifaEquipPropDAO.findByProperty(
					"equipo.equipoId",entity.getEquipoId());

			if (Utilities.validationsList(dataTarifaEquipProps) == true) {
				throw new ZMessManager().new DeletingException(
						"dataTarifaEquipProps");
			}
			equipoDAO.delete(entity);

			log.debug("delete Equipo successful");
		} catch (Exception e) {
			log.error("delete Equipo failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateEquipo(Equipo entity, List<TarifaEquipPropDTO> dataTarifaEquipProp,  List<EquipoEventoDTO> dataEventosEquipos) throws Exception {
		log.debug("updating Equipo instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Equipo");
			}

			/*if (entity.getCategoriaEquipo() == null) {
				throw new ZMessManager().new ForeignException("categoriaEquipo");
			}
			
			if (entity.getContratista() == null) {
				throw new ZMessManager().new ForeignException("contratista");
			}
			*/
			if ((entity.getAnioFabricacion() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getAnioFabricacion(), 4, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"anioFabricacion");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getColor() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getColor(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("color");
			}

			if ((entity.getTipoPropiedad() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getTipoPropiedad(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"tipoPropiedad");
			}

			if ((entity.getCompania() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if (entity.getEquipoId() == null) {
				throw new ZMessManager().new EmptyFieldException("equipoId");
			}

			if ((entity.getEquipoId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getEquipoId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("equipoId");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getFoto() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getFoto(),
							150) == false)) {
				throw new ZMessManager().new NotValidFormatException("foto");
			}

			if ((entity.getFuncion() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getFuncion(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("funcion");
			}

			if ((entity.getInfoAdicional() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getInfoAdicional(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"infoAdicional");
			}

			if ((entity.getInfoAdicional2() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getInfoAdicional2(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"infoAdicional2");
			}

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getNombre(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			if ((entity.getPlaca() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getPlaca(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("placa");
			}

			if ((entity.getTaraEstandar() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getTaraEstandar(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"taraEstandar");
			}

			/*if (entity.getCategoriaEquipo().getCategEquipId() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"categEquipId_CategoriaEquipo");
			}

			if ((entity.getCategoriaEquipo().getCategEquipId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCategoriaEquipo().getCategEquipId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"categEquipId_CategoriaEquipo");
			}*/

			if ((entity.getCentCost() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCentCost(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"centCostId_CentCost");
			}

			/*if (entity.getContratista().getPersEmprId() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"contratistaId_Contratista");
			}

			if ((entity.getContratista().getPersEmprId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getContratista().getPersEmprId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"contratistaId_Contratista");
			}
			*/
			
			if ((entity.getElementoCosto() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getElementoCosto(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"elemCostoId_ElementoCosto");
			}

			if ((entity.getFlotaTransporte() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getFlotaTransporte(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"flotaTranspId_FlotaTransporte");
			}

			if ((entity.getLabor() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getLabor(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"laborId_Labor");
			}

			if ((entity.getMedidor() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getMedidor(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"medidorId_Medidor");
			}

			if ((entity.getModeloEquipo() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getModeloEquipo(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"modeloEquipoId_ModeloEquipo");
			}

			if ((entity.getNumeroEje() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getNumeroEje(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"numEjeId_NumeroEje");
			}
			
			if ((entity.getServicio() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getServicio(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"servicioId_Servicio");
			}

			if ((entity.getTrabajador() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getTrabajador(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"trabId_Trabajador");
			}

			equipoDAO.update(entity);

			if (dataTarifaEquipProp != null) {

				for (TarifaEquipPropDTO valorDto : dataTarifaEquipProp) {

					if (valorDto.getTarifaEquipPropId() == null) {

						TarifaEquipProp valor = new TarifaEquipProp();

						valor.setCompania(valorDto.getCompania());
						valor.setLabor_tarifa(valorDto.getLabor_tarifa());
						valor.setFechaInicial(valorDto.getFechaInicial());
						valor.setFechaFinal(valorDto.getFechaFinal());
						valor.setTarifa(valorDto.getTarifa());
						valor.setFechaCreacion(valorDto.getFechaCreacion());
						valor.setFechaModificacion(valorDto.getFechaModificacion());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());
						
						valor.setEquipo(entity);

						tarifaEquipPropDAO.save(valor);
						
					} else  {
						
						TarifaEquipProp valor = tarifaEquipPropDAO
								.findById(valorDto.getTarifaEquipPropId());

						valor.setCompania(valorDto.getCompania());
						valor.setLabor_tarifa(valorDto.getLabor_tarifa());
						valor.setFechaInicial(valorDto.getFechaInicial());
						valor.setFechaFinal(valorDto.getFechaFinal());
						valor.setTarifa(valorDto.getTarifa());
						valor.setFechaCreacion(valorDto.getFechaCreacion());
						valor.setFechaModificacion(valorDto.getFechaModificacion());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());
						
						valor.setEquipo(entity);

					}


				}
			}
			
			if(dataEventosEquipos !=null){
				
				for (EquipoEventoDTO equipoEventoDTO : dataEventosEquipos) {
					
					if(equipoEventoDTO.getId() == null){
						
						EquipoEvento ee = new EquipoEvento();
						
						ee.setFechaInicial(equipoEventoDTO.getFechaInicial());
						ee.setFechaFinal(equipoEventoDTO.getFechaFinal());
						ee.setEventos(equipoEventoDTO.getEventosId_Eventos());
						ee.setFechaCreacion(equipoEventoDTO.getFechaCreacion());
						ee.setFechaModificacion(equipoEventoDTO.getFechaModificacion());
						ee.setDiasNotificacion(equipoEventoDTO.getDiasNotificacion());
						ee.setRegistraPago(equipoEventoDTO.getRegistraPago());
						
						ee.setEquipo(entity);
						
						equipoEventoDAO.save(ee);

						
					}else{
						
						EquipoEvento ee = equipoEventoDAO.findById(equipoEventoDTO.getId());
						
						ee.setFechaInicial(equipoEventoDTO.getFechaInicial());
						ee.setFechaFinal(equipoEventoDTO.getFechaFinal());
						ee.setEventos(equipoEventoDTO.getEventosId_Eventos());
						ee.setFechaCreacion(equipoEventoDTO.getFechaCreacion());
						ee.setFechaModificacion(equipoEventoDTO.getFechaModificacion());
						ee.setDiasNotificacion(equipoEventoDTO.getDiasNotificacion());
						ee.setRegistraPago(equipoEventoDTO.getRegistraPago());
						
						ee.setEquipo(entity);
						
						equipoEventoDAO.update(ee);

					}

				}
				
			}


			log.debug("update Equipo successful");
		} catch (Exception e) {
			log.error("update Equipo failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<EquipoDTO> getDataEquipo() throws Exception {
		try {
			List<Equipo> equipo = equipoDAO.findAll();

			List<EquipoDTO> equipoDTO = new ArrayList<EquipoDTO>();

			for (Equipo equipoTmp : equipo) {
				EquipoDTO equipoDTO2 = new EquipoDTO();

				equipoDTO2.setEquipoId(equipoTmp.getEquipoId());
				equipoDTO2
						.setAnioFabricacion((equipoTmp.getAnioFabricacion() != null) ? equipoTmp
								.getAnioFabricacion() : null);
				equipoDTO2
						.setCodigo((equipoTmp.getCodigo() != null) ? equipoTmp
								.getCodigo() : null);
				equipoDTO2.setColor((equipoTmp.getColor() != null) ? equipoTmp
						.getColor() : null);
				equipoDTO2
						.setCompania((equipoTmp.getCompania() != null) ? equipoTmp
								.getCompania() : null);
				equipoDTO2
						.setEstado((equipoTmp.getEstado() != null) ? equipoTmp
								.getEstado() : null);
				equipoDTO2.setFechaCreacion(equipoTmp.getFechaCreacion());
				equipoDTO2.setFechaModificacion(equipoTmp
						.getFechaModificacion());
				equipoDTO2.setFoto((equipoTmp.getFoto() != null) ? equipoTmp
						.getFoto() : null);
				equipoDTO2.setFoto((equipoTmp.getFoto() != null && !equipoTmp
						.getFoto().equals("")) ? equipoTmp.getFoto()
						: "default.jpg");
				equipoDTO2
						.setFuncion((equipoTmp.getFuncion() != null) ? equipoTmp
								.getFuncion() : null);
				equipoDTO2
						.setInfoAdicional((equipoTmp.getInfoAdicional() != null) ? equipoTmp
								.getInfoAdicional() : null);
				equipoDTO2
						.setInfoAdicional2((equipoTmp.getInfoAdicional2() != null) ? equipoTmp
								.getInfoAdicional2() : null);
				equipoDTO2
						.setNombre((equipoTmp.getNombre() != null) ? equipoTmp
								.getNombre() : null);
				equipoDTO2.setPlaca((equipoTmp.getPlaca() != null) ? equipoTmp
						.getPlaca() : null);
				equipoDTO2
						.setTaraEstandar((equipoTmp.getTaraEstandar() != null) ? equipoTmp
								.getTaraEstandar() : null);
				equipoDTO2
						.setCategEquipId_CategoriaEquipo((equipoTmp
								.getCategoriaEquipo() != null) ? equipoTmp
								.getCategoriaEquipo().getCategEquipId() : null);
				equipoDTO2
						.setCentCostId_CentCost((equipoTmp.getCentCost() != null) ? equipoTmp
								.getCentCost() : null);

				if (equipoTmp.getContratista() != null) {
					equipoDTO2.setContratistaId_Contratista(equipoTmp
							.getContratista().getPersEmprId());
				} else {
					equipoDTO2.setContratistaId_Contratista(null);
				}

				equipoDTO2.setElemCostoId_ElementoCosto((equipoTmp
						.getElementoCosto() != null) ? equipoTmp
						.getElementoCosto() : null);
				equipoDTO2.setFlotaTranspId_FlotaTransporte((equipoTmp
						.getFlotaTransporte() != null) ? equipoTmp
						.getFlotaTransporte() : null);
				equipoDTO2.setModeloEquipoId_ModeloEquipo((equipoTmp
						.getModeloEquipo() != null) ? equipoTmp
						.getModeloEquipo() : null);
				equipoDTO2
						.setNumEjeId_NumeroEje((equipoTmp.getNumeroEje() != null) ? equipoTmp
								.getNumeroEje() : null);
				equipoDTO2
						.setTrabId_Trabajador((equipoTmp.getTrabajador() != null) ? equipoTmp
								.getTrabajador() : null);
				equipoDTO2
						.setServicioId_Servicio((equipoTmp.getServicio() != null) ? equipoTmp
								.getServicio() : null);
				equipoDTO2
						.setMedidorId_Medidor((equipoTmp.getMedidor() != null) ? equipoTmp
								.getMedidor() : null);
				equipoDTO2
						.setLaborId_Labor((equipoTmp.getLabor() != null) ? equipoTmp
								.getLabor() : null);
				equipoDTO2
						.setTipoPropiedad((equipoTmp.getTipoPropiedad() != null) ? equipoTmp
								.getTipoPropiedad() : null);
				
				equipoDTO2
				.setOrigenDatos((equipoTmp.getOrigenDatos() != null) ? equipoTmp
						.getOrigenDatos() : null);
		
				equipoDTO2.setIndicador_vuelta_medidor((equipoTmp.getIndicador_vuelta_medidor() != null)
                        ? equipoTmp.getIndicador_vuelta_medidor() : null);
				
				
				equipoDTO2.setHor_odo_abastecimiento_inicial((equipoTmp.getHor_odo_abastecimiento_inicial() != null)
                        ? equipoTmp.getHor_odo_abastecimiento_inicial() : null);
                
				if (equipoTmp.getCapacidadTanque() != null) {
					equipoDTO2.setCapacidadTanque(equipoTmp
							.getCapacidadTanque());
				} else {
					equipoDTO2.setCapacidadTanque(null);
				}

				equipoDTO.add(equipoDTO2);
			}

			return equipoDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Equipo getEquipo(Long equipoId) throws Exception {
		log.debug("getting Equipo instance");

		Equipo entity = null;

		try {
			entity = equipoDAO.findById(equipoId);
		} catch (Exception e) {
			log.error("get Equipo failed", e);
			throw new ZMessManager().new FindingException("Equipo");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Equipo> findPageEquipo(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<Equipo> entity = null;

		try {
			entity = equipoDAO.findPage(sortColumnName, sortAscending,
					startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Equipo Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberEquipo() throws Exception {
		Long entity = null;

		try {
			entity = equipoDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Equipo Count");
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
	public List<Equipo> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<Equipo> list = new ArrayList<Equipo>();
		String where = new String();
		String tempWhere = new String();

		if (variables != null) {
			for (int i = 0; i < variables.length; i++) {
				if ((variables[i] != null) && (variables[i + 1] != null)
						&& (variables[i + 2] != null)
						&& (variables[i + 3] != null)) {
					String variable = (String) variables[i];
					Boolean booVariable = (Boolean) variables[i + 1];
					Object value = variables[i + 2];
					String comparator = (String) variables[i + 3];

					if (booVariable.booleanValue()) {
						tempWhere = (tempWhere.length() == 0) ? ("(model."
								+ variable + " " + comparator + " \'" + value + "\' )")
								: (tempWhere + " AND (model." + variable + " "
										+ comparator + " \'" + value + "\' )");
					} else {
						tempWhere = (tempWhere.length() == 0) ? ("(model."
								+ variable + " " + comparator + " " + value + " )")
								: (tempWhere + " AND (model." + variable + " "
										+ comparator + " " + value + " )");
					}
				}

				i = i + 3;
			}
		}

		if (variablesBetween != null) {
			for (int j = 0; j < variablesBetween.length; j++) {
				if ((variablesBetween[j] != null)
						&& (variablesBetween[j + 1] != null)
						&& (variablesBetween[j + 2] != null)
						&& (variablesBetween[j + 3] != null)
						&& (variablesBetween[j + 4] != null)) {
					String variable = (String) variablesBetween[j];
					Object value = variablesBetween[j + 1];
					Object value2 = variablesBetween[j + 2];
					String comparator1 = (String) variablesBetween[j + 3];
					String comparator2 = (String) variablesBetween[j + 4];
					tempWhere = (tempWhere.length() == 0) ? ("(" + value + " "
							+ comparator1 + " " + variable + " and " + variable
							+ " " + comparator2 + " " + value2 + " )")
							: (tempWhere + " AND (" + value + " " + comparator1
									+ " " + variable + " and " + variable + " "
									+ comparator2 + " " + value2 + " )");
				}

				j = j + 4;
			}
		}

		if (variablesBetweenDates != null) {
			for (int k = 0; k < variablesBetweenDates.length; k++) {
				if ((variablesBetweenDates[k] != null)
						&& (variablesBetweenDates[k + 1] != null)
						&& (variablesBetweenDates[k + 2] != null)) {
					String variable = (String) variablesBetweenDates[k];
					Object object1 = variablesBetweenDates[k + 1];
					Object object2 = variablesBetweenDates[k + 2];
					String value = null;
					String value2 = null;

					try {
						Date date1 = (Date) object1;
						Date date2 = (Date) object2;
						value = Utilities
								.formatDateWithoutTimeInAStringForBetweenWhere(date1);
						value2 = Utilities
								.formatDateWithoutTimeInAStringForBetweenWhere(date2);
					} catch (Exception e) {
						list = null;
						throw e;
					}

					tempWhere = (tempWhere.length() == 0) ? ("(model."
							+ variable + " between \'" + value + "\' and \'"
							+ value2 + "\')") : (tempWhere + " AND (model."
							+ variable + " between \'" + value + "\' and \'"
							+ value2 + "\')");
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
			list = equipoDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<EquipoDTO> findByCriteriaPageEquipo(int startRow, int pageSize,
			String sortField, boolean sortOrder, Map<String, Object> filters, String modulo)
			throws Exception {
		try {
			List<Equipo> entity = null;

			String whereCondition = new String();
			Iterator it = filters.entrySet().iterator();

			while (it.hasNext()) {
				Map.Entry e = (Map.Entry) it.next();
				whereCondition += ((whereCondition.length() == 0) ? " "
						: " and ")
						+ "upper("
						+ e.getKey()
						+ ")"
						+ " LIKE '%"
						+ e.getValue().toString().toUpperCase() + "%' ";
			}
			
			whereCondition += ((whereCondition.length() == 0) ? " " : " and ") +"origenDatos="+"'"+modulo+"'";

			entity = equipoDAO.findByCriteriaPage(whereCondition, sortField,
					sortOrder, startRow, pageSize);

			List<EquipoDTO> equipoDTO = new ArrayList<EquipoDTO>();
			
			

			for (Equipo equipoTmp : entity) {
				EquipoDTO equipoDTO2 = new EquipoDTO();

				equipoDTO2.setEquipoId(equipoTmp.getEquipoId());
				equipoDTO2
						.setAnioFabricacion((equipoTmp.getAnioFabricacion() != null) ? equipoTmp
								.getAnioFabricacion() : null);
				equipoDTO2
						.setCodigo((equipoTmp.getCodigo() != null) ? equipoTmp
								.getCodigo() : null);
				equipoDTO2.setColor((equipoTmp.getColor() != null) ? equipoTmp
						.getColor() : null);
				equipoDTO2
						.setCompania((equipoTmp.getCompania() != null) ? equipoTmp
								.getCompania() : null);
				equipoDTO2
						.setEstado((equipoTmp.getEstado() != null) ? equipoTmp
								.getEstado() : null);
				equipoDTO2.setFechaCreacion(equipoTmp.getFechaCreacion());
				equipoDTO2.setFechaModificacion(equipoTmp
						.getFechaModificacion());
				equipoDTO2.setFoto((equipoTmp.getFoto() != null) ? equipoTmp
						.getFoto() : null);
				equipoDTO2.setFoto((equipoTmp.getFoto() != null && !equipoTmp
						.getFoto().equals("")) ? equipoTmp.getFoto()
						: "default.jpg");
				equipoDTO2
						.setFuncion((equipoTmp.getFuncion() != null) ? equipoTmp
								.getFuncion() : null);
				equipoDTO2
						.setInfoAdicional((equipoTmp.getInfoAdicional() != null) ? equipoTmp
								.getInfoAdicional() : null);
				equipoDTO2
						.setInfoAdicional2((equipoTmp.getInfoAdicional2() != null) ? equipoTmp
								.getInfoAdicional2() : null);
				equipoDTO2
						.setNombre((equipoTmp.getNombre() != null) ? equipoTmp
								.getNombre() : null);
				equipoDTO2.setPlaca((equipoTmp.getPlaca() != null) ? equipoTmp
						.getPlaca() : null);
				equipoDTO2
						.setTaraEstandar((equipoTmp.getTaraEstandar() != null) ? equipoTmp
								.getTaraEstandar() : null);
				
				equipoDTO2.setCategEquipId_CategoriaEquipo((equipoTmp
								.getCategoriaEquipo() != null) ? equipoTmp
								.getCategoriaEquipo().getCategEquipId() : null);
				equipoDTO2
						.setCentCostId_CentCost((equipoTmp.getCentCost() != null) ? equipoTmp
								.getCentCost() : null);

				if (equipoTmp.getContratista() != null) {
					equipoDTO2.setContratistaId_Contratista(equipoTmp
							.getContratista().getPersEmprId());
				} else {
					equipoDTO2.setContratistaId_Contratista(null);
				}

				equipoDTO2.setElemCostoId_ElementoCosto((equipoTmp
						.getElementoCosto() != null) ? equipoTmp
						.getElementoCosto() : null);
				equipoDTO2.setFlotaTranspId_FlotaTransporte((equipoTmp
						.getFlotaTransporte() != null) ? equipoTmp
						.getFlotaTransporte() : null);
				equipoDTO2.setModeloEquipoId_ModeloEquipo((equipoTmp
						.getModeloEquipo() != null) ? equipoTmp
						.getModeloEquipo() : null);
				equipoDTO2
						.setNumEjeId_NumeroEje((equipoTmp.getNumeroEje() != null) ? equipoTmp
								.getNumeroEje() : null);
				equipoDTO2
						.setTrabId_Trabajador((equipoTmp.getTrabajador() != null) ? equipoTmp
								.getTrabajador() : null);
				equipoDTO2
						.setServicioId_Servicio((equipoTmp.getServicio() != null) ? equipoTmp
								.getServicio() : null);
				equipoDTO2
						.setMedidorId_Medidor((equipoTmp.getMedidor() != null) ? equipoTmp
								.getMedidor() : null);
				equipoDTO2
						.setLaborId_Labor((equipoTmp.getLabor() != null) ? equipoTmp
								.getLabor() : null);
				equipoDTO2
						.setTipoPropiedad((equipoTmp.getTipoPropiedad() != null) ? equipoTmp
								.getTipoPropiedad() : null);
				
				equipoDTO2
				.setOrigenDatos((equipoTmp.getOrigenDatos() != null) ? equipoTmp
						.getOrigenDatos() : null);
		
				
				equipoDTO2.setFechaUltimoServicios(equipoTmp.getFechaUltimoServicios());
				
				equipoDTO2.setFechaUltimoAbastecimiento(equipoTmp.getFechaUltimoAbastecimiento());
				
				equipoDTO2.setGenerico(equipoTmp.getGenerico());
				equipoDTO2.setExcluirDistribucciones(equipoTmp.getExcluirDistribucciones());

				equipoDTO2
				.setValorCompra((equipoTmp.getValorCompra() != null) ? equipoTmp
						.getValorCompra() : null);
		
				  
				equipoDTO2.setIndicador_vuelta_medidor((equipoTmp.getIndicador_vuelta_medidor() != null)
                        ? equipoTmp.getIndicador_vuelta_medidor() : null);
                
				
				equipoDTO2.setHor_odo_abastecimiento_inicial((equipoTmp.getHor_odo_abastecimiento_inicial() != null)
                        ? equipoTmp.getHor_odo_abastecimiento_inicial() : null);
                
				equipoDTO2
				.setTipoDistribuccionCostos((equipoTmp.getTipoDistribuccionCostos() != null) ? equipoTmp
						.getTipoDistribuccionCostos() : null);
				
				Long cant = calcular_cantidadEventos(equipoTmp.getEquipoId());
				
				if(cant > 0 ){
					equipoDTO2.setColorEvento("btn btn-danger");
					equipoDTO2.setContarEventos(cant);
					cant = 0L;
				}else{
					equipoDTO2.setColorEvento("btn btn-primary");
					equipoDTO2.setContarEventos(0L);
				}
				
				if (equipoTmp.getCategoriaEquipo() != null) {
					equipoDTO2.setNombreCategoria(equipoTmp
							.getCategoriaEquipo().getNombre());
				} else {
					equipoDTO2.setNombreCategoria(null);
				}


				if (equipoTmp.getCategoriaEquipo() != null) {
					equipoDTO2.setCategoriaEquipo(equipoTmp
							.getCategoriaEquipo());
				} else {
					equipoDTO2.setCategoriaEquipo(null);
				}

				if (equipoTmp.getCapacidadTanque() != null) {
					equipoDTO2.setCapacidadTanque(equipoTmp
							.getCapacidadTanque());
				} else {
					equipoDTO2.setCapacidadTanque(null);
				}

				
				equipoDTO.add(equipoDTO2);
				
				
			}
			return equipoDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	public long calcular_cantidadEventos(Long equipoId) {

		java.util.Date hoy = new Date();
		GregorianCalendar cPeriodoInicial = new GregorianCalendar();
		GregorianCalendar cPeriodoFinal = new GregorianCalendar();
		GregorianCalendar cHoy = new GregorianCalendar();
		GregorianCalendar cFechaNotificacion = new GregorianCalendar();
		long diasNotif = 0;
		long diasTotales = 0;
		int diasRestantes = 0;
		int contarEventos = 0;
	
		List<EquipoEvento> equipoEvento = equipoEventoDAO.findByCriteria("equipo.equipoId= " + equipoId);
		
		if (equipoEvento != null && equipoEvento.size() > 0) {

			for (EquipoEvento equipoEvento2 : equipoEvento) {
			 if(equipoEvento2.getRegistraPago() !=null ){
				if (equipoEvento2.getRegistraPago().equals("NO")) {

					cPeriodoInicial.setTime(equipoEvento2.getFechaInicial());
					int dia = cPeriodoInicial.get(java.util.Calendar.DAY_OF_MONTH);
					int mes = cPeriodoInicial.get(java.util.Calendar.MONTH);
					int ano = cPeriodoInicial.get(java.util.Calendar.YEAR);
					cPeriodoInicial.set(ano, mes, dia);
					java.sql.Date fechaPeriodoInicial = new java.sql.Date(cPeriodoInicial.getTimeInMillis());

					cPeriodoFinal.setTime(equipoEvento2.getFechaFinal());
					int diaF = cPeriodoFinal.get(java.util.Calendar.DAY_OF_MONTH);
					int mesF = cPeriodoFinal.get(java.util.Calendar.MONTH);
					int anoF = cPeriodoFinal.get(java.util.Calendar.YEAR);
					cPeriodoFinal.set(anoF, mesF, diaF);
					java.sql.Date fechaPeriodoFinal = new java.sql.Date(cPeriodoFinal.getTimeInMillis());

					cHoy.setTime(hoy);
					int diaHoy = cHoy.get(java.util.Calendar.DAY_OF_MONTH);
					int mesHoy = cHoy.get(java.util.Calendar.MONTH);
					int anoHoy = cHoy.get(java.util.Calendar.YEAR);
					cHoy.set(anoHoy, mesHoy, diaHoy);
					java.sql.Date fechaHoy = new java.sql.Date(cHoy.getTimeInMillis());
					
					if(equipoEvento2.getDiasNotificacion() !=null){
					diasNotif = equipoEvento2.getDiasNotificacion().longValue();
					}
					diasTotales = (fechaPeriodoFinal.getTime() - fechaPeriodoInicial.getTime())/(24 * 60 * 60 * 1000);
					
					if(diasTotales > diasNotif){
						diasRestantes = (int) (diasTotales - diasNotif);
					}else{   diasRestantes = (int) (diasNotif - diasTotales); }
					
					cFechaNotificacion.setTime(equipoEvento2.getFechaInicial());
					int diaNF = cFechaNotificacion.get(java.util.Calendar.DAY_OF_MONTH);
					int mesNF = cFechaNotificacion.get(java.util.Calendar.MONTH);
					int anoNF = cFechaNotificacion.get(java.util.Calendar.YEAR);
					cFechaNotificacion.set(anoNF, mesNF, diasRestantes+1);
					java.sql.Date fechaNotificar = new java.sql.Date(cFechaNotificacion.getTimeInMillis());

					if(fechaHoy.getTime() >= fechaNotificar.getTime()){
						
						contarEventos ++;
						
						
						
					}
				
				}

			}
		  }
		
		}
		return contarEventos;
	}
	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberEquipo(Map<String, Object> filters)
			throws Exception {
		Long entity = null;

		try {
			String whereCondition = new String();
			Iterator it = filters.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry e = (Map.Entry) it.next();
				whereCondition += ((whereCondition.length() == 0) ? " "
						: " and ")
						+ "upper("
						+ e.getKey()
						+ ")"
						+ " LIKE '%"
						+ e.getValue().toString().toUpperCase() + "%' ";
			}
			entity = equipoDAO.countByCriteria(whereCondition);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Equipo Count");
		} finally {
		}
		return entity;
	}

}
