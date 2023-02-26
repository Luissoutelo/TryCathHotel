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
		LocalDate now= LocalDate.now();	
	if(now.isAfter(data) || dataSaida.isBefore(now)) {
		
			System.out.println("Error in reservation:Check-out date must be after check-in date!");
	}else if (data.isAfter(dataSaida)){
	System.out.println("Error in reservation:Check-out date and check-in date must be future dates!");
	}else {
		reserv.atualizarReserva(data, dataSaida);
		System.out.println(reserv.toString());
	}
	}
	
	sc.close();
}
}
