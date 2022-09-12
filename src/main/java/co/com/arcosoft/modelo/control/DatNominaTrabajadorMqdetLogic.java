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

import co.com.arcosoft.dataaccess.dao.IDatNominaTrabajadorMqdetDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatNominaTrabajadorMqdet;
import co.com.arcosoft.modelo.dto.DatNominaTrabajadorMqdetDTO;
import co.com.arcosoft.utilities.Utilities;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("DatNominaTrabajadorMqdetLogic")
public class DatNominaTrabajadorMqdetLogic
    implements IDatNominaTrabajadorMqdetLogic {
    private static final Logger log = LoggerFactory.getLogger(DatNominaTrabajadorMqdetLogic.class);

    /**
     * DAO injected by Spring that manages DatNominaTrabajadorMqdet entities
     *
     */
    @Autowired
    private IDatNominaTrabajadorMqdetDAO datNominaTrabajadorMqdetDAO;

    /**
    * Logic injected by Spring that manages DatNominaTrabajadorMq entities
    *
    */
    @Autowired
    IDatNominaTrabajadorMqLogic logicDatNominaTrabajadorMq1;

    /**
    * Logic injected by Spring that manages Trabajador entities
    *
    */
    @Autowired
    ITrabajadorLogic logicTrabajador2;

    @Autowired
    IEquipoLogic logicEquipo;

    
    @Transactional(readOnly = true)
    public List<DatNominaTrabajadorMqdet> getDatNominaTrabajadorMqdet()
        throws Exception {
        log.debug("finding all DatNominaTrabajadorMqdet instances");

        List<DatNominaTrabajadorMqdet> list = new ArrayList<DatNominaTrabajadorMqdet>();

        try {
            list = datNominaTrabajadorMqdetDAO.findAll();
        } catch (Exception e) {
            log.error("finding all DatNominaTrabajadorMqdet failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "DatNominaTrabajadorMqdet");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveDatNominaTrabajadorMqdet(DatNominaTrabajadorMqdet entity)
        throws Exception {
        log.debug("saving DatNominaTrabajadorMqdet instance");

        try {
            if (entity.getDatNominaTrabajadorMq() == null) {
                throw new ZMessManager().new ForeignException(
                    "datNominaTrabajadorMq");
            }

            if (entity.getTrabajador() == null) {
                throw new ZMessManager().new ForeignException("trabajador");
            }

            if ((entity.getCantidad() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getCantidad(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException("cantidad");
            }

            if ((entity.getValorTotal() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorTotal(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorTotal");
            }

            if (entity.getDatNominaTrabajadorMq().getDatNominaTrabajadorMqId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "datNominaTrabajadorMqId_DatNominaTrabajadorMq");
            }

            if (entity.getTrabajador().getTrabId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "trabId_Trabajador");
            }

            if (getDatNominaTrabajadorMqdet(
                        entity.getDatNominaTrabajadorMqdetId()) != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            datNominaTrabajadorMqdetDAO.save(entity);

            log.debug("save DatNominaTrabajadorMqdet successful");
        } catch (Exception e) {
            log.error("save DatNominaTrabajadorMqdet failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteDatNominaTrabajadorMqdet(DatNominaTrabajadorMqdet entity)
        throws Exception {
        log.debug("deleting DatNominaTrabajadorMqdet instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion(
                "DatNominaTrabajadorMqdet");
        }

        if (entity.getDatNominaTrabajadorMqdetId() == null) {
            throw new ZMessManager().new EmptyFieldException(
                "datNominaTrabajadorMqdetId");
        }

        try {
            datNominaTrabajadorMqdetDAO.delete(entity);

            log.debug("delete DatNominaTrabajadorMqdet successful");
        } catch (Exception e) {
            log.error("delete DatNominaTrabajadorMqdet failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateDatNominaTrabajadorMqdet(DatNominaTrabajadorMqdet entity)
        throws Exception {
        log.debug("updating DatNominaTrabajadorMqdet instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "DatNominaTrabajadorMqdet");
            }

            if (entity.getDatNominaTrabajadorMq() == null) {
                throw new ZMessManager().new ForeignException(
                    "datNominaTrabajadorMq");
            }

            if (entity.getTrabajador() == null) {
                throw new ZMessManager().new ForeignException("trabajador");
            }

            if ((entity.getCantidad() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getCantidad(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException("cantidad");
            }

            if ((entity.getValorTotal() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorTotal(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorTotal");
            }

            if (entity.getDatNominaTrabajadorMq().getDatNominaTrabajadorMqId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "datNominaTrabajadorMqId_DatNominaTrabajadorMq");
            }

            if (entity.getTrabajador().getTrabId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "trabId_Trabajador");
            }

            datNominaTrabajadorMqdetDAO.update(entity);

            log.debug("update DatNominaTrabajadorMqdet successful");
        } catch (Exception e) {
            log.error("update DatNominaTrabajadorMqdet failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<DatNominaTrabajadorMqdetDTO> getDataDatNominaTrabajadorMqdet()
        throws Exception {
        try {
            List<DatNominaTrabajadorMqdet> datNominaTrabajadorMqdet = datNominaTrabajadorMqdetDAO.findAll();

            List<DatNominaTrabajadorMqdetDTO> datNominaTrabajadorMqdetDTO = new ArrayList<DatNominaTrabajadorMqdetDTO>();

            for (DatNominaTrabajadorMqdet datNominaTrabajadorMqdetTmp : datNominaTrabajadorMqdet) {
                DatNominaTrabajadorMqdetDTO datNominaTrabajadorMqdetDTO2 = new DatNominaTrabajadorMqdetDTO();

                datNominaTrabajadorMqdetDTO2.setDatNominaTrabajadorMqdetId(datNominaTrabajadorMqdetTmp.getDatNominaTrabajadorMqdetId());
                datNominaTrabajadorMqdetDTO2.setCantidad((datNominaTrabajadorMqdetTmp.getCantidad() != null)
                    ? datNominaTrabajadorMqdetTmp.getCantidad() : null);
                datNominaTrabajadorMqdetDTO2.setCeptoNominaId((datNominaTrabajadorMqdetTmp.getCeptoNominaId() != null)
                    ? datNominaTrabajadorMqdetTmp.getCeptoNominaId() : null);
                datNominaTrabajadorMqdetDTO2.setUdadMedId((datNominaTrabajadorMqdetTmp.getUdadMedId() != null)
                    ? datNominaTrabajadorMqdetTmp.getUdadMedId() : null);
                datNominaTrabajadorMqdetDTO2.setValorTotal((datNominaTrabajadorMqdetTmp.getValorTotal() != null)
                    ? datNominaTrabajadorMqdetTmp.getValorTotal() : null);
                datNominaTrabajadorMqdetDTO2.setDatNominaTrabajadorMqId_DatNominaTrabajadorMq((datNominaTrabajadorMqdetTmp.getDatNominaTrabajadorMq()
                                                                                                                          .getDatNominaTrabajadorMqId() != null)
                    ? datNominaTrabajadorMqdetTmp.getDatNominaTrabajadorMq()
                                                 .getDatNominaTrabajadorMqId()
                    : null);

                if (datNominaTrabajadorMqdetTmp.getTrabajador() != null) {
                    datNominaTrabajadorMqdetDTO2.setTrabId_Trabajador(datNominaTrabajadorMqdetTmp.getTrabajador()
                                                                                                 );
                } else {
                    datNominaTrabajadorMqdetDTO2.setTrabId_Trabajador(null);
                }
                
                if (datNominaTrabajadorMqdetTmp.getFechaInicialVac() != null) {
					datNominaTrabajadorMqdetDTO2.setFechaInicialVac(datNominaTrabajadorMqdetTmp.getFechaInicialVac());
				} else {
					datNominaTrabajadorMqdetDTO2.setFechaInicialVac(null);
				}
				if (datNominaTrabajadorMqdetTmp.getFechaFinalVac() != null) {
					datNominaTrabajadorMqdetDTO2.setFechaFinalVac(datNominaTrabajadorMqdetTmp.getFechaFinalVac());
				} else {
					datNominaTrabajadorMqdetDTO2.setFechaFinalVac(null);
				}

				if (datNominaTrabajadorMqdetTmp.getTrabajador() != null) {
					datNominaTrabajadorMqdetDTO2.setTrabId_Trabajador(datNominaTrabajadorMqdetTmp.getTrabajador());
				} else {
					datNominaTrabajadorMqdetDTO2.setTrabId_Trabajador(null);
				}

				if (datNominaTrabajadorMqdetTmp.getTrabajador() != null) {
					datNominaTrabajadorMqdetDTO2
							.setNombreTrabajador(datNominaTrabajadorMqdetTmp.getTrabajador().getNombre());
				} else {
					datNominaTrabajadorMqdetDTO2.setNombreTrabajador(null);
				}
				
				if (datNominaTrabajadorMqdetTmp.getUdadMedId() != null) {
					datNominaTrabajadorMqdetDTO2
							.setNombreUdadMed(datNominaTrabajadorMqdetTmp.getUdadMedId().getNombre());
				} else {
					datNominaTrabajadorMqdetDTO2.setNombreUdadMed(null);
				}
				
				if (datNominaTrabajadorMqdetTmp.getUdadMedId() != null) {
					datNominaTrabajadorMqdetDTO2
							.setUdadMedId(datNominaTrabajadorMqdetTmp.getUdadMedId());
				} else {
					datNominaTrabajadorMqdetDTO2.setUdadMedId(null);
				}

				if (datNominaTrabajadorMqdetTmp.getCantidad() != null) {
					datNominaTrabajadorMqdetDTO2
							.setCantidad(datNominaTrabajadorMqdetTmp.getCantidad());
				} else {
					datNominaTrabajadorMqdetDTO2.setCantidad(null);
				}
				
				
				if (datNominaTrabajadorMqdetTmp.getValorDeduccion() != null) {
					datNominaTrabajadorMqdetDTO2
							.setValorDeduccion(datNominaTrabajadorMqdetTmp.getValorDeduccion());
				} else {
					datNominaTrabajadorMqdetDTO2.setValorDeduccion(null);
				}
				
				
				if (datNominaTrabajadorMqdetTmp.getTipoMovimiento() != null) {
					datNominaTrabajadorMqdetDTO2
							.setTipoMovimiento(datNominaTrabajadorMqdetTmp.getTipoMovimiento());
				} else {
					datNominaTrabajadorMqdetDTO2.setTipoMovimiento(null);
				}
				
				
				if (datNominaTrabajadorMqdetTmp.getEquipoId() != null) {
					datNominaTrabajadorMqdetDTO2
							.setEquipoId(datNominaTrabajadorMqdetTmp.getEquipoId().getEquipoId());
				} else {
					datNominaTrabajadorMqdetDTO2.setEquipoId(null);
				}
				
				if (datNominaTrabajadorMqdetTmp.getEquipoId() != null) {
					datNominaTrabajadorMqdetDTO2
							.setCodEquipo(datNominaTrabajadorMqdetTmp.getEquipoId().getCodigo());
				} else {
					datNominaTrabajadorMqdetDTO2.setCodEquipo(null);
				}
				

				if (datNominaTrabajadorMqdetTmp.getDetalleNota() != null) {
					datNominaTrabajadorMqdetDTO2
							.setDetalleNota(datNominaTrabajadorMqdetTmp.getDetalleNota());
				} else {
					datNominaTrabajadorMqdetDTO2.setDetalleNota(null);
				}

                datNominaTrabajadorMqdetDTO.add(datNominaTrabajadorMqdetDTO2);
            }

            return datNominaTrabajadorMqdetDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public DatNominaTrabajadorMqdet getDatNominaTrabajadorMqdet(
        Long datNominaTrabajadorMqdetId) throws Exception {
        log.debug("getting DatNominaTrabajadorMqdet instance");

        DatNominaTrabajadorMqdet entity = null;

        try {
            entity = datNominaTrabajadorMqdetDAO.findById(datNominaTrabajadorMqdetId);
        } catch (Exception e) {
            log.error("get DatNominaTrabajadorMqdet failed", e);
            throw new ZMessManager().new FindingException(
                "DatNominaTrabajadorMqdet");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<DatNominaTrabajadorMqdet> findPageDatNominaTrabajadorMqdet(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        List<DatNominaTrabajadorMqdet> entity = null;

        try {
            entity = datNominaTrabajadorMqdetDAO.findPage(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatNominaTrabajadorMqdet Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberDatNominaTrabajadorMqdet()
        throws Exception {
        Long entity = null;

        try {
            entity = datNominaTrabajadorMqdetDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatNominaTrabajadorMqdet Count");
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
    public List<DatNominaTrabajadorMqdet> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<DatNominaTrabajadorMqdet> list = new ArrayList<DatNominaTrabajadorMqdet>();
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
            list = datNominaTrabajadorMqdetDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
    
	
    @Override
	@Transactional(readOnly = true)
	public List<DatNominaTrabajadorMqdetDTO> getDataDatNominaTrabajadorMqdetByNomina(Long idNomina) throws Exception {
		try {
			List<DatNominaTrabajadorMqdet> datNominaTrabajadorMqdet = datNominaTrabajadorMqdetDAO
					.findByCriteria("datNominaTrabajadorMq.datNominaTrabajadorMqId= " + idNomina);
			List<DatNominaTrabajadorMqdetDTO> datNominaTrabajadorMqdetDTO = new ArrayList<DatNominaTrabajadorMqdetDTO>();

			for (DatNominaTrabajadorMqdet datNominaTrabajadorMqdetTmp : datNominaTrabajadorMqdet) {
				DatNominaTrabajadorMqdetDTO datNominaTrabajadorMqdetDTO2 = new DatNominaTrabajadorMqdetDTO();

				datNominaTrabajadorMqdetDTO2
						.setDatNominaTrabajadorMqdetId(datNominaTrabajadorMqdetTmp.getDatNominaTrabajadorMqdetId());
				datNominaTrabajadorMqdetDTO2.setValorTotal((datNominaTrabajadorMqdetTmp.getValorTotal() != null)
						? datNominaTrabajadorMqdetTmp.getValorTotal() : null);
				

				datNominaTrabajadorMqdetDTO2.setDatNominaTrabajadorMqId_DatNominaTrabajadorMq(
						(datNominaTrabajadorMqdetTmp.getDatNominaTrabajadorMq().getDatNominaTrabajadorMqId() != null)
								? datNominaTrabajadorMqdetTmp.getDatNominaTrabajadorMq().getDatNominaTrabajadorMqId() : null);


				if (datNominaTrabajadorMqdetTmp.getCeptoNominaId() != null) {
					datNominaTrabajadorMqdetDTO2.setCeptoNominaId(datNominaTrabajadorMqdetTmp.getCeptoNominaId());
				} else {
					datNominaTrabajadorMqdetDTO2.setCeptoNominaId(null);
				}
				
				if (datNominaTrabajadorMqdetTmp.getCeptoNominaId() != null) {
					datNominaTrabajadorMqdetDTO2.setNombreConceptoNomina(datNominaTrabajadorMqdetTmp.getCeptoNominaId().getNombre());
				} else {
					datNominaTrabajadorMqdetDTO2.setNombreConceptoNomina(null);
				}


				
				if (datNominaTrabajadorMqdetTmp.getTrabajador() != null) {
					datNominaTrabajadorMqdetDTO2.setTrabId_Trabajador(datNominaTrabajadorMqdetTmp.getTrabajador());
				} else {
					datNominaTrabajadorMqdetDTO2.setTrabId_Trabajador(null);
				}

				if (datNominaTrabajadorMqdetTmp.getTrabajador() != null) {
					datNominaTrabajadorMqdetDTO2
							.setNombreTrabajador(datNominaTrabajadorMqdetTmp.getTrabajador().getNombre());
				} else {
					datNominaTrabajadorMqdetDTO2.setNombreTrabajador(null);
				}
				
				if (datNominaTrabajadorMqdetTmp.getUdadMedId() != null) {
					datNominaTrabajadorMqdetDTO2
							.setNombreUdadMed(datNominaTrabajadorMqdetTmp.getUdadMedId().getNombre());
				} else {
					datNominaTrabajadorMqdetDTO2.setNombreUdadMed(null);
				}
				
				if (datNominaTrabajadorMqdetTmp.getUdadMedId() != null) {
					datNominaTrabajadorMqdetDTO2
							.setUdadMedId(datNominaTrabajadorMqdetTmp.getUdadMedId());
				} else {
					datNominaTrabajadorMqdetDTO2.setUdadMedId(null);
				}

				if (datNominaTrabajadorMqdetTmp.getCantidad() != null) {
					datNominaTrabajadorMqdetDTO2
							.setCantidad(datNominaTrabajadorMqdetTmp.getCantidad());
				} else {
					datNominaTrabajadorMqdetDTO2.setCantidad(null);
				}
				
				
				if (datNominaTrabajadorMqdetTmp.getValorDeduccion() != null) {
					datNominaTrabajadorMqdetDTO2
							.setValorDeduccion(datNominaTrabajadorMqdetTmp.getValorDeduccion());
				} else {
					datNominaTrabajadorMqdetDTO2.setValorDeduccion(null);
				}
				
				
				if (datNominaTrabajadorMqdetTmp.getTipoMovimiento() != null) {
					datNominaTrabajadorMqdetDTO2
							.setTipoMovimiento(datNominaTrabajadorMqdetTmp.getTipoMovimiento());
				} else {
					datNominaTrabajadorMqdetDTO2.setTipoMovimiento(null);
				}
				
				
				if (datNominaTrabajadorMqdetTmp.getEquipoId() != null) {
					datNominaTrabajadorMqdetDTO2
							.setEquipoId(datNominaTrabajadorMqdetTmp.getEquipoId().getEquipoId());
				} else {
					datNominaTrabajadorMqdetDTO2.setEquipoId(null);
				}
				
				if (datNominaTrabajadorMqdetTmp.getEquipoId() != null) {
					datNominaTrabajadorMqdetDTO2
							.setCodEquipo(datNominaTrabajadorMqdetTmp.getEquipoId().getCodigo());
				} else {
					datNominaTrabajadorMqdetDTO2.setCodEquipo(null);
				}
				

				if (datNominaTrabajadorMqdetTmp.getDetalleNota() != null) {
					datNominaTrabajadorMqdetDTO2
							.setDetalleNota(datNominaTrabajadorMqdetTmp.getDetalleNota());
				} else {
					datNominaTrabajadorMqdetDTO2.setDetalleNota(null);
				}
				
				if (datNominaTrabajadorMqdetTmp.getFechaInicialVac() != null) {
					datNominaTrabajadorMqdetDTO2.setFechaInicialVac(datNominaTrabajadorMqdetTmp.getFechaInicialVac());
				} else {
					datNominaTrabajadorMqdetDTO2.setFechaInicialVac(null);
				}
				if (datNominaTrabajadorMqdetTmp.getFechaFinalVac() != null) {
					datNominaTrabajadorMqdetDTO2.setFechaFinalVac(datNominaTrabajadorMqdetTmp.getFechaFinalVac());
				} else {
					datNominaTrabajadorMqdetDTO2.setFechaFinalVac(null);
				}
				
				 
				 
				if (datNominaTrabajadorMqdetTmp.getCentCost() != null) {
					datNominaTrabajadorMqdetDTO2.setCentCostId_CentCost(datNominaTrabajadorMqdetTmp.getCentCost().getCentCostId());
					datNominaTrabajadorMqdetDTO2.setNombreCentroCosto(datNominaTrabajadorMqdetTmp.getCentCost().getNombre());
				} else {
					datNominaTrabajadorMqdetDTO2.setCentCostId_CentCost(null);
					datNominaTrabajadorMqdetDTO2.setNombreCentroCosto(null);
				}
				
				datNominaTrabajadorMqdetDTO.add(datNominaTrabajadorMqdetDTO2);
			}

			return datNominaTrabajadorMqdetDTO;
		} catch (Exception e) {
			throw e;
		}
	}

}
