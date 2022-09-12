package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.ZonaGeografica;
import co.com.arcosoft.modelo.dto.ZonaGeograficaDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IZonaGeograficaLogic {
	public List<ZonaGeografica> getZonaGeografica() throws Exception;

	/**
	 * Save an new ZonaGeografica entity
	 */
	public void saveZonaGeografica(ZonaGeografica entity) throws Exception;

	/**
	 * Delete an existing ZonaGeografica entity
	 *
	 */
	public void deleteZonaGeografica(ZonaGeografica entity) throws Exception;

	/**
	 * Update an existing ZonaGeografica entity
	 *
	 */
	public void updateZonaGeografica(ZonaGeografica entity) throws Exception;

	/**
	 * Load an existing ZonaGeografica entity
	 *
	 */
	public ZonaGeografica getZonaGeografica(Long zonaGeograficaId) throws Exception;

	public List<ZonaGeografica> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<ZonaGeografica> findPageZonaGeografica(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberZonaGeografica() throws Exception;

	public List<ZonaGeograficaDTO> getDataZonaGeografica() throws Exception;
}
