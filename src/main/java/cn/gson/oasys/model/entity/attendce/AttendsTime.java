package cn.gson.oasys.model.entity.attendce;

import javax.persistence.*;

/**
 * 考勤时间
 */
@Entity
@Table(name = "aoa_attendstime")
public class AttendsTime {
    @Id
    @Column(name = "attendstime_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long attendstimeId;

    @Column(name = "attendstime_start")
    private String attendstimeStart;

    @Column(name = "attendstime_end")
    private String attendstimeEnd;



    public AttendsTime(){
        super();
    }

    public AttendsTime(Long attendstimeId,String attendstimeStart,String attendstimeEnd){
        super();
        this.attendstimeId = attendstimeId;
        this.attendstimeStart = attendstimeStart;
        this.attendstimeEnd = attendstimeEnd;
    }


    public Long getAttendstimeId() {
        return attendstimeId;
    }

    public void setAttendstimeId(Long attendstimeId) {
        this.attendstimeId = attendstimeId;
    }

    public String getAttendstimeStart() {
        return attendstimeStart;
    }

    public void setAttendstimeStart(String attendstimeStart) {
        this.attendstimeStart = attendstimeStart;
    }

    public String getAttendstimeEnd() {
        return attendstimeEnd;
    }

    public void setAttendstimeEnd(String attendstimeEnd) {
        this.attendstimeEnd = attendstimeEnd;
    }

    @Override
    public String toString() {
        return "AttendsTime{" +
                "attendstimeId=" + attendstimeId +
                ", attendstimeStart='" + attendstimeStart + '\'' +
                ", attendstimeEnd='" + attendstimeEnd + '\'' +
                '}';
    }
}
