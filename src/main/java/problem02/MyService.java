package problem02;

public class MyService extends BaseService {

	@Override
	public void service(String state) {
		if(state.equals("낮")) {
			System.out.println(day());
		}else if(state.equals("밤")) {
			System.out.println(night());
		}else {
			System.out.println(afternoon());
		}
	}

	@Override
	public String day() {
		return "낮서비스시작";
	}

	@Override
	public String night() {
		return "밤서비스시작";
	}

	public String afternoon() {
		return "오후서비스시작";
	}
}
