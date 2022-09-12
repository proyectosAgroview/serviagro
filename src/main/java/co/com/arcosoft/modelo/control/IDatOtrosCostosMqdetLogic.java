package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatOtrosCostosMqdet;
import co.com.arcosoft.modelo.dto.DatOtrosCostosMqdetDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IDatOtrosCostosMqdetLogic {
    public List<DatOtrosCostosMqdet> getDatOtrosCostosMqdet()
        throws Exception;

    /**
         * Save an new DatOtrosCostosMqdet entity
         */
    public void saveDatOtrosCostosMqdet(DatOtrosCostosMqdet entity)
        throws Exception;

    /**
         * Delete an existing DatOtrosCostosMqdet entity
         *
         */
    public void deleteDatOtrosCostosMqdet(DatOtrosCostosMqdet entity)
        throws Exception;

    /**
        * Update an existing DatOtrosCostosMqdet entity
        *
        */
    public void updateDatOtrosCostosMqdet(DatOtrosCostosMqdet entity)
        throws Exception;

    /**
         * Load an existing DatOtrosCostosMqdet entity
         *
         */
    public DatOtrosCostosMqdet getDatOtrosCostosMqdet(
        Long datOtrosCostosMqdetId) throws Exception;

    public List<DatOtrosCostosMqdet> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<DatOtrosCostosMqdet> findPageDatOtrosCostosMqdet(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberDatOtrosCostosMqdet() throws Exception;

    public List<DatOtrosCostosMqdetDTO> getDataDatOtrosCostosMqdet()
        throws Exception;
    
    public List<DatOtrosCostosMqdetDTO> getDataDatOtrosCostosMqdetByMaquinaria(Long idOtrosCostosMq)
            throws Exception;
    
}
