package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.ValorVarAnaTrans;
import co.com.arcosoft.modelo.dto.ValorVarAnaTransDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IValorVarAnaTransLogic {
	public List<ValorVarAnaTrans> getValorVarAnaTrans() throws Exception;

	/**
	 * Save an new ValorVarAnaTrans entity
	 */
	public void saveValorVarAnaTrans(ValorVarAnaTrans entity) throws Exception;

	/**
	 * Delete an existing ValorVarAnaTrans entity
	 *
	 */
	public void deleteValorVarAnaTrans(ValorVarAnaTrans entity) throws Exception;

	/**
	 * Update an existing ValorVarAnaTrans entity
	 *
	 */
	public void updateValorVarAnaTrans(ValorVarAnaTrans entity) throws Exception;

	/**
	 * Load an existing ValorVarAnaTrans entity
	 *
	 */
	public ValorVarAnaTrans getValorVarAnaTrans(Long valorVarAnaTransId) throws Exception;

	public List<ValorVarAnaTrans> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<ValorVarAnaTrans> findPageValorVarAnaTrans(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberValorVarAnaTrans() throws Exception;

	public List<ValorVarAnaTransDTO> getDataValorVarAnaTrans() throws Exception;
}
