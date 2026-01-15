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
	
	
// ------------------------------------------------------------------------------------------	
	
	//항목별 사용 횟수 증가
	int[] categoryCountup(int[] PayReason, int count) { // 지출 사유, 지출 횟수 
		int[] categoryCount = new int[4];
		for(int i = 0; i < count; i++) {
			switch(PayReason[i]) {
			case 1 :
				categoryCount[1]++;			//식비 1증가
				continue;
			case 2 :
				categoryCount[2]++;			//교통 1증가
				continue;
			case 3 :
				categoryCount[3]++;			//쇼핑 1증가
				continue;
			default :
				categoryCount[0]++;			//기타 1증가
				continue;
			}//switch
		}//for
		return categoryCount;				// 항목 수 총합(결과)
	}//categoryCountup
	
	
	
	
	//항목별 사용 금액 증가
	int[] categoryPaySum(int[] PayReason, int[] arrPaymentDetail, int count) { //지출 사유, 지출 액, 지출 횟수
		int[] categoryPayment = new int[4];
		for(int i = 0; i < count; i++) {
			switch(PayReason[i]) {
			case 1:
				categoryPayment[1] += arrPaymentDetail[i];		//식비 총합에 해당 순서의 지출액 추가
				continue;

			case 2:
				categoryPayment[2] += arrPaymentDetail[i];		//교통 총합에 해당 순서의 지출액 추가
				continue;
			
			case 3:
				categoryPayment[3] += arrPaymentDetail[i];		//쇼핑 총합에 해당 순서의 지출액 추가
				continue;
			
			default :
				categoryPayment[0] += arrPaymentDetail[i];		//기타 총합에 해당 순서의 지출액 추가
				continue;
			
			}
		}
		return categoryPayment;										//항목당 지출 총합(결과)
	}//categoryPaySum
	

	//항목별 사용 횟수와 사용 금액 출력
	void categoryPayPrint(int[] categoryCount, int[] categoryPayment) {
		System.out.println("기타\t식비\t교통\t쇼핑");
		for(int i = 0; i < 4; i++) { 
			System.out.print(categoryCount[i] + "번\t");	//항목 사용 횟수
		}//for
	
		System.out.println();
		for(int i = 0; i < 4; i++) {
			System.out.print(categoryPayment[i] + "\t");	//항목별 총 금액
		}//for
	
		System.out.println();
	}
	
}
