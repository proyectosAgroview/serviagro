package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.AnaLaboratorio;
import co.com.arcosoft.modelo.dto.AnaLaboratorioDTO;
import co.com.arcosoft.modelo.dto.AnaLaboratorioVariableDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IAnaLaboratorioLogic {
    public List<AnaLaboratorio> getAnaLaboratorio() throws Exception;

    /**
         * Save an new AnaLaboratorio entity
         */
    public void saveAnaLaboratorio(AnaLaboratorio entity, List<AnaLaboratorioVariableDTO> dataVariablesLab)
        throws Exception;

    /**
         * Delete an existing AnaLaboratorio entity
         *
         */
    public void deleteAnaLaboratorio(AnaLaboratorio entity)
        throws Exception;

    /**
        * Update an existing AnaLaboratorio entity
        *
        */
    public void updateAnaLaboratorio(AnaLaboratorio entity, List<AnaLaboratorioVariableDTO> dataVariablesLab)
        throws Exception;

    /**
         * Load an existing AnaLaboratorio entity
         *
         */
    public AnaLaboratorio getAnaLaboratorio(Long anaLabId)
        throws Exception;

    public List<AnaLaboratorio> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<AnaLaboratorio> findPageAnaLaboratorio(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberAnaLaboratorio() throws Exception;

    public List<AnaLaboratorioDTO> getDataAnaLaboratorio()
        throws Exception;
}
