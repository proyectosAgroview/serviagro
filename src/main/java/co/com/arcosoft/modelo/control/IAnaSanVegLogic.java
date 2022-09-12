package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.AnaSanVeg;
import co.com.arcosoft.modelo.dto.AnaSanVegDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IAnaSanVegLogic {
	public List<AnaSanVeg> getAnaSanVeg() throws Exception;

	/**
	 * Save an new AnaSanVeg entity
	 */
	public void saveAnaSanVeg(AnaSanVeg entity, List<String> selectedCultivos) throws Exception;

	/**
	 * Delete an existing AnaSanVeg entity
	 *
	 */
	public void deleteAnaSanVeg(AnaSanVeg entity) throws Exception;

	/**
	 * Update an existing AnaSanVeg entity
	 *
	 */
	public void updateAnaSanVeg(AnaSanVeg entity, List<String> selectedCultivos) throws Exception;

	/**
	 * Load an existing AnaSanVeg entity
	 *
	 */
	public AnaSanVeg getAnaSanVeg(Long anaSanVegId) throws Exception;

	public List<AnaSanVeg> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<AnaSanVeg> findPageAnaSanVeg(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberAnaSanVeg() throws Exception;

	public List<AnaSanVegDTO> getDataAnaSanVeg() throws Exception;
}
