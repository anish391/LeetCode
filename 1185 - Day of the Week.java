class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] days = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        if(month<3){
            month+=12;
            year-=1;
        }
        int century = year%100;
        int zb = year/100;
        int a = day+(13*(month+1)/5)+century+(century/4)+(zb/4)+(5*zb);
        return days[a%7];
    }
}