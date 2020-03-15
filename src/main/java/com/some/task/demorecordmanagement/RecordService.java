package com.some.task.demorecordmanagement;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecordService {

	@Autowired
	private RecordRepository recordRepository;
	private Optional<Record> findOne;

	// Creating a record
	@Transactional
	public Record createRecord(String languageKey, String text, String textMeaning) {

		return recordRepository.save(new Record(languageKey, text, textMeaning));

	}

	public Optional<Record> fetchSingleRecord(final String langKey, final String text) {
		Record r = new Record();
		r.setLanguageKey(langKey);
		r.setText(text);

		ExampleMatcher exampleMatcher = ExampleMatcher.matching().withIgnorePaths(langKey).withIgnorePaths(text);

		Example<Record> ex = Example.of(r, exampleMatcher);
		findOne = recordRepository.findOne(ex);
		return findOne;
	}

	// Retrieving a record
	@Transactional
	public Optional<Record> getRecord(final String langKey, final String text) {

		Optional<Record> record = fetchSingleRecord(langKey, text);
		return record;

	}

	// Update exisiting text
	@Transactional
	public Record updateRecord(final String langKey, final String text, final String textMeaning) {

		final Optional<Record> r = fetchSingleRecord(langKey, text);
		Record rec = r.get();

		rec.setTextMeaning(textMeaning);
		return recordRepository.save(rec);
	}

	// Delete a record
	// @Transactional
	// public void deleteRecord(final String langKey, final String text) {
	// final Record r = recordRepository.findText(langKey, text);
	// recordRepository.delete(r);;
	// }

}
