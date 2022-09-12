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

import co.com.arcosoft.dataaccess.dao.IAnaLaboratorioDAO;
import co.com.arcosoft.dataaccess.dao.IAnaLaboratorioVariableDAO;
import co.com.arcosoft.dataaccess.dao.IDatAnaLaboratorioDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.AnaLaboratorio;
import co.com.arcosoft.modelo.AnaLaboratorioVariable;
import co.com.arcosoft.modelo.DatAnaLaboratorio;
import co.com.arcosoft.modelo.dto.AnaLaboratorioDTO;
import co.com.arcosoft.modelo.dto.AnaLaboratorioVariableDTO;
import co.com.arcosoft.utilities.Utilities;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("AnaLaboratorioLogic")
public class AnaLaboratorioLogic implements IAnaLaboratorioLogic {
    private static final Logger log = LoggerFactory.getLogger(AnaLaboratorioLogic.class);

    /**
     * DAO injected by Spring that manages AnaLaboratorio entities
     *
     */
    @Autowired
    private IAnaLaboratorioDAO anaLaboratorioDAO;

    /**
    * DAO injected by Spring that manages AnaLaboratorioVariable entities
    *
    */
    @Autowired
    private IAnaLaboratorioVariableDAO anaLaboratorioVariableDAO;

    /**
    * DAO injected by Spring that manages DatAnaLaboratorio entities
    *
    */
    @Autowired
    private IDatAnaLaboratorioDAO datAnaLaboratorioDAO;

    @Transactional(readOnly = true)
    public List<AnaLaboratorio> getAnaLaboratorio() throws Exception {
        log.debug("finding all AnaLaboratorio instances");

        List<AnaLaboratorio> list = new ArrayList<AnaLaboratorio>();

        try {
            list = anaLaboratorioDAO.findAll();
        } catch (Exception e) {
            log.error("finding all AnaLaboratorio failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "AnaLaboratorio");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveAnaLaboratorio(AnaLaboratorio entity, List<AnaLaboratorioVariableDTO> dataVariablesLab)
        throws Exception {
        log.debug("saving AnaLaboratorio instance");

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

            if ((entity.getFrecuenciaDigitacion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getFrecuenciaDigitacion(), 30) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "frecuenciaDigitacion");
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

            if ((entity.getNombre() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getNombre(),
                        60) == false)) {
                throw new ZMessManager().new NotValidFormatException("nombre");
            }

            if ((entity.getTipoAnalisis() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getTipoAnalisis(), 30) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "tipoAnalisis");
            }


            anaLaboratorioDAO.save(entity);
            
            if (dataVariablesLab != null) {

				for (AnaLaboratorioVariableDTO valorDto : dataVariablesLab) {

					if (valorDto.getAnaLaboratorioVariableId() == null) {

						AnaLaboratorioVariable valor = new AnaLaboratorioVariable();

						valor.setVariableLab(valorDto.getVariableLabId_VariableLab());
						valor.setOrdenDigitacion(valorDto.getOrdenDigitacion());
					
						valor.setAnaLaboratorio(entity);

						anaLaboratorioVariableDAO.save(valor);
					}

				}
			}

            log.debug("save AnaLaboratorio successful");
        } catch (Exception e) {
            log.error("save AnaLaboratorio failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteAnaLaboratorio(AnaLaboratorio entity)
        throws Exception {
        log.debug("deleting AnaLaboratorio instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("AnaLaboratorio");
        }

        if (entity.getAnaLabId() == null) {
            throw new ZMessManager().new EmptyFieldException("anaLabId");
        }

        List<AnaLaboratorioVariable> anaLaboratorioVariables = null;
        List<DatAnaLaboratorio> datAnaLaboratorios = null;

        try {
            anaLaboratorioVariables = anaLaboratorioVariableDAO.findByProperty("anaLaboratorio.anaLabId",
                    entity.getAnaLabId());

            if (Utilities.validationsList(anaLaboratorioVariables) == true) {
                throw new ZMessManager().new DeletingException(
                    "anaLaboratorioVariables");
            }

            datAnaLaboratorios = datAnaLaboratorioDAO.findByProperty("anaLaboratorio.anaLabId",
                    entity.getAnaLabId());

            if (Utilities.validationsList(datAnaLaboratorios) == true) {
                throw new ZMessManager().new DeletingException(
                    "datAnaLaboratorios");
            }

            anaLaboratorioDAO.delete(entity);

            log.debug("delete AnaLaboratorio successful");
        } catch (Exception e) {
            log.error("delete AnaLaboratorio failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateAnaLaboratorio(AnaLaboratorio entity, List<AnaLaboratorioVariableDTO> dataVariablesLab)
        throws Exception {
        log.debug("updating AnaLaboratorio instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "AnaLaboratorio");
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

            if ((entity.getFrecuenciaDigitacion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getFrecuenciaDigitacion(), 30) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "frecuenciaDigitacion");
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

            if ((entity.getNombre() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getNombre(),
                        60) == false)) {
                throw new ZMessManager().new NotValidFormatException("nombre");
            }

            if ((entity.getTipoAnalisis() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getTipoAnalisis(), 30) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "tipoAnalisis");
            }

            anaLaboratorioDAO.update(entity);

            if (dataVariablesLab != null) {

				for (AnaLaboratorioVariableDTO valorDto : dataVariablesLab) {

					if (valorDto.getAnaLaboratorioVariableId() == null) {

						AnaLaboratorioVariable valor = new AnaLaboratorioVariable();

						valor.setVariableLab(valorDto.getVariableLabId_VariableLab());
						valor.setOrdenDigitacion(valorDto.getOrdenDigitacion());
					
						valor.setAnaLaboratorio(entity);

						anaLaboratorioVariableDAO.save(valor);


					} else {

						AnaLaboratorioVariable valor = anaLaboratorioVariableDAO.findById(valorDto.getAnaLaboratorioVariableId());


						valor.setVariableLab(valorDto.getVariableLabId_VariableLab());
						valor.setOrdenDigitacion(valorDto.getOrdenDigitacion());
					
						valor.setAnaLaboratorio(entity);

						anaLaboratorioVariableDAO.update(valor);

					}

				}
			}

            log.debug("update AnaLaboratorio successful");
        } catch (Exception e) {
            log.error("update AnaLaboratorio failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<AnaLaboratorioDTO> getDataAnaLaboratorio()
        throws Exception {
        try {
            List<AnaLaboratorio> anaLaboratorio = anaLaboratorioDAO.findAll();

            List<AnaLaboratorioDTO> anaLaboratorioDTO = new ArrayList<AnaLaboratorioDTO>();

            for (AnaLaboratorio anaLaboratorioTmp : anaLaboratorio) {
                AnaLaboratorioDTO anaLaboratorioDTO2 = new AnaLaboratorioDTO();

                anaLaboratorioDTO2.setAnaLabId(anaLaboratorioTmp.getAnaLabId());
                anaLaboratorioDTO2.setCodigo((anaLaboratorioTmp.getCodigo() != null)
                    ? anaLaboratorioTmp.getCodigo() : null);
                anaLaboratorioDTO2.setCompania((anaLaboratorioTmp.getCompania() != null)
                    ? anaLaboratorioTmp.getCompania() : null);
                anaLaboratorioDTO2.setEstado((anaLaboratorioTmp.getEstado() != null)
                    ? anaLaboratorioTmp.getEstado() : null);
                anaLaboratorioDTO2.setFechaCreacion(anaLaboratorioTmp.getFechaCreacion());
                anaLaboratorioDTO2.setFechaModificacion(anaLaboratorioTmp.getFechaModificacion());
                anaLaboratorioDTO2.setFrecuenciaDigitacion((anaLaboratorioTmp.getFrecuenciaDigitacion() != null)
                    ? anaLaboratorioTmp.getFrecuenciaDigitacion() : null);
                anaLaboratorioDTO2.setHoraInicialDigitacion(anaLaboratorioTmp.getHoraInicialDigitacion());
                anaLaboratorioDTO2.setInfoAdicional((anaLaboratorioTmp.getInfoAdicional() != null)
                    ? anaLaboratorioTmp.getInfoAdicional() : null);
                anaLaboratorioDTO2.setInfoAdicional2((anaLaboratorioTmp.getInfoAdicional2() != null)
                    ? anaLaboratorioTmp.getInfoAdicional2() : null);
                anaLaboratorioDTO2.setNombre((anaLaboratorioTmp.getNombre() != null)
                    ? anaLaboratorioTmp.getNombre() : null);
                anaLaboratorioDTO2.setTipoAnalisis((anaLaboratorioTmp.getTipoAnalisis() != null)
                    ? anaLaboratorioTmp.getTipoAnalisis() : null);
                anaLaboratorioDTO.add(anaLaboratorioDTO2);
            }

            return anaLaboratorioDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public AnaLaboratorio getAnaLaboratorio(Long anaLabId)
        throws Exception {
        log.debug("getting AnaLaboratorio instance");

        AnaLaboratorio entity = null;

        try {
            entity = anaLaboratorioDAO.findById(anaLabId);
        } catch (Exception e) {
            log.error("get AnaLaboratorio failed", e);
            throw new ZMessManager().new FindingException("AnaLaboratorio");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<AnaLaboratorio> findPageAnaLaboratorio(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<AnaLaboratorio> entity = null;

        try {
            entity = anaLaboratorioDAO.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "AnaLaboratorio Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberAnaLaboratorio() throws Exception {
        Long entity = null;

        try {
            entity = anaLaboratorioDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "AnaLaboratorio Count");
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
    public List<AnaLaboratorio> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<AnaLaboratorio> list = new ArrayList<AnaLaboratorio>();
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
            list = anaLaboratorioDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
