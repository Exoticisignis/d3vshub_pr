package com.example.infrastructure.dbtasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;

@Component
public class ScheduledTasks {
    @PersistenceContext
    private EntityManager entityManager;

    @Scheduled(cron = "0 0 0 * * *")
    @Transactional
    public void dataPurgeForTracking(){
        LocalDate retentionDate = LocalDate.now().minusMonths(6);
        String purgingSql = "DELETE FROM tracking WHERE update_date < :retentionDate";
        entityManager.createNativeQuery(purgingSql)
                .setParameter("retentionDate", retentionDate)
                .executeUpdate();
        System.out.println("Data purging completed successfully.");
    }
}
