package com.ust.webinar_service.repository;

import com.ust.webinar_service.model.Webinar;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface WebinarRepository extends ReactiveMongoRepository<Webinar, String> {
}
