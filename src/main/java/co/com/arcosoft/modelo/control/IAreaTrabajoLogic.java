package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.AreaTrabajo;
import co.com.arcosoft.modelo.dto.AreaTrabajoDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IAreaTrabajoLogic {
    public List<AreaTrabajo> getAreaTrabajo() throws Exception;

    /**
         * Save an new AreaTrabajo entity
         */
    public void saveAreaTrabajo(AreaTrabajo entity) throws Exception;

    /**
         * Delete an existing AreaTrabajo entity
         *
         */
    public void deleteAreaTrabajo(AreaTrabajo entity) throws Exception;

    /**
        * Update an existing AreaTrabajo entity
        *
        */
    public void updateAreaTrabajo(AreaTrabajo entity) throws Exception;

    /**
         * Load an existing AreaTrabajo entity
         *
         */
    public AreaTrabajo getAreaTrabajo(Long areaTrabajoId)
        throws Exception;

    public List<AreaTrabajo> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<AreaTrabajo> findPageAreaTrabajo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberAreaTrabajo() throws Exception;

    public List<AreaTrabajoDTO> getDataAreaTrabajo() throws Exception;
}
