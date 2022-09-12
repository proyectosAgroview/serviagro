package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.CompartimientosEquipo;
import co.com.arcosoft.modelo.dto.CompartimientosEquipoDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface ICompartimientosEquipoLogic {
    public List<CompartimientosEquipo> getCompartimientosEquipo()
        throws Exception;

    /**
         * Save an new CompartimientosEquipo entity
         */
    public void saveCompartimientosEquipo(CompartimientosEquipo entity)
        throws Exception;

    /**
         * Delete an existing CompartimientosEquipo entity
         *
         */
    public void deleteCompartimientosEquipo(CompartimientosEquipo entity)
        throws Exception;

    /**
        * Update an existing CompartimientosEquipo entity
        *
        */
    public void updateCompartimientosEquipo(CompartimientosEquipo entity)
        throws Exception;

    /**
         * Load an existing CompartimientosEquipo entity
         *
         */
    public CompartimientosEquipo getCompartimientosEquipo(
        Long compartimientosEquipoId) throws Exception;

    public List<CompartimientosEquipo> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<CompartimientosEquipo> findPageCompartimientosEquipo(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberCompartimientosEquipo()
        throws Exception;

    public List<CompartimientosEquipoDTO> getDataCompartimientosEquipo()
        throws Exception;
}
