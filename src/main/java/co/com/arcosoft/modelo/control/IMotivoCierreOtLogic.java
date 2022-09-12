package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.MotivoCierreOt;
import co.com.arcosoft.modelo.dto.MotivoCierreOtDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IMotivoCierreOtLogic {
	public List<MotivoCierreOt> getMotivoCierreOt() throws Exception;

	/**
	 * Save an new MotivoCierreOt entity
	 */
	public void saveMotivoCierreOt(MotivoCierreOt entity) throws Exception;

	/**
	 * Delete an existing MotivoCierreOt entity
	 *
	 */
	public void deleteMotivoCierreOt(MotivoCierreOt entity) throws Exception;

	/**
	 * Update an existing MotivoCierreOt entity
	 *
	 */
	public void updateMotivoCierreOt(MotivoCierreOt entity) throws Exception;

	/**
	 * Load an existing MotivoCierreOt entity
	 *
	 */
	public MotivoCierreOt getMotivoCierreOt(Long motCierreOtId) throws Exception;

	public List<MotivoCierreOt> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<MotivoCierreOt> findPageMotivoCierreOt(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberMotivoCierreOt() throws Exception;

	public List<MotivoCierreOtDTO> getDataMotivoCierreOt() throws Exception;
}
