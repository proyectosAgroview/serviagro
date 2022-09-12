package co.com.arcosoft.modelo.control;

import co.com.arcosoft.modelo.UbicacionesAlmacen;
import co.com.arcosoft.modelo.dto.UbicacionesAlmacenDTO;

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
public interface IUbicacionesAlmacenLogic {
    public List<UbicacionesAlmacen> getUbicacionesAlmacen()
        throws Exception;

    /**
         * Save an new UbicacionesAlmacen entity
         */
    public void saveUbicacionesAlmacen(UbicacionesAlmacen entity)
        throws Exception;

    /**
         * Delete an existing UbicacionesAlmacen entity
         *
         */
    public void deleteUbicacionesAlmacen(UbicacionesAlmacen entity)
        throws Exception;

    /**
        * Update an existing UbicacionesAlmacen entity
        *
        */
    public void updateUbicacionesAlmacen(UbicacionesAlmacen entity)
        throws Exception;

    /**
         * Load an existing UbicacionesAlmacen entity
         *
         */
    public UbicacionesAlmacen getUbicacionesAlmacen(Long ubicacionesAlmacen)
        throws Exception;

    public List<UbicacionesAlmacen> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<UbicacionesAlmacen> findPageUbicacionesAlmacen(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberUbicacionesAlmacen() throws Exception;

    public List<UbicacionesAlmacenDTO> getDataUbicacionesAlmacen()
        throws Exception;
}
