package groupProMethod;

import java.util.Scanner;

public class GroupProMethodMain
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		GroupProClass gpc = new GroupProClass(); // class 추가
//		===================소비계획 입력 시작 ======================

		System.out.print("지출을 기록할 일일을 입력해주세요.(최소 1일) : ");
		int daysCount = gpc.inputInt(sc.nextLine());
		// 예산 입력// 예산 삭제 예정
		System.out.print("예산을 입력해주세요 : ");
		int budget = gpc.inputInt(sc.nextLine());

		daysCount = daysCount <= 0 ? 1 : daysCount; // 0이 들어왔을 때의 예외처리
		int count = 0;
				
//		===================변수 선언 ======================
		// 메인에 남길변수
		int[] arrPaymentDetail = new int[daysCount]; // 지출금 내역 저장 배열		
		int[] arrPayReason = new int[daysCount]; // 지출 사유 저장 배열		
		int totalPaymentSum = 0; // 총 지출 합 저장 변수
		String payRoutineMsg = ""; // 소비 습관 판단 메시지
		
		// 이 외의 변수들은 가능한 각자 메소드에서 처리해주세요.

//		================= 데이터 입력 처리	 ===================
		while(count < daysCount) {
			// 지출항목 입력
			System.out.printf("현재일자 : %d, 지출 항목을 입력해주세요 : ", count + 1);
			String payReason = sc.nextLine();
			// 지출항목 변수 선언
			int convertReason = 0;
			// 입력받은 지출 사유를 switch문으로 컨버트
			convertReason = gpc.convertReasonToInt(payReason);
			
			// n번째 일자에 지출 사유 저장 
			arrPayReason[count] = convertReason;
			
			// n번째 일자에 지출액 저장
			System.out.print("지출액을 입력해주세요 : ");
			arrPaymentDetail[count] = gpc.inputInt(sc.nextLine());
			count++;
		}
		
//		================= 메서드 작업 진행 영역	 ===================
		
		// 항목별 지출 합계 저장 배열
		// 카테고리별 합계 관련 메서드에서 별도 선언 예정
		int[] categoryPaymentSum = new int[4];
		// 지출 금액 연속 증가 여부 카운트 변수
		int increasePaymentCount = 0;
		// 카테고리 이름 배열 - 변재원
		// 3번기능 생성 과정에서 선언 예정 
		String[] categoryName = {"기타", "식비", "교통", "쇼핑"};
		

		// 항목별 지출 합계 기능 작업 시작 - 재민
//		- 항목별 지출 횟수 저장 변수	
		int[] categoryCountSum = new int[4];				//[기타] [식비] [교통] [쇼핑] 순
		
//		[로직]
//			1. 지출 사유 분류(for문)
//			- 초기식 : i = 0
//			- 조건식 : i < daysCount
//			- 증감식 : i++
		for(int i = 0; i < daysCount; i++) { 
//				1.switch문
			switch(arrPayReason[i]) {
//				- 조건 : arrPayReason[i] = 1
			case 1 :
//					1. 식비 변수 1업
				categoryCountSum[1]++;
//					2. categoryPaymentSum[1] + arrPaymentDetail[i]
				categoryPaymentSum[1] += arrPaymentDetail[i];
				continue;
//				- 조건 : arrPayReason[i] = 2
			case 2 :
//					1. 교통 변수 1업
				categoryCountSum[2]++;
//					2. categoryPaymentSum[2] + arrPaymentDetail[i]
				categoryPaymentSum[2] += arrPaymentDetail[i];
				continue;
//				- 조건 : arrPayReason[i] = 3
			case 3 :
//					1. 쇼핑 변수 1업
				categoryCountSum[3]++;
//					2. categoryPaymentSum[3] + arrPaymentDetail[i]
				categoryPaymentSum[3] += arrPaymentDetail[i];
				continue;
//				- 그 외
			default :
//					1. 기타 변수 1업
				categoryCountSum[0]++;
//					2.categoryPaymentSum[0] +arrPaymentDetail[i]
				categoryPaymentSum[0] += arrPaymentDetail[i];
				continue;
			}//switch

		}//for
	
		for (int i = 0; i < categoryPaymentSum.length; i++) { // 항목별 지출 합계가 담긴 배열의 크기만큼 반복한다.
			totalPaymentSum += categoryPaymentSum[i]; // 총 지출 합계 변수에 항목 별 지출 합계를 순차적으로 더해준다.
		}
		
		// 각종 기능 선택 및 연산(0 입력시 while문 종료)
		while(true)
		{
			System.out.print("기능을 선택 하세요."
					+ "\n 1. 총 지출 금액 출력"
					+ "\n 2. 항목별 지출 금액 출력"
					+ "\n 3. 항목별 지출 비율 체크"
					+ "\n 4. 지출 금액 연속 증가 여부 확인"
					+ "\n 5. 예산검정"
					+ "\n 0. 시스템 종료 :");
			int optionSelect = gpc.inputInt(sc.nextLine());
			
			// 종료 선택 시 반복종료
			if(optionSelect == 0)
			{
				break;
			}
			
			// 총 지출 금액 기능 작업 관련 시작 -준승
			if(optionSelect == 1) {
				System.out.println("총 지출금액은 " + totalPaymentSum);
			}
					
			// 총 지출 금액 기능 작업 관련 종료
			
			
			// 항목별 지출 합계 출력 기능 - 재민
			if(optionSelect == 2) {
//				1. 내용출력
				System.out.println("기타\t식비\t교통\t쇼핑");
				for(int i = 0; i < 4; i++) { 
					System.out.print(categoryCountSum[i] + "번\t");	//항목 사용 횟수
				}//for
				
				System.out.println();
				for(int i = 0; i < 4; i++) {
					System.out.print(categoryPaymentSum[i] + "\t");	//항목별 총 금액
				}//for
				
				System.out.println();
				
			}//if
			
			// 항목별 지출 합계 기능 작업 종료 
			
			
			// 특정 항목이 전체의 일정 비율 이상일 경우 경고 메시지 기능 작업 시작 - 재원
			if(optionSelect == 3) {      // 3번 옵션 선택 시 실행
	             double limitRate = 0.5;      // 경고 비율 지정
	             double[] categoryPerRate = new double[4];   // 카테고리 별 비율 배열

	             for(int i = 0; i < categoryPaymentSum.length; i++) {
	                 categoryPerRate[i] = (double)categoryPaymentSum[i] / totalPaymentSum;   // 항목 별 비율

	                 System.out.printf("%s : %.2f%% \n", categoryName[i], categoryPerRate[i] * 100);   // 항목별 비율출력

	                 if(categoryPerRate[i] >= limitRate) {
	                     System.out.println("!!!"+categoryName[i] + " 항목의 지출이 총 지출의 50%를 넘겼습니다!!!");      // 경고 메시지
	                 }
	             }
	         }
			
			// 특정 항목이 전체의 일정 비율 이상일 경우 경고 메시지 기능 작업 종료
			
			
			// 지출 금액이 연속으로 증가하는 패턴 감지 기능 작업 시작 - 명근

			// 1) optionSelect가 4라면 코드 실행
			if (optionSelect == 4) {

				// +) 금액들을 저장할 문자열 선언
				String increasedAmounts = "";

				// for문으로 현재 지출과 이전 지출을 비교
				// 2) for문 (초기식 int i =1, 조건식 arrPaymentDetail.length (지출금내역 저장 배열의 길이),증감식++)
				for (int i = 1; i < arrPaymentDetail.length; i++) {
					// 2-1) if(arrPaymentDetail[i] > arrPaymentDetail[i-1]) 이라면 / 지금 확인하는 지출액이 이전
					// 지출액보다 크다면
					if (arrPaymentDetail[i] > arrPaymentDetail[i - 1]) {

						// +) increasePaymentCount가 0일땐
						// => 문자열에 "\n" + 이전 지출액 + " - " + 지금 확인하는 지출액을 문자열에 더해 저장해줌
						if (increasePaymentCount == 0) {
							increasedAmounts += "\n" + arrPaymentDetail[i - 1] + " - " + arrPaymentDetail[i];
						} else {
							// +) 아닐땐 문자열에 " - " + 지금 확인하는 지출액을 문자열에 더해 저장해줌
							increasedAmounts += " - " + arrPaymentDetail[i];
						}

						// # 연속으로 증가한 횟수를 저장할 변수 - 미리 선언한 increasePaymentCount(연속 증가 카운트 변수)사용
						// 2-2) increasePaymentCount++; 로 증가횟수를 1회 늘려줌
						increasePaymentCount++;

					} else {
						// 2-3) else 로 증가하지 않았을때는 increasePaymentCount를 0으로 초기화
						increasePaymentCount = 0;
					}
				} // for

				// +) 금액들을 저장할 문자열이 빈칸이 아니라면
				if (increasedAmounts != "") {
					System.out.print("------지출 금액 증가 패턴------");
					// +) 문자열을 출력해 지출액이 증가한 내역들을 표시
					System.out.println(increasedAmounts);
				}

				System.out.println("\n------지출 금액 연속 증가 여부 확인------");
				// 3) 만약 increasePaymentCount가 1보다 크다면 최근 몇번 지출금액이 증가했는지 메세지 출력
				if (increasePaymentCount > 1) {
					System.out.println("최근 지출금액이 " + increasePaymentCount + "회 연속으로 증가했습니다\n");
				} else {
					// 3) 아니라면 연속으로 증가하지 않았다고 출력
					System.out.println("최근 지출금액이 연속적으로 증가하지 않았습니다\n");
				}
			}

			// 지출 금액이 연속으로 증가하는 패턴 감지 기능 작업 종료
			
//		================= 예산 초과 여부 판단 메소드 호출	 ===================
			payRoutineMsg = gpc.ctResult(totalPaymentSum,  budget);
			String ctResultMsg = gpc.ctResultD(totalPaymentSum,  budget, daysCount);

            if(optionSelect == 5)
            // 가독성 향상을 위한 줄바꿈 추가
            System.out.println(ctResultMsg);
		}
		// 예산 초과 여부 판단 기능 작업 종료		
		System.out.printf("총 지출 금액 : %d, 소비 습관 판단 메시지 : %s\n", totalPaymentSum, payRoutineMsg);
		
		sc.close();
	}
}
