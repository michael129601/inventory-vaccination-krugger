package com.krugger.vaccinationinventory.mapper.contract;

public interface IMapper <DTO,ENTITY> {

    DTO toDTO(ENTITY entity);

    ENTITY toEntity(DTO dto);
}
