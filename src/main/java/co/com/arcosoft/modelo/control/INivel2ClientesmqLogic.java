package co.com.arcosoft.modelo.control;

import java.util.List;
import java.util.Map;

import co.com.arcosoft.modelo.Nivel2Clientesmq;
import co.com.arcosoft.modelo.dto.Nivel2ClientesmqDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface INivel2ClientesmqLogic {
    public List<Nivel2Clientesmq> getNivel2Clientesmq()
        throws Exception;

    /**
         * Save an new Nivel2Clientesmq entity
         */
    public void saveNivel2Clientesmq(Nivel2Clientesmq entity)
        throws Exception;

    /**
         * Delete an existing Nivel2Clientesmq entity
         *
         */
    public void deleteNivel2Clientesmq(Nivel2Clientesmq entity)
        throws Exception;

    /**
        * Update an existing Nivel2Clientesmq entity
        *
        */
    public void updateNivel2Clientesmq(Nivel2Clientesmq entity)
        throws Exception;

    /**
         * Load an existing Nivel2Clientesmq entity
         *
         */
    public Nivel2Clientesmq getNivel2Clientesmq(Long nivel2ClientesmqId)
        throws Exception;

    public List<Nivel2Clientesmq> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Nivel2Clientesmq> findPageNivel2Clientesmq(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberNivel2Clientesmq() throws Exception;

    public List<Nivel2ClientesmqDTO> getDataNivel2Clientesmq()
        throws Exception;
    
    public List<Nivel2ClientesmqDTO> findByCriteriaPageNivel2Clientesmq(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) throws Exception;

	public Long findTotalNumberNivel2Clientesmq(Map<String, Object> filters) throws Exception;
}
