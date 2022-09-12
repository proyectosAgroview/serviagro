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
import co.com.arcosoft.rest.service.dto.ImplementoDTO;



@Controller
@RequestMapping("/catalogos")
public class WsImplementos {

	private static final Logger logger = LoggerFactory.getLogger(WsImplementos.class);

	@Autowired
	IEquipoLogic  vagonlogic;
	
	@Autowired
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	
	@RequestMapping(value = "/listarVagones", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<ImplementoDTO>> listarEquipo() throws Exception {

		List<Equipo> a = new ArrayList<Equipo>();
		List<ImplementoDTO> ma = new ArrayList<ImplementoDTO>();

		a = vagonlogic.getEquipo();

		if (a != null && a.size() > 0) {

			for (Equipo mEquipo : a) {
				
				if(mEquipo.getCategoriaEquipo() !=null) {
					
					Long categId =  mEquipo.getCategoriaEquipo().getCategEquipId();
					CategoriaEquipo categ = businessDelegatorView.getCategoriaEquipo(categId);
					String funcion =categ.getFuncion();
					 
					if (mEquipo.getEstado().equals("A") && (funcion.equals("Implemento") || funcion.equals("Remolques/Vagones"))) {

						ImplementoDTO tmp = new ImplementoDTO();
						tmp.setImplementoId(mEquipo.getEquipoId());
						tmp.setCodigo(mEquipo.getCodigo());
						tmp.setNombre(mEquipo.getNombre());
						tmp.setCategEquipId_CategoriaEquipo(categId);
						ma.add(tmp);
					}

					
				}

			}

			return new ResponseEntity<List<ImplementoDTO>>(ma, HttpStatus.OK);

		} else {

			return new ResponseEntity<List<ImplementoDTO>>(HttpStatus.NO_CONTENT);
		}
		
		
	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}
	
	

}
