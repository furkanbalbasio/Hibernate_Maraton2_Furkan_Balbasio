package org.example.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_computer_spec")
public class ComputerSpec {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String ram;
    String ekranKarti;
    String islemci;
    String kapasite;
}
