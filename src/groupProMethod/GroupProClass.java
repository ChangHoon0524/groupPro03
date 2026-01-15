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
	
// 예산 초과 여부 판단 기능 작업 메소드 작업 - (최종수정 260114)지수v0.3
	
//	Consumer tendency Result = 소비성향결과
	
	public String ctResult(int totalPaymentSum, int budget ) {
		
		if (totalPaymentSum == 0) { // 분기별 노출 메시지 저장
			 // 지출 소비 자체가 0일때
			return  "이번달 소비내역이 없습니다";
		} else if (totalPaymentSum > budget) {
			//예산초과
			return  "예산을 초과하는 소비가 잦습니다. 지출 관리가 필요합니다.";
		} else {
			//예산 안정
			return  "안정적인 소비 습관입니다";
		}


	}
	
	public String ctResultD(int totalPaymentSum, int budget, int daysCount ) {
		
		if (totalPaymentSum == 0) { // 분기별 노출 메시지 저장
			// 지출 소비 자체가 0일때
			return  "이번달 소비내역이 없습니다";
		} else if (totalPaymentSum > budget) {
			//예산초과
			return  "예산을 초과하는 소비가 잦습니다." + daysCount+ "일동안 예산의 " + (totalPaymentSum-budget) + "원 초과하셨습니다";
		} else {
			//예산 안정
			return  "안정적인 소비 습관입니다";
		}
		
	}
	
}
	
	






