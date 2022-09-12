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

import co.com.arcosoft.dataaccess.dao.IDatParadasFabricaDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatParadasFabrica;
import co.com.arcosoft.modelo.dto.DatParadasFabricaDTO;
import co.com.arcosoft.utilities.Utilities;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("DatParadasFabricaLogic")
public class DatParadasFabricaLogic implements IDatParadasFabricaLogic {
    private static final Logger log = LoggerFactory.getLogger(DatParadasFabricaLogic.class);

    /**
     * DAO injected by Spring that manages DatParadasFabrica entities
     *
     */
    @Autowired
    private IDatParadasFabricaDAO datParadasFabricaDAO;

    @Transactional(readOnly = true)
    public List<DatParadasFabrica> getDatParadasFabrica()
        throws Exception {
        log.debug("finding all DatParadasFabrica instances");

        List<DatParadasFabrica> list = new ArrayList<DatParadasFabrica>();

        try {
            list = datParadasFabricaDAO.findAll();
        } catch (Exception e) {
            log.error("finding all DatParadasFabrica failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "DatParadasFabrica");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveDatParadasFabrica(DatParadasFabrica entity)
        throws Exception {
        log.debug("saving DatParadasFabrica instance");

        try {
            if ((entity.getDescripcionParada() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDescripcionParada(), 3900) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "descripcionParada");
            }

            if ((entity.getEstado() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
                throw new ZMessManager().new NotValidFormatException("estado");
            }

            if ((entity.getObservacionAnularReg() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getObservacionAnularReg(), 500) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "observacionAnularReg");
            }

            if ((entity.getObservaciones() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getObservaciones(), 3900) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "observaciones");
            }

            if ((entity.getParadaCritica() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getParadaCritica(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "paradaCritica");
            }


            datParadasFabricaDAO.save(entity);

            log.debug("save DatParadasFabrica successful");
        } catch (Exception e) {
            log.error("save DatParadasFabrica failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteDatParadasFabrica(DatParadasFabrica entity)
        throws Exception {
        log.debug("deleting DatParadasFabrica instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion(
                "DatParadasFabrica");
        }

        if (entity.getDatParadasFabricaId() == null) {
            throw new ZMessManager().new EmptyFieldException(
                "datParadasFabricaId");
        }

        try {
            datParadasFabricaDAO.delete(entity);

            log.debug("delete DatParadasFabrica successful");
        } catch (Exception e) {
            log.error("delete DatParadasFabrica failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateDatParadasFabrica(DatParadasFabrica entity)
        throws Exception {
        log.debug("updating DatParadasFabrica instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "DatParadasFabrica");
            }

            if ((entity.getDescripcionParada() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDescripcionParada(), 3900) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "descripcionParada");
            }

            if ((entity.getEstado() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
                throw new ZMessManager().new NotValidFormatException("estado");
            }

            if ((entity.getObservacionAnularReg() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getObservacionAnularReg(), 500) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "observacionAnularReg");
            }

            if ((entity.getObservaciones() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getObservaciones(), 3900) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "observaciones");
            }

            if ((entity.getParadaCritica() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getParadaCritica(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "paradaCritica");
            }

            datParadasFabricaDAO.update(entity);

            log.debug("update DatParadasFabrica successful");
        } catch (Exception e) {
            log.error("update DatParadasFabrica failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<DatParadasFabricaDTO> getDataDatParadasFabrica()
        throws Exception {
        try {
            List<DatParadasFabrica> datParadasFabrica = datParadasFabricaDAO.findAll();

            List<DatParadasFabricaDTO> datParadasFabricaDTO = new ArrayList<DatParadasFabricaDTO>();

            for (DatParadasFabrica datParadasFabricaTmp : datParadasFabrica) {
                DatParadasFabricaDTO datParadasFabricaDTO2 = new DatParadasFabricaDTO();

                datParadasFabricaDTO2.setDatParadasFabricaId(datParadasFabricaTmp.getDatParadasFabricaId());
                
                if (datParadasFabricaTmp.getAgenteCausadorParadaId() != null) {
                	datParadasFabricaDTO2.setAgenteCausadorParadaId(datParadasFabricaTmp.getAgenteCausadorParadaId().getAgenteCausadorParadaId());
				} else {
					datParadasFabricaDTO2.setAgenteCausadorParadaId(null);
				}
                
                if (datParadasFabricaTmp.getAreaTrabajoId() != null) {
                	datParadasFabricaDTO2.setAreaTrabajoId(datParadasFabricaTmp.getAreaTrabajoId().getAreaTrabajoId());
				} else {
					datParadasFabricaDTO2.setAreaTrabajoId(null);
				}
               
                if (datParadasFabricaTmp.getTagId() != null) {
                	datParadasFabricaDTO2.setTagId(datParadasFabricaTmp.getTagId().getTagId());
				} else {
					datParadasFabricaDTO2.setTagId(null);
				}
              
                if (datParadasFabricaTmp.getEquipoId() != null) {
                	datParadasFabricaDTO2.setEquipoId(datParadasFabricaTmp.getEquipoId().getEquipoId());
				} else {
					datParadasFabricaDTO2.setEquipoId(null);
				}
                
                if (datParadasFabricaTmp.getMotivosParadaId() != null) {
                	datParadasFabricaDTO2.setMotivosParadaId(datParadasFabricaTmp.getMotivosParadaId().getMotivosEntradaTallerId());
				} else {
					datParadasFabricaDTO2.setMotivosParadaId(null);
				}
                datParadasFabricaDTO2.setCompania((datParadasFabricaTmp.getCompania() != null)
                    ? datParadasFabricaTmp.getCompania() : null);
                datParadasFabricaDTO2.setConsecutivo((datParadasFabricaTmp.getConsecutivo() != null)
                    ? datParadasFabricaTmp.getConsecutivo() : null);
                datParadasFabricaDTO2.setDescripcionParada((datParadasFabricaTmp.getDescripcionParada() != null)
                    ? datParadasFabricaTmp.getDescripcionParada() : null);
                datParadasFabricaDTO2.setEstado((datParadasFabricaTmp.getEstado() != null)
                    ? datParadasFabricaTmp.getEstado() : null);
                datParadasFabricaDTO2.setFechaAnulacion(datParadasFabricaTmp.getFechaAnulacion());
                datParadasFabricaDTO2.setFechaCreacion(datParadasFabricaTmp.getFechaCreacion());
                datParadasFabricaDTO2.setFechaModificacion(datParadasFabricaTmp.getFechaModificacion());
                datParadasFabricaDTO2.setFechapFinal(datParadasFabricaTmp.getFechapFinal());
                datParadasFabricaDTO2.setFechapInicial(datParadasFabricaTmp.getFechapInicial());
                datParadasFabricaDTO2.setHorapFinal(datParadasFabricaTmp.getHorapFinal());
                datParadasFabricaDTO2.setHorapInicial(datParadasFabricaTmp.getHorapInicial());
                datParadasFabricaDTO2.setObservacionAnularReg((datParadasFabricaTmp.getObservacionAnularReg() != null)
                    ? datParadasFabricaTmp.getObservacionAnularReg() : null);
                datParadasFabricaDTO2.setObservaciones((datParadasFabricaTmp.getObservaciones() != null)
                    ? datParadasFabricaTmp.getObservaciones() : null);
                datParadasFabricaDTO2.setParadaCritica((datParadasFabricaTmp.getParadaCritica() != null)
                    ? datParadasFabricaTmp.getParadaCritica() : null);
                datParadasFabricaDTO2.setUsuarioDigitacion((datParadasFabricaTmp.getUsuarioDigitacion() != null)
                        ? datParadasFabricaTmp.getUsuarioDigitacion() : null);
                
                
                if (datParadasFabricaTmp.getAgenteCausadorParadaId() != null) {
                	datParadasFabricaDTO2.setNombreAgente(datParadasFabricaTmp.getAgenteCausadorParadaId().getNombre());
				} else {
					datParadasFabricaDTO2.setNombreAgente(null);
				}
                
                if (datParadasFabricaTmp.getAreaTrabajoId() != null) {
                	datParadasFabricaDTO2.setNombreAreaTrabajo(datParadasFabricaTmp.getAreaTrabajoId().getNombre());
				} else {
					datParadasFabricaDTO2.setNombreAreaTrabajo(null);
				}
               
                if (datParadasFabricaTmp.getTagId() != null) {
                	datParadasFabricaDTO2.setNombreTag(datParadasFabricaTmp.getTagId().getNombre());
				} else {
					datParadasFabricaDTO2.setNombreTag(null);
				}
              
                if (datParadasFabricaTmp.getEquipoId() != null) {
                	datParadasFabricaDTO2.setNombreEquipo(datParadasFabricaTmp.getEquipoId().getNombre());
				} else {
					datParadasFabricaDTO2.setNombreEquipo(null);
				}
                
                if (datParadasFabricaTmp.getMotivosParadaId() != null) {
                	datParadasFabricaDTO2.setNombreMotivoParada(datParadasFabricaTmp.getMotivosParadaId().getNombre());
				} else {
					datParadasFabricaDTO2.setNombreMotivoParada(null);
				}
                
                datParadasFabricaDTO.add(datParadasFabricaDTO2);
            }

            return datParadasFabricaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public DatParadasFabrica getDatParadasFabrica(Long datParadasFabricaId)
        throws Exception {
        log.debug("getting DatParadasFabrica instance");

        DatParadasFabrica entity = null;

        try {
            entity = datParadasFabricaDAO.findById(datParadasFabricaId);
        } catch (Exception e) {
            log.error("get DatParadasFabrica failed", e);
            throw new ZMessManager().new FindingException("DatParadasFabrica");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<DatParadasFabrica> findPageDatParadasFabrica(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        List<DatParadasFabrica> entity = null;

        try {
            entity = datParadasFabricaDAO.findPage(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatParadasFabrica Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberDatParadasFabrica() throws Exception {
        Long entity = null;

        try {
            entity = datParadasFabricaDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatParadasFabrica Count");
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
    public List<DatParadasFabrica> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<DatParadasFabrica> list = new ArrayList<DatParadasFabrica>();
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
            list = datParadasFabricaDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
