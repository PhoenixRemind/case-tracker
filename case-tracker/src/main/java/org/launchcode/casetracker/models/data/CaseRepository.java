package org.launchcode.casetracker.models.data;

import org.launchcode.casetracker.models.Case;
import org.springframework.data.repository.CrudRepository;

public interface CaseRepository extends CrudRepository<Case, Integer> {

}
