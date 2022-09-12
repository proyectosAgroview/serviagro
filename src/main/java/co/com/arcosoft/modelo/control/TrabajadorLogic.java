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

import co.com.arcosoft.dataaccess.dao.IDatAnaLaboratorioDAO;
import co.com.arcosoft.dataaccess.dao.IDatAplicProductoDAO;
import co.com.arcosoft.dataaccess.dao.IDatHerramientaDAO;
import co.com.arcosoft.dataaccess.dao.IDatPlanLaborDAO;
import co.com.arcosoft.dataaccess.dao.IDatPlanillaNominaDAO;
import co.com.arcosoft.dataaccess.dao.IDatRiegoDAO;
import co.com.arcosoft.dataaccess.dao.IDatSanVegDAO;
import co.com.arcosoft.dataaccess.dao.IDatServicioDAO;
import co.com.arcosoft.dataaccess.dao.IEquipoDAO;
import co.com.arcosoft.dataaccess.dao.IEquipoTrabajoDAO;
import co.com.arcosoft.dataaccess.dao.INivel1DAO;
import co.com.arcosoft.dataaccess.dao.INivel2DAO;
import co.com.arcosoft.dataaccess.dao.INivel3DAO;
import co.com.arcosoft.dataaccess.dao.INivel4DAO;
import co.com.arcosoft.dataaccess.dao.ITarifaDeduccionDAO;
import co.com.arcosoft.dataaccess.dao.ITarifaOtrosDevengosDAO;
import co.com.arcosoft.dataaccess.dao.ITrabajadorDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatAnaLaboratorio;
import co.com.arcosoft.modelo.DatAplicProducto;
import co.com.arcosoft.modelo.DatHerramienta;
import co.com.arcosoft.modelo.DatPlanLabor;
import co.com.arcosoft.modelo.DatPlanillaNomina;
import co.com.arcosoft.modelo.DatRiego;
import co.com.arcosoft.modelo.DatSanVeg;
import co.com.arcosoft.modelo.DatServicio;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.EquipoTrabajo;
import co.com.arcosoft.modelo.Nivel1;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel3;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.TarifaDeduccion;
import co.com.arcosoft.modelo.TarifaOtrosDevengos;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.dto.TarifaDeduccionDTO;
import co.com.arcosoft.modelo.dto.TarifaOtrosDevengosDTO;
import co.com.arcosoft.modelo.dto.TrabajadorDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("TrabajadorLogic")
public class TrabajadorLogic implements ITrabajadorLogic {
	private static final Logger log = LoggerFactory.getLogger(TrabajadorLogic.class);

	/**
	 * DAO injected by Spring that manages Trabajador entities
	 *
	 */
	@Autowired
	private ITrabajadorDAO trabajadorDAO;

	/**
	 * DAO injected by Spring that manages DatAnaLaboratorio entities
	 *
	 */
	@Autowired
	private IDatAnaLaboratorioDAO datAnaLaboratorioDAO;

	/**
	 * DAO injected by Spring that manages DatAplicProducto entities
	 *
	 */
	@Autowired
	private IDatAplicProductoDAO datAplicProductoDAO;

	/**
	 * DAO injected by Spring that manages DatHerramienta entities
	 *
	 */
	@Autowired
	private IDatHerramientaDAO datHerramientaDAO;

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
	 * DAO injected by Spring that manages DatSanVeg entities
	 *
	 */
	@Autowired
	private IDatSanVegDAO datSanVegDAO;

	/**
	 * DAO injected by Spring that manages DatServicio entities
	 *
	 */
	@Autowired
	private IDatServicioDAO datServicioDAO;

	/**
	 * DAO injected by Spring that manages EquipoTrabajo entities
	 *
	 */
	@Autowired
	private IEquipoTrabajoDAO equipoTrabajoDAO;

	@Autowired
	private ITarifaDeduccionDAO tarifaDeduccionDAO;

	@Autowired
	private ITarifaOtrosDevengosDAO tarifaDevengosDAO;

	/**
	 * DAO injected by Spring that manages Equipo entities
	 *
	 */
	@Autowired
	private IEquipoDAO equipoDAO;

	/**
	 * DAO injected by Spring that manages Nivel1 entities
	 *
	 */
	@Autowired
	private INivel1DAO nivel1DAO;

	/**
	 * DAO injected by Spring that manages Nivel2 entities
	 *
	 */
	@Autowired
	private INivel2DAO nivel2DAO;

	/**
	 * DAO injected by Spring that manages Nivel3 entities
	 *
	 */
	@Autowired
	private INivel3DAO nivel3DAO;

	/**
	 * DAO injected by Spring that manages Nivel4 entities
	 *
	 */
	@Autowired
	private INivel4DAO nivel4DAO;

	/**
	 * Logic injected by Spring that manages CentCost entities
	 *
	 */
	@Autowired
	ICentCostLogic logicCentCost1;

	/**
	 * Logic injected by Spring that manages Contratista entities
	 *
	 */

	/**
	 * Logic injected by Spring that manages EquipoTrabajo entities
	 *
	 */
	@Autowired
	IEquipoTrabajoLogic logicEquipoTrabajo3;

	/**
	 * Logic injected by Spring that manages Profesion entities
	 *
	 */
	@Autowired
	IProfesionLogic logicProfesion4;

	@Override
	@Transactional(readOnly = true)
	public List<Trabajador> getTrabajador() throws Exception {
		log.debug("finding all Trabajador instances");

		List<Trabajador> list = new ArrayList<Trabajador>();

		try {
			list = trabajadorDAO.findAll();
		} catch (Exception e) {
			log.error("finding all Trabajador failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "Trabajador");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveTrabajador(Trabajador entity, List<TarifaDeduccionDTO> dataTarifaDeduccion,
			List<TarifaOtrosDevengosDTO> dataTarifaDevengos) throws Exception {
		log.debug("saving Trabajador instance");

		try {
			/*
			 * if (entity.getCentCost() == null) { throw new ZMessManager().new
			 * ForeignException("centCost"); }
			 */

			if (entity.getContratista() == null) {
				throw new ZMessManager().new ForeignException("contratista");
			}

			if (entity.getProfesion() == null) {
				throw new ZMessManager().new ForeignException("profesion");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getEmail() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEmail(), 40) == false)) {
				throw new ZMessManager().new NotValidFormatException("email");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getFoto() != null) && (Utilities.checkWordAndCheckWithlength(entity.getFoto(), 150) == false)) {
				throw new ZMessManager().new NotValidFormatException("foto");
			}

			if ((entity.getGenero() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getGenero(), 12) == false)) {
				throw new ZMessManager().new NotValidFormatException("genero");
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

			if ((entity.getPrimerApellido() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getPrimerApellido(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("primerApellido");
			}

			if ((entity.getPrimerNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getPrimerNombre(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("primerNombre");
			}

			if ((entity.getSegundoApellido() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getSegundoApellido(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("segundoApellido");
			}

			if ((entity.getSegundoNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getSegundoNombre(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("segundoNombre");
			}

			if ((entity.getTelefono() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getTelefono(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("telefono");
			}

			/*
			 * if (entity.getCentCost().getCentCostId() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "centCostId_CentCost"); }
			 */

//			if ((entity.getCentCost() != null) && (Utilities
//					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCentCost(), 18, 0) == false)) {
//				throw new ZMessManager().new NotValidFormatException("centCostId_CentCost");
//			}

			if ((entity.getCiudad() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCiudad(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("ciudadId_Ciudad");
			}

			if (entity.getContratista().getPersEmprId() == null) {
				throw new ZMessManager().new EmptyFieldException("contratistaId_Contratista");
			}

			if ((entity.getContratista().getPersEmprId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getContratista().getPersEmprId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("contratistaId_Contratista");
			}

			if (entity.getProfesion().getProfId() == null) {
				throw new ZMessManager().new EmptyFieldException("profId_Profesion");
			}

			if ((entity.getProfesion().getProfId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getProfesion().getProfId(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("profId_Profesion");
			}
			/*
			 * if (entity.getTrabId() == null) { throw new ZMessManager().new
			 * EmptyFieldException("trabId"); }
			 * 
			 * if ((entity.getTrabId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getTrabId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException("trabId"); }
			 * 
			 * if (getTrabajador(entity.getTrabId()) != null) { throw new
			 * ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */
			trabajadorDAO.save(entity);

			if (dataTarifaDeduccion != null) {

				for (TarifaDeduccionDTO valorDto : dataTarifaDeduccion) {

					if (valorDto.getDeduccionId() == null) {

						TarifaDeduccion valor = new TarifaDeduccion();

						valor.setCompania(valorDto.getCompania());
						valor.setConceptoNominaId(valorDto.getConceptoNominaId());
						valor.setFechaCreacion(valorDto.getFechaCreacion());
						valor.setFechaFinal(valorDto.getFechaFinal());
						valor.setFechaInicial(valorDto.getFechaInicial());
						valor.setFechaModificacion(valorDto.getFechaModificacion());
						valor.setValorDeduccion(valorDto.getValorDeduccion());
						valor.setEstado(valorDto.getEstado());

						valor.setTrabajador(entity);

						tarifaDeduccionDAO.save(valor);
					}

				}
			}

			if (dataTarifaDevengos != null) {

				for (TarifaOtrosDevengosDTO valorDto : dataTarifaDevengos) {

					if (valorDto.getOdevengosId() == null) {

						TarifaOtrosDevengos valor = new TarifaOtrosDevengos();

						valor.setCompania(valorDto.getCompania());
						valor.setConceptoNominaId(valorDto.getConceptoNominaId());
						valor.setFechaCreacion(valorDto.getFechaCreacion());
						valor.setFechaFinal(valorDto.getFechaFinal());
						valor.setFechaInicial(valorDto.getFechaInicial());
						valor.setFechaModificacion(valorDto.getFechaModificacion());
						valor.setValorDeduccion(valorDto.getValorDeduccion());
						valor.setEstado(valorDto.getEstado());
						valor.setCeptoNominaAlternativo(valorDto.getCeptoNominaAlternativo());
						valor.setGeneraAuxilioTransp(valorDto.getGeneraAuxilioTransp());
						valor.setGeneraDomingosFestivos(valorDto.getGeneraDomingosFestivos());
						valor.setGeneraAuxilioAdmon(valorDto.getGeneraAuxilioAdmon());
						valor.setHorasDia(valorDto.getHorasDia());
						valor.setHorasMes(valorDto.getHorasMes());
						valor.setTrabId(entity);
						tarifaDevengosDAO.save(valor);
					}

				}
			}

			log.debug("save Trabajador successful");
		} catch (Exception e) {
			log.error("save Trabajador failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteTrabajador(Trabajador entity) throws Exception {
		log.debug("deleting Trabajador instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Trabajador");
		}

		if (entity.getTrabId() == null) {
			throw new ZMessManager().new EmptyFieldException("trabId");
		}

		List<DatAnaLaboratorio> datAnaLaboratorios = null;
		List<DatAplicProducto> datAplicProductos = null;
		List<DatHerramienta> datHerramientas = null;
		List<DatPlanLabor> datPlanLabors = null;
		List<DatPlanillaNomina> datPlanillaNominas = null;
		List<DatRiego> datRiegos = null;
		List<DatSanVeg> datSanVegs = null;
		List<DatServicio> datServicios = null;
		List<EquipoTrabajo> equipoTrabajos = null;
		List<Equipo> equipos = null;
		List<Nivel1> nivel1s = null;
		List<Nivel2> nivel2s = null;
		List<Nivel3> nivel3s = null;
		List<Nivel4> nivel4s = null;
		List<TarifaDeduccion> tarifaDeduccions = null;
		List<TarifaOtrosDevengos> tarifaOtrosDevengoss = null;

		try {

			tarifaDeduccions = tarifaDeduccionDAO.findByProperty("trabajador.trabId", entity.getTrabId());

			if (Utilities.validationsList(tarifaDeduccions) == true) {
				throw new ZMessManager().new DeletingException("tarifaDeduccions");
			}

			tarifaOtrosDevengoss = tarifaDevengosDAO.findByProperty("trabajador.trabId", entity.getTrabId());

			if (Utilities.validationsList(tarifaOtrosDevengoss) == true) {
				throw new ZMessManager().new DeletingException("tarifaOtrosDevengoss");
			}

			datAnaLaboratorios = datAnaLaboratorioDAO.findByProperty("trabajador.trabId", entity.getTrabId());

			if (Utilities.validationsList(datAnaLaboratorios) == true) {
				throw new ZMessManager().new DeletingException("datAnaLaboratorios");
			}

			datAplicProductos = datAplicProductoDAO.findByProperty("trabajador.trabId", entity.getTrabId());

			if (Utilities.validationsList(datAplicProductos) == true) {
				throw new ZMessManager().new DeletingException("datAplicProductos");
			}

			datHerramientas = datHerramientaDAO.findByProperty("trabajador.trabId", entity.getTrabId());

			if (Utilities.validationsList(datHerramientas) == true) {
				throw new ZMessManager().new DeletingException("datHerramientas");
			}

			datPlanLabors = datPlanLaborDAO.findByProperty("trabajador.trabId", entity.getTrabId());

			if (Utilities.validationsList(datPlanLabors) == true) {
				throw new ZMessManager().new DeletingException("datPlanLabors");
			}

			datPlanillaNominas = datPlanillaNominaDAO.findByProperty("trabajador.trabId", entity.getTrabId());

			if (Utilities.validationsList(datPlanillaNominas) == true) {
				throw new ZMessManager().new DeletingException("datPlanillaNominas");
			}

			datRiegos = datRiegoDAO.findByProperty("trabajador.trabId", entity.getTrabId());

			if (Utilities.validationsList(datRiegos) == true) {
				throw new ZMessManager().new DeletingException("datRiegos");
			}

			datSanVegs = datSanVegDAO.findByProperty("trabajador.trabId", entity.getTrabId());

			if (Utilities.validationsList(datSanVegs) == true) {
				throw new ZMessManager().new DeletingException("datSanVegs");
			}

			datServicios = datServicioDAO.findByProperty("trabajador.trabId", entity.getTrabId());

			if (Utilities.validationsList(datServicios) == true) {
				throw new ZMessManager().new DeletingException("datServicios");
			}

			equipoTrabajos = equipoTrabajoDAO.findByProperty("trabajador.trabId", entity.getTrabId());

			if (Utilities.validationsList(equipoTrabajos) == true) {
				throw new ZMessManager().new DeletingException("equipoTrabajos");
			}

			equipos = equipoDAO.findByProperty("trabajador.trabId", entity.getTrabId());

			if (Utilities.validationsList(equipos) == true) {
				throw new ZMessManager().new DeletingException("equipos");
			}

			nivel1s = nivel1DAO.findByProperty("trabajador.trabId", entity.getTrabId());

			if (Utilities.validationsList(nivel1s) == true) {
				throw new ZMessManager().new DeletingException("nivel1s");
			}

			nivel2s = nivel2DAO.findByProperty("trabajador.trabId", entity.getTrabId());

			if (Utilities.validationsList(nivel2s) == true) {
				throw new ZMessManager().new DeletingException("nivel2s");
			}

			nivel3s = nivel3DAO.findByProperty("trabajador.trabId", entity.getTrabId());

			if (Utilities.validationsList(nivel3s) == true) {
				throw new ZMessManager().new DeletingException("nivel3s");
			}

			nivel4s = nivel4DAO.findByProperty("trabajador.trabId", entity.getTrabId());

			if (Utilities.validationsList(nivel4s) == true) {
				throw new ZMessManager().new DeletingException("nivel4s");
			}

			trabajadorDAO.delete(entity);

			log.debug("delete Trabajador successful");
		} catch (Exception e) {
			log.error("delete Trabajador failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateTrabajador(Trabajador entity, List<TarifaDeduccionDTO> dataTarifaDeduccion,
			List<TarifaOtrosDevengosDTO> dataTarifaDevengos) throws Exception {
		log.debug("updating Trabajador instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Trabajador");
			}
			/*
			 * if (entity.getCentCost() == null) { throw new ZMessManager().new
			 * ForeignException("centCost"); }
			 */

			if (entity.getContratista() == null) {
				throw new ZMessManager().new ForeignException("contratista");
			}

			if (entity.getProfesion() == null) {
				throw new ZMessManager().new ForeignException("profesion");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getEmail() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEmail(), 40) == false)) {
				throw new ZMessManager().new NotValidFormatException("email");
			}

			if ((entity.getDireccion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getDireccion(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("direccion");
			}

			if ((entity.getnIdentificacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getnIdentificacion(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("nIdentificacion");
			}

			if ((entity.getEstadoCivil() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstadoCivil(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("estadoCivil");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getFoto() != null) && (Utilities.checkWordAndCheckWithlength(entity.getFoto(), 150) == false)) {
				throw new ZMessManager().new NotValidFormatException("foto");
			}

			if ((entity.getGenero() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getGenero(), 12) == false)) {
				throw new ZMessManager().new NotValidFormatException("genero");
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

			if ((entity.getPrimerApellido() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getPrimerApellido(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("primerApellido");
			}

			if ((entity.getPrimerNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getPrimerNombre(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("primerNombre");
			}

			if ((entity.getSegundoApellido() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getSegundoApellido(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("segundoApellido");
			}

			if ((entity.getSegundoNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getSegundoNombre(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("segundoNombre");
			}

			if ((entity.getTelefono() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getTelefono(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("telefono");
			}

			if (entity.getTrabId() == null) {
				throw new ZMessManager().new EmptyFieldException("trabId");
			}

			if ((entity.getTrabId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTrabId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("trabId");
			}

			/*
			 * if (entity.getCentCost().getCentCostId() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "centCostId_CentCost"); }
			 */

//			if ((entity.getCentCost() != null) && (Utilities
//					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCentCost(), 18, 0) == false)) {
//				throw new ZMessManager().new NotValidFormatException("centCostId_CentCost");
//			}

			if ((entity.getCiudad() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCiudad(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("ciudadId_Ciudad");
			}

			if (entity.getContratista().getPersEmprId() == null) {
				throw new ZMessManager().new EmptyFieldException("contratistaId_Contratista");
			}

			if ((entity.getContratista().getPersEmprId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getContratista().getPersEmprId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("contratistaId_Contratista");
			}

			if (entity.getProfesion().getProfId() == null) {
				throw new ZMessManager().new EmptyFieldException("profId_Profesion");
			}

			if ((entity.getProfesion().getProfId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getProfesion().getProfId(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("profId_Profesion");
			}

			trabajadorDAO.update(entity);
			if (dataTarifaDeduccion != null) {

				for (TarifaDeduccionDTO valorDto : dataTarifaDeduccion) {

					if (valorDto.getDeduccionId() == null) {

						TarifaDeduccion valor = new TarifaDeduccion();

						valor.setCompania(valorDto.getCompania());
						valor.setConceptoNominaId(valorDto.getConceptoNominaId());
						valor.setFechaCreacion(valorDto.getFechaCreacion());
						valor.setFechaFinal(valorDto.getFechaFinal());
						valor.setFechaInicial(valorDto.getFechaInicial());
						valor.setFechaModificacion(valorDto.getFechaModificacion());
						valor.setValorDeduccion(valorDto.getValorDeduccion());
						valor.setEstado(valorDto.getEstado());

						valor.setTrabajador(entity);

						tarifaDeduccionDAO.save(valor);
					} else {
						TarifaDeduccion valor = tarifaDeduccionDAO.findById(valorDto.getDeduccionId());

						valor.setCompania(valorDto.getCompania());
						valor.setConceptoNominaId(valorDto.getConceptoNominaId());
						valor.setFechaCreacion(valorDto.getFechaCreacion());
						valor.setFechaFinal(valorDto.getFechaFinal());
						valor.setFechaInicial(valorDto.getFechaInicial());
						valor.setFechaModificacion(valorDto.getFechaModificacion());
						valor.setValorDeduccion(valorDto.getValorDeduccion());
						valor.setEstado(valorDto.getEstado());
						valor.setTrabajador(entity);
						tarifaDeduccionDAO.update(valor);
					}

				}
			}
			if (dataTarifaDevengos != null) {

				for (TarifaOtrosDevengosDTO valorDto : dataTarifaDevengos) {

					if (valorDto.getOdevengosId() == null) {

						TarifaOtrosDevengos valor = new TarifaOtrosDevengos();

						valor.setCompania(valorDto.getCompania());
						valor.setConceptoNominaId(valorDto.getConceptoNominaId());
						valor.setFechaCreacion(valorDto.getFechaCreacion());
						valor.setFechaFinal(valorDto.getFechaFinal());
						valor.setFechaInicial(valorDto.getFechaInicial());
						valor.setFechaModificacion(valorDto.getFechaModificacion());
						valor.setValorDeduccion(valorDto.getValorDeduccion());
						valor.setEstado(valorDto.getEstado());
						valor.setCeptoNominaAlternativo(valorDto.getCeptoNominaAlternativo());
						valor.setGeneraAuxilioTransp(valorDto.getGeneraAuxilioTransp());
						valor.setGeneraDomingosFestivos(valorDto.getGeneraDomingosFestivos());
						valor.setGeneraAuxilioAdmon(valorDto.getGeneraAuxilioAdmon());
						valor.setHorasDia(valorDto.getHorasDia());
						valor.setHorasMes(valorDto.getHorasMes());
						valor.setTrabId(entity);

						tarifaDevengosDAO.save(valor);
					} else {
						TarifaOtrosDevengos valor = tarifaDevengosDAO.findById(valorDto.getOdevengosId());

						valor.setCompania(valorDto.getCompania());
						valor.setConceptoNominaId(valorDto.getConceptoNominaId());
						valor.setFechaCreacion(valorDto.getFechaCreacion());
						valor.setFechaFinal(valorDto.getFechaFinal());
						valor.setFechaInicial(valorDto.getFechaInicial());
						valor.setFechaModificacion(valorDto.getFechaModificacion());
						valor.setValorDeduccion(valorDto.getValorDeduccion());
						valor.setEstado(valorDto.getEstado());
						valor.setCeptoNominaAlternativo(valorDto.getCeptoNominaAlternativo());
						valor.setGeneraAuxilioTransp(valorDto.getGeneraAuxilioTransp());
						valor.setGeneraDomingosFestivos(valorDto.getGeneraDomingosFestivos());
						valor.setGeneraAuxilioAdmon(valorDto.getGeneraAuxilioAdmon());
						valor.setHorasDia(valorDto.getHorasDia());
						valor.setHorasMes(valorDto.getHorasMes());
						valor.setTrabId(entity);

						tarifaDevengosDAO.update(valor);
					}
				}
			}

			log.debug("update Trabajador successful");
		} catch (Exception e) {
			log.error("update Trabajador failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<TrabajadorDTO> getDataTrabajador() throws Exception {
		try {
			List<Trabajador> trabajador = trabajadorDAO.findAll();

			List<TrabajadorDTO> trabajadorDTO = new ArrayList<TrabajadorDTO>();

			for (Trabajador trabajadorTmp : trabajador) {
				TrabajadorDTO trabajadorDTO2 = new TrabajadorDTO();

				trabajadorDTO2.setTrabId(trabajadorTmp.getTrabId());
				trabajadorDTO2.setCodigo((trabajadorTmp.getCodigo() != null) ? trabajadorTmp.getCodigo() : null);
				trabajadorDTO2.setCompania((trabajadorTmp.getCompania() != null) ? trabajadorTmp.getCompania() : null);
				trabajadorDTO2.setEmail((trabajadorTmp.getEmail() != null) ? trabajadorTmp.getEmail() : null);
				trabajadorDTO2.setEstado((trabajadorTmp.getEstado() != null) ? trabajadorTmp.getEstado() : null);
				trabajadorDTO2.setFechaAdmision(trabajadorTmp.getFechaAdmision());
				trabajadorDTO2.setFechaCreacion(trabajadorTmp.getFechaCreacion());
				trabajadorDTO2.setFechaModificacion(trabajadorTmp.getFechaModificacion());
				trabajadorDTO2.setFechaNacimiento(trabajadorTmp.getFechaNacimiento());
				trabajadorDTO2.setFoto((trabajadorTmp.getFoto() != null && !trabajadorTmp.getFoto().equals(""))
						? trabajadorTmp.getFoto() : "default.jpg");
				trabajadorDTO2.setGenero((trabajadorTmp.getGenero() != null) ? trabajadorTmp.getGenero() : null);
				trabajadorDTO2.setInfoAdicional(
						(trabajadorTmp.getInfoAdicional() != null) ? trabajadorTmp.getInfoAdicional() : null);
				trabajadorDTO2.setInfoAdicional2(
						(trabajadorTmp.getInfoAdicional2() != null) ? trabajadorTmp.getInfoAdicional2() : null);
				trabajadorDTO2.setNombre((trabajadorTmp.getNombre() != null) ? trabajadorTmp.getNombre() : null);
				trabajadorDTO2.setPrimerApellido(
						(trabajadorTmp.getPrimerApellido() != null) ? trabajadorTmp.getPrimerApellido() : null);
				trabajadorDTO2.setPrimerNombre(
						(trabajadorTmp.getPrimerNombre() != null) ? trabajadorTmp.getPrimerNombre() : null);
				trabajadorDTO2.setSegundoApellido(
						(trabajadorTmp.getSegundoApellido() != null) ? trabajadorTmp.getSegundoApellido() : null);
				trabajadorDTO2.setSegundoNombre(
						(trabajadorTmp.getSegundoNombre() != null) ? trabajadorTmp.getSegundoNombre() : null);
				trabajadorDTO2.setTelefono((trabajadorTmp.getTelefono() != null) ? trabajadorTmp.getTelefono() : null);
				trabajadorDTO2.setNIdentificacion(
						(trabajadorTmp.getnIdentificacion() != null) ? trabajadorTmp.getnIdentificacion() : null);
				trabajadorDTO2.setEstadoCivil(
						(trabajadorTmp.getEstadoCivil() != null) ? trabajadorTmp.getEstadoCivil() : null);
				trabajadorDTO2
						.setDireccion((trabajadorTmp.getDireccion() != null) ? trabajadorTmp.getDireccion() : null);
				if (trabajadorTmp.getCentCost() != null) {
					trabajadorDTO2.setCentCostId_CentCost(trabajadorTmp.getProfesion().getProfId());
				} else {
					trabajadorDTO2.setCentCostId_CentCost(null);
				}

				trabajadorDTO2
						.setCiudadId_Ciudad((trabajadorTmp.getCiudad() != null) ? trabajadorTmp.getCiudad() : null);
				if (trabajadorTmp.getContratista() != null) {
					trabajadorDTO2.setContratistaId_Contratista(trabajadorTmp.getContratista().getPersEmprId());
				} else {
					trabajadorDTO2.setContratistaId_Contratista(null);
				}
				
				if (trabajadorTmp.getEquipoTrabajo() != null) {
					trabajadorDTO2.setEqpTrabId_EquipoTrabajo(trabajadorTmp.getEquipoTrabajo().getEqpTrabId());
				} else {
					trabajadorDTO2.setEqpTrabId_EquipoTrabajo(null);
				}

				if (trabajadorTmp.getProfesion() != null) {
					trabajadorDTO2.setProfId_Profesion(trabajadorTmp.getProfesion().getProfId());
				} else {
					trabajadorDTO2.setProfId_Profesion(null);
				}
				
				trabajadorDTO2.setOrigenDatos((trabajadorTmp.getOrigenDatos() != null) ? trabajadorTmp.getOrigenDatos() : null);				

				if (trabajadorTmp.getBarrio() != null) {
					trabajadorDTO2.setBarrio(trabajadorTmp.getBarrio());
				} else {
					trabajadorDTO2.setBarrio(null);
				}
				
				if (trabajadorTmp.getTipo_vivienda() != null) {
					trabajadorDTO2.setTipo_vivienda(trabajadorTmp.getTipo_vivienda());
				} else {
					trabajadorDTO2.setTipo_vivienda(null);
				}
				
				if (trabajadorTmp.getCelular() != null) {
					trabajadorDTO2.setCelular(trabajadorTmp.getCelular());
				} else {
					trabajadorDTO2.setCelular(null);
				}
				if (trabajadorTmp.getTipo_licencia_conduccion() != null) {
					trabajadorDTO2.setTipo_licencia_conduccion(trabajadorTmp.getTipo_licencia_conduccion());
				} else {
					trabajadorDTO2.setTipo_licencia_conduccion(null);
				}
				if (trabajadorTmp.getNumero_licencia_conduccion() != null) {
					trabajadorDTO2.setNumero_licencia_conduccion(trabajadorTmp.getNumero_licencia_conduccion());
				} else {
					trabajadorDTO2.setNumero_licencia_conduccion(null);
				}
				if (trabajadorTmp.getNum_pasado_judicial() != null) {
					trabajadorDTO2.setNum_pasado_judicial(trabajadorTmp.getNum_pasado_judicial());
				} else {
					trabajadorDTO2.setNum_pasado_judicial(null);
				}
				if (trabajadorTmp.getNum_tarjeta_profesional() != null) {
					trabajadorDTO2.setNum_tarjeta_profesional(trabajadorTmp.getNum_tarjeta_profesional());
				} else {
					trabajadorDTO2.setNum_tarjeta_profesional(null);
				}
				if (trabajadorTmp.getTipo_sangre() != null) {
					trabajadorDTO2.setTipo_sangre(trabajadorTmp.getTipo_sangre());
				} else {
					trabajadorDTO2.setTipo_sangre(null);
				}
				if (trabajadorTmp.getNombre_eps() != null) {
					trabajadorDTO2.setNombre_eps(trabajadorTmp.getNombre_eps());
				} else {
					trabajadorDTO2.setNombre_eps(null);
				}
				if (trabajadorTmp.getNombre_fondo_pension() != null) {
					trabajadorDTO2.setNombre_fondo_pension(trabajadorTmp.getNombre_fondo_pension());
				} else {
					trabajadorDTO2.setNombre_fondo_pension(null);
				}
				if (trabajadorTmp.getNombre_fondo_cesantias() != null) {
					trabajadorDTO2.setNombre_fondo_cesantias(trabajadorTmp.getNombre_fondo_cesantias());
				} else {
					trabajadorDTO2.setNombre_fondo_cesantias(null);
				}
				if (trabajadorTmp.getNombre_arp() != null) {
					trabajadorDTO2.setNombre_arp(trabajadorTmp.getNombre_arp());
				} else {
					trabajadorDTO2.setNombre_arp(null);
				}
				if (trabajadorTmp.getNombre_caja_compensacion() != null) {
					trabajadorDTO2.setNombre_caja_compensacion(trabajadorTmp.getNombre_caja_compensacion());
				} else {
					trabajadorDTO2.setNombre_caja_compensacion(null);
				}
				if (trabajadorTmp.getNumero_cuenta_bancaria() != null) {
					trabajadorDTO2.setNumero_cuenta_bancaria(trabajadorTmp.getNumero_cuenta_bancaria());
				} else {
					trabajadorDTO2.setNumero_cuenta_bancaria(null);
				}
				if (trabajadorTmp.getEnt_banc_id() != null) {
					trabajadorDTO2.setEnt_banc_id(trabajadorTmp.getEnt_banc_id());
				} else {
					trabajadorDTO2.setEnt_banc_id(null);
				}
				if (trabajadorTmp.getTipo_cuenta_bancaria() != null) {
					trabajadorDTO2.setTipo_cuenta_bancaria(trabajadorTmp.getTipo_cuenta_bancaria());
				} else {
					trabajadorDTO2.setTipo_cuenta_bancaria(null);
				}
				if (trabajadorTmp.getNombres_conyugue() != null) {
					trabajadorDTO2.setNombres_conyugue(trabajadorTmp.getNombres_conyugue());
				} else {
					trabajadorDTO2.setNombres_conyugue(null);
				}
				if (trabajadorTmp.getNumero_hijos() != null) {
					trabajadorDTO2.setNumero_hijos(trabajadorTmp.getNumero_hijos());
				} else {
					trabajadorDTO2.setNumero_hijos(null);
				}
				if (trabajadorTmp.getContacto_emergencia() != null) {
					trabajadorDTO2.setContacto_emergencia(trabajadorTmp.getContacto_emergencia());
				} else {
					trabajadorDTO2.setContacto_emergencia(null);
				}
				if (trabajadorTmp.getContacto_emergencia_parentesco() != null) {
					trabajadorDTO2.setContacto_emergencia_parentesco(trabajadorTmp.getContacto_emergencia_parentesco());
				} else {
					trabajadorDTO2.setContacto_emergencia_parentesco(null);
				}
				if (trabajadorTmp.getEstudio_bachillerato() != null) {
					trabajadorDTO2.setEstudio_bachillerato(trabajadorTmp.getEstudio_bachillerato());
				} else {
					trabajadorDTO2.setEstudio_bachillerato(null);
				}
				if (trabajadorTmp.getEstudio_bachillerato_entidad() != null) {
					trabajadorDTO2.setEstudio_bachillerato_entidad(trabajadorTmp.getEstudio_bachillerato_entidad());
				} else {
					trabajadorDTO2.setEstudio_bachillerato_entidad(null);
				}
				if (trabajadorTmp.getEstudio_tecnico() != null) {
					trabajadorDTO2.setEstudio_tecnico(trabajadorTmp.getEstudio_tecnico());
				} else {
					trabajadorDTO2.setEstudio_tecnico(null);
				}
				if (trabajadorTmp.getEstudio_tecnico_titulo() != null) {
					trabajadorDTO2.setEstudio_tecnico_titulo(trabajadorTmp.getEstudio_tecnico_titulo());
				} else {
					trabajadorDTO2.setEstudio_tecnico_titulo(null);
				}
				if (trabajadorTmp.getEstudio_tecnico_entidad() != null) {
					trabajadorDTO2.setEstudio_tecnico_entidad(trabajadorTmp.getEstudio_tecnico_entidad());
				} else {
					trabajadorDTO2.setEstudio_tecnico_entidad(null);
				}
				if (trabajadorTmp.getEstudio_tecnologico() != null) {
					trabajadorDTO2.setEstudio_tecnologico(trabajadorTmp.getEstudio_tecnologico());
				} else {
					trabajadorDTO2.setEstudio_tecnologico(null);
				}
				if (trabajadorTmp.getEstudio_tecnologico_titulo() != null) {
					trabajadorDTO2.setEstudio_tecnologico_titulo(trabajadorTmp.getEstudio_tecnologico_titulo());
				} else {
					trabajadorDTO2.setEstudio_tecnologico_titulo(null);
				}
				if (trabajadorTmp.getEstudio_tecnologico_entidad() != null) {
					trabajadorDTO2.setEstudio_tecnologico_entidad(trabajadorTmp.getEstudio_tecnologico_entidad());
				} else {
					trabajadorDTO2.setEstudio_tecnologico_entidad(null);
				}
				if (trabajadorTmp.getEstudio_pregrado() != null) {
					trabajadorDTO2.setEstudio_pregrado(trabajadorTmp.getEstudio_pregrado());
				} else {
					trabajadorDTO2.setEstudio_pregrado(null);
				}
				if (trabajadorTmp.getEstudio_pregrado_titulo() != null) {
					trabajadorDTO2.setEstudio_pregrado_titulo(trabajadorTmp.getEstudio_pregrado_titulo());
				} else {
					trabajadorDTO2.setEstudio_pregrado_titulo(null);
				}
				if (trabajadorTmp.getEstudio_pregrado_entidad() != null) {
					trabajadorDTO2.setEstudio_pregrado_entidad(trabajadorTmp.getEstudio_pregrado_entidad());
				} else {
					trabajadorDTO2.setEstudio_pregrado_entidad(null);
				}
				if (trabajadorTmp.getEstudio_potsgrado() != null) {
					trabajadorDTO2.setEstudio_potsgrado(trabajadorTmp.getEstudio_potsgrado());
				} else {
					trabajadorDTO2.setEstudio_potsgrado(null);
				}
				if (trabajadorTmp.getEstudio_potsgrado_titulo() != null) {
					trabajadorDTO2.setEstudio_potsgrado_titulo(trabajadorTmp.getEstudio_potsgrado_titulo());
				} else {
					trabajadorDTO2.setEstudio_potsgrado_titulo(null);
				}
				if (trabajadorTmp.getEstudio_potsgrado_entidad() != null) {
					trabajadorDTO2.setEstudio_potsgrado_entidad(trabajadorTmp.getEstudio_potsgrado_entidad());
				} else {
					trabajadorDTO2.setEstudio_potsgrado_entidad(null);
				}
				if (trabajadorTmp.getEstudio_otros() != null) {
					trabajadorDTO2.setEstudio_otros(trabajadorTmp.getEstudio_otros());
				} else {
					trabajadorDTO2.setEstudio_otros(null);
				}
				if (trabajadorTmp.getEstudio_otros_titulo() != null) {
					trabajadorDTO2.setEstudio_otros_titulo(trabajadorTmp.getEstudio_otros_titulo());
				} else {
					trabajadorDTO2.setEstudio_otros_titulo(null);
				}
				if (trabajadorTmp.getEstudio_otros_entidad() != null) {
					trabajadorDTO2.setEstudio_otros_entidad(trabajadorTmp.getEstudio_otros_entidad());
				} else {
					trabajadorDTO2.setEstudio_otros_entidad(null);
				}
				if (trabajadorTmp.getPecargo1_nombre() != null) {
					trabajadorDTO2.setPecargo1_nombre(trabajadorTmp.getPecargo1_nombre());
				} else {
					trabajadorDTO2.setPecargo1_nombre(null);
				}
				if (trabajadorTmp.getPecargo1_parentesco() != null) {
					trabajadorDTO2.setPecargo1_parentesco(trabajadorTmp.getPecargo1_parentesco());
				} else {
					trabajadorDTO2.setPecargo1_parentesco(null);
				}
				if (trabajadorTmp.getPecargo1_edad() != null) {
					trabajadorDTO2.setPecargo1_edad(trabajadorTmp.getPecargo1_edad());
				} else {
					trabajadorDTO2.setPecargo1_edad(null);
				}
				if (trabajadorTmp.getPecargo1_niveleducativo() != null) {
					trabajadorDTO2.setPecargo1_niveleducativo(trabajadorTmp.getPecargo1_niveleducativo());
				} else {
					trabajadorDTO2.setPecargo1_niveleducativo(null);
				}
				if (trabajadorTmp.getPecargo2_nombre() != null) {
					trabajadorDTO2.setPecargo2_nombre(trabajadorTmp.getPecargo2_nombre());
				} else {
					trabajadorDTO2.setPecargo2_nombre(null);
				}
				if (trabajadorTmp.getPecargo2_parentesco() != null) {
					trabajadorDTO2.setPecargo2_parentesco(trabajadorTmp.getPecargo2_parentesco());
				} else {
					trabajadorDTO2.setPecargo2_parentesco(null);
				}
				if (trabajadorTmp.getPecargo2_edad() != null) {
					trabajadorDTO2.setPecargo2_edad(trabajadorTmp.getPecargo2_edad());
				} else {
					trabajadorDTO2.setPecargo2_edad(null);
				}
				if (trabajadorTmp.getPecargo2_niveleducativo() != null) {
					trabajadorDTO2.setPecargo2_niveleducativo(trabajadorTmp.getPecargo2_niveleducativo());
				} else {
					trabajadorDTO2.setPecargo2_niveleducativo(null);
				}
				if (trabajadorTmp.getPecargo3_nombre() != null) {
					trabajadorDTO2.setPecargo3_nombre(trabajadorTmp.getPecargo3_nombre());
				} else {
					trabajadorDTO2.setPecargo3_nombre(null);
				}
				if (trabajadorTmp.getPecargo3_parentesco() != null) {
					trabajadorDTO2.setPecargo3_parentesco(trabajadorTmp.getPecargo3_parentesco());
				} else {
					trabajadorDTO2.setPecargo3_parentesco(null);
				}
				if (trabajadorTmp.getPecargo3_edad() != null) {
					trabajadorDTO2.setPecargo3_edad(trabajadorTmp.getPecargo3_edad());
				} else {
					trabajadorDTO2.setPecargo3_edad(null);
				}
				if (trabajadorTmp.getPecargo3_niveleducativo() != null) {
					trabajadorDTO2.setPecargo3_niveleducativo(trabajadorTmp.getPecargo3_niveleducativo());
				} else {
					trabajadorDTO2.setPecargo3_niveleducativo(null);
				}
				if (trabajadorTmp.getPecargo4_nombre() != null) {
					trabajadorDTO2.setPecargo4_nombre(trabajadorTmp.getPecargo4_nombre());
				} else {
					trabajadorDTO2.setPecargo4_nombre(null);
				}
				if (trabajadorTmp.getPecargo4_parentesco() != null) {
					trabajadorDTO2.setPecargo4_parentesco(trabajadorTmp.getPecargo4_parentesco());
				} else {
					trabajadorDTO2.setPecargo4_parentesco(null);
				}
				if (trabajadorTmp.getPecargo4_edad() != null) {
					trabajadorDTO2.setPecargo4_edad(trabajadorTmp.getPecargo4_edad());
				} else {
					trabajadorDTO2.setPecargo4_edad(null);
				}
				if (trabajadorTmp.getPecargo4_niveleducativo() != null) {
					trabajadorDTO2.setPecargo4_niveleducativo(trabajadorTmp.getPecargo4_niveleducativo());
				} else {
					trabajadorDTO2.setPecargo4_niveleducativo(null);
				}
				if (trabajadorTmp.getPecargo5_nombre() != null) {
					trabajadorDTO2.setPecargo5_nombre(trabajadorTmp.getPecargo5_nombre());
				} else {
					trabajadorDTO2.setPecargo5_nombre(null);
				}
				if (trabajadorTmp.getPecargo5_parentesco() != null) {
					trabajadorDTO2.setPecargo5_parentesco(trabajadorTmp.getPecargo5_parentesco());
				} else {
					trabajadorDTO2.setPecargo5_parentesco(null);
				}
				if (trabajadorTmp.getPecargo5_edad() != null) {
					trabajadorDTO2.setPecargo5_edad(trabajadorTmp.getPecargo5_edad());
				} else {
					trabajadorDTO2.setPecargo5_edad(null);
				}
				if (trabajadorTmp.getPecargo5_niveleducativo() != null) {
					trabajadorDTO2.setPecargo5_niveleducativo(trabajadorTmp.getPecargo5_niveleducativo());
				} else {
					trabajadorDTO2.setPecargo5_niveleducativo(null);
				}				

				if (trabajadorTmp.getTipo_trabajador() != null) {
					trabajadorDTO2.setTipo_trabajador(trabajadorTmp.getTipo_trabajador());
				} else {
					trabajadorDTO2.setTipo_trabajador(null);
				}
				
				trabajadorDTO2.setTipoCotizante((trabajadorTmp.getTipoCotizante() != null) ? 
						trabajadorTmp.getTipoCotizante().getTipoCotizanteId() : null);
				
				trabajadorDTO2.setAportaEps((trabajadorTmp.getAportaEps() != null) ? trabajadorTmp.getAportaEps() : null);
				
				trabajadorDTO2.setEmpleadorAportaEps((trabajadorTmp.getEmpleadorAportaEps() != null) ? 
						trabajadorTmp.getEmpleadorAportaEps() : null);
				
				trabajadorDTO2.setEpsActual((trabajadorTmp.getEpsActual() != null) ? 
						trabajadorTmp.getEpsActual().getPersEmprId() : null);
				
				trabajadorDTO2.setFechaInicioEps((trabajadorTmp.getFechaInicioEps() != null) ? 
						trabajadorTmp.getFechaInicioEps() : null);
				
				trabajadorDTO2.setEpsAnterior((trabajadorTmp.getEpsAnterior() != null) ? 
						trabajadorTmp.getEpsAnterior().getPersEmprId() : null);
				
				trabajadorDTO2.setSubTipoCotizante((trabajadorTmp.getSubTipoCotizante() != null) ? 
						trabajadorTmp.getSubTipoCotizante().getSubTipoCotizanteId() : null);
				
				trabajadorDTO2.setAportaAfp((trabajadorTmp.getAportaAfp() != null) ? trabajadorTmp.getAportaAfp() : null);
				
				trabajadorDTO2.setAfpActual((trabajadorTmp.getAfpActual() != null) ? 
						trabajadorTmp.getAfpActual().getPersEmprId() : null);
				
				trabajadorDTO2.setFechaInicioAfp((trabajadorTmp.getFechaInicioAfp() != null) ? 
						trabajadorTmp.getFechaInicioAfp() : null);
				
				trabajadorDTO2.setAfpAnterior((trabajadorTmp.getAfpAnterior() != null) ? 
						trabajadorTmp.getAfpAnterior().getPersEmprId() : null);
				
				trabajadorDTO2.setAportaCcf((trabajadorTmp.getAportaCcf() != null) ? trabajadorTmp.getAportaCcf() : null);
				trabajadorDTO2.setAportaArl((trabajadorTmp.getAportaArl() != null) ? trabajadorTmp.getAportaArl() : null);
				trabajadorDTO2.setAportaIcbf((trabajadorTmp.getAportaIcbf() != null) ? trabajadorTmp.getAportaIcbf() : null);
				trabajadorDTO2.setAportaSena((trabajadorTmp.getAportaSena() != null) ? trabajadorTmp.getAportaSena() : null);
				trabajadorDTO2.setAltoRiesgo((trabajadorTmp.getAltoRiesgo() != null) ? trabajadorTmp.getAltoRiesgo() : null);

				trabajadorDTO2.setTarifaCajaCompensacion((trabajadorTmp.getTarifaCajaCompensacion() != null) ? 
						trabajadorTmp.getTarifaCajaCompensacion() : null);
				
				trabajadorDTO2.setClaseTarifaArl((trabajadorTmp.getClaseTarifaArl() != null) ? 
						trabajadorTmp.getClaseTarifaArl() : null);
				
				trabajadorDTO2.setTarifaArl((trabajadorTmp.getTarifaArl() != null) ? trabajadorTmp.getTarifaArl() : null);
				trabajadorDTO2.setTarifaIcbf((trabajadorTmp.getTarifaIcbf() != null) ? trabajadorTmp.getTarifaIcbf() : null);
				trabajadorDTO2.setTarifaSena((trabajadorTmp.getTarifaSena() != null) ? trabajadorTmp.getTarifaSena() : null);
				
				trabajadorDTO2.setCajaCompensacion((trabajadorTmp.getCajaCompensacion() != null) ? 
						trabajadorTmp.getCajaCompensacion().getPersEmprId() : null);
				
				trabajadorDTO2.setArl((trabajadorTmp.getArl() != null) ? trabajadorTmp.getArl().getPersEmprId() : null);
				
				trabajadorDTO2.setFondoCesantias((trabajadorTmp.getFondoCesantias() != null) ? 
						trabajadorTmp.getFondoCesantias().getPersEmprId() : null);
	
				
				if (trabajadorTmp.getTarifasArlId() != null) {
					trabajadorDTO2.setTarifasArlId(trabajadorTmp.getTarifasArlId());
				} else {
					trabajadorDTO2.setTarifasArlId(null);
				}
				
				trabajadorDTO.add(trabajadorDTO2);
			}

			return trabajadorDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Trabajador getTrabajador(Long trabId) throws Exception {
		log.debug("getting Trabajador instance");

		Trabajador entity = null;

		try {
			entity = trabajadorDAO.findById(trabId);
		} catch (Exception e) {
			log.error("get Trabajador failed", e);
			throw new ZMessManager().new FindingException("Trabajador");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Trabajador> findPageTrabajador(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<Trabajador> entity = null;

		try {
			entity = trabajadorDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Trabajador Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberTrabajador() throws Exception {
		Long entity = null;

		try {
			entity = trabajadorDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Trabajador Count");
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
	public List<Trabajador> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<Trabajador> list = new ArrayList<Trabajador>();
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
			list = trabajadorDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@SuppressWarnings("rawtypes")
	@Override
	@Transactional(readOnly = true)
	public List<TrabajadorDTO> findByCriteriaPageTrabajador(int startRow, int pageSize, String sortField,
			boolean sortOrder, Map<String, Object> filters, String modulo) throws Exception {
		try {
			List<Trabajador> entity = null;

			String whereCondition = new String();
			Iterator it = filters.entrySet().iterator();

			while (it.hasNext()) {
				Map.Entry e = (Map.Entry) it.next();
				whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(" + e.getKey() + ")"
						+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";
			}
			whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "origenDatos=" + "'" + modulo + "'";

			entity = trabajadorDAO.findByCriteriaPage(whereCondition, sortField, sortOrder, startRow, pageSize);

			List<TrabajadorDTO> trabajadorDTO = new ArrayList<TrabajadorDTO>();

			for (Trabajador trabajadorTmp : entity) {
				TrabajadorDTO trabajadorDTO2 = new TrabajadorDTO();

				trabajadorDTO2.setTrabId(trabajadorTmp.getTrabId());
				trabajadorDTO2.setCodigo((trabajadorTmp.getCodigo() != null) ? trabajadorTmp.getCodigo() : null);
				trabajadorDTO2.setCompania((trabajadorTmp.getCompania() != null) ? trabajadorTmp.getCompania() : null);
				trabajadorDTO2.setEmail((trabajadorTmp.getEmail() != null) ? trabajadorTmp.getEmail() : null);
				trabajadorDTO2.setEstado((trabajadorTmp.getEstado() != null) ? trabajadorTmp.getEstado() : null);
				trabajadorDTO2.setFechaAdmision(trabajadorTmp.getFechaAdmision());
				trabajadorDTO2.setFechaCreacion(trabajadorTmp.getFechaCreacion());
				trabajadorDTO2.setFechaModificacion(trabajadorTmp.getFechaModificacion());
				trabajadorDTO2.setClaseContrato(trabajadorTmp.getClaseContrato());
				trabajadorDTO2.setFechaNacimiento(trabajadorTmp.getFechaNacimiento());
				trabajadorDTO2.setFoto((trabajadorTmp.getFoto() != null && !trabajadorTmp.getFoto().equals(""))
						? trabajadorTmp.getFoto() : "default.jpg");
				trabajadorDTO2.setGenero((trabajadorTmp.getGenero() != null) ? trabajadorTmp.getGenero() : null);
				trabajadorDTO2.setInfoAdicional(
						(trabajadorTmp.getInfoAdicional() != null) ? trabajadorTmp.getInfoAdicional() : null);
				trabajadorDTO2.setInfoAdicional2(
						(trabajadorTmp.getInfoAdicional2() != null) ? trabajadorTmp.getInfoAdicional2() : null);
				trabajadorDTO2.setNombre((trabajadorTmp.getNombre() != null) ? trabajadorTmp.getNombre() : null);
				trabajadorDTO2.setPrimerApellido(
						(trabajadorTmp.getPrimerApellido() != null) ? trabajadorTmp.getPrimerApellido() : null);
				trabajadorDTO2.setPrimerNombre(
						(trabajadorTmp.getPrimerNombre() != null) ? trabajadorTmp.getPrimerNombre() : null);
				trabajadorDTO2.setSegundoApellido(
						(trabajadorTmp.getSegundoApellido() != null) ? trabajadorTmp.getSegundoApellido() : null);
				trabajadorDTO2.setSegundoNombre(
						(trabajadorTmp.getSegundoNombre() != null) ? trabajadorTmp.getSegundoNombre() : null);
				trabajadorDTO2.setTelefono((trabajadorTmp.getTelefono() != null) ? trabajadorTmp.getTelefono() : null);
				trabajadorDTO2.setNIdentificacion(
						(trabajadorTmp.getnIdentificacion() != null) ? trabajadorTmp.getnIdentificacion() : null);
				trabajadorDTO2.setEstadoCivil(
						(trabajadorTmp.getEstadoCivil() != null) ? trabajadorTmp.getEstadoCivil() : null);
				trabajadorDTO2
						.setDireccion((trabajadorTmp.getDireccion() != null) ? trabajadorTmp.getDireccion() : null);

				if (trabajadorTmp.getCentCost() != null) {
					trabajadorDTO2.setCentCostId_CentCost(trabajadorTmp.getProfesion().getProfId());
				} else {
					trabajadorDTO2.setCentCostId_CentCost(null);
				}

				trabajadorDTO2
						.setCiudadId_Ciudad((trabajadorTmp.getCiudad() != null) ? trabajadorTmp.getCiudad() : null);
				if (trabajadorTmp.getContratista() != null) {
					trabajadorDTO2.setContratistaId_Contratista(trabajadorTmp.getContratista().getPersEmprId());
				} else {
					trabajadorDTO2.setContratistaId_Contratista(null);
				}

				if (trabajadorTmp.getProfesion() != null) {
					trabajadorDTO2.setProfId_Profesion(trabajadorTmp.getProfesion().getProfId());
				} else {
					trabajadorDTO2.setProfId_Profesion(null);
				}
				
				trabajadorDTO2
				.setOrigenDatos((trabajadorTmp.getOrigenDatos() != null) ? trabajadorTmp
						.getOrigenDatos() : null);
				
				
				if (trabajadorTmp.getBarrio() != null) {
					trabajadorDTO2.setBarrio(trabajadorTmp.getBarrio());
				} else {
					trabajadorDTO2.setBarrio(null);
				}
				if (trabajadorTmp.getTipo_vivienda() != null) {
					trabajadorDTO2.setTipo_vivienda(trabajadorTmp.getTipo_vivienda());
				} else {
					trabajadorDTO2.setTipo_vivienda(null);
				}
				if (trabajadorTmp.getCelular() != null) {
					trabajadorDTO2.setCelular(trabajadorTmp.getCelular());
				} else {
					trabajadorDTO2.setCelular(null);
				}
				if (trabajadorTmp.getTipo_licencia_conduccion() != null) {
					trabajadorDTO2.setTipo_licencia_conduccion(trabajadorTmp.getTipo_licencia_conduccion());
				} else {
					trabajadorDTO2.setTipo_licencia_conduccion(null);
				}
				if (trabajadorTmp.getNumero_licencia_conduccion() != null) {
					trabajadorDTO2.setNumero_licencia_conduccion(trabajadorTmp.getNumero_licencia_conduccion());
				} else {
					trabajadorDTO2.setNumero_licencia_conduccion(null);
				}
				if (trabajadorTmp.getNum_pasado_judicial() != null) {
					trabajadorDTO2.setNum_pasado_judicial(trabajadorTmp.getNum_pasado_judicial());
				} else {
					trabajadorDTO2.setNum_pasado_judicial(null);
				}
				if (trabajadorTmp.getNum_tarjeta_profesional() != null) {
					trabajadorDTO2.setNum_tarjeta_profesional(trabajadorTmp.getNum_tarjeta_profesional());
				} else {
					trabajadorDTO2.setNum_tarjeta_profesional(null);
				}
				if (trabajadorTmp.getTipo_sangre() != null) {
					trabajadorDTO2.setTipo_sangre(trabajadorTmp.getTipo_sangre());
				} else {
					trabajadorDTO2.setTipo_sangre(null);
				}
				if (trabajadorTmp.getNombre_eps() != null) {
					trabajadorDTO2.setNombre_eps(trabajadorTmp.getNombre_eps());
				} else {
					trabajadorDTO2.setNombre_eps(null);
				}
				if (trabajadorTmp.getNombre_fondo_pension() != null) {
					trabajadorDTO2.setNombre_fondo_pension(trabajadorTmp.getNombre_fondo_pension());
				} else {
					trabajadorDTO2.setNombre_fondo_pension(null);
				}
				if (trabajadorTmp.getNombre_fondo_cesantias() != null) {
					trabajadorDTO2.setNombre_fondo_cesantias(trabajadorTmp.getNombre_fondo_cesantias());
				} else {
					trabajadorDTO2.setNombre_fondo_cesantias(null);
				}
				if (trabajadorTmp.getNombre_arp() != null) {
					trabajadorDTO2.setNombre_arp(trabajadorTmp.getNombre_arp());
				} else {
					trabajadorDTO2.setNombre_arp(null);
				}
				if (trabajadorTmp.getNombre_caja_compensacion() != null) {
					trabajadorDTO2.setNombre_caja_compensacion(trabajadorTmp.getNombre_caja_compensacion());
				} else {
					trabajadorDTO2.setNombre_caja_compensacion(null);
				}
				if (trabajadorTmp.getNumero_cuenta_bancaria() != null) {
					trabajadorDTO2.setNumero_cuenta_bancaria(trabajadorTmp.getNumero_cuenta_bancaria());
				} else {
					trabajadorDTO2.setNumero_cuenta_bancaria(null);
				}
				if (trabajadorTmp.getEnt_banc_id() != null) {
					trabajadorDTO2.setEnt_banc_id(trabajadorTmp.getEnt_banc_id());
				} else {
					trabajadorDTO2.setEnt_banc_id(null);
				}
				if (trabajadorTmp.getTipo_cuenta_bancaria() != null) {
					trabajadorDTO2.setTipo_cuenta_bancaria(trabajadorTmp.getTipo_cuenta_bancaria());
				} else {
					trabajadorDTO2.setTipo_cuenta_bancaria(null);
				}
				if (trabajadorTmp.getNombres_conyugue() != null) {
					trabajadorDTO2.setNombres_conyugue(trabajadorTmp.getNombres_conyugue());
				} else {
					trabajadorDTO2.setNombres_conyugue(null);
				}
				if (trabajadorTmp.getNumero_hijos() != null) {
					trabajadorDTO2.setNumero_hijos(trabajadorTmp.getNumero_hijos());
				} else {
					trabajadorDTO2.setNumero_hijos(null);
				}
				if (trabajadorTmp.getContacto_emergencia() != null) {
					trabajadorDTO2.setContacto_emergencia(trabajadorTmp.getContacto_emergencia());
				} else {
					trabajadorDTO2.setContacto_emergencia(null);
				}
				if (trabajadorTmp.getContacto_emergencia_parentesco() != null) {
					trabajadorDTO2.setContacto_emergencia_parentesco(trabajadorTmp.getContacto_emergencia_parentesco());
				} else {
					trabajadorDTO2.setContacto_emergencia_parentesco(null);
				}
				if (trabajadorTmp.getEstudio_bachillerato() != null) {
					trabajadorDTO2.setEstudio_bachillerato(trabajadorTmp.getEstudio_bachillerato());
				} else {
					trabajadorDTO2.setEstudio_bachillerato(null);
				}
				if (trabajadorTmp.getEstudio_bachillerato_entidad() != null) {
					trabajadorDTO2.setEstudio_bachillerato_entidad(trabajadorTmp.getEstudio_bachillerato_entidad());
				} else {
					trabajadorDTO2.setEstudio_bachillerato_entidad(null);
				}
				if (trabajadorTmp.getEstudio_tecnico() != null) {
					trabajadorDTO2.setEstudio_tecnico(trabajadorTmp.getEstudio_tecnico());
				} else {
					trabajadorDTO2.setEstudio_tecnico(null);
				}
				if (trabajadorTmp.getEstudio_tecnico_titulo() != null) {
					trabajadorDTO2.setEstudio_tecnico_titulo(trabajadorTmp.getEstudio_tecnico_titulo());
				} else {
					trabajadorDTO2.setEstudio_tecnico_titulo(null);
				}
				if (trabajadorTmp.getEstudio_tecnico_entidad() != null) {
					trabajadorDTO2.setEstudio_tecnico_entidad(trabajadorTmp.getEstudio_tecnico_entidad());
				} else {
					trabajadorDTO2.setEstudio_tecnico_entidad(null);
				}
				if (trabajadorTmp.getEstudio_tecnologico() != null) {
					trabajadorDTO2.setEstudio_tecnologico(trabajadorTmp.getEstudio_tecnologico());
				} else {
					trabajadorDTO2.setEstudio_tecnologico(null);
				}
				if (trabajadorTmp.getEstudio_tecnologico_titulo() != null) {
					trabajadorDTO2.setEstudio_tecnologico_titulo(trabajadorTmp.getEstudio_tecnologico_titulo());
				} else {
					trabajadorDTO2.setEstudio_tecnologico_titulo(null);
				}
				if (trabajadorTmp.getEstudio_tecnologico_entidad() != null) {
					trabajadorDTO2.setEstudio_tecnologico_entidad(trabajadorTmp.getEstudio_tecnologico_entidad());
				} else {
					trabajadorDTO2.setEstudio_tecnologico_entidad(null);
				}
				if (trabajadorTmp.getEstudio_pregrado() != null) {
					trabajadorDTO2.setEstudio_pregrado(trabajadorTmp.getEstudio_pregrado());
				} else {
					trabajadorDTO2.setEstudio_pregrado(null);
				}
				if (trabajadorTmp.getEstudio_pregrado_titulo() != null) {
					trabajadorDTO2.setEstudio_pregrado_titulo(trabajadorTmp.getEstudio_pregrado_titulo());
				} else {
					trabajadorDTO2.setEstudio_pregrado_titulo(null);
				}
				if (trabajadorTmp.getEstudio_pregrado_entidad() != null) {
					trabajadorDTO2.setEstudio_pregrado_entidad(trabajadorTmp.getEstudio_pregrado_entidad());
				} else {
					trabajadorDTO2.setEstudio_pregrado_entidad(null);
				}
				if (trabajadorTmp.getEstudio_potsgrado() != null) {
					trabajadorDTO2.setEstudio_potsgrado(trabajadorTmp.getEstudio_potsgrado());
				} else {
					trabajadorDTO2.setEstudio_potsgrado(null);
				}
				if (trabajadorTmp.getEstudio_potsgrado_titulo() != null) {
					trabajadorDTO2.setEstudio_potsgrado_titulo(trabajadorTmp.getEstudio_potsgrado_titulo());
				} else {
					trabajadorDTO2.setEstudio_potsgrado_titulo(null);
				}
				if (trabajadorTmp.getEstudio_potsgrado_entidad() != null) {
					trabajadorDTO2.setEstudio_potsgrado_entidad(trabajadorTmp.getEstudio_potsgrado_entidad());
				} else {
					trabajadorDTO2.setEstudio_potsgrado_entidad(null);
				}
				if (trabajadorTmp.getEstudio_otros() != null) {
					trabajadorDTO2.setEstudio_otros(trabajadorTmp.getEstudio_otros());
				} else {
					trabajadorDTO2.setEstudio_otros(null);
				}
				if (trabajadorTmp.getEstudio_otros_titulo() != null) {
					trabajadorDTO2.setEstudio_otros_titulo(trabajadorTmp.getEstudio_otros_titulo());
				} else {
					trabajadorDTO2.setEstudio_otros_titulo(null);
				}
				if (trabajadorTmp.getEstudio_otros_entidad() != null) {
					trabajadorDTO2.setEstudio_otros_entidad(trabajadorTmp.getEstudio_otros_entidad());
				} else {
					trabajadorDTO2.setEstudio_otros_entidad(null);
				}
				if (trabajadorTmp.getPecargo1_nombre() != null) {
					trabajadorDTO2.setPecargo1_nombre(trabajadorTmp.getPecargo1_nombre());
				} else {
					trabajadorDTO2.setPecargo1_nombre(null);
				}
				if (trabajadorTmp.getPecargo1_parentesco() != null) {
					trabajadorDTO2.setPecargo1_parentesco(trabajadorTmp.getPecargo1_parentesco());
				} else {
					trabajadorDTO2.setPecargo1_parentesco(null);
				}
				if (trabajadorTmp.getPecargo1_edad() != null) {
					trabajadorDTO2.setPecargo1_edad(trabajadorTmp.getPecargo1_edad());
				} else {
					trabajadorDTO2.setPecargo1_edad(null);
				}
				if (trabajadorTmp.getPecargo1_niveleducativo() != null) {
					trabajadorDTO2.setPecargo1_niveleducativo(trabajadorTmp.getPecargo1_niveleducativo());
				} else {
					trabajadorDTO2.setPecargo1_niveleducativo(null);
				}
				if (trabajadorTmp.getPecargo2_nombre() != null) {
					trabajadorDTO2.setPecargo2_nombre(trabajadorTmp.getPecargo2_nombre());
				} else {
					trabajadorDTO2.setPecargo2_nombre(null);
				}
				if (trabajadorTmp.getPecargo2_parentesco() != null) {
					trabajadorDTO2.setPecargo2_parentesco(trabajadorTmp.getPecargo2_parentesco());
				} else {
					trabajadorDTO2.setPecargo2_parentesco(null);
				}
				if (trabajadorTmp.getPecargo2_edad() != null) {
					trabajadorDTO2.setPecargo2_edad(trabajadorTmp.getPecargo2_edad());
				} else {
					trabajadorDTO2.setPecargo2_edad(null);
				}
				if (trabajadorTmp.getPecargo2_niveleducativo() != null) {
					trabajadorDTO2.setPecargo2_niveleducativo(trabajadorTmp.getPecargo2_niveleducativo());
				} else {
					trabajadorDTO2.setPecargo2_niveleducativo(null);
				}
				if (trabajadorTmp.getPecargo3_nombre() != null) {
					trabajadorDTO2.setPecargo3_nombre(trabajadorTmp.getPecargo3_nombre());
				} else {
					trabajadorDTO2.setPecargo3_nombre(null);
				}
				if (trabajadorTmp.getPecargo3_parentesco() != null) {
					trabajadorDTO2.setPecargo3_parentesco(trabajadorTmp.getPecargo3_parentesco());
				} else {
					trabajadorDTO2.setPecargo3_parentesco(null);
				}
				if (trabajadorTmp.getPecargo3_edad() != null) {
					trabajadorDTO2.setPecargo3_edad(trabajadorTmp.getPecargo3_edad());
				} else {
					trabajadorDTO2.setPecargo3_edad(null);
				}
				if (trabajadorTmp.getPecargo3_niveleducativo() != null) {
					trabajadorDTO2.setPecargo3_niveleducativo(trabajadorTmp.getPecargo3_niveleducativo());
				} else {
					trabajadorDTO2.setPecargo3_niveleducativo(null);
				}
				if (trabajadorTmp.getPecargo4_nombre() != null) {
					trabajadorDTO2.setPecargo4_nombre(trabajadorTmp.getPecargo4_nombre());
				} else {
					trabajadorDTO2.setPecargo4_nombre(null);
				}
				if (trabajadorTmp.getPecargo4_parentesco() != null) {
					trabajadorDTO2.setPecargo4_parentesco(trabajadorTmp.getPecargo4_parentesco());
				} else {
					trabajadorDTO2.setPecargo4_parentesco(null);
				}
				if (trabajadorTmp.getPecargo4_edad() != null) {
					trabajadorDTO2.setPecargo4_edad(trabajadorTmp.getPecargo4_edad());
				} else {
					trabajadorDTO2.setPecargo4_edad(null);
				}
				if (trabajadorTmp.getPecargo4_niveleducativo() != null) {
					trabajadorDTO2.setPecargo4_niveleducativo(trabajadorTmp.getPecargo4_niveleducativo());
				} else {
					trabajadorDTO2.setPecargo4_niveleducativo(null);
				}
				if (trabajadorTmp.getPecargo5_nombre() != null) {
					trabajadorDTO2.setPecargo5_nombre(trabajadorTmp.getPecargo5_nombre());
				} else {
					trabajadorDTO2.setPecargo5_nombre(null);
				}
				if (trabajadorTmp.getPecargo5_parentesco() != null) {
					trabajadorDTO2.setPecargo5_parentesco(trabajadorTmp.getPecargo5_parentesco());
				} else {
					trabajadorDTO2.setPecargo5_parentesco(null);
				}
				if (trabajadorTmp.getPecargo5_edad() != null) {
					trabajadorDTO2.setPecargo5_edad(trabajadorTmp.getPecargo5_edad());
				} else {
					trabajadorDTO2.setPecargo5_edad(null);
				}
				if (trabajadorTmp.getPecargo5_niveleducativo() != null) {
					trabajadorDTO2.setPecargo5_niveleducativo(trabajadorTmp.getPecargo5_niveleducativo());
				} else {
					trabajadorDTO2.setPecargo5_niveleducativo(null);
				}
				if (trabajadorTmp.getSalario() != null) {
					trabajadorDTO2.setSalario(trabajadorTmp.getSalario());
				} else {
					trabajadorDTO2.setSalario(null);
				}
				
				if (trabajadorTmp.getUsuario_asociado() != null) {
					trabajadorDTO2.setUsuario_asociado(trabajadorTmp.getUsuario_asociado());
				} else {
					trabajadorDTO2.setUsuario_asociado(null);
				}
				
				if (trabajadorTmp.getTipo_trabajador() != null) {
					trabajadorDTO2.setTipo_trabajador(trabajadorTmp.getTipo_trabajador());
				} else {
					trabajadorDTO2.setTipo_trabajador(null);
				}
				
				
				if (trabajadorTmp.getTarifasArlId() != null) {
					trabajadorDTO2.setTarifasArlId(trabajadorTmp.getTarifasArlId());
				} else {
					trabajadorDTO2.setTarifasArlId(null);
				}
				
				
				trabajadorDTO.add(trabajadorDTO2);
				
			}
			

			return trabajadorDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberTrabajador(Map<String, Object> filters) throws Exception {
		Long entity = null;

		try {
			String whereCondition = new String();
			Iterator it = filters.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry e = (Map.Entry) it.next();
				whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(" + e.getKey() + ")"
						+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";
			}
			entity = trabajadorDAO.countByCriteria(whereCondition);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Trabajador Count");
		} finally {
		}
		return entity;
	}

}
