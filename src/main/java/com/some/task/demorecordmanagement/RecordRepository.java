package com.some.task.demorecordmanagement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends MongoRepository<Record,String>{

    // @Query
    // Record findText(String langKey,String textValue);
	// public Record addTextValue(Record record);
}
