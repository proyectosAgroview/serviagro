package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.IngredienteActivo;
import co.com.arcosoft.modelo.dto.IngredienteActivoDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IIngredienteActivoLogic {
	public List<IngredienteActivo> getIngredienteActivo() throws Exception;

	/**
	 * Save an new IngredienteActivo entity
	 */
	public void saveIngredienteActivo(IngredienteActivo entity) throws Exception;

	/**
	 * Delete an existing IngredienteActivo entity
	 *
	 */
	public void deleteIngredienteActivo(IngredienteActivo entity) throws Exception;

	/**
	 * Update an existing IngredienteActivo entity
	 *
	 */
	public void updateIngredienteActivo(IngredienteActivo entity) throws Exception;

	/**
	 * Load an existing IngredienteActivo entity
	 *
	 */
	public IngredienteActivo getIngredienteActivo(Long ingredienteActId) throws Exception;

	public List<IngredienteActivo> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<IngredienteActivo> findPageIngredienteActivo(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberIngredienteActivo() throws Exception;

	public List<IngredienteActivoDTO> getDataIngredienteActivo() throws Exception;
}
