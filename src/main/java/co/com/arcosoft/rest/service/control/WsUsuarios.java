package co.com.arcosoft.rest.service.control;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedProperty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.Usuarios;
import co.com.arcosoft.modelo.control.IUsuariosLogic;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.rest.service.dto.UsuariosDTO;


@Controller
@RequestMapping("/catalogos")
public class WsUsuarios {

	private static final Logger logger = LoggerFactory.getLogger(WsUsuarios.class);

	@Autowired
	IUsuariosLogic datalogic;
	
	@Autowired
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	@RequestMapping(value = "/listarUsuarios", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<UsuariosDTO>> listarUsuarios() throws Exception {

		List<Usuarios> a = new ArrayList<Usuarios>();
		List<UsuariosDTO> ma = new ArrayList<UsuariosDTO>();

		a = datalogic.getUsuarios();

		if (a != null && a.size() > 0) {

			for (Usuarios mU : a) {
				
				if (mU.getEnabled().equals("true")) {
					Long idUsuario = mU.getUsuarioId();
					Object[] condicionT = { "usuario_asociado", true, idUsuario, "=" };
					List<Trabajador> listaT = (idUsuario != null)
							? businessDelegatorView.findByCriteriaInTrabajador(condicionT, null, null)
							: null;
					if (listaT != null && listaT.size() > 0) {
						
						UsuariosDTO tmp = new UsuariosDTO();
						tmp.setUsuarioId(mU.getUsuarioId());
						tmp.setLogin(mU.getLogin());
						tmp.setNombre(mU.getNombre());
						tmp.setCompania(mU.getCompania().getCompaniaId().longValue());
						tmp.setContrasena(mU.getContrasena());
						if (mU.getPermisosMovil() != null) {
							tmp.setPermisosMovil(mU.getPermisosMovil());
						} else {
							tmp.setPermisosMovil("todos");
						}
						
						if (mU.getUsaPlanificacion() != null) {
							tmp.setUsa_planificacion(mU.getUsaPlanificacion());
						} else {
							tmp.setUsa_planificacion("NO");
						}
						
						
						ma.add(tmp);
					}
				}

			}

			return new ResponseEntity<List<UsuariosDTO>>(ma, HttpStatus.OK);

		} else {

			return new ResponseEntity<List<UsuariosDTO>>(HttpStatus.NO_CONTENT);
		}

	}

	@RequestMapping(value = "/listarUsuario", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<UsuariosDTO>> obtenerUsuario(
			@RequestParam(value = "login", required = true) String login,
			@RequestParam(value = "contrasena", required = true) String contrasena

	) throws Exception {

		List<Usuarios> a = new ArrayList<Usuarios>();
		List<UsuariosDTO> ma = new ArrayList<UsuariosDTO>();

		//BCryptPasswordEncoder bcryptEncoder = new BCryptPasswordEncoder();

		// a = datalogic.getUsuarios();
		Object[] condicion = { "enabled", true, "true", "=", "login", true, login, "=", "nombre", true, contrasena,
				"=" };

		a = datalogic.findByCriteria(condicion, null, null);

		if (a != null && a.size() > 0) {

			for (Usuarios mU : a) {
				Long idUsuario = mU.getUsuarioId();
				Object[] condicionT = { "usuario_asociado", true, idUsuario, "=" };
				List<Trabajador> listaT = (idUsuario != null)
						? businessDelegatorView.findByCriteriaInTrabajador(condicionT, null, null)
						: null;
				if (listaT != null && listaT.size() > 0) {
					UsuariosDTO tmp = new UsuariosDTO();
					tmp.setUsuarioId(mU.getUsuarioId());
					tmp.setLogin(mU.getLogin());
					tmp.setNombre(mU.getNombre());
					tmp.setCompania(mU.getCompania().getCompaniaId().longValue());
					tmp.setContrasena(mU.getContrasena());
					if (mU.getPermisosMovil() != null) {
						tmp.setPermisosMovil(mU.getPermisosMovil());
					} else {
						tmp.setPermisosMovil("todos");
					}
					
					if (mU.getUsaPlanificacion() != null) {
						tmp.setUsa_planificacion(mU.getUsaPlanificacion());
					} else {
						tmp.setUsa_planificacion("NO");
					}
					
					ma.add(tmp);
				}
			}

			return new ResponseEntity<List<UsuariosDTO>>(ma, HttpStatus.OK);

		} else {

			return new ResponseEntity<List<UsuariosDTO>>(HttpStatus.NO_CONTENT);
		}

	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}
	
	

}
