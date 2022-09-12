package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.TipoRecurso;
import co.com.arcosoft.modelo.dto.TipoRecursoDTO;
import co.com.arcosoft.modelo.dto.TipoRecursosEquiposDTO;
import co.com.arcosoft.modelo.dto.TipoRecursosInsumosDTO;
import co.com.arcosoft.modelo.dto.TipoRecursosOtrosDTO;
import co.com.arcosoft.modelo.dto.TipoRecursosProfesionDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ITipoRecursoLogic {
	public List<TipoRecurso> getTipoRecurso() throws Exception;

	/**
	 * Save an new TipoRecurso entity
	 */
	public void saveTipoRecurso(TipoRecurso entity, List<TipoRecursosProfesionDTO> dataTRProfesion,
			List<TipoRecursosEquiposDTO> dataTREquipos, List<TipoRecursosInsumosDTO> dataTRInsumos,
			List<TipoRecursosOtrosDTO> dataTROtros) throws Exception;

	/**
	 * Delete an existing TipoRecurso entity
	 *
	 */
	public void deleteTipoRecurso(TipoRecurso entity) throws Exception;

	/**
	 * Update an existing TipoRecurso entity
	 *
	 */
	public void updateTipoRecurso(TipoRecurso entity, List<TipoRecursosProfesionDTO> dataTRProfesion,
			List<TipoRecursosEquiposDTO> dataTREquipos, List<TipoRecursosInsumosDTO> dataTRInsumos,
			List<TipoRecursosOtrosDTO> dataTROtros) throws Exception;

	/**
	 * Load an existing TipoRecurso entity
	 *
	 */
	public TipoRecurso getTipoRecurso(Long tpRecursoId) throws Exception;

	public List<TipoRecurso> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<TipoRecurso> findPageTipoRecurso(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberTipoRecurso() throws Exception;

	public List<TipoRecursoDTO> getDataTipoRecurso() throws Exception;
}
