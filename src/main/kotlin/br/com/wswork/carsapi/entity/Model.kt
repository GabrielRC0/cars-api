package br.com.wswork.carsapi.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*


@Entity
@Table(name = "models")
class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null

    @Column(name = "name")
    var modelName: String? = null

    @Column(name = "fipe_value")
    var fipeValue: Int? = null

    @ManyToOne
    @JoinColumn(name = "brand_id")
    @JsonIgnore
    var brand: Brand? = null

    @OneToMany(mappedBy = "model", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val model: List<Cars>? = null
}