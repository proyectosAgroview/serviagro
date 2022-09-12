package co.com.arcosoft.modelo.control;

import co.com.arcosoft.modelo.PrecioPromMateriaPrima;
import co.com.arcosoft.modelo.dto.PrecioPromMateriaPrimaDTO;

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
public interface IPrecioPromMateriaPrimaLogic {
    public List<PrecioPromMateriaPrima> getPrecioPromMateriaPrima()
        throws Exception;

    /**
         * Save an new PrecioPromMateriaPrima entity
         */
    public void savePrecioPromMateriaPrima(PrecioPromMateriaPrima entity)
        throws Exception;

    /**
         * Delete an existing PrecioPromMateriaPrima entity
         *
         */
    public void deletePrecioPromMateriaPrima(PrecioPromMateriaPrima entity)
        throws Exception;

    /**
        * Update an existing PrecioPromMateriaPrima entity
        *
        */
    public void updatePrecioPromMateriaPrima(PrecioPromMateriaPrima entity)
        throws Exception;

    /**
         * Load an existing PrecioPromMateriaPrima entity
         *
         */
    public PrecioPromMateriaPrima getPrecioPromMateriaPrima(
        Long precioPromMateriaPrimaId) throws Exception;

    public List<PrecioPromMateriaPrima> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<PrecioPromMateriaPrima> findPagePrecioPromMateriaPrima(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberPrecioPromMateriaPrima()
        throws Exception;

    public List<PrecioPromMateriaPrimaDTO> getDataPrecioPromMateriaPrima()
        throws Exception;

    public List<PrecioPromMateriaPrimaDTO> getDataPrecioPromMateriaPrimaByCompra(Long datCompraMateriaPrimaId)
        throws Exception;

    public List<PrecioPromMateriaPrimaDTO> getDataPrecioPromMateriaPrimaByInventario(Long datOtrosMovInventarioId)
        throws Exception;
}
