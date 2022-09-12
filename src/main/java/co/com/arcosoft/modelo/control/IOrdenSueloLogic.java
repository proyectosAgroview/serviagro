package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.OrdenSuelo;
import co.com.arcosoft.modelo.dto.OrdenSueloDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IOrdenSueloLogic {
	public List<OrdenSuelo> getOrdenSuelo() throws Exception;

	/**
	 * Save an new OrdenSuelo entity
	 */
	public void saveOrdenSuelo(OrdenSuelo entity) throws Exception;

	/**
	 * Delete an existing OrdenSuelo entity
	 *
	 */
	public void deleteOrdenSuelo(OrdenSuelo entity) throws Exception;

	/**
	 * Update an existing OrdenSuelo entity
	 *
	 */
	public void updateOrdenSuelo(OrdenSuelo entity) throws Exception;

	/**
	 * Load an existing OrdenSuelo entity
	 *
	 */
	public OrdenSuelo getOrdenSuelo(Long ordenSuelo) throws Exception;

	public List<OrdenSuelo> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<OrdenSuelo> findPageOrdenSuelo(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberOrdenSuelo() throws Exception;

	public List<OrdenSueloDTO> getDataOrdenSuelo() throws Exception;
}
