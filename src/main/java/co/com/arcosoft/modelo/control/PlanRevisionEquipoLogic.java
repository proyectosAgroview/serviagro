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

import co.com.arcosoft.dataaccess.dao.IDatMantenimientoEquipoDAO;
import co.com.arcosoft.dataaccess.dao.IPlanRevisionEquipoActivDAO;
import co.com.arcosoft.dataaccess.dao.IPlanRevisionEquipoDAO;
import co.com.arcosoft.dataaccess.dao.IPlanRevisionEquipoDetDAO;
import co.com.arcosoft.dataaccess.dao.IPlanRevisionEquipoRecursosDAO;
import co.com.arcosoft.dataaccess.dao.IPlanRevisionProdDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatMantenimientoEquipo;
import co.com.arcosoft.modelo.PlanRevisionEquipo;
import co.com.arcosoft.modelo.PlanRevisionEquipoActiv;
import co.com.arcosoft.modelo.PlanRevisionEquipoDet;
import co.com.arcosoft.modelo.PlanRevisionEquipoRecursos;
import co.com.arcosoft.modelo.PlanRevisionProd;
import co.com.arcosoft.modelo.dto.PlanRevisionEquipoActivDTO;
import co.com.arcosoft.modelo.dto.PlanRevisionEquipoDTO;
import co.com.arcosoft.modelo.dto.PlanRevisionEquipoDetDTO;
import co.com.arcosoft.modelo.dto.PlanRevisionEquipoRecursosDTO;
import co.com.arcosoft.modelo.dto.PlanRevisionProdDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("PlanRevisionEquipoLogic")
public class PlanRevisionEquipoLogic implements IPlanRevisionEquipoLogic {
	private static final Logger log = LoggerFactory.getLogger(PlanRevisionEquipoLogic.class);

	/**
	 * DAO injected by Spring that manages PlanRevisionEquipo entities
	 *
	 */
	@Autowired
	private IPlanRevisionEquipoDAO planRevisionEquipoDAO;

	/**
	 * DAO injected by Spring that manages DatMantenimientoEquipo entities
	 *
	 */
	@Autowired
	private IDatMantenimientoEquipoDAO datMantenimientoEquipoDAO;

	/**
	 * DAO injected by Spring that manages PlanRevisionEquipoActiv entities
	 *
	 */
	@Autowired
	private IPlanRevisionEquipoActivDAO planRevisionEquipoActivDAO;

	/**
	 * DAO injected by Spring that manages PlanRevisionEquipoDet entities
	 *
	 */
	@Autowired
	private IPlanRevisionProdDAO planRevisionProdDAO;

	@Autowired
	private IPlanRevisionEquipoDetDAO planRevisionEquipoDetDAO;

	@Autowired
	private IPlanRevisionEquipoRecursosDAO planRevisionEquipoRecursosDAO;

	@Override
	@Transactional(readOnly = true)
	public List<PlanRevisionEquipo> getPlanRevisionEquipo() throws Exception {
		log.debug("finding all PlanRevisionEquipo instances");

		List<PlanRevisionEquipo> list = new ArrayList<PlanRevisionEquipo>();

		try {
			list = planRevisionEquipoDAO.findAll();
		} catch (Exception e) {
			log.error("finding all PlanRevisionEquipo failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "PlanRevisionEquipo");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void savePlanRevisionEquipo(PlanRevisionEquipo entity, List<PlanRevisionEquipoDetDTO> dataDetEquipo,
			List<PlanRevisionEquipoActivDTO> dataDetActividad, List<PlanRevisionEquipoRecursosDTO> dataRecursos,
			List<PlanRevisionProdDTO> dataPlanRevisionProd) throws Exception {
		log.debug("saving PlanRevisionEquipo instance");

		try {
			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 300) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacion(), 1000) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacion");
			}

			planRevisionEquipoDAO.save(entity);

			if (dataDetEquipo != null) {

				for (PlanRevisionEquipoDetDTO valorDto : dataDetEquipo) {

					if (valorDto.getPlanRevisionEquipoDetId() == null) {

						PlanRevisionEquipoDet valor = new PlanRevisionEquipoDet();
						valor.setEquipo(valorDto.getEquipo());
						valor.setPeriocidadDias(valorDto.getPeriocidadDias());
						valor.setPeriocidadHora(valorDto.getPeriocidadHora());
						valor.setPeriocidadKm(valorDto.getPeriocidadKm());
						valor.setCompartimientosEquipo(valorDto.getCompartimientosEquipo());
						valor.setSistemasEquipo(valorDto.getSistemasEquipo());
						valor.setInfoAdicional(valorDto.getInfoAdicional());
						valor.setInfoAdicional2(valorDto.getInfoAdicional2());
						
						valor.setFechaProxServicio(valorDto.getFechaProxServicio());
						valor.setFechaUltimoServicio(valorDto.getFechaUltimoServicio());
						valor.setHorasProxServicio(valorDto.getHorasProxServicio());
						valor.setHorasUltimoServicio(valorDto.getHorasUltimoServicio());
						
						valor.setKmProxServicio(valorDto.getKmProxServicio());
						valor.setKmUltimoServicio(valorDto.getKmUltimoServicio());
						
						valor.setAlertaMax(valorDto.getAlertaMax());
						valor.setAlertaMin(valorDto.getAlertaMin());
						valor.setObservacion(valorDto.getObservacion());
						
						valor.setPlanRevisionEquipo(entity);

						planRevisionEquipoDetDAO.save(valor);
					}

				}
			}

			if (dataDetActividad != null) {

				for (PlanRevisionEquipoActivDTO valorDto : dataDetActividad) {

					if (valorDto.getPlanRevisionEquipoActivId() == null) {

						PlanRevisionEquipoActiv valor = new PlanRevisionEquipoActiv();
						valor.setDuracion(valorDto.getDuracion());
						valor.setLabor(valorDto.getLaborId());
						valor.setSecuencia(valorDto.getSecuencia());

						valor.setPlanRevisionEquipo(entity);

						planRevisionEquipoActivDAO.save(valor);
					}

				}
			}
			if (dataRecursos != null) {

				for (PlanRevisionEquipoRecursosDTO valorDto : dataRecursos) {

					if (valorDto.getPlanRevisionEquipoRecursosId() == null) {

						PlanRevisionEquipoRecursos valor = new PlanRevisionEquipoRecursos();

						valor.setRecursoId(valorDto.getRecursoId());
						valor.setRendimientoRecurso(valorDto.getRendimientoRecurso());
						valor.setTpRecursoId(valorDto.getTpRecursoId());
						valor.setUdadMedId(valorDto.getUdadMedId());
						valor.setNombreRecurso(valorDto.getNombreRecurso());

						valor.setPlanRevisionEquipoRecursosId(entity.getPlanRevisionEquipoId());

						valor.setPlanRevisionEquipo(entity);

						planRevisionEquipoRecursosDAO.save(valor);
					}

				}
			}

			if (dataPlanRevisionProd != null) {

				for (PlanRevisionProdDTO valorDto : dataPlanRevisionProd) {

					if (valorDto.getPlanRevisionProdId() == null) {

						PlanRevisionProd valor = new PlanRevisionProd();
						valor.setCantidad(valorDto.getCantidad());
						valor.setProducto(valorDto.getProductoId_Producto());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());

						valor.setPlanRevisionEquipoId(entity);

						planRevisionProdDAO.save(valor);
					}

				}
			}

			log.debug("save PlanRevisionEquipo successful");
		} catch (Exception e) {
			log.error("save PlanRevisionEquipo failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deletePlanRevisionEquipo(PlanRevisionEquipo entity) throws Exception {
		log.debug("deleting PlanRevisionEquipo instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("PlanRevisionEquipo");
		}

		if (entity.getPlanRevisionEquipoId() == null) {
			throw new ZMessManager().new EmptyFieldException("planRevisionEquipoId");
		}

		List<DatMantenimientoEquipo> datMantenimientoEquipos = null;
		List<PlanRevisionEquipoActiv> planRevisionEquipoActivs = null;
		List<PlanRevisionEquipoDet> planRevisionEquipoDets = null;
		List<PlanRevisionEquipoRecursos> planRevisionEquipoRecursoss = null;

		try {
			datMantenimientoEquipos = datMantenimientoEquipoDAO
					.findByProperty("planRevisionEquipo.planRevisionEquipoId", entity.getPlanRevisionEquipoId());

			if (Utilities.validationsList(datMantenimientoEquipos) == true) {
				throw new ZMessManager().new DeletingException("datMantenimientoEquipos");
			}

			planRevisionEquipoActivs = planRevisionEquipoActivDAO
					.findByProperty("planRevisionEquipo.planRevisionEquipoId", entity.getPlanRevisionEquipoId());

			if (Utilities.validationsList(planRevisionEquipoActivs) == true) {
				throw new ZMessManager().new DeletingException("planRevisionEquipoActivs");
			}

			planRevisionEquipoDets = planRevisionEquipoDetDAO.findByProperty("planRevisionEquipo.planRevisionEquipoId",
					entity.getPlanRevisionEquipoId());

			if (Utilities.validationsList(planRevisionEquipoDets) == true) {
				throw new ZMessManager().new DeletingException("planRevisionEquipoDets");
			}

			planRevisionEquipoRecursoss = planRevisionEquipoRecursosDAO
					.findByProperty("planRevisionEquipo.planRevisionEquipoId", entity.getPlanRevisionEquipoId());

			if (Utilities.validationsList(planRevisionEquipoRecursoss) == true) {
				throw new ZMessManager().new DeletingException("planRevisionEquipoRecursoss");
			}

			planRevisionEquipoDAO.delete(entity);

			log.debug("delete PlanRevisionEquipo successful");
		} catch (Exception e) {
			log.error("delete PlanRevisionEquipo failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updatePlanRevisionEquipo(PlanRevisionEquipo entity, List<PlanRevisionEquipoDetDTO> dataDetEquipo,
			List<PlanRevisionEquipoActivDTO> dataDetActividad, List<PlanRevisionEquipoRecursosDTO> dataRecursos,
			List<PlanRevisionProdDTO> dataPlanRevisionProd) throws Exception {
		log.debug("updating PlanRevisionEquipo instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("PlanRevisionEquipo");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 300) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacion(), 1000) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacion");
			}

			if (entity.getPlanRevisionEquipoId() == null) {
				throw new ZMessManager().new EmptyFieldException("planRevisionEquipoId");
			}

			if ((entity.getPlanRevisionEquipoId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getPlanRevisionEquipoId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("planRevisionEquipoId");
			}

			planRevisionEquipoDAO.update(entity);

			if (dataDetEquipo != null) {

				for (PlanRevisionEquipoDetDTO valorDto : dataDetEquipo) {

					if (valorDto.getPlanRevisionEquipoDetId() == null) {

						PlanRevisionEquipoDet valor = new PlanRevisionEquipoDet();
						valor.setEquipo(valorDto.getEquipo());
						valor.setPeriocidadDias(valorDto.getPeriocidadDias());
						valor.setPeriocidadHora(valorDto.getPeriocidadHora());
						valor.setPeriocidadKm(valorDto.getPeriocidadKm());
						valor.setCompartimientosEquipo(valorDto.getCompartimientosEquipo());
						valor.setSistemasEquipo(valorDto.getSistemasEquipo());
						valor.setInfoAdicional(valorDto.getInfoAdicional());
						valor.setInfoAdicional2(valorDto.getInfoAdicional2());
						valor.setFechaProxServicio(valorDto.getFechaProxServicio());
						valor.setFechaUltimoServicio(valorDto.getFechaUltimoServicio());
						valor.setHorasProxServicio(valorDto.getHorasProxServicio());
						valor.setHorasUltimoServicio(valorDto.getHorasUltimoServicio());
						
						valor.setKmProxServicio(valorDto.getKmProxServicio());
						valor.setKmUltimoServicio(valorDto.getKmUltimoServicio());
						
						valor.setAlertaMax(valorDto.getAlertaMax());
						valor.setAlertaMin(valorDto.getAlertaMin());

						valor.setObservacion(valorDto.getObservacion());
						
						valor.setPlanRevisionEquipo(entity);

						planRevisionEquipoDetDAO.save(valor);

					} else {

						PlanRevisionEquipoDet valor = planRevisionEquipoDetDAO
								.findById(valorDto.getPlanRevisionEquipoDetId());
						valor.setEquipo(valorDto.getEquipo());
						valor.setPeriocidadDias(valorDto.getPeriocidadDias());
						valor.setPeriocidadHora(valorDto.getPeriocidadHora());
						valor.setPeriocidadKm(valorDto.getPeriocidadKm());
						valor.setCompartimientosEquipo(valorDto.getCompartimientosEquipo());
						valor.setSistemasEquipo(valorDto.getSistemasEquipo());
						valor.setInfoAdicional(valorDto.getInfoAdicional());
						valor.setInfoAdicional2(valorDto.getInfoAdicional2());
						
						valor.setFechaProxServicio(valorDto.getFechaProxServicio());
						valor.setFechaUltimoServicio(valorDto.getFechaUltimoServicio());
						valor.setHorasProxServicio(valorDto.getHorasProxServicio());
						valor.setHorasUltimoServicio(valorDto.getHorasUltimoServicio());
						
						valor.setKmProxServicio(valorDto.getKmProxServicio());
						valor.setKmUltimoServicio(valorDto.getKmUltimoServicio());
						
						valor.setAlertaMax(valorDto.getAlertaMax());
						valor.setAlertaMin(valorDto.getAlertaMin());

						valor.setObservacion(valorDto.getObservacion());
						
						valor.setPlanRevisionEquipo(entity);

						planRevisionEquipoDetDAO.update(valor);
					}

				}
			}

			if (dataDetActividad != null) {

				for (PlanRevisionEquipoActivDTO valorDto : dataDetActividad) {

					if (valorDto.getPlanRevisionEquipoActivId() == null) {
						PlanRevisionEquipoActiv valor = new PlanRevisionEquipoActiv();
						valor.setDuracion(valorDto.getDuracion());
						valor.setLabor(valorDto.getLaborId());
						valor.setSecuencia(valorDto.getSecuencia());

						valor.setPlanRevisionEquipo(entity);

						planRevisionEquipoActivDAO.save(valor);

					} else {
						PlanRevisionEquipoActiv valor = planRevisionEquipoActivDAO
								.findById(valorDto.getPlanRevisionEquipoActivId());
						valor.setDuracion(valorDto.getDuracion());
						valor.setLabor(valorDto.getLaborId());
						valor.setSecuencia(valorDto.getSecuencia());

						valor.setPlanRevisionEquipo(entity);

						planRevisionEquipoActivDAO.update(valor);
					}

				}
			}
			if (dataRecursos != null) {

				for (PlanRevisionEquipoRecursosDTO valorDto : dataRecursos) {

					if (valorDto.getPlanRevisionEquipoRecursosId() == null) {

						PlanRevisionEquipoRecursos valor = new PlanRevisionEquipoRecursos();

						valor.setRecursoId(valorDto.getRecursoId());
						valor.setRendimientoRecurso(valorDto.getRendimientoRecurso());
						valor.setTpRecursoId(valorDto.getTpRecursoId());
						valor.setUdadMedId(valorDto.getUdadMedId());
						valor.setNombreRecurso(valorDto.getNombreRecurso());

						valor.setPlanRevisionEquipoRecursosId(entity.getPlanRevisionEquipoId());
						valor.setPlanRevisionEquipo(entity);
						planRevisionEquipoRecursosDAO.save(valor);

					} else {
						PlanRevisionEquipoRecursos valor = planRevisionEquipoRecursosDAO
								.findById(valorDto.getPlanRevisionEquipoRecursosId());

						valor.setRecursoId(valorDto.getRecursoId());
						valor.setRendimientoRecurso(valorDto.getRendimientoRecurso());
						valor.setTpRecursoId(valorDto.getTpRecursoId());
						valor.setUdadMedId(valorDto.getUdadMedId());
						valor.setNombreRecurso(valorDto.getNombreRecurso());

						valor.setPlanRevisionEquipo(entity);
						planRevisionEquipoRecursosDAO.update(valor);

					}

				}
			}

			if (dataPlanRevisionProd != null) {

				for (PlanRevisionProdDTO valorDto : dataPlanRevisionProd) {

					if (valorDto.getPlanRevisionProdId() == null) {

						PlanRevisionProd valor = new PlanRevisionProd();
						valor.setCantidad(valorDto.getCantidad());
						valor.setProducto(valorDto.getProductoId_Producto());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());
						valor.setPlanRevisionEquipoId(entity);

						planRevisionProdDAO.save(valor);

					} else {
						PlanRevisionProd valor = planRevisionProdDAO.findById(valorDto.getPlanRevisionProdId());

						valor.setCantidad(valorDto.getCantidad());
						valor.setProducto(valorDto.getProductoId_Producto());
						valor.setUdadMed(valorDto.getUdadMedId_UdadMed());
						valor.setPlanRevisionEquipoId(entity);

						planRevisionProdDAO.update(valor);

					}

				}
			}

			log.debug("update PlanRevisionEquipo successful");
		} catch (Exception e) {
			log.error("update PlanRevisionEquipo failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<PlanRevisionEquipoDTO> getDataPlanRevisionEquipo(String modulo, Long flagPlanRevision,
			String planSeleccionados) throws Exception {
		try {
			
			List<PlanRevisionEquipoDTO> planRevisionEquipoDTO = null;

			if (flagPlanRevision == 0L) {

				List<PlanRevisionEquipo> planRevisionEquipo = planRevisionEquipoDAO
						.findByCriteria("origenDatos = " + "'" + modulo + "'");

				planRevisionEquipoDTO = new ArrayList<PlanRevisionEquipoDTO>();

				for (PlanRevisionEquipo planRevisionEquipoTmp : planRevisionEquipo) {
					PlanRevisionEquipoDTO planRevisionEquipoDTO2 = new PlanRevisionEquipoDTO();

					planRevisionEquipoDTO2.setPlanRevisionEquipoId(planRevisionEquipoTmp.getPlanRevisionEquipoId());
					planRevisionEquipoDTO2.setCodigo(
							(planRevisionEquipoTmp.getCodigo() != null) ? planRevisionEquipoTmp.getCodigo() : null);
					planRevisionEquipoDTO2.setCompania(
							(planRevisionEquipoTmp.getCompania() != null) ? planRevisionEquipoTmp.getCompania() : null);
					planRevisionEquipoDTO2.setEstado(
							(planRevisionEquipoTmp.getEstado() != null) ? planRevisionEquipoTmp.getEstado() : null);
					planRevisionEquipoDTO2.setFechaCreacion(planRevisionEquipoTmp.getFechaCreacion());
					planRevisionEquipoDTO2.setFechaModificacion(planRevisionEquipoTmp.getFechaModificacion());
					planRevisionEquipoDTO2.setNombre(
							(planRevisionEquipoTmp.getNombre() != null) ? planRevisionEquipoTmp.getNombre() : null);
					planRevisionEquipoDTO2.setObservacion(
							(planRevisionEquipoTmp.getObservacion() != null) ? planRevisionEquipoTmp.getObservacion()
									: null);
					planRevisionEquipoDTO2.setTipoPlanRev(planRevisionEquipoTmp.getTipoPlan());
					planRevisionEquipoDTO2.setOrigenDatos(
							(planRevisionEquipoTmp.getOrigenDatos() != null) ? planRevisionEquipoTmp.getOrigenDatos()
									: null);

					planRevisionEquipoDTO.add(planRevisionEquipoDTO2);


				}

			} else {

				Long id = 1L;
				String[] parts = planSeleccionados.split(",");
				Long size = Long.parseLong(String.valueOf(parts.length));
				planRevisionEquipoDTO = new ArrayList<PlanRevisionEquipoDTO>();

				for (int i = 0; i < parts.length; i++) {
					
					id = Long.parseLong(parts[i].toString()) ;

					List<PlanRevisionEquipo> planRevisionEquipo = planRevisionEquipoDAO
							.findByCriteria("origenDatos = " + "'" + modulo + "'" + "and planRevisionEquipoId=" + id);

					for (PlanRevisionEquipo planRevisionEquipoTmp : planRevisionEquipo) {
						
						PlanRevisionEquipoDTO planRevisionEquipoDTO2 = new PlanRevisionEquipoDTO();

						planRevisionEquipoDTO2.setPlanRevisionEquipoId(planRevisionEquipoTmp.getPlanRevisionEquipoId());
						planRevisionEquipoDTO2.setCodigo(
								(planRevisionEquipoTmp.getCodigo() != null) ? planRevisionEquipoTmp.getCodigo() : null);
						planRevisionEquipoDTO2.setCompania(
								(planRevisionEquipoTmp.getCompania() != null) ? planRevisionEquipoTmp.getCompania()
										: null);
						planRevisionEquipoDTO2.setEstado(
								(planRevisionEquipoTmp.getEstado() != null) ? planRevisionEquipoTmp.getEstado() : null);
						planRevisionEquipoDTO2.setFechaCreacion(planRevisionEquipoTmp.getFechaCreacion());
						planRevisionEquipoDTO2.setFechaModificacion(planRevisionEquipoTmp.getFechaModificacion());
						planRevisionEquipoDTO2.setNombre(
								(planRevisionEquipoTmp.getNombre() != null) ? planRevisionEquipoTmp.getNombre() : null);
						planRevisionEquipoDTO2.setObservacion((planRevisionEquipoTmp.getObservacion() != null)
								? planRevisionEquipoTmp.getObservacion()
								: null);
						planRevisionEquipoDTO2.setTipoPlanRev(planRevisionEquipoTmp.getTipoPlan());
						planRevisionEquipoDTO2.setOrigenDatos((planRevisionEquipoTmp.getOrigenDatos() != null)
								? planRevisionEquipoTmp.getOrigenDatos()
								: null);

						planRevisionEquipoDTO.add(planRevisionEquipoDTO2);


					}

				}//for

			}
			

			return planRevisionEquipoDTO;

		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public PlanRevisionEquipo getPlanRevisionEquipo(Long planRevisionEquipoId) throws Exception {
		log.debug("getting PlanRevisionEquipo instance");

		PlanRevisionEquipo entity = null;

		try {
			entity = planRevisionEquipoDAO.findById(planRevisionEquipoId);
		} catch (Exception e) {
			log.error("get PlanRevisionEquipo failed", e);
			throw new ZMessManager().new FindingException("PlanRevisionEquipo");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<PlanRevisionEquipo> findPagePlanRevisionEquipo(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		List<PlanRevisionEquipo> entity = null;

		try {
			entity = planRevisionEquipoDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("PlanRevisionEquipo Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberPlanRevisionEquipo() throws Exception {
		Long entity = null;

		try {
			entity = planRevisionEquipoDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("PlanRevisionEquipo Count");
		} finally {
		}

		return entity;
	}

	/**
	 *
	 * @param varibles         este arreglo debera tener:
	 *
	 *                         [0] = String variable = (String) varibles[i];
	 *                         representa como se llama la variable en el pojo
	 *
	 *                         [1] = Boolean booVariable = (Boolean) varibles[i +
	 *                         1]; representa si el valor necesita o no ''(comillas
	 *                         simples)usado para campos de tipo string
	 *
	 *                         [2] = Object value = varibles[i + 2]; representa el
	 *                         valor que se va a buscar en la BD
	 *
	 *                         [3] = String comparator = (String) varibles[i + 3];
	 *                         representa que tipo de busqueda voy a hacer..,
	 *                         ejemplo: where nombre=william o where
	 *                         nombre<>william, en este campo iria el tipo de
	 *                         comparador que quiero si es = o <>
	 *
	 *                         Se itera de 4 en 4..., entonces 4 registros del
	 *                         arreglo representan 1 busqueda en un campo, si se
	 *                         ponen mas pues el continuara buscando en lo que se le
	 *                         ingresen en los otros 4
	 *
	 *
	 * @param variablesBetween
	 *
	 *                         la diferencia son estas dos posiciones
	 *
	 *                         [0] = String variable = (String) varibles[j]; la
	 *                         variable ne la BD que va a ser buscada en un rango
	 *
	 *                         [1] = Object value = varibles[j + 1]; valor 1 para
	 *                         buscar en un rango
	 *
	 *                         [2] = Object value2 = varibles[j + 2]; valor 2 para
	 *                         buscar en un rango ejempolo: a > 1 and a < 5 --> 1
	 *                         seria value y 5 seria value2
	 *
	 *                         [3] = String comparator1 = (String) varibles[j + 3];
	 *                         comparador 1 ejemplo: a comparator1 1 and a < 5
	 *
	 *                         [4] = String comparator2 = (String) varibles[j + 4];
	 *                         comparador 2 ejemplo: a comparador1>1 and a
	 *                         comparador2<5 (el original: a > 1 and a < 5) *
	 * @param                  variablesBetweenDates(en este caso solo para mysql)
	 *                         [0] = String variable = (String) varibles[k]; el
	 *                         nombre de la variable que hace referencia a una fecha
	 *
	 *                         [1] = Object object1 = varibles[k + 2]; fecha 1 a
	 *                         comparar(deben ser dates)
	 *
	 *                         [2] = Object object2 = varibles[k + 3]; fecha 2 a
	 *                         comparar(deben ser dates)
	 *
	 *                         esto hace un between entre las dos fechas.
	 *
	 * @return lista con los objetos que se necesiten
	 * @throws Exception
	 */
	@Override
	@Transactional(readOnly = true)
	public List<PlanRevisionEquipo> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<PlanRevisionEquipo> list = new ArrayList<PlanRevisionEquipo>();
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
			list = planRevisionEquipoDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
