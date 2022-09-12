package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.ContBanco;
import co.com.arcosoft.modelo.dto.ContBancoDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IContBancoLogic {
	public List<ContBanco> getContBanco() throws Exception;

	/**
	 * Save an new ContBanco entity
	 */
	public void saveContBanco(ContBanco entity) throws Exception;

	/**
	 * Delete an existing ContBanco entity
	 *
	 */
	public void deleteContBanco(ContBanco entity) throws Exception;

	/**
	 * Update an existing ContBanco entity
	 *
	 */
	public void updateContBanco(ContBanco entity) throws Exception;

	/**
	 * Load an existing ContBanco entity
	 *
	 */
	public ContBanco getContBanco(Long contBancId) throws Exception;

	public List<ContBanco> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<ContBanco> findPageContBanco(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberContBanco() throws Exception;

	public List<ContBancoDTO> getDataContBanco() throws Exception;
}
