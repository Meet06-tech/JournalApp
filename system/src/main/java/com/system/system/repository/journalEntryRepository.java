package com.system.system.repository;

import com.system.system.entity.journalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface journalEntryRepository extends MongoRepository<journalEntry,String> {

}
