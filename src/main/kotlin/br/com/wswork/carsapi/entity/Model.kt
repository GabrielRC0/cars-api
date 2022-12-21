package br.com.wswork.carsapi.entity

import javax.persistence.*


@Entity
@Table(name = "model")
class Model {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "model_seq")
    @SequenceGenerator(name = "model_seq", sequenceName = "model_seq", allocationSize = 1)
    var id: Long? = null

    @Column(name = "name")
    var name: String? = null

    @Column(name = "fipe_value")
    var fipeValue: Float? = null

    @ManyToOne
    @JoinColumn(name = "brand_id")
    var brand: Brand? = null

    @OneToMany(mappedBy = "modelId")
    val cars: List<Car>? = null
}