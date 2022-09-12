package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.ConceptoNomina;
import co.com.arcosoft.modelo.dto.ConceptoNominaDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IConceptoNominaLogic {
	public List<ConceptoNomina> getConceptoNomina() throws Exception;

	/**
	 * Save an new ConceptoNomina entity
	 */
	public void saveConceptoNomina(ConceptoNomina entity) throws Exception;

	/**
	 * Delete an existing ConceptoNomina entity
	 *
	 */
	public void deleteConceptoNomina(ConceptoNomina entity) throws Exception;

	/**
	 * Update an existing ConceptoNomina entity
	 *
	 */
	public void updateConceptoNomina(ConceptoNomina entity) throws Exception;

	/**
	 * Load an existing ConceptoNomina entity
	 *
	 */
	public ConceptoNomina getConceptoNomina(Long ceptoNominaId) throws Exception;

	public List<ConceptoNomina> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<ConceptoNomina> findPageConceptoNomina(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberConceptoNomina() throws Exception;

	public List<ConceptoNominaDTO> getDataConceptoNomina() throws Exception;
}
