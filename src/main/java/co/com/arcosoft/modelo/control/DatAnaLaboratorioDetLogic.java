package co.com.arcosoft.modelo.control;

import co.com.arcosoft.dataaccess.dao.*;
import co.com.arcosoft.exceptions.*;
import co.com.arcosoft.modelo.*;
import co.com.arcosoft.modelo.dto.DatAnaLaboratorioDetDTO;
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
@Service("DatAnaLaboratorioDetLogic")
public class DatAnaLaboratorioDetLogic implements IDatAnaLaboratorioDetLogic {
    private static final Logger log = LoggerFactory.getLogger(DatAnaLaboratorioDetLogic.class);

    /**
     * DAO injected by Spring that manages DatAnaLaboratorioDet entities
     *
     */
    @Autowired
    private IDatAnaLaboratorioDetDAO datAnaLaboratorioDetDAO;

    /**
    * Logic injected by Spring that manages DatAnaLaboratorio entities
    *
    */
    @Autowired
    IDatAnaLaboratorioLogic logicDatAnaLaboratorio1;

    /**
    * Logic injected by Spring that manages VariableLab entities
    *
    */
    @Autowired
    IVariableLabLogic logicVariableLab2;

    @Transactional(readOnly = true)
    public List<DatAnaLaboratorioDet> getDatAnaLaboratorioDet()
        throws Exception {
        log.debug("finding all DatAnaLaboratorioDet instances");

        List<DatAnaLaboratorioDet> list = new ArrayList<DatAnaLaboratorioDet>();

        try {
            list = datAnaLaboratorioDetDAO.findAll();
        } catch (Exception e) {
            log.error("finding all DatAnaLaboratorioDet failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "DatAnaLaboratorioDet");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveDatAnaLaboratorioDet(DatAnaLaboratorioDet entity)
        throws Exception {
        log.debug("saving DatAnaLaboratorioDet instance");

        try {
            if (entity.getDatAnaLaboratorio() == null) {
                throw new ZMessManager().new ForeignException(
                    "datAnaLaboratorio");
            }

            if (entity.getVariableLab() == null) {
                throw new ZMessManager().new ForeignException("variableLab");
            }

            if ((entity.getValorVariable() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorVariable(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorVariable");
            }

            if (entity.getDatAnaLaboratorio().getDatAnaLabId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "datAnaLabId_DatAnaLaboratorio");
            }

            if (entity.getVariableLab().getVariableLabId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "variableLabId_VariableLab");
            }


            datAnaLaboratorioDetDAO.save(entity);

            log.debug("save DatAnaLaboratorioDet successful");
        } catch (Exception e) {
            log.error("save DatAnaLaboratorioDet failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteDatAnaLaboratorioDet(DatAnaLaboratorioDet entity)
        throws Exception {
        log.debug("deleting DatAnaLaboratorioDet instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion(
                "DatAnaLaboratorioDet");
        }

        if (entity.getDatAnaLaboratorioDetId() == null) {
            throw new ZMessManager().new EmptyFieldException(
                "datAnaLaboratorioDetId");
        }

        try {
            datAnaLaboratorioDetDAO.delete(entity);

            log.debug("delete DatAnaLaboratorioDet successful");
        } catch (Exception e) {
            log.error("delete DatAnaLaboratorioDet failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateDatAnaLaboratorioDet(DatAnaLaboratorioDet entity)
        throws Exception {
        log.debug("updating DatAnaLaboratorioDet instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "DatAnaLaboratorioDet");
            }

            if (entity.getDatAnaLaboratorio() == null) {
                throw new ZMessManager().new ForeignException(
                    "datAnaLaboratorio");
            }

            if (entity.getVariableLab() == null) {
                throw new ZMessManager().new ForeignException("variableLab");
            }

          

            if (entity.getDatAnaLaboratorio().getDatAnaLabId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "datAnaLabId_DatAnaLaboratorio");
            }

            if (entity.getVariableLab().getVariableLabId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "variableLabId_VariableLab");
            }

            datAnaLaboratorioDetDAO.update(entity);

            log.debug("update DatAnaLaboratorioDet successful");
        } catch (Exception e) {
            log.error("update DatAnaLaboratorioDet failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<DatAnaLaboratorioDetDTO> getDataDatAnaLaboratorioDet()
        throws Exception {
        try {
            List<DatAnaLaboratorioDet> datAnaLaboratorioDet = datAnaLaboratorioDetDAO.findAll();

            List<DatAnaLaboratorioDetDTO> datAnaLaboratorioDetDTO = new ArrayList<DatAnaLaboratorioDetDTO>();

            for (DatAnaLaboratorioDet datAnaLaboratorioDetTmp : datAnaLaboratorioDet) {
                DatAnaLaboratorioDetDTO datAnaLaboratorioDetDTO2 = new DatAnaLaboratorioDetDTO();

                datAnaLaboratorioDetDTO2.setDatAnaLaboratorioDetId(datAnaLaboratorioDetTmp.getDatAnaLaboratorioDetId());
                datAnaLaboratorioDetDTO2.setHora0000(datAnaLaboratorioDetTmp.getHora0000());
                datAnaLaboratorioDetDTO2.setHora0100(datAnaLaboratorioDetTmp.getHora0100());
                datAnaLaboratorioDetDTO2.setHora0200(datAnaLaboratorioDetTmp.getHora0200());
                datAnaLaboratorioDetDTO2.setHora0300(datAnaLaboratorioDetTmp.getHora0300());
                datAnaLaboratorioDetDTO2.setHora0400(datAnaLaboratorioDetTmp.getHora0400());
                datAnaLaboratorioDetDTO2.setHora0500(datAnaLaboratorioDetTmp.getHora0500());
                datAnaLaboratorioDetDTO2.setHora0600(datAnaLaboratorioDetTmp.getHora0600());
                datAnaLaboratorioDetDTO2.setHora0700(datAnaLaboratorioDetTmp.getHora0700());
                datAnaLaboratorioDetDTO2.setHora0800(datAnaLaboratorioDetTmp.getHora0800());
                datAnaLaboratorioDetDTO2.setHora0900(datAnaLaboratorioDetTmp.getHora0900());
                datAnaLaboratorioDetDTO2.setHora1000(datAnaLaboratorioDetTmp.getHora1000());
                datAnaLaboratorioDetDTO2.setHora1100(datAnaLaboratorioDetTmp.getHora1100());
                datAnaLaboratorioDetDTO2.setHora1200(datAnaLaboratorioDetTmp.getHora1200());
                datAnaLaboratorioDetDTO2.setHora1300(datAnaLaboratorioDetTmp.getHora1300());
                datAnaLaboratorioDetDTO2.setHora1400(datAnaLaboratorioDetTmp.getHora1400());
                datAnaLaboratorioDetDTO2.setHora1500(datAnaLaboratorioDetTmp.getHora1500());
                datAnaLaboratorioDetDTO2.setHora1600(datAnaLaboratorioDetTmp.getHora1600());
                datAnaLaboratorioDetDTO2.setHora1700(datAnaLaboratorioDetTmp.getHora1700());
                datAnaLaboratorioDetDTO2.setHora1800(datAnaLaboratorioDetTmp.getHora1800());
                datAnaLaboratorioDetDTO2.setHora1900(datAnaLaboratorioDetTmp.getHora1900());
                datAnaLaboratorioDetDTO2.setHora2000(datAnaLaboratorioDetTmp.getHora2000());
                datAnaLaboratorioDetDTO2.setHora2100(datAnaLaboratorioDetTmp.getHora2100());
                datAnaLaboratorioDetDTO2.setHora2200(datAnaLaboratorioDetTmp.getHora2200());
                datAnaLaboratorioDetDTO2.setHora2300(datAnaLaboratorioDetTmp.getHora2300());
                datAnaLaboratorioDetDTO2.setValorVariable((datAnaLaboratorioDetTmp.getValorVariable() != null)
                    ? datAnaLaboratorioDetTmp.getValorVariable() : null);
                datAnaLaboratorioDetDTO2.setDatAnaLabId_DatAnaLaboratorio((datAnaLaboratorioDetTmp.getDatAnaLaboratorio()
                                                                                                  .getDatAnaLabId() != null)
                    ? datAnaLaboratorioDetTmp.getDatAnaLaboratorio()
                                             .getDatAnaLabId() : null);
                datAnaLaboratorioDetDTO2.setVariableLabId_VariableLab((datAnaLaboratorioDetTmp.getVariableLab()
                                                                                              .getVariableLabId() != null)
                    ? datAnaLaboratorioDetTmp.getVariableLab()
                    : null);
                datAnaLaboratorioDetDTO.add(datAnaLaboratorioDetDTO2);
            }

            return datAnaLaboratorioDetDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public DatAnaLaboratorioDet getDatAnaLaboratorioDet(
        Long datAnaLaboratorioDetId) throws Exception {
        log.debug("getting DatAnaLaboratorioDet instance");

        DatAnaLaboratorioDet entity = null;

        try {
            entity = datAnaLaboratorioDetDAO.findById(datAnaLaboratorioDetId);
        } catch (Exception e) {
            log.error("get DatAnaLaboratorioDet failed", e);
            throw new ZMessManager().new FindingException(
                "DatAnaLaboratorioDet");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<DatAnaLaboratorioDet> findPageDatAnaLaboratorioDet(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        List<DatAnaLaboratorioDet> entity = null;

        try {
            entity = datAnaLaboratorioDetDAO.findPage(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatAnaLaboratorioDet Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberDatAnaLaboratorioDet() throws Exception {
        Long entity = null;

        try {
            entity = datAnaLaboratorioDetDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatAnaLaboratorioDet Count");
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
    public List<DatAnaLaboratorioDet> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<DatAnaLaboratorioDet> list = new ArrayList<DatAnaLaboratorioDet>();
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
            list = datAnaLaboratorioDetDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
    

    @Transactional(readOnly = true)
    public List<DatAnaLaboratorioDetDTO> getDataDatAnaLaboratorioDetByAnalisis(Long idDatAnaLaboratorio)
        throws Exception {
        try {
            List<DatAnaLaboratorioDet> datAnaLaboratorioDet = 
            		datAnaLaboratorioDetDAO.findByCriteria("datAnaLaboratorio.datAnaLabId= " + idDatAnaLaboratorio);

            List<DatAnaLaboratorioDetDTO> datAnaLaboratorioDetDTO = new ArrayList<DatAnaLaboratorioDetDTO>();

            for (DatAnaLaboratorioDet datAnaLaboratorioDetTmp : datAnaLaboratorioDet) {
                DatAnaLaboratorioDetDTO datAnaLaboratorioDetDTO2 = new DatAnaLaboratorioDetDTO();

                datAnaLaboratorioDetDTO2.setDatAnaLaboratorioDetId(datAnaLaboratorioDetTmp.getDatAnaLaboratorioDetId());
                datAnaLaboratorioDetDTO2.setHora0000(datAnaLaboratorioDetTmp.getHora0000());
                datAnaLaboratorioDetDTO2.setHora0100(datAnaLaboratorioDetTmp.getHora0100());
                datAnaLaboratorioDetDTO2.setHora0200(datAnaLaboratorioDetTmp.getHora0200());
                datAnaLaboratorioDetDTO2.setHora0300(datAnaLaboratorioDetTmp.getHora0300());
                datAnaLaboratorioDetDTO2.setHora0400(datAnaLaboratorioDetTmp.getHora0400());
                datAnaLaboratorioDetDTO2.setHora0500(datAnaLaboratorioDetTmp.getHora0500());
                datAnaLaboratorioDetDTO2.setHora0600(datAnaLaboratorioDetTmp.getHora0600());
                datAnaLaboratorioDetDTO2.setHora0700(datAnaLaboratorioDetTmp.getHora0700());
                datAnaLaboratorioDetDTO2.setHora0800(datAnaLaboratorioDetTmp.getHora0800());
                datAnaLaboratorioDetDTO2.setHora0900(datAnaLaboratorioDetTmp.getHora0900());
                datAnaLaboratorioDetDTO2.setHora1000(datAnaLaboratorioDetTmp.getHora1000());
                datAnaLaboratorioDetDTO2.setHora1100(datAnaLaboratorioDetTmp.getHora1100());
                datAnaLaboratorioDetDTO2.setHora1200(datAnaLaboratorioDetTmp.getHora1200());
                datAnaLaboratorioDetDTO2.setHora1300(datAnaLaboratorioDetTmp.getHora1300());
                datAnaLaboratorioDetDTO2.setHora1400(datAnaLaboratorioDetTmp.getHora1400());
                datAnaLaboratorioDetDTO2.setHora1500(datAnaLaboratorioDetTmp.getHora1500());
                datAnaLaboratorioDetDTO2.setHora1600(datAnaLaboratorioDetTmp.getHora1600());
                datAnaLaboratorioDetDTO2.setHora1700(datAnaLaboratorioDetTmp.getHora1700());
                datAnaLaboratorioDetDTO2.setHora1800(datAnaLaboratorioDetTmp.getHora1800());
                datAnaLaboratorioDetDTO2.setHora1900(datAnaLaboratorioDetTmp.getHora1900());
                datAnaLaboratorioDetDTO2.setHora2000(datAnaLaboratorioDetTmp.getHora2000());
                datAnaLaboratorioDetDTO2.setHora2100(datAnaLaboratorioDetTmp.getHora2100());
                datAnaLaboratorioDetDTO2.setHora2200(datAnaLaboratorioDetTmp.getHora2200());
                datAnaLaboratorioDetDTO2.setHora2300(datAnaLaboratorioDetTmp.getHora2300());
                datAnaLaboratorioDetDTO2.setValorVariable((datAnaLaboratorioDetTmp.getValorVariable() != null)
                    ? datAnaLaboratorioDetTmp.getValorVariable() : null);
                datAnaLaboratorioDetDTO2.setDatAnaLabId_DatAnaLaboratorio((datAnaLaboratorioDetTmp.getDatAnaLaboratorio()
                                                                                                  .getDatAnaLabId() != null)
                    ? datAnaLaboratorioDetTmp.getDatAnaLaboratorio()
                                             .getDatAnaLabId() : null);
                datAnaLaboratorioDetDTO2.setVariableLabId_VariableLab((datAnaLaboratorioDetTmp.getVariableLab()
                                                                                              .getVariableLabId() != null)
                    ? datAnaLaboratorioDetTmp.getVariableLab()
                    : null);
                

				if (datAnaLaboratorioDetTmp.getVariableLab() != null) {
					datAnaLaboratorioDetDTO2.setCodigoVariable(datAnaLaboratorioDetTmp.getVariableLab().getNombre() 
							+" ("+datAnaLaboratorioDetTmp.getVariableLab().getCodigo()+ " )" );
				} else {
					datAnaLaboratorioDetDTO2.setCodigoVariable(null);
				}

				//String estadoEstrue = "true";
				String estadoEstrue = "none";
				
				if (datAnaLaboratorioDetTmp.getVariableLab() != null) {
					if (datAnaLaboratorioDetTmp.getVariableLab().getTipoVariable().						
							equals("Consulta_Sql")||datAnaLaboratorioDetTmp.getVariableLab().getTipoVariable().equals("Formula") ) {
							estadoEstrue = "inline-block";
								datAnaLaboratorioDetDTO2.setEstadoTrue(estadoEstrue);
						}else {
							datAnaLaboratorioDetDTO2.setEstadoTrue(estadoEstrue);
						}
				} else {
					datAnaLaboratorioDetDTO2.setEstadoTrue(estadoEstrue);
				}
			
				String color1 = "#FFFFFF";
				if (datAnaLaboratorioDetTmp.getVariableLab() != null) {
					if (datAnaLaboratorioDetTmp.getVariableLab().getTipoVariable().						
							equals("Consulta_Sql")) {
							color1  = "#90EE90";
								datAnaLaboratorioDetDTO2.setColor1(color1);
						}
					if (datAnaLaboratorioDetTmp.getVariableLab().getTipoVariable().						
							equals("Formula")) {
							color1  = "#ADD8E6";
								datAnaLaboratorioDetDTO2.setColor1(color1);
						}
				
					else {
							datAnaLaboratorioDetDTO2.setColor1(color1);
						}
				} else {
					datAnaLaboratorioDetDTO2.setColor1(color1);
				}
				
			
				
                datAnaLaboratorioDetDTO.add(datAnaLaboratorioDetDTO2);
            }

            return datAnaLaboratorioDetDTO;
        } catch (Exception e) {
            throw e;
        }
    }

}
