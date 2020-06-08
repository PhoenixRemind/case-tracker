package org.launchcode.casetracker.models.data;

import org.launchcode.casetracker.models.Cases;
import org.springframework.data.repository.CrudRepository;

public interface CasesRepository extends CrudRepository<Cases, Integer> {

}
