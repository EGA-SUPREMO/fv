package qef.estazhj.vivazhj;

import java.awt.Rectangle;

import qef.QefObjektj;
import qef.estazhj.Estazh;
import qef.son.Son;

public abstract class Vivazh implements Estazh {
	/*
	 * 
	 * 0:supre aux sube
	 * 1:maldekstre
	 * 2:dekstre
	 * 
	 */
	private double x, y;
	protected final Rectangle[] LIMJ;
	protected int nunBild;
	protected int brulazh;
	
	protected static final int KVANTSTATJ = 16;
	protected static final int rotaciplejNombr = KVANTSTATJ*2;
	protected static final double rotaci = 2*Math.PI/rotaciplejNombr;
	protected double rapidecX, rapidecY;
	
	protected int largxVivazh, altVivazh;
	protected int viv, plejviv;
	private int damagx;
	
	protected Son damagxit;
	protected long longDamagxit, venontDamagxit;

	public Vivazh(final int limj, final String itenerSon) {
		
		this.largxVivazh = 32;
		this.altVivazh = 32;
		this.nunBild = 0;
		this.rapidecX = 1;
		brulazh = 20000;
		x = 0;
		y = 0;
		viv = 100;
		plejviv = viv;
		damagx = 100;
		LIMJ = new Rectangle[limj];

		damagxit = new Son(itenerSon, 0);
		longDamagxit = damagxit.longsonn();
		
	}
	
	public Vivazh(final float rapidec, final int largxVivazh, final int altVivazh, final 
			int plejviv, final Rectangle[] limj, final String itenerSon) {
		
		this.largxVivazh = largxVivazh;
		this.altVivazh = altVivazh;
		this.nunBild = 0;
		this.rapidecX = rapidec;
		this.viv = plejviv;
		this.plejviv = plejviv;
		LIMJ = limj;

		damagxit = new Son(itenerSon, 0);
		longDamagxit = damagxit.longsonn();
	}
	
	protected void anim() {
		
	}

	protected void yangxMapn() {
	}
	
	protected boolean qnekolicie(final int direkt) {
/*		final int direktX;
		final int direktY;
		switch(direkt) {
			case 0:
				direktX = 0;
				direktY = -1;
				break;
			case 1:
				direktX = 0;
				direktY = 1;
				break;
			case 2:
				direktX = 1;
				direktY = 0;
				break;
			case 3:
				direktX = -1;
				direktY = 0;
				break;
			default:
				direktX = 0;
				direktY = 0;
		}
		
			
			final int origenX = area.x + (direktX * (int) rapidec << 1);
			final int origenY = area.y + (direktY * (int) rapidec << 1);
			
			/*final int origenX = area.x + direktX * (int) Math.round(rapidec) + 3 * (int) rapidec; //por fari pli reala
			final int origenY = area.y + direktY * (int) Math.round(rapidec) + 3 * (int) Math.round(rapidec);*/
			
			/*if (LIMJ[direkt].intersects(new Rectangle(origenX, origenY, Konstantj.SPRITELARGX, Konstantj.SPRITEALT))) {
				return false;
			}
		}*/
		return true;
	}
	@Override
	public void desegn() {}
	
	@Override
	public void gxisdatig() {}
	
	public double rapidecXn() {
		return rapidecX;
	}
	public void rapidecX(final float rapidec) {
		rapidecX = rapidec;
	}
	
	public int damagxn() {
		return damagx;
	}
	public int vivn() {
		return viv;
	}
	public int largxVivazhn() {
		return largxVivazh;
	}
	public int altVivazhn() {
		return altVivazh;
	}
/*	public Integer resistencn() {
		return resistenc;
	}*/

	public Rectangle[] LIMJN() {
		return LIMJ;
	}
	public double xn() {
		return x;
	}
	public double yn() {
		return y;
	}
	
	public void pliX() {
		x += rapidecX;
		if(x<QefObjektj.map.yn().length) {
		} else {
			x = rapidecX;
		}
		brulazh -= rapidecX;
	}
	public void pliY() {
		y += rapidecY;
		brulazh -= rapidecY;
	}
	public void mlpliX() {
		if(x>0) {
			x -= rapidecX;
		} else {
			x = QefObjektj.map.yn().length - rapidecX;
		}
		brulazh -= rapidecX;
	}
	public void mlpliY() {
		y -= rapidecY;
		brulazh -= rapidecY;
	}
	public void setXn(final double xo) {
		if(xo<0) {
			final int xFaktor = (int) (-xo/QefObjektj.map.yn().length + 0.9999);
			x = xFaktor*QefObjektj.map.yn().length + xo;
		} else if(xo > QefObjektj.map.yn().length) {
			final int xFaktor = (int) (xo/QefObjektj.map.yn().length);
			x = xo - xFaktor*QefObjektj.map.yn().length;
		} else
			x = xo;
	}
	public void setSenmidifXn(final double xo) {
		x = xo;
	}
	public void setSenmidifYn(final double yo) {
		y = yo;
	}
	public void setYn(final double y) {
		this.y = y;
	}
	public Rectangle nunposiciare() {
		return new Rectangle((int) x, (int) y, largxVivazh, altVivazh);
	}
	
	public void malgajnVivn(int damagx) {
		if(venontDamagxit <= 0) {
			damagxit.play();
			venontDamagxit = longDamagxit;
		}
		
        if (viv - damagx < 0)
            viv = 0;
        else
            viv -= damagx;
	}
	
}