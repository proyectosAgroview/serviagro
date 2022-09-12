package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.Fitosanidad;
import co.com.arcosoft.modelo.dto.FitosanidadDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IFitosanidadLogic {
	public List<Fitosanidad> getFitosanidad() throws Exception;

	/**
	 * Save an new Fitosanidad entity
	 */
	public void saveFitosanidad(Fitosanidad entity, List<String> selectedCultivos) throws Exception;

	/**
	 * Delete an existing Fitosanidad entity
	 *
	 */
	public void deleteFitosanidad(Fitosanidad entity) throws Exception;

	/**
	 * Update an existing Fitosanidad entity
	 *
	 */
	public void updateFitosanidad(Fitosanidad entity, List<String> selectedCultivos) throws Exception;

	/**
	 * Load an existing Fitosanidad entity
	 *
	 */
	public Fitosanidad getFitosanidad(Long fitosanidadId) throws Exception;

	public List<Fitosanidad> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Fitosanidad> findPageFitosanidad(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberFitosanidad() throws Exception;

	public List<FitosanidadDTO> getDataFitosanidad() throws Exception;
}
