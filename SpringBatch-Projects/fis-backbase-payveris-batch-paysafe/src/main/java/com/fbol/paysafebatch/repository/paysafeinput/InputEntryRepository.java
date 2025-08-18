package com.fbol.paysafebatch.repository.paysafeinput;

import com.fbol.paysafebatch.models.paysafeinput.InputEntry;
import com.fbol.paysafebatch.models.paysafeinput.enums.ProcessStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface InputEntryRepository extends PagingAndSortingRepository<InputEntry, Integer> {
    Page<InputEntry> findByStatus(ProcessStatus status, Pageable pageable);
}
