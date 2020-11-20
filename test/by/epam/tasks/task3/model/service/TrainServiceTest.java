package by.epam.tasks.task3.model.service;

import by.epam.tasks.task3.model.entity.PassengerTrain;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class TrainServiceTest {
    static PassengerTrain train1 = new PassengerTrain("dest1", 12, 10, 1236, 20);
    static PassengerTrain train2 = new PassengerTrain("dest2", 10, 45, 23658, 20);
    static PassengerTrain train3 = new PassengerTrain("dest2", 15, 40, 125, 20);
    static TrainService trainService = new TrainService();

    @Test
    public void testFindClosest() {
        PassengerTrain[] trains = {train1, train2, train3};
        PassengerTrain expected = train2;
        PassengerTrain actual = trainService.findClosest("dest2", new int[]{7, 15}, trains).get();
        assertEquals(actual, expected);
    }

    @Test
    public void testCalculateFreeSeats() {
        int expected = 972;
        int actual = trainService.calculateFreeSeats(train1);
        assertEquals(actual, expected);
    }

    @Test
    public void testTrainsToDestination() {
        List<PassengerTrain> expected = new ArrayList<>();
        expected.add(train2);
        expected.add(train3);
        List<PassengerTrain> actual = trainService.trainsToDestination("dest2", train1, train2, train3);
        assertEquals(actual, expected);
    }

    @Test
    public void testTestTrainsToDestination() {
        List<PassengerTrain> expected = new ArrayList<>();
        List<PassengerTrain> actual = trainService.trainsToDestination("dest1", new int[]{17, 15}, train1, train2, train3);
        assertEquals(actual, expected);
    }
}