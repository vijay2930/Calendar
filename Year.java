public class Year {
    private int year;
    private String[] days={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};

    private String[] months={"Jan","Feb","Mar","Apr","May","June","July","Aug","Sep","Oct","Nov","Dec"};

    private int[] daysInMonth={31,28,31,30,31,30,31,31,30,31,30,31};
    private int startDate;
    Year(){
        this(1);
    }
    Year(int year){
        this.year=year;
        if(year%4==0 ){
            daysInMonth[1]=29;
            if(year%100==0 && year%400!=0){
                daysInMonth[1]=28;
            }
        }
        int temp=year;
        temp=(temp)+((temp-1)/4)-((temp/100)-(temp/400));
        temp=temp%7;
        startDate=temp;
    }
    public void printYear(){
        this.print(months,0,days,startDate,daysInMonth);
    }
    public void print(String[] months,int month,String[] weeks,int startDate,int[] daysInMonth){
        System.out.printf("%21s\n\n",this.year);
        for(int i=0;i<months.length;i++){
            System.out.printf("%20s\n\n",months[i]);
            for(int j=0;j< weeks.length;j++){
                System.out.printf("%5s",weeks[j].substring(0,3));
            }
            System.out.println();
            int count=0;
            int day=1;
            while(day!=daysInMonth[i]+1){
                if(count>=startDate){
                    System.out.printf("%5d",day++);
                    startDate++;
                }else{
                    System.out.print("     ");
                }
                count++;
                if(startDate==7){
                    System.out.println();
                    startDate=0;
                }
            }
            System.out.println("\n");
        }
    }
}
