package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatMantenimientoEquipoMec;
import co.com.arcosoft.modelo.dto.DatMantenimientoEquipoMecDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IDatMantenimientoEquipoMecLogic {
	public List<DatMantenimientoEquipoMec> getDatMantenimientoEquipoMec() throws Exception;

	/**
	 * Save an new DatMantenimientoEquipoMec entity
	 */
	public void saveDatMantenimientoEquipoMec(DatMantenimientoEquipoMec entity) throws Exception;

	/**
	 * Delete an existing DatMantenimientoEquipoMec entity
	 *
	 */
	public void deleteDatMantenimientoEquipoMec(DatMantenimientoEquipoMec entity) throws Exception;

	/**
	 * Update an existing DatMantenimientoEquipoMec entity
	 *
	 */
	public void updateDatMantenimientoEquipoMec(DatMantenimientoEquipoMec entity) throws Exception;

	/**
	 * Load an existing DatMantenimientoEquipoMec entity
	 *
	 */
	public DatMantenimientoEquipoMec getDatMantenimientoEquipoMec(Long datMantenimientoEquipoMecId) throws Exception;

	public List<DatMantenimientoEquipoMec> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatMantenimientoEquipoMec> findPageDatMantenimientoEquipoMec(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatMantenimientoEquipoMec() throws Exception;

	public List<DatMantenimientoEquipoMecDTO> getDataDatMantenimientoEquipoMec() throws Exception;

	public List<DatMantenimientoEquipoMecDTO> getDataDatMantenimientoEquipoMecByMec(Long datMantenimientoEquipoId)
			throws Exception;
}
