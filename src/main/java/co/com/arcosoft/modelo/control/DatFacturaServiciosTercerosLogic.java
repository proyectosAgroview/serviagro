package co.com.arcosoft.modelo.control;

import co.com.arcosoft.dataaccess.dao.*;
import co.com.arcosoft.exceptions.*;
import co.com.arcosoft.modelo.*;
import co.com.arcosoft.modelo.dto.DatFacturaServiciosTercerosDTO;
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
@Service("DatFacturaServiciosTercerosLogic")
public class DatFacturaServiciosTercerosLogic
    implements IDatFacturaServiciosTercerosLogic {
    private static final Logger log = LoggerFactory.getLogger(DatFacturaServiciosTercerosLogic.class);

    /**
     * DAO injected by Spring that manages DatFacturaServiciosTerceros entities
     *
     */
    @Autowired
    private IDatFacturaServiciosTercerosDAO datFacturaServiciosTercerosDAO;

    /**
    * Logic injected by Spring that manages PersEmpr entities
    *
    */
    @Autowired
    IPersEmprLogic logicPersEmpr1;

    /**
    * Logic injected by Spring that manages PersEmpr entities
    *
    */
    @Autowired
    IPersEmprLogic logicPersEmpr2;

    @Transactional(readOnly = true)
    public List<DatFacturaServiciosTerceros> getDatFacturaServiciosTerceros()
        throws Exception {
        log.debug("finding all DatFacturaServiciosTerceros instances");

        List<DatFacturaServiciosTerceros> list = new ArrayList<DatFacturaServiciosTerceros>();

        try {
            list = datFacturaServiciosTercerosDAO.findAll();
        } catch (Exception e) {
            log.error("finding all DatFacturaServiciosTerceros failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "DatFacturaServiciosTerceros");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveDatFacturaServiciosTerceros(
        DatFacturaServiciosTerceros entity) throws Exception {
        log.debug("saving DatFacturaServiciosTerceros instance");

        try {
            if (entity.getPersEmprByClienteId() == null) {
                throw new ZMessManager().new ForeignException(
                    "persEmprByClienteId");
            }

            if (entity.getPersEmprByPersEmprId() == null) {
                throw new ZMessManager().new ForeignException(
                    "persEmprByPersEmprId");
            }

            if ((entity.getDetalleFactura() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDetalleFactura(), 3900) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "detalleFactura");
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

            if ((entity.getPrefijo() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getPrefijo(), 30) == false)) {
                throw new ZMessManager().new NotValidFormatException("prefijo");
            }

            if ((entity.getRetencion() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getRetencion(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "retencion");
            }

            if ((entity.getValorBaseIva() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorBaseIva(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorBaseIva");
            }

            if ((entity.getValorDescuento() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorDescuento(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorDescuento");
            }

            if ((entity.getValorDescuentoCenicana() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorDescuentoCenicana(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorDescuentoCenicana");
            }

            if ((entity.getValorDescuentoTimbre() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorDescuentoTimbre(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorDescuentoTimbre");
            }

            if ((entity.getValorFactura() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorFactura(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorFactura");
            }

            if ((entity.getValorIva() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorIva(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException("valorIva");
            }

            if ((entity.getValorReteIca() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorReteIca(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorReteIca");
            }

            if ((entity.getValorReteIva() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorReteIva(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorReteIva");
            }

            if ((entity.getValorRetencionContrato() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorRetencionContrato(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorRetencionContrato");
            }

       

            datFacturaServiciosTercerosDAO.save(entity);

            log.debug("save DatFacturaServiciosTerceros successful");
        } catch (Exception e) {
            log.error("save DatFacturaServiciosTerceros failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteDatFacturaServiciosTerceros(
        DatFacturaServiciosTerceros entity) throws Exception {
        log.debug("deleting DatFacturaServiciosTerceros instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion(
                "DatFacturaServiciosTerceros");
        }

        if (entity.getDatFacturaServiciosTercerosId() == null) {
            throw new ZMessManager().new EmptyFieldException(
                "datFacturaServiciosTercerosId");
        }

        try {
            datFacturaServiciosTercerosDAO.delete(entity);

            log.debug("delete DatFacturaServiciosTerceros successful");
        } catch (Exception e) {
            log.error("delete DatFacturaServiciosTerceros failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateDatFacturaServiciosTerceros(
        DatFacturaServiciosTerceros entity) throws Exception {
        log.debug("updating DatFacturaServiciosTerceros instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "DatFacturaServiciosTerceros");
            }

            if (entity.getPersEmprByClienteId() == null) {
                throw new ZMessManager().new ForeignException(
                    "persEmprByClienteId");
            }

            if (entity.getPersEmprByPersEmprId() == null) {
                throw new ZMessManager().new ForeignException(
                    "persEmprByPersEmprId");
            }

            if ((entity.getDetalleFactura() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDetalleFactura(), 3900) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "detalleFactura");
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

            if ((entity.getPrefijo() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getPrefijo(), 30) == false)) {
                throw new ZMessManager().new NotValidFormatException("prefijo");
            }

            if ((entity.getRetencion() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getRetencion(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "retencion");
            }

            if ((entity.getValorBaseIva() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorBaseIva(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorBaseIva");
            }

            if ((entity.getValorDescuento() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorDescuento(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorDescuento");
            }

            if ((entity.getValorDescuentoCenicana() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorDescuentoCenicana(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorDescuentoCenicana");
            }

            if ((entity.getValorDescuentoTimbre() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorDescuentoTimbre(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorDescuentoTimbre");
            }

            if ((entity.getValorFactura() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorFactura(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorFactura");
            }

            if ((entity.getValorIva() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorIva(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException("valorIva");
            }

            if ((entity.getValorReteIca() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorReteIca(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorReteIca");
            }

            if ((entity.getValorReteIva() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorReteIva(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorReteIva");
            }

            if ((entity.getValorRetencionContrato() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorRetencionContrato(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorRetencionContrato");
            }

          

            datFacturaServiciosTercerosDAO.update(entity);

            log.debug("update DatFacturaServiciosTerceros successful");
        } catch (Exception e) {
            log.error("update DatFacturaServiciosTerceros failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<DatFacturaServiciosTercerosDTO> getDataDatFacturaServiciosTerceros()
        throws Exception {
        try {
            List<DatFacturaServiciosTerceros> datFacturaServiciosTerceros = datFacturaServiciosTercerosDAO.findAll();

            List<DatFacturaServiciosTercerosDTO> datFacturaServiciosTercerosDTO = new ArrayList<DatFacturaServiciosTercerosDTO>();

            for (DatFacturaServiciosTerceros datFacturaServiciosTercerosTmp : datFacturaServiciosTerceros) {
                DatFacturaServiciosTercerosDTO datFacturaServiciosTercerosDTO2 = new DatFacturaServiciosTercerosDTO();

                datFacturaServiciosTercerosDTO2.setDatFacturaServiciosTercerosId(datFacturaServiciosTercerosTmp.getDatFacturaServiciosTercerosId());
                datFacturaServiciosTercerosDTO2.setCentCostId((datFacturaServiciosTercerosTmp.getCentCostId() != null)
                    ? datFacturaServiciosTercerosTmp.getCentCostId() : null);
                datFacturaServiciosTercerosDTO2.setCompania((datFacturaServiciosTercerosTmp.getCompania() != null)
                    ? datFacturaServiciosTercerosTmp.getCompania() : null);
                datFacturaServiciosTercerosDTO2.setConsecutivo((datFacturaServiciosTercerosTmp.getConsecutivo() != null)
                    ? datFacturaServiciosTercerosTmp.getConsecutivo() : null);
                datFacturaServiciosTercerosDTO2.setDetalleFactura((datFacturaServiciosTercerosTmp.getDetalleFactura() != null)
                    ? datFacturaServiciosTercerosTmp.getDetalleFactura() : null);
                datFacturaServiciosTercerosDTO2.setEstado((datFacturaServiciosTercerosTmp.getEstado() != null)
                    ? datFacturaServiciosTercerosTmp.getEstado() : null);
                datFacturaServiciosTercerosDTO2.setFechaAnulacion(datFacturaServiciosTercerosTmp.getFechaAnulacion());
                datFacturaServiciosTercerosDTO2.setFechaCreacion(datFacturaServiciosTercerosTmp.getFechaCreacion());
                datFacturaServiciosTercerosDTO2.setFechaModificacion(datFacturaServiciosTercerosTmp.getFechaModificacion());
                datFacturaServiciosTercerosDTO2.setFechaRegistro(datFacturaServiciosTercerosTmp.getFechaRegistro());
                datFacturaServiciosTercerosDTO2.setFechaVencimiento(datFacturaServiciosTercerosTmp.getFechaVencimiento());
                datFacturaServiciosTercerosDTO2.setFormaPago((datFacturaServiciosTercerosTmp.getFormaPago() != null)
                    ? datFacturaServiciosTercerosTmp.getFormaPago() : null);
                datFacturaServiciosTercerosDTO2.setObservacion((datFacturaServiciosTercerosTmp.getObservacion() != null)
                    ? datFacturaServiciosTercerosTmp.getObservacion() : null);
                datFacturaServiciosTercerosDTO2.setObservacionAnularReg((datFacturaServiciosTercerosTmp.getObservacionAnularReg() != null)
                    ? datFacturaServiciosTercerosTmp.getObservacionAnularReg()
                    : null);
                datFacturaServiciosTercerosDTO2.setPlazo((datFacturaServiciosTercerosTmp.getPlazo() != null)
                    ? datFacturaServiciosTercerosTmp.getPlazo() : null);
                datFacturaServiciosTercerosDTO2.setPrefijo((datFacturaServiciosTercerosTmp.getPrefijo() != null)
                    ? datFacturaServiciosTercerosTmp.getPrefijo() : null);
                datFacturaServiciosTercerosDTO2.setRetencion((datFacturaServiciosTercerosTmp.getRetencion() != null)
                    ? datFacturaServiciosTercerosTmp.getRetencion() : null);
                datFacturaServiciosTercerosDTO2.setUsuarioDigitacion((datFacturaServiciosTercerosTmp.getUsuarioDigitacion() != null)
                    ? datFacturaServiciosTercerosTmp.getUsuarioDigitacion() : null);
                datFacturaServiciosTercerosDTO2.setValorBaseIva((datFacturaServiciosTercerosTmp.getValorBaseIva() != null)
                    ? datFacturaServiciosTercerosTmp.getValorBaseIva() : null);
                datFacturaServiciosTercerosDTO2.setValorDescuento((datFacturaServiciosTercerosTmp.getValorDescuento() != null)
                    ? datFacturaServiciosTercerosTmp.getValorDescuento() : null);
                datFacturaServiciosTercerosDTO2.setValorDescuentoCenicana((datFacturaServiciosTercerosTmp.getValorDescuentoCenicana() != null)
                    ? datFacturaServiciosTercerosTmp.getValorDescuentoCenicana()
                    : null);
                datFacturaServiciosTercerosDTO2.setValorDescuentoTimbre((datFacturaServiciosTercerosTmp.getValorDescuentoTimbre() != null)
                    ? datFacturaServiciosTercerosTmp.getValorDescuentoTimbre()
                    : null);
                datFacturaServiciosTercerosDTO2.setValorFactura((datFacturaServiciosTercerosTmp.getValorFactura() != null)
                    ? datFacturaServiciosTercerosTmp.getValorFactura() : null);
                datFacturaServiciosTercerosDTO2.setValorIva((datFacturaServiciosTercerosTmp.getValorIva() != null)
                    ? datFacturaServiciosTercerosTmp.getValorIva() : null);
                datFacturaServiciosTercerosDTO2.setValorReteIca((datFacturaServiciosTercerosTmp.getValorReteIca() != null)
                    ? datFacturaServiciosTercerosTmp.getValorReteIca() : null);
                datFacturaServiciosTercerosDTO2.setValorReteIva((datFacturaServiciosTercerosTmp.getValorReteIva() != null)
                    ? datFacturaServiciosTercerosTmp.getValorReteIva() : null);
                datFacturaServiciosTercerosDTO2.setValorRetencionContrato((datFacturaServiciosTercerosTmp.getValorRetencionContrato() != null)
                    ? datFacturaServiciosTercerosTmp.getValorRetencionContrato()
                    : null);
                datFacturaServiciosTercerosDTO2.setPersEmprByClienteId((datFacturaServiciosTercerosTmp.getPersEmprByClienteId()
                                                                                                      .getPersEmprId() != null)
                    ? datFacturaServiciosTercerosTmp.getPersEmprByClienteId()
                                                    .getPersEmprId() : null);
                
                datFacturaServiciosTercerosDTO2.setPersEmprByPersEmprId((datFacturaServiciosTercerosTmp.getPersEmprByPersEmprId()
                        .getPersEmprId() != null)
							? datFacturaServiciosTercerosTmp.getPersEmprByPersEmprId()
							.getPersEmprId() : null);
					
                datFacturaServiciosTercerosDTO2.setTipoOperacion((datFacturaServiciosTercerosTmp.getTipoOperacion() != null)
                        ? datFacturaServiciosTercerosTmp.getTipoOperacion()
                        : null);
                
                datFacturaServiciosTercerosDTO.add(datFacturaServiciosTercerosDTO2);
            }

            return datFacturaServiciosTercerosDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public DatFacturaServiciosTerceros getDatFacturaServiciosTerceros(
        Long datFacturaServiciosTercerosId) throws Exception {
        log.debug("getting DatFacturaServiciosTerceros instance");

        DatFacturaServiciosTerceros entity = null;

        try {
            entity = datFacturaServiciosTercerosDAO.findById(datFacturaServiciosTercerosId);
        } catch (Exception e) {
            log.error("get DatFacturaServiciosTerceros failed", e);
            throw new ZMessManager().new FindingException(
                "DatFacturaServiciosTerceros");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<DatFacturaServiciosTerceros> findPageDatFacturaServiciosTerceros(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        List<DatFacturaServiciosTerceros> entity = null;

        try {
            entity = datFacturaServiciosTercerosDAO.findPage(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatFacturaServiciosTerceros Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberDatFacturaServiciosTerceros()
        throws Exception {
        Long entity = null;

        try {
            entity = datFacturaServiciosTercerosDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatFacturaServiciosTerceros Count");
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
    public List<DatFacturaServiciosTerceros> findByCriteria(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        List<DatFacturaServiciosTerceros> list = new ArrayList<DatFacturaServiciosTerceros>();
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
            list = datFacturaServiciosTercerosDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
