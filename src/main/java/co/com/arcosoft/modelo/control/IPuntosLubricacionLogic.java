package co.com.arcosoft.modelo.control;

import co.com.arcosoft.modelo.PuntosLubricacion;
import co.com.arcosoft.modelo.dto.PuntosLubricacionDTO;

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
public interface IPuntosLubricacionLogic {
    public List<PuntosLubricacion> getPuntosLubricacion()
        throws Exception;

    /**
         * Save an new PuntosLubricacion entity
         */
    public void savePuntosLubricacion(PuntosLubricacion entity)
        throws Exception;

    /**
         * Delete an existing PuntosLubricacion entity
         *
         */
    public void deletePuntosLubricacion(PuntosLubricacion entity)
        throws Exception;

    /**
        * Update an existing PuntosLubricacion entity
        *
        */
    public void updatePuntosLubricacion(PuntosLubricacion entity)
        throws Exception;

    /**
         * Load an existing PuntosLubricacion entity
         *
         */
    public PuntosLubricacion getPuntosLubricacion(Long puntoLubricacionId)
        throws Exception;

    public List<PuntosLubricacion> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<PuntosLubricacion> findPagePuntosLubricacion(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberPuntosLubricacion() throws Exception;

    public List<PuntosLubricacionDTO> getDataPuntosLubricacion()
        throws Exception;
}
