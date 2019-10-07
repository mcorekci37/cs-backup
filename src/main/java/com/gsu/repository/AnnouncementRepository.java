package com.gsu.repository;

import com.gsu.model.Announcement;
import org.springframework.data.repository.CrudRepository;

public interface AnnouncementRepository extends CrudRepository<Announcement,Long> {
}
