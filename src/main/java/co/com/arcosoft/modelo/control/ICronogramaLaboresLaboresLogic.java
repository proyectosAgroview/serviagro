package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.CronogramaLaboresLabores;
import co.com.arcosoft.modelo.dto.CronogramaLaboresLaboresDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ICronogramaLaboresLaboresLogic {
	public List<CronogramaLaboresLabores> getCronogramaLaboresLabores() throws Exception;

	/**
	 * Save an new CronogramaLaboresLabores entity
	 */
	public void saveCronogramaLaboresLabores(CronogramaLaboresLabores entity) throws Exception;

	/**
	 * Delete an existing CronogramaLaboresLabores entity
	 *
	 */
	public void deleteCronogramaLaboresLabores(CronogramaLaboresLabores entity) throws Exception;

	/**
	 * Update an existing CronogramaLaboresLabores entity
	 *
	 */
	public void updateCronogramaLaboresLabores(CronogramaLaboresLabores entity) throws Exception;

	/**
	 * Load an existing CronogramaLaboresLabores entity
	 *
	 */
	public CronogramaLaboresLabores getCronogramaLaboresLabores(Long cronogramaLaboresLaboresId) throws Exception;

	public List<CronogramaLaboresLabores> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<CronogramaLaboresLabores> findPageCronogramaLaboresLabores(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberCronogramaLaboresLabores() throws Exception;

	public List<CronogramaLaboresLaboresDTO> getDataCronogramaLaboresLabores() throws Exception;

	public List<CronogramaLaboresLaboresDTO> getDataCronogramaLaboresLaboresByCronograma(Long cronogramaLaboresId)
			throws Exception;
}
