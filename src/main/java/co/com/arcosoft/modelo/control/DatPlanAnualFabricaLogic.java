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

import co.com.arcosoft.dataaccess.dao.IDatPlanAnualFabricaDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.DatPlanAnualFabrica;
import co.com.arcosoft.modelo.dto.DatPlanAnualFabricaDTO;
import co.com.arcosoft.utilities.Utilities;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("DatPlanAnualFabricaLogic")
public class DatPlanAnualFabricaLogic implements IDatPlanAnualFabricaLogic {
    private static final Logger log = LoggerFactory.getLogger(DatPlanAnualFabricaLogic.class);

    /**
     * DAO injected by Spring that manages DatPlanAnualFabrica entities
     *
     */
    @Autowired
    private IDatPlanAnualFabricaDAO datPlanAnualFabricaDAO;

    @Transactional(readOnly = true)
    public List<DatPlanAnualFabrica> getDatPlanAnualFabrica()
        throws Exception {
        log.debug("finding all DatPlanAnualFabrica instances");

        List<DatPlanAnualFabrica> list = new ArrayList<DatPlanAnualFabrica>();

        try {
            list = datPlanAnualFabricaDAO.findAll();
        } catch (Exception e) {
            log.error("finding all DatPlanAnualFabrica failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "DatPlanAnualFabrica");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveDatPlanAnualFabrica(DatPlanAnualFabrica entity)
        throws Exception {
        log.debug("saving DatPlanAnualFabrica instance");

        try {
            if ((entity.getEstado() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
                throw new ZMessManager().new NotValidFormatException("estado");
            }

            if ((entity.getHorasMttoNoProgEjec() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getHorasMttoNoProgEjec(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "horasMttoNoProgEjec");
            }

            if ((entity.getHorasMttoNoProgEst() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getHorasMttoNoProgEst(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "horasMttoNoProgEst");
            }

            if ((entity.getHorasMttoProgEjec() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getHorasMttoProgEjec(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "horasMttoProgEjec");
            }

            if ((entity.getHorasMttoProgEst() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getHorasMttoProgEst(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "horasMttoProgEst");
            }

            if ((entity.getHorasPlantaEjec() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getHorasPlantaEjec(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "horasPlantaEjec");
            }

            if ((entity.getHorasPlantaEst() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getHorasPlantaEst(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "horasPlantaEst");
            }

            if ((entity.getHorasProcesoEjec() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getHorasProcesoEjec(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "horasProcesoEjec");
            }

            if ((entity.getHorasProcesoEst() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getHorasProcesoEst(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "horasProcesoEst");
            }

            if ((entity.getObservacion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getObservacion(), 3000) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "observacion");
            }

            if ((entity.getObservacionAnularReg() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getObservacionAnularReg(), 500) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "observacionAnularReg");
            }

            if ((entity.getOrigenDatos() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getOrigenDatos(), 30) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "origenDatos");
            }

            if ((entity.getProduccionAbril() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionAbril(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionAbril");
            }

            if ((entity.getProduccionAgosto() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionAgosto(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionAgosto");
            }

            if ((entity.getProduccionDiciembre() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionDiciembre(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionDiciembre");
            }

            if ((entity.getProduccionEnero() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionEnero(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionEnero");
            }

            if ((entity.getProduccionEstAbril() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionEstAbril(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionEstAbril");
            }

            if ((entity.getProduccionEstAgosto() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionEstAgosto(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionEstAgosto");
            }

            if ((entity.getProduccionEstDiciembre() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionEstDiciembre(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionEstDiciembre");
            }

            if ((entity.getProduccionEstEnero() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionEstEnero(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionEstEnero");
            }

            if ((entity.getProduccionEstFebrero() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionEstFebrero(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionEstFebrero");
            }

            if ((entity.getProduccionEstJulio() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionEstJulio(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionEstJulio");
            }

            if ((entity.getProduccionEstJunio() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionEstJunio(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionEstJunio");
            }

            if ((entity.getProduccionEstMarzo() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionEstMarzo(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionEstMarzo");
            }

            if ((entity.getProduccionEstMayo() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionEstMayo(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionEstMayo");
            }

            if ((entity.getProduccionEstNoviembre() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionEstNoviembre(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionEstNoviembre");
            }

            if ((entity.getProduccionEstOctubre() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionEstOctubre(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionEstOctubre");
            }

            if ((entity.getProduccionEstSeptiembre() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionEstSeptiembre(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionEstSeptiembre");
            }

            if ((entity.getProduccionEstTotal() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionEstTotal(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionEstTotal");
            }

            if ((entity.getProduccionFebrero() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionFebrero(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionFebrero");
            }

            if ((entity.getProduccionJulio() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionJulio(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionJulio");
            }

            if ((entity.getProduccionJunio() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionJunio(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionJunio");
            }

            if ((entity.getProduccionMarzo() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionMarzo(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionMarzo");
            }

            if ((entity.getProduccionMayo() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionMayo(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionMayo");
            }

            if ((entity.getProduccionNoviembre() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionNoviembre(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionNoviembre");
            }

            if ((entity.getProduccionOctubre() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionOctubre(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionOctubre");
            }

            if ((entity.getProduccionSeptiembre() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionSeptiembre(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionSeptiembre");
            }

            if ((entity.getProduccionTotal() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionTotal(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionTotal");
            }

            if ((entity.getValorPromedioHrDia() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorPromedioHrDia(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorPromedioHrDia");
            }

            if ((entity.getVelocidadEstandar() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getVelocidadEstandar(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "velocidadEstandar");
            }


            datPlanAnualFabricaDAO.save(entity);

            log.debug("save DatPlanAnualFabrica successful");
        } catch (Exception e) {
            log.error("save DatPlanAnualFabrica failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteDatPlanAnualFabrica(DatPlanAnualFabrica entity)
        throws Exception {
        log.debug("deleting DatPlanAnualFabrica instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion(
                "DatPlanAnualFabrica");
        }

        if (entity.getDatPlanAnualFabricaId() == null) {
            throw new ZMessManager().new EmptyFieldException(
                "datPlanAnualFabricaId");
        }

        try {
            datPlanAnualFabricaDAO.delete(entity);

            log.debug("delete DatPlanAnualFabrica successful");
        } catch (Exception e) {
            log.error("delete DatPlanAnualFabrica failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateDatPlanAnualFabrica(DatPlanAnualFabrica entity)
        throws Exception {
        log.debug("updating DatPlanAnualFabrica instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "DatPlanAnualFabrica");
            }

            if ((entity.getEstado() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getEstado(), 1) == false)) {
                throw new ZMessManager().new NotValidFormatException("estado");
            }

            if ((entity.getHorasMttoNoProgEjec() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getHorasMttoNoProgEjec(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "horasMttoNoProgEjec");
            }

            if ((entity.getHorasMttoNoProgEst() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getHorasMttoNoProgEst(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "horasMttoNoProgEst");
            }

            if ((entity.getHorasMttoProgEjec() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getHorasMttoProgEjec(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "horasMttoProgEjec");
            }

            if ((entity.getHorasMttoProgEst() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getHorasMttoProgEst(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "horasMttoProgEst");
            }

            if ((entity.getHorasPlantaEjec() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getHorasPlantaEjec(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "horasPlantaEjec");
            }

            if ((entity.getHorasPlantaEst() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getHorasPlantaEst(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "horasPlantaEst");
            }

            if ((entity.getHorasProcesoEjec() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getHorasProcesoEjec(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "horasProcesoEjec");
            }

            if ((entity.getHorasProcesoEst() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getHorasProcesoEst(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "horasProcesoEst");
            }

            if ((entity.getObservacion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getObservacion(), 3000) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "observacion");
            }

            if ((entity.getObservacionAnularReg() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getObservacionAnularReg(), 500) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "observacionAnularReg");
            }

            if ((entity.getOrigenDatos() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getOrigenDatos(), 30) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "origenDatos");
            }

            if ((entity.getProduccionAbril() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionAbril(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionAbril");
            }

            if ((entity.getProduccionAgosto() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionAgosto(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionAgosto");
            }

            if ((entity.getProduccionDiciembre() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionDiciembre(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionDiciembre");
            }

            if ((entity.getProduccionEnero() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionEnero(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionEnero");
            }

            if ((entity.getProduccionEstAbril() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionEstAbril(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionEstAbril");
            }

            if ((entity.getProduccionEstAgosto() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionEstAgosto(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionEstAgosto");
            }

            if ((entity.getProduccionEstDiciembre() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionEstDiciembre(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionEstDiciembre");
            }

            if ((entity.getProduccionEstEnero() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionEstEnero(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionEstEnero");
            }

            if ((entity.getProduccionEstFebrero() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionEstFebrero(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionEstFebrero");
            }

            if ((entity.getProduccionEstJulio() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionEstJulio(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionEstJulio");
            }

            if ((entity.getProduccionEstJunio() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionEstJunio(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionEstJunio");
            }

            if ((entity.getProduccionEstMarzo() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionEstMarzo(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionEstMarzo");
            }

            if ((entity.getProduccionEstMayo() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionEstMayo(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionEstMayo");
            }

            if ((entity.getProduccionEstNoviembre() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionEstNoviembre(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionEstNoviembre");
            }

            if ((entity.getProduccionEstOctubre() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionEstOctubre(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionEstOctubre");
            }

            if ((entity.getProduccionEstSeptiembre() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionEstSeptiembre(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionEstSeptiembre");
            }

            if ((entity.getProduccionEstTotal() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionEstTotal(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionEstTotal");
            }

            if ((entity.getProduccionFebrero() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionFebrero(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionFebrero");
            }

            if ((entity.getProduccionJulio() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionJulio(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionJulio");
            }

            if ((entity.getProduccionJunio() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionJunio(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionJunio");
            }

            if ((entity.getProduccionMarzo() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionMarzo(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionMarzo");
            }

            if ((entity.getProduccionMayo() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionMayo(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionMayo");
            }

            if ((entity.getProduccionNoviembre() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionNoviembre(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionNoviembre");
            }

            if ((entity.getProduccionOctubre() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionOctubre(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionOctubre");
            }

            if ((entity.getProduccionSeptiembre() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionSeptiembre(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionSeptiembre");
            }

            if ((entity.getProduccionTotal() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getProduccionTotal(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "produccionTotal");
            }

            if ((entity.getValorPromedioHrDia() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getValorPromedioHrDia(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorPromedioHrDia");
            }

            if ((entity.getVelocidadEstandar() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getVelocidadEstandar(), 12, 4) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "velocidadEstandar");
            }

            datPlanAnualFabricaDAO.update(entity);

            log.debug("update DatPlanAnualFabrica successful");
        } catch (Exception e) {
            log.error("update DatPlanAnualFabrica failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<DatPlanAnualFabricaDTO> getDataDatPlanAnualFabrica()
        throws Exception {
        try {
            List<DatPlanAnualFabrica> datPlanAnualFabrica = datPlanAnualFabricaDAO.findAll();

            List<DatPlanAnualFabricaDTO> datPlanAnualFabricaDTO = new ArrayList<DatPlanAnualFabricaDTO>();

            for (DatPlanAnualFabrica datPlanAnualFabricaTmp : datPlanAnualFabrica) {
                DatPlanAnualFabricaDTO datPlanAnualFabricaDTO2 = new DatPlanAnualFabricaDTO();

                datPlanAnualFabricaDTO2.setDatPlanAnualFabricaId(datPlanAnualFabricaTmp.getDatPlanAnualFabricaId());
                datPlanAnualFabricaDTO2.setAnio((datPlanAnualFabricaTmp.getAnio() != null)
                    ? datPlanAnualFabricaTmp.getAnio() : null);
                datPlanAnualFabricaDTO2.setCompania((datPlanAnualFabricaTmp.getCompania() != null)
                    ? datPlanAnualFabricaTmp.getCompania() : null);
                datPlanAnualFabricaDTO2.setConsecutivo((datPlanAnualFabricaTmp.getConsecutivo() != null)
                    ? datPlanAnualFabricaTmp.getConsecutivo() : null);
                datPlanAnualFabricaDTO2.setEstado((datPlanAnualFabricaTmp.getEstado() != null)
                    ? datPlanAnualFabricaTmp.getEstado() : null);
                datPlanAnualFabricaDTO2.setFechaAnulacion(datPlanAnualFabricaTmp.getFechaAnulacion());
                datPlanAnualFabricaDTO2.setFechaCreacion(datPlanAnualFabricaTmp.getFechaCreacion());
                datPlanAnualFabricaDTO2.setFechaModificacion(datPlanAnualFabricaTmp.getFechaModificacion());
                datPlanAnualFabricaDTO2.setHorasArranque((datPlanAnualFabricaTmp.getHorasArranque() != null)
                    ? datPlanAnualFabricaTmp.getHorasArranque() : null);
                datPlanAnualFabricaDTO2.setHorasMttoNoProgEjec((datPlanAnualFabricaTmp.getHorasMttoNoProgEjec() != null)
                    ? datPlanAnualFabricaTmp.getHorasMttoNoProgEjec() : null);
                datPlanAnualFabricaDTO2.setHorasMttoNoProgEst((datPlanAnualFabricaTmp.getHorasMttoNoProgEst() != null)
                    ? datPlanAnualFabricaTmp.getHorasMttoNoProgEst() : null);
                datPlanAnualFabricaDTO2.setHorasMttoProgEjec((datPlanAnualFabricaTmp.getHorasMttoProgEjec() != null)
                    ? datPlanAnualFabricaTmp.getHorasMttoProgEjec() : null);
                datPlanAnualFabricaDTO2.setHorasMttoProgEst((datPlanAnualFabricaTmp.getHorasMttoProgEst() != null)
                    ? datPlanAnualFabricaTmp.getHorasMttoProgEst() : null);
                datPlanAnualFabricaDTO2.setHorasPlantaEjec((datPlanAnualFabricaTmp.getHorasPlantaEjec() != null)
                    ? datPlanAnualFabricaTmp.getHorasPlantaEjec() : null);
                datPlanAnualFabricaDTO2.setHorasPlantaEst((datPlanAnualFabricaTmp.getHorasPlantaEst() != null)
                    ? datPlanAnualFabricaTmp.getHorasPlantaEst() : null);
                datPlanAnualFabricaDTO2.setHorasProcesoEjec((datPlanAnualFabricaTmp.getHorasProcesoEjec() != null)
                    ? datPlanAnualFabricaTmp.getHorasProcesoEjec() : null);
                datPlanAnualFabricaDTO2.setHorasProcesoEst((datPlanAnualFabricaTmp.getHorasProcesoEst() != null)
                    ? datPlanAnualFabricaTmp.getHorasProcesoEst() : null);
                datPlanAnualFabricaDTO2.setObservacion((datPlanAnualFabricaTmp.getObservacion() != null)
                    ? datPlanAnualFabricaTmp.getObservacion() : null);
                datPlanAnualFabricaDTO2.setObservacionAnularReg((datPlanAnualFabricaTmp.getObservacionAnularReg() != null)
                    ? datPlanAnualFabricaTmp.getObservacionAnularReg() : null);
                datPlanAnualFabricaDTO2.setOrigenDatos((datPlanAnualFabricaTmp.getOrigenDatos() != null)
                    ? datPlanAnualFabricaTmp.getOrigenDatos() : null);
                datPlanAnualFabricaDTO2.setProduccionAbril((datPlanAnualFabricaTmp.getProduccionAbril() != null)
                    ? datPlanAnualFabricaTmp.getProduccionAbril() : null);
                datPlanAnualFabricaDTO2.setProduccionAgosto((datPlanAnualFabricaTmp.getProduccionAgosto() != null)
                    ? datPlanAnualFabricaTmp.getProduccionAgosto() : null);
                datPlanAnualFabricaDTO2.setProduccionDiciembre((datPlanAnualFabricaTmp.getProduccionDiciembre() != null)
                    ? datPlanAnualFabricaTmp.getProduccionDiciembre() : null);
                datPlanAnualFabricaDTO2.setProduccionEnero((datPlanAnualFabricaTmp.getProduccionEnero() != null)
                    ? datPlanAnualFabricaTmp.getProduccionEnero() : null);
                datPlanAnualFabricaDTO2.setProduccionEstAbril((datPlanAnualFabricaTmp.getProduccionEstAbril() != null)
                    ? datPlanAnualFabricaTmp.getProduccionEstAbril() : null);
                datPlanAnualFabricaDTO2.setProduccionEstAgosto((datPlanAnualFabricaTmp.getProduccionEstAgosto() != null)
                    ? datPlanAnualFabricaTmp.getProduccionEstAgosto() : null);
                datPlanAnualFabricaDTO2.setProduccionEstDiciembre((datPlanAnualFabricaTmp.getProduccionEstDiciembre() != null)
                    ? datPlanAnualFabricaTmp.getProduccionEstDiciembre() : null);
                datPlanAnualFabricaDTO2.setProduccionEstEnero((datPlanAnualFabricaTmp.getProduccionEstEnero() != null)
                    ? datPlanAnualFabricaTmp.getProduccionEstEnero() : null);
                datPlanAnualFabricaDTO2.setProduccionEstFebrero((datPlanAnualFabricaTmp.getProduccionEstFebrero() != null)
                    ? datPlanAnualFabricaTmp.getProduccionEstFebrero() : null);
                datPlanAnualFabricaDTO2.setProduccionEstJulio((datPlanAnualFabricaTmp.getProduccionEstJulio() != null)
                    ? datPlanAnualFabricaTmp.getProduccionEstJulio() : null);
                datPlanAnualFabricaDTO2.setProduccionEstJunio((datPlanAnualFabricaTmp.getProduccionEstJunio() != null)
                    ? datPlanAnualFabricaTmp.getProduccionEstJunio() : null);
                datPlanAnualFabricaDTO2.setProduccionEstMarzo((datPlanAnualFabricaTmp.getProduccionEstMarzo() != null)
                    ? datPlanAnualFabricaTmp.getProduccionEstMarzo() : null);
                datPlanAnualFabricaDTO2.setProduccionEstMayo((datPlanAnualFabricaTmp.getProduccionEstMayo() != null)
                    ? datPlanAnualFabricaTmp.getProduccionEstMayo() : null);
                datPlanAnualFabricaDTO2.setProduccionEstNoviembre((datPlanAnualFabricaTmp.getProduccionEstNoviembre() != null)
                    ? datPlanAnualFabricaTmp.getProduccionEstNoviembre() : null);
                datPlanAnualFabricaDTO2.setProduccionEstOctubre((datPlanAnualFabricaTmp.getProduccionEstOctubre() != null)
                    ? datPlanAnualFabricaTmp.getProduccionEstOctubre() : null);
                datPlanAnualFabricaDTO2.setProduccionEstSeptiembre((datPlanAnualFabricaTmp.getProduccionEstSeptiembre() != null)
                    ? datPlanAnualFabricaTmp.getProduccionEstSeptiembre() : null);
                datPlanAnualFabricaDTO2.setProduccionEstTotal((datPlanAnualFabricaTmp.getProduccionEstTotal() != null)
                    ? datPlanAnualFabricaTmp.getProduccionEstTotal() : null);
                datPlanAnualFabricaDTO2.setProduccionFebrero((datPlanAnualFabricaTmp.getProduccionFebrero() != null)
                    ? datPlanAnualFabricaTmp.getProduccionFebrero() : null);
                datPlanAnualFabricaDTO2.setProduccionJulio((datPlanAnualFabricaTmp.getProduccionJulio() != null)
                    ? datPlanAnualFabricaTmp.getProduccionJulio() : null);
                datPlanAnualFabricaDTO2.setProduccionJunio((datPlanAnualFabricaTmp.getProduccionJunio() != null)
                    ? datPlanAnualFabricaTmp.getProduccionJunio() : null);
                datPlanAnualFabricaDTO2.setProduccionMarzo((datPlanAnualFabricaTmp.getProduccionMarzo() != null)
                    ? datPlanAnualFabricaTmp.getProduccionMarzo() : null);
                datPlanAnualFabricaDTO2.setProduccionMayo((datPlanAnualFabricaTmp.getProduccionMayo() != null)
                    ? datPlanAnualFabricaTmp.getProduccionMayo() : null);
                datPlanAnualFabricaDTO2.setProduccionNoviembre((datPlanAnualFabricaTmp.getProduccionNoviembre() != null)
                    ? datPlanAnualFabricaTmp.getProduccionNoviembre() : null);
                datPlanAnualFabricaDTO2.setProduccionOctubre((datPlanAnualFabricaTmp.getProduccionOctubre() != null)
                    ? datPlanAnualFabricaTmp.getProduccionOctubre() : null);
                datPlanAnualFabricaDTO2.setProduccionSeptiembre((datPlanAnualFabricaTmp.getProduccionSeptiembre() != null)
                    ? datPlanAnualFabricaTmp.getProduccionSeptiembre() : null);
                datPlanAnualFabricaDTO2.setProduccionTotal((datPlanAnualFabricaTmp.getProduccionTotal() != null)
                    ? datPlanAnualFabricaTmp.getProduccionTotal() : null);
                datPlanAnualFabricaDTO2.setUsuarioDigitacion((datPlanAnualFabricaTmp.getUsuarioDigitacion() != null)
                    ? datPlanAnualFabricaTmp.getUsuarioDigitacion() : null);
                datPlanAnualFabricaDTO2.setValorPromedioHrDia((datPlanAnualFabricaTmp.getValorPromedioHrDia() != null)
                    ? datPlanAnualFabricaTmp.getValorPromedioHrDia() : null);
                datPlanAnualFabricaDTO2.setVelocidadEstandar((datPlanAnualFabricaTmp.getVelocidadEstandar() != null)
                    ? datPlanAnualFabricaTmp.getVelocidadEstandar() : null);
                datPlanAnualFabricaDTO.add(datPlanAnualFabricaDTO2);
            }

            return datPlanAnualFabricaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public DatPlanAnualFabrica getDatPlanAnualFabrica(
        Long datPlanAnualFabricaId) throws Exception {
        log.debug("getting DatPlanAnualFabrica instance");

        DatPlanAnualFabrica entity = null;

        try {
            entity = datPlanAnualFabricaDAO.findById(datPlanAnualFabricaId);
        } catch (Exception e) {
            log.error("get DatPlanAnualFabrica failed", e);
            throw new ZMessManager().new FindingException("DatPlanAnualFabrica");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<DatPlanAnualFabrica> findPageDatPlanAnualFabrica(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        List<DatPlanAnualFabrica> entity = null;

        try {
            entity = datPlanAnualFabricaDAO.findPage(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatPlanAnualFabrica Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberDatPlanAnualFabrica() throws Exception {
        Long entity = null;

        try {
            entity = datPlanAnualFabricaDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "DatPlanAnualFabrica Count");
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
    public List<DatPlanAnualFabrica> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<DatPlanAnualFabrica> list = new ArrayList<DatPlanAnualFabrica>();
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
            list = datPlanAnualFabricaDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
