package com.cinema.cinema.Cinema.Dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ComprarIngressoDeFilmeDto {
    private Integer pessoaId;
    private Integer sessaoId;
    //private List<Integer> numerosAsento;
}
