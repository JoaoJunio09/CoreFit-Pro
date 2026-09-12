package br.com.joaojuniodev.corefitpro.recentAcitivty.repository;

import br.com.joaojuniodev.corefitpro.recentAcitivty.model.RecentActivity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RecentActivityRepository extends JpaRepository<RecentActivity, UUID> {

    List<RecentActivity> findAll(Specification<RecentActivity> spec);
}