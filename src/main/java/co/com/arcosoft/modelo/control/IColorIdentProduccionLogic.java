package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.ColorIdentProduccion;
import co.com.arcosoft.modelo.dto.ColorIdentProduccionDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IColorIdentProduccionLogic {
	public List<ColorIdentProduccion> getColorIdentProduccion() throws Exception;

	/**
	 * Save an new ColorIdentProduccion entity
	 */
	public void saveColorIdentProduccion(ColorIdentProduccion entity) throws Exception;

	/**
	 * Delete an existing ColorIdentProduccion entity
	 *
	 */
	public void deleteColorIdentProduccion(ColorIdentProduccion entity) throws Exception;

	/**
	 * Update an existing ColorIdentProduccion entity
	 *
	 */
	public void updateColorIdentProduccion(ColorIdentProduccion entity) throws Exception;

	/**
	 * Load an existing ColorIdentProduccion entity
	 *
	 */
	public ColorIdentProduccion getColorIdentProduccion(Long colorIdentProdId) throws Exception;

	public List<ColorIdentProduccion> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<ColorIdentProduccion> findPageColorIdentProduccion(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberColorIdentProduccion() throws Exception;

	public List<ColorIdentProduccionDTO> getDataColorIdentProduccion() throws Exception;
}
