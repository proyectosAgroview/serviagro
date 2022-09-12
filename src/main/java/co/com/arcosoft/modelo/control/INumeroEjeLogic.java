package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.NumeroEje;
import co.com.arcosoft.modelo.dto.NumeroEjeDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface INumeroEjeLogic {
	public List<NumeroEje> getNumeroEje() throws Exception;

	/**
	 * Save an new NumeroEje entity
	 */
	public void saveNumeroEje(NumeroEje entity) throws Exception;

	/**
	 * Delete an existing NumeroEje entity
	 *
	 */
	public void deleteNumeroEje(NumeroEje entity) throws Exception;

	/**
	 * Update an existing NumeroEje entity
	 *
	 */
	public void updateNumeroEje(NumeroEje entity) throws Exception;

	/**
	 * Load an existing NumeroEje entity
	 *
	 */
	public NumeroEje getNumeroEje(Long numEjeId) throws Exception;

	public List<NumeroEje> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<NumeroEje> findPageNumeroEje(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberNumeroEje() throws Exception;

	public List<NumeroEjeDTO> getDataNumeroEje() throws Exception;
}
