package co.com.arcosoft.dataaccess.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

@Service("AutocompletadoDAO")
public class AutocompletadoDAO implements IAutocompletadoDAO {

	@Resource
	private SessionFactory sessionFactory;

	public AutocompletadoDAO() {
		super();
	}

	@Override
	public List<String> consultarItemsPorModulo(String modulo) {

		Session session = sessionFactory.openSession();

		SQLQuery q = session.createSQLQuery("exec PR_ITEMS_MENU  :modulo");
		q.setString("modulo", modulo);

		// execute stored procedure and get list result
		List l = q.list();
		List<String> items = null;
		StringBuilder result = new StringBuilder();

		if (l.size() > 0) {

			items = new ArrayList<String>();

			for (Iterator it = l.iterator(); it.hasNext();) {

				// Object[] row = (Object[]) it.next();
				items.add(it.next().toString());

			}
		}

		return items;
	}

}
