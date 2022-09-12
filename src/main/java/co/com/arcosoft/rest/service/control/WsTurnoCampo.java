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

import co.com.arcosoft.modelo.TurnoCampo;
import co.com.arcosoft.modelo.control.ITurnoCampoLogic;
import co.com.arcosoft.rest.service.dto.TurnoCampoDTO;

@Controller
@RequestMapping("/catalogos")
public class WsTurnoCampo {

	private static final Logger logger = LoggerFactory.getLogger(WsTurnoCampo.class);

	@Autowired
	ITurnoCampoLogic datalogic;

	@RequestMapping(value = "/listarTurnoCampo", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<TurnoCampoDTO>> listarTurnoCampo() throws Exception {

		List<TurnoCampo> a = new ArrayList<TurnoCampo>();
		List<TurnoCampoDTO> ma = new ArrayList<TurnoCampoDTO>();

		a = datalogic.getTurnoCampo();

		if (a != null && a.size() > 0) {

			for (TurnoCampo tc : a) {

				if (tc.getEstado().equals("A")) {

					TurnoCampoDTO tmp = new TurnoCampoDTO();
					tmp.setTurnoCampoId(tc.getTurnoCampoId());
					tmp.setCodigo(tc.getCodigo());
					tmp.setNombre(tc.getNombre());
					tmp.setHoraInicial(tc.getHoraInicial());
					tmp.setHoraFinal(tc.getHoraFinal());
					ma.add(tmp);
				}

			}

			return new ResponseEntity<List<TurnoCampoDTO>>(ma, HttpStatus.OK);

		} else {

			return new ResponseEntity<List<TurnoCampoDTO>>(HttpStatus.NO_CONTENT);
		}

	}

}
