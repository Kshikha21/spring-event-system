package com.company.inventory.service;

import com.company.inventory.entity.ProcessedEvent;
import com.company.inventory.repository.ProcessedEventRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class InventoryService {

    private final ProcessedEventRepository processedEventRepository;

    public InventoryService(ProcessedEventRepository processedEventRepository) {
        this.processedEventRepository = processedEventRepository;
    }
   /*
   “Inventory processing is idempotent and transactional.”
   * */
    @Transactional
    public void reserverInventory(Long orderId){
        // 1. Check idempotency
        boolean alreadyProcessed = processedEventRepository.existsById(orderId);

        if(alreadyProcessed){
            return;  // ignore duplicate event
        }
        // 2. Reserve inventory (simulated)
        // In real world → reduce stock from DB
        System.out.println("Inventory reserved for order " + orderId);

        // 3. Mark event as processed
        processedEventRepository.save(new ProcessedEvent(orderId));
    }


}
