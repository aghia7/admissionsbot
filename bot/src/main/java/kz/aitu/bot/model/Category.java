package kz.aitu.bot.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_rus")
    private String nameRus;

    @Column(name = "category_kaz")
    private String nameKaz;

    @Column(name = "category_eng")
    private String nameEng;

    @Column(name = "parent_category_id")
    private Long parentId;
}
