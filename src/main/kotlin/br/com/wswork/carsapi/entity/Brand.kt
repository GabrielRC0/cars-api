package br.com.wswork.carsapi.entity


import javax.persistence.*

@Entity
@Table(name = "brand")
class Brand {
    @Id
    @Column(name = "id")
    var id: Long? = null
    @Column(name = "brand")
    var carBrand: String? = null

    @OneToMany(mappedBy = "brand", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val model: List<Model>? = null

}