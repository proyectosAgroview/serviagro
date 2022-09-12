package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.CronogramaLaboresNivel4;
import co.com.arcosoft.modelo.dto.CronogramaLaboresNivel4DTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ICronogramaLaboresNivel4Logic {
	public List<CronogramaLaboresNivel4> getCronogramaLaboresNivel4() throws Exception;

	/**
	 * Save an new CronogramaLaboresNivel4 entity
	 */
	public void saveCronogramaLaboresNivel4(CronogramaLaboresNivel4 entity) throws Exception;

	/**
	 * Delete an existing CronogramaLaboresNivel4 entity
	 *
	 */
	public void deleteCronogramaLaboresNivel4(CronogramaLaboresNivel4 entity) throws Exception;

	/**
	 * Update an existing CronogramaLaboresNivel4 entity
	 *
	 */
	public void updateCronogramaLaboresNivel4(CronogramaLaboresNivel4 entity) throws Exception;

	/**
	 * Load an existing CronogramaLaboresNivel4 entity
	 *
	 */
	public CronogramaLaboresNivel4 getCronogramaLaboresNivel4(Long cronogramaLaboresNivel4Id) throws Exception;

	public List<CronogramaLaboresNivel4> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<CronogramaLaboresNivel4> findPageCronogramaLaboresNivel4(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberCronogramaLaboresNivel4() throws Exception;

	public List<CronogramaLaboresNivel4DTO> getDataCronogramaLaboresNivel4() throws Exception;

	public List<CronogramaLaboresNivel4DTO> getDataCronogramaLaboresNivel4ByCronograma(Long cronogramaLaboresId)
			throws Exception;
}
