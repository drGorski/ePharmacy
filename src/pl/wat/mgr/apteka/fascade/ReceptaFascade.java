package pl.wat.mgr.apteka.fascade;

import java.util.List;

import pl.wat.mgr.apteka.dao.ReceptaDao;
import pl.wat.mgr.apteka.model.PozycjaRecepty;
import pl.wat.mgr.apteka.model.Recepta;

public class ReceptaFascade {

	ReceptaDao rDao = new ReceptaDao();
	
	public List<Recepta> pobierzRecepty() {
		
		try {
			rDao.beginTransaction();
			return rDao.findAll();
		} finally {
			rDao.commitAndCloseTransaction();
		}
	}
	
	public void zapisz(Recepta r) {
		rDao.beginTransaction();
		rDao.save(r);
		rDao.commitAndCloseTransaction();
	}
	
	public void aktualizuj(Recepta r) {
		rDao.beginTransaction();
		rDao.update(r);
		rDao.commitAndCloseTransaction();
	}
	
	public boolean czyIstnieje(Recepta r) {
		
		try {
			rDao.beginTransaction();
			List<Recepta> list = rDao.findAll();
			for(Recepta rec : list) {
				if(rec.equals(r))
					return true;
			}
			
			return false;
		} finally {
			rDao.commitAndCloseTransaction();
		}
	}
	
	public Recepta uzupelnijId(Recepta nowa) {
		
		Recepta stara = find(nowa);
		nowa.setId(stara.getId());
		for(PozycjaRecepty n  : nowa.getSpecyfikacja()) {
			
			for(PozycjaRecepty s : stara.getSpecyfikacja()) {
				if(s.getNazwa().equals(n.getNazwa()))
					n.setId(s.getId());
			}
			
		}
		
		return nowa;
	}
	
	private Recepta find(Recepta r) {
		
		try {
			rDao.beginTransaction();
			List<Recepta> list = rDao.findAll();
			for(Recepta rec : list) {
				if(rec.equals(r))
					return rec;
			}
			
			return null;
		} finally {
			rDao.commitAndCloseTransaction();
		}

	}
	
}
