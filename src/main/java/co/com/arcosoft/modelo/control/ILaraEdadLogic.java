package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.LaraEdad;
import co.com.arcosoft.modelo.dto.LaraEdadDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ILaraEdadLogic {
	public List<LaraEdad> getLaraEdad() throws Exception;

	/**
	 * Save an new LaraEdad entity
	 */
	public void saveLaraEdad(LaraEdad entity) throws Exception;

	/**
	 * Delete an existing LaraEdad entity
	 *
	 */
	public void deleteLaraEdad(LaraEdad entity) throws Exception;

	/**
	 * Update an existing LaraEdad entity
	 *
	 */
	public void updateLaraEdad(LaraEdad entity) throws Exception;

	/**
	 * Load an existing LaraEdad entity
	 *
	 */
	public LaraEdad getLaraEdad(Long laraEdadId) throws Exception;

	public List<LaraEdad> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<LaraEdad> findPageLaraEdad(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberLaraEdad() throws Exception;

	public List<LaraEdadDTO> getDataLaraEdad() throws Exception;
}
