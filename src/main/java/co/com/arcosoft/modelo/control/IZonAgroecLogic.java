package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.ZonAgroec;
import co.com.arcosoft.modelo.dto.ZonAgroecDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IZonAgroecLogic {
	public List<ZonAgroec> getZonAgroec() throws Exception;

	/**
	 * Save an new ZonAgroec entity
	 */
	public void saveZonAgroec(ZonAgroec entity) throws Exception;

	/**
	 * Delete an existing ZonAgroec entity
	 *
	 */
	public void deleteZonAgroec(ZonAgroec entity) throws Exception;

	/**
	 * Update an existing ZonAgroec entity
	 *
	 */
	public void updateZonAgroec(ZonAgroec entity) throws Exception;

	/**
	 * Load an existing ZonAgroec entity
	 *
	 */
	public ZonAgroec getZonAgroec(Long zonAgroec) throws Exception;

	public List<ZonAgroec> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<ZonAgroec> findPageZonAgroec(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberZonAgroec() throws Exception;

	public List<ZonAgroecDTO> getDataZonAgroec() throws Exception;
}
