package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatFacturaServicios;
import co.com.arcosoft.modelo.dto.DatFacturaServiciosDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IDatFacturaServiciosLogic {
    public List<DatFacturaServicios> getDatFacturaServicios()
        throws Exception;

    /**
         * Save an new DatFacturaServicios entity
         */
    public void saveDatFacturaServicios(DatFacturaServicios entity)
        throws Exception;

    /**
         * Delete an existing DatFacturaServicios entity
         *
         */
    public void deleteDatFacturaServicios(DatFacturaServicios entity)
        throws Exception;

    /**
        * Update an existing DatFacturaServicios entity
        *
        */
    public void updateDatFacturaServicios(DatFacturaServicios entity)
        throws Exception;

    /**
         * Load an existing DatFacturaServicios entity
         *
         */
    public DatFacturaServicios getDatFacturaServicios(
        Long datFacturaServiciosId) throws Exception;

    public List<DatFacturaServicios> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<DatFacturaServicios> findPageDatFacturaServicios(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberDatFacturaServicios() throws Exception;

    public List<DatFacturaServiciosDTO> getDataDatFacturaServicios()
        throws Exception;
}
