package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.NivelPrioridad;
import co.com.arcosoft.modelo.dto.NivelPrioridadDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface INivelPrioridadLogic {
    public List<NivelPrioridad> getNivelPrioridad() throws Exception;

    /**
         * Save an new NivelPrioridad entity
         */
    public void saveNivelPrioridad(NivelPrioridad entity)
        throws Exception;

    /**
         * Delete an existing NivelPrioridad entity
         *
         */
    public void deleteNivelPrioridad(NivelPrioridad entity)
        throws Exception;

    /**
        * Update an existing NivelPrioridad entity
        *
        */
    public void updateNivelPrioridad(NivelPrioridad entity)
        throws Exception;

    /**
         * Load an existing NivelPrioridad entity
         *
         */
    public NivelPrioridad getNivelPrioridad(Long nivelPrioridadId)
        throws Exception;

    public List<NivelPrioridad> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<NivelPrioridad> findPageNivelPrioridad(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberNivelPrioridad() throws Exception;

    public List<NivelPrioridadDTO> getDataNivelPrioridad()
        throws Exception;
}
