package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatPlanAnualFabrica;
import co.com.arcosoft.modelo.dto.DatPlanAnualFabricaDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IDatPlanAnualFabricaLogic {
    public List<DatPlanAnualFabrica> getDatPlanAnualFabrica()
        throws Exception;

    /**
         * Save an new DatPlanAnualFabrica entity
         */
    public void saveDatPlanAnualFabrica(DatPlanAnualFabrica entity)
        throws Exception;

    /**
         * Delete an existing DatPlanAnualFabrica entity
         *
         */
    public void deleteDatPlanAnualFabrica(DatPlanAnualFabrica entity)
        throws Exception;

    /**
        * Update an existing DatPlanAnualFabrica entity
        *
        */
    public void updateDatPlanAnualFabrica(DatPlanAnualFabrica entity)
        throws Exception;

    /**
         * Load an existing DatPlanAnualFabrica entity
         *
         */
    public DatPlanAnualFabrica getDatPlanAnualFabrica(
        Long datPlanAnualFabricaId) throws Exception;

    public List<DatPlanAnualFabrica> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<DatPlanAnualFabrica> findPageDatPlanAnualFabrica(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberDatPlanAnualFabrica() throws Exception;

    public List<DatPlanAnualFabricaDTO> getDataDatPlanAnualFabrica()
        throws Exception;
}
