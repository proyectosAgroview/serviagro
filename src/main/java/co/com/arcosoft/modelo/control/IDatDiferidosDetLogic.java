package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatDiferidosDet;
import co.com.arcosoft.modelo.dto.DatDiferidosDetDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IDatDiferidosDetLogic {
    public List<DatDiferidosDet> getDatDiferidosDet() throws Exception;

    /**
         * Save an new DatDiferidosDet entity
         */
    public void saveDatDiferidosDet(DatDiferidosDet entity)
        throws Exception;

    /**
         * Delete an existing DatDiferidosDet entity
         *
         */
    public void deleteDatDiferidosDet(DatDiferidosDet entity)
        throws Exception;

    /**
        * Update an existing DatDiferidosDet entity
        *
        */
    public void updateDatDiferidosDet(DatDiferidosDet entity)
        throws Exception;

    /**
         * Load an existing DatDiferidosDet entity
         *
         */
    public DatDiferidosDet getDatDiferidosDet(Long datDiferidosDetId)
        throws Exception;

    public List<DatDiferidosDet> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<DatDiferidosDet> findPageDatDiferidosDet(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberDatDiferidosDet() throws Exception;

    public List<DatDiferidosDetDTO> getDataDatDiferidosDet()
        throws Exception;
    
    public List<DatDiferidosDetDTO> getDataDatDiferidosDetByDiferidos(Long datDiferidosId)
            throws Exception;
    
   
}
