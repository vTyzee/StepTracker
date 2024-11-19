package org.example;

public class MonthData {
    int[] days;

    public MonthData(){
        days = new int[30];
    }

    public void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++){
            System.out.println((i + 1) + ". День: " + days[i]);
            if ((i + 1) % 5 == 0) {
                System.out.println();
            }
        }

    }

    public int sumStepsFromMonth(){
        int sum = 0;
        for (int i = 0; i < days.length; i++){
            sum += days[i];
        }
        return sum;
    }
    public int maxSteps(){
        int max = 0;
        for (int i = 0; i < days.length; i ++){
            if (days[i] > max){
                max = days[i];
            }
        }
        return max;
    }
    public int bestSeries(int goalByStepsPerDay){
        int bestSeries = 0;
        int currentSeries = 0;

        for (int i = 0; i < days.length; i++){
            if (days[i] >= goalByStepsPerDay){
                currentSeries++;
                if(currentSeries > bestSeries) {
                    bestSeries = currentSeries;
                }
                }else {
                currentSeries = 0;

            }
        }
        return bestSeries;
    }
}
