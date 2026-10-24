class Solution {
    private int daysPerMonth[]= {31,28,31,30,31,30,31,31,30,31,30,31};
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob){

        int AliceStartDate=DayOfYear(arriveAlice);
        int AliceEndDate=DayOfYear(leaveAlice); 
        int BobStartDate=DayOfYear(arriveBob);
        int BobEndDate= DayOfYear(leaveBob);

        int start=Math.max(AliceStartDate,BobStartDate);
        int end=Math.min(AliceEndDate,BobEndDate);
        
        return Math.max(0,end-start+1);
    }

    private int DayOfYear(String s){
        int month=Integer.parseInt(s.substring(0,2));
        int day=Integer.parseInt(s.substring(3,5));

        int daysSpent=day;
        for(int i=0;i<month-1;i++){
            daysSpent+=daysPerMonth[i];
        }
        return daysSpent;
    }
}