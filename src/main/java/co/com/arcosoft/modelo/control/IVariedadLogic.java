package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.Variedad;
import co.com.arcosoft.modelo.dto.VariedadDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IVariedadLogic {
	public List<Variedad> getVariedad() throws Exception;

	/**
	 * Save an new Variedad entity
	 */
	public void saveVariedad(Variedad entity) throws Exception;

	/**
	 * Delete an existing Variedad entity
	 *
	 */
	public void deleteVariedad(Variedad entity) throws Exception;

	/**
	 * Update an existing Variedad entity
	 *
	 */
	public void updateVariedad(Variedad entity) throws Exception;

	/**
	 * Load an existing Variedad entity
	 *
	 */
	public Variedad getVariedad(Long variedId) throws Exception;

	public List<Variedad> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Variedad> findPageVariedad(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberVariedad() throws Exception;

	public List<VariedadDTO> getDataVariedad() throws Exception;
}
