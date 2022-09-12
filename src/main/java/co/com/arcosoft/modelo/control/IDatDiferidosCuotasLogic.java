package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatDiferidosCuotas;
import co.com.arcosoft.modelo.dto.DatDiferidosCuotasDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IDatDiferidosCuotasLogic {
    public List<DatDiferidosCuotas> getDatDiferidosCuotas()
        throws Exception;

    /**
         * Save an new DatDiferidosCuotas entity
         */
    public void saveDatDiferidosCuotas(DatDiferidosCuotas entity)
        throws Exception;

    /**
         * Delete an existing DatDiferidosCuotas entity
         *
         */
    public void deleteDatDiferidosCuotas(DatDiferidosCuotas entity)
        throws Exception;

    /**
        * Update an existing DatDiferidosCuotas entity
        *
        */
    public void updateDatDiferidosCuotas(DatDiferidosCuotas entity)
        throws Exception;

    /**
         * Load an existing DatDiferidosCuotas entity
         *
         */
    public DatDiferidosCuotas getDatDiferidosCuotas(Long datDiferidosCuotasId)
        throws Exception;

    public List<DatDiferidosCuotas> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<DatDiferidosCuotas> findPageDatDiferidosCuotas(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberDatDiferidosCuotas() throws Exception;

    public List<DatDiferidosCuotasDTO> getDataDatDiferidosCuotas()
        throws Exception;
    
    public List<DatDiferidosCuotasDTO> getDataDatDiferidosCuotasByCuotas(Long datDiferidosId)
            throws Exception ;
       
}
