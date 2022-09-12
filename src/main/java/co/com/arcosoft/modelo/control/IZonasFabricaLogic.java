package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.ZonasFabrica;
import co.com.arcosoft.modelo.dto.ZonasFabricaDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IZonasFabricaLogic {
    public List<ZonasFabrica> getZonasFabrica() throws Exception;

    /**
         * Save an new ZonasFabrica entity
         */
    public void saveZonasFabrica(ZonasFabrica entity) throws Exception;

    /**
         * Delete an existing ZonasFabrica entity
         *
         */
    public void deleteZonasFabrica(ZonasFabrica entity)
        throws Exception;

    /**
        * Update an existing ZonasFabrica entity
        *
        */
    public void updateZonasFabrica(ZonasFabrica entity)
        throws Exception;

    /**
         * Load an existing ZonasFabrica entity
         *
         */
    public ZonasFabrica getZonasFabrica(Long zonasFabricaId)
        throws Exception;

    public List<ZonasFabrica> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<ZonasFabrica> findPageZonasFabrica(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberZonasFabrica() throws Exception;

    public List<ZonasFabricaDTO> getDataZonasFabrica()
        throws Exception;
}
