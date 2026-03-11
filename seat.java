package model;

public class Seat {

    private int seatId;
    private boolean occupied;

    public Seat(int seatId) {
        this.seatId = seatId;
        this.occupied = false;
    }

    public int getSeatId() {
        return seatId;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void reserveSeat() {
        this.occupied = true;
    }

    public void freeSeat() {
        this.occupied = false;
    }

    @Override
    public String toString() {
        return "Seat " + seatId + " : " + (occupied ? "Occupied" : "Available");
    }
}
package model;

public class Book {

    private String title;
    private String author;
    private String rackId;

    public Book(String title, String author, String rackId) {
        this.title = title;
        this.author = author;
        this.rackId = rackId;
    }

    public String getTitle() {
        return title;
    }

    public String getRackId() {
        return rackId;
    }

    @Override
    public String toString() {
        return title + " by " + author + " | Rack: " + rackId;
    }
}
package model;

import java.util.ArrayList;
import java.util.List;

public class Rack {

    private String rackId;
    private List<Book> books = new ArrayList<>();

    public Rack(String rackId) {
        this.rackId = rackId;
    }

    public String getRackId() {
        return rackId;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }
}
package service;

import model.Seat;
import java.util.ArrayList;
import java.util.List;

public class SeatManager {

    private List<Seat> seats = new ArrayList<>();

    public void createSeats(int totalSeats) {

        for(int i = 1; i <= totalSeats; i++) {
            seats.add(new Seat(i));
        }
    }

    public void showSeats() {

        for(Seat seat : seats) {
            System.out.println(seat);
        }
    }

    public void reserveSeat(int seatId) {

        for(Seat seat : seats) {
            if(seat.getSeatId() == seatId) {

                if(!seat.isOccupied()) {
                    seat.reserveSeat();
                    System.out.println("Seat reserved successfully.");
                } else {
                    System.out.println("Seat already occupied.");
                }
                return;
            }
        }

        System.out.println("Seat not found.");
    }
}
package service;

import model.Book;
import model.Rack;

import java.util.ArrayList;
import java.util.List;

public class RackManager {

    private List<Rack> racks = new ArrayList<>();

    public void addRack(Rack rack) {
        racks.add(rack);
    }

    public void addBookToRack(String rackId, Book book) {

        for(Rack rack : racks) {

            if(rack.getRackId().equals(rackId)) {
                rack.addBook(book);
                return;
            }
        }
    }

    public void searchBook(String title) {

        for(Rack rack : racks) {

            for(Book book : rack.getBooks()) {

                if(book.getTitle().equalsIgnoreCase(title)) {
                    System.out.println("Book Found: " + book);
                    return;
                }
            }
        }

        System.out.println("Book not found.");
    }
}
package service;

import model.Book;
import model.Rack;

public class LibrarySystem {

    private SeatManager seatManager = new SeatManager();
    private RackManager rackManager = new RackManager();

    public void initialize() {

        seatManager.createSeats(10);

        Rack rackA = new Rack("A");
        Rack rackB = new Rack("B");

        rackManager.addRack(rackA);
        rackManager.addRack(rackB);

        rackManager.addBookToRack("A", new Book("Java Programming", "James Gosling", "A"));
        rackManager.addBookToRack("B", new Book("Data Structures", "Mark Allen", "B"));
    }

    public void showSeats() {
        seatManager.showSeats();
    }

    public void reserveSeat(int seatId) {
        seatManager.reserveSeat(seatId);
    }

    public void searchBook(String title) {
        rackManager.searchBook(title);
    }
}
package util;

public class DataStore {

    public static final int TOTAL_SEATS = 20;

}
