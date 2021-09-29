package ru.beliy;

public class Mfu {
    public volatile static boolean useXerx = true;
    public volatile static boolean usePrint = true;
    public volatile static boolean useScan = true;
    public static void main(String[] args) {
        Mfu prinFile = new Mfu();
        new Thread(() -> {
            try {
                prinFile.print();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
    public synchronized void print() throws InterruptedException {
        if (useXerx) {
            usePrint = false;
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println("Вывел на печать");
            usePrint = true;
        }
    }
    public synchronized void skan() throws InterruptedException {
        if (useXerx) {
            useScan = false;
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println("Сделал скан");
            useScan = true;
        }
    }
    public synchronized void xerx() throws InterruptedException {
        if (usePrint && useScan) {
            useXerx = false;
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println("Сделал скан и распечатал");
            useXerx = true;
        }
    }
}