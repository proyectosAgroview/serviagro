package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.ModeloEquipo;
import co.com.arcosoft.modelo.dto.ModeloEquipoDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IModeloEquipoLogic {
	public List<ModeloEquipo> getModeloEquipo() throws Exception;

	/**
	 * Save an new ModeloEquipo entity
	 */
	public void saveModeloEquipo(ModeloEquipo entity) throws Exception;

	/**
	 * Delete an existing ModeloEquipo entity
	 *
	 */
	public void deleteModeloEquipo(ModeloEquipo entity) throws Exception;

	/**
	 * Update an existing ModeloEquipo entity
	 *
	 */
	public void updateModeloEquipo(ModeloEquipo entity) throws Exception;

	/**
	 * Load an existing ModeloEquipo entity
	 *
	 */
	public ModeloEquipo getModeloEquipo(Long modeloEquipoId) throws Exception;

	public List<ModeloEquipo> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<ModeloEquipo> findPageModeloEquipo(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberModeloEquipo() throws Exception;

	public List<ModeloEquipoDTO> getDataModeloEquipo() throws Exception;
}
