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

import co.com.arcosoft.dataaccess.dao.IDatServRealizadosEquipoDetDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatServRealizadosEquipoDet;
import co.com.arcosoft.modelo.dto.DatServRealizadosEquipoDetDTO;
import co.com.arcosoft.utilities.Utilities;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("DatServRealizadosEquipoDetLogic")
public class DatServRealizadosEquipoDetLogic
    implements IDatServRealizadosEquipoDetLogic {
    private static final Logger log = LoggerFactory.getLogger(DatServRealizadosEquipoDetLogic.class);

    /**
     * DAO injected by Spring that manages DatServRealizadosEquipoDet entities
     *
     */
    @Autowired
    private IDatServRealizadosEquipoDetDAO datServRealizadosEquipoDetDAO;

    /**
    * Logic injected by Spring that manages Labor entities
    *
    */
    @Autowired
    ILaborLogic logicLabor1;

    /**
    * Logic injected by Spring that manages UdadMed entities
    *
    */
    @Autowired
    IUdadMedLogic logicUdadMed2;

    @Transactional(readOnly = true)
    public List<DatServRealizadosEquipoDet> getDatServRealizadosEquipoDet()
        throws Exception {
        log.debug("finding all DatServRealizadosEquipoDet instances");

        List<DatServRealizadosEquipoDet> list = new ArrayList<DatServRealizadosEquipoDet>();

        try {
            list = datServRealizadosEquipoDetDAO.findAll();
        } catch (Exception e) {
            log.error("finding all DatServRealizadosEquipoDet failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "DatServRealizadosEquipoDet");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveDatServRealizadosEquipoDet(
        DatServRealizadosEquipoDet entity) throws Exception {
        log.debug("saving DatServRealizadosEquipoDet instance");

        try {
            if (entity.getLabor() == null) {
                throw new ZMessManager().new ForeignException("labor");
            }

            if (entity.getUdadMed() == null) {
                throw new ZMessManager().new ForeignException("udadMed");
            }

       

            if ((entity.getHorometroFinal() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getHorometroFinal(),12,4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "horometroFinal");
            }

            if ((entity.getHorometroInicial() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getHorometroInicial(),12,4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "horometroInicial");
            }

          
        
            if ((entity.getValorUnitario() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorUnitario(),12,4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorUnitario");
            }

            if (entity.getLabor().getLaborId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "laborId_Labor");
            }

            if (entity.getUdadMed().getUdadMedId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "udadMedId_UdadMed");
            }


            datServRealizadosEquipoDetDAO.save(entity);

            log.debug("save DatServRealizadosEquipoDet successful");
        } catch (Exception e) {
            log.error("save DatServRealizadosEquipoDet failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteDatServRealizadosEquipoDet(
        DatServRealizadosEquipoDet entity) throws Exception {
        log.debug("deleting DatServRealizadosEquipoDet instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion(
                "DatServRealizadosEquipoDet");
        }

        if (entity.getDatServRealizadosEquipoDetId() == null) {
            throw new ZMessManager().new EmptyFieldException(
                "datServRealizadosEquipoDetId");
        }

        try {
            datServRealizadosEquipoDetDAO.delete(entity);

            log.debug("delete DatServRealizadosEquipoDet successful");
        } catch (Exception e) {
            log.error("delete DatServRealizadosEquipoDet failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateDatServRealizadosEquipoDet(
        DatServRealizadosEquipoDet entity) throws Exception {
        log.debug("updating DatServRealizadosEquipoDet instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "DatServRealizadosEquipoDet");
            }

         

          
            if ((entity.getHorometroFinal() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getHorometroFinal(),12,4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "horometroFinal");
            }

            if ((entity.getHorometroInicial() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getHorometroInicial(),12,4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "horometroInicial");
            }

        

            if ((entity.getValorUnitario() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorUnitario(),12,4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorUnitario");
            }

            

            datServRealizadosEquipoDetDAO.update(entity);

            log.debug("update DatServRealizadosEquipoDet successful");
        } catch (Exception e) {
            log.error("update DatServRealizadosEquipoDet failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<DatServRealizadosEquipoDetDTO> getDataDatServRealizadosEquipoDet()
        throws Exception {
        try {
            List<DatServRealizadosEquipoDet> datServRealizadosEquipoDet = datServRealizadosEquipoDetDAO.findAll();

            List<DatServRealizadosEquipoDetDTO> datServRealizadosEquipoDetDTO = new ArrayList<DatServRealizadosEquipoDetDTO>();

            for (DatServRealizadosEquipoDet datServRealizadosEquipoDetTmp : datServRealizadosEquipoDet) {
                DatServRealizadosEquipoDetDTO datServRealizadosEquipoDetDTO2 = new DatServRealizadosEquipoDetDTO();

                datServRealizadosEquipoDetDTO2.setDatServRealizadosEquipoDetId(datServRealizadosEquipoDetTmp.getDatServRealizadosEquipoDetId());
               
                datServRealizadosEquipoDetDTO2.setHoraFinal(datServRealizadosEquipoDetTmp.getHoraFinal());
                datServRealizadosEquipoDetDTO2.setHoraInicial(datServRealizadosEquipoDetTmp.getHoraInicial());
                datServRealizadosEquipoDetDTO2.setHorasTotal((datServRealizadosEquipoDetTmp.getHorasTotal() != null)
                    ? datServRealizadosEquipoDetTmp.getHorasTotal() : null);
                datServRealizadosEquipoDetDTO2.setHorometroFinal((datServRealizadosEquipoDetTmp.getHorometroFinal() != null)
                    ? datServRealizadosEquipoDetTmp.getHorometroFinal() : null);
                datServRealizadosEquipoDetDTO2.setHorometroInicial((datServRealizadosEquipoDetTmp.getHorometroInicial() != null)
                    ? datServRealizadosEquipoDetTmp.getHorometroInicial() : null);
                datServRealizadosEquipoDetDTO2.setHorometroTotal((datServRealizadosEquipoDetTmp.getHorometroTotal() != null)
                    ? datServRealizadosEquipoDetTmp.getHorometroTotal() : null);
                datServRealizadosEquipoDetDTO2.setIngresoTotal((datServRealizadosEquipoDetTmp.getIngresoTotal() != null)
                    ? datServRealizadosEquipoDetTmp.getIngresoTotal() : null);
                datServRealizadosEquipoDetDTO2.setValorUnitario((datServRealizadosEquipoDetTmp.getValorUnitario() != null)
                    ? datServRealizadosEquipoDetTmp.getValorUnitario() : null);

                if (datServRealizadosEquipoDetTmp.getLabor() != null) {
                    datServRealizadosEquipoDetDTO2.setLaborId_Labor(datServRealizadosEquipoDetTmp.getLabor()
                                                                                                 );
                } else {
                    datServRealizadosEquipoDetDTO2.setLaborId_Labor(null);
                }

                datServRealizadosEquipoDetDTO2.setUdadMedId_UdadMed((datServRealizadosEquipoDetTmp.getUdadMed()
                                                                                                   != null)
                    ? datServRealizadosEquipoDetTmp.getUdadMed()
                    : null);
                
               
                datServRealizadosEquipoDetDTO2.setAuxilioTransporte((datServRealizadosEquipoDetTmp.getAuxilioTransporte() != null)
                        ? datServRealizadosEquipoDetTmp.getAuxilioTransporte() : null);


                datServRealizadosEquipoDetDTO2.setEstadoFactura((datServRealizadosEquipoDetTmp.getEstadoFactura() != null)
                        ? datServRealizadosEquipoDetTmp.getEstadoFactura() : null);
                
                datServRealizadosEquipoDetDTO2.setTipoMttoTexto((datServRealizadosEquipoDetTmp.getTipoMttoTexto() != null)
                        ? datServRealizadosEquipoDetTmp.getTipoMttoTexto() : null);
              
                datServRealizadosEquipoDetDTO2.setHorometroMtto((datServRealizadosEquipoDetTmp.getHorometroMtto() != null)
                        ? datServRealizadosEquipoDetTmp.getHorometroMtto() : null);
                

                datServRealizadosEquipoDetDTO.add(datServRealizadosEquipoDetDTO2);
            }

            return datServRealizadosEquipoDetDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public DatServRealizadosEquipoDet getDatServRealizadosEquipoDet(
        Long datServRealizadosEquipoDetId) throws Exception {
        log.debug("getting DatServRealizadosEquipoDet instance");

        DatServRealizadosEquipoDet entity = null;

        try {
            entity = datServRealizadosEquipoDetDAO.findById(datServRealizadosEquipoDetId);
        } catch (Exception e) {
            log.error("get DatServRealizadosEquipoDet failed", e);
            throw new ZMessManager().new FindingException(
                "DatServRealizadosEquipoDet");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<DatServRealizadosEquipoDet> findPageDatServRealizadosEquipoDet(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        List<DatServRealizadosEquipoDet> entity = null;

        try {
            entity = datServRealizadosEquipoDetDAO.findPage(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatServRealizadosEquipoDet Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberDatServRealizadosEquipoDet()
        throws Exception {
        Long entity = null;

        try {
            entity = datServRealizadosEquipoDetDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatServRealizadosEquipoDet Count");
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
    public List<DatServRealizadosEquipoDet> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<DatServRealizadosEquipoDet> list = new ArrayList<DatServRealizadosEquipoDet>();
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
            list = datServRealizadosEquipoDetDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
    
    @Transactional(readOnly = true)
    public List<DatServRealizadosEquipoDetDTO> getDataDatServRealizadosEquipoDetByServ(Long datServId)
        throws Exception {
        try {

            List<DatServRealizadosEquipoDet> datServRealizadosEquipoDet = datServRealizadosEquipoDetDAO
					.findByCriteria("datServRealizadosEquipoId.datServRealizadosEquipoId= " + datServId);
									
			List<DatServRealizadosEquipoDetDTO> datServRealizadosEquipoDetDTO = new ArrayList<DatServRealizadosEquipoDetDTO>();
			
            for (DatServRealizadosEquipoDet datServRealizadosEquipoDetTmp : datServRealizadosEquipoDet) {
                DatServRealizadosEquipoDetDTO datServRealizadosEquipoDetDTO2 = new DatServRealizadosEquipoDetDTO();

                datServRealizadosEquipoDetDTO2.setDatServRealizadosEquipoDetId(datServRealizadosEquipoDetTmp.getDatServRealizadosEquipoDetId());
                datServRealizadosEquipoDetDTO2.setHoraFinal(datServRealizadosEquipoDetTmp.getHoraFinal());
                datServRealizadosEquipoDetDTO2.setHoraInicial(datServRealizadosEquipoDetTmp.getHoraInicial());
                datServRealizadosEquipoDetDTO2.setHorasTotal((datServRealizadosEquipoDetTmp.getHorasTotal() != null)
                    ? datServRealizadosEquipoDetTmp.getHorasTotal() : null);
                datServRealizadosEquipoDetDTO2.setCantidad((datServRealizadosEquipoDetTmp.getCantidad() != null)
                        ? datServRealizadosEquipoDetTmp.getCantidad() : null);
                datServRealizadosEquipoDetDTO2.setHorometroFinal((datServRealizadosEquipoDetTmp.getHorometroFinal() != null)
                    ? datServRealizadosEquipoDetTmp.getHorometroFinal() : null);
                datServRealizadosEquipoDetDTO2.setHorometroInicial((datServRealizadosEquipoDetTmp.getHorometroInicial() != null)
                    ? datServRealizadosEquipoDetTmp.getHorometroInicial() : null);
                datServRealizadosEquipoDetDTO2.setHorometroTotal((datServRealizadosEquipoDetTmp.getHorometroTotal() != null)
                    ? datServRealizadosEquipoDetTmp.getHorometroTotal() : null);
                datServRealizadosEquipoDetDTO2.setIngresoTotal((datServRealizadosEquipoDetTmp.getIngresoTotal() != null)
                    ? datServRealizadosEquipoDetTmp.getIngresoTotal() : null);
                datServRealizadosEquipoDetDTO2.setValorUnitario((datServRealizadosEquipoDetTmp.getValorUnitario() != null)
                    ? datServRealizadosEquipoDetTmp.getValorUnitario() : null);

              
                datServRealizadosEquipoDetDTO2.setTurno((datServRealizadosEquipoDetTmp.getTurno() != null)
                        ? datServRealizadosEquipoDetTmp.getTurno() : null);
               
                datServRealizadosEquipoDetDTO2.setBonificacionTrabajador((datServRealizadosEquipoDetTmp.getBonificacionTrabajador() != null)
                        ? datServRealizadosEquipoDetTmp.getBonificacionTrabajador() : null);
                
                
                if (datServRealizadosEquipoDetTmp.getConceptoNominaId() != null) {
                    datServRealizadosEquipoDetDTO2.setConceptoNominaId(datServRealizadosEquipoDetTmp.getConceptoNominaId()
                                                                                                 );
                } else {
                    datServRealizadosEquipoDetDTO2.setConceptoNominaId(null);
                }
                
                if (datServRealizadosEquipoDetTmp.getConceptoNominaId() != null) {
                    datServRealizadosEquipoDetDTO2.setNomConceptoNomina(datServRealizadosEquipoDetTmp.getConceptoNominaId().getNombre()
                                                                                                 );
                } else {
                    datServRealizadosEquipoDetDTO2.setNomConceptoNomina(null);
                }
                
                
                if (datServRealizadosEquipoDetTmp.getPersEmpr() != null) {
                    datServRealizadosEquipoDetDTO2.setPersEmpr(datServRealizadosEquipoDetTmp.getPersEmpr()
                                                                                                 );
                } else {
                    datServRealizadosEquipoDetDTO2.setPersEmpr(null);
                }
                
                if (datServRealizadosEquipoDetTmp.getImplemento() != null) {
                    datServRealizadosEquipoDetDTO2.setImplemento(datServRealizadosEquipoDetTmp.getImplemento()
                                                                                                 );
                } else {
                    datServRealizadosEquipoDetDTO2.setImplemento(null);
                }
                
               
                
                if (datServRealizadosEquipoDetTmp.getTrabajador() != null) {
                    datServRealizadosEquipoDetDTO2.setTrabajador(datServRealizadosEquipoDetTmp.getTrabajador()
                                                                                                 );
                } else {
                    datServRealizadosEquipoDetDTO2.setTrabajador(null);
                }
                
                if (datServRealizadosEquipoDetTmp.getNivel2ClientesId() != null) {
                    datServRealizadosEquipoDetDTO2.setNivel2ClientesId(datServRealizadosEquipoDetTmp.getNivel2ClientesId()
                                                                                                 );
                } else {
                    datServRealizadosEquipoDetDTO2.setNivel2ClientesId(null);
                }
                
                
             
                if (datServRealizadosEquipoDetTmp.getPersEmpr() != null) {
                    datServRealizadosEquipoDetDTO2.setNomCliente(datServRealizadosEquipoDetTmp.getPersEmpr().getNombre()
                                                                                                 );
                } else {
                    datServRealizadosEquipoDetDTO2.setNomCliente(null);
                }
                
                if (datServRealizadosEquipoDetTmp.getImplemento() != null) {
                    datServRealizadosEquipoDetDTO2.setCodImplemento(datServRealizadosEquipoDetTmp.getImplemento().getCodigo()
                                                                                                 );
                } else {
                    datServRealizadosEquipoDetDTO2.setCodImplemento(null);
                }
                
               
                
                if (datServRealizadosEquipoDetTmp.getTrabajador() != null) {
                    datServRealizadosEquipoDetDTO2.setCodTrabajador(datServRealizadosEquipoDetTmp.getTrabajador().getNombre()
                                                                                                 );
                } else {
                    datServRealizadosEquipoDetDTO2.setCodTrabajador(null);
                }
                
                if (datServRealizadosEquipoDetTmp.getNivel2ClientesId() != null) {
                    datServRealizadosEquipoDetDTO2.setNomNivel2ClientesId(datServRealizadosEquipoDetTmp.getNivel2ClientesId().getNombre()
                                                                                                 );
                } else {
                    datServRealizadosEquipoDetDTO2.setNomNivel2ClientesId(null);
                }
                
                
                if (datServRealizadosEquipoDetTmp.getLabor() != null) {
                    datServRealizadosEquipoDetDTO2.setLaborId_Labor(datServRealizadosEquipoDetTmp.getLabor()
                                                                                                 );
                } else {
                    datServRealizadosEquipoDetDTO2.setLaborId_Labor(null);
                }

                if (datServRealizadosEquipoDetTmp.getLabor() != null) {
                    datServRealizadosEquipoDetDTO2.setNombreLabor(datServRealizadosEquipoDetTmp.getLabor()
                                                                                                 .getNombre());
                } else {
                    datServRealizadosEquipoDetDTO2.setNombreLabor(null);
                }

                
                datServRealizadosEquipoDetDTO2.setUdadMedId_UdadMed((datServRealizadosEquipoDetTmp.getUdadMed()
                                                                                                   != null)
                    ? datServRealizadosEquipoDetTmp.getUdadMed()
                    : null);
                
                if (datServRealizadosEquipoDetTmp.getUdadMed() != null) {
                    datServRealizadosEquipoDetDTO2.setNombreUdadMed(datServRealizadosEquipoDetTmp.getUdadMed()
                                                                                                 .getNombre());
                } else {
                    datServRealizadosEquipoDetDTO2.setNombreUdadMed(null);
                }

                if (datServRealizadosEquipoDetTmp.getNivel2Id() != null) {
                    datServRealizadosEquipoDetDTO2.setNivel2(datServRealizadosEquipoDetTmp.getNivel2Id()
                                                                                                 );
                } else {
                    datServRealizadosEquipoDetDTO2.setNivel2(null);
                }

                if (datServRealizadosEquipoDetTmp.getNivel4() != null) {
                    datServRealizadosEquipoDetDTO2.setNivel4(datServRealizadosEquipoDetTmp.getNivel4()
                                                                                                 );
                } else {
                    datServRealizadosEquipoDetDTO2.setNivel4(null);
                }


                if (datServRealizadosEquipoDetTmp.getNivel2Id() != null) {
                    datServRealizadosEquipoDetDTO2.setNombreNivel2(datServRealizadosEquipoDetTmp.getNivel2Id().getNombre()
                                                                                                 );
                } else {
                    datServRealizadosEquipoDetDTO2.setNombreNivel2(null);
                }
/*
                if (datServRealizadosEquipoDetTmp.getNombreNivel4() != null) {
                    datServRealizadosEquipoDetDTO2.setNombreNivel4(datServRealizadosEquipoDetTmp.getNombreNivel4()
                                                                                                 );
                } else {
                    datServRealizadosEquipoDetDTO2.setNombreNivel4(null);
                }
*/
                
                if (datServRealizadosEquipoDetTmp.getNivel4ClientesId() != null) {
                    datServRealizadosEquipoDetDTO2.setNombreNivel4(datServRealizadosEquipoDetTmp.getNivel4ClientesId().getNombre()
                                                                                                 );
                } else {
                    datServRealizadosEquipoDetDTO2.setNombreNivel4(null);
                }
                
                
                if (datServRealizadosEquipoDetTmp.getNivel4ClientesId() != null) {
                    datServRealizadosEquipoDetDTO2.setNivel4ClientesId(datServRealizadosEquipoDetTmp.getNivel4ClientesId()
                                                                                                 );
                } else {
                    datServRealizadosEquipoDetDTO2.setNivel4ClientesId(null);
                }
                
                datServRealizadosEquipoDetDTO2.setFechaValidacion((datServRealizadosEquipoDetTmp.getFechaValidacion() != null)
                        ? datServRealizadosEquipoDetTmp.getFechaValidacion() : null);

                datServRealizadosEquipoDetDTO2.setUsuarioValidacion((datServRealizadosEquipoDetTmp.getUsuarioValidacion() != null)
                        ? datServRealizadosEquipoDetTmp.getUsuarioValidacion() : null);

                datServRealizadosEquipoDetDTO2.setEstadoFactura((datServRealizadosEquipoDetTmp.getEstadoFactura() != null)
                        ? datServRealizadosEquipoDetTmp.getEstadoFactura() : null);
                          

                datServRealizadosEquipoDetDTO2.setNumFactura((datServRealizadosEquipoDetTmp.getNumFactura() != null)
                        ? datServRealizadosEquipoDetTmp.getNumFactura() : null);
                
                
                datServRealizadosEquipoDetDTO2.setCantidadCombustible((datServRealizadosEquipoDetTmp.getCantidadCombustible() != null)
                        ? datServRealizadosEquipoDetTmp.getCantidadCombustible() : null);

                datServRealizadosEquipoDetDTO2.setSello((datServRealizadosEquipoDetTmp.getSello() != null)
                        ? datServRealizadosEquipoDetTmp.getSello() : null);
                
                if (datServRealizadosEquipoDetTmp.getProductoId() != null) {
                    datServRealizadosEquipoDetDTO2.setProductoId(datServRealizadosEquipoDetTmp.getProductoId()
                                                                                                 );
                } else {
                    datServRealizadosEquipoDetDTO2.setProductoId(null);
                }
                
                if (datServRealizadosEquipoDetTmp.getProductoId() != null) {
                    datServRealizadosEquipoDetDTO2.setCodProducto(datServRealizadosEquipoDetTmp.getProductoId().getCodigo()
                                                                                                 );
                } else {
                    datServRealizadosEquipoDetDTO2.setCodProducto(null);
                }
                
                if (datServRealizadosEquipoDetTmp.getAlmacenId() != null) {
                    datServRealizadosEquipoDetDTO2.setAlmacenId(datServRealizadosEquipoDetTmp.getAlmacenId()
                                                                                                 );
                } else {
                    datServRealizadosEquipoDetDTO2.setAlmacenId(null);
                }
                
                datServRealizadosEquipoDetDTO2.setCostoCombustible((datServRealizadosEquipoDetTmp.getCostoCombustible() != null)
                        ? datServRealizadosEquipoDetTmp.getCostoCombustible() : null);

                datServRealizadosEquipoDetDTO2.setAuxilioTransporte((datServRealizadosEquipoDetTmp.getAuxilioTransporte() != null)
                        ? datServRealizadosEquipoDetTmp.getAuxilioTransporte() : null);


                if (datServRealizadosEquipoDetTmp.getDat_plan_servicios_mqdet_id() != null) {
                    datServRealizadosEquipoDetDTO2.setDat_plan_servicios_mqdet_id(datServRealizadosEquipoDetTmp.getDat_plan_servicios_mqdet_id()
                                                                                                 );
                } else {
                    datServRealizadosEquipoDetDTO2.setDat_plan_servicios_mqdet_id(null);
                }
                

                if (datServRealizadosEquipoDetTmp.getDat_plan_servicios_mqdet_id() != null) {
                    datServRealizadosEquipoDetDTO2.setIdProgramaMaqDet(datServRealizadosEquipoDetTmp.getDat_plan_servicios_mqdet_id().getDatPlanServiciosMqdetId()
                                                                                                 );
                } else {
                    datServRealizadosEquipoDetDTO2.setIdProgramaMaqDet(null);
                }
                
                datServRealizadosEquipoDetDTO2.setValor_total_trabajador((datServRealizadosEquipoDetTmp.getValor_total_trabajador() != null)
                        ? datServRealizadosEquipoDetTmp.getValor_total_trabajador() : null);
                datServRealizadosEquipoDetDTO2.setValor_unitario_trabajador((datServRealizadosEquipoDetTmp.getValor_unitario_trabajador() != null)
                        ? datServRealizadosEquipoDetTmp.getValor_unitario_trabajador() : null);
              
                if (datServRealizadosEquipoDetTmp.getDatServRealizadosEquipoId() != null) {
                    datServRealizadosEquipoDetDTO2.setDatServRealizadosEquipoId(datServRealizadosEquipoDetTmp.getDatServRealizadosEquipoId().getDatServRealizadosEquipoId()
                                                                                                 );
                } else {
                    datServRealizadosEquipoDetDTO2.setDatServRealizadosEquipoId(null);
                }
                
                datServRealizadosEquipoDetDTO2.setObservacion((datServRealizadosEquipoDetTmp.getObservacion() != null)
                        ? datServRealizadosEquipoDetTmp.getObservacion() : null);
              
                datServRealizadosEquipoDetDTO2.setReportarNovedadParada((datServRealizadosEquipoDetTmp.getReportarNovedadParada() != null)
                        ? datServRealizadosEquipoDetTmp.getReportarNovedadParada() : null);
              
                datServRealizadosEquipoDetDTO2.setCantidadTrabajador((datServRealizadosEquipoDetTmp.getCantidadTrabajador() != null)
                        ? datServRealizadosEquipoDetTmp.getCantidadTrabajador() : null);
              
                datServRealizadosEquipoDetDTO2.setUnidadMedidaTrabajador((datServRealizadosEquipoDetTmp.getUnidadMedidaTrabajador() != null)
                        ? datServRealizadosEquipoDetTmp.getUnidadMedidaTrabajador() : null);
              
                datServRealizadosEquipoDetDTO2.setUsuarioDigitacion((datServRealizadosEquipoDetTmp.getUsuarioDigitacion() != null)
                        ? datServRealizadosEquipoDetTmp.getUsuarioDigitacion() : null);
              
                datServRealizadosEquipoDetDTO2.setTipoMttoTexto((datServRealizadosEquipoDetTmp.getTipoMttoTexto() != null)
                        ? datServRealizadosEquipoDetTmp.getTipoMttoTexto() : null);
              
                datServRealizadosEquipoDetDTO2.setHorometroMtto((datServRealizadosEquipoDetTmp.getHorometroMtto() != null)
                        ? datServRealizadosEquipoDetTmp.getHorometroMtto() : null);
                
                datServRealizadosEquipoDetDTO.add(datServRealizadosEquipoDetDTO2);
            }

            return datServRealizadosEquipoDetDTO;
        } catch (Exception e) {
            throw e;
        }
    }
}
