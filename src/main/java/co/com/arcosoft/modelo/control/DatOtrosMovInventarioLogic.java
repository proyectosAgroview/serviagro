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

import co.com.arcosoft.dataaccess.dao.IDatOtrosMovInventarioDAO;
import co.com.arcosoft.dataaccess.dao.IPrecioPromProdDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatOtrosMovInventario;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.PrecioPromProd;
import co.com.arcosoft.modelo.dto.DatOtrosMovInventarioDTO;
import co.com.arcosoft.modelo.dto.PrecioPromProdDTO;
import co.com.arcosoft.utilities.Utilities;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("DatOtrosMovInventarioLogic")
public class DatOtrosMovInventarioLogic implements IDatOtrosMovInventarioLogic {
    private static final Logger log = LoggerFactory.getLogger(DatOtrosMovInventarioLogic.class);

    /**
     * DAO injected by Spring that manages DatOtrosMovInventario entities
     *
     */
    @Autowired
    private IDatOtrosMovInventarioDAO datOtrosMovInventarioDAO;

    /**
    * DAO injected by Spring that manages PrecioPromProd entities
    *
    */
    @Autowired
    private IPrecioPromProdDAO precioPromProdDAO;

    /**
    * Logic injected by Spring that manages ConceptoKardex entities
    *
    */
    @Autowired
    IConceptoKardexLogic logicConceptoKardex1;

    /**
    * Logic injected by Spring that manages Labor entities
    *
    */
    @Autowired
    ILaborLogic logicLabor2;

    /**
    * Logic injected by Spring that manages PersEmpr entities
    *
    */
    @Autowired
    IPersEmprLogic logicPersEmpr3;


    @Autowired
    IEquipoLogic logicImplemento;

    @Autowired
    IEquipoLogic logicEquipo;
    
    @Transactional(readOnly = true)
    public List<DatOtrosMovInventario> getDatOtrosMovInventario()
        throws Exception {
        log.debug("finding all DatOtrosMovInventario instances");

        List<DatOtrosMovInventario> list = new ArrayList<DatOtrosMovInventario>();

        try {
            list = datOtrosMovInventarioDAO.findAll();
        } catch (Exception e) {
            log.error("finding all DatOtrosMovInventario failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "DatOtrosMovInventario");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveDatOtrosMovInventario(DatOtrosMovInventario entity, List<PrecioPromProdDTO> dataDetPrecioProductos)
        throws Exception {
        log.debug("saving DatOtrosMovInventario instance");

        try {
            if (entity.getConceptoKardex() == null) {
                throw new ZMessManager().new ForeignException("conceptoKardex");
            }


            if ((entity.getDetalleNota() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDetalleNota(), 3900) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "detalleNota");
            }

            if ((entity.getDistribuirCantidad() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDistribuirCantidad(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "distribuirCantidad");
            }

            if ((entity.getEstado() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
                throw new ZMessManager().new NotValidFormatException("estado");
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

            if (entity.getConceptoKardex().getConceptoKardexId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "conceptoKardexId_ConceptoKardex");
            }

            datOtrosMovInventarioDAO.save(entity);
            if (dataDetPrecioProductos != null) {

				for (PrecioPromProdDTO valorDto : dataDetPrecioProductos) {

					if (valorDto.getPrecioProdId() == null) {

						PrecioPromProd valor = new PrecioPromProd();
						valor.setConsecutivo(entity.getConsecutivo());
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
						valor.setEquipoId(valorDto.getEquipoId());
						
						if(valorDto.getEquipoId()!=null) {
							if(valorDto.getEquipoId()!=null) {
								valor.setCentCostId(valorDto.getEquipoId().getCentCost());	
							}
						}
	
						valor.setConceptoKardexId(valorDto.getConceptoKardexId());
						valor.setProducto(valorDto.getProducto());
						valor.setTrabajador(valorDto.getTrabajador());
						valor.setPorcIva(valorDto.getPorcIva());
						valor.setValorIva(valorDto.getValorIva());
						valor.setCostoTotal(valorDto.getCostoTotal());
						valor.setTipoMovimiento(valorDto.getTipoMovimiento());
						valor.setNumFacturaCompra(valorDto.getNumFacturaCompra());
						valor.setInfoAdicional(valorDto.getInfoAdicional());
						valor.setConceptoGastoId(valorDto.getConceptoGastoId());
						valor.setNivel2Id(valorDto.getNivel2Id_Nivel2());
						valor.setNivel4Id(valorDto.getNivel4Id_Nivel4());
						valor.setOrigenDatos(valorDto.getOrigenDatos());
						valor.setEtapaId(valorDto.getEtapaId());
						valor.setVariedId(valorDto.getVariedId());
						valor.setDiferido("NO");
						valor.setUsuarioDigitacion(entity.getUsuarioDigitacion());
						valor.setHorometro_abastecimiento(valorDto.getHorometro_abastecimiento());
						valor.setIndicador_vuelta_medidor(valorDto.getIndicador_vuelta_medidor());
						valor.setUbicacionesAlmacen(valorDto.getUbicacionesAlmacen());
					
						if(valorDto.getImplementoId()!=null) {
						Equipo implemento = logicImplemento.getEquipo(valorDto.getImplementoId());
						valor.setImplementoId(implemento);
						}
						
						valor.setReferenciaFacCompra(valorDto.getReferenciaFacCompra());
					 
					
						valor.setDatOtrosMovInventarioId(entity);
						
						precioPromProdDAO.save(valor);
					}

				}
			}

            log.debug("save DatOtrosMovInventario successful");
        } catch (Exception e) {
            log.error("save DatOtrosMovInventario failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteDatOtrosMovInventario(DatOtrosMovInventario entity)
        throws Exception {
        log.debug("deleting DatOtrosMovInventario instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion(
                "DatOtrosMovInventario");
        }

        if (entity.getDatOtrosMovInventarioId() == null) {
            throw new ZMessManager().new EmptyFieldException(
                "datOtrosMovInventarioId");
        }

        List<PrecioPromProd> precioPromProds = null;

        try {
            precioPromProds = precioPromProdDAO.findByProperty("datOtrosMovInventario.datOtrosMovInventarioId",
                    entity.getDatOtrosMovInventarioId());

            if (Utilities.validationsList(precioPromProds) == true) {
                throw new ZMessManager().new DeletingException(
                    "precioPromProds");
            }
            
            datOtrosMovInventarioDAO.delete(entity);

            log.debug("delete DatOtrosMovInventario successful");
        } catch (Exception e) {
            log.error("delete DatOtrosMovInventario failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateDatOtrosMovInventario(DatOtrosMovInventario entity, List<PrecioPromProdDTO> dataDetPrecioProductos)
        throws Exception {
        log.debug("updating DatOtrosMovInventario instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "DatOtrosMovInventario");
            }

            if (entity.getConceptoKardex() == null) {
                throw new ZMessManager().new ForeignException("conceptoKardex");
            }


            if ((entity.getDetalleNota() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDetalleNota(), 3900) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "detalleNota");
            }

            if ((entity.getDistribuirCantidad() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDistribuirCantidad(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "distribuirCantidad");
            }

            if ((entity.getEstado() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
                throw new ZMessManager().new NotValidFormatException("estado");
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

            if (entity.getConceptoKardex().getConceptoKardexId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "conceptoKardexId_ConceptoKardex");
            }

            

            datOtrosMovInventarioDAO.update(entity);

			if (dataDetPrecioProductos != null) {

				for (PrecioPromProdDTO valorDto : dataDetPrecioProductos) {

					if (valorDto.getPrecioProdId() == null) {

						PrecioPromProd valor = new PrecioPromProd();
						valor.setConsecutivo(entity.getConsecutivo());
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
						valor.setEquipoId(valorDto.getEquipoId());
						valor.setConceptoKardexId(valorDto.getConceptoKardexId());
						valor.setProducto(valorDto.getProducto());
						valor.setTrabajador(valorDto.getTrabajador());
						valor.setPorcIva(valorDto.getPorcIva());
						valor.setValorIva(valorDto.getValorIva());
						valor.setCostoTotal(valorDto.getCostoTotal());
						valor.setTipoMovimiento(valorDto.getTipoMovimiento());
						valor.setNumFacturaCompra(valorDto.getNumFacturaCompra());
						valor.setInfoAdicional(valorDto.getInfoAdicional());
						valor.setConceptoGastoId(valorDto.getConceptoGastoId());
						valor.setNivel2Id(valorDto.getNivel2Id_Nivel2());
						valor.setNivel4Id(valorDto.getNivel4Id_Nivel4());
						valor.setDiferido("NO");
						valor.setEtapaId(valorDto.getEtapaId());
						valor.setVariedId(valorDto.getVariedId());
						valor.setOrigenDatos(valorDto.getOrigenDatos());
						valor.setHorometro_abastecimiento(valorDto.getHorometro_abastecimiento());
						valor.setIndicador_vuelta_medidor(valorDto.getIndicador_vuelta_medidor());
						valor.setUbicacionesAlmacen(valorDto.getUbicacionesAlmacen());
						valor.setReferenciaFacCompra(valorDto.getReferenciaFacCompra());
						if(valorDto.getImplementoId()!=null) {
							Equipo implemento = logicImplemento.getEquipo(valorDto.getImplementoId());
							valor.setImplementoId(implemento);
							}
						if(valorDto.getEquipoId()!=null) {
							if(valorDto.getEquipoId()!=null) {
								valor.setCentCostId(valorDto.getEquipoId().getCentCost());	
							}
						}
						valor.setDatOtrosMovInventarioId(entity);
						 
					
						precioPromProdDAO.save(valor);
						
					} else {
						
						PrecioPromProd valor = precioPromProdDAO.findById(valorDto.getPrecioProdId());
						
						valor.setConsecutivo(entity.getConsecutivo());
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
						valor.setEquipoId(valorDto.getEquipoId());
						valor.setConceptoKardexId(valorDto.getConceptoKardexId());
						valor.setProducto(valorDto.getProducto());
						valor.setTrabajador(valorDto.getTrabajador());
						valor.setPorcIva(valorDto.getPorcIva());
						valor.setValorIva(valorDto.getValorIva());
						valor.setCostoTotal(valorDto.getCostoTotal());
						valor.setTipoMovimiento(valorDto.getTipoMovimiento());
						valor.setNumFacturaCompra(valorDto.getNumFacturaCompra());
						valor.setInfoAdicional(valorDto.getInfoAdicional());
						valor.setConceptoGastoId(valorDto.getConceptoGastoId());
						valor.setNivel2Id(valorDto.getNivel2Id_Nivel2());
						valor.setNivel4Id(valorDto.getNivel4Id_Nivel4());
						valor.setDiferido("NO");
						valor.setEtapaId(valorDto.getEtapaId());
						valor.setVariedId(valorDto.getVariedId());
						valor.setOrigenDatos(valorDto.getOrigenDatos());
						valor.setHorometro_abastecimiento(valorDto.getHorometro_abastecimiento());
						valor.setIndicador_vuelta_medidor(valorDto.getIndicador_vuelta_medidor());
						valor.setUbicacionesAlmacen(valorDto.getUbicacionesAlmacen());
						if(valorDto.getImplementoId()!=null) {
							Equipo implemento = logicImplemento.getEquipo(valorDto.getImplementoId());
							valor.setImplementoId(implemento);
							}
						valor.setReferenciaFacCompra(valorDto.getReferenciaFacCompra());
						if(valorDto.getEquipoId()!=null) {
							if(valorDto.getEquipoId()!=null) {
								valor.setCentCostId(valorDto.getEquipoId().getCentCost());	
							}
						}
						valor.setDatOtrosMovInventarioId(entity);
						 
						precioPromProdDAO.update(valor);
					}

				}
			}

            log.debug("update DatOtrosMovInventario successful");
        } catch (Exception e) {
            log.error("update DatOtrosMovInventario failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<DatOtrosMovInventarioDTO> getDataDatOtrosMovInventario()
        throws Exception {
        try {
            List<DatOtrosMovInventario> datOtrosMovInventario = datOtrosMovInventarioDAO.findAll();

            List<DatOtrosMovInventarioDTO> datOtrosMovInventarioDTO = new ArrayList<DatOtrosMovInventarioDTO>();

            for (DatOtrosMovInventario datOtrosMovInventarioTmp : datOtrosMovInventario) {
                DatOtrosMovInventarioDTO datOtrosMovInventarioDTO2 = new DatOtrosMovInventarioDTO();

                datOtrosMovInventarioDTO2.setDatOtrosMovInventarioId(datOtrosMovInventarioTmp.getDatOtrosMovInventarioId());
                datOtrosMovInventarioDTO2.setCompania((datOtrosMovInventarioTmp.getCompania() != null)
                    ? datOtrosMovInventarioTmp.getCompania() : null);
                datOtrosMovInventarioDTO2.setConsecutivo((datOtrosMovInventarioTmp.getConsecutivo() != null)
                    ? datOtrosMovInventarioTmp.getConsecutivo() : null);
                datOtrosMovInventarioDTO2.setDetalleNota((datOtrosMovInventarioTmp.getDetalleNota() != null)
                    ? datOtrosMovInventarioTmp.getDetalleNota() : null);
                datOtrosMovInventarioDTO2.setDistribuirCantidad((datOtrosMovInventarioTmp.getDistribuirCantidad() != null)
                    ? datOtrosMovInventarioTmp.getDistribuirCantidad() : null);
                datOtrosMovInventarioDTO2.setEstado((datOtrosMovInventarioTmp.getEstado() != null)
                    ? datOtrosMovInventarioTmp.getEstado() : null);
                datOtrosMovInventarioDTO2.setFechaAnulacion(datOtrosMovInventarioTmp.getFechaAnulacion());
                datOtrosMovInventarioDTO2.setFechaCreacion(datOtrosMovInventarioTmp.getFechaCreacion());
                datOtrosMovInventarioDTO2.setFechaModificacion(datOtrosMovInventarioTmp.getFechaModificacion());
                datOtrosMovInventarioDTO2.setFechaRegistro(datOtrosMovInventarioTmp.getFechaRegistro());
                datOtrosMovInventarioDTO2.setNumFactura((datOtrosMovInventarioTmp.getNumFactura() != null)
                    ? datOtrosMovInventarioTmp.getNumFactura() : null);
                datOtrosMovInventarioDTO2.setObservacion((datOtrosMovInventarioTmp.getObservacion() != null)
                    ? datOtrosMovInventarioTmp.getObservacion() : null);
                datOtrosMovInventarioDTO2.setObservacionAnularReg((datOtrosMovInventarioTmp.getObservacionAnularReg() != null)
                    ? datOtrosMovInventarioTmp.getObservacionAnularReg() : null);
                datOtrosMovInventarioDTO2.setUsuarioDigitacion((datOtrosMovInventarioTmp.getUsuarioDigitacion() != null)
                    ? datOtrosMovInventarioTmp.getUsuarioDigitacion() : null);
                datOtrosMovInventarioDTO2.setConceptoKardexId_ConceptoKardex((datOtrosMovInventarioTmp.getConceptoKardex()
                                                                                                      .getConceptoKardexId() != null)
                    ? datOtrosMovInventarioTmp.getConceptoKardex()
                                              .getConceptoKardexId() : null);

                if (datOtrosMovInventarioTmp.getLabor() != null) {
                    datOtrosMovInventarioDTO2.setLaborId_Labor(datOtrosMovInventarioTmp.getLabor()
                                                                                       .getLaborId());
                } else {
                    datOtrosMovInventarioDTO2.setLaborId_Labor(null);
                }

                if (datOtrosMovInventarioTmp.getPersEmpr() != null) {
                    datOtrosMovInventarioDTO2.setPersEmprId_PersEmpr(datOtrosMovInventarioTmp.getPersEmpr()
                                                                                       .getPersEmprId());
                } else {
                    datOtrosMovInventarioDTO2.setPersEmprId_PersEmpr(null);
                }
                
                if (datOtrosMovInventarioTmp.getConceptoKardex() != null) {
                    datOtrosMovInventarioDTO2.setNomConceptoKardex(datOtrosMovInventarioTmp.getConceptoKardex()
                                                                                       .getNombre());
                } else {
                    datOtrosMovInventarioDTO2.setNomConceptoKardex(null);
                }
                

                if (datOtrosMovInventarioTmp.getConceptoKardex() != null) {
                    datOtrosMovInventarioDTO2.setTipoMovimiento(datOtrosMovInventarioTmp.getConceptoKardex()
                                                                                       .getTipoMovimiento());
                } else {
                    datOtrosMovInventarioDTO2.setTipoMovimiento(null);
                }
                
                if (datOtrosMovInventarioTmp.getCategoria() != null) {
                	datOtrosMovInventarioDTO2.setCategoria(datOtrosMovInventarioTmp.getCategoria()
                                                                             );
                } else {
                	datOtrosMovInventarioDTO2.setCategoria(null);
                }
                datOtrosMovInventarioDTO2.setCentCostId((datOtrosMovInventarioTmp.getCentCostId() != null)
						? datOtrosMovInventarioTmp.getCentCostId()
						: null);
                
          
                datOtrosMovInventarioDTO.add(datOtrosMovInventarioDTO2);
            }

            return datOtrosMovInventarioDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public DatOtrosMovInventario getDatOtrosMovInventario(
        Long datOtrosMovInventarioId) throws Exception {
        log.debug("getting DatOtrosMovInventario instance");

        DatOtrosMovInventario entity = null;

        try {
            entity = datOtrosMovInventarioDAO.findById(datOtrosMovInventarioId);
        } catch (Exception e) {
            log.error("get DatOtrosMovInventario failed", e);
            throw new ZMessManager().new FindingException(
                "DatOtrosMovInventario");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<DatOtrosMovInventario> findPageDatOtrosMovInventario(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        List<DatOtrosMovInventario> entity = null;

        try {
            entity = datOtrosMovInventarioDAO.findPage(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatOtrosMovInventario Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberDatOtrosMovInventario()
        throws Exception {
        Long entity = null;

        try {
            entity = datOtrosMovInventarioDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatOtrosMovInventario Count");
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
    public List<DatOtrosMovInventario> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<DatOtrosMovInventario> list = new ArrayList<DatOtrosMovInventario>();
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
            list = datOtrosMovInventarioDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
