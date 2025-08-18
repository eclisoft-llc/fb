package com.fbol.paysafebatch.repository.paysafeinput;

import com.fbol.paysafebatch.models.paysafeinput.InputFile;
import com.fbol.paysafebatch.models.paysafeinput.enums.ProcessStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface InputFileRepository extends PagingAndSortingRepository<InputFile, Integer> {
    Page<InputFile> findByStatus(ProcessStatus status, Pageable pageable);
}