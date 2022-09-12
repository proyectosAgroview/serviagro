package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatPlanServiciosMq;
import co.com.arcosoft.modelo.dto.DatPlanServiciosMqDTO;
import co.com.arcosoft.modelo.dto.DatPlanServiciosMqdetDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IDatPlanServiciosMqLogic {
    public List<DatPlanServiciosMq> getDatPlanServiciosMq()
        throws Exception;

    /**
         * Save an new DatPlanServiciosMq entity
         */
    public void saveDatPlanServiciosMq(DatPlanServiciosMq entity ,List<DatPlanServiciosMqdetDTO> dataPlanServDet)
        throws Exception;

    /**
         * Delete an existing DatPlanServiciosMq entity
         *
         */
    public void deleteDatPlanServiciosMq(DatPlanServiciosMq entity)
        throws Exception;

    /**
        * Update an existing DatPlanServiciosMq entity
        *
        */
    public void updateDatPlanServiciosMq(DatPlanServiciosMq entity, List<DatPlanServiciosMqdetDTO> dataPlanServDet)
        throws Exception;

    /**
         * Load an existing DatPlanServiciosMq entity
         *
         */
    public DatPlanServiciosMq getDatPlanServiciosMq(Long datPlanServiciosMqId)
        throws Exception;

    public List<DatPlanServiciosMq> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<DatPlanServiciosMq> findPageDatPlanServiciosMq(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberDatPlanServiciosMq() throws Exception;

    public List<DatPlanServiciosMqDTO> getDataDatPlanServiciosMq()
        throws Exception;
}
