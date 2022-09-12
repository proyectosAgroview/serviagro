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

import co.com.arcosoft.dataaccess.dao.IDatOtrosCostosMqDAO;
import co.com.arcosoft.dataaccess.dao.IDatOtrosCostosMqdetDAO;
import co.com.arcosoft.dataaccess.dao.IDatOtrosCostosMqdetDistribuccionDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.CentCost;
import co.com.arcosoft.modelo.DatOtrosCostosMq;
import co.com.arcosoft.modelo.DatOtrosCostosMqdet;
import co.com.arcosoft.modelo.DatOtrosCostosMqdetDistribuccion;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.dto.DatOtrosCostosMqDTO;
import co.com.arcosoft.modelo.dto.DatOtrosCostosMqdetDTO;
import co.com.arcosoft.modelo.dto.DatOtrosCostosMqdetDistribuccionDTO;
import co.com.arcosoft.modelo.informes.dto.ListaEquiposCategoriaDTO;
import co.com.arcosoft.utilities.Utilities;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("DatOtrosCostosMqLogic")
public class DatOtrosCostosMqLogic implements IDatOtrosCostosMqLogic {
    private static final Logger log = LoggerFactory.getLogger(DatOtrosCostosMqLogic.class);

    /**
     * DAO injected by Spring that manages DatOtrosCostosMq entities
     *
     */
    @Autowired
    private IDatOtrosCostosMqDAO datOtrosCostosMqDAO;

    /**
    * DAO injected by Spring that manages DatOtrosCostosMqdet entities
    *
    */
    @Autowired
    private IDatOtrosCostosMqdetDAO datOtrosCostosMqdetDAO;

    @Autowired
    private IDatOtrosCostosMqdetDistribuccionDAO datOtrosCostosMqdetDistribuccionDAO;
    
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

    @Autowired
    IEquipoLogic logicEquipo;
    
    @Autowired
    ITagLogic logicTag;
    
    /**
    * Logic injected by Spring that manages PersEmpr entities
    *
    */
    @Autowired
    IPersEmprLogic logicPersEmpr4;

    @Autowired
    IEquipoLogic logicImplemento;

    
    @Override
	@Transactional(readOnly = true)
    public List<DatOtrosCostosMq> getDatOtrosCostosMq()
        throws Exception {
        log.debug("finding all DatOtrosCostosMq instances");

        List<DatOtrosCostosMq> list = new ArrayList<DatOtrosCostosMq>();

        try {
            list = datOtrosCostosMqDAO.findAll();
        } catch (Exception e) {
            log.error("finding all DatOtrosCostosMq failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "DatOtrosCostosMq");
        } finally {
        }

        return list;
    }

    @Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveDatOtrosCostosMq(DatOtrosCostosMq entity,  List<DatOtrosCostosMqdetDTO> dataMqdet
    		,  List<DatOtrosCostosMqdetDistribuccionDTO> dataDistr)
        throws Exception {
        log.debug("saving DatOtrosCostosMq instance");

        try {

            if ((entity.getEstado() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
                throw new ZMessManager().new NotValidFormatException("estado");
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

            if ((entity.getNumFactura() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getNumFactura(), 60) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "numFactura");
            }

            if ((entity.getObservacion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getObservacion(), 3900) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "observacion");
            }

            if ((entity.getObservacionAnularReg() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getObservacionAnularReg(), 500) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "observacionAnularReg");
            }

            if ((entity.getReglaDistribuccion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getReglaDistribuccion(), 60) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "reglaDistribuccion");
            }

            if ((entity.getSerieFactura() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getSerieFactura(), 60) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "serieFactura");
            }

            if ((entity.getTipoTransaccion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getTipoTransaccion(), 30) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "tipoTransaccion");
            }

            if ((entity.getValorTotal() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorTotal(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorTotal");
            }
            
            datOtrosCostosMqDAO.save(entity);

			if (dataMqdet != null) {

				for (DatOtrosCostosMqdetDTO valorDto : dataMqdet) {

					if (valorDto.getDatOtrosCostosMqdetId() == null) {

						DatOtrosCostosMqdet valor = new DatOtrosCostosMqdet();

						valor.setTag(valorDto.getTagId_Tag());
						valor.setEquipo(valorDto.getEquipoId_Equipo());
						valor.setPorcentaje(valorDto.getPorcentaje());
						valor.setCantidad(valorDto.getCantidad());
						valor.setCostoTotal(valorDto.getCostoTotal());
						valor.setProducto(valorDto.getProducto());
						valor.setUdadMed(valorDto.getUdadMed());
						valor.setValorUnitario(valorDto.getValorUnitario());
						valor.setDescripcion(valorDto.getDescripcion());
						valor.setPersEmpr(valorDto.getPersEmpr());
						valor.setHorometroServicio(valorDto.getHorometroServicio());
						valor.setNroFactura(valorDto.getNroFactura());
						valor.setLabor(valorDto.getLabor());
						
						if( valorDto.getCentCostId_CentCost()!=null) {
							Long centCostId = valorDto.getCentCostId_CentCost();
							CentCost centCost =   logicCentCost1.getCentCost(centCostId);
							valor.setCentCost(centCost);	
						}
						if(valorDto.getImplementoId()!=null) {
						Equipo implemento = logicImplemento.getEquipo(valorDto.getImplementoId());
						valor.setImplementoId(implemento);
						 }
						valor.setDatOtrosCostosMq(entity);

						datOtrosCostosMqdetDAO.save(valor);
					}
				}
			}

			if (dataDistr != null) {

				for (DatOtrosCostosMqdetDistribuccionDTO valorDto : dataDistr) {

					if (valorDto.getDatOtrosCostosMqdetDistrId() == null) {

						DatOtrosCostosMqdetDistribuccion valor = new DatOtrosCostosMqdetDistribuccion();

						valor.setEquipo(valorDto.getEquipoId_Equipo());						
						valor.setDatOtrosCostosMq(entity);

						datOtrosCostosMqdetDistribuccionDAO.save(valor);
					}
				}
			}           
            
            log.debug("save DatOtrosCostosMq successful");
        } catch (Exception e) {
            log.error("save DatOtrosCostosMq failed", e);
            throw e;
        } finally {
        }
    }

    @Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteDatOtrosCostosMq(DatOtrosCostosMq entity)
        throws Exception {
        log.debug("deleting DatOtrosCostosMq instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("DatOtrosCostosMq");
        }

        if (entity.getDatOtrosCostosMqId() == null) {
            throw new ZMessManager().new EmptyFieldException(
                "datOtrosCostosMqId");
        }

        List<DatOtrosCostosMqdet> datOtrosCostosMqdets = null;

        try {
            datOtrosCostosMqdets = datOtrosCostosMqdetDAO.findByProperty("datOtrosCostosMq.datOtrosCostosMqId",
                    entity.getDatOtrosCostosMqId());

            if (Utilities.validationsList(datOtrosCostosMqdets) == true) {
                throw new ZMessManager().new DeletingException(
                    "datOtrosCostosMqdets");
            }

            datOtrosCostosMqDAO.delete(entity);

            log.debug("delete DatOtrosCostosMq successful");
        } catch (Exception e) {
            log.error("delete DatOtrosCostosMq failed", e);
            throw e;
        } finally {
        }
    }

    @Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateDatOtrosCostosMq(DatOtrosCostosMq entity,   List<DatOtrosCostosMqdetDTO> dataMqdet
    		,  List<DatOtrosCostosMqdetDistribuccionDTO> dataDistr)
        throws Exception {
        log.debug("updating DatOtrosCostosMq instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "DatOtrosCostosMq");
            }
            
            if ((entity.getEstado() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
                throw new ZMessManager().new NotValidFormatException("estado");
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

            if ((entity.getNumFactura() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getNumFactura(), 60) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "numFactura");
            }

            if ((entity.getObservacion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getObservacion(), 3900) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "observacion");
            }

            if ((entity.getObservacionAnularReg() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getObservacionAnularReg(), 500) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "observacionAnularReg");
            }

            if ((entity.getReglaDistribuccion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getReglaDistribuccion(), 60) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "reglaDistribuccion");
            }

            if ((entity.getSerieFactura() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getSerieFactura(), 60) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "serieFactura");
            }

            if ((entity.getTipoTransaccion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getTipoTransaccion(), 30) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "tipoTransaccion");
            }

            if ((entity.getValorTotal() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorTotal(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorTotal");
            }

            datOtrosCostosMqDAO.update(entity);

			if (dataMqdet != null) {
				for (DatOtrosCostosMqdetDTO valorDto : dataMqdet) {

					if (valorDto.getDatOtrosCostosMqdetId() == null) { 

						DatOtrosCostosMqdet valor = new DatOtrosCostosMqdet();
						valor.setTag(valorDto.getTagId_Tag());
						valor.setEquipo(valorDto.getEquipoId_Equipo());
						valor.setPorcentaje(valorDto.getPorcentaje());
						valor.setCantidad(valorDto.getCantidad());
						valor.setCostoTotal(valorDto.getCostoTotal());
						valor.setProducto(valorDto.getProducto());
						valor.setUdadMed(valorDto.getUdadMed());
						valor.setValorUnitario(valorDto.getValorUnitario());
						valor.setDescripcion(valorDto.getDescripcion());
						valor.setLabor(valorDto.getLabor());
						valor.setPersEmpr(valorDto.getPersEmpr());
						valor.setHorometroServicio(valorDto.getHorometroServicio());
						valor.setNroFactura(valorDto.getNroFactura());
						
						if( valorDto.getCentCostId_CentCost()!=null) {
							Long centCostId = valorDto.getCentCostId_CentCost();
							CentCost centCost =   logicCentCost1.getCentCost(centCostId);
							valor.setCentCost(centCost);	
						}
						if(valorDto.getImplementoId()!=null) {
							Equipo implemento = logicImplemento.getEquipo(valorDto.getImplementoId());
							valor.setImplementoId(implemento);
							
							
							}
						valor.setDatOtrosCostosMq(entity);

						datOtrosCostosMqdetDAO.save(valor);

					} else {
						DatOtrosCostosMqdet valor = datOtrosCostosMqdetDAO.findById(valorDto.getDatOtrosCostosMqdetId());
						valor.setTag(valorDto.getTagId_Tag());
						valor.setEquipo(valorDto.getEquipoId_Equipo());
						valor.setPorcentaje(valorDto.getPorcentaje());
						valor.setCantidad(valorDto.getCantidad());
						valor.setCostoTotal(valorDto.getCostoTotal());
						valor.setProducto(valorDto.getProducto());
						valor.setUdadMed(valorDto.getUdadMed());
						valor.setValorUnitario(valorDto.getValorUnitario());
						valor.setDescripcion(valorDto.getDescripcion());
						valor.setPersEmpr(valorDto.getPersEmpr());
						valor.setHorometroServicio(valorDto.getHorometroServicio());
						valor.setLabor(valorDto.getLabor());
						valor.setNroFactura(valorDto.getNroFactura());
						
						if( valorDto.getCentCostId_CentCost()!=null) {
							Long centCostId = valorDto.getCentCostId_CentCost();
							CentCost centCost =   logicCentCost1.getCentCost(centCostId);
							valor.setCentCost(centCost);	
						}
						if(valorDto.getImplementoId()!=null) {
							Equipo implemento = logicImplemento.getEquipo(valorDto.getImplementoId());
							valor.setImplementoId(implemento);
							
							
							}
						valor.setDatOtrosCostosMq(entity);

						datOtrosCostosMqdetDAO.update(valor);
					}
				}
			}			
			
			if (dataDistr != null) {
				for (DatOtrosCostosMqdetDistribuccionDTO valorDto : dataDistr) {

					if (valorDto.getDatOtrosCostosMqdetDistrId() == null) { 

						DatOtrosCostosMqdetDistribuccion valor = new DatOtrosCostosMqdetDistribuccion();
						valor.setEquipo(valorDto.getEquipoId_Equipo());

						datOtrosCostosMqdetDistribuccionDAO.save(valor);

					} else {
						DatOtrosCostosMqdetDistribuccion valor = datOtrosCostosMqdetDistribuccionDAO
								.findById(valorDto.getDatOtrosCostosMqdetDistrId());
						valor.setEquipo(valorDto.getEquipoId_Equipo());
						valor.setDatOtrosCostosMq(entity);

						datOtrosCostosMqdetDistribuccionDAO.update(valor);
					}
				}
			}
			
            log.debug("update DatOtrosCostosMq successful");
        } catch (Exception e) {
            log.error("update DatOtrosCostosMq failed", e);
            throw e;
        } finally {
        }
    }

    @Override
	@Transactional(readOnly = true)
    public List<DatOtrosCostosMqDTO> getDataDatOtrosCostosMq()
        throws Exception {
        try {
           // List<DatOtrosCostosMq> datOtrosCostosMq = datOtrosCostosMqDAO.findByCriteria("origenDatos = "+"'"+modulo+"'");
            List<DatOtrosCostosMq> datOtrosCostosMq = datOtrosCostosMqDAO.findAll();
            
            List<DatOtrosCostosMqDTO> datOtrosCostosMqDTO = new ArrayList<DatOtrosCostosMqDTO>();

            for (DatOtrosCostosMq datOtrosCostosMqTmp : datOtrosCostosMq) {
                DatOtrosCostosMqDTO datOtrosCostosMqDTO2 = new DatOtrosCostosMqDTO();

                datOtrosCostosMqDTO2.setDatOtrosCostosMqId(datOtrosCostosMqTmp.getDatOtrosCostosMqId());
                datOtrosCostosMqDTO2.setCompania((datOtrosCostosMqTmp.getCompania() != null)
                    ? datOtrosCostosMqTmp.getCompania() : null);
                datOtrosCostosMqDTO2.setConsecutivo((datOtrosCostosMqTmp.getConsecutivo() != null)
                    ? datOtrosCostosMqTmp.getConsecutivo() : null);
                datOtrosCostosMqDTO2.setEstado((datOtrosCostosMqTmp.getEstado() != null)
                    ? datOtrosCostosMqTmp.getEstado() : null);
                datOtrosCostosMqDTO2.setFechaAnulacion(datOtrosCostosMqTmp.getFechaAnulacion());
                datOtrosCostosMqDTO2.setFechaCreacion(datOtrosCostosMqTmp.getFechaCreacion());
                datOtrosCostosMqDTO2.setFechaInicial(datOtrosCostosMqTmp.getFechaInicial());
                datOtrosCostosMqDTO2.setFechaModificacion(datOtrosCostosMqTmp.getFechaModificacion());
                datOtrosCostosMqDTO2.setFechaRegistro(datOtrosCostosMqTmp.getFechaRegistro());
                datOtrosCostosMqDTO2.setInfoAdicional((datOtrosCostosMqTmp.getInfoAdicional() != null)
                    ? datOtrosCostosMqTmp.getInfoAdicional() : null);
                datOtrosCostosMqDTO2.setInfoAdicional2((datOtrosCostosMqTmp.getInfoAdicional2() != null)
                    ? datOtrosCostosMqTmp.getInfoAdicional2() : null);
                datOtrosCostosMqDTO2.setNumFactura((datOtrosCostosMqTmp.getNumFactura() != null)
                    ? datOtrosCostosMqTmp.getNumFactura() : null);
                datOtrosCostosMqDTO2.setObservacion((datOtrosCostosMqTmp.getObservacion() != null)
                    ? datOtrosCostosMqTmp.getObservacion() : null);
                datOtrosCostosMqDTO2.setObservacionAnularReg((datOtrosCostosMqTmp.getObservacionAnularReg() != null)
                    ? datOtrosCostosMqTmp.getObservacionAnularReg() : null);
                datOtrosCostosMqDTO2.setReglaDistribuccion((datOtrosCostosMqTmp.getReglaDistribuccion() != null)
                    ? datOtrosCostosMqTmp.getReglaDistribuccion() : null);
                datOtrosCostosMqDTO2.setSerieFactura((datOtrosCostosMqTmp.getSerieFactura() != null)
                    ? datOtrosCostosMqTmp.getSerieFactura() : null);
                datOtrosCostosMqDTO2.setTipoTransaccion((datOtrosCostosMqTmp.getTipoTransaccion() != null)
                    ? datOtrosCostosMqTmp.getTipoTransaccion() : null);
                datOtrosCostosMqDTO2.setUsuarioDigitacion((datOtrosCostosMqTmp.getUsuarioDigitacion() != null)
                    ? datOtrosCostosMqTmp.getUsuarioDigitacion() : null);
                datOtrosCostosMqDTO2.setValorTotal((datOtrosCostosMqTmp.getValorTotal() != null)
                    ? datOtrosCostosMqTmp.getValorTotal() : null);
                datOtrosCostosMqDTO2.setCentCostId_CentCost((datOtrosCostosMqTmp.getCentCost()
                                                                                 != null)
                    ? datOtrosCostosMqTmp.getCentCost().getCentCostId() : null);
           
                if (datOtrosCostosMqTmp.getElementoCosto() != null) {
                    datOtrosCostosMqDTO2.setElemCostoId_ElementoCosto(datOtrosCostosMqTmp.getElementoCosto()
                                                                             .getElemCostoId());
                } else {
                    datOtrosCostosMqDTO2.setElemCostoId_ElementoCosto(null);
                }
                
                if (datOtrosCostosMqTmp.getLabor() != null) {
                    datOtrosCostosMqDTO2.setLaborId_Labor(datOtrosCostosMqTmp.getLabor()
                                                                             .getLaborId());
                } else {
                    datOtrosCostosMqDTO2.setLaborId_Labor(null);
                }

                datOtrosCostosMqDTO2.setPersEmprId_PersEmpr((datOtrosCostosMqTmp.getPersEmpr()
                                                                                .getPersEmprId() != null)
                    ? datOtrosCostosMqTmp.getPersEmpr().getPersEmprId() : null);
                
                datOtrosCostosMqDTO2
				.setOrigenDatos((datOtrosCostosMqTmp.getOrigenDatos() != null) ? datOtrosCostosMqTmp
						.getOrigenDatos() : null);
                
                if (datOtrosCostosMqTmp.getCategoria() != null) {
                    datOtrosCostosMqDTO2.setCategoria(datOtrosCostosMqTmp.getCategoria()
                                                                             );
                } else {
                    datOtrosCostosMqDTO2.setCategoria(null);
                }
                
                datOtrosCostosMqDTO2
				.setOrigenDatos((datOtrosCostosMqTmp.getTipoGasto() != null) ? datOtrosCostosMqTmp
						.getTipoGasto() : null);
		
                datOtrosCostosMqDTO.add(datOtrosCostosMqDTO2);
            }

            return datOtrosCostosMqDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
	@Transactional(readOnly = true)
    public DatOtrosCostosMq getDatOtrosCostosMq(Long datOtrosCostosMqId)
        throws Exception {
        log.debug("getting DatOtrosCostosMq instance");

        DatOtrosCostosMq entity = null;

        try {
            entity = datOtrosCostosMqDAO.findById(datOtrosCostosMqId);
        } catch (Exception e) {
            log.error("get DatOtrosCostosMq failed", e);
            throw new ZMessManager().new FindingException("DatOtrosCostosMq");
        } finally {
        }

        return entity;
    }

    @Override
	@Transactional(readOnly = true)
    public List<DatOtrosCostosMq> findPageDatOtrosCostosMq(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        List<DatOtrosCostosMq> entity = null;

        try {
            entity = datOtrosCostosMqDAO.findPage(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatOtrosCostosMq Count");
        } finally {
        }

        return entity;
    }

    @Override
	@Transactional(readOnly = true)
    public Long findTotalNumberDatOtrosCostosMq() throws Exception {
        Long entity = null;

        try {
            entity = datOtrosCostosMqDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatOtrosCostosMq Count");
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
    @Override
	@Transactional(readOnly = true)
    public List<DatOtrosCostosMq> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<DatOtrosCostosMq> list = new ArrayList<DatOtrosCostosMq>();
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
            list = datOtrosCostosMqDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
    
    @Override
   	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
       public void saveDatOtrosCostosMqVer2(DatOtrosCostosMq entity, List<DatOtrosCostosMqdetDTO> dataMqdet, List<ListaEquiposCategoriaDTO> dataDistr)
           throws Exception {
           log.debug("saving DatOtrosCostosMq instance");

           try {
            
              


               if ((entity.getEstado() != null) &&
                       (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
                   throw new ZMessManager().new NotValidFormatException("estado");
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

               if ((entity.getNumFactura() != null) &&
                       (Utilities.checkWordAndCheckWithlength(
                           entity.getNumFactura(), 60) == false)) {
                   throw new ZMessManager().new NotValidFormatException(
                       "numFactura");
               }

               if ((entity.getObservacion() != null) &&
                       (Utilities.checkWordAndCheckWithlength(
                           entity.getObservacion(), 3900) == false)) {
                   throw new ZMessManager().new NotValidFormatException(
                       "observacion");
               }

               if ((entity.getObservacionAnularReg() != null) &&
                       (Utilities.checkWordAndCheckWithlength(
                           entity.getObservacionAnularReg(), 500) == false)) {
                   throw new ZMessManager().new NotValidFormatException(
                       "observacionAnularReg");
               }

               if ((entity.getReglaDistribuccion() != null) &&
                       (Utilities.checkWordAndCheckWithlength(
                           entity.getReglaDistribuccion(), 60) == false)) {
                   throw new ZMessManager().new NotValidFormatException(
                       "reglaDistribuccion");
               }

               if ((entity.getSerieFactura() != null) &&
                       (Utilities.checkWordAndCheckWithlength(
                           entity.getSerieFactura(), 60) == false)) {
                   throw new ZMessManager().new NotValidFormatException(
                       "serieFactura");
               }

               if ((entity.getTipoTransaccion() != null) &&
                       (Utilities.checkWordAndCheckWithlength(
                           entity.getTipoTransaccion(), 30) == false)) {
                   throw new ZMessManager().new NotValidFormatException(
                       "tipoTransaccion");
               }

               if ((entity.getValorTotal() != null) &&
                       (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                           entity.getValorTotal(), 8, 4) == false)) {
                   throw new ZMessManager().new NotValidFormatException(
                       "valorTotal");
               }

           
             

               datOtrosCostosMqDAO.save(entity);
              

   			if (dataMqdet != null) {

   				for (DatOtrosCostosMqdetDTO valorDto : dataMqdet) {

   					if (valorDto.getDatOtrosCostosMqdetId() == null) {

   						DatOtrosCostosMqdet valor = new DatOtrosCostosMqdet();

   						valor.setTag(valorDto.getTagId_Tag());
   						valor.setEquipo(valorDto.getEquipoId_Equipo());
   						valor.setPorcentaje(valorDto.getPorcentaje());
   						valor.setCantidad(valorDto.getCantidad());
   						valor.setCostoTotal(valorDto.getCostoTotal());
   						valor.setProducto(valorDto.getProducto());
   						valor.setUdadMed(valorDto.getUdadMed());
   						valor.setValorUnitario(valorDto.getValorUnitario());
   						valor.setDescripcion(valorDto.getDescripcion());

   						valor.setDatOtrosCostosMq(entity);

   						datOtrosCostosMqdetDAO.save(valor);
   					}

   				}
   			}

   		
   			
   			if (dataDistr != null) {

   				for (ListaEquiposCategoriaDTO valorDto : dataDistr) {

   					

   					DatOtrosCostosMqdetDistribuccion valor = new DatOtrosCostosMqdetDistribuccion();
   						
   						Equipo equipo = logicEquipo.getEquipo(valorDto.getEquipo_id().longValue());
						valor.setEquipo(equipo);
						
						valor.setDatOtrosCostosMq(entity);

						datOtrosCostosMqdetDistribuccionDAO.save(valor);
   					

   				}
   			}

               
               
               log.debug("save DatOtrosCostosMq successful");
           } catch (Exception e) {
               log.error("save DatOtrosCostosMq failed", e);
               throw e;
           } finally {
           }
       }
    
    @Override
   	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
       public void updateDatOtrosCostosMqVer2(DatOtrosCostosMq entity, List<DatOtrosCostosMqdetDTO> dataMqdet, List<ListaEquiposCategoriaDTO> dataDistr)
           throws Exception {
           log.debug("updating DatOtrosCostosMq instance");

           try {
               if (entity == null) {
                   throw new ZMessManager().new NullEntityExcepcion(
                       "DatOtrosCostosMq");
               }

              
            

               if ((entity.getEstado() != null) &&
                       (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
                   throw new ZMessManager().new NotValidFormatException("estado");
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

               if ((entity.getNumFactura() != null) &&
                       (Utilities.checkWordAndCheckWithlength(
                           entity.getNumFactura(), 60) == false)) {
                   throw new ZMessManager().new NotValidFormatException(
                       "numFactura");
               }

               if ((entity.getObservacion() != null) &&
                       (Utilities.checkWordAndCheckWithlength(
                           entity.getObservacion(), 3900) == false)) {
                   throw new ZMessManager().new NotValidFormatException(
                       "observacion");
               }

               if ((entity.getObservacionAnularReg() != null) &&
                       (Utilities.checkWordAndCheckWithlength(
                           entity.getObservacionAnularReg(), 500) == false)) {
                   throw new ZMessManager().new NotValidFormatException(
                       "observacionAnularReg");
               }

               if ((entity.getReglaDistribuccion() != null) &&
                       (Utilities.checkWordAndCheckWithlength(
                           entity.getReglaDistribuccion(), 60) == false)) {
                   throw new ZMessManager().new NotValidFormatException(
                       "reglaDistribuccion");
               }

               if ((entity.getSerieFactura() != null) &&
                       (Utilities.checkWordAndCheckWithlength(
                           entity.getSerieFactura(), 60) == false)) {
                   throw new ZMessManager().new NotValidFormatException(
                       "serieFactura");
               }

               if ((entity.getTipoTransaccion() != null) &&
                       (Utilities.checkWordAndCheckWithlength(
                           entity.getTipoTransaccion(), 30) == false)) {
                   throw new ZMessManager().new NotValidFormatException(
                       "tipoTransaccion");
               }

               if ((entity.getValorTotal() != null) &&
                       (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                           entity.getValorTotal(), 8, 4) == false)) {
                   throw new ZMessManager().new NotValidFormatException(
                       "valorTotal");
               }

              
             

           
               datOtrosCostosMqDAO.update(entity);
               
               if (dataMqdet != null) {
   				for (DatOtrosCostosMqdetDTO valorDto : dataMqdet) {

   					if (valorDto.getDatOtrosCostosMqdetId() == null) { // crear
   																		// el
   																		// valor
   						// nuevo

   						DatOtrosCostosMqdet valor = new DatOtrosCostosMqdet();
   						valor.setTag(valorDto.getTagId_Tag());
   						valor.setEquipo(valorDto.getEquipoId_Equipo());
   						valor.setPorcentaje(valorDto.getPorcentaje());
   						valor.setCantidad(valorDto.getCantidad());
   						valor.setCostoTotal(valorDto.getCostoTotal());
   						valor.setProducto(valorDto.getProducto());
   						valor.setUdadMed(valorDto.getUdadMed());
   						valor.setValorUnitario(valorDto.getValorUnitario());
   						valor.setDescripcion(valorDto.getDescripcion());
   						valor.setDescripcion(valorDto.getDescripcion());
   						valor.setDatOtrosCostosMq(entity);

   						datOtrosCostosMqdetDAO.save(valor);

   					} else {
   						DatOtrosCostosMqdet valor = datOtrosCostosMqdetDAO
   								.findById(valorDto.getDatOtrosCostosMqdetId());
   						valor.setTag(valorDto.getTagId_Tag());
   						valor.setEquipo(valorDto.getEquipoId_Equipo());
   						valor.setPorcentaje(valorDto.getPorcentaje());
   						valor.setCantidad(valorDto.getCantidad());
   						valor.setCostoTotal(valorDto.getCostoTotal());
   						valor.setProducto(valorDto.getProducto());
   						valor.setUdadMed(valorDto.getUdadMed());
   						valor.setValorUnitario(valorDto.getValorUnitario());
   						valor.setDescripcion(valorDto.getDescripcion());

   						valor.setDatOtrosCostosMq(entity);

   						datOtrosCostosMqdetDAO.update(valor);
   					}

   				}
   			}
   			
   			

               if (dataDistr != null) {

      				for (ListaEquiposCategoriaDTO valorDto : dataDistr) {

      					

      					DatOtrosCostosMqdetDistribuccion valor = new DatOtrosCostosMqdetDistribuccion();
      						
      						Equipo equipo = logicEquipo.getEquipo(valorDto.getEquipo_id().longValue());
   						valor.setEquipo(equipo);
   					
   						valor.setDatOtrosCostosMq(entity);

   						datOtrosCostosMqdetDistribuccionDAO.save(valor);
      					

      				}
      			}

               log.debug("update DatOtrosCostosMq successful");
           } catch (Exception e) {
               log.error("update DatOtrosCostosMq failed", e);
               throw e;
           } finally {
           }
       }
}
