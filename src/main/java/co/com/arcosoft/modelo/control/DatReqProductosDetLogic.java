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

import co.com.arcosoft.dataaccess.dao.IDatReqProductosDetDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatReqProductosDet;
import co.com.arcosoft.modelo.dto.DatReqProductosDetDTO;
import co.com.arcosoft.utilities.Utilities;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("DatReqProductosDetLogic")
public class DatReqProductosDetLogic implements IDatReqProductosDetLogic {
    private static final Logger log = LoggerFactory.getLogger(DatReqProductosDetLogic.class);

    /**
     * DAO injected by Spring that manages DatReqProductosDet entities
     *
     */
    @Autowired
    private IDatReqProductosDetDAO datReqProductosDetDAO;

    /**
    * Logic injected by Spring that manages DatReqProductos entities
    *
    */
    @Autowired
    IDatReqProductosLogic logicDatReqProductos1;

    /**
    * Logic injected by Spring that manages Producto entities
    *
    */
    @Autowired
    IProductoLogic logicProducto2;

    /**
    * Logic injected by Spring that manages UdadMed entities
    *
    */
    @Autowired
    IUdadMedLogic logicUdadMed3;

    @Transactional(readOnly = true)
    public List<DatReqProductosDet> getDatReqProductosDet()
        throws Exception {
        log.debug("finding all DatReqProductosDet instances");

        List<DatReqProductosDet> list = new ArrayList<DatReqProductosDet>();

        try {
            list = datReqProductosDetDAO.findAll();
        } catch (Exception e) {
            log.error("finding all DatReqProductosDet failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "DatReqProductosDet");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveDatReqProductosDet(DatReqProductosDet entity)
        throws Exception {
        log.debug("saving DatReqProductosDet instance");

        try {
            if (entity.getDatReqProductos() == null) {
                throw new ZMessManager().new ForeignException("datReqProductos");
            }

            if (entity.getProducto() == null) {
                throw new ZMessManager().new ForeignException("producto");
            }

            if (entity.getUdadMed() == null) {
                throw new ZMessManager().new ForeignException("udadMed");
            }

            if ((entity.getCantidadFaltante() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getCantidadFaltante(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "cantidadFaltante");
            }

            if ((entity.getCantidadNormal() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getCantidadNormal(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "cantidadNormal");
            }

            if ((entity.getCantidadUrgente() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getCantidadUrgente(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "cantidadUrgente");
            }

            if ((entity.getDetalleNota() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDetalleNota(), 3900) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "detalleNota");
            }

            if (entity.getDatReqProductos().getDatReqProductosId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "datReqProductosId_DatReqProductos");
            }

            if (entity.getProducto().getProductoId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "productoId_Producto");
            }

            if (entity.getUdadMed().getUdadMedId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "udadMedId_UdadMed");
            }

           

            datReqProductosDetDAO.save(entity);

            log.debug("save DatReqProductosDet successful");
        } catch (Exception e) {
            log.error("save DatReqProductosDet failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteDatReqProductosDet(DatReqProductosDet entity)
        throws Exception {
        log.debug("deleting DatReqProductosDet instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion(
                "DatReqProductosDet");
        }

        if (entity.getDatReqProductosDetId() == null) {
            throw new ZMessManager().new EmptyFieldException(
                "datReqProductosDetId");
        }

        try {
            datReqProductosDetDAO.delete(entity);

            log.debug("delete DatReqProductosDet successful");
        } catch (Exception e) {
            log.error("delete DatReqProductosDet failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateDatReqProductosDet(DatReqProductosDet entity)
        throws Exception {
        log.debug("updating DatReqProductosDet instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "DatReqProductosDet");
            }

            if (entity.getDatReqProductos() == null) {
                throw new ZMessManager().new ForeignException("datReqProductos");
            }

            if (entity.getProducto() == null) {
                throw new ZMessManager().new ForeignException("producto");
            }

            if (entity.getUdadMed() == null) {
                throw new ZMessManager().new ForeignException("udadMed");
            }

            if ((entity.getCantidadFaltante() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getCantidadFaltante(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "cantidadFaltante");
            }

            if ((entity.getCantidadNormal() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getCantidadNormal(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "cantidadNormal");
            }

            if ((entity.getCantidadUrgente() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getCantidadUrgente(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "cantidadUrgente");
            }

            if ((entity.getDetalleNota() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDetalleNota(), 3900) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "detalleNota");
            }

            if (entity.getDatReqProductos().getDatReqProductosId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "datReqProductosId_DatReqProductos");
            }

            if (entity.getProducto().getProductoId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "productoId_Producto");
            }

            if (entity.getUdadMed().getUdadMedId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "udadMedId_UdadMed");
            }

            datReqProductosDetDAO.update(entity);

            log.debug("update DatReqProductosDet successful");
        } catch (Exception e) {
            log.error("update DatReqProductosDet failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<DatReqProductosDetDTO> getDataDatReqProductosDet()
        throws Exception {
        try {
            List<DatReqProductosDet> datReqProductosDet = datReqProductosDetDAO.findAll();

            List<DatReqProductosDetDTO> datReqProductosDetDTO = new ArrayList<DatReqProductosDetDTO>();

            for (DatReqProductosDet datReqProductosDetTmp : datReqProductosDet) {
                DatReqProductosDetDTO datReqProductosDetDTO2 = new DatReqProductosDetDTO();

                datReqProductosDetDTO2.setDatReqProductosDetId(datReqProductosDetTmp.getDatReqProductosDetId());
                datReqProductosDetDTO2.setCantidadFaltante((datReqProductosDetTmp.getCantidadFaltante() != null)
                    ? datReqProductosDetTmp.getCantidadFaltante() : null);
                datReqProductosDetDTO2.setCantidadNormal((datReqProductosDetTmp.getCantidadNormal() != null)
                    ? datReqProductosDetTmp.getCantidadNormal() : null);
                datReqProductosDetDTO2.setCantidadUrgente((datReqProductosDetTmp.getCantidadUrgente() != null)
                    ? datReqProductosDetTmp.getCantidadUrgente() : null);
                datReqProductosDetDTO2.setDetalleNota((datReqProductosDetTmp.getDetalleNota() != null)
                    ? datReqProductosDetTmp.getDetalleNota() : null);
                datReqProductosDetDTO2.setSaldo((datReqProductosDetTmp.getSaldo() != null)
                    ? datReqProductosDetTmp.getSaldo() : null);
                datReqProductosDetDTO2.setDatReqProductosId_DatReqProductos((datReqProductosDetTmp.getDatReqProductos()
                                                                                                  .getDatReqProductosId() != null)
                    ? datReqProductosDetTmp.getDatReqProductos()
                                           .getDatReqProductosId() : null);

                if (datReqProductosDetTmp.getProducto() != null) {
                    datReqProductosDetDTO2.setProductoId_Producto(datReqProductosDetTmp.getProducto()
                                                                                       );
                } else {
                    datReqProductosDetDTO2.setProductoId_Producto(null);
                }

                if (datReqProductosDetTmp.getUdadMed() != null) {
                    datReqProductosDetDTO2.setUdadMedId_UdadMed(datReqProductosDetTmp.getUdadMed()
                                                                                      );
                } else {
                    datReqProductosDetDTO2.setUdadMedId_UdadMed(null);
                }
                    
                datReqProductosDetDTO.add(datReqProductosDetDTO2);
            }

            return datReqProductosDetDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public DatReqProductosDet getDatReqProductosDet(Long datReqProductosDetId)
        throws Exception {
        log.debug("getting DatReqProductosDet instance");

        DatReqProductosDet entity = null;

        try {
            entity = datReqProductosDetDAO.findById(datReqProductosDetId);
        } catch (Exception e) {
            log.error("get DatReqProductosDet failed", e);
            throw new ZMessManager().new FindingException("DatReqProductosDet");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<DatReqProductosDet> findPageDatReqProductosDet(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        List<DatReqProductosDet> entity = null;

        try {
            entity = datReqProductosDetDAO.findPage(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatReqProductosDet Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberDatReqProductosDet() throws Exception {
        Long entity = null;

        try {
            entity = datReqProductosDetDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatReqProductosDet Count");
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
    public List<DatReqProductosDet> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<DatReqProductosDet> list = new ArrayList<DatReqProductosDet>();
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
            list = datReqProductosDetDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
    

    @Transactional(readOnly = true)
    public List<DatReqProductosDetDTO> getDataDatReqProductosDetByProductos(Long datReqProductosId)
        throws Exception {
        try {
        	
        	  List<DatReqProductosDet> datReqProductosDet = datReqProductosDetDAO
  					.findByCriteria("datReqProductos.datReqProductosId= " + datReqProductosId);
        	  
            List<DatReqProductosDetDTO> datReqProductosDetDTO = new ArrayList<DatReqProductosDetDTO>();

            for (DatReqProductosDet datReqProductosDetTmp : datReqProductosDet) {
                DatReqProductosDetDTO datReqProductosDetDTO2 = new DatReqProductosDetDTO();

                datReqProductosDetDTO2.setDatReqProductosDetId(datReqProductosDetTmp.getDatReqProductosDetId());
                datReqProductosDetDTO2.setCantidadFaltante((datReqProductosDetTmp.getCantidadFaltante() != null)
                    ? datReqProductosDetTmp.getCantidadFaltante() : null);
                datReqProductosDetDTO2.setCantidadNormal((datReqProductosDetTmp.getCantidadNormal() != null)
                    ? datReqProductosDetTmp.getCantidadNormal() : null);
                datReqProductosDetDTO2.setCantidadUrgente((datReqProductosDetTmp.getCantidadUrgente() != null)
                    ? datReqProductosDetTmp.getCantidadUrgente() : null);
                datReqProductosDetDTO2.setDetalleNota((datReqProductosDetTmp.getDetalleNota() != null)
                    ? datReqProductosDetTmp.getDetalleNota() : null);
                datReqProductosDetDTO2.setSaldo((datReqProductosDetTmp.getSaldo() != null)
                    ? datReqProductosDetTmp.getSaldo() : null);
                datReqProductosDetDTO2.setDatReqProductosId_DatReqProductos((datReqProductosDetTmp.getDatReqProductos()
                                                                                                  .getDatReqProductosId() != null)
                    ? datReqProductosDetTmp.getDatReqProductos()
                                           .getDatReqProductosId() : null);

                if (datReqProductosDetTmp.getProducto() != null) {
                    datReqProductosDetDTO2.setProductoId_Producto(datReqProductosDetTmp.getProducto()
                                                                                       );
                } else {
                    datReqProductosDetDTO2.setProductoId_Producto(null);
                }

                if (datReqProductosDetTmp.getUdadMed() != null) {
                    datReqProductosDetDTO2.setUdadMedId_UdadMed(datReqProductosDetTmp.getUdadMed()
                                                                                       );
                } else {
                    datReqProductosDetDTO2.setUdadMedId_UdadMed(null);
                }
                
                
                if (datReqProductosDetTmp.getProducto() != null) {
                    datReqProductosDetDTO2.setCodigoProducto(datReqProductosDetTmp.getProducto()
                                                                                       .getCodigo());
                } else {
                    datReqProductosDetDTO2.setCodigoProducto(null);
                }

                if (datReqProductosDetTmp.getUdadMed() != null) {
                    datReqProductosDetDTO2.setNombreUdadMed(datReqProductosDetTmp.getUdadMed()
                                                                                       .getNombre());
                } else {
                    datReqProductosDetDTO2.setNombreUdadMed(null);
                }
             
                datReqProductosDetDTO.add(datReqProductosDetDTO2);
            }

            return datReqProductosDetDTO;
        } catch (Exception e) {
            throw e;
        }
    }
}
