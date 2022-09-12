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

import co.com.arcosoft.modelo.EstPluvio;
import co.com.arcosoft.modelo.control.IEstPluvioLogic;
import co.com.arcosoft.rest.service.dto.EstPluvioDTO;



@Controller
@RequestMapping("/catalogos")
public class WsEstPluvio {

	private static final Logger logger = LoggerFactory.getLogger(WsEstPluvio.class);

	@Autowired
	IEstPluvioLogic datalogic;

	@RequestMapping(value = "/listarPluviometro", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<EstPluvioDTO>> listarPluviometro() throws Exception {

		List<EstPluvio> a = new ArrayList<EstPluvio>();
		List<EstPluvioDTO> ma = new ArrayList<EstPluvioDTO>();

		a = datalogic.getEstPluvio();

		if (a != null && a.size() > 0) {

			for (EstPluvio mU : a) {

				if (mU.getEstado().equals("A")) {

					EstPluvioDTO tmp = new EstPluvioDTO();
					tmp.setEstPluvioId(mU.getEstPluvioId());
					tmp.setCodigo(mU.getCodigo().trim());
					tmp.setNombre(mU.getNombre().trim());
					tmp.setCompania(mU.getCompania());
					ma.add(tmp);
				}

			}

			return new ResponseEntity<List<EstPluvioDTO>>(ma, HttpStatus.OK);

		} else {

			return new ResponseEntity<List<EstPluvioDTO>>(HttpStatus.NO_CONTENT);
		}

	}

}
