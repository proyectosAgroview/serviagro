package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.LogBascula;
import co.com.arcosoft.modelo.dto.LogBasculaDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface ILogBasculaLogic {
    public List<LogBascula> getLogBascula() throws Exception;

    /**
         * Save an new LogBascula entity
         */
    public void saveLogBascula(LogBascula entity) throws Exception;

    /**
         * Delete an existing LogBascula entity
         *
         */
    public void deleteLogBascula(LogBascula entity) throws Exception;

    /**
        * Update an existing LogBascula entity
        *
        */
    public void updateLogBascula(LogBascula entity) throws Exception;

    /**
         * Load an existing LogBascula entity
         *
         */
    public LogBascula getLogBascula(Long logBasculaId)
        throws Exception;

    public List<LogBascula> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<LogBascula> findPageLogBascula(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberLogBascula() throws Exception;

    public List<LogBasculaDTO> getDataLogBascula() throws Exception;
}
