package co.com.arcosoft.modelo.control;

import java.util.List;
import java.util.Map;

import co.com.arcosoft.modelo.Nivel4Clientesmq;
import co.com.arcosoft.modelo.dto.Nivel4ClientesmqDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface INivel4ClientesmqLogic {
    public List<Nivel4Clientesmq> getNivel4Clientesmq()
        throws Exception;

    /**
         * Save an new Nivel4Clientesmq entity
         */
    public void saveNivel4Clientesmq(Nivel4Clientesmq entity)
        throws Exception;

    /**
         * Delete an existing Nivel4Clientesmq entity
         *
         */
    public void deleteNivel4Clientesmq(Nivel4Clientesmq entity)
        throws Exception;

    /**
        * Update an existing Nivel4Clientesmq entity
        *
        */
    public void updateNivel4Clientesmq(Nivel4Clientesmq entity)
        throws Exception;

    /**
         * Load an existing Nivel4Clientesmq entity
         *
         */
    public Nivel4Clientesmq getNivel4Clientesmq(Long nivel4ClientesmqId)
        throws Exception;

    public List<Nivel4Clientesmq> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Nivel4Clientesmq> findPageNivel4Clientesmq(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberNivel4Clientesmq() throws Exception;

    public List<Nivel4ClientesmqDTO> getDataNivel4Clientesmq()
        throws Exception;
    
    public List<Nivel4ClientesmqDTO> findByCriteriaPageNivel4Clientesmq(int startRow, int pageSize, String sortField, boolean sortOrder,
 			Map<String, Object> filters) throws Exception;

 	public Long findTotalNumberNivel4Clientesmq(Map<String, Object> filters) throws Exception;
 	
 	
}
