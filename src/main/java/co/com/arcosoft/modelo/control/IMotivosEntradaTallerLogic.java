package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.MotivosEntradaTaller;
import co.com.arcosoft.modelo.dto.MotivosEntradaTallerDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IMotivosEntradaTallerLogic {
	public List<MotivosEntradaTaller> getMotivosEntradaTaller() throws Exception;

	/**
	 * Save an new MotivosEntradaTaller entity
	 */
	public void saveMotivosEntradaTaller(MotivosEntradaTaller entity) throws Exception;

	/**
	 * Delete an existing MotivosEntradaTaller entity
	 *
	 */
	public void deleteMotivosEntradaTaller(MotivosEntradaTaller entity) throws Exception;

	/**
	 * Update an existing MotivosEntradaTaller entity
	 *
	 */
	public void updateMotivosEntradaTaller(MotivosEntradaTaller entity) throws Exception;

	/**
	 * Load an existing MotivosEntradaTaller entity
	 *
	 */
	public MotivosEntradaTaller getMotivosEntradaTaller(Long motivosEntradaTallerId) throws Exception;

	public List<MotivosEntradaTaller> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<MotivosEntradaTaller> findPageMotivosEntradaTaller(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberMotivosEntradaTaller() throws Exception;

	public List<MotivosEntradaTallerDTO> getDataMotivosEntradaTaller() throws Exception;
}
