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

import co.com.arcosoft.dataaccess.dao.IDatCheckListEquipoDAO;
import co.com.arcosoft.dataaccess.dao.IPlanRevisionEquipoDetDAO;
import co.com.arcosoft.dataaccess.dao.ISistemasEquipoDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatCheckListEquipo;
import co.com.arcosoft.modelo.PlanRevisionEquipoDet;
import co.com.arcosoft.modelo.SistemasEquipo;
import co.com.arcosoft.modelo.dto.SistemasEquipoDTO;
import co.com.arcosoft.utilities.Utilities;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("SistemasEquipoLogic")
public class SistemasEquipoLogic implements ISistemasEquipoLogic {
    private static final Logger log = LoggerFactory.getLogger(SistemasEquipoLogic.class);

    /**
     * DAO injected by Spring that manages SistemasEquipo entities
     *
     */
    @Autowired
    private ISistemasEquipoDAO sistemasEquipoDAO;

    /**
    * DAO injected by Spring that manages DatCheckListEquipo entities
    *
    */
    @Autowired
    private IDatCheckListEquipoDAO datCheckListEquipoDAO;

    /**
    * DAO injected by Spring that manages PlanRevisionEquipoDet entities
    *
    */
    @Autowired
    private IPlanRevisionEquipoDetDAO planRevisionEquipoDetDAO;

    @Override
	@Transactional(readOnly = true)
    public List<SistemasEquipo> getSistemasEquipo() throws Exception {
        log.debug("finding all SistemasEquipo instances");

        List<SistemasEquipo> list = new ArrayList<SistemasEquipo>();

        try {
            list = sistemasEquipoDAO.findAll();
        } catch (Exception e) {
            log.error("finding all SistemasEquipo failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "SistemasEquipo");
        } finally {
        }

        return list;
    }

    @Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveSistemasEquipo(SistemasEquipo entity)
        throws Exception {
        log.debug("saving SistemasEquipo instance");

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

            if ((entity.getInfoAdicional1() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getInfoAdicional1(), 100) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "infoAdicional1");
            }

            if ((entity.getNombre() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getNombre(),
                        100) == false)) {
                throw new ZMessManager().new NotValidFormatException("nombre");
            }

            if ((entity.getOrigenDatos() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getOrigenDatos(), 30) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "origenDatos");
            }
            /*
            if (getSistemasEquipo(entity.getSistemasEquipoId()) != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }
*/
            sistemasEquipoDAO.save(entity);

            log.debug("save SistemasEquipo successful");
        } catch (Exception e) {
            log.error("save SistemasEquipo failed", e);
            throw e;
        } finally {
        }
    }

    @Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteSistemasEquipo(SistemasEquipo entity)
        throws Exception {
        log.debug("deleting SistemasEquipo instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("SistemasEquipo");
        }

        if (entity.getSistemasEquipoId() == null) {
            throw new ZMessManager().new EmptyFieldException("sistemasEquipoId");
        }

        List<DatCheckListEquipo> datCheckListEquipos = null;
        List<PlanRevisionEquipoDet> planRevisionEquipoDets = null;

        try {
            datCheckListEquipos = datCheckListEquipoDAO.findByProperty("sistemasEquipo.sistemasEquipoId",
                    entity.getSistemasEquipoId());

            if (Utilities.validationsList(datCheckListEquipos) == true) {
                throw new ZMessManager().new DeletingException(
                    "datCheckListEquipos");
            }

            planRevisionEquipoDets = planRevisionEquipoDetDAO.findByProperty("sistemasEquipo.sistemasEquipoId",
                    entity.getSistemasEquipoId());

            if (Utilities.validationsList(planRevisionEquipoDets) == true) {
                throw new ZMessManager().new DeletingException(
                    "planRevisionEquipoDets");
            }

            sistemasEquipoDAO.delete(entity);

            log.debug("delete SistemasEquipo successful");
        } catch (Exception e) {
            log.error("delete SistemasEquipo failed", e);
            throw e;
        } finally {
        }
    }

    @Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateSistemasEquipo(SistemasEquipo entity)
        throws Exception {
        log.debug("updating SistemasEquipo instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "SistemasEquipo");
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

            if ((entity.getInfoAdicional1() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getInfoAdicional1(), 100) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "infoAdicional1");
            }

            if ((entity.getNombre() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getNombre(),
                        100) == false)) {
                throw new ZMessManager().new NotValidFormatException("nombre");
            }

            if ((entity.getOrigenDatos() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getOrigenDatos(), 30) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "origenDatos");
            }

            sistemasEquipoDAO.update(entity);

            log.debug("update SistemasEquipo successful");
        } catch (Exception e) {
            log.error("update SistemasEquipo failed", e);
            throw e;
        } finally {
        }
    }

    @Override
	@Transactional(readOnly = true)
    public List<SistemasEquipoDTO> getDataSistemasEquipo()
        throws Exception {
        try {
            List<SistemasEquipo> sistemasEquipo = sistemasEquipoDAO.findAll();

            List<SistemasEquipoDTO> sistemasEquipoDTO = new ArrayList<SistemasEquipoDTO>();

            for (SistemasEquipo sistemasEquipoTmp : sistemasEquipo) {
                SistemasEquipoDTO sistemasEquipoDTO2 = new SistemasEquipoDTO();

                sistemasEquipoDTO2.setSistemasEquipoId(sistemasEquipoTmp.getSistemasEquipoId());
                sistemasEquipoDTO2.setCodigo((sistemasEquipoTmp.getCodigo() != null)
                    ? sistemasEquipoTmp.getCodigo() : null);
                sistemasEquipoDTO2.setCompania((sistemasEquipoTmp.getCompania() != null)
                    ? sistemasEquipoTmp.getCompania() : null);
                sistemasEquipoDTO2.setEstado((sistemasEquipoTmp.getEstado() != null)
                    ? sistemasEquipoTmp.getEstado() : null);
                sistemasEquipoDTO2.setFechaCreacion(sistemasEquipoTmp.getFechaCreacion());
                sistemasEquipoDTO2.setFechaModificacion(sistemasEquipoTmp.getFechaModificacion());
                sistemasEquipoDTO2.setInfoAdicional((sistemasEquipoTmp.getInfoAdicional() != null)
                    ? sistemasEquipoTmp.getInfoAdicional() : null);
                sistemasEquipoDTO2.setInfoAdicional1((sistemasEquipoTmp.getInfoAdicional1() != null)
                    ? sistemasEquipoTmp.getInfoAdicional1() : null);
                sistemasEquipoDTO2.setNombre((sistemasEquipoTmp.getNombre() != null)
                    ? sistemasEquipoTmp.getNombre() : null);
                sistemasEquipoDTO2.setOrigenDatos((sistemasEquipoTmp.getOrigenDatos() != null)
                    ? sistemasEquipoTmp.getOrigenDatos() : null);
                sistemasEquipoDTO.add(sistemasEquipoDTO2);
            }

            return sistemasEquipoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
	@Transactional(readOnly = true)
    public SistemasEquipo getSistemasEquipo(Long sistemasEquipoId)
        throws Exception {
        log.debug("getting SistemasEquipo instance");

        SistemasEquipo entity = null;

        try {
            entity = sistemasEquipoDAO.findById(sistemasEquipoId);
        } catch (Exception e) {
            log.error("get SistemasEquipo failed", e);
            throw new ZMessManager().new FindingException("SistemasEquipo");
        } finally {
        }

        return entity;
    }

    @Override
	@Transactional(readOnly = true)
    public List<SistemasEquipo> findPageSistemasEquipo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<SistemasEquipo> entity = null;

        try {
            entity = sistemasEquipoDAO.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "SistemasEquipo Count");
        } finally {
        }

        return entity;
    }

    @Override
	@Transactional(readOnly = true)
    public Long findTotalNumberSistemasEquipo() throws Exception {
        Long entity = null;

        try {
            entity = sistemasEquipoDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "SistemasEquipo Count");
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
    public List<SistemasEquipo> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<SistemasEquipo> list = new ArrayList<SistemasEquipo>();
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
            list = sistemasEquipoDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
