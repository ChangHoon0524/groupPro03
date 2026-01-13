package groupPro03;

import java.util.Scanner;


/*
B. 용돈관리 & 소비 패턴 분석
	사용자가 일정기간동안의 지출을 입력하면 지출 내역을 배열에 저장하고 종료 시 소비 패턴을 분석하는 프로그램
- 기능 요구사항
	지출입력 : 날짜 또는 순서 입력, 지출 항목 입력(식비/교통/쇼핑/기타), 지출 금액 입력
	지출할 때마다 배열에 저장 : 날짜 또는 순서 입력, 항목, 금액
	[분석 조건]
	아래 조건 중 최소 2개 이상 구현
	- 총 지출 금액 
	- 항목별 지출 합계
	- 특정 항목이 전체의 일정 비율 이상일 경우 경고
	- 지출 금액이 연속으로 증가하는 패턴 감지
	- 예산 초과 여부 판단
	종료 후 결과 출력 : 총 지출, 가장 많이 사용한 항목, 소비 습관 판단 메시지

-공통 필수 규칙
	배열 최소 2개 이상 사용
	팀원 전원 코드 작성 필수
	각 코드 영역에 담당자 이름, 기능 주석 필수
	본인 영역 외에 수정하면 안됨
	실행되지 않으면 안됨



역할분배 
기본 뼈대 및 입출력 - 창훈
총 지출 금액 기능 작업 - 준승
항목별 지출 합계 - 재민
특정 항목이 전체의 일정 비율 이상일 경우 경고 메시지 - 재원
지출 금액이 연속으로 증가하는 패턴 감지 - 명근
예산 초과 여부 판단 - 지수

[기초로직]
1. Scanner 클래스 import
2. 날짜(정수값)입력 받고 while 반복문 활용

 * 
 * */
public class GroupPro03 {
	public static void main(String[] args) {
		// 20260112 SCH 작성
		Scanner sc = new Scanner(System.in);
		// 입력 관련 처리
		// 일자 입력
		System.out.print("지출을 기록할 일일을 입력해주세요.(최소 1일) : ");
		int daysCount = sc.nextInt();
		// 예산 입력
		System.out.print("예산을 입력해주세요 : ");
		int budget = sc.nextInt();
		// 엔터 소진
		sc.nextLine();
		
		// 0이 들어왔을 때의 예외처리
		daysCount = daysCount <= 0 ? 1 : daysCount;
		int count = 0;
		
		// 지출항목 상수 선언
		// 기타 : 0, 식비 : 1, 교통 : 2, 쇼핑 : 3
		final int ETC = 0, EATTING = 1, TRANSPORT = 2, SHOPPING = 3;
		
		// 배열 선언
		// 지출금 내역 저장 배열
		int[] arrPaymentDetail = new int[daysCount];
		// 지출 사유 저장 배열
		int[] arrPayReason = new int[daysCount];		
		
		// 데이터 입력 처리		
		while(count < daysCount) {
			// 지출항목 입력
			System.out.print("지출 항목을 입력해주세요 : ");
			String payReason = sc.nextLine();
			// 지출항목 변수 선언
			int convertReason = 0;
			// 입력받은 지출 사유를 switch문으로 컨버트
			switch (payReason) {
			case "식비" -> convertReason = EATTING;
			case "교통" -> convertReason = TRANSPORT;
			case "쇼핑" -> convertReason = SHOPPING;
			default -> convertReason = ETC;
			}
			
			// n번째 일자에 지출 사유 저장 
			arrPayReason[count] = convertReason;
			
			// n번째 일자에 지출액 저장
			System.out.print("지출액을 입력해주세요 : ");
			arrPaymentDetail[count] = sc.nextInt();
			sc.nextLine();

			count++;
		}
		
		// 계산용 변수 선언
		// 총 지출 합 저장 변수
		int totalPaymentSum = 0;
		// 항목별 지출 합계 저장 배열
		int[] categoryPaymentSum = new int[4];
		// 지출 금액 연속 증가 여부 카운트 변수
		int increasePaymentCount = 0;
		// 최다 사용 항목
		String mostPayCategory = "";
		// 소비 습관 판단 메시지
		String payRoutineMsg = "";
		// 카테고리 이름 배열 - 변재원
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
					+ "\n 0. 시스템 종료");
			int optionSelect = sc.nextInt();
			
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


			// 예산 초과 여부 판단 기능 작업 시작 - (최종수정 260113 16:19)지수v0.2

			if (totalPaymentSum == 0) { // 분기별 노출 메시지 저장
				payRoutineMsg = "이번달 소비내역이 없습니다!"; // 지출 소비 자체가 0일때
			} else if (totalPaymentSum > budget) {
				payRoutineMsg = "예산초과 입니다!!";
			} else {
				payRoutineMsg = "안정적인 소비 습관입니다.";
            }
			
//			5번 옵션시 분기별 메시지 출력 추가
			
            if(optionSelect == 5) { // 5번 메뉴로 바로 진입시 노출
//            	System.out.println(); // 의미없음 가독성용
                if(totalPaymentSum == 0) {
                	System.out.println("\n이번달 소비내역이 없습니다\n");
                } else if(totalPaymentSum > budget) {
                	System.out.println("\n예산을 초과하는 소비가 잦습니다. 지출 관리가 필요합니다.\n");
                } else {
                	System.out.println("\n안정적인 소비 습관입니다.\n");
				}
//                System.out.println();//// 의미없음 가독성용
             }
            
			
			// 예산 초과 여부 판단 기능 작업 종료
		
		System.out.printf("총 지출 금액 : %d, 가장 많이 사용한 항목 : %s, 소비 습관 판단 메시지 : %s\n"
				, totalPaymentSum, mostPayCategory, payRoutineMsg);
		sc.close();
		}
	}
}
