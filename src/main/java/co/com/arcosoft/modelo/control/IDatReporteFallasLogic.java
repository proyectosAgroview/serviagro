package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatReporteFallas;
import co.com.arcosoft.modelo.dto.DatReporteFallasDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IDatReporteFallasLogic {
    public List<DatReporteFallas> getDatReporteFallas()
        throws Exception;

    /**
         * Save an new DatReporteFallas entity
         */
    public void saveDatReporteFallas(DatReporteFallas entity)
        throws Exception;

    /**
         * Delete an existing DatReporteFallas entity
         *
         */
    public void deleteDatReporteFallas(DatReporteFallas entity)
        throws Exception;

    /**
        * Update an existing DatReporteFallas entity
        *
        */
    public void updateDatReporteFallas(DatReporteFallas entity)
        throws Exception;

    /**
         * Load an existing DatReporteFallas entity
         *
         */
    public DatReporteFallas getDatReporteFallas(Long datReporteFallasId)
        throws Exception;

    public List<DatReporteFallas> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<DatReporteFallas> findPageDatReporteFallas(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberDatReporteFallas() throws Exception;

    public List<DatReporteFallasDTO> getDataDatReporteFallas(String modulo)
        throws Exception;
}
