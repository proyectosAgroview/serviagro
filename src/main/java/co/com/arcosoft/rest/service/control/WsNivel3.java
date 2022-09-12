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

import co.com.arcosoft.modelo.Nivel3;
import co.com.arcosoft.modelo.control.INivel3Logic;
import co.com.arcosoft.rest.service.dto.Nivel3DTO;

@Controller
@RequestMapping("/catalogos")
public class WsNivel3 {

	private static final Logger logger = LoggerFactory.getLogger(WsNivel3.class);

	@Autowired
	INivel3Logic nivellogic;

	@RequestMapping(value = "/listarNivel3", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Nivel3DTO>> listarNivel3() throws Exception {

		List<Nivel3> a = new ArrayList<Nivel3>();
		List<Nivel3DTO> ma = new ArrayList<Nivel3DTO>();

		a = nivellogic.getNivel3();

		if (a != null && a.size() > 0) {

			for (Nivel3 mNivel3 : a) {

				if (mNivel3.getEstado().equals("A")) {

					Nivel3DTO tmp = new Nivel3DTO();
					tmp.setNivel3Id(mNivel3.getNivel3Id());
					tmp.setCodigo(mNivel3.getCodigo());
					tmp.setNombre(mNivel3.getNombre());
					tmp.setCompania(mNivel3.getCompania());
					tmp.setNivel2(mNivel3.getNivel2().getNivel2Id());
					ma.add(tmp);
				}

			}

			return new ResponseEntity<List<Nivel3DTO>>(ma, HttpStatus.OK);

		} else {

			return new ResponseEntity<List<Nivel3DTO>>(HttpStatus.NO_CONTENT);
		}

	}

}
