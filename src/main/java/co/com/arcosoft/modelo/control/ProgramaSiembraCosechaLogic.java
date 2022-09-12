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

import co.com.arcosoft.dataaccess.dao.IProgramaSiembraCosechaDAO;
import co.com.arcosoft.dataaccess.dao.IProgramaSiembraCosechaDetDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.ProgramaSiembraCosecha;
import co.com.arcosoft.modelo.ProgramaSiembraCosechaDet;
import co.com.arcosoft.modelo.dto.ProgramaSiembraCosechaDTO;
import co.com.arcosoft.modelo.dto.ProgramaSiembraCosechaDetDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("ProgramaSiembraCosechaLogic")
public class ProgramaSiembraCosechaLogic implements IProgramaSiembraCosechaLogic {
	private static final Logger log = LoggerFactory.getLogger(ProgramaSiembraCosechaLogic.class);

	/**
	 * DAO injected by Spring that manages ProgramaSiembraCosecha entities
	 *
	 */
	@Autowired
	private IProgramaSiembraCosechaDAO programaSiembraCosechaDAO;

	/**
	 * DAO injected by Spring that manages ProgramaSiembraCosechaDet entities
	 *
	 */
	@Autowired
	private IProgramaSiembraCosechaDetDAO programaSiembraCosechaDetDAO;

	/**
	 * Logic injected by Spring that manages Trabajador entities
	 *
	 */
	@Autowired
	ITrabajadorLogic logicTrabajador1;

	@Override
	@Transactional(readOnly = true)
	public List<ProgramaSiembraCosecha> getProgramaSiembraCosecha() throws Exception {
		log.debug("finding all ProgramaSiembraCosecha instances");

		List<ProgramaSiembraCosecha> list = new ArrayList<ProgramaSiembraCosecha>();

		try {
			list = programaSiembraCosechaDAO.findAll();
		} catch (Exception e) {
			log.error("finding all ProgramaSiembraCosecha failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "ProgramaSiembraCosecha");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveProgramaSiembraCosecha(ProgramaSiembraCosecha entity,
			List<ProgramaSiembraCosechaDetDTO> dataProgramaDet) throws Exception {
		log.debug("saving ProgramaSiembraCosecha instance");

		try {

			if ((entity.getAnio() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAnio(), 4, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("anio");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getConsecutivo() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getConsecutivo(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("consecutivo");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacion(), 3900) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacion");
			}

			if ((entity.getUsuarioDigitacion() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getUsuarioDigitacion(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("usuarioDigitacion");
			}

			programaSiembraCosechaDAO.save(entity);

			if (dataProgramaDet != null) {

				for (ProgramaSiembraCosechaDetDTO valorDto : dataProgramaDet) {

					if (valorDto.getProgramaSiembraCosechaDetId() == null) {

						ProgramaSiembraCosechaDet valor = new ProgramaSiembraCosechaDet();

						valor.setCosecha1(valorDto.getCosecha1());
						valor.setCosecha10(valorDto.getCosecha10());
						valor.setCosecha11(valorDto.getCosecha11());
						valor.setCosecha12(valorDto.getCosecha12());
						valor.setCosecha13(valorDto.getCosecha13());
						valor.setCosecha14(valorDto.getCosecha14());
						valor.setCosecha15(valorDto.getCosecha15());
						valor.setCosecha16(valorDto.getCosecha16());
						valor.setCosecha17(valorDto.getCosecha17());
						valor.setCosecha18(valorDto.getCosecha18());
						valor.setCosecha19(valorDto.getCosecha19());
						valor.setCosecha2(valorDto.getCosecha2());
						valor.setCosecha20(valorDto.getCosecha20());
						valor.setCosecha21(valorDto.getCosecha21());
						valor.setCosecha22(valorDto.getCosecha22());
						valor.setCosecha23(valorDto.getCosecha23());
						valor.setCosecha24(valorDto.getCosecha24());
						valor.setCosecha25(valorDto.getCosecha25());
						valor.setCosecha26(valorDto.getCosecha26());
						valor.setCosecha27(valorDto.getCosecha27());
						valor.setCosecha28(valorDto.getCosecha28());
						valor.setCosecha29(valorDto.getCosecha29());
						valor.setCosecha3(valorDto.getCosecha3());
						valor.setCosecha30(valorDto.getCosecha30());
						valor.setCosecha31(valorDto.getCosecha31());
						valor.setCosecha32(valorDto.getCosecha32());
						valor.setCosecha33(valorDto.getCosecha33());
						valor.setCosecha34(valorDto.getCosecha34());
						valor.setCosecha35(valorDto.getCosecha35());
						valor.setCosecha36(valorDto.getCosecha36());
						valor.setCosecha37(valorDto.getCosecha37());
						valor.setCosecha38(valorDto.getCosecha38());
						valor.setCosecha39(valorDto.getCosecha39());
						valor.setCosecha4(valorDto.getCosecha4());
						valor.setCosecha40(valorDto.getCosecha40());
						valor.setCosecha41(valorDto.getCosecha41());
						valor.setCosecha42(valorDto.getCosecha42());
						valor.setCosecha43(valorDto.getCosecha43());
						valor.setCosecha44(valorDto.getCosecha44());
						valor.setCosecha45(valorDto.getCosecha45());
						valor.setCosecha46(valorDto.getCosecha46());
						valor.setCosecha47(valorDto.getCosecha47());
						valor.setCosecha48(valorDto.getCosecha48());
						valor.setCosecha49(valorDto.getCosecha49());
						valor.setCosecha5(valorDto.getCosecha5());
						valor.setCosecha50(valorDto.getCosecha50());
						valor.setCosecha51(valorDto.getCosecha51());
						valor.setCosecha52(valorDto.getCosecha52());
						valor.setCosecha53(valorDto.getCosecha53());
						valor.setCosecha6(valorDto.getCosecha6());
						valor.setCosecha7(valorDto.getCosecha7());
						valor.setCosecha8(valorDto.getCosecha8());
						valor.setCosecha9(valorDto.getCosecha9());
						valor.setFechaCosecha(valorDto.getFechaCosecha());
						valor.setFechaSiembra(valorDto.getFechaSiembra());
						valor.setRotacionCultivo(valorDto.getRotacionCultivo());
						valor.setSiembra1(valorDto.getSiembra1());
						valor.setSiembra10(valorDto.getSiembra10());
						valor.setSiembra11(valorDto.getSiembra11());
						valor.setSiembra12(valorDto.getSiembra12());
						valor.setSiembra13(valorDto.getSiembra13());
						valor.setSiembra14(valorDto.getSiembra14());
						valor.setSiembra15(valorDto.getSiembra15());
						valor.setSiembra16(valorDto.getSiembra16());
						valor.setSiembra17(valorDto.getSiembra17());
						valor.setSiembra18(valorDto.getSiembra18());
						valor.setSiembra19(valorDto.getSiembra19());
						valor.setSiembra2(valorDto.getSiembra2());
						valor.setSiembra20(valorDto.getSiembra20());
						valor.setSiembra21(valorDto.getSiembra21());
						valor.setSiembra22(valorDto.getSiembra22());
						valor.setSiembra23(valorDto.getSiembra23());
						valor.setSiembra24(valorDto.getSiembra24());
						valor.setSiembra25(valorDto.getSiembra25());
						valor.setSiembra26(valorDto.getSiembra26());
						valor.setSiembra27(valorDto.getSiembra27());
						valor.setSiembra28(valorDto.getSiembra28());
						valor.setSiembra29(valorDto.getSiembra29());
						valor.setSiembra3(valorDto.getSiembra3());
						valor.setSiembra30(valorDto.getSiembra30());
						valor.setSiembra31(valorDto.getSiembra31());
						valor.setSiembra32(valorDto.getSiembra32());
						valor.setSiembra33(valorDto.getSiembra33());
						valor.setSiembra34(valorDto.getSiembra34());
						valor.setSiembra35(valorDto.getSiembra35());
						valor.setSiembra36(valorDto.getSiembra36());
						valor.setSiembra37(valorDto.getSiembra37());
						valor.setSiembra38(valorDto.getSiembra38());
						valor.setSiembra39(valorDto.getSiembra39());
						valor.setSiembra4(valorDto.getSiembra4());
						valor.setSiembra40(valorDto.getSiembra40());
						valor.setSiembra41(valorDto.getSiembra41());
						valor.setSiembra42(valorDto.getSiembra42());
						valor.setSiembra43(valorDto.getSiembra43());
						valor.setSiembra44(valorDto.getSiembra44());
						valor.setSiembra45(valorDto.getSiembra45());
						valor.setSiembra46(valorDto.getSiembra46());
						valor.setSiembra47(valorDto.getSiembra47());
						valor.setSiembra48(valorDto.getSiembra48());
						valor.setSiembra49(valorDto.getSiembra49());
						valor.setSiembra5(valorDto.getSiembra5());
						valor.setSiembra50(valorDto.getSiembra50());
						valor.setSiembra51(valorDto.getSiembra51());
						valor.setSiembra52(valorDto.getSiembra52());
						valor.setSiembra53(valorDto.getSiembra53());
						valor.setSiembra6(valorDto.getSiembra6());
						valor.setSiembra7(valorDto.getSiembra7());
						valor.setSiembra8(valorDto.getSiembra8());
						valor.setSiembra9(valorDto.getSiembra9());
						valor.setTotalCosecha(valorDto.getTotalCosecha());
						valor.setTotalSiembra(valorDto.getTotalSiembra());
						valor.setPersEmpr(valorDto.getPersEmprId_PersEmpr());
						valor.setVariedad(valorDto.getVariedId_Variedad());

						valor.setProgramaSiembraCosecha(entity);

						programaSiembraCosechaDetDAO.save(valor);
					}

				}
			}

			log.debug("save ProgramaSiembraCosecha successful");
		} catch (Exception e) {
			log.error("save ProgramaSiembraCosecha failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteProgramaSiembraCosecha(ProgramaSiembraCosecha entity) throws Exception {
		log.debug("deleting ProgramaSiembraCosecha instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("ProgramaSiembraCosecha");
		}

		if (entity.getProgramaSiembraCosechaId() == null) {
			throw new ZMessManager().new EmptyFieldException("programaSiembraCosechaId");
		}

		List<ProgramaSiembraCosechaDet> programaSiembraCosechaDets = null;

		try {
			programaSiembraCosechaDets = programaSiembraCosechaDetDAO.findByProperty(
					"programaSiembraCosecha.programaSiembraCosechaId", entity.getProgramaSiembraCosechaId());

			if (Utilities.validationsList(programaSiembraCosechaDets) == true) {
				throw new ZMessManager().new DeletingException("programaSiembraCosechaDets");
			}

			programaSiembraCosechaDAO.delete(entity);

			log.debug("delete ProgramaSiembraCosecha successful");
		} catch (Exception e) {
			log.error("delete ProgramaSiembraCosecha failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateProgramaSiembraCosecha(ProgramaSiembraCosecha entity,
			List<ProgramaSiembraCosechaDetDTO> dataProgramaDet) throws Exception {
		log.debug("updating ProgramaSiembraCosecha instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("ProgramaSiembraCosecha");
			}

			if ((entity.getAnio() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getAnio(), 4, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("anio");
			}

			if ((entity.getCompania() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("compania");
			}

			if ((entity.getConsecutivo() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getConsecutivo(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("consecutivo");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getObservacion(), 3900) == false)) {
				throw new ZMessManager().new NotValidFormatException("observacion");
			}

			if (entity.getProgramaSiembraCosechaId() == null) {
				throw new ZMessManager().new EmptyFieldException("programaSiembraCosechaId");
			}

			if ((entity.getProgramaSiembraCosechaId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getProgramaSiembraCosechaId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("programaSiembraCosechaId");
			}

			if ((entity.getUsuarioDigitacion() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getUsuarioDigitacion(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("usuarioDigitacion");
			}

			programaSiembraCosechaDAO.update(entity);

			for (ProgramaSiembraCosechaDetDTO valorDto : dataProgramaDet) {

				if (valorDto.getProgramaSiembraCosechaDetId() == null) { // crear
																			// el
																			// valor
					// nuevo

					ProgramaSiembraCosechaDet valor = new ProgramaSiembraCosechaDet();
					valor.setCosecha1(valorDto.getCosecha1());
					valor.setCosecha10(valorDto.getCosecha10());
					valor.setCosecha11(valorDto.getCosecha11());
					valor.setCosecha12(valorDto.getCosecha12());
					valor.setCosecha13(valorDto.getCosecha13());
					valor.setCosecha14(valorDto.getCosecha14());
					valor.setCosecha15(valorDto.getCosecha15());
					valor.setCosecha16(valorDto.getCosecha16());
					valor.setCosecha17(valorDto.getCosecha17());
					valor.setCosecha18(valorDto.getCosecha18());
					valor.setCosecha19(valorDto.getCosecha19());
					valor.setCosecha2(valorDto.getCosecha2());
					valor.setCosecha20(valorDto.getCosecha20());
					valor.setCosecha21(valorDto.getCosecha21());
					valor.setCosecha22(valorDto.getCosecha22());
					valor.setCosecha23(valorDto.getCosecha23());
					valor.setCosecha24(valorDto.getCosecha24());
					valor.setCosecha25(valorDto.getCosecha25());
					valor.setCosecha26(valorDto.getCosecha26());
					valor.setCosecha27(valorDto.getCosecha27());
					valor.setCosecha28(valorDto.getCosecha28());
					valor.setCosecha29(valorDto.getCosecha29());
					valor.setCosecha3(valorDto.getCosecha3());
					valor.setCosecha30(valorDto.getCosecha30());
					valor.setCosecha31(valorDto.getCosecha31());
					valor.setCosecha32(valorDto.getCosecha32());
					valor.setCosecha33(valorDto.getCosecha33());
					valor.setCosecha34(valorDto.getCosecha34());
					valor.setCosecha35(valorDto.getCosecha35());
					valor.setCosecha36(valorDto.getCosecha36());
					valor.setCosecha37(valorDto.getCosecha37());
					valor.setCosecha38(valorDto.getCosecha38());
					valor.setCosecha39(valorDto.getCosecha39());
					valor.setCosecha4(valorDto.getCosecha4());
					valor.setCosecha40(valorDto.getCosecha40());
					valor.setCosecha41(valorDto.getCosecha41());
					valor.setCosecha42(valorDto.getCosecha42());
					valor.setCosecha43(valorDto.getCosecha43());
					valor.setCosecha44(valorDto.getCosecha44());
					valor.setCosecha45(valorDto.getCosecha45());
					valor.setCosecha46(valorDto.getCosecha46());
					valor.setCosecha47(valorDto.getCosecha47());
					valor.setCosecha48(valorDto.getCosecha48());
					valor.setCosecha49(valorDto.getCosecha49());
					valor.setCosecha5(valorDto.getCosecha5());
					valor.setCosecha50(valorDto.getCosecha50());
					valor.setCosecha51(valorDto.getCosecha51());
					valor.setCosecha52(valorDto.getCosecha52());
					valor.setCosecha53(valorDto.getCosecha53());
					valor.setCosecha6(valorDto.getCosecha6());
					valor.setCosecha7(valorDto.getCosecha7());
					valor.setCosecha8(valorDto.getCosecha8());
					valor.setCosecha9(valorDto.getCosecha9());
					valor.setFechaCosecha(valorDto.getFechaCosecha());
					valor.setFechaSiembra(valorDto.getFechaSiembra());
					valor.setRotacionCultivo(valorDto.getRotacionCultivo());
					valor.setSiembra1(valorDto.getSiembra1());
					valor.setSiembra10(valorDto.getSiembra10());
					valor.setSiembra11(valorDto.getSiembra11());
					valor.setSiembra12(valorDto.getSiembra12());
					valor.setSiembra13(valorDto.getSiembra13());
					valor.setSiembra14(valorDto.getSiembra14());
					valor.setSiembra15(valorDto.getSiembra15());
					valor.setSiembra16(valorDto.getSiembra16());
					valor.setSiembra17(valorDto.getSiembra17());
					valor.setSiembra18(valorDto.getSiembra18());
					valor.setSiembra19(valorDto.getSiembra19());
					valor.setSiembra2(valorDto.getSiembra2());
					valor.setSiembra20(valorDto.getSiembra20());
					valor.setSiembra21(valorDto.getSiembra21());
					valor.setSiembra22(valorDto.getSiembra22());
					valor.setSiembra23(valorDto.getSiembra23());
					valor.setSiembra24(valorDto.getSiembra24());
					valor.setSiembra25(valorDto.getSiembra25());
					valor.setSiembra26(valorDto.getSiembra26());
					valor.setSiembra27(valorDto.getSiembra27());
					valor.setSiembra28(valorDto.getSiembra28());
					valor.setSiembra29(valorDto.getSiembra29());
					valor.setSiembra3(valorDto.getSiembra3());
					valor.setSiembra30(valorDto.getSiembra30());
					valor.setSiembra31(valorDto.getSiembra31());
					valor.setSiembra32(valorDto.getSiembra32());
					valor.setSiembra33(valorDto.getSiembra33());
					valor.setSiembra34(valorDto.getSiembra34());
					valor.setSiembra35(valorDto.getSiembra35());
					valor.setSiembra36(valorDto.getSiembra36());
					valor.setSiembra37(valorDto.getSiembra37());
					valor.setSiembra38(valorDto.getSiembra38());
					valor.setSiembra39(valorDto.getSiembra39());
					valor.setSiembra4(valorDto.getSiembra4());
					valor.setSiembra40(valorDto.getSiembra40());
					valor.setSiembra41(valorDto.getSiembra41());
					valor.setSiembra42(valorDto.getSiembra42());
					valor.setSiembra43(valorDto.getSiembra43());
					valor.setSiembra44(valorDto.getSiembra44());
					valor.setSiembra45(valorDto.getSiembra45());
					valor.setSiembra46(valorDto.getSiembra46());
					valor.setSiembra47(valorDto.getSiembra47());
					valor.setSiembra48(valorDto.getSiembra48());
					valor.setSiembra49(valorDto.getSiembra49());
					valor.setSiembra5(valorDto.getSiembra5());
					valor.setSiembra50(valorDto.getSiembra50());
					valor.setSiembra51(valorDto.getSiembra51());
					valor.setSiembra52(valorDto.getSiembra52());
					valor.setSiembra53(valorDto.getSiembra53());
					valor.setSiembra6(valorDto.getSiembra6());
					valor.setSiembra7(valorDto.getSiembra7());
					valor.setSiembra8(valorDto.getSiembra8());
					valor.setSiembra9(valorDto.getSiembra9());
					valor.setTotalCosecha(valorDto.getTotalCosecha());
					valor.setTotalSiembra(valorDto.getTotalSiembra());
					valor.setPersEmpr(valorDto.getPersEmprId_PersEmpr());
					valor.setVariedad(valorDto.getVariedId_Variedad());

					valor.setProgramaSiembraCosecha(entity);

					programaSiembraCosechaDetDAO.save(valor);

				} else {
					ProgramaSiembraCosechaDet valor = programaSiembraCosechaDetDAO
							.findById(valorDto.getProgramaSiembraCosechaDetId());

					valor.setCosecha1(valorDto.getCosecha1());
					valor.setCosecha10(valorDto.getCosecha10());
					valor.setCosecha11(valorDto.getCosecha11());
					valor.setCosecha12(valorDto.getCosecha12());
					valor.setCosecha13(valorDto.getCosecha13());
					valor.setCosecha14(valorDto.getCosecha14());
					valor.setCosecha15(valorDto.getCosecha15());
					valor.setCosecha16(valorDto.getCosecha16());
					valor.setCosecha17(valorDto.getCosecha17());
					valor.setCosecha18(valorDto.getCosecha18());
					valor.setCosecha19(valorDto.getCosecha19());
					valor.setCosecha2(valorDto.getCosecha2());
					valor.setCosecha20(valorDto.getCosecha20());
					valor.setCosecha21(valorDto.getCosecha21());
					valor.setCosecha22(valorDto.getCosecha22());
					valor.setCosecha23(valorDto.getCosecha23());
					valor.setCosecha24(valorDto.getCosecha24());
					valor.setCosecha25(valorDto.getCosecha25());
					valor.setCosecha26(valorDto.getCosecha26());
					valor.setCosecha27(valorDto.getCosecha27());
					valor.setCosecha28(valorDto.getCosecha28());
					valor.setCosecha29(valorDto.getCosecha29());
					valor.setCosecha3(valorDto.getCosecha3());
					valor.setCosecha30(valorDto.getCosecha30());
					valor.setCosecha31(valorDto.getCosecha31());
					valor.setCosecha32(valorDto.getCosecha32());
					valor.setCosecha33(valorDto.getCosecha33());
					valor.setCosecha34(valorDto.getCosecha34());
					valor.setCosecha35(valorDto.getCosecha35());
					valor.setCosecha36(valorDto.getCosecha36());
					valor.setCosecha37(valorDto.getCosecha37());
					valor.setCosecha38(valorDto.getCosecha38());
					valor.setCosecha39(valorDto.getCosecha39());
					valor.setCosecha4(valorDto.getCosecha4());
					valor.setCosecha40(valorDto.getCosecha40());
					valor.setCosecha41(valorDto.getCosecha41());
					valor.setCosecha42(valorDto.getCosecha42());
					valor.setCosecha43(valorDto.getCosecha43());
					valor.setCosecha44(valorDto.getCosecha44());
					valor.setCosecha45(valorDto.getCosecha45());
					valor.setCosecha46(valorDto.getCosecha46());
					valor.setCosecha47(valorDto.getCosecha47());
					valor.setCosecha48(valorDto.getCosecha48());
					valor.setCosecha49(valorDto.getCosecha49());
					valor.setCosecha5(valorDto.getCosecha5());
					valor.setCosecha50(valorDto.getCosecha50());
					valor.setCosecha51(valorDto.getCosecha51());
					valor.setCosecha52(valorDto.getCosecha52());
					valor.setCosecha53(valorDto.getCosecha53());
					valor.setCosecha6(valorDto.getCosecha6());
					valor.setCosecha7(valorDto.getCosecha7());
					valor.setCosecha8(valorDto.getCosecha8());
					valor.setCosecha9(valorDto.getCosecha9());
					valor.setFechaCosecha(valorDto.getFechaCosecha());
					valor.setFechaSiembra(valorDto.getFechaSiembra());
					valor.setRotacionCultivo(valorDto.getRotacionCultivo());
					valor.setSiembra1(valorDto.getSiembra1());
					valor.setSiembra10(valorDto.getSiembra10());
					valor.setSiembra11(valorDto.getSiembra11());
					valor.setSiembra12(valorDto.getSiembra12());
					valor.setSiembra13(valorDto.getSiembra13());
					valor.setSiembra14(valorDto.getSiembra14());
					valor.setSiembra15(valorDto.getSiembra15());
					valor.setSiembra16(valorDto.getSiembra16());
					valor.setSiembra17(valorDto.getSiembra17());
					valor.setSiembra18(valorDto.getSiembra18());
					valor.setSiembra19(valorDto.getSiembra19());
					valor.setSiembra2(valorDto.getSiembra2());
					valor.setSiembra20(valorDto.getSiembra20());
					valor.setSiembra21(valorDto.getSiembra21());
					valor.setSiembra22(valorDto.getSiembra22());
					valor.setSiembra23(valorDto.getSiembra23());
					valor.setSiembra24(valorDto.getSiembra24());
					valor.setSiembra25(valorDto.getSiembra25());
					valor.setSiembra26(valorDto.getSiembra26());
					valor.setSiembra27(valorDto.getSiembra27());
					valor.setSiembra28(valorDto.getSiembra28());
					valor.setSiembra29(valorDto.getSiembra29());
					valor.setSiembra3(valorDto.getSiembra3());
					valor.setSiembra30(valorDto.getSiembra30());
					valor.setSiembra31(valorDto.getSiembra31());
					valor.setSiembra32(valorDto.getSiembra32());
					valor.setSiembra33(valorDto.getSiembra33());
					valor.setSiembra34(valorDto.getSiembra34());
					valor.setSiembra35(valorDto.getSiembra35());
					valor.setSiembra36(valorDto.getSiembra36());
					valor.setSiembra37(valorDto.getSiembra37());
					valor.setSiembra38(valorDto.getSiembra38());
					valor.setSiembra39(valorDto.getSiembra39());
					valor.setSiembra4(valorDto.getSiembra4());
					valor.setSiembra40(valorDto.getSiembra40());
					valor.setSiembra41(valorDto.getSiembra41());
					valor.setSiembra42(valorDto.getSiembra42());
					valor.setSiembra43(valorDto.getSiembra43());
					valor.setSiembra44(valorDto.getSiembra44());
					valor.setSiembra45(valorDto.getSiembra45());
					valor.setSiembra46(valorDto.getSiembra46());
					valor.setSiembra47(valorDto.getSiembra47());
					valor.setSiembra48(valorDto.getSiembra48());
					valor.setSiembra49(valorDto.getSiembra49());
					valor.setSiembra5(valorDto.getSiembra5());
					valor.setSiembra50(valorDto.getSiembra50());
					valor.setSiembra51(valorDto.getSiembra51());
					valor.setSiembra52(valorDto.getSiembra52());
					valor.setSiembra53(valorDto.getSiembra53());
					valor.setSiembra6(valorDto.getSiembra6());
					valor.setSiembra7(valorDto.getSiembra7());
					valor.setSiembra8(valorDto.getSiembra8());
					valor.setSiembra9(valorDto.getSiembra9());
					valor.setTotalCosecha(valorDto.getTotalCosecha());
					valor.setTotalSiembra(valorDto.getTotalSiembra());
					valor.setPersEmpr(valorDto.getPersEmprId_PersEmpr());
					valor.setVariedad(valorDto.getVariedId_Variedad());

					programaSiembraCosechaDetDAO.update(valor);
				}

			}

			log.debug("update ProgramaSiembraCosecha successful");
		} catch (Exception e) {
			log.error("update ProgramaSiembraCosecha failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProgramaSiembraCosechaDTO> getDataProgramaSiembraCosecha() throws Exception {
		try {
			List<ProgramaSiembraCosecha> programaSiembraCosecha = programaSiembraCosechaDAO.findAll();

			List<ProgramaSiembraCosechaDTO> programaSiembraCosechaDTO = new ArrayList<ProgramaSiembraCosechaDTO>();

			for (ProgramaSiembraCosecha programaSiembraCosechaTmp : programaSiembraCosecha) {
				ProgramaSiembraCosechaDTO programaSiembraCosechaDTO2 = new ProgramaSiembraCosechaDTO();

				programaSiembraCosechaDTO2
						.setProgramaSiembraCosechaId(programaSiembraCosechaTmp.getProgramaSiembraCosechaId());
				programaSiembraCosechaDTO2.setAnio(
						(programaSiembraCosechaTmp.getAnio() != null) ? programaSiembraCosechaTmp.getAnio() : null);
				programaSiembraCosechaDTO2.setCompania((programaSiembraCosechaTmp.getCompania() != null)
						? programaSiembraCosechaTmp.getCompania() : null);
				programaSiembraCosechaDTO2.setConsecutivo((programaSiembraCosechaTmp.getConsecutivo() != null)
						? programaSiembraCosechaTmp.getConsecutivo() : null);
				programaSiembraCosechaDTO2.setEstado(
						(programaSiembraCosechaTmp.getEstado() != null) ? programaSiembraCosechaTmp.getEstado() : null);
				programaSiembraCosechaDTO2.setFechaCreacion(programaSiembraCosechaTmp.getFechaCreacion());
				programaSiembraCosechaDTO2.setFechaModificacion(programaSiembraCosechaTmp.getFechaModificacion());
				programaSiembraCosechaDTO2.setObservacion((programaSiembraCosechaTmp.getObservacion() != null)
						? programaSiembraCosechaTmp.getObservacion() : null);
				programaSiembraCosechaDTO2
						.setUsuarioDigitacion((programaSiembraCosechaTmp.getUsuarioDigitacion() != null)
								? programaSiembraCosechaTmp.getUsuarioDigitacion() : null);

				if (programaSiembraCosechaTmp.getTrabajador() != null) {
					programaSiembraCosechaDTO2
							.setTrabId_Trabajador(programaSiembraCosechaTmp.getTrabajador().getTrabId());
				} else {
					programaSiembraCosechaDTO2.setTrabId_Trabajador(null);
				}

				if (programaSiembraCosechaTmp.getTrabajador() != null) {
					programaSiembraCosechaDTO2.setTecnicoNombre(programaSiembraCosechaTmp.getTrabajador().getNombre());
				} else {
					programaSiembraCosechaDTO2.setTecnicoNombre(null);
				}
				String estadoEstrue = "false";
				if (programaSiembraCosechaTmp.getEstado().equals("I")) {
					estadoEstrue = "true";
					programaSiembraCosechaDTO2.setEstadoTrue(estadoEstrue);
					programaSiembraCosechaDTO2.setEstadoTrue2(estadoEstrue);
				}

				programaSiembraCosechaDTO.add(programaSiembraCosechaDTO2);
			}

			return programaSiembraCosechaDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public ProgramaSiembraCosecha getProgramaSiembraCosecha(Long programaSiembraCosechaId) throws Exception {
		log.debug("getting ProgramaSiembraCosecha instance");

		ProgramaSiembraCosecha entity = null;

		try {
			entity = programaSiembraCosechaDAO.findById(programaSiembraCosechaId);
		} catch (Exception e) {
			log.error("get ProgramaSiembraCosecha failed", e);
			throw new ZMessManager().new FindingException("ProgramaSiembraCosecha");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProgramaSiembraCosecha> findPageProgramaSiembraCosecha(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception {
		List<ProgramaSiembraCosecha> entity = null;

		try {
			entity = programaSiembraCosechaDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("ProgramaSiembraCosecha Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberProgramaSiembraCosecha() throws Exception {
		Long entity = null;

		try {
			entity = programaSiembraCosechaDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("ProgramaSiembraCosecha Count");
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
	 * @param variablesBetweenDates(en
	 *            este caso solo para mysql) [0] = String variable = (String)
	 *            varibles[k]; el nombre de la variable que hace referencia a
	 *            una fecha
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
	public List<ProgramaSiembraCosecha> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<ProgramaSiembraCosecha> list = new ArrayList<ProgramaSiembraCosecha>();
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
			list = programaSiembraCosechaDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

}
