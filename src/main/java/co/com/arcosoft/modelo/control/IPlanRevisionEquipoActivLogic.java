package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.PlanRevisionEquipoActiv;
import co.com.arcosoft.modelo.dto.PlanRevisionEquipoActivDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IPlanRevisionEquipoActivLogic {
	public List<PlanRevisionEquipoActiv> getPlanRevisionEquipoActiv() throws Exception;

	/**
	 * Save an new PlanRevisionEquipoActiv entity
	 */
	public void savePlanRevisionEquipoActiv(PlanRevisionEquipoActiv entity) throws Exception;

	/**
	 * Delete an existing PlanRevisionEquipoActiv entity
	 *
	 */
	public void deletePlanRevisionEquipoActiv(PlanRevisionEquipoActiv entity) throws Exception;

	/**
	 * Update an existing PlanRevisionEquipoActiv entity
	 *
	 */
	public void updatePlanRevisionEquipoActiv(PlanRevisionEquipoActiv entity) throws Exception;

	/**
	 * Load an existing PlanRevisionEquipoActiv entity
	 *
	 */
	public PlanRevisionEquipoActiv getPlanRevisionEquipoActiv(Long planRevisionEquipoActivId) throws Exception;

	public List<PlanRevisionEquipoActiv> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<PlanRevisionEquipoActiv> findPagePlanRevisionEquipoActiv(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberPlanRevisionEquipoActiv() throws Exception;

	public List<PlanRevisionEquipoActivDTO> getDataPlanRevisionEquipoActiv() throws Exception;

	public List<PlanRevisionEquipoActivDTO> getDataPlanRevisionEquipoActivByEquipo(Long planRevisionEquipoId)
			throws Exception;
}
