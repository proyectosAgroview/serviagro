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

import co.com.arcosoft.dataaccess.dao.IDatDiferidosCuotasDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatDiferidosCuotas;
import co.com.arcosoft.modelo.dto.DatDiferidosCuotasDTO;
import co.com.arcosoft.utilities.Utilities;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("DatDiferidosCuotasLogic")
public class DatDiferidosCuotasLogic implements IDatDiferidosCuotasLogic {
    private static final Logger log = LoggerFactory.getLogger(DatDiferidosCuotasLogic.class);

    /**
     * DAO injected by Spring that manages DatDiferidosCuotas entities
     *
     */
    @Autowired
    private IDatDiferidosCuotasDAO datDiferidosCuotasDAO;

    /**
    * Logic injected by Spring that manages DatDiferidos entities
    *
    */
    @Autowired
    IDatDiferidosLogic logicDatDiferidos1;

    @Transactional(readOnly = true)
    public List<DatDiferidosCuotas> getDatDiferidosCuotas()
        throws Exception {
        log.debug("finding all DatDiferidosCuotas instances");

        List<DatDiferidosCuotas> list = new ArrayList<DatDiferidosCuotas>();

        try {
            list = datDiferidosCuotasDAO.findAll();
        } catch (Exception e) {
            log.error("finding all DatDiferidosCuotas failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "DatDiferidosCuotas");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveDatDiferidosCuotas(DatDiferidosCuotas entity)
        throws Exception {
        log.debug("saving DatDiferidosCuotas instance");

        try {
            if (entity.getDatDiferidos() == null) {
                throw new ZMessManager().new ForeignException("datDiferidos");
            }

        
            datDiferidosCuotasDAO.save(entity);

            log.debug("save DatDiferidosCuotas successful");
        } catch (Exception e) {
            log.error("save DatDiferidosCuotas failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteDatDiferidosCuotas(DatDiferidosCuotas entity)
        throws Exception {
        log.debug("deleting DatDiferidosCuotas instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion(
                "DatDiferidosCuotas");
        }

        if (entity.getDatDiferidosCuotasId() == null) {
            throw new ZMessManager().new EmptyFieldException(
                "datDiferidosCuotasId");
        }

        try {
            datDiferidosCuotasDAO.delete(entity);

            log.debug("delete DatDiferidosCuotas successful");
        } catch (Exception e) {
            log.error("delete DatDiferidosCuotas failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateDatDiferidosCuotas(DatDiferidosCuotas entity)
        throws Exception {
        log.debug("updating DatDiferidosCuotas instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "DatDiferidosCuotas");
            }

            if (entity.getDatDiferidos() == null) {
                throw new ZMessManager().new ForeignException("datDiferidos");
            }

          
            if (entity.getDatDiferidos().getDatDiferidosId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "datDiferidosId_DatDiferidos");
            }

            datDiferidosCuotasDAO.update(entity);

            log.debug("update DatDiferidosCuotas successful");
        } catch (Exception e) {
            log.error("update DatDiferidosCuotas failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<DatDiferidosCuotasDTO> getDataDatDiferidosCuotas()
        throws Exception {
        try {
            List<DatDiferidosCuotas> datDiferidosCuotas = datDiferidosCuotasDAO.findAll();

            List<DatDiferidosCuotasDTO> datDiferidosCuotasDTO = new ArrayList<DatDiferidosCuotasDTO>();

            for (DatDiferidosCuotas datDiferidosCuotasTmp : datDiferidosCuotas) {
                DatDiferidosCuotasDTO datDiferidosCuotasDTO2 = new DatDiferidosCuotasDTO();

                datDiferidosCuotasDTO2.setDatDiferidosCuotasId(datDiferidosCuotasTmp.getDatDiferidosCuotasId());
                datDiferidosCuotasDTO2.setAnio((datDiferidosCuotasTmp.getAnio() != null)
                    ? datDiferidosCuotasTmp.getAnio() : null);
                datDiferidosCuotasDTO2.setFecha(datDiferidosCuotasTmp.getFecha());
                datDiferidosCuotasDTO2.setMes((datDiferidosCuotasTmp.getMes() != null)
                    ? datDiferidosCuotasTmp.getMes() : null);
                datDiferidosCuotasDTO2.setValorCuota((datDiferidosCuotasTmp.getValorCuota() != null)
                    ? datDiferidosCuotasTmp.getValorCuota() : null);
                datDiferidosCuotasDTO2.setDatDiferidosId_DatDiferidos((datDiferidosCuotasTmp.getDatDiferidos()
                                                                                            .getDatDiferidosId() != null)
                    ? datDiferidosCuotasTmp.getDatDiferidos().getDatDiferidosId()
                    : null);
                datDiferidosCuotasDTO.add(datDiferidosCuotasDTO2);
            }

            return datDiferidosCuotasDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public DatDiferidosCuotas getDatDiferidosCuotas(Long datDiferidosCuotasId)
        throws Exception {
        log.debug("getting DatDiferidosCuotas instance");

        DatDiferidosCuotas entity = null;

        try {
            entity = datDiferidosCuotasDAO.findById(datDiferidosCuotasId);
        } catch (Exception e) {
            log.error("get DatDiferidosCuotas failed", e);
            throw new ZMessManager().new FindingException("DatDiferidosCuotas");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<DatDiferidosCuotas> findPageDatDiferidosCuotas(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        List<DatDiferidosCuotas> entity = null;

        try {
            entity = datDiferidosCuotasDAO.findPage(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatDiferidosCuotas Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberDatDiferidosCuotas() throws Exception {
        Long entity = null;

        try {
            entity = datDiferidosCuotasDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatDiferidosCuotas Count");
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
    public List<DatDiferidosCuotas> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<DatDiferidosCuotas> list = new ArrayList<DatDiferidosCuotas>();
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
            list = datDiferidosCuotasDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
    
    

    @Transactional(readOnly = true)
    public List<DatDiferidosCuotasDTO> getDataDatDiferidosCuotasByCuotas(Long datDiferidosId)
        throws Exception {
        try {
         
            List<DatDiferidosCuotas> datDiferidosCuotas = datDiferidosCuotasDAO
     					.findByCriteria("datDiferidos.datDiferidosId= " + datDiferidosId);
                 
            List<DatDiferidosCuotasDTO> datDiferidosCuotasDTO = new ArrayList<DatDiferidosCuotasDTO>();

            for (DatDiferidosCuotas datDiferidosCuotasTmp : datDiferidosCuotas) {
                DatDiferidosCuotasDTO datDiferidosCuotasDTO2 = new DatDiferidosCuotasDTO();

                datDiferidosCuotasDTO2.setDatDiferidosCuotasId(datDiferidosCuotasTmp.getDatDiferidosCuotasId());
                datDiferidosCuotasDTO2.setAnio((datDiferidosCuotasTmp.getAnio() != null)
                    ? datDiferidosCuotasTmp.getAnio() : null);
                datDiferidosCuotasDTO2.setFecha(datDiferidosCuotasTmp.getFecha());
                datDiferidosCuotasDTO2.setMes((datDiferidosCuotasTmp.getMes() != null)
                    ? datDiferidosCuotasTmp.getMes() : null);
                datDiferidosCuotasDTO2.setValorCuota((datDiferidosCuotasTmp.getValorCuota() != null)
                    ? datDiferidosCuotasTmp.getValorCuota() : null);
                datDiferidosCuotasDTO2.setDatDiferidosId_DatDiferidos((datDiferidosCuotasTmp.getDatDiferidos()
                                                                                            .getDatDiferidosId() != null)
                    ? datDiferidosCuotasTmp.getDatDiferidos().getDatDiferidosId()
                    : null);
                datDiferidosCuotasDTO.add(datDiferidosCuotasDTO2);
            }

            return datDiferidosCuotasDTO;
        } catch (Exception e) {
            throw e;
        }
    }
}
