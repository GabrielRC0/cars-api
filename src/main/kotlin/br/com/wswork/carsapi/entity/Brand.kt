package br.com.wswork.carsapi.entity


import javax.persistence.*

@Entity
@Table(name = "brand")
class Brand {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "brand_seq")
    @SequenceGenerator(name = "brand_seq", sequenceName = "brand_seq", allocationSize = 1)
    var id: Long? = null

    @Column(name = "name")
    var name: String? = null

    @OneToMany(mappedBy = "brand")
    val model: List<Model>? = null

}