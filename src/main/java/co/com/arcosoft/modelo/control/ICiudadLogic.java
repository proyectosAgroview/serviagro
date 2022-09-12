package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.Ciudad;
import co.com.arcosoft.modelo.dto.CiudadDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ICiudadLogic {
	public List<Ciudad> getCiudad() throws Exception;

	/**
	 * Save an new Ciudad entity
	 */
	public void saveCiudad(Ciudad entity) throws Exception;

	/**
	 * Delete an existing Ciudad entity
	 *
	 */
	public void deleteCiudad(Ciudad entity) throws Exception;

	/**
	 * Update an existing Ciudad entity
	 *
	 */
	public void updateCiudad(Ciudad entity) throws Exception;

	/**
	 * Load an existing Ciudad entity
	 *
	 */
	public Ciudad getCiudad(Long ciudadId) throws Exception;

	public List<Ciudad> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Ciudad> findPageCiudad(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberCiudad() throws Exception;

	public List<CiudadDTO> getDataCiudad() throws Exception;
}
