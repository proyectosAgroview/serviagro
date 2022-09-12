package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatDiferidosCuotasAgricolas;
import co.com.arcosoft.modelo.dto.DatDiferidosCuotasAgricolasDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IDatDiferidosCuotasAgricolasLogic {
    public List<DatDiferidosCuotasAgricolas> getDatDiferidosCuotasAgricolas()
        throws Exception;

    /**
         * Save an new DatDiferidosCuotasAgricolas entity
         */
    public void saveDatDiferidosCuotasAgricolas(
        DatDiferidosCuotasAgricolas entity) throws Exception;

    /**
         * Delete an existing DatDiferidosCuotasAgricolas entity
         *
         */
    public void deleteDatDiferidosCuotasAgricolas(
        DatDiferidosCuotasAgricolas entity) throws Exception;

    /**
        * Update an existing DatDiferidosCuotasAgricolas entity
        *
        */
    public void updateDatDiferidosCuotasAgricolas(
        DatDiferidosCuotasAgricolas entity) throws Exception;

    /**
         * Load an existing DatDiferidosCuotasAgricolas entity
         *
         */
    public DatDiferidosCuotasAgricolas getDatDiferidosCuotasAgricolas(
        Long datDiferidosCuotasAgricolasId) throws Exception;

    public List<DatDiferidosCuotasAgricolas> findByCriteria(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<DatDiferidosCuotasAgricolas> findPageDatDiferidosCuotasAgricolas(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberDatDiferidosCuotasAgricolas()
        throws Exception;

    public List<DatDiferidosCuotasAgricolasDTO> getDataDatDiferidosCuotasAgricolas()
        throws Exception;
    
    public List<DatDiferidosCuotasAgricolasDTO> getDataDatDiferidosCuotasAgricolasByDatDiferidosAgricola(Long datDiferidosAgricolaId)
            throws Exception;
}
