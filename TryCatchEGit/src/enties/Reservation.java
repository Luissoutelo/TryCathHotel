package enties;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reservation {
		DateTimeFormatter fm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		private Integer roomNumber;
		private LocalDate checkIn;
		private LocalDate checkOut;

		public Reservation() {

		}

		public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) {

			this.roomNumber = roomNumber;
			this.checkIn = checkIn;
			this.checkOut = checkOut;

		}

		public Integer getRoomNumber() {
			return roomNumber;
		}

		public void setRoomNumber(Integer roomNumber) {
			this.roomNumber = roomNumber;
		}

		public LocalDate getCheckIn() {
			return checkIn;
		}

		public LocalDate getCheckOut() {
			return checkOut;
		}



		public long Duration() {

	Duration d= Duration.between(checkIn.atStartOfDay(), checkOut.atStartOfDay());
			return d.toDays();
		}

		public void atualizarReserva(LocalDate checkIn, LocalDate checkOut) {

			this.checkIn = checkIn;
			this.checkOut = checkOut;

		}


		@Override
		public String toString() {
			return "Reservation : " + "Room " + roomNumber + ", check-in: " + fm.format(checkIn) + ", check-out: "
					+ fm.format(checkOut) + ", " + Duration() + " nights";
		}
}
