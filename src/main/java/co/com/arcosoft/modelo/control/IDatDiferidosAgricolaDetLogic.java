package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatDiferidosAgricolaDet;
import co.com.arcosoft.modelo.dto.DatDiferidosAgricolaDetDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IDatDiferidosAgricolaDetLogic {
    public List<DatDiferidosAgricolaDet> getDatDiferidosAgricolaDet()
        throws Exception;

    /**
         * Save an new DatDiferidosAgricolaDet entity
         */
    public void saveDatDiferidosAgricolaDet(DatDiferidosAgricolaDet entity)
        throws Exception;

    /**
         * Delete an existing DatDiferidosAgricolaDet entity
         *
         */
    public void deleteDatDiferidosAgricolaDet(DatDiferidosAgricolaDet entity)
        throws Exception;

    /**
        * Update an existing DatDiferidosAgricolaDet entity
        *
        */
    public void updateDatDiferidosAgricolaDet(DatDiferidosAgricolaDet entity)
        throws Exception;

    /**
         * Load an existing DatDiferidosAgricolaDet entity
         *
         */
    public DatDiferidosAgricolaDet getDatDiferidosAgricolaDet(
        Long datDiferidosAgricolaDetId) throws Exception;

    public List<DatDiferidosAgricolaDet> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<DatDiferidosAgricolaDet> findPageDatDiferidosAgricolaDet(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberDatDiferidosAgricolaDet()
        throws Exception;

    public List<DatDiferidosAgricolaDetDTO> getDataDatDiferidosAgricolaDet()
        throws Exception;
    
    public List<DatDiferidosAgricolaDetDTO> getDataDatDiferidosAgricolaDetByDatDiferidosAgricola(Long datDiferidosAgricolaId)
            throws Exception;
}
