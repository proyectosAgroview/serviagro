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

import co.com.arcosoft.dataaccess.dao.IDatPagosNotasClientesDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatPagosNotasClientes;
import co.com.arcosoft.modelo.dto.DatPagosNotasClientesDTO;
import co.com.arcosoft.utilities.Utilities;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("DatPagosNotasClientesLogic")
public class DatPagosNotasClientesLogic implements IDatPagosNotasClientesLogic {
    private static final Logger log = LoggerFactory.getLogger(DatPagosNotasClientesLogic.class);

    /**
     * DAO injected by Spring that manages DatPagosNotasClientes entities
     *
     */
    @Autowired
    private IDatPagosNotasClientesDAO datPagosNotasClientesDAO;

    /**
    * Logic injected by Spring that manages PersEmpr entities
    *
    */
    @Autowired
    IPersEmprLogic logicPersEmpr1;

    @Transactional(readOnly = true)
    public List<DatPagosNotasClientes> getDatPagosNotasClientes()
        throws Exception {
        log.debug("finding all DatPagosNotasClientes instances");

        List<DatPagosNotasClientes> list = new ArrayList<DatPagosNotasClientes>();

        try {
            list = datPagosNotasClientesDAO.findAll();
        } catch (Exception e) {
            log.error("finding all DatPagosNotasClientes failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "DatPagosNotasClientes");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveDatPagosNotasClientes(DatPagosNotasClientes entity)
        throws Exception {
        log.debug("saving DatPagosNotasClientes instance");

        try {
            if (entity.getPersEmpr() == null) {
                throw new ZMessManager().new ForeignException("persEmpr");
            }

            if ((entity.getDetalleNota() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDetalleNota(), 3900) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "detalleNota");
            }

            if ((entity.getEstado() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
                throw new ZMessManager().new NotValidFormatException("estado");
            }

            if ((entity.getFormaPago() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getFormaPago(), 60) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "formaPago");
            }

            if ((entity.getObservacion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getObservacion(), 3900) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "observacion");
            }

            if ((entity.getObservacionAnularReg() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getObservacionAnularReg(), 500) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "observacionAnularReg");
            }

            if ((entity.getValorCredito() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorCredito(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorCredito");
            }

            if ((entity.getValorDebito() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorDebito(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorDebito");
            }

            if (entity.getPersEmpr().getPersEmprId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "persEmprId_PersEmpr");
            }

          datPagosNotasClientesDAO.save(entity);

            log.debug("save DatPagosNotasClientes successful");
        } catch (Exception e) {
            log.error("save DatPagosNotasClientes failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteDatPagosNotasClientes(DatPagosNotasClientes entity)
        throws Exception {
        log.debug("deleting DatPagosNotasClientes instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion(
                "DatPagosNotasClientes");
        }

        if (entity.getDatPagosNotasClientesId() == null) {
            throw new ZMessManager().new EmptyFieldException(
                "datPagosNotasClientesId");
        }

        try {
            datPagosNotasClientesDAO.delete(entity);

            log.debug("delete DatPagosNotasClientes successful");
        } catch (Exception e) {
            log.error("delete DatPagosNotasClientes failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateDatPagosNotasClientes(DatPagosNotasClientes entity)
        throws Exception {
        log.debug("updating DatPagosNotasClientes instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "DatPagosNotasClientes");
            }

            if (entity.getPersEmpr() == null) {
                throw new ZMessManager().new ForeignException("persEmpr");
            }

            if ((entity.getDetalleNota() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDetalleNota(), 3900) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "detalleNota");
            }

            if ((entity.getEstado() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
                throw new ZMessManager().new NotValidFormatException("estado");
            }

            if ((entity.getFormaPago() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getFormaPago(), 60) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "formaPago");
            }

            if ((entity.getObservacion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getObservacion(), 3900) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "observacion");
            }

            if ((entity.getObservacionAnularReg() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getObservacionAnularReg(), 500) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "observacionAnularReg");
            }

            if ((entity.getValorCredito() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorCredito(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorCredito");
            }

            if ((entity.getValorDebito() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorDebito(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorDebito");
            }

            if (entity.getPersEmpr().getPersEmprId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "persEmprId_PersEmpr");
            }

            datPagosNotasClientesDAO.update(entity);

            log.debug("update DatPagosNotasClientes successful");
        } catch (Exception e) {
            log.error("update DatPagosNotasClientes failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<DatPagosNotasClientesDTO> getDataDatPagosNotasClientes()
        throws Exception {
        try {
            List<DatPagosNotasClientes> datPagosNotasClientes = datPagosNotasClientesDAO.findAll();

            List<DatPagosNotasClientesDTO> datPagosNotasClientesDTO = new ArrayList<DatPagosNotasClientesDTO>();

            for (DatPagosNotasClientes datPagosNotasClientesTmp : datPagosNotasClientes) {
                DatPagosNotasClientesDTO datPagosNotasClientesDTO2 = new DatPagosNotasClientesDTO();

                datPagosNotasClientesDTO2.setDatPagosNotasClientesId(datPagosNotasClientesTmp.getDatPagosNotasClientesId());
                datPagosNotasClientesDTO2.setCompania((datPagosNotasClientesTmp.getCompania() != null)
                    ? datPagosNotasClientesTmp.getCompania() : null);
                datPagosNotasClientesDTO2.setConsecutivo((datPagosNotasClientesTmp.getConsecutivo() != null)
                    ? datPagosNotasClientesTmp.getConsecutivo() : null);
                datPagosNotasClientesDTO2.setDetalleNota((datPagosNotasClientesTmp.getDetalleNota() != null)
                    ? datPagosNotasClientesTmp.getDetalleNota() : null);
                datPagosNotasClientesDTO2.setEstado((datPagosNotasClientesTmp.getEstado() != null)
                    ? datPagosNotasClientesTmp.getEstado() : null);
                datPagosNotasClientesDTO2.setFechaAnulacion(datPagosNotasClientesTmp.getFechaAnulacion());
                datPagosNotasClientesDTO2.setFechaCreacion(datPagosNotasClientesTmp.getFechaCreacion());
                datPagosNotasClientesDTO2.setFechaModificacion(datPagosNotasClientesTmp.getFechaModificacion());
                datPagosNotasClientesDTO2.setFechaRegistro(datPagosNotasClientesTmp.getFechaRegistro());
                datPagosNotasClientesDTO2.setFechaVencimiento(datPagosNotasClientesTmp.getFechaVencimiento());
                datPagosNotasClientesDTO2.setFormaPago((datPagosNotasClientesTmp.getFormaPago() != null)
                    ? datPagosNotasClientesTmp.getFormaPago() : null);
                datPagosNotasClientesDTO2.setNumFactura((datPagosNotasClientesTmp.getNumFactura() != null)
                    ? datPagosNotasClientesTmp.getNumFactura() : null);
                datPagosNotasClientesDTO2.setObservacion((datPagosNotasClientesTmp.getObservacion() != null)
                    ? datPagosNotasClientesTmp.getObservacion() : null);
                datPagosNotasClientesDTO2.setObservacionAnularReg((datPagosNotasClientesTmp.getObservacionAnularReg() != null)
                    ? datPagosNotasClientesTmp.getObservacionAnularReg() : null);
                datPagosNotasClientesDTO2.setUsuarioDigitacion((datPagosNotasClientesTmp.getUsuarioDigitacion() != null)
                    ? datPagosNotasClientesTmp.getUsuarioDigitacion() : null);
                datPagosNotasClientesDTO2.setValorCredito((datPagosNotasClientesTmp.getValorCredito() != null)
                    ? datPagosNotasClientesTmp.getValorCredito() : null);
                datPagosNotasClientesDTO2.setValorDebito((datPagosNotasClientesTmp.getValorDebito() != null)
                    ? datPagosNotasClientesTmp.getValorDebito() : null);
               
                

				if (datPagosNotasClientesTmp.getPersEmpr() != null) {
					datPagosNotasClientesDTO2.setPersEmprId_PersEmpr(datPagosNotasClientesTmp.getPersEmpr().getPersEmprId());
				} else {
					datPagosNotasClientesDTO2.setPersEmprId_PersEmpr(null);
				}
				
            
                
                
                datPagosNotasClientesDTO.add(datPagosNotasClientesDTO2);
            }

            return datPagosNotasClientesDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public DatPagosNotasClientes getDatPagosNotasClientes(
        Long datPagosNotasClientesId) throws Exception {
        log.debug("getting DatPagosNotasClientes instance");

        DatPagosNotasClientes entity = null;

        try {
            entity = datPagosNotasClientesDAO.findById(datPagosNotasClientesId);
        } catch (Exception e) {
            log.error("get DatPagosNotasClientes failed", e);
            throw new ZMessManager().new FindingException(
                "DatPagosNotasClientes");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<DatPagosNotasClientes> findPageDatPagosNotasClientes(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        List<DatPagosNotasClientes> entity = null;

        try {
            entity = datPagosNotasClientesDAO.findPage(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatPagosNotasClientes Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberDatPagosNotasClientes()
        throws Exception {
        Long entity = null;

        try {
            entity = datPagosNotasClientesDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatPagosNotasClientes Count");
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
    public List<DatPagosNotasClientes> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<DatPagosNotasClientes> list = new ArrayList<DatPagosNotasClientes>();
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
            list = datPagosNotasClientesDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
