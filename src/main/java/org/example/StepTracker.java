package org.example;

import java.util.Scanner;

public class StepTracker {
    MonthData[] monthToData;
    int goalByStepsPerDay = 10000;
    Scanner scanner;
    Converter converter = new Converter();

    public StepTracker(Scanner scanner) {
        this.scanner = scanner;
        monthToData = new MonthData[12];

        for (int i = 0; i < 12; i++) {
            monthToData[i] = new MonthData();
        }
    }

    public void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца 1-12: ");
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Неправильный номер месяца 1-12 ");
            return;
        }

        System.out.println("Введите день месяца 1-30: ");
        int day = scanner.nextInt();
        if (day < 1 || day > 12) {
            System.out.println("Неправильный день месяца 1-30 ");
            return;
        }

        System.out.println("Введите количество шагов: ");
        int steps = scanner.nextInt();
        if (steps < 0) {
            System.out.println("Количество шагов не может быть отрицательным. ");
            return;
        }

        MonthData monthData = monthToData[month - 1];
        monthData.days[day - 1] = steps;
        System.out.println("Данные сохранены! ");

    }

    public void changeStepGoal() {
        System.out.println("Введите новую цель по шагам в день: ");
        int newGoal = scanner.nextInt();
        if (newGoal <= 0) {
            System.out.println("Цель должна быть положительным числом. ");
        } else {
            goalByStepsPerDay = newGoal;
            System.out.println("Новая цель сохранена! ");
        }
    }

    public void printStatistic() {
        System.out.println("Введите номер месяца 1-12: ");
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Неправильный номер месяца 1-12");
            return;
        }
        MonthData monthData = monthToData[month - 1];

        System.out.println("Статистика за месяц: ");
        monthData.printDaysAndStepsFromMonth();

        int totalSteps = monthData.sumStepsFromMonth();
        System.out.println("Общее количество шагов за месяц: " + totalSteps);

        int maxSteps = monthData.maxSteps();
        System.out.println("Максимальное количество шагов в месяце за день: " + maxSteps);

        double averageSteps = totalSteps / 30.0;
        System.out.println("Среднее количество шагов за день: " + averageSteps);

        double distance = converter.convertToKm(totalSteps);
        System.out.println("Пройденная дистанция (в км): " + distance);

        double kilocalories = converter.convertStepsToKilocalories(totalSteps);
        System.out.println("Количество сожжённых килокалорий: " + kilocalories);

        int bestSeries = monthData.bestSeries(goalByStepsPerDay);
        System.out.println("Лучшая серия: " + bestSeries + " дней");
    }
}
