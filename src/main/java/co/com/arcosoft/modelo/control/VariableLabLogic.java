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

import co.com.arcosoft.dataaccess.dao.IAnaLaboratorioVariableDAO;
import co.com.arcosoft.dataaccess.dao.IDatAnaLaboratorioDetDAO;
import co.com.arcosoft.dataaccess.dao.IVariableLabDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.AnaLaboratorioVariable;
import co.com.arcosoft.modelo.DatAnaLaboratorioDet;
import co.com.arcosoft.modelo.VariableLab;
import co.com.arcosoft.modelo.dto.VariableLabDTO;
import co.com.arcosoft.utilities.Utilities;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("VariableLabLogic")
public class VariableLabLogic implements IVariableLabLogic {
    private static final Logger log = LoggerFactory.getLogger(VariableLabLogic.class);

    /**
     * DAO injected by Spring that manages VariableLab entities
     *
     */
    @Autowired
    private IVariableLabDAO variableLabDAO;

    /**
    * DAO injected by Spring that manages AnaLaboratorioVariable entities
    *
    */
    @Autowired
    private IAnaLaboratorioVariableDAO anaLaboratorioVariableDAO;

    /**
    * DAO injected by Spring that manages DatAnaLaboratorioDet entities
    *
    */
    @Autowired
    private IDatAnaLaboratorioDetDAO datAnaLaboratorioDetDAO;

    @Transactional(readOnly = true)
    public List<VariableLab> getVariableLab() throws Exception {
        log.debug("finding all VariableLab instances");

        List<VariableLab> list = new ArrayList<VariableLab>();

        try {
            list = variableLabDAO.findAll();
        } catch (Exception e) {
            log.error("finding all VariableLab failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "VariableLab");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveVariableLab(VariableLab entity) throws Exception {
        log.debug("saving VariableLab instance");

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

            if ((entity.getFormula() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getFormula(), 3000) == false)) {
                throw new ZMessManager().new NotValidFormatException("formula");
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

            if ((entity.getPeriocidadVariable() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getPeriocidadVariable(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "periocidadVariable");
            }

            if ((entity.getTipoDato() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getTipoDato(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException("tipoDato");
            }

            if ((entity.getTipoDeAcumulado() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getTipoDeAcumulado(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "tipoDeAcumulado");
            }

            if ((entity.getTipoVariable() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getTipoVariable(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "tipoVariable");
            }

            if ((entity.getValorMaximo() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorMaximo(), 6, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorMaximo");
            }

            if ((entity.getValorMinimo() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorMinimo(), 6, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorMinimo");
            }


            variableLabDAO.save(entity);

            log.debug("save VariableLab successful");
        } catch (Exception e) {
            log.error("save VariableLab failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteVariableLab(VariableLab entity) throws Exception {
        log.debug("deleting VariableLab instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("VariableLab");
        }

        if (entity.getVariableLabId() == null) {
            throw new ZMessManager().new EmptyFieldException("variableLabId");
        }

        List<AnaLaboratorioVariable> anaLaboratorioVariables = null;
        List<DatAnaLaboratorioDet> datAnaLaboratorioDets = null;

        try {
            anaLaboratorioVariables = anaLaboratorioVariableDAO.findByProperty("variableLab.variableLabId",
                    entity.getVariableLabId());

            if (Utilities.validationsList(anaLaboratorioVariables) == true) {
                throw new ZMessManager().new DeletingException(
                    "anaLaboratorioVariables");
            }

            datAnaLaboratorioDets = datAnaLaboratorioDetDAO.findByProperty("variableLab.variableLabId",
                    entity.getVariableLabId());

            if (Utilities.validationsList(datAnaLaboratorioDets) == true) {
                throw new ZMessManager().new DeletingException(
                    "datAnaLaboratorioDets");
            }

            variableLabDAO.delete(entity);

            log.debug("delete VariableLab successful");
        } catch (Exception e) {
            log.error("delete VariableLab failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateVariableLab(VariableLab entity) throws Exception {
        log.debug("updating VariableLab instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("VariableLab");
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

            if ((entity.getFormula() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getFormula(), 3000) == false)) {
                throw new ZMessManager().new NotValidFormatException("formula");
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

            if ((entity.getPeriocidadVariable() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getPeriocidadVariable(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "periocidadVariable");
            }

            if ((entity.getTipoDato() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getTipoDato(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException("tipoDato");
            }

            if ((entity.getTipoDeAcumulado() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getTipoDeAcumulado(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "tipoDeAcumulado");
            }

            if ((entity.getTipoVariable() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getTipoVariable(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "tipoVariable");
            }

            if ((entity.getValorMaximo() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorMaximo(), 6, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorMaximo");
            }

            if ((entity.getValorMinimo() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorMinimo(), 6, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorMinimo");
            }

            variableLabDAO.update(entity);

            log.debug("update VariableLab successful");
        } catch (Exception e) {
            log.error("update VariableLab failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<VariableLabDTO> getDataVariableLab() throws Exception {
        try {
            List<VariableLab> variableLab = variableLabDAO.findAll();

            List<VariableLabDTO> variableLabDTO = new ArrayList<VariableLabDTO>();

            for (VariableLab variableLabTmp : variableLab) {
                VariableLabDTO variableLabDTO2 = new VariableLabDTO();

                variableLabDTO2.setVariableLabId(variableLabTmp.getVariableLabId());
                variableLabDTO2.setCodigo((variableLabTmp.getCodigo() != null)
                    ? variableLabTmp.getCodigo() : null);
                variableLabDTO2.setConsultaSql((variableLabTmp.getConsultaSql() != null)
                        ? variableLabTmp.getConsultaSql() : null);
                variableLabDTO2.setCompania((variableLabTmp.getCompania() != null)
                    ? variableLabTmp.getCompania() : null);
                variableLabDTO2.setEstado((variableLabTmp.getEstado() != null)
                    ? variableLabTmp.getEstado() : null);
                variableLabDTO2.setFechaCreacion(variableLabTmp.getFechaCreacion());
                variableLabDTO2.setFechaModificacion(variableLabTmp.getFechaModificacion());
                variableLabDTO2.setFormula((variableLabTmp.getFormula() != null)
                    ? variableLabTmp.getFormula() : null);
                variableLabDTO2.setInfoAdicional((variableLabTmp.getInfoAdicional() != null)
                    ? variableLabTmp.getInfoAdicional() : null);
                variableLabDTO2.setInfoAdicional2((variableLabTmp.getInfoAdicional2() != null)
                    ? variableLabTmp.getInfoAdicional2() : null);
                variableLabDTO2.setNombre((variableLabTmp.getNombre() != null)
                    ? variableLabTmp.getNombre() : null);
                variableLabDTO2.setNumeroDecimales((variableLabTmp.getNumeroDecimales() != null)
                    ? variableLabTmp.getNumeroDecimales() : null);
                variableLabDTO2.setPeriocidadVariable((variableLabTmp.getPeriocidadVariable() != null)
                    ? variableLabTmp.getPeriocidadVariable() : null);
                variableLabDTO2.setTipoDato((variableLabTmp.getTipoDato() != null)
                    ? variableLabTmp.getTipoDato() : null);
                variableLabDTO2.setTipoDeAcumulado((variableLabTmp.getTipoDeAcumulado() != null)
                    ? variableLabTmp.getTipoDeAcumulado() : null);
                variableLabDTO2.setTipoVariable((variableLabTmp.getTipoVariable() != null)
                    ? variableLabTmp.getTipoVariable() : null);
                variableLabDTO2.setValorMaximo((variableLabTmp.getValorMaximo() != null)
                    ? variableLabTmp.getValorMaximo() : null);
                variableLabDTO2.setValorMinimo((variableLabTmp.getValorMinimo() != null)
                    ? variableLabTmp.getValorMinimo() : null);
                variableLabDTO.add(variableLabDTO2);
            }

            return variableLabDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public VariableLab getVariableLab(Long variableLabId)
        throws Exception {
        log.debug("getting VariableLab instance");

        VariableLab entity = null;

        try {
            entity = variableLabDAO.findById(variableLabId);
        } catch (Exception e) {
            log.error("get VariableLab failed", e);
            throw new ZMessManager().new FindingException("VariableLab");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<VariableLab> findPageVariableLab(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<VariableLab> entity = null;

        try {
            entity = variableLabDAO.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("VariableLab Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberVariableLab() throws Exception {
        Long entity = null;

        try {
            entity = variableLabDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("VariableLab Count");
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
    public List<VariableLab> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<VariableLab> list = new ArrayList<VariableLab>();
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
            list = variableLabDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
