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

import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.control.IUdadMedLogic;
import co.com.arcosoft.rest.service.dto.UdadMedDTO;

@Controller
@RequestMapping("/catalogos")
public class WsUdadMed {

	private static final Logger logger = LoggerFactory.getLogger(WsUdadMed.class);

	@Autowired
	IUdadMedLogic datalogic;

	@RequestMapping(value = "/listarUdadMeds", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<UdadMedDTO>> listarUdadMeds() throws Exception {

		List<UdadMed> a = new ArrayList<UdadMed>();
		List<UdadMedDTO> ma = new ArrayList<UdadMedDTO>();

		a = datalogic.getUdadMed();

		if (a != null && a.size() > 0) {

			for (UdadMed mU : a) {

				if (mU.getEstado().equals("A")) {

					UdadMedDTO tmp = new UdadMedDTO();
					tmp.setUdadMedId(mU.getUdadMedId());
					tmp.setCodigo(mU.getCodigo().trim());
					tmp.setNombre(mU.getNombre().trim());
					ma.add(tmp);
				}

			}

			return new ResponseEntity<List<UdadMedDTO>>(ma, HttpStatus.OK);

		} else {

			return new ResponseEntity<List<UdadMedDTO>>(HttpStatus.NO_CONTENT);
		}

	}

}
