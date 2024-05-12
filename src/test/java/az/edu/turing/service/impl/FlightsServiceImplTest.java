//package az.edu.turing.service.impl;
//
//import az.edu.turing.controller.BookingController;
//import az.edu.turing.controller.FlightsController;
//import az.edu.turing.dao.BookingDao;
//import az.edu.turing.dao.FlightsDao;
//import az.edu.turing.dao.impl.BookingFileDao;
//import az.edu.turing.dao.impl.FlightsFileDao;
//import az.edu.turing.model.FlightsDto;
//import az.edu.turing.entity.FlightsEntity;
//import az.edu.turing.service.BookingService;
//import az.edu.turing.service.FlightsService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
//import static org.mockito.Mockito.*;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.time.LocalDateTime;
//import java.util.*;
//import java.util.function.Predicate;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class FlightServiceImplTest {
//
//    public static final BookingDao bookingDao = mock(BookingDao.class);
//    public static final FlightsDao flightDao = mock(FlightsDao.class);
//    public static final FlightsService flightService = new FlightsServiceImpl(flightDao);
//    public static final FlightsController flightController = new FlightsController(flightService);
//    public static final BookingService bookingService = new BookingServiceImpl(bookingDao, flightDao);
//    public static final BookingController bookingController = new BookingController(bookingService);
//
//    @BeforeEach
//    void setup() {
//        LocalDateTime dateTime1 = LocalDateTime.of(2024, 5, 2, 10, 0);
//        LocalDateTime dateTime2 = LocalDateTime.of(2024, 5, 3, 12, 0);
//        FlightsEntity flight1 = new FlightsEntity(dateTime1, "New York", "Baku", 20);
//        FlightsEntity flight2 = new FlightsEntity(dateTime2, "Los Angeles", "Dubai", 13);
//        String location = "New York";
//        Predicate<FlightsEntity> idPredicate = flight -> flight.getFlightId() == flight1.getFlightId();
//        Predicate<FlightsEntity> locationPredicate = flight -> flight.getDestination().equals(location);
//        when(flightDao.getAll()).thenReturn(Arrays.asList(flight1, flight2));
//        when(flightDao.getAllBy(locationPredicate)).thenReturn(Arrays.asList(flight1, flight2));
//        when(flightDao.getOneBy(idPredicate)).thenReturn(Optional.of(flight1));
//        //when(flightDao.getAll()).thenReturn(List.of(flight1));
//    }
//
//    @Test
//    void testGetAllFlights() {
//        List<FlightsDto> result = flightService.getAllFlights();
//        assertEquals(2, result.size());
//    }
//
//
//    @Test
//    void testGetAllByLocation() {
//        List<FlightDto> result = flightService.getAllByLocationIn24Hours("New York");
//        assertEquals(1, result.size());
//    }
//
//    @Test
//    void testGetFlightById() {
//
//    }
//
//    @Test
//    void testCreateFlight() {
//        // Arrange
//        LocalDateTime dateTime = LocalDateTime.of(2024, 5, 10, 8, 0);
//        String location = "New York";
//        String destination = "London";
//        int seats = 100;
//        FlightDto flightDto = new FlightDto(dateTime, location, destination, seats);
//
//        FlightEntity expectedFlightEntity = new FlightEntity(dateTime, location, destination, seats);
//
//        when(flightDao.save(anyList())).thenReturn(true);
//
//        // Act
//        boolean result = flightService.createFlight(flightDto);
//
//        // Assert
//        assertTrue(result);
//        verify(flightDao, times(1)).save(Collections.singletonList(expectedFlightEntity));
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
////package az.edu.turing.service.impl;
////
////import az.edu.turing.dao.FlightsDao;
////import az.edu.turing.entity.FlightsEntity;
////import az.edu.turing.model.FlightsDto;
////import org.junit.jupiter.api.BeforeEach;
////import org.junit.jupiter.api.Test;
////import org.mockito.Mock;
////import org.mockito.MockitoAnnotations;
////
////import java.time.LocalDateTime;
////import java.util.Arrays;
////import java.util.Collection;
////import java.util.List;
////import java.util.Optional;
////
////import static org.junit.jupiter.api.Assertions.assertEquals;
////import static org.mockito.Mockito.*;
////
////class FlightsServiceImplTest {
////    @Mock
////    private FlightsDao flightsDao;
////
////    private FlightsServiceImpl flightsService;
////    @BeforeEach
////    void setUp() {
////        MockitoAnnotations.openMocks(this);
////        flightsService = new FlightsServiceImpl(flightsDao);
////    }
////
////    @Test
////    void createFlights() {
////        // Mock data
////        FlightsDto flightsDto = new FlightsDto(1, LocalDateTime.of(2024, 5, 11, 10, 0), "Destination", "Location", 100);
////
////        // Execute the method
////        flightsService.createFlights(flightsDto);
////
////        // Verify the interaction with the DAO
////        verify(flightsDao, times(1)).getAll();
////        verify(flightsDao, times(1)).save(anyCollection());
////    }
////
////    @Test
////    void getAllFlights() {
////        // Mock data
////        FlightsEntity flight1 = new FlightsEntity(1, LocalDateTime.of(2024, 5, 11, 10, 0), "Destination 1", "Location 1", 100);
////        FlightsEntity flight2 = new FlightsEntity(2, LocalDateTime.of(2024, 5, 12, 12, 0), "Destination 2", "Location 2", 150);
////        Collection<FlightsEntity> flightsEntities = Arrays.asList(flight1, flight2);
////
////        // Stubbing the behavior of the DAO
////        when(flightsDao.getAll()).thenReturn(flightsEntities);
////
////        // Execute the method
////        Collection<FlightsDto> result = flightsService.getAllFlights();
////
////        // Verify the result
////        assertEquals(2, result.size());
////        verify(flightsDao, times(1)).getAll();
////
////        // Verify the conversion from entity to DTO
////        FlightsDto dto1 = result.stream().filter(dto -> dto.getFlightId() == 1).findFirst().orElse(null);
////        FlightsDto dto2 = result.stream().filter(dto -> dto.getFlightId() == 2).findFirst().orElse(null);
////        assertEquals(flight1.getFlightId(), dto1.getFlightId());
////
////    }
////
////    @Test
////    void getAllFlightsByLocation() {
////        // Mock data
////        FlightsEntity flight1 = new FlightsEntity(1, LocalDateTime.of(2024, 5, 11, 10, 0), "Destination 1", "Location 1", 100);
////        FlightsEntity flight2 = new FlightsEntity(2, LocalDateTime.of(2024, 5, 12, 12, 0), "Destination 2", "Location 2", 150);
////        Collection<FlightsEntity> flightsEntities = Arrays.asList(flight1, flight2);
////
////        // Stubbing the behavior of the DAO
////        when(flightsDao.getAll()).thenReturn(flightsEntities);
////
////        // Execute the method
////        List<FlightsDto> result = flightsService.getAllFlightsByLocation("Location 1");
////
////        // Verify the result
////        assertEquals(1, result.size());
////        assertEquals(flight1.getFlightId(), result.get(0).getFlightId());
////        verify(flightsDao, times(1)).getAll();
////    }
////
////    @Test
////    void getAllFlightsByDestination() {
////        // Mock data
////        FlightsEntity flight1 = new FlightsEntity(1, LocalDateTime.of(2024, 5, 11, 10, 0), "Destination 1", "Location 1", 100);
////        FlightsEntity flight2 = new FlightsEntity(2, LocalDateTime.of(2024, 5, 12, 12, 0), "Destination 2", "Location 2", 150);
////        FlightsEntity flight3 = new FlightsEntity(3, LocalDateTime.of(2024, 5, 13, 14, 0), "Destination 1", "Location 3", 200);
////        Collection<FlightsEntity> flightsEntities = Arrays.asList(flight1, flight2, flight3);
////
////        // Stubbing the behavior of the DAO
////        when(flightsDao.getAll()).thenReturn(flightsEntities);
////
////        // Execute the method
////        List<FlightsDto> result = flightsService.getAllFlightsByDestination("Destination 1");
////
////        // Verify the result
////        assertEquals(2, result.size());
////        assertEquals(flight1.getFlightId(), result.get(0).getFlightId());
////        assertEquals(flight3.getFlightId(), result.get(1).getFlightId());
////        verify(flightsDao, times(1)).getAll();
////    }
////
////    @Test
////    void getAllFlightsByFlightId() {
////        // Mock data
////        FlightsEntity flight1 = new FlightsEntity(1, LocalDateTime.of(2024, 5, 11, 10, 0), "Destination 1", "Location 1", 100);
////        FlightsEntity flight2 = new FlightsEntity(2, LocalDateTime.of(2024, 5, 12, 12, 0), "Destination 2", "Location 2", 150);
////        FlightsEntity flight3 = new FlightsEntity(3, LocalDateTime.of(2024, 5, 13, 14, 0), "Destination 3", "Location 3", 200);
////        Collection<FlightsEntity> flightsEntities = Arrays.asList(flight1, flight2, flight3);
////
////        // Stubbing the behavior of the DAO
////        when(flightsDao.getAll()).thenReturn(flightsEntities);
////
////        // Execute the method
////        List<FlightsDto> result = flightsService.getAllFlightsByFlightId(2);
////
////        // Verify the result
////        assertEquals(1, result.size());
////        assertEquals(flight2.getFlightId(), result.get(0).getFlightId());
////        verify(flightsDao, times(1)).getAll();
////    }
////
////    @Test
////    void getOneFlightByFlightId() {
////        // Mock data
////        FlightsEntity flight1 = new FlightsEntity(1, LocalDateTime.of(2024, 5, 11, 10, 0), "Destination 1", "Location 1", 100);
////        FlightsEntity flight2 = new FlightsEntity(2, LocalDateTime.of(2024, 5, 12, 12, 0), "Destination 2", "Location 2", 150);
////        Collection<FlightsEntity> flightsEntities = Arrays.asList(flight1, flight2);
////
////        // Stubbing the behavior of the DAO
////        when(flightsDao.getAll()).thenReturn(flightsEntities);
////
////        // Execute the method
////        Optional<FlightsDto> result = flightsService.getOneFlightByFlightId(2);
////
////        // Verify the result
////        assertEquals(flight2.getFlightId(), result.get().getFlightId());
////        verify(flightsDao, times(1)).getAll();
////    }
////
////    @Test
////    void flightsInNext24Hours() {
////        // Mock data
////        LocalDateTime now = LocalDateTime.now();
////        FlightsEntity flight1 = new FlightsEntity(1, now.plusHours(1), "Destination 1", "Location 1", 100);
////        FlightsEntity flight2 = new FlightsEntity(2, now.plusHours(12), "Destination 2", "Location 2", 150);
////        FlightsEntity flight3 = new FlightsEntity(3, now.plusHours(25), "Destination 3", "Location 3", 200); // This flight is outside the 24-hour window
////        Collection<FlightsEntity> flightsEntities = Arrays.asList(flight1, flight2, flight3);
////
////        // Stubbing the behavior of the DAO
////        when(flightsDao.getAll()).thenReturn(flightsEntities);
////
////        // Execute the method
////        List<FlightsDto> result = flightsService.flightsInNext24Hours("Location 1", now);
////
////        // Verify the result
////        assertEquals(1, result.size());
////        assertEquals(flight1.getFlightId(), result.get(0).getFlightId());
////        verify(flightsDao, times(1)).getAll();
////    }
////}