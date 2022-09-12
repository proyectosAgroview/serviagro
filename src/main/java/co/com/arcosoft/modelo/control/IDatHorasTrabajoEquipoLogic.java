package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatHorasTrabajoEquipo;
import co.com.arcosoft.modelo.dto.DatHorasTrabajoEquipoDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IDatHorasTrabajoEquipoLogic {
    public List<DatHorasTrabajoEquipo> getDatHorasTrabajoEquipo()
        throws Exception;

    /**
         * Save an new DatHorasTrabajoEquipo entity
         */
    public void saveDatHorasTrabajoEquipo(DatHorasTrabajoEquipo entity)
        throws Exception;

    /**
         * Delete an existing DatHorasTrabajoEquipo entity
         *
         */
    public void deleteDatHorasTrabajoEquipo(DatHorasTrabajoEquipo entity)
        throws Exception;

    /**
        * Update an existing DatHorasTrabajoEquipo entity
        *
        */
    public void updateDatHorasTrabajoEquipo(DatHorasTrabajoEquipo entity)
        throws Exception;

    /**
         * Load an existing DatHorasTrabajoEquipo entity
         *
         */
    public DatHorasTrabajoEquipo getDatHorasTrabajoEquipo(
        Long datHorasTrabajoEquipoId) throws Exception;

    public List<DatHorasTrabajoEquipo> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<DatHorasTrabajoEquipo> findPageDatHorasTrabajoEquipo(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberDatHorasTrabajoEquipo()
        throws Exception;

    public List<DatHorasTrabajoEquipoDTO> getDataDatHorasTrabajoEquipo(String modulo) throws Exception;
}
