package co.com.arcosoft.modelo.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.com.arcosoft.dataaccess.dao.IGroupMembersDAO;
import co.com.arcosoft.dataaccess.dao.IGroupsDAO;
import co.com.arcosoft.dataaccess.dao.IUsuariosDAO;
import co.com.arcosoft.exceptions.ZMessManager;
import co.com.arcosoft.modelo.GroupMembers;
import co.com.arcosoft.modelo.Groups;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.dto.UsuariosDTO;
import co.com.arcosoft.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("UsuariosLogic")
public class UsuariosLogic implements IUsuariosLogic {
	private static final Logger log = LoggerFactory.getLogger(UsuariosLogic.class);

	/**
	 * DAO injected by Spring that manages Usuarios entities
	 *
	 */
	@Autowired
	private IUsuariosDAO usuariosDAO;

	/**
	 * DAO injected by Spring that manages GroupMembers entities
	 *
	 */
	@Autowired
	private IGroupMembersDAO groupMembersDAO;

	/**
	 * Logic injected by Spring that manages Compania entities
	 *
	 */
	@Autowired
	ICompaniaLogic logicCompania1;

	@Autowired
	private IGroupsDAO groupsDAO;

	@Transactional(readOnly = true)
	public List<Usuarios> getUsuarios() throws Exception {
		log.debug("finding all Usuarios instances");

		List<Usuarios> list = new ArrayList<Usuarios>();

		try {
			list = usuariosDAO.findAll();
		} catch (Exception e) {
			log.error("finding all Usuarios failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "Usuarios");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveUsuarios(Usuarios entity, List<String> grpUser) throws Exception {
		log.debug("saving Usuarios instance");

		try {
			if (entity.getCompania() == null) {
				throw new ZMessManager().new ForeignException("compania");
			}

			if ((entity.getContrasena() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getContrasena(), 90) == false)) {
				throw new ZMessManager().new NotValidFormatException("contrasena");
			}

			if ((entity.getEnabled() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEnabled(), 7) == false)) {
				throw new ZMessManager().new NotValidFormatException("enabled");
			}

			if ((entity.getLogin() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getLogin(), 50) == false)) {
				throw new ZMessManager().new NotValidFormatException("login");
			}

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			/*
			 * if (entity.getUsuarioId() == null) { throw new ZMessManager().new
			 * EmptyFieldException("usuarioId"); }
			 */

			/*
			 * if ((entity.getUsuarioId() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getUsuarioId(), 18, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "usuarioId"); }
			 */

			/*if (entity.getCompania().getCompaniaId() == null) {
				throw new ZMessManager().new EmptyFieldException("companiaId_Compania");
			}

			if ((entity.getCompania().getCompaniaId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania().getCompaniaId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("companiaId_Compania");
			}*/

			usuariosDAO.save(entity);

			if (grpUser != null) {

				for (String g : grpUser) {

					Long grupoId = new Long(g);
					Groups grupos = groupsDAO.findById(grupoId);

					GroupMembers grupoMembers = new GroupMembers();
					grupoMembers.setGroups(grupos);
					grupoMembers.setUsuarios(entity);

					groupMembersDAO.save(grupoMembers);

				}

			}

			log.debug("save Usuarios successful");
		} catch (Exception e) {
			log.error("save Usuarios failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteUsuarios(Usuarios entity) throws Exception {
		log.debug("deleting Usuarios instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Usuarios");
		}

		if (entity.getUsuarioId() == null) {
			throw new ZMessManager().new EmptyFieldException("usuarioId");
		}

		List<GroupMembers> groupMemberses = null;

		try {
			groupMemberses = groupMembersDAO.findByProperty("usuarios.usuarioId", entity.getUsuarioId());

			if (Utilities.validationsList(groupMemberses) == true) {
				throw new ZMessManager().new DeletingException("groupMemberses");
			}

			usuariosDAO.delete(entity);

			log.debug("delete Usuarios successful");
		} catch (Exception e) {
			log.error("delete Usuarios failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateUsuarios(Usuarios entity, List<String> grpUser) throws Exception {
		log.debug("updating Usuarios instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Usuarios");
			}

			if (entity.getCompania() == null) {
				throw new ZMessManager().new ForeignException("compania");
			}

			if ((entity.getContrasena() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getContrasena(), 90) == false)) {
				throw new ZMessManager().new NotValidFormatException("contrasena");
			}

			if ((entity.getEnabled() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getEnabled(), 7) == false)) {
				throw new ZMessManager().new NotValidFormatException("enabled");
			}

			if ((entity.getLogin() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getLogin(), 50) == false)) {
				throw new ZMessManager().new NotValidFormatException("login");
			}

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getNombre(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
			}

			if (entity.getUsuarioId() == null) {
				throw new ZMessManager().new EmptyFieldException("usuarioId");
			}

			if ((entity.getUsuarioId() != null) && (Utilities
					.checkNumberAndCheckWithPrecisionAndScale("" + entity.getUsuarioId(), 18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("usuarioId");
			}

			if (entity.getCompania().getCompaniaId() == null) {
				throw new ZMessManager().new EmptyFieldException("companiaId_Compania");
			}

			if ((entity.getCompania().getCompaniaId() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale("" + entity.getCompania().getCompaniaId(),
							18, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("companiaId_Compania");
			}

			usuariosDAO.update(entity);

			if (grpUser != null) {

				groupMembersDAO.deleteByProperty("GroupMembers", "usuarios.usuarioId", entity.getUsuarioId());

				for (String g : grpUser) {

					Long grupoId = new Long(g);
					Groups grupos = groupsDAO.findById(grupoId);

					GroupMembers grupoMembers = new GroupMembers();
					grupoMembers.setGroups(grupos);
					grupoMembers.setUsuarios(entity);
					groupMembersDAO.save(grupoMembers);

				}

			}

			log.debug("update Usuarios successful");
		} catch (Exception e) {
			log.error("update Usuarios failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<UsuariosDTO> getDataUsuarios() throws Exception {
		try {
			List<Usuarios> usuarios = usuariosDAO.findAll();

			List<UsuariosDTO> usuariosDTO = new ArrayList<UsuariosDTO>();

			for (Usuarios usuariosTmp : usuarios) {
				UsuariosDTO usuariosDTO2 = new UsuariosDTO();

				usuariosDTO2.setUsuarioId(usuariosTmp.getUsuarioId());
				usuariosDTO2.setContrasena((usuariosTmp.getContrasena() != null) ? usuariosTmp.getContrasena() : null);
				usuariosDTO2.setEnabled((usuariosTmp.getEnabled() != null) ? usuariosTmp.getEnabled() : null);
				usuariosDTO2.setFechaCreacion(usuariosTmp.getFechaCreacion());
				usuariosDTO2.setFechaModificacion(usuariosTmp.getFechaModificacion());
				usuariosDTO2.setLogin((usuariosTmp.getLogin() != null) ? usuariosTmp.getLogin() : null);
				usuariosDTO2.setNombre((usuariosTmp.getNombre() != null) ? usuariosTmp.getNombre() : null);
				usuariosDTO2.setPermisosMovil((usuariosTmp.getPermisosMovil() != null) ? usuariosTmp.getPermisosMovil() : null);

				if (usuariosTmp.getCompania() != null) {
					String nombreCompania = usuariosTmp.getCompania().getNombre();
					usuariosDTO2.setNombreCompania(nombreCompania);
				}
				usuariosDTO2.setNivelAutorizacion1((usuariosTmp.getNivelAutorizacion1() != null) ? usuariosTmp.getNivelAutorizacion1() : null);

				usuariosDTO2.setNivelAutorizacion2((usuariosTmp.getNivelAutorizacion2() != null) ? usuariosTmp.getNivelAutorizacion2() : null);
				
				usuariosDTO2.setPermisosMovil((usuariosTmp.getPermisosMovil() != null) ? usuariosTmp.getPermisosMovil() : null);


				if (usuariosTmp.getNivelAcceso() != null) {
					
					usuariosDTO2.setNivelAcceso( usuariosTmp.getNivelAcceso());
				}else {
					usuariosDTO2.setNivelAcceso(null);
				}
				
				usuariosDTO.add(usuariosDTO2);
			}

			return usuariosDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public Usuarios getUsuarios(Long usuarioId) throws Exception {
		log.debug("getting Usuarios instance");

		Usuarios entity = null;

		try {
			entity = usuariosDAO.findById(usuarioId);
		} catch (Exception e) {
			log.error("get Usuarios failed", e);
			throw new ZMessManager().new FindingException("Usuarios");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<Usuarios> findPageUsuarios(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<Usuarios> entity = null;

		try {
			entity = usuariosDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Usuarios Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberUsuarios() throws Exception {
		Long entity = null;

		try {
			entity = usuariosDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Usuarios Count");
		} finally {
		}

		return entity;
	}

	/**
	 *
	 * @param varibles
	 *            este arreglo debera tener:
	 *
	 *            [0] = String variable = (String) varibles[i]; representa como
	 *            se llama la variable en el pojo
	 *
	 *            [1] = Boolean booVariable = (Boolean) varibles[i + 1];
	 *            representa si el valor necesita o no ''(comillas simples)usado
	 *            para campos de tipo string
	 *
	 *            [2] = Object value = varibles[i + 2]; representa el valor que
	 *            se va a buscar en la BD
	 *
	 *            [3] = String comparator = (String) varibles[i + 3]; representa
	 *            que tipo de busqueda voy a hacer.., ejemplo: where
	 *            nombre=william o where nombre<>william, en este campo iria el
	 *            tipo de comparador que quiero si es = o <>
	 *
	 *            Se itera de 4 en 4..., entonces 4 registros del arreglo
	 *            representan 1 busqueda en un campo, si se ponen mas pues el
	 *            continuara buscando en lo que se le ingresen en los otros 4
	 *
	 *
	 * @param variablesBetween
	 *
	 *            la diferencia son estas dos posiciones
	 *
	 *            [0] = String variable = (String) varibles[j]; la variable ne
	 *            la BD que va a ser buscada en un rango
	 *
	 *            [1] = Object value = varibles[j + 1]; valor 1 para buscar en
	 *            un rango
	 *
	 *            [2] = Object value2 = varibles[j + 2]; valor 2 para buscar en
	 *            un rango ejempolo: a > 1 and a < 5 --> 1 seria value y 5 seria
	 *            value2
	 *
	 *            [3] = String comparator1 = (String) varibles[j + 3];
	 *            comparador 1 ejemplo: a comparator1 1 and a < 5
	 *
	 *            [4] = String comparator2 = (String) varibles[j + 4];
	 *            comparador 2 ejemplo: a comparador1>1 and a comparador2<5 (el
	 *            original: a > 1 and a < 5) *
	 * @param variablesBetweenDates(en
	 *            este caso solo para mysql) [0] = String variable = (String)
	 *            varibles[k]; el nombre de la variable que hace referencia a
	 *            una fecha
	 *
	 *            [1] = Object object1 = varibles[k + 2]; fecha 1 a
	 *            comparar(deben ser dates)
	 *
	 *            [2] = Object object2 = varibles[k + 3]; fecha 2 a
	 *            comparar(deben ser dates)
	 *
	 *            esto hace un between entre las dos fechas.
	 *
	 * @return lista con los objetos que se necesiten
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	public List<Usuarios> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<Usuarios> list = new ArrayList<Usuarios>();
		String where = new String();
		String tempWhere = new String();

		if (variables != null) {
			for (int i = 0; i < variables.length; i++) {
				if ((variables[i] != null) && (variables[i + 1] != null) && (variables[i + 2] != null)
						&& (variables[i + 3] != null)) {
					String variable = (String) variables[i];
					Boolean booVariable = (Boolean) variables[i + 1];
					Object value = variables[i + 2];
					String comparator = (String) variables[i + 3];

					if (booVariable.booleanValue()) {
						tempWhere = (tempWhere.length() == 0)
								? ("(model." + variable + " " + comparator + " \'" + value + "\' )")
								: (tempWhere + " AND (model." + variable + " " + comparator + " \'" + value + "\' )");
					} else {
						tempWhere = (tempWhere.length() == 0)
								? ("(model." + variable + " " + comparator + " " + value + " )")
								: (tempWhere + " AND (model." + variable + " " + comparator + " " + value + " )");
					}
				}

				i = i + 3;
			}
		}

		if (variablesBetween != null) {
			for (int j = 0; j < variablesBetween.length; j++) {
				if ((variablesBetween[j] != null) && (variablesBetween[j + 1] != null)
						&& (variablesBetween[j + 2] != null) && (variablesBetween[j + 3] != null)
						&& (variablesBetween[j + 4] != null)) {
					String variable = (String) variablesBetween[j];
					Object value = variablesBetween[j + 1];
					Object value2 = variablesBetween[j + 2];
					String comparator1 = (String) variablesBetween[j + 3];
					String comparator2 = (String) variablesBetween[j + 4];
					tempWhere = (tempWhere.length() == 0)
							? ("(" + value + " " + comparator1 + " " + variable + " and " + variable + " " + comparator2
									+ " " + value2 + " )")
							: (tempWhere + " AND (" + value + " " + comparator1 + " " + variable + " and " + variable
									+ " " + comparator2 + " " + value2 + " )");
				}

				j = j + 4;
			}
		}

		if (variablesBetweenDates != null) {
			for (int k = 0; k < variablesBetweenDates.length; k++) {
				if ((variablesBetweenDates[k] != null) && (variablesBetweenDates[k + 1] != null)
						&& (variablesBetweenDates[k + 2] != null)) {
					String variable = (String) variablesBetweenDates[k];
					Object object1 = variablesBetweenDates[k + 1];
					Object object2 = variablesBetweenDates[k + 2];
					String value = null;
					String value2 = null;

					try {
						Date date1 = (Date) object1;
						Date date2 = (Date) object2;
						value = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date1);
						value2 = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date2);
					} catch (Exception e) {
						list = null;
						throw e;
					}

					tempWhere = (tempWhere.length() == 0)
							? ("(model." + variable + " between \'" + value + "\' and \'" + value2 + "\')")
							: (tempWhere + " AND (model." + variable + " between \'" + value + "\' and \'" + value2
									+ "\')");
				}

				k = k + 2;
			}
		}

		if (tempWhere.length() == 0) {
			where = null;
		} else {
			where = "(" + tempWhere + ")";
		}

		try {
			list = usuariosDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
