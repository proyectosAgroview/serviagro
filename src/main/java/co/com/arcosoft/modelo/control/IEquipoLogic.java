package co.com.arcosoft.modelo.control;

import java.util.List;
import java.util.Map;

import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.dto.EquipoDTO;
import co.com.arcosoft.modelo.dto.EquipoEventoDTO;
import co.com.arcosoft.modelo.dto.TarifaEquipPropDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IEquipoLogic {
	public List<Equipo> getEquipo() throws Exception;

	/**
	 * Save an new Equipo entity
	 */
	public void saveEquipo(Equipo entity, List<TarifaEquipPropDTO> dataTarifaEquipProp,
			List<EquipoEventoDTO> dataEventosEquipos) throws Exception;

	/**
	 * Delete an existing Equipo entity
	 *
	 */
	public void deleteEquipo(Equipo entity) throws Exception;

	/**
	 * Update an existing Equipo entity
	 *
	 */
	public void updateEquipo(Equipo entity, List<TarifaEquipPropDTO> dataTarifaEquipProp,
			List<EquipoEventoDTO> dataEventosEquipos) throws Exception;

	/**
	 * Load an existing Equipo entity
	 *
	 */
	public Equipo getEquipo(Long equipoId) throws Exception;

	public List<Equipo> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Equipo> findPageEquipo(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberEquipo() throws Exception;

	public List<EquipoDTO> getDataEquipo() throws Exception;

	public Long findTotalNumberEquipo(Map<String, Object> filters) throws Exception;

	public List<EquipoDTO> findByCriteriaPageEquipo(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters, String modulo) throws Exception;
}
