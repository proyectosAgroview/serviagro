package co.com.arcosoft.modelo.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.com.arcosoft.dataaccess.dao.IDatDiferidosCuotasDAO;
import co.com.arcosoft.dataaccess.dao.IDatDiferidosDAO;
import co.com.arcosoft.dataaccess.dao.IDatDiferidosDetDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatDiferidos;
import co.com.arcosoft.modelo.DatDiferidosCuotas;
import co.com.arcosoft.modelo.DatDiferidosDet;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.dto.DatDiferidosCuotasDTO;
import co.com.arcosoft.modelo.dto.DatDiferidosDTO;
import co.com.arcosoft.modelo.dto.DatDiferidosDetDTO;
import co.com.arcosoft.modelo.informes.dto.ListaEquiposCategoriaDTO;
import co.com.arcosoft.utilities.Utilities;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("DatDiferidosLogic")
public class DatDiferidosLogic implements IDatDiferidosLogic {
    private static final Logger log = LoggerFactory.getLogger(DatDiferidosLogic.class);

    /**
     * DAO injected by Spring that manages DatDiferidos entities
     *
     */
    @Autowired
    private IDatDiferidosDAO datDiferidosDAO;

    /**
    * DAO injected by Spring that manages DatDiferidosDet entities
    *
    */
    @Autowired
    private IDatDiferidosDetDAO datDiferidosDetDAO;

    @Autowired
    private IDatDiferidosCuotasDAO datDiferidosCuotasDAO;
    
    @Autowired
    IEquipoLogic logicEquipo;
    
    @Autowired
    IEquipoLogic logicImplemento;

    
    
    @Transactional(readOnly = true)
    public List<DatDiferidos> getDatDiferidos() throws Exception {
        log.debug("finding all DatDiferidos instances");

        List<DatDiferidos> list = new ArrayList<DatDiferidos>();

        try {
            list = datDiferidosDAO.findAll();
        } catch (Exception e) {
            log.error("finding all DatDiferidos failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "DatDiferidos");
        } finally {
        }

        return list;
    }

    @SuppressWarnings("null")
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveDatDiferidos(DatDiferidos entity,  List<DatDiferidosDetDTO> dataDet,
    		List<DatDiferidosCuotasDTO> dataCuotas
    		
    		) throws Exception {
        log.debug("saving DatDiferidos instance");

        try {
            if ((entity.getDetalleAplicacion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDetalleAplicacion(), 3900) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "detalleAplicacion");
            }

            if ((entity.getDetalleNota() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDetalleNota(), 3900) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "detalleNota");
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

     
            datDiferidosDAO.save(entity);

			if (dataDet != null) {

				for (DatDiferidosDetDTO valorDto : dataDet) {

					if (valorDto.getDatDiferidosDetId() == null) {

						DatDiferidosDet valor = new DatDiferidosDet();						
					
						valor.setEquipoId(valorDto.getEquipoId());						
						valor.setDatDiferidos(entity);
						if(valorDto.getImplementoId()!=null) {
							Equipo implemento = logicImplemento.getEquipo(valorDto.getImplementoId());
							valor.setImplementoId(implemento);
							
							
							}
						datDiferidosDetDAO.save(valor);
					}

				}
			}
			
			if (dataCuotas == null) {

				int numCuotas = entity.getPeriodos().intValue();

				for (int i = 0; i < numCuotas; i++) {

					DatDiferidosCuotas valor = new DatDiferidosCuotas();

					GregorianCalendar fechaInicial = new GregorianCalendar();
					fechaInicial.setTime(entity.getFechaRegistro());
					fechaInicial.add(GregorianCalendar.MONTH, i);

					Long anioRegistro = (long) fechaInicial.get(java.util.Calendar.YEAR);
					Long mesRegistro = (long) fechaInicial.get(java.util.Calendar.MONTH) + 1;

					valor.setFecha(fechaInicial.getTime());
					valor.setAnio(anioRegistro);
					valor.setMes(mesRegistro);
					valor.setValorCuota(entity.getValorInicial() / entity.getPeriodos());

					valor.setDatDiferidos(entity);

					datDiferidosCuotasDAO.save(valor);
				}

			}
        
				
			
            log.debug("save DatDiferidos successful");
        } catch (Exception e) {
            log.error("save DatDiferidos failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteDatDiferidos(DatDiferidos entity)
        throws Exception {
        log.debug("deleting DatDiferidos instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("DatDiferidos");
        }

        if (entity.getDatDiferidosId() == null) {
            throw new ZMessManager().new EmptyFieldException("datDiferidosId");
        }

        List<DatDiferidosDet> datDiferidosDets = null;
        List<DatDiferidosCuotas> datDiferidosCuotass = null;

        try {
            datDiferidosDets = datDiferidosDetDAO.findByProperty("datDiferidos.datDiferidosId",
                    entity.getDatDiferidosId());
            
            datDiferidosCuotass = datDiferidosCuotasDAO.findByProperty("datDiferidos.datDiferidosId",
                    entity.getDatDiferidosId());

            if (Utilities.validationsList(datDiferidosDets) == true) {
                throw new ZMessManager().new DeletingException(
                    "datDiferidosDets");
            }
            
            if (Utilities.validationsList(datDiferidosCuotass) == true) {
                throw new ZMessManager().new DeletingException(
                    "datDiferidosCuotass");
            }

            datDiferidosDAO.delete(entity);

            log.debug("delete DatDiferidos successful");
        } catch (Exception e) {
            log.error("delete DatDiferidos failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateDatDiferidos(DatDiferidos entity,   List<DatDiferidosDetDTO> dataDet, List<DatDiferidosCuotasDTO> dataCuotas)
        throws Exception {
        log.debug("updating DatDiferidos instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("DatDiferidos");
            }

            if ((entity.getDetalleAplicacion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDetalleAplicacion(), 3900) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "detalleAplicacion");
            }

            if ((entity.getDetalleNota() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDetalleNota(), 3900) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "detalleNota");
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

           

            datDiferidosDAO.update(entity);
            if (dataDet != null) {

				for (DatDiferidosDetDTO valorDto : dataDet) {

					if (valorDto.getDatDiferidosDetId() == null) { // crear el
																	// valor
																	// nuevo
						DatDiferidosDet valor = new DatDiferidosDet();
						valor.setEquipoId(valorDto.getEquipoId());
						valor.setDatDiferidos(entity);
						if(valorDto.getImplementoId()!=null) {
							Equipo implemento = logicImplemento.getEquipo(valorDto.getImplementoId());
							valor.setImplementoId(implemento);
							
							
							}
						datDiferidosDetDAO.save(valor);

					} else {
						DatDiferidosDet valor = datDiferidosDetDAO.findById(valorDto.getDatDiferidosDetId());
						
						valor.setEquipoId(valorDto.getEquipoId());
						valor.setDatDiferidos(entity);
						if(valorDto.getImplementoId()!=null) {
							Equipo implemento = logicImplemento.getEquipo(valorDto.getImplementoId());
							valor.setImplementoId(implemento);
							
							
							}
						datDiferidosDetDAO.update(valor);
					}

				}
			}
        	if (dataCuotas== null) {

				int numCuotas = entity.getPeriodos().intValue();

				for (int i = 0; i < numCuotas; i++) {
						
						DatDiferidosCuotas valor = new DatDiferidosCuotas();

						GregorianCalendar fechaInicial = new GregorianCalendar();
						fechaInicial.setTime(entity.getFechaRegistro()); 
						fechaInicial.add(GregorianCalendar.MONTH, i); 
						

						
						Long  anioRegistro = (long) fechaInicial.get(java.util.Calendar.YEAR);
						Long  mesRegistro = (long) fechaInicial.get(java.util.Calendar.MONTH)+1;
						
						valor.setFecha(fechaInicial.getTime());
						valor.setAnio(anioRegistro);
						valor.setMes(mesRegistro);
						valor.setValorCuota(entity.getValorInicial()/entity.getPeriodos());
						
						valor.setDatDiferidos(entity);

						datDiferidosCuotasDAO.save(valor);
					}
					
				}
            log.debug("update DatDiferidos successful");
        } catch (Exception e) {
            log.error("update DatDiferidos failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<DatDiferidosDTO> getDataDatDiferidos()
        throws Exception {
        try {
            List<DatDiferidos> datDiferidos = datDiferidosDAO.findAll();

            List<DatDiferidosDTO> datDiferidosDTO = new ArrayList<DatDiferidosDTO>();

            for (DatDiferidos datDiferidosTmp : datDiferidos) {
                DatDiferidosDTO datDiferidosDTO2 = new DatDiferidosDTO();

                datDiferidosDTO2.setDatDiferidosId(datDiferidosTmp.getDatDiferidosId());
                datDiferidosDTO2.setAnioAplicacion((datDiferidosTmp.getAnioAplicacion() != null)
                    ? datDiferidosTmp.getAnioAplicacion() : null);
                datDiferidosDTO2.setCompania((datDiferidosTmp.getCompania() != null)
                    ? datDiferidosTmp.getCompania() : null);
                datDiferidosDTO2.setConsecutivo((datDiferidosTmp.getConsecutivo() != null)
                    ? datDiferidosTmp.getConsecutivo() : null);
                datDiferidosDTO2.setDetalleAplicacion((datDiferidosTmp.getDetalleAplicacion() != null)
                    ? datDiferidosTmp.getDetalleAplicacion() : null);
                datDiferidosDTO2.setDetalleNota((datDiferidosTmp.getDetalleNota() != null)
                    ? datDiferidosTmp.getDetalleNota() : null);
                datDiferidosDTO2.setEstado((datDiferidosTmp.getEstado() != null)
                    ? datDiferidosTmp.getEstado() : null);
                datDiferidosDTO2.setFechaAnulacion(datDiferidosTmp.getFechaAnulacion());
                datDiferidosDTO2.setFechaCreacion(datDiferidosTmp.getFechaCreacion());
                datDiferidosDTO2.setFechaModificacion(datDiferidosTmp.getFechaModificacion());
                datDiferidosDTO2.setFechaRegistro(datDiferidosTmp.getFechaRegistro());
              
                if (datDiferidosTmp.getLaborId() != null) {

                	datDiferidosDTO2
							.setLaborId(datDiferidosTmp.getLaborId().getLaborId());

				} else {

					datDiferidosDTO2.setLaborId(null);

				}
                
                if (datDiferidosTmp.getLaborId() != null) {

                	datDiferidosDTO2
							.setNombreLabor(datDiferidosTmp.getLaborId().getCodigo() +" - "+datDiferidosTmp.getLaborId().getNombre());

				} else {

					datDiferidosDTO2.setNombreLabor(null);

				}
                datDiferidosDTO2.setMesAplicacion((datDiferidosTmp.getMesAplicacion() != null)
                    ? datDiferidosTmp.getMesAplicacion() : null);
                datDiferidosDTO2.setNpReset((datDiferidosTmp.getNpReset() != null)
                    ? datDiferidosTmp.getNpReset() : null);
                datDiferidosDTO2.setObservacion((datDiferidosTmp.getObservacion() != null)
                    ? datDiferidosTmp.getObservacion() : null);
                datDiferidosDTO2.setObservacionAnularReg((datDiferidosTmp.getObservacionAnularReg() != null)
                    ? datDiferidosTmp.getObservacionAnularReg() : null);
                datDiferidosDTO2.setPeriodos((datDiferidosTmp.getPeriodos() != null)
                    ? datDiferidosTmp.getPeriodos() : null);
                datDiferidosDTO2.setUsuarioDigitacion((datDiferidosTmp.getUsuarioDigitacion() != null)
                    ? datDiferidosTmp.getUsuarioDigitacion() : null);
                datDiferidosDTO2.setValorCuota((datDiferidosTmp.getValorCuota() != null)
                    ? datDiferidosTmp.getValorCuota() : null);
                datDiferidosDTO2.setValorInicial((datDiferidosTmp.getValorInicial() != null)
                    ? datDiferidosTmp.getValorInicial() : null);
                datDiferidosDTO2.setValorSaldo((datDiferidosTmp.getValorSaldo() != null)
                    ? datDiferidosTmp.getValorSaldo() : null);
                datDiferidosDTO2.setNumeroFactura((datDiferidosTmp.getNumeroFactura() != null)
                        ? datDiferidosTmp.getNumeroFactura() : null);
                
                datDiferidosDTO2.setCentCostId((datDiferidosTmp.getCentCostId() != null)
						? datDiferidosTmp.getCentCostId()
						: null);
                
                
                if (datDiferidosTmp.getPersEmpr() != null) {

                	datDiferidosDTO2
							.setPersEmpr(datDiferidosTmp.getPersEmpr().getPersEmprId());

				} else {

					datDiferidosDTO2.setPersEmpr(null);

				}
                
                datDiferidosDTO.add(datDiferidosDTO2);
            }

            return datDiferidosDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public DatDiferidos getDatDiferidos(Long datDiferidosId)
        throws Exception {
        log.debug("getting DatDiferidos instance");

        DatDiferidos entity = null;

        try {
            entity = datDiferidosDAO.findById(datDiferidosId);
        } catch (Exception e) {
            log.error("get DatDiferidos failed", e);
            throw new ZMessManager().new FindingException("DatDiferidos");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<DatDiferidos> findPageDatDiferidos(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<DatDiferidos> entity = null;

        try {
            entity = datDiferidosDAO.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("DatDiferidos Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberDatDiferidos() throws Exception {
        Long entity = null;

        try {
            entity = datDiferidosDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("DatDiferidos Count");
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
    public List<DatDiferidos> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<DatDiferidos> list = new ArrayList<DatDiferidos>();
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
            list = datDiferidosDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
    
    
    @SuppressWarnings("null")
   	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
       public void saveDatDiferidosVer2(DatDiferidos entity,   List<ListaEquiposCategoriaDTO> dataDistr,
       		List<DatDiferidosCuotasDTO> dataCuotas
       		
       		) throws Exception {
           log.debug("saving DatDiferidos instance");

           try {
               if ((entity.getDetalleAplicacion() != null) &&
                       (Utilities.checkWordAndCheckWithlength(
                           entity.getDetalleAplicacion(), 3900) == false)) {
                   throw new ZMessManager().new NotValidFormatException(
                       "detalleAplicacion");
               }

               if ((entity.getDetalleNota() != null) &&
                       (Utilities.checkWordAndCheckWithlength(
                           entity.getDetalleNota(), 3900) == false)) {
                   throw new ZMessManager().new NotValidFormatException(
                       "detalleNota");
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

               if ((entity.getValorCuota() != null) &&
                       (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                           entity.getValorCuota(), 8, 4) == false)) {
                   throw new ZMessManager().new NotValidFormatException(
                       "valorCuota");
               }

               if ((entity.getValorInicial() != null) &&
                       (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                           entity.getValorInicial(), 8, 4) == false)) {
                   throw new ZMessManager().new NotValidFormatException(
                       "valorInicial");
               }

               if ((entity.getValorSaldo() != null) &&
                       (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                           entity.getValorSaldo(), 8, 4) == false)) {
                   throw new ZMessManager().new NotValidFormatException(
                       "valorSaldo");
               }

        
               datDiferidosDAO.save(entity);

               
               if (dataDistr != null) {

     				for (ListaEquiposCategoriaDTO valorDto : dataDistr) {

     					DatDiferidosDet valor = new DatDiferidosDet();
     						
     					Equipo equipo = logicEquipo.getEquipo(valorDto.getEquipo_id().longValue());
  						valor.setEquipoId(equipo);
  					
  						valor.setDatDiferidos(entity);

  						datDiferidosDetDAO.save(valor);
     					

     				}
     			}
               
   		
   			
   			if (dataCuotas== null) {

   					int numCuotas = entity.getPeriodos().intValue();

   					for (int i = 0; i < numCuotas; i++) {
   							
   							DatDiferidosCuotas valor = new DatDiferidosCuotas();
   	
   							GregorianCalendar fechaInicial =  new GregorianCalendar();
   							fechaInicial.setTime(entity.getFechaRegistro()); 
   							fechaInicial.add(GregorianCalendar.MONTH, i); 
   							
   							
   							
   							Long  anioRegistro = (long) fechaInicial.get(java.util.Calendar.YEAR);
   							Long  mesRegistro = (long) fechaInicial.get(java.util.Calendar.MONTH)+1;
   							
   							valor.setFecha(fechaInicial.getTime());
   							valor.setAnio(anioRegistro);
   							valor.setMes(mesRegistro);
   							valor.setValorCuota(entity.getValorInicial()/entity.getPeriodos());
   							
   							valor.setDatDiferidos(entity);

   							datDiferidosCuotasDAO.save(valor);
   						}
   						
   					}
           
   				
   			
               log.debug("save DatDiferidos successful");
           } catch (Exception e) {
               log.error("save DatDiferidos failed", e);
               throw e;
           } finally {
           }
       }
    
    

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateDatDiferidosVer2(DatDiferidos entity,  List<ListaEquiposCategoriaDTO> dataDistr, List<DatDiferidosCuotasDTO> dataCuotas)
        throws Exception {
        log.debug("updating DatDiferidos instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("DatDiferidos");
            }

            if ((entity.getDetalleAplicacion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDetalleAplicacion(), 3900) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "detalleAplicacion");
            }

            if ((entity.getDetalleNota() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDetalleNota(), 3900) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "detalleNota");
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

            if ((entity.getValorCuota() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorCuota(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorCuota");
            }

            if ((entity.getValorInicial() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorInicial(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorInicial");
            }

            if ((entity.getValorSaldo() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorSaldo(), 8, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorSaldo");
            }

            datDiferidosDAO.update(entity);
            if (dataDistr != null) {

  				for (ListaEquiposCategoriaDTO valorDto : dataDistr) {

  					

  					DatDiferidosDet valor = new DatDiferidosDet();
  						
  						Equipo equipo = logicEquipo.getEquipo(valorDto.getEquipo_id().longValue());
						valor.setEquipoId(equipo);
					
						valor.setDatDiferidos(entity);

						datDiferidosDetDAO.save(valor);
  					

  				}
  			}
        	if (dataCuotas== null) {

				int numCuotas = entity.getPeriodos().intValue();

				for (int i = 0; i < numCuotas; i++) {
						
						DatDiferidosCuotas valor = new DatDiferidosCuotas();

						GregorianCalendar fechaInicial = new GregorianCalendar();
						fechaInicial.setTime(entity.getFechaRegistro()); 
						fechaInicial.add(GregorianCalendar.MONTH, i); 
						

						
						Long  anioRegistro = (long) fechaInicial.get(java.util.Calendar.YEAR);
						Long  mesRegistro = (long) fechaInicial.get(java.util.Calendar.MONTH)+1;
						
						valor.setFecha(fechaInicial.getTime());
						valor.setAnio(anioRegistro);
						valor.setMes(mesRegistro);
						valor.setValorCuota(entity.getValorInicial()/entity.getPeriodos());
						
						valor.setDatDiferidos(entity);

						datDiferidosCuotasDAO.save(valor);
					}
					
				}
            log.debug("update DatDiferidos successful");
        } catch (Exception e) {
            log.error("update DatDiferidos failed", e);
            throw e;
        } finally {
        }
    }
}
