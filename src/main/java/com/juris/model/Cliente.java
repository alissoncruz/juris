package com.juris.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document("cliente")
public class Cliente {

    @Id
    @Null
    private String id;
    @NotNull
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private String rg;
    private Status status;
    private EstadoCivil estadoCivil;
    @Getter
    @AllArgsConstructor
    public enum Status {
        ATIVO ("ATIVO", 1),
        INATIVO ("INATIVO", 0);
        private String id;
        private Integer status;
    }

    @Getter
    @AllArgsConstructor
    public enum EstadoCivil {
        CASADO ("CASADO", "Casado"),
        SOLTEIRO ("SOLTEIRO", "Solteiro"),
        DIVORCIADO ("DIVORCIADO", "Divorciado"),
        VIUVO ("VIUVO", "Viúvo"),
        UNIAO_ESTAVEL ("UNIAO_ESTAVEL", "União Estável");
        private String id;
        private String descricao;
    }

}
