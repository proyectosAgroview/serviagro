package co.com.arcosoft.modelo.control;

import co.com.arcosoft.dataaccess.dao.*;
import co.com.arcosoft.exceptions.*;
import co.com.arcosoft.modelo.*;
import co.com.arcosoft.modelo.dto.SubTipoCotizanteDTO;
import co.com.arcosoft.utilities.Utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("SubTipoCotizanteLogic")
public class SubTipoCotizanteLogic implements ISubTipoCotizanteLogic {
    private static final Logger log = LoggerFactory.getLogger(SubTipoCotizanteLogic.class);

    /**
     * DAO injected by Spring that manages SubTipoCotizante entities
     *
     */
    @Autowired
    private ISubTipoCotizanteDAO subTipoCotizanteDAO;

    @Transactional(readOnly = true)
    public List<SubTipoCotizante> getSubTipoCotizante()
        throws Exception {
        log.debug("finding all SubTipoCotizante instances");

        List<SubTipoCotizante> list = new ArrayList<SubTipoCotizante>();

        try {
            list = subTipoCotizanteDAO.findAll();
        } catch (Exception e) {
            log.error("finding all SubTipoCotizante failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "SubTipoCotizante");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveSubTipoCotizante(SubTipoCotizante entity)
        throws Exception {
        log.debug("saving SubTipoCotizante instance");

        try {
            if ((entity.getCodigo() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getCodigo(),
                        50) == false)) {
                throw new ZMessManager().new NotValidFormatException("codigo");
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

            if ((entity.getNombre() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getNombre(),
                        50) == false)) {
                throw new ZMessManager().new NotValidFormatException("nombre");
            }

            subTipoCotizanteDAO.save(entity);

            log.debug("save SubTipoCotizante successful");
        } catch (Exception e) {
            log.error("save SubTipoCotizante failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteSubTipoCotizante(SubTipoCotizante entity)
        throws Exception {
        log.debug("deleting SubTipoCotizante instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("SubTipoCotizante");
        }

        if (entity.getSubTipoCotizanteId() == null) {
            throw new ZMessManager().new EmptyFieldException(
                "subTipoCotizanteId");
        }

        try {
            subTipoCotizanteDAO.delete(entity);

            log.debug("delete SubTipoCotizante successful");
        } catch (Exception e) {
            log.error("delete SubTipoCotizante failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateSubTipoCotizante(SubTipoCotizante entity)
        throws Exception {
        log.debug("updating SubTipoCotizante instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "SubTipoCotizante");
            }

            if ((entity.getCodigo() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getCodigo(),
                        50) == false)) {
                throw new ZMessManager().new NotValidFormatException("codigo");
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

            if ((entity.getNombre() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getNombre(),
                        50) == false)) {
                throw new ZMessManager().new NotValidFormatException("nombre");
            }

            subTipoCotizanteDAO.update(entity);

            log.debug("update SubTipoCotizante successful");
        } catch (Exception e) {
            log.error("update SubTipoCotizante failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<SubTipoCotizanteDTO> getDataSubTipoCotizante()
        throws Exception {
        try {
            List<SubTipoCotizante> subTipoCotizante = subTipoCotizanteDAO.findAll();

            List<SubTipoCotizanteDTO> subTipoCotizanteDTO = new ArrayList<SubTipoCotizanteDTO>();

            for (SubTipoCotizante subTipoCotizanteTmp : subTipoCotizante) {
                SubTipoCotizanteDTO subTipoCotizanteDTO2 = new SubTipoCotizanteDTO();

                subTipoCotizanteDTO2.setSubTipoCotizanteId(subTipoCotizanteTmp.getSubTipoCotizanteId());
                subTipoCotizanteDTO2.setCodigo((subTipoCotizanteTmp.getCodigo() != null)
                    ? subTipoCotizanteTmp.getCodigo() : null);
                subTipoCotizanteDTO2.setCompania((subTipoCotizanteTmp.getCompania() != null)
                    ? subTipoCotizanteTmp.getCompania() : null);
                subTipoCotizanteDTO2.setEstado((subTipoCotizanteTmp.getEstado() != null)
                    ? subTipoCotizanteTmp.getEstado() : null);
                subTipoCotizanteDTO2.setFechaCreacion(subTipoCotizanteTmp.getFechaCreacion());
                subTipoCotizanteDTO2.setFechaModificacion(subTipoCotizanteTmp.getFechaModificacion());
                subTipoCotizanteDTO2.setInfoAdicional((subTipoCotizanteTmp.getInfoAdicional() != null)
                    ? subTipoCotizanteTmp.getInfoAdicional() : null);
                subTipoCotizanteDTO2.setInfoAdicional2((subTipoCotizanteTmp.getInfoAdicional2() != null)
                    ? subTipoCotizanteTmp.getInfoAdicional2() : null);
                subTipoCotizanteDTO2.setNombre((subTipoCotizanteTmp.getNombre() != null)
                    ? subTipoCotizanteTmp.getNombre() : null);
                subTipoCotizanteDTO.add(subTipoCotizanteDTO2);
            }

            return subTipoCotizanteDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public SubTipoCotizante getSubTipoCotizante(Long subTipoCotizanteId)
        throws Exception {
        log.debug("getting SubTipoCotizante instance");

        SubTipoCotizante entity = null;

        try {
            entity = subTipoCotizanteDAO.findById(subTipoCotizanteId);
        } catch (Exception e) {
            log.error("get SubTipoCotizante failed", e);
            throw new ZMessManager().new FindingException("SubTipoCotizante");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<SubTipoCotizante> findPageSubTipoCotizante(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        List<SubTipoCotizante> entity = null;

        try {
            entity = subTipoCotizanteDAO.findPage(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "SubTipoCotizante Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberSubTipoCotizante() throws Exception {
        Long entity = null;

        try {
            entity = subTipoCotizanteDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "SubTipoCotizante Count");
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
    public List<SubTipoCotizante> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<SubTipoCotizante> list = new ArrayList<SubTipoCotizante>();
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
            list = subTipoCotizanteDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
