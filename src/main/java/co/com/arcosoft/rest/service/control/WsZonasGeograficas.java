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

import co.com.arcosoft.modelo.ZonaGeografica;
import co.com.arcosoft.modelo.control.IZonaGeograficaLogic;
import co.com.arcosoft.rest.service.dto.ZonaGeograficaDTO;

@Controller
@RequestMapping("/catalogos")
public class WsZonasGeograficas {

	private static final Logger logger = LoggerFactory.getLogger(WsZonasGeograficas.class);

	@Autowired
	IZonaGeograficaLogic nivellogic;

	@RequestMapping(value = "/listarZonasGeograficas", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<ZonaGeograficaDTO>> listarZonaGeografica() throws Exception {

		List<ZonaGeografica> a = new ArrayList<ZonaGeografica>();
		List<ZonaGeograficaDTO> ma = new ArrayList<ZonaGeograficaDTO>();

		a = nivellogic.getZonaGeografica();

		if (a != null && a.size() > 0) {

			for (ZonaGeografica mZonaGeografica : a) {

				if (mZonaGeografica.getEstado().equals("A")) {

					ZonaGeograficaDTO tmp = new ZonaGeograficaDTO();
					tmp.setZonaGeograficaId(mZonaGeografica.getZonaGeograficaId());
					tmp.setCodigo(mZonaGeografica.getCodigo());
					tmp.setNombre(mZonaGeografica.getNombre());
					tmp.setCompania(mZonaGeografica.getCompania());
					ma.add(tmp);
				}

			}

			return new ResponseEntity<List<ZonaGeograficaDTO>>(ma, HttpStatus.OK);

		} else {

			return new ResponseEntity<List<ZonaGeograficaDTO>>(HttpStatus.NO_CONTENT);
		}

	}

}
