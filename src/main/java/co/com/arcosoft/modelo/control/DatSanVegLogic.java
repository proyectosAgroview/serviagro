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

import co.com.arcosoft.dataaccess.dao.IDatSanVegDAO;
import co.com.arcosoft.dataaccess.dao.IValorVarDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatSanVeg;
import co.com.arcosoft.modelo.ValorVar;
import co.com.arcosoft.modelo.dto.DatSanVegDTO;
import co.com.arcosoft.modelo.dto.ValorVarDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("DatSanVegLogic")
public class DatSanVegLogic implements IDatSanVegLogic {
	private static final Logger log = LoggerFactory.getLogger(DatSanVegLogic.class);

	/**
	 * DAO injected by Spring that manages DatSanVeg entities
	 *
	 */
	@Autowired
	private IDatSanVegDAO datSanVegDAO;

	/**
	 * DAO injected by Spring that manages ValorVar entities
	 *
	 */
	@Autowired
	private IValorVarDAO valorVarDAO;

	/**
	 * Logic injected by Spring that manages AnaSanVeg entities
	 *
	 */
	@Autowired
	IAnaSanVegLogic logicAnaSanVeg1;

	/**
	 * Logic injected by Spring that manages Nivel2 entities
	 *
	 */
	@Autowired
	INivel2Logic logicNivel22;

	/**
	 * Logic injected by Spring that manages Nivel4 entities
	 *
	 */
	@Autowired
	INivel4Logic logicNivel43;

	/**
	 * Logic injected by Spring that manages Trabajador entities
	 *
	 */
	@Autowired
	ITrabajadorLogic logicTrabajador4;

	@Transactional(readOnly = true)
	public List<DatSanVeg> getDatSanVeg() throws Exception {
		log.debug("finding all DatSanVeg instances");

		List<DatSanVeg> list = new ArrayList<DatSanVeg>();

		try {
			list = datSanVegDAO.findAll();
		} catch (Exception e) {
			log.error("finding all DatSanVeg failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "DatSanVeg");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveDatSanVeg(DatSanVeg entity, List<ValorVarDTO> dataValor) throws Exception {
		log.debug("saving DatSanVeg instance");

		try {
			/*if (entity.getAnaSanVeg() == null) {
				throw new ZMessManager().new ForeignException("anaSanVeg");
			}*/

			if (entity.getNivel2() == null) {
				throw new ZMessManager().new ForeignException("nivel2");
			}

			if (entity.getNivel4() == null) {
				throw new ZMessManager().new ForeignException("nivel4");
			}

			/*
			 * if (entity.getTrabajador() == null) { throw new
			 * ZMessManager().new ForeignException("trabajador"); }
			 */

			if ((entity.getFoto() != null) && (Utilities.checkWordAndCheckWithlength(entity.getFoto(), 150) == false)) {
				throw new ZMessManager().new NotValidFormatException("foto");
			}

			if ((entity.getAnioFiscalNivel4() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAnioFiscalNivel4(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("anioFiscalNivel4");
			}

			if ((entity.getAreaBruta() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAreaBruta(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("areaBruta");
			}

			if ((entity.getAreaNeta() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAreaNeta(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("areaNeta");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getConsecutivo() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getConsecutivo(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("consecutivo");
			}

			if ((entity.getEdadNivel4() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEdadNivel4(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("edadNivel4");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getEtapaNivel4() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEtapaNivel4(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("etapaNivel4");
			}

			if ((entity.getFaseFenoNivel4() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getFaseFenoNivel4(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("faseFenoNivel4");
			}

			if ((entity.getInfoAdicional() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional");
			}

			if ((entity.getInfoAdicional2() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional2(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional2");
			}

			if ((entity.getMobileId() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getMobileId(), 23) == false)) {
				throw new ZMessManager().new NotValidFormatException("mobileId");
			}

			if ((entity.getNivel1Id() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivel1Id(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivel1Id");
			}

			if ((entity.getNivel3Id() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivel3Id(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivel3Id");
			}

			if ((entity.getNumPlantasActuales() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumPlantasActuales(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("numPlantasActuales");
			}

			if ((entity.getNumPlantasSembradas() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumPlantasSembradas(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("numPlantasSembradas");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacion(), 1000) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacion");
			}

			if ((entity.getObservacionAnularReg() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacionAnularReg(), 500) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacionAnularReg");
			}

			if ((entity.getUsuarioDigitacion() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getUsuarioDigitacion(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("usuarioDigitacion");
			}

			if ((entity.getVariedNivel4() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariedNivel4(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("variedNivel4");
			}

			/*if (entity.getAnaSanVeg().getAnaSanVegId() == null) {
				throw new ZMessManager().new EmptyFieldException("anaSanVegId_AnaSanVeg");
			}

			if ((entity.getAnaSanVeg().getAnaSanVegId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAnaSanVeg().getAnaSanVegId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("anaSanVegId_AnaSanVeg");
			}*/

			if (entity.getNivel2().getNivel2Id() == null) {
				throw new ZMessManager().new EmptyFieldException("nivel2Id_Nivel2");
			}

			if ((entity.getNivel2().getNivel2Id() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivel2().getNivel2Id(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivel2Id_Nivel2");
			}

			if (entity.getNivel4().getNivel4Id() == null) {
				throw new ZMessManager().new EmptyFieldException("nivel4Id_Nivel4");
			}

			if ((entity.getNivel4().getNivel4Id() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivel4().getNivel4Id(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivel4Id_Nivel4");
			}

			/*
			 * if (entity.getTrabajador().getTrabId() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "trabId_Trabajador"); }
			 */
			if ((entity.getTrabajador() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTrabajador(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("trabId_Trabajador");
			}

			if ((entity.getVariable1() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable1(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable1");
			}

			if ((entity.getVariable2() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable2(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable2");
			}

			if ((entity.getVariable3() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable3(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable3");
			}

			if ((entity.getVariable4() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable4(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable4");
			}

			if ((entity.getVariable5() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable5(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable5");
			}

			if ((entity.getVariable6() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable6(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable6");
			}

			if ((entity.getVariable7() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable7(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable7");
			}

			if ((entity.getVariable8() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable8(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable8");
			}
			if ((entity.getVariable9() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable9(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable9");
			}
			if ((entity.getVariable10() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable10(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable10");
			}
			if ((entity.getVariable11() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable11(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable11");
			}
			if ((entity.getVariable12() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable12(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable12");
			}
			if ((entity.getVariable13() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable13(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable13");
			}
			if ((entity.getVariable14() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable14(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable14");
			}
			if ((entity.getVariable15() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable15(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable15");
			}
			if ((entity.getVariable16() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable16(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable16");
			}
			if ((entity.getVariable17() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable17(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable17");
			}
			if ((entity.getVariable18() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable18(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable18");
			}
			if ((entity.getVariable19() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable19(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable19");
			}
			if ((entity.getVariable20() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable20(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable20");
			}
			if ((entity.getVariable21() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable21(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable21");
			}
			if ((entity.getVariable22() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable22(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable22");
			}
			if ((entity.getVariable23() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable23(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable23");
			}
			if ((entity.getVariable24() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable24(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable24");
			}
			if ((entity.getVariable25() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable25(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable25");
			}
			if ((entity.getVariable26() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable26(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable26");
			}
			if ((entity.getVariable27() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable27(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable27");
			}
			if ((entity.getVariable28() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable28(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable28");
			}
			if ((entity.getVariable29() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable29(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable29");
			}
			if ((entity.getVariable30() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable30(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable30");
			}

			if ((entity.getVariableText1() != null)
					&& (Utilities.checkWordAndCheckWithlength("" + entity.getVariableText1(), 50) == false)) {
				throw new ZMessManager().new NotValidFormatException("variableText1");
			}
			if ((entity.getVariableText2() != null)
					&& (Utilities.checkWordAndCheckWithlength("" + entity.getVariableText2(), 50) == false)) {
				throw new ZMessManager().new NotValidFormatException("variableText2");
			}
			if ((entity.getVariableText3() != null)
					&& (Utilities.checkWordAndCheckWithlength("" + entity.getVariableText3(), 50) == false)) {
				throw new ZMessManager().new NotValidFormatException("variableText3");
			}
			if ((entity.getVariableText4() != null)
					&& (Utilities.checkWordAndCheckWithlength("" + entity.getVariableText4(), 50) == false)) {
				throw new ZMessManager().new NotValidFormatException("variableText4");
			}
			if ((entity.getVariableText5() != null)
					&& (Utilities.checkWordAndCheckWithlength("" + entity.getVariableText5(), 50) == false)) {
				throw new ZMessManager().new NotValidFormatException("variableText5");
			}
			/*
			 * if (entity.getDatSanVegId() == null) { throw new
			 * ZMessManager().new EmptyFieldException("datSanVegId"); }
			 * 
			 * if ((entity.getDatSanVegId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getDatSanVegId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "datSanVegId"); }
			 * 
			 * if (getDatSanVeg(entity.getDatSanVegId()) != null) { throw new
			 * ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */

			datSanVegDAO.save(entity);

			if (dataValor != null) {

				for (ValorVarDTO valorDto : dataValor) {

					if (valorDto.getValorVarId() == null) {

						ValorVar valor = new ValorVar();
						valor.setFitosanidad(valorDto.getFitosanidad());
						valor.setVariableDate1(valorDto.getVariableDate1());
						valor.setVariable1(valorDto.getVariable1());
						valor.setVariable2(valorDto.getVariable2());
						valor.setVariable3(valorDto.getVariable3());
						valor.setVariable4(valorDto.getVariable4());
						valor.setVariable5(valorDto.getVariable5());
						valor.setVariable6(valorDto.getVariable5());
						valor.setVariable7(valorDto.getVariable5());
						valor.setVariable8(valorDto.getVariable5());
						valor.setVariable9(valorDto.getVariable5());
						valor.setVariable10(valorDto.getVariable5());
						valor.setVariableText1(valorDto.getVariableText1());
						valor.setVariableText2(valorDto.getVariableText2());
						valor.setVariableText3(valorDto.getVariableText3());
						valor.setVariableText4(valorDto.getVariableText4());
						valor.setVariableText5(valorDto.getVariableText5());
						valor.setVariableText6(valorDto.getVariableText6());
						valor.setVariableText7(valorDto.getVariableText7());
						valor.setVariableText8(valorDto.getVariableText8());
						valor.setVariableText9(valorDto.getVariableText9());
						valor.setVariableText10(valorDto.getVariableText10());
						
						valor.setDatSanVeg(entity);

						valorVarDAO.save(valor);
					}

				}
			}

			log.debug("save DatSanVeg successful");
		} catch (Exception e) {
			log.error("save DatSanVeg failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteDatSanVeg(DatSanVeg entity) throws Exception {
		log.debug("deleting DatSanVeg instance");

		/*if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("DatSanVeg");
		}*/

		if (entity.getDatSanVegId() == null) {
			throw new ZMessManager().new EmptyFieldException("datSanVegId");
		}

		List<ValorVar> valorVars = null;

		try {
			valorVars = valorVarDAO.findByProperty("datSanVeg.datSanVegId", entity.getDatSanVegId());

			if (Utilities.validationsList(valorVars) == true) {
				throw new ZMessManager().new DeletingException("valorVars");
			}

			datSanVegDAO.delete(entity);

			log.debug("delete DatSanVeg successful");
		} catch (Exception e) {
			log.error("delete DatSanVeg failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateDatSanVeg(DatSanVeg entity, List<ValorVarDTO> dataValor) throws Exception {
		log.debug("updating DatSanVeg instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("DatSanVeg");
			}

			if (entity.getAnaSanVeg() == null) {
				throw new ZMessManager().new ForeignException("anaSanVeg");
			}

			if (entity.getNivel2() == null) {
				throw new ZMessManager().new ForeignException("nivel2");
			}

			if (entity.getNivel4() == null) {
				throw new ZMessManager().new ForeignException("nivel4");
			}
			/*
			 * if (entity.getTrabajador() == null) { throw new
			 * ZMessManager().new ForeignException("trabajador"); }
			 */

			if ((entity.getFoto() != null) && (Utilities.checkWordAndCheckWithlength(entity.getFoto(), 150) == false)) {
				throw new ZMessManager().new NotValidFormatException("foto");
			}

			if ((entity.getAnioFiscalNivel4() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAnioFiscalNivel4(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("anioFiscalNivel4");
			}

			if ((entity.getAreaBruta() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAreaBruta(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("areaBruta");
			}

			if ((entity.getAreaNeta() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAreaNeta(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("areaNeta");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getConsecutivo() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getConsecutivo(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("consecutivo");
			}

			if (entity.getDatSanVegId() == null) {
				throw new ZMessManager().new EmptyFieldException("datSanVegId");
			}

			if ((entity.getDatSanVegId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getDatSanVegId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("datSanVegId");
			}

			if ((entity.getEdadNivel4() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEdadNivel4(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("edadNivel4");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getEtapaNivel4() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getEtapaNivel4(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("etapaNivel4");
			}

			if ((entity.getFaseFenoNivel4() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getFaseFenoNivel4(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("faseFenoNivel4");
			}

			if ((entity.getInfoAdicional() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional");
			}

			if ((entity.getInfoAdicional2() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getInfoAdicional2(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("infoAdicional2");
			}

			if ((entity.getMobileId() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getMobileId(), 23) == false)) {
				throw new ZMessManager().new NotValidFormatException("mobileId");
			}

			if ((entity.getNivel1Id() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivel1Id(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivel1Id");
			}

			if ((entity.getNivel3Id() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivel3Id(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivel3Id");
			}

			if ((entity.getNumPlantasActuales() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumPlantasActuales(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("numPlantasActuales");
			}

			if ((entity.getNumPlantasSembradas() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNumPlantasSembradas(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("numPlantasSembradas");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacion(), 1000) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacion");
			}

			if ((entity.getObservacionAnularReg() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacionAnularReg(), 500) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacionAnularReg");
			}

			if ((entity.getUsuarioDigitacion() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getUsuarioDigitacion(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("usuarioDigitacion");
			}

			if ((entity.getVariedNivel4() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariedNivel4(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("variedNivel4");
			}

			if (entity.getAnaSanVeg().getAnaSanVegId() == null) {
				throw new ZMessManager().new EmptyFieldException("anaSanVegId_AnaSanVeg");
			}

			if ((entity.getAnaSanVeg().getAnaSanVegId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAnaSanVeg().getAnaSanVegId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("anaSanVegId_AnaSanVeg");
			}

			if (entity.getNivel2().getNivel2Id() == null) {
				throw new ZMessManager().new EmptyFieldException("nivel2Id_Nivel2");
			}

			if ((entity.getNivel2().getNivel2Id() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivel2().getNivel2Id(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivel2Id_Nivel2");
			}

			if (entity.getNivel4().getNivel4Id() == null) {
				throw new ZMessManager().new EmptyFieldException("nivel4Id_Nivel4");
			}

			if ((entity.getNivel4().getNivel4Id() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getNivel4().getNivel4Id(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("nivel4Id_Nivel4");
			}

			/*
			 * if (entity.getTrabajador().getTrabId() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "trabId_Trabajador"); }
			 */

			if ((entity.getTrabajador() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTrabajador(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("trabId_Trabajador");
			}

			if ((entity.getVariable1() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable1(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable1");
			}

			if ((entity.getVariable2() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable2(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable2");
			}

			if ((entity.getVariable3() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable3(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable3");
			}

			if ((entity.getVariable4() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable4(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable4");
			}

			if ((entity.getVariable5() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable5(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable5");
			}

			if ((entity.getVariable6() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable6(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable6");
			}

			if ((entity.getVariable7() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable7(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable7");
			}

			if ((entity.getVariable8() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable8(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable8");
			}
			if ((entity.getVariable9() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable9(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable9");
			}
			if ((entity.getVariable10() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable10(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable10");
			}
			if ((entity.getVariable11() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable11(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable11");
			}
			if ((entity.getVariable12() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable12(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable12");
			}
			if ((entity.getVariable13() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable13(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable13");
			}
			if ((entity.getVariable14() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable14(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable14");
			}
			if ((entity.getVariable15() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable15(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable15");
			}
			if ((entity.getVariable16() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable16(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable16");
			}
			if ((entity.getVariable17() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable17(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable17");
			}
			if ((entity.getVariable18() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable18(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable18");
			}
			if ((entity.getVariable19() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable19(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable19");
			}
			if ((entity.getVariable20() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable20(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable20");
			}
			if ((entity.getVariable21() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable21(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable21");
			}
			if ((entity.getVariable22() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable22(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable22");
			}
			if ((entity.getVariable23() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable23(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable23");
			}
			if ((entity.getVariable24() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable24(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable24");
			}
			if ((entity.getVariable25() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable25(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable25");
			}
			if ((entity.getVariable26() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable26(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable26");
			}
			if ((entity.getVariable27() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable27(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable27");
			}
			if ((entity.getVariable28() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable28(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable28");
			}
			if ((entity.getVariable29() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable29(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable29");
			}
			if ((entity.getVariable30() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getVariable30(), 12, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("variable30");
			}

			if ((entity.getVariableText1() != null)
					&& (Utilities.checkWordAndCheckWithlength("" + entity.getVariableText1(), 50) == false)) {
				throw new ZMessManager().new NotValidFormatException("variableText1");
			}
			if ((entity.getVariableText2() != null)
					&& (Utilities.checkWordAndCheckWithlength("" + entity.getVariableText2(), 50) == false)) {
				throw new ZMessManager().new NotValidFormatException("variableText2");
			}
			if ((entity.getVariableText3() != null)
					&& (Utilities.checkWordAndCheckWithlength("" + entity.getVariableText3(), 50) == false)) {
				throw new ZMessManager().new NotValidFormatException("variableText3");
			}
			if ((entity.getVariableText4() != null)
					&& (Utilities.checkWordAndCheckWithlength("" + entity.getVariableText4(), 50) == false)) {
				throw new ZMessManager().new NotValidFormatException("variableText4");
			}
			if ((entity.getVariableText5() != null)
					&& (Utilities.checkWordAndCheckWithlength("" + entity.getVariableText5(), 50) == false)) {
				throw new ZMessManager().new NotValidFormatException("variableText5");
			}

			datSanVegDAO.update(entity);

			if (dataValor != null) {

				for (ValorVarDTO valorDto : dataValor) {

					if (valorDto.getValorVarId() == null) { // crear el valor
															// nuevo

						ValorVar valor = new ValorVar();
						valor.setFitosanidad(valorDto.getFitosanidad());
						valor.setVariableDate1(valorDto.getVariableDate1());
						valor.setVariable1(valorDto.getVariable1());
						valor.setVariable2(valorDto.getVariable2());
						valor.setVariable3(valorDto.getVariable3());
						valor.setVariable4(valorDto.getVariable4());
						valor.setVariable5(valorDto.getVariable5());
						valor.setVariable6(valorDto.getVariable5());
						valor.setVariable7(valorDto.getVariable5());
						valor.setVariable8(valorDto.getVariable5());
						valor.setVariable9(valorDto.getVariable5());
						valor.setVariable10(valorDto.getVariable5());
						valor.setVariableText1(valorDto.getVariableText1());
						valor.setVariableText2(valorDto.getVariableText2());
						valor.setVariableText3(valorDto.getVariableText3());
						valor.setVariableText4(valorDto.getVariableText4());
						valor.setVariableText5(valorDto.getVariableText5());
						valor.setVariableText6(valorDto.getVariableText6());
						valor.setVariableText7(valorDto.getVariableText7());
						valor.setVariableText8(valorDto.getVariableText8());
						valor.setVariableText9(valorDto.getVariableText9());
						valor.setVariableText10(valorDto.getVariableText10());
						
						
						
						valor.setDatSanVeg(entity);

						valorVarDAO.save(valor);

					} else {
						ValorVar valor = valorVarDAO.findById(valorDto.getValorVarId());

						valor.setFitosanidad(valorDto.getFitosanidad());
						valor.setVariableDate1(valorDto.getVariableDate1());
						valor.setVariable1(valorDto.getVariable1());
						valor.setVariable2(valorDto.getVariable2());
						valor.setVariable3(valorDto.getVariable3());
						valor.setVariable4(valorDto.getVariable4());
						valor.setVariable5(valorDto.getVariable5());
						valor.setVariable6(valorDto.getVariable5());
						valor.setVariable7(valorDto.getVariable5());
						valor.setVariable8(valorDto.getVariable5());
						valor.setVariable9(valorDto.getVariable5());
						valor.setVariable10(valorDto.getVariable5());
						valor.setVariableText1(valorDto.getVariableText1());
						valor.setVariableText2(valorDto.getVariableText2());
						valor.setVariableText3(valorDto.getVariableText3());
						valor.setVariableText4(valorDto.getVariableText4());
						valor.setVariableText5(valorDto.getVariableText5());
						valor.setVariableText6(valorDto.getVariableText6());
						valor.setVariableText7(valorDto.getVariableText7());
						valor.setVariableText8(valorDto.getVariableText8());
						valor.setVariableText9(valorDto.getVariableText9());
						valor.setVariableText10(valorDto.getVariableText10());
						
						valor.setDatSanVeg(entity);

						valorVarDAO.update(valor);
					}

				}
			}

			log.debug("update DatSanVeg successful");
		} catch (Exception e) {
			log.error("update DatSanVeg failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<DatSanVegDTO> getDataDatSanVeg(Long idAnalisis) throws Exception {
		try {
			List<DatSanVeg> datSanVeg = datSanVegDAO.findByCriteria("anaSanVeg.anaSanVegId= " + idAnalisis);

			List<DatSanVegDTO> datSanVegDTO = new ArrayList<DatSanVegDTO>();

			for (DatSanVeg datSanVegTmp : datSanVeg) {
				DatSanVegDTO datSanVegDTO2 = new DatSanVegDTO();

				datSanVegDTO2.setDatSanVegId(datSanVegTmp.getDatSanVegId());
				datSanVegDTO2.setAnioFiscalNivel4(
						(datSanVegTmp.getAnioFiscalNivel4() != null) ? datSanVegTmp.getAnioFiscalNivel4() : null);
				datSanVegDTO2.setAreaBruta((datSanVegTmp.getAreaBruta() != null) ? datSanVegTmp.getAreaBruta() : null);
				datSanVegDTO2.setAreaNeta((datSanVegTmp.getAreaNeta() != null) ? datSanVegTmp.getAreaNeta() : null);
				datSanVegDTO2.setCompania((datSanVegTmp.getCompania() != null) ? datSanVegTmp.getCompania() : null);
				datSanVegDTO2
						.setConsecutivo((datSanVegTmp.getConsecutivo() != null) ? datSanVegTmp.getConsecutivo() : null);
				datSanVegDTO2
						.setEdadNivel4((datSanVegTmp.getEdadNivel4() != null) ? datSanVegTmp.getEdadNivel4() : null);
				datSanVegDTO2.setEstado((datSanVegTmp.getEstado() != null) ? datSanVegTmp.getEstado() : null);
				datSanVegDTO2
						.setEtapaNivel4((datSanVegTmp.getEtapaNivel4() != null) ? datSanVegTmp.getEtapaNivel4() : null);
				datSanVegDTO2.setFaseFenoNivel4(
						(datSanVegTmp.getFaseFenoNivel4() != null) ? datSanVegTmp.getFaseFenoNivel4() : null);
				datSanVegDTO2.setFechaAnalisis(datSanVegTmp.getFechaAnalisis());
				datSanVegDTO2.setFechaCreacion(datSanVegTmp.getFechaCreacion());
				datSanVegDTO2.setFechaModificacion(datSanVegTmp.getFechaModificacion());
				datSanVegDTO2.setInfoAdicional(
						(datSanVegTmp.getInfoAdicional() != null) ? datSanVegTmp.getInfoAdicional() : null);
				datSanVegDTO2.setInfoAdicional2(
						(datSanVegTmp.getInfoAdicional2() != null) ? datSanVegTmp.getInfoAdicional2() : null);
				datSanVegDTO2.setMobileId((datSanVegTmp.getMobileId() != null) ? datSanVegTmp.getMobileId() : null);
				datSanVegDTO2.setNivel1Id((datSanVegTmp.getNivel1Id() != null) ? datSanVegTmp.getNivel1Id() : null);
				datSanVegDTO2.setNivel3Id((datSanVegTmp.getNivel3Id() != null) ? datSanVegTmp.getNivel3Id() : null);
				datSanVegDTO2.setNumPlantasActuales(
						(datSanVegTmp.getNumPlantasActuales() != null) ? datSanVegTmp.getNumPlantasActuales() : null);
				datSanVegDTO2.setNumPlantasSembradas(
						(datSanVegTmp.getNumPlantasSembradas() != null) ? datSanVegTmp.getNumPlantasSembradas() : null);
				datSanVegDTO2
						.setObservacion((datSanVegTmp.getObservacion() != null) ? datSanVegTmp.getObservacion() : null);
				datSanVegDTO2.setObservacionAnularReg((datSanVegTmp.getObservacionAnularReg() != null)
						? datSanVegTmp.getObservacionAnularReg() : null);
				datSanVegDTO2.setUsuarioDigitacion(
						(datSanVegTmp.getUsuarioDigitacion() != null) ? datSanVegTmp.getUsuarioDigitacion() : null);
				datSanVegDTO2.setVariedNivel4(
						(datSanVegTmp.getVariedNivel4() != null) ? datSanVegTmp.getVariedNivel4() : null);
				datSanVegDTO2.setAnaSanVegId_AnaSanVeg((datSanVegTmp.getAnaSanVeg().getAnaSanVegId() != null)
						? datSanVegTmp.getAnaSanVeg().getAnaSanVegId() : null);

				datSanVegDTO2.setNombreAnalisis((datSanVegTmp.getAnaSanVeg().getNombre() != null)
						? datSanVegTmp.getAnaSanVeg().getNombre() : null);

				if (datSanVegTmp.getNivel2() != null) {
					datSanVegDTO2.setNivel2Id_Nivel2(datSanVegTmp.getNivel2().getNivel2Id());
				} else {
					datSanVegDTO2.setNivel2Id_Nivel2(null);
				}

				if (datSanVegTmp.getNivel4() != null) {
					datSanVegDTO2.setNivel4Id_Nivel4(datSanVegTmp.getNivel4().getNivel4Id());
				} else {
					datSanVegDTO2.setNivel4Id_Nivel4(null);
				}

				if (datSanVegTmp.getTrabajador() != null) {
					datSanVegDTO2.setTrabId_Trabajador(datSanVegTmp.getTrabajador());
				} else {
					datSanVegDTO2.setTrabId_Trabajador(null);
				}

				datSanVegDTO2.setVariable1((datSanVegTmp.getVariable1() != null) ? datSanVegTmp.getVariable1() : null);
				datSanVegDTO2.setVariable2((datSanVegTmp.getVariable2() != null) ? datSanVegTmp.getVariable2() : null);
				datSanVegDTO2.setVariable3((datSanVegTmp.getVariable3() != null) ? datSanVegTmp.getVariable3() : null);
				datSanVegDTO2.setVariable4((datSanVegTmp.getVariable4() != null) ? datSanVegTmp.getVariable4() : null);
				datSanVegDTO2.setFoto((datSanVegTmp.getFoto() != null && !datSanVegTmp.getFoto().equals(""))
						? datSanVegTmp.getFoto() : "default.jpg");

				datSanVegDTO2.setVariable5((datSanVegTmp.getVariable5() != null) ? datSanVegTmp.getVariable5() : null);
				datSanVegDTO2.setVariable6((datSanVegTmp.getVariable6() != null) ? datSanVegTmp.getVariable6() : null);
				datSanVegDTO2.setVariableText1(
						(datSanVegTmp.getVariableText1() != null) ? datSanVegTmp.getVariableText1() : null);
				datSanVegDTO2.setVariableText2(
						(datSanVegTmp.getVariableText2() != null) ? datSanVegTmp.getVariableText2() : null);
				datSanVegDTO2.setVariableText3(
						(datSanVegTmp.getVariableText3() != null) ? datSanVegTmp.getVariableText3() : null);
				datSanVegDTO2.setVariableText4(
						(datSanVegTmp.getVariableText4() != null) ? datSanVegTmp.getVariableText4() : null);
				datSanVegDTO2.setVariableText5(
						(datSanVegTmp.getVariableText5() != null) ? datSanVegTmp.getVariableText5() : null);

				if (datSanVegTmp.getNivel2() != null) {
					datSanVegDTO2.setNombreHacienda(datSanVegTmp.getNivel2().getNombre());
				} else {
					datSanVegDTO2.setNombreHacienda(null);
				}

				if (datSanVegTmp.getNivel4() != null) {
					datSanVegDTO2.setNombreLote(datSanVegTmp.getNivel4().getNombre());
				} else {
					datSanVegDTO2.setNombreLote(null);
				}

				String btodescarga = "true";
				if(datSanVegTmp.getFoto() !=null) {
					
					btodescarga = "false";
					datSanVegDTO2.setFoto(datSanVegTmp.getFoto());
					datSanVegDTO2.setDisableBtoDescarga(btodescarga);
	
				}else {
					
					btodescarga = "true";
					datSanVegDTO2.setFoto(null);
					datSanVegDTO2.setDisableBtoDescarga(btodescarga);

				}
				String estadoEstrue = "false";
				if (datSanVegTmp.getEstado().equals("I")) {
					estadoEstrue = "true";
					datSanVegDTO2.setEstadoTrue(estadoEstrue);
				}
				datSanVegDTO2.setEstadoTrue(estadoEstrue);

				datSanVegDTO.add(datSanVegDTO2);
			}

			return datSanVegDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public DatSanVeg getDatSanVeg(Long datSanVegId) throws Exception {
		log.debug("getting DatSanVeg instance");

		DatSanVeg entity = null;

		try {
			entity = datSanVegDAO.findById(datSanVegId);
		} catch (Exception e) {
			log.error("get DatSanVeg failed", e);
			throw new ZMessManager().new FindingException("DatSanVeg");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<DatSanVeg> findPageDatSanVeg(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<DatSanVeg> entity = null;

		try {
			entity = datSanVegDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatSanVeg Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberDatSanVeg() throws Exception {
		Long entity = null;

		try {
			entity = datSanVegDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DatSanVeg Count");
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
	@Transactional(readOnly = true)
	public List<DatSanVeg> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<DatSanVeg> list = new ArrayList<DatSanVeg>();
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
			list = datSanVegDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
