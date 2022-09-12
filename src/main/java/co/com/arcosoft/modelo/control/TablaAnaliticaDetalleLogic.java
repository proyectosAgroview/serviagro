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

import co.com.arcosoft.dataaccess.dao.ITablaAnaliticaDetalleDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.TablaAnaliticaDetalle;
import co.com.arcosoft.modelo.dto.TablaAnaliticaDetalleDTO;
import co.com.arcosoft.utilities.Utilities;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("TablaAnaliticaDetalleLogic")
public class TablaAnaliticaDetalleLogic implements ITablaAnaliticaDetalleLogic {
    private static final Logger log = LoggerFactory.getLogger(TablaAnaliticaDetalleLogic.class);

    /**
     * DAO injected by Spring that manages TablaAnaliticaDetalle entities
     *
     */
    @Autowired
    private ITablaAnaliticaDetalleDAO tablaAnaliticaDetalleDAO;

    /**
    * Logic injected by Spring that manages TablaAnalitica entities
    *
    */
    @Autowired
    ITablaAnaliticaLogic logicTablaAnalitica1;

    @Transactional(readOnly = true)
    public List<TablaAnaliticaDetalle> getTablaAnaliticaDetalle()
        throws Exception {
        log.debug("finding all TablaAnaliticaDetalle instances");

        List<TablaAnaliticaDetalle> list = new ArrayList<TablaAnaliticaDetalle>();

        try {
            list = tablaAnaliticaDetalleDAO.findAll();
        } catch (Exception e) {
            log.error("finding all TablaAnaliticaDetalle failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "TablaAnaliticaDetalle");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveTablaAnaliticaDetalle(TablaAnaliticaDetalle entity)
        throws Exception {
        log.debug("saving TablaAnaliticaDetalle instance");

        try {
            if (entity.getTablaAnalitica() == null) {
                throw new ZMessManager().new ForeignException("tablaAnalitica");
            }

            if ((entity.getValorVariableEntrada1() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorVariableEntrada1(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorVariableEntrada1");
            }

            if ((entity.getValorVariableEntrada2() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorVariableEntrada2(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorVariableEntrada2");
            }

            if ((entity.getValorVariableEntrada3() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorVariableEntrada3(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorVariableEntrada3");
            }

            if ((entity.getValorVariableSalida1() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorVariableSalida1(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorVariableSalida1");
            }

            if ((entity.getValorVariableSalida2() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorVariableSalida2(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorVariableSalida2");
            }

            if (entity.getTablaAnalitica().getTablaAnaliticaId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "tablaAnaliticaId_TablaAnalitica");
            }

            if (getTablaAnaliticaDetalle(entity.getTablaAnaliticaDetalleId()) != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            tablaAnaliticaDetalleDAO.save(entity);

            log.debug("save TablaAnaliticaDetalle successful");
        } catch (Exception e) {
            log.error("save TablaAnaliticaDetalle failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteTablaAnaliticaDetalle(TablaAnaliticaDetalle entity)
        throws Exception {
        log.debug("deleting TablaAnaliticaDetalle instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion(
                "TablaAnaliticaDetalle");
        }

        if (entity.getTablaAnaliticaDetalleId() == null) {
            throw new ZMessManager().new EmptyFieldException(
                "tablaAnaliticaDetalleId");
        }

        try {
            tablaAnaliticaDetalleDAO.delete(entity);

            log.debug("delete TablaAnaliticaDetalle successful");
        } catch (Exception e) {
            log.error("delete TablaAnaliticaDetalle failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateTablaAnaliticaDetalle(TablaAnaliticaDetalle entity)
        throws Exception {
        log.debug("updating TablaAnaliticaDetalle instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "TablaAnaliticaDetalle");
            }

            if (entity.getTablaAnalitica() == null) {
                throw new ZMessManager().new ForeignException("tablaAnalitica");
            }

            if ((entity.getValorVariableEntrada1() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorVariableEntrada1(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorVariableEntrada1");
            }

            if ((entity.getValorVariableEntrada2() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorVariableEntrada2(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorVariableEntrada2");
            }

            if ((entity.getValorVariableEntrada3() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorVariableEntrada3(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorVariableEntrada3");
            }

            if ((entity.getValorVariableSalida1() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorVariableSalida1(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorVariableSalida1");
            }

            if ((entity.getValorVariableSalida2() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorVariableSalida2(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorVariableSalida2");
            }

            if (entity.getTablaAnalitica().getTablaAnaliticaId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "tablaAnaliticaId_TablaAnalitica");
            }

            tablaAnaliticaDetalleDAO.update(entity);

            log.debug("update TablaAnaliticaDetalle successful");
        } catch (Exception e) {
            log.error("update TablaAnaliticaDetalle failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<TablaAnaliticaDetalleDTO> getDataTablaAnaliticaDetalle()
        throws Exception {
        try {
            List<TablaAnaliticaDetalle> tablaAnaliticaDetalle = tablaAnaliticaDetalleDAO.findAll();

            List<TablaAnaliticaDetalleDTO> tablaAnaliticaDetalleDTO = new ArrayList<TablaAnaliticaDetalleDTO>();

            for (TablaAnaliticaDetalle tablaAnaliticaDetalleTmp : tablaAnaliticaDetalle) {
                TablaAnaliticaDetalleDTO tablaAnaliticaDetalleDTO2 = new TablaAnaliticaDetalleDTO();

                tablaAnaliticaDetalleDTO2.setTablaAnaliticaDetalleId(tablaAnaliticaDetalleTmp.getTablaAnaliticaDetalleId());
                tablaAnaliticaDetalleDTO2.setValorVariableEntrada1((tablaAnaliticaDetalleTmp.getValorVariableEntrada1() != null)
                    ? tablaAnaliticaDetalleTmp.getValorVariableEntrada1() : null);
                tablaAnaliticaDetalleDTO2.setValorVariableEntrada2((tablaAnaliticaDetalleTmp.getValorVariableEntrada2() != null)
                    ? tablaAnaliticaDetalleTmp.getValorVariableEntrada2() : null);
                tablaAnaliticaDetalleDTO2.setValorVariableEntrada3((tablaAnaliticaDetalleTmp.getValorVariableEntrada3() != null)
                    ? tablaAnaliticaDetalleTmp.getValorVariableEntrada3() : null);
                tablaAnaliticaDetalleDTO2.setValorVariableSalida1((tablaAnaliticaDetalleTmp.getValorVariableSalida1() != null)
                    ? tablaAnaliticaDetalleTmp.getValorVariableSalida1() : null);
                tablaAnaliticaDetalleDTO2.setValorVariableSalida2((tablaAnaliticaDetalleTmp.getValorVariableSalida2() != null)
                    ? tablaAnaliticaDetalleTmp.getValorVariableSalida2() : null);
                tablaAnaliticaDetalleDTO2.setTablaAnaliticaId_TablaAnalitica((tablaAnaliticaDetalleTmp.getTablaAnalitica()
                                                                                                      .getTablaAnaliticaId() != null)
                    ? tablaAnaliticaDetalleTmp.getTablaAnalitica(): null);
                tablaAnaliticaDetalleDTO.add(tablaAnaliticaDetalleDTO2);
            }

            return tablaAnaliticaDetalleDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public TablaAnaliticaDetalle getTablaAnaliticaDetalle(
        Long tablaAnaliticaDetalleId) throws Exception {
        log.debug("getting TablaAnaliticaDetalle instance");

        TablaAnaliticaDetalle entity = null;

        try {
            entity = tablaAnaliticaDetalleDAO.findById(tablaAnaliticaDetalleId);
        } catch (Exception e) {
            log.error("get TablaAnaliticaDetalle failed", e);
            throw new ZMessManager().new FindingException(
                "TablaAnaliticaDetalle");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<TablaAnaliticaDetalle> findPageTablaAnaliticaDetalle(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        List<TablaAnaliticaDetalle> entity = null;

        try {
            entity = tablaAnaliticaDetalleDAO.findPage(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "TablaAnaliticaDetalle Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberTablaAnaliticaDetalle()
        throws Exception {
        Long entity = null;

        try {
            entity = tablaAnaliticaDetalleDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "TablaAnaliticaDetalle Count");
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
    public List<TablaAnaliticaDetalle> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<TablaAnaliticaDetalle> list = new ArrayList<TablaAnaliticaDetalle>();
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
            list = tablaAnaliticaDetalleDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
    
    @Transactional(readOnly = true)
    public List<TablaAnaliticaDetalleDTO> getDataTablaAnaliticaDetalleByTablaAnalitica(Long tablaAnaliticaId)
        throws Exception {
        try {
            List<TablaAnaliticaDetalle> tablaAnaliticaDetalle = tablaAnaliticaDetalleDAO.findByCriteria("tablaAnalitica.tablaAnaliticaId= " + tablaAnaliticaId);;

            List<TablaAnaliticaDetalleDTO> tablaAnaliticaDetalleDTO = new ArrayList<TablaAnaliticaDetalleDTO>();

            for (TablaAnaliticaDetalle tablaAnaliticaDetalleTmp : tablaAnaliticaDetalle) {
                TablaAnaliticaDetalleDTO tablaAnaliticaDetalleDTO2 = new TablaAnaliticaDetalleDTO();

                tablaAnaliticaDetalleDTO2.setTablaAnaliticaDetalleId(tablaAnaliticaDetalleTmp.getTablaAnaliticaDetalleId());
                tablaAnaliticaDetalleDTO2.setValorVariableEntrada1((tablaAnaliticaDetalleTmp.getValorVariableEntrada1() != null)
                    ? tablaAnaliticaDetalleTmp.getValorVariableEntrada1() : null);
                tablaAnaliticaDetalleDTO2.setValorVariableEntrada2((tablaAnaliticaDetalleTmp.getValorVariableEntrada2() != null)
                    ? tablaAnaliticaDetalleTmp.getValorVariableEntrada2() : null);
                tablaAnaliticaDetalleDTO2.setValorVariableEntrada3((tablaAnaliticaDetalleTmp.getValorVariableEntrada3() != null)
                    ? tablaAnaliticaDetalleTmp.getValorVariableEntrada3() : null);
                tablaAnaliticaDetalleDTO2.setValorVariableSalida1((tablaAnaliticaDetalleTmp.getValorVariableSalida1() != null)
                    ? tablaAnaliticaDetalleTmp.getValorVariableSalida1() : null);
                tablaAnaliticaDetalleDTO2.setValorVariableSalida2((tablaAnaliticaDetalleTmp.getValorVariableSalida2() != null)
                    ? tablaAnaliticaDetalleTmp.getValorVariableSalida2() : null);
                tablaAnaliticaDetalleDTO2.setTablaAnaliticaId_TablaAnalitica((tablaAnaliticaDetalleTmp.getTablaAnalitica()
                                                                                                      .getTablaAnaliticaId() != null)
                    ? tablaAnaliticaDetalleTmp.getTablaAnalitica(): null);
                tablaAnaliticaDetalleDTO.add(tablaAnaliticaDetalleDTO2);
            }

            return tablaAnaliticaDetalleDTO;
        } catch (Exception e) {
            throw e;
        }
    }
}
