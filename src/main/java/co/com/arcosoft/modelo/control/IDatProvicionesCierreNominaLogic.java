package co.com.arcosoft.modelo.control;

import co.com.arcosoft.modelo.DatProvicionesCierreNomina;
import co.com.arcosoft.modelo.dto.DatProvicionesCierreNominaDTO;

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
public interface IDatProvicionesCierreNominaLogic {
    public List<DatProvicionesCierreNomina> getDatProvicionesCierreNomina()
        throws Exception;

    /**
         * Save an new DatProvicionesCierreNomina entity
         */
    public void saveDatProvicionesCierreNomina(
        DatProvicionesCierreNomina entity) throws Exception;

    /**
         * Delete an existing DatProvicionesCierreNomina entity
         *
         */
    public void deleteDatProvicionesCierreNomina(
        DatProvicionesCierreNomina entity) throws Exception;

    /**
        * Update an existing DatProvicionesCierreNomina entity
        *
        */
    public void updateDatProvicionesCierreNomina(
        DatProvicionesCierreNomina entity) throws Exception;

    /**
         * Load an existing DatProvicionesCierreNomina entity
         *
         */
    public DatProvicionesCierreNomina getDatProvicionesCierreNomina(
        Long datProvicionesCierreNominaId) throws Exception;

    public List<DatProvicionesCierreNomina> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<DatProvicionesCierreNomina> findPageDatProvicionesCierreNomina(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberDatProvicionesCierreNomina()
        throws Exception;

    public List<DatProvicionesCierreNominaDTO> getDataDatProvicionesCierreNomina()
        throws Exception;
}
