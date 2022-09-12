package co.com.arcosoft.modelo.control;

import co.com.arcosoft.modelo.DatFacturaServiciosTerceros;
import co.com.arcosoft.modelo.dto.DatFacturaServiciosTercerosDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IDatFacturaServiciosTercerosLogic {
    public List<DatFacturaServiciosTerceros> getDatFacturaServiciosTerceros()
        throws Exception;

    /**
         * Save an new DatFacturaServiciosTerceros entity
         */
    public void saveDatFacturaServiciosTerceros(
        DatFacturaServiciosTerceros entity) throws Exception;

    /**
         * Delete an existing DatFacturaServiciosTerceros entity
         *
         */
    public void deleteDatFacturaServiciosTerceros(
        DatFacturaServiciosTerceros entity) throws Exception;

    /**
        * Update an existing DatFacturaServiciosTerceros entity
        *
        */
    public void updateDatFacturaServiciosTerceros(
        DatFacturaServiciosTerceros entity) throws Exception;

    /**
         * Load an existing DatFacturaServiciosTerceros entity
         *
         */
    public DatFacturaServiciosTerceros getDatFacturaServiciosTerceros(
        Long datFacturaServiciosTercerosId) throws Exception;

    public List<DatFacturaServiciosTerceros> findByCriteria(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<DatFacturaServiciosTerceros> findPageDatFacturaServiciosTerceros(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberDatFacturaServiciosTerceros()
        throws Exception;

    public List<DatFacturaServiciosTercerosDTO> getDataDatFacturaServiciosTerceros()
        throws Exception;
}
