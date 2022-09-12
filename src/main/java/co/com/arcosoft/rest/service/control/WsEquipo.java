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

import co.com.arcosoft.modelo.CategoriaEquipo;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.control.IEquipoLogic;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.rest.service.dto.EquipoDTO;
import co.com.arcosoft.rest.service.dto.ImplementoDTO;

@Controller
@RequestMapping("/catalogos")
public class WsEquipo {

	private static final Logger logger = LoggerFactory.getLogger(WsEquipo.class);

	@Autowired
	IEquipoLogic equipologic;
	
	@Autowired
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	
	@RequestMapping(value = "/listarEquipo", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<EquipoDTO>> listarEquipoes() throws Exception {

		List<Equipo> a = new ArrayList<Equipo>();
		List<EquipoDTO> ma = new ArrayList<EquipoDTO>();

		a = equipologic.getEquipo();

		if (a != null && a.size() > 0) {

			for (Equipo mEquipo : a) {

				Long categId =  mEquipo.getCategoriaEquipo().getCategEquipId();
				CategoriaEquipo categ = businessDelegatorView.getCategoriaEquipo(categId);
				String funcion =categ.getFuncion();
				 
				if (mEquipo.getEstado().equals("A") && (!funcion.equals("Implemento") || !funcion.equals("Remolques/Vagones")
						|| !funcion.equals("Herramienta") || !funcion.equals("Otros"))
						) {
					EquipoDTO tmp = new EquipoDTO();
					tmp.setEquipoId(mEquipo.getEquipoId());
					tmp.setCodigo(mEquipo.getCodigo());
					tmp.setNombre(mEquipo.getNombre());
					tmp.setCompania(mEquipo.getCompania());
					tmp.setCategEquipId_CategoriaEquipo(categId);
					ma.add(tmp);
				}

			}

			return new ResponseEntity<List<EquipoDTO>>(ma, HttpStatus.OK);

		} else {

			return new ResponseEntity<List<EquipoDTO>>(HttpStatus.NO_CONTENT);
		}

	}
	

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}
	

}
