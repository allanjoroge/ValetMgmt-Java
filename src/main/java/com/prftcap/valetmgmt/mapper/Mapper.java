package com.prftcap.valetmgmt.mapper;

import com.prftcap.valetmgmt.dto.OwnerDTO;
import com.prftcap.valetmgmt.dto.ValetDTO;
import com.prftcap.valetmgmt.dto.VehicleDTO;
import com.prftcap.valetmgmt.entity.Owner;
import com.prftcap.valetmgmt.entity.Valet;
import com.prftcap.valetmgmt.entity.Vehicle;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    private ModelMapper modelMapper;

    @Autowired
    public Mapper(ModelMapper modelMapper){
        this.modelMapper =modelMapper;
    }

    public VehicleDTO transform(Vehicle vehicle){
        return modelMapper.map(vehicle, VehicleDTO.class);
    }
    public Vehicle reverseTransform(VehicleDTO vehicleDTO){
        return modelMapper.map(vehicleDTO, Vehicle.class);
    }


    public ValetDTO transform(Valet valet){
        return modelMapper.map(valet, ValetDTO.class);
    }
    public Valet reverseTransform(ValetDTO valetDTO){
        return modelMapper.map(valetDTO, Valet.class);
    }


    public OwnerDTO transform(Owner owner){
        return modelMapper.map(owner, OwnerDTO.class);
    }
    public Owner reverseTransform(OwnerDTO ownerDTO){
        return modelMapper.map(ownerDTO, Owner.class);
    }
}
