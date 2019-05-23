package pl.wat.mgr.apteka.dao;

import pl.wat.mgr.apteka.model.Recepta;

public class ReceptaDao extends GenericDao<Recepta> {
	private static final long serialVersionUID = 9105104585837235875L;

	public ReceptaDao() {
		super(Recepta.class);
	}
}
