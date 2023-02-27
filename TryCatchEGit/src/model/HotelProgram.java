package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import enties.Reservation;

public class HotelProgram {
	public static void main(String[] args) {
		
		
	Scanner sc = new Scanner(System.in);
	DateTimeFormatter fm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	System.out.print("Room number: ");
	int room = sc.nextInt();
	System.out.print("Data checkin (dd/MM/yyyy): ");
	sc.nextLine();
	LocalDate data = LocalDate.parse(sc.nextLine(), fm);
	System.out.print("Data checkout (dd/MM/yyyy) :");

	LocalDate dataSaida = LocalDate.parse(sc.nextLine(), fm);

	if (data.isAfter(dataSaida)) {
		System.out.println("Error in reservation:Check-out date must be after check-in date!");

	} else {
	
		Reservation reserv = new Reservation(room, data, dataSaida);
		System.out.println(reserv.toString());
		System.out.println();
		System.out.println("Enter data to update the reservation:");
		System.out.print("Data checkin (dd/MM/yyyy):");
		data = LocalDate.parse(sc.nextLine(), fm);
		System.out.print("Data checkout (dd/MM/yyyy):");
		dataSaida = LocalDate.parse(sc.nextLine(), fm);

		String error= reserv.atualizarReserva(data, dataSaida);
		if(error!=null) {
			System.out.println("Error in reservation : "+ error);
		}else {
		System.out.println(reserv.toString());
		}
	}
	
	sc.close();
}
}
