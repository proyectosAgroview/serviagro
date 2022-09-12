package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.Variable;
import co.com.arcosoft.modelo.dto.ListValorDTO;
import co.com.arcosoft.modelo.dto.RangoValorDTO;
import co.com.arcosoft.modelo.dto.VariableDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IVariableLogic {
	public List<Variable> getVariable() throws Exception;

	/**
	 * Save an new Variable entity
	 */
	public void saveVariable(Variable entity, List<ListValorDTO> dataValores, List<RangoValorDTO> dataRango)
			throws Exception;

	/**
	 * Delete an existing Variable entity
	 *
	 */
	public void deleteVariable(Variable entity) throws Exception;

	/**
	 * Update an existing Variable entity
	 *
	 */
	public void updateVariable(Variable entity, List<ListValorDTO> dataValores, List<RangoValorDTO> dataRango)
			throws Exception;

	/**
	 * Load an existing Variable entity
	 *
	 */
	public Variable getVariable(Long variableId) throws Exception;

	public List<Variable> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Variable> findPageVariable(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberVariable() throws Exception;

	public List<VariableDTO> getDataVariable() throws Exception;

}
