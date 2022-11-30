package test;

public class UserScoreData {
	String name;
	int score;

	public UserScoreData(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	public UserScoreData() {
		super();
	}

	@Override
	public String toString() {
		return "[name=" + name + ", score=" + score + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		long beforeTime = System.currentTimeMillis(); // 코드 실행 전에 시간 받아오기
		long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		long secDiffTime = (afterTime - beforeTime) / 1000; // 두 시간에 차 계산
		System.out.println("걸린시간 : " + secDiffTime);
		this.score = score;
	}

}
