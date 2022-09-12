package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.ListValor;
import co.com.arcosoft.modelo.dto.ListValorDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IListValorLogic {
	public List<ListValor> getListValor() throws Exception;

	/**
	 * Save an new ListValor entity
	 */
	public void saveListValor(ListValor entity) throws Exception;

	/**
	 * Delete an existing ListValor entity
	 *
	 */
	public void deleteListValor(ListValor entity) throws Exception;

	/**
	 * Update an existing ListValor entity
	 *
	 */
	public void updateListValor(ListValor entity) throws Exception;

	/**
	 * Load an existing ListValor entity
	 *
	 */
	public ListValor getListValor(Long listValorId) throws Exception;

	public List<ListValor> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<ListValor> findPageListValor(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberListValor() throws Exception;

	public List<ListValorDTO> getDataListValor() throws Exception;

	public List<ListValorDTO> getDataValorByVariableId(Long variableId) throws Exception;
}
