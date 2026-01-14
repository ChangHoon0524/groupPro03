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
   
   
   void printPercent(int[] categoryPaymentSum, int totalPaymentSum) {
      double limitRate = 0.5;      // 경고 비율 지정
      String[] categoryName = {"기타", "식비", "교통", "쇼핑"};
      double[] categoryPerRate = new double[4];   // 카테고리 별 비율 배열

      for(int i = 0; i < categoryPaymentSum.length; i++) {
         categoryPerRate[i] = (double)categoryPaymentSum[i] / totalPaymentSum;   // 항목 별 비율

         System.out.printf("%s : %.2f%% \n", categoryName[i], categoryPerRate[i] * 100);   // 항목별 비율출력

      if(categoryPerRate[i] >= limitRate) {
         System.out.println("!!!"+categoryName[i] + " 항목의 지출이 총 지출의 50%를 넘겼습니다!!!");      // 경고 메시지
         }
      }
   }
}
