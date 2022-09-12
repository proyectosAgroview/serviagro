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

import co.com.arcosoft.dataaccess.dao.ITablaAnaliticaDAO;
import co.com.arcosoft.dataaccess.dao.ITablaAnaliticaDetalleDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.TablaAnalitica;
import co.com.arcosoft.modelo.TablaAnaliticaDetalle;
import co.com.arcosoft.modelo.dto.TablaAnaliticaDTO;
import co.com.arcosoft.modelo.dto.TablaAnaliticaDetalleDTO;
import co.com.arcosoft.utilities.Utilities;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("TablaAnaliticaLogic")
public class TablaAnaliticaLogic implements ITablaAnaliticaLogic {
    private static final Logger log = LoggerFactory.getLogger(TablaAnaliticaLogic.class);

    /**
     * DAO injected by Spring that manages TablaAnalitica entities
     *
     */
    @Autowired
    private ITablaAnaliticaDAO tablaAnaliticaDAO;

    /**
    * DAO injected by Spring that manages TablaAnaliticaDetalle entities
    *
    */
    @Autowired
    private ITablaAnaliticaDetalleDAO tablaAnaliticaDetalleDAO;

    @Transactional(readOnly = true)
    public List<TablaAnalitica> getTablaAnalitica() throws Exception {
        log.debug("finding all TablaAnalitica instances");

        List<TablaAnalitica> list = new ArrayList<TablaAnalitica>();

        try {
            list = tablaAnaliticaDAO.findAll();
        } catch (Exception e) {
            log.error("finding all TablaAnalitica failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "TablaAnalitica");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveTablaAnalitica(TablaAnalitica entity, List<TablaAnaliticaDetalleDTO> dataTabAna)
        throws Exception {
        log.debug("saving TablaAnalitica instance");

        try {
            if ((entity.getCodigo() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getCodigo(),
                        20) == false)) {
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
                        60) == false)) {
                throw new ZMessManager().new NotValidFormatException("nombre");
            }

            if ((entity.getVariableEntrada1() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getVariableEntrada1(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "variableEntrada1");
            }

            if ((entity.getVariableEntrada2() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getVariableEntrada2(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "variableEntrada2");
            }

            if ((entity.getVariableEntrada3() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getVariableEntrada3(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "variableEntrada3");
            }

            if ((entity.getVariableSalida1() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getVariableSalida1(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "variableSalida1");
            }

            if ((entity.getVariableSalida2() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getVariableSalida2(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "variableSalida2");
            }

            tablaAnaliticaDAO.save(entity);
            
            if (dataTabAna != null) {

				for (TablaAnaliticaDetalleDTO valorDto : dataTabAna) {

					if (valorDto.getTablaAnaliticaDetalleId() == null) {

						TablaAnaliticaDetalle valor = new TablaAnaliticaDetalle();

						valor.setTablaAnalitica(valorDto.getTablaAnaliticaId_TablaAnalitica());
						valor.setValorVariableEntrada1(valorDto.getValorVariableEntrada1());
						valor.setValorVariableEntrada2(valorDto.getValorVariableEntrada2());
						valor.setValorVariableEntrada3(valorDto.getValorVariableEntrada3());
						valor.setValorVariableSalida1(valorDto.getValorVariableSalida1());
						valor.setValorVariableSalida2(valorDto.getValorVariableSalida2());
						valor.setTablaAnalitica(entity);

						tablaAnaliticaDetalleDAO.save(valor);
					}

				}
			}

            log.debug("save TablaAnalitica successful");
        } catch (Exception e) {
            log.error("save TablaAnalitica failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteTablaAnalitica(TablaAnalitica entity)
        throws Exception {
        log.debug("deleting TablaAnalitica instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("TablaAnalitica");
        }

        if (entity.getTablaAnaliticaId() == null) {
            throw new ZMessManager().new EmptyFieldException("tablaAnaliticaId");
        }

        List<TablaAnaliticaDetalle> tablaAnaliticaDetalles = null;

        try {
            tablaAnaliticaDetalles = tablaAnaliticaDetalleDAO.findByProperty("tablaAnalitica.tablaAnaliticaId",
                    entity.getTablaAnaliticaId());

            if (Utilities.validationsList(tablaAnaliticaDetalles) == true) {
                throw new ZMessManager().new DeletingException(
                    "tablaAnaliticaDetalles");
            }

            tablaAnaliticaDAO.delete(entity);

            log.debug("delete TablaAnalitica successful");
        } catch (Exception e) {
            log.error("delete TablaAnalitica failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateTablaAnalitica(TablaAnalitica entity, List<TablaAnaliticaDetalleDTO> dataTabAna)
        throws Exception {
        log.debug("updating TablaAnalitica instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "TablaAnalitica");
            }

            if ((entity.getCodigo() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getCodigo(),
                        20) == false)) {
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
                        60) == false)) {
                throw new ZMessManager().new NotValidFormatException("nombre");
            }

            if ((entity.getVariableEntrada1() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getVariableEntrada1(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "variableEntrada1");
            }

            if ((entity.getVariableEntrada2() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getVariableEntrada2(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "variableEntrada2");
            }

            if ((entity.getVariableEntrada3() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getVariableEntrada3(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "variableEntrada3");
            }

            if ((entity.getVariableSalida1() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getVariableSalida1(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "variableSalida1");
            }

            if ((entity.getVariableSalida2() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getVariableSalida2(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "variableSalida2");
            }

            tablaAnaliticaDAO.update(entity);
            
            if (dataTabAna != null) {

				for (TablaAnaliticaDetalleDTO valorDto : dataTabAna) {

					if (valorDto.getTablaAnaliticaDetalleId() == null) {

						TablaAnaliticaDetalle valor = new TablaAnaliticaDetalle();

						valor.setTablaAnalitica(valorDto.getTablaAnaliticaId_TablaAnalitica());
						valor.setValorVariableEntrada1(valorDto.getValorVariableEntrada1());
						valor.setValorVariableEntrada2(valorDto.getValorVariableEntrada2());
						valor.setValorVariableEntrada3(valorDto.getValorVariableEntrada3());
						valor.setValorVariableSalida1(valorDto.getValorVariableSalida1());
						valor.setValorVariableSalida2(valorDto.getValorVariableSalida2());
						valor.setTablaAnalitica(entity);

						tablaAnaliticaDetalleDAO.save(valor);
						
					} else  {
						
						TablaAnaliticaDetalle valor = tablaAnaliticaDetalleDAO.findById(valorDto.getTablaAnaliticaDetalleId());

						valor.setTablaAnalitica(valorDto.getTablaAnaliticaId_TablaAnalitica());
						valor.setValorVariableEntrada1(valorDto.getValorVariableEntrada1());
						valor.setValorVariableEntrada2(valorDto.getValorVariableEntrada2());
						valor.setValorVariableEntrada3(valorDto.getValorVariableEntrada3());
						valor.setValorVariableSalida1(valorDto.getValorVariableSalida1());
						valor.setValorVariableSalida2(valorDto.getValorVariableSalida2());
						valor.setTablaAnalitica(entity);

					}
				}
			}

            log.debug("update TablaAnalitica successful");
        } catch (Exception e) {
            log.error("update TablaAnalitica failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<TablaAnaliticaDTO> getDataTablaAnalitica()
        throws Exception {
        try {
            List<TablaAnalitica> tablaAnalitica = tablaAnaliticaDAO.findAll();

            List<TablaAnaliticaDTO> tablaAnaliticaDTO = new ArrayList<TablaAnaliticaDTO>();

            for (TablaAnalitica tablaAnaliticaTmp : tablaAnalitica) {
                TablaAnaliticaDTO tablaAnaliticaDTO2 = new TablaAnaliticaDTO();

                tablaAnaliticaDTO2.setTablaAnaliticaId(tablaAnaliticaTmp.getTablaAnaliticaId());
                tablaAnaliticaDTO2.setCodigo((tablaAnaliticaTmp.getCodigo() != null)
                    ? tablaAnaliticaTmp.getCodigo() : null);
                tablaAnaliticaDTO2.setCompania((tablaAnaliticaTmp.getCompania() != null)
                    ? tablaAnaliticaTmp.getCompania() : null);
                tablaAnaliticaDTO2.setEstado((tablaAnaliticaTmp.getEstado() != null)
                    ? tablaAnaliticaTmp.getEstado() : null);
                tablaAnaliticaDTO2.setFechaCreacion(tablaAnaliticaTmp.getFechaCreacion());
                tablaAnaliticaDTO2.setFechaModificacion(tablaAnaliticaTmp.getFechaModificacion());
                tablaAnaliticaDTO2.setInfoAdicional((tablaAnaliticaTmp.getInfoAdicional() != null)
                    ? tablaAnaliticaTmp.getInfoAdicional() : null);
                tablaAnaliticaDTO2.setInfoAdicional2((tablaAnaliticaTmp.getInfoAdicional2() != null)
                    ? tablaAnaliticaTmp.getInfoAdicional2() : null);
                tablaAnaliticaDTO2.setNombre((tablaAnaliticaTmp.getNombre() != null)
                    ? tablaAnaliticaTmp.getNombre() : null);
                tablaAnaliticaDTO2.setUsuario((tablaAnaliticaTmp.getUsuario() != null)
                        ? tablaAnaliticaTmp.getUsuario() : null);
                tablaAnaliticaDTO2.setVariableEntrada1((tablaAnaliticaTmp.getVariableEntrada1() != null)
                    ? tablaAnaliticaTmp.getVariableEntrada1() : null);
                tablaAnaliticaDTO2.setVariableEntrada2((tablaAnaliticaTmp.getVariableEntrada2() != null)
                    ? tablaAnaliticaTmp.getVariableEntrada2() : null);
                tablaAnaliticaDTO2.setVariableEntrada3((tablaAnaliticaTmp.getVariableEntrada3() != null)
                    ? tablaAnaliticaTmp.getVariableEntrada3() : null);
                tablaAnaliticaDTO2.setVariableSalida1((tablaAnaliticaTmp.getVariableSalida1() != null)
                    ? tablaAnaliticaTmp.getVariableSalida1() : null);
                tablaAnaliticaDTO2.setVariableSalida2((tablaAnaliticaTmp.getVariableSalida2() != null)
                    ? tablaAnaliticaTmp.getVariableSalida2() : null);
                tablaAnaliticaDTO.add(tablaAnaliticaDTO2);
            }

            return tablaAnaliticaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public TablaAnalitica getTablaAnalitica(Long tablaAnaliticaId)
        throws Exception {
        log.debug("getting TablaAnalitica instance");

        TablaAnalitica entity = null;

        try {
            entity = tablaAnaliticaDAO.findById(tablaAnaliticaId);
        } catch (Exception e) {
            log.error("get TablaAnalitica failed", e);
            throw new ZMessManager().new FindingException("TablaAnalitica");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<TablaAnalitica> findPageTablaAnalitica(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<TablaAnalitica> entity = null;

        try {
            entity = tablaAnaliticaDAO.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "TablaAnalitica Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberTablaAnalitica() throws Exception {
        Long entity = null;

        try {
            entity = tablaAnaliticaDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "TablaAnalitica Count");
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
    public List<TablaAnalitica> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<TablaAnalitica> list = new ArrayList<TablaAnalitica>();
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
            list = tablaAnaliticaDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
