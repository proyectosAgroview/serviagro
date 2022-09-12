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

import co.com.arcosoft.dataaccess.dao.IDatCtrlMaqPinesDAO;
import co.com.arcosoft.dataaccess.dao.IInformes2DAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatCajaMenorDet;
import co.com.arcosoft.modelo.DatCtrlMaqPines;
import co.com.arcosoft.modelo.dto.DatCtrlMaqPinesDTO;
import co.com.arcosoft.utilities.Utilities;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("DatCtrlMaqPinesLogic")
public class DatCtrlMaqPinesLogic implements IDatCtrlMaqPinesLogic {
    private static final Logger log = LoggerFactory.getLogger(DatCtrlMaqPinesLogic.class);

    /**
     * DAO injected by Spring that manages DatCtrlMaqPines entities
     *
     */
    @Autowired
    private IDatCtrlMaqPinesDAO datCtrlMaqPinesDAO;

	@Autowired
	private IInformes2DAO informes2DAO;
    /**
    * Logic injected by Spring that manages Equipo entities
    *
    */
    @Autowired
    IEquipoLogic logicEquipo1;

    @Transactional(readOnly = true)
    public List<DatCtrlMaqPines> getDatCtrlMaqPines() throws Exception {
        log.debug("finding all DatCtrlMaqPines instances");

        List<DatCtrlMaqPines> list = new ArrayList<DatCtrlMaqPines>();

        try {
            list = datCtrlMaqPinesDAO.findAll();
        } catch (Exception e) {
            log.error("finding all DatCtrlMaqPines failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "DatCtrlMaqPines");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveDatCtrlMaqPines(DatCtrlMaqPines entity)
        throws Exception {
        log.debug("saving DatCtrlMaqPines instance");

        try {
            if (entity.getEquipo() == null) {
                throw new ZMessManager().new ForeignException("equipo");
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

            if ((entity.getUltHoroOdoMetro() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getUltHoroOdoMetro(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "ultHoroOdoMetro");
            }

            if (entity.getEquipo().getEquipoId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "equipoId_Equipo");
            }

          

            datCtrlMaqPinesDAO.save(entity);

            log.debug("save DatCtrlMaqPines successful");
        } catch (Exception e) {
            log.error("save DatCtrlMaqPines failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteDatCtrlMaqPines(DatCtrlMaqPines entity)
        throws Exception {
        log.debug("deleting DatCtrlMaqPines instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("DatCtrlMaqPines");
        }

        if (entity.getDatCtrlMaqPinesId() == null) {
            throw new ZMessManager().new EmptyFieldException(
                "datCtrlMaqPinesId");
        }

        try {
            datCtrlMaqPinesDAO.delete(entity);

            log.debug("delete DatCtrlMaqPines successful");
        } catch (Exception e) {
            log.error("delete DatCtrlMaqPines failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateDatCtrlMaqPines(DatCtrlMaqPines entity)
        throws Exception {
        log.debug("updating DatCtrlMaqPines instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "DatCtrlMaqPines");
            }

            if (entity.getEquipo() == null) {
                throw new ZMessManager().new ForeignException("equipo");
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

            if ((entity.getUltHoroOdoMetro() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getUltHoroOdoMetro(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "ultHoroOdoMetro");
            }

            if (entity.getEquipo().getEquipoId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "equipoId_Equipo");
            }

            datCtrlMaqPinesDAO.update(entity);

            log.debug("update DatCtrlMaqPines successful");
        } catch (Exception e) {
            log.error("update DatCtrlMaqPines failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<DatCtrlMaqPinesDTO> getDataDatCtrlMaqPines()
        throws Exception {
        try {
            List<DatCtrlMaqPines> datCtrlMaqPines = datCtrlMaqPinesDAO.findAll();

            List<DatCtrlMaqPinesDTO> datCtrlMaqPinesDTO = new ArrayList<DatCtrlMaqPinesDTO>();

            for (DatCtrlMaqPines datCtrlMaqPinesTmp : datCtrlMaqPines) {
                DatCtrlMaqPinesDTO datCtrlMaqPinesDTO2 = new DatCtrlMaqPinesDTO();

                datCtrlMaqPinesDTO2.setDatCtrlMaqPinesId(datCtrlMaqPinesTmp.getDatCtrlMaqPinesId());
                datCtrlMaqPinesDTO2.setBoletaFinal((datCtrlMaqPinesTmp.getBoletaFinal() != null)
                    ? datCtrlMaqPinesTmp.getBoletaFinal() : null);
                datCtrlMaqPinesDTO2.setBoletaInicial((datCtrlMaqPinesTmp.getBoletaInicial() != null)
                    ? datCtrlMaqPinesTmp.getBoletaInicial() : null);
                datCtrlMaqPinesDTO2.setCompania((datCtrlMaqPinesTmp.getCompania() != null)
                    ? datCtrlMaqPinesTmp.getCompania() : null);
                datCtrlMaqPinesDTO2.setConsecutivoPin((datCtrlMaqPinesTmp.getConsecutivoPin() != null)
                    ? datCtrlMaqPinesTmp.getConsecutivoPin() : null);
                datCtrlMaqPinesDTO2.setEstado((datCtrlMaqPinesTmp.getEstado() != null)
                    ? datCtrlMaqPinesTmp.getEstado() : null);
                datCtrlMaqPinesDTO2.setFechaAnulacion(datCtrlMaqPinesTmp.getFechaAnulacion());
                datCtrlMaqPinesDTO2.setFechaCreacion(datCtrlMaqPinesTmp.getFechaCreacion());
                datCtrlMaqPinesDTO2.setFechaModificacion(datCtrlMaqPinesTmp.getFechaModificacion());
                datCtrlMaqPinesDTO2.setObservacion((datCtrlMaqPinesTmp.getObservacion() != null)
                    ? datCtrlMaqPinesTmp.getObservacion() : null);
                datCtrlMaqPinesDTO2.setObservacionAnularReg((datCtrlMaqPinesTmp.getObservacionAnularReg() != null)
                    ? datCtrlMaqPinesTmp.getObservacionAnularReg() : null);
                datCtrlMaqPinesDTO2.setUltHoroOdoMetro((datCtrlMaqPinesTmp.getUltHoroOdoMetro() != null)
                    ? datCtrlMaqPinesTmp.getUltHoroOdoMetro() : null);
                datCtrlMaqPinesDTO2.setUsuarioDigitacion((datCtrlMaqPinesTmp.getUsuarioDigitacion() != null)
                    ? datCtrlMaqPinesTmp.getUsuarioDigitacion() : null);

                if (datCtrlMaqPinesTmp.getEquipo() != null) {
                    datCtrlMaqPinesDTO2.setEquipoId_Equipo(datCtrlMaqPinesTmp.getEquipo()
                                                                             .getEquipoId());
                } else {
                    datCtrlMaqPinesDTO2.setEquipoId_Equipo(null);
                }

                if (datCtrlMaqPinesTmp.getEquipo() != null) {
                    datCtrlMaqPinesDTO2.setCodigoEquipo(datCtrlMaqPinesTmp.getEquipo()
                                                                             .getCodigo());
                } else {
                    datCtrlMaqPinesDTO2.setCodigoEquipo(null);
                }
                if (datCtrlMaqPinesTmp.getEquipo() != null) {
                	Long equipoConsulta = datCtrlMaqPinesTmp.getEquipo()
                            .getEquipoId();
                    datCtrlMaqPinesDTO2.setUltHorometroTanqueo( informes2DAO.pr_ult_horo_odometro_tanqueo( datCtrlMaqPinesTmp.getCompania(),  equipoConsulta));
                
                } else {
                    datCtrlMaqPinesDTO2.setUltHorometroTanqueo(null);
                }
                
                datCtrlMaqPinesDTO2.setIndicador_vuelta_medidor((datCtrlMaqPinesTmp.getIndicador_vuelta_medidor() != null)
                        ? datCtrlMaqPinesTmp.getIndicador_vuelta_medidor() : null);
                    
                
                datCtrlMaqPinesDTO.add(datCtrlMaqPinesDTO2);
                

                
            }

            return datCtrlMaqPinesDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public DatCtrlMaqPines getDatCtrlMaqPines(Long datCtrlMaqPinesId)
        throws Exception {
        log.debug("getting DatCtrlMaqPines instance");

        DatCtrlMaqPines entity = null;

        try {
            entity = datCtrlMaqPinesDAO.findById(datCtrlMaqPinesId);
        } catch (Exception e) {
            log.error("get DatCtrlMaqPines failed", e);
            throw new ZMessManager().new FindingException("DatCtrlMaqPines");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<DatCtrlMaqPines> findPageDatCtrlMaqPines(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        List<DatCtrlMaqPines> entity = null;

        try {
            entity = datCtrlMaqPinesDAO.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatCtrlMaqPines Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberDatCtrlMaqPines() throws Exception {
        Long entity = null;

        try {
            entity = datCtrlMaqPinesDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatCtrlMaqPines Count");
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
    public List<DatCtrlMaqPines> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<DatCtrlMaqPines> list = new ArrayList<DatCtrlMaqPines>();
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
            list = datCtrlMaqPinesDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
    
    
    @Transactional(readOnly = true)
    public List<DatCtrlMaqPinesDTO> getDataDatCtrlMaqPinesFiltroEquipo(Long equipoId)
        throws Exception {
        try {
        	
        	   List<DatCtrlMaqPines> datCtrlMaqPines = datCtrlMaqPinesDAO
   					.findByCriteria("equipo.equipoId= " + equipoId);
        	   
      

            List<DatCtrlMaqPinesDTO> datCtrlMaqPinesDTO = new ArrayList<DatCtrlMaqPinesDTO>();

            for (DatCtrlMaqPines datCtrlMaqPinesTmp : datCtrlMaqPines) {
                DatCtrlMaqPinesDTO datCtrlMaqPinesDTO2 = new DatCtrlMaqPinesDTO();

                datCtrlMaqPinesDTO2.setDatCtrlMaqPinesId(datCtrlMaqPinesTmp.getDatCtrlMaqPinesId());
                datCtrlMaqPinesDTO2.setBoletaFinal((datCtrlMaqPinesTmp.getBoletaFinal() != null)
                    ? datCtrlMaqPinesTmp.getBoletaFinal() : null);
                datCtrlMaqPinesDTO2.setBoletaInicial((datCtrlMaqPinesTmp.getBoletaInicial() != null)
                    ? datCtrlMaqPinesTmp.getBoletaInicial() : null);
                datCtrlMaqPinesDTO2.setCompania((datCtrlMaqPinesTmp.getCompania() != null)
                    ? datCtrlMaqPinesTmp.getCompania() : null);
                datCtrlMaqPinesDTO2.setConsecutivoPin((datCtrlMaqPinesTmp.getConsecutivoPin() != null)
                    ? datCtrlMaqPinesTmp.getConsecutivoPin() : null);
                datCtrlMaqPinesDTO2.setEstado((datCtrlMaqPinesTmp.getEstado() != null)
                    ? datCtrlMaqPinesTmp.getEstado() : null);
                datCtrlMaqPinesDTO2.setFechaAnulacion(datCtrlMaqPinesTmp.getFechaAnulacion());
                datCtrlMaqPinesDTO2.setFechaCreacion(datCtrlMaqPinesTmp.getFechaCreacion());
                datCtrlMaqPinesDTO2.setFechaModificacion(datCtrlMaqPinesTmp.getFechaModificacion());
                datCtrlMaqPinesDTO2.setObservacion((datCtrlMaqPinesTmp.getObservacion() != null)
                    ? datCtrlMaqPinesTmp.getObservacion() : null);
                datCtrlMaqPinesDTO2.setObservacionAnularReg((datCtrlMaqPinesTmp.getObservacionAnularReg() != null)
                    ? datCtrlMaqPinesTmp.getObservacionAnularReg() : null);
                datCtrlMaqPinesDTO2.setUltHoroOdoMetro((datCtrlMaqPinesTmp.getUltHoroOdoMetro() != null)
                    ? datCtrlMaqPinesTmp.getUltHoroOdoMetro() : null);
                datCtrlMaqPinesDTO2.setUsuarioDigitacion((datCtrlMaqPinesTmp.getUsuarioDigitacion() != null)
                    ? datCtrlMaqPinesTmp.getUsuarioDigitacion() : null);

                if (datCtrlMaqPinesTmp.getEquipo() != null) {
                    datCtrlMaqPinesDTO2.setEquipoId_Equipo(datCtrlMaqPinesTmp.getEquipo()
                                                                             .getEquipoId());
                } else {
                    datCtrlMaqPinesDTO2.setEquipoId_Equipo(null);
                }
                
              
                
                if (datCtrlMaqPinesTmp.getEquipo() != null) {
                	Long equipoConsulta = datCtrlMaqPinesTmp.getEquipo()
                            .getEquipoId();
                    datCtrlMaqPinesDTO2.setUltHorometroTanqueo( informes2DAO.pr_ult_horo_odometro_tanqueo( datCtrlMaqPinesTmp.getCompania(),  equipoConsulta));
                
                } else {
                    datCtrlMaqPinesDTO2.setUltHorometroTanqueo(null);
                }

                if (datCtrlMaqPinesTmp.getEquipo() != null) {
                    datCtrlMaqPinesDTO2.setCodigoEquipo(datCtrlMaqPinesTmp.getEquipo()
                                                                             .getCodigo());
                } else {
                    datCtrlMaqPinesDTO2.setCodigoEquipo(null);
                }
                datCtrlMaqPinesDTO2.setIndicador_vuelta_medidor((datCtrlMaqPinesTmp.getIndicador_vuelta_medidor() != null)
                        ? datCtrlMaqPinesTmp.getIndicador_vuelta_medidor() : null);
                    
                
                
                datCtrlMaqPinesDTO.add(datCtrlMaqPinesDTO2);
                
      
            }

            return datCtrlMaqPinesDTO;
        } catch (Exception e) {
            throw e;
        }
    }
}
