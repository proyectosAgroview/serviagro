package co.com.arcosoft.modelo.control;

import co.com.arcosoft.modelo.DatOtrosCostosDetalle;
import co.com.arcosoft.modelo.dto.DatOtrosCostosDetalleDTO;

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
public interface IDatOtrosCostosDetalleLogic {
    public List<DatOtrosCostosDetalle> getDatOtrosCostosDetalle()
        throws Exception;

    /**
         * Save an new DatOtrosCostosDetalle entity
         */
    public void saveDatOtrosCostosDetalle(DatOtrosCostosDetalle entity)
        throws Exception;

    /**
         * Delete an existing DatOtrosCostosDetalle entity
         *
         */
    public void deleteDatOtrosCostosDetalle(DatOtrosCostosDetalle entity)
        throws Exception;

    /**
        * Update an existing DatOtrosCostosDetalle entity
        *
        */
    public void updateDatOtrosCostosDetalle(DatOtrosCostosDetalle entity)
        throws Exception;

    /**
         * Load an existing DatOtrosCostosDetalle entity
         *
         */
    public DatOtrosCostosDetalle getDatOtrosCostosDetalle(
        Long datOtrosCostosDetId) throws Exception;

    public List<DatOtrosCostosDetalle> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<DatOtrosCostosDetalle> findPageDatOtrosCostosDetalle(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberDatOtrosCostosDetalle()
        throws Exception;

    public List<DatOtrosCostosDetalleDTO> getDataDatOtrosCostosDetalle()
        throws Exception;

    public List<DatOtrosCostosDetalleDTO> getDataDatOtrosCostosDetalleByOtrosCostos(Long idOtrosCostos)
        throws Exception;
}
