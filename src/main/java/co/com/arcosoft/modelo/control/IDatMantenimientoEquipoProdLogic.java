package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatMantenimientoEquipoProd;
import co.com.arcosoft.modelo.dto.DatMantenimientoEquipoProdDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IDatMantenimientoEquipoProdLogic {
	public List<DatMantenimientoEquipoProd> getDatMantenimientoEquipoProd() throws Exception;

	/**
	 * Save an new DatMantenimientoEquipoProd entity
	 */
	public void saveDatMantenimientoEquipoProd(DatMantenimientoEquipoProd entity) throws Exception;

	/**
	 * Delete an existing DatMantenimientoEquipoProd entity
	 *
	 */
	public void deleteDatMantenimientoEquipoProd(DatMantenimientoEquipoProd entity) throws Exception;

	/**
	 * Update an existing DatMantenimientoEquipoProd entity
	 *
	 */
	public void updateDatMantenimientoEquipoProd(DatMantenimientoEquipoProd entity) throws Exception;

	/**
	 * Load an existing DatMantenimientoEquipoProd entity
	 *
	 */
	public DatMantenimientoEquipoProd getDatMantenimientoEquipoProd(Long datMantenimientoEquipoProdId) throws Exception;

	public List<DatMantenimientoEquipoProd> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatMantenimientoEquipoProd> findPageDatMantenimientoEquipoProd(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatMantenimientoEquipoProd() throws Exception;

	public List<DatMantenimientoEquipoProdDTO> getDataDatMantenimientoEquipoProd() throws Exception;

	public List<DatMantenimientoEquipoProdDTO> getDataDatMantenimientoEquipoProdByProd(Long datMantenimientoEquipoId)
			throws Exception;
}
