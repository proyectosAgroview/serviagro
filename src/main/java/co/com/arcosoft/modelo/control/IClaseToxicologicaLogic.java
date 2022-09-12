package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.ClaseToxicologica;
import co.com.arcosoft.modelo.dto.ClaseToxicologicaDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IClaseToxicologicaLogic {
	public List<ClaseToxicologica> getClaseToxicologica() throws Exception;

	/**
	 * Save an new ClaseToxicologica entity
	 */
	public void saveClaseToxicologica(ClaseToxicologica entity) throws Exception;

	/**
	 * Delete an existing ClaseToxicologica entity
	 *
	 */
	public void deleteClaseToxicologica(ClaseToxicologica entity) throws Exception;

	/**
	 * Update an existing ClaseToxicologica entity
	 *
	 */
	public void updateClaseToxicologica(ClaseToxicologica entity) throws Exception;

	/**
	 * Load an existing ClaseToxicologica entity
	 *
	 */
	public ClaseToxicologica getClaseToxicologica(Long claseToxicId) throws Exception;

	public List<ClaseToxicologica> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<ClaseToxicologica> findPageClaseToxicologica(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberClaseToxicologica() throws Exception;

	public List<ClaseToxicologicaDTO> getDataClaseToxicologica() throws Exception;
}
