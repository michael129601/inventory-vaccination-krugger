package com.krugger.vaccinationinventory.mapper;


import com.krugger.vaccinationinventory.mapper.contract.IMapper;
import org.modelmapper.ModelMapper;


public abstract class MapperBase <DTO ,ENTITY> implements IMapper<DTO,ENTITY> {

    private ModelMapper modelMapper;

    public  ModelMapper getInstanceMapper (){
        if (this.modelMapper == null )
            return new ModelMapper();
        return this.modelMapper;
    }

    protected abstract Class<DTO> getDTOClass();

    protected abstract Class<ENTITY> getEntityClass();

    public DTO toDTO(ENTITY entity) {
        return this.getInstanceMapper().map(entity, this.getDTOClass());
    }

    public ENTITY toEntity(DTO dto) {
        return this.getInstanceMapper().map(dto,this.getEntityClass());
    }

}
