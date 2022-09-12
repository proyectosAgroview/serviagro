package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.PlanAsignarRecurso;
import co.com.arcosoft.modelo.PlanAsignarRecursoId;
import co.com.arcosoft.modelo.dto.PlanAsignarRecursoDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IPlanAsignarRecursoLogic {
	public List<PlanAsignarRecurso> getPlanAsignarRecurso() throws Exception;

	/**
	 * Save an new PlanAsignarRecurso entity
	 */
	public void savePlanAsignarRecurso(PlanAsignarRecurso entity) throws Exception;

	/**
	 * Delete an existing PlanAsignarRecurso entity
	 *
	 */
	public void deletePlanAsignarRecurso(PlanAsignarRecurso entity) throws Exception;

	/**
	 * Update an existing PlanAsignarRecurso entity
	 *
	 */
	public void updatePlanAsignarRecurso(PlanAsignarRecurso entity) throws Exception;

	/**
	 * Load an existing PlanAsignarRecurso entity
	 *
	 */
	public PlanAsignarRecurso getPlanAsignarRecurso(PlanAsignarRecursoId id) throws Exception;

	public List<PlanAsignarRecurso> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<PlanAsignarRecurso> findPagePlanAsignarRecurso(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberPlanAsignarRecurso() throws Exception;

	public List<PlanAsignarRecursoDTO> getDataPlanAsignarRecurso() throws Exception;
}
