package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.AnaLaboratorioVariable;
import co.com.arcosoft.modelo.dto.AnaLaboratorioVariableDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IAnaLaboratorioVariableLogic {
    public List<AnaLaboratorioVariable> getAnaLaboratorioVariable()
        throws Exception;

    /**
         * Save an new AnaLaboratorioVariable entity
         */
    public void saveAnaLaboratorioVariable(AnaLaboratorioVariable entity)
        throws Exception;

    /**
         * Delete an existing AnaLaboratorioVariable entity
         *
         */
    public void deleteAnaLaboratorioVariable(AnaLaboratorioVariable entity)
        throws Exception;

    /**
        * Update an existing AnaLaboratorioVariable entity
        *
        */
    public void updateAnaLaboratorioVariable(AnaLaboratorioVariable entity)
        throws Exception;

    /**
         * Load an existing AnaLaboratorioVariable entity
         *
         */
    public AnaLaboratorioVariable getAnaLaboratorioVariable(
        Long anaLaboratorioVariableId) throws Exception;

    public List<AnaLaboratorioVariable> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<AnaLaboratorioVariable> findPageAnaLaboratorioVariable(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberAnaLaboratorioVariable()
        throws Exception;

    public List<AnaLaboratorioVariableDTO> getDataAnaLaboratorioVariable()
        throws Exception;
    
    public List<AnaLaboratorioVariableDTO> getDataAnaLaboratorioVariableByVariable(Long idAnalisis)
            throws Exception;
}
