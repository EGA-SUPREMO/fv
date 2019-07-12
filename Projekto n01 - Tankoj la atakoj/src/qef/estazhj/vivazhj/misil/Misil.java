package qef.estazhj.vivazhj.misil;

import java.awt.Color;
import java.awt.Rectangle;

import qef.Konstantj;
import qef.QefObjektj;
import qef.estazhj.vivazhj.Vivazh;
import qef.ilj.DebugDesegn;
import qef.ilj.Kvantperant;
import qef.ilj.Vicperant;

public class Misil extends Vivazh {
	
	protected final double damagxLargxX;
	protected final int komencDamagxX;
	protected final int damagxaltec;
	protected final int grandec;
	public final KalkuliTrajektn trajekt;
	public final int ludant;
	private final Rectangle[] kolicij;
	private boolean qneelir, qelir;

	public Misil(final int ekangulo, final int potenco, final int damagxo, final double ekXo,
			final double ekYo) {
		super(1, damagxo, Konstantj.ITENER_SON_MISIL);
		
		grandec = (int) Math.sqrt(damagx);
		largxVivazh = grandec;
		altVivazh = grandec;
		
		damagxLargxX = damagx;
		komencDamagxX = (int) (damagxLargxX/2);
		damagxaltec = (int) (damagx*0.7 * QefObjektj.map.mldurec);
		ludant = Vicperant.nunLudantn();
		
		setXn(ekXo);
		setYn(ekYo);
		
		trajekt = new KalkuliTrajektn(this, QefObjektj.map.ventn(), ekangulo, potenco);
		
		qneelir = true;
		kolicij = new Rectangle[Vicperant.ludantj.length];
		for(int i = 0; i < Vicperant.ludantj.length; i++)
			kolicij[i] = Vicperant.ludantj[i].nunposiciare();
	}
	
	public Misil(final KalkuliTrajektn trajekto,final int damagxo, final double ekXo, final double ekYo) {
		super(1, damagxo, Konstantj.ITENER_SON_MISIL);
		
		grandec = (int) Math.sqrt(damagx);
		
		damagxLargxX = damagx;
		komencDamagxX = (int) (damagxLargxX/2);
		damagxaltec = (int) (damagx*0.7 * QefObjektj.map.mldurec);
		ludant = Vicperant.nunLudantn();
		
		setXn(ekXo);
		setYn(ekYo);
		
		trajekt = trajekto;
		
		qneelir = true;
		kolicij = new Rectangle[Vicperant.ludantj.length];
		for(int i = 0; i < Vicperant.ludantj.length; i++)
			kolicij[i] = Vicperant.ludantj[i].nunposiciare();
	}

	@Override
	public void gxisdatig() {
		for(int i = 0; i < 10; i++)
			if(yn() >= QefObjektj.map.yn()[(int) xn()] && qnekolici()) {
				trajekt.executShotn();
			} else {
				exploci();
				
				for(int j = 0; j < Vicperant.ludantj.length; j++)
					Vicperant.ludantj[j].setYn(QefObjektj.map.yn()[(int) Vicperant.ludantj[j].xn()]);
				break;
			}
	}
	private boolean qnekolici() {
		for(int i = 0; i < kolicij.length; i++) {
			if(kolicij[i].intersects(new Rectangle((int) xn(), (int) yn(), largxVivazh, altVivazh))) {
				if(i == ludant && qneelir) {
					qelir = false;
					continue;
				}
				if(Vicperant.ludantj[i].vivn()!=0 && !qneelir)
					return false;
			}
		}
		if(qelir && qneelir)
			qneelir = false;
		else
			qelir = true;
		return true;
	}

	@Override
	public void desegn() {
		DebugDesegn.desegnOval((int) Kvantperant.koordenadXalekranPosicin(xn()),
				(int) Kvantperant.koordenadYalekranPosicin(yn()), grandec, grandec, Color.BLACK);
	}
	
	public void exploci() {
		mlkonstruMapn();
		mlgajnVivDeludantj();
		venontVicn();
	}
	
	protected void mlkonstruMapn() {
		for(int i = -komencDamagxX; i < komencDamagxX; i++)
			QefObjektj.map.setYn((int) xn() + i, QefObjektj.map.yn((int) xn() + i) -
					Math.sin(Math.PI*(i+komencDamagxX)/damagxLargxX)*damagxaltec);
	}
	
	protected void mlgajnVivDeludantj() {
		for(int i = 0; i < Vicperant.ludantj.length; i++) {
			double distanc = Kvantperant.kakulDistancn((int) xn(), (int) yn(),
					(int) Vicperant.ludantj[i].xn(), (int) Vicperant.ludantj[i].yn());
			final double dudistanc = QefObjektj.map.yn().length - distanc;
			
			distanc = distanc<dudistanc? distanc: dudistanc;
			
			final double damagxX = damagxLargxX + (Vicperant.ludantj[i].largxVivazhn()>>1);
			
			if(distanc <= damagxX) {
				final double potenc = (damagxX - distanc)/damagxX;
				Vicperant.ludantj[i].mlgajnVivn(Math.pow(potenc*damagx, 2)/(damagx*damagx)*damagx, damagx, ludant);
			}
			
		}
	}
	protected void venontVicn() {
		Vicperant.setNunMisiln(null);
		Vicperant.venontNunLudantn();
	}
	
}