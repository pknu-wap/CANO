package com.wap.cano_be.domain;

import com.wap.cano_be.domain.enums.Degree;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Menu {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @Enumerated(value = EnumType.STRING)
    private Degree acidity;

    @Enumerated(value = EnumType.STRING)
    private Degree body;

    @Enumerated(value = EnumType.STRING)
    private Degree bitterness;

    @Enumerated(value = EnumType.STRING)
    private Degree sweetness;

    @ElementCollection
    @CollectionTable(name = "menu_aromas", joinColumns = @JoinColumn(name = "menu_id"))
    @Column(name = "aroma")
    private List<String> aromas = new ArrayList<>();

    public Menu() {}

    @Builder
    public Menu(String name, String acidity, String body, String bitterness, List<String> aromas) {
        this.name = name;
        this.acidity = Degree.valueOf(acidity);
        this.body = Degree.valueOf(body);
        this.bitterness = Degree.valueOf(bitterness);
        this.aromas = new ArrayList<>(aromas);
    }
}
