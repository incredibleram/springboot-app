package com.inm429.ecommerce.Service;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.inm429.ecommerce.Repository.CountRepository;

@Service
public class UserMetricsService {

	@Autowired
    private MeterRegistry meterRegistry;
    
    @Autowired
    private CountRepository countRepository;

    @Scheduled(fixedRate = 10000)
    public void updateUsersMetric() {
        int usersOnline = getCurrentUsersCount();

        meterRegistry.gauge("users_online", Tags.empty(), usersOnline);
    }

    public int getCurrentUsersCount() {
        return countRepository.getCurrentCount();
    }

	public void decreaseCount() {
		countRepository.decreaseCount();
	}
	
	public void increaseCount() {
		countRepository.increaseCount();
	}
}
