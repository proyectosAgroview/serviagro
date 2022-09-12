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

import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.control.INivel2Logic;
import co.com.arcosoft.rest.service.dto.Nivel2DTO;

@Controller
@RequestMapping("/catalogos")
public class WsNivel2 {

	private static final Logger logger = LoggerFactory.getLogger(WsNivel2.class);

	@Autowired
	INivel2Logic nivellogic;

	@RequestMapping(value = "/listarNivel2", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Nivel2DTO>> listarNivel2() throws Exception {

		List<Nivel2> a = new ArrayList<Nivel2>();
		List<Nivel2DTO> ma = new ArrayList<Nivel2DTO>();

		a = nivellogic.getNivel2();

		if (a != null && a.size() > 0) {

			for (Nivel2 mNivel2 : a) {

				if (mNivel2.getEstado().equals("A")) {

					Nivel2DTO tmp = new Nivel2DTO();
					tmp.setNivel2Id(mNivel2.getNivel2Id());
					tmp.setCodigo(mNivel2.getCodigo());
					tmp.setNombre(mNivel2.getNombre());
					tmp.setCompania(mNivel2.getCompania());
					tmp.setNivel1(mNivel2.getNivel1().getNivel1Id());
					ma.add(tmp);
				}

			}

			return new ResponseEntity<List<Nivel2DTO>>(ma, HttpStatus.OK);

		} else {

			return new ResponseEntity<List<Nivel2DTO>>(HttpStatus.NO_CONTENT);
		}

	}

}
