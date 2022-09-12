package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatReqProductosDet;
import co.com.arcosoft.modelo.dto.DatReqProductosDetDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IDatReqProductosDetLogic {
    public List<DatReqProductosDet> getDatReqProductosDet()
        throws Exception;

    /**
         * Save an new DatReqProductosDet entity
         */
    public void saveDatReqProductosDet(DatReqProductosDet entity)
        throws Exception;

    /**
         * Delete an existing DatReqProductosDet entity
         *
         */
    public void deleteDatReqProductosDet(DatReqProductosDet entity)
        throws Exception;

    /**
        * Update an existing DatReqProductosDet entity
        *
        */
    public void updateDatReqProductosDet(DatReqProductosDet entity)
        throws Exception;

    /**
         * Load an existing DatReqProductosDet entity
         *
         */
    public DatReqProductosDet getDatReqProductosDet(Long datReqProductosDetId)
        throws Exception;

    public List<DatReqProductosDet> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<DatReqProductosDet> findPageDatReqProductosDet(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberDatReqProductosDet() throws Exception;

    public List<DatReqProductosDetDTO> getDataDatReqProductosDet()
        throws Exception;
    
    public List<DatReqProductosDetDTO> getDataDatReqProductosDetByProductos(Long datReqProductosId)
            throws Exception;
}
