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

import co.com.arcosoft.modelo.Nivel1;
import co.com.arcosoft.modelo.control.INivel1Logic;
import co.com.arcosoft.rest.service.dto.Nivel1DTO;

@Controller
@RequestMapping("/catalogos")
public class WsNivel1 {

	private static final Logger logger = LoggerFactory.getLogger(WsNivel1.class);

	@Autowired
	INivel1Logic nivellogic;

	@RequestMapping(value = "/listarNivel1", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Nivel1DTO>> listarNivel1() throws Exception {

		List<Nivel1> a = new ArrayList<Nivel1>();
		List<Nivel1DTO> ma = new ArrayList<Nivel1DTO>();

		a = nivellogic.getNivel1();

		if (a != null && a.size() > 0) {

			for (Nivel1 mNivel1 : a) {

				if (mNivel1.getEstado().equals("A")) {

					Nivel1DTO tmp = new Nivel1DTO();
					tmp.setNivel1Id(mNivel1.getNivel1Id());
					tmp.setCodigo(mNivel1.getCodigo());
					tmp.setNombre(mNivel1.getNombre());
					tmp.setCompania(mNivel1.getCompania());
					ma.add(tmp);
				}

			}

			return new ResponseEntity<List<Nivel1DTO>>(ma, HttpStatus.OK);

		} else {

			return new ResponseEntity<List<Nivel1DTO>>(HttpStatus.NO_CONTENT);
		}

	}

}
