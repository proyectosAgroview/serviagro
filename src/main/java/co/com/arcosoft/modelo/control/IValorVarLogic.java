package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.ValorVar;
import co.com.arcosoft.modelo.dto.ValorVarDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IValorVarLogic {
	public List<ValorVar> getValorVar() throws Exception;

	/**
	 * Save an new ValorVar entity
	 */
	public void saveValorVar(ValorVar entity) throws Exception;

	/**
	 * Delete an existing ValorVar entity
	 *
	 */
	public void deleteValorVar(ValorVar entity) throws Exception;

	/**
	 * Update an existing ValorVar entity
	 *
	 */
	public void updateValorVar(ValorVar entity) throws Exception;

	/**
	 * Load an existing ValorVar entity
	 *
	 */
	public ValorVar getValorVar(Long valorVarId) throws Exception;

	public List<ValorVar> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<ValorVar> findPageValorVar(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberValorVar() throws Exception;

	public List<ValorVarDTO> getDataValorVar() throws Exception;

	public List<ValorVarDTO> getDataValorVarByValor(Long datSanVegId) throws Exception;

}
