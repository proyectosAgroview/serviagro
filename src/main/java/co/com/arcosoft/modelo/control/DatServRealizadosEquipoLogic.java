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

import co.com.arcosoft.dataaccess.dao.IDatServRealizadosEquipoDAO;
import co.com.arcosoft.dataaccess.dao.IDatServRealizadosEquipoDetDAO;
import co.com.arcosoft.dataaccess.dao.IPrecioPromProdDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatServRealizadosEquipo;
import co.com.arcosoft.modelo.DatServRealizadosEquipoDet;
import co.com.arcosoft.modelo.PrecioPromProd;
import co.com.arcosoft.modelo.dto.DatServRealizadosEquipoDTO;
import co.com.arcosoft.modelo.dto.DatServRealizadosEquipoDetDTO;
import co.com.arcosoft.modelo.dto.PrecioPromProdDTO;
import co.com.arcosoft.utilities.Utilities;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("DatServRealizadosEquipoLogic")
public class DatServRealizadosEquipoLogic
    implements IDatServRealizadosEquipoLogic {
    private static final Logger log = LoggerFactory.getLogger(DatServRealizadosEquipoLogic.class);

    /**
     * DAO injected by Spring that manages DatServRealizadosEquipo entities
     *
     */
    @Autowired
    private IDatServRealizadosEquipoDAO datServRealizadosEquipoDAO;

    /**
    * Logic injected by Spring that manages CentCost entities
    *
    */
    @Autowired
    ICentCostLogic logicCentCost1;

    @Autowired
  IDatServRealizadosEquipoDetDAO datServRealizadosEquipoDetDAO;

    
    @Autowired
    IPrecioPromProdDAO precioPromProdDAO;

    /**
    * Logic injected by Spring that manages ElementoCosto entities
    *
    */
    @Autowired
    IElementoCostoLogic logicElementoCosto2;

    /**
    * Logic injected by Spring that manages Equipo entities
    *
    */
    @Autowired
    IEquipoLogic logicEquipo3;

    /**
    * Logic injected by Spring that manages PersEmpr entities
    *
    */
    @Autowired
    IPersEmprLogic logicPersEmpr4;

    @Transactional(readOnly = true)
    public List<DatServRealizadosEquipo> getDatServRealizadosEquipo()
        throws Exception {
        log.debug("finding all DatServRealizadosEquipo instances");

        List<DatServRealizadosEquipo> list = new ArrayList<DatServRealizadosEquipo>();

        try {
            list = datServRealizadosEquipoDAO.findAll();
        } catch (Exception e) {
            log.error("finding all DatServRealizadosEquipo failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "DatServRealizadosEquipo");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveDatServRealizadosEquipo(DatServRealizadosEquipo entity, List<DatServRealizadosEquipoDetDTO> dataServDet,
    		 List<PrecioPromProdDTO> dataDetPrecioProductos )
        throws Exception {
        log.debug("saving DatServRealizadosEquipo instance");

        try {
 

            if (entity.getEquipo() == null) {
                throw new ZMessManager().new ForeignException("equipo");
            }

            if ((entity.getEstado() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
                throw new ZMessManager().new NotValidFormatException("estado");
            }


            if ((entity.getObservacion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getObservacion(), 3000) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "observacion");
            }

            if ((entity.getObservacionAnularReg() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getObservacionAnularReg(), 500) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "observacionAnularReg");
            }

            if ((entity.getOrigenDatos() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getOrigenDatos(), 30) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "origenDatos");
            }

            if ((entity.getSerieFactura() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getSerieFactura(), 60) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "serieFactura");
            }

            

            if (entity.getEquipo().getEquipoId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "equipoId_Equipo");
            }


      
            datServRealizadosEquipoDAO.save(entity);
            
        	if (dataServDet != null) {

				for (DatServRealizadosEquipoDetDTO valorDto : dataServDet) {

					if (valorDto.getDatServRealizadosEquipoDetId() == null) {

						DatServRealizadosEquipoDet valor = new DatServRealizadosEquipoDet();

						valor.setLabor(valorDto.getLaborId_Labor());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());
						valor.setHoraFinal(valorDto.getHoraFinal());
						valor.setHoraInicial(valorDto.getHoraInicial());
						valor.setHorometroInicial(valorDto.getHorometroInicial());
						valor.setHorometroFinal(valorDto.getHorometroFinal());
						
						if(valorDto.getHorometroInicial()!=null && valorDto.getHorometroFinal()!=null ) {
							valor.setHorasTotal(valorDto.getHorometroFinal() - valorDto.getHorometroInicial());
							valor.setHorometroTotal(valorDto.getHorometroFinal() - valorDto.getHorometroInicial());
						}else {
							valor.setHorasTotal(valorDto.getHorasTotal());
							valor.setHorometroTotal(valorDto.getHorometroTotal());
						}
						
						
						
						valor.setCantidad(valorDto.getCantidad());
						valor.setIngresoTotal(valorDto.getIngresoTotal());
						valor.setValorUnitario(valorDto.getValorUnitario());
						
						valor.setNivel2Id(valorDto.getNivel2());
						valor.setNivel4(valorDto.getNivel4());
						
						valor.setNombreNivel4(valorDto.getNombreNivel4());
						valor.setPersEmpr(valorDto.getPersEmpr());
						valor.setImplemento(valorDto.getImplemento());
						valor.setTurno(valorDto.getTurno());
						valor.setTrabajador(valorDto.getTrabajador());
						valor.setNivel2ClientesId(valorDto.getNivel2ClientesId());
						valor.setBonificacionTrabajador(valorDto.getBonificacionTrabajador());
						valor.setConceptoNominaId(valorDto.getConceptoNominaId());
						valor.setNivel4ClientesId(valorDto.getNivel4ClientesId());
						valor.setEstadoFactura(valorDto.getEstadoFactura());
						valor.setAlmacenId(valorDto.getAlmacenId());
						valor.setProductoId(valorDto.getProductoId());
						valor.setCantidadCombustible(valorDto.getCantidadCombustible());
						valor.setCostoCombustible(valorDto.getCostoCombustible());
						valor.setSello(valorDto.getSello());
						valor.setAuxilioTransporte(valorDto.getAuxilioTransporte());
						valor.setDat_plan_servicios_mqdet_id(valorDto.getDat_plan_servicios_mqdet_id());
					
						
						valor.setValor_total_trabajador(valorDto.getValor_total_trabajador());
						valor.setValor_unitario_trabajador(valorDto.getValor_unitario_trabajador());
						
						valor.setObservacion(valorDto.getObservacion());
						valor.setReportarNovedadParada(valorDto.getReportarNovedadParada());
						valor.setCantidadTrabajador(valorDto.getCantidadTrabajador());
						
						valor.setUnidadMedidaTrabajador(valorDto.getUnidadMedidaTrabajador());
						valor.setUsuarioDigitacion(entity.getUsuarioDigitacion());
						valor.setTipoMttoTexto(valorDto.getTipoMttoTexto());
						valor.setHorometroMtto(valorDto.getHorometroMtto());
						valor.setDatServRealizadosEquipoId(entity);

						datServRealizadosEquipoDetDAO.save(valor);
					}

				}
			}

			if (dataDetPrecioProductos != null) {

				for (PrecioPromProdDTO valorDto : dataDetPrecioProductos) {

					if (valorDto.getPrecioProdId() == null) {

						PrecioPromProd valor = new PrecioPromProd();

						valor.setFechaInicial(valorDto.getFechaInicial());
						valor.setFechaVencimiento(valorDto.getFechaVencimiento());
						valor.setCantidadCompra(valorDto.getCantidadCompra());
						valor.setUnidadMedida(valorDto.getUnidadMedida());
						valor.setLoteCompraProducto(valorDto.getLoteCompraProducto());
						valor.setRegistroIca(valorDto.getRegistroIca());
						valor.setAlmacenId(valorDto.getAlmacenId());
						valor.setValorUnitario(valorDto.getValorUnitario());
						valor.setCompania(valorDto.getCompania());
						valor.setFechaCreacion(valorDto.getFechaCreacion());
						valor.setFechaModificacion(valorDto.getFechaModificacion());
						valor.setPersEmpr(valorDto.getPersEmprId_PersEmpr());
						valor.setConceptoKardexId(valorDto.getConceptoKardexId());
						valor.setTipoMovimiento(valorDto.getTipoMovimiento());
						valor.setNumFacturaCompra(valorDto.getNumFacturaCompra());
						valor.setCostoTotal(valorDto.getCostoTotal());
						valor.setEquipoId(valorDto.getEquipoId());
						valor.setProducto(valorDto.getProducto());
						//valor.setConceptoGastoId(163L);
						valor.setHorometro_abastecimiento(valorDto.getHorometro_abastecimiento());
						valor.setInfoAdicional(valorDto.getInfoAdicional());
						valor.setDatServRealizadosEquipoId(entity);
						valor.setUsuarioDigitacion(entity.getUsuarioDigitacion());
						valor.setIndicador_vuelta_medidor(valorDto.getIndicador_vuelta_medidor());
						valor.setCentCostId(valorDto.getCentCostId());	
						
						
						
						if(valorDto.getCantidadCompra()>0) {
							precioPromProdDAO.save(valor);
						}
						
					}

				}
			}

            log.debug("save DatServRealizadosEquipo successful");
        } catch (Exception e) {
            log.error("save DatServRealizadosEquipo failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteDatServRealizadosEquipo(DatServRealizadosEquipo entity)
        throws Exception {
        log.debug("deleting DatServRealizadosEquipo instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion(
                "DatServRealizadosEquipo");
        }

        if (entity.getDatServRealizadosEquipoId() == null) {
            throw new ZMessManager().new EmptyFieldException(
                "datServRealizadosEquipoId");
        }
        List<DatServRealizadosEquipoDet> dataServDets = null;

        try {
            
        	dataServDets = datServRealizadosEquipoDetDAO.findByProperty(
					"datServRealizadosEquipo.datServRealizadosEquipoId", entity.getDatServRealizadosEquipoId());

			if (Utilities.validationsList(dataServDets) == true) {
				throw new ZMessManager().new DeletingException(
						"dataServDets");
			}
			
        	datServRealizadosEquipoDAO.delete(entity);
            
            log.debug("delete DatServRealizadosEquipo successful");
        } catch (Exception e) {
            log.error("delete DatServRealizadosEquipo failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateDatServRealizadosEquipo(DatServRealizadosEquipo entity, List<DatServRealizadosEquipoDetDTO> dataServDet,
   		 List<PrecioPromProdDTO> dataDetPrecioProductos)
        throws Exception {
        log.debug("updating DatServRealizadosEquipo instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "DatServRealizadosEquipo");
            }


            if (entity.getEquipo() == null) {
                throw new ZMessManager().new ForeignException("equipo");
            }


            if ((entity.getEstado() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
                throw new ZMessManager().new NotValidFormatException("estado");
            }

            if ((entity.getObservacion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getObservacion(), 3000) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "observacion");
            }

            if ((entity.getObservacionAnularReg() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getObservacionAnularReg(), 500) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "observacionAnularReg");
            }

            if ((entity.getOrigenDatos() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getOrigenDatos(), 30) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "origenDatos");
            }

            if ((entity.getSerieFactura() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getSerieFactura(), 60) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "serieFactura");
            }


            if (entity.getEquipo().getEquipoId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "equipoId_Equipo");
            }


            datServRealizadosEquipoDAO.update(entity);


			if (dataServDet != null) {

				for (DatServRealizadosEquipoDetDTO valorDto : dataServDet) {

					if (valorDto.getDatServRealizadosEquipoDetId() == null) {

						DatServRealizadosEquipoDet valor = new DatServRealizadosEquipoDet();

						valor.setLabor(valorDto.getLaborId_Labor());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());
						valor.setHoraFinal(valorDto.getHoraFinal());
						valor.setHoraInicial(valorDto.getHoraInicial());
						valor.setHorometroInicial(valorDto.getHorometroInicial());
						valor.setHorometroFinal(valorDto.getHorometroFinal());
						if(valorDto.getHorometroInicial()!=null && valorDto.getHorometroFinal()!=null ) {
							valor.setHorasTotal(valorDto.getHorometroFinal() - valorDto.getHorometroInicial());
							valor.setHorometroTotal(valorDto.getHorometroFinal() - valorDto.getHorometroInicial());
						}else {
							valor.setHorasTotal(valorDto.getHorasTotal());
							valor.setHorometroTotal(valorDto.getHorometroTotal());
						}
						
						
						valor.setCantidad(valorDto.getCantidad());
						valor.setIngresoTotal(valorDto.getIngresoTotal());
						valor.setValorUnitario(valorDto.getValorUnitario());
						
						valor.setNivel2Id(valorDto.getNivel2());
						valor.setNivel4(valorDto.getNivel4());

						valor.setConceptoNominaId(valorDto.getConceptoNominaId());
						valor.setNombreNivel4(valorDto.getNombreNivel4());
						valor.setPersEmpr(valorDto.getPersEmpr());
						valor.setImplemento(valorDto.getImplemento());
						valor.setTrabajador(valorDto.getTrabajador());
						valor.setNivel2ClientesId(valorDto.getNivel2ClientesId());
						valor.setTurno(valorDto.getTurno());
						valor.setBonificacionTrabajador(valorDto.getBonificacionTrabajador());
						valor.setNivel4ClientesId(valorDto.getNivel4ClientesId());
						valor.setEstadoFactura(valorDto.getEstadoFactura());
						valor.setAlmacenId(valorDto.getAlmacenId());
						valor.setProductoId(valorDto.getProductoId());
						valor.setCantidadCombustible(valorDto.getCantidadCombustible());
						valor.setCostoCombustible(valorDto.getCostoCombustible());
						valor.setSello(valorDto.getSello());
						valor.setAuxilioTransporte(valorDto.getAuxilioTransporte());
						valor.setDat_plan_servicios_mqdet_id(valorDto.getDat_plan_servicios_mqdet_id());
						valor.setValor_total_trabajador(valorDto.getValor_total_trabajador());
						valor.setValor_unitario_trabajador(valorDto.getValor_unitario_trabajador());
						valor.setObservacion(valorDto.getObservacion());

						valor.setReportarNovedadParada(valorDto.getReportarNovedadParada());
						valor.setCantidadTrabajador(valorDto.getCantidadTrabajador());
							
						valor.setUnidadMedidaTrabajador(valorDto.getUnidadMedidaTrabajador());
						valor.setUsuarioDigitacion(entity.getUsuarioDigitacion());
						valor.setTipoMttoTexto(valorDto.getTipoMttoTexto());
						valor.setHorometroMtto(valorDto.getHorometroMtto());
						valor.setDatServRealizadosEquipoId(entity);
						

						datServRealizadosEquipoDetDAO.save(valor);
						
					} else  {
						
						DatServRealizadosEquipoDet valor = datServRealizadosEquipoDetDAO
								.findById(valorDto.getDatServRealizadosEquipoDetId());


						valor.setLabor(valorDto.getLaborId_Labor());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());
						valor.setHoraFinal(valorDto.getHoraFinal());
						valor.setHoraInicial(valorDto.getHoraInicial());
						valor.setHorometroInicial(valorDto.getHorometroInicial());
						valor.setHorometroFinal(valorDto.getHorometroFinal());
						if(valorDto.getHorometroInicial()!=null && valorDto.getHorometroFinal()!=null ) {
							valor.setHorasTotal(valorDto.getHorometroFinal() - valorDto.getHorometroInicial());
							valor.setHorometroTotal(valorDto.getHorometroFinal() - valorDto.getHorometroInicial());
						}else {
							valor.setHorasTotal(valorDto.getHorasTotal());
							valor.setHorometroTotal(valorDto.getHorometroTotal());
						}
						
						valor.setCantidad(valorDto.getCantidad());
						valor.setIngresoTotal(valorDto.getIngresoTotal());
						valor.setValorUnitario(valorDto.getValorUnitario());
						
						valor.setNivel2Id(valorDto.getNivel2());
						valor.setNivel4(valorDto.getNivel4());

						valor.setConceptoNominaId(valorDto.getConceptoNominaId());
						valor.setNombreNivel4(valorDto.getNombreNivel4());
						valor.setPersEmpr(valorDto.getPersEmpr());
						valor.setImplemento(valorDto.getImplemento());
						valor.setTrabajador(valorDto.getTrabajador());
						valor.setNivel2ClientesId(valorDto.getNivel2ClientesId());
						valor.setTurno(valorDto.getTurno());	
						valor.setBonificacionTrabajador(valorDto.getBonificacionTrabajador());
						valor.setNivel4ClientesId(valorDto.getNivel4ClientesId());
						valor.setEstadoFactura(valorDto.getEstadoFactura());
						valor.setAlmacenId(valorDto.getAlmacenId());
						valor.setProductoId(valorDto.getProductoId());
						valor.setCantidadCombustible(valorDto.getCantidadCombustible());
						valor.setCostoCombustible(valorDto.getCostoCombustible());
						valor.setSello(valorDto.getSello());
						valor.setAuxilioTransporte(valorDto.getAuxilioTransporte());
						valor.setDat_plan_servicios_mqdet_id(valorDto.getDat_plan_servicios_mqdet_id());
						valor.setValor_total_trabajador(valorDto.getValor_total_trabajador());
						valor.setValor_unitario_trabajador(valorDto.getValor_unitario_trabajador());
						valor.setObservacion(valorDto.getObservacion());

						valor.setReportarNovedadParada(valorDto.getReportarNovedadParada());
						valor.setCantidadTrabajador(valorDto.getCantidadTrabajador());
						valor.setUnidadMedidaTrabajador(valorDto.getUnidadMedidaTrabajador());
						valor.setUsuarioDigitacion(entity.getUsuarioDigitacion());
						valor.setTipoMttoTexto(valorDto.getTipoMttoTexto());
						valor.setHorometroMtto(valorDto.getHorometroMtto());
						valor.setDatServRealizadosEquipoId(entity);
						datServRealizadosEquipoDetDAO.update(valor);
					}


				}
			}

			if (dataDetPrecioProductos != null) {

				for (PrecioPromProdDTO valorDto : dataDetPrecioProductos) {

					if (valorDto.getPrecioProdId() == null) {

						PrecioPromProd valor = new PrecioPromProd();

						valor.setFechaInicial(valorDto.getFechaInicial());
						valor.setFechaVencimiento(valorDto.getFechaVencimiento());
						valor.setCantidadCompra(valorDto.getCantidadCompra());
						valor.setUnidadMedida(valorDto.getUnidadMedida());
						valor.setLoteCompraProducto(valorDto.getLoteCompraProducto());
						valor.setRegistroIca(valorDto.getRegistroIca());
						valor.setAlmacenId(valorDto.getAlmacenId());
						valor.setValorUnitario(valorDto.getValorUnitario());
						valor.setCompania(valorDto.getCompania());
						valor.setFechaCreacion(valorDto.getFechaCreacion());
						valor.setFechaModificacion(valorDto.getFechaModificacion());
						valor.setPersEmpr(valorDto.getPersEmprId_PersEmpr());
						valor.setConceptoKardexId(valorDto.getConceptoKardexId());
						valor.setTipoMovimiento(valorDto.getTipoMovimiento());
						valor.setNumFacturaCompra(valorDto.getNumFacturaCompra());
						valor.setCostoTotal(valorDto.getCostoTotal());
						valor.setEquipoId(valorDto.getEquipoId());
						valor.setProducto(valorDto.getProducto());
						//valor.setConceptoGastoId(163L);
						valor.setHorometro_abastecimiento(valorDto.getHorometro_abastecimiento());
						valor.setInfoAdicional(valorDto.getInfoAdicional());
						valor.setIndicador_vuelta_medidor(valorDto.getIndicador_vuelta_medidor());
						valor.setDatServRealizadosEquipoId(entity);
						valor.setCentCostId(valorDto.getCentCostId());	
						
						if(valorDto.getCantidadCompra()>0) {
							precioPromProdDAO.save(valor);
						}
						
					} else {
						PrecioPromProd valor = precioPromProdDAO.findById(valorDto.getPrecioProdId());

						valor.setFechaInicial(valorDto.getFechaInicial());
						valor.setFechaVencimiento(valorDto.getFechaVencimiento());
						valor.setCantidadCompra(valorDto.getCantidadCompra());
						valor.setUnidadMedida(valorDto.getUnidadMedida());
						valor.setLoteCompraProducto(valorDto.getLoteCompraProducto());
						valor.setRegistroIca(valorDto.getRegistroIca());
						valor.setAlmacenId(valorDto.getAlmacenId());
						valor.setValorUnitario(valorDto.getValorUnitario());
						valor.setCompania(valorDto.getCompania());
						valor.setFechaCreacion(valorDto.getFechaCreacion());
						valor.setFechaModificacion(valorDto.getFechaModificacion());
						valor.setPersEmpr(valorDto.getPersEmprId_PersEmpr());
						valor.setConceptoKardexId(valorDto.getConceptoKardexId());
						valor.setTipoMovimiento(valorDto.getTipoMovimiento());
						valor.setNumFacturaCompra(valorDto.getNumFacturaCompra());
						valor.setCostoTotal(valorDto.getCostoTotal());
						valor.setEquipoId(valorDto.getEquipoId());
						valor.setProducto(valorDto.getProducto());
						//valor.setConceptoGastoId(163L);
						valor.setHorometro_abastecimiento(valorDto.getHorometro_abastecimiento());
						valor.setInfoAdicional(valorDto.getInfoAdicional());
						valor.setIndicador_vuelta_medidor(valorDto.getIndicador_vuelta_medidor());
						valor.setDatServRealizadosEquipoId(entity);
					
						valor.setCentCostId(valorDto.getCentCostId());	
						if(valorDto.getCantidadCompra()>0) {
							precioPromProdDAO.update(valor);
						}
						
						
					}

				}
			}

            log.debug("update DatServRealizadosEquipo successful");
        } catch (Exception e) {
            log.error("update DatServRealizadosEquipo failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<DatServRealizadosEquipoDTO> getDataDatServRealizadosEquipo()
        throws Exception {
        try {
            List<DatServRealizadosEquipo> datServRealizadosEquipo = datServRealizadosEquipoDAO.findAll();

            List<DatServRealizadosEquipoDTO> datServRealizadosEquipoDTO = new ArrayList<DatServRealizadosEquipoDTO>();

            for (DatServRealizadosEquipo datServRealizadosEquipoTmp : datServRealizadosEquipo) {
                DatServRealizadosEquipoDTO datServRealizadosEquipoDTO2 = new DatServRealizadosEquipoDTO();

                datServRealizadosEquipoDTO2.setDatServRealizadosEquipoId(datServRealizadosEquipoTmp.getDatServRealizadosEquipoId());
                datServRealizadosEquipoDTO2.setCompania((datServRealizadosEquipoTmp.getCompania() != null)
                    ? datServRealizadosEquipoTmp.getCompania() : null);
                datServRealizadosEquipoDTO2.setConsecutivo((datServRealizadosEquipoTmp.getConsecutivo() != null)
                    ? datServRealizadosEquipoTmp.getConsecutivo() : null);
                datServRealizadosEquipoDTO2.setEstado((datServRealizadosEquipoTmp.getEstado() != null)
                    ? datServRealizadosEquipoTmp.getEstado() : null);
                datServRealizadosEquipoDTO2.setFechaAnulacion(datServRealizadosEquipoTmp.getFechaAnulacion());
                datServRealizadosEquipoDTO2.setFechaCreacion(datServRealizadosEquipoTmp.getFechaCreacion());
                datServRealizadosEquipoDTO2.setFechaModificacion(datServRealizadosEquipoTmp.getFechaModificacion());
                datServRealizadosEquipoDTO2.setFechaRegistro(datServRealizadosEquipoTmp.getFechaRegistro());
                datServRealizadosEquipoDTO2.setNumFactura((datServRealizadosEquipoTmp.getNumFactura() != null)
                    ? datServRealizadosEquipoTmp.getNumFactura() : null);
                datServRealizadosEquipoDTO2.setObservacion((datServRealizadosEquipoTmp.getObservacion() != null)
                    ? datServRealizadosEquipoTmp.getObservacion() : null);
                datServRealizadosEquipoDTO2.setObservacionAnularReg((datServRealizadosEquipoTmp.getObservacionAnularReg() != null)
                    ? datServRealizadosEquipoTmp.getObservacionAnularReg() : null);
                datServRealizadosEquipoDTO2.setOrigenDatos((datServRealizadosEquipoTmp.getOrigenDatos() != null)
                    ? datServRealizadosEquipoTmp.getOrigenDatos() : null);
                datServRealizadosEquipoDTO2.setSerieFactura((datServRealizadosEquipoTmp.getSerieFactura() != null)
                    ? datServRealizadosEquipoTmp.getSerieFactura() : null);
                datServRealizadosEquipoDTO2.setUsuarioDigitacion((datServRealizadosEquipoTmp.getUsuarioDigitacion() != null)
                    ? datServRealizadosEquipoTmp.getUsuarioDigitacion() : null);
                
                
                datServRealizadosEquipoDTO2.setCostoCombustible((datServRealizadosEquipoTmp.getCostoCombustible() != null)
                        ? datServRealizadosEquipoTmp.getCostoCombustible() : null);
                    
                datServRealizadosEquipoDTO2.setIndicador_vuelta_medidor((datServRealizadosEquipoTmp.getIndicador_vuelta_medidor() != null)
                        ? datServRealizadosEquipoTmp.getIndicador_vuelta_medidor() : null);
                    
                    
                
                
                if (datServRealizadosEquipoTmp.getCentCost() != null) {
                    datServRealizadosEquipoDTO2.setCentCostId_CentCost(datServRealizadosEquipoTmp.getCentCost().getCentCostId());
                } else {
                    datServRealizadosEquipoDTO2.setCentCostId_CentCost(null);
                }
                
                if (datServRealizadosEquipoTmp.getElementoCosto() != null) {
                    datServRealizadosEquipoDTO2.setElemCostoId_ElementoCosto(datServRealizadosEquipoTmp.getElementoCosto()
                            .getElemCostoId());
                } else {
                    datServRealizadosEquipoDTO2.setElemCostoId_ElementoCosto(null);
                }


                if (datServRealizadosEquipoTmp.getEquipo() != null) {
                    datServRealizadosEquipoDTO2.setEquipoId_Equipo(datServRealizadosEquipoTmp.getEquipo()
                                                                                             .getEquipoId());
                } else {
                    datServRealizadosEquipoDTO2.setEquipoId_Equipo(null);
                }

                if (datServRealizadosEquipoTmp.getEquipo() != null) {
                    datServRealizadosEquipoDTO2.setEquipoId_Equipo(datServRealizadosEquipoTmp.getEquipo()
                                                                                             .getEquipoId());
                } else {
                    datServRealizadosEquipoDTO2.setEquipoId_Equipo(null);
                }

                if (datServRealizadosEquipoTmp.getEquipo() != null) {
                    datServRealizadosEquipoDTO2.setNombreEquipo(datServRealizadosEquipoTmp.getEquipo()
                                                                                             .getNombre());
                } else {
                    datServRealizadosEquipoDTO2.setNombreEquipo(null);
                }


                if (datServRealizadosEquipoTmp.getPersEmpr() != null) {
                    datServRealizadosEquipoDTO2.setPersEmprId_PersEmpr(datServRealizadosEquipoTmp.getPersEmpr()
                            .getPersEmprId());
                } else {
                    datServRealizadosEquipoDTO2.setPersEmprId_PersEmpr(null);
                }
               
                
                datServRealizadosEquipoDTO2.setCantidadCombustible((datServRealizadosEquipoTmp.getCantidadCombustible() != null)
                        ? datServRealizadosEquipoTmp.getCantidadCombustible() : null);

                datServRealizadosEquipoDTO2.setSello((datServRealizadosEquipoTmp.getSello() != null)
                        ? datServRealizadosEquipoTmp.getSello() : null);
                
                if (datServRealizadosEquipoTmp.getProductoId() != null) {
                    datServRealizadosEquipoDTO2.setProductoId(datServRealizadosEquipoTmp.getProductoId().getProductoId()
                                                                                                 );
                } else {
                    datServRealizadosEquipoDTO2.setProductoId(null);
                }
                

                if (datServRealizadosEquipoTmp.getPuedeEditarPin() != null) {
                    datServRealizadosEquipoDTO2.setPuedeEditarPin(datServRealizadosEquipoTmp.getPuedeEditarPin()
                                                                                                 );
                } else {
                    datServRealizadosEquipoDTO2.setPuedeEditarPin(null);
                }
                
                datServRealizadosEquipoDTO2.setDobleTanqueo((datServRealizadosEquipoTmp.getDobleTanqueo() != null)
                        ? datServRealizadosEquipoTmp.getDobleTanqueo() : null);
                    
           
                
                
				String estadoEstrue = "false";
				if (datServRealizadosEquipoTmp.getEstado().equals("I")) {
					estadoEstrue = "true";
					datServRealizadosEquipoDTO2.setEstadoTrue(estadoEstrue);
				}
				
				if(datServRealizadosEquipoTmp.getPuedeEditarPin() != null) {
					if (datServRealizadosEquipoTmp.getEstado().equals("A") &&   datServRealizadosEquipoTmp.getPuedeEditarPin().equals("No")) {
						estadoEstrue = "true";
						datServRealizadosEquipoDTO2.setEstadoTrue(estadoEstrue);
					}
					if (datServRealizadosEquipoTmp.getEstado().equals("A") &&   datServRealizadosEquipoTmp.getPuedeEditarPin().equals("Si")) {
						estadoEstrue = "false";
						datServRealizadosEquipoDTO2.setEstadoTrue(estadoEstrue);
					}
				}else {
					estadoEstrue = "true";
				}
				
				datServRealizadosEquipoDTO2.setEstadoTrue(estadoEstrue);

                datServRealizadosEquipoDTO.add(datServRealizadosEquipoDTO2);
            }

            return datServRealizadosEquipoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public DatServRealizadosEquipo getDatServRealizadosEquipo(
        Long datServRealizadosEquipoId) throws Exception {
        log.debug("getting DatServRealizadosEquipo instance");

        DatServRealizadosEquipo entity = null;

        try {
            entity = datServRealizadosEquipoDAO.findById(datServRealizadosEquipoId);
        } catch (Exception e) {
            log.error("get DatServRealizadosEquipo failed", e);
            throw new ZMessManager().new FindingException(
                "DatServRealizadosEquipo");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<DatServRealizadosEquipo> findPageDatServRealizadosEquipo(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        List<DatServRealizadosEquipo> entity = null;

        try {
            entity = datServRealizadosEquipoDAO.findPage(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatServRealizadosEquipo Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberDatServRealizadosEquipo()
        throws Exception {
        Long entity = null;

        try {
            entity = datServRealizadosEquipoDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatServRealizadosEquipo Count");
        } finally {
        }

        return entity;
    }

    /**
    *
    * @param varibles
    *            este arreglo debera tener:
    *
    * [0] = String variable = (String) varibles[i]; representa como se llama la
    * variable en el pojo
    *
    * [1] = Boolean booVariable = (Boolean) varibles[i + 1]; representa si el
    * valor necesita o no ''(comillas simples)usado para campos de tipo string
    *
    * [2] = Object value = varibles[i + 2]; representa el valor que se va a
    * buscar en la BD
    *
    * [3] = String comparator = (String) varibles[i + 3]; representa que tipo
    * de busqueda voy a hacer.., ejemplo: where nombre=william o where nombre<>william,
        * en este campo iria el tipo de comparador que quiero si es = o <>
            *
            * Se itera de 4 en 4..., entonces 4 registros del arreglo representan 1
            * busqueda en un campo, si se ponen mas pues el continuara buscando en lo
            * que se le ingresen en los otros 4
            *
            *
            * @param variablesBetween
            *
            * la diferencia son estas dos posiciones
            *
            * [0] = String variable = (String) varibles[j]; la variable ne la BD que va
            * a ser buscada en un rango
            *
            * [1] = Object value = varibles[j + 1]; valor 1 para buscar en un rango
            *
            * [2] = Object value2 = varibles[j + 2]; valor 2 para buscar en un rango
            * ejempolo: a > 1 and a < 5 --> 1 seria value y 5 seria value2
                *
                * [3] = String comparator1 = (String) varibles[j + 3]; comparador 1
                * ejemplo: a comparator1 1 and a < 5
                    *
                    * [4] = String comparator2 = (String) varibles[j + 4]; comparador 2
                    * ejemplo: a comparador1>1  and a comparador2<5  (el original: a > 1 and a <
                            * 5) *
                            * @param variablesBetweenDates(en
                            *            este caso solo para mysql)
                            *  [0] = String variable = (String) varibles[k]; el nombre de la variable que hace referencia a
                            *            una fecha
                            *
                            * [1] = Object object1 = varibles[k + 2]; fecha 1 a comparar(deben ser
                            * dates)
                            *
                            * [2] = Object object2 = varibles[k + 3]; fecha 2 a comparar(deben ser
                            * dates)
                            *
                            * esto hace un between entre las dos fechas.
                            *
                            * @return lista con los objetos que se necesiten
                            * @throws Exception
                            */
    @Transactional(readOnly = true)
    public List<DatServRealizadosEquipo> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<DatServRealizadosEquipo> list = new ArrayList<DatServRealizadosEquipo>();
        String where = new String();
        String tempWhere = new String();

        if (variables != null) {
            for (int i = 0; i < variables.length; i++) {
                if ((variables[i] != null) && (variables[i + 1] != null) &&
                        (variables[i + 2] != null) &&
                        (variables[i + 3] != null)) {
                    String variable = (String) variables[i];
                    Boolean booVariable = (Boolean) variables[i + 1];
                    Object value = variables[i + 2];
                    String comparator = (String) variables[i + 3];

                    if (booVariable.booleanValue()) {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " \'" +
                            value + "\' )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " \'" + value + "\' )");
                    } else {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " " +
                            value + " )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " " + value + " )");
                    }
                }

                i = i + 3;
            }
        }

        if (variablesBetween != null) {
            for (int j = 0; j < variablesBetween.length; j++) {
                if ((variablesBetween[j] != null) &&
                        (variablesBetween[j + 1] != null) &&
                        (variablesBetween[j + 2] != null) &&
                        (variablesBetween[j + 3] != null) &&
                        (variablesBetween[j + 4] != null)) {
                    String variable = (String) variablesBetween[j];
                    Object value = variablesBetween[j + 1];
                    Object value2 = variablesBetween[j + 2];
                    String comparator1 = (String) variablesBetween[j + 3];
                    String comparator2 = (String) variablesBetween[j + 4];
                    tempWhere = (tempWhere.length() == 0)
                        ? ("(" + value + " " + comparator1 + " " + variable +
                        " and " + variable + " " + comparator2 + " " + value2 +
                        " )")
                        : (tempWhere + " AND (" + value + " " + comparator1 +
                        " " + variable + " and " + variable + " " +
                        comparator2 + " " + value2 + " )");
                }

                j = j + 4;
            }
        }

        if (variablesBetweenDates != null) {
            for (int k = 0; k < variablesBetweenDates.length; k++) {
                if ((variablesBetweenDates[k] != null) &&
                        (variablesBetweenDates[k + 1] != null) &&
                        (variablesBetweenDates[k + 2] != null)) {
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
                        ? ("(model." + variable + " between \'" + value +
                        "\' and \'" + value2 + "\')")
                        : (tempWhere + " AND (model." + variable +
                        " between \'" + value + "\' and \'" + value2 + "\')");
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
            list = datServRealizadosEquipoDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
