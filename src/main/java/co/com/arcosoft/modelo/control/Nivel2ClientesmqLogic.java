package co.com.arcosoft.modelo.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.com.arcosoft.dataaccess.dao.INivel2ClientesmqDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Nivel2Clientesmq;
import co.com.arcosoft.modelo.dto.Nivel2ClientesmqDTO;
import co.com.arcosoft.utilities.Utilities;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("Nivel2ClientesmqLogic")
public class Nivel2ClientesmqLogic implements INivel2ClientesmqLogic {
    private static final Logger log = LoggerFactory.getLogger(Nivel2ClientesmqLogic.class);

    /**
     * DAO injected by Spring that manages Nivel2Clientesmq entities
     *
     */
    @Autowired
    private INivel2ClientesmqDAO nivel2ClientesmqDAO;

    /**
    * Logic injected by Spring that manages CentCost entities
    *
    */
    @Autowired
    ICentCostLogic logicCentCost1;

    /**
    * Logic injected by Spring that manages Ciudad entities
    *
    */
    @Autowired
    ICiudadLogic logicCiudad2;

    /**
    * Logic injected by Spring that manages PersEmpr entities
    *
    */
    @Autowired
    IPersEmprLogic logicPersEmpr3;

    @Transactional(readOnly = true)
    public List<Nivel2Clientesmq> getNivel2Clientesmq()
        throws Exception {
        log.debug("finding all Nivel2Clientesmq instances");

        List<Nivel2Clientesmq> list = new ArrayList<Nivel2Clientesmq>();

        try {
            list = nivel2ClientesmqDAO.findAll();
        } catch (Exception e) {
            log.error("finding all Nivel2Clientesmq failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "Nivel2Clientesmq");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveNivel2Clientesmq(Nivel2Clientesmq entity)
        throws Exception {
        log.debug("saving Nivel2Clientesmq instance");

        try {
            

            
            if (entity.getPersEmpr() == null) {
                throw new ZMessManager().new ForeignException("persEmpr");
            }

            if ((entity.getBarrio() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getBarrio(),
                        30) == false)) {
                throw new ZMessManager().new NotValidFormatException("barrio");
            }

            if ((entity.getCodigo() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getCodigo(),
                        20) == false)) {
                throw new ZMessManager().new NotValidFormatException("codigo");
            }

            if ((entity.getCodigoAlternativo() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getCodigoAlternativo(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "codigoAlternativo");
            }

            if ((entity.getDireccion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDireccion(), 30) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "direccion");
            }

            if ((entity.getDistanciaOficina() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getDistanciaOficina(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "distanciaOficina");
            }

            if ((entity.getDistanciaPlanta() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getDistanciaPlanta(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "distanciaPlanta");
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

            if ((entity.getInfoAdicional2() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getInfoAdicional2(), 100) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "infoAdicional2");
            }

            if ((entity.getLatitud() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getLatitud(), 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException("latitud");
            }

            if ((entity.getLongitud() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getLongitud(), 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException("longitud");
            }

            if ((entity.getNombre() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getNombre(),
                        60) == false)) {
                throw new ZMessManager().new NotValidFormatException("nombre");
            }

            if ((entity.getObservacion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getObservacion(), 150) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "observacion");
            }

            if ((entity.getPbx() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getPbx(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException("pbx");
            }

            if ((entity.getPrecision1() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getPrecision1(), 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "precision1");
            }

            if ((entity.getTelefono() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getTelefono(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException("telefono");
            }

            if ((entity.getTipoPropiedad() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getTipoPropiedad(), 30) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "tipoPropiedad");
            }

            if (entity.getPersEmpr().getPersEmprId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "persEmprId_PersEmpr");
            }


            nivel2ClientesmqDAO.save(entity);

            log.debug("save Nivel2Clientesmq successful");
        } catch (Exception e) {
            log.error("save Nivel2Clientesmq failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteNivel2Clientesmq(Nivel2Clientesmq entity)
        throws Exception {
        log.debug("deleting Nivel2Clientesmq instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Nivel2Clientesmq");
        }

        if (entity.getNivel2ClientesmqId() == null) {
            throw new ZMessManager().new EmptyFieldException(
                "nivel2ClientesmqId");
        }

        try {
            nivel2ClientesmqDAO.delete(entity);

            log.debug("delete Nivel2Clientesmq successful");
        } catch (Exception e) {
            log.error("delete Nivel2Clientesmq failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateNivel2Clientesmq(Nivel2Clientesmq entity)
        throws Exception {
        log.debug("updating Nivel2Clientesmq instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "Nivel2Clientesmq");
            }

            if (entity.getPersEmpr() == null) {
                throw new ZMessManager().new ForeignException("persEmpr");
            }

            if ((entity.getBarrio() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getBarrio(),
                        30) == false)) {
                throw new ZMessManager().new NotValidFormatException("barrio");
            }

            if ((entity.getCodigo() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getCodigo(),
                        20) == false)) {
                throw new ZMessManager().new NotValidFormatException("codigo");
            }

            if ((entity.getCodigoAlternativo() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getCodigoAlternativo(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "codigoAlternativo");
            }

            if ((entity.getDireccion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDireccion(), 30) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "direccion");
            }

            if ((entity.getDistanciaOficina() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getDistanciaOficina(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "distanciaOficina");
            }

            if ((entity.getDistanciaPlanta() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getDistanciaPlanta(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "distanciaPlanta");
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

            if ((entity.getInfoAdicional2() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getInfoAdicional2(), 100) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "infoAdicional2");
            }

            if ((entity.getLatitud() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getLatitud(), 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException("latitud");
            }

            if ((entity.getLongitud() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getLongitud(), 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException("longitud");
            }

            if ((entity.getNombre() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getNombre(),
                        60) == false)) {
                throw new ZMessManager().new NotValidFormatException("nombre");
            }

            if ((entity.getObservacion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getObservacion(), 150) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "observacion");
            }

            if ((entity.getPbx() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getPbx(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException("pbx");
            }

            if ((entity.getPrecision1() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getPrecision1(), 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "precision1");
            }

            if ((entity.getTelefono() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getTelefono(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException("telefono");
            }

            if ((entity.getTipoPropiedad() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getTipoPropiedad(), 30) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "tipoPropiedad");
            }


            if (entity.getPersEmpr().getPersEmprId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "persEmprId_PersEmpr");
            }

            nivel2ClientesmqDAO.update(entity);

            log.debug("update Nivel2Clientesmq successful");
        } catch (Exception e) {
            log.error("update Nivel2Clientesmq failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<Nivel2ClientesmqDTO> getDataNivel2Clientesmq()
        throws Exception {
        try {
            List<Nivel2Clientesmq> nivel2Clientesmq = nivel2ClientesmqDAO.findAll();

            List<Nivel2ClientesmqDTO> nivel2ClientesmqDTO = new ArrayList<Nivel2ClientesmqDTO>();

            for (Nivel2Clientesmq nivel2ClientesmqTmp : nivel2Clientesmq) {
                Nivel2ClientesmqDTO nivel2ClientesmqDTO2 = new Nivel2ClientesmqDTO();

                nivel2ClientesmqDTO2.setNivel2ClientesmqId(nivel2ClientesmqTmp.getNivel2ClientesmqId());
                nivel2ClientesmqDTO2.setBarrio((nivel2ClientesmqTmp.getBarrio() != null)
                    ? nivel2ClientesmqTmp.getBarrio() : null);
                nivel2ClientesmqDTO2.setCodigo((nivel2ClientesmqTmp.getCodigo() != null)
                    ? nivel2ClientesmqTmp.getCodigo() : null);
                nivel2ClientesmqDTO2.setCodigoAlternativo((nivel2ClientesmqTmp.getCodigoAlternativo() != null)
                    ? nivel2ClientesmqTmp.getCodigoAlternativo() : null);
                nivel2ClientesmqDTO2.setCompania((nivel2ClientesmqTmp.getCompania() != null)
                    ? nivel2ClientesmqTmp.getCompania() : null);
                nivel2ClientesmqDTO2.setDireccion((nivel2ClientesmqTmp.getDireccion() != null)
                    ? nivel2ClientesmqTmp.getDireccion() : null);
                nivel2ClientesmqDTO2.setDistanciaOficina((nivel2ClientesmqTmp.getDistanciaOficina() != null)
                    ? nivel2ClientesmqTmp.getDistanciaOficina() : null);
                nivel2ClientesmqDTO2.setDistanciaPlanta((nivel2ClientesmqTmp.getDistanciaPlanta() != null)
                    ? nivel2ClientesmqTmp.getDistanciaPlanta() : null);
                nivel2ClientesmqDTO2.setEstado((nivel2ClientesmqTmp.getEstado() != null)
                    ? nivel2ClientesmqTmp.getEstado() : null);
                nivel2ClientesmqDTO2.setFechaCreacion(nivel2ClientesmqTmp.getFechaCreacion());
                nivel2ClientesmqDTO2.setFechaModificacion(nivel2ClientesmqTmp.getFechaModificacion());
                nivel2ClientesmqDTO2.setInfoAdicional((nivel2ClientesmqTmp.getInfoAdicional() != null)
                    ? nivel2ClientesmqTmp.getInfoAdicional() : null);
                nivel2ClientesmqDTO2.setInfoAdicional2((nivel2ClientesmqTmp.getInfoAdicional2() != null)
                    ? nivel2ClientesmqTmp.getInfoAdicional2() : null);
                nivel2ClientesmqDTO2.setLatitud((nivel2ClientesmqTmp.getLatitud() != null)
                    ? nivel2ClientesmqTmp.getLatitud() : null);
                nivel2ClientesmqDTO2.setLongitud((nivel2ClientesmqTmp.getLongitud() != null)
                    ? nivel2ClientesmqTmp.getLongitud() : null);
                nivel2ClientesmqDTO2.setNombre((nivel2ClientesmqTmp.getNombre() != null)
                    ? nivel2ClientesmqTmp.getNombre() : null);
                nivel2ClientesmqDTO2.setObservacion((nivel2ClientesmqTmp.getObservacion() != null)
                    ? nivel2ClientesmqTmp.getObservacion() : null);
                nivel2ClientesmqDTO2.setPbx((nivel2ClientesmqTmp.getPbx() != null)
                    ? nivel2ClientesmqTmp.getPbx() : null);
                nivel2ClientesmqDTO2.setPrecision1((nivel2ClientesmqTmp.getPrecision1() != null)
                    ? nivel2ClientesmqTmp.getPrecision1() : null);
                nivel2ClientesmqDTO2.setTelefono((nivel2ClientesmqTmp.getTelefono() != null)
                    ? nivel2ClientesmqTmp.getTelefono() : null);
                nivel2ClientesmqDTO2.setTipoPropiedad((nivel2ClientesmqTmp.getTipoPropiedad() != null)
                    ? nivel2ClientesmqTmp.getTipoPropiedad() : null);
                nivel2ClientesmqDTO2.setVereda((nivel2ClientesmqTmp.getVereda() != null)
                    ? nivel2ClientesmqTmp.getVereda() : null);

                if (nivel2ClientesmqTmp.getCentCost() != null) {
                    nivel2ClientesmqDTO2.setCentCostId_CentCost(nivel2ClientesmqTmp.getCentCost()
                                                                               .getCentCostId());
                } else {
                    nivel2ClientesmqDTO2.setCentCostId_CentCost(null);
                }
                
                if (nivel2ClientesmqTmp.getCiudad() != null) {
                    nivel2ClientesmqDTO2.setCiudadId_Ciudad(nivel2ClientesmqTmp.getCiudad()
                                                                               .getCiudadId());
                } else {
                    nivel2ClientesmqDTO2.setCiudadId_Ciudad(null);
                }

                nivel2ClientesmqDTO2.setPersEmprId_PersEmpr((nivel2ClientesmqTmp.getPersEmpr()
                                                                                .getPersEmprId() != null)
                    ? nivel2ClientesmqTmp.getPersEmpr().getPersEmprId() : null);
                
                if (nivel2ClientesmqTmp.getPersEmpr() != null) {
                    nivel2ClientesmqDTO2.setNomCliente(nivel2ClientesmqTmp.getPersEmpr()
                                                                               .getNombre());
                } else {
                    nivel2ClientesmqDTO2.setNomCliente(null);
                }
                
                nivel2ClientesmqDTO.add(nivel2ClientesmqDTO2);
            }

            return nivel2ClientesmqDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Nivel2Clientesmq getNivel2Clientesmq(Long nivel2ClientesmqId)
        throws Exception {
        log.debug("getting Nivel2Clientesmq instance");

        Nivel2Clientesmq entity = null;

        try {
            entity = nivel2ClientesmqDAO.findById(nivel2ClientesmqId);
        } catch (Exception e) {
            log.error("get Nivel2Clientesmq failed", e);
            throw new ZMessManager().new FindingException("Nivel2Clientesmq");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<Nivel2Clientesmq> findPageNivel2Clientesmq(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        List<Nivel2Clientesmq> entity = null;

        try {
            entity = nivel2ClientesmqDAO.findPage(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "Nivel2Clientesmq Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberNivel2Clientesmq() throws Exception {
        Long entity = null;

        try {
            entity = nivel2ClientesmqDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "Nivel2Clientesmq Count");
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
    public List<Nivel2Clientesmq> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<Nivel2Clientesmq> list = new ArrayList<Nivel2Clientesmq>();
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
            list = nivel2ClientesmqDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
    
	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberNivel2Clientesmq(Map<String, Object> filters) throws Exception {
		Long entity = null;

		try {
			String whereCondition = new String();
			Iterator it = filters.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry e = (Map.Entry) it.next();
				// whereCondition+=((whereCondition.length() ==
				// 0)?" ":" and ")+"upper("+e.getKey()+")"+ " LIKE '%" +
				// e.getValue().toString().toUpperCase()+"%' ";
				if (e.getKey().equals("nombreNivel1")) {

					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(nivel1.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else {
					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(" + e.getKey() + ")"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				}
			}
			entity = nivel2ClientesmqDAO.countByCriteria(whereCondition);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Nivel2 Count");
		} finally {
		}
		return entity;
	}

	   @Transactional(readOnly = true)
	    public List<Nivel2ClientesmqDTO> findByCriteriaPageNivel2Clientesmq(int startRow, int pageSize, String sortField, boolean sortOrder,
				Map<String, Object> filters) throws Exception {
			try {

				List<Nivel2Clientesmq> entity = null;

				String whereCondition = new String();
				Iterator it = filters.entrySet().iterator();

				while (it.hasNext()) {
					Map.Entry e = (Map.Entry) it.next();
					// whereCondition+=((whereCondition.length() ==
					// 0)?" ":" and ")+"upper("+e.getKey()+")"+ " LIKE '%" +
					// e.getValue().toString().toUpperCase()+"%' ";
					if (e.getKey().equals("nombre")) {

						whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(nombre)"
								+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

					} else {
						whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(" + e.getKey() + ")"
								+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

					}

				}

				entity = nivel2ClientesmqDAO.findByCriteriaPage(whereCondition, sortField, sortOrder, startRow, pageSize);


	            List<Nivel2ClientesmqDTO> nivel2ClientesmqDTO = new ArrayList<Nivel2ClientesmqDTO>();

	            for (Nivel2Clientesmq nivel2ClientesmqTmp : entity) {
	                Nivel2ClientesmqDTO nivel2ClientesmqDTO2 = new Nivel2ClientesmqDTO();

	                nivel2ClientesmqDTO2.setNivel2ClientesmqId(nivel2ClientesmqTmp.getNivel2ClientesmqId());
	                nivel2ClientesmqDTO2.setBarrio((nivel2ClientesmqTmp.getBarrio() != null)
	                    ? nivel2ClientesmqTmp.getBarrio() : null);
	                nivel2ClientesmqDTO2.setCodigo((nivel2ClientesmqTmp.getCodigo() != null)
	                    ? nivel2ClientesmqTmp.getCodigo() : null);
	                nivel2ClientesmqDTO2.setCodigoAlternativo((nivel2ClientesmqTmp.getCodigoAlternativo() != null)
	                    ? nivel2ClientesmqTmp.getCodigoAlternativo() : null);
	                nivel2ClientesmqDTO2.setCompania((nivel2ClientesmqTmp.getCompania() != null)
	                    ? nivel2ClientesmqTmp.getCompania() : null);
	                nivel2ClientesmqDTO2.setDireccion((nivel2ClientesmqTmp.getDireccion() != null)
	                    ? nivel2ClientesmqTmp.getDireccion() : null);
	                nivel2ClientesmqDTO2.setDistanciaOficina((nivel2ClientesmqTmp.getDistanciaOficina() != null)
	                    ? nivel2ClientesmqTmp.getDistanciaOficina() : null);
	                nivel2ClientesmqDTO2.setDistanciaPlanta((nivel2ClientesmqTmp.getDistanciaPlanta() != null)
	                    ? nivel2ClientesmqTmp.getDistanciaPlanta() : null);
	                nivel2ClientesmqDTO2.setEstado((nivel2ClientesmqTmp.getEstado() != null)
	                    ? nivel2ClientesmqTmp.getEstado() : null);
	                nivel2ClientesmqDTO2.setFechaCreacion(nivel2ClientesmqTmp.getFechaCreacion());
	                nivel2ClientesmqDTO2.setFechaModificacion(nivel2ClientesmqTmp.getFechaModificacion());
	                nivel2ClientesmqDTO2.setInfoAdicional((nivel2ClientesmqTmp.getInfoAdicional() != null)
	                    ? nivel2ClientesmqTmp.getInfoAdicional() : null);
	                nivel2ClientesmqDTO2.setInfoAdicional2((nivel2ClientesmqTmp.getInfoAdicional2() != null)
	                    ? nivel2ClientesmqTmp.getInfoAdicional2() : null);
	                nivel2ClientesmqDTO2.setLatitud((nivel2ClientesmqTmp.getLatitud() != null)
	                    ? nivel2ClientesmqTmp.getLatitud() : null);
	                nivel2ClientesmqDTO2.setLongitud((nivel2ClientesmqTmp.getLongitud() != null)
	                    ? nivel2ClientesmqTmp.getLongitud() : null);
	                nivel2ClientesmqDTO2.setNombre((nivel2ClientesmqTmp.getNombre() != null)
	                    ? nivel2ClientesmqTmp.getNombre() : null);
	                nivel2ClientesmqDTO2.setObservacion((nivel2ClientesmqTmp.getObservacion() != null)
	                    ? nivel2ClientesmqTmp.getObservacion() : null);
	                nivel2ClientesmqDTO2.setPbx((nivel2ClientesmqTmp.getPbx() != null)
	                    ? nivel2ClientesmqTmp.getPbx() : null);
	                nivel2ClientesmqDTO2.setPrecision1((nivel2ClientesmqTmp.getPrecision1() != null)
	                    ? nivel2ClientesmqTmp.getPrecision1() : null);
	                nivel2ClientesmqDTO2.setTelefono((nivel2ClientesmqTmp.getTelefono() != null)
	                    ? nivel2ClientesmqTmp.getTelefono() : null);
	                nivel2ClientesmqDTO2.setTipoPropiedad((nivel2ClientesmqTmp.getTipoPropiedad() != null)
	                    ? nivel2ClientesmqTmp.getTipoPropiedad() : null);
	                nivel2ClientesmqDTO2.setVereda((nivel2ClientesmqTmp.getVereda() != null)
	                    ? nivel2ClientesmqTmp.getVereda() : null);

	                if (nivel2ClientesmqTmp.getCentCost() != null) {
	                    nivel2ClientesmqDTO2.setCentCostId_CentCost(nivel2ClientesmqTmp.getCentCost()
	                                                                               .getCentCostId());
	                } else {
	                    nivel2ClientesmqDTO2.setCentCostId_CentCost(null);
	                }
	                
	                if (nivel2ClientesmqTmp.getCiudad() != null) {
	                    nivel2ClientesmqDTO2.setCiudadId_Ciudad(nivel2ClientesmqTmp.getCiudad()
	                                                                               .getCiudadId());
	                } else {
	                    nivel2ClientesmqDTO2.setCiudadId_Ciudad(null);
	                }

	                nivel2ClientesmqDTO2.setPersEmprId_PersEmpr((nivel2ClientesmqTmp.getPersEmpr()
	                                                                                .getPersEmprId() != null)
	                    ? nivel2ClientesmqTmp.getPersEmpr().getPersEmprId() : null);
	                
	                if (nivel2ClientesmqTmp.getPersEmpr() != null) {
	                    nivel2ClientesmqDTO2.setNomCliente(nivel2ClientesmqTmp.getPersEmpr()
	                                                                               .getNombre());
	                } else {
	                    nivel2ClientesmqDTO2.setNomCliente(null);
	                }
	                
	                nivel2ClientesmqDTO.add(nivel2ClientesmqDTO2);
	            }

	            return nivel2ClientesmqDTO;
	        } catch (Exception e) {
	            throw e;
	        }
	    }


}
