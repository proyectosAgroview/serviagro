package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.TablaAnaliticaDetalle;
import co.com.arcosoft.modelo.dto.TablaAnaliticaDetalleDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface ITablaAnaliticaDetalleLogic {
    public List<TablaAnaliticaDetalle> getTablaAnaliticaDetalle()
        throws Exception;

    /**
         * Save an new TablaAnaliticaDetalle entity
         */
    public void saveTablaAnaliticaDetalle(TablaAnaliticaDetalle entity)
        throws Exception;

    /**
         * Delete an existing TablaAnaliticaDetalle entity
         *
         */
    public void deleteTablaAnaliticaDetalle(TablaAnaliticaDetalle entity)
        throws Exception;

    /**
        * Update an existing TablaAnaliticaDetalle entity
        *
        */
    public void updateTablaAnaliticaDetalle(TablaAnaliticaDetalle entity)
        throws Exception;

    /**
         * Load an existing TablaAnaliticaDetalle entity
         *
         */
    public TablaAnaliticaDetalle getTablaAnaliticaDetalle(
        Long tablaAnaliticaDetalleId) throws Exception;

    public List<TablaAnaliticaDetalle> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<TablaAnaliticaDetalle> findPageTablaAnaliticaDetalle(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTablaAnaliticaDetalle()
        throws Exception;

    public List<TablaAnaliticaDetalleDTO> getDataTablaAnaliticaDetalle()
        throws Exception;
    
    public List<TablaAnaliticaDetalleDTO> getDataTablaAnaliticaDetalleByTablaAnalitica(Long tablaAnaliticaId)
    		throws Exception;
}
