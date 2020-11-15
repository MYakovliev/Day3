package by.epam.tasks.task3.controller;

import by.epam.tasks.task3.model.entity.PassengerTrain;
import by.epam.tasks.task3.view.Output;
import by.epam.tasks.task3.view.Reports;

public class Main {
    static Reports reports = new Reports();
    static Output output = new Output();

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        try {
            int amount = 15;
            PassengerTrain[] trains = new PassengerTrain[amount];
            for (int i = 0; i < amount; i++) {
                trains[i] = new PassengerTrain(("dest" + (i % 5)), i, i + 20, i * i * i, 20);
            }
            sb.append(reports.findClosestReport(trains));
            sb.append(reports.calculateFreeSeatsReport(trains));
            sb.append(reports.trainsToDestinationReport(trains));
            sb.append(reports.trainsToDestinationReportAfterTime(trains));
        } catch (Exception e){
            output.consolePrintLine(e.getMessage());
        } finally {
            output.consolePrintLine(sb);
        }
    }
}
