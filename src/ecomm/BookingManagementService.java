package ecomm;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BookingManagementService {

    Map<Integer, Deal> deals;

    Map<Integer, Set<Integer>> dealsClaimedByCustomer;

    public BookingManagementService(){
        deals = new HashMap<>();
        dealsClaimedByCustomer = new HashMap<>();
    }

    public void createDeal(Deal newDeal){
        Integer dealId = deals.size() + 1;
        deals.put(dealId, newDeal);
        System.out.println("Deal added successfully!");
    }

    public void endDeal(Integer dealId){
        if(deals.containsKey(dealId)){
            Deal deal = deals.get(dealId);
            deal.setEndTime(LocalDateTime.now());
        }
        else {
            System.out.println("No Deal found!");
        }
    }

    public void updateDealEndTime(Integer dealId, Integer endTimeInMinutes){
        if(deals.containsKey(dealId)){
            Deal deal = deals.get(dealId);
            deal.setEndTime(deal.getEndTime().plusMinutes(endTimeInMinutes));
            System.out.println("Deal updated successfully!");
        }
        else {
            System.out.println("No Deal found!");
        }
    }

    public void updateDealQuantity(Integer dealId, Integer quantity){
        if(deals.containsKey(dealId)){
            Deal deal = deals.get(dealId);
            deal.setQuantity(deal.getQuantity() + quantity);
            System.out.println("Deal updated successfully!");
        }
        else {
            System.out.println("No Deal found!");
        }
    }

    public void claimDeal(Integer dealId, Integer userId){
        if(deals.containsKey(dealId)) {
            if (!isDealActive(dealId)) {
                System.out.println("Deal ended!");
                return;
            }
            if (isDealAlreadyClaimed(dealId, userId)) {
                System.out.println("Deal already claimed by user!");
                return;
            }
            Deal deal = deals.get(dealId);

            if(deal.getQuantity() > 0 ){
                deal.setQuantity(deal.getQuantity() - 1);
                Set<Integer> dealList = dealsClaimedByCustomer.getOrDefault(userId, new HashSet<>());
                dealList.add(dealId);
                dealsClaimedByCustomer.put(userId, dealList);
                System.out.println("Deal claimed successfully!");
            }
            else {
                System.out.println("Deal already claimed!");
            }
        }
    }

    private boolean isDealActive(Integer dealId){
        Deal deal = deals.get(dealId);
        LocalDateTime currentTime = LocalDateTime.now();
        return deal.getStartTime().isBefore(currentTime) && deal.getEndTime().isAfter(currentTime);
    }

    private boolean isDealAlreadyClaimed(Integer dealId, Integer userId){
        if(dealsClaimedByCustomer.containsKey(userId)){
            Set<Integer> dealList = dealsClaimedByCustomer.get(userId);
            return dealList.contains(dealId);
        }
        return false;
    }
}
