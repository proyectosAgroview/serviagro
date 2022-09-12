package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.CronogramaLabores;
import co.com.arcosoft.modelo.dto.CronogramaLaboresDTO;
import co.com.arcosoft.modelo.dto.CronogramaLaboresLaboresDTO;
import co.com.arcosoft.modelo.dto.CronogramaLaboresNivel4DTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ICronogramaLaboresLogic {
	public List<CronogramaLabores> getCronogramaLabores() throws Exception;

	/**
	 * Save an new CronogramaLabores entity
	 */
	public void saveCronogramaLabores(CronogramaLabores entity,
			List<CronogramaLaboresLaboresDTO> dataCronogramaLaboresLabores,
			List<CronogramaLaboresNivel4DTO> dataCronogramaLaboresNivel4) throws Exception;

	/**
	 * Delete an existing CronogramaLabores entity
	 *
	 */
	public void deleteCronogramaLabores(CronogramaLabores entity) throws Exception;

	/**
	 * Update an existing CronogramaLabores entity
	 *
	 */
	public void updateCronogramaLabores(CronogramaLabores entity,
			List<CronogramaLaboresLaboresDTO> dataCronogramaLaboresLabores,
			List<CronogramaLaboresNivel4DTO> dataCronogramaLaboresNivel4) throws Exception;

	/**
	 * Load an existing CronogramaLabores entity
	 *
	 */
	public CronogramaLabores getCronogramaLabores(Long cronogramaLaboresId) throws Exception;

	public List<CronogramaLabores> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<CronogramaLabores> findPageCronogramaLabores(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberCronogramaLabores() throws Exception;

	public List<CronogramaLaboresDTO> getDataCronogramaLabores() throws Exception;
}
