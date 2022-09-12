package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.GrpTenen;
import co.com.arcosoft.modelo.dto.GrpTenenDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IGrpTenenLogic {
	public List<GrpTenen> getGrpTenen() throws Exception;

	/**
	 * Save an new GrpTenen entity
	 */
	public void saveGrpTenen(GrpTenen entity) throws Exception;

	/**
	 * Delete an existing GrpTenen entity
	 *
	 */
	public void deleteGrpTenen(GrpTenen entity) throws Exception;

	/**
	 * Update an existing GrpTenen entity
	 *
	 */
	public void updateGrpTenen(GrpTenen entity) throws Exception;

	/**
	 * Load an existing GrpTenen entity
	 *
	 */
	public GrpTenen getGrpTenen(Long grpTenId) throws Exception;

	public List<GrpTenen> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<GrpTenen> findPageGrpTenen(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberGrpTenen() throws Exception;

	public List<GrpTenenDTO> getDataGrpTenen() throws Exception;
}
