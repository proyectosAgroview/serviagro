package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.Topografia;
import co.com.arcosoft.modelo.dto.TopografiaDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ITopografiaLogic {
	public List<Topografia> getTopografia() throws Exception;

	/**
	 * Save an new Topografia entity
	 */
	public void saveTopografia(Topografia entity) throws Exception;

	/**
	 * Delete an existing Topografia entity
	 *
	 */
	public void deleteTopografia(Topografia entity) throws Exception;

	/**
	 * Update an existing Topografia entity
	 *
	 */
	public void updateTopografia(Topografia entity) throws Exception;

	/**
	 * Load an existing Topografia entity
	 *
	 */
	public Topografia getTopografia(Long topografiaId) throws Exception;

	public List<Topografia> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Topografia> findPageTopografia(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberTopografia() throws Exception;

	public List<TopografiaDTO> getDataTopografia() throws Exception;
}
