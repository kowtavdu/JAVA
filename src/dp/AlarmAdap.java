package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Alarm{
	
	Alarm(String alt, String als, String ald){
		this.alarmSeverity = als;
		this.alarmType = ald;
		this.alarmTime = alt;
	}
	String alarmType;
	public String getAlarmType() {
		return alarmType;
	}
	public void setAlarmType(String alarmType) {
		this.alarmType = alarmType;
	}
	public String getAlarmSeverity() {
		return alarmSeverity;
	}
	public void setAlarmSeverity(String alarmSeverity) {
		this.alarmSeverity = alarmSeverity;
	}
	public String getAlarmTime() {
		return alarmTime;
	}
	public void setAlarmTime(String alarmTime) {
		this.alarmTime = alarmTime;
	}
	
	public String toString(){
		return "["+alarmSeverity+"---"+alarmType+"---"+alarmTime+"]";
		
	}
	
	String alarmSeverity;
	String alarmTime;
}

class RawAlarm{
	String alaram;
	public String getAlaram() {
		return alaram;
	}
	public void setAlaram(String alaram) {
		this.alaram = alaram;
	}
	RawAlarm(String a){
	 this.alaram = a;	
	}	
}

interface alarmAdap {
	public Alarm snmpAlarm(String msg);
	public Alarm restAlarm(String msg);
}

class AlaramAdaImpl implements alarmAdap{

	@Override
	public Alarm snmpAlarm(String msg) {
		RawAlarm aa  = new RawAlarm(msg);
		String[] str =  result(aa.getAlaram());
		return new Alarm(str[0],str[2],str[3]);
	}

	@Override
	public Alarm restAlarm(String msg) {
		RawAlarm aa  = new RawAlarm(msg);
		String[] str =  result(aa.getAlaram());
		return new Alarm(str[0],str[2],str[3]);
	}
	
	public String[] result(String msg){
		String[] ll = msg.split(":");
		return ll;
	}
	
}

public class AlarmAdap {

	static Alarm getAlarm(alarmAdap adp, String msg){
		
		if(msg.contains("SNMP")){
			return adp.snmpAlarm(msg);
		}else if(msg.contains("REST")){
			return adp.snmpAlarm(msg);
		}else{
		   throw new RuntimeException("Not a Valid Alaram");	
		}
		
		
	}
	public static void main(String[] args) {
		alarmAdap adap = new AlaramAdaImpl();
		String rawAlarm = "SNMP:MIB[1,2,3,4,,6,7,7,9,8,]:high:12PM";
		Alarm am = getAlarm(adap, rawAlarm);
		System.out.println(am);
		
		String rawAlarm2 = "REST:restconf/supported:low:12PM";
		Alarm am2 = getAlarm(adap, rawAlarm2);
		System.out.println(am2);
		
		String rawAlarm3 = "SNMP:MIB[1,2,3,4,,6,7,7,9,8,]:low:9PM";
		Alarm am3 = getAlarm(adap, rawAlarm3);
		System.out.println(am3);
	}
}
