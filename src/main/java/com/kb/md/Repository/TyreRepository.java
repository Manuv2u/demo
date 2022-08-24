package com.kb.md.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kb.md.Entity.Tyre;

@Repository
public interface TyreRepository extends JpaRepository<Tyre ,Long> {
}
