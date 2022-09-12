package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.CategoriaEquipo;
import co.com.arcosoft.modelo.dto.CategoriaEquipoDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ICategoriaEquipoLogic {
	public List<CategoriaEquipo> getCategoriaEquipo() throws Exception;

	/**
	 * Save an new CategoriaEquipo entity
	 */
	public void saveCategoriaEquipo(CategoriaEquipo entity) throws Exception;

	/**
	 * Delete an existing CategoriaEquipo entity
	 *
	 */
	public void deleteCategoriaEquipo(CategoriaEquipo entity) throws Exception;

	/**
	 * Update an existing CategoriaEquipo entity
	 *
	 */
	public void updateCategoriaEquipo(CategoriaEquipo entity) throws Exception;

	/**
	 * Load an existing CategoriaEquipo entity
	 *
	 */
	public CategoriaEquipo getCategoriaEquipo(Long categEquipId) throws Exception;

	public List<CategoriaEquipo> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<CategoriaEquipo> findPageCategoriaEquipo(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberCategoriaEquipo() throws Exception;

	public List<CategoriaEquipoDTO> getDataCategoriaEquipo() throws Exception;
}
