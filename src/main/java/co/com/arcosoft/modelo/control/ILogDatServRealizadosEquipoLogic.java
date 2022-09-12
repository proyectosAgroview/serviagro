package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.LogDatServRealizadosEquipo;
import co.com.arcosoft.modelo.dto.LogDatServRealizadosEquipoDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface ILogDatServRealizadosEquipoLogic {
    public List<LogDatServRealizadosEquipo> getLogDatServRealizadosEquipo()
        throws Exception;

    /**
         * Save an new LogDatServRealizadosEquipo entity
         */
    public void saveLogDatServRealizadosEquipo(
        LogDatServRealizadosEquipo entity) throws Exception;

    /**
         * Delete an existing LogDatServRealizadosEquipo entity
         *
         */
    public void deleteLogDatServRealizadosEquipo(
        LogDatServRealizadosEquipo entity) throws Exception;

    /**
        * Update an existing LogDatServRealizadosEquipo entity
        *
        */
    public void updateLogDatServRealizadosEquipo(
        LogDatServRealizadosEquipo entity) throws Exception;

    /**
         * Load an existing LogDatServRealizadosEquipo entity
         *
         */
    public LogDatServRealizadosEquipo getLogDatServRealizadosEquipo(
        Long logDatServRealizadosEquipoId) throws Exception;

    public List<LogDatServRealizadosEquipo> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<LogDatServRealizadosEquipo> findPageLogDatServRealizadosEquipo(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberLogDatServRealizadosEquipo()
        throws Exception;

    public List<LogDatServRealizadosEquipoDTO> getDataLogDatServRealizadosEquipo()
        throws Exception;
}
