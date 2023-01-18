package com.alperenikinci.repository;

import com.alperenikinci.repository.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISaleRepository extends JpaRepository<Sale,Long> {
}
