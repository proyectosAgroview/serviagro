package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.Vereda;
import co.com.arcosoft.modelo.dto.VeredaDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IVeredaLogic {
	public List<Vereda> getVereda() throws Exception;

	/**
	 * Save an new Vereda entity
	 */
	public void saveVereda(Vereda entity) throws Exception;

	/**
	 * Delete an existing Vereda entity
	 *
	 */
	public void deleteVereda(Vereda entity) throws Exception;

	/**
	 * Update an existing Vereda entity
	 *
	 */
	public void updateVereda(Vereda entity) throws Exception;

	/**
	 * Load an existing Vereda entity
	 *
	 */
	public Vereda getVereda(Long veredaId) throws Exception;

	public List<Vereda> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Vereda> findPageVereda(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberVereda() throws Exception;

	public List<VeredaDTO> getDataVereda() throws Exception;
}
