package co.com.arcosoft.modelo.control;

import co.com.arcosoft.modelo.TarifasArl;
import co.com.arcosoft.modelo.dto.TarifasArlDTO;

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
public interface ITarifasArlLogic {
    public List<TarifasArl> getTarifasArl() throws Exception;

    /**
         * Save an new TarifasArl entity
         */
    public void saveTarifasArl(TarifasArl entity) throws Exception;

    /**
         * Delete an existing TarifasArl entity
         *
         */
    public void deleteTarifasArl(TarifasArl entity) throws Exception;

    /**
        * Update an existing TarifasArl entity
        *
        */
    public void updateTarifasArl(TarifasArl entity) throws Exception;

    /**
         * Load an existing TarifasArl entity
         *
         */
    public TarifasArl getTarifasArl(Long tarifasArlId)
        throws Exception;

    public List<TarifasArl> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<TarifasArl> findPageTarifasArl(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTarifasArl() throws Exception;

    public List<TarifasArlDTO> getDataTarifasArl() throws Exception;
}
