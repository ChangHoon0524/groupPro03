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
		// 식사 : 0, 교통 : 1, 쇼핑 : 2, 기타 : 3
		final int EATTING = 1, TRANSPORT = 2, SHOPPING = 3, ETC = 0;
		
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
			
			
			// 총 지출 금액 기능 작업 관련 종료
			
			
			// 항목별 지출 합계 기능 작업 시작 - 재민
			
			
			// 항목별 지출 합계 기능 작업 종료 
			
			
			// 특정 항목이 전체의 일정 비율 이상일 경우 경고 메시지 기능 작업 시작 - 재원
			
			
			// 특정 항목이 전체의 일정 비율 이상일 경우 경고 메시지 기능 작업 종료
			
			
			// 지출 금액이 연속으로 증가하는 패턴 감지 기능 작업 시작 - 명근
			
			
			// 지출 금액이 연속으로 증가하는 패턴 감지 기능 작업 종료
			
			
			// 예산 초과 여부 판단 기능 작업 시작 - 지수
			
			
			// 예산 초과 여부 판단 기능 작업 종료
		}
		
		System.out.printf("총 지출 금액 : %d, 가장 많이 사용한 항목 : %s, 소비 습관 판단 메시지 : %s\n"
				, totalPaymentSum, mostPayCategory, payRoutineMsg);
		sc.close();
	}
}
