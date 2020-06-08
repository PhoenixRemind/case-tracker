package org.launchcode.casetracker.models.data;

import org.launchcode.casetracker.models.Transcript;
import org.springframework.data.repository.CrudRepository;

public interface TranscriptRepository extends CrudRepository<Transcript, Integer> {
}
