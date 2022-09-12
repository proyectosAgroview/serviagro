package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.EntBanc;
import co.com.arcosoft.modelo.dto.EntBancDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IEntBancLogic {
	public List<EntBanc> getEntBanc() throws Exception;

	/**
	 * Save an new EntBanc entity
	 */
	public void saveEntBanc(EntBanc entity) throws Exception;

	/**
	 * Delete an existing EntBanc entity
	 *
	 */
	public void deleteEntBanc(EntBanc entity) throws Exception;

	/**
	 * Update an existing EntBanc entity
	 *
	 */
	public void updateEntBanc(EntBanc entity) throws Exception;

	/**
	 * Load an existing EntBanc entity
	 *
	 */
	public EntBanc getEntBanc(Long entBancId) throws Exception;

	public List<EntBanc> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<EntBanc> findPageEntBanc(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberEntBanc() throws Exception;

	public List<EntBancDTO> getDataEntBanc() throws Exception;
}
