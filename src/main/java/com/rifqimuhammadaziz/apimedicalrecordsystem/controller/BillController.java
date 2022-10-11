package com.rifqimuhammadaziz.apimedicalrecordsystem.controller;

import com.rifqimuhammadaziz.apimedicalrecordsystem.entity.Bill;
import com.rifqimuhammadaziz.apimedicalrecordsystem.service.contract.BillService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/bills")
public class BillController {

    private final BillService billService;

    @PostMapping
    public Bill createBill(@RequestBody Bill bill) {
        return billService.createBill(bill);
    }

    @GetMapping
    public List<Bill> findAllBills() {
        return billService.findAllBills();
    }

    @GetMapping("/{id}")
    public Bill findSingleBillByID(@PathVariable("id") String id) {
        return billService.findSingleBill(id);
    }

    @PutMapping
    public Bill updateBill(Bill bill) {
        return billService.updateBill(bill);
    }

    @DeleteMapping("/{id}")
    public void deleteBillByID(String id) {
        billService.deleteBillByID(id);
    }
}
