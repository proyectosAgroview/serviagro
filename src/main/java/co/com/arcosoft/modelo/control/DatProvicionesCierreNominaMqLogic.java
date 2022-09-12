package co.com.arcosoft.modelo.control;

import co.com.arcosoft.dataaccess.dao.*;
import co.com.arcosoft.exceptions.*;
import co.com.arcosoft.modelo.*;
import co.com.arcosoft.modelo.dto.DatProvicionesCierreNominaMqDTO;
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
@Service("DatProvicionesCierreNominaMqLogic")
public class DatProvicionesCierreNominaMqLogic
    implements IDatProvicionesCierreNominaMqLogic {
    private static final Logger log = LoggerFactory.getLogger(DatProvicionesCierreNominaMqLogic.class);

    /**
     * DAO injected by Spring that manages DatProvicionesCierreNominaMq entities
     *
     */
    @Autowired
    private IDatProvicionesCierreNominaMqDAO datProvicionesCierreNominaMqDAO;

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
    public List<DatProvicionesCierreNominaMq> getDatProvicionesCierreNominaMq()
        throws Exception {
        log.debug("finding all DatProvicionesCierreNominaMq instances");

        List<DatProvicionesCierreNominaMq> list = new ArrayList<DatProvicionesCierreNominaMq>();

        try {
            list = datProvicionesCierreNominaMqDAO.findAll();
        } catch (Exception e) {
            log.error("finding all DatProvicionesCierreNominaMq failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "DatProvicionesCierreNominaMq");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveDatProvicionesCierreNominaMq(
        DatProvicionesCierreNominaMq entity) throws Exception {
        log.debug("saving DatProvicionesCierreNominaMq instance");

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

            datProvicionesCierreNominaMqDAO.save(entity);

            log.debug("save DatProvicionesCierreNominaMq successful");
        } catch (Exception e) {
            log.error("save DatProvicionesCierreNominaMq failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteDatProvicionesCierreNominaMq(
        DatProvicionesCierreNominaMq entity) throws Exception {
        log.debug("deleting DatProvicionesCierreNominaMq instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion(
                "DatProvicionesCierreNominaMq");
        }

        if (entity.getDatProvicionesCierreNominaMqId() == null) {
            throw new ZMessManager().new EmptyFieldException(
                "datProvicionesCierreNominaMqId");
        }

        try {
            datProvicionesCierreNominaMqDAO.delete(entity);

            log.debug("delete DatProvicionesCierreNominaMq successful");
        } catch (Exception e) {
            log.error("delete DatProvicionesCierreNominaMq failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateDatProvicionesCierreNominaMq(
        DatProvicionesCierreNominaMq entity) throws Exception {
        log.debug("updating DatProvicionesCierreNominaMq instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "DatProvicionesCierreNominaMq");
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

            datProvicionesCierreNominaMqDAO.update(entity);

            log.debug("update DatProvicionesCierreNominaMq successful");
        } catch (Exception e) {
            log.error("update DatProvicionesCierreNominaMq failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<DatProvicionesCierreNominaMqDTO> getDataDatProvicionesCierreNominaMq()
        throws Exception {
        try {
            List<DatProvicionesCierreNominaMq> datProvicionesCierreNominaMq = datProvicionesCierreNominaMqDAO.findAll();

            List<DatProvicionesCierreNominaMqDTO> datProvicionesCierreNominaMqDTO =
                new ArrayList<DatProvicionesCierreNominaMqDTO>();

            for (DatProvicionesCierreNominaMq datProvicionesCierreNominaMqTmp : datProvicionesCierreNominaMq) {
                DatProvicionesCierreNominaMqDTO datProvicionesCierreNominaMqDTO2 =
                    new DatProvicionesCierreNominaMqDTO();

                datProvicionesCierreNominaMqDTO2.setDatProvicionesCierreNominaMqId(datProvicionesCierreNominaMqTmp.getDatProvicionesCierreNominaMqId());
                datProvicionesCierreNominaMqDTO2.setAnioRegistro((datProvicionesCierreNominaMqTmp.getAnioRegistro() != null)
                    ? datProvicionesCierreNominaMqTmp.getAnioRegistro() : null);
                datProvicionesCierreNominaMqDTO2.setCompania((datProvicionesCierreNominaMqTmp.getCompania() != null)
                    ? datProvicionesCierreNominaMqTmp.getCompania() : null);
                datProvicionesCierreNominaMqDTO2.setDevengos((datProvicionesCierreNominaMqTmp.getDevengos() != null)
                    ? datProvicionesCierreNominaMqTmp.getDevengos() : null);
                datProvicionesCierreNominaMqDTO2.setFechaCreacion(datProvicionesCierreNominaMqTmp.getFechaCreacion());
                datProvicionesCierreNominaMqDTO2.setFechaFinal(datProvicionesCierreNominaMqTmp.getFechaFinal());
                datProvicionesCierreNominaMqDTO2.setFechaInicial(datProvicionesCierreNominaMqTmp.getFechaInicial());
                datProvicionesCierreNominaMqDTO2.setFechaModificacion(datProvicionesCierreNominaMqTmp.getFechaModificacion());
                datProvicionesCierreNominaMqDTO2.setGastoId((datProvicionesCierreNominaMqTmp.getGastoId() != null)
                    ? datProvicionesCierreNominaMqTmp.getGastoId() : null);
                datProvicionesCierreNominaMqDTO2.setMes((datProvicionesCierreNominaMqTmp.getMes() != null)
                    ? datProvicionesCierreNominaMqTmp.getMes() : null);
                datProvicionesCierreNominaMqDTO2.setPeriodoLiquidacion((datProvicionesCierreNominaMqTmp.getPeriodoLiquidacion() != null)
                    ? datProvicionesCierreNominaMqTmp.getPeriodoLiquidacion()
                    : null);
                datProvicionesCierreNominaMqDTO2.setTipoMovimiento((datProvicionesCierreNominaMqTmp.getTipoMovimiento() != null)
                    ? datProvicionesCierreNominaMqTmp.getTipoMovimiento() : null);
                datProvicionesCierreNominaMqDTO2.setUsuarioDigitacion((datProvicionesCierreNominaMqTmp.getUsuarioDigitacion() != null)
                    ? datProvicionesCierreNominaMqTmp.getUsuarioDigitacion()
                    : null);
                datProvicionesCierreNominaMqDTO2.setValorDeduccion((datProvicionesCierreNominaMqTmp.getValorDeduccion() != null)
                    ? datProvicionesCierreNominaMqTmp.getValorDeduccion() : null);
                datProvicionesCierreNominaMqDTO2.setCeptoNominaId_ConceptoNomina((datProvicionesCierreNominaMqTmp.getConceptoNomina()
                                                                                                                 .getCeptoNominaId() != null)
                    ? datProvicionesCierreNominaMqTmp.getConceptoNomina()
                                                     .getCeptoNominaId() : null);

                if (datProvicionesCierreNominaMqTmp.getTrabajador() != null) {
                    datProvicionesCierreNominaMqDTO2.setTrabId_Trabajador(datProvicionesCierreNominaMqTmp.getTrabajador()
                                                                                                         .getTrabId());
                } else {
                    datProvicionesCierreNominaMqDTO2.setTrabId_Trabajador(null);
                }

                if (datProvicionesCierreNominaMqTmp.getCentCostId() != null) {
                    datProvicionesCierreNominaMqDTO2.setCentCostId(datProvicionesCierreNominaMqTmp.getCentCostId());
                } else {
                    datProvicionesCierreNominaMqDTO2.setCentCostId(null);
                }

                
                datProvicionesCierreNominaMqDTO.add(datProvicionesCierreNominaMqDTO2);
            }

            return datProvicionesCierreNominaMqDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public DatProvicionesCierreNominaMq getDatProvicionesCierreNominaMq(
        Long datProvicionesCierreNominaMqId) throws Exception {
        log.debug("getting DatProvicionesCierreNominaMq instance");

        DatProvicionesCierreNominaMq entity = null;

        try {
            entity = datProvicionesCierreNominaMqDAO.findById(datProvicionesCierreNominaMqId);
        } catch (Exception e) {
            log.error("get DatProvicionesCierreNominaMq failed", e);
            throw new ZMessManager().new FindingException(
                "DatProvicionesCierreNominaMq");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<DatProvicionesCierreNominaMq> findPageDatProvicionesCierreNominaMq(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        List<DatProvicionesCierreNominaMq> entity = null;

        try {
            entity = datProvicionesCierreNominaMqDAO.findPage(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatProvicionesCierreNominaMq Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberDatProvicionesCierreNominaMq()
        throws Exception {
        Long entity = null;

        try {
            entity = datProvicionesCierreNominaMqDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatProvicionesCierreNominaMq Count");
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
    public List<DatProvicionesCierreNominaMq> findByCriteria(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        List<DatProvicionesCierreNominaMq> list = new ArrayList<DatProvicionesCierreNominaMq>();
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
            list = datProvicionesCierreNominaMqDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
