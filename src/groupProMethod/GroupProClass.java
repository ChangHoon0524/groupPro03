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
}
