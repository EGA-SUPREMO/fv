package qef.uzantinterfac;

import java.awt.Rectangle;

import qef.Konstantj;
import qef.QefObjektj;
import qef.ilj.Bildperant;
import qef.ilj.DebugDesegn;

public class Buton extends Komponant {
	
	//public static int selektit = 0;
	protected int spec;
	public final int unukolor, dukolor;
	public int statDeLaMenu;
	public final static int LARGX_BUTON = Konstantj.ludLargx/3;//Konstantj.duonLudLargx;
	public boolean qalt;
	public int temp;
	private boolean pulsit;
	
	public Buton(final int xo, final int yo, final int largxo, final int koloro, final int dukoloro, final int stato,
			final String texto) {
		super(xo, yo, largxo, 2, koloro, texto);
		unukolor = koloro;
		dukolor = dukoloro;
		spec = 0;
		statDeLaMenu = stato;
		alt = Konstantj.KOMENC_MENU_ALT_BUTON;
		kolici = new Rectangle(xo, yo, largxo, alt);
		qalt = false;
		pulsit = false;
		temp = 0;
		definigBildn();
	}
	public Buton(final int xo, final int yo, final int largxo, final int alto, final int koloro, final int dukoloro,
			final int stato, final String texto) {
		super(xo, yo, largxo, 2, koloro, texto);
		unukolor = koloro;
		dukolor = dukoloro;
		spec = 0;
		statDeLaMenu = stato;
		alt = alto;
		kolici = new Rectangle(xo, yo, largxo, alto);
		qalt = true;
		pulsit = false;
		temp = 0;
		definigBildn();
	}
	
	public void yangxKolor() {
		if(kolor != dukolor) {
			kolor = dukolor;
			qgxisdatig = true;
		}
	}
	public void resetButonn() {
		if(kolor == dukolor) {
			kolor = unukolor;
			y -= spec*4;
			spec = 0;
			qgxisdatig = true;
		}
	}
	public void setSpec(final int speco) {
		if(spec == speco)
			return;
		if(speco==0) {
			kolor = unukolor;
			y -= 4;
		} else if(speco==1) {
			kolor = dukolor;
			y += 4;
		}
		spec = speco;
		qgxisdatig = true;
	}
	public void resetSpecn() {
		if(spec == 1) {
			temp = 0;
			spec = 0;
			y -= 4;
			qgxisdatig = true;
		}
		pulsit = true;
	}
	public void resetKolorn() {
		if(kolor == dukolor) {
			kolor = unukolor;
			qgxisdatig = true;
		}
	}
	
	@Override
	public void desegn() {
		DebugDesegn.desegnKomponantn(bild, x, y);
	}

	@Override
	public void gxisdatig() {
		
		final Rectangle muy = QefObjektj.superfic.muyn().rectangleReskalitPosicin();
		if(muy.intersects(kolici)) {
			yangxKolor();
			if(QefObjektj.superfic.muyn().qclickn()) {
				setSpec(1);
			}
		} else
			resetButonn();
		
		if(spec!=0)
			if(temp++>Konstantj.KOMENC_MENU_DUONBUTONPLEJTEMP) {
				resetSpecn();
			}

		definigBildn();
	}
	
	public int specn() {
		return spec;
	}
	public boolean pulsitn() {
		final boolean pulsit1 = pulsit;
		pulsit = false;
		return pulsit1;
	}
	@Override
	public void setAltn(final int alto) {
		super.setAltn(alto);
		qalt = true;
	}
	@Override
	public void definigBildn() {
		if(qgxisdatig) {
			
			bild = Bildperant.kreButon(largx, kolor, spec, kolor==dukolor ? 1:0, text);
			if(qalt)
				bild = Bildperant.yangxButonAltn(bild, alt, spec);
			
			aldonAldonayjn(spec);
			qgxisdatig = false;
		}
	}
	
}