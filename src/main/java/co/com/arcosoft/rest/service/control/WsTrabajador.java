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

import co.com.arcosoft.modelo.Profesion;
import co.com.arcosoft.modelo.TipoProducto;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.control.ITrabajadorLogic;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.rest.service.dto.TrabajadorDTO;

@Controller
@RequestMapping("/catalogos")
public class WsTrabajador {

	private static final Logger logger = LoggerFactory.getLogger(WsTrabajador.class);

	@Autowired
	ITrabajadorLogic trabajadorLogic;
	
	
	@Autowired
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	@RequestMapping(value = "/listarTrabajadores", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<TrabajadorDTO>> listarTrabajadores() throws Exception {

		List<Trabajador> t = new ArrayList<Trabajador>();
		List<TrabajadorDTO> tm = new ArrayList<TrabajadorDTO>();

		t = trabajadorLogic.getTrabajador();

		if (t != null && t.size() > 0) {

			for (Trabajador trabajador : t) {
				
				Long profId =  trabajador.getProfesion().getProfId();
				Profesion tipProd = businessDelegatorView.getProfesion(profId);
				String funcion =tipProd.getFunciones();

				if (trabajador.getEstado().equals("A") && (funcion.equals("Tractorista") || funcion.equals("Bombero")
								|| funcion.equals("Conductor") || funcion.equals("Conductor")
								|| funcion.equals("Operador equipos cosecha") || funcion.equals("Obrero Agrícola")
								|| funcion.equals("Supervisor")
						)
						) {

					TrabajadorDTO tmp = new TrabajadorDTO();
					tmp.setTrabajadorId(trabajador.getTrabId());
					tmp.setCodigo(trabajador.getCodigo().trim());
					tmp.setNombre(trabajador.getNombre().trim());
					tmp.setContratistaId(trabajador.getContratista().getPersEmprId().toString());
					tmp.setCompania(trabajador.getCompania());

					tm.add(tmp);
				}

			}

			return new ResponseEntity<List<TrabajadorDTO>>(tm, HttpStatus.OK);

		} else {

			return new ResponseEntity<List<TrabajadorDTO>>(HttpStatus.NO_CONTENT);
		}

	}

}
