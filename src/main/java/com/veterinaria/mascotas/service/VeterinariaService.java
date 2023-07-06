package com.veterinaria.mascotas.service;

import com.veterinaria.mascotas.dto.MetadataGet;
import com.veterinaria.mascotas.dto.ResponseGet;
import com.veterinaria.mascotas.entities.Mascotas;
import com.veterinaria.mascotas.repository.VeterinariaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class VeterinariaService {
    private final VeterinariaRepository veterinariaRepository;

    public VeterinariaService(VeterinariaRepository veterinariaRepository) {
        this.veterinariaRepository = veterinariaRepository;
    }


    public ResponseGet getAll(Pageable pageable) {
        ResponseGet responseGet = new ResponseGet();
        MetadataGet metadataGet = new MetadataGet();
        Page<Mascotas> result = veterinariaRepository.findAll(pageable);
        responseGet.setData(Collections.singletonList(result.toList()));
        metadataGet.setLimit(pageable.getPageSize());
        metadataGet.setPage(pageable.getPageNumber());
        AtomicInteger i = new AtomicInteger();
        result.forEach(uifParameter -> { i.getAndIncrement();});
        metadataGet.setTotal(i.byteValue());
        responseGet.setMetadata(metadataGet);
        return responseGet;
    }
}
