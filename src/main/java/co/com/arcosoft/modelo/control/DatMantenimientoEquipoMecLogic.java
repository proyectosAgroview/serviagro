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

import co.com.arcosoft.dataaccess.dao.IDatMantenimientoEquipoMecDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatMantenimientoEquipoMec;
import co.com.arcosoft.modelo.dto.DatMantenimientoEquipoMecDTO;
import co.com.arcosoft.utilities.Utilities;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("DatMantenimientoEquipoMecLogic")
public class DatMantenimientoEquipoMecLogic
    implements IDatMantenimientoEquipoMecLogic {
    private static final Logger log = LoggerFactory.getLogger(DatMantenimientoEquipoMecLogic.class);

    /**
     * DAO injected by Spring that manages DatMantenimientoEquipoMec entities
     *
     */
    @Autowired
    private IDatMantenimientoEquipoMecDAO datMantenimientoEquipoMecDAO;

    /**
    * Logic injected by Spring that manages ConceptoNomina entities
    *
    */
    @Autowired
    IConceptoNominaLogic logicConceptoNomina1;

    /**
    * Logic injected by Spring that manages DatMantenimientoEquipo entities
    *
    */
    @Autowired
    IDatMantenimientoEquipoLogic logicDatMantenimientoEquipo2;

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
    public List<DatMantenimientoEquipoMec> getDatMantenimientoEquipoMec()
        throws Exception {
        log.debug("finding all DatMantenimientoEquipoMec instances");

        List<DatMantenimientoEquipoMec> list = new ArrayList<DatMantenimientoEquipoMec>();

        try {
            list = datMantenimientoEquipoMecDAO.findAll();
        } catch (Exception e) {
            log.error("finding all DatMantenimientoEquipoMec failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "DatMantenimientoEquipoMec");
        } finally {
        }

        return list;
    }

    @Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveDatMantenimientoEquipoMec(DatMantenimientoEquipoMec entity)
        throws Exception {
        log.debug("saving DatMantenimientoEquipoMec instance");

        try {
            if (entity.getConceptoNomina() == null) {
                throw new ZMessManager().new ForeignException("conceptoNomina");
            }

            if (entity.getDatMantenimientoEquipo() == null) {
                throw new ZMessManager().new ForeignException(
                    "datMantenimientoEquipo");
            }

            if (entity.getTrabajador() == null) {
                throw new ZMessManager().new ForeignException("trabajador");
            }

            if (entity.getUdadMed() == null) {
                throw new ZMessManager().new ForeignException("udadMed");
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

            if (entity.getDatMantenimientoEquipoMecId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "datMantenimientoEquipoMecId");
            }

            if ((entity.getDatMantenimientoEquipoMecId() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getDatMantenimientoEquipoMecId(), 18, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "datMantenimientoEquipoMecId");
            }

            if ((entity.getValorUnitario() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorUnitario(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorUnitario");
            }

            if (entity.getConceptoNomina().getCeptoNominaId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "ceptoNominaId_ConceptoNomina");
            }

            if ((entity.getConceptoNomina().getCeptoNominaId() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getConceptoNomina().getCeptoNominaId(), 18, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "ceptoNominaId_ConceptoNomina");
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

            if (entity.getTrabajador().getTrabId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "trabId_Trabajador");
            }

            if ((entity.getTrabajador().getTrabId() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getTrabajador().getTrabId(), 18, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "trabId_Trabajador");
            }

            if (entity.getUdadMed().getUdadMedId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "udadMedId_UdadMed");
            }

            if ((entity.getUdadMed().getUdadMedId() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getUdadMed().getUdadMedId(), 18, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "udadMedId_UdadMed");
            }

            if (getDatMantenimientoEquipoMec(
                        entity.getDatMantenimientoEquipoMecId()) != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            datMantenimientoEquipoMecDAO.save(entity);

            log.debug("save DatMantenimientoEquipoMec successful");
        } catch (Exception e) {
            log.error("save DatMantenimientoEquipoMec failed", e);
            throw e;
        } finally {
        }
    }

    @Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteDatMantenimientoEquipoMec(
        DatMantenimientoEquipoMec entity) throws Exception {
        log.debug("deleting DatMantenimientoEquipoMec instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion(
                "DatMantenimientoEquipoMec");
        }

        if (entity.getDatMantenimientoEquipoMecId() == null) {
            throw new ZMessManager().new EmptyFieldException(
                "datMantenimientoEquipoMecId");
        }

        try {
            datMantenimientoEquipoMecDAO.delete(entity);

            log.debug("delete DatMantenimientoEquipoMec successful");
        } catch (Exception e) {
            log.error("delete DatMantenimientoEquipoMec failed", e);
            throw e;
        } finally {
        }
    }

    @Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateDatMantenimientoEquipoMec(
        DatMantenimientoEquipoMec entity) throws Exception {
        log.debug("updating DatMantenimientoEquipoMec instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "DatMantenimientoEquipoMec");
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

            if (entity.getDatMantenimientoEquipoMecId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "datMantenimientoEquipoMecId");
            }

            if ((entity.getDatMantenimientoEquipoMecId() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getDatMantenimientoEquipoMecId(), 18, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "datMantenimientoEquipoMecId");
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

           

           
            datMantenimientoEquipoMecDAO.update(entity);

            log.debug("update DatMantenimientoEquipoMec successful");
        } catch (Exception e) {
            log.error("update DatMantenimientoEquipoMec failed", e);
            throw e;
        } finally {
        }
    }

    @Override
	@Transactional(readOnly = true)
    public List<DatMantenimientoEquipoMecDTO> getDataDatMantenimientoEquipoMec()
        throws Exception {
        try {
            List<DatMantenimientoEquipoMec> datMantenimientoEquipoMec = datMantenimientoEquipoMecDAO.findAll();

            List<DatMantenimientoEquipoMecDTO> datMantenimientoEquipoMecDTO = new ArrayList<DatMantenimientoEquipoMecDTO>();

            for (DatMantenimientoEquipoMec datMantenimientoEquipoMecTmp : datMantenimientoEquipoMec) {
                DatMantenimientoEquipoMecDTO datMantenimientoEquipoMecDTO2 = new DatMantenimientoEquipoMecDTO();

                datMantenimientoEquipoMecDTO2.setDatMantenimientoEquipoMecId(datMantenimientoEquipoMecTmp.getDatMantenimientoEquipoMecId());
                datMantenimientoEquipoMecDTO2.setCantidad((datMantenimientoEquipoMecTmp.getCantidad() != null)
                    ? datMantenimientoEquipoMecTmp.getCantidad() : null);
                datMantenimientoEquipoMecDTO2.setCostoTotal((datMantenimientoEquipoMecTmp.getCostoTotal() != null)
                    ? datMantenimientoEquipoMecTmp.getCostoTotal() : null);
                datMantenimientoEquipoMecDTO2.setFechaCreacion(datMantenimientoEquipoMecTmp.getFechaCreacion());
                datMantenimientoEquipoMecDTO2.setFechaModificacion(datMantenimientoEquipoMecTmp.getFechaModificacion());
                datMantenimientoEquipoMecDTO2.setFechaRegistro(datMantenimientoEquipoMecTmp.getFechaRegistro());
                datMantenimientoEquipoMecDTO2.setValorUnitario((datMantenimientoEquipoMecTmp.getValorUnitario() != null)
                    ? datMantenimientoEquipoMecTmp.getValorUnitario() : null);
                datMantenimientoEquipoMecDTO2.setCeptoNominaId_ConceptoNomina((datMantenimientoEquipoMecTmp.getConceptoNomina()
                                                                                                            != null)
                    ? datMantenimientoEquipoMecTmp.getConceptoNomina()
                                                   : null);
                datMantenimientoEquipoMecDTO2.setDatMantenimientoEquipoId_DatMantenimientoEquipo((datMantenimientoEquipoMecTmp.getDatMantenimientoEquipo()
                                                                                                                              .getDatMantenimientoEquipoId() != null)
                    ? datMantenimientoEquipoMecTmp.getDatMantenimientoEquipo()
                                                  .getDatMantenimientoEquipoId()
                    : null);

                if (datMantenimientoEquipoMecTmp.getTrabajador() != null) {
                    datMantenimientoEquipoMecDTO2.setTrabId_Trabajador(datMantenimientoEquipoMecTmp.getTrabajador()
                                                                                                  	);
                } else {
                    datMantenimientoEquipoMecDTO2.setTrabId_Trabajador(null);
                }

                
                if (datMantenimientoEquipoMecTmp.getTrabajador() != null) {
                    datMantenimientoEquipoMecDTO2.setTrabId_Trabajador(datMantenimientoEquipoMecTmp.getTrabajador()
                                                                                                  	);
                } else {
                    datMantenimientoEquipoMecDTO2.setTrabId_Trabajador(null);
                }
                
                
                datMantenimientoEquipoMecDTO2.setUdadMedId_UdadMed((datMantenimientoEquipoMecTmp.getUdadMed()
                                                                                                 != null)
                    ? datMantenimientoEquipoMecTmp.getUdadMed()
                    : null);
                datMantenimientoEquipoMecDTO.add(datMantenimientoEquipoMecDTO2);
            }

            return datMantenimientoEquipoMecDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
	@Transactional(readOnly = true)
    public DatMantenimientoEquipoMec getDatMantenimientoEquipoMec(
        Long datMantenimientoEquipoMecId) throws Exception {
        log.debug("getting DatMantenimientoEquipoMec instance");

        DatMantenimientoEquipoMec entity = null;

        try {
            entity = datMantenimientoEquipoMecDAO.findById(datMantenimientoEquipoMecId);
        } catch (Exception e) {
            log.error("get DatMantenimientoEquipoMec failed", e);
            throw new ZMessManager().new FindingException(
                "DatMantenimientoEquipoMec");
        } finally {
        }

        return entity;
    }

    @Override
	@Transactional(readOnly = true)
    public List<DatMantenimientoEquipoMec> findPageDatMantenimientoEquipoMec(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        List<DatMantenimientoEquipoMec> entity = null;

        try {
            entity = datMantenimientoEquipoMecDAO.findPage(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatMantenimientoEquipoMec Count");
        } finally {
        }

        return entity;
    }

    @Override
	@Transactional(readOnly = true)
    public Long findTotalNumberDatMantenimientoEquipoMec()
        throws Exception {
        Long entity = null;

        try {
            entity = datMantenimientoEquipoMecDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatMantenimientoEquipoMec Count");
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
    public List<DatMantenimientoEquipoMec> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<DatMantenimientoEquipoMec> list = new ArrayList<DatMantenimientoEquipoMec>();
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
            list = datMantenimientoEquipoMecDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }


    @Override
	@Transactional(readOnly = true)
    public List<DatMantenimientoEquipoMecDTO> getDataDatMantenimientoEquipoMecByMec(Long datMantenimientoEquipoId)
        throws Exception {
        try {
            List<DatMantenimientoEquipoMec> datMantenimientoEquipoMec = datMantenimientoEquipoMecDAO.findByCriteria(
            		 "datMantenimientoEquipo.datMantenimientoEquipoId= " +datMantenimientoEquipoId);

           
            List<DatMantenimientoEquipoMecDTO> datMantenimientoEquipoMecDTO = new ArrayList<DatMantenimientoEquipoMecDTO>();

            for (DatMantenimientoEquipoMec datMantenimientoEquipoMecTmp : datMantenimientoEquipoMec) {
                DatMantenimientoEquipoMecDTO datMantenimientoEquipoMecDTO2 = new DatMantenimientoEquipoMecDTO();
                datMantenimientoEquipoMecDTO2.setLaborId_Labor((datMantenimientoEquipoMecTmp.getLabor()  !=null ) ? datMantenimientoEquipoMecTmp.getLabor() : null);
                datMantenimientoEquipoMecDTO2.setDatMantenimientoEquipoMecId(datMantenimientoEquipoMecTmp.getDatMantenimientoEquipoMecId());
                datMantenimientoEquipoMecDTO2.setCantidad((datMantenimientoEquipoMecTmp.getCantidad() != null)
                    ? datMantenimientoEquipoMecTmp.getCantidad() : null);
                datMantenimientoEquipoMecDTO2.setCostoTotal((datMantenimientoEquipoMecTmp.getCostoTotal() != null)
                    ? datMantenimientoEquipoMecTmp.getCostoTotal() : null);
                datMantenimientoEquipoMecDTO2.setFechaCreacion(datMantenimientoEquipoMecTmp.getFechaCreacion());
                datMantenimientoEquipoMecDTO2.setTipoPersonal(datMantenimientoEquipoMecTmp.getTipoPersonal());
                datMantenimientoEquipoMecDTO2.setFechaModificacion(datMantenimientoEquipoMecTmp.getFechaModificacion());
                datMantenimientoEquipoMecDTO2.setFechaRegistro(datMantenimientoEquipoMecTmp.getFechaRegistro());
                datMantenimientoEquipoMecDTO2.setValorUnitario((datMantenimientoEquipoMecTmp.getValorUnitario() != null)
                    ? datMantenimientoEquipoMecTmp.getValorUnitario() : null);
                datMantenimientoEquipoMecDTO2.setCeptoNominaId_ConceptoNomina((datMantenimientoEquipoMecTmp.getConceptoNomina()
                                                                                                            != null)
                    ? datMantenimientoEquipoMecTmp.getConceptoNomina()
                                                   : null);
                datMantenimientoEquipoMecDTO2.setDatMantenimientoEquipoId_DatMantenimientoEquipo((datMantenimientoEquipoMecTmp.getDatMantenimientoEquipo()
                                                                                                                              .getDatMantenimientoEquipoId() != null)
                    ? datMantenimientoEquipoMecTmp.getDatMantenimientoEquipo()
                                                  .getDatMantenimientoEquipoId()
                    : null);

                if (datMantenimientoEquipoMecTmp.getTrabajador() != null) {
                    datMantenimientoEquipoMecDTO2.setTrabId_Trabajador(datMantenimientoEquipoMecTmp.getTrabajador()
                                                                                                  	);
                } else {
                    datMantenimientoEquipoMecDTO2.setTrabId_Trabajador(null);
                }
                
                
                if(datMantenimientoEquipoMecTmp.getLabor() !=null){
                	datMantenimientoEquipoMecDTO2.setCodLabor(datMantenimientoEquipoMecTmp.getLabor().getNombre());
                }else{
                	
                	datMantenimientoEquipoMecDTO2.setCodLabor(null);
                }

                

                if(datMantenimientoEquipoMecTmp.getUdadMed() !=null){
                	datMantenimientoEquipoMecDTO2.setUdadMedId_UdadMed(datMantenimientoEquipoMecTmp.getUdadMed());
                }else{
                	
                	datMantenimientoEquipoMecDTO2.setUdadMedId_UdadMed(null);
                }

                
                if(datMantenimientoEquipoMecTmp.getUdadMed() !=null){
                	datMantenimientoEquipoMecDTO2.setCodUdadMed(datMantenimientoEquipoMecTmp.getUdadMed().getCodigo());
                }else{
                	
                	datMantenimientoEquipoMecDTO2.setCodUdadMed(null);
                }

               
                if (datMantenimientoEquipoMecTmp.getTrabajador() != null) {
                    datMantenimientoEquipoMecDTO2.setCodTrabajador(datMantenimientoEquipoMecTmp.getTrabajador().getNombre()
                                                                                                  	);
                } else {
                    datMantenimientoEquipoMecDTO2.setCodTrabajador(null);
                }
                

                if (datMantenimientoEquipoMecTmp.getConceptoNomina() != null) {
                    datMantenimientoEquipoMecDTO2.setCodConcepto(datMantenimientoEquipoMecTmp.getConceptoNomina().getCodigo()
                                                                                                  	);
                } else {
                    datMantenimientoEquipoMecDTO2.setCodConcepto(null);
                }
                
              
              
                
               
                datMantenimientoEquipoMecDTO2.setCodSistema((datMantenimientoEquipoMecTmp.getSistemasEquipo() !=null) ? datMantenimientoEquipoMecTmp.getCompartimientosEquipo().getCodigo() :null);
                
            	datMantenimientoEquipoMecDTO2.setCodCompartimiento((datMantenimientoEquipoMecTmp.getCompartimientosEquipo() !=null) ? datMantenimientoEquipoMecTmp.getCompartimientosEquipo().getCodigo() : null);
                
                            
                datMantenimientoEquipoMecDTO2.setHoraIniMec((datMantenimientoEquipoMecTmp.getHoraIniMec() != null) ? datMantenimientoEquipoMecTmp.getHoraIniMec() : null);
                datMantenimientoEquipoMecDTO2.setHoraFinMec((datMantenimientoEquipoMecTmp.getHoraFinMec() != null) ? datMantenimientoEquipoMecTmp.getHoraFinMec() : null );

                if (datMantenimientoEquipoMecTmp.getContratistaId() != null) {
                    datMantenimientoEquipoMecDTO2.setContratistaId(datMantenimientoEquipoMecTmp.getContratistaId()
                                                                                                  	);
                } else {
                    datMantenimientoEquipoMecDTO2.setContratistaId(null);
                }
                

                if (datMantenimientoEquipoMecTmp.getContratistaId() != null) {
                    datMantenimientoEquipoMecDTO2.setNomProveedor(datMantenimientoEquipoMecTmp.getContratistaId().getNombre()
                                                                                                  	);
                } else {
                    datMantenimientoEquipoMecDTO2.setNomProveedor("N/A");
                }
                if (datMantenimientoEquipoMecTmp.getNumFactura() != null) {
                    datMantenimientoEquipoMecDTO2.setNumFactura(datMantenimientoEquipoMecTmp.getNumFactura()
                                                                                                  	);
                } else {
                    datMantenimientoEquipoMecDTO2.setNumFactura(null);
                }
                
                if (datMantenimientoEquipoMecTmp.getObservacion() != null) {
                    datMantenimientoEquipoMecDTO2.setObservacion(datMantenimientoEquipoMecTmp.getObservacion()
                                                                                                  	);
                } else {
                    datMantenimientoEquipoMecDTO2.setObservacion(null);
                }
                
                datMantenimientoEquipoMecDTO.add(datMantenimientoEquipoMecDTO2);
            }

            return datMantenimientoEquipoMecDTO;
        } catch (Exception e) {
            throw e;
        }
    }

}
