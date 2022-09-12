package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.TarifaProfesion;
import co.com.arcosoft.modelo.dto.TarifaProfesionDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ITarifaProfesionLogic {
	public List<TarifaProfesion> getTarifaProfesion() throws Exception;

	/**
	 * Save an new TarifaProfesion entity
	 */
	public void saveTarifaProfesion(TarifaProfesion entity) throws Exception;

	/**
	 * Delete an existing TarifaProfesion entity
	 *
	 */
	public void deleteTarifaProfesion(TarifaProfesion entity) throws Exception;

	/**
	 * Update an existing TarifaProfesion entity
	 *
	 */
	public void updateTarifaProfesion(TarifaProfesion entity) throws Exception;

	/**
	 * Load an existing TarifaProfesion entity
	 *
	 */
	public TarifaProfesion getTarifaProfesion(Long tarifaProfId) throws Exception;

	public List<TarifaProfesion> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<TarifaProfesion> findPageTarifaProfesion(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberTarifaProfesion() throws Exception;

	public List<TarifaProfesionDTO> getDataTarifaProfesion() throws Exception;

	public List<TarifaProfesionDTO> getDataProfesionByTarifaProfesionId(Long profesionId) throws Exception;
}
