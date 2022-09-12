package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.GrpLabor;
import co.com.arcosoft.modelo.dto.GrpLaborDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IGrpLaborLogic {
	public List<GrpLabor> getGrpLabor() throws Exception;

	/**
	 * Save an new GrpLabor entity
	 */
	public void saveGrpLabor(GrpLabor entity) throws Exception;

	/**
	 * Delete an existing GrpLabor entity
	 *
	 */
	public void deleteGrpLabor(GrpLabor entity) throws Exception;

	/**
	 * Update an existing GrpLabor entity
	 *
	 */
	public void updateGrpLabor(GrpLabor entity) throws Exception;

	/**
	 * Load an existing GrpLabor entity
	 *
	 */
	public GrpLabor getGrpLabor(Long grpLaborId) throws Exception;

	public List<GrpLabor> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<GrpLabor> findPageGrpLabor(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberGrpLabor() throws Exception;

	public List<GrpLaborDTO> getDataGrpLabor() throws Exception;
}
