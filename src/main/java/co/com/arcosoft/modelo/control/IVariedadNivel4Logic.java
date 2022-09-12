package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.VariedadNivel4;
import co.com.arcosoft.modelo.dto.VariedadNivel4DTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IVariedadNivel4Logic {
	public List<VariedadNivel4> getVariedadNivel4() throws Exception;

	/**
	 * Save an new VariedadNivel4 entity
	 */
	public void saveVariedadNivel4(VariedadNivel4 entity) throws Exception;

	/**
	 * Delete an existing VariedadNivel4 entity
	 *
	 */
	public void deleteVariedadNivel4(VariedadNivel4 entity) throws Exception;

	/**
	 * Update an existing VariedadNivel4 entity
	 *
	 */
	public void updateVariedadNivel4(VariedadNivel4 entity) throws Exception;

	/**
	 * Load an existing VariedadNivel4 entity
	 *
	 */
	public VariedadNivel4 getVariedadNivel4(Long variedadNivel4Id) throws Exception;

	public List<VariedadNivel4> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<VariedadNivel4> findPageVariedadNivel4(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberVariedadNivel4() throws Exception;

	public List<VariedadNivel4DTO> getDataVariedadNivel4() throws Exception;

	public List<VariedadNivel4DTO> getDataVariedadNivel4ByNivel4Id(Long niveldId) throws Exception;
}
