package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.CajaMenor;
import co.com.arcosoft.modelo.dto.CajaMenorDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface ICajaMenorLogic {
    public List<CajaMenor> getCajaMenor() throws Exception;

    /**
         * Save an new CajaMenor entity
         */
    public void saveCajaMenor(CajaMenor entity) throws Exception;

    /**
         * Delete an existing CajaMenor entity
         *
         */
    public void deleteCajaMenor(CajaMenor entity) throws Exception;

    /**
        * Update an existing CajaMenor entity
        *
        */
    public void updateCajaMenor(CajaMenor entity) throws Exception;

    /**
         * Load an existing CajaMenor entity
         *
         */
    public CajaMenor getCajaMenor(Long cajaMenorId) throws Exception;

    public List<CajaMenor> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<CajaMenor> findPageCajaMenor(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberCajaMenor() throws Exception;

    public List<CajaMenorDTO> getDataCajaMenor() throws Exception;
}
