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

import co.com.arcosoft.dataaccess.dao.ICompaniaDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.Compania;
import co.com.arcosoft.modelo.dto.CompaniaDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("CompaniaLogic")
public class CompaniaLogic implements ICompaniaLogic {
	private static final Logger log = LoggerFactory.getLogger(CompaniaLogic.class);

	/**
	 * DAO injected by Spring that manages Compania entities
	 *
	 */
	@Autowired
	private ICompaniaDAO companiaDAO;

	/**
	 * Logic injected by Spring that manages Ciudad entities
	 *
	 */
	@Autowired
	ICiudadLogic logicCiudad1;

	/**
	 * Logic injected by Spring that manages EntBanc entities
	 *
	 */
	@Autowired
	IEntBancLogic logicEntBanc2;

	@Override
	@Transactional(readOnly = true)
	public List<Compania> getCompania() throws Exception {
		log.debug("finding all Compania instances");

		List<Compania> list = new ArrayList<Compania>();

		try {
			list = companiaDAO.findAll();
		} catch (Exception e) {
			log.error("finding all Compania failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "Compania");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveCompania(Compania entity) throws Exception {
		log.debug("saving Compania instance");

		try {
			/*
			 * if (entity.getCiudad() == null) { throw new ZMessManager().new
			 * ForeignException("ciudad"); }
			 * 
			 * if (entity.getEntBanc() == null) { throw new ZMessManager().new
			 * ForeignException("entBanc"); }
			 */

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getDireccion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getDireccion(), 300) == false)) {
				throw new ZMessManager().new NotValidFormatException("direccion");
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

			/*
			 * if ((entity.getLatitud() != null) &&
			 * (Utilities.checkWordAndCheckWithlength( entity.getLatitud(), 40)
			 * == false)) { throw new ZMessManager().new
			 * NotValidFormatException("latitud"); }
			 * 
			 * if ((entity.getLongitud() != null) &&
			 * (Utilities.checkWordAndCheckWithlength( entity.getLongitud(), 40)
			 * == false)) { throw new ZMessManager().new
			 * NotValidFormatException("longitud"); }
			 * 
			 * if ((entity.getPrecision() != null) &&
			 * (Utilities.checkWordAndCheckWithlength( entity.getPrecision(),
			 * 40) == false)) { throw new ZMessManager().new
			 * NotValidFormatException( "precision"); }
			 */
			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			if ((entity.getPbx() != null) && (Utilities.checkWordAndCheckWithlength(entity.getPbx(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("pbx");
			}

			if ((entity.getRut() != null) && (Utilities.checkWordAndCheckWithlength(entity.getRut(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("rut");
			}

			if ((entity.getTelefono() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getTelefono(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("telefono");
			}

			/*
			 * if (entity.getCiudad().getCiudadId() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "ciudadId_Ciudad"); }
			 */

			if ((entity.getCiudad() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCiudad(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("ciudadId_Ciudad");
			}

			/*
			 * if (entity.getEntBanc() == null) { throw new ZMessManager().new
			 * EmptyFieldException( "entBancId_EntBanc"); }
			 */

			if ((entity.getEntBanc() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEntBanc(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("entBancId_EntBanc");
			}
			/*
			 * if (entity.getCompaniaId() == null) { throw new
			 * ZMessManager().new EmptyFieldException("companiaId"); }
			 * 
			 * if ((entity.getCompaniaId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getCompaniaId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "companiaId"); } if
			 * (getCompania(entity.getCompaniaId()) != null) { throw new
			 * ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */

			companiaDAO.save(entity);

			log.debug("save Compania successful");
		} catch (Exception e) {
			log.error("save Compania failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteCompania(Compania entity) throws Exception {
		log.debug("deleting Compania instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Compania");
		}

		if (entity.getCompaniaId() == null) {
			throw new ZMessManager().new EmptyFieldException("companiaId");
		}

		try {
			companiaDAO.delete(entity);

			log.debug("delete Compania successful");
		} catch (Exception e) {
			log.error("delete Compania failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateCompania(Compania entity) throws Exception {
		log.debug("updating Compania instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Compania");
			}

			/*
			 * if (entity.getCiudad() == null) { throw new ZMessManager().new
			 * ForeignException("ciudad"); }
			 * 
			 * if (entity.getEntBanc() == null) { throw new ZMessManager().new
			 * ForeignException("entBanc"); }
			 */

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if (entity.getCompaniaId() == null) {
				throw new ZMessManager().new EmptyFieldException("companiaId");
			}

			if ((entity.getCompaniaId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompaniaId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("companiaId");
			}

			if ((entity.getDireccion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getDireccion(), 300) == false)) {
				throw new ZMessManager().new NotValidFormatException("direccion");
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
			/*
			 * if ((entity.getLatitud() != null) &&
			 * (Utilities.checkWordAndCheckWithlength( entity.getLatitud(), 40)
			 * == false)) { throw new ZMessManager().new
			 * NotValidFormatException("latitud"); }
			 * 
			 * if ((entity.getLongitud() != null) &&
			 * (Utilities.checkWordAndCheckWithlength( entity.getLongitud(), 40)
			 * == false)) { throw new ZMessManager().new
			 * NotValidFormatException("longitud"); }
			 * 
			 * if ((entity.getPrecision() != null) &&
			 * (Utilities.checkWordAndCheckWithlength( entity.getPrecision(),
			 * 40) == false)) { throw new ZMessManager().new
			 * NotValidFormatException( "precision"); }
			 */
			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			if ((entity.getPbx() != null) && (Utilities.checkWordAndCheckWithlength(entity.getPbx(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("pbx");
			}

			if ((entity.getRut() != null) && (Utilities.checkWordAndCheckWithlength(entity.getRut(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("rut");
			}

			if ((entity.getTelefono() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getTelefono(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("telefono");
			}

			/*
			 * if (entity.getCiudad().getCiudadId() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "ciudadId_Ciudad"); }
			 */

			if ((entity.getCiudad() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCiudad(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("ciudadId_Ciudad");
			}

			/*
			 * if (entity.getEntBanc().getEntBancId() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "entBancId_EntBanc"); }
			 */

			if ((entity.getEntBanc() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEntBanc(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("entBancId_EntBanc");
			}

			companiaDAO.update(entity);

			log.debug("update Compania successful");
		} catch (Exception e) {
			log.error("update Compania failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<CompaniaDTO> getDataCompania() throws Exception {
		try {
			List<Compania> compania = companiaDAO.findAll();

			List<CompaniaDTO> companiaDTO = new ArrayList<CompaniaDTO>();

			for (Compania companiaTmp : compania) {
				CompaniaDTO companiaDTO2 = new CompaniaDTO();

				companiaDTO2.setCompaniaId(companiaTmp.getCompaniaId());
				companiaDTO2.setCodigo((companiaTmp.getCodigo() != null) ? companiaTmp.getCodigo() : null);
				companiaDTO2.setDireccion((companiaTmp.getDireccion() != null) ? companiaTmp.getDireccion() : null);
				companiaDTO2.setEstado((companiaTmp.getEstado() != null) ? companiaTmp.getEstado() : null);
				companiaDTO2.setFechaCreacion(companiaTmp.getFechaCreacion());
				companiaDTO2.setFechaModificacion(companiaTmp.getFechaModificacion());
				companiaDTO2.setInfoAdicional((companiaTmp.getInfoAdicional() != null) ? companiaTmp.getInfoAdicional() : null);
				companiaDTO2.setInfoAdicional2((companiaTmp.getInfoAdicional2() != null) ? companiaTmp.getInfoAdicional2() : null);
				companiaDTO2.setLatitud((companiaTmp.getLatitud() != null) ? companiaTmp.getLatitud() : null);
				companiaDTO2.setLongitud((companiaTmp.getLongitud() != null) ? companiaTmp.getLongitud() : null);
				companiaDTO2.setNombre((companiaTmp.getNombre() != null) ? companiaTmp.getNombre() : null);
				companiaDTO2.setPbx((companiaTmp.getPbx() != null) ? companiaTmp.getPbx() : null);
				companiaDTO2.setPrecision((companiaTmp.getPrecision() != null) ? companiaTmp.getPrecision() : null);
				companiaDTO2.setRut((companiaTmp.getRut() != null) ? companiaTmp.getRut() : null);
				companiaDTO2.setTelefono((companiaTmp.getTelefono() != null) ? companiaTmp.getTelefono() : null);
				companiaDTO2.setCiudadId_Ciudad((companiaTmp.getCiudad() != null) ? companiaTmp.getCiudad() : null);
				companiaDTO2.setEntBancId_EntBanc((companiaTmp.getEntBanc() != null) ? companiaTmp.getEntBanc() : null);
				companiaDTO2.setNivelAutorizaLabor((companiaTmp.getNivelAutorizaLabor() != null) ? companiaTmp.getNivelAutorizaLabor() : null);

				companiaDTO2.setValorUvt((companiaTmp.getValorUvt() != null) ? companiaTmp.getValorUvt() : null);
				companiaDTO2.setSalarioMinimoLegal((companiaTmp.getSalarioMinimoLegal() != null) ? companiaTmp.getSalarioMinimoLegal() : null);
				companiaDTO2.setTopeSmlAuxTransporte((companiaTmp.getTopeSmlAuxTransporte() != null) ? companiaTmp.getTopeSmlAuxTransporte() : null);
				companiaDTO2.setRentasExentasUvt((companiaTmp.getRentasExentasUvt() != null) ? companiaTmp.getRentasExentasUvt() : null);
				companiaDTO2.setPorcMinContribucion((companiaTmp.getPorcMinContribucion() != null) ? companiaTmp.getPorcMinContribucion() : null);
				companiaDTO2.setIpc((companiaTmp.getIpc() != null) ? companiaTmp.getIpc() : null);				
				companiaDTO2.setAuxilioTransporte((companiaTmp.getAuxilioTransporte() != null) ? companiaTmp.getAuxilioTransporte() : null);
				companiaDTO2.setPorcRentasExternas((companiaTmp.getPorcRentasExternas() != null) ? companiaTmp.getPorcRentasExternas() : null);
				companiaDTO2.setPorcLey1527((companiaTmp.getPorcLey1527() != null) ? companiaTmp.getPorcLey1527() : null);
				companiaDTO2.setTarifaIvaRetenido((companiaTmp.getTarifaIvaRetenido() != null) ? companiaTmp.getTarifaIvaRetenido() : null);
				companiaDTO2.setPorcProvisionCesantias((companiaTmp.getPorcProvisionCesantias() != null) ? companiaTmp.getPorcProvisionCesantias() : null);				
				companiaDTO2.setPorcProvisionPrimas((companiaTmp.getPorcProvisionPrimas() != null) ? companiaTmp.getPorcProvisionPrimas() : null);
				companiaDTO2.setPorcProvisionVacaciones((companiaTmp.getPorcProvisionVacaciones() != null) ? companiaTmp.getPorcProvisionVacaciones() : null);
				companiaDTO2.setPorcProvisionInteresesCesantias((companiaTmp.getPorcProvisionInteresesCesantias() != null) ? companiaTmp.getPorcProvisionInteresesCesantias() : null);
				companiaDTO2.setPorcAporteEpsEmpleador((companiaTmp.getPorcAporteEpsEmpleador() != null) ? companiaTmp.getPorcAporteEpsEmpleador() : null);				
				companiaDTO2.setPorcAporteAfpAltoRiesgoEmpleador((companiaTmp.getPorcAporteAfpAltoRiesgoEmpleador() != null) ? companiaTmp.getPorcAporteAfpAltoRiesgoEmpleador() : null);
				companiaDTO2.setPorcAporteIcbfEmpleador((companiaTmp.getPorcAporteIcbfEmpleador() != null) ? companiaTmp.getPorcAporteIcbfEmpleador() : null);
				companiaDTO2.setPorcAporteAfpEmpleador((companiaTmp.getPorcAporteAfpEmpleador() != null) ? companiaTmp.getPorcAporteAfpEmpleador() : null);
				companiaDTO2.setPorcAporteCcfEmpleador((companiaTmp.getPorcAporteCcfEmpleador() != null) ? companiaTmp.getPorcAporteCcfEmpleador() : null);
				companiaDTO2.setPorcAporteSenaEmpleador((companiaTmp.getValorUvt() != null) ? companiaTmp.getValorUvt() : null);
				companiaDTO2.setMinimoSmlAporteSenaIcbf((companiaTmp.getMinimoSmlAporteSenaIcbf() != null) ? companiaTmp.getMinimoSmlAporteSenaIcbf() : null);				
				companiaDTO2.setAportesNominaLiquidan((companiaTmp.getAportesNominaLiquidan() != null) ? companiaTmp.getAportesNominaLiquidan() : null);
				companiaDTO2.setTopeSmlCotizarEps((companiaTmp.getTopeSmlCotizarEps() != null) ? companiaTmp.getTopeSmlCotizarEps() : null);
				companiaDTO2.setTopeSmlCotizarAfp((companiaTmp.getTopeSmlCotizarAfp() != null) ? companiaTmp.getTopeSmlCotizarAfp() : null);
				companiaDTO2.setTopeSmlCotizarArl((companiaTmp.getTopeSmlCotizarArl() != null) ? companiaTmp.getTopeSmlCotizarArl() : null);
				companiaDTO2.setAuxilioTransporteLiquidan((companiaTmp.getAuxilioTransporteLiquidan() != null) ? companiaTmp.getAuxilioTransporteLiquidan() : null);
				companiaDTO2.setPorcAporteEpsTrabajador((companiaTmp.getPorcAporteEpsTrabajador() != null) ? companiaTmp.getPorcAporteEpsTrabajador() : null);
				companiaDTO2.setPorcAporteAfpTrabajador((companiaTmp.getPorcAporteAfpTrabajador() != null) ? companiaTmp.getPorcAporteAfpTrabajador() : null);
				companiaDTO2.setPorcAporteFspTrabajador((companiaTmp.getPorcAporteFspTrabajador() != null) ? companiaTmp.getPorcAporteFspTrabajador() : null);
				companiaDTO2.setMinimoSmlAportaFSP((companiaTmp.getMinimoSmlAportaFSP() != null) ? companiaTmp.getMinimoSmlAportaFSP() : null);
				
				companiaDTO2.setDevengoMinimoDiario((companiaTmp.getDevengoMinimoDiario() != null) ? companiaTmp.getDevengoMinimoDiario() : null);
				
				companiaDTO2.setProductoCombustibleId((companiaTmp.getProductoCombustibleId() != null) ? companiaTmp.getProductoCombustibleId() : null);
				companiaDTO2.setKardexEntradaEstandar((companiaTmp.getKardexEntradaEstandar() != null) ? companiaTmp.getKardexEntradaEstandar() : null);
				companiaDTO2.setKardexSalidaEstandar((companiaTmp.getKardexSalidaEstandar() != null) ? companiaTmp.getKardexSalidaEstandar() : null);
				
				companiaDTO.add(companiaDTO2);
			}

			return companiaDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Compania getCompania(Long companiaId) throws Exception {
		log.debug("getting Compania instance");

		Compania entity = null;

		try {
			entity = companiaDAO.findById(companiaId);
		} catch (Exception e) {
			log.error("get Compania failed", e);
			throw new ZMessManager().new FindingException("Compania");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Compania> findPageCompania(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<Compania> entity = null;

		try {
			entity = companiaDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Compania Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberCompania() throws Exception {
		Long entity = null;

		try {
			entity = companiaDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Compania Count");
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
	public List<Compania> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<Compania> list = new ArrayList<Compania>();
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
			list = companiaDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
