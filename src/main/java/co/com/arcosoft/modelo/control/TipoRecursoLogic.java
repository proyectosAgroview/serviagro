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

import co.com.arcosoft.dataaccess.dao.ILaborRecursosDAO;
import co.com.arcosoft.dataaccess.dao.IPlanAsignarRecursoDAO;
import co.com.arcosoft.dataaccess.dao.IRecursoDAO;
import co.com.arcosoft.dataaccess.dao.ITipoRecursoDAO;
import co.com.arcosoft.dataaccess.dao.ITipoRecursosEquiposDAO;
import co.com.arcosoft.dataaccess.dao.ITipoRecursosInsumosDAO;
import co.com.arcosoft.dataaccess.dao.ITipoRecursosOtrosDAO;
import co.com.arcosoft.dataaccess.dao.ITipoRecursosProfesionDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.LaborRecursos;
import co.com.arcosoft.modelo.PlanAsignarRecurso;
import co.com.arcosoft.modelo.Recurso;
import co.com.arcosoft.modelo.TipoRecurso;
import co.com.arcosoft.modelo.TipoRecursosEquipos;
import co.com.arcosoft.modelo.TipoRecursosInsumos;
import co.com.arcosoft.modelo.TipoRecursosOtros;
import co.com.arcosoft.modelo.TipoRecursosProfesion;
import co.com.arcosoft.modelo.dto.TipoRecursoDTO;
import co.com.arcosoft.modelo.dto.TipoRecursosEquiposDTO;
import co.com.arcosoft.modelo.dto.TipoRecursosInsumosDTO;
import co.com.arcosoft.modelo.dto.TipoRecursosOtrosDTO;
import co.com.arcosoft.modelo.dto.TipoRecursosProfesionDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("TipoRecursoLogic")
public class TipoRecursoLogic implements ITipoRecursoLogic {
	private static final Logger log = LoggerFactory.getLogger(TipoRecursoLogic.class);

	/**
	 * DAO injected by Spring that manages TipoRecurso entities
	 *
	 */
	@Autowired
	private ITipoRecursoDAO tipoRecursoDAO;

	@Autowired
	private ITipoRecursosProfesionDAO tipoRecursosProfesionDAO;

	@Autowired
	private ITipoRecursosEquiposDAO tipoRecursosEquiposDAO;

	@Autowired
	private ITipoRecursosOtrosDAO tipoRecursosOtrosDAO;

	@Autowired
	private ITipoRecursosInsumosDAO tipoRecursosInsumosDAO;

	@Autowired
	private ILaborRecursosDAO laborRecursosDAO;

	/**
	 * DAO injected by Spring that manages PlanAsignarRecurso entities
	 *
	 */
	@Autowired
	private IPlanAsignarRecursoDAO planAsignarRecursoDAO;

	/**
	 * DAO injected by Spring that manages Recurso entities
	 *
	 */
	@Autowired
	private IRecursoDAO recursoDAO;

	@Override
	@Transactional(readOnly = true)
	public List<TipoRecurso> getTipoRecurso() throws Exception {
		log.debug("finding all TipoRecurso instances");

		List<TipoRecurso> list = new ArrayList<TipoRecurso>();

		try {
			list = tipoRecursoDAO.findAll();
		} catch (Exception e) {
			log.error("finding all TipoRecurso failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "TipoRecurso");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveTipoRecurso(TipoRecurso entity,

			List<TipoRecursosProfesionDTO> dataTRProfesion, List<TipoRecursosEquiposDTO> dataTREquipos,
			List<TipoRecursosInsumosDTO> dataTRInsumos, List<TipoRecursosOtrosDTO> dataTROtros) throws Exception {
		log.debug("saving TipoRecurso instance");

		try {
			if ((entity.getClaseRecurso() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getClaseRecurso(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("claseRecurso");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getControlCosto() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getControlCosto(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("controlCosto");
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
			/*
			 * if (entity.getTpRecursoId() == null) { throw new
			 * ZMessManager().new EmptyFieldException("tpRecursoId"); }
			 * 
			 * if ((entity.getTpRecursoId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getTpRecursoId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "tpRecursoId"); }
			 * 
			 * if (getTipoRecurso(entity.getTpRecursoId()) != null) { throw new
			 * ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */
			tipoRecursoDAO.save(entity);

			if (dataTRProfesion != null) {

				for (TipoRecursosProfesionDTO valorDto : dataTRProfesion) {

					if (valorDto.getTipoRecursosProfesionId() == null) {

						TipoRecursosProfesion valor = new TipoRecursosProfesion();

						valor.setDisponibilidadDia(valorDto.getDisponibilidadDia());
						valor.setDisponibilidadTotal(valorDto.getDisponibilidadDia());
						valor.setFechaCreacion(valorDto.getFechaCreacion());
						valor.setFechaFinal(valorDto.getFechaFinal());
						valor.setFechaInicial(valorDto.getFechaInicial());
						valor.setFechaModificacion(valorDto.getFechaModificacion());
						valor.setValor(valorDto.getValor());
						valor.setElementoCosto(valorDto.getElemCostoId_ElementoCosto());
						valor.setProfesion(valorDto.getProfId_Profesion());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());

						valor.setTipoRecurso(entity);

						tipoRecursosProfesionDAO.save(valor);
					}

				}
			}

			if (dataTREquipos != null) {

				for (TipoRecursosEquiposDTO valorDto : dataTREquipos) {

					if (valorDto.getTipoRecursosEquiposId() == null) {

						TipoRecursosEquipos valor = new TipoRecursosEquipos();

						valor.setDisponibilidadDia(valorDto.getDisponibilidadDia());
						valor.setDisponibilidadTotal(valorDto.getDisponibilidadDia());
						valor.setFechaCreacion(valorDto.getFechaCreacion());
						valor.setFechaFinal(valorDto.getFechaFinal());
						valor.setFechaInicial(valorDto.getFechaInicial());
						valor.setFechaModificacion(valorDto.getFechaModificacion());
						valor.setValor(valorDto.getValor());
						valor.setElementoCosto(valorDto.getElemCostoId_ElementoCosto());
						valor.setCategoriaEquipo(valorDto.getCategEquipId_CategoriaEquipo());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());

						valor.setTipoRecurso(entity);

						tipoRecursosEquiposDAO.save(valor);
					}

				}
			}

			if (dataTRInsumos != null) {

				for (TipoRecursosInsumosDTO valorDto : dataTRInsumos) {

					if (valorDto.getTipoRecursosInsumosId() == null) {

						TipoRecursosInsumos valor = new TipoRecursosInsumos();

						valor.setFechaCreacion(valorDto.getFechaCreacion());
						valor.setFechaFinal(valorDto.getFechaFinal());
						valor.setFechaInicial(valorDto.getFechaInicial());
						valor.setFechaModificacion(valorDto.getFechaModificacion());
						valor.setValor(valorDto.getValor());
						valor.setElementoCosto(valorDto.getElemCostoId_ElementoCosto());
						valor.setProducto(valorDto.getProductoId_Producto());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());

						valor.setTipoRecurso(entity);

						tipoRecursosInsumosDAO.save(valor);
					}

				}
			}

			if (dataTROtros != null) {

				for (TipoRecursosOtrosDTO valorDto : dataTROtros) {

					if (valorDto.getTipoRecursosOtrosId() == null) {

						TipoRecursosOtros valor = new TipoRecursosOtros();

						valor.setFechaCreacion(valorDto.getFechaCreacion());
						valor.setFechaFinal(valorDto.getFechaFinal());
						valor.setFechaInicial(valorDto.getFechaInicial());
						valor.setFechaModificacion(valorDto.getFechaModificacion());
						valor.setCodigo(valorDto.getCodigo());
						valor.setServicioId(valorDto.getServicioId());
						valor.setNombre(valorDto.getNombre());
						valor.setValor(valorDto.getValor());
						valor.setElementoCosto(valorDto.getElemCostoId_ElementoCosto());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());

						valor.setTipoRecurso(entity);

						tipoRecursosOtrosDAO.save(valor);
					}

				}
			}

			log.debug("save TipoRecurso successful");
		} catch (Exception e) {
			log.error("save TipoRecurso failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteTipoRecurso(TipoRecurso entity) throws Exception {
		log.debug("deleting TipoRecurso instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("TipoRecurso");
		}

		if (entity.getTpRecursoId() == null) {
			throw new ZMessManager().new EmptyFieldException("tpRecursoId");
		}

		List<PlanAsignarRecurso> planAsignarRecursos = null;
		List<Recurso> recursos = null;
		List<LaborRecursos> laborRecursoses = null;
		List<TipoRecursosEquipos> tipoRecursosEquiposes = null;
		List<TipoRecursosInsumos> tipoRecursosInsumoses = null;
		List<TipoRecursosOtros> tipoRecursosOtroses = null;
		List<TipoRecursosProfesion> tipoRecursosProfesions = null;

		try {
			planAsignarRecursos = planAsignarRecursoDAO.findByProperty("tipoRecurso.tpRecursoId",
					entity.getTpRecursoId());

			if (Utilities.validationsList(planAsignarRecursos) == true) {
				throw new ZMessManager().new DeletingException("planAsignarRecursos");
			}

			recursos = recursoDAO.findByProperty("tipoRecurso.tpRecursoId", entity.getTpRecursoId());

			if (Utilities.validationsList(recursos) == true) {
				throw new ZMessManager().new DeletingException("recursos");
			}

			laborRecursoses = laborRecursosDAO.findByProperty("tipoRecurso.tpRecursoId", entity.getTpRecursoId());

			if (Utilities.validationsList(laborRecursoses) == true) {
				throw new ZMessManager().new DeletingException("laborRecursoses");
			}

			tipoRecursosEquiposes = tipoRecursosEquiposDAO.findByProperty("tipoRecurso.tpRecursoId",
					entity.getTpRecursoId());

			if (Utilities.validationsList(tipoRecursosEquiposes) == true) {
				throw new ZMessManager().new DeletingException("tipoRecursosEquiposes");
			}

			tipoRecursosInsumoses = tipoRecursosInsumosDAO.findByProperty("tipoRecurso.tpRecursoId",
					entity.getTpRecursoId());

			if (Utilities.validationsList(tipoRecursosInsumoses) == true) {
				throw new ZMessManager().new DeletingException("tipoRecursosInsumoses");
			}

			tipoRecursosOtroses = tipoRecursosOtrosDAO.findByProperty("tipoRecurso.tpRecursoId",
					entity.getTpRecursoId());

			if (Utilities.validationsList(tipoRecursosOtroses) == true) {
				throw new ZMessManager().new DeletingException("tipoRecursosOtroses");
			}

			tipoRecursosProfesions = tipoRecursosProfesionDAO.findByProperty("tipoRecurso.tpRecursoId",
					entity.getTpRecursoId());

			if (Utilities.validationsList(tipoRecursosProfesions) == true) {
				throw new ZMessManager().new DeletingException("tipoRecursosProfesions");
			}

			tipoRecursoDAO.delete(entity);

			log.debug("delete TipoRecurso successful");
		} catch (Exception e) {
			log.error("delete TipoRecurso failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateTipoRecurso(TipoRecurso entity, List<TipoRecursosProfesionDTO> dataTRProfesion,
			List<TipoRecursosEquiposDTO> dataTREquipos, List<TipoRecursosInsumosDTO> dataTRInsumos,
			List<TipoRecursosOtrosDTO> dataTROtros) throws Exception {
		log.debug("updating TipoRecurso instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("TipoRecurso");
			}

			if ((entity.getClaseRecurso() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getClaseRecurso(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("claseRecurso");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getControlCosto() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getControlCosto(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("controlCosto");
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

			if (entity.getTpRecursoId() == null) {
				throw new ZMessManager().new EmptyFieldException("tpRecursoId");
			}

			if ((entity.getTpRecursoId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTpRecursoId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("tpRecursoId");
			}

			tipoRecursoDAO.update(entity);

			if (dataTRProfesion != null) {

				for (TipoRecursosProfesionDTO valorDto : dataTRProfesion) {

					if (valorDto.getTipoRecursosProfesionId() == null) {

						TipoRecursosProfesion valor = new TipoRecursosProfesion();

						valor.setDisponibilidadDia(valorDto.getDisponibilidadDia());
						valor.setDisponibilidadTotal(valorDto.getDisponibilidadDia());
						valor.setFechaCreacion(valorDto.getFechaCreacion());
						valor.setFechaFinal(valorDto.getFechaFinal());
						valor.setFechaInicial(valorDto.getFechaInicial());
						valor.setFechaModificacion(valorDto.getFechaModificacion());
						valor.setValor(valorDto.getValor());
						valor.setElementoCosto(valorDto.getElemCostoId_ElementoCosto());
						valor.setProfesion(valorDto.getProfId_Profesion());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());

						valor.setTipoRecurso(entity);

						tipoRecursosProfesionDAO.save(valor);
					} else {
						TipoRecursosProfesion valor = tipoRecursosProfesionDAO
								.findById(valorDto.getTipoRecursosProfesionId());

						valor.setDisponibilidadDia(valorDto.getDisponibilidadDia());
						valor.setDisponibilidadTotal(valorDto.getDisponibilidadDia());
						valor.setFechaCreacion(valorDto.getFechaCreacion());
						valor.setFechaFinal(valorDto.getFechaFinal());
						valor.setFechaInicial(valorDto.getFechaInicial());
						valor.setFechaModificacion(valorDto.getFechaModificacion());
						valor.setValor(valorDto.getValor());
						valor.setElementoCosto(valorDto.getElemCostoId_ElementoCosto());
						valor.setProfesion(valorDto.getProfId_Profesion());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());

						valor.setTipoRecurso(entity);

						tipoRecursosProfesionDAO.update(valor);

					}

				}
			}

			if (dataTREquipos != null) {

				for (TipoRecursosEquiposDTO valorDto : dataTREquipos) {

					if (valorDto.getTipoRecursosEquiposId() == null) {

						TipoRecursosEquipos valor = new TipoRecursosEquipos();

						valor.setDisponibilidadDia(valorDto.getDisponibilidadDia());
						valor.setDisponibilidadTotal(valorDto.getDisponibilidadDia());
						valor.setFechaCreacion(valorDto.getFechaCreacion());
						valor.setFechaFinal(valorDto.getFechaFinal());
						valor.setFechaInicial(valorDto.getFechaInicial());
						valor.setFechaModificacion(valorDto.getFechaModificacion());
						valor.setValor(valorDto.getValor());
						valor.setElementoCosto(valorDto.getElemCostoId_ElementoCosto());
						valor.setCategoriaEquipo(valorDto.getCategEquipId_CategoriaEquipo());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());

						valor.setTipoRecurso(entity);

						tipoRecursosEquiposDAO.save(valor);
					} else {
						TipoRecursosEquipos valor = tipoRecursosEquiposDAO
								.findById(valorDto.getTipoRecursosEquiposId());

						valor.setDisponibilidadDia(valorDto.getDisponibilidadDia());
						valor.setDisponibilidadTotal(valorDto.getDisponibilidadDia());
						valor.setFechaCreacion(valorDto.getFechaCreacion());
						valor.setFechaFinal(valorDto.getFechaFinal());
						valor.setFechaInicial(valorDto.getFechaInicial());
						valor.setFechaModificacion(valorDto.getFechaModificacion());
						valor.setValor(valorDto.getValor());
						valor.setElementoCosto(valorDto.getElemCostoId_ElementoCosto());
						valor.setCategoriaEquipo(valorDto.getCategEquipId_CategoriaEquipo());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());

						valor.setTipoRecurso(entity);

						tipoRecursosEquiposDAO.update(valor);

					}

				}
			}

			if (dataTRInsumos != null) {

				for (TipoRecursosInsumosDTO valorDto : dataTRInsumos) {

					if (valorDto.getTipoRecursosInsumosId() == null) {

						TipoRecursosInsumos valor = new TipoRecursosInsumos();

						valor.setFechaCreacion(valorDto.getFechaCreacion());
						valor.setFechaFinal(valorDto.getFechaFinal());
						valor.setFechaInicial(valorDto.getFechaInicial());
						valor.setFechaModificacion(valorDto.getFechaModificacion());
						valor.setValor(valorDto.getValor());
						valor.setElementoCosto(valorDto.getElemCostoId_ElementoCosto());
						valor.setProducto(valorDto.getProductoId_Producto());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());

						valor.setTipoRecurso(entity);

						tipoRecursosInsumosDAO.save(valor);
					} else {
						TipoRecursosInsumos valor = tipoRecursosInsumosDAO
								.findById(valorDto.getTipoRecursosInsumosId());

						valor.setFechaCreacion(valorDto.getFechaCreacion());
						valor.setFechaFinal(valorDto.getFechaFinal());
						valor.setFechaInicial(valorDto.getFechaInicial());
						valor.setFechaModificacion(valorDto.getFechaModificacion());
						valor.setValor(valorDto.getValor());
						valor.setElementoCosto(valorDto.getElemCostoId_ElementoCosto());
						valor.setProducto(valorDto.getProductoId_Producto());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());

						valor.setTipoRecurso(entity);

						tipoRecursosInsumosDAO.update(valor);

					}

				}
			}

			if (dataTROtros != null) {

				for (TipoRecursosOtrosDTO valorDto : dataTROtros) {

					if (valorDto.getTipoRecursosOtrosId() == null) {

						TipoRecursosOtros valor = new TipoRecursosOtros();

						valor.setFechaCreacion(valorDto.getFechaCreacion());
						valor.setFechaFinal(valorDto.getFechaFinal());
						valor.setFechaInicial(valorDto.getFechaInicial());
						valor.setFechaModificacion(valorDto.getFechaModificacion());
						valor.setCodigo(valorDto.getCodigo());
						valor.setServicioId(valorDto.getServicioId());
						valor.setNombre(valorDto.getNombre());
						valor.setValor(valorDto.getValor());
						valor.setElementoCosto(valorDto.getElemCostoId_ElementoCosto());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());

						valor.setTipoRecurso(entity);

						tipoRecursosOtrosDAO.save(valor);
					} else {
						TipoRecursosOtros valor = tipoRecursosOtrosDAO.findById(valorDto.getTipoRecursosOtrosId());
						valor.setFechaCreacion(valorDto.getFechaCreacion());
						valor.setFechaFinal(valorDto.getFechaFinal());
						valor.setFechaInicial(valorDto.getFechaInicial());
						valor.setFechaModificacion(valorDto.getFechaModificacion());
						valor.setCodigo(valorDto.getCodigo());
						valor.setNombre(valorDto.getNombre());
						valor.setServicioId(valorDto.getServicioId());
						valor.setValor(valorDto.getValor());
						valor.setElementoCosto(valorDto.getElemCostoId_ElementoCosto());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());

						valor.setTipoRecurso(entity);

						tipoRecursosOtrosDAO.update(valor);

					}

				}
			}

			log.debug("update TipoRecurso successful");
		} catch (Exception e) {
			log.error("update TipoRecurso failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<TipoRecursoDTO> getDataTipoRecurso() throws Exception {
		try {
			List<TipoRecurso> tipoRecurso = tipoRecursoDAO.findAll();

			List<TipoRecursoDTO> tipoRecursoDTO = new ArrayList<TipoRecursoDTO>();

			for (TipoRecurso tipoRecursoTmp : tipoRecurso) {
				TipoRecursoDTO tipoRecursoDTO2 = new TipoRecursoDTO();

				tipoRecursoDTO2.setTpRecursoId(tipoRecursoTmp.getTpRecursoId());
				tipoRecursoDTO2.setClaseRecurso(
						(tipoRecursoTmp.getClaseRecurso() != null) ? tipoRecursoTmp.getClaseRecurso() : null);
				tipoRecursoDTO2.setCodigo((tipoRecursoTmp.getCodigo() != null) ? tipoRecursoTmp.getCodigo() : null);
				tipoRecursoDTO2
						.setCompania((tipoRecursoTmp.getCompania() != null) ? tipoRecursoTmp.getCompania() : null);
				tipoRecursoDTO2.setControlCosto(
						(tipoRecursoTmp.getControlCosto() != null) ? tipoRecursoTmp.getControlCosto() : null);
				tipoRecursoDTO2.setEstado((tipoRecursoTmp.getEstado() != null) ? tipoRecursoTmp.getEstado() : null);
				tipoRecursoDTO2.setFechaCreacion(tipoRecursoTmp.getFechaCreacion());
				tipoRecursoDTO2.setFechaModificacion(tipoRecursoTmp.getFechaModificacion());
				tipoRecursoDTO2.setInfoAdicional(
						(tipoRecursoTmp.getInfoAdicional() != null) ? tipoRecursoTmp.getInfoAdicional() : null);
				tipoRecursoDTO2.setInfoAdicional2(
						(tipoRecursoTmp.getInfoAdicional2() != null) ? tipoRecursoTmp.getInfoAdicional2() : null);
				tipoRecursoDTO2.setNombre((tipoRecursoTmp.getNombre() != null) ? tipoRecursoTmp.getNombre() : null);
				tipoRecursoDTO.add(tipoRecursoDTO2);
			}

			return tipoRecursoDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public TipoRecurso getTipoRecurso(Long tpRecursoId) throws Exception {
		log.debug("getting TipoRecurso instance");

		TipoRecurso entity = null;

		try {
			entity = tipoRecursoDAO.findById(tpRecursoId);
		} catch (Exception e) {
			log.error("get TipoRecurso failed", e);
			throw new ZMessManager().new FindingException("TipoRecurso");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<TipoRecurso> findPageTipoRecurso(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<TipoRecurso> entity = null;

		try {
			entity = tipoRecursoDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("TipoRecurso Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberTipoRecurso() throws Exception {
		Long entity = null;

		try {
			entity = tipoRecursoDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("TipoRecurso Count");
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
	public List<TipoRecurso> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<TipoRecurso> list = new ArrayList<TipoRecurso>();
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
			list = tipoRecursoDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
