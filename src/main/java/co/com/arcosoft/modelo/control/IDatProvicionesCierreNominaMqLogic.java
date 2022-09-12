package co.com.arcosoft.modelo.control;

import co.com.arcosoft.modelo.DatProvicionesCierreNominaMq;
import co.com.arcosoft.modelo.dto.DatProvicionesCierreNominaMqDTO;

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
public interface IDatProvicionesCierreNominaMqLogic {
    public List<DatProvicionesCierreNominaMq> getDatProvicionesCierreNominaMq()
        throws Exception;

    /**
         * Save an new DatProvicionesCierreNominaMq entity
         */
    public void saveDatProvicionesCierreNominaMq(
        DatProvicionesCierreNominaMq entity) throws Exception;

    /**
         * Delete an existing DatProvicionesCierreNominaMq entity
         *
         */
    public void deleteDatProvicionesCierreNominaMq(
        DatProvicionesCierreNominaMq entity) throws Exception;

    /**
        * Update an existing DatProvicionesCierreNominaMq entity
        *
        */
    public void updateDatProvicionesCierreNominaMq(
        DatProvicionesCierreNominaMq entity) throws Exception;

    /**
         * Load an existing DatProvicionesCierreNominaMq entity
         *
         */
    public DatProvicionesCierreNominaMq getDatProvicionesCierreNominaMq(
        Long datProvicionesCierreNominaMqId) throws Exception;

    public List<DatProvicionesCierreNominaMq> findByCriteria(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<DatProvicionesCierreNominaMq> findPageDatProvicionesCierreNominaMq(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberDatProvicionesCierreNominaMq()
        throws Exception;

    public List<DatProvicionesCierreNominaMqDTO> getDataDatProvicionesCierreNominaMq()
        throws Exception;
}
