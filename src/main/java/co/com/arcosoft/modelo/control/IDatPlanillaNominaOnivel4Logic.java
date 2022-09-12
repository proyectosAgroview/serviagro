package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatPlanillaNominaOnivel4;
import co.com.arcosoft.modelo.dto.DatPlanillaNominaOnivel4DTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IDatPlanillaNominaOnivel4Logic {
    public List<DatPlanillaNominaOnivel4> getDatPlanillaNominaOnivel4()
        throws Exception;

    /**
         * Save an new DatPlanillaNominaOnivel4 entity
         */
    public void saveDatPlanillaNominaOnivel4(DatPlanillaNominaOnivel4 entity)
        throws Exception;

    /**
         * Delete an existing DatPlanillaNominaOnivel4 entity
         *
         */
    public void deleteDatPlanillaNominaOnivel4(DatPlanillaNominaOnivel4 entity)
        throws Exception;

    /**
        * Update an existing DatPlanillaNominaOnivel4 entity
        *
        */
    public void updateDatPlanillaNominaOnivel4(DatPlanillaNominaOnivel4 entity)
        throws Exception;

    /**
         * Load an existing DatPlanillaNominaOnivel4 entity
         *
         */
    public DatPlanillaNominaOnivel4 getDatPlanillaNominaOnivel4(
        Long detPlanillaNominaOnivel4Id) throws Exception;

    public List<DatPlanillaNominaOnivel4> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<DatPlanillaNominaOnivel4> findPageDatPlanillaNominaOnivel4(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberDatPlanillaNominaOnivel4()
        throws Exception;

    public List<DatPlanillaNominaOnivel4DTO> getDataDatPlanillaNominaOnivel4()
        throws Exception;
    
    public List<DatPlanillaNominaOnivel4DTO> getDataDatPlanillaNominaOnivel4ByNomina(Long planillaNominaId)  throws Exception;
    
}
