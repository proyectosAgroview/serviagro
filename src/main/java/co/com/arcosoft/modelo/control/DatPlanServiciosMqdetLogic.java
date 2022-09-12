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

import co.com.arcosoft.dataaccess.dao.IDatPlanServiciosMqdetDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatPlanServiciosMqdet;
import co.com.arcosoft.modelo.dto.DatPlanServiciosMqdetDTO;
import co.com.arcosoft.utilities.Utilities;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("DatPlanServiciosMqdetLogic")
public class DatPlanServiciosMqdetLogic implements IDatPlanServiciosMqdetLogic {
    private static final Logger log = LoggerFactory.getLogger(DatPlanServiciosMqdetLogic.class);

    /**
     * DAO injected by Spring that manages DatPlanServiciosMqdet entities
     *
     */
    @Autowired
    private IDatPlanServiciosMqdetDAO datPlanServiciosMqdetDAO;

    /**
    * Logic injected by Spring that manages DatPlanServiciosMq entities
    *
    */
    @Autowired
    IDatPlanServiciosMqLogic logicDatPlanServiciosMq1;

    /**
    * Logic injected by Spring that manages Equipo entities
    *
    */
    @Autowired
    IEquipoLogic logicEquipo2;

    /**
    * Logic injected by Spring that manages Labor entities
    *
    */
    @Autowired
    ILaborLogic logicLabor3;

    /**
    * Logic injected by Spring that manages Nivel2Clientesmq entities
    *
    */
    @Autowired
    INivel2ClientesmqLogic logicNivel2Clientesmq4;

    /**
    * Logic injected by Spring that manages PersEmpr entities
    *
    */
    @Autowired
    IPersEmprLogic logicPersEmpr5;

    /**
    * Logic injected by Spring that manages UdadMed entities
    *
    */
    @Autowired
    IUdadMedLogic logicUdadMed6;

    @Transactional(readOnly = true)
    public List<DatPlanServiciosMqdet> getDatPlanServiciosMqdet()
        throws Exception {
        log.debug("finding all DatPlanServiciosMqdet instances");

        List<DatPlanServiciosMqdet> list = new ArrayList<DatPlanServiciosMqdet>();

        try {
            list = datPlanServiciosMqdetDAO.findAll();
        } catch (Exception e) {
            log.error("finding all DatPlanServiciosMqdet failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "DatPlanServiciosMqdet");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveDatPlanServiciosMqdet(DatPlanServiciosMqdet entity)
        throws Exception {
        log.debug("saving DatPlanServiciosMqdet instance");

        try {
            if (entity.getDatPlanServiciosMq() == null) {
                throw new ZMessManager().new ForeignException(
                    "datPlanServiciosMq");
            }

           


            if ((entity.getConcluido() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getConcluido(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "concluido");
            }

            if ((entity.getDetalleNota() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDetalleNota(), 1000) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "detalleNota");
            }

            if ((entity.getNivel4mqTexto() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getNivel4mqTexto(), 1000) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "nivel4mqTexto");
            }


            if (entity.getDatPlanServiciosMq().getDatPlanServiciosMqId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "datPlanServiciosMqId_DatPlanServiciosMq");
            }

         
          
         

            datPlanServiciosMqdetDAO.save(entity);

            log.debug("save DatPlanServiciosMqdet successful");
        } catch (Exception e) {
            log.error("save DatPlanServiciosMqdet failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteDatPlanServiciosMqdet(DatPlanServiciosMqdet entity)
        throws Exception {
        log.debug("deleting DatPlanServiciosMqdet instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion(
                "DatPlanServiciosMqdet");
        }

        if (entity.getDatPlanServiciosMqdetId() == null) {
            throw new ZMessManager().new EmptyFieldException(
                "datPlanServiciosMqdetId");
        }

        try {
            datPlanServiciosMqdetDAO.delete(entity);

            log.debug("delete DatPlanServiciosMqdet successful");
        } catch (Exception e) {
            log.error("delete DatPlanServiciosMqdet failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateDatPlanServiciosMqdet(DatPlanServiciosMqdet entity)
        throws Exception {
        log.debug("updating DatPlanServiciosMqdet instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "DatPlanServiciosMqdet");
            }

            if (entity.getDatPlanServiciosMq() == null) {
                throw new ZMessManager().new ForeignException(
                    "datPlanServiciosMq");
            }

          



            if ((entity.getConcluido() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getConcluido(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "concluido");
            }

            if ((entity.getDetalleNota() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDetalleNota(), 1000) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "detalleNota");
            }

            if ((entity.getNivel4mqTexto() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getNivel4mqTexto(), 1000) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "nivel4mqTexto");
            }

            if (entity.getDatPlanServiciosMq().getDatPlanServiciosMqId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "datPlanServiciosMqId_DatPlanServiciosMq");
            }


            datPlanServiciosMqdetDAO.update(entity);

            log.debug("update DatPlanServiciosMqdet successful");
        } catch (Exception e) {
            log.error("update DatPlanServiciosMqdet failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<DatPlanServiciosMqdetDTO> getDataDatPlanServiciosMqdet()
        throws Exception {
        try {
            List<DatPlanServiciosMqdet> datPlanServiciosMqdet = datPlanServiciosMqdetDAO.findAll();

            List<DatPlanServiciosMqdetDTO> datPlanServiciosMqdetDTO = new ArrayList<DatPlanServiciosMqdetDTO>();

            for (DatPlanServiciosMqdet datPlanServiciosMqdetTmp : datPlanServiciosMqdet) {
                DatPlanServiciosMqdetDTO datPlanServiciosMqdetDTO2 = new DatPlanServiciosMqdetDTO();

                datPlanServiciosMqdetDTO2.setDatPlanServiciosMqdetId(datPlanServiciosMqdetTmp.getDatPlanServiciosMqdetId());
                datPlanServiciosMqdetDTO2.setCantidadPlan((datPlanServiciosMqdetTmp.getCantidadPlan() != null)
                    ? datPlanServiciosMqdetTmp.getCantidadPlan() : null);
                datPlanServiciosMqdetDTO2.setCantidadRealizada((datPlanServiciosMqdetTmp.getCantidadRealizada() != null)
                        ? datPlanServiciosMqdetTmp.getCantidadRealizada() : null);
                    
                datPlanServiciosMqdetDTO2.setCantidadPendiente((datPlanServiciosMqdetTmp.getCantidadPendiente() != null)
                        ? datPlanServiciosMqdetTmp.getCantidadPendiente() : null);
                    
                
                datPlanServiciosMqdetDTO2.setFacturado((datPlanServiciosMqdetTmp.getFacturado() != null)
                        ? datPlanServiciosMqdetTmp.getFacturado() : null);
                
                datPlanServiciosMqdetDTO2.setConcluido((datPlanServiciosMqdetTmp.getConcluido() != null)
                    ? datPlanServiciosMqdetTmp.getConcluido() : null);
                datPlanServiciosMqdetDTO2.setDetalleNota((datPlanServiciosMqdetTmp.getDetalleNota() != null)
                    ? datPlanServiciosMqdetTmp.getDetalleNota() : null);
                datPlanServiciosMqdetDTO2.setNivel4mqTexto((datPlanServiciosMqdetTmp.getNivel4mqTexto() != null)
                    ? datPlanServiciosMqdetTmp.getNivel4mqTexto() : null);
                datPlanServiciosMqdetDTO2.setValorEstTotal((datPlanServiciosMqdetTmp.getValorEstTotal() != null)
                    ? datPlanServiciosMqdetTmp.getValorEstTotal() : null);
                datPlanServiciosMqdetDTO2.setValorEstUnitario((datPlanServiciosMqdetTmp.getValorEstUnitario() != null)
                    ? datPlanServiciosMqdetTmp.getValorEstUnitario() : null);
                datPlanServiciosMqdetDTO2.setDatPlanServiciosMqId_DatPlanServiciosMq((datPlanServiciosMqdetTmp.getDatPlanServiciosMq()
                                                                                                              .getDatPlanServiciosMqId() != null)
                    ? datPlanServiciosMqdetTmp.getDatPlanServiciosMq()
                                              .getDatPlanServiciosMqId() : null);

                
                
                if (datPlanServiciosMqdetTmp.getNivel2Clientesmq() != null) {
                    datPlanServiciosMqdetDTO2.setNivel2ClientesmqId_Nivel2Clientesmq(datPlanServiciosMqdetTmp.getNivel2Clientesmq()
                                                                                         );
                } else {
                    datPlanServiciosMqdetDTO2.setNivel2ClientesmqId_Nivel2Clientesmq(null);
                }
                
                if (datPlanServiciosMqdetTmp.getNivel2Clientesmq() != null) {
                    datPlanServiciosMqdetDTO2.setNombreHacienda(datPlanServiciosMqdetTmp.getNivel2Clientesmq().getNombre()
                                                                                         );
                } else {
                    datPlanServiciosMqdetDTO2.setNombreHacienda(null);
                }
                
                if (datPlanServiciosMqdetTmp.getNivel4ClientesmqId() != null) {
                    datPlanServiciosMqdetDTO2.setNivel4ClientesmqId(datPlanServiciosMqdetTmp.getNivel4ClientesmqId()
                                                                                         );
                } else {
                    datPlanServiciosMqdetDTO2.setNivel4ClientesmqId(null);
                }
                
                if (datPlanServiciosMqdetTmp.getNivel4ClientesmqId() != null) {
                    datPlanServiciosMqdetDTO2.setCodigoLote(datPlanServiciosMqdetTmp.getNivel4ClientesmqId().getCodigo()
                                                                                         );
                } else {
                    datPlanServiciosMqdetDTO2.setCodigoLote(null);
                }
                 
              
                if (datPlanServiciosMqdetTmp.getEquipo() != null) {
                    datPlanServiciosMqdetDTO2.setEquipoId_Equipo(datPlanServiciosMqdetTmp.getEquipo()
                                                                                         );
                } else {
                    datPlanServiciosMqdetDTO2.setEquipoId_Equipo(null);
                }
                
                if (datPlanServiciosMqdetTmp.getEquipo() != null) {
                    datPlanServiciosMqdetDTO2.setCodigoEquipo(datPlanServiciosMqdetTmp.getEquipo().getCodigo()
                                                                                         );
                } else {
                    datPlanServiciosMqdetDTO2.setCodigoEquipo(null);
                }

                

                if (datPlanServiciosMqdetTmp.getLabor() != null) {
                    datPlanServiciosMqdetDTO2.setLaborId_Labor(datPlanServiciosMqdetTmp.getLabor()
                                                                                       );
                } else {
                    datPlanServiciosMqdetDTO2.setLaborId_Labor(null);
                }
                
                if (datPlanServiciosMqdetTmp.getLabor() != null) {
                    datPlanServiciosMqdetDTO2.setNombreLabor(datPlanServiciosMqdetTmp.getLabor().getNombre()
                                                                                       );
                } else {
                    datPlanServiciosMqdetDTO2.setNombreLabor(null);
                }
                

                if (datPlanServiciosMqdetTmp.getPersEmpr() != null) {
                    datPlanServiciosMqdetDTO2.setPersEmprId_PersEmpr(datPlanServiciosMqdetTmp.getPersEmpr()
                                                                                       );
                } else {
                    datPlanServiciosMqdetDTO2.setPersEmprId_PersEmpr(null);
                }
                
                if (datPlanServiciosMqdetTmp.getPersEmpr() != null) {
                    datPlanServiciosMqdetDTO2.setNombreCliente(datPlanServiciosMqdetTmp.getPersEmpr().getNombre()
                                                                                       );
                } else {
                    datPlanServiciosMqdetDTO2.setNombreCliente(null);
                }
                
                if (datPlanServiciosMqdetTmp.getUdadMed() != null) {
                    datPlanServiciosMqdetDTO2.setUdadMedId_UdadMed(datPlanServiciosMqdetTmp.getUdadMed()
                                                                                       );
                } else {
                    datPlanServiciosMqdetDTO2.setUdadMedId_UdadMed(null);
                }
                
                if (datPlanServiciosMqdetTmp.getUdadMed() != null) {
                    datPlanServiciosMqdetDTO2.setNombreUdadMed(datPlanServiciosMqdetTmp.getUdadMed().getNombre()
                                                                                       );
                } else {
                    datPlanServiciosMqdetDTO2.setNombreUdadMed(null);
                }
                
                
                if (datPlanServiciosMqdetTmp.getCantidadPresupuesto() != null) {
                    datPlanServiciosMqdetDTO2.setCantidadPresupuesto(datPlanServiciosMqdetTmp.getCantidadPresupuesto()
                                                                                         );
                } else {
                    datPlanServiciosMqdetDTO2.setCantidadPresupuesto(null);
                }
                
                
                datPlanServiciosMqdetDTO.add(datPlanServiciosMqdetDTO2);
            }

            return datPlanServiciosMqdetDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public DatPlanServiciosMqdet getDatPlanServiciosMqdet(
        Long datPlanServiciosMqdetId) throws Exception {
        log.debug("getting DatPlanServiciosMqdet instance");

        DatPlanServiciosMqdet entity = null;

        try {
            entity = datPlanServiciosMqdetDAO.findById(datPlanServiciosMqdetId);
        } catch (Exception e) {
            log.error("get DatPlanServiciosMqdet failed", e);
            throw new ZMessManager().new FindingException(
                "DatPlanServiciosMqdet");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<DatPlanServiciosMqdet> findPageDatPlanServiciosMqdet(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        List<DatPlanServiciosMqdet> entity = null;

        try {
            entity = datPlanServiciosMqdetDAO.findPage(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatPlanServiciosMqdet Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberDatPlanServiciosMqdet()
        throws Exception {
        Long entity = null;

        try {
            entity = datPlanServiciosMqdetDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatPlanServiciosMqdet Count");
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
    public List<DatPlanServiciosMqdet> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<DatPlanServiciosMqdet> list = new ArrayList<DatPlanServiciosMqdet>();
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
            list = datPlanServiciosMqdetDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
    

    @Transactional(readOnly = true)
    public List<DatPlanServiciosMqdetDTO> getDataDatPlanServiciosMqdetByPlan(Long datPlanServiciosMqId)
        throws Exception {
        try {
        	
        	   List<DatPlanServiciosMqdet> datPlanServiciosMqdet = datPlanServiciosMqdetDAO
   					.findByCriteria("datPlanServiciosMq.datPlanServiciosMqId= " + datPlanServiciosMqId);
   			
   			
            List<DatPlanServiciosMqdetDTO> datPlanServiciosMqdetDTO = new ArrayList<DatPlanServiciosMqdetDTO>();

            for (DatPlanServiciosMqdet datPlanServiciosMqdetTmp : datPlanServiciosMqdet) {
                DatPlanServiciosMqdetDTO datPlanServiciosMqdetDTO2 = new DatPlanServiciosMqdetDTO();

                datPlanServiciosMqdetDTO2.setDatPlanServiciosMqdetId(datPlanServiciosMqdetTmp.getDatPlanServiciosMqdetId());
                datPlanServiciosMqdetDTO2.setCantidadPlan((datPlanServiciosMqdetTmp.getCantidadPlan() != null)
                    ? datPlanServiciosMqdetTmp.getCantidadPlan() : null);
                
                
                datPlanServiciosMqdetDTO2.setCantidadRealizada((datPlanServiciosMqdetTmp.getCantidadRealizada() != null)
                        ? datPlanServiciosMqdetTmp.getCantidadRealizada() : null);
                    
                datPlanServiciosMqdetDTO2.setCantidadPendiente((datPlanServiciosMqdetTmp.getCantidadPendiente() != null)
                        ? datPlanServiciosMqdetTmp.getCantidadPendiente() : null);
                    
                
                datPlanServiciosMqdetDTO2.setFacturado((datPlanServiciosMqdetTmp.getFacturado() != null)
                        ? datPlanServiciosMqdetTmp.getFacturado() : null);
                    
                
                datPlanServiciosMqdetDTO2.setConcluido((datPlanServiciosMqdetTmp.getConcluido() != null)
                    ? datPlanServiciosMqdetTmp.getConcluido() : null);
                datPlanServiciosMqdetDTO2.setDetalleNota((datPlanServiciosMqdetTmp.getDetalleNota() != null)
                    ? datPlanServiciosMqdetTmp.getDetalleNota() : null);
                datPlanServiciosMqdetDTO2.setNivel4mqTexto((datPlanServiciosMqdetTmp.getNivel4mqTexto() != null)
                    ? datPlanServiciosMqdetTmp.getNivel4mqTexto() : null);
                datPlanServiciosMqdetDTO2.setValorEstTotal((datPlanServiciosMqdetTmp.getValorEstTotal() != null)
                    ? datPlanServiciosMqdetTmp.getValorEstTotal() : null);
                datPlanServiciosMqdetDTO2.setValorEstUnitario((datPlanServiciosMqdetTmp.getValorEstUnitario() != null)
                    ? datPlanServiciosMqdetTmp.getValorEstUnitario() : null);
                datPlanServiciosMqdetDTO2.setDatPlanServiciosMqId_DatPlanServiciosMq((datPlanServiciosMqdetTmp.getDatPlanServiciosMq()
                                                                                                              .getDatPlanServiciosMqId() != null)
                    ? datPlanServiciosMqdetTmp.getDatPlanServiciosMq()
                                              .getDatPlanServiciosMqId() : null);

                
                datPlanServiciosMqdetDTO2.setCantidadPlan((datPlanServiciosMqdetTmp.getCantidadPlan() != null)
                        ? datPlanServiciosMqdetTmp.getCantidadPlan() : null);
                 
                datPlanServiciosMqdetDTO2.setAreaProgramada((datPlanServiciosMqdetTmp.getAreaProgramada() != null)
                        ? datPlanServiciosMqdetTmp.getAreaProgramada() : null);
              
                
                if (datPlanServiciosMqdetTmp.getNivel2Clientesmq() != null) {
                    datPlanServiciosMqdetDTO2.setNivel2ClientesmqId_Nivel2Clientesmq(datPlanServiciosMqdetTmp.getNivel2Clientesmq()
                                                                                         );
                } else {
                    datPlanServiciosMqdetDTO2.setNivel2ClientesmqId_Nivel2Clientesmq(null);
                }
                
                if (datPlanServiciosMqdetTmp.getNivel2Clientesmq() != null) {
                    datPlanServiciosMqdetDTO2.setNombreHacienda(datPlanServiciosMqdetTmp.getNivel2Clientesmq().getNombre()
                                                                                         );
                } else {
                    datPlanServiciosMqdetDTO2.setNombreHacienda(null);
                }
                
                if (datPlanServiciosMqdetTmp.getNivel4ClientesmqId() != null) {
                    datPlanServiciosMqdetDTO2.setNivel4ClientesmqId(datPlanServiciosMqdetTmp.getNivel4ClientesmqId()
                                                                                         );
                } else {
                    datPlanServiciosMqdetDTO2.setNivel4ClientesmqId(null);
                }
                
                if (datPlanServiciosMqdetTmp.getNivel4ClientesmqId() != null) {
                    datPlanServiciosMqdetDTO2.setCodigoLote(datPlanServiciosMqdetTmp.getNivel4ClientesmqId().getCodigo()
                                                                                         );
                } else {
                    datPlanServiciosMqdetDTO2.setCodigoLote(null);
                }
                 
              
                if (datPlanServiciosMqdetTmp.getEquipo() != null) {
                    datPlanServiciosMqdetDTO2.setEquipoId_Equipo(datPlanServiciosMqdetTmp.getEquipo()
                                                                                         );
                } else {
                    datPlanServiciosMqdetDTO2.setEquipoId_Equipo(null);
                }
                
                if (datPlanServiciosMqdetTmp.getEquipo() != null) {
                    datPlanServiciosMqdetDTO2.setCodigoEquipo(datPlanServiciosMqdetTmp.getEquipo().getCodigo()
                                                                                         );
                } else {
                    datPlanServiciosMqdetDTO2.setCodigoEquipo(null);
                }

                

                if (datPlanServiciosMqdetTmp.getLabor() != null) {
                    datPlanServiciosMqdetDTO2.setLaborId_Labor(datPlanServiciosMqdetTmp.getLabor()
                                                                                       );
                } else {
                    datPlanServiciosMqdetDTO2.setLaborId_Labor(null);
                }
                
                if (datPlanServiciosMqdetTmp.getLabor() != null) {
                    datPlanServiciosMqdetDTO2.setNombreLabor(datPlanServiciosMqdetTmp.getLabor().getNombre()
                                                                                       );
                } else {
                    datPlanServiciosMqdetDTO2.setNombreLabor(null);
                }
                

                if (datPlanServiciosMqdetTmp.getPersEmpr() != null) {
                    datPlanServiciosMqdetDTO2.setPersEmprId_PersEmpr(datPlanServiciosMqdetTmp.getPersEmpr()
                                                                                       );
                } else {
                    datPlanServiciosMqdetDTO2.setPersEmprId_PersEmpr(null);
                }
                
                if (datPlanServiciosMqdetTmp.getPersEmpr() != null) {
                    datPlanServiciosMqdetDTO2.setNombreCliente(datPlanServiciosMqdetTmp.getPersEmpr().getNombre()
                                                                                       );
                } else {
                    datPlanServiciosMqdetDTO2.setNombreCliente(null);
                }
                
                if (datPlanServiciosMqdetTmp.getUdadMed() != null) {
                    datPlanServiciosMqdetDTO2.setUdadMedId_UdadMed(datPlanServiciosMqdetTmp.getUdadMed()
                                                                                       );
                } else {
                    datPlanServiciosMqdetDTO2.setUdadMedId_UdadMed(null);
                }
                
                if (datPlanServiciosMqdetTmp.getUdadMed() != null) {
                    datPlanServiciosMqdetDTO2.setNombreUdadMed(datPlanServiciosMqdetTmp.getUdadMed().getNombre()
                                                                                       );
                } else {
                    datPlanServiciosMqdetDTO2.setNombreUdadMed(null);
                }
                


                if (datPlanServiciosMqdetTmp.getOperario() != null) {
                    datPlanServiciosMqdetDTO2.setOperario(datPlanServiciosMqdetTmp.getOperario()
                                                                                         );
                } else {
                    datPlanServiciosMqdetDTO2.setOperario(null);
                }
                
                if (datPlanServiciosMqdetTmp.getOperario() != null) {
                    datPlanServiciosMqdetDTO2.setCodOperario(datPlanServiciosMqdetTmp.getOperario().getNombre()
                                                                                         );
                } else {
                    datPlanServiciosMqdetDTO2.setCodOperario(null);
                }
                
                
                if (datPlanServiciosMqdetTmp.getNumPases() != null) {
                    datPlanServiciosMqdetDTO2.setNumPases(datPlanServiciosMqdetTmp.getNumPases()
                                                                                         );
                } else {
                    datPlanServiciosMqdetDTO2.setNumPases(null);
                }
                
                if (datPlanServiciosMqdetTmp.getPeriodoInicial() != null) {
                    datPlanServiciosMqdetDTO2.setPeriodoInicial(datPlanServiciosMqdetTmp.getPeriodoInicial()
                                                                                         );
                } else {
                    datPlanServiciosMqdetDTO2.setPeriodoInicial(null);
                }
                
                if (datPlanServiciosMqdetTmp.getCantidadPresupuesto() != null) {
                    datPlanServiciosMqdetDTO2.setCantidadPresupuesto(datPlanServiciosMqdetTmp.getCantidadPresupuesto()
                                                                                         );
                } else {
                    datPlanServiciosMqdetDTO2.setCantidadPresupuesto(null);
                }
                
                
                datPlanServiciosMqdetDTO.add(datPlanServiciosMqdetDTO2);
            }

            return datPlanServiciosMqdetDTO;
        } catch (Exception e) {
            throw e;
        }
    }

}
