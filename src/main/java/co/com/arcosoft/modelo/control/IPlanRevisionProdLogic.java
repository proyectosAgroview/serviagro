package co.com.arcosoft.modelo.control;

import co.com.arcosoft.modelo.PlanRevisionProd;
import co.com.arcosoft.modelo.dto.PlanRevisionProdDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IPlanRevisionProdLogic {
    public List<PlanRevisionProd> getPlanRevisionProd()
        throws Exception;

    /**
         * Save an new PlanRevisionProd entity
         */
    public void savePlanRevisionProd(PlanRevisionProd entity)
        throws Exception;

    /**
         * Delete an existing PlanRevisionProd entity
         *
         */
    public void deletePlanRevisionProd(PlanRevisionProd entity)
        throws Exception;

    /**
        * Update an existing PlanRevisionProd entity
        *
        */
    public void updatePlanRevisionProd(PlanRevisionProd entity)
        throws Exception;

    /**
         * Load an existing PlanRevisionProd entity
         *
         */
    public PlanRevisionProd getPlanRevisionProd(Long planRevisionProdId)
        throws Exception;

    public List<PlanRevisionProd> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<PlanRevisionProd> findPagePlanRevisionProd(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberPlanRevisionProd() throws Exception;

    public List<PlanRevisionProdDTO> getDataPlanRevisionProd()
        throws Exception;
    
    public List<PlanRevisionProdDTO> getDataPlanRevisionProdByPlanRevision(Long planRecursoId)
            throws Exception;
}
