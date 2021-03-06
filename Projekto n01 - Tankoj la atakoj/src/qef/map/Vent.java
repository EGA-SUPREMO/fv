package qef.map;

import qef.Konstantj;
import qef.QefObjektj;

public class Vent {
	
	private static int temp = 0;
	
	public static void forigBrun(final double[] y) {
		final double[] novY = new double[y.length];
		
		temp++;
		
		if(temp>Konstantj.plejtempVent) {
			for(int i = 1; i < y.length-1; i++)
				novY[i] = (y[i-1] + y[i] + y[i+1])/3;
			novY[0] = (y[y.length-1] + y[0] + y[1])/3;
			novY[y.length-1] = (y[y.length-2] + y[y.length-1] + y[0])/3;
			System.arraycopy(novY, 0, y, 0, y.length);
			QefObjektj.map.setQmodifitn(true);
			temp = 0;
		}
	}
	
}