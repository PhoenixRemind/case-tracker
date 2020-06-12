package org.launchcode.casetracker.models.data;

import org.launchcode.casetracker.models.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Integer> {

}
