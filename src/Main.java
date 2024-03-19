import ecomm.BookingManagementService;
import ecomm.RequestHandler;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        BookingManagementService bookingManagementService = new BookingManagementService();
        RequestHandler requestHandler = new RequestHandler();


        requestHandler.processRequest("CREATE 1000 5 0 120", bookingManagementService);
        requestHandler.processRequest("CREATE 100 3 0 120", bookingManagementService);
        requestHandler.processRequest("CREATE 200 2 0 120", bookingManagementService);

        System.out.println();
        requestHandler.processRequest("CLAIM 3 1", bookingManagementService);
        requestHandler.processRequest("CLAIM 3 1", bookingManagementService); // error
        requestHandler.processRequest("CLAIM 3 2", bookingManagementService);
        requestHandler.processRequest("CLAIM 3 3", bookingManagementService); // error

        System.out.println();
        requestHandler.processRequest("UPDATE QUANTITY 3 2", bookingManagementService);
        requestHandler.processRequest("CLAIM 3 3", bookingManagementService);
        requestHandler.processRequest("CLAIM 3 4", bookingManagementService);

        requestHandler.processRequest("UPDATE QUANTITY 5 2", bookingManagementService);
    }
}