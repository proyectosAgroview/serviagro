package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.ItemsMenu;
import co.com.arcosoft.modelo.dto.ItemsMenuDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IItemsMenuLogic {
	public List<ItemsMenu> getItemsMenu() throws Exception;

	/**
	 * Save an new ItemsMenu entity
	 */
	public void saveItemsMenu(ItemsMenu entity) throws Exception;

	/**
	 * Delete an existing ItemsMenu entity
	 *
	 */
	public void deleteItemsMenu(ItemsMenu entity) throws Exception;

	/**
	 * Update an existing ItemsMenu entity
	 *
	 */
	public void updateItemsMenu(ItemsMenu entity) throws Exception;

	/**
	 * Load an existing ItemsMenu entity
	 *
	 */
	public ItemsMenu getItemsMenu(Long id) throws Exception;

	public List<ItemsMenu> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<ItemsMenu> findPageItemsMenu(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberItemsMenu() throws Exception;

	public List<ItemsMenuDTO> getDataItemsMenu() throws Exception;

	public List<ItemsMenuDTO> getDataItemsMenuGlosario(String modulo) throws Exception;
}
