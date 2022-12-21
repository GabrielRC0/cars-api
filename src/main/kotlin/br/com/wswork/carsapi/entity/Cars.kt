package br.com.wswork.carsapi.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.Date
import javax.persistence.*

@Entity
@Table(name = "cars")
class Cars {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = 0

    @Column(name = "created")
    var created: Date? = null

    @Column(name = "year")
    var year: Int? = null

    @Column(name = "doors")
    var door: Int? = null

    @Column(name = "color")
    var color: String? = null

    @ManyToOne
    @JoinColumn(name = "model_id")
    @JsonIgnore
    var model: Model? = null
}