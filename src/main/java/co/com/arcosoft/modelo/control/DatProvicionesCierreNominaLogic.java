package co.com.arcosoft.modelo.control;

import co.com.arcosoft.dataaccess.dao.*;
import co.com.arcosoft.exceptions.*;
import co.com.arcosoft.modelo.*;
import co.com.arcosoft.modelo.dto.DatProvicionesCierreNominaDTO;
import co.com.arcosoft.utilities.Utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("DatProvicionesCierreNominaLogic")
public class DatProvicionesCierreNominaLogic
    implements IDatProvicionesCierreNominaLogic {
    private static final Logger log = LoggerFactory.getLogger(DatProvicionesCierreNominaLogic.class);

    /**
     * DAO injected by Spring that manages DatProvicionesCierreNomina entities
     *
     */
    @Autowired
    private IDatProvicionesCierreNominaDAO datProvicionesCierreNominaDAO;

    /**
    * Logic injected by Spring that manages ConceptoNomina entities
    *
    */
    @Autowired
    IConceptoNominaLogic logicConceptoNomina1;

    /**
    * Logic injected by Spring that manages Trabajador entities
    *
    */
    @Autowired
    ITrabajadorLogic logicTrabajador2;

    @Transactional(readOnly = true)
    public List<DatProvicionesCierreNomina> getDatProvicionesCierreNomina()
        throws Exception {
        log.debug("finding all DatProvicionesCierreNomina instances");

        List<DatProvicionesCierreNomina> list = new ArrayList<DatProvicionesCierreNomina>();

        try {
            list = datProvicionesCierreNominaDAO.findAll();
        } catch (Exception e) {
            log.error("finding all DatProvicionesCierreNomina failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "DatProvicionesCierreNomina");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveDatProvicionesCierreNomina(
        DatProvicionesCierreNomina entity) throws Exception {
        log.debug("saving DatProvicionesCierreNomina instance");

        try {
            if (entity.getConceptoNomina() == null) {
                throw new ZMessManager().new ForeignException("conceptoNomina");
            }

            if (entity.getTrabajador() == null) {
                throw new ZMessManager().new ForeignException("trabajador");
            }

            if ((entity.getDevengos() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getDevengos(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException("devengos");
            }

            if ((entity.getPeriodoLiquidacion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getPeriodoLiquidacion(), 200) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "periodoLiquidacion");
            }

            if ((entity.getTipoMovimiento() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getTipoMovimiento(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "tipoMovimiento");
            }

            if ((entity.getValorDeduccion() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorDeduccion(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorDeduccion");
            }

            if (entity.getConceptoNomina().getCeptoNominaId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "ceptoNominaId_ConceptoNomina");
            }

            if (entity.getTrabajador().getTrabId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "trabId_Trabajador");
            }

            datProvicionesCierreNominaDAO.save(entity);

            log.debug("save DatProvicionesCierreNomina successful");
        } catch (Exception e) {
            log.error("save DatProvicionesCierreNomina failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteDatProvicionesCierreNomina(
        DatProvicionesCierreNomina entity) throws Exception {
        log.debug("deleting DatProvicionesCierreNomina instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion(
                "DatProvicionesCierreNomina");
        }

        if (entity.getDatProvicionesCierreNominaId() == null) {
            throw new ZMessManager().new EmptyFieldException(
                "datProvicionesCierreNominaId");
        }

        try {
            datProvicionesCierreNominaDAO.delete(entity);

            log.debug("delete DatProvicionesCierreNomina successful");
        } catch (Exception e) {
            log.error("delete DatProvicionesCierreNomina failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateDatProvicionesCierreNomina(
        DatProvicionesCierreNomina entity) throws Exception {
        log.debug("updating DatProvicionesCierreNomina instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "DatProvicionesCierreNomina");
            }

            if (entity.getConceptoNomina() == null) {
                throw new ZMessManager().new ForeignException("conceptoNomina");
            }

            if (entity.getTrabajador() == null) {
                throw new ZMessManager().new ForeignException("trabajador");
            }

            if ((entity.getDevengos() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getDevengos(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException("devengos");
            }

            if ((entity.getPeriodoLiquidacion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getPeriodoLiquidacion(), 200) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "periodoLiquidacion");
            }

            if ((entity.getTipoMovimiento() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getTipoMovimiento(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "tipoMovimiento");
            }

            if ((entity.getValorDeduccion() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorDeduccion(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorDeduccion");
            }

            if (entity.getConceptoNomina().getCeptoNominaId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "ceptoNominaId_ConceptoNomina");
            }

            if (entity.getTrabajador().getTrabId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "trabId_Trabajador");
            }

            datProvicionesCierreNominaDAO.update(entity);

            log.debug("update DatProvicionesCierreNomina successful");
        } catch (Exception e) {
            log.error("update DatProvicionesCierreNomina failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<DatProvicionesCierreNominaDTO> getDataDatProvicionesCierreNomina()
        throws Exception {
        try {
            List<DatProvicionesCierreNomina> datProvicionesCierreNomina = datProvicionesCierreNominaDAO.findAll();

            List<DatProvicionesCierreNominaDTO> datProvicionesCierreNominaDTO = new ArrayList<DatProvicionesCierreNominaDTO>();

            for (DatProvicionesCierreNomina datProvicionesCierreNominaTmp : datProvicionesCierreNomina) {
                DatProvicionesCierreNominaDTO datProvicionesCierreNominaDTO2 = new DatProvicionesCierreNominaDTO();

                datProvicionesCierreNominaDTO2.setDatProvicionesCierreNominaId(datProvicionesCierreNominaTmp.getDatProvicionesCierreNominaId());
                datProvicionesCierreNominaDTO2.setAnioRegistro((datProvicionesCierreNominaTmp.getAnioRegistro() != null)
                    ? datProvicionesCierreNominaTmp.getAnioRegistro() : null);
                datProvicionesCierreNominaDTO2.setCompania((datProvicionesCierreNominaTmp.getCompania() != null)
                    ? datProvicionesCierreNominaTmp.getCompania() : null);
                datProvicionesCierreNominaDTO2.setDevengos((datProvicionesCierreNominaTmp.getDevengos() != null)
                    ? datProvicionesCierreNominaTmp.getDevengos() : null);
                datProvicionesCierreNominaDTO2.setFechaCreacion(datProvicionesCierreNominaTmp.getFechaCreacion());
                datProvicionesCierreNominaDTO2.setFechaFinal(datProvicionesCierreNominaTmp.getFechaFinal());
                datProvicionesCierreNominaDTO2.setFechaInicial(datProvicionesCierreNominaTmp.getFechaInicial());
                datProvicionesCierreNominaDTO2.setFechaModificacion(datProvicionesCierreNominaTmp.getFechaModificacion());
                datProvicionesCierreNominaDTO2.setGastoId((datProvicionesCierreNominaTmp.getGastoId() != null)
                    ? datProvicionesCierreNominaTmp.getGastoId() : null);
                datProvicionesCierreNominaDTO2.setMes((datProvicionesCierreNominaTmp.getMes() != null)
                    ? datProvicionesCierreNominaTmp.getMes() : null);
                datProvicionesCierreNominaDTO2.setPeriodoLiquidacion((datProvicionesCierreNominaTmp.getPeriodoLiquidacion() != null)
                    ? datProvicionesCierreNominaTmp.getPeriodoLiquidacion() : null);
                datProvicionesCierreNominaDTO2.setTipoMovimiento((datProvicionesCierreNominaTmp.getTipoMovimiento() != null)
                    ? datProvicionesCierreNominaTmp.getTipoMovimiento() : null);
                datProvicionesCierreNominaDTO2.setUsuarioDigitacion((datProvicionesCierreNominaTmp.getUsuarioDigitacion() != null)
                    ? datProvicionesCierreNominaTmp.getUsuarioDigitacion() : null);
                datProvicionesCierreNominaDTO2.setValorDeduccion((datProvicionesCierreNominaTmp.getValorDeduccion() != null)
                    ? datProvicionesCierreNominaTmp.getValorDeduccion() : null);
                datProvicionesCierreNominaDTO2.setCeptoNominaId_ConceptoNomina((datProvicionesCierreNominaTmp.getConceptoNomina()
                                                                                                             .getCeptoNominaId() != null)
                    ? datProvicionesCierreNominaTmp.getConceptoNomina()
                                                   .getCeptoNominaId() : null);

                if (datProvicionesCierreNominaTmp.getTrabajador() != null) {
                    datProvicionesCierreNominaDTO2.setTrabId_Trabajador(datProvicionesCierreNominaTmp.getTrabajador()
                                                                                                     .getTrabId());
                } else {
                    datProvicionesCierreNominaDTO2.setTrabId_Trabajador(null);
                }

                datProvicionesCierreNominaDTO.add(datProvicionesCierreNominaDTO2);
            }

            return datProvicionesCierreNominaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public DatProvicionesCierreNomina getDatProvicionesCierreNomina(
        Long datProvicionesCierreNominaId) throws Exception {
        log.debug("getting DatProvicionesCierreNomina instance");

        DatProvicionesCierreNomina entity = null;

        try {
            entity = datProvicionesCierreNominaDAO.findById(datProvicionesCierreNominaId);
        } catch (Exception e) {
            log.error("get DatProvicionesCierreNomina failed", e);
            throw new ZMessManager().new FindingException(
                "DatProvicionesCierreNomina");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<DatProvicionesCierreNomina> findPageDatProvicionesCierreNomina(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        List<DatProvicionesCierreNomina> entity = null;

        try {
            entity = datProvicionesCierreNominaDAO.findPage(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatProvicionesCierreNomina Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberDatProvicionesCierreNomina()
        throws Exception {
        Long entity = null;

        try {
            entity = datProvicionesCierreNominaDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatProvicionesCierreNomina Count");
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
    public List<DatProvicionesCierreNomina> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<DatProvicionesCierreNomina> list = new ArrayList<DatProvicionesCierreNomina>();
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
            list = datProvicionesCierreNominaDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
