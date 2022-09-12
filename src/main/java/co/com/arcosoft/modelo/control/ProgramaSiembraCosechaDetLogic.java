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

import co.com.arcosoft.dataaccess.dao.IProgramaSiembraCosechaDetDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.ProgramaSiembraCosechaDet;
import co.com.arcosoft.modelo.dto.ProgramaSiembraCosechaDetDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("ProgramaSiembraCosechaDetLogic")
public class ProgramaSiembraCosechaDetLogic implements IProgramaSiembraCosechaDetLogic {
	private static final Logger log = LoggerFactory.getLogger(ProgramaSiembraCosechaDetLogic.class);

	/**
	 * DAO injected by Spring that manages ProgramaSiembraCosechaDet entities
	 *
	 */
	@Autowired
	private IProgramaSiembraCosechaDetDAO programaSiembraCosechaDetDAO;

	/**
	 * Logic injected by Spring that manages PersEmpr entities
	 *
	 */
	@Autowired
	IPersEmprLogic logicPersEmpr1;

	/**
	 * Logic injected by Spring that manages ProgramaSiembraCosecha entities
	 *
	 */
	@Autowired
	IProgramaSiembraCosechaLogic logicProgramaSiembraCosecha2;

	/**
	 * Logic injected by Spring that manages Variedad entities
	 *
	 */
	@Autowired
	IVariedadLogic logicVariedad3;

	@Override
	@Transactional(readOnly = true)
	public List<ProgramaSiembraCosechaDet> getProgramaSiembraCosechaDet() throws Exception {
		log.debug("finding all ProgramaSiembraCosechaDet instances");

		List<ProgramaSiembraCosechaDet> list = new ArrayList<ProgramaSiembraCosechaDet>();

		try {
			list = programaSiembraCosechaDetDAO.findAll();
		} catch (Exception e) {
			log.error("finding all ProgramaSiembraCosechaDet failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "ProgramaSiembraCosechaDet");
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveProgramaSiembraCosechaDet(ProgramaSiembraCosechaDet entity) throws Exception {
		log.debug("saving ProgramaSiembraCosechaDet instance");

		try {

			if (entity.getProgramaSiembraCosecha() == null) {
				throw new ZMessManager().new ForeignException("programaSiembraCosecha");
			}
			if ((entity.getCosecha1() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha1(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha1");
			}

			if ((entity.getCosecha10() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha10(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha10");
			}

			if ((entity.getCosecha11() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha11(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha11");
			}

			if ((entity.getCosecha12() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha12(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha12");
			}

			if ((entity.getCosecha13() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha13(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha13");
			}

			if ((entity.getCosecha14() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha14(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha14");
			}

			if ((entity.getCosecha15() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha15(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha15");
			}

			if ((entity.getCosecha16() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha16(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha16");
			}

			if ((entity.getCosecha17() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha17(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha17");
			}

			if ((entity.getCosecha18() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha18(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha18");
			}

			if ((entity.getCosecha19() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha19(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha19");
			}

			if ((entity.getCosecha2() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha2(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha2");
			}

			if ((entity.getCosecha20() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha20(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha20");
			}

			if ((entity.getCosecha21() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha21(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha21");
			}

			if ((entity.getCosecha22() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha22(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha22");
			}

			if ((entity.getCosecha23() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha23(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha23");
			}

			if ((entity.getCosecha24() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha24(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha24");
			}

			if ((entity.getCosecha25() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha25(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha25");
			}

			if ((entity.getCosecha26() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha26(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha26");
			}

			if ((entity.getCosecha27() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha27(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha27");
			}

			if ((entity.getCosecha28() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha28(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha28");
			}

			if ((entity.getCosecha29() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha29(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha29");
			}

			if ((entity.getCosecha3() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha3(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha3");
			}

			if ((entity.getCosecha30() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha30(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha30");
			}

			if ((entity.getCosecha31() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha31(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha31");
			}

			if ((entity.getCosecha32() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha32(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha32");
			}

			if ((entity.getCosecha33() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha33(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha33");
			}

			if ((entity.getCosecha34() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha34(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha34");
			}

			if ((entity.getCosecha35() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha35(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha35");
			}

			if ((entity.getCosecha36() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha36(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha36");
			}

			if ((entity.getCosecha37() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha37(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha37");
			}

			if ((entity.getCosecha38() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha38(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha38");
			}

			if ((entity.getCosecha39() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha39(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha39");
			}

			if ((entity.getCosecha4() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha4(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha4");
			}

			if ((entity.getCosecha40() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha40(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha40");
			}

			if ((entity.getCosecha41() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha41(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha41");
			}

			if ((entity.getCosecha42() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha42(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha42");
			}

			if ((entity.getCosecha43() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha43(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha43");
			}

			if ((entity.getCosecha44() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha44(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha44");
			}

			if ((entity.getCosecha45() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha45(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha45");
			}

			if ((entity.getCosecha46() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha46(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha46");
			}

			if ((entity.getCosecha47() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha47(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha47");
			}

			if ((entity.getCosecha48() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha48(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha48");
			}

			if ((entity.getCosecha49() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha49(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha49");
			}

			if ((entity.getCosecha5() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha5(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha5");
			}

			if ((entity.getCosecha50() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha50(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha50");
			}

			if ((entity.getCosecha51() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha51(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha51");
			}

			if ((entity.getCosecha52() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha52(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha52");
			}

			if ((entity.getCosecha53() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha53(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha53");
			}

			if ((entity.getCosecha6() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha6(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha6");
			}

			if ((entity.getCosecha7() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha7(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha7");
			}

			if ((entity.getCosecha8() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha8(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha8");
			}

			if ((entity.getCosecha9() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha9(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha9");
			}

			if (entity.getProgramaSiembraCosechaDetId() == null) {
				throw new ZMessManager().new EmptyFieldException("programaSiembraCosechaDetId");
			}

			if ((entity.getProgramaSiembraCosechaDetId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getProgramaSiembraCosechaDetId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("programaSiembraCosechaDetId");
			}

			if ((entity.getRotacionCultivo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getRotacionCultivo(), 10) == false)) {
				throw new ZMessManager().new NotValidFormatException("rotacionCultivo");
			}

			if ((entity.getSiembra1() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra1(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra1");
			}

			if ((entity.getSiembra10() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra10(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra10");
			}

			if ((entity.getSiembra11() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra11(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra11");
			}

			if ((entity.getSiembra12() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra12(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra12");
			}

			if ((entity.getSiembra13() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra13(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra13");
			}

			if ((entity.getSiembra14() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra14(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra14");
			}

			if ((entity.getSiembra15() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra15(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra15");
			}

			if ((entity.getSiembra16() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra16(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra16");
			}

			if ((entity.getSiembra17() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra17(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra17");
			}

			if ((entity.getSiembra18() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra18(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra18");
			}

			if ((entity.getSiembra19() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra19(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra19");
			}

			if ((entity.getSiembra2() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra2(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra2");
			}

			if ((entity.getSiembra20() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra20(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra20");
			}

			if ((entity.getSiembra21() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra21(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra21");
			}

			if ((entity.getSiembra22() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra22(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra22");
			}

			if ((entity.getSiembra23() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra23(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra23");
			}

			if ((entity.getSiembra24() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra24(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra24");
			}

			if ((entity.getSiembra25() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra25(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra25");
			}

			if ((entity.getSiembra26() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra26(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra26");
			}

			if ((entity.getSiembra27() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra27(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra27");
			}

			if ((entity.getSiembra28() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra28(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra28");
			}

			if ((entity.getSiembra29() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra29(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra29");
			}

			if ((entity.getSiembra3() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra3(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra3");
			}

			if ((entity.getSiembra30() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra30(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra30");
			}

			if ((entity.getSiembra31() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra31(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra31");
			}

			if ((entity.getSiembra32() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra32(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra32");
			}

			if ((entity.getSiembra33() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra33(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra33");
			}

			if ((entity.getSiembra34() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra34(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra34");
			}

			if ((entity.getSiembra35() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra35(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra35");
			}

			if ((entity.getSiembra36() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra36(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra36");
			}

			if ((entity.getSiembra37() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra37(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra37");
			}

			if ((entity.getSiembra38() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra38(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra38");
			}

			if ((entity.getSiembra39() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra39(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra39");
			}

			if ((entity.getSiembra4() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra4(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra4");
			}

			if ((entity.getSiembra40() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra40(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra40");
			}

			if ((entity.getSiembra41() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra41(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra41");
			}

			if ((entity.getSiembra42() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra42(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra42");
			}

			if ((entity.getSiembra43() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra43(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra43");
			}

			if ((entity.getSiembra44() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra44(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra44");
			}

			if ((entity.getSiembra45() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra45(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra45");
			}

			if ((entity.getSiembra46() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra46(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra46");
			}

			if ((entity.getSiembra47() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra47(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra47");
			}

			if ((entity.getSiembra48() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra48(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra48");
			}

			if ((entity.getSiembra49() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra49(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra49");
			}

			if ((entity.getSiembra5() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra5(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra5");
			}

			if ((entity.getSiembra50() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra50(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra50");
			}

			if ((entity.getSiembra51() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra51(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra51");
			}

			if ((entity.getSiembra52() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra52(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra52");
			}

			if ((entity.getSiembra53() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra53(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra53");
			}

			if ((entity.getSiembra6() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra6(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra6");
			}

			if ((entity.getSiembra7() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra7(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra7");
			}

			if ((entity.getSiembra8() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra8(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra8");
			}

			if ((entity.getSiembra9() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra9(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra9");
			}

			if ((entity.getTotalCosecha() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTotalCosecha(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("totalCosecha");
			}

			if ((entity.getTotalSiembra() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTotalSiembra(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("totalSiembra");
			}

			programaSiembraCosechaDetDAO.save(entity);

			log.debug("save ProgramaSiembraCosechaDet successful");
		} catch (Exception e) {
			log.error("save ProgramaSiembraCosechaDet failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteProgramaSiembraCosechaDet(ProgramaSiembraCosechaDet entity) throws Exception {
		log.debug("deleting ProgramaSiembraCosechaDet instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("ProgramaSiembraCosechaDet");
		}

		if (entity.getProgramaSiembraCosechaDetId() == null) {
			throw new ZMessManager().new EmptyFieldException("programaSiembraCosechaDetId");
		}

		try {
			programaSiembraCosechaDetDAO.delete(entity);

			log.debug("delete ProgramaSiembraCosechaDet successful");
		} catch (Exception e) {
			log.error("delete ProgramaSiembraCosechaDet failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateProgramaSiembraCosechaDet(ProgramaSiembraCosechaDet entity) throws Exception {
		log.debug("updating ProgramaSiembraCosechaDet instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("ProgramaSiembraCosechaDet");
			}

			if (entity.getPersEmpr() == null) {
				throw new ZMessManager().new ForeignException("persEmpr");
			}

			if (entity.getProgramaSiembraCosecha() == null) {
				throw new ZMessManager().new ForeignException("programaSiembraCosecha");
			}

			if ((entity.getCosecha1() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha1(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha1");
			}

			if ((entity.getCosecha10() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha10(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha10");
			}

			if ((entity.getCosecha11() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha11(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha11");
			}

			if ((entity.getCosecha12() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha12(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha12");
			}

			if ((entity.getCosecha13() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha13(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha13");
			}

			if ((entity.getCosecha14() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha14(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha14");
			}

			if ((entity.getCosecha15() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha15(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha15");
			}

			if ((entity.getCosecha16() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha16(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha16");
			}

			if ((entity.getCosecha17() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha17(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha17");
			}

			if ((entity.getCosecha18() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha18(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha18");
			}

			if ((entity.getCosecha19() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha19(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha19");
			}

			if ((entity.getCosecha2() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha2(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha2");
			}

			if ((entity.getCosecha20() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha20(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha20");
			}

			if ((entity.getCosecha21() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha21(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha21");
			}

			if ((entity.getCosecha22() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha22(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha22");
			}

			if ((entity.getCosecha23() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha23(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha23");
			}

			if ((entity.getCosecha24() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha24(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha24");
			}

			if ((entity.getCosecha25() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha25(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha25");
			}

			if ((entity.getCosecha26() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha26(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha26");
			}

			if ((entity.getCosecha27() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha27(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha27");
			}

			if ((entity.getCosecha28() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha28(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha28");
			}

			if ((entity.getCosecha29() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha29(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha29");
			}

			if ((entity.getCosecha3() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha3(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha3");
			}

			if ((entity.getCosecha30() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha30(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha30");
			}

			if ((entity.getCosecha31() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha31(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha31");
			}

			if ((entity.getCosecha32() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha32(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha32");
			}

			if ((entity.getCosecha33() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha33(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha33");
			}

			if ((entity.getCosecha34() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha34(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha34");
			}

			if ((entity.getCosecha35() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha35(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha35");
			}

			if ((entity.getCosecha36() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha36(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha36");
			}

			if ((entity.getCosecha37() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha37(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha37");
			}

			if ((entity.getCosecha38() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha38(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha38");
			}

			if ((entity.getCosecha39() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha39(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha39");
			}

			if ((entity.getCosecha4() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha4(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha4");
			}

			if ((entity.getCosecha40() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha40(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha40");
			}

			if ((entity.getCosecha41() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha41(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha41");
			}

			if ((entity.getCosecha42() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha42(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha42");
			}

			if ((entity.getCosecha43() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha43(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha43");
			}

			if ((entity.getCosecha44() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha44(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha44");
			}

			if ((entity.getCosecha45() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha45(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha45");
			}

			if ((entity.getCosecha46() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha46(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha46");
			}

			if ((entity.getCosecha47() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha47(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha47");
			}

			if ((entity.getCosecha48() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha48(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha48");
			}

			if ((entity.getCosecha49() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha49(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha49");
			}

			if ((entity.getCosecha5() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha5(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha5");
			}

			if ((entity.getCosecha50() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha50(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha50");
			}

			if ((entity.getCosecha51() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha51(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha51");
			}

			if ((entity.getCosecha52() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha52(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha52");
			}

			if ((entity.getCosecha53() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha53(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha53");
			}

			if ((entity.getCosecha6() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha6(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha6");
			}

			if ((entity.getCosecha7() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha7(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha7");
			}

			if ((entity.getCosecha8() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha8(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha8");
			}

			if ((entity.getCosecha9() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCosecha9(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("cosecha9");
			}

			if (entity.getProgramaSiembraCosechaDetId() == null) {
				throw new ZMessManager().new EmptyFieldException("programaSiembraCosechaDetId");
			}

			if ((entity.getProgramaSiembraCosechaDetId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getProgramaSiembraCosechaDetId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("programaSiembraCosechaDetId");
			}

			if ((entity.getRotacionCultivo() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getRotacionCultivo(), 10) == false)) {
				throw new ZMessManager().new NotValidFormatException("rotacionCultivo");
			}

			if ((entity.getSiembra1() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra1(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra1");
			}

			if ((entity.getSiembra10() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra10(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra10");
			}

			if ((entity.getSiembra11() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra11(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra11");
			}

			if ((entity.getSiembra12() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra12(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra12");
			}

			if ((entity.getSiembra13() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra13(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra13");
			}

			if ((entity.getSiembra14() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra14(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra14");
			}

			if ((entity.getSiembra15() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra15(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra15");
			}

			if ((entity.getSiembra16() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra16(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra16");
			}

			if ((entity.getSiembra17() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra17(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra17");
			}

			if ((entity.getSiembra18() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra18(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra18");
			}

			if ((entity.getSiembra19() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra19(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra19");
			}

			if ((entity.getSiembra2() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra2(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra2");
			}

			if ((entity.getSiembra20() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra20(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra20");
			}

			if ((entity.getSiembra21() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra21(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra21");
			}

			if ((entity.getSiembra22() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra22(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra22");
			}

			if ((entity.getSiembra23() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra23(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra23");
			}

			if ((entity.getSiembra24() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra24(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra24");
			}

			if ((entity.getSiembra25() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra25(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra25");
			}

			if ((entity.getSiembra26() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra26(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra26");
			}

			if ((entity.getSiembra27() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra27(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra27");
			}

			if ((entity.getSiembra28() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra28(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra28");
			}

			if ((entity.getSiembra29() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra29(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra29");
			}

			if ((entity.getSiembra3() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra3(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra3");
			}

			if ((entity.getSiembra30() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra30(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra30");
			}

			if ((entity.getSiembra31() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra31(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra31");
			}

			if ((entity.getSiembra32() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra32(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra32");
			}

			if ((entity.getSiembra33() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra33(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra33");
			}

			if ((entity.getSiembra34() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra34(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra34");
			}

			if ((entity.getSiembra35() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra35(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra35");
			}

			if ((entity.getSiembra36() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra36(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra36");
			}

			if ((entity.getSiembra37() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra37(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra37");
			}

			if ((entity.getSiembra38() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra38(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra38");
			}

			if ((entity.getSiembra39() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra39(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra39");
			}

			if ((entity.getSiembra4() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra4(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra4");
			}

			if ((entity.getSiembra40() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra40(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra40");
			}

			if ((entity.getSiembra41() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra41(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra41");
			}

			if ((entity.getSiembra42() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra42(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra42");
			}

			if ((entity.getSiembra43() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra43(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra43");
			}

			if ((entity.getSiembra44() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra44(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra44");
			}

			if ((entity.getSiembra45() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra45(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra45");
			}

			if ((entity.getSiembra46() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra46(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra46");
			}

			if ((entity.getSiembra47() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra47(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra47");
			}

			if ((entity.getSiembra48() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra48(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra48");
			}

			if ((entity.getSiembra49() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra49(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra49");
			}

			if ((entity.getSiembra5() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra5(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra5");
			}

			if ((entity.getSiembra50() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra50(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra50");
			}

			if ((entity.getSiembra51() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra51(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra51");
			}

			if ((entity.getSiembra52() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra52(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra52");
			}

			if ((entity.getSiembra53() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra53(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra53");
			}

			if ((entity.getSiembra6() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra6(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra6");
			}

			if ((entity.getSiembra7() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra7(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra7");
			}

			if ((entity.getSiembra8() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra8(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra8");
			}

			if ((entity.getSiembra9() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getSiembra9(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("siembra9");
			}

			if ((entity.getTotalCosecha() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTotalCosecha(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("totalCosecha");
			}

			if ((entity.getTotalSiembra() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getTotalSiembra(), 8, 4) == false)) {
				throw new ZMessManager().new NotValidFormatException("totalSiembra");
			}

			if (entity.getProgramaSiembraCosecha().getProgramaSiembraCosechaId() == null) {
				throw new ZMessManager().new EmptyFieldException("programaSiembraCosechaId_ProgramaSiembraCosecha");
			}

			if ((entity.getProgramaSiembraCosecha().getProgramaSiembraCosechaId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(
							"" + entity.getProgramaSiembraCosecha().getProgramaSiembraCosechaId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("programaSiembraCosechaId_ProgramaSiembraCosecha");
			}

			programaSiembraCosechaDetDAO.update(entity);

			log.debug("update ProgramaSiembraCosechaDet successful");
		} catch (Exception e) {
			log.error("update ProgramaSiembraCosechaDet failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProgramaSiembraCosechaDetDTO> getDataProgramaSiembraCosechaDet() throws Exception {
		try {
			List<ProgramaSiembraCosechaDet> programaSiembraCosechaDet = programaSiembraCosechaDetDAO.findAll();

			List<ProgramaSiembraCosechaDetDTO> programaSiembraCosechaDetDTO = new ArrayList<ProgramaSiembraCosechaDetDTO>();

			for (ProgramaSiembraCosechaDet programaSiembraCosechaDetTmp : programaSiembraCosechaDet) {
				ProgramaSiembraCosechaDetDTO programaSiembraCosechaDetDTO2 = new ProgramaSiembraCosechaDetDTO();

				programaSiembraCosechaDetDTO2
						.setProgramaSiembraCosechaDetId(programaSiembraCosechaDetTmp.getProgramaSiembraCosechaDetId());
				programaSiembraCosechaDetDTO2.setCosecha1((programaSiembraCosechaDetTmp.getCosecha1() != null)
						? programaSiembraCosechaDetTmp.getCosecha1() : null);
				programaSiembraCosechaDetDTO2.setCosecha10((programaSiembraCosechaDetTmp.getCosecha10() != null)
						? programaSiembraCosechaDetTmp.getCosecha10() : null);
				programaSiembraCosechaDetDTO2.setCosecha11((programaSiembraCosechaDetTmp.getCosecha11() != null)
						? programaSiembraCosechaDetTmp.getCosecha11() : null);
				programaSiembraCosechaDetDTO2.setCosecha12((programaSiembraCosechaDetTmp.getCosecha12() != null)
						? programaSiembraCosechaDetTmp.getCosecha12() : null);
				programaSiembraCosechaDetDTO2.setCosecha13((programaSiembraCosechaDetTmp.getCosecha13() != null)
						? programaSiembraCosechaDetTmp.getCosecha13() : null);
				programaSiembraCosechaDetDTO2.setCosecha14((programaSiembraCosechaDetTmp.getCosecha14() != null)
						? programaSiembraCosechaDetTmp.getCosecha14() : null);
				programaSiembraCosechaDetDTO2.setCosecha15((programaSiembraCosechaDetTmp.getCosecha15() != null)
						? programaSiembraCosechaDetTmp.getCosecha15() : null);
				programaSiembraCosechaDetDTO2.setCosecha16((programaSiembraCosechaDetTmp.getCosecha16() != null)
						? programaSiembraCosechaDetTmp.getCosecha16() : null);
				programaSiembraCosechaDetDTO2.setCosecha17((programaSiembraCosechaDetTmp.getCosecha17() != null)
						? programaSiembraCosechaDetTmp.getCosecha17() : null);
				programaSiembraCosechaDetDTO2.setCosecha18((programaSiembraCosechaDetTmp.getCosecha18() != null)
						? programaSiembraCosechaDetTmp.getCosecha18() : null);
				programaSiembraCosechaDetDTO2.setCosecha19((programaSiembraCosechaDetTmp.getCosecha19() != null)
						? programaSiembraCosechaDetTmp.getCosecha19() : null);
				programaSiembraCosechaDetDTO2.setCosecha2((programaSiembraCosechaDetTmp.getCosecha2() != null)
						? programaSiembraCosechaDetTmp.getCosecha2() : null);
				programaSiembraCosechaDetDTO2.setCosecha20((programaSiembraCosechaDetTmp.getCosecha20() != null)
						? programaSiembraCosechaDetTmp.getCosecha20() : null);
				programaSiembraCosechaDetDTO2.setCosecha21((programaSiembraCosechaDetTmp.getCosecha21() != null)
						? programaSiembraCosechaDetTmp.getCosecha21() : null);
				programaSiembraCosechaDetDTO2.setCosecha22((programaSiembraCosechaDetTmp.getCosecha22() != null)
						? programaSiembraCosechaDetTmp.getCosecha22() : null);
				programaSiembraCosechaDetDTO2.setCosecha23((programaSiembraCosechaDetTmp.getCosecha23() != null)
						? programaSiembraCosechaDetTmp.getCosecha23() : null);
				programaSiembraCosechaDetDTO2.setCosecha24((programaSiembraCosechaDetTmp.getCosecha24() != null)
						? programaSiembraCosechaDetTmp.getCosecha24() : null);
				programaSiembraCosechaDetDTO2.setCosecha25((programaSiembraCosechaDetTmp.getCosecha25() != null)
						? programaSiembraCosechaDetTmp.getCosecha25() : null);
				programaSiembraCosechaDetDTO2.setCosecha26((programaSiembraCosechaDetTmp.getCosecha26() != null)
						? programaSiembraCosechaDetTmp.getCosecha26() : null);
				programaSiembraCosechaDetDTO2.setCosecha27((programaSiembraCosechaDetTmp.getCosecha27() != null)
						? programaSiembraCosechaDetTmp.getCosecha27() : null);
				programaSiembraCosechaDetDTO2.setCosecha28((programaSiembraCosechaDetTmp.getCosecha28() != null)
						? programaSiembraCosechaDetTmp.getCosecha28() : null);
				programaSiembraCosechaDetDTO2.setCosecha29((programaSiembraCosechaDetTmp.getCosecha29() != null)
						? programaSiembraCosechaDetTmp.getCosecha29() : null);
				programaSiembraCosechaDetDTO2.setCosecha3((programaSiembraCosechaDetTmp.getCosecha3() != null)
						? programaSiembraCosechaDetTmp.getCosecha3() : null);
				programaSiembraCosechaDetDTO2.setCosecha30((programaSiembraCosechaDetTmp.getCosecha30() != null)
						? programaSiembraCosechaDetTmp.getCosecha30() : null);
				programaSiembraCosechaDetDTO2.setCosecha31((programaSiembraCosechaDetTmp.getCosecha31() != null)
						? programaSiembraCosechaDetTmp.getCosecha31() : null);
				programaSiembraCosechaDetDTO2.setCosecha32((programaSiembraCosechaDetTmp.getCosecha32() != null)
						? programaSiembraCosechaDetTmp.getCosecha32() : null);
				programaSiembraCosechaDetDTO2.setCosecha33((programaSiembraCosechaDetTmp.getCosecha33() != null)
						? programaSiembraCosechaDetTmp.getCosecha33() : null);
				programaSiembraCosechaDetDTO2.setCosecha34((programaSiembraCosechaDetTmp.getCosecha34() != null)
						? programaSiembraCosechaDetTmp.getCosecha34() : null);
				programaSiembraCosechaDetDTO2.setCosecha35((programaSiembraCosechaDetTmp.getCosecha35() != null)
						? programaSiembraCosechaDetTmp.getCosecha35() : null);
				programaSiembraCosechaDetDTO2.setCosecha36((programaSiembraCosechaDetTmp.getCosecha36() != null)
						? programaSiembraCosechaDetTmp.getCosecha36() : null);
				programaSiembraCosechaDetDTO2.setCosecha37((programaSiembraCosechaDetTmp.getCosecha37() != null)
						? programaSiembraCosechaDetTmp.getCosecha37() : null);
				programaSiembraCosechaDetDTO2.setCosecha38((programaSiembraCosechaDetTmp.getCosecha38() != null)
						? programaSiembraCosechaDetTmp.getCosecha38() : null);
				programaSiembraCosechaDetDTO2.setCosecha39((programaSiembraCosechaDetTmp.getCosecha39() != null)
						? programaSiembraCosechaDetTmp.getCosecha39() : null);
				programaSiembraCosechaDetDTO2.setCosecha4((programaSiembraCosechaDetTmp.getCosecha4() != null)
						? programaSiembraCosechaDetTmp.getCosecha4() : null);
				programaSiembraCosechaDetDTO2.setCosecha40((programaSiembraCosechaDetTmp.getCosecha40() != null)
						? programaSiembraCosechaDetTmp.getCosecha40() : null);
				programaSiembraCosechaDetDTO2.setCosecha41((programaSiembraCosechaDetTmp.getCosecha41() != null)
						? programaSiembraCosechaDetTmp.getCosecha41() : null);
				programaSiembraCosechaDetDTO2.setCosecha42((programaSiembraCosechaDetTmp.getCosecha42() != null)
						? programaSiembraCosechaDetTmp.getCosecha42() : null);
				programaSiembraCosechaDetDTO2.setCosecha43((programaSiembraCosechaDetTmp.getCosecha43() != null)
						? programaSiembraCosechaDetTmp.getCosecha43() : null);
				programaSiembraCosechaDetDTO2.setCosecha44((programaSiembraCosechaDetTmp.getCosecha44() != null)
						? programaSiembraCosechaDetTmp.getCosecha44() : null);
				programaSiembraCosechaDetDTO2.setCosecha45((programaSiembraCosechaDetTmp.getCosecha45() != null)
						? programaSiembraCosechaDetTmp.getCosecha45() : null);
				programaSiembraCosechaDetDTO2.setCosecha46((programaSiembraCosechaDetTmp.getCosecha46() != null)
						? programaSiembraCosechaDetTmp.getCosecha46() : null);
				programaSiembraCosechaDetDTO2.setCosecha47((programaSiembraCosechaDetTmp.getCosecha47() != null)
						? programaSiembraCosechaDetTmp.getCosecha47() : null);
				programaSiembraCosechaDetDTO2.setCosecha48((programaSiembraCosechaDetTmp.getCosecha48() != null)
						? programaSiembraCosechaDetTmp.getCosecha48() : null);
				programaSiembraCosechaDetDTO2.setCosecha49((programaSiembraCosechaDetTmp.getCosecha49() != null)
						? programaSiembraCosechaDetTmp.getCosecha49() : null);
				programaSiembraCosechaDetDTO2.setCosecha5((programaSiembraCosechaDetTmp.getCosecha5() != null)
						? programaSiembraCosechaDetTmp.getCosecha5() : null);
				programaSiembraCosechaDetDTO2.setCosecha50((programaSiembraCosechaDetTmp.getCosecha50() != null)
						? programaSiembraCosechaDetTmp.getCosecha50() : null);
				programaSiembraCosechaDetDTO2.setCosecha51((programaSiembraCosechaDetTmp.getCosecha51() != null)
						? programaSiembraCosechaDetTmp.getCosecha51() : null);
				programaSiembraCosechaDetDTO2.setCosecha52((programaSiembraCosechaDetTmp.getCosecha52() != null)
						? programaSiembraCosechaDetTmp.getCosecha52() : null);
				programaSiembraCosechaDetDTO2.setCosecha53((programaSiembraCosechaDetTmp.getCosecha53() != null)
						? programaSiembraCosechaDetTmp.getCosecha53() : null);
				programaSiembraCosechaDetDTO2.setCosecha6((programaSiembraCosechaDetTmp.getCosecha6() != null)
						? programaSiembraCosechaDetTmp.getCosecha6() : null);
				programaSiembraCosechaDetDTO2.setCosecha7((programaSiembraCosechaDetTmp.getCosecha7() != null)
						? programaSiembraCosechaDetTmp.getCosecha7() : null);
				programaSiembraCosechaDetDTO2.setCosecha8((programaSiembraCosechaDetTmp.getCosecha8() != null)
						? programaSiembraCosechaDetTmp.getCosecha8() : null);
				programaSiembraCosechaDetDTO2.setCosecha9((programaSiembraCosechaDetTmp.getCosecha9() != null)
						? programaSiembraCosechaDetTmp.getCosecha9() : null);
				programaSiembraCosechaDetDTO2.setFechaCosecha((programaSiembraCosechaDetTmp.getFechaCosecha() != null)
						? programaSiembraCosechaDetTmp.getFechaCosecha() : null);
				programaSiembraCosechaDetDTO2.setFechaSiembra((programaSiembraCosechaDetTmp.getFechaSiembra() != null)
						? programaSiembraCosechaDetTmp.getFechaSiembra() : null);
				programaSiembraCosechaDetDTO2
						.setRotacionCultivo((programaSiembraCosechaDetTmp.getRotacionCultivo() != null)
								? programaSiembraCosechaDetTmp.getRotacionCultivo() : null);
				programaSiembraCosechaDetDTO2.setSiembra1((programaSiembraCosechaDetTmp.getSiembra1() != null)
						? programaSiembraCosechaDetTmp.getSiembra1() : null);
				programaSiembraCosechaDetDTO2.setSiembra10((programaSiembraCosechaDetTmp.getSiembra10() != null)
						? programaSiembraCosechaDetTmp.getSiembra10() : null);
				programaSiembraCosechaDetDTO2.setSiembra11((programaSiembraCosechaDetTmp.getSiembra11() != null)
						? programaSiembraCosechaDetTmp.getSiembra11() : null);
				programaSiembraCosechaDetDTO2.setSiembra12((programaSiembraCosechaDetTmp.getSiembra12() != null)
						? programaSiembraCosechaDetTmp.getSiembra12() : null);
				programaSiembraCosechaDetDTO2.setSiembra13((programaSiembraCosechaDetTmp.getSiembra13() != null)
						? programaSiembraCosechaDetTmp.getSiembra13() : null);
				programaSiembraCosechaDetDTO2.setSiembra14((programaSiembraCosechaDetTmp.getSiembra14() != null)
						? programaSiembraCosechaDetTmp.getSiembra14() : null);
				programaSiembraCosechaDetDTO2.setSiembra15((programaSiembraCosechaDetTmp.getSiembra15() != null)
						? programaSiembraCosechaDetTmp.getSiembra15() : null);
				programaSiembraCosechaDetDTO2.setSiembra16((programaSiembraCosechaDetTmp.getSiembra16() != null)
						? programaSiembraCosechaDetTmp.getSiembra16() : null);
				programaSiembraCosechaDetDTO2.setSiembra17((programaSiembraCosechaDetTmp.getSiembra17() != null)
						? programaSiembraCosechaDetTmp.getSiembra17() : null);
				programaSiembraCosechaDetDTO2.setSiembra18((programaSiembraCosechaDetTmp.getSiembra18() != null)
						? programaSiembraCosechaDetTmp.getSiembra18() : null);
				programaSiembraCosechaDetDTO2.setSiembra19((programaSiembraCosechaDetTmp.getSiembra19() != null)
						? programaSiembraCosechaDetTmp.getSiembra19() : null);
				programaSiembraCosechaDetDTO2.setSiembra2((programaSiembraCosechaDetTmp.getSiembra2() != null)
						? programaSiembraCosechaDetTmp.getSiembra2() : null);
				programaSiembraCosechaDetDTO2.setSiembra20((programaSiembraCosechaDetTmp.getSiembra20() != null)
						? programaSiembraCosechaDetTmp.getSiembra20() : null);
				programaSiembraCosechaDetDTO2.setSiembra21((programaSiembraCosechaDetTmp.getSiembra21() != null)
						? programaSiembraCosechaDetTmp.getSiembra21() : null);
				programaSiembraCosechaDetDTO2.setSiembra22((programaSiembraCosechaDetTmp.getSiembra22() != null)
						? programaSiembraCosechaDetTmp.getSiembra22() : null);
				programaSiembraCosechaDetDTO2.setSiembra23((programaSiembraCosechaDetTmp.getSiembra23() != null)
						? programaSiembraCosechaDetTmp.getSiembra23() : null);
				programaSiembraCosechaDetDTO2.setSiembra24((programaSiembraCosechaDetTmp.getSiembra24() != null)
						? programaSiembraCosechaDetTmp.getSiembra24() : null);
				programaSiembraCosechaDetDTO2.setSiembra25((programaSiembraCosechaDetTmp.getSiembra25() != null)
						? programaSiembraCosechaDetTmp.getSiembra25() : null);
				programaSiembraCosechaDetDTO2.setSiembra26((programaSiembraCosechaDetTmp.getSiembra26() != null)
						? programaSiembraCosechaDetTmp.getSiembra26() : null);
				programaSiembraCosechaDetDTO2.setSiembra27((programaSiembraCosechaDetTmp.getSiembra27() != null)
						? programaSiembraCosechaDetTmp.getSiembra27() : null);
				programaSiembraCosechaDetDTO2.setSiembra28((programaSiembraCosechaDetTmp.getSiembra28() != null)
						? programaSiembraCosechaDetTmp.getSiembra28() : null);
				programaSiembraCosechaDetDTO2.setSiembra29((programaSiembraCosechaDetTmp.getSiembra29() != null)
						? programaSiembraCosechaDetTmp.getSiembra29() : null);
				programaSiembraCosechaDetDTO2.setSiembra3((programaSiembraCosechaDetTmp.getSiembra3() != null)
						? programaSiembraCosechaDetTmp.getSiembra3() : null);
				programaSiembraCosechaDetDTO2.setSiembra30((programaSiembraCosechaDetTmp.getSiembra30() != null)
						? programaSiembraCosechaDetTmp.getSiembra30() : null);
				programaSiembraCosechaDetDTO2.setSiembra31((programaSiembraCosechaDetTmp.getSiembra31() != null)
						? programaSiembraCosechaDetTmp.getSiembra31() : null);
				programaSiembraCosechaDetDTO2.setSiembra32((programaSiembraCosechaDetTmp.getSiembra32() != null)
						? programaSiembraCosechaDetTmp.getSiembra32() : null);
				programaSiembraCosechaDetDTO2.setSiembra33((programaSiembraCosechaDetTmp.getSiembra33() != null)
						? programaSiembraCosechaDetTmp.getSiembra33() : null);
				programaSiembraCosechaDetDTO2.setSiembra34((programaSiembraCosechaDetTmp.getSiembra34() != null)
						? programaSiembraCosechaDetTmp.getSiembra34() : null);
				programaSiembraCosechaDetDTO2.setSiembra35((programaSiembraCosechaDetTmp.getSiembra35() != null)
						? programaSiembraCosechaDetTmp.getSiembra35() : null);
				programaSiembraCosechaDetDTO2.setSiembra36((programaSiembraCosechaDetTmp.getSiembra36() != null)
						? programaSiembraCosechaDetTmp.getSiembra36() : null);
				programaSiembraCosechaDetDTO2.setSiembra37((programaSiembraCosechaDetTmp.getSiembra37() != null)
						? programaSiembraCosechaDetTmp.getSiembra37() : null);
				programaSiembraCosechaDetDTO2.setSiembra38((programaSiembraCosechaDetTmp.getSiembra38() != null)
						? programaSiembraCosechaDetTmp.getSiembra38() : null);
				programaSiembraCosechaDetDTO2.setSiembra39((programaSiembraCosechaDetTmp.getSiembra39() != null)
						? programaSiembraCosechaDetTmp.getSiembra39() : null);
				programaSiembraCosechaDetDTO2.setSiembra4((programaSiembraCosechaDetTmp.getSiembra4() != null)
						? programaSiembraCosechaDetTmp.getSiembra4() : null);
				programaSiembraCosechaDetDTO2.setSiembra40((programaSiembraCosechaDetTmp.getSiembra40() != null)
						? programaSiembraCosechaDetTmp.getSiembra40() : null);
				programaSiembraCosechaDetDTO2.setSiembra41((programaSiembraCosechaDetTmp.getSiembra41() != null)
						? programaSiembraCosechaDetTmp.getSiembra41() : null);
				programaSiembraCosechaDetDTO2.setSiembra42((programaSiembraCosechaDetTmp.getSiembra42() != null)
						? programaSiembraCosechaDetTmp.getSiembra42() : null);
				programaSiembraCosechaDetDTO2.setSiembra43((programaSiembraCosechaDetTmp.getSiembra43() != null)
						? programaSiembraCosechaDetTmp.getSiembra43() : null);
				programaSiembraCosechaDetDTO2.setSiembra44((programaSiembraCosechaDetTmp.getSiembra44() != null)
						? programaSiembraCosechaDetTmp.getSiembra44() : null);
				programaSiembraCosechaDetDTO2.setSiembra45((programaSiembraCosechaDetTmp.getSiembra45() != null)
						? programaSiembraCosechaDetTmp.getSiembra45() : null);
				programaSiembraCosechaDetDTO2.setSiembra46((programaSiembraCosechaDetTmp.getSiembra46() != null)
						? programaSiembraCosechaDetTmp.getSiembra46() : null);
				programaSiembraCosechaDetDTO2.setSiembra47((programaSiembraCosechaDetTmp.getSiembra47() != null)
						? programaSiembraCosechaDetTmp.getSiembra47() : null);
				programaSiembraCosechaDetDTO2.setSiembra48((programaSiembraCosechaDetTmp.getSiembra48() != null)
						? programaSiembraCosechaDetTmp.getSiembra48() : null);
				programaSiembraCosechaDetDTO2.setSiembra49((programaSiembraCosechaDetTmp.getSiembra49() != null)
						? programaSiembraCosechaDetTmp.getSiembra49() : null);
				programaSiembraCosechaDetDTO2.setSiembra5((programaSiembraCosechaDetTmp.getSiembra5() != null)
						? programaSiembraCosechaDetTmp.getSiembra5() : null);
				programaSiembraCosechaDetDTO2.setSiembra50((programaSiembraCosechaDetTmp.getSiembra50() != null)
						? programaSiembraCosechaDetTmp.getSiembra50() : null);
				programaSiembraCosechaDetDTO2.setSiembra51((programaSiembraCosechaDetTmp.getSiembra51() != null)
						? programaSiembraCosechaDetTmp.getSiembra51() : null);
				programaSiembraCosechaDetDTO2.setSiembra52((programaSiembraCosechaDetTmp.getSiembra52() != null)
						? programaSiembraCosechaDetTmp.getSiembra52() : null);
				programaSiembraCosechaDetDTO2.setSiembra53((programaSiembraCosechaDetTmp.getSiembra53() != null)
						? programaSiembraCosechaDetTmp.getSiembra53() : null);
				programaSiembraCosechaDetDTO2.setSiembra6((programaSiembraCosechaDetTmp.getSiembra6() != null)
						? programaSiembraCosechaDetTmp.getSiembra6() : null);
				programaSiembraCosechaDetDTO2.setSiembra7((programaSiembraCosechaDetTmp.getSiembra7() != null)
						? programaSiembraCosechaDetTmp.getSiembra7() : null);
				programaSiembraCosechaDetDTO2.setSiembra8((programaSiembraCosechaDetTmp.getSiembra8() != null)
						? programaSiembraCosechaDetTmp.getSiembra8() : null);
				programaSiembraCosechaDetDTO2.setSiembra9((programaSiembraCosechaDetTmp.getSiembra9() != null)
						? programaSiembraCosechaDetTmp.getSiembra9() : null);
				programaSiembraCosechaDetDTO2.setTotalCosecha((programaSiembraCosechaDetTmp.getTotalCosecha() != null)
						? programaSiembraCosechaDetTmp.getTotalCosecha() : null);
				programaSiembraCosechaDetDTO2.setTotalSiembra((programaSiembraCosechaDetTmp.getTotalSiembra() != null)
						? programaSiembraCosechaDetTmp.getTotalSiembra() : null);
				programaSiembraCosechaDetDTO2
						.setPersEmprId_PersEmpr((programaSiembraCosechaDetTmp.getPersEmpr() != null)
								? programaSiembraCosechaDetTmp.getPersEmpr() : null);

				programaSiembraCosechaDetDTO2
						.setEmpresaNombre((programaSiembraCosechaDetTmp.getPersEmpr().getCodigo() != null)
								? programaSiembraCosechaDetTmp.getPersEmpr().getCodigo() : null);

				programaSiembraCosechaDetDTO2.setProgramaSiembraCosechaId_ProgramaSiembraCosecha(
						(programaSiembraCosechaDetTmp.getProgramaSiembraCosecha().getProgramaSiembraCosechaId() != null)
								? programaSiembraCosechaDetTmp.getProgramaSiembraCosecha().getProgramaSiembraCosechaId()
								: null);

				if (programaSiembraCosechaDetTmp.getVariedad() != null) {
					programaSiembraCosechaDetDTO2.setVariedId_Variedad(programaSiembraCosechaDetTmp.getVariedad());
				} else {
					programaSiembraCosechaDetDTO2.setVariedId_Variedad(null);
				}

				if (programaSiembraCosechaDetTmp.getVariedad() != null) {
					programaSiembraCosechaDetDTO2
							.setVariedadNombre(programaSiembraCosechaDetTmp.getVariedad().getNombre());
				} else {
					programaSiembraCosechaDetDTO2.setVariedadNombre(null);
				}

				programaSiembraCosechaDetDTO.add(programaSiembraCosechaDetDTO2);
			}

			return programaSiembraCosechaDetDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public ProgramaSiembraCosechaDet getProgramaSiembraCosechaDet(Long programaSiembraCosechaDetId) throws Exception {
		log.debug("getting ProgramaSiembraCosechaDet instance");

		ProgramaSiembraCosechaDet entity = null;

		try {
			entity = programaSiembraCosechaDetDAO.findById(programaSiembraCosechaDetId);
		} catch (Exception e) {
			log.error("get ProgramaSiembraCosechaDet failed", e);
			throw new ZMessManager().new FindingException("ProgramaSiembraCosechaDet");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProgramaSiembraCosechaDet> findPageProgramaSiembraCosechaDet(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults) throws Exception {
		List<ProgramaSiembraCosechaDet> entity = null;

		try {
			entity = programaSiembraCosechaDetDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("ProgramaSiembraCosechaDet Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public Long findTotalNumberProgramaSiembraCosechaDet() throws Exception {
		Long entity = null;

		try {
			entity = programaSiembraCosechaDetDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("ProgramaSiembraCosechaDet Count");
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
	public List<ProgramaSiembraCosechaDet> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<ProgramaSiembraCosechaDet> list = new ArrayList<ProgramaSiembraCosechaDet>();
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
			list = programaSiembraCosechaDetDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProgramaSiembraCosechaDetDTO> getDataProgramaSiembraCosechaDetByPrograma(Long programaDetId)
			throws Exception {
		try {
			List<ProgramaSiembraCosechaDet> programaSiembraCosechaDet = programaSiembraCosechaDetDAO
					.findByCriteria("programaSiembraCosecha.programaSiembraCosechaId= " + programaDetId);

			List<ProgramaSiembraCosechaDetDTO> programaSiembraCosechaDetDTO = new ArrayList<ProgramaSiembraCosechaDetDTO>();

			for (ProgramaSiembraCosechaDet programaSiembraCosechaDetTmp : programaSiembraCosechaDet) {
				ProgramaSiembraCosechaDetDTO programaSiembraCosechaDetDTO2 = new ProgramaSiembraCosechaDetDTO();

				programaSiembraCosechaDetDTO2
						.setProgramaSiembraCosechaDetId(programaSiembraCosechaDetTmp.getProgramaSiembraCosechaDetId());
				programaSiembraCosechaDetDTO2.setCosecha1((programaSiembraCosechaDetTmp.getCosecha1() != null)
						? programaSiembraCosechaDetTmp.getCosecha1() : null);
				programaSiembraCosechaDetDTO2.setCosecha10((programaSiembraCosechaDetTmp.getCosecha10() != null)
						? programaSiembraCosechaDetTmp.getCosecha10() : null);
				programaSiembraCosechaDetDTO2.setCosecha11((programaSiembraCosechaDetTmp.getCosecha11() != null)
						? programaSiembraCosechaDetTmp.getCosecha11() : null);
				programaSiembraCosechaDetDTO2.setCosecha12((programaSiembraCosechaDetTmp.getCosecha12() != null)
						? programaSiembraCosechaDetTmp.getCosecha12() : null);
				programaSiembraCosechaDetDTO2.setCosecha13((programaSiembraCosechaDetTmp.getCosecha13() != null)
						? programaSiembraCosechaDetTmp.getCosecha13() : null);
				programaSiembraCosechaDetDTO2.setCosecha14((programaSiembraCosechaDetTmp.getCosecha14() != null)
						? programaSiembraCosechaDetTmp.getCosecha14() : null);
				programaSiembraCosechaDetDTO2.setCosecha15((programaSiembraCosechaDetTmp.getCosecha15() != null)
						? programaSiembraCosechaDetTmp.getCosecha15() : null);
				programaSiembraCosechaDetDTO2.setCosecha16((programaSiembraCosechaDetTmp.getCosecha16() != null)
						? programaSiembraCosechaDetTmp.getCosecha16() : null);
				programaSiembraCosechaDetDTO2.setCosecha17((programaSiembraCosechaDetTmp.getCosecha17() != null)
						? programaSiembraCosechaDetTmp.getCosecha17() : null);
				programaSiembraCosechaDetDTO2.setCosecha18((programaSiembraCosechaDetTmp.getCosecha18() != null)
						? programaSiembraCosechaDetTmp.getCosecha18() : null);
				programaSiembraCosechaDetDTO2.setCosecha19((programaSiembraCosechaDetTmp.getCosecha19() != null)
						? programaSiembraCosechaDetTmp.getCosecha19() : null);
				programaSiembraCosechaDetDTO2.setCosecha2((programaSiembraCosechaDetTmp.getCosecha2() != null)
						? programaSiembraCosechaDetTmp.getCosecha2() : null);
				programaSiembraCosechaDetDTO2.setCosecha20((programaSiembraCosechaDetTmp.getCosecha20() != null)
						? programaSiembraCosechaDetTmp.getCosecha20() : null);
				programaSiembraCosechaDetDTO2.setCosecha21((programaSiembraCosechaDetTmp.getCosecha21() != null)
						? programaSiembraCosechaDetTmp.getCosecha21() : null);
				programaSiembraCosechaDetDTO2.setCosecha22((programaSiembraCosechaDetTmp.getCosecha22() != null)
						? programaSiembraCosechaDetTmp.getCosecha22() : null);
				programaSiembraCosechaDetDTO2.setCosecha23((programaSiembraCosechaDetTmp.getCosecha23() != null)
						? programaSiembraCosechaDetTmp.getCosecha23() : null);
				programaSiembraCosechaDetDTO2.setCosecha24((programaSiembraCosechaDetTmp.getCosecha24() != null)
						? programaSiembraCosechaDetTmp.getCosecha24() : null);
				programaSiembraCosechaDetDTO2.setCosecha25((programaSiembraCosechaDetTmp.getCosecha25() != null)
						? programaSiembraCosechaDetTmp.getCosecha25() : null);
				programaSiembraCosechaDetDTO2.setCosecha26((programaSiembraCosechaDetTmp.getCosecha26() != null)
						? programaSiembraCosechaDetTmp.getCosecha26() : null);
				programaSiembraCosechaDetDTO2.setCosecha27((programaSiembraCosechaDetTmp.getCosecha27() != null)
						? programaSiembraCosechaDetTmp.getCosecha27() : null);
				programaSiembraCosechaDetDTO2.setCosecha28((programaSiembraCosechaDetTmp.getCosecha28() != null)
						? programaSiembraCosechaDetTmp.getCosecha28() : null);
				programaSiembraCosechaDetDTO2.setCosecha29((programaSiembraCosechaDetTmp.getCosecha29() != null)
						? programaSiembraCosechaDetTmp.getCosecha29() : null);
				programaSiembraCosechaDetDTO2.setCosecha3((programaSiembraCosechaDetTmp.getCosecha3() != null)
						? programaSiembraCosechaDetTmp.getCosecha3() : null);
				programaSiembraCosechaDetDTO2.setCosecha30((programaSiembraCosechaDetTmp.getCosecha30() != null)
						? programaSiembraCosechaDetTmp.getCosecha30() : null);
				programaSiembraCosechaDetDTO2.setCosecha31((programaSiembraCosechaDetTmp.getCosecha31() != null)
						? programaSiembraCosechaDetTmp.getCosecha31() : null);
				programaSiembraCosechaDetDTO2.setCosecha32((programaSiembraCosechaDetTmp.getCosecha32() != null)
						? programaSiembraCosechaDetTmp.getCosecha32() : null);
				programaSiembraCosechaDetDTO2.setCosecha33((programaSiembraCosechaDetTmp.getCosecha33() != null)
						? programaSiembraCosechaDetTmp.getCosecha33() : null);
				programaSiembraCosechaDetDTO2.setCosecha34((programaSiembraCosechaDetTmp.getCosecha34() != null)
						? programaSiembraCosechaDetTmp.getCosecha34() : null);
				programaSiembraCosechaDetDTO2.setCosecha35((programaSiembraCosechaDetTmp.getCosecha35() != null)
						? programaSiembraCosechaDetTmp.getCosecha35() : null);
				programaSiembraCosechaDetDTO2.setCosecha36((programaSiembraCosechaDetTmp.getCosecha36() != null)
						? programaSiembraCosechaDetTmp.getCosecha36() : null);
				programaSiembraCosechaDetDTO2.setCosecha37((programaSiembraCosechaDetTmp.getCosecha37() != null)
						? programaSiembraCosechaDetTmp.getCosecha37() : null);
				programaSiembraCosechaDetDTO2.setCosecha38((programaSiembraCosechaDetTmp.getCosecha38() != null)
						? programaSiembraCosechaDetTmp.getCosecha38() : null);
				programaSiembraCosechaDetDTO2.setCosecha39((programaSiembraCosechaDetTmp.getCosecha39() != null)
						? programaSiembraCosechaDetTmp.getCosecha39() : null);
				programaSiembraCosechaDetDTO2.setCosecha4((programaSiembraCosechaDetTmp.getCosecha4() != null)
						? programaSiembraCosechaDetTmp.getCosecha4() : null);
				programaSiembraCosechaDetDTO2.setCosecha40((programaSiembraCosechaDetTmp.getCosecha40() != null)
						? programaSiembraCosechaDetTmp.getCosecha40() : null);
				programaSiembraCosechaDetDTO2.setCosecha41((programaSiembraCosechaDetTmp.getCosecha41() != null)
						? programaSiembraCosechaDetTmp.getCosecha41() : null);
				programaSiembraCosechaDetDTO2.setCosecha42((programaSiembraCosechaDetTmp.getCosecha42() != null)
						? programaSiembraCosechaDetTmp.getCosecha42() : null);
				programaSiembraCosechaDetDTO2.setCosecha43((programaSiembraCosechaDetTmp.getCosecha43() != null)
						? programaSiembraCosechaDetTmp.getCosecha43() : null);
				programaSiembraCosechaDetDTO2.setCosecha44((programaSiembraCosechaDetTmp.getCosecha44() != null)
						? programaSiembraCosechaDetTmp.getCosecha44() : null);
				programaSiembraCosechaDetDTO2.setCosecha45((programaSiembraCosechaDetTmp.getCosecha45() != null)
						? programaSiembraCosechaDetTmp.getCosecha45() : null);
				programaSiembraCosechaDetDTO2.setCosecha46((programaSiembraCosechaDetTmp.getCosecha46() != null)
						? programaSiembraCosechaDetTmp.getCosecha46() : null);
				programaSiembraCosechaDetDTO2.setCosecha47((programaSiembraCosechaDetTmp.getCosecha47() != null)
						? programaSiembraCosechaDetTmp.getCosecha47() : null);
				programaSiembraCosechaDetDTO2.setCosecha48((programaSiembraCosechaDetTmp.getCosecha48() != null)
						? programaSiembraCosechaDetTmp.getCosecha48() : null);
				programaSiembraCosechaDetDTO2.setCosecha49((programaSiembraCosechaDetTmp.getCosecha49() != null)
						? programaSiembraCosechaDetTmp.getCosecha49() : null);
				programaSiembraCosechaDetDTO2.setCosecha5((programaSiembraCosechaDetTmp.getCosecha5() != null)
						? programaSiembraCosechaDetTmp.getCosecha5() : null);
				programaSiembraCosechaDetDTO2.setCosecha50((programaSiembraCosechaDetTmp.getCosecha50() != null)
						? programaSiembraCosechaDetTmp.getCosecha50() : null);
				programaSiembraCosechaDetDTO2.setCosecha51((programaSiembraCosechaDetTmp.getCosecha51() != null)
						? programaSiembraCosechaDetTmp.getCosecha51() : null);
				programaSiembraCosechaDetDTO2.setCosecha52((programaSiembraCosechaDetTmp.getCosecha52() != null)
						? programaSiembraCosechaDetTmp.getCosecha52() : null);
				programaSiembraCosechaDetDTO2.setCosecha53((programaSiembraCosechaDetTmp.getCosecha53() != null)
						? programaSiembraCosechaDetTmp.getCosecha53() : null);
				programaSiembraCosechaDetDTO2.setCosecha6((programaSiembraCosechaDetTmp.getCosecha6() != null)
						? programaSiembraCosechaDetTmp.getCosecha6() : null);
				programaSiembraCosechaDetDTO2.setCosecha7((programaSiembraCosechaDetTmp.getCosecha7() != null)
						? programaSiembraCosechaDetTmp.getCosecha7() : null);
				programaSiembraCosechaDetDTO2.setCosecha8((programaSiembraCosechaDetTmp.getCosecha8() != null)
						? programaSiembraCosechaDetTmp.getCosecha8() : null);
				programaSiembraCosechaDetDTO2.setCosecha9((programaSiembraCosechaDetTmp.getCosecha9() != null)
						? programaSiembraCosechaDetTmp.getCosecha9() : null);
				programaSiembraCosechaDetDTO2.setFechaCosecha((programaSiembraCosechaDetTmp.getFechaCosecha() != null)
						? programaSiembraCosechaDetTmp.getFechaCosecha() : null);
				programaSiembraCosechaDetDTO2.setFechaSiembra((programaSiembraCosechaDetTmp.getFechaSiembra() != null)
						? programaSiembraCosechaDetTmp.getFechaSiembra() : null);
				programaSiembraCosechaDetDTO2
						.setRotacionCultivo((programaSiembraCosechaDetTmp.getRotacionCultivo() != null)
								? programaSiembraCosechaDetTmp.getRotacionCultivo() : null);
				programaSiembraCosechaDetDTO2.setSiembra1((programaSiembraCosechaDetTmp.getSiembra1() != null)
						? programaSiembraCosechaDetTmp.getSiembra1() : null);
				programaSiembraCosechaDetDTO2.setSiembra10((programaSiembraCosechaDetTmp.getSiembra10() != null)
						? programaSiembraCosechaDetTmp.getSiembra10() : null);
				programaSiembraCosechaDetDTO2.setSiembra11((programaSiembraCosechaDetTmp.getSiembra11() != null)
						? programaSiembraCosechaDetTmp.getSiembra11() : null);
				programaSiembraCosechaDetDTO2.setSiembra12((programaSiembraCosechaDetTmp.getSiembra12() != null)
						? programaSiembraCosechaDetTmp.getSiembra12() : null);
				programaSiembraCosechaDetDTO2.setSiembra13((programaSiembraCosechaDetTmp.getSiembra13() != null)
						? programaSiembraCosechaDetTmp.getSiembra13() : null);
				programaSiembraCosechaDetDTO2.setSiembra14((programaSiembraCosechaDetTmp.getSiembra14() != null)
						? programaSiembraCosechaDetTmp.getSiembra14() : null);
				programaSiembraCosechaDetDTO2.setSiembra15((programaSiembraCosechaDetTmp.getSiembra15() != null)
						? programaSiembraCosechaDetTmp.getSiembra15() : null);
				programaSiembraCosechaDetDTO2.setSiembra16((programaSiembraCosechaDetTmp.getSiembra16() != null)
						? programaSiembraCosechaDetTmp.getSiembra16() : null);
				programaSiembraCosechaDetDTO2.setSiembra17((programaSiembraCosechaDetTmp.getSiembra17() != null)
						? programaSiembraCosechaDetTmp.getSiembra17() : null);
				programaSiembraCosechaDetDTO2.setSiembra18((programaSiembraCosechaDetTmp.getSiembra18() != null)
						? programaSiembraCosechaDetTmp.getSiembra18() : null);
				programaSiembraCosechaDetDTO2.setSiembra19((programaSiembraCosechaDetTmp.getSiembra19() != null)
						? programaSiembraCosechaDetTmp.getSiembra19() : null);
				programaSiembraCosechaDetDTO2.setSiembra2((programaSiembraCosechaDetTmp.getSiembra2() != null)
						? programaSiembraCosechaDetTmp.getSiembra2() : null);
				programaSiembraCosechaDetDTO2.setSiembra20((programaSiembraCosechaDetTmp.getSiembra20() != null)
						? programaSiembraCosechaDetTmp.getSiembra20() : null);
				programaSiembraCosechaDetDTO2.setSiembra21((programaSiembraCosechaDetTmp.getSiembra21() != null)
						? programaSiembraCosechaDetTmp.getSiembra21() : null);
				programaSiembraCosechaDetDTO2.setSiembra22((programaSiembraCosechaDetTmp.getSiembra22() != null)
						? programaSiembraCosechaDetTmp.getSiembra22() : null);
				programaSiembraCosechaDetDTO2.setSiembra23((programaSiembraCosechaDetTmp.getSiembra23() != null)
						? programaSiembraCosechaDetTmp.getSiembra23() : null);
				programaSiembraCosechaDetDTO2.setSiembra24((programaSiembraCosechaDetTmp.getSiembra24() != null)
						? programaSiembraCosechaDetTmp.getSiembra24() : null);
				programaSiembraCosechaDetDTO2.setSiembra25((programaSiembraCosechaDetTmp.getSiembra25() != null)
						? programaSiembraCosechaDetTmp.getSiembra25() : null);
				programaSiembraCosechaDetDTO2.setSiembra26((programaSiembraCosechaDetTmp.getSiembra26() != null)
						? programaSiembraCosechaDetTmp.getSiembra26() : null);
				programaSiembraCosechaDetDTO2.setSiembra27((programaSiembraCosechaDetTmp.getSiembra27() != null)
						? programaSiembraCosechaDetTmp.getSiembra27() : null);
				programaSiembraCosechaDetDTO2.setSiembra28((programaSiembraCosechaDetTmp.getSiembra28() != null)
						? programaSiembraCosechaDetTmp.getSiembra28() : null);
				programaSiembraCosechaDetDTO2.setSiembra29((programaSiembraCosechaDetTmp.getSiembra29() != null)
						? programaSiembraCosechaDetTmp.getSiembra29() : null);
				programaSiembraCosechaDetDTO2.setSiembra3((programaSiembraCosechaDetTmp.getSiembra3() != null)
						? programaSiembraCosechaDetTmp.getSiembra3() : null);
				programaSiembraCosechaDetDTO2.setSiembra30((programaSiembraCosechaDetTmp.getSiembra30() != null)
						? programaSiembraCosechaDetTmp.getSiembra30() : null);
				programaSiembraCosechaDetDTO2.setSiembra31((programaSiembraCosechaDetTmp.getSiembra31() != null)
						? programaSiembraCosechaDetTmp.getSiembra31() : null);
				programaSiembraCosechaDetDTO2.setSiembra32((programaSiembraCosechaDetTmp.getSiembra32() != null)
						? programaSiembraCosechaDetTmp.getSiembra32() : null);
				programaSiembraCosechaDetDTO2.setSiembra33((programaSiembraCosechaDetTmp.getSiembra33() != null)
						? programaSiembraCosechaDetTmp.getSiembra33() : null);
				programaSiembraCosechaDetDTO2.setSiembra34((programaSiembraCosechaDetTmp.getSiembra34() != null)
						? programaSiembraCosechaDetTmp.getSiembra34() : null);
				programaSiembraCosechaDetDTO2.setSiembra35((programaSiembraCosechaDetTmp.getSiembra35() != null)
						? programaSiembraCosechaDetTmp.getSiembra35() : null);
				programaSiembraCosechaDetDTO2.setSiembra36((programaSiembraCosechaDetTmp.getSiembra36() != null)
						? programaSiembraCosechaDetTmp.getSiembra36() : null);
				programaSiembraCosechaDetDTO2.setSiembra37((programaSiembraCosechaDetTmp.getSiembra37() != null)
						? programaSiembraCosechaDetTmp.getSiembra37() : null);
				programaSiembraCosechaDetDTO2.setSiembra38((programaSiembraCosechaDetTmp.getSiembra38() != null)
						? programaSiembraCosechaDetTmp.getSiembra38() : null);
				programaSiembraCosechaDetDTO2.setSiembra39((programaSiembraCosechaDetTmp.getSiembra39() != null)
						? programaSiembraCosechaDetTmp.getSiembra39() : null);
				programaSiembraCosechaDetDTO2.setSiembra4((programaSiembraCosechaDetTmp.getSiembra4() != null)
						? programaSiembraCosechaDetTmp.getSiembra4() : null);
				programaSiembraCosechaDetDTO2.setSiembra40((programaSiembraCosechaDetTmp.getSiembra40() != null)
						? programaSiembraCosechaDetTmp.getSiembra40() : null);
				programaSiembraCosechaDetDTO2.setSiembra41((programaSiembraCosechaDetTmp.getSiembra41() != null)
						? programaSiembraCosechaDetTmp.getSiembra41() : null);
				programaSiembraCosechaDetDTO2.setSiembra42((programaSiembraCosechaDetTmp.getSiembra42() != null)
						? programaSiembraCosechaDetTmp.getSiembra42() : null);
				programaSiembraCosechaDetDTO2.setSiembra43((programaSiembraCosechaDetTmp.getSiembra43() != null)
						? programaSiembraCosechaDetTmp.getSiembra43() : null);
				programaSiembraCosechaDetDTO2.setSiembra44((programaSiembraCosechaDetTmp.getSiembra44() != null)
						? programaSiembraCosechaDetTmp.getSiembra44() : null);
				programaSiembraCosechaDetDTO2.setSiembra45((programaSiembraCosechaDetTmp.getSiembra45() != null)
						? programaSiembraCosechaDetTmp.getSiembra45() : null);
				programaSiembraCosechaDetDTO2.setSiembra46((programaSiembraCosechaDetTmp.getSiembra46() != null)
						? programaSiembraCosechaDetTmp.getSiembra46() : null);
				programaSiembraCosechaDetDTO2.setSiembra47((programaSiembraCosechaDetTmp.getSiembra47() != null)
						? programaSiembraCosechaDetTmp.getSiembra47() : null);
				programaSiembraCosechaDetDTO2.setSiembra48((programaSiembraCosechaDetTmp.getSiembra48() != null)
						? programaSiembraCosechaDetTmp.getSiembra48() : null);
				programaSiembraCosechaDetDTO2.setSiembra49((programaSiembraCosechaDetTmp.getSiembra49() != null)
						? programaSiembraCosechaDetTmp.getSiembra49() : null);
				programaSiembraCosechaDetDTO2.setSiembra5((programaSiembraCosechaDetTmp.getSiembra5() != null)
						? programaSiembraCosechaDetTmp.getSiembra5() : null);
				programaSiembraCosechaDetDTO2.setSiembra50((programaSiembraCosechaDetTmp.getSiembra50() != null)
						? programaSiembraCosechaDetTmp.getSiembra50() : null);
				programaSiembraCosechaDetDTO2.setSiembra51((programaSiembraCosechaDetTmp.getSiembra51() != null)
						? programaSiembraCosechaDetTmp.getSiembra51() : null);
				programaSiembraCosechaDetDTO2.setSiembra52((programaSiembraCosechaDetTmp.getSiembra52() != null)
						? programaSiembraCosechaDetTmp.getSiembra52() : null);
				programaSiembraCosechaDetDTO2.setSiembra53((programaSiembraCosechaDetTmp.getSiembra53() != null)
						? programaSiembraCosechaDetTmp.getSiembra53() : null);
				programaSiembraCosechaDetDTO2.setSiembra6((programaSiembraCosechaDetTmp.getSiembra6() != null)
						? programaSiembraCosechaDetTmp.getSiembra6() : null);
				programaSiembraCosechaDetDTO2.setSiembra7((programaSiembraCosechaDetTmp.getSiembra7() != null)
						? programaSiembraCosechaDetTmp.getSiembra7() : null);
				programaSiembraCosechaDetDTO2.setSiembra8((programaSiembraCosechaDetTmp.getSiembra8() != null)
						? programaSiembraCosechaDetTmp.getSiembra8() : null);
				programaSiembraCosechaDetDTO2.setSiembra9((programaSiembraCosechaDetTmp.getSiembra9() != null)
						? programaSiembraCosechaDetTmp.getSiembra9() : null);
				programaSiembraCosechaDetDTO2.setTotalCosecha((programaSiembraCosechaDetTmp.getTotalCosecha() != null)
						? programaSiembraCosechaDetTmp.getTotalCosecha() : null);
				programaSiembraCosechaDetDTO2.setTotalSiembra((programaSiembraCosechaDetTmp.getTotalSiembra() != null)
						? programaSiembraCosechaDetTmp.getTotalSiembra() : null);
				programaSiembraCosechaDetDTO2
						.setPersEmprId_PersEmpr((programaSiembraCosechaDetTmp.getPersEmpr() != null)
								? programaSiembraCosechaDetTmp.getPersEmpr() : null);

				programaSiembraCosechaDetDTO2
						.setEmpresaNombre((programaSiembraCosechaDetTmp.getPersEmpr().getNombre() != null)
								? programaSiembraCosechaDetTmp.getPersEmpr().getCodigo() : null);

				programaSiembraCosechaDetDTO2.setProgramaSiembraCosechaId_ProgramaSiembraCosecha(
						(programaSiembraCosechaDetTmp.getProgramaSiembraCosecha().getProgramaSiembraCosechaId() != null)
								? programaSiembraCosechaDetTmp.getProgramaSiembraCosecha().getProgramaSiembraCosechaId()
								: null);

				if (programaSiembraCosechaDetTmp.getVariedad() != null) {
					programaSiembraCosechaDetDTO2.setVariedId_Variedad(programaSiembraCosechaDetTmp.getVariedad());
				} else {
					programaSiembraCosechaDetDTO2.setVariedId_Variedad(null);
				}

				if (programaSiembraCosechaDetTmp.getVariedad() != null) {
					programaSiembraCosechaDetDTO2
							.setVariedadNombre(programaSiembraCosechaDetTmp.getVariedad().getNombre());
				} else {
					programaSiembraCosechaDetDTO2.setVariedadNombre(null);
				}

				programaSiembraCosechaDetDTO.add(programaSiembraCosechaDetDTO2);
			}

			return programaSiembraCosechaDetDTO;
		} catch (Exception e) {
			throw e;
		}
	}

}
