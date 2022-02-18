package com.juris.processo;

import com.juris.model.Processo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProcessoRepository extends MongoRepository<Processo, String> {
}
