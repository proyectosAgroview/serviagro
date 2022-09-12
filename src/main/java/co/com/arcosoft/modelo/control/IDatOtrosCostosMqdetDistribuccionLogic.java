package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatOtrosCostosMqdetDistribuccion;
import co.com.arcosoft.modelo.dto.DatOtrosCostosMqdetDistribuccionDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IDatOtrosCostosMqdetDistribuccionLogic {
    public List<DatOtrosCostosMqdetDistribuccion> getDatOtrosCostosMqdetDistribuccion()
        throws Exception;

    /**
         * Save an new DatOtrosCostosMqdetDistribuccion entity
         */
    public void saveDatOtrosCostosMqdetDistribuccion(
        DatOtrosCostosMqdetDistribuccion entity) throws Exception;

    /**
         * Delete an existing DatOtrosCostosMqdetDistribuccion entity
         *
         */
    public void deleteDatOtrosCostosMqdetDistribuccion(
        DatOtrosCostosMqdetDistribuccion entity) throws Exception;

    /**
        * Update an existing DatOtrosCostosMqdetDistribuccion entity
        *
        */
    public void updateDatOtrosCostosMqdetDistribuccion(
        DatOtrosCostosMqdetDistribuccion entity) throws Exception;

    /**
         * Load an existing DatOtrosCostosMqdetDistribuccion entity
         *
         */
    public DatOtrosCostosMqdetDistribuccion getDatOtrosCostosMqdetDistribuccion(
        Long datOtrosCostosMqdetDistrId) throws Exception;

    public List<DatOtrosCostosMqdetDistribuccion> findByCriteria(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<DatOtrosCostosMqdetDistribuccion> findPageDatOtrosCostosMqdetDistribuccion(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberDatOtrosCostosMqdetDistribuccion()
        throws Exception;

    public List<DatOtrosCostosMqdetDistribuccionDTO> getDataDatOtrosCostosMqdetDistribuccion()
        throws Exception;
    public List<DatOtrosCostosMqdetDistribuccionDTO> getDataDatOtrosCostosMqdetDistribuccionByDistr(Long idOtrosCostosMq)
            throws Exception;
}
