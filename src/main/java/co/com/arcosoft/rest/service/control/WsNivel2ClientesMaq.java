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

import co.com.arcosoft.modelo.Nivel2Clientesmq;
import co.com.arcosoft.modelo.control.INivel2ClientesmqLogic;
import co.com.arcosoft.rest.service.dto.Nivel2ClientesMaqDTO;

@Controller
@RequestMapping("/catalogos")
public class WsNivel2ClientesMaq {
	public WsNivel2ClientesMaq() {
		// TODO Auto-generated constructor stub
	}


	private static final Logger logger = LoggerFactory.getLogger(WsNivel2ClientesMaq.class);

	@Autowired
	INivel2ClientesmqLogic nivellogic;

	@RequestMapping(value = "/listarNivel2ClientesMaq", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Nivel2ClientesMaqDTO>> listarNivel2Clientesmq() throws Exception {

		List<Nivel2Clientesmq> a = new ArrayList<Nivel2Clientesmq>();
		List<Nivel2ClientesMaqDTO> ma = new ArrayList<Nivel2ClientesMaqDTO>();

		a = nivellogic.getNivel2Clientesmq();

		if (a != null && a.size() > 0) {

			for (Nivel2Clientesmq mNivel2Clientesmq : a) {

				if (mNivel2Clientesmq.getEstado().equals("A")) {

					Nivel2ClientesMaqDTO tmp = new Nivel2ClientesMaqDTO();
					tmp.setNivel2ClientesmqId(mNivel2Clientesmq.getNivel2ClientesmqId());
					tmp.setCodigo(mNivel2Clientesmq.getCodigo());
					tmp.setNombre(mNivel2Clientesmq.getNombre());
					
					tmp.setCompania(mNivel2Clientesmq.getCompania());
					tmp.setPersEmprId_PersEmpr(mNivel2Clientesmq.getPersEmpr().getPersEmprId());
					ma.add(tmp);
				}

			}

			return new ResponseEntity<List<Nivel2ClientesMaqDTO>>(ma, HttpStatus.OK);

		} else {

			return new ResponseEntity<List<Nivel2ClientesMaqDTO>>(HttpStatus.NO_CONTENT);
		}

	}

}
