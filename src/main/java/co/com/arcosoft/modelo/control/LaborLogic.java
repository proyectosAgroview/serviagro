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

import co.com.arcosoft.dataaccess.dao.IDatAplicProductoDAO;
import co.com.arcosoft.dataaccess.dao.IDatPlanLaborDAO;
import co.com.arcosoft.dataaccess.dao.IDatPlanillaNominaDAO;
import co.com.arcosoft.dataaccess.dao.IDatRiegoDAO;
import co.com.arcosoft.dataaccess.dao.IDatServicioDAO;
import co.com.arcosoft.dataaccess.dao.IEquipoDAO;
import co.com.arcosoft.dataaccess.dao.ILaborAsociadaDAO;
import co.com.arcosoft.dataaccess.dao.ILaborCcontableDAO;
import co.com.arcosoft.dataaccess.dao.ILaborDAO;
import co.com.arcosoft.dataaccess.dao.ILaborRecursosDAO;
import co.com.arcosoft.dataaccess.dao.ILaborServicioDAO;
import co.com.arcosoft.dataaccess.dao.ITarifaLaborRendimientoDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatAplicProducto;
import co.com.arcosoft.modelo.DatPlanLabor;
import co.com.arcosoft.modelo.DatPlanillaNomina;
import co.com.arcosoft.modelo.DatRiego;
import co.com.arcosoft.modelo.DatServicio;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.LaborAsociada;
import co.com.arcosoft.modelo.LaborCcontable;
import co.com.arcosoft.modelo.LaborRecursos;
import co.com.arcosoft.modelo.LaborServicio;
import co.com.arcosoft.modelo.TarifaLaborRendimiento;
import co.com.arcosoft.modelo.dto.LaborCcontableDTO;
import co.com.arcosoft.modelo.dto.LaborDTO;
import co.com.arcosoft.modelo.dto.LaborRecursosDTO;
import co.com.arcosoft.modelo.dto.TarifaLaborRendimientoDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("LaborLogic")
public class LaborLogic implements ILaborLogic {
	private static final Logger log = LoggerFactory.getLogger(LaborLogic.class);

	/**
	 * DAO injected by Spring that manages Labor entities
	 *
	 */
	@Autowired
	private ILaborDAO laborDAO;

	@Autowired
	private ITarifaLaborRendimientoDAO tarifaLaborRendimientoDAO;

	/**
	 * DAO injected by Spring that manages DatAplicProducto entities
	 *
	 */
	@Autowired
	private IDatAplicProductoDAO datAplicProductoDAO;

	/**
	 * DAO injected by Spring that manages DatPlanLabor entities
	 *
	 */
	@Autowired
	private IDatPlanLaborDAO datPlanLaborDAO;

	/**
	 * DAO injected by Spring that manages DatPlanillaNomina entities
	 *
	 */
	@Autowired
	private IDatPlanillaNominaDAO datPlanillaNominaDAO;

	/**
	 * DAO injected by Spring that manages DatRiego entities
	 *
	 */
	@Autowired
	private IDatRiegoDAO datRiegoDAO;

	/**
	 * DAO injected by Spring that manages DatServicio entities
	 *
	 */
	@Autowired
	private IDatServicioDAO datServicioDAO;

	/**
	 * DAO injected by Spring that manages Equipo entities
	 *
	 */
	@Autowired
	private IEquipoDAO equipoDAO;

	/**
	 * DAO injected by Spring that manages LaborAsociada entities
	 *
	 */
	@Autowired
	private ILaborAsociadaDAO laborAsociadaDAO;

	/**
	 * DAO injected by Spring that manages LaborCcontable entities
	 *
	 */
	@Autowired
	private ILaborCcontableDAO laborCcontableDAO;

	/**
	 * DAO injected by Spring that manages LaborServicio entities
	 *
	 */
	@Autowired
	private ILaborServicioDAO laborServicioDAO;

	@Autowired
	private ILaborRecursosDAO laborRecursosDAO;

	/**
	 * Logic injected by Spring that manages GrpLabor entities
	 *
	 */
	@Autowired
	IGrpLaborLogic logicGrpLabor1;

	/**
	 * Logic injected by Spring that manages UdadMed entities
	 *
	 */
	@Autowired
	IUdadMedLogic logicUdadMed2;

	/**
	 * Logic injected by Spring that manages UdadMed entities
	 *
	 */
	@Autowired
	IUdadMedLogic logicUdadMed3;

	/**
	 * Logic injected by Spring that manages UdadMed entities
	 *
	 */
	@Autowired
	IUdadMedLogic logicUdadMed4;

	@Override
	@Transactional(readOnly = true)
	public List<Labor> getLabor() throws Exception {
		log.debug("finding all Labor instances");

		List<Labor> list = new ArrayList<Labor>();

		try {
			list = laborDAO.findAll();
		} catch (Exception e) {
			log.error("finding all Labor failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "Labor");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveLabor(Labor entity, List<TarifaLaborRendimientoDTO> dataTarifaRendimiento,
			List<LaborRecursosDTO> dataLaborRecursos, 	List<LaborCcontableDTO> dataCcontable) throws Exception {
		log.debug("saving Labor instance");

		try {
			if (entity.getGrpLabor() == null) {
				throw new ZMessManager().new ForeignException("grpLabor");
			}

			if (entity.getUdadMedByUdadMedPago() == null) {
				throw new ZMessManager().new ForeignException("udadMedByUdadMedPago");
			}

			/*
			 * if (entity.getUdadMedByUdadMedPlan() == null) { throw new
			 * ZMessManager().new ForeignException( "udadMedByUdadMedPlan"); }
			 * 
			 * if (entity.getUdadMedByUdadMedProd() == null) { throw new
			 * ZMessManager().new ForeignException( "udadMedByUdadMedProd"); }
			 */
			if ((entity.getClaseLabor() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getClaseLabor(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("claseLabor");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getColor() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getColor(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("color");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getDigitaLinea() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getDigitaLinea(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("digitaLinea");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getInfoAdicional() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional");
			}

			if ((entity.getInfoAdicional2() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional2(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional2");
			}

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			if ((entity.getRestriCicloCosecha() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getRestriCicloCosecha(), 4, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("restriCicloCosecha");
			}

			if ((entity.getRestriSecuencia() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getRestriSecuencia(), 4, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("restriSecuencia");
			}

			if ((entity.getTipoLabor() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getTipoLabor(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("tipoLabor");
			}

			if (entity.getGrpLabor().getGrpLaborId() == null) {
				throw new ZMessManager().new EmptyFieldException("grpLaborId_GrpLabor");
			}

			if ((entity.getGrpLabor().getGrpLaborId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getGrpLabor().getGrpLaborId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("grpLaborId_GrpLabor");
			}

			if (entity.getUdadMedByUdadMedPago().getUdadMedId() == null) {
				throw new ZMessManager().new EmptyFieldException("udadMedId_UdadMed");
			}

			if ((entity.getUdadMedByUdadMedPago().getUdadMedId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getUdadMedByUdadMedPago().getUdadMedId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("udadMedId_UdadMed");
			}

			/*
			 * if (entity.getUdadMedByUdadMedPlan() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "udadMedId_UdadMed"); }
			 */

			if ((entity.getUdadMedByUdadMedPlan() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getUdadMedByUdadMedPlan(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("udadMedId_UdadMed");
			}

			/*
			 * if (entity.getUdadMedByUdadMedProd() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "udadMedId_UdadMed"); }
			 */

			if ((entity.getUdadMedByUdadMedProd() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getUdadMedByUdadMedProd(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("udadMedId_UdadMed");
			}

			/*
			 * if (entity.getLaborId() == null) { throw new ZMessManager().new
			 * EmptyFieldException("laborId"); }
			 * 
			 * if ((entity.getLaborId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getLaborId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException("laborId"); }
			 * 
			 * if (getLabor(entity.getLaborId()) != null) { throw new
			 * ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */

			laborDAO.save(entity);

			if (dataTarifaRendimiento != null) {

				for (TarifaLaborRendimientoDTO valorDto : dataTarifaRendimiento) {

					if (valorDto.getTarifaLaborId() == null) {

						TarifaLaborRendimiento valor = new TarifaLaborRendimiento();

						valor.setCompania(valorDto.getCompania());
						valor.setNivel2Id(valorDto.getNivel2Id());
						valor.setBonificacion(valorDto.getBonificacion());
						valor.setRendimiento(valorDto.getRendimiento());
						valor.setFechaCreacion(valorDto.getFechaCreacion());
						valor.setFechaFinal(valorDto.getFechaFinal());
						valor.setFechaInicial(valorDto.getFechaInicial());
						valor.setFechaModificacion(valorDto.getFechaModificacion());
						valor.setContratistaId(valorDto.getContratistaId());
						valor.setTarifa(valorDto.getTarifa());
						valor.setRendimientoMax(valorDto.getRendimientoMax());
						
						valor.setUdadMedId(valorDto.getUdadMedId());

						valor.setLabor(entity);

						tarifaLaborRendimientoDAO.save(valor);
					}

				}
			}

			if (dataLaborRecursos != null) {

				for (LaborRecursosDTO valorDto : dataLaborRecursos) {

					if (valorDto.getLaborRecursosId() == null) {

						LaborRecursos valor = new LaborRecursos();

						valor.setRecursoId(valorDto.getRecursoId());
						valor.setRendimientoRecurso(valorDto.getRendimientoRecurso());
						valor.setTipoRecurso(valorDto.getTpRecursoId_TipoRecurso());
						valor.setUdadMedId(valorDto.getUdadMedId());
						valor.setNombreRecurso(valorDto.getNombreRecurso());

						valor.setLabor(entity);

						laborRecursosDAO.save(valor);
					}

				}
			}

			log.debug("save Labor successful");
		} catch (Exception e) {
			log.error("save Labor failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteLabor(Labor entity) throws Exception {
		log.debug("deleting Labor instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Labor");
		}

		if (entity.getLaborId() == null) {
			throw new ZMessManager().new EmptyFieldException("laborId");
		}

		List<DatAplicProducto> datAplicProductos = null;
		List<DatPlanLabor> datPlanLabors = null;
		List<DatPlanillaNomina> datPlanillaNominas = null;
		List<DatRiego> datRiegos = null;
		List<DatServicio> datServicios = null;
		List<Equipo> equipos = null;
		List<LaborAsociada> laborAsociadasForLaborAsocId = null;
		List<LaborAsociada> laborAsociadasForLaborId = null;
		List<LaborCcontable> laborCcontables = null;
		List<LaborServicio> laborServicios = null;
		List<LaborRecursos> laborRecursoses = null;

		try {
			laborRecursoses = laborRecursosDAO.findByProperty("labor.laborId", entity.getLaborId());

			if (Utilities.validationsList(laborRecursoses) == true) {
				throw new ZMessManager().new DeletingException("laborRecursoses");
			}

			datAplicProductos = datAplicProductoDAO.findByProperty("labor.laborId", entity.getLaborId());

			if (Utilities.validationsList(datAplicProductos) == true) {
				throw new ZMessManager().new DeletingException("datAplicProductos");
			}

			datPlanLabors = datPlanLaborDAO.findByProperty("labor.laborId", entity.getLaborId());

			if (Utilities.validationsList(datPlanLabors) == true) {
				throw new ZMessManager().new DeletingException("datPlanLabors");
			}

			datPlanillaNominas = datPlanillaNominaDAO.findByProperty("labor.laborId", entity.getLaborId());

			if (Utilities.validationsList(datPlanillaNominas) == true) {
				throw new ZMessManager().new DeletingException("datPlanillaNominas");
			}

			datRiegos = datRiegoDAO.findByProperty("labor.laborId", entity.getLaborId());

			if (Utilities.validationsList(datRiegos) == true) {
				throw new ZMessManager().new DeletingException("datRiegos");
			}

			datServicios = datServicioDAO.findByProperty("labor.laborId", entity.getLaborId());

			if (Utilities.validationsList(datServicios) == true) {
				throw new ZMessManager().new DeletingException("datServicios");
			}

			equipos = equipoDAO.findByProperty("labor.laborId", entity.getLaborId());

			if (Utilities.validationsList(equipos) == true) {
				throw new ZMessManager().new DeletingException("equipos");
			}

			laborAsociadasForLaborAsocId = laborAsociadaDAO.findByProperty("labor.laborId", entity.getLaborId());

			if (Utilities.validationsList(laborAsociadasForLaborAsocId) == true) {
				throw new ZMessManager().new DeletingException("laborAsociadasForLaborAsocId");
			}

			laborAsociadasForLaborId = laborAsociadaDAO.findByProperty("labor.laborId", entity.getLaborId());

			if (Utilities.validationsList(laborAsociadasForLaborId) == true) {
				throw new ZMessManager().new DeletingException("laborAsociadasForLaborId");
			}

			laborCcontables = laborCcontableDAO.findByProperty("labor.laborId", entity.getLaborId());

			if (Utilities.validationsList(laborCcontables) == true) {
				throw new ZMessManager().new DeletingException("laborCcontables");
			}

			laborServicios = laborServicioDAO.findByProperty("labor.laborId", entity.getLaborId());

			if (Utilities.validationsList(laborServicios) == true) {
				throw new ZMessManager().new DeletingException("laborServicios");
			}

			laborDAO.delete(entity);

			log.debug("delete Labor successful");
		} catch (Exception e) {
			log.error("delete Labor failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateLabor(Labor entity, List<TarifaLaborRendimientoDTO> dataTarifaRendimiento,
			List<LaborRecursosDTO> dataLaborRecursos, 	List<LaborCcontableDTO> dataCcontable) throws Exception {
		log.debug("updating Labor instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Labor");
			}

			if (entity.getGrpLabor() == null) {
				throw new ZMessManager().new ForeignException("grpLabor");
			}

			if (entity.getUdadMedByUdadMedPago() == null) {
				throw new ZMessManager().new ForeignException("udadMedByUdadMedPago");
			}

			/*
			 * if (entity.getUdadMedByUdadMedPlan() == null) { throw new
			 * ZMessManager().new ForeignException( "udadMedByUdadMedPlan"); }
			 * 
			 * if (entity.getUdadMedByUdadMedProd() == null) { throw new
			 * ZMessManager().new ForeignException( "udadMedByUdadMedProd"); }
			 */

			if ((entity.getClaseLabor() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getClaseLabor(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("claseLabor");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getColor() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getColor(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("color");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getDigitaLinea() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getDigitaLinea(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("digitaLinea");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getInfoAdicional() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional");
			}

			if ((entity.getInfoAdicional2() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional2(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional2");
			}

			if (entity.getLaborId() == null) {
				throw new ZMessManager().new EmptyFieldException("laborId");
			}

			if ((entity.getLaborId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getLaborId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("laborId");
			}

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			if ((entity.getRestriCicloCosecha() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getRestriCicloCosecha(), 4, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("restriCicloCosecha");
			}

			if ((entity.getRestriSecuencia() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getRestriSecuencia(), 4, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("restriSecuencia");
			}

			if ((entity.getTipoLabor() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getTipoLabor(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("tipoLabor");
			}

			if (entity.getGrpLabor().getGrpLaborId() == null) {
				throw new ZMessManager().new EmptyFieldException("grpLaborId_GrpLabor");
			}

			if ((entity.getGrpLabor().getGrpLaborId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getGrpLabor().getGrpLaborId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("grpLaborId_GrpLabor");
			}

			if (entity.getUdadMedByUdadMedPago().getUdadMedId() == null) {
				throw new ZMessManager().new EmptyFieldException("udadMedId_UdadMed");
			}

			if ((entity.getUdadMedByUdadMedPago().getUdadMedId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getUdadMedByUdadMedPago().getUdadMedId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("udadMedId_UdadMed");
			}

			/*
			 * if (entity.getUdadMedByUdadMedPlan() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "udadMedId_UdadMed"); }
			 */

			/*
			 * if ((entity.getUdadMedByUdadMedPlan() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getUdadMedByUdadMedPlan(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "udadMedId_UdadMed");
			 * }
			 */

			/*
			 * if (entity.getUdadMedByUdadMedProd() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "udadMedId_UdadMed"); }
			 */

			/*
			 * if ((entity.getUdadMedByUdadMedProd() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getUdadMedByUdadMedProd(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "udadMedId_UdadMed");
			 * }
			 */

			laborDAO.update(entity);
			if (dataTarifaRendimiento != null) {

				for (TarifaLaborRendimientoDTO valorDto : dataTarifaRendimiento) {

					if (valorDto.getTarifaLaborId() == null) {

						TarifaLaborRendimiento valor = new TarifaLaborRendimiento();

						valor.setCompania(valorDto.getCompania());
						valor.setNivel2Id(valorDto.getNivel2Id());
						valor.setBonificacion(valorDto.getBonificacion());
						valor.setRendimiento(valorDto.getRendimiento());
						valor.setFechaCreacion(valorDto.getFechaCreacion());
						valor.setFechaFinal(valorDto.getFechaFinal());
						valor.setFechaInicial(valorDto.getFechaInicial());
						valor.setFechaModificacion(valorDto.getFechaModificacion());
						valor.setContratistaId(valorDto.getContratistaId());
						valor.setTarifa(valorDto.getTarifa());
						valor.setUdadMedId(valorDto.getUdadMedId());
						valor.setRendimientoMax(valorDto.getRendimientoMax());
						
						valor.setLabor(entity);

						tarifaLaborRendimientoDAO.save(valor);
					} else {
						TarifaLaborRendimiento valor = tarifaLaborRendimientoDAO.findById(valorDto.getTarifaLaborId());

						valor.setCompania(valorDto.getCompania());
						valor.setNivel2Id(valorDto.getNivel2Id());
						valor.setBonificacion(valorDto.getBonificacion());
						valor.setRendimiento(valorDto.getRendimiento());
						valor.setFechaCreacion(valorDto.getFechaCreacion());
						valor.setFechaFinal(valorDto.getFechaFinal());
						valor.setFechaInicial(valorDto.getFechaInicial());
						valor.setFechaModificacion(valorDto.getFechaModificacion());
						valor.setContratistaId(valorDto.getContratistaId());
						valor.setTarifa(valorDto.getTarifa());
						valor.setUdadMedId(valorDto.getUdadMedId());
						valor.setRendimientoMax(valorDto.getRendimientoMax());
						
						tarifaLaborRendimientoDAO.update(valor);
					}

				}
			}
			if (dataLaborRecursos != null) {

				for (LaborRecursosDTO valorDto : dataLaborRecursos) {

					if (valorDto.getLaborRecursosId() == null) {

						LaborRecursos valor = new LaborRecursos();

						valor.setRecursoId(valorDto.getRecursoId());
						valor.setRendimientoRecurso(valorDto.getRendimientoRecurso());
						valor.setTipoRecurso(valorDto.getTpRecursoId_TipoRecurso());
						valor.setUdadMedId(valorDto.getUdadMedId());
						valor.setNombreRecurso(valorDto.getNombreRecurso());

						valor.setLabor(entity);
						laborRecursosDAO.save(valor);

					} else {

						LaborRecursos valor = laborRecursosDAO.findById(valorDto.getLaborRecursosId());

						valor.setRecursoId(valorDto.getRecursoId());
						valor.setRendimientoRecurso(valorDto.getRendimientoRecurso());
						valor.setTipoRecurso(valorDto.getTpRecursoId_TipoRecurso());
						valor.setUdadMedId(valorDto.getUdadMedId());
						valor.setNombreRecurso(valorDto.getNombreRecurso());

						valor.setLabor(entity);
						laborRecursosDAO.update(valor);
					}

				}
			}
			if (dataCcontable != null) {

				for (LaborCcontableDTO valorDto : dataCcontable) {

					if (valorDto.getLaborCcontableId() == null) {

						LaborCcontable valor = new LaborCcontable();

						valor.setCuentaContable(valorDto.getCcontableId());
						valor.setLabor(entity);
						laborCcontableDAO.save(valor);

					} else {

						LaborCcontable valor = laborCcontableDAO.findById(valorDto.getLaborCcontableId());

						valor.setCuentaContable(valorDto.getCcontableId());
						valor.setLabor(entity);
						laborCcontableDAO.update(valor);
					}

				}
			}
			log.debug("update Labor successful");
		} catch (Exception e) {
			log.error("update Labor failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<LaborDTO> getDataLabor() throws Exception {
		try {
			List<Labor> labor = laborDAO.findAll();

			List<LaborDTO> laborDTO = new ArrayList<LaborDTO>();

			for (Labor laborTmp : labor) {
				LaborDTO laborDTO2 = new LaborDTO();

				laborDTO2.setLaborId(laborTmp.getLaborId());
				laborDTO2.setClaseLabor((laborTmp.getClaseLabor() != null) ? laborTmp.getClaseLabor() : null);
				laborDTO2.setCodigo((laborTmp.getCodigo() != null) ? laborTmp.getCodigo() : null);
				laborDTO2.setColor((laborTmp.getColor() != null) ? laborTmp.getColor() : null);
				laborDTO2.setCompania((laborTmp.getCompania() != null) ? laborTmp.getCompania() : null);
				laborDTO2.setDigitaLinea((laborTmp.getDigitaLinea() != null) ? laborTmp.getDigitaLinea() : null);
				laborDTO2.setEstado((laborTmp.getEstado() != null) ? laborTmp.getEstado() : null);
				laborDTO2.setFechaCreacion(laborTmp.getFechaCreacion());
				laborDTO2.setFechaModificacion(laborTmp.getFechaModificacion());
				laborDTO2.setInfoAdicional((laborTmp.getInfoAdicional() != null) ? laborTmp.getInfoAdicional() : null);
				laborDTO2.setInfoAdicional2(
						(laborTmp.getInfoAdicional2() != null) ? laborTmp.getInfoAdicional2() : null);
				laborDTO2.setNombre((laborTmp.getNombre() != null) ? laborTmp.getNombre() : null);
				laborDTO2.setRestriCicloCosecha(
						(laborTmp.getRestriCicloCosecha() != null) ? laborTmp.getRestriCicloCosecha() : null);
				laborDTO2.setRestriSecuencia(
						(laborTmp.getRestriSecuencia() != null) ? laborTmp.getRestriSecuencia() : null);
				laborDTO2.setTipoLabor((laborTmp.getTipoLabor() != null) ? laborTmp.getTipoLabor() : null);
				laborDTO2.setGrpLaborId_GrpLabor((laborTmp.getGrpLabor().getGrpLaborId() != null)
						? laborTmp.getGrpLabor().getGrpLaborId() : null);
				laborDTO2.setUdadMedId_UdadMed_Pago((laborTmp.getUdadMedByUdadMedPago().getUdadMedId() != null)
						? laborTmp.getUdadMedByUdadMedPago().getUdadMedId() : null);
				laborDTO2.setUdadMedId_UdadMed_Plan(
						(laborTmp.getUdadMedByUdadMedPlan() != null) ? laborTmp.getUdadMedByUdadMedPlan() : null);
				laborDTO2.setUdadMedId_UdadMed_Prod(
						(laborTmp.getUdadMedByUdadMedProd() != null) ? laborTmp.getUdadMedByUdadMedProd() : null);

				laborDTO2.setGrupoLabor((laborTmp.getGrpLabor().getNombre() != null)
						? laborTmp.getGrpLabor().getNombre() : null);
				

				laborDTO2.setCuentaContable((laborTmp.getCuentaContable() != null)
						? laborTmp.getCuentaContable()  : null);
				
			
				laborDTO2.setTarifaEstandar((laborTmp.getTarifaEstandar() != null)
						? laborTmp.getTarifaEstandar()  : null);
				
				laborDTO2.setTarifaEstandar2((laborTmp.getTarifaEstandar2() != null)
						? laborTmp.getTarifaEstandar2()  : null);
				
				laborDTO2.setTarifaEstandar3((laborTmp.getTarifaEstandar3() != null)
						? laborTmp.getTarifaEstandar3()  : null);
				
				laborDTO2.setTarifaEstandar4((laborTmp.getTarifaEstandar4() != null)
						? laborTmp.getTarifaEstandar4()  : null);
				
				laborDTO2.setTarifaEstandar5((laborTmp.getTarifaEstandar5() != null)
						? laborTmp.getTarifaEstandar5()  : null);
				
				laborDTO2.setTarifaEstandar6((laborTmp.getTarifaEstandar6() != null)
						? laborTmp.getTarifaEstandar6()  : null);
				
				laborDTO2.setTarifaEstandar7((laborTmp.getTarifaEstandar7() != null)
						? laborTmp.getTarifaEstandar7()  : null);
				
				laborDTO2.setTarifaEstandar8((laborTmp.getTarifaEstandar8() != null)
						? laborTmp.getTarifaEstandar8()  : null);
				
				laborDTO2.setTarifaEstandar9((laborTmp.getTarifaEstandar9() != null)
						? laborTmp.getTarifaEstandar9()  : null);
				
				laborDTO2.setTarifaEstandar10((laborTmp.getTarifaEstandar10() != null)
						? laborTmp.getTarifaEstandar10()  : null);
				
				laborDTO2.setPagoPorArea((laborTmp.getPagoPorArea() != null)
						? laborTmp.getPagoPorArea()  : null);
				
				laborDTO2.setTipoParada((laborTmp.getTipoParada() != null)
						? laborTmp.getTipoParada()  : null);
				
			
				laborDTO.add(laborDTO2);

			}

			return laborDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Labor getLabor(Long laborId) throws Exception {
		log.debug("getting Labor instance");

		Labor entity = null;

		try {
			entity = laborDAO.findById(laborId);
		} catch (Exception e) {
			log.error("get Labor failed", e);
			throw new ZMessManager().new FindingException("Labor");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Labor> findPageLabor(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<Labor> entity = null;

		try {
			entity = laborDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Labor Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberLabor() throws Exception {
		Long entity = null;

		try {
			entity = laborDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Labor Count");
		} finally {
		}

		return entity;
	}

	/**
	 *
	 * @param varibles
	 *            este arreglo debera tener:
	 *
	 *            [0] = String variable = (String) varibles[i]; representa como
	 *            se llama la variable en el pojo
	 *
	 *            [1] = Boolean booVariable = (Boolean) varibles[i + 1];
	 *            representa si el valor necesita o no ''(comillas simples)usado
	 *            para campos de tipo string
	 *
	 *            [2] = Object value = varibles[i + 2]; representa el valor que
	 *            se va a buscar en la BD
	 *
	 *            [3] = String comparator = (String) varibles[i + 3]; representa
	 *            que tipo de busqueda voy a hacer.., ejemplo: where
	 *            nombre=william o where nombre<>william, en este campo iria el
	 *            tipo de comparador que quiero si es = o <>
	 *
	 *            Se itera de 4 en 4..., entonces 4 registros del arreglo
	 *            representan 1 busqueda en un campo, si se ponen mas pues el
	 *            continuara buscando en lo que se le ingresen en los otros 4
	 *
	 *
	 * @param variablesBetween
	 *
	 *            la diferencia son estas dos posiciones
	 *
	 *            [0] = String variable = (String) varibles[j]; la variable ne
	 *            la BD que va a ser buscada en un rango
	 *
	 *            [1] = Object value = varibles[j + 1]; valor 1 para buscar en
	 *            un rango
	 *
	 *            [2] = Object value2 = varibles[j + 2]; valor 2 para buscar en
	 *            un rango ejempolo: a > 1 and a < 5 --> 1 seria value y 5 seria
	 *            value2
	 *
	 *            [3] = String comparator1 = (String) varibles[j + 3];
	 *            comparador 1 ejemplo: a comparator1 1 and a < 5
	 *
	 *            [4] = String comparator2 = (String) varibles[j + 4];
	 *            comparador 2 ejemplo: a comparador1>1 and a comparador2<5 (el
	 *            original: a > 1 and a < 5) *
	 * @param variablesBetweenDates
	 *            (en este caso solo para mysql) [0] = String variable =
	 *            (String) varibles[k]; el nombre de la variable que hace
	 *            referencia a una fecha
	 *
	 *            [1] = Object object1 = varibles[k + 2]; fecha 1 a
	 *            comparar(deben ser dates)
	 *
	 *            [2] = Object object2 = varibles[k + 3]; fecha 2 a
	 *            comparar(deben ser dates)
	 *
	 *            esto hace un between entre las dos fechas.
	 *
	 * @return lista con los objetos que se necesiten
	 * @throws Exception
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Labor> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<Labor> list = new ArrayList<Labor>();
		String where = new String();
		String tempWhere = new String();

		if (variables != null) {
			for (int i = 0; i < variables.length; i++) {
				if ((variables[i] != null) && (variables[i + 1] != null) && (variables[i + 2] != null)
						&& (variables[i + 3] != null)) {
					String variable = (String) variables[i];
					Boolean booVariable = (Boolean) variables[i + 1];
					Object value = variables[i + 2];
					String comparator = (String) variables[i + 3];

					if (booVariable.booleanValue()) {
						tempWhere = (tempWhere.length() == 0)
								? ("(model." + variable + " " + comparator + " \'" + value + "\' )")
								: (tempWhere + " AND (model." + variable + " " + comparator + " \'" + value + "\' )");
					} else {
						tempWhere = (tempWhere.length() == 0)
								? ("(model." + variable + " " + comparator + " " + value + " )")
								: (tempWhere + " AND (model." + variable + " " + comparator + " " + value + " )");
					}
				}

				i = i + 3;
			}
		}

		if (variablesBetween != null) {
			for (int j = 0; j < variablesBetween.length; j++) {
				if ((variablesBetween[j] != null) && (variablesBetween[j + 1] != null)
						&& (variablesBetween[j + 2] != null) && (variablesBetween[j + 3] != null)
						&& (variablesBetween[j + 4] != null)) {
					String variable = (String) variablesBetween[j];
					Object value = variablesBetween[j + 1];
					Object value2 = variablesBetween[j + 2];
					String comparator1 = (String) variablesBetween[j + 3];
					String comparator2 = (String) variablesBetween[j + 4];
					tempWhere = (tempWhere.length() == 0)
							? ("(" + value + " " + comparator1 + " " + variable + " and " + variable + " " + comparator2
									+ " " + value2 + " )")
							: (tempWhere + " AND (" + value + " " + comparator1 + " " + variable + " and " + variable
									+ " " + comparator2 + " " + value2 + " )");
				}

				j = j + 4;
			}
		}

		if (variablesBetweenDates != null) {
			for (int k = 0; k < variablesBetweenDates.length; k++) {
				if ((variablesBetweenDates[k] != null) && (variablesBetweenDates[k + 1] != null)
						&& (variablesBetweenDates[k + 2] != null)) {
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
							? ("(model." + variable + " between \'" + value + "\' and \'" + value2 + "\')")
							: (tempWhere + " AND (model." + variable + " between \'" + value + "\' and \'" + value2
									+ "\')");
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
			list = laborDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}



}
