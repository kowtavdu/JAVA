package dp;

class Volt{

	int volt;

	Volt(int v){
		this.volt = v;
	}
	public int getVolt() {
		return volt;
	}

	public void setVolt(int volt) {
		this.volt = volt;
	}
	
	
}


class WallSocket{
	
	public Volt getVoltProduce(){
		//System.out.println("Called in VoltProducer");
		return new Volt(120);
	}
}

interface MobileAdaptor{
	
	public Volt get3Volt();
	public Volt get120Volt();
	public Volt get240Volt();
}

class AdaptorImpl extends WallSocket implements MobileAdaptor{
	@Override
	public Volt get3Volt(){
		Volt v = getVoltProduce();
		return convertVolt(v, 40);
	}

	@Override
	public Volt get120Volt() {
		Volt v = getVoltProduce();
		// TODO Auto-generated method stub
		return convertVolt(v, 1);
	}

	@Override
	public Volt get240Volt() {
		// TODO Auto-generated method stub
		Volt v = getVoltProduce();
		return new Volt(2*v.getVolt());
	}
	
	public Volt convertVolt(Volt v, int division){
		//System.out.println("called in 3 volt------"+v.getVolt()+" ---- "+division);
		return new Volt(v.getVolt()/division);
	}
	}


public class AdaptorD {

	public static Volt getVolt(MobileAdaptor ma, int i){
		switch(i){
		
		case 3: return ma.get3Volt();
		case 120: return ma.get120Volt();
		case 240: return ma.get240Volt();
		default : return ma.get120Volt();
		}
	}
	public static void main(String[] args) {
		MobileAdaptor adap = new AdaptorImpl();
		Volt v3 = getVolt(adap,3);
		System.out.println("Get 120 VOLT "+v3.getVolt());
		System.out.println("Get 240 VOLT "+adap.get240Volt().getVolt());
	}
}
