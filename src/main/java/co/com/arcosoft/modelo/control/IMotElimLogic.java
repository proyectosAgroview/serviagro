package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.MotElim;
import co.com.arcosoft.modelo.dto.MotElimDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IMotElimLogic {
	public List<MotElim> getMotElim() throws Exception;

	/**
	 * Save an new MotElim entity
	 */
	public void saveMotElim(MotElim entity) throws Exception;

	/**
	 * Delete an existing MotElim entity
	 *
	 */
	public void deleteMotElim(MotElim entity) throws Exception;

	/**
	 * Update an existing MotElim entity
	 *
	 */
	public void updateMotElim(MotElim entity) throws Exception;

	/**
	 * Load an existing MotElim entity
	 *
	 */
	public MotElim getMotElim(Long motElimId) throws Exception;

	public List<MotElim> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<MotElim> findPageMotElim(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberMotElim() throws Exception;

	public List<MotElimDTO> getDataMotElim() throws Exception;
}
