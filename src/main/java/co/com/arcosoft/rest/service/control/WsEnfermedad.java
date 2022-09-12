package co.com.arcosoft.rest.service.control;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.com.arcosoft.modelo.Fitosanidad;
import co.com.arcosoft.modelo.control.IFitosanidadLogic;
import co.com.arcosoft.modelo.dto.FitosanidadDTO;



@Controller
@RequestMapping("/catalogos")
public class WsEnfermedad {

	private static final Logger logger = LoggerFactory.getLogger(WsEnfermedad.class);

	@Autowired
	IFitosanidadLogic datalogic;

	@RequestMapping(value = "/listarEnfermedad", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<FitosanidadDTO>> listarEnfermedad() throws Exception {

		List<Fitosanidad> a = new ArrayList<Fitosanidad>();
		List<FitosanidadDTO> ma = new ArrayList<FitosanidadDTO>();

		a = datalogic.getFitosanidad();

		if (a != null && a.size() > 0) {

			for (Fitosanidad mU : a) {

				if (mU.getEstado().equals("A")) {

					FitosanidadDTO   tmp = new FitosanidadDTO();
					tmp.setFitosanidadId(mU.getFitosanidadId());
					tmp.setCodigo(mU.getCodigo());
					tmp.setNombre(mU.getNombre());
					tmp.setClaseFitosanidad(mU.getClaseFitosanidad());
					
					if(mU.getControlInsectos()!=null) {
					      tmp.setControlInsectos(mU.getControlInsectos());
					}else {
						  tmp.setControlInsectos("NO");
					}
					//tmp.setTipoFitosanidad(mU.getTipoFitosanidad());
					//tmp.setCultivos(mU.getCultivoFitosanidads().toString());
					tmp.setCompania(mU.getCompania());
					ma.add(tmp);
				}

			}

			return new ResponseEntity<List<FitosanidadDTO>>(ma, HttpStatus.OK);

		} else {

			return new ResponseEntity<List<FitosanidadDTO>>(HttpStatus.NO_CONTENT);
		}

	}

}
