package com.carlosdev.personApi.personApi.dto.request;


import com.carlosdev.personApi.personApi.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {


    public Long id;

    @Enumerated(EnumType.ORDINAL)
    public PhoneType type;
    @NotEmpty
    @Size(min = 12, max = 14)
    public String number;

}
