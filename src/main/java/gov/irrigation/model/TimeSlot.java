package gov.irrigation.model;

import gov.irrigation.base.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "time_slots")
@Setter
@Getter
public class TimeSlot extends BaseEntity<Long> {


    @ManyToOne
    @JoinColumn(name = "plot_id", nullable = false)
    private Plot plot;

    @Column(nullable = false)
    private LocalTime startTime;

    @Column(nullable = false)
    private LocalTime endTime;

    @Column(nullable = false)
    private Double waterAmount;

    @Column(nullable = false)
    private String status;

}

