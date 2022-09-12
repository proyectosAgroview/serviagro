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

import co.com.arcosoft.dataaccess.dao.INivel4ClientesmqDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Nivel4Clientesmq;
import co.com.arcosoft.modelo.dto.Nivel4ClientesmqDTO;
import co.com.arcosoft.utilities.Utilities;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("Nivel4ClientesmqLogic")
public class Nivel4ClientesmqLogic implements INivel4ClientesmqLogic {
    private static final Logger log = LoggerFactory.getLogger(Nivel4ClientesmqLogic.class);

    /**
     * DAO injected by Spring that manages Nivel4Clientesmq entities
     *
     */
    @Autowired
    private INivel4ClientesmqDAO nivel4ClientesmqDAO;

    /**
    * Logic injected by Spring that manages Nivel2Clientesmq entities
    *
    */
    @Autowired
    INivel2ClientesmqLogic logicNivel2Clientesmq1;

    @Transactional(readOnly = true)
    public List<Nivel4Clientesmq> getNivel4Clientesmq()
        throws Exception {
        log.debug("finding all Nivel4Clientesmq instances");

        List<Nivel4Clientesmq> list = new ArrayList<Nivel4Clientesmq>();

        try {
            list = nivel4ClientesmqDAO.findAll();
        } catch (Exception e) {
            log.error("finding all Nivel4Clientesmq failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "Nivel4Clientesmq");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveNivel4Clientesmq(Nivel4Clientesmq entity)
        throws Exception {
        log.debug("saving Nivel4Clientesmq instance");

        try {
            if (entity.getNivel2Clientesmq() == null) {
                throw new ZMessManager().new ForeignException(
                    "nivel2Clientesmq");
            }

            if ((entity.getAreaNeta() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getAreaNeta(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException("areaNeta");
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

            if ((entity.getNombre() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getNombre(),
                        60) == false)) {
                throw new ZMessManager().new NotValidFormatException("nombre");
            }

            if ((entity.getNumeroPlantas() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getNumeroPlantas(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "numeroPlantas");
            }

            if (entity.getNivel2Clientesmq().getNivel2ClientesmqId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "nivel2ClientesmqId_Nivel2Clientesmq");
            }


            nivel4ClientesmqDAO.save(entity);

            log.debug("save Nivel4Clientesmq successful");
        } catch (Exception e) {
            log.error("save Nivel4Clientesmq failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteNivel4Clientesmq(Nivel4Clientesmq entity)
        throws Exception {
        log.debug("deleting Nivel4Clientesmq instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Nivel4Clientesmq");
        }

        if (entity.getNivel4ClientesmqId() == null) {
            throw new ZMessManager().new EmptyFieldException(
                "nivel4ClientesmqId");
        }

        try {
            nivel4ClientesmqDAO.delete(entity);

            log.debug("delete Nivel4Clientesmq successful");
        } catch (Exception e) {
            log.error("delete Nivel4Clientesmq failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateNivel4Clientesmq(Nivel4Clientesmq entity)
        throws Exception {
        log.debug("updating Nivel4Clientesmq instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "Nivel4Clientesmq");
            }

            if (entity.getNivel2Clientesmq() == null) {
                throw new ZMessManager().new ForeignException(
                    "nivel2Clientesmq");
            }

            if ((entity.getAreaNeta() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getAreaNeta(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException("areaNeta");
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

            if ((entity.getNombre() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getNombre(),
                        60) == false)) {
                throw new ZMessManager().new NotValidFormatException("nombre");
            }

            if ((entity.getNumeroPlantas() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getNumeroPlantas(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "numeroPlantas");
            }

            if (entity.getNivel2Clientesmq().getNivel2ClientesmqId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "nivel2ClientesmqId_Nivel2Clientesmq");
            }

            nivel4ClientesmqDAO.update(entity);

            log.debug("update Nivel4Clientesmq successful");
        } catch (Exception e) {
            log.error("update Nivel4Clientesmq failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<Nivel4ClientesmqDTO> getDataNivel4Clientesmq()
        throws Exception {
        try {
            List<Nivel4Clientesmq> nivel4Clientesmq = nivel4ClientesmqDAO.findAll();

            List<Nivel4ClientesmqDTO> nivel4ClientesmqDTO = new ArrayList<Nivel4ClientesmqDTO>();

            for (Nivel4Clientesmq nivel4ClientesmqTmp : nivel4Clientesmq) {
                Nivel4ClientesmqDTO nivel4ClientesmqDTO2 = new Nivel4ClientesmqDTO();

                nivel4ClientesmqDTO2.setNivel4ClientesmqId(nivel4ClientesmqTmp.getNivel4ClientesmqId());
                nivel4ClientesmqDTO2.setAreaNeta((nivel4ClientesmqTmp.getAreaNeta() != null)
                    ? nivel4ClientesmqTmp.getAreaNeta() : null);
                nivel4ClientesmqDTO2.setCodigo((nivel4ClientesmqTmp.getCodigo() != null)
                    ? nivel4ClientesmqTmp.getCodigo() : null);
                nivel4ClientesmqDTO2.setCodigoAlternativo((nivel4ClientesmqTmp.getCodigoAlternativo() != null)
                    ? nivel4ClientesmqTmp.getCodigoAlternativo() : null);
                nivel4ClientesmqDTO2.setCompania((nivel4ClientesmqTmp.getCompania() != null)
                    ? nivel4ClientesmqTmp.getCompania() : null);
                nivel4ClientesmqDTO2.setEstado((nivel4ClientesmqTmp.getEstado() != null)
                    ? nivel4ClientesmqTmp.getEstado() : null);
                nivel4ClientesmqDTO2.setFechaCreacion(nivel4ClientesmqTmp.getFechaCreacion());
                nivel4ClientesmqDTO2.setFechaModificacion(nivel4ClientesmqTmp.getFechaModificacion());
                nivel4ClientesmqDTO2.setInfoAdicional((nivel4ClientesmqTmp.getInfoAdicional() != null)
                    ? nivel4ClientesmqTmp.getInfoAdicional() : null);
                nivel4ClientesmqDTO2.setInfoAdicional2((nivel4ClientesmqTmp.getInfoAdicional2() != null)
                    ? nivel4ClientesmqTmp.getInfoAdicional2() : null);
                nivel4ClientesmqDTO2.setNombre((nivel4ClientesmqTmp.getNombre() != null)
                    ? nivel4ClientesmqTmp.getNombre() : null);
                nivel4ClientesmqDTO2.setNumeroPlantas((nivel4ClientesmqTmp.getNumeroPlantas() != null)
                    ? nivel4ClientesmqTmp.getNumeroPlantas() : null);
                nivel4ClientesmqDTO2.setNivel2ClientesmqId_Nivel2Clientesmq((nivel4ClientesmqTmp.getNivel2Clientesmq()
                                                                                                .getNivel2ClientesmqId() != null)
                    ? nivel4ClientesmqTmp.getNivel2Clientesmq()
                                         .getNivel2ClientesmqId() : null);
                
                if (nivel4ClientesmqTmp.getNivel2Clientesmq() != null) {
                    nivel4ClientesmqDTO2.setNombreHacienda(nivel4ClientesmqTmp.getNivel2Clientesmq()
                                                                               .getNombre());
                } else {
                    nivel4ClientesmqDTO2.setNombreHacienda(null);
                }
      
                
                nivel4ClientesmqDTO.add(nivel4ClientesmqDTO2);
            }

            return nivel4ClientesmqDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Nivel4Clientesmq getNivel4Clientesmq(Long nivel4ClientesmqId)
        throws Exception {
        log.debug("getting Nivel4Clientesmq instance");

        Nivel4Clientesmq entity = null;

        try {
            entity = nivel4ClientesmqDAO.findById(nivel4ClientesmqId);
        } catch (Exception e) {
            log.error("get Nivel4Clientesmq failed", e);
            throw new ZMessManager().new FindingException("Nivel4Clientesmq");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<Nivel4Clientesmq> findPageNivel4Clientesmq(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        List<Nivel4Clientesmq> entity = null;

        try {
            entity = nivel4ClientesmqDAO.findPage(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "Nivel4Clientesmq Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberNivel4Clientesmq() throws Exception {
        Long entity = null;

        try {
            entity = nivel4ClientesmqDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "Nivel4Clientesmq Count");
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
    public List<Nivel4Clientesmq> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<Nivel4Clientesmq> list = new ArrayList<Nivel4Clientesmq>();
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
            list = nivel4ClientesmqDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
    
    
    @Override
	@Transactional(readOnly = true)
	public Long findTotalNumberNivel4Clientesmq(Map<String, Object> filters) throws Exception {
		Long entity = null;

		try {
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
			entity = nivel4ClientesmqDAO.countByCriteria(whereCondition);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Nivel4 Count");
		} finally {
		}
		return entity;
	}

    @Transactional(readOnly = true)
    public List<Nivel4ClientesmqDTO> findByCriteriaPageNivel4Clientesmq(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) throws Exception {
		try {

			List<Nivel4Clientesmq> entity = null;

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

			entity = nivel4ClientesmqDAO.findByCriteriaPage(whereCondition, sortField, sortOrder, startRow, pageSize);


            List<Nivel4ClientesmqDTO> nivel4ClientesmqDTO = new ArrayList<Nivel4ClientesmqDTO>();

            for (Nivel4Clientesmq nivel4ClientesmqTmp : entity) {
                Nivel4ClientesmqDTO nivel4ClientesmqDTO2 = new Nivel4ClientesmqDTO();

                nivel4ClientesmqDTO2.setNivel4ClientesmqId(nivel4ClientesmqTmp.getNivel4ClientesmqId());
                nivel4ClientesmqDTO2.setAreaNeta((nivel4ClientesmqTmp.getAreaNeta() != null)
                    ? nivel4ClientesmqTmp.getAreaNeta() : null);
                nivel4ClientesmqDTO2.setCodigo((nivel4ClientesmqTmp.getCodigo() != null)
                    ? nivel4ClientesmqTmp.getCodigo() : null);
                nivel4ClientesmqDTO2.setCodigoAlternativo((nivel4ClientesmqTmp.getCodigoAlternativo() != null)
                    ? nivel4ClientesmqTmp.getCodigoAlternativo() : null);
                nivel4ClientesmqDTO2.setCompania((nivel4ClientesmqTmp.getCompania() != null)
                    ? nivel4ClientesmqTmp.getCompania() : null);
                nivel4ClientesmqDTO2.setEstado((nivel4ClientesmqTmp.getEstado() != null)
                    ? nivel4ClientesmqTmp.getEstado() : null);
                nivel4ClientesmqDTO2.setFechaCreacion(nivel4ClientesmqTmp.getFechaCreacion());
                nivel4ClientesmqDTO2.setFechaModificacion(nivel4ClientesmqTmp.getFechaModificacion());
                nivel4ClientesmqDTO2.setInfoAdicional((nivel4ClientesmqTmp.getInfoAdicional() != null)
                    ? nivel4ClientesmqTmp.getInfoAdicional() : null);
                nivel4ClientesmqDTO2.setInfoAdicional2((nivel4ClientesmqTmp.getInfoAdicional2() != null)
                    ? nivel4ClientesmqTmp.getInfoAdicional2() : null);
                nivel4ClientesmqDTO2.setNombre((nivel4ClientesmqTmp.getNombre() != null)
                    ? nivel4ClientesmqTmp.getNombre() : null);
                nivel4ClientesmqDTO2.setNumeroPlantas((nivel4ClientesmqTmp.getNumeroPlantas() != null)
                    ? nivel4ClientesmqTmp.getNumeroPlantas() : null);
                nivel4ClientesmqDTO2.setNivel2ClientesmqId_Nivel2Clientesmq((nivel4ClientesmqTmp.getNivel2Clientesmq()
                                                                                                .getNivel2ClientesmqId() != null)
                    ? nivel4ClientesmqTmp.getNivel2Clientesmq()
                                         .getNivel2ClientesmqId() : null);
                
                if (nivel4ClientesmqTmp.getNivel2Clientesmq() != null) {
                    nivel4ClientesmqDTO2.setNombreHacienda(nivel4ClientesmqTmp.getNivel2Clientesmq()
                                                                               .getNombre());
                } else {
                    nivel4ClientesmqDTO2.setNombreHacienda(null);
                }
      
                
                nivel4ClientesmqDTO.add(nivel4ClientesmqDTO2);
            }

            return nivel4ClientesmqDTO;
        } catch (Exception e) {
            throw e;
        }
    }
}
