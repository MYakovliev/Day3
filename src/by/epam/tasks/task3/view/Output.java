package by.epam.tasks.task3.view;

public class Output {
    public <T> void consolePrint(T string) {
        System.out.print(string);
    }

    public <T> void consolePrintLine(T string) {
        System.out.println(string);
    }

}