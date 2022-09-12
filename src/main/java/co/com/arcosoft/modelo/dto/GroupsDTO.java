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
public class GroupsDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(GroupsDTO.class);
	private String groupName;
	private Long id;
	private Long id_GroupsAutoridad;
	private String nombreAutoridad;

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_GroupsAutoridad() {
		return id_GroupsAutoridad;
	}

	public String getNombreAutoridad() {
		return nombreAutoridad;
	}

	public void setId_GroupsAutoridad(Long id_GroupsAutoridad) {
		this.id_GroupsAutoridad = id_GroupsAutoridad;
	}

	public void setNombreAutoridad(String nombreAutoridad) {
		this.nombreAutoridad = nombreAutoridad;
	}

}
