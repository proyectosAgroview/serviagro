package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.UsuariosDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IUsuariosLogic {
	public List<Usuarios> getUsuarios() throws Exception;

	/**
	 * Save an new Usuarios entity
	 */
	public void saveUsuarios(Usuarios entity, List<String> grpUser) throws Exception;

	/**
	 * Delete an existing Usuarios entity
	 *
	 */
	public void deleteUsuarios(Usuarios entity) throws Exception;

	/**
	 * Update an existing Usuarios entity
	 *
	 */
	public void updateUsuarios(Usuarios entity, List<String> grpUser) throws Exception;

	/**
	 * Load an existing Usuarios entity
	 *
	 */
	public Usuarios getUsuarios(Long usuarioId) throws Exception;

	public List<Usuarios> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Usuarios> findPageUsuarios(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberUsuarios() throws Exception;

	public List<UsuariosDTO> getDataUsuarios() throws Exception;
}
