package co.com.arcosoft.modelo.dto;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class GroupMembersDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(GroupMembersDTO.class);
	private Long id;
	private Long id_Groups;
	private Long usuarioId_Usuarios;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_Groups() {
		return id_Groups;
	}

	public void setId_Groups(Long id_Groups) {
		this.id_Groups = id_Groups;
	}

	public Long getUsuarioId_Usuarios() {
		return usuarioId_Usuarios;
	}

	public void setUsuarioId_Usuarios(Long usuarioId_Usuarios) {
		this.usuarioId_Usuarios = usuarioId_Usuarios;
	}
}
