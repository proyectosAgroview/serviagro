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

import com.ibm.icu.text.DecimalFormat;

import co.com.arcosoft.dataaccess.dao.IDatDiferidosAgricolaDAO;
import co.com.arcosoft.dataaccess.dao.IDatDiferidosAgricolaDetDAO;
import co.com.arcosoft.dataaccess.dao.IDatDiferidosCuotasAgricolasDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatDiferidosAgricola;
import co.com.arcosoft.modelo.DatDiferidosAgricolaDet;
import co.com.arcosoft.modelo.DatDiferidosCuotasAgricolas;
import co.com.arcosoft.modelo.Etapa;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.dto.DatDiferidosAgricolaDTO;
import co.com.arcosoft.modelo.dto.DatDiferidosAgricolaDetDTO;
import co.com.arcosoft.modelo.dto.DatDiferidosCuotasAgricolasDTO;
import co.com.arcosoft.modelo.informes.dto.ListaNivel4DTO;
import co.com.arcosoft.utilities.Utilities;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("DatDiferidosAgricolaLogic")
public class DatDiferidosAgricolaLogic implements IDatDiferidosAgricolaLogic {
    private static final Logger log = LoggerFactory.getLogger(DatDiferidosAgricolaLogic.class);

    /**
     * DAO injected by Spring that manages DatDiferidosAgricola entities
     *
     */
    @Autowired
    private IDatDiferidosAgricolaDAO datDiferidosAgricolaDAO;

    /**
    * DAO injected by Spring that manages DatDiferidosAgricolaDet entities
    *
    */
    @Autowired
    private IDatDiferidosAgricolaDetDAO datDiferidosAgricolaDetDAO;
    
    /**
     * DAO injected by Spring that manages DatDiferidosAgricolaDet entities
     *
     */
     @Autowired
     private IDatDiferidosCuotasAgricolasDAO datDiferidosCuotasAgricolaDAO;

    /**
    * Logic injected by Spring that manages Labor entities
    *
    */    
    @Autowired
    ILaborLogic logicLabor1;

    @Autowired
    INivel4Logic nivel4Logic;

    @Autowired
    INivel2Logic nivel2Logic;

    @Transactional(readOnly = true)
    public List<DatDiferidosAgricola> getDatDiferidosAgricola()
        throws Exception {
        log.debug("finding all DatDiferidosAgricola instances");

        List<DatDiferidosAgricola> list = new ArrayList<DatDiferidosAgricola>();

        try {
            list = datDiferidosAgricolaDAO.findAll();
        } catch (Exception e) {
            log.error("finding all DatDiferidosAgricola failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "DatDiferidosAgricola");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveDatDiferidosAgricola(DatDiferidosAgricola entity, List<DatDiferidosAgricolaDetDTO> dataDet,
    		List<DatDiferidosCuotasAgricolasDTO> dataCuotas)
        throws Exception {
        log.debug("saving DatDiferidosAgricola instance");

        try {
            if (entity.getLabor() == null) {
                throw new ZMessManager().new ForeignException("labor");
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

            if ((entity.getNumeroFactura() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getNumeroFactura(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "numeroFactura");
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

            if ((entity.getTipoTransaccion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getTipoTransaccion(), 100) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "tipoTransaccion");
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

            if (entity.getLabor().getLaborId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "laborId_Labor");
            }

            datDiferidosAgricolaDAO.save(entity);
            
            if (dataDet != null) {

 				for (DatDiferidosAgricolaDetDTO valorDto : dataDet) {

 					DatDiferidosAgricolaDet valor = new DatDiferidosAgricolaDet();     						
 					Nivel4 nivel4 = nivel4Logic.getNivel4(valorDto.getNivel4Id_Nivel4().getNivel4Id());
 					
 					valor.setNivel4(nivel4); 	
					valor.setEtapaId(valorDto.getEtapaId());
					valor.setVariedadId(valorDto.getVariedadId());	
					valor.setAreaNeta(valorDto.getAreaNeta());					
					valor.setDatDiferidosAgricola(entity);
					datDiferidosAgricolaDetDAO.save(valor);    		
					
 				}
 			} 	
            
			if (dataCuotas == null) {

				int numCuotas = entity.getPeriodos().intValue();

				for (int i = 0; i < numCuotas; i++) {

					DatDiferidosCuotasAgricolas valor = new DatDiferidosCuotasAgricolas();

					GregorianCalendar fechaInicial = new GregorianCalendar();
					fechaInicial.setTime(entity.getFechaRegistro());
					fechaInicial.add(GregorianCalendar.MONTH, i);

					Long anioRegistro = (long) fechaInicial.get(java.util.Calendar.YEAR);
					Long mesRegistro = (long) fechaInicial.get(java.util.Calendar.MONTH) + 1;

					valor.setFecha(fechaInicial.getTime());
					valor.setAnio(anioRegistro);
					valor.setMes(mesRegistro);
					valor.setValorCuota(entity.getValorInicial() / entity.getPeriodos());
					valor.setDatDiferidosAgricola(entity);

					datDiferidosCuotasAgricolaDAO.save(valor);
				}

			}

            log.debug("save DatDiferidosAgricola successful");
        } catch (Exception e) {
            log.error("save DatDiferidosAgricola failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteDatDiferidosAgricola(DatDiferidosAgricola entity)
        throws Exception {
        log.debug("deleting DatDiferidosAgricola instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion(
                "DatDiferidosAgricola");
        }

        if (entity.getDatDiferidosAgricolaId() == null) {
            throw new ZMessManager().new EmptyFieldException(
                "datDiferidosAgricolaId");
        }

        List<DatDiferidosAgricolaDet> datDiferidosAgricolaDets = null;

        try {
            datDiferidosAgricolaDets = datDiferidosAgricolaDetDAO.findByProperty("datDiferidosAgricola.datDiferidosAgricolaId",
                    entity.getDatDiferidosAgricolaId());

            if (Utilities.validationsList(datDiferidosAgricolaDets) == true) {
                throw new ZMessManager().new DeletingException(
                    "datDiferidosAgricolaDets");
            }

            datDiferidosAgricolaDAO.delete(entity);

            log.debug("delete DatDiferidosAgricola successful");
        } catch (Exception e) {
            log.error("delete DatDiferidosAgricola failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateDatDiferidosAgricola(DatDiferidosAgricola entity, List<DatDiferidosAgricolaDetDTO> dataDet,
    		List<DatDiferidosCuotasAgricolasDTO> dataCuotas)
        throws Exception {
        log.debug("updating DatDiferidosAgricola instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "DatDiferidosAgricola");
            }

            if (entity.getLabor() == null) {
                throw new ZMessManager().new ForeignException("labor");
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

            if ((entity.getNumeroFactura() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getNumeroFactura(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "numeroFactura");
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

            if ((entity.getTipoTransaccion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getTipoTransaccion(), 100) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "tipoTransaccion");
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

            if (entity.getLabor().getLaborId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "laborId_Labor");
            }

            datDiferidosAgricolaDAO.update(entity);
            
            if (dataDet != null) {

 				for (DatDiferidosAgricolaDetDTO valorDto : dataDet) {

 					DatDiferidosAgricolaDet valor = new DatDiferidosAgricolaDet();     						
 					Nivel4 nivel4 = nivel4Logic.getNivel4(valorDto.getNivel4Id_Nivel4().getNivel4Id());
 					
 					valor.setNivel4(nivel4); 
					valor.setEtapaId(valorDto.getEtapaId());
					valor.setVariedadId(valorDto.getVariedadId());
					valor.setAreaNeta(valorDto.getAreaNeta());					
					valor.setDatDiferidosAgricola(entity);
					datDiferidosAgricolaDetDAO.save(valor);    		
					
 				}
 			} 
            
            if (dataCuotas == null) {

				int numCuotas = entity.getPeriodos().intValue();

				for (int i = 0; i < numCuotas; i++) {

					DatDiferidosCuotasAgricolas valor = new DatDiferidosCuotasAgricolas();

					GregorianCalendar fechaInicial = new GregorianCalendar();
					fechaInicial.setTime(entity.getFechaRegistro());
					fechaInicial.add(GregorianCalendar.MONTH, i);

					Long anioRegistro = (long) fechaInicial.get(java.util.Calendar.YEAR);
					Long mesRegistro = (long) fechaInicial.get(java.util.Calendar.MONTH) + 1;

					valor.setFecha(fechaInicial.getTime());
					valor.setAnio(anioRegistro);
					valor.setMes(mesRegistro);
					valor.setValorCuota(entity.getValorInicial() / entity.getPeriodos());
					valor.setDatDiferidosAgricola(entity);

					datDiferidosCuotasAgricolaDAO.save(valor);
				}

			}

            log.debug("update DatDiferidosAgricola successful");
        } catch (Exception e) {
            log.error("update DatDiferidosAgricola failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<DatDiferidosAgricolaDTO> getDataDatDiferidosAgricola()
        throws Exception {
        try {
            List<DatDiferidosAgricola> datDiferidosAgricola = datDiferidosAgricolaDAO.findAll();

            List<DatDiferidosAgricolaDTO> datDiferidosAgricolaDTO = new ArrayList<DatDiferidosAgricolaDTO>();

            for (DatDiferidosAgricola datDiferidosAgricolaTmp : datDiferidosAgricola) {
                DatDiferidosAgricolaDTO datDiferidosAgricolaDTO2 = new DatDiferidosAgricolaDTO();

                datDiferidosAgricolaDTO2.setDatDiferidosAgricolaId(datDiferidosAgricolaTmp.getDatDiferidosAgricolaId());
                datDiferidosAgricolaDTO2.setAnioAplicacion((datDiferidosAgricolaTmp.getAnioAplicacion() != null)
                    ? datDiferidosAgricolaTmp.getAnioAplicacion() : null);
                datDiferidosAgricolaDTO2.setCategEquipId((datDiferidosAgricolaTmp.getCategEquipId() != null)
                    ? datDiferidosAgricolaTmp.getCategEquipId() : null);
                datDiferidosAgricolaDTO2.setCompania((datDiferidosAgricolaTmp.getCompania() != null)
                    ? datDiferidosAgricolaTmp.getCompania() : null);
                datDiferidosAgricolaDTO2.setConsecutivo((datDiferidosAgricolaTmp.getConsecutivo() != null)
                    ? datDiferidosAgricolaTmp.getConsecutivo() : null);
                datDiferidosAgricolaDTO2.setDetalleAplicacion((datDiferidosAgricolaTmp.getDetalleAplicacion() != null)
                    ? datDiferidosAgricolaTmp.getDetalleAplicacion() : null);
                datDiferidosAgricolaDTO2.setDetalleNota((datDiferidosAgricolaTmp.getDetalleNota() != null)
                    ? datDiferidosAgricolaTmp.getDetalleNota() : null);
                datDiferidosAgricolaDTO2.setEstado((datDiferidosAgricolaTmp.getEstado() != null)
                    ? datDiferidosAgricolaTmp.getEstado() : null);
                datDiferidosAgricolaDTO2.setFechaAnulacion(datDiferidosAgricolaTmp.getFechaAnulacion());
                datDiferidosAgricolaDTO2.setFechaCreacion(datDiferidosAgricolaTmp.getFechaCreacion());
                datDiferidosAgricolaDTO2.setFechaModificacion(datDiferidosAgricolaTmp.getFechaModificacion());
                datDiferidosAgricolaDTO2.setFechaRegistro(datDiferidosAgricolaTmp.getFechaRegistro());
                datDiferidosAgricolaDTO2.setMesAplicacion((datDiferidosAgricolaTmp.getMesAplicacion() != null)
                    ? datDiferidosAgricolaTmp.getMesAplicacion() : null);
                datDiferidosAgricolaDTO2.setNpReset((datDiferidosAgricolaTmp.getNpReset() != null)
                    ? datDiferidosAgricolaTmp.getNpReset() : null);
                datDiferidosAgricolaDTO2.setNumeroFactura((datDiferidosAgricolaTmp.getNumeroFactura() != null)
                    ? datDiferidosAgricolaTmp.getNumeroFactura() : null);
                datDiferidosAgricolaDTO2.setObservacion((datDiferidosAgricolaTmp.getObservacion() != null)
                    ? datDiferidosAgricolaTmp.getObservacion() : null);
                datDiferidosAgricolaDTO2.setObservacionAnularReg((datDiferidosAgricolaTmp.getObservacionAnularReg() != null)
                    ? datDiferidosAgricolaTmp.getObservacionAnularReg() : null);
                datDiferidosAgricolaDTO2.setPeriodos((datDiferidosAgricolaTmp.getPeriodos() != null)
                    ? datDiferidosAgricolaTmp.getPeriodos() : null);
                datDiferidosAgricolaDTO2.setTipoTransaccion((datDiferidosAgricolaTmp.getTipoTransaccion() != null)
                    ? datDiferidosAgricolaTmp.getTipoTransaccion() : null);
                datDiferidosAgricolaDTO2.setUsuarioDigitacion((datDiferidosAgricolaTmp.getUsuarioDigitacion() != null)
                    ? datDiferidosAgricolaTmp.getUsuarioDigitacion() : null);
                datDiferidosAgricolaDTO2.setValorCuota((datDiferidosAgricolaTmp.getValorCuota() != null)
                    ? datDiferidosAgricolaTmp.getValorCuota() : null);
                datDiferidosAgricolaDTO2.setValorInicial((datDiferidosAgricolaTmp.getValorInicial() != null)
                    ? datDiferidosAgricolaTmp.getValorInicial() : null);
                datDiferidosAgricolaDTO2.setValorSaldo((datDiferidosAgricolaTmp.getValorSaldo() != null)
                    ? datDiferidosAgricolaTmp.getValorSaldo() : null);

                if (datDiferidosAgricolaTmp.getLabor() != null) {
                    datDiferidosAgricolaDTO2.setLaborId_Labor(datDiferidosAgricolaTmp.getLabor()
                                                                                     .getLaborId());
                } else {
                    datDiferidosAgricolaDTO2.setLaborId_Labor(null);
                }

                datDiferidosAgricolaDTO.add(datDiferidosAgricolaDTO2);
            }

            return datDiferidosAgricolaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public DatDiferidosAgricola getDatDiferidosAgricola(
        Long datDiferidosAgricolaId) throws Exception {
        log.debug("getting DatDiferidosAgricola instance");

        DatDiferidosAgricola entity = null;

        try {
            entity = datDiferidosAgricolaDAO.findById(datDiferidosAgricolaId);
        } catch (Exception e) {
            log.error("get DatDiferidosAgricola failed", e);
            throw new ZMessManager().new FindingException(
                "DatDiferidosAgricola");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<DatDiferidosAgricola> findPageDatDiferidosAgricola(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        List<DatDiferidosAgricola> entity = null;

        try {
            entity = datDiferidosAgricolaDAO.findPage(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatDiferidosAgricola Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberDatDiferidosAgricola() throws Exception {
        Long entity = null;

        try {
            entity = datDiferidosAgricolaDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatDiferidosAgricola Count");
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
    public List<DatDiferidosAgricola> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<DatDiferidosAgricola> list = new ArrayList<DatDiferidosAgricola>();
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
            list = datDiferidosAgricolaDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
    
   	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
       public void saveDatDiferidosAgricolaVer2(DatDiferidosAgricola entity, List<ListaNivel4DTO> dataNivel4,     		
    		   List<DatDiferidosCuotasAgricolasDTO> dataCuotas) throws Exception {
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
        
               datDiferidosAgricolaDAO.save(entity);
               
				if (dataNivel4 != null) {
	
					for (ListaNivel4DTO valorDto : dataNivel4) {
	
						DatDiferidosAgricolaDet valor = new DatDiferidosAgricolaDet();
						Nivel4 nivel4 = nivel4Logic.getNivel4(valorDto.getNivel4_id().longValue());		
						Nivel2 nivel2 = nivel2Logic.getNivel2(valorDto.getNivel2_id().longValue());
						Etapa etapa = nivel4.getEtapa();
	
						valor.setNivel4(nivel4);
						valor.setNivel2(nivel2);
						valor.setAreaNeta(nivel4.getAreaNeta());
						if (etapa != null) {
							valor.setEtapaId(etapa.getEtapaId());							
						}
						valor.setVariedadId(nivel4.getVariedad());
						valor.setDatDiferidosAgricola(entity);
						datDiferidosAgricolaDetDAO.save(valor);
					}
				}
	
				if (dataCuotas == null) {
	
					int numCuotas = entity.getPeriodos().intValue();
	
					for (int i = 0; i < numCuotas; i++) {
	
						DatDiferidosCuotasAgricolas valor = new DatDiferidosCuotasAgricolas();
	
						GregorianCalendar fechaInicial = new GregorianCalendar();
						fechaInicial.setTime(entity.getFechaRegistro());
						fechaInicial.add(GregorianCalendar.MONTH, i);
	
						Long anioRegistro = (long) fechaInicial.get(java.util.Calendar.YEAR);
						Long mesRegistro = (long) fechaInicial.get(java.util.Calendar.MONTH) + 1;
	
						valor.setFecha(fechaInicial.getTime());
						valor.setAnio(anioRegistro);
						valor.setMes(mesRegistro);
						valor.setValorCuota((double)Math.round((entity.getValorInicial() / entity.getPeriodos()) * 100) / 100);
						valor.setDatDiferidosAgricola(entity);
	
						datDiferidosCuotasAgricolaDAO.save(valor);
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
    public void updateDatDiferidosAgricolaVer2(DatDiferidosAgricola entity, List<ListaNivel4DTO> dataNivel4,
    		List<DatDiferidosCuotasAgricolasDTO> dataCuotas)
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

            datDiferidosAgricolaDAO.update(entity);
            
            if (dataNivel4 != null) {

  				for (ListaNivel4DTO valorDto : dataNivel4) {

  					DatDiferidosAgricolaDet valor = new DatDiferidosAgricolaDet();
					Nivel4 nivel4 = nivel4Logic.getNivel4(valorDto.getNivel4_id().longValue());		
					Nivel2 nivel2 = nivel2Logic.getNivel2(valorDto.getNivel2_id().longValue());
					Etapa etapa = nivel4.getEtapa();

					valor.setNivel4(nivel4);
					valor.setNivel2(nivel2);
					valor.setAreaNeta(nivel4.getAreaNeta());
					if (etapa != null) {
						valor.setEtapaId(etapa.getEtapaId());							
					}
					valor.setVariedadId(nivel4.getVariedad());
					valor.setDatDiferidosAgricola(entity);

					datDiferidosAgricolaDetDAO.save(valor);
  					
  				}
  			}
            
            if (dataCuotas == null) {
            	
				int numCuotas = entity.getPeriodos().intValue();

				for (int i = 0; i < numCuotas; i++) {

					DatDiferidosCuotasAgricolas valor = new DatDiferidosCuotasAgricolas();

					GregorianCalendar fechaInicial = new GregorianCalendar();
					fechaInicial.setTime(entity.getFechaRegistro());
					fechaInicial.add(GregorianCalendar.MONTH, i);

					Long anioRegistro = (long) fechaInicial.get(java.util.Calendar.YEAR);
					Long mesRegistro = (long) fechaInicial.get(java.util.Calendar.MONTH) + 1;

					valor.setFecha(fechaInicial.getTime());
					valor.setAnio(anioRegistro);
					valor.setMes(mesRegistro);
					valor.setValorCuota(entity.getValorInicial() / entity.getPeriodos());
					valor.setDatDiferidosAgricola(entity);

					datDiferidosCuotasAgricolaDAO.save(valor);
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
