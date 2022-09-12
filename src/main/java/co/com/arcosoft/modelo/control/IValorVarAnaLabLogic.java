package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.ValorVarAnaLab;
import co.com.arcosoft.modelo.dto.ValorVarAnaLabDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IValorVarAnaLabLogic {
	public List<ValorVarAnaLab> getValorVarAnaLab() throws Exception;

	/**
	 * Save an new ValorVarAnaLab entity
	 */
	public void saveValorVarAnaLab(ValorVarAnaLab entity) throws Exception;

	/**
	 * Delete an existing ValorVarAnaLab entity
	 *
	 */
	public void deleteValorVarAnaLab(ValorVarAnaLab entity) throws Exception;

	/**
	 * Update an existing ValorVarAnaLab entity
	 *
	 */
	public void updateValorVarAnaLab(ValorVarAnaLab entity) throws Exception;

	/**
	 * Load an existing ValorVarAnaLab entity
	 *
	 */
	public ValorVarAnaLab getValorVarAnaLab(Long valorVarAnaLabId) throws Exception;

	public List<ValorVarAnaLab> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<ValorVarAnaLab> findPageValorVarAnaLab(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberValorVarAnaLab() throws Exception;

	public List<ValorVarAnaLabDTO> getDataValorVarAnaLab() throws Exception;
}
