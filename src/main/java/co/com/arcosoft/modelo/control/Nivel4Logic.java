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

import co.com.arcosoft.dataaccess.dao.IDatSanVegDAO;
import co.com.arcosoft.dataaccess.dao.IEstructSiembDAO;
import co.com.arcosoft.dataaccess.dao.INivel4DAO;
import co.com.arcosoft.dataaccess.dao.IPersEmprDAO;
import co.com.arcosoft.dataaccess.dao.IRestrMaduranteDAO;
import co.com.arcosoft.dataaccess.dao.IRestrQuemaDAO;
import co.com.arcosoft.dataaccess.dao.IRestriMaduranteNivel4DAO;
import co.com.arcosoft.dataaccess.dao.IRestriccionQuemaNivel4DAO;
import co.com.arcosoft.dataaccess.dao.IVariedadDAO;
import co.com.arcosoft.dataaccess.dao.IVariedadNivel4DAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatSanVeg;
import co.com.arcosoft.modelo.EstructSiemb;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.RestrMadurante;
import co.com.arcosoft.modelo.RestrQuema;
import co.com.arcosoft.modelo.RestriMaduranteNivel4;
import co.com.arcosoft.modelo.RestriMaduranteNivel4Id;
import co.com.arcosoft.modelo.RestriccionQuemaNivel4;
import co.com.arcosoft.modelo.RestriccionQuemaNivel4Id;
import co.com.arcosoft.modelo.VariedadNivel4;
import co.com.arcosoft.modelo.dto.Nivel4DTO;
import co.com.arcosoft.modelo.dto.VariedadNivel4DTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("Nivel4Logic")
public class Nivel4Logic implements INivel4Logic {
	private static final Logger log = LoggerFactory.getLogger(Nivel4Logic.class);

	/**
	 * DAO injected by Spring that manages Nivel4 entities
	 *
	 */
	@Autowired
	private INivel4DAO nivel4DAO;

	/**
	 * DAO injected by Spring that manages DatSanVeg entities
	 *
	 */
	@Autowired
	private IDatSanVegDAO datSanVegDAO;

	/**
	 * DAO injected by Spring that manages EstructSiemb entities
	 *
	 */
	@Autowired
	private IEstructSiembDAO estructSiembDAO;

	/**
	 * DAO injected by Spring that manages RestriMaduranteNivel4 entities
	 *
	 */
	@Autowired
	private IRestriMaduranteNivel4DAO restriMaduranteNivel4DAO;

	/**
	 * DAO injected by Spring that manages RestriccionQuemaNivel4 entities
	 *
	 */
	@Autowired
	private IRestriccionQuemaNivel4DAO restriccionQuemaNivel4DAO;

	@Autowired
	private IRestrQuemaDAO restrQuemaDAO;

	@Autowired
	private IRestrMaduranteDAO restrMaduranteDAO;

	/**
	 * DAO injected by Spring that manages VariedadNivel4 entities
	 *
	 */
	@Autowired
	private IVariedadNivel4DAO variedadNivel4DAO;

	/**
	 * Logic injected by Spring that manages Almacen entities
	 *
	 */
	@Autowired
	IAlmacenLogic logicAlmacen1;

	/**
	 * Logic injected by Spring that manages AnioFiscal entities
	 *
	 */
	@Autowired
	IAnioFiscalLogic logicAnioFiscal2;

	/**
	 * Logic injected by Spring that manages ClaseTextSuelo entities
	 *
	 */
	@Autowired
	IClaseTextSueloLogic logicClaseTextSuelo3;

	/**
	 * Logic injected by Spring that manages EstClimat entities
	 *
	 */
	@Autowired
	IEstClimatLogic logicEstClimat4;

	/**
	 * Logic injected by Spring that manages EstEvaporimetro entities
	 *
	 */
	@Autowired
	IEstEvaporimetroLogic logicEstEvaporimetro5;

	/**
	 * Logic injected by Spring that manages EstPluvio entities
	 *
	 */
	@Autowired
	IEstPluvioLogic logicEstPluvio6;

	/**
	 * Logic injected by Spring that manages Etapa entities
	 *
	 */
	@Autowired
	IEtapaLogic logicEtapa7;

	/**
	 * Logic injected by Spring that manages FaseFenologica entities
	 *
	 */
	@Autowired
	IFaseFenologicaLogic logicFaseFenologica8;

	/**
	 * Logic injected by Spring that manages FliaTextSuelo entities
	 *
	 */
	@Autowired
	IFliaTextSueloLogic logicFliaTextSuelo9;

	/**
	 * Logic injected by Spring that manages GrpSuelo entities
	 *
	 */
	@Autowired
	IGrpSueloLogic logicGrpSuelo10;

	/**
	 * Logic injected by Spring that manages N4Motivo entities
	 *
	 */
	@Autowired
	IN4MotivoLogic logicN4Motivo11;

	/**
	 * Logic injected by Spring that manages Nivel3 entities
	 *
	 */
	@Autowired
	INivel3Logic logicNivel312;

	/**
	 * Logic injected by Spring that manages Ocupacion entities
	 *
	 */
	@Autowired
	IOcupacionLogic logicOcupacion13;

	/**
	 * Logic injected by Spring that manages OrdenSuelo entities
	 *
	 */
	@Autowired
	IOrdenSueloLogic logicOrdenSuelo14;

	/**
	 * Logic injected by Spring that manages Organizacion entities
	 *
	 */
	@Autowired
	IOrganizacionLogic logicOrganizacion15;

	/**
	 * Logic injected by Spring that manages PersEmpr entities
	 *
	 */
	@Autowired
	IPersEmprLogic persEmprLogic;

	/**
	 * Logic injected by Spring that manages SerieSuelo entities
	 *
	 */
	@Autowired
	ISerieSueloLogic logicSerieSuelo17;

	/**
	 * Logic injected by Spring that manages Tenencia entities
	 *
	 */
	@Autowired
	ITenenciaLogic logicTenencia18;

	/**
	 * Logic injected by Spring that manages TipCultivo entities
	 *
	 */
	@Autowired
	ITipCultivoLogic logicTipCultivo19;

	/**
	 * Logic injected by Spring that manages TipoDrenaje entities
	 *
	 */
	@Autowired
	ITipoDrenajeLogic logicTipoDrenaje20;

	/**
	 * Logic injected by Spring that manages Topografia entities
	 *
	 */
	@Autowired
	ITopografiaLogic logicTopografia21;

	/**
	 * Logic injected by Spring that manages Trabajador entities
	 *
	 */
	@Autowired
	ITrabajadorLogic logicTrabajador22;

	/**
	 * Logic injected by Spring that manages ZonAgroec entities
	 *
	 */
	@Autowired
	IZonAgroecLogic logicZonAgroec23;

	@Override
	@Transactional(readOnly = true)
	public List<Nivel4> getNivel4() throws Exception {
		log.debug("finding all Nivel4 instances");

		List<Nivel4> list = new ArrayList<Nivel4>();

		try {
			list = nivel4DAO.findAll();
		} catch (Exception e) {
			log.error("finding all Nivel4 failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "Nivel4");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveNivel4(Nivel4 entity, List<String> restriccionDeQuema, List<String> restriccionDeMadurante,
			List<VariedadNivel4DTO> dataVariedad) throws Exception {
		log.debug("saving Nivel4 instance");

		try {
			/*
			 * if (entity.getAlmacen() == null) { throw new ZMessManager().new
			 * ForeignException("almacen"); }
			 * 
			 * if (entity.getAnioFiscal() == null) { throw new
			 * ZMessManager().new ForeignException("anioFiscal"); }
			 * 
			 * if (entity.getClaseTextSuelo() == null) { throw new
			 * ZMessManager().new ForeignException("claseTextSuelo"); }
			 * 
			 * if (entity.getEstClimat() == null) { throw new ZMessManager().new
			 * ForeignException("estClimat"); }
			 * 
			 * if (entity.getEstEvaporimetro() == null) { throw new
			 * ZMessManager().new ForeignException("estEvaporimetro"); }
			 * 
			 * if (entity.getEstPluvio() == null) { throw new ZMessManager().new
			 * ForeignException("estPluvio"); }
			 * 
			 * if (entity.getEtapa() == null) { throw new ZMessManager().new
			 * ForeignException("etapa"); }
			 * 
			 * if (entity.getFaseFenologica() == null) { throw new
			 * ZMessManager().new ForeignException("faseFenologica"); }
			 * 
			 * if (entity.getFliaTextSuelo() == null) { throw new
			 * ZMessManager().new ForeignException("fliaTextSuelo"); }
			 * 
			 * if (entity.getGrpSuelo() == null) { throw new ZMessManager().new
			 * ForeignException("grpSuelo"); }
			 * 
			 * if (entity.getN4Motivo() == null) { throw new ZMessManager().new
			 * ForeignException("n4Motivo"); }
			 * 
			 * if (entity.getNivel3() == null) { throw new ZMessManager().new
			 * ForeignException("nivel3"); }
			 * 
			 * if (entity.getOcupacion() == null) { throw new ZMessManager().new
			 * ForeignException("ocupacion"); }
			 * 
			 * if (entity.getOrdenSuelo() == null) { throw new
			 * ZMessManager().new ForeignException("ordenSuelo"); }
			 * 
			 * if (entity.getOrganizacion() == null) { throw new
			 * ZMessManager().new ForeignException("organizacion"); }
			 * 
			 * if (entity.getProveedor() == null) { throw new ZMessManager().new
			 * ForeignException("proveedor"); }
			 * 
			 * if (entity.getSerieSuelo() == null) { throw new
			 * ZMessManager().new ForeignException("serieSuelo"); }
			 * 
			 * if (entity.getTenencia() == null) { throw new ZMessManager().new
			 * ForeignException("tenencia"); }
			 * 
			 * if (entity.getTipCultivo() == null) { throw new
			 * ZMessManager().new ForeignException("tipCultivo"); }
			 * 
			 * if (entity.getTipoDrenaje() == null) { throw new
			 * ZMessManager().new ForeignException("tipoDrenaje"); }
			 * 
			 * if (entity.getTopografia() == null) { throw new
			 * ZMessManager().new ForeignException("topografia"); }
			 * 
			 * if (entity.getTrabajador() == null) { throw new
			 * ZMessManager().new ForeignException("trabajador"); }
			 * 
			 * if (entity.getZonAgroec() == null) { throw new ZMessManager().new
			 * ForeignException("zonAgroec"); }
			 */

			if ((entity.getAlturaPromedioPlantas() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAlturaPromedioPlantas(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("alturaPromedioPlantas");
			}

			if ((entity.getAna1() != null) && (Utilities.checkWordAndCheckWithlength(entity.getAna1(), 40) == false)) {
				throw new ZMessManager().new NotValidFormatException("ana1");
			}

			if ((entity.getAplicacionMadurante() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAplicacionMadurante(), 1, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("aplicacionMadurante");
			}

			if ((entity.getAreaBruta() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAreaBruta(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("areaBruta");
			}

			if ((entity.getAreaInutil() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAreaInutil(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("areaInutil");
			}

			if ((entity.getAreaManual() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAreaManual(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("areaManual");
			}

			if ((entity.getAreaMecanizada() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAreaMecanizada(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("areaMecanizada");
			}

			if ((entity.getAreaNeta() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAreaNeta(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("areaNeta");
			}

			if ((entity.getAreaOtrosCultivos() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAreaOtrosCultivos(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("areaOtrosCultivos");
			}

			if ((entity.getAreaReservada() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAreaReservada(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("areaReservada");
			}

			if ((entity.getAreaRestringida() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAreaRestringida(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("areaRestringida");
			}

			if ((entity.getSistemaRiego() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSistemaRiego(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("sistemaRiego");
			}

			if ((entity.getCantidadValvulasRiego() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCantidadValvulasRiego(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("cantidadValvulasRiego");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			/*
			 * if ((entity.getCodigoUsuarioApertura() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getCodigoUsuarioApertura(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException(
			 * "codigoUsuarioApertura"); }
			 * 
			 * if ((entity.getCodigoUsuarioCierre() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getCodigoUsuarioCierre(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException(
			 * "codigoUsuarioCierre"); }
			 * 
			 * if ((entity.getCompania() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getCompania(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException("compania"); }
			 */

			if ((entity.getCostosAmortizados() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCostosAmortizados(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("costosAmortizados");
			}

			if ((entity.getEdadActual() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEdadActual(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("edadActual");
			}

			if ((entity.getEdadUltimaCosecha() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEdadUltimaCosecha(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("edadUltimaCosecha");
			}

		

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			/*
			 * if ((entity.getFechaAnalisisPreCosecha() != null) &&
			 * (Utilities.checkWordAndCheckWithlength(
			 * entity.getFechaAnalisisPreCosecha(), 10) == false)) { throw new
			 * ZMessManager().new NotValidFormatException(
			 * "fechaAnalisisPreCosecha"); }
			 */

			/*
			 * if ((entity.getFotoInfraestructura() != null) &&
			 * (Utilities.checkWordAndCheckWithlength(
			 * entity.getFotoInfraestructura(), 300) == false)) { throw new
			 * ZMessManager().new NotValidFormatException(
			 * "fotoInfraestructura"); }
			 */

			if ((entity.getGenerico() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getGenerico(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("generico");
			}

			if ((entity.getIndiceHelada() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getIndiceHelada(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("indiceHelada");
			}

			if ((entity.getInfoAdicional() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional");
			}

			if ((entity.getInfoAdicional2() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional2(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional2");
			}

			if ((entity.getKilmNivel4Fab() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getKilmNivel4Fab(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("kilmNivel4Fab");
			}

			if ((entity.getKilmNivel4FabPav() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getKilmNivel4FabPav(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("kilmNivel4FabPav");
			}

			if ((entity.getKilmNivel4FabTerraceria() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getKilmNivel4FabTerraceria(), 8,
							4) == false)) {
				throw new ZMessManager().new NotValidFormatException("kilmNivel4FabTerraceria");
			}

			/*
			 * if (entity.getNivel4Id() == null) { throw new ZMessManager().new
			 * EmptyFieldException("nivel4Id"); }
			 * 
			 * if ((entity.getNivel4Id() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getNivel4Id(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException("nivel4Id"); }
			 */

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			if ((entity.getNumComederosHect() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumComederosHect(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("numComederosHect");
			}

			if ((entity.getNumDensidadActual() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumDensidadActual(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("numDensidadActual");
			}

			if ((entity.getNumDensidadSiembra() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumDensidadSiembra(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("numDensidadSiembra");
			}

			if ((entity.getNumEstimTonAnioFiscal() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumEstimTonAnioFiscal(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("numEstimTonAnioFiscal");
			}

		

			if ((entity.getNumEstimTonMesAnioFiscal() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumEstimTonMesAnioFiscal(), 8,
							4) == false)) {
				throw new ZMessManager().new NotValidFormatException("numEstimTonMesAnioFiscal");
			}

			if ((entity.getNumHectCosIndFab() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumHectCosIndFab(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("numHectCosIndFab");
			}

			if ((entity.getNumHectOtroDestino() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumHectOtroDestino(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("numHectOtroDestino");
			}

			if ((entity.getNumHectUltCosecha() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumHectUltCosecha(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("numHectUltCosecha");
			}

			if ((entity.getNumLarvasSembradas() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumLarvasSembradas(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("numLarvasSembradas");
			}

			if ((entity.getNumLineasSembradas() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumLineasSembradas(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("numLineasSembradas");
			}

			if ((entity.getNumPlantasActuales() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumPlantasActuales(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("numPlantasActuales");
			}

			if ((entity.getNumPlantasSembradas() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumPlantasSembradas(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("numPlantasSembradas");
			}

			if ((entity.getNumPlantasSembradas2() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumPlantasSembradas2(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("numPlantasSembradas2");
			}

			if ((entity.getNumRacionesCrustaceos() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumRacionesCrustaceos(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("numRacionesCrustaceos");
			}

			if ((entity.getNumTonCosIndFab() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumTonCosIndFab(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("numTonCosIndFab");
			}

			if ((entity.getNumTonOtroDestino() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumTonOtroDestino(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("numTonOtroDestino");
			}

			if ((entity.getNumTonUltCosecha() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumTonUltCosecha(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("numTonUltCosecha");
			}

			if ((entity.getPesoPromedioNivel4() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getPesoPromedioNivel4(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("pesoPromedioNivel4");
			}

			if ((entity.getRenovacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getRenovacion(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("renovacion");
			}

			if ((entity.getSemillero() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getSemillero(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("semillero");
			}

			if ((entity.getTotalComederos() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTotalComederos(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("totalComederos");
			}

			if ((entity.getUltDosisAplicadaMadurante() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getUltDosisAplicadaMadurante(),
							8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("ultDosisAplicadaMadurante");
			}

			if ((entity.getPersEmpr() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getPersEmpr(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("proveId_Proveedor");
			}

			/*
			 * if (entity.getAlmacen().getAlmacenId() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "almacenId_Almacen"); }
			 * 
			 * if ((entity.getAlmacen().getAlmacenId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getAlmacen().getAlmacenId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "almacenId_Almacen");
			 * }
			 * 
			 * if (entity.getAnioFiscal().getAnioFiscalId() == null) { throw new
			 * ZMessManager().new EmptyFieldException(
			 * "anioFiscalId_AnioFiscal"); }
			 * 
			 * if ((entity.getAnioFiscal().getAnioFiscalId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getAnioFiscal().getAnioFiscalId(), 18, 0) == false)) {
			 * throw new ZMessManager().new NotValidFormatException(
			 * "anioFiscalId_AnioFiscal"); }
			 * 
			 * if (entity.getClaseTextSuelo().getClaseTextSueloId() == null) {
			 * throw new ZMessManager().new EmptyFieldException(
			 * "claseTextSueloId_ClaseTextSuelo"); }
			 * 
			 * if ((entity.getClaseTextSuelo().getClaseTextSueloId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getClaseTextSuelo().getClaseTextSueloId(), 18, 0) ==
			 * false)) { throw new ZMessManager().new NotValidFormatException(
			 * "claseTextSueloId_ClaseTextSuelo"); }
			 * 
			 * if (entity.getEstClimat().getEstClimatId() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "estClimatId_EstClimat");
			 * }
			 * 
			 * if ((entity.getEstClimat().getEstClimatId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getEstClimat().getEstClimatId(), 18, 0) == false)) { throw
			 * new ZMessManager().new NotValidFormatException(
			 * "estClimatId_EstClimat"); }
			 * 
			 * if (entity.getEstEvaporimetro().getEstEvaporimetroId() == null) {
			 * throw new ZMessManager().new EmptyFieldException(
			 * "estEvaporimetroId_EstEvaporimetro"); }
			 * 
			 * if ((entity.getEstEvaporimetro().getEstEvaporimetroId() != null)
			 * && (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getEstEvaporimetro() .getEstEvaporimetroId(), 18, 0) ==
			 * false)) { throw new ZMessManager().new NotValidFormatException(
			 * "estEvaporimetroId_EstEvaporimetro"); }
			 * 
			 * if (entity.getEstPluvio().getEstPluvioId() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "estPluvioId_EstPluvio");
			 * }
			 * 
			 * if ((entity.getEstPluvio().getEstPluvioId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getEstPluvio().getEstPluvioId(), 18, 0) == false)) { throw
			 * new ZMessManager().new NotValidFormatException(
			 * "estPluvioId_EstPluvio"); }
			 * 
			 * if (entity.getEtapa().getEtapaId() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "etapaId_Etapa"); }
			 * 
			 * if ((entity.getEtapa().getEtapaId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getEtapa().getEtapaId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "etapaId_Etapa"); }
			 * 
			 * if (entity.getFaseFenologica().getFaseFenoId() == null) { throw
			 * new ZMessManager().new EmptyFieldException(
			 * "faseFenoId_FaseFenologica"); }
			 * 
			 * if ((entity.getFaseFenologica().getFaseFenoId() != null) &&
			 * (Utilities .checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getFaseFenologica() .getFaseFenoId(), 18, 0) == false)) {
			 * throw new ZMessManager().new NotValidFormatException(
			 * "faseFenoId_FaseFenologica"); }
			 * 
			 * if (entity.getFliaTextSuelo().getFliaTextSueloId() == null) {
			 * throw new ZMessManager().new EmptyFieldException(
			 * "fliaTextSueloId_FliaTextSuelo"); }
			 * 
			 * if ((entity.getFliaTextSuelo().getFliaTextSueloId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getFliaTextSuelo().getFliaTextSueloId(), 18, 0) == false))
			 * { throw new ZMessManager().new NotValidFormatException(
			 * "fliaTextSueloId_FliaTextSuelo"); }
			 * 
			 * if (entity.getGrpSuelo().getGrupoSuelo() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "grupoSuelo_GrpSuelo"); }
			 * 
			 * if ((entity.getGrpSuelo().getGrupoSuelo() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getGrpSuelo().getGrupoSuelo(), 18, 0) == false)) { throw
			 * new ZMessManager().new NotValidFormatException(
			 * "grupoSuelo_GrpSuelo"); }
			 * 
			 * if (entity.getN4Motivo().getN4Mot() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "n4Mot_N4Motivo"); }
			 * 
			 * if ((entity.getN4Motivo().getN4Mot() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getN4Motivo().getN4Mot(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "n4Mot_N4Motivo"); }
			 */

			if (entity.getNivel3().getNivel3Id() == null) {
				throw new ZMessManager().new EmptyFieldException("nivel3Id_Nivel3");
			}

			if ((entity.getNivel3().getNivel3Id() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivel3().getNivel3Id(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivel3Id_Nivel3");
			}

			/*
			 * if (entity.getOcupacion().getOcupacionId() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "ocupacionId_Ocupacion");
			 * }
			 * 
			 * if ((entity.getOcupacion().getOcupacionId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getOcupacion().getOcupacionId(), 18, 0) == false)) { throw
			 * new ZMessManager().new NotValidFormatException(
			 * "ocupacionId_Ocupacion"); }
			 * 
			 * if (entity.getOrdenSuelo().getOrdenSuelo() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "ordenSuelo_OrdenSuelo");
			 * }
			 * 
			 * if ((entity.getOrdenSuelo().getOrdenSuelo() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getOrdenSuelo().getOrdenSuelo(), 18, 0) == false)) { throw
			 * new ZMessManager().new NotValidFormatException(
			 * "ordenSuelo_OrdenSuelo"); }
			 * 
			 * if (entity.getOrganizacion().getOrganizId() == null) { throw new
			 * ZMessManager().new EmptyFieldException(
			 * "organizId_Organizacion"); }
			 * 
			 * if ((entity.getOrganizacion().getOrganizId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getOrganizacion().getOrganizId(), 18, 0) == false)) {
			 * throw new ZMessManager().new NotValidFormatException(
			 * "organizId_Organizacion"); }
			 * 
			 * if (entity.getProveedor().getProveId() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "proveId_Proveedor"); }
			 * 
			 * 
			 * if (entity.getSerieSuelo().getSerieSueloId() == null) { throw new
			 * ZMessManager().new EmptyFieldException(
			 * "serieSueloId_SerieSuelo"); }
			 * 
			 * if ((entity.getSerieSuelo().getSerieSueloId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getSerieSuelo().getSerieSueloId(), 18, 0) == false)) {
			 * throw new ZMessManager().new NotValidFormatException(
			 * "serieSueloId_SerieSuelo"); }
			 * 
			 * if (entity.getTenencia().getTenenId() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "tenenId_Tenencia"); }
			 * 
			 * if ((entity.getTenencia().getTenenId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getTenencia().getTenenId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "tenenId_Tenencia");
			 * }
			 * 
			 * if (entity.getTipCultivo().getTipoCultivoId() == null) { throw
			 * new ZMessManager().new EmptyFieldException(
			 * "tipoCultivoId_TipCultivo"); }
			 * 
			 * if ((entity.getTipCultivo().getTipoCultivoId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getTipCultivo().getTipoCultivoId(), 18, 0) == false)) {
			 * throw new ZMessManager().new NotValidFormatException(
			 * "tipoCultivoId_TipCultivo"); }
			 * 
			 * if (entity.getTipoDrenaje().getTipoDrenajeId() == null) { throw
			 * new ZMessManager().new EmptyFieldException(
			 * "tipoDrenajeId_TipoDrenaje"); }
			 * 
			 * if ((entity.getTipoDrenaje().getTipoDrenajeId() != null) &&
			 * (Utilities .checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getTipoDrenaje() .getTipoDrenajeId(), 18, 0) == false)) {
			 * throw new ZMessManager().new NotValidFormatException(
			 * "tipoDrenajeId_TipoDrenaje"); }
			 * 
			 * if (entity.getTopografia().getTopografiaId() == null) { throw new
			 * ZMessManager().new EmptyFieldException(
			 * "topografiaId_Topografia"); }
			 * 
			 * if ((entity.getTopografia().getTopografiaId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getTopografia().getTopografiaId(), 18, 0) == false)) {
			 * throw new ZMessManager().new NotValidFormatException(
			 * "topografiaId_Topografia"); }
			 * 
			 * if (entity.getTrabajador().getTrabId() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "trabId_Trabajador"); }
			 * 
			 * if ((entity.getTrabajador().getTrabId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getTrabajador().getTrabId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "trabId_Trabajador");
			 * }
			 * 
			 * if (entity.getZonAgroec().getZonAgroec() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "zonAgroec_ZonAgroec"); }
			 * 
			 * if ((entity.getZonAgroec().getZonAgroec() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getZonAgroec().getZonAgroec(), 18, 0) == false)) { throw
			 * new ZMessManager().new NotValidFormatException(
			 * "zonAgroec_ZonAgroec"); }
			 * 
			 * if (getNivel4(entity.getNivel4Id()) != null) { throw new
			 * ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */

			nivel4DAO.save(entity);

			if (restriccionDeQuema != null) {
				for (String rq : restriccionDeQuema) {

					Long restQuemaId = new Long(rq);
					RestrQuema rqma = restrQuemaDAO.findById(restQuemaId);

					RestriccionQuemaNivel4Id restriccionQuemaNivel4Id = new RestriccionQuemaNivel4Id();
					restriccionQuemaNivel4Id.setRestrQuemaRestQuema(rqma.getRestQuema());
					restriccionQuemaNivel4Id.setNivel4Nivel4Id(entity.getNivel4Id());

					RestriccionQuemaNivel4 restriccionQuemaNivel4 = new RestriccionQuemaNivel4();
					restriccionQuemaNivel4.setRestrQuema(rqma);
					restriccionQuemaNivel4.setNivel4(entity);
					restriccionQuemaNivel4.setId(restriccionQuemaNivel4Id);

					restriccionQuemaNivel4DAO.save(restriccionQuemaNivel4);
				}
			}

			if (restriccionDeMadurante != null) {
				for (String rm : restriccionDeMadurante) {

					Long restMaduranteId = new Long(rm);
					RestrMadurante rmte = restrMaduranteDAO.findById(restMaduranteId);

					RestriMaduranteNivel4Id restriMaduranteNivel4Id = new RestriMaduranteNivel4Id();
					restriMaduranteNivel4Id.setRestrMaduranteRestMaduId(rmte.getRestMaduId());
					restriMaduranteNivel4Id.setNivel4Nivel4Id(entity.getNivel4Id());

					RestriMaduranteNivel4 restriMaduranteNivel4 = new RestriMaduranteNivel4();
					restriMaduranteNivel4.setRestrMadurante(rmte);
					restriMaduranteNivel4.setNivel4(entity);
					restriMaduranteNivel4.setId(restriMaduranteNivel4Id);

					restriMaduranteNivel4DAO.save(restriMaduranteNivel4);
				}
			}

			if (dataVariedad != null) {

				for (VariedadNivel4DTO vn4DTO : dataVariedad) {

					if (vn4DTO.getVariedadNivel4Id() == null) {

						VariedadNivel4 vn4Id = new VariedadNivel4();
						vn4Id.setVariedad(vn4DTO.getVariedId_Variedad());
						vn4Id.setPorcentajeArea(vn4DTO.getPorcentajeArea());
						vn4Id.setNivel4(entity);
						variedadNivel4DAO.save(vn4Id);

					}

				}

			}

			log.debug("save Nivel4 successful");
		} catch (Exception e) {
			log.error("save Nivel4 failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteNivel4(Nivel4 entity) throws Exception {
		log.debug("deleting Nivel4 instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Nivel4");
		}

		if (entity.getNivel4Id() == null) {
			throw new ZMessManager().new EmptyFieldException("nivel4Id");
		}

		List<DatSanVeg> datSanVegs = null;
		List<EstructSiemb> estructSiembs = null;
		List<RestriMaduranteNivel4> restriMaduranteNivel4s = null;
		List<RestriccionQuemaNivel4> restriccionQuemaNivel4s = null;
		List<VariedadNivel4> variedadNivel4s = null;

		try {
			datSanVegs = datSanVegDAO.findByProperty("nivel4.nivel4Id", entity.getNivel4Id());

			if (Utilities.validationsList(datSanVegs) == true) {
				throw new ZMessManager().new DeletingException("datSanVegs");
			}

			estructSiembs = estructSiembDAO.findByProperty("nivel4.nivel4Id", entity.getNivel4Id());

			if (Utilities.validationsList(estructSiembs) == true) {
				throw new ZMessManager().new DeletingException("estructSiembs");
			}

			restriMaduranteNivel4s = restriMaduranteNivel4DAO.findByProperty("nivel4.nivel4Id", entity.getNivel4Id());

			if (Utilities.validationsList(restriMaduranteNivel4s) == true) {
				throw new ZMessManager().new DeletingException("restriMaduranteNivel4s");
			}

			restriccionQuemaNivel4s = restriccionQuemaNivel4DAO.findByProperty("nivel4.nivel4Id", entity.getNivel4Id());

			if (Utilities.validationsList(restriccionQuemaNivel4s) == true) {
				throw new ZMessManager().new DeletingException("restriccionQuemaNivel4s");
			}

			variedadNivel4s = variedadNivel4DAO.findByProperty("nivel4.nivel4Id", entity.getNivel4Id());

			if (Utilities.validationsList(variedadNivel4s) == true) {
				throw new ZMessManager().new DeletingException("variedadNivel4s");
			}

			nivel4DAO.delete(entity);

			log.debug("delete Nivel4 successful");
		} catch (Exception e) {
			log.error("delete Nivel4 failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateNivel4(Nivel4 entity, List<String> restriccionDeQuema, List<String> restriccionDeMadurante,
			List<VariedadNivel4DTO> dataVariedad) throws Exception {
		log.debug("updating Nivel4 instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Nivel4");
			}

			if ((entity.getPersEmpr() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getPersEmpr(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("proveId_Proveedor");
			}

			/*
			 * if (entity.getAlmacen() == null) { throw new ZMessManager().new
			 * ForeignException("almacen"); }
			 * 
			 * if (entity.getAnioFiscal() == null) { throw new
			 * ZMessManager().new ForeignException("anioFiscal"); }
			 * 
			 * if (entity.getClaseTextSuelo() == null) { throw new
			 * ZMessManager().new ForeignException("claseTextSuelo"); }
			 * 
			 * if (entity.getEstClimat() == null) { throw new ZMessManager().new
			 * ForeignException("estClimat"); }
			 * 
			 * if (entity.getEstEvaporimetro() == null) { throw new
			 * ZMessManager().new ForeignException("estEvaporimetro"); }
			 * 
			 * if (entity.getEstPluvio() == null) { throw new ZMessManager().new
			 * ForeignException("estPluvio"); }
			 * 
			 * if (entity.getEtapa() == null) { throw new ZMessManager().new
			 * ForeignException("etapa"); }
			 * 
			 * if (entity.getFaseFenologica() == null) { throw new
			 * ZMessManager().new ForeignException("faseFenologica"); }
			 * 
			 * if (entity.getFliaTextSuelo() == null) { throw new
			 * ZMessManager().new ForeignException("fliaTextSuelo"); }
			 * 
			 * if (entity.getGrpSuelo() == null) { throw new ZMessManager().new
			 * ForeignException("grpSuelo"); }
			 * 
			 * if (entity.getN4Motivo() == null) { throw new ZMessManager().new
			 * ForeignException("n4Motivo"); }
			 * 
			 * if (entity.getNivel3() == null) { throw new ZMessManager().new
			 * ForeignException("nivel3"); }
			 * 
			 * if (entity.getOcupacion() == null) { throw new ZMessManager().new
			 * ForeignException("ocupacion"); }
			 * 
			 * if (entity.getOrdenSuelo() == null) { throw new
			 * ZMessManager().new ForeignException("ordenSuelo"); }
			 * 
			 * if (entity.getOrganizacion() == null) { throw new
			 * ZMessManager().new ForeignException("organizacion"); }
			 * 
			 * if (entity.getProveedor() == null) { throw new ZMessManager().new
			 * ForeignException("proveedor"); }
			 * 
			 * if (entity.getSerieSuelo() == null) { throw new
			 * ZMessManager().new ForeignException("serieSuelo"); }
			 * 
			 * if (entity.getTenencia() == null) { throw new ZMessManager().new
			 * ForeignException("tenencia"); }
			 * 
			 * if (entity.getTipCultivo() == null) { throw new
			 * ZMessManager().new ForeignException("tipCultivo"); }
			 * 
			 * if (entity.getTipoDrenaje() == null) { throw new
			 * ZMessManager().new ForeignException("tipoDrenaje"); }
			 * 
			 * if (entity.getTopografia() == null) { throw new
			 * ZMessManager().new ForeignException("topografia"); }
			 * 
			 * if (entity.getTrabajador() == null) { throw new
			 * ZMessManager().new ForeignException("trabajador"); }
			 * 
			 * if (entity.getZonAgroec() == null) { throw new ZMessManager().new
			 * ForeignException("zonAgroec"); }
			 */

			if ((entity.getAlturaPromedioPlantas() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAlturaPromedioPlantas(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("alturaPromedioPlantas");
			}

			if ((entity.getAna1() != null) && (Utilities.checkWordAndCheckWithlength(entity.getAna1(), 40) == false)) {
				throw new ZMessManager().new NotValidFormatException("ana1");
			}

			if ((entity.getAplicacionMadurante() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAplicacionMadurante(), 1, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("aplicacionMadurante");
			}

			if ((entity.getAreaBruta() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAreaBruta(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("areaBruta");
			}

			if ((entity.getSistemaRiego() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSistemaRiego(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("sistemaRiego");
			}

			if ((entity.getAreaInutil() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAreaInutil(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("areaInutil");
			}

			if ((entity.getAreaManual() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAreaManual(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("areaManual");
			}

			if ((entity.getAreaMecanizada() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAreaMecanizada(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("areaMecanizada");
			}

			if ((entity.getAreaNeta() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAreaNeta(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("areaNeta");
			}

			if ((entity.getAreaOtrosCultivos() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAreaOtrosCultivos(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("areaOtrosCultivos");
			}

			if ((entity.getAreaReservada() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAreaReservada(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("areaReservada");
			}

			if ((entity.getAreaRestringida() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAreaRestringida(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("areaRestringida");
			}

			if ((entity.getCantidadValvulasRiego() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCantidadValvulasRiego(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("cantidadValvulasRiego");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCodigo(), 20) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getCodigoUsuarioApertura() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCodigoUsuarioApertura(), 18,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigoUsuarioApertura");
			}

			if ((entity.getCodigoUsuarioCierre() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCodigoUsuarioCierre(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigoUsuarioCierre");
			}

			/*
			 * if ((entity.getCompania() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getCompania(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException("compania"); }
			 */

			if ((entity.getCostosAmortizados() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getCostosAmortizados(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("costosAmortizados");
			}

			/*
			 * if ((entity.getEdadActual() != null) && (Utilities
			 * .checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getEdadActual(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException("edadActual"); }
			 */

			if ((entity.getEdadUltimaCosecha() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEdadUltimaCosecha(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("edadUltimaCosecha");
			}

	
			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			/*
			 * if ((entity.getFechaAnalisisPreCosecha() != null) &&
			 * (Utilities.checkWordAndCheckWithlength(
			 * entity.getFechaAnalisisPreCosecha(), 10) == false)) { throw new
			 * ZMessManager().new NotValidFormatException(
			 * "fechaAnalisisPreCosecha"); }
			 */

			if ((entity.getFotoInfraestructura() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getFotoInfraestructura(), 300) == false)) {
				throw new ZMessManager().new NotValidFormatException("fotoInfraestructura");
			}

			if ((entity.getGenerico() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getGenerico(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("generico");
			}

			if ((entity.getIndiceHelada() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getIndiceHelada(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("indiceHelada");
			}

			if ((entity.getInfoAdicional() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional");
			}

			if ((entity.getInfoAdicional2() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional2(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional2");
			}

			if ((entity.getKilmNivel4Fab() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getKilmNivel4Fab(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("kilmNivel4Fab");
			}

			if ((entity.getKilmNivel4FabPav() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getKilmNivel4FabPav(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("kilmNivel4FabPav");
			}

			if ((entity.getKilmNivel4FabTerraceria() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getKilmNivel4FabTerraceria(), 8,
							4) == false)) {
				throw new ZMessManager().new NotValidFormatException("kilmNivel4FabTerraceria");
			}

			/*
			 * if (entity.getNivel4Id() == null) { throw new ZMessManager().new
			 * EmptyFieldException("nivel4Id"); }
			 * 
			 * if ((entity.getNivel4Id() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getNivel4Id(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException("nivel4Id"); }
			 */

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			if ((entity.getNumComederosHect() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumComederosHect(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("numComederosHect");
			}

			if ((entity.getNumDensidadActual() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumDensidadActual(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("numDensidadActual");
			}

			if ((entity.getNumDensidadSiembra() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumDensidadSiembra(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("numDensidadSiembra");
			}

			if ((entity.getNumEstimTonAnioFiscal() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumEstimTonAnioFiscal(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("numEstimTonAnioFiscal");
			}


			if ((entity.getNumEstimTonMesAnioFiscal() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumEstimTonMesAnioFiscal(), 8,
							4) == false)) {
				throw new ZMessManager().new NotValidFormatException("numEstimTonMesAnioFiscal");
			}

			if ((entity.getNumHectCosIndFab() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumHectCosIndFab(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("numHectCosIndFab");
			}

			if ((entity.getNumHectOtroDestino() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumHectOtroDestino(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("numHectOtroDestino");
			}

			if ((entity.getNumHectUltCosecha() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumHectUltCosecha(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("numHectUltCosecha");
			}

			if ((entity.getNumLarvasSembradas() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumLarvasSembradas(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("numLarvasSembradas");
			}

			if ((entity.getNumLineasSembradas() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumLineasSembradas(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("numLineasSembradas");
			}

			if ((entity.getNumPlantasActuales() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumPlantasActuales(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("numPlantasActuales");
			}

			if ((entity.getNumPlantasSembradas() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumPlantasSembradas(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("numPlantasSembradas");
			}

			if ((entity.getNumPlantasSembradas2() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumPlantasSembradas2(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("numPlantasSembradas2");
			}

			if ((entity.getNumRacionesCrustaceos() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumRacionesCrustaceos(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("numRacionesCrustaceos");
			}

			if ((entity.getNumTonCosIndFab() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumTonCosIndFab(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("numTonCosIndFab");
			}

			if ((entity.getNumTonOtroDestino() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumTonOtroDestino(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("numTonOtroDestino");
			}

			if ((entity.getNumTonUltCosecha() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumTonUltCosecha(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("numTonUltCosecha");
			}

			if ((entity.getPesoPromedioNivel4() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getPesoPromedioNivel4(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("pesoPromedioNivel4");
			}

			if ((entity.getRenovacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getRenovacion(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("renovacion");
			}

			if ((entity.getSemillero() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getSemillero(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("semillero");
			}

			if ((entity.getTotalComederos() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTotalComederos(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("totalComederos");
			}

			if ((entity.getUltDosisAplicadaMadurante() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getUltDosisAplicadaMadurante(),
							8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("ultDosisAplicadaMadurante");
			}

			/*
			 * if (entity.getAlmacen().getAlmacenId() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "almacenId_Almacen"); }
			 * 
			 * if ((entity.getAlmacen().getAlmacenId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getAlmacen().getAlmacenId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "almacenId_Almacen");
			 * }
			 * 
			 * if (entity.getAnioFiscal().getAnioFiscalId() == null) { throw new
			 * ZMessManager().new EmptyFieldException(
			 * "anioFiscalId_AnioFiscal"); }
			 * 
			 * if ((entity.getAnioFiscal().getAnioFiscalId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getAnioFiscal().getAnioFiscalId(), 18, 0) == false)) {
			 * throw new ZMessManager().new NotValidFormatException(
			 * "anioFiscalId_AnioFiscal"); }
			 * 
			 * if (entity.getClaseTextSuelo().getClaseTextSueloId() == null) {
			 * throw new ZMessManager().new EmptyFieldException(
			 * "claseTextSueloId_ClaseTextSuelo"); }
			 * 
			 * if ((entity.getClaseTextSuelo().getClaseTextSueloId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getClaseTextSuelo().getClaseTextSueloId(), 18, 0) ==
			 * false)) { throw new ZMessManager().new NotValidFormatException(
			 * "claseTextSueloId_ClaseTextSuelo"); }
			 * 
			 * if (entity.getEstClimat().getEstClimatId() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "estClimatId_EstClimat");
			 * }
			 * 
			 * if ((entity.getEstClimat().getEstClimatId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getEstClimat().getEstClimatId(), 18, 0) == false)) { throw
			 * new ZMessManager().new NotValidFormatException(
			 * "estClimatId_EstClimat"); }
			 * 
			 * if (entity.getEstEvaporimetro().getEstEvaporimetroId() == null) {
			 * throw new ZMessManager().new EmptyFieldException(
			 * "estEvaporimetroId_EstEvaporimetro"); }
			 * 
			 * if ((entity.getEstEvaporimetro().getEstEvaporimetroId() != null)
			 * && (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getEstEvaporimetro() .getEstEvaporimetroId(), 18, 0) ==
			 * false)) { throw new ZMessManager().new NotValidFormatException(
			 * "estEvaporimetroId_EstEvaporimetro"); }
			 * 
			 * if (entity.getEstPluvio().getEstPluvioId() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "estPluvioId_EstPluvio");
			 * }
			 * 
			 * if ((entity.getEstPluvio().getEstPluvioId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getEstPluvio().getEstPluvioId(), 18, 0) == false)) { throw
			 * new ZMessManager().new NotValidFormatException(
			 * "estPluvioId_EstPluvio"); }
			 * 
			 * if (entity.getEtapa().getEtapaId() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "etapaId_Etapa"); }
			 * 
			 * if ((entity.getEtapa().getEtapaId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getEtapa().getEtapaId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "etapaId_Etapa"); }
			 * 
			 * if (entity.getFaseFenologica().getFaseFenoId() == null) { throw
			 * new ZMessManager().new EmptyFieldException(
			 * "faseFenoId_FaseFenologica"); }
			 * 
			 * if ((entity.getFaseFenologica().getFaseFenoId() != null) &&
			 * (Utilities .checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getFaseFenologica() .getFaseFenoId(), 18, 0) == false)) {
			 * throw new ZMessManager().new NotValidFormatException(
			 * "faseFenoId_FaseFenologica"); }
			 * 
			 * if (entity.getFliaTextSuelo().getFliaTextSueloId() == null) {
			 * throw new ZMessManager().new EmptyFieldException(
			 * "fliaTextSueloId_FliaTextSuelo"); }
			 * 
			 * if ((entity.getFliaTextSuelo().getFliaTextSueloId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getFliaTextSuelo().getFliaTextSueloId(), 18, 0) == false))
			 * { throw new ZMessManager().new NotValidFormatException(
			 * "fliaTextSueloId_FliaTextSuelo"); }
			 * 
			 * if (entity.getGrpSuelo().getGrupoSuelo() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "grupoSuelo_GrpSuelo"); }
			 * 
			 * if ((entity.getGrpSuelo().getGrupoSuelo() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getGrpSuelo().getGrupoSuelo(), 18, 0) == false)) { throw
			 * new ZMessManager().new NotValidFormatException(
			 * "grupoSuelo_GrpSuelo"); }
			 * 
			 * if (entity.getN4Motivo().getN4Mot() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "n4Mot_N4Motivo"); }
			 * 
			 * if ((entity.getN4Motivo().getN4Mot() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getN4Motivo().getN4Mot(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "n4Mot_N4Motivo"); }
			 * 
			 * if (entity.getNivel3().getNivel3Id() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "nivel3Id_Nivel3"); }
			 * 
			 * if ((entity.getNivel3().getNivel3Id() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getNivel3().getNivel3Id(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "nivel3Id_Nivel3"); }
			 * 
			 * if (entity.getOcupacion().getOcupacionId() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "ocupacionId_Ocupacion");
			 * }
			 * 
			 * if ((entity.getOcupacion().getOcupacionId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getOcupacion().getOcupacionId(), 18, 0) == false)) { throw
			 * new ZMessManager().new NotValidFormatException(
			 * "ocupacionId_Ocupacion"); }
			 * 
			 * if (entity.getOrdenSuelo().getOrdenSuelo() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "ordenSuelo_OrdenSuelo");
			 * }
			 * 
			 * if ((entity.getOrdenSuelo().getOrdenSuelo() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getOrdenSuelo().getOrdenSuelo(), 18, 0) == false)) { throw
			 * new ZMessManager().new NotValidFormatException(
			 * "ordenSuelo_OrdenSuelo"); }
			 * 
			 * if (entity.getOrganizacion().getOrganizId() == null) { throw new
			 * ZMessManager().new EmptyFieldException(
			 * "organizId_Organizacion"); }
			 * 
			 * if ((entity.getOrganizacion().getOrganizId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getOrganizacion().getOrganizId(), 18, 0) == false)) {
			 * throw new ZMessManager().new NotValidFormatException(
			 * "organizId_Organizacion"); }
			 * 
			 * if (entity.getProveedor().getProveId() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "proveId_Proveedor"); }
			 * 
			 * if ((entity.getProveedor().getProveId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getProveedor().getProveId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "proveId_Proveedor");
			 * }
			 * 
			 * if (entity.getSerieSuelo().getSerieSueloId() == null) { throw new
			 * ZMessManager().new EmptyFieldException(
			 * "serieSueloId_SerieSuelo"); }
			 * 
			 * if ((entity.getSerieSuelo().getSerieSueloId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getSerieSuelo().getSerieSueloId(), 18, 0) == false)) {
			 * throw new ZMessManager().new NotValidFormatException(
			 * "serieSueloId_SerieSuelo"); }
			 * 
			 * if (entity.getTenencia().getTenenId() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "tenenId_Tenencia"); }
			 * 
			 * if ((entity.getTenencia().getTenenId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getTenencia().getTenenId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "tenenId_Tenencia");
			 * }
			 * 
			 * if (entity.getTipCultivo().getTipoCultivoId() == null) { throw
			 * new ZMessManager().new EmptyFieldException(
			 * "tipoCultivoId_TipCultivo"); }
			 * 
			 * if ((entity.getTipCultivo().getTipoCultivoId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getTipCultivo().getTipoCultivoId(), 18, 0) == false)) {
			 * throw new ZMessManager().new NotValidFormatException(
			 * "tipoCultivoId_TipCultivo"); }
			 * 
			 * if (entity.getTipoDrenaje().getTipoDrenajeId() == null) { throw
			 * new ZMessManager().new EmptyFieldException(
			 * "tipoDrenajeId_TipoDrenaje"); }
			 * 
			 * if ((entity.getTipoDrenaje().getTipoDrenajeId() != null) &&
			 * (Utilities .checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getTipoDrenaje() .getTipoDrenajeId(), 18, 0) == false)) {
			 * throw new ZMessManager().new NotValidFormatException(
			 * "tipoDrenajeId_TipoDrenaje"); }
			 * 
			 * if (entity.getTopografia().getTopografiaId() == null) { throw new
			 * ZMessManager().new EmptyFieldException(
			 * "topografiaId_Topografia"); }
			 * 
			 * if ((entity.getTopografia().getTopografiaId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getTopografia().getTopografiaId(), 18, 0) == false)) {
			 * throw new ZMessManager().new NotValidFormatException(
			 * "topografiaId_Topografia"); }
			 * 
			 * if (entity.getTrabajador().getTrabId() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "trabId_Trabajador"); }
			 * 
			 * if ((entity.getTrabajador().getTrabId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getTrabajador().getTrabId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "trabId_Trabajador");
			 * }
			 * 
			 * if (entity.getZonAgroec().getZonAgroec() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "zonAgroec_ZonAgroec"); }
			 * 
			 * if ((entity.getZonAgroec().getZonAgroec() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getZonAgroec().getZonAgroec(), 18, 0) == false)) { throw
			 * new ZMessManager().new NotValidFormatException(
			 * "zonAgroec_ZonAgroec"); }
			 */

			nivel4DAO.update(entity);

			if (restriccionDeQuema != null) {

				restriccionQuemaNivel4DAO.deleteByProperty("RestriccionQuemaNivel4", "nivel4.nivel4Id",
						entity.getNivel4Id());

				for (String rq : restriccionDeQuema) {

					Long restQuemaId = new Long(rq);
					RestrQuema rqma = restrQuemaDAO.findById(restQuemaId);

					RestriccionQuemaNivel4Id restriccionQuemaNivel4Id = new RestriccionQuemaNivel4Id();
					restriccionQuemaNivel4Id.setRestrQuemaRestQuema(rqma.getRestQuema());
					restriccionQuemaNivel4Id.setNivel4Nivel4Id(entity.getNivel4Id());

					RestriccionQuemaNivel4 restriccionQuemaNivel4 = new RestriccionQuemaNivel4();
					restriccionQuemaNivel4.setRestrQuema(rqma);
					restriccionQuemaNivel4.setNivel4(entity);
					restriccionQuemaNivel4.setId(restriccionQuemaNivel4Id);

					restriccionQuemaNivel4DAO.save(restriccionQuemaNivel4);
				}

			}

			if (restriccionDeMadurante != null) {

				restriMaduranteNivel4DAO.deleteByProperty("RestriMaduranteNivel4", "nivel4.nivel4Id",
						entity.getNivel4Id());

				for (String rm : restriccionDeMadurante) {

					Long restMaduranteId = new Long(rm);
					RestrMadurante rmte = restrMaduranteDAO.findById(restMaduranteId);

					RestriMaduranteNivel4Id restriMaduranteNivel4Id = new RestriMaduranteNivel4Id();
					restriMaduranteNivel4Id.setRestrMaduranteRestMaduId(rmte.getRestMaduId());
					restriMaduranteNivel4Id.setNivel4Nivel4Id(entity.getNivel4Id());

					RestriMaduranteNivel4 restriMaduranteNivel4 = new RestriMaduranteNivel4();
					restriMaduranteNivel4.setRestrMadurante(rmte);
					restriMaduranteNivel4.setNivel4(entity);
					restriMaduranteNivel4.setId(restriMaduranteNivel4Id);

					restriMaduranteNivel4DAO.save(restriMaduranteNivel4);
				}

			}

			if (dataVariedad != null) {

				for (VariedadNivel4DTO valorDto : dataVariedad) {

					if (valorDto.getVariedadNivel4Id() == null) { // crear el
																	// valor
						// nuevo

						VariedadNivel4 vn4Id = new VariedadNivel4();
						vn4Id.setVariedad(valorDto.getVariedId_Variedad());
						vn4Id.setPorcentajeArea(valorDto.getPorcentajeArea());
						vn4Id.setNivel4(entity);
						variedadNivel4DAO.save(vn4Id);

					} else {
						VariedadNivel4 vn4Id = variedadNivel4DAO.findById(valorDto.getVariedadNivel4Id());
						vn4Id.setVariedad(valorDto.getVariedId_Variedad());
						vn4Id.setPorcentajeArea(valorDto.getPorcentajeArea());
						vn4Id.setNivel4(entity);

						variedadNivel4DAO.save(vn4Id);

					}

				}
			}

			log.debug("update Nivel4 successful");
		} catch (Exception e) {
			log.error("update Nivel4 failed", e);
			throw e;
		} finally {
		}
	}

	public Long listener_calcularEdadActual(Date fechaultimocorte) {

		Date hoy = new Date();
		Long edadactual;

		if (fechaultimocorte != null) {
			edadactual = (long) (((hoy.getTime() - fechaultimocorte.getTime()) / (1000 * 60 * 60 * 24)) / 30.45);
		} else {
			edadactual = (long) 0;
		}

		return edadactual;

	}

	@Override
	@Transactional(readOnly = true)
	public List<Nivel4DTO> getDataNivel4() throws Exception {
		try {
			List<Nivel4> nivel4 = nivel4DAO.findAll();

			List<Nivel4DTO> nivel4DTO = new ArrayList<Nivel4DTO>();

			for (Nivel4 nivel4Tmp : nivel4) {
				Nivel4DTO nivel4DTO2 = new Nivel4DTO();

				nivel4DTO2.setNivel4Id(nivel4Tmp.getNivel4Id());
				nivel4DTO2.setAlturaPromedioPlantas(
						(nivel4Tmp.getAlturaPromedioPlantas() != null) ? nivel4Tmp.getAlturaPromedioPlantas() : null);
				nivel4DTO2.setAna1((nivel4Tmp.getAna1() != null) ? nivel4Tmp.getAna1() : null);
				nivel4DTO2.setAplicacionMadurante(
						(nivel4Tmp.getAplicacionMadurante() != null) ? nivel4Tmp.getAplicacionMadurante() : null);
				nivel4DTO2.setAreaBruta((nivel4Tmp.getAreaBruta() != null) ? nivel4Tmp.getAreaBruta() : null);
				nivel4DTO2.setAreaInutil((nivel4Tmp.getAreaInutil() != null) ? nivel4Tmp.getAreaInutil() : null);
				nivel4DTO2.setAreaManual((nivel4Tmp.getAreaManual() != null) ? nivel4Tmp.getAreaManual() : null);
				nivel4DTO2.setAreaMecanizada(
						(nivel4Tmp.getAreaMecanizada() != null) ? nivel4Tmp.getAreaMecanizada() : null);
				nivel4DTO2.setAreaNeta((nivel4Tmp.getAreaNeta() != null) ? nivel4Tmp.getAreaNeta() : null);
				nivel4DTO2.setAreaOtrosCultivos(
						(nivel4Tmp.getAreaOtrosCultivos() != null) ? nivel4Tmp.getAreaOtrosCultivos() : null);
				nivel4DTO2
						.setAreaReservada((nivel4Tmp.getAreaReservada() != null) ? nivel4Tmp.getAreaReservada() : null);
				nivel4DTO2.setAreaRestringida(
						(nivel4Tmp.getAreaRestringida() != null) ? nivel4Tmp.getAreaRestringida() : null);
				nivel4DTO2.setCantidadValvulasRiego(
						(nivel4Tmp.getCantidadValvulasRiego() != null) ? nivel4Tmp.getCantidadValvulasRiego() : null);
				nivel4DTO2.setCodigo((nivel4Tmp.getCodigo() != null) ? nivel4Tmp.getCodigo() : null);
				nivel4DTO2.setCodigoUsuarioApertura(
						(nivel4Tmp.getCodigoUsuarioApertura() != null) ? nivel4Tmp.getCodigoUsuarioApertura() : null);
				nivel4DTO2.setCodigoUsuarioCierre(
						(nivel4Tmp.getCodigoUsuarioCierre() != null) ? nivel4Tmp.getCodigoUsuarioCierre() : null);
				nivel4DTO2.setCompania((nivel4Tmp.getCompania() != null) ? nivel4Tmp.getCompania() : null);
				nivel4DTO2.setCostosAmortizados(
						(nivel4Tmp.getCostosAmortizados() != null) ? nivel4Tmp.getCostosAmortizados() : null);

				nivel4DTO2.setFechaUltimoCorte(nivel4Tmp.getFechaUltimoCorte());

				/*
				 * nivel4DTO2 .setEdadActual((nivel4Tmp.getEdadActual() != null)
				 * ? listener_calcularEdadActual(nivel4Tmp
				 * .getFechaUltimoCorte()) : null);
				 */

				nivel4DTO2.setEdadUltimaCosecha(
						(nivel4Tmp.getEdadUltimaCosecha() != null) ? nivel4Tmp.getEdadUltimaCosecha() : null);
				nivel4DTO2.setEspacioLineasSembradas(
						(nivel4Tmp.getEspacioLineasSembradas() != null) ? nivel4Tmp.getEspacioLineasSembradas() : null);
				nivel4DTO2.setEstado((nivel4Tmp.getEstado() != null) ? nivel4Tmp.getEstado() : null);
				nivel4DTO2.setFechaAnalisisPostCosecha(nivel4Tmp.getFechaAnalisisPostCosecha());
				nivel4DTO2.setFechaAnalisisPreCosecha((nivel4Tmp.getFechaAnalisisPreCosecha() != null)
						? nivel4Tmp.getFechaAnalisisPreCosecha() : null);
				nivel4DTO2.setFechaAperturaCosecha(nivel4Tmp.getFechaAperturaCosecha());
				nivel4DTO2.setFechaAplicacionMadurante(nivel4Tmp.getFechaAplicacionMadurante());
				nivel4DTO2.setFechaCierreCosecha(nivel4Tmp.getFechaCierreCosecha());
				nivel4DTO2.setFechaCorteAnterior(nivel4Tmp.getFechaCorteAnterior());
				nivel4DTO2.setFechaCreacion(nivel4Tmp.getFechaCreacion());
				nivel4DTO2.setFechaEstimadaUltimoRiego(nivel4Tmp.getFechaEstimadaUltimoRiego());
				nivel4DTO2.setFechaInactivo(nivel4Tmp.getFechaInactivo());
				nivel4DTO2.setFechaModificacion(nivel4Tmp.getFechaModificacion());
				nivel4DTO2.setFechaPrimerCorte(nivel4Tmp.getFechaPrimerCorte());
				nivel4DTO2.setFechaProximoCorte(nivel4Tmp.getFechaProximoCorte());
				nivel4DTO2.setFechaSiembra(nivel4Tmp.getFechaSiembra());
				nivel4DTO2.setFechaUltimoApunteRiego(nivel4Tmp.getFechaUltimoApunteRiego());
				nivel4DTO2.setFotoInfraestructura(
						(nivel4Tmp.getFotoInfraestructura() != null) ? nivel4Tmp.getFotoInfraestructura() : null);
				nivel4DTO2.setGenerico((nivel4Tmp.getGenerico() != null) ? nivel4Tmp.getGenerico() : null);
				nivel4DTO2.setIndiceHelada((nivel4Tmp.getIndiceHelada() != null) ? nivel4Tmp.getIndiceHelada() : null);
				nivel4DTO2
						.setInfoAdicional((nivel4Tmp.getInfoAdicional() != null) ? nivel4Tmp.getInfoAdicional() : null);
				nivel4DTO2.setInfoAdicional2(
						(nivel4Tmp.getInfoAdicional2() != null) ? nivel4Tmp.getInfoAdicional2() : null);
				nivel4DTO2
						.setKilmNivel4Fab((nivel4Tmp.getKilmNivel4Fab() != null) ? nivel4Tmp.getKilmNivel4Fab() : null);
				nivel4DTO2.setKilmNivel4FabPav(
						(nivel4Tmp.getKilmNivel4FabPav() != null) ? nivel4Tmp.getKilmNivel4FabPav() : null);
				nivel4DTO2.setKilmNivel4FabTerraceria((nivel4Tmp.getKilmNivel4FabTerraceria() != null)
						? nivel4Tmp.getKilmNivel4FabTerraceria() : null);
				nivel4DTO2.setLatitud((nivel4Tmp.getLatitud() != null) ? nivel4Tmp.getLatitud() : null);
				nivel4DTO2.setLongitud((nivel4Tmp.getLongitud() != null) ? nivel4Tmp.getLongitud() : null);
				nivel4DTO2.setNombre((nivel4Tmp.getNombre() != null) ? nivel4Tmp.getNombre() : null);
				nivel4DTO2.setNumComederosHect(
						(nivel4Tmp.getNumComederosHect() != null) ? nivel4Tmp.getNumComederosHect() : null);
				nivel4DTO2.setNumDensidadActual(
						(nivel4Tmp.getNumDensidadActual() != null) ? nivel4Tmp.getNumDensidadActual() : null);
				nivel4DTO2.setNumDensidadSiembra(
						(nivel4Tmp.getNumDensidadSiembra() != null) ? nivel4Tmp.getNumDensidadSiembra() : null);
				nivel4DTO2.setNumEstimTonAnioFiscal(
						(nivel4Tmp.getNumEstimTonAnioFiscal() != null) ? nivel4Tmp.getNumEstimTonAnioFiscal() : null);
				nivel4DTO2.setNumEstimTonHectPrimVez(
						(nivel4Tmp.getNumEstimTonHectPrimVez() != null) ? nivel4Tmp.getNumEstimTonHectPrimVez() : null);
				nivel4DTO2.setNumEstimTonMesAnioFiscal((nivel4Tmp.getNumEstimTonMesAnioFiscal() != null)
						? nivel4Tmp.getNumEstimTonMesAnioFiscal() : null);
				nivel4DTO2.setNumHectCosIndFab(
						(nivel4Tmp.getNumHectCosIndFab() != null) ? nivel4Tmp.getNumHectCosIndFab() : null);
				nivel4DTO2.setNumHectOtroDestino(
						(nivel4Tmp.getNumHectOtroDestino() != null) ? nivel4Tmp.getNumHectOtroDestino() : null);
				nivel4DTO2.setNumHectUltCosecha(
						(nivel4Tmp.getNumHectUltCosecha() != null) ? nivel4Tmp.getNumHectUltCosecha() : null);
				nivel4DTO2.setNumLarvasSembradas(
						(nivel4Tmp.getNumLarvasSembradas() != null) ? nivel4Tmp.getNumLarvasSembradas() : null);
				nivel4DTO2.setNumLineasSembradas(
						(nivel4Tmp.getNumLineasSembradas() != null) ? nivel4Tmp.getNumLineasSembradas() : null);
				nivel4DTO2.setNumPlantasActuales(
						(nivel4Tmp.getNumPlantasActuales() != null) ? nivel4Tmp.getNumPlantasActuales() : null);
				nivel4DTO2.setNumPlantasSembradas(
						(nivel4Tmp.getNumPlantasSembradas() != null) ? nivel4Tmp.getNumPlantasSembradas() : null);
				nivel4DTO2.setNumPlantasSembradas2(
						(nivel4Tmp.getNumPlantasSembradas2() != null) ? nivel4Tmp.getNumPlantasSembradas2() : null);
				nivel4DTO2.setNumRacionesCrustaceos(
						(nivel4Tmp.getNumRacionesCrustaceos() != null) ? nivel4Tmp.getNumRacionesCrustaceos() : null);
				nivel4DTO2.setNumTonCosIndFab(
						(nivel4Tmp.getNumTonCosIndFab() != null) ? nivel4Tmp.getNumTonCosIndFab() : null);
				nivel4DTO2.setNumTonOtroDestino(
						(nivel4Tmp.getNumTonOtroDestino() != null) ? nivel4Tmp.getNumTonOtroDestino() : null);
				nivel4DTO2.setNumTonUltCosecha(
						(nivel4Tmp.getNumTonUltCosecha() != null) ? nivel4Tmp.getNumTonUltCosecha() : null);
				nivel4DTO2.setPesoPromedioNivel4(
						(nivel4Tmp.getPesoPromedioNivel4() != null) ? nivel4Tmp.getPesoPromedioNivel4() : null);
				nivel4DTO2.setPrecision((nivel4Tmp.getPrecision() != null) ? nivel4Tmp.getPrecision() : null);
				nivel4DTO2

						.setRenovacion((nivel4Tmp.getRenovacion() != null) ? nivel4Tmp.getRenovacion() : null);
				nivel4DTO2.setSemillero((nivel4Tmp.getSemillero() != null) ? nivel4Tmp.getSemillero() : null);
				nivel4DTO2.setTotalComederos(
						(nivel4Tmp.getTotalComederos() != null) ? nivel4Tmp.getTotalComederos() : null);
				nivel4DTO2.setUltDosisAplicadaMadurante((nivel4Tmp.getUltDosisAplicadaMadurante() != null)
						? nivel4Tmp.getUltDosisAplicadaMadurante() : null);

				if (nivel4Tmp.getAlmacen() != null) {
					nivel4DTO2.setAlmacenId_Almacen(nivel4Tmp.getAlmacen().getAlmacenId());
				} else {
					nivel4DTO2.setAlmacenId_Almacen(null);
				}

				nivel4DTO2.setAnioFiscalId_AnioFiscal(
						(nivel4Tmp.getAnioFiscal() != null) ? nivel4Tmp.getAnioFiscal().getAnioFiscalId() : null);

				nivel4DTO2.setClaseTextSueloId_ClaseTextSuelo((nivel4Tmp.getClaseTextSuelo() != null)
						? nivel4Tmp.getClaseTextSuelo().getClaseTextSueloId() : null);

				nivel4DTO2.setEstClimatId_EstClimat(
						(nivel4Tmp.getEstClimat() != null) ? nivel4Tmp.getEstClimat().getEstClimatId() : null);

				if (nivel4Tmp.getEstEvaporimetro() != null) {

					nivel4DTO2.setEstEvaporimetroId_EstEvaporimetro(
							nivel4Tmp.getEstEvaporimetro().getEstEvaporimetroId());
				} else {

					nivel4DTO2.setEstEvaporimetroId_EstEvaporimetro(null);
				}

				if (nivel4Tmp.getEstPluvio() != null) {
					nivel4DTO2.setEstPluvioId_EstPluvio(nivel4Tmp.getEstPluvio().getEstPluvioId());
				} else {
					nivel4DTO2.setEstPluvioId_EstPluvio(null);
				}

				if (nivel4Tmp.getEtapa() != null) {
					nivel4DTO2.setEtapaId_Etapa(nivel4Tmp.getEtapa().getEtapaId());
				} else {
					nivel4DTO2.setEtapaId_Etapa(null);
				}

				nivel4DTO2.setFaseFenoId_FaseFenologica(
						(nivel4Tmp.getFaseFenologica() != null) ? nivel4Tmp.getFaseFenologica().getFaseFenoId() : null);
				nivel4DTO2.setFliaTextSueloId_FliaTextSuelo((nivel4Tmp.getFliaTextSuelo() != null)
						? nivel4Tmp.getFliaTextSuelo().getFliaTextSueloId() : null);

				nivel4DTO2.setGrupoSuelo_GrpSuelo(
						(nivel4Tmp.getGrpSuelo() != null) ? nivel4Tmp.getGrpSuelo().getGrupoSuelo() : null);

				if (nivel4Tmp.getN4Motivo() != null) {

					nivel4DTO2.setN4Mot_N4Motivo(nivel4Tmp.getN4Motivo().getN4Mot());

				} else {
					nivel4DTO2.setN4Mot_N4Motivo(null);
				}

				if (nivel4Tmp.getNivel3() != null) {
					nivel4DTO2.setNivel3Id_Nivel3(nivel4Tmp.getNivel3().getNivel3Id());
				} else {
					nivel4DTO2.setNivel3Id_Nivel3(null);
				}

				if (nivel4Tmp.getOcupacion() != null) {
					nivel4DTO2.setOcupacionId_Ocupacion(nivel4Tmp.getOcupacion().getOcupacionId());
				} else {
					nivel4DTO2.setOcupacionId_Ocupacion(null);
				}

				nivel4DTO2.setOrdenSuelo_OrdenSuelo(
						(nivel4Tmp.getOrdenSuelo() != null) ? nivel4Tmp.getOrdenSuelo().getOrdenSuelo() : null);

				if (nivel4Tmp.getOrganizacion() != null) {
					nivel4DTO2.setOrganizId_Organizacion(nivel4Tmp.getOrganizacion().getOrganizId());
				} else {
					nivel4DTO2.setOrganizId_Organizacion(null);
				}

				if (nivel4Tmp.getPersEmpr() != null) {

					nivel4DTO2.setPersEmprId_persEmpr(nivel4Tmp.getPersEmpr());

				} else {
					nivel4DTO2.setPersEmprId_persEmpr(null);
				}

				if (nivel4Tmp.getSerieSuelo() != null) {

					nivel4DTO2.setSerieSueloId_SerieSuelo(nivel4Tmp.getSerieSuelo().getSerieSueloId());

				} else {

					nivel4DTO2.setSerieSueloId_SerieSuelo(null);
				}

				if (nivel4Tmp.getTenencia() != null) {
					nivel4DTO2.setTenenId_Tenencia(nivel4Tmp.getTenencia().getTenenId());
				} else {
					nivel4DTO2.setTenenId_Tenencia(null);
				}

				if (nivel4Tmp.getTipCultivo() != null) {
					nivel4DTO2.setTipoCultivoId_TipCultivo(nivel4Tmp.getTipCultivo().getTipoCultivoId());
				} else {
					nivel4DTO2.setTipoCultivoId_TipCultivo(null);
				}

				if (nivel4Tmp.getTipoDrenaje() != null) {

					nivel4DTO2.setTipoDrenajeId_TipoDrenaje(nivel4Tmp.getTipoDrenaje().getTipoDrenajeId());

				} else {

					nivel4DTO2.setTipoDrenajeId_TipoDrenaje(null);
				}

				if (nivel4Tmp.getTopografia() != null) {
					nivel4DTO2.setTopografiaId_Topografia(nivel4Tmp.getTopografia().getTopografiaId());
				} else {
					nivel4DTO2.setTopografiaId_Topografia(null);
				}

				if (nivel4Tmp.getTrabajador() != null) {
					nivel4DTO2.setTrabId_Trabajador(nivel4Tmp.getTrabajador().getTrabId());
				} else {
					nivel4DTO2.setTrabId_Trabajador(null);
				}

				if (nivel4Tmp.getZonAgroec() != null) {
					nivel4DTO2.setZonAgroec_ZonAgroec(nivel4Tmp.getZonAgroec().getZonAgroec());
				} else {
					nivel4DTO2.setZonAgroec_ZonAgroec(null);
				}

				nivel4DTO2.setNombreBloque(nivel4Tmp.getNivel3().getNombre());

				String nombreAnioFiscal = nivel4Tmp.getAnioFiscal().getNombre();
				nivel4DTO2.setNombreAnioFiscal(nombreAnioFiscal);

				String nombreEtapa = nivel4Tmp.getEtapa().getNombre();
				nivel4DTO2.setNombreEtapa(nombreEtapa);

				nivel4DTO.add(nivel4DTO2);
			}

			return nivel4DTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Nivel4DTO> findByCriteriaPageNivel4(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) throws Exception {
		try {

			List<Nivel4> entity = null;
			String whereCondition = new String();
			Iterator it = filters.entrySet().iterator();

			while (it.hasNext()) {
				Map.Entry e = (Map.Entry) it.next();
				if (e.getKey().equals("nombreAnioFiscal")) {

					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(anioFiscal.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else if (e.getKey().equals("nombreEtapa")) {

					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(etapa.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else {
					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(" + e.getKey() + ")"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				}
			}

			entity = nivel4DAO.findByCriteriaPage(whereCondition, sortField, sortOrder, startRow, pageSize);

			List<Nivel4DTO> nivel4DTO = new ArrayList<Nivel4DTO>();

			for (Nivel4 nivel4Tmp : entity) {
				Nivel4DTO nivel4DTO2 = new Nivel4DTO();

				if (nivel4Tmp.getEstado().equals("A")) {
					nivel4DTO2.setNivel4Id(nivel4Tmp.getNivel4Id());
					nivel4DTO2.setAlturaPromedioPlantas((nivel4Tmp.getAlturaPromedioPlantas() != null)
							? nivel4Tmp.getAlturaPromedioPlantas() : null);
					nivel4DTO2.setVariedad((nivel4Tmp.getVariedad() != null) ? nivel4Tmp.getVariedad() : null);

					nivel4DTO2.setAna1((nivel4Tmp.getAna1() != null) ? nivel4Tmp.getAna1() : null);
					nivel4DTO2.setAplicacionMadurante(
							(nivel4Tmp.getAplicacionMadurante() != null) ? nivel4Tmp.getAplicacionMadurante() : null);
					nivel4DTO2.setAreaBruta((nivel4Tmp.getAreaBruta() != null) ? nivel4Tmp.getAreaBruta() : null);
					nivel4DTO2.setAreaInutil((nivel4Tmp.getAreaInutil() != null) ? nivel4Tmp.getAreaInutil() : null);
					nivel4DTO2.setAreaManual((nivel4Tmp.getAreaManual() != null) ? nivel4Tmp.getAreaManual() : null);
					nivel4DTO2.setAreaMecanizada(
							(nivel4Tmp.getAreaMecanizada() != null) ? nivel4Tmp.getAreaMecanizada() : null);
					nivel4DTO2.setAreaNeta((nivel4Tmp.getAreaNeta() != null) ? nivel4Tmp.getAreaNeta() : null);
					nivel4DTO2.setAreaOtrosCultivos(
							(nivel4Tmp.getAreaOtrosCultivos() != null) ? nivel4Tmp.getAreaOtrosCultivos() : null);
					nivel4DTO2.setAreaReservada(
							(nivel4Tmp.getAreaReservada() != null) ? nivel4Tmp.getAreaReservada() : null);
					nivel4DTO2.setAreaRestringida(
							(nivel4Tmp.getAreaRestringida() != null) ? nivel4Tmp.getAreaRestringida() : null);
					nivel4DTO2.setCantidadValvulasRiego((nivel4Tmp.getCantidadValvulasRiego() != null)
							? nivel4Tmp.getCantidadValvulasRiego() : null);
					nivel4DTO2.setCodigo((nivel4Tmp.getCodigo() != null) ? nivel4Tmp.getCodigo() : null);
					nivel4DTO2.setCodigoUsuarioApertura((nivel4Tmp.getCodigoUsuarioApertura() != null)
							? nivel4Tmp.getCodigoUsuarioApertura() : null);
					nivel4DTO2.setCodigoUsuarioCierre(
							(nivel4Tmp.getCodigoUsuarioCierre() != null) ? nivel4Tmp.getCodigoUsuarioCierre() : null);
					nivel4DTO2.setCompania((nivel4Tmp.getCompania() != null) ? nivel4Tmp.getCompania() : null);
					nivel4DTO2.setCostosAmortizados(
							(nivel4Tmp.getCostosAmortizados() != null) ? nivel4Tmp.getCostosAmortizados() : null);

					nivel4DTO2.setFechaUltimoCorte(nivel4Tmp.getFechaUltimoCorte());
					nivel4DTO2.setFechaDescanso(nivel4Tmp.getFechaDescanso());
					nivel4DTO2.setSistemaRiego((nivel4Tmp.getSistemaRiego()));

					nivel4DTO2.setEdadActual((nivel4Tmp.getEdadActual() != null)
							? listener_calcularEdadActual(nivel4Tmp.getFechaUltimoCorte()) : null);

					nivel4DTO2.setEdadUltimaCosecha(
							(nivel4Tmp.getEdadUltimaCosecha() != null) ? nivel4Tmp.getEdadUltimaCosecha() : null);
					nivel4DTO2.setEspacioLineasSembradas((nivel4Tmp.getEspacioLineasSembradas() != null)
							? nivel4Tmp.getEspacioLineasSembradas() : null);
					nivel4DTO2.setEstado((nivel4Tmp.getEstado() != null) ? nivel4Tmp.getEstado() : null);
					nivel4DTO2.setFechaAnalisisPostCosecha(nivel4Tmp.getFechaAnalisisPostCosecha());
					nivel4DTO2.setFechaAnalisisPreCosecha((nivel4Tmp.getFechaAnalisisPreCosecha() != null)
							? nivel4Tmp.getFechaAnalisisPreCosecha() : null);
					nivel4DTO2.setFechaAperturaCosecha(nivel4Tmp.getFechaAperturaCosecha());
					nivel4DTO2.setFechaAplicacionMadurante(nivel4Tmp.getFechaAplicacionMadurante());
					nivel4DTO2.setFechaCierreCosecha(nivel4Tmp.getFechaCierreCosecha());
					nivel4DTO2.setFechaCorteAnterior(nivel4Tmp.getFechaCorteAnterior());
					nivel4DTO2.setFechaCreacion(nivel4Tmp.getFechaCreacion());
					nivel4DTO2.setFechaEstimadaUltimoRiego(nivel4Tmp.getFechaEstimadaUltimoRiego());
					nivel4DTO2.setFechaInactivo(nivel4Tmp.getFechaInactivo());
					nivel4DTO2.setFechaModificacion(nivel4Tmp.getFechaModificacion());
					nivel4DTO2.setFechaPrimerCorte(nivel4Tmp.getFechaPrimerCorte());
					nivel4DTO2.setFechaProximoCorte(nivel4Tmp.getFechaProximoCorte());
					nivel4DTO2.setFechaSiembra(nivel4Tmp.getFechaSiembra());
					nivel4DTO2.setFechaUltimoApunteRiego(nivel4Tmp.getFechaUltimoApunteRiego());
					nivel4DTO2.setFotoInfraestructura(
							(nivel4Tmp.getFotoInfraestructura() != null) ? nivel4Tmp.getFotoInfraestructura() : null);
					nivel4DTO2.setGenerico((nivel4Tmp.getGenerico() != null) ? nivel4Tmp.getGenerico() : null);
					nivel4DTO2.setIndiceHelada(
							(nivel4Tmp.getIndiceHelada() != null) ? nivel4Tmp.getIndiceHelada() : null);
					nivel4DTO2.setInfoAdicional(
							(nivel4Tmp.getInfoAdicional() != null) ? nivel4Tmp.getInfoAdicional() : null);
					nivel4DTO2.setInfoAdicional2(
							(nivel4Tmp.getInfoAdicional2() != null) ? nivel4Tmp.getInfoAdicional2() : null);
					nivel4DTO2.setKilmNivel4Fab(
							(nivel4Tmp.getKilmNivel4Fab() != null) ? nivel4Tmp.getKilmNivel4Fab() : null);
					nivel4DTO2.setKilmNivel4FabPav(
							(nivel4Tmp.getKilmNivel4FabPav() != null) ? nivel4Tmp.getKilmNivel4FabPav() : null);
					nivel4DTO2.setKilmNivel4FabTerraceria((nivel4Tmp.getKilmNivel4FabTerraceria() != null)
							? nivel4Tmp.getKilmNivel4FabTerraceria() : null);
					nivel4DTO2.setLatitud((nivel4Tmp.getLatitud() != null) ? nivel4Tmp.getLatitud() : null);
					nivel4DTO2.setLongitud((nivel4Tmp.getLongitud() != null) ? nivel4Tmp.getLongitud() : null);
					nivel4DTO2.setNombre((nivel4Tmp.getNombre() != null) ? nivel4Tmp.getNombre() : null);
					nivel4DTO2.setNumComederosHect(
							(nivel4Tmp.getNumComederosHect() != null) ? nivel4Tmp.getNumComederosHect() : null);
					nivel4DTO2.setNumDensidadActual(
							(nivel4Tmp.getNumDensidadActual() != null) ? nivel4Tmp.getNumDensidadActual() : null);
					nivel4DTO2.setNumDensidadSiembra(
							(nivel4Tmp.getNumDensidadSiembra() != null) ? nivel4Tmp.getNumDensidadSiembra() : null);
					nivel4DTO2.setNumEstimTonAnioFiscal((nivel4Tmp.getNumEstimTonAnioFiscal() != null)
							? nivel4Tmp.getNumEstimTonAnioFiscal() : null);
					nivel4DTO2.setNumEstimTonHectPrimVez((nivel4Tmp.getNumEstimTonHectPrimVez() != null)
							? nivel4Tmp.getNumEstimTonHectPrimVez() : null);
					nivel4DTO2.setNumEstimTonMesAnioFiscal((nivel4Tmp.getNumEstimTonMesAnioFiscal() != null)
							? nivel4Tmp.getNumEstimTonMesAnioFiscal() : null);
					nivel4DTO2.setNumHectCosIndFab(
							(nivel4Tmp.getNumHectCosIndFab() != null) ? nivel4Tmp.getNumHectCosIndFab() : null);
					nivel4DTO2.setNumHectOtroDestino(
							(nivel4Tmp.getNumHectOtroDestino() != null) ? nivel4Tmp.getNumHectOtroDestino() : null);
					nivel4DTO2.setNumHectUltCosecha(
							(nivel4Tmp.getNumHectUltCosecha() != null) ? nivel4Tmp.getNumHectUltCosecha() : null);
					nivel4DTO2.setNumLarvasSembradas(
							(nivel4Tmp.getNumLarvasSembradas() != null) ? nivel4Tmp.getNumLarvasSembradas() : null);
					nivel4DTO2.setNumLineasSembradas(
							(nivel4Tmp.getNumLineasSembradas() != null) ? nivel4Tmp.getNumLineasSembradas() : null);
					nivel4DTO2.setNumPlantasActuales(
							(nivel4Tmp.getNumPlantasActuales() != null) ? nivel4Tmp.getNumPlantasActuales() : null);
					nivel4DTO2.setNumPlantasSembradas(
							(nivel4Tmp.getNumPlantasSembradas() != null) ? nivel4Tmp.getNumPlantasSembradas() : null);
					nivel4DTO2.setNumPlantasSembradas2(
							(nivel4Tmp.getNumPlantasSembradas2() != null) ? nivel4Tmp.getNumPlantasSembradas2() : null);
					nivel4DTO2.setNumRacionesCrustaceos((nivel4Tmp.getNumRacionesCrustaceos() != null)
							? nivel4Tmp.getNumRacionesCrustaceos() : null);
					nivel4DTO2.setNumTonCosIndFab(
							(nivel4Tmp.getNumTonCosIndFab() != null) ? nivel4Tmp.getNumTonCosIndFab() : null);
					nivel4DTO2.setNumTonOtroDestino(
							(nivel4Tmp.getNumTonOtroDestino() != null) ? nivel4Tmp.getNumTonOtroDestino() : null);
					nivel4DTO2.setNumTonUltCosecha(
							(nivel4Tmp.getNumTonUltCosecha() != null) ? nivel4Tmp.getNumTonUltCosecha() : null);
					nivel4DTO2.setPesoPromedioNivel4(
							(nivel4Tmp.getPesoPromedioNivel4() != null) ? nivel4Tmp.getPesoPromedioNivel4() : null);
					nivel4DTO2.setPrecision((nivel4Tmp.getPrecision() != null) ? nivel4Tmp.getPrecision() : null);
					nivel4DTO2

							.setRenovacion((nivel4Tmp.getRenovacion() != null) ? nivel4Tmp.getRenovacion() : null);
					nivel4DTO2.setSemillero((nivel4Tmp.getSemillero() != null) ? nivel4Tmp.getSemillero() : null);
					nivel4DTO2.setTotalComederos(
							(nivel4Tmp.getTotalComederos() != null) ? nivel4Tmp.getTotalComederos() : null);
					nivel4DTO2.setUltDosisAplicadaMadurante((nivel4Tmp.getUltDosisAplicadaMadurante() != null)
							? nivel4Tmp.getUltDosisAplicadaMadurante() : null);

					if (nivel4Tmp.getAlmacen() != null) {
						nivel4DTO2.setAlmacenId_Almacen(nivel4Tmp.getAlmacen().getAlmacenId());
					} else {
						nivel4DTO2.setAlmacenId_Almacen(null);
					}

					nivel4DTO2.setAnioFiscalId_AnioFiscal(
							(nivel4Tmp.getAnioFiscal() != null) ? nivel4Tmp.getAnioFiscal().getAnioFiscalId() : null);

					nivel4DTO2.setClaseTextSueloId_ClaseTextSuelo((nivel4Tmp.getClaseTextSuelo() != null)
							? nivel4Tmp.getClaseTextSuelo().getClaseTextSueloId() : null);

					nivel4DTO2.setEstClimatId_EstClimat(
							(nivel4Tmp.getEstClimat() != null) ? nivel4Tmp.getEstClimat().getEstClimatId() : null);

					if (nivel4Tmp.getEstEvaporimetro() != null) {

						nivel4DTO2.setEstEvaporimetroId_EstEvaporimetro(
								nivel4Tmp.getEstEvaporimetro().getEstEvaporimetroId());
					} else {

						nivel4DTO2.setEstEvaporimetroId_EstEvaporimetro(null);
					}

					if (nivel4Tmp.getEstPluvio() != null) {
						nivel4DTO2.setEstPluvioId_EstPluvio(nivel4Tmp.getEstPluvio().getEstPluvioId());
					} else {
						nivel4DTO2.setEstPluvioId_EstPluvio(null);
					}

					if (nivel4Tmp.getEtapa() != null) {
						nivel4DTO2.setEtapaId_Etapa(nivel4Tmp.getEtapa().getEtapaId());
					} else {
						nivel4DTO2.setEtapaId_Etapa(null);
					}

					nivel4DTO2.setFaseFenoId_FaseFenologica((nivel4Tmp.getFaseFenologica() != null)
							? nivel4Tmp.getFaseFenologica().getFaseFenoId() : null);
					nivel4DTO2.setFliaTextSueloId_FliaTextSuelo((nivel4Tmp.getFliaTextSuelo() != null)
							? nivel4Tmp.getFliaTextSuelo().getFliaTextSueloId() : null);

					nivel4DTO2.setGrupoSuelo_GrpSuelo(
							(nivel4Tmp.getGrpSuelo() != null) ? nivel4Tmp.getGrpSuelo().getGrupoSuelo() : null);

					if (nivel4Tmp.getN4Motivo() != null) {

						nivel4DTO2.setN4Mot_N4Motivo(nivel4Tmp.getN4Motivo().getN4Mot());

					} else {
						nivel4DTO2.setN4Mot_N4Motivo(null);
					}

					if (nivel4Tmp.getNivel3() != null) {
						nivel4DTO2.setNivel3Id_Nivel3(nivel4Tmp.getNivel3().getNivel3Id());
					} else {
						nivel4DTO2.setNivel3Id_Nivel3(null);
					}

					if (nivel4Tmp.getOcupacion() != null) {
						nivel4DTO2.setOcupacionId_Ocupacion(nivel4Tmp.getOcupacion().getOcupacionId());
					} else {
						nivel4DTO2.setOcupacionId_Ocupacion(null);
					}

					nivel4DTO2.setOrdenSuelo_OrdenSuelo(
							(nivel4Tmp.getOrdenSuelo() != null) ? nivel4Tmp.getOrdenSuelo().getOrdenSuelo() : null);

					if (nivel4Tmp.getOrganizacion() != null) {
						nivel4DTO2.setOrganizId_Organizacion(nivel4Tmp.getOrganizacion().getOrganizId());
					} else {
						nivel4DTO2.setOrganizId_Organizacion(null);
					}

					if (nivel4Tmp.getPersEmpr() != null) {

						nivel4DTO2.setPersEmprId_persEmpr(nivel4Tmp.getPersEmpr());

					} else {
						nivel4DTO2.setPersEmprId_persEmpr(null);
					}

					if (nivel4Tmp.getSerieSuelo() != null) {

						nivel4DTO2.setSerieSueloId_SerieSuelo(nivel4Tmp.getSerieSuelo().getSerieSueloId());

					} else {

						nivel4DTO2.setSerieSueloId_SerieSuelo(null);
					}

					if (nivel4Tmp.getTenencia() != null) {
						nivel4DTO2.setTenenId_Tenencia(nivel4Tmp.getTenencia().getTenenId());
					} else {
						nivel4DTO2.setTenenId_Tenencia(null);
					}

					if (nivel4Tmp.getTipCultivo() != null) {
						nivel4DTO2.setTipoCultivoId_TipCultivo(nivel4Tmp.getTipCultivo().getTipoCultivoId());
					} else {
						nivel4DTO2.setTipoCultivoId_TipCultivo(null);
					}

					if (nivel4Tmp.getTipoDrenaje() != null) {

						nivel4DTO2.setTipoDrenajeId_TipoDrenaje(nivel4Tmp.getTipoDrenaje().getTipoDrenajeId());

					} else {

						nivel4DTO2.setTipoDrenajeId_TipoDrenaje(null);
					}

					if (nivel4Tmp.getTopografia() != null) {
						nivel4DTO2.setTopografiaId_Topografia(nivel4Tmp.getTopografia().getTopografiaId());
					} else {
						nivel4DTO2.setTopografiaId_Topografia(null);
					}

					if (nivel4Tmp.getTrabajador() != null) {
						nivel4DTO2.setTrabId_Trabajador(nivel4Tmp.getTrabajador().getTrabId());
					} else {
						nivel4DTO2.setTrabId_Trabajador(null);
					}

					if (nivel4Tmp.getZonAgroec() != null) {
						nivel4DTO2.setZonAgroec_ZonAgroec(nivel4Tmp.getZonAgroec().getZonAgroec());
					} else {
						nivel4DTO2.setZonAgroec_ZonAgroec(null);
					}

					// String nombreAnioFiscal =
					// nivel4Tmp.getAnioFiscal().getNombre();
					// nivel4DTO2.setNombreAnioFiscal(nombreAnioFiscal);
					nivel4DTO2.setNombreBloque(nivel4Tmp.getNivel3().getNombre());

					if (nivel4Tmp.getEtapa() != null) {
						nivel4DTO2.setNombreEtapa(nivel4Tmp.getEtapa().getNombre());
					} else {
						nivel4DTO2.setNombreEtapa(null);
					}
					
					nivel4DTO2.setNumTonHaMesUltCosecha(
							(nivel4Tmp.getNumTonHaMesUltCosecha() != null) ? nivel4Tmp.getNumTonHaMesUltCosecha() : null);
					
					
					nivel4DTO.add(nivel4DTO2);
				}

			}

			return nivel4DTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberNivel4(Map<String, Object> filters) throws Exception {
		Long entity = null;

		try {
			String whereCondition = new String();
			Iterator it = filters.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry e = (Map.Entry) it.next();
				/*
				 * whereCondition += ((whereCondition.length() == 0) ? " " :
				 * " and ") + "upper(" + e.getKey() + ")" + " LIKE '%" +
				 * e.getValue().toString().toUpperCase() + "%' ";
				 */
				if (e.getKey().equals("nombreAnioFiscal")) {

					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(labor.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else if (e.getKey().equals("nombreEtapa")) {

					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(etapa.nombre)"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				} else {
					whereCondition += ((whereCondition.length() == 0) ? " " : " and ") + "upper(" + e.getKey() + ")"
							+ " LIKE '%" + e.getValue().toString().toUpperCase() + "%' ";

				}
			}
			entity = nivel4DAO.countByCriteria(whereCondition);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Nivel4 Count");
		} finally {
		}
		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Nivel4 getNivel4(Long nivel4Id) throws Exception {
		log.debug("getting Nivel4 instance");

		Nivel4 entity = null;

		try {
			entity = nivel4DAO.findById(nivel4Id);
		} catch (Exception e) {
			log.error("get Nivel4 failed", e);
			throw new ZMessManager().new FindingException("Nivel4");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Nivel4> findPageNivel4(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<Nivel4> entity = null;

		try {
			entity = nivel4DAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Nivel4 Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberNivel4() throws Exception {
		Long entity = null;

		try {
			entity = nivel4DAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Nivel4 Count");
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
	public List<Nivel4> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<Nivel4> list = new ArrayList<Nivel4>();
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
			list = nivel4DAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
