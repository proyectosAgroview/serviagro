package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.TipoRecursosProfesion;
import co.com.arcosoft.modelo.dto.TipoRecursosProfesionDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ITipoRecursosProfesionLogic {
	public List<TipoRecursosProfesion> getTipoRecursosProfesion() throws Exception;

	/**
	 * Save an new TipoRecursosProfesion entity
	 */
	public void saveTipoRecursosProfesion(TipoRecursosProfesion entity) throws Exception;

	/**
	 * Delete an existing TipoRecursosProfesion entity
	 *
	 */
	public void deleteTipoRecursosProfesion(TipoRecursosProfesion entity) throws Exception;

	/**
	 * Update an existing TipoRecursosProfesion entity
	 *
	 */
	public void updateTipoRecursosProfesion(TipoRecursosProfesion entity) throws Exception;

	/**
	 * Load an existing TipoRecursosProfesion entity
	 *
	 */
	public TipoRecursosProfesion getTipoRecursosProfesion(Long tipoRecursosProfesionId) throws Exception;

	public List<TipoRecursosProfesion> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<TipoRecursosProfesion> findPageTipoRecursosProfesion(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberTipoRecursosProfesion() throws Exception;

	public List<TipoRecursosProfesionDTO> getDataTipoRecursosProfesion() throws Exception;

	public List<TipoRecursosProfesionDTO> getDataTipoRecursosProfesionByProfesion(Long tipoRecursosProfesionId)
			throws Exception;

}
