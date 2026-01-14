package groupProMethod;

public class GroupProClass
{
	// 지출항목 상수 선언
	// 기타 : 0, 식비 : 1, 교통 : 2, 쇼핑 : 3
	final int ETC = 0, EATTING = 1, TRANSPORT = 2, SHOPPING = 3;

	public int convertReasonToInt(String reason)
	{
		switch (reason)
		{
			case "식비":
				return EATTING;
			case "교통":
				return TRANSPORT;
			case "쇼핑":
				return SHOPPING;
			default:
				return ETC;
		}
	}
	
	public String convertReasonToString(int reason) {
		switch(reason) {
			case EATTING:
				return "식비";
			case TRANSPORT:
				return "교통";
			case SHOPPING:
				return "쇼핑";
			default:
				return "기타";
		}
	}

	// 입력받은 스트링을 int로 파싱
	public int inputInt(String str)
	{
		int parseInt = 0;
		try
		{
			parseInt = Integer.parseInt(str);
		}
		catch (NumberFormatException ex)
		{
			System.out.println("잘못 입력하셨습니다");
		}

		return parseInt;
	}

	// 지출 금액이 연속으로 증가하는 패턴 감지 기능
	void increaseCalc(int[] ar, int count) {
		// 2) 금액들을 저장할 문자열 선언
		String increasedAmounts = "";
		// 3) for문으로 현재 지출과 이전 지출을 비교
		// for문 (초기식 int i =1, 조건식 i < 지출금내역 저장 배열의 길이,증감식++)
		for (int i = 1; i < ar.length; i++) {
			//4) 지금 확인하는 지출액이 이전 지출액보다 크다면 아래 코드 실행
			if (ar[i] > ar[i - 1]) {
				//5-1)연속 증가 카운트 변수가 0일때는 문자열에 "\n" + 이전 지출액 + " - " + 지금 확인하는 지출액을 문자열에 더해 저장해줌
				if (count == 0) {
					increasedAmounts += "\n" + ar[i - 1] + " - " + ar[i];
				} else {
					//5-2) 아닐땐 문자열에 " - " + 지금 확인하는 지출액을 문자열에 더해 저장해줌
					increasedAmounts += " - " + ar[i];
				}
				//6) 연속 증가 카운트 변수를 1회 늘려줌
				count++;
			} else {
				//7) 지금 확인하는 지출액이 이전 지출액보다 크지 않다면 연속 증가 카운트 변수를 0으로 초기화
				count = 0;
			}
		} // for
		//8)금액들을 저장할 문자열이 빈칸이 아니라면 문자열을 출력해 지출액이 증가한 내역들을 표시
		if (increasedAmounts != "") {
			System.out.print("------지출 금액 증가 패턴------");
			System.out.println(increasedAmounts);
		}

		System.out.println("\n------지출 금액 연속 증가 여부 확인------");
		//9) 만약 연속 증가 카운트 변수가 1보다 크다면 최근 몇번 지출금액이 증가했는지 메세지 출력
		if (count > 1) {
			System.out.println("최근 지출금액이 " + count + "회 연속으로 증가했습니다\n");
		} else {
			//10) 아니라면 연속으로 증가하지 않았다고 출력
			System.out.println("최근 지출금액이 연속적으로 증가하지 않았습니다\n");
		}
	}

}
