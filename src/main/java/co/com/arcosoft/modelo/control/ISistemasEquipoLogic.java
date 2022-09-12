package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.SistemasEquipo;
import co.com.arcosoft.modelo.dto.SistemasEquipoDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface ISistemasEquipoLogic {
    public List<SistemasEquipo> getSistemasEquipo() throws Exception;

    /**
         * Save an new SistemasEquipo entity
         */
    public void saveSistemasEquipo(SistemasEquipo entity)
        throws Exception;

    /**
         * Delete an existing SistemasEquipo entity
         *
         */
    public void deleteSistemasEquipo(SistemasEquipo entity)
        throws Exception;

    /**
        * Update an existing SistemasEquipo entity
        *
        */
    public void updateSistemasEquipo(SistemasEquipo entity)
        throws Exception;

    /**
         * Load an existing SistemasEquipo entity
         *
         */
    public SistemasEquipo getSistemasEquipo(Long sistemasEquipoId)
        throws Exception;

    public List<SistemasEquipo> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<SistemasEquipo> findPageSistemasEquipo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberSistemasEquipo() throws Exception;

    public List<SistemasEquipoDTO> getDataSistemasEquipo()
        throws Exception;
}
