package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.TablaAnalitica;
import co.com.arcosoft.modelo.dto.TablaAnaliticaDTO;
import co.com.arcosoft.modelo.dto.TablaAnaliticaDetalleDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface ITablaAnaliticaLogic {
    public List<TablaAnalitica> getTablaAnalitica() throws Exception;

    /**
         * Save an new TablaAnalitica entity
         */
    public void saveTablaAnalitica(TablaAnalitica entity, List<TablaAnaliticaDetalleDTO> dataTabAna)
        throws Exception;

    /**
         * Delete an existing TablaAnalitica entity
         *
         */
    public void deleteTablaAnalitica(TablaAnalitica entity)
        throws Exception;

    /**
        * Update an existing TablaAnalitica entity
        *
        */
    public void updateTablaAnalitica(TablaAnalitica entity, List<TablaAnaliticaDetalleDTO> dataTabAna)
        throws Exception;

    /**
         * Load an existing TablaAnalitica entity
         *
         */
    public TablaAnalitica getTablaAnalitica(Long tablaAnaliticaId)
        throws Exception;

    public List<TablaAnalitica> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<TablaAnalitica> findPageTablaAnalitica(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTablaAnalitica() throws Exception;

    public List<TablaAnaliticaDTO> getDataTablaAnalitica()
        throws Exception;
}
