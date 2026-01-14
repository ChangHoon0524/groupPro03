package groupProMethod;

public class GroupProClass
{
	// 지출항목 상수 선언
	// 기타 : 0, 식비 : 1, 교통 : 2, 쇼핑 : 3
	final int ETC = 0, EATTING = 1, TRANSPORT = 2, SHOPPING = 3;

	// String 소비사유를 int로 전환하는 메소드
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
	
	// int 소비사유를 String으로 전환하는 메소드
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
	
	// 항목별 지출횟수 or 합계 구하는 메소드
	public int[] getCategoryCountArray(int[][] payments, int[][]reasons, boolean isCalcSum)
	{
		int[] arrCategory = new int[4];
		for(int i = 0 ; i < payments.length; i++)
		{
			for(int j = 0; j < payments[i].length; j++)
			{
				if(payments[i][j] == 0 || reasons[i][j] == 0)
				{
					break;
				}
				
				switch(reasons[i][j])
				{
					case EATTING :
						{
							int num = isCalcSum ? arrCategory[EATTING] + payments[i][j] : arrCategory[EATTING] + 1;
							arrCategory[EATTING] = num;
							break;
						}
					case SHOPPING : 
					{
						int num = isCalcSum ? arrCategory[SHOPPING] + payments[i][j] : arrCategory[SHOPPING] + 1;
						arrCategory[SHOPPING] = num;
						break;
					}
					case TRANSPORT : 
					{
						int num = isCalcSum ? arrCategory[TRANSPORT] + payments[i][j] : arrCategory[TRANSPORT] + 1;
						arrCategory[TRANSPORT] = num;
						break;
					}
					default : {
						int num = isCalcSum ? arrCategory[ETC] + payments[i][j] : arrCategory[ETC] + 1;
						arrCategory[ETC] = num;
						break;
					}
				}
				
			}
		}
		return arrCategory;
	}
}
