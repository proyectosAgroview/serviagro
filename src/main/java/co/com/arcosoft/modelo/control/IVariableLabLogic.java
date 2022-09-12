package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.VariableLab;
import co.com.arcosoft.modelo.dto.VariableLabDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IVariableLabLogic {
    public List<VariableLab> getVariableLab() throws Exception;

    /**
         * Save an new VariableLab entity
         */
    public void saveVariableLab(VariableLab entity) throws Exception;

    /**
         * Delete an existing VariableLab entity
         *
         */
    public void deleteVariableLab(VariableLab entity) throws Exception;

    /**
        * Update an existing VariableLab entity
        *
        */
    public void updateVariableLab(VariableLab entity) throws Exception;

    /**
         * Load an existing VariableLab entity
         *
         */
    public VariableLab getVariableLab(Long variableLabId)
        throws Exception;

    public List<VariableLab> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<VariableLab> findPageVariableLab(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberVariableLab() throws Exception;

    public List<VariableLabDTO> getDataVariableLab() throws Exception;
    
}
