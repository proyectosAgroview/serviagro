package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.PlanRevisionEquipoDet;
import co.com.arcosoft.modelo.dto.PlanRevisionEquipoDetDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IPlanRevisionEquipoDetLogic {
    public List<PlanRevisionEquipoDet> getPlanRevisionEquipoDet()
        throws Exception;

    /**
         * Save an new PlanRevisionEquipoDet entity
         */
    public void savePlanRevisionEquipoDet(PlanRevisionEquipoDet entity)
        throws Exception;

    /**
         * Delete an existing PlanRevisionEquipoDet entity
         *
         */
    public void deletePlanRevisionEquipoDet(PlanRevisionEquipoDet entity)
        throws Exception;

    /**
        * Update an existing PlanRevisionEquipoDet entity
        *
        */
    public void updatePlanRevisionEquipoDet(PlanRevisionEquipoDet entity)
        throws Exception;

    /**
         * Load an existing PlanRevisionEquipoDet entity
         *
         */
    public PlanRevisionEquipoDet getPlanRevisionEquipoDet(
        Long planRevisionEquipoDetId) throws Exception;

    public List<PlanRevisionEquipoDet> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<PlanRevisionEquipoDet> findPagePlanRevisionEquipoDet(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberPlanRevisionEquipoDet()
        throws Exception;

    public List<PlanRevisionEquipoDetDTO> getDataPlanRevisionEquipoDet()
        throws Exception;

    public List<PlanRevisionEquipoDetDTO> getDataPlanRevisionEquipoDetByEquipo(Long planRevisionEquipoId)
            throws Exception;
    
    public List<PlanRevisionEquipoDetDTO> getDataPlanRevisionEquipoDetByEquipoId(Long equipoId)
            throws Exception;
}
