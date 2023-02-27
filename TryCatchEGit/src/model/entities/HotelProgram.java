package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import application.Reservation;
import model.exceptions.DomainException;

public class HotelProgram {
	public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);
	DateTimeFormatter fm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	System.out.print("Room number: ");
	try {
	int room = sc.nextInt();
	System.out.print("Data checkin (dd/MM/yyyy): ");
	sc.nextLine();
	LocalDate data = LocalDate.parse(sc.nextLine(), fm);
	System.out.print("Data checkout (dd/MM/yyyy) :");

	LocalDate dataSaida = LocalDate.parse(sc.nextLine(), fm);

	Reservation reserv = new Reservation(room, data, dataSaida);
	System.out.println(reserv.toString());

	System.out.println();

	System.out.println("Enter data to update the reservation:");

	System.out.print("Data checkin (dd/MM/yyyy):");
	data = LocalDate.parse(sc.nextLine(), fm);
	System.out.print("Data checkout (dd/MM/yyyy):");
	dataSaida = LocalDate.parse(sc.nextLine(), fm);

	reserv.atualizarReserva(data, dataSaida);
    System.out.println(reserv.toString());
	}catch(DomainException e) {
System.out.println("Erro in reservation: " + e.getMessage());		
	}
	sc.close();
	}
}
