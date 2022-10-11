package com.rifqimuhammadaziz.apimedicalrecordsystem.service.contract;

import com.rifqimuhammadaziz.apimedicalrecordsystem.entity.Bill;

import java.util.List;

public interface BillService {
    Bill createBill(Bill bill);
    List<Bill> findAllBills();
    Bill findSingleBill(String id);
    Bill updateBill(Bill bill);
    void deleteBillByID(String id);
}
