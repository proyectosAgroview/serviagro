package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.PlanRevisionEquipo;
import co.com.arcosoft.modelo.dto.PlanRevisionEquipoActivDTO;
import co.com.arcosoft.modelo.dto.PlanRevisionEquipoDTO;
import co.com.arcosoft.modelo.dto.PlanRevisionEquipoDetDTO;
import co.com.arcosoft.modelo.dto.PlanRevisionEquipoRecursosDTO;
import co.com.arcosoft.modelo.dto.PlanRevisionProdDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IPlanRevisionEquipoLogic {
	public List<PlanRevisionEquipo> getPlanRevisionEquipo() throws Exception;

	/**
	 * Save an new PlanRevisionEquipo entity
	 */
	public void savePlanRevisionEquipo(PlanRevisionEquipo entity, List<PlanRevisionEquipoDetDTO> dataDetEquipo,
			List<PlanRevisionEquipoActivDTO> dataDetActividad,List<PlanRevisionEquipoRecursosDTO> dataRecursos,
			List<PlanRevisionProdDTO> dataPlanRevisionProd) throws Exception;

	/**
	 * Delete an existing PlanRevisionEquipo entity
	 *
	 */
	public void deletePlanRevisionEquipo(PlanRevisionEquipo entity) throws Exception;

	/**
	 * Update an existing PlanRevisionEquipo entity
	 *
	 */
	public void updatePlanRevisionEquipo(PlanRevisionEquipo entity, List<PlanRevisionEquipoDetDTO> dataDetEquipo,
			List<PlanRevisionEquipoActivDTO> dataDetActividad,List<PlanRevisionEquipoRecursosDTO> dataRecursos,
			List<PlanRevisionProdDTO> dataPlanRevisionProd) throws Exception;

	/**
	 * Load an existing PlanRevisionEquipo entity
	 *
	 */
	public PlanRevisionEquipo getPlanRevisionEquipo(Long planRevisionEquipoId) throws Exception;

	public List<PlanRevisionEquipo> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<PlanRevisionEquipo> findPagePlanRevisionEquipo(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberPlanRevisionEquipo() throws Exception;

	public List<PlanRevisionEquipoDTO> getDataPlanRevisionEquipo(String modulo, Long flagPlanRevision, String planSeleccionados) throws Exception;

	
}
