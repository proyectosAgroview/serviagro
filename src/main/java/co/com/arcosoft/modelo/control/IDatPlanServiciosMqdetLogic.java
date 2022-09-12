package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatPlanServiciosMqdet;
import co.com.arcosoft.modelo.dto.DatPlanServiciosMqdetDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IDatPlanServiciosMqdetLogic {
    public List<DatPlanServiciosMqdet> getDatPlanServiciosMqdet()
        throws Exception;

    /**
         * Save an new DatPlanServiciosMqdet entity
         */
    public void saveDatPlanServiciosMqdet(DatPlanServiciosMqdet entity)
        throws Exception;

    /**
         * Delete an existing DatPlanServiciosMqdet entity
         *
         */
    public void deleteDatPlanServiciosMqdet(DatPlanServiciosMqdet entity)
        throws Exception;

    /**
        * Update an existing DatPlanServiciosMqdet entity
        *
        */
    public void updateDatPlanServiciosMqdet(DatPlanServiciosMqdet entity)
        throws Exception;

    /**
         * Load an existing DatPlanServiciosMqdet entity
         *
         */
    public DatPlanServiciosMqdet getDatPlanServiciosMqdet(
        Long datPlanServiciosMqdetId) throws Exception;

    public List<DatPlanServiciosMqdet> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<DatPlanServiciosMqdet> findPageDatPlanServiciosMqdet(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberDatPlanServiciosMqdet()
        throws Exception;

    public List<DatPlanServiciosMqdetDTO> getDataDatPlanServiciosMqdet()
        throws Exception;
    
    public List<DatPlanServiciosMqdetDTO> getDataDatPlanServiciosMqdetByPlan(Long datPlanServiciosMqId)
            throws Exception;
}
