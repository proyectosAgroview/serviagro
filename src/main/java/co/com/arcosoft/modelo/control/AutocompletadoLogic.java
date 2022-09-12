package co.com.arcosoft.modelo.control;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.com.arcosoft.dataaccess.dao.IAutocompletadoDAO;

@Scope("singleton")
@Service("AutocompletadoLogic")
public class AutocompletadoLogic implements IAutocompletadoLogic {

	private static final Logger log = LoggerFactory.getLogger(AutocompletadoLogic.class);

	@Autowired
	private IAutocompletadoDAO autocompletadoDAO;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public List<String> consultarItemsPorModulo(String modulo) {
		return autocompletadoDAO.consultarItemsPorModulo(modulo);

	}

}
