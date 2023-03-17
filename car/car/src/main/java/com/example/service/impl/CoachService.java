package com.example.service.impl;

import com.example.model.Coach;
import com.example.repository.ICoachRepository;
import com.example.service.ICoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CoachService implements ICoachService {
    @Autowired
    private ICoachRepository coachRepository;

    @Override
    public Page<Coach> findAll(Pageable pageable) {
        return coachRepository.findAll(pageable);
    }

    @Override
    public boolean update(Coach coach) {
        try {
            coachRepository.updateCoach(coach.getId(), coach.getCompanyName(), coach.getDepartureTime(),
                    coach.getDestinationTime(), coach.getEmail(), coach.getPhoneNumber(),
                    coach.getCoachType().getId(), coach.getDeparture().getId(), coach.getDestination().getId());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            this.coachRepository.deleteCoach(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Coach findById(int id) {
        return coachRepository.findCoachById(id);
    }

    @Override
    public boolean save(Coach coach) {
        try {
            coachRepository.saveCoach(coach.getId(), coach.getCompanyName(), coach.getDepartureTime(),
                    coach.getDestinationTime(), coach.getEmail(), coach.getPhoneNumber(),
                    coach.getCoachType().getId(), coach.getDeparture().getId(), coach.getDestination().getId());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
