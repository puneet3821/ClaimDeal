package ecomm;

import java.time.LocalDateTime;

public class RequestHandler {

    public void processRequest(String request, BookingManagementService requestHandler){
        String[] requestParam = request.split(" ");
        if(requestParam.length < 1){
            System.out.println("Invalid input");
        }

        if(requestParam[0].equals("CREATE")){
            Deal newDeal = new Deal(Integer.parseInt(requestParam[1]), Integer.parseInt(requestParam[2]),
                    LocalDateTime.now().plusMinutes(Integer.parseInt(requestParam[3])),
                    LocalDateTime.now().plusMinutes(Integer.parseInt(requestParam[4])));
            requestHandler.createDeal(newDeal);
        }

        if(requestParam[0].equals("END")){
            requestHandler.endDeal(Integer.parseInt(requestParam[1]));
        }

        if(requestParam[0].equals("UPDATE")){
            if(requestParam[1].equals("QUANTITY")){
                requestHandler.updateDealQuantity(Integer.parseInt(requestParam[2]), Integer.parseInt(requestParam[3]));
            }
            if(requestParam[1].equals("TIME")){
                requestHandler.updateDealEndTime(Integer.parseInt(requestParam[2]), Integer.parseInt(requestParam[3]));
            }
        }

        if(requestParam[0].equals("CLAIM")){
            requestHandler.claimDeal(Integer.parseInt(requestParam[1]), Integer.parseInt(requestParam[2]));
        }
    }
}
