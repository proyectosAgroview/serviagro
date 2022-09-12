package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.CultivoFitosanidad;
import co.com.arcosoft.modelo.CultivoFitosanidadId;
import co.com.arcosoft.modelo.dto.CultivoFitosanidadDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ICultivoFitosanidadLogic {
	public List<CultivoFitosanidad> getCultivoFitosanidad() throws Exception;

	/**
	 * Save an new CultivoFitosanidad entity
	 */
	public void saveCultivoFitosanidad(CultivoFitosanidad entity) throws Exception;

	/**
	 * Delete an existing CultivoFitosanidad entity
	 *
	 */
	public void deleteCultivoFitosanidad(CultivoFitosanidad entity) throws Exception;

	/**
	 * Update an existing CultivoFitosanidad entity
	 *
	 */
	public void updateCultivoFitosanidad(CultivoFitosanidad entity) throws Exception;

	/**
	 * Load an existing CultivoFitosanidad entity
	 *
	 */
	public CultivoFitosanidad getCultivoFitosanidad(CultivoFitosanidadId id) throws Exception;

	public List<CultivoFitosanidad> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<CultivoFitosanidad> findPageCultivoFitosanidad(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberCultivoFitosanidad() throws Exception;

	public List<CultivoFitosanidadDTO> getDataCultivoFitosanidad() throws Exception;
}
