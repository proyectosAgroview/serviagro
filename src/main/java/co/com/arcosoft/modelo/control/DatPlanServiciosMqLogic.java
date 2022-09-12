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

import co.com.arcosoft.dataaccess.dao.IDatPlanServiciosMqDAO;
import co.com.arcosoft.dataaccess.dao.IDatPlanServiciosMqdetDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatPlanServiciosMq;
import co.com.arcosoft.modelo.DatPlanServiciosMqdet;
import co.com.arcosoft.modelo.dto.DatPlanServiciosMqDTO;
import co.com.arcosoft.modelo.dto.DatPlanServiciosMqdetDTO;
import co.com.arcosoft.utilities.Utilities;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("DatPlanServiciosMqLogic")
public class DatPlanServiciosMqLogic implements IDatPlanServiciosMqLogic {
    private static final Logger log = LoggerFactory.getLogger(DatPlanServiciosMqLogic.class);

    /**
     * DAO injected by Spring that manages DatPlanServiciosMq entities
     *
     */
    @Autowired
    private IDatPlanServiciosMqDAO datPlanServiciosMqDAO;

    /**
    * DAO injected by Spring that manages DatPlanServiciosMqdet entities
    *
    */
    @Autowired
    private IDatPlanServiciosMqdetDAO datPlanServiciosMqdetDAO;

    /**
    * Logic injected by Spring that manages Trabajador entities
    *
    */
    @Autowired
    ITrabajadorLogic logicTrabajador1;

    /**
    * Logic injected by Spring that manages ZonaGeografica entities
    *
    */
    @Autowired
    IZonaGeograficaLogic logicZonaGeografica2;

    @Transactional(readOnly = true)
    public List<DatPlanServiciosMq> getDatPlanServiciosMq()
        throws Exception {
        log.debug("finding all DatPlanServiciosMq instances");

        List<DatPlanServiciosMq> list = new ArrayList<DatPlanServiciosMq>();

        try {
            list = datPlanServiciosMqDAO.findAll();
        } catch (Exception e) {
            log.error("finding all DatPlanServiciosMq failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "DatPlanServiciosMq");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveDatPlanServiciosMq(DatPlanServiciosMq entity, List<DatPlanServiciosMqdetDTO> dataPlanServDet)
        throws Exception {
        log.debug("saving DatPlanServiciosMq instance");

        try {
            if (entity.getTrabajador() == null) {
                throw new ZMessManager().new ForeignException("trabajador");
            }

            if (entity.getZonaGeografica() == null) {
                throw new ZMessManager().new ForeignException("zonaGeografica");
            }

            if ((entity.getCierreOt() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getCierreOt(), 1) == false)) {
                throw new ZMessManager().new NotValidFormatException("cierreOt");
            }

            if ((entity.getCostoTotalEstimado() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getCostoTotalEstimado(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "costoTotalEstimado");
            }

            if ((entity.getEstado() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
                throw new ZMessManager().new NotValidFormatException("estado");
            }

            if ((entity.getIdMobile() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getIdMobile(), 30) == false)) {
                throw new ZMessManager().new NotValidFormatException("idMobile");
            }

            if ((entity.getInfoAdicional() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getInfoAdicional(), 100) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "infoAdicional");
            }

            if ((entity.getInfoAdicional2() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getInfoAdicional2(), 100) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "infoAdicional2");
            }

            if ((entity.getLatitud() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getLatitud(), 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException("latitud");
            }

            if ((entity.getLongitud() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getLongitud(), 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException("longitud");
            }

            if ((entity.getNivelAutorizacion1() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getNivelAutorizacion1(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "nivelAutorizacion1");
            }

            if ((entity.getNivelAutorizacion2() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getNivelAutorizacion2(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "nivelAutorizacion2");
            }

            if ((entity.getObservacion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getObservacion(), 1000) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "observacion");
            }

            if ((entity.getObservacionAnularReg() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getObservacionAnularReg(), 500) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "observacionAnularReg");
            }

            if ((entity.getPrecision1() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getPrecision1(), 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "precision1");
            }

            if (entity.getTrabajador().getTrabId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "trabId_Trabajador");
            }

            if (entity.getZonaGeografica().getZonaGeograficaId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "zonaGeograficaId_ZonaGeografica");
            }

          
            datPlanServiciosMqDAO.save(entity);


         
            
        	if (dataPlanServDet != null) {

				for (DatPlanServiciosMqdetDTO valorDto : dataPlanServDet) {

					if (valorDto.getDatPlanServiciosMqdetId() == null) {

						DatPlanServiciosMqdet valor = new DatPlanServiciosMqdet();

						valor.setLabor(valorDto.getLaborId_Labor());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());
						
						valor.setCantidadPlan(valorDto.getCantidadPlan());
						valor.setValorEstTotal(valorDto.getValorEstTotal());
						valor.setValorEstUnitario(valorDto.getValorEstUnitario());
						
						valor.setNivel4mqTexto(valorDto.getNivel4mqTexto());
						valor.setPersEmpr(valorDto.getPersEmprId_PersEmpr());
						valor.setEquipo(valorDto.getEquipoId_Equipo());
						valor.setNivel2Clientesmq(valorDto.getNivel2ClientesmqId_Nivel2Clientesmq());
						valor.setNivel4ClientesmqId(valorDto.getNivel4ClientesmqId());
						
						valor.setConcluido(valorDto.getConcluido());
						valor.setDetalleNota(valorDto.getDetalleNota());
						valor.setFacturado(valorDto.getFacturado());
						valor.setCantidadPendiente(valorDto.getCantidadPendiente());
						valor.setCantidadRealizada(valorDto.getCantidadRealizada());
						
						valor.setOperario(valorDto.getOperario());
						valor.setNumPases(valorDto.getNumPases());
						valor.setPeriodoInicial(valorDto.getPeriodoInicial());
						valor.setAreaProgramada(valorDto.getAreaProgramada());
						valor.setCantidadPresupuesto(valorDto.getCantidadPresupuesto());
						
						valor.setDatPlanServiciosMq(entity);

						datPlanServiciosMqdetDAO.save(valor);
					}

				}
			}
            log.debug("save DatPlanServiciosMq successful");
        } catch (Exception e) {
            log.error("save DatPlanServiciosMq failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteDatPlanServiciosMq(DatPlanServiciosMq entity)
        throws Exception {
        log.debug("deleting DatPlanServiciosMq instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion(
                "DatPlanServiciosMq");
        }

        if (entity.getDatPlanServiciosMqId() == null) {
            throw new ZMessManager().new EmptyFieldException(
                "datPlanServiciosMqId");
        }

        List<DatPlanServiciosMqdet> datPlanServiciosMqdets = null;

        try {
            datPlanServiciosMqdets = datPlanServiciosMqdetDAO.findByProperty("datPlanServiciosMq.datPlanServiciosMqId",
                    entity.getDatPlanServiciosMqId());

            if (Utilities.validationsList(datPlanServiciosMqdets) == true) {
                throw new ZMessManager().new DeletingException(
                    "datPlanServiciosMqdets");
            }

            datPlanServiciosMqDAO.delete(entity);

            log.debug("delete DatPlanServiciosMq successful");
        } catch (Exception e) {
            log.error("delete DatPlanServiciosMq failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateDatPlanServiciosMq(DatPlanServiciosMq entity, List<DatPlanServiciosMqdetDTO> dataPlanServDet)
        throws Exception {
        log.debug("updating DatPlanServiciosMq instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "DatPlanServiciosMq");
            }

            if (entity.getTrabajador() == null) {
                throw new ZMessManager().new ForeignException("trabajador");
            }

            if (entity.getZonaGeografica() == null) {
                throw new ZMessManager().new ForeignException("zonaGeografica");
            }

            if ((entity.getCierreOt() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getCierreOt(), 1) == false)) {
                throw new ZMessManager().new NotValidFormatException("cierreOt");
            }

            if ((entity.getCostoTotalEstimado() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getCostoTotalEstimado(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "costoTotalEstimado");
            }

            if ((entity.getEstado() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
                throw new ZMessManager().new NotValidFormatException("estado");
            }

            if ((entity.getIdMobile() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getIdMobile(), 30) == false)) {
                throw new ZMessManager().new NotValidFormatException("idMobile");
            }

            if ((entity.getInfoAdicional() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getInfoAdicional(), 100) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "infoAdicional");
            }

            if ((entity.getInfoAdicional2() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getInfoAdicional2(), 100) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "infoAdicional2");
            }

            if ((entity.getLatitud() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getLatitud(), 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException("latitud");
            }

            if ((entity.getLongitud() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getLongitud(), 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException("longitud");
            }

            if ((entity.getNivelAutorizacion1() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getNivelAutorizacion1(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "nivelAutorizacion1");
            }

            if ((entity.getNivelAutorizacion2() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getNivelAutorizacion2(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "nivelAutorizacion2");
            }

            if ((entity.getObservacion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getObservacion(), 1000) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "observacion");
            }

            if ((entity.getObservacionAnularReg() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getObservacionAnularReg(), 500) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "observacionAnularReg");
            }

            if ((entity.getPrecision1() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getPrecision1(), 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "precision1");
            }

            if (entity.getTrabajador().getTrabId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "trabId_Trabajador");
            }

            if (entity.getZonaGeografica().getZonaGeograficaId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "zonaGeograficaId_ZonaGeografica");
            }

            datPlanServiciosMqDAO.update(entity);

			if (dataPlanServDet != null) {

				for (DatPlanServiciosMqdetDTO valorDto : dataPlanServDet) {

					if (valorDto.getDatPlanServiciosMqdetId() == null) {

						DatPlanServiciosMqdet valor = new DatPlanServiciosMqdet();

						valor.setLabor(valorDto.getLaborId_Labor());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());
						
						valor.setCantidadPlan(valorDto.getCantidadPlan());
						valor.setValorEstTotal(valorDto.getValorEstTotal());
						valor.setValorEstUnitario(valorDto.getValorEstUnitario());
						
						valor.setNivel4mqTexto(valorDto.getNivel4mqTexto());
						valor.setPersEmpr(valorDto.getPersEmprId_PersEmpr());
						valor.setEquipo(valorDto.getEquipoId_Equipo());
						valor.setNivel2Clientesmq(valorDto.getNivel2ClientesmqId_Nivel2Clientesmq());
						valor.setNivel4ClientesmqId(valorDto.getNivel4ClientesmqId());
						
						valor.setConcluido(valorDto.getConcluido());
						valor.setDetalleNota(valorDto.getDetalleNota());
						valor.setFacturado(valorDto.getFacturado());
						valor.setCantidadPendiente(valorDto.getCantidadPendiente());
						valor.setCantidadRealizada(valorDto.getCantidadRealizada());
						valor.setOperario(valorDto.getOperario());
						valor.setNumPases(valorDto.getNumPases());
						valor.setPeriodoInicial(valorDto.getPeriodoInicial());
						valor.setAreaProgramada(valorDto.getAreaProgramada());
						valor.setCantidadPresupuesto(valorDto.getCantidadPresupuesto());
						valor.setDatPlanServiciosMq(entity);
						

						datPlanServiciosMqdetDAO.save(valor);
						
					} else  {
						
						DatPlanServiciosMqdet valor = datPlanServiciosMqdetDAO
								.findById(valorDto.getDatPlanServiciosMqdetId());

						valor.setLabor(valorDto.getLaborId_Labor());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());
						
						valor.setCantidadPlan(valorDto.getCantidadPlan());
						valor.setValorEstTotal(valorDto.getValorEstTotal());
						valor.setValorEstUnitario(valorDto.getValorEstUnitario());
						
						valor.setNivel4mqTexto(valorDto.getNivel4mqTexto());
						valor.setPersEmpr(valorDto.getPersEmprId_PersEmpr());
						valor.setEquipo(valorDto.getEquipoId_Equipo());
						valor.setNivel2Clientesmq(valorDto.getNivel2ClientesmqId_Nivel2Clientesmq());
						valor.setNivel4ClientesmqId(valorDto.getNivel4ClientesmqId());
						valor.setConcluido(valorDto.getConcluido());
						valor.setDetalleNota(valorDto.getDetalleNota());
						
						valor.setFacturado(valorDto.getFacturado());
						valor.setCantidadPendiente(valorDto.getCantidadPendiente());
						valor.setCantidadRealizada(valorDto.getCantidadRealizada());
						valor.setOperario(valorDto.getOperario());
						valor.setNumPases(valorDto.getNumPases());
						valor.setPeriodoInicial(valorDto.getPeriodoInicial());
						valor.setAreaProgramada(valorDto.getAreaProgramada());
						valor.setCantidadPresupuesto(valorDto.getCantidadPresupuesto());
						valor.setDatPlanServiciosMq(entity);
						

						datPlanServiciosMqdetDAO.update(valor);

					}


				}
			}

            log.debug("update DatPlanServiciosMq successful");
        } catch (Exception e) {
            log.error("update DatPlanServiciosMq failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<DatPlanServiciosMqDTO> getDataDatPlanServiciosMq()
        throws Exception {
        try {
            List<DatPlanServiciosMq> datPlanServiciosMq = datPlanServiciosMqDAO.findAll();

            List<DatPlanServiciosMqDTO> datPlanServiciosMqDTO = new ArrayList<DatPlanServiciosMqDTO>();

            for (DatPlanServiciosMq datPlanServiciosMqTmp : datPlanServiciosMq) {
                DatPlanServiciosMqDTO datPlanServiciosMqDTO2 = new DatPlanServiciosMqDTO();

                datPlanServiciosMqDTO2.setDatPlanServiciosMqId(datPlanServiciosMqTmp.getDatPlanServiciosMqId());
                datPlanServiciosMqDTO2.setNPases((datPlanServiciosMqTmp.getNPases() != null)
                    ? datPlanServiciosMqTmp.getNPases() : null);
                datPlanServiciosMqDTO2.setAnio((datPlanServiciosMqTmp.getAnio() != null)
                    ? datPlanServiciosMqTmp.getAnio() : null);
                datPlanServiciosMqDTO2.setCierreOt((datPlanServiciosMqTmp.getCierreOt() != null)
                    ? datPlanServiciosMqTmp.getCierreOt() : null);
                datPlanServiciosMqDTO2.setCompania((datPlanServiciosMqTmp.getCompania() != null)
                    ? datPlanServiciosMqTmp.getCompania() : null);
                datPlanServiciosMqDTO2.setConsecutivo((datPlanServiciosMqTmp.getConsecutivo() != null)
                    ? datPlanServiciosMqTmp.getConsecutivo() : null);
                datPlanServiciosMqDTO2.setCostoTotalEstimado((datPlanServiciosMqTmp.getCostoTotalEstimado() != null)
                    ? datPlanServiciosMqTmp.getCostoTotalEstimado() : null);
                datPlanServiciosMqDTO2.setEstado((datPlanServiciosMqTmp.getEstado() != null)
                    ? datPlanServiciosMqTmp.getEstado() : null);
                datPlanServiciosMqDTO2.setFechaAnulacion(datPlanServiciosMqTmp.getFechaAnulacion());
                datPlanServiciosMqDTO2.setFechaCierreOt(datPlanServiciosMqTmp.getFechaCierreOt());
                datPlanServiciosMqDTO2.setFechaCreacion(datPlanServiciosMqTmp.getFechaCreacion());
                datPlanServiciosMqDTO2.setFechaModificacion(datPlanServiciosMqTmp.getFechaModificacion());
                datPlanServiciosMqDTO2.setFechaReaperturaOt(datPlanServiciosMqTmp.getFechaReaperturaOt());
                datPlanServiciosMqDTO2.setIdMobile((datPlanServiciosMqTmp.getIdMobile() != null)
                    ? datPlanServiciosMqTmp.getIdMobile() : null);
                datPlanServiciosMqDTO2.setInfoAdicional((datPlanServiciosMqTmp.getInfoAdicional() != null)
                    ? datPlanServiciosMqTmp.getInfoAdicional() : null);
                datPlanServiciosMqDTO2.setInfoAdicional2((datPlanServiciosMqTmp.getInfoAdicional2() != null)
                    ? datPlanServiciosMqTmp.getInfoAdicional2() : null);
                datPlanServiciosMqDTO2.setLatitud((datPlanServiciosMqTmp.getLatitud() != null)
                    ? datPlanServiciosMqTmp.getLatitud() : null);
                datPlanServiciosMqDTO2.setLongitud((datPlanServiciosMqTmp.getLongitud() != null)
                    ? datPlanServiciosMqTmp.getLongitud() : null);
                datPlanServiciosMqDTO2.setNivelAutorizacion1((datPlanServiciosMqTmp.getNivelAutorizacion1() != null)
                    ? datPlanServiciosMqTmp.getNivelAutorizacion1() : null);
                datPlanServiciosMqDTO2.setNivelAutorizacion2((datPlanServiciosMqTmp.getNivelAutorizacion2() != null)
                    ? datPlanServiciosMqTmp.getNivelAutorizacion2() : null);
                datPlanServiciosMqDTO2.setObservacion((datPlanServiciosMqTmp.getObservacion() != null)
                    ? datPlanServiciosMqTmp.getObservacion() : null);
                datPlanServiciosMqDTO2.setObservacionAnularReg((datPlanServiciosMqTmp.getObservacionAnularReg() != null)
                    ? datPlanServiciosMqTmp.getObservacionAnularReg() : null);
                datPlanServiciosMqDTO2.setPeriodoFinal(datPlanServiciosMqTmp.getPeriodoFinal());
                datPlanServiciosMqDTO2.setPeriodoInicial(datPlanServiciosMqTmp.getPeriodoInicial());
                datPlanServiciosMqDTO2.setPrecision1((datPlanServiciosMqTmp.getPrecision1() != null)
                    ? datPlanServiciosMqTmp.getPrecision1() : null);
                datPlanServiciosMqDTO2.setUsuarioDigitacion((datPlanServiciosMqTmp.getUsuarioDigitacion() != null)
                    ? datPlanServiciosMqTmp.getUsuarioDigitacion() : null);

                if (datPlanServiciosMqTmp.getTrabajador() != null) {
                    datPlanServiciosMqDTO2.setTrabId_Trabajador(datPlanServiciosMqTmp.getTrabajador()
                                                                                     .getTrabId());
                } else {
                    datPlanServiciosMqDTO2.setTrabId_Trabajador(null);
                }
                
                if (datPlanServiciosMqTmp.getTrabajador() != null) {
                    datPlanServiciosMqDTO2.setCodigoSupervisor(datPlanServiciosMqTmp.getTrabajador()
                                                                                     .getCodigo());
                } else {
                    datPlanServiciosMqDTO2.setCodigoSupervisor(null);
                }
                
                if (datPlanServiciosMqTmp.getTrabajador() != null) {
                    datPlanServiciosMqDTO2.setNombreSupervisor(datPlanServiciosMqTmp.getTrabajador()
                                                                                     .getNombre());
                } else {
                    datPlanServiciosMqDTO2.setNombreSupervisor(null);
                }
                
                
                if (datPlanServiciosMqTmp.getZonaGeografica() != null) {
                    datPlanServiciosMqDTO2.setZonaGeograficaId_ZonaGeografica(datPlanServiciosMqTmp.getZonaGeografica()
                                                                                     .getZonaGeograficaId());
                } else {
                    datPlanServiciosMqDTO2.setZonaGeograficaId_ZonaGeografica(null);
                }
                
                if (datPlanServiciosMqTmp.getZonaGeografica() != null) {
                    datPlanServiciosMqDTO2.setNombreZona(datPlanServiciosMqTmp.getZonaGeografica()
                                                                                     .getNombre());
                } else {
                    datPlanServiciosMqDTO2.setNombreZona(null);
                }
                
                if (datPlanServiciosMqTmp.getNivel2Clientesmq() != null) {
                    datPlanServiciosMqDTO2.setNivel2Clientesmq(datPlanServiciosMqTmp.getNivel2Clientesmq().getNivel2ClientesmqId()
                                                                                     );
                } else {
                    datPlanServiciosMqDTO2.setNivel2Clientesmq(null);
                }
                
                if (datPlanServiciosMqTmp.getNivel2Clientesmq() != null) {
                    datPlanServiciosMqDTO2.setNombreHacienda(datPlanServiciosMqTmp.getNivel2Clientesmq()
                                                                                     .getNombre());
                } else {
                    datPlanServiciosMqDTO2.setNombreHacienda(null);
                }

                

                if (datPlanServiciosMqTmp.getPersEmpr() != null) {
                    datPlanServiciosMqDTO2.setPersEmpr(datPlanServiciosMqTmp.getPersEmpr().getPersEmprId()
                                                                                     );
                } else {
                    datPlanServiciosMqDTO2.setPersEmpr(null);
                }
                
                if (datPlanServiciosMqTmp.getPersEmpr() != null) {
                    datPlanServiciosMqDTO2.setNombreCliente(datPlanServiciosMqTmp.getPersEmpr()
                                                                                     .getNombre());
                } else {
                    datPlanServiciosMqDTO2.setNombreCliente(null);
                }

                datPlanServiciosMqDTO2.setTipoProyecto((datPlanServiciosMqTmp.getTipoProyecto() != null)
                        ? datPlanServiciosMqTmp.getTipoProyecto() : null);

                
                
                datPlanServiciosMqDTO.add(datPlanServiciosMqDTO2);
            }

            return datPlanServiciosMqDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public DatPlanServiciosMq getDatPlanServiciosMq(Long datPlanServiciosMqId)
        throws Exception {
        log.debug("getting DatPlanServiciosMq instance");

        DatPlanServiciosMq entity = null;

        try {
            entity = datPlanServiciosMqDAO.findById(datPlanServiciosMqId);
        } catch (Exception e) {
            log.error("get DatPlanServiciosMq failed", e);
            throw new ZMessManager().new FindingException("DatPlanServiciosMq");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<DatPlanServiciosMq> findPageDatPlanServiciosMq(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        List<DatPlanServiciosMq> entity = null;

        try {
            entity = datPlanServiciosMqDAO.findPage(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatPlanServiciosMq Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberDatPlanServiciosMq() throws Exception {
        Long entity = null;

        try {
            entity = datPlanServiciosMqDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatPlanServiciosMq Count");
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
    public List<DatPlanServiciosMq> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<DatPlanServiciosMq> list = new ArrayList<DatPlanServiciosMq>();
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
            list = datPlanServiciosMqDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
