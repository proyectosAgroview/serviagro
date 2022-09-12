package co.com.arcosoft.modelo.control;

import co.com.arcosoft.modelo.DatCompraMateriaPrima;
import co.com.arcosoft.modelo.dto.DatCompraMateriaPrimaDTO;
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
public interface IDatCompraMateriaPrimaLogic {
    public List<DatCompraMateriaPrima> getDatCompraMateriaPrima()
        throws Exception;

    /**
         * Save an new DatCompraMateriaPrima entity
         */
    public void saveDatCompraMateriaPrima(DatCompraMateriaPrima entity, List<PrecioPromMateriaPrimaDTO> dataDetPrecioProductos)
        throws Exception;

    /**
         * Delete an existing DatCompraMateriaPrima entity
         *
         */
    public void deleteDatCompraMateriaPrima(DatCompraMateriaPrima entity)
        throws Exception;

    /**
        * Update an existing DatCompraMateriaPrima entity
        *
        */
    public void updateDatCompraMateriaPrima(DatCompraMateriaPrima entity, List<PrecioPromMateriaPrimaDTO> dataDetPrecioProductos)
        throws Exception;

    /**
         * Load an existing DatCompraMateriaPrima entity
         *
         */
    public DatCompraMateriaPrima getDatCompraMateriaPrima(
        Long datCompraMateriaPrimaId) throws Exception;

    public List<DatCompraMateriaPrima> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<DatCompraMateriaPrima> findPageDatCompraMateriaPrima(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberDatCompraMateriaPrima()
        throws Exception;

    public List<DatCompraMateriaPrimaDTO> getDataDatCompraMateriaPrima()
        throws Exception;
}
