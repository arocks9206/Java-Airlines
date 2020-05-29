import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FlightTest {

    Flight flight;
    Plane plane;
    Passenger passenger1;
    Passenger passenger2;
    Passenger passenger3;
    Passenger passenger4;

    @Before
    public void setUp(){
        passenger1 = new Passenger("Ruby", 3);
        passenger2 = new Passenger("James", 2);
        passenger3 = new Passenger("Mia", 1);
        passenger4 = new Passenger("Chris", 5);
        plane = new Plane(PlaneType.BOEING);
        flight = new Flight(plane,"a1010","JFK","GLA","18:00");
    }
    
    @Test
    public void theFlightStartWithNoPassenger(){
        assertEquals(0, flight.countPassenger());
    }

    @Test
    public void weCanAddPassengerIfThereIsAvailableSpaceOnThePlane(){
        flight.addPassenger(passenger1);
        assertEquals(1, flight.countPassenger());
    }
    
    @Test
    public void weCanRemoveAPassenger(){
        flight.addPassenger(passenger1);
        flight.addPassenger(passenger2);
        flight.removePassenger();
        assertEquals(1, flight.countPassenger());
    }

    @Test
    public void checkIfThereIsAvailableSeat(){
        assertTrue(flight.checkAvailableSeat());
    }
    
    @Test
    public void weCanNotAddPassengerOverCapacity(){
        Plane plane2 = new Plane(PlaneType.SMALLJET);
        Flight flight2 = new Flight(plane2,"a1010","BRI","GLA","18:00");
        flight2.addPassenger(passenger1);
        assertFalse(flight2.checkAvailableSeat());
    }

    @Test
    public void checkIfPassengerIsAlreadyBooked_HeIsBooked() {
        flight.addPassenger(passenger1);
        assertTrue(flight.checkIfPassengerIsAlreadyInThePassengerList(passenger1));
    }
    
    @Test
    public void checkIfPassengerIsAlreadyBooked_HeIsNotBooked() {
        flight.addPassenger(passenger1);
        assertFalse(flight.checkIfPassengerIsAlreadyInThePassengerList(passenger2));
    }
    
}
