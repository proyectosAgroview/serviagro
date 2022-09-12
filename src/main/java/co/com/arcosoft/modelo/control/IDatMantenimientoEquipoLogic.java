package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatHorasTrabajoEquipo;
import co.com.arcosoft.modelo.DatMantenimientoEquipo;
import co.com.arcosoft.modelo.dto.DatMantenimientoEquipoDTO;
import co.com.arcosoft.modelo.dto.DatMantenimientoEquipoMecDTO;
import co.com.arcosoft.modelo.dto.DatMantenimientoEquipoPlanRevisionDTO;
import co.com.arcosoft.modelo.dto.DatMantenimientoEquipoProdDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IDatMantenimientoEquipoLogic {
	public List<DatMantenimientoEquipo> getDatMantenimientoEquipo() throws Exception;

	/**
	 * Save an new DatMantenimientoEquipo entity
	 */
	public void saveDatMantenimientoEquipo(DatMantenimientoEquipo entity, List<DatMantenimientoEquipoMecDTO> DataEquipoMec, 
			List<DatMantenimientoEquipoProdDTO> DataEquipoProd, List<DatMantenimientoEquipoPlanRevisionDTO> dataPlanRevision, 
			DatHorasTrabajoEquipo entity_hrt) throws Exception;

	/**
	 * Delete an existing DatMantenimientoEquipo entity
	 *
	 */
	public void deleteDatMantenimientoEquipo(DatMantenimientoEquipo entity) throws Exception;

	/**
	 * Update an existing DatMantenimientoEquipo entity
	 *
	 */
	public void updateDatMantenimientoEquipo(DatMantenimientoEquipo entity, List<DatMantenimientoEquipoMecDTO> DataEquipoMec, 
			List<DatMantenimientoEquipoProdDTO> DataEquipoProd, List<DatMantenimientoEquipoPlanRevisionDTO> dataPlanRevision)
			throws Exception;

	/**
	 * Load an existing DatMantenimientoEquipo entity
	 *
	 */
	public DatMantenimientoEquipo getDatMantenimientoEquipo(Long datMantenimientoEquipoId) throws Exception;

	public List<DatMantenimientoEquipo> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatMantenimientoEquipo> findPageDatMantenimientoEquipo(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatMantenimientoEquipo() throws Exception;

	public List<DatMantenimientoEquipoDTO> getDataDatMantenimientoEquipo(String modulo) throws Exception;

	
}
