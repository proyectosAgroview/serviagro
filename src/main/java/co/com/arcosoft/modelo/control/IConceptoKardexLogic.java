package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.ConceptoKardex;
import co.com.arcosoft.modelo.dto.ConceptoKardexDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IConceptoKardexLogic {
    public List<ConceptoKardex> getConceptoKardex() throws Exception;

    /**
         * Save an new ConceptoKardex entity
         */
    public void saveConceptoKardex(ConceptoKardex entity)
        throws Exception;

    /**
         * Delete an existing ConceptoKardex entity
         *
         */
    public void deleteConceptoKardex(ConceptoKardex entity)
        throws Exception;

    /**
        * Update an existing ConceptoKardex entity
        *
        */
    public void updateConceptoKardex(ConceptoKardex entity)
        throws Exception;

    /**
         * Load an existing ConceptoKardex entity
         *
         */
    public ConceptoKardex getConceptoKardex(Long conceptoKardexId)
        throws Exception;

    public List<ConceptoKardex> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<ConceptoKardex> findPageConceptoKardex(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberConceptoKardex() throws Exception;

    public List<ConceptoKardexDTO> getDataConceptoKardex()
        throws Exception;
}
