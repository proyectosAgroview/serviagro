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

import co.com.arcosoft.dataaccess.dao.IDatMantenimientoEquipoProdDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatMantenimientoEquipoProd;
import co.com.arcosoft.modelo.dto.DatMantenimientoEquipoProdDTO;
import co.com.arcosoft.utilities.Utilities;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("DatMantenimientoEquipoProdLogic")
public class DatMantenimientoEquipoProdLogic
    implements IDatMantenimientoEquipoProdLogic {
    private static final Logger log = LoggerFactory.getLogger(DatMantenimientoEquipoProdLogic.class);

    /**
     * DAO injected by Spring that manages DatMantenimientoEquipoProd entities
     *
     */
    @Autowired
    private IDatMantenimientoEquipoProdDAO datMantenimientoEquipoProdDAO;

    /**
    * Logic injected by Spring that manages DatMantenimientoEquipo entities
    *
    */
    @Autowired
    IDatMantenimientoEquipoLogic logicDatMantenimientoEquipo1;

    /**
    * Logic injected by Spring that manages Producto entities
    *
    */
    @Autowired
    IProductoLogic logicProducto2;

    /**
    * Logic injected by Spring that manages Trabajador entities
    *
    */
    @Autowired
    ITrabajadorLogic logicTrabajador3;

    /**
    * Logic injected by Spring that manages UdadMed entities
    *
    */
    @Autowired
    IUdadMedLogic logicUdadMed4;

    @Override
	@Transactional(readOnly = true)
    public List<DatMantenimientoEquipoProd> getDatMantenimientoEquipoProd()
        throws Exception {
        log.debug("finding all DatMantenimientoEquipoProd instances");

        List<DatMantenimientoEquipoProd> list = new ArrayList<DatMantenimientoEquipoProd>();

        try {
            list = datMantenimientoEquipoProdDAO.findAll();
        } catch (Exception e) {
            log.error("finding all DatMantenimientoEquipoProd failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "DatMantenimientoEquipoProd");
        } finally {
        }

        return list;
    }

    @Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveDatMantenimientoEquipoProd(
        DatMantenimientoEquipoProd entity) throws Exception {
        log.debug("saving DatMantenimientoEquipoProd instance");

        try {
            if (entity.getDatMantenimientoEquipo() == null) {
                throw new ZMessManager().new ForeignException(
                    "datMantenimientoEquipo");
            }

          

            if ((entity.getCantidad() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getCantidad(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException("cantidad");
            }

            if ((entity.getCostoTotal() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getCostoTotal(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "costoTotal");
            }

            if (entity.getDatMantenimientoEquipoProdId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "datMantenimientoEquipoProdId");
            }

            if ((entity.getDatMantenimientoEquipoProdId() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getDatMantenimientoEquipoProdId(), 18, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "datMantenimientoEquipoProdId");
            }

            if ((entity.getValorUnitario() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorUnitario(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorUnitario");
            }

            if (entity.getDatMantenimientoEquipo().getDatMantenimientoEquipoId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "datMantenimientoEquipoId_DatMantenimientoEquipo");
            }

            if ((entity.getDatMantenimientoEquipo().getDatMantenimientoEquipoId() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getDatMantenimientoEquipo()
                                  .getDatMantenimientoEquipoId(), 18, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "datMantenimientoEquipoId_DatMantenimientoEquipo");
            }

          

           
       

            if (getDatMantenimientoEquipoProd(
                        entity.getDatMantenimientoEquipoProdId()) != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            datMantenimientoEquipoProdDAO.save(entity);

            log.debug("save DatMantenimientoEquipoProd successful");
        } catch (Exception e) {
            log.error("save DatMantenimientoEquipoProd failed", e);
            throw e;
        } finally {
        }
    }

    @Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteDatMantenimientoEquipoProd(
        DatMantenimientoEquipoProd entity) throws Exception {
        log.debug("deleting DatMantenimientoEquipoProd instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion(
                "DatMantenimientoEquipoProd");
        }

        if (entity.getDatMantenimientoEquipoProdId() == null) {
            throw new ZMessManager().new EmptyFieldException(
                "datMantenimientoEquipoProdId");
        }

        try {
            datMantenimientoEquipoProdDAO.delete(entity);

            log.debug("delete DatMantenimientoEquipoProd successful");
        } catch (Exception e) {
            log.error("delete DatMantenimientoEquipoProd failed", e);
            throw e;
        } finally {
        }
    }

    @Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateDatMantenimientoEquipoProd(
        DatMantenimientoEquipoProd entity) throws Exception {
        log.debug("updating DatMantenimientoEquipoProd instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "DatMantenimientoEquipoProd");
            }

            if (entity.getDatMantenimientoEquipo() == null) {
                throw new ZMessManager().new ForeignException(
                    "datMantenimientoEquipo");
            }

          
            if ((entity.getCantidad() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getCantidad(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException("cantidad");
            }

            if ((entity.getCostoTotal() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getCostoTotal(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "costoTotal");
            }

            if (entity.getDatMantenimientoEquipoProdId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "datMantenimientoEquipoProdId");
            }

            if ((entity.getDatMantenimientoEquipoProdId() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getDatMantenimientoEquipoProdId(), 18, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "datMantenimientoEquipoProdId");
            }

            if ((entity.getValorUnitario() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorUnitario(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorUnitario");
            }

            if (entity.getDatMantenimientoEquipo().getDatMantenimientoEquipoId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "datMantenimientoEquipoId_DatMantenimientoEquipo");
            }

            if ((entity.getDatMantenimientoEquipo().getDatMantenimientoEquipoId() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getDatMantenimientoEquipo()
                                  .getDatMantenimientoEquipoId(), 18, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "datMantenimientoEquipoId_DatMantenimientoEquipo");
            }


            datMantenimientoEquipoProdDAO.update(entity);

            log.debug("update DatMantenimientoEquipoProd successful");
        } catch (Exception e) {
            log.error("update DatMantenimientoEquipoProd failed", e);
            throw e;
        } finally {
        }
    }

    @Override
	@Transactional(readOnly = true)
    public List<DatMantenimientoEquipoProdDTO> getDataDatMantenimientoEquipoProd()
        throws Exception {
        try {
            List<DatMantenimientoEquipoProd> datMantenimientoEquipoProd = datMantenimientoEquipoProdDAO.findAll();

            List<DatMantenimientoEquipoProdDTO> datMantenimientoEquipoProdDTO = new ArrayList<DatMantenimientoEquipoProdDTO>();

            for (DatMantenimientoEquipoProd datMantenimientoEquipoProdTmp : datMantenimientoEquipoProd) {
                DatMantenimientoEquipoProdDTO datMantenimientoEquipoProdDTO2 = new DatMantenimientoEquipoProdDTO();

                datMantenimientoEquipoProdDTO2.setDatMantenimientoEquipoProdId(datMantenimientoEquipoProdTmp.getDatMantenimientoEquipoProdId());
                datMantenimientoEquipoProdDTO2.setAlmacenId((datMantenimientoEquipoProdTmp.getAlmacenId() != null)
                    ? datMantenimientoEquipoProdTmp.getAlmacenId() : null);
                datMantenimientoEquipoProdDTO2.setCantidad((datMantenimientoEquipoProdTmp.getCantidad() != null)
                    ? datMantenimientoEquipoProdTmp.getCantidad() : null);
                datMantenimientoEquipoProdDTO2.setCostoTotal((datMantenimientoEquipoProdTmp.getCostoTotal() != null)
                    ? datMantenimientoEquipoProdTmp.getCostoTotal() : null);
                datMantenimientoEquipoProdDTO2.setFechaCreacion(datMantenimientoEquipoProdTmp.getFechaCreacion());
                datMantenimientoEquipoProdDTO2.setFechaModificacion(datMantenimientoEquipoProdTmp.getFechaModificacion());
                datMantenimientoEquipoProdDTO2.setValorUnitario((datMantenimientoEquipoProdTmp.getValorUnitario() != null)
                    ? datMantenimientoEquipoProdTmp.getValorUnitario() : null);
                datMantenimientoEquipoProdDTO2.setDatMantenimientoEquipoId_DatMantenimientoEquipo((datMantenimientoEquipoProdTmp.getDatMantenimientoEquipo()
                                                                                                                                .getDatMantenimientoEquipoId() != null)
                    ? datMantenimientoEquipoProdTmp.getDatMantenimientoEquipo()
                                                   .getDatMantenimientoEquipoId()
                    : null);

                if (datMantenimientoEquipoProdTmp.getProducto() != null) {
                    datMantenimientoEquipoProdDTO2.setProductoId_Producto(datMantenimientoEquipoProdTmp.getProducto()
                                                                                                       );
                } else {
                    datMantenimientoEquipoProdDTO2.setProductoId_Producto(null);
                }

                if (datMantenimientoEquipoProdTmp.getUbicacionesAlmacen() != null) {
                    datMantenimientoEquipoProdDTO2.setUbicacionesAlmacen(datMantenimientoEquipoProdTmp.getUbicacionesAlmacen());
                } else {
                    datMantenimientoEquipoProdDTO2.setUbicacionesAlmacen(null);
                }

                if (datMantenimientoEquipoProdTmp.getUbicacionesAlmacen() != null) {
                    datMantenimientoEquipoProdDTO2.setNomUbAlmacen(datMantenimientoEquipoProdTmp.getUbicacionesAlmacen().getNombre());
                } else {
                    datMantenimientoEquipoProdDTO2.setNomUbAlmacen(null);
                }

                if (datMantenimientoEquipoProdTmp.getTrabajador() != null) {
                    datMantenimientoEquipoProdDTO2.setTrabId_Trabajador(datMantenimientoEquipoProdTmp.getTrabajador()
                                                                                                     );
                } else {
                    datMantenimientoEquipoProdDTO2.setTrabId_Trabajador(null);
                }

                    
                datMantenimientoEquipoProdDTO2.setUdadMedId_UdadMed((datMantenimientoEquipoProdTmp.getUdadMed()
                                                                                                   != null)
                    ? datMantenimientoEquipoProdTmp.getUdadMed()
                    : null);
                datMantenimientoEquipoProdDTO2.setDescargaInventario(datMantenimientoEquipoProdTmp.getDescargaInventario());
                datMantenimientoEquipoProdDTO.add(datMantenimientoEquipoProdDTO2);
            }

            return datMantenimientoEquipoProdDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
	@Transactional(readOnly = true)
    public DatMantenimientoEquipoProd getDatMantenimientoEquipoProd(
        Long datMantenimientoEquipoProdId) throws Exception {
        log.debug("getting DatMantenimientoEquipoProd instance");

        DatMantenimientoEquipoProd entity = null;

        try {
            entity = datMantenimientoEquipoProdDAO.findById(datMantenimientoEquipoProdId);
        } catch (Exception e) {
            log.error("get DatMantenimientoEquipoProd failed", e);
            throw new ZMessManager().new FindingException(
                "DatMantenimientoEquipoProd");
        } finally {
        }

        return entity;
    }

    @Override
	@Transactional(readOnly = true)
    public List<DatMantenimientoEquipoProd> findPageDatMantenimientoEquipoProd(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        List<DatMantenimientoEquipoProd> entity = null;

        try {
            entity = datMantenimientoEquipoProdDAO.findPage(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatMantenimientoEquipoProd Count");
        } finally {
        }

        return entity;
    }

    @Override
	@Transactional(readOnly = true)
    public Long findTotalNumberDatMantenimientoEquipoProd()
        throws Exception {
        Long entity = null;

        try {
            entity = datMantenimientoEquipoProdDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatMantenimientoEquipoProd Count");
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
    @Override
	@Transactional(readOnly = true)
    public List<DatMantenimientoEquipoProd> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<DatMantenimientoEquipoProd> list = new ArrayList<DatMantenimientoEquipoProd>();
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
            list = datMantenimientoEquipoProdDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }


    @Override
	@Transactional(readOnly = true)
    public List<DatMantenimientoEquipoProdDTO> getDataDatMantenimientoEquipoProdByProd(Long datMantenimientoEquipoId)
        throws Exception {
        try {
            List<DatMantenimientoEquipoProd> datMantenimientoEquipoProd = datMantenimientoEquipoProdDAO.findByCriteria(
           		 "datMantenimientoEquipo.datMantenimientoEquipoId= " +datMantenimientoEquipoId);

            List<DatMantenimientoEquipoProdDTO> datMantenimientoEquipoProdDTO = new ArrayList<DatMantenimientoEquipoProdDTO>();

            for (DatMantenimientoEquipoProd datMantenimientoEquipoProdTmp : datMantenimientoEquipoProd) {
                DatMantenimientoEquipoProdDTO datMantenimientoEquipoProdDTO2 = new DatMantenimientoEquipoProdDTO();

                datMantenimientoEquipoProdDTO2.setDatMantenimientoEquipoProdId(datMantenimientoEquipoProdTmp.getDatMantenimientoEquipoProdId());
                datMantenimientoEquipoProdDTO2.setAlmacenId((datMantenimientoEquipoProdTmp.getAlmacenId() != null)
                    ? datMantenimientoEquipoProdTmp.getAlmacenId() : null);
                datMantenimientoEquipoProdDTO2.setCantidad((datMantenimientoEquipoProdTmp.getCantidad() != null)
                    ? datMantenimientoEquipoProdTmp.getCantidad() : null);
                datMantenimientoEquipoProdDTO2.setCostoTotal((datMantenimientoEquipoProdTmp.getCostoTotal() != null)
                    ? datMantenimientoEquipoProdTmp.getCostoTotal() : null);
                datMantenimientoEquipoProdDTO2.setFechaCreacion(datMantenimientoEquipoProdTmp.getFechaCreacion());
                datMantenimientoEquipoProdDTO2.setFechaModificacion(datMantenimientoEquipoProdTmp.getFechaModificacion());
                datMantenimientoEquipoProdDTO2.setValorUnitario((datMantenimientoEquipoProdTmp.getValorUnitario() != null)
                    ? datMantenimientoEquipoProdTmp.getValorUnitario() : null);
                datMantenimientoEquipoProdDTO2.setDatMantenimientoEquipoId_DatMantenimientoEquipo((datMantenimientoEquipoProdTmp.getDatMantenimientoEquipo()
                                                                                                                                .getDatMantenimientoEquipoId() != null)
                    ? datMantenimientoEquipoProdTmp.getDatMantenimientoEquipo()
                                                   .getDatMantenimientoEquipoId()
                    : null);

                if (datMantenimientoEquipoProdTmp.getProducto() != null) {
                    datMantenimientoEquipoProdDTO2.setProductoId_Producto(datMantenimientoEquipoProdTmp.getProducto()
                                                                                                       );
                } else {
                    datMantenimientoEquipoProdDTO2.setProductoId_Producto(null);
                }

                if (datMantenimientoEquipoProdTmp.getTrabajador() != null) {
                    datMantenimientoEquipoProdDTO2.setTrabId_Trabajador(datMantenimientoEquipoProdTmp.getTrabajador()
                                                                                                     );
                } else {
                    datMantenimientoEquipoProdDTO2.setTrabId_Trabajador(null);
                }

                if (datMantenimientoEquipoProdTmp.getUbicacionesAlmacen() != null) {
                    datMantenimientoEquipoProdDTO2.setUbicacionesAlmacen(datMantenimientoEquipoProdTmp.getUbicacionesAlmacen());
                } else {
                    datMantenimientoEquipoProdDTO2.setUbicacionesAlmacen(null);
                }

                if (datMantenimientoEquipoProdTmp.getUbicacionesAlmacen() != null) {
                    datMantenimientoEquipoProdDTO2.setNomUbAlmacen(datMantenimientoEquipoProdTmp.getUbicacionesAlmacen().getNombre());
                } else {
                    datMantenimientoEquipoProdDTO2.setNomUbAlmacen(null);
                }
                
                if (datMantenimientoEquipoProdTmp.getTrabajador() != null) {
                    datMantenimientoEquipoProdDTO2.setCodTrabajador(datMantenimientoEquipoProdTmp.getTrabajador().getNombre()
                                                                                                     );
                } else {
                    datMantenimientoEquipoProdDTO2.setCodTrabajador(null);
                }

                if (datMantenimientoEquipoProdTmp.getUdadMed() != null) {
                    datMantenimientoEquipoProdDTO2.setUdadMedId_UdadMed(datMantenimientoEquipoProdTmp.getUdadMed()
                                                                                                     );
                } else {
                    datMantenimientoEquipoProdDTO2.setUdadMedId_UdadMed(null);
                }

                
                if (datMantenimientoEquipoProdTmp.getUdadMed() != null) {
                    datMantenimientoEquipoProdDTO2.setCodUdadMed(datMantenimientoEquipoProdTmp.getUdadMed().getCodigo()
                                                                                                     );
                } else {
                    datMantenimientoEquipoProdDTO2.setCodUdadMed(null);
                }
                if (datMantenimientoEquipoProdTmp.getAlmacenId() != null) {
                    datMantenimientoEquipoProdDTO2.setAlmacenId(datMantenimientoEquipoProdTmp.getAlmacenId()
                                                                                                     );
                } else {
                    datMantenimientoEquipoProdDTO2.setAlmacenId(null);
                }

                
                if (datMantenimientoEquipoProdTmp.getAlmacenId() != null) {
                    datMantenimientoEquipoProdDTO2.setCodAlmacen(datMantenimientoEquipoProdTmp.getAlmacenId().getCodigo()
                                                                                                     );
                } else {
                    datMantenimientoEquipoProdDTO2.setCodAlmacen(null);
                }

              
                
                if (datMantenimientoEquipoProdTmp.getProducto() != null) {
                    datMantenimientoEquipoProdDTO2.setCodProducto(datMantenimientoEquipoProdTmp.getProducto().getCodigo()
                                                                                                       );
                } else {
                    datMantenimientoEquipoProdDTO2.setCodProducto(null);
                }
                
                if (datMantenimientoEquipoProdTmp.getProducto() != null) {
                    datMantenimientoEquipoProdDTO2.setNomProducto(datMantenimientoEquipoProdTmp.getProducto().getNombre()
                                                                                                       );
                } else {
                    datMantenimientoEquipoProdDTO2.setNomProducto(null);
                }
              
              

                datMantenimientoEquipoProdDTO2.setTipoSuministro((datMantenimientoEquipoProdTmp.getTipoSuministro() != null)
                        ? datMantenimientoEquipoProdTmp.getTipoSuministro() : null);
                
                if (datMantenimientoEquipoProdTmp.getCompartimientosEquipo() != null) {
                    datMantenimientoEquipoProdDTO2.setCodCompartimientosEquipo(datMantenimientoEquipoProdTmp.getCompartimientosEquipo().getNombre()
                                                                                                     );
                } else {
                    datMantenimientoEquipoProdDTO2.setCodCompartimientosEquipo(null);
                }
                
                if (datMantenimientoEquipoProdTmp.getSistemasEquipo() != null) {
                    datMantenimientoEquipoProdDTO2.setCodSistemasEquipo(datMantenimientoEquipoProdTmp.getSistemasEquipo().getCodigo()
                                                                                                     );
                } else {
                    datMantenimientoEquipoProdDTO2.setCodSistemasEquipo(null);
                }
                
                
                
                if (datMantenimientoEquipoProdTmp.getUbicacionesAlmacen() != null) {
                    datMantenimientoEquipoProdDTO2.setIdUbicacion(datMantenimientoEquipoProdTmp.getUbicacionesAlmacen().getUbicacionesAlmacenId());
                } else {
                    datMantenimientoEquipoProdDTO2.setUbicacionesAlmacen(null);
                }

                
                if (datMantenimientoEquipoProdTmp.getAlmacenId() != null) {
                    datMantenimientoEquipoProdDTO2.setIdAlmacen(datMantenimientoEquipoProdTmp.getAlmacenId().getAlmacenId()
                                                                                                     );
                } else {
                    datMantenimientoEquipoProdDTO2.setIdAlmacen(null);
                }

                
                if (datMantenimientoEquipoProdTmp.getCompartimientosEquipo() != null) {
                    datMantenimientoEquipoProdDTO2.setIdCompartimiento(datMantenimientoEquipoProdTmp.getCompartimientosEquipo().getCompartimientosEquipoId()
                                                                                                     );
                } else {
                    datMantenimientoEquipoProdDTO2.setCodCompartimientosEquipo(null);
                }
                
                
                if (datMantenimientoEquipoProdTmp.getUdadMed() != null) {
                    datMantenimientoEquipoProdDTO2.setIdUdadMed(datMantenimientoEquipoProdTmp.getUdadMed().getUdadMedId()
                                                                                                     );
                } else {
                    datMantenimientoEquipoProdDTO2.setIdUdadMed(null);
                }

                if (datMantenimientoEquipoProdTmp.getProducto() != null) {
                    datMantenimientoEquipoProdDTO2.setIdProducto(datMantenimientoEquipoProdTmp.getProducto().getProductoId()
                                                                                                       );
                } else {
                    datMantenimientoEquipoProdDTO2.setIdProducto(null);
                }
              
                if (datMantenimientoEquipoProdTmp.getProducto() != null) {
                    datMantenimientoEquipoProdDTO2.setCodProducto(datMantenimientoEquipoProdTmp.getProducto().getCodigo()
                                                                                                       );
                } else {
                    datMantenimientoEquipoProdDTO2.setCodProducto(null);
                }
                    
                if (datMantenimientoEquipoProdTmp.getConceptoKardexId() != null) {
                    datMantenimientoEquipoProdDTO2.setNomConceptoKardexId(datMantenimientoEquipoProdTmp.getConceptoKardexId().getNombre()); 
                   datMantenimientoEquipoProdDTO2.setConceptoKardexId(datMantenimientoEquipoProdTmp.getConceptoKardexId()  );
                } else {
                    datMantenimientoEquipoProdDTO2.setNomConceptoKardexId(null);
                    datMantenimientoEquipoProdDTO2.setConceptoKardexId(null);
                }
                    
                if (datMantenimientoEquipoProdTmp.getPendienteImportacion() != null) {
                    datMantenimientoEquipoProdDTO2.setPendienteImportacion(datMantenimientoEquipoProdTmp.getPendienteImportacion() );
                    if(datMantenimientoEquipoProdTmp.getPendienteImportacion().equals("SI")) {
                    	datMantenimientoEquipoProdDTO2.setColorImportacion("#F9AD97");
                    }else{
                    	datMantenimientoEquipoProdDTO2.setColorImportacion("#F5F5F5");
                    }
                } else {
                    datMantenimientoEquipoProdDTO2.setPendienteImportacion(null);
                }
                
                datMantenimientoEquipoProdDTO2.setFechaRegistro(datMantenimientoEquipoProdTmp.getFechaRegistro());
                datMantenimientoEquipoProdDTO2.setDescargaInventario(datMantenimientoEquipoProdTmp.getDescargaInventario());
                
                datMantenimientoEquipoProdDTO.add(datMantenimientoEquipoProdDTO2);
            }

            return datMantenimientoEquipoProdDTO;
        } catch (Exception e) {
            throw e;
        }
    }


}
