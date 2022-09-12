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

import co.com.arcosoft.dataaccess.dao.IDatCajaMenorDetDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatCajaMenorDet;
import co.com.arcosoft.modelo.dto.DatCajaMenorDetDTO;
import co.com.arcosoft.utilities.Utilities;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("DatCajaMenorDetLogic")
public class DatCajaMenorDetLogic implements IDatCajaMenorDetLogic {
    private static final Logger log = LoggerFactory.getLogger(DatCajaMenorDetLogic.class);

    /**
     * DAO injected by Spring that manages DatCajaMenorDet entities
     *
     */
    @Autowired
    private IDatCajaMenorDetDAO datCajaMenorDetDAO;

    /**
    * Logic injected by Spring that manages DatCajaMenor entities
    *
    */
    @Autowired
    IDatCajaMenorLogic logicDatCajaMenor1;

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

    @Transactional(readOnly = true)
    public List<DatCajaMenorDet> getDatCajaMenorDet() throws Exception {
        log.debug("finding all DatCajaMenorDet instances");

        List<DatCajaMenorDet> list = new ArrayList<DatCajaMenorDet>();

        try {
            list = datCajaMenorDetDAO.findAll();
        } catch (Exception e) {
            log.error("finding all DatCajaMenorDet failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "DatCajaMenorDet");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveDatCajaMenorDet(DatCajaMenorDet entity)
        throws Exception {
        log.debug("saving DatCajaMenorDet instance");

        try {
            if (entity.getDatCajaMenor() == null) {
                throw new ZMessManager().new ForeignException("datCajaMenor");
            }

            if (entity.getEquipo() == null) {
                throw new ZMessManager().new ForeignException("equipo");
            }

            if (entity.getLabor() == null) {
                throw new ZMessManager().new ForeignException("labor");
            }

            if ((entity.getDetalleNota() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDetalleNota(), 3900) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "detalleNota");
            }

            if ((entity.getValor() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValor(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException("valor");
            }

            if (entity.getDatCajaMenor().getDatCajaMenorId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "datCajaMenorId_DatCajaMenor");
            }

            if (entity.getEquipo().getEquipoId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "equipoId_Equipo");
            }

            if (entity.getLabor().getLaborId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "laborId_Labor");
            }

         

            datCajaMenorDetDAO.save(entity);

            log.debug("save DatCajaMenorDet successful");
        } catch (Exception e) {
            log.error("save DatCajaMenorDet failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteDatCajaMenorDet(DatCajaMenorDet entity)
        throws Exception {
        log.debug("deleting DatCajaMenorDet instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("DatCajaMenorDet");
        }

        if (entity.getDatCajaMenordetId() == null) {
            throw new ZMessManager().new EmptyFieldException(
                "datCajaMenordetId");
        }

        try {
            datCajaMenorDetDAO.delete(entity);

            log.debug("delete DatCajaMenorDet successful");
        } catch (Exception e) {
            log.error("delete DatCajaMenorDet failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateDatCajaMenorDet(DatCajaMenorDet entity)
        throws Exception {
        log.debug("updating DatCajaMenorDet instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "DatCajaMenorDet");
            }

            if (entity.getDatCajaMenor() == null) {
                throw new ZMessManager().new ForeignException("datCajaMenor");
            }

            if (entity.getEquipo() == null) {
                throw new ZMessManager().new ForeignException("equipo");
            }

            if (entity.getLabor() == null) {
                throw new ZMessManager().new ForeignException("labor");
            }

            if ((entity.getDetalleNota() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDetalleNota(), 3900) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "detalleNota");
            }

            if ((entity.getValor() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValor(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException("valor");
            }

            if (entity.getDatCajaMenor().getDatCajaMenorId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "datCajaMenorId_DatCajaMenor");
            }

            if (entity.getEquipo().getEquipoId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "equipoId_Equipo");
            }

            if (entity.getLabor().getLaborId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "laborId_Labor");
            }

            datCajaMenorDetDAO.update(entity);

            log.debug("update DatCajaMenorDet successful");
        } catch (Exception e) {
            log.error("update DatCajaMenorDet failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<DatCajaMenorDetDTO> getDataDatCajaMenorDet()
        throws Exception {
        try {
            List<DatCajaMenorDet> datCajaMenorDet = datCajaMenorDetDAO.findAll();

            List<DatCajaMenorDetDTO> datCajaMenorDetDTO = new ArrayList<DatCajaMenorDetDTO>();

            for (DatCajaMenorDet datCajaMenorDetTmp : datCajaMenorDet) {
                DatCajaMenorDetDTO datCajaMenorDetDTO2 = new DatCajaMenorDetDTO();

                datCajaMenorDetDTO2.setDatCajaMenordetId(datCajaMenorDetTmp.getDatCajaMenordetId());
                datCajaMenorDetDTO2.setDetalleNota((datCajaMenorDetTmp.getDetalleNota() != null)
                    ? datCajaMenorDetTmp.getDetalleNota() : null);
                datCajaMenorDetDTO2.setValor((datCajaMenorDetTmp.getValor() != null)
                    ? datCajaMenorDetTmp.getValor() : null);
                datCajaMenorDetDTO2.setDatCajaMenorId_DatCajaMenor((datCajaMenorDetTmp.getDatCajaMenor()
                                                                                      .getDatCajaMenorId() != null)
                    ? datCajaMenorDetTmp.getDatCajaMenor().getDatCajaMenorId()
                    : null);

                if (datCajaMenorDetTmp.getEquipo() != null) {
                    datCajaMenorDetDTO2.setEquipoId_Equipo(datCajaMenorDetTmp.getEquipo()
                                                                             );
                } else {
                    datCajaMenorDetDTO2.setEquipoId_Equipo(null);
                }
                
                if (datCajaMenorDetTmp.getEquipo() != null) {
                    datCajaMenorDetDTO2.setCodigoEquipo(datCajaMenorDetTmp.getEquipo().getCodigo()
                                                                             );
                } else {
                    datCajaMenorDetDTO2.setCodigoEquipo(null);
                }


                if (datCajaMenorDetTmp.getLabor() != null) {
                    datCajaMenorDetDTO2.setLaborId_Labor(datCajaMenorDetTmp.getLabor()
                                                                           );
                } else {
                    datCajaMenorDetDTO2.setLaborId_Labor(null);
                }

                datCajaMenorDetDTO.add(datCajaMenorDetDTO2);
            }

            return datCajaMenorDetDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public DatCajaMenorDet getDatCajaMenorDet(Long datCajaMenordetId)
        throws Exception {
        log.debug("getting DatCajaMenorDet instance");

        DatCajaMenorDet entity = null;

        try {
            entity = datCajaMenorDetDAO.findById(datCajaMenordetId);
        } catch (Exception e) {
            log.error("get DatCajaMenorDet failed", e);
            throw new ZMessManager().new FindingException("DatCajaMenorDet");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<DatCajaMenorDet> findPageDatCajaMenorDet(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        List<DatCajaMenorDet> entity = null;

        try {
            entity = datCajaMenorDetDAO.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatCajaMenorDet Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberDatCajaMenorDet() throws Exception {
        Long entity = null;

        try {
            entity = datCajaMenorDetDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatCajaMenorDet Count");
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
    public List<DatCajaMenorDet> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<DatCajaMenorDet> list = new ArrayList<DatCajaMenorDet>();
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
            list = datCajaMenorDetDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
    


    @Transactional(readOnly = true)
    public List<DatCajaMenorDetDTO> getDataDatCajaMenorDetByCaja(Long datCajaMenorId)
        throws Exception {
        try {
     
            List<DatCajaMenorDet> datCajaMenorDet = datCajaMenorDetDAO
					.findByCriteria("datCajaMenor.datCajaMenorId= " + datCajaMenorId);
           
			
            List<DatCajaMenorDetDTO> datCajaMenorDetDTO = new ArrayList<DatCajaMenorDetDTO>();

            
            for (DatCajaMenorDet datCajaMenorDetTmp : datCajaMenorDet) {
                DatCajaMenorDetDTO datCajaMenorDetDTO2 = new DatCajaMenorDetDTO();

                datCajaMenorDetDTO2.setDatCajaMenordetId(datCajaMenorDetTmp.getDatCajaMenordetId());
                datCajaMenorDetDTO2.setDetalleNota((datCajaMenorDetTmp.getDetalleNota() != null)
                    ? datCajaMenorDetTmp.getDetalleNota() : null);
                datCajaMenorDetDTO2.setValor((datCajaMenorDetTmp.getValor() != null)
                    ? datCajaMenorDetTmp.getValor() : null);
                datCajaMenorDetDTO2.setDatCajaMenorId_DatCajaMenor((datCajaMenorDetTmp.getDatCajaMenor()
                                                                                      .getDatCajaMenorId() != null)
                    ? datCajaMenorDetTmp.getDatCajaMenor().getDatCajaMenorId()
                    : null);

                if (datCajaMenorDetTmp.getEquipo() != null) {
                    datCajaMenorDetDTO2.setEquipoId_Equipo(datCajaMenorDetTmp.getEquipo()
                                                                             );
                } else {
                    datCajaMenorDetDTO2.setEquipoId_Equipo(null);
                }

                if (datCajaMenorDetTmp.getEquipo() != null) {
                    datCajaMenorDetDTO2.setCodigoEquipo(datCajaMenorDetTmp.getEquipo().getCodigo()
                                                                             );
                } else {
                    datCajaMenorDetDTO2.setCodigoEquipo(null);
                }
                
                if (datCajaMenorDetTmp.getLabor() != null) {
                    datCajaMenorDetDTO2.setLaborId_Labor(datCajaMenorDetTmp.getLabor()
                                                                           );
                } else {
                    datCajaMenorDetDTO2.setLaborId_Labor(null);
                }
                
                if (datCajaMenorDetTmp.getLabor() != null) {
                    datCajaMenorDetDTO2.setNombreLabor(datCajaMenorDetTmp.getLabor()
                                                                           .getNombre());
                } else {
                    datCajaMenorDetDTO2.setNombreLabor(null);
                }

                if (datCajaMenorDetTmp.getNumFactura() != null) {
                    datCajaMenorDetDTO2.setNumFactura(datCajaMenorDetTmp.getNumFactura());
                } else {
                    datCajaMenorDetDTO2.setNumFactura(null);
                }

                if (datCajaMenorDetTmp.getPersEmpr() != null) {
                    datCajaMenorDetDTO2.setPersEmpr(datCajaMenorDetTmp.getPersEmpr()
                                                                           );
                } else {
                    datCajaMenorDetDTO2.setPersEmpr(null);
                }
                
                if (datCajaMenorDetTmp.getPersEmpr() != null) {
                    datCajaMenorDetDTO2.setNomProveedor(datCajaMenorDetTmp.getPersEmpr()
                                                                           .getNombre());
                } else {
                    datCajaMenorDetDTO2.setNomProveedor(null);
                }
                
                if (datCajaMenorDetTmp.getPersEmpr() != null) {
                    datCajaMenorDetDTO2.setIdProveedor(datCajaMenorDetTmp.getPersEmpr()
                                                                           .getPersEmprId());
                } else {
                    datCajaMenorDetDTO2.setIdProveedor(null);
                }
            	if (datCajaMenorDetTmp.getImplementoId() != null) {
            		datCajaMenorDetDTO2.setImplementoId(datCajaMenorDetTmp.getImplementoId().getEquipoId());
            		datCajaMenorDetDTO2.setCodImplemento(datCajaMenorDetTmp.getImplementoId().getCodigo() +"-"+datCajaMenorDetTmp.getImplementoId().getNombre());
				} else {
					datCajaMenorDetDTO2.setCodImplemento(null);
					datCajaMenorDetDTO2.setImplementoId(null);
				}
            	if (datCajaMenorDetTmp.getCentCost() != null) {
					datCajaMenorDetDTO2.setCentCostId_CentCost(datCajaMenorDetTmp.getCentCost().getCentCostId());
					datCajaMenorDetDTO2.setNombreCentroCosto(datCajaMenorDetTmp.getCentCost().getNombre());
				} else {
					datCajaMenorDetDTO2.setCentCostId_CentCost(null);
					datCajaMenorDetDTO2.setNombreCentroCosto(null);
				}
                datCajaMenorDetDTO.add(datCajaMenorDetDTO2);
            }

            return datCajaMenorDetDTO;
        } catch (Exception e) {
            throw e;
        }
    }


}
