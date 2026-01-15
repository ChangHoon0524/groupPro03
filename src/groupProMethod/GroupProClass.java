package groupProMethod;

public class GroupProClass{
//	- 항목별 사용 횟수 총합 구하기 매서드
//	1. 리턴타입 설정
//	2. 매개변수 설정(지출 사유 배열, 지출 횟수 배열)
//	3. 지출 사유 분류
//		-for문(초기식 : i = 0, 조건식 : i < 지출 횟수, 증감식 : i++)
//				1.switch문
//				- 조건 : 지출사유 = 1 (식비)
//					1. 식비 1업 (인덱스 = 1)
//				- 조건 : 지출사유 = 2(교통)
//					1. 교통 1업 (인덱스 = 2)
//				- 조건 : 지출사유 = 3 (쇼핑)
//					1. 쇼핑 1업 (인덱스 = 3)
//				- 그 외
//					1. 기타 1업
//	4. 리턴 : 항목별 사용 횟수 배열
//
	int[] categoryCountup(int[] PayReason) { // 지출 사유, 지출 횟수 
		int[] categoryCount = new int[4];
		for(int i = 0; i < PayReason.length; i++) {
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
	
	
	//- 항목별 지불 액 총합 구하기 매서드
//	1. 리턴타입 설정
//	2. 매개변수 설정(지출 사유 배열, 지출 비용 배열)
//	3. 지출 사유 분류
//		-for문(초기식 : i = 0, 조건식 : i < 지출 횟수, 증감식 : i++)
//				1.switch문
//				- 조건 : 지출사유 = 1 (식비)
//					1. 식비 지불 배열[1] += 지출 비용 배열[i]
//				- 조건 : 지출사유 = 2(교통)
//					1. 교통 지불 배열[2] += 지출 비용 배열[i]
//				- 조건 : 지출사유 = 3 (쇼핑)
//					1. 쇼핑 지불 배열[3] += 지출 비용 배열[i]
//				- 그 외
//					1. 기타 지불 배열[3] += 지출 비용 배열[i]
//	4. 리턴 : 항목별 지불 배열	
	
	
	//항목별 사용 금액 증가
	int[] categoryPaySum(int[] PayReason, int[] arrPaymentDetail) { //지출 사유, 지출 액, 지출 횟수
		int[] categoryPayment = new int[4];
		for(int i = 0; i < PayReason.length; i++) {
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
	

	//- 항목별 횟수와 지불비용 출력 메서드
//		1. 리턴타입 설정
//		2. 매개변수 설정(항목별 사용횟수 총합 배열, 항목별 지용비율 총합 배열)
//		3. 항목 사용 횟수 설정
//			- for문(추기 : i = 0, 조건: i < 항목 갯수, 증감: i++)
//				1. 항목별 사용 횟수 출력
//		4. 항목 지불비용 설정
//			- for문(추기 : i = 0, 조건: i < 항목 갯수, 증감: i++)
//				1. 항목별 지불 비용 출력
		
	//항목별 사용 횟수와 사용 금액 출력
	void categoryPayPrint(int[] categoryCount, int[] categoryPayment) {
		System.out.println("기타\t식비\t교통\t쇼핑");
		for(int i = 0; i < categoryCount.length; i++) { 
			System.out.print(categoryCount[i] + "번\t");	//항목 사용 횟수
		}//for
	
		System.out.println();
		for(int i = 0; i < categoryCount.length; i++) {
			System.out.print(categoryPayment[i] + "\t");	//항목별 총 금액
		}//for
	
		System.out.println();
	}
	
}
