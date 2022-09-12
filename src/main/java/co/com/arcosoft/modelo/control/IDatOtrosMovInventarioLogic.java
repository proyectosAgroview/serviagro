package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatOtrosMovInventario;
import co.com.arcosoft.modelo.dto.DatOtrosMovInventarioDTO;
import co.com.arcosoft.modelo.dto.PrecioPromProdDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IDatOtrosMovInventarioLogic {
    public List<DatOtrosMovInventario> getDatOtrosMovInventario()
        throws Exception;

    /**
         * Save an new DatOtrosMovInventario entity
         */

    /**
         * Delete an existing DatOtrosMovInventario entity
         *
         */
    public void deleteDatOtrosMovInventario(DatOtrosMovInventario entity)
        throws Exception;

    /**
        * Update an existing DatOtrosMovInventario entity
        *
        */
    /**
         * Load an existing DatOtrosMovInventario entity
         *
         */
    public DatOtrosMovInventario getDatOtrosMovInventario(
        Long datOtrosMovInventarioId) throws Exception;

    public List<DatOtrosMovInventario> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<DatOtrosMovInventario> findPageDatOtrosMovInventario(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberDatOtrosMovInventario()
        throws Exception;

    public List<DatOtrosMovInventarioDTO> getDataDatOtrosMovInventario()
        throws Exception;

    public void saveDatOtrosMovInventario(DatOtrosMovInventario entity, List<PrecioPromProdDTO> dataDetPrecioProductos)
            throws Exception ;

        public void updateDatOtrosMovInventario(DatOtrosMovInventario entity, List<PrecioPromProdDTO> dataDetPrecioProductos)
            throws Exception ;

}
