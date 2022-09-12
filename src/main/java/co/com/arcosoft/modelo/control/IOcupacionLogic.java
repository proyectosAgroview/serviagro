package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.Ocupacion;
import co.com.arcosoft.modelo.dto.OcupacionDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IOcupacionLogic {
	public List<Ocupacion> getOcupacion() throws Exception;

	/**
	 * Save an new Ocupacion entity
	 */
	public void saveOcupacion(Ocupacion entity) throws Exception;

	/**
	 * Delete an existing Ocupacion entity
	 *
	 */
	public void deleteOcupacion(Ocupacion entity) throws Exception;

	/**
	 * Update an existing Ocupacion entity
	 *
	 */
	public void updateOcupacion(Ocupacion entity) throws Exception;

	/**
	 * Load an existing Ocupacion entity
	 *
	 */
	public Ocupacion getOcupacion(Long ocupacionId) throws Exception;

	public List<Ocupacion> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Ocupacion> findPageOcupacion(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberOcupacion() throws Exception;

	public List<OcupacionDTO> getDataOcupacion() throws Exception;
}
