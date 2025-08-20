package com.com.store_management_stm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.com.store_management_stm.entity.Receipt;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {

}
