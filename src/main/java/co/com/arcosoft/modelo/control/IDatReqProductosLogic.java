package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatReqProductos;
import co.com.arcosoft.modelo.dto.DatReqProductosDTO;
import co.com.arcosoft.modelo.dto.DatReqProductosDetDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IDatReqProductosLogic {
    public List<DatReqProductos> getDatReqProductos() throws Exception;

    /**
         * Save an new DatReqProductos entity
         */
   

    /**
         * Delete an existing DatReqProductos entity
         *
         */
    public void deleteDatReqProductos(DatReqProductos entity)
        throws Exception;

    /**
        * Update an existing DatReqProductos entity
        *
        */
  

    /**
         * Load an existing DatReqProductos entity
         *
         */
    public DatReqProductos getDatReqProductos(Long datReqProductosId)
        throws Exception;

    public List<DatReqProductos> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<DatReqProductos> findPageDatReqProductos(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberDatReqProductos() throws Exception;

    public List<DatReqProductosDTO> getDataDatReqProductos()
        throws Exception;
    
    
    public void updateDatReqProductos(DatReqProductos entity, List<DatReqProductosDetDTO> dataReq)
         throws Exception ;
 		
 public void saveDatReqProductos(DatReqProductos entity, List<DatReqProductosDetDTO> dataReq)
         throws Exception ;
 		
}
