package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatCajaMenorDet;
import co.com.arcosoft.modelo.dto.DatCajaMenorDetDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IDatCajaMenorDetLogic {
    public List<DatCajaMenorDet> getDatCajaMenorDet() throws Exception;

    /**
         * Save an new DatCajaMenorDet entity
         */
    public void saveDatCajaMenorDet(DatCajaMenorDet entity)
        throws Exception;

    /**
         * Delete an existing DatCajaMenorDet entity
         *
         */
    public void deleteDatCajaMenorDet(DatCajaMenorDet entity)
        throws Exception;

    /**
        * Update an existing DatCajaMenorDet entity
        *
        */
    public void updateDatCajaMenorDet(DatCajaMenorDet entity)
        throws Exception;

    /**
         * Load an existing DatCajaMenorDet entity
         *
         */
    public DatCajaMenorDet getDatCajaMenorDet(Long datCajaMenordetId)
        throws Exception;

    public List<DatCajaMenorDet> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<DatCajaMenorDet> findPageDatCajaMenorDet(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberDatCajaMenorDet() throws Exception;

    public List<DatCajaMenorDetDTO> getDataDatCajaMenorDet()
        throws Exception;
    
    public List<DatCajaMenorDetDTO> getDataDatCajaMenorDetByCaja(Long datCajaMenorId)
            throws Exception ;
}
