package qef.kontrolj;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

import qef.Konstantj;
import qef.estazhj.vivazhj.Ludant;
import qef.ilj.Vicperant;

public class Klavar extends KeyAdapter {

	public Klav supr = new Klav();
	public Klav sub = new Klav();
	public Klav dextr = new Klav();
	public Klav mldextr = new Klav();
	public boolean kuri = false;
	public boolean debug = false;
	public boolean aktivInventari = false;
	public boolean qkolekt = false;
	public boolean qatak = false;
	public boolean subiPotenc = false;
	public boolean supriPotenc = false;
	public boolean subiArmil = false;
	public boolean supriArmil = false;
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case Konstantj.SUPR:
				supr.puls();
				break;
			case Konstantj.SUB:
				sub.puls();
				break;
			case Konstantj.DEXTR:
				dextr.puls();
				break;
			case Konstantj.MLDEXTR:
				mldextr.puls();
				break;
			case Konstantj.KURI:
				kuri = true;
				Konstantj.ANGULRAPIDEC = 3;
				break;
			case Konstantj.SUBIPOTENC:
				subiPotenc = true;
				break;
			case Konstantj.SUPRIPOTENC:
				supriPotenc = true;
				break;
			case Konstantj.DEBUG:
				debug = !debug;
				break;
			case Konstantj.AKTIV_INVENTARI:
				aktivInventari = !aktivInventari;
				break;
			case Konstantj.QKOLEKT:
				qkolekt = true;
				break;
			case Konstantj.ATAKI:
				if(Vicperant.nunMisiln()==null)
					qatak = true;
				break;
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
			case Konstantj.SUPR:
				supr.mlpuls();
				break;
			case Konstantj.SUB:
				sub.mlpuls();
				break;
			case Konstantj.DEXTR:
				dextr.mlpuls();
				break;
			case Konstantj.MLDEXTR:
				mldextr.mlpuls();
				break;
			case Konstantj.SUBIPOTENC:
				subiPotenc = false;
				break;
			case Konstantj.SUPRIPOTENC:
				supriPotenc = false;
				break;
			case Konstantj.SUBIARMIL:
				if(Vicperant.nunMisiln()==null)
					subiArmil = true;
				break;
			case Konstantj.SUPRIARMIL:
				if(Vicperant.nunMisiln()==null)
					supriArmil = true;
				break;
			case Konstantj.KURI:
				Konstantj.ANGULRAPIDEC = 1;
				for(int i = 0; i < Vicperant.ludantj.length; i++)
					Vicperant.ludantj[i].rapidecX = 1;
				kuri = false;
				break;
			case Konstantj.ELIRI:
				elir();
				break;
			case Konstantj.REKOMENCI:
				Ludant.teleir();
				break;
			case Konstantj.QKOLEKT:
				qkolekt = false;
				break;
		}
	}
	
	public void elir() {
		System.exit(0);
	}
	
}