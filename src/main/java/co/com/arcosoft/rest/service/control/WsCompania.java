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

import co.com.arcosoft.modelo.Compania;
import co.com.arcosoft.modelo.control.ICompaniaLogic;
import co.com.arcosoft.rest.service.dto.CompaniaDTO;

@Controller
@RequestMapping("/catalogos")
public class WsCompania {

	private static final Logger logger = LoggerFactory.getLogger(WsCompania.class);

	@Autowired
	ICompaniaLogic companialogic;

	@RequestMapping(value = "/listarCompania", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<CompaniaDTO>> listarCompanias() throws Exception {

		List<Compania> a = new ArrayList<Compania>();
		List<CompaniaDTO> ma = new ArrayList<CompaniaDTO>();

		a = companialogic.getCompania();

		if (a != null && a.size() > 0) {

			for (Compania mCompania : a) {

				if (mCompania.getEstado().equals("A")) {

					CompaniaDTO tmp = new CompaniaDTO();
					tmp.setCompaniaId(mCompania.getCompaniaId());
					tmp.setCodigo(mCompania.getCodigo());
					tmp.setNombre(mCompania.getNombre());
					if(mCompania.getTelefono() !=null) {
						tmp.setTelefono(mCompania.getTelefono());
					}else {
						tmp.setTelefono(".");
					}
					
					ma.add(tmp);
				}

			}

			return new ResponseEntity<List<CompaniaDTO>>(ma, HttpStatus.OK);

		} else {

			return new ResponseEntity<List<CompaniaDTO>>(HttpStatus.NO_CONTENT);
		}

	}

}
