package ecomm;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

public class BookingManagementDAO {
    Map<Integer, Deal> deals;

    Map<Integer, Set<Integer>> dealsClaimedByCustomer;

    public Deal getDealByDealId(Integer dealId){
        if(deals.containsKey(dealId)){
            return deals.get(dealId);
        }
        System.out.println("No Deal found!");
        return null;
    }

    public void createDeal(Deal newDeal){
        Integer dealId = deals.size() + 1;
        deals.put(dealId, newDeal);
        System.out.println("Deal added successfully!");
    }
}
