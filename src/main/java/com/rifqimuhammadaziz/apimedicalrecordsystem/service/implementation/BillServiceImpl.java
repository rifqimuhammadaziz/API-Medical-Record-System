package com.rifqimuhammadaziz.apimedicalrecordsystem.service.implementation;

import com.rifqimuhammadaziz.apimedicalrecordsystem.entity.Bill;
import com.rifqimuhammadaziz.apimedicalrecordsystem.repository.BillRepository;
import com.rifqimuhammadaziz.apimedicalrecordsystem.service.contract.BillService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BillServiceImpl implements BillService {

    private final BillRepository billRepository;

    @Override
    public Bill createBill(Bill bill) {
        return billRepository.save(bill);
    }

    @Override
    public List<Bill> findAllBills() {
        return billRepository.findAll();
    }

    @Override
    public Bill findSingleBill(String id) {
        return billRepository.findById(id).get();
    }

    @Override
    public Bill updateBill(Bill bill) {
        return billRepository.save(bill);
    }

    @Override
    public void deleteBillByID(String id) {
        billRepository.deleteById(id);
    }
}
