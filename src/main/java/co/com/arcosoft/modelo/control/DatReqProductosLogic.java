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

import co.com.arcosoft.dataaccess.dao.IDatReqProductosDAO;
import co.com.arcosoft.dataaccess.dao.IDatReqProductosDetDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatReqProductos;
import co.com.arcosoft.modelo.DatReqProductosDet;
import co.com.arcosoft.modelo.dto.DatReqProductosDTO;
import co.com.arcosoft.modelo.dto.DatReqProductosDetDTO;
import co.com.arcosoft.utilities.Utilities;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("DatReqProductosLogic")
public class DatReqProductosLogic implements IDatReqProductosLogic {
    private static final Logger log = LoggerFactory.getLogger(DatReqProductosLogic.class);

    /**
     * DAO injected by Spring that manages DatReqProductos entities
     *
     */
    @Autowired
    private IDatReqProductosDAO datReqProductosDAO;

    /**
    * DAO injected by Spring that manages DatReqProductosDet entities
    *
    */
    @Autowired
    private IDatReqProductosDetDAO datReqProductosDetDAO;

    @Transactional(readOnly = true)
    public List<DatReqProductos> getDatReqProductos() throws Exception {
        log.debug("finding all DatReqProductos instances");

        List<DatReqProductos> list = new ArrayList<DatReqProductos>();

        try {
            list = datReqProductosDAO.findAll();
        } catch (Exception e) {
            log.error("finding all DatReqProductos failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "DatReqProductos");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveDatReqProductos(DatReqProductos entity, List<DatReqProductosDetDTO> dataReq)
        throws Exception {
        log.debug("saving DatReqProductos instance");

        try {
            if ((entity.getEstado() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
                throw new ZMessManager().new NotValidFormatException("estado");
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

           
            datReqProductosDAO.save(entity);
           

			if (dataReq != null) {

				for (DatReqProductosDetDTO valorDto : dataReq) {

					if (valorDto.getDatReqProductosDetId() == null) {

						DatReqProductosDet valor = new DatReqProductosDet();

						valor.setCantidadFaltante(valorDto.getCantidadFaltante());
						valor.setCantidadNormal(valorDto.getCantidadNormal());
						valor.setCantidadUrgente(valorDto.getCantidadUrgente());
						valor.setDetalleNota(valorDto.getDetalleNota());
						valor.setSaldo(valorDto.getSaldo());
						valor.setProducto(valorDto.getProductoId_Producto());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());
						valor.setDatReqProductos(entity);

						datReqProductosDetDAO.save(valor);
					}

				}
			}
            log.debug("save DatReqProductos successful");
        } catch (Exception e) {
            log.error("save DatReqProductos failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteDatReqProductos(DatReqProductos entity)
        throws Exception {
        log.debug("deleting DatReqProductos instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("DatReqProductos");
        }

        if (entity.getDatReqProductosId() == null) {
            throw new ZMessManager().new EmptyFieldException(
                "datReqProductosId");
        }

        List<DatReqProductosDet> datReqProductosDets = null;

        try {
            datReqProductosDets = datReqProductosDetDAO.findByProperty("datReqProductos.datReqProductosId",
                    entity.getDatReqProductosId());

            if (Utilities.validationsList(datReqProductosDets) == true) {
                throw new ZMessManager().new DeletingException(
                    "datReqProductosDets");
            }

            datReqProductosDAO.delete(entity);

            log.debug("delete DatReqProductos successful");
        } catch (Exception e) {
            log.error("delete DatReqProductos failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateDatReqProductos(DatReqProductos entity, List<DatReqProductosDetDTO> dataReq)
        throws Exception {
        log.debug("updating DatReqProductos instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "DatReqProductos");
            }

            if ((entity.getEstado() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
                throw new ZMessManager().new NotValidFormatException("estado");
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

            datReqProductosDAO.update(entity);
            if (dataReq != null) {

				for (DatReqProductosDetDTO valorDto : dataReq) {

					if (valorDto.getDatReqProductosDetId() == null) { // crear el
																	// valor
																	// nuevo

						DatReqProductosDet valor = new DatReqProductosDet();
						valor.setCantidadFaltante(valorDto.getCantidadFaltante());
						valor.setCantidadNormal(valorDto.getCantidadNormal());
						valor.setCantidadUrgente(valorDto.getCantidadUrgente());
						valor.setDetalleNota(valorDto.getDetalleNota());
						valor.setSaldo(valorDto.getSaldo());
						valor.setProducto(valorDto.getProductoId_Producto());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());
						valor.setDatReqProductos(entity);
						

						datReqProductosDetDAO.save(valor);

					} else {
						DatReqProductosDet valor = datReqProductosDetDAO.findById(valorDto.getDatReqProductosDetId());
						valor.setCantidadFaltante(valorDto.getCantidadFaltante());
						valor.setCantidadNormal(valorDto.getCantidadNormal());
						valor.setCantidadUrgente(valorDto.getCantidadUrgente());
						valor.setDetalleNota(valorDto.getDetalleNota());
						valor.setSaldo(valorDto.getSaldo());
						valor.setProducto(valorDto.getProductoId_Producto());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());
						valor.setDatReqProductos(entity);
						

						datReqProductosDetDAO.update(valor);
					}

				}
			}
            log.debug("update DatReqProductos successful");
        } catch (Exception e) {
            log.error("update DatReqProductos failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<DatReqProductosDTO> getDataDatReqProductos()
        throws Exception {
        try {
            List<DatReqProductos> datReqProductos = datReqProductosDAO.findAll();

            List<DatReqProductosDTO> datReqProductosDTO = new ArrayList<DatReqProductosDTO>();

            for (DatReqProductos datReqProductosTmp : datReqProductos) {
                DatReqProductosDTO datReqProductosDTO2 = new DatReqProductosDTO();

                datReqProductosDTO2.setDatReqProductosId(datReqProductosTmp.getDatReqProductosId());
                datReqProductosDTO2.setCompania((datReqProductosTmp.getCompania() != null)
                    ? datReqProductosTmp.getCompania() : null);
                datReqProductosDTO2.setConsecutivo((datReqProductosTmp.getConsecutivo() != null)
                    ? datReqProductosTmp.getConsecutivo() : null);
                datReqProductosDTO2.setEstado((datReqProductosTmp.getEstado() != null)
                    ? datReqProductosTmp.getEstado() : null);
                datReqProductosDTO2.setFechaAnulacion(datReqProductosTmp.getFechaAnulacion());
                datReqProductosDTO2.setFechaCreacion(datReqProductosTmp.getFechaCreacion());
                datReqProductosDTO2.setFechaModificacion(datReqProductosTmp.getFechaModificacion());
                datReqProductosDTO2.setFechaRegistro(datReqProductosTmp.getFechaRegistro());
                datReqProductosDTO2.setObservacion((datReqProductosTmp.getObservacion() != null)
                    ? datReqProductosTmp.getObservacion() : null);
                datReqProductosDTO2.setObservacionAnularReg((datReqProductosTmp.getObservacionAnularReg() != null)
                    ? datReqProductosTmp.getObservacionAnularReg() : null);
                datReqProductosDTO2.setUsuarioDigitacion((datReqProductosTmp.getUsuarioDigitacion() != null)
                    ? datReqProductosTmp.getUsuarioDigitacion() : null);
                datReqProductosDTO.add(datReqProductosDTO2);
            }

            return datReqProductosDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public DatReqProductos getDatReqProductos(Long datReqProductosId)
        throws Exception {
        log.debug("getting DatReqProductos instance");

        DatReqProductos entity = null;

        try {
            entity = datReqProductosDAO.findById(datReqProductosId);
        } catch (Exception e) {
            log.error("get DatReqProductos failed", e);
            throw new ZMessManager().new FindingException("DatReqProductos");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<DatReqProductos> findPageDatReqProductos(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        List<DatReqProductos> entity = null;

        try {
            entity = datReqProductosDAO.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatReqProductos Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberDatReqProductos() throws Exception {
        Long entity = null;

        try {
            entity = datReqProductosDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatReqProductos Count");
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
    public List<DatReqProductos> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<DatReqProductos> list = new ArrayList<DatReqProductos>();
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
            list = datReqProductosDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
