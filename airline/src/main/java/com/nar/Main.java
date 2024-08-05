package com.nar;
import com.nar.Controller.AirFlightController;
import com.nar.Controller.AirplaneController;
import com.nar.Controller.ReservationController;
import com.nar.Controller.TravelerController;
import com.nar.Entity.AirFlights;
import com.nar.Entity.Airplane;
import com.nar.Entity.Reservation;
import com.nar.Entity.Traveler;

import javax.swing.*;
import java.text.ParseException;



public class Main {


    public static void travelerMenu(){
        System.out.println("""
                1. create traveler
                2. List traveler
                3. Update traveler
                4. delete travaler
                5. exit
                """);
    }


    public static void reservationMenu(){
        System.out.println("""
                1. create airplane
                2. List airplane
                3. Update airplane
                4. delete airplane
                5. capacity
                6. exit
                """);
    }

    public  static void airFligthsMenu (){
        System.out.println("""
                1. create airFlight
                2. list airfligth
                3. update airfligth
                4. delete airfligth
                5. exist """);
    }


    public static void traveler(){
        TravelerController travelerController = new TravelerController();
        int opcion;
        do{
            travelerMenu();
            opcion = Integer.parseInt(JOptionPane.showInputDialog(" insert option"));
            switch (opcion){
                case 1:
                    String nameTraveler = JOptionPane.showInputDialog("inert name traveler");
                    String lastName = JOptionPane.showInputDialog("insert Last name traveler");
                    int cc = Integer.parseInt(JOptionPane.showInputDialog("insert cc traveler"));
                    Traveler traveler = new Traveler(nameTraveler,lastName,cc);
                    travelerController.create(traveler);
                    break;
                case 2:
                    travelerController.read();
                    break;
                case 3:
                    int idUpdate = Integer.parseInt(JOptionPane.showInputDialog(" ingresa el id"));
                    String namenew =JOptionPane.showInputDialog("insert name");
                    String lastNameNEw = JOptionPane.showInputDialog("insert lastname");
                    Traveler travelerNew = new Traveler();
                    travelerNew.setId(idUpdate);
                    travelerNew.setName(namenew);
                    travelerNew.setLastName(lastNameNEw);
                    travelerController.update(travelerNew);
                    break;
                case 4:
                    int idDelete = Integer.parseInt(JOptionPane.showInputDialog("insert id to delete"));
                    travelerController.delete(idDelete);
                    break;
                case 5:
                    break;
                default:
                    break;
            }
        }while(opcion!=5);
    }

    public static void airfligths() throws ParseException {

AirFlightController airFlightController = new AirFlightController();
        int option;

        do {
           airFligthsMenu();
            option = Integer.parseInt(JOptionPane.showInputDialog("Insert opcion"));
            switch (option){
                case 1:
                    String destination = JOptionPane.showInputDialog("insert destination");
//                    LocalDate date = LocalDate.parse(JOptionPane.showInputDialog("Ingrese la fecha (AAAAMMDD)"), DateTimeFormatter.ofPattern("yyyyMMdd"));
// Obtener la hora del usuario
                    String dateS = JOptionPane.showInputDialog("inser flight date (AAAA-MM-DD)");
                    String hour = JOptionPane.showInputDialog("insert hour (HH:MM:SS5)");
                    int idAirplane = Integer.parseInt(JOptionPane.showInputDialog("Insert to id airplane "));

                    AirFlights airFlights = new AirFlights(destination,dateS,hour,idAirplane);
                    airFlightController.create(airFlights);

                    break;

                case 2:
                    airFlightController.read();
                    break;
                case 3:
                    int idFligh = Integer.parseInt(JOptionPane.showInputDialog("insert id "));
                    String dateFlight = JOptionPane.showInputDialog("insert new Date (AAAA-MM-DD)");
                    AirFlights airFlightsObject = new AirFlights();
                    airFlightsObject.setDate(dateFlight);
                    airFlightsObject.setId(idFligh);
                    airFlightController.update(airFlightsObject);
                    break;
                case 4:
                    int idDeleteflight = Integer.parseInt(JOptionPane.showInputDialog("insert id to delete"));
                    airFlightController.delete(idDeleteflight);
                    break;
                case 5:
                    break;

                default:
                    break;
            }
        }while(option!=5);


    }

    public static  void reservation(){
        int option;
        ReservationController reservationController = new ReservationController();
        Reservation reservation2 = new Reservation();



        do {
           reservationMenu();
            option = Integer.parseInt(JOptionPane.showInputDialog("Insert opcion"));
            switch (option){
                case 1:
                    int seatNumber = Integer.parseInt(JOptionPane.showInputDialog("insert seat number"));
                    int id_fligth = Integer.parseInt(JOptionPane.showInputDialog("insert fligth number"));
                    int id_traveler = Integer.parseInt(JOptionPane.showInputDialog("insert traveler number"));
                    Reservation reservation = new Reservation(seatNumber,id_fligth,id_traveler);
                    reservationController.create(reservation);
                    break;

                case 2:
                    reservationController.read(reservation2);
                    break;
                case 3:
                    int idUpdate = Integer.parseInt(JOptionPane.showInputDialog(" insert to id update"));
                    int setaNumberN= Integer.parseInt(JOptionPane.showInputDialog( "inser seat number"));
                    int numberFlight= Integer.parseInt(JOptionPane.showInputDialog( "inser seat number"));
                    int travelerId= Integer.parseInt(JOptionPane.showInputDialog( "inser seat number"));
                    Reservation reservation1 = new Reservation(idUpdate,setaNumberN,numberFlight,travelerId);

                    break;
                case 4:
                    Integer idDelete = Integer.valueOf(JOptionPane.showInputDialog("inser id to delete"));
                    reservationController.delete(idDelete);
                    break;
                case 5:
                    int idReserv = Integer.parseInt(JOptionPane.showInputDialog("inser id"));
                    reservationController.capacityReservation(idReserv);
                case 6:
                    break;

                default:
                    break;
            }
        }while(option!=6);

    }
    public static  void mainMenu (){
        System.out.println("""
                Main menu
                1. Reservation
                2. Airplane
                3. Flight
                4. Traveler
                5. exit.
                insert a option
                """);
    }


    public static void airplaneMenu(){
        System.out.println("""
                1. create airplane
                2. List airplane
                3. update airplane
                4. delete airplane
                5. Read count flitghts
                6. exit
                """);
    }
    public static void airplane(){
        AirplaneController airplaneController = new AirplaneController();
 int option;

        do {
           airplaneMenu();
            option = Integer.parseInt(JOptionPane.showInputDialog("Insert an Option"));
            switch (option){
                case 1:
                    String model = JOptionPane.showInputDialog("inser the model");
                    int lenght = Integer.parseInt(JOptionPane.showInputDialog("insert the capacity"));
                    Airplane airplane = new Airplane(model,lenght);
                    Airplane airplane1 = airplaneController.create(airplane);
                    JOptionPane.showMessageDialog(null, airplane1);
                    break;
                case 2:
                    airplaneController.read();
                    break;
                case 3:
                    int idUpdate = Integer.parseInt(JOptionPane.showInputDialog("insert id to update"));
                    String models = JOptionPane.showInputDialog("inser new model");
                    int length = Integer.parseInt(JOptionPane.showInputDialog("insert the capacity"));
                    Airplane airplaneUpdate = new Airplane(idUpdate, models,length);
                    airplaneController.update(airplaneUpdate);
                    break;
                case 4:
                    int idDelete = Integer.parseInt(JOptionPane.showInputDialog("insert id ariplane"));
                    airplaneController.delete(idDelete);
                    break;
                case 5:
                    airplaneController.capacity();
                    break;
                case 6:
                    System.out.println("exiting the system");
                    break;
                default:
                    System.out.println("option invalid");
                    break;
            }
        }while (option != 6);
    }
    public static void main(String[] args) throws ParseException {

        int option;

        do {
            mainMenu();
            option = Integer.parseInt(JOptionPane.showInputDialog("insert option"));


            switch (option){
                case 1:
                    reservation();
                    break;
                case 2:
                    airplane();
                    break;
                case 3:
                    airfligths();
                    break;
                case 4:
                    traveler();
                    break;
                case 5:
                    break;

                default:
                    break;
            }

        }while(option !=5);


    }
}
