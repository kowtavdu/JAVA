package dp;

interface Statement {
	public void getAccountDetail();
	public void getDetailForMonth();
}

class MiniStatement implements Statement{

	@Override
	public void getAccountDetail() {
		// TODO Auto-generated method stub
		System.out.println("Called in ministatement getAccountDetail");
		
	}

	@Override
	public void getDetailForMonth() {
		// TODO Auto-generated method stub
		System.out.println("Called in ministatement +getDetailForMonth");
	}
	
}

class DetailStatement implements Statement{

	@Override
	public void getAccountDetail() {
		// TODO Auto-generated method stub
		System.out.println("Called in DetailStatement getAccountDetail ");
	}

	@Override
	public void getDetailForMonth() {
		// TODO Auto-generated method stub
		System.out.println("Called in DetailStatement getDetailForMonth ");
	}
	
}

public class FactoryD {
	
	static Statement getStatementInstance(String str){
		if(str=="mini"){
			return new MiniStatement(); 
		}else{
			return new DetailStatement();
		}
	}
	
	public static void main(String[] args) {
	
		Statement str = FactoryD.getStatementInstance("nin");
		str.getAccountDetail();
		
	}

}
