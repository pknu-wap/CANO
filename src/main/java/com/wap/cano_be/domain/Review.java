package com.wap.cano_be.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Review {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String contents;
    private Double score;
    private Double acidity;
    private Double body;
    private Double bitterness;
    private Double sweetness;

    @ElementCollection
    @CollectionTable(name = "review_aromas", joinColumns = @JoinColumn(name = "review_id"))
    @Column(name = "aromas")
    private List<String> aromas = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @ElementCollection
    @CollectionTable(name = "review_images", joinColumns = @JoinColumn(name = "review_id"))
    @Column(name = "images")
    private List<String> imageUrls = new ArrayList<>();

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    public Review(){}

    @Builder
    public Review(String contents, Double score, Double acidity, Double body, Double bitterness, Double sweetness, Member member, Menu menu, List<String> imageUrls, List<String> aromas, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.contents = contents;
        this.score = score;
        this.acidity = acidity;
        this.body = body;
        this.bitterness = bitterness;
        this.sweetness = sweetness;
        this.member = member;
        this.menu = menu;
        this.imageUrls = imageUrls;
        this.aromas = aromas;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}
