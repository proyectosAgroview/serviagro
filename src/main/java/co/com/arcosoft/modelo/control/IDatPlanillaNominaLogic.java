package co.com.arcosoft.modelo.control;

import java.util.List;
import java.util.Map;

import co.com.arcosoft.modelo.DatPlanillaNomina;
import co.com.arcosoft.modelo.dto.DatAplicProdDetDTO;
import co.com.arcosoft.modelo.dto.DatPlanillaNominaDTO;
import co.com.arcosoft.modelo.dto.DatPlanillaNominaDetDTO;
import co.com.arcosoft.modelo.dto.DatPlanillaNominaOnivel4DTO;
import co.com.arcosoft.modelo.dto.DatRiegoDTO;
import co.com.arcosoft.modelo.dto.DatServicioDetDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IDatPlanillaNominaLogic {
	public List<DatPlanillaNomina> getDatPlanillaNomina() throws Exception;

	/**
	 * Save an new DatPlanillaNomina entity
	 */
	public void saveDatPlanillaNomina(DatPlanillaNomina entity, List<DatPlanillaNominaDetDTO> dataPlanillaDet,List<DatServicioDetDTO> dataServicioDet,
			List<DatAplicProdDetDTO> dataProductoDet,
			List<DatRiegoDTO> dataRiegoDet, List<DatPlanillaNominaOnivel4DTO> datPlanillaNominaOnivel4)
			throws Exception;

	/**
	 * Delete an existing DatPlanillaNomina entity
	 *
	 */
	public void deleteDatPlanillaNomina(DatPlanillaNomina entity) throws Exception;

	/**
	 * Update an existing DatPlanillaNomina entity
	 *
	 */
	public void updateDatPlanillaNomina(DatPlanillaNomina entity, List<DatPlanillaNominaDetDTO> dataPlanillaDet,List<DatServicioDetDTO> dataServicioDet,
			List<DatAplicProdDetDTO> dataProductoDet,
			List<DatRiegoDTO> dataRiegoDet, List<DatPlanillaNominaOnivel4DTO> datPlanillaNominaOnivel4)
			throws Exception;

	/**
	 * Load an existing DatPlanillaNomina entity
	 *
	 */
	public DatPlanillaNomina getDatPlanillaNomina(Long planillaNominaId) throws Exception;

	public List<DatPlanillaNomina> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatPlanillaNomina> findPageDatPlanillaNomina(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDatPlanillaNomina() throws Exception;

	public List<DatPlanillaNominaDTO> getDataDatPlanillaNomina() throws Exception;

	public List<DatPlanillaNominaDTO> findByCriteriaPagePlanillaNomina(int startRow, int pageSize, String sortField,
			boolean sortOrder, Map<String, Object> filters) throws Exception;

	public Long findTotalNumberPlanillaNomina(Map<String, Object> filters) throws Exception;

}
