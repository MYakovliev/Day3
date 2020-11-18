package by.epam.tasks.task3.model.entity;

public class Seat {
    private int num;
    private boolean reserved;

    public Seat(int num) {
        setNum(num);
        setReserved(false);
    }

    public Seat(int num, boolean reserved){
        setReserved(reserved);
        setNum(num);
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        if (num <= 0){
            throw new IllegalArgumentException("invalid data");
        }

        this.num = num;
    }

}
