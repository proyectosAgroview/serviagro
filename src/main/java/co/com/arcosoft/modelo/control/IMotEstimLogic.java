package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.MotEstim;
import co.com.arcosoft.modelo.dto.MotEstimDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IMotEstimLogic {
	public List<MotEstim> getMotEstim() throws Exception;

	/**
	 * Save an new MotEstim entity
	 */
	public void saveMotEstim(MotEstim entity) throws Exception;

	/**
	 * Delete an existing MotEstim entity
	 *
	 */
	public void deleteMotEstim(MotEstim entity) throws Exception;

	/**
	 * Update an existing MotEstim entity
	 *
	 */
	public void updateMotEstim(MotEstim entity) throws Exception;

	/**
	 * Load an existing MotEstim entity
	 *
	 */
	public MotEstim getMotEstim(Long motEstimId) throws Exception;

	public List<MotEstim> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<MotEstim> findPageMotEstim(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberMotEstim() throws Exception;

	public List<MotEstimDTO> getDataMotEstim() throws Exception;
}
