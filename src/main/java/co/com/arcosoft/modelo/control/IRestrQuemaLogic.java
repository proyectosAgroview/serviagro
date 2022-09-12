package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.RestrQuema;
import co.com.arcosoft.modelo.dto.RestrQuemaDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IRestrQuemaLogic {
	public List<RestrQuema> getRestrQuema() throws Exception;

	/**
	 * Save an new RestrQuema entity
	 */
	public void saveRestrQuema(RestrQuema entity) throws Exception;

	/**
	 * Delete an existing RestrQuema entity
	 *
	 */
	public void deleteRestrQuema(RestrQuema entity) throws Exception;

	/**
	 * Update an existing RestrQuema entity
	 *
	 */
	public void updateRestrQuema(RestrQuema entity) throws Exception;

	/**
	 * Load an existing RestrQuema entity
	 *
	 */
	public RestrQuema getRestrQuema(Long restQuema) throws Exception;

	public List<RestrQuema> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<RestrQuema> findPageRestrQuema(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberRestrQuema() throws Exception;

	public List<RestrQuemaDTO> getDataRestrQuema() throws Exception;
}
