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

import co.com.arcosoft.dataaccess.dao.IDatDiferidosAgricolaDetDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatDiferidosAgricolaDet;
import co.com.arcosoft.modelo.dto.DatDiferidosAgricolaDetDTO;
import co.com.arcosoft.utilities.Utilities;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("DatDiferidosAgricolaDetLogic")
public class DatDiferidosAgricolaDetLogic
    implements IDatDiferidosAgricolaDetLogic {
    private static final Logger log = LoggerFactory.getLogger(DatDiferidosAgricolaDetLogic.class);

    /**
     * DAO injected by Spring that manages DatDiferidosAgricolaDet entities
     *
     */
    @Autowired
    private IDatDiferidosAgricolaDetDAO datDiferidosAgricolaDetDAO;

    /**
    * Logic injected by Spring that manages DatDiferidosAgricola entities
    *
    */
    @Autowired
    IDatDiferidosAgricolaLogic logicDatDiferidosAgricola1;

    /**
    * Logic injected by Spring that manages Nivel2 entities
    *
    */
    @Autowired
    INivel2Logic logicNivel22;

    /**
    * Logic injected by Spring that manages Nivel4 entities
    *
    */
    @Autowired
    INivel4Logic logicNivel43;

    @Transactional(readOnly = true)
    public List<DatDiferidosAgricolaDet> getDatDiferidosAgricolaDet()
        throws Exception {
        log.debug("finding all DatDiferidosAgricolaDet instances");

        List<DatDiferidosAgricolaDet> list = new ArrayList<DatDiferidosAgricolaDet>();

        try {
            list = datDiferidosAgricolaDetDAO.findAll();
        } catch (Exception e) {
            log.error("finding all DatDiferidosAgricolaDet failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "DatDiferidosAgricolaDet");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveDatDiferidosAgricolaDet(DatDiferidosAgricolaDet entity)
        throws Exception {
        log.debug("saving DatDiferidosAgricolaDet instance");

        try {
            if (entity.getDatDiferidosAgricola() == null) {
                throw new ZMessManager().new ForeignException(
                    "datDiferidosAgricola");
            }

            if (entity.getNivel2() == null) {
                throw new ZMessManager().new ForeignException("nivel2");
            }

            if (entity.getNivel4() == null) {
                throw new ZMessManager().new ForeignException("nivel4");
            }

            if ((entity.getValorFactura() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorFactura(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorFactura");
            }

            if (entity.getDatDiferidosAgricola().getDatDiferidosAgricolaId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "datDiferidosAgricolaId_DatDiferidosAgricola");
            }

            if (entity.getNivel2().getNivel2Id() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "nivel2Id_Nivel2");
            }

            if (entity.getNivel4().getNivel4Id() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "nivel4Id_Nivel4");
            }

            if (getDatDiferidosAgricolaDet(
                        entity.getDatDiferidosAgricolaDetId()) != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            datDiferidosAgricolaDetDAO.save(entity);

            log.debug("save DatDiferidosAgricolaDet successful");
        } catch (Exception e) {
            log.error("save DatDiferidosAgricolaDet failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteDatDiferidosAgricolaDet(DatDiferidosAgricolaDet entity)
        throws Exception {
        log.debug("deleting DatDiferidosAgricolaDet instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion(
                "DatDiferidosAgricolaDet");
        }

        if (entity.getDatDiferidosAgricolaDetId() == null) {
            throw new ZMessManager().new EmptyFieldException(
                "datDiferidosAgricolaDetId");
        }

        try {
            datDiferidosAgricolaDetDAO.delete(entity);

            log.debug("delete DatDiferidosAgricolaDet successful");
        } catch (Exception e) {
            log.error("delete DatDiferidosAgricolaDet failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateDatDiferidosAgricolaDet(DatDiferidosAgricolaDet entity)
        throws Exception {
        log.debug("updating DatDiferidosAgricolaDet instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "DatDiferidosAgricolaDet");
            }

            if (entity.getDatDiferidosAgricola() == null) {
                throw new ZMessManager().new ForeignException(
                    "datDiferidosAgricola");
            }

            if ((entity.getValorFactura() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorFactura(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorFactura");
            }

            if (entity.getDatDiferidosAgricola().getDatDiferidosAgricolaId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "datDiferidosAgricolaId_DatDiferidosAgricola");
            }

            datDiferidosAgricolaDetDAO.update(entity);

            log.debug("update DatDiferidosAgricolaDet successful");
        } catch (Exception e) {
            log.error("update DatDiferidosAgricolaDet failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<DatDiferidosAgricolaDetDTO> getDataDatDiferidosAgricolaDet()
        throws Exception {
        try {
            List<DatDiferidosAgricolaDet> datDiferidosAgricolaDet = datDiferidosAgricolaDetDAO.findAll();

            List<DatDiferidosAgricolaDetDTO> datDiferidosAgricolaDetDTO = new ArrayList<DatDiferidosAgricolaDetDTO>();

            for (DatDiferidosAgricolaDet datDiferidosAgricolaDetTmp : datDiferidosAgricolaDet) {
                DatDiferidosAgricolaDetDTO datDiferidosAgricolaDetDTO2 = new DatDiferidosAgricolaDetDTO();

                datDiferidosAgricolaDetDTO2.setDatDiferidosAgricolaDetId(datDiferidosAgricolaDetTmp.getDatDiferidosAgricolaDetId());
                datDiferidosAgricolaDetDTO2.setValorFactura((datDiferidosAgricolaDetTmp.getValorFactura() != null)
                    ? datDiferidosAgricolaDetTmp.getValorFactura() : null);
                datDiferidosAgricolaDetDTO2.setDatDiferidosAgricolaId_DatDiferidosAgricola((datDiferidosAgricolaDetTmp.getDatDiferidosAgricola()
                                                                                                                      .getDatDiferidosAgricolaId() != null)
                    ? datDiferidosAgricolaDetTmp.getDatDiferidosAgricola()
                                                .getDatDiferidosAgricolaId()
                    : null);
                
                datDiferidosAgricolaDetDTO2.setAreaNeta((datDiferidosAgricolaDetTmp.getAreaNeta() != null)
                        ? datDiferidosAgricolaDetTmp.getAreaNeta() : null);
                
                datDiferidosAgricolaDetDTO2.setEtapaId((datDiferidosAgricolaDetTmp.getEtapaId() != null)
                        ? datDiferidosAgricolaDetTmp.getEtapaId() : null);
                
                datDiferidosAgricolaDetDTO2.setVariedadId((datDiferidosAgricolaDetTmp.getVariedadId() != null)
                        ? datDiferidosAgricolaDetTmp.getVariedadId() : null);

                if (datDiferidosAgricolaDetTmp.getNivel2() != null) {
                    datDiferidosAgricolaDetDTO2.setNivel2Id_Nivel2(datDiferidosAgricolaDetTmp.getNivel2()
                                                                                             .getNivel2Id());
                } else {
                    datDiferidosAgricolaDetDTO2.setNivel2Id_Nivel2(null);
                }

                if (datDiferidosAgricolaDetTmp.getNivel4() != null) {
                    datDiferidosAgricolaDetDTO2.setNivel4Id_Nivel4(datDiferidosAgricolaDetTmp.getNivel4());
                } else {
                    datDiferidosAgricolaDetDTO2.setNivel4Id_Nivel4(null);
                }
                
                if (datDiferidosAgricolaDetTmp.getNivel4() != null) {
                    datDiferidosAgricolaDetDTO2.setCodigoNivel4(datDiferidosAgricolaDetTmp.getNivel4().getCodigo());
                } else {
                    datDiferidosAgricolaDetDTO2.setCodigoNivel4(null);
                }

                datDiferidosAgricolaDetDTO.add(datDiferidosAgricolaDetDTO2);
            }

            return datDiferidosAgricolaDetDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public DatDiferidosAgricolaDet getDatDiferidosAgricolaDet(
        Long datDiferidosAgricolaDetId) throws Exception {
        log.debug("getting DatDiferidosAgricolaDet instance");

        DatDiferidosAgricolaDet entity = null;

        try {
            entity = datDiferidosAgricolaDetDAO.findById(datDiferidosAgricolaDetId);
        } catch (Exception e) {
            log.error("get DatDiferidosAgricolaDet failed", e);
            throw new ZMessManager().new FindingException(
                "DatDiferidosAgricolaDet");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<DatDiferidosAgricolaDet> findPageDatDiferidosAgricolaDet(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        List<DatDiferidosAgricolaDet> entity = null;

        try {
            entity = datDiferidosAgricolaDetDAO.findPage(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatDiferidosAgricolaDet Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberDatDiferidosAgricolaDet()
        throws Exception {
        Long entity = null;

        try {
            entity = datDiferidosAgricolaDetDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatDiferidosAgricolaDet Count");
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
    public List<DatDiferidosAgricolaDet> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<DatDiferidosAgricolaDet> list = new ArrayList<DatDiferidosAgricolaDet>();
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
            list = datDiferidosAgricolaDetDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
    
    @Transactional(readOnly = true)
    public List<DatDiferidosAgricolaDetDTO> getDataDatDiferidosAgricolaDetByDatDiferidosAgricola(Long datDiferidosAgricolaId)
        throws Exception {
        try {
            List<DatDiferidosAgricolaDet> datDiferidosAgricolaDet = datDiferidosAgricolaDetDAO.
            		findByCriteria("datDiferidosAgricola.datDiferidosAgricolaId= " + datDiferidosAgricolaId);

            List<DatDiferidosAgricolaDetDTO> datDiferidosAgricolaDetDTO = new ArrayList<DatDiferidosAgricolaDetDTO>();

            for (DatDiferidosAgricolaDet datDiferidosAgricolaDetTmp : datDiferidosAgricolaDet) {
                DatDiferidosAgricolaDetDTO datDiferidosAgricolaDetDTO2 = new DatDiferidosAgricolaDetDTO();

                datDiferidosAgricolaDetDTO2.setDatDiferidosAgricolaDetId(datDiferidosAgricolaDetTmp.getDatDiferidosAgricolaDetId());
                datDiferidosAgricolaDetDTO2.setValorFactura((datDiferidosAgricolaDetTmp.getValorFactura() != null)
                    ? datDiferidosAgricolaDetTmp.getValorFactura() : null);
                datDiferidosAgricolaDetDTO2.setDatDiferidosAgricolaId_DatDiferidosAgricola((datDiferidosAgricolaDetTmp.getDatDiferidosAgricola()
                                                                                                                      .getDatDiferidosAgricolaId() != null)
                    ? datDiferidosAgricolaDetTmp.getDatDiferidosAgricola()
                                                .getDatDiferidosAgricolaId()
                    : null);

                if (datDiferidosAgricolaDetTmp.getNivel2() != null) {
                    datDiferidosAgricolaDetDTO2.setNivel2Id_Nivel2(datDiferidosAgricolaDetTmp.getNivel2()
                                                                                             .getNivel2Id());
                } else {
                    datDiferidosAgricolaDetDTO2.setNivel2Id_Nivel2(null);
                }

                if (datDiferidosAgricolaDetTmp.getNivel4() != null) {
                    datDiferidosAgricolaDetDTO2.setNivel4Id_Nivel4(datDiferidosAgricolaDetTmp.getNivel4());
                } else {
                    datDiferidosAgricolaDetDTO2.setNivel4Id_Nivel4(null);
                }
                
                if (datDiferidosAgricolaDetTmp.getNivel4() != null) {
                    datDiferidosAgricolaDetDTO2.setCodigoNivel4(datDiferidosAgricolaDetTmp.getNivel4().getCodigo());
                } else {
                    datDiferidosAgricolaDetDTO2.setCodigoNivel4(null);
                }

                datDiferidosAgricolaDetDTO.add(datDiferidosAgricolaDetDTO2);
            }

            return datDiferidosAgricolaDetDTO;
        } catch (Exception e) {
            throw e;
        }
        
    }
}
