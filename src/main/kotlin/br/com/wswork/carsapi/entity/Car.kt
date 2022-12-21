package br.com.wswork.carsapi.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.Date
import javax.persistence.*

@Entity
@Table(name = "car")
class Car {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_seq")
    @SequenceGenerator(name = "car_seq", sequenceName = "car_seq", allocationSize = 1)
    var id: Long? = null

    @Column(name = "create_date")
    var created: Date? = null

    @Column(name = "year")
    var year: Int? = null

    @Column(name = "doors_amount")
    var door: Int? = null

    @Column(name = "color")
    var color: String? = null

    @Column(name = "fuel")
    var fuel: String? = null

    @ManyToOne
    @JoinColumn(name = "model_id")
    var model: Model? = null
}