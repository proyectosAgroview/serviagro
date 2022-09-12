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

import co.com.arcosoft.modelo.ConceptoNomina;
import co.com.arcosoft.modelo.control.IConceptoNominaLogic;
import co.com.arcosoft.rest.service.dto.ConceptoNominaDTO;

@Controller
@RequestMapping("/catalogos")
public class WsConceptoNomina {

	private static final Logger logger = LoggerFactory.getLogger(WsConceptoNomina.class);

	@Autowired
	IConceptoNominaLogic cnlogic;

	@RequestMapping(value = "/listarConceptoNomina", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<ConceptoNominaDTO>> listarConceptoNomina() throws Exception {

		List<ConceptoNomina> a = new ArrayList<ConceptoNomina>();
		List<ConceptoNominaDTO> ma = new ArrayList<ConceptoNominaDTO>();

		a = cnlogic.getConceptoNomina();

		if (a != null && a.size() > 0) {

			for (ConceptoNomina cn : a) {

				if (cn.getEstado().equals("A")) {

					ConceptoNominaDTO tmp = new ConceptoNominaDTO();

					tmp.setCeptoNominaId(cn.getCeptoNominaId());
					tmp.setCodigo(cn.getCodigo().trim());
					tmp.setNombre(cn.getNombre().trim());
					tmp.setCompania(cn.getCompania());

					ma.add(tmp);
				}

			}

			return new ResponseEntity<List<ConceptoNominaDTO>>(ma, HttpStatus.OK);

		} else {

			return new ResponseEntity<List<ConceptoNominaDTO>>(HttpStatus.NO_CONTENT);
		}

	}

}
