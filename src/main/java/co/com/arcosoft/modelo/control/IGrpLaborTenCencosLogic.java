package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.GrpLaborTenCencos;
import co.com.arcosoft.modelo.GrpLaborTenCencosId;
import co.com.arcosoft.modelo.dto.GrpLaborTenCencosDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IGrpLaborTenCencosLogic {
	public List<GrpLaborTenCencos> getGrpLaborTenCencos() throws Exception;

	/**
	 * Save an new GrpLaborTenCencos entity
	 */
	public void saveGrpLaborTenCencos(GrpLaborTenCencos entity) throws Exception;

	/**
	 * Delete an existing GrpLaborTenCencos entity
	 *
	 */
	public void deleteGrpLaborTenCencos(GrpLaborTenCencos entity) throws Exception;

	/**
	 * Update an existing GrpLaborTenCencos entity
	 *
	 */
	public void updateGrpLaborTenCencos(GrpLaborTenCencos entity) throws Exception;

	/**
	 * Load an existing GrpLaborTenCencos entity
	 *
	 */
	public GrpLaborTenCencos getGrpLaborTenCencos(GrpLaborTenCencosId id) throws Exception;

	public List<GrpLaborTenCencos> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<GrpLaborTenCencos> findPageGrpLaborTenCencos(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberGrpLaborTenCencos() throws Exception;

	public List<GrpLaborTenCencosDTO> getDataGrpLaborTenCencos() throws Exception;
}
