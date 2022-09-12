package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.PlanRevisionEquipoRecursos;
import co.com.arcosoft.modelo.dto.PlanRevisionEquipoRecursosDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IPlanRevisionEquipoRecursosLogic {
    public List<PlanRevisionEquipoRecursos> getPlanRevisionEquipoRecursos()
        throws Exception;

    /**
         * Save an new PlanRevisionEquipoRecursos entity
         */
    public void savePlanRevisionEquipoRecursos(
        PlanRevisionEquipoRecursos entity) throws Exception;

    /**
         * Delete an existing PlanRevisionEquipoRecursos entity
         *
         */
    public void deletePlanRevisionEquipoRecursos(
        PlanRevisionEquipoRecursos entity) throws Exception;

    /**
        * Update an existing PlanRevisionEquipoRecursos entity
        *
        */
    public void updatePlanRevisionEquipoRecursos(
        PlanRevisionEquipoRecursos entity) throws Exception;

    /**
         * Load an existing PlanRevisionEquipoRecursos entity
         *
         */
    public PlanRevisionEquipoRecursos getPlanRevisionEquipoRecursos(
        Long planRevisionEquipoRecursosId) throws Exception;

    public List<PlanRevisionEquipoRecursos> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<PlanRevisionEquipoRecursos> findPagePlanRevisionEquipoRecursos(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberPlanRevisionEquipoRecursos()
        throws Exception;

    public List<PlanRevisionEquipoRecursosDTO> getDataPlanRevisionEquipoRecursos()
        throws Exception;
    public List<PlanRevisionEquipoRecursosDTO> getDataPlanRevisionEquipoRecursosByRecursos(Long equipoRcursosId)
            throws Exception ;
}
